/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.FactoryProductLine;
import com.bluebirdme.mes.linglong.building.entity.Site;
import com.bluebirdme.mes.linglong.building.entity.SubEquipment;
import com.bluebirdme.mes.linglong.building.uda.EquipmentUDA;
import com.bluebirdme.mes.linglong.building.uda.ProductionLineUDA;
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryProductionLineConstant.FactoryCommonConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryProductionLineConstant.FactoryEquipmentConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Equipment;
import com.datasweep.compatibility.client.EquipmentClass;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.client.WorkCenter;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 机台信息管理
 * @author syl
 * @Date 2019-01-11 15:02:27
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FactoryProductLineServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return null;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    /**
     * 父设备机型的增删改操作
     * 时永良
     * 2019年2月15日
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveEquipmentModelChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
    	List<Map<String, Object>> subequipmentList=null;
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	subequipmentList=rockWellEntityDTO.getDeleted();
        	for(Map<String, Object> item:subequipmentList){
        		final String plinename=item.get("p_line_name").toString();
        		Equipment equipment=getFunction().getEquipmentByName(item.get("equip_name").toString());
        		int num=isDeleteFatherEquipment(String.valueOf(equipment.getEquipmentKey()));
        		if(num==0){
        			WorkCenter workCenter=getFunction().getWorkCenterByName(getProductlineWCName(plinename));
            		workCenter.removeEquipment(equipment);
            		workCenter.save();
            		EquipmentClass equipmentClass=getFunction().getEquipmentClassByName(item.get("machinetype_s").toString());
            		equipmentClass.removeEquipment(equipment);
            		equipmentClass.save();
        			equipment.delete(getDBTime(), LLWebUtils.getUserName()+"删除了设备");
        		}else{
        			 return ""+equipment.getName()+"设备机器下有未删除的投料口、产出口等，请先去投料口、产出口维护中删除对应的投料口、产出口等！";
        		}
        	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	subequipmentList=rockWellEntityDTO.getInserted();
        	List<String> errormsg= new ArrayList<>();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	String msg="";
        	for(Map<String, Object> item:subequipmentList){
        		addString.add(item.get("p_line_name").toString());
        		ruplicateList.add(item.get("p_line_name").toString());
        		//设备名称 产线编码+设备编码
        		String equipName=item.get("equip_name").toString();        		
        		Equipment equipment=getFunction().createEquipment(equipName);
        		List<Map<String,Object>> list=existsEquipment(equipment.getName());
        		if(list.size()!=0){
        			msg="存在重复的设备编码！";
        			errormsg.add(msg);
        		}
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		msg="存在重复的设备编码！";
    			errormsg.add(msg);
        	}
        	if(errormsg.size()!=0){
        		return errormsg.get(0).toString();
        	}else{
        		for(Map<String, Object> item:subequipmentList){
	        		//设备名称 产线编码+设备编码
	        		final String plinename=item.get("p_line_name").toString();
	        		String equipName=item.get("equip_name").toString();        		
	        		String description=item.get("description").toString();  
	        		Equipment equipment=getFunction().createEquipment(equipName);
        			equipment.setDescription(description);
        			equipment.setUDA(item.get("remarks_s").toString(), EquipmentUDA.REMARKS);
        			equipment.setUDA(item.get("model_s").toString(), EquipmentUDA.MODEL);
        			equipment.setUDA(item.get("specification_s").toString(), EquipmentUDA.SPECIFICATION);
        			equipment.setUDA(item.get("factory_s").toString(), EquipmentUDA.FACTORY);
        			equipment.setUDA(item.get("manufacturingtime_t").toString(), EquipmentUDA.MANUFACTURINGTIME);/////
        			equipment.setUDA(item.get("shape_s").toString(), EquipmentUDA.SHAPE);
        			equipment.setUDA(item.get("weight_s").toString(), EquipmentUDA.WEIGHT);
        			equipment.setUDA(item.get("servicelife_s").toString(), EquipmentUDA.SERVICELIFE);
        			equipment.setUDA(item.get("activetime_t").toString(), EquipmentUDA.ACTIVETIME);////////
        			equipment.setUDA(item.get("department_s").toString(), EquipmentUDA.DEPARTMENT);
        			equipment.setUDA(item.get("responsible_s").toString(), EquipmentUDA.RESPONSIBLE);
        			equipment.setUDA(FactoryEquipmentConstant.BUILDING, EquipmentUDA.EQUIP_TYPE);
        			equipment.setUDA(FactoryCommonConstant.BUILDING_PROCESS, EquipmentUDA.PROCESS);
            		equipment.save();
            		WorkCenter workCenter=getFunction().getWorkCenterByName(getProductlineWCName(plinename));
            		workCenter.addEquipment(equipment);
            		workCenter.save();
            		EquipmentClass equipmentClass=getFunction().getEquipmentClassByName(item.get("machinetype_s").toString());
            		if(equipmentClass==null){
            			EquipmentClass addEquipmentClass=getFunction().createEquipmentClass(item.get("machinetype_s").toString());
            			addEquipmentClass.addEquipment(equipment);
            			addEquipmentClass.save();
            		}else{
            			equipmentClass.addEquipment(equipment);
                		equipmentClass.save();
            		}
        	}
        	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	subequipmentList=rockWellEntityDTO.getUpdated();
        	for(Map<String, Object> item:subequipmentList){
        		String equipName=item.get("equip_name").toString();    
        		String equipKey=item.get("equip_key").toString();    
        		Equipment equipment=getFunction().getEquipmentByKey(Long.valueOf(equipKey));
        		if(equipment==null){
        			continue;
        		}
        		String description=item.get("description").toString();   
        		equipment.setName(equipName);
            	equipment.setDescription(description);
            	equipment.setUDA(item.get("remarks_s").toString(), EquipmentUDA.REMARKS);
            	equipment.setUDA(item.get("model_s").toString(), EquipmentUDA.MODEL);
            	equipment.setUDA(item.get("specification_s").toString(), EquipmentUDA.SPECIFICATION);
                equipment.setUDA(item.get("factory_s").toString(), EquipmentUDA.FACTORY);
            	equipment.setUDA(item.get("manufacturingtime_t").toString(), EquipmentUDA.MANUFACTURINGTIME);
            	equipment.setUDA(item.get("shape_s").toString(), EquipmentUDA.SHAPE);
            	equipment.setUDA(item.get("weight_s").toString(), EquipmentUDA.WEIGHT);
            	equipment.setUDA(item.get("servicelife_s").toString(), EquipmentUDA.SERVICELIFE);
            	equipment.setUDA(item.get("activetime_t").toString(), EquipmentUDA.ACTIVETIME);
            	equipment.setUDA(item.get("department_s").toString(), EquipmentUDA.DEPARTMENT);
            	equipment.setUDA(item.get("responsible_s").toString(), EquipmentUDA.RESPONSIBLE);
            	equipment.setUDA(FactoryEquipmentConstant.BUILDING, EquipmentUDA.EQUIP_TYPE);
            	equipment.setUDA(FactoryCommonConstant.BUILDING_PROCESS, EquipmentUDA.PROCESS);
            	equipment.save();
            	//修改机台类型的时候，页面设备类字段跟equipment_class表在equipment_class_equip产生关系，删除旧关系，新增新关系
            	EquipmentClass equipmentClass=getFunction().getEquipmentClassByName(item.get("machinetype_s").toString());
            	String equipClassKey=getEquipmentClassKeyByEquipkey(equipKey).get(0).get("EQUIP_CLASS_KEY").toString();
            	EquipmentClass oldEquipmentClass=getFunction().getEquipmentClassByKey(Long.valueOf(equipClassKey));
            	if(equipmentClass==null){
            		oldEquipmentClass.removeEquipment(equipment);
            		oldEquipmentClass.save();
        			EquipmentClass addEquipmentClass=getFunction().createEquipmentClass(item.get("machinetype_s").toString());
        			addEquipmentClass.addEquipment(equipment);
        			addEquipmentClass.save();
        		}else{
        			oldEquipmentClass.removeEquipment(equipment);
        			oldEquipmentClass.save();
        			equipmentClass.addEquipment(equipment);
            		equipmentClass.save();
        		}
        	}
        }
        return "操作成功";
    }
    //判断是否可以删除父设备，等于0可以删除，大于0不可删除，需先删除父设备下的投料口、产出口等
    public int isDeleteFatherEquipment(String equipkey){
    	SQLQuery query=createSQLQuery(getSQL("isDeleteFatherEquipment"));
		query.setParameter("equipkey", equipkey);
		List<Map<String, Object>> list=query.list();
    	if(list.get(0).get("COUNT(1)").toString().equals("0")){
    		return 0;
    	}
    	return Integer.valueOf(list.get(0).get("COUNT(1)").toString());
    }
    //判断是否可以删除产线，等于0可以删除，大于0不可删除，需先删除产线下的机台设备等
    public int isDeleteProductionLine(String productionLinekey){
    	SQLQuery query=createSQLQuery(getSQL("isDeleteProductionLine"));
		query.setParameter("productionLinekey", productionLinekey);
		List<Map<String, Object>> list=query.list();
    	if(list.get(0).get("COUNT(1)").toString().equals("0")){
    		return 0;
    	}
    	return Integer.valueOf(list.get(0).get("COUNT(1)").toString());
    }
    /**
	 * 根据产线条码和日期查询当前日期下得日计划号
	 * 刘程明
	 * 2019年3月15日
	 * @param equipCode 设备条码
	 * @param productDate 计划日期
	 * @return
	 */
	public List<String> searchDayplannoByEquipCodeAndPlanDate(String equipCode,String productDate) {
		SQLQuery query = createSQLQuery(getSQL("searchDayplannoByProductlineAndPlanDate"));
		query.setParameter("equipcode", equipCode);
		query.setParameter("productiondate",productDate);
		return query.list();
	}
    
    //判断新保存的设备机型是否已存在数据库（equipment）
    public List<Map<String,Object>> existsEquipment(String equipName){
    	SQLQuery query=createSQLQuery(getSQL("existsEquipment"));
		query.setParameter("equipName", equipName);
		List<Map<String, Object>> list=query.list();
    	return list;
    }
    //判断新保存的产线是否已存在数据库（productionLine）
    public List<Map<String,Object>> existsProduction(String productionName){
    	SQLQuery query=createSQLQuery(getSQL("existsProduction"));
    	String s_factory_s=LLWebUtils.factory();
		query.setParameter("productionName", productionName);
		query.setParameter("s_factory_s", s_factory_s);
		List<Map<String, Object>> list=query.list();
    	return list;
    }
  //判断新保存的子设备是否已存在数据库（childEquipment）
    public List<Map<String,Object>> existsChildEquipment(String equipName){
    	SQLQuery query=createSQLQuery(getSQL("existsChildEquipment"));
    	String s_factory_s=LLWebUtils.factory();
		query.setParameter("equipName", equipName);
		List<Map<String, Object>> list=query.list();
    	return list;
    }
    //通过equipment表中equipkey查询equipmentclass表的equipclasskey
    public List<Map<String,Object>> getEquipmentClassKeyByEquipkey(String equipkey){
    	SQLQuery query=createSQLQuery(getSQL("getEquipmentClassKeyByEquipkey"));
		query.setParameter("equipkey", equipkey);
		List<Map<String, Object>> list=query.list();
    	return list;
    }
    
    //获取设备机型
    public List<Map<String,Object>> equipmentModelList(){
    	SQLQuery query=createSQLQuery(getSQL("equipmentModelList"));
    	String s_factory_s=LLWebUtils.factory();
    	List<Map<String,Object>> list=searchBy189();
    	List<String> QGParaLists=new ArrayList<>();
    	List<String> BGParaLists=new ArrayList<>();
    	String dictCode=null;
    	for(int i=0;i<list.size();i++){
    		String dictName=list.get(i).get("dictname_s").toString();
        	if(dictName.indexOf("全钢")!=-1){
        		dictCode=list.get(i).get("dictcode_s").toString();
        		QGParaLists.add(dictCode);
        	}else{
        		dictCode=list.get(i).get("dictcode_s").toString();
        		BGParaLists.add(dictCode);
        	}
    	}
		if(s_factory_s.equals("1")){
			query.setParameterList("dictcode_s", QGParaLists);
		}
		if(s_factory_s.equals("2")){
			query.setParameterList("dictcode_s", BGParaLists);
		}
    	List<Map<String, Object>> listMap = query.list();
    	return listMap;
    }
    
    
    /**
     * 子设备的增删改操作
     * 时永良
     * 2019年2月15日
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveEquipmentChanges(Map<String, Object> rockWellEntityDTO) throws Exception{
    	List<Map<String, Object>> deletedList = (List<Map<String, Object>>) rockWellEntityDTO.get("deleted");
    	List<Map<String, Object>> insertedList = (List<Map<String, Object>>) rockWellEntityDTO.get("inserted");
    	List<Map<String, Object>> updatedList = (List<Map<String, Object>>) rockWellEntityDTO.get("updated");
    	String equipkey = rockWellEntityDTO.get("equipKey").toString();
    	Long equip_key=Long.valueOf(equipkey);
        if (!ListUtils.isEmpty(deletedList)) {
        	for(Map<String, Object> item:deletedList){
        		Equipment equipment=getFunction().getEquipmentByName(item.get("equip_name").toString());
        		Equipment fatherEquipment=getFunction().getEquipmentByKey(equip_key);
        		fatherEquipment.removeEquipment(equipment);
        		fatherEquipment.save();
        		equipment.delete(getDBTime(), LLWebUtils.getUserName()+"删除了设备");
        	}
        }
        if (!ListUtils.isEmpty(insertedList)) {
        	List<String> errormsg= new ArrayList<>();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	String msg="";
        	for(Map<String, Object> item:insertedList){
        		//设备名称 产线编码+设备类型+物料大类
        		final String plinename=item.get("p_line_name").toString();
        		String equipName=null;
        		if(item.get("configclassmes_s")==null||item.get("configclassmes_s")==""){
        			equipName=plinename+"_"+item.get("equip_type_s").toString();
        		}else{
        			equipName=plinename+"_"+item.get("equip_type_s").toString()+"_"+item.get("configclassmes_s").toString();        		
        		}   
        		System.out.println(item.get("configclassmes_s"));
        		//如果允许重复添加产线
        		if(!item.get("configclassmes_s").equals("198012")){
        			addString.add(equipName);
            		ruplicateList.add(equipName);
            		Equipment equipment=getFunction().createEquipment(equipName);
        			//判断新保存的子设备是否已存在数据库（childEquipment）
        			List<Map<String,Object>> list=existsChildEquipment(equipment.getName());
            		if(list.size()!=0){
            			msg="存在重复的子设备！";
            			errormsg.add(msg);
            		}
        		}
        		
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		msg="存在重复的子设备！";
    			errormsg.add(msg);
        	}
        	//添加操作
        	if(errormsg.size()!=0){
        		return errormsg.get(0).toString();
        	}else{
        		for(Map<String, Object> item:insertedList){
            		//设备名称 产线编码+设备类型+物料大类
            		final String plinename=item.get("p_line_name").toString();
            		String equipName=null;
            		if(item.get("configclassmes_s")==null||item.get("configclassmes_s")==""){
            			equipName=plinename+"_"+item.get("equip_type_s").toString();
            		}else{
            			equipName=plinename+"_"+item.get("equip_type_s").toString()+"_"+item.get("configclassmes_s").toString();        		
            		}
            		String proLineCodeName=plinename+"_"+item.get("equip_type_s").toString();
            		Equipment equipment=getFunction().createEquipment(equipName);
            		//如果是投料口，则将子设备编码最后一位存入Equipment扩展表sort字段中，用于投料逻辑-时永良 2020年7月21日13:57:03修改
            		if(item.get("equip_type_s").toString().equals("161001")){
            			equipment.setUDA(equipName.substring(equipName.length()-1), EquipmentUDA.SORT);
            		}else{
            			equipment.setUDA("", EquipmentUDA.SORT);
            		}
            		equipment.setDescription(item.get("description").toString());
            		equipment.setUDA(item.get("rfid_antenna_code_s").toString(), EquipmentUDA.RFID_ANTENNA_CODE);
            		equipment.setUDA(item.get("rfidaddress_s").toString(), EquipmentUDA.RFIDADDRESS);
                    equipment.setUDA(item.get("equip_type_s").toString(),EquipmentUDA.EQUIP_TYPE);
            		equipment.setUDA(item.get("ip_address_s").toString(),EquipmentUDA.IP_ADDRESS);
            		equipment.setUDA(item.get("configclassmes_s").toString(),EquipmentUDA.CONFIGCLASSMES);
            		//时永良修改，2020年8月4日16:26:02
            		if(item.get("configclassmes_s")!=null&&item.get("configclassmes_s")!=""){
            			String reqResult=item.get("configclassmes_s").toString();
            			List<Map<String, Object>> list= materialTypeListByDictCode(reqResult);
            			int count=count(list.get(0).get("DICTNAME_S").toString(),"-");
            			if(count>1){
            				String getSignInfo = list.get(0).get("DICTNAME_S").toString().substring(list.get(0).get("DICTNAME_S").toString().indexOf("-") + 1);
                			String reqResult2=getSignInfo.substring(0, getSignInfo.indexOf("-"));
                			String reqResult3=getSignInfo.substring(getSignInfo.indexOf("-") + 1);
            				equipment.setUDA(reqResult3+reqResult2,EquipmentUDA.CONFIGCLASSNAME);
            			}else{
            				String getSignInfo = list.get(0).get("DICTNAME_S").toString().substring(list.get(0).get("DICTNAME_S").toString().indexOf("-") + 1);
            				equipment.setUDA(getSignInfo,EquipmentUDA.CONFIGCLASSNAME);
            			}
            		}
            		equipment.setUDA(getErpcodeByDictcode(item.get("configclassmes_s").toString()), EquipmentUDA.CONFIGCLASS);
            		equipment.setUDA(item.get("remark_s").toString() ,EquipmentUDA.REMARK);
            		equipment.setUDA(item.get("specialcontrol_s").toString(),EquipmentUDA.SPECIALCONTROL);
            		equipment.setUDA(item.get("device_valid_s").toString(),EquipmentUDA.DEVICE_VALID);
            		equipment.setUDA(proLineCodeName,EquipmentUDA.PRODUCTIONLINE_CODE);
            		if(item.containsKey(item.get("outputgroup_s")))
            		{
            			equipment.setUDA(item.get("outputgroup_s").toString(), EquipmentUDA.OUTPUTGROUP);
            		}  
            		if(item.containsKey(item.get("plasticnumber_i")))
            		{
            			equipment.setUDA(item.get("plasticnumber_i").toString(), EquipmentUDA.PLASTICNUMBER);
            		}
            		if(item.containsKey(item.get("specialselect_s")))
            		{
            			equipment.setUDA(item.get("specialselect_s").toString(), EquipmentUDA.SPECIALSELECT);
            		}
            		//将子设备投料口、产出口放入设备机型中
            		Equipment fatherEquipment=getFunction().getEquipmentByKey(equip_key);
            		equipment.setUDA(LLWebUtils.getUserName(),EquipmentUDA.CHANGEBY);
            		equipment.setUDA(new Date(),EquipmentUDA.CHANGETIME);
            		equipment.setUDA(LLWebUtils.factory(),EquipmentUDA.S_FACTORY);
            		equipment.setUDA(LLConstant.JING_MEN_CODE,EquipmentUDA.AGENCNO);
            		equipment.setUDA(FactoryCommonConstant.BUILDING_PROCESS,EquipmentUDA.PROCESS);
            		equipment.setUDA("0", EquipmentUDA.CONFIGSTATUS);
            		equipment.setUDA(getPersentErpcodeByDictcode(item.get("configclassmes_s").toString()), EquipmentUDA.CONTROLCODE);
            		equipment.save();
            		fatherEquipment.addEquipment(equipment);
            		fatherEquipment.save();
            	}
        	}
        }
        if (!ListUtils.isEmpty(updatedList)) {
        	for(Map<String, Object> item:updatedList){
        		Equipment equipment=getFunction().getEquipmentByName(item.get("equip_name").toString());
        		if(equipment==null){
        			continue;
        		}
        		String newEquipName="";
        		String proLineCodeName="";
        		if(item.get("configclassmes_s")==null||item.get("configclassmes_s")==""){
        			newEquipName=item.get("equip_name").toString();
        			proLineCodeName=item.get("equip_name").toString();
        		}else{
        			String newName=StringUtils.substringBeforeLast(item.get("equip_name").toString(), "_"); 
            		newEquipName=newName+"_"+item.get("configclassmes_s").toString();
            		proLineCodeName=newName;
        		}
        		equipment.setUDA(proLineCodeName,EquipmentUDA.PRODUCTIONLINE_CODE);
        		equipment.setName(newEquipName);
        		//如果是投料口，则将子设备编码最后一位存入Equipment扩展表sort字段中，用于投料逻辑-时永良 2020年7月21日13:57:03修改
        		if(item.get("equip_type_s").toString().equals("161001")){
        			equipment.setUDA(item.get("equip_name").toString().substring(item.get("equip_name").toString().length()-1), EquipmentUDA.SORT);
        		}else{
        			equipment.setUDA("", EquipmentUDA.SORT);
        		}
        		equipment.setDescription(item.get("description").toString());
        		equipment.setUDA(item.get("rfid_antenna_code_s").toString(), EquipmentUDA.RFID_ANTENNA_CODE);
        		equipment.setUDA(item.get("rfidaddress_s").toString(), EquipmentUDA.RFIDADDRESS);
        		equipment.setUDA(item.get("equip_type_s").toString(), EquipmentUDA.EQUIP_TYPE);
        		equipment.setUDA(item.get("ip_address_s").toString(),EquipmentUDA.IP_ADDRESS);
        		equipment.setUDA(item.get("configclassmes_s").toString(),EquipmentUDA.CONFIGCLASSMES);
        		//时永良修改，2020年8月4日16:26:02
        		if(item.get("configclassmes_s")!=null&&item.get("configclassmes_s")!=""){
        			String reqResult=item.get("configclassmes_s").toString();
        			List<Map<String, Object>> list= materialTypeListByDictCode(reqResult);
        			int count=count(list.get(0).get("DICTNAME_S").toString(),"-");
        			if(count>1){
        				String getSignInfo = list.get(0).get("DICTNAME_S").toString().substring(list.get(0).get("DICTNAME_S").toString().indexOf("-") + 1);
            			String reqResult2=getSignInfo.substring(0, getSignInfo.indexOf("-"));
            			String reqResult3=getSignInfo.substring(getSignInfo.indexOf("-") + 1);
        				equipment.setUDA(reqResult3+reqResult2,EquipmentUDA.CONFIGCLASSNAME);
        			}else{
        				String getSignInfo = list.get(0).get("DICTNAME_S").toString().substring(list.get(0).get("DICTNAME_S").toString().indexOf("-") + 1);
        				equipment.setUDA(getSignInfo,EquipmentUDA.CONFIGCLASSNAME);
        			}
        		}
        		equipment.setUDA(getErpcodeByDictcode(item.get("configclassmes_s").toString()), EquipmentUDA.CONFIGCLASS);
        		equipment.setUDA(item.get("remark_s").toString() ,EquipmentUDA.REMARK);
        		if(item.get("specialcontrol_s")!=null){
        			equipment.setUDA(item.get("specialcontrol_s").toString(),EquipmentUDA.SPECIALCONTROL);
        		}else{
        			equipment.setUDA(null,EquipmentUDA.SPECIALCONTROL);
        		}
        		equipment.setUDA(item.get("device_valid_s").toString(),EquipmentUDA.DEVICE_VALID);
        		
        		if(item.containsKey(item.get("outputgroup_s")))
        		{
        			equipment.setUDA(item.get("outputgroup_s").toString(), EquipmentUDA.OUTPUTGROUP);
        		}  
        		if(item.containsKey(item.get("plasticnumber_i")))
        		{
        			equipment.setUDA(item.get("plasticnumber_i").toString(), EquipmentUDA.PLASTICNUMBER);
        		}
        		if(item.containsKey(item.get("specialselect_s")))
        		{
        			equipment.setUDA(item.get("specialselect_s").toString(), EquipmentUDA.SPECIALSELECT);
        		}
        		equipment.setUDA(LLWebUtils.getUserName(),EquipmentUDA.CHANGEBY);
        		equipment.setUDA(new Date(),EquipmentUDA.CHANGETIME);
        		equipment.setUDA(LLWebUtils.factory(),EquipmentUDA.S_FACTORY);
        		equipment.setUDA(LLConstant.JING_MEN_CODE,EquipmentUDA.AGENCNO);
        		equipment.setUDA(FactoryCommonConstant.BUILDING_PROCESS,EquipmentUDA.PROCESS);
        		equipment.setUDA(getPersentErpcodeByDictcode(item.get("configclassmes_s").toString()), EquipmentUDA.CONTROLCODE);
        		equipment.save();
        	}
        }
        return "操作成功";
    }
    
    //判断1个字符串中出现了几次其他字符串,如出现了几次“-”
    public static int count(String text,String sub){
        int count =0, start =0;
        while((start=text.indexOf(sub,start))>=0){
            start += sub.length();
            count ++;
        }
        return count;
    }
    //通过数据字典code返回代码值
    public String getErpcodeByDictcode(String dictcode) {
		Object erpcode =
				getSession().createSQLQuery(getSQL("getErpcodeByDictcode"))
				.setParameter("dictcode_s", dictcode)
				.uniqueResult();
		if(erpcode==null){
			return null;
		}
		return erpcode.toString();
	}
    
    //通过数据字典code返回代码值
    public String getDictnameByDictcode(String dictcode) {
		Object dictname =
				getSession().createSQLQuery(getSQL("getDictnameByDictcode"))
				.setParameter("dictcode_s", dictcode)
				.uniqueResult();
		if(dictname==null){
			return null;
		}
		return dictname.toString();
	}
    
   //通过数据字典code返回百分比的代码值
    public String getPersentErpcodeByDictcode(String dictcode) {
		Object erpcode =
				getSession().createSQLQuery(getSQL("getPersentErpcodeByDictcode"))
				.setParameter("dictcode_s", dictcode)
				.uniqueResult();
		if(erpcode==null){
			return null;
		}
		return erpcode.toString();
	}
    
    
    /**
     * 产线的增删改操作
     * 时永良
     * 2019年2月15日
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception{
        
    	List<Map<String, Object>>  cxProductLineList=null;
    	String productionNameJudgeResult=null;
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	cxProductLineList=rockWellEntityDTO.getDeleted();
        	List<String> errormsg= new ArrayList<>();
        	for(Map<String, Object> item:cxProductLineList){
        		ProductionLine productionLine=getFunction().getProductionLineByName(item.get("p_line_name").toString());
        		if(productionLine==null){
        			errormsg.add(item.get("p_line_name").toString()+"产线编码不存在，不允许删除");
        			continue;
        		}
        		int num=isDeleteProductionLine(String.valueOf(productionLine.getProductionLineKey()));
        		if(num==0){
        			//先从area中删除他们俩的关系
            		removeProductlineFromArea(item.get("area_name").toString(),item.get("p_line_name").toString());
            		//产线层及产线层和WC层关系删除删除
            		deleteProductline(item.get("p_line_name").toString());
            		//WC层删除及WC和设备层关系删除
            		String workCenterName= item.get("p_line_name").toString()+"WC1";
            		deleteEquipmentFromWorkCenter(workCenterName,item.get("p_line_name").toString());
            		deleteWorkCenter(workCenterName);
        		}else{
       			 return ""+productionLine.getName()+"产线下有未删除的机台设备，请先去设备机型维护中删除对应的机台设备！";
       		    }
        	}
            
        	if(errormsg.size()!=0){
        		return errormsg.toString();
        	}
            
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	cxProductLineList=rockWellEntityDTO.getInserted();
        	List<String> errormsg= new ArrayList<>();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	String msg="";
        	for(Map<String, Object> item:cxProductLineList){
        		productionNameJudgeResult=productionNameJudge(item.get("p_line_name").toString(),LLWebUtils.factory());
        		if(productionNameJudgeResult.equals("success")==false){
        			return productionNameJudgeResult;
        		}
        		addString.add(item.get("p_line_name").toString());
        		ruplicateList.add(item.get("p_line_name").toString());
        		ProductionLine productionLine = getFunction().createProductionLine(item.get("p_line_name").toString());
        		List<Map<String,Object>> list=existsProduction(productionLine.getName());
        		if(list.size()!=0){
        			msg="存在重复的产线！";
        			errormsg.add(msg);
        		}
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		msg="存在重复的产线！";
    			errormsg.add(msg);
        	}
        	if(errormsg.size()!=0){
        		return errormsg.get(0).toString();
        	}else{
        		for(Map<String, Object> item:cxProductLineList){
            		ProductionLine productionLine = getFunction().createProductionLine(item.get("p_line_name").toString());
            		productionLine.setDescription(item.get("description").toString());
            		productionLine.setUDA(item.get("machinegroup_s").toString(), ProductionLineUDA.MACHINEGROUP);
            		//设置产线的UDA
            		//productionLine.setUDA(item.get("machinetype_s").toString(), ProductionLineUDA.MACHINETYPE);
            		productionLine.setUDA(item.get("memo_s").toString(), ProductionLineUDA.MEMO);
            		productionLine.setUDA(LLWebUtils.getUserName(),ProductionLineUDA.CREATEBY);
            		productionLine.setUDA(new Date(),ProductionLineUDA.CREATETIME);
            		productionLine.setUDA(item.get("producttype_s").toString(), ProductionLineUDA.PRODUCTTYPE);
            		productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
            		productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductionLineUDA.AGENCNO);
            		productionLine.setUDA(FactoryCommonConstant.BUILDING_PROCESS, ProductionLineUDA.PROCESS);
            		productionLine.save();
            		if(item.get("area_name")==null||item.get("area_name")==""){
            			String areaName=FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"B";;
            			//在area添加产线
    	        		areaAddProductline(areaName,productionLine);
            		}else{
            			//在area添加产线
    	        		areaAddProductline(item.get("area_name").toString(),productionLine);
            		}
            		//产线中新增工作中心
            		String workcentername=item.get("p_line_name").toString()+"WC1";
            		productLineAddWorkcenter(item.get("p_line_name").toString(),workcentername);
        		}
        	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	cxProductLineList=rockWellEntityDTO.getUpdated();
        	List<String> errormsg= new ArrayList<>();
        	for(Map<String, Object> item:cxProductLineList){
        		ProductionLine productionLine=getFunction().getProductionLineByName(item.get("p_line_name").toString());
        		if(productionLine==null){
        			errormsg.add(item.get("p_line_name").toString()+"产线编码不存在，不允许更新");
        			continue;
        		}
        		if(item.containsKey(item.get("category")))
        		{
        			productionLine.setCategory(item.get("category").toString());
        		}  
        		productionLine.setName(item.get("p_line_name").toString());//修改名称
        		productionLine.setDescription(item.get("description").toString());//修改描述
        		productionLine.setUDA(item.get("machinegroup_s").toString(), ProductionLineUDA.MACHINEGROUP);
        		//productionLine.setUDA(item.get("machinetype_s").toString(), ProductionLineUDA.MACHINETYPE);
        		productionLine.setUDA(item.get("memo_s").toString(), ProductionLineUDA.MEMO);
        		productionLine.setUDA(LLWebUtils.getUserName(), ProductionLineUDA.CHANGEBY);
        		productionLine.setUDA(new Date(), ProductionLineUDA.CHANGETIME);
        		productionLine.setUDA(item.get("producttype_s").toString(), ProductionLineUDA.PRODUCTTYPE);
        		productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
        		productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductionLineUDA.AGENCNO);
        		productionLine.setUDA(FactoryCommonConstant.BUILDING_PROCESS, ProductionLineUDA.PROCESS);
        		productionLine.save();
        	}
        	if(errormsg.size()!=0){
        		return errormsg.toString();
        	}
        }
        return "操作成功";
    }
    
    /**产线编码规则校验
	 * 时永良
	 * 2019年6月21日
	 */
	public String productionNameJudge(String productionName,String factory) {
 		if(!(productionName.length()==6)){
 			return "产线编码必须是6位";
 		}
 		String  unitPreIndex=productionName.substring(0,3);
 		//SQLQuery uniqueProductionNameJudge=createSQLQuery(getSQL("uniqueProductionNameJudge"));
 		if(factory.equals(Factory.FullSteel)){
 	 		if(unitPreIndex.equals("FBS")){
 	 			/*uniqueProductionNameJudge.setParameter("productionName",productionName);
 				if(uniqueProductionNameJudge.list().isEmpty()){
 					return "success";
 				}
 	 			return "产线编码已存在"; */
 	 			return "success";
 	 		}
 	 		return "全钢成型产线编码规则：全钢:F,设备类型 :BS";
 		}
		if(factory.equals(Factory.HalfSteel)){
			if(unitPreIndex.equals("HBS")){
				/*uniqueProductionNameJudge.setParameter("productionName",productionName);
 				if(uniqueProductionNameJudge.list().isEmpty()){
 					return "success";
 				}
 				return "产线编码已存在"; */
				return "success";
 	 		}
 		    return "半钢成型产线编码规则：半钢:H,设备类型 :BS";
 		}
        return "success";
	}
    public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
    
    /**
     * area中增加productline
     * 时永良
     * 2019年2月15日
     * @param areakey
     * @param productline
     */
    public void areaAddProductline(String areaname,ProductionLine productionLine) {
    	//在area添加产线
		com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaname);
		area.addProductionLine(productionLine);
		area.save();
	}
    
    /**
     * 产线中新增工作中心
     * 时永良
     * 2019年2月15日
     * @param productionLine
     * @param workCenterName
     */
    public void productLineAddWorkcenter(String productionLineName,String workCenterName) {
    	com.datasweep.compatibility.client.ProductionLine addproductionLine=getFunction().getProductionLineByName(productionLineName);
    	com.datasweep.compatibility.client.WorkCenter addWorkCenter = getFunction().createWorkCenter(workCenterName);
		addWorkCenter.save();
		addproductionLine.addWorkCenter(addWorkCenter);
		addproductionLine.save();
	}
    /**
     * 删除area和产线之间的关系
     * 时永良
     * 2019年2月15日
     * @param areakey
     * @param productionLine
     * @throws Exception
     */
    public void removeProductlineFromArea(String areaname,String productionLinename) throws Exception{
    	com.datasweep.compatibility.client.ProductionLine removeproductionLine=getFunction().getProductionLineByName(productionLinename);
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaname);
		area.removeProductionLine(removeproductionLine);
		area.save();
		
    }
    /**
     * 删除产线层，和产线层和WC的关系，但是WC层没有删除
     * 时永良
     * 2019年2月15日
     * @param productionLine
     */
    public void deleteProductline(String productionLineName) {
    	com.datasweep.compatibility.client.ProductionLine deleteProductionLine=getFunction().getProductionLineByName(productionLineName);
    	deleteProductionLine.delete(getDBTime(), LLWebUtils.getUserName()+"删除产线");
	}
   /**
   * 删除wc
   * 时永良
   * 2019年2月15日
   * @param workCenterName
   */
    public void deleteWorkCenter(String workCenterName) {
    	com.datasweep.compatibility.client.WorkCenter workCenter=getFunction().getWorkCenterByName(workCenterName);
		workCenter.delete(getDBTime(), LLWebUtils.getUserName()+"删除WC");
	}
    /**
     * 删除某一产线下-某一工作中心下所有设备
     * 时永良
     * 2019年2月15日
     * @param workCenterName
     */
    public void deleteEquipmentFromWorkCenter(String workCenterName,String plinename) {
    	com.datasweep.compatibility.client.WorkCenter workCenter=getFunction().getWorkCenterByName(workCenterName);
    	
    	SQLQuery query=createSQLQuery(getSQL("getEquipNameByPlineName"));
  		query.setParameter("p_line_name", plinename);
  		List<Map<String, Object>> list= query.list();
  		for(Map<String, Object> item:list){
  			com.datasweep.compatibility.client.Equipment equipment=getFunction().getEquipmentByName(item.get("EQUIP_NAME").toString());
  	    	workCenter.removeEquipment(equipment);
  	    	workCenter.save();
  	    	equipment.delete(getDBTime(), LLWebUtils.getUserName()+"删除产线时删除了该产线下的设备");
  		}
    	
	}
    
    
    /**
     * 返回厂区信息
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<Site> getSite() throws Exception {
		SQLQuery query=createSQLQuery(getSQL("getSite"),Site.class);
		query.setParameter("category", LLConstant.JING_MEN_CODE);
		query.setParameter("factory", LLWebUtils.factory());
		return query.list();
	}
    
	 /**
	  * 根据site名称返回下面得工段信息
	  * 时永良
	  * 2019年3月5日
	  * @param sitename
	  * @return
	  * @throws Exception
	  */
    @SuppressWarnings("unchecked")
  	public List<Map<String, Object>> getAreaBySitename(String sitename) throws Exception {
  		SQLQuery query=createSQLQuery(getSQL("getAreaBySitename"));
  		query.setParameter("site_name", sitename);
  		//TransformUpperCase transformUpperCase=new TransformUpperCase();
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
  	}
   
    
    /**
     * 根据工段（AREA）名称返回产线信息
     * 时永良
     * 2019年3月5日
     * @param areaname
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
  	public List<Map<String, Object>>getProductlineByAreaName(String areaname) throws Exception {
  		SQLQuery query=createSQLQuery(getSQL("getProductlineByAreaName"));
  		query.setParameter("area_name", areaname);
  		//TransformUpperCase transformUpperCase=new TransformUpperCase();
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
  	}
    
 	/**
 	 * 获取产线下工作中心的名称
 	 * 时永良
 	 * 2019年2月15日
 	 * @param p_line_key
 	 * @return
 	 */
 	public String getProductlineWCName(String plinename) {
		return getSession().createSQLQuery(getSQL("getProductlineWCName")).setParameter("p_line_name", plinename).uniqueResult().toString();
	}
 	
 	/**
 	 * 根据site返回成型的产线信息
 	 * 时永良
 	 * 2019年2月27日
 	 * @param sitename
 	 * @return
 	 * @throws Exception
 	 */
 	 @SuppressWarnings("unchecked")
   	public List<Map<String, Object>>getProductlineBySiteName(String sitename) throws Exception {
 		Filter filter=new Filter();
 		filter.set("sitename", sitename);
   		SQLQuery query=createSQLQuery(getSQL("getProductlineBySitename",filter));
   		//TransformUpperCase transformUpperCase=new TransformUpperCase();
   		List<Map<String, Object>> res=query.list();
   		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
   		for (int i = 0; i < res.size(); i++) {
 			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
 		}
 		return list_new;
   	}
 	
 	 /**
 	  * 获取成型的产线
 	  * 时永良
 	  * 2019年3月5日
 	  * @return
 	  * @throws Exception
 	  */
 	@SuppressWarnings("unchecked")
   	public List<Map<String, Object>>getProductline(String process_s) throws Exception {
 		Filter filter=new Filter();
 	 	filter.set("process_s", process_s);
 	 	filter.set("sitename", LLWebUtils.factory());
 		System.out.println(getSQL("getProductlineBySitename",filter));
 		
   		SQLQuery query=createSQLQuery(getSQL("getProductlineBySitename",filter));
   		List<Map<String, Object>> res=query.list();
   		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
   		for (int i = 0; i < res.size(); i++) {
 			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
 		}
 		return list_new;
   	}
 	
 	 /**
	  * 获取成型的产线
	  * 时永良
	  * 2019年3月5日
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
  	public List<Map<String, Object>>getMachinetypeAndProducttypeByProductlineName(String plinename,String process_s,String category) throws Exception {
		
		Filter filter=new Filter();
		filter.set("lineCode", plinename);
		filter.set("process_s", process_s);
		filter.set("category", category);
		filter.set("sitename", LLWebUtils.factory());
		
		System.out.println(getSQL("getProductlineBySitename",filter));
		
  		SQLQuery query=createSQLQuery(getSQL("getProductlineBySitename",filter));
  		//TransformUpperCase transformUpperCase=new TransformUpperCase();
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
  	}
	
 	 /**
      * 获取产线下设备信息,通过产线名称
      * 时永良
      * 2019年1月24日
      * @param plinekey 产线的id
      * @return
      * @throws Exception
      */
  	public List<Map<String, Object>>getEquipByProductlineName(String plinename) throws Exception {
   		SQLQuery query=createSQLQuery(getSQL("getEquipByProductlineName"));
   		query.setParameter("p_line_name", plinename);
   		//TransformUpperCase transformUpperCase=new TransformUpperCase();
   		List<Map<String, Object>> res=query.list();
   		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
   		for (int i = 0; i < res.size(); i++) {
 			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
 		}
 		return list_new;
   	}
  	
  	 /**
     * 获取产线下设备信息(投料口、产出口),通过equip_key
     * 时永良
     * 2019年1月24日
     * @param equipKey equipment的id
     * @return
     * @throws Exception
     */
 	public List<Map<String, Object>>getEquipByEquipKey(String equipKey) throws Exception {
  		SQLQuery query=createSQLQuery(getSQL("getEquipByEquipKey"));
  		query.setParameter("equipKey", equipKey);
  		//TransformUpperCase transformUpperCase=new TransformUpperCase();
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
  	}
 	
  	/**
  	 * 返回子设备维护页面-物料类型的下拉框信息
  	 * 时永良
  	 * 2019年3月1日
  	 * @return
  	 */
 	public List<Map<String,Object>> materialTypeList(){
 		SQLQuery query=createSQLQuery(getSQL("materialTypeList"));
 		if(LLWebUtils.factory().equals("1")){
 			query.setParameter("pid_i", "562486");
 		}
 		else {
 			query.setParameter("pid_i", "562485");
 		}
    	List<Map<String, Object>> list=query.list();
	    return list;
 	}
 	
 	/**
  	 * 返回子设备维护页面-物料类型的下拉框信息
  	 * 时永良
  	 * 2019年3月1日
  	 * @return
  	 */
 	public List<Map<String,Object>> materialTypeListByDictCode(String dictCode){
 		SQLQuery query=createSQLQuery(getSQL("materialTypeListByDictCode"));
 		if(LLWebUtils.factory().equals("1")){
 			query.setParameter("pid_i", "562486");
 		}
 		else {
 			query.setParameter("pid_i", "562485");
 		}
 		query.setParameter("dictcode_s", dictCode);
    	List<Map<String, Object>> list=query.list();
	    return list;
 	}
 	
 	/**
 	 * 通过产线名称拿到产线+产线UDA的信息
 	 * 时永良
 	 * 2019年3月11日
 	 * @param plinename
 	 * @return
 	 */
 	public Map<String,Object> getProductLineInfoByName(String plinename){
 		SQLQuery query=createSQLQuery(getSQL("getProductLineInfoByName"));
 		query.setParameter("plinename", plinename);
    	List<Map<String, Object>> list=query.list();
    	if(list==null){
    		return null;
    	}
	    return list.get(0);
 	}
 	
 	/**
	 * 根据189查出对应数据字典（189为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy189() {
		SQLQuery query = createSQLQuery(getSQL("searchBy189"));
		List<Map<String, Object>> res=query.list();
   		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
   		for (int i = 0; i < res.size(); i++) {
 			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
 		}
 		return list_new;
	}
	
	/**
	 * 保存字典类别的增删改信息
	 * 
	 * @author Goofy
	 * @Date 2018年7月3日 上午9:25:46
	 * @param dictDTO
	 * @throws Exception 
	 */
	@RockWellTransactional
	public List<String> saveDictChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		List<String> repeatCodes = new ArrayList<String>();
		List<Map<String, Object>> insertList=rockWellEntityDTO.getInserted();
		List<Map<String, Object>> updateList=rockWellEntityDTO.getUpdated();
		if (!ListUtils.isEmpty(updateList)) {
			List list = new ArrayList<>();
			for (int i = 0; i < updateList.size(); i++) {
				CoreDictionary coreDictionary=(CoreDictionary) MapTrunPojo.mapToEntity(updateList.get(i), CoreDictionary.class);
				/*Where where = new Where();
				where.andEqual("dictcode_s", coreDictionary.getDictcode_s());
				if (findByWhere(where).size() > 0) {
					repeatCodes.add(coreDictionary.getDictcode_s());
					continue;// 应对复制页面问题
				}*/
				coreDictionary.setPid_i(532432L);
				coreDictionary.setChanged_by_s(WebUtils.getUserName());
				coreDictionary.setChanged_time_t(new Date());
				update(coreDictionary);
			}
		}
		if (!ListUtils.isEmpty(insertList)) {
			List list = new ArrayList<>();
			for (int i = 0; i < insertList.size(); i++) {
				CoreDictionary coreDictionary=(CoreDictionary) MapTrunPojo.mapToEntity(insertList.get(i), CoreDictionary.class);
			/*	Where where = new Where();
				where.andEqual("dictcode_s", coreDictionary.getDictcode_s());
				if (findByWhere(where).size() > 0) {
					repeatCodes.add(coreDictionary.getDictcode_s());
					continue;// 应对复制页面问题
				}*/
				coreDictionary.setCreated_by_s(WebUtils.getUserName());
				coreDictionary.setCreated_time_t(new Date());
				coreDictionary.setPid_i(532432L);
				list.add(coreDictionary);
			}
			save(list);
		}
		if (!ListUtils.isEmpty(repeatCodes)) {
			return repeatCodes;
		}
		return repeatCodes;
	}
}
