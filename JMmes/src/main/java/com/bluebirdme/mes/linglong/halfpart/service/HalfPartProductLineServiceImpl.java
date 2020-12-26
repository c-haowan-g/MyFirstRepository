/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.building.uda.EquipmentUDA;
import com.bluebirdme.mes.linglong.common.entity.Site;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDA.ProductlineUDA;
import com.bluebirdme.mes.linglong.core.RockWellUDA.EquipMentUDA;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryProductionLineConstant.FactoryCommonConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryProductionLineConstant.FactoryEquipmentConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Area;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.DatasweepException;
import com.datasweep.compatibility.client.Equipment;
import com.datasweep.compatibility.client.EquipmentClass;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.client.WorkCenter;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 半部件机台信息管理
 * @author 时永良
 * @Date 2020年3月6日14:46:38
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfPartProductLineServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv; 
    @Resource HalfPartMachineStatusServiceImpl machineStatusSrv;
    /*@Resource HalfpartProductionLineLogServiceImpl productionLinelogSrv;
    @Resource HalfpartEquipmentLogServiceImpl  equiplogSrv;*/
    @Resource HalfpartEquipmentStatusServiceImpl equipstatusSrv;
    
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
     * 半部件产线信息增删改
     * 时永良
     * 2020年3月6日14:46:47
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveProductLineChanges(RockWellEntityDTO productline) throws Exception{
    	List<Map<String, Object>> productLineList=null;
    	List<String> errorTips=new ArrayList<>();
    	int lineRecord=0;
	    String machineStatusTip=null;
	    String machineLogTip=null;
	    String equipStatusTip=null;
		String equipLogTip=null;
		String productLineUniqueJudge=null;
    	 if (!ListUtils.isEmpty(productline.getInserted())) {
         	productLineList=productline.getInserted();
         	machineStatusTip=null;
         	machineLogTip=null;
    	    equipStatusTip=null;
    		equipLogTip=null;
         	for(Map<String, Object> item:productLineList){
         		productLineUniqueJudge=productLineNameJudge(item.get("p_line_name").toString());
         		if(productLineUniqueJudge.equals("success")==false){
         			return productLineUniqueJudge;
         			/*errorTips.add(productLineUniqueJudge);
         			throw new Exception(productLineUniqueJudge);*/
         			//continue;
         		}
         		ProductionLine productionLine = getFunction().createProductionLine(item.get("p_line_name").toString());
         		productionLine.setDescription(item.get("description").toString());
         		//productionLine.setCategory(item.get("category").toString());
         		//设置产线的UDA
         		//productionLine.setUDA(item.get("equipcode_s").toString(), ProductlineUDA.EQUIPCODE);
         		//productionLine.setUDA(item.get("isplate_s").toString(), ProductlineUDA.ISPLATE);
         		if(item.get("remarks_s")!=null){
         			productionLine.setUDA(item.get("remarks_s").toString(), ProductlineUDA.REMARKS);
         		}else{
         			productionLine.setUDA("", ProductlineUDA.REMARKS);
         		}
         		if(item.get("model_s")!=null){
         			productionLine.setUDA(item.get("model_s").toString(), ProductlineUDA.MODEL);
         		}else{
         			productionLine.setUDA("", ProductlineUDA.MODEL);
         		}
         		//productionLine.setUDA(item.get("factory_s").toString(), ProductlineUDA.FACTORY);
         		productionLine.setUDA(LLWebUtils.getUserName(),ProductlineUDA.CREATEBY);
         		productionLine.setUDA(new Date(),ProductlineUDA.CREATETIME);
         		productionLine.setUDA(LLWebUtils.factory(), ProductlineUDA.S_FACTORY);
         		productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductlineUDA.AGENCNO);
         		productionLine.setUDA(Process.HalfPart, ProductlineUDA.PROCESS);
         		productionLine.setUDA(item.get("memo_s").toString(), ProductlineUDA.MEMO);
         		productionLine.save();	
         		productionLine.refresh();
         		if(item.get("area_name")==null||item.get("area_name")==""){
        			String areaName=FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"A";;
        			//在area添加产线
        			addProductLineUnderArea(areaName,productionLine);
        		}else{
        			//在area添加产线
        			addProductLineUnderArea(item.get("area_name").toString(),productionLine);
        		}
         		//产线中新增工作中心
        		String workcentername=item.get("p_line_name").toString()+"WC1";
        		addWorkCenterUnderProductLine(item.get("p_line_name").toString(),workcentername);
         		lineRecord++;
         	}
        	/*if(lineRecord==productLineList.size()){
        		machineStatusTip=insertDataToMachineStatusTable(productline);
        		machineLogTip=insertDataToProductLineLogTable(productline);
          		if(machineStatusTip!="success"){
          			errorTips.add(machineStatusTip);
          		}
          		if(machineLogTip!="success"){
          			errorTips.add(machineLogTip);
          		}
        	}*//*else{
        		errorTips.add("产线信息不正确，无法新建产线并将将产线据更新到产线状态表和产线记录表中");
        	}*/
         }
    	 
        if (!ListUtils.isEmpty(productline.getDeleted())) {
        	productLineList=productline.getDeleted();
        	lineRecord=0;
        	boolean result=true;
         	machineStatusTip=null;
         	machineLogTip=null;
    	    equipStatusTip=null;
    		equipLogTip=null;
        	for(Map<String, Object> item:productLineList){
        		ProductionLine productionLine=getFunction().getProductionLineByName(item.get("p_line_name").toString());
        		if(productionLine==null){
        			errorTips.add(item.get("p_line_name").toString()+"产线编码不存在，不允许删除");
        			continue;
        		}
        		int num=isDeleteProductionLine(String.valueOf(productionLine.getProductionLineKey()));
        		if(num==0){
        			//先从area中删除他们俩的关系
        			removeProductLineFromArea(item.get("area_name").toString(),item.get("p_line_name").toString());
        			//产线层及产线层和WC层关系删除删除
        			deleteProductline(item.get("p_line_name").toString());
        			deleteWorkCenter(item.get("p_line_name").toString().concat("WC1"));
        		}else{
       			   return ""+productionLine.getName()+"产线下有未删除的子设备，请先去子设备维护中删除对应的子设备！";
       		    }
        		lineRecord++;
        	}
        	/*if(lineRecord==productLineList.size()){
             	machineStatusTip=insertDataToMachineStatusTable(productline);
             	machineLogTip=insertDataToProductLineLogTable(productline);
          		if(machineStatusTip!="success"){
          			errorTips.add(machineStatusTip);
          		}
          		if(machineLogTip!="success"){
          			errorTips.add(machineLogTip);
          		}
          		if(equipStatusTip!="success"){
          			errorTips.add(equipStatusTip);
          		}
        	}*//*else{
        		errorTips.add("产线信息不正确，无法新建产线并将将产线据更新到产线状态表和产线记录表中");
        	}*/
        }
       
        if (!ListUtils.isEmpty(productline.getUpdated())) {
        	productLineList=productline.getUpdated();
        	lineRecord=0;
         	machineStatusTip=null;
         	machineLogTip=null;
    	    equipStatusTip=null;
    		equipLogTip=null;
    		productLineUniqueJudge=null;
        	for(Map<String, Object> item:productLineList){
        		ProductionLine productionLine=getFunction().getProductionLineByName(item.get("p_line_name").toString());
        		if(productionLine==null){
        			errorTips.add(item.get("p_line_name").toString()+"产线编码不存在，不允许更新");
        			continue;
        		}
        		//productLineUniqueJudge=productLineNameJudge(item.getP_line_name());
         		/*if(productLineUniqueJudge.equals("success")==false){
         			errorTips.add(productLineUniqueJudge);
         			continue;
         		}*/
        		productionLine.setName(item.get("p_line_name").toString());
        		productionLine.setDescription(item.get("description").toString());
        		productionLine.setUDA(Process.HalfPart, ProductlineUDA.PROCESS);
        		if(item.get("memo_s")!=null){
         			productionLine.setUDA(item.get("memo_s").toString(), ProductlineUDA.MEMO);
         		}else{
         			productionLine.setUDA("", ProductlineUDA.MEMO);
         		}
        		productionLine.setUDA(LLWebUtils.getUserName(), ProductlineUDA.CHANGEBY);
        		productionLine.setUDA(new Date(), ProductlineUDA.CHANGETIME);
        		productionLine.setUDA(LLWebUtils.factory(), ProductlineUDA.S_FACTORY);
        		productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductlineUDA.AGENCNO);
        		productionLine.save();
        		productionLine.refresh();
        		lineRecord++;
        	}
        	/*if(lineRecord==productLineList.size()){
        		machineStatusTip=insertDataToMachineStatusTable(productline);
        		machineLogTip=insertDataToProductLineLogTable(productline);
          		if(machineStatusTip!="success"){
          			errorTips.add(machineStatusTip);
          		}
          		if(machineLogTip!="success"){
          			errorTips.add(machineLogTip);
          		}
        	}*/
        }
        if(!(errorTips==null||errorTips.toString()==null||errorTips.isEmpty()||errorTips.get(0)==null)){
        	return errorTips.toString();
        }
        return "操作成功";
    }
    
    /**
     * 半部件设备机型的增删改操作
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
        	int lineRecord=0;
    	    String machineStatusTip=null;
    	    String equipStatusTip=null;
    		List<String> errormsg= new ArrayList<>();
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
        			 return ""+equipment.getName()+"设备机器下有未删除的投料口、产出口等，请先去子设备维护中删除对应的投料口、产出口等！";
        		}
        		lineRecord++;
        	}
        	if(lineRecord==subequipmentList.size()){
         	    machineStatusTip=insertDataToMachineStatusTable(rockWellEntityDTO);
        	}    
      		if(machineStatusTip!="success"){
      			errormsg.add(machineStatusTip);
      		} else{
    	    	errormsg.add("设备信息不正确，无法新建设备并将设备数据更新到产线状态表和产线记录表中");
    	    }
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	int lineRecord=0;
    	    String machineStatusTip=null;
    	    String machineLogTip=null;
    	    String equipStatusTip=null;
    		String equipLogTip=null;
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
        			equipment.setUDA(item.get("uda_3").toString(), 3);
        			equipment.setUDA(item.get("uda_4").toString(), 4);
        			equipment.setUDA(item.get("factory_s").toString(), EquipmentUDA.FACTORY);
        			equipment.setUDA(FactoryCommonConstant.HALFPART_PROCESS, EquipmentUDA.PROCESS);
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
            		lineRecord++;
        	}
        	}
        	if(lineRecord==subequipmentList.size()){
         	machineStatusTip=insertDataToMachineStatusTable(rockWellEntityDTO);
         	//machineLogTip=insertDataToProductLineLogTable(rockWellEntityDTO);
      		if(machineStatusTip!="success"){
      			errormsg.add(machineStatusTip);
      		}
      		/*if(machineLogTip!="success"){
      			errormsg.add(machineLogTip);
      		}*/
      		if(equipStatusTip!="success"){
      			errormsg.add(equipStatusTip);
      		}
	    	}else{
	    		errormsg.add("设备信息不正确，无法新建设备并将设备数据更新到产线状态表和产线记录表中");
	    	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	int lineRecord=0;
    	    String machineStatusTip=null;
    	    String machineLogTip=null;
    	    String equipStatusTip=null;
    		String equipLogTip=null;
    		List<String> errormsg= new ArrayList<>();
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
                	equipment.setUDA(item.get("uda_3").toString(), 3);
        			equipment.setUDA(item.get("uda_4").toString(), 4);
        			equipment.setUDA(item.get("factory_s").toString(), EquipmentUDA.FACTORY);
                	equipment.setUDA(FactoryCommonConstant.HALFPART_PROCESS, EquipmentUDA.PROCESS);
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
                	lineRecord++;
            	}
        		if(lineRecord==subequipmentList.size()){
                 	machineStatusTip=insertDataToMachineStatusTable(rockWellEntityDTO);
                 	//machineLogTip=insertDataToProductLineLogTable(rockWellEntityDTO);
              		if(machineStatusTip!="success"){
              			errormsg.add(machineStatusTip);
              		}
              		/*if(machineLogTip!="success"){
              			errormsg.add(machineLogTip);
              		}*/
              		if(equipStatusTip!="success"){
              			errormsg.add(equipStatusTip);
              		}
        	    	}else{
        	    		errormsg.add("设备信息不正确，无法新建设备并将设备数据更新到产线状态表和产线记录表中");
        	    	}
        }
        return "操作成功";
    }
    
    
    /**
     * 半部件子设备信息增删改
     * 时永良
     * 2020年3月6日14:47:07
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
    	List<Map<String,Object>> subequipmentList=null;
    	List<String> errorTips=new ArrayList<>();
    	String machineTip=null;
    	String equipTip=null;
    	int equipRecord=0;
    	String equipTypeErpCode=null;
        if (!ListUtils.isEmpty(insertedList)) {
        	subequipmentList=insertedList;
        	equipRecord=0;
        	for(Map<String,Object> item:subequipmentList){
        		if(Long.valueOf(item.get("plasticnumber_i").toString())>10){
        			errorTips.add(item.get("equip_name").toString().concat("维护的胶案数量大于10"));
        			throw new Exception(item.get("equip_name").toString().concat("维护的胶案数量大于10"));
        		}
        		String equipNameJudgeResult=equipNameJudge(item.get("p_line_name").toString(),item.get("equip_name").toString(),item.get("equip_type_s").toString());
        		if(equipNameJudgeResult.equals("success")==false){
        			errorTips.add(equipNameJudgeResult);
        			throw new Exception(equipNameJudgeResult);
        		}
        		Equipment equipment=getFunction().createEquipment(item.get("equip_name").toString());
        		equipment.setDescription(item.get("description").toString());
                equipment.setUDA(item.get("equip_type_s").toString(),EquipMentUDA.EQUIP_TYPE);  //子设备类型
                equipTypeErpCode=getErpcodeByDictcode(item.get("equip_type_s").toString());
                item.put("productionline_code_s", item.get("p_line_name").toString().concat(equipTypeErpCode));
        		equipment.setUDA((item.get("p_line_name").toString()).concat(equipTypeErpCode),EquipMentUDA.PRODUCTIONLINE_CODE); //子设备组号
        		equipment.setUDA(item.get("ip_address_s").toString(),EquipMentUDA.IP_ADDRESS);  //子设备IP
        		equipment.setUDA(item.get("configclass_s").toString(),EquipMentUDA.CONFIGCLASS);  //物料类型
        		equipment.setUDA(item.get("outputgroup_s").toString(),EquipMentUDA.OUTPUTGROUP);  //产出分组
        		equipment.setUDA(item.get("plasticnumber_i").toString(), EquipMentUDA.PLASTICNUMBER);  //投入胶案数量
        		equipment.setUDA(item.get("specialselect_s").toString(), EquipMentUDA.SPECIALSELECT);  //特殊选择
        		equipment.setUDA(item.get("rfidaddress_s").toString(), EquipMentUDA.RFIDADDRESS);  
        		equipment.setUDA(item.get("intoutaddress_s").toString(), EquipMentUDA.INTOUTADDRESS);  
        		equipment.setUDA(item.get("remark_s").toString() ,EquipMentUDA.REMARK);
        		equipment.setUDA(LLWebUtils.getUserName(),EquipMentUDA.CHANGEBY);
        		equipment.setUDA(new Date(),EquipMentUDA.CHANGETIME);
        		equipment.setUDA(LLWebUtils.factory(),EquipMentUDA.S_FACTORY);
        		equipment.setUDA(LLConstant.JING_MEN_CODE,EquipMentUDA.AGENCNO);
        		equipment.setUDA(Process.HalfPart,EquipMentUDA.PROCESS);
        		equipment.save();
        		equipment.refresh();
        		//将子设备投料口、产出口放入设备机型中
        		Equipment fatherEquipment=getFunction().getEquipmentByKey(equip_key);
        		fatherEquipment.addEquipment(equipment);
        		fatherEquipment.save();
        		equipRecord++;
        	}
        	if(equipRecord==subequipmentList.size()){
             	machineTip=insertDataToEquipStatusTable(rockWellEntityDTO);
             	//equipTip=insertDataToEquipLogTable(rockWellEntityDTO);
          		if(machineTip!="success"){
          			errorTips.add(machineTip);
          		}
          		/*if(equipTip!="success"){
          			errorTips.add(equipTip);
          		}*/
        	}
        }
        if (!ListUtils.isEmpty(updatedList)) {
        	subequipmentList=updatedList;
        	equipRecord=0;
        	for(Map<String, Object> item:subequipmentList){
        		if(Long.valueOf(item.get("plasticnumber_i").toString())>10){
        			errorTips.add(item.get("equip_name").toString().concat("维护的胶案数量大于10"));
        			continue;
        		}
        		Equipment equipment=getFunction().getEquipmentByName(item.get("equip_name").toString());
        		if(equipment==null){
        			errorTips.add(item.get("equip_name").toString().concat("子设备信息不存在"));
        			continue;
        		}
        		equipment.setDescription(item.get("description").toString());
                equipment.setUDA(item.get("equip_type_s").toString(),EquipMentUDA.EQUIP_TYPE);  //子设备类型
                equipTypeErpCode=getErpcodeByDictcode(item.get("equip_type_s").toString());
        		//equipment.setUDA(item.get("p_line_name").toString().concat(equipTypeErpCode),EquipMentUDA.PRODUCTIONLINE_CODE); //子设备组号
        		equipment.setUDA(item.get("ip_address_s").toString(),EquipMentUDA.IP_ADDRESS);  //子设备IP
        		//equipment.setUDA(getErpcodeByDictcode(item.getConfigclassmes_s()), EquipMentUDA.CONFIGCLASS); //物料类型
        		equipment.setUDA(item.get("configclass_s").toString(),EquipMentUDA.CONFIGCLASS);  //物料类型
        		equipment.setUDA(item.get("plasticnumber_i").toString(), EquipMentUDA.PLASTICNUMBER);  //投入胶案数量
        		equipment.setUDA(item.get("outputgroup_s").toString(),EquipMentUDA.OUTPUTGROUP);  //产出分组
        		equipment.setUDA(item.get("specialselect_s").toString(), EquipMentUDA.SPECIALSELECT);  //特殊选择
        		equipment.setUDA(item.get("rfidaddress_s").toString(), EquipMentUDA.RFIDADDRESS);  
        		equipment.setUDA(item.get("intoutaddress_s").toString(), EquipMentUDA.INTOUTADDRESS);  
        		equipment.setUDA(item.get("remark_s").toString() ,EquipMentUDA.REMARK);
        		equipment.setUDA(LLWebUtils.getUserName(),EquipMentUDA.CHANGEBY);
        		equipment.setUDA(new Date(),EquipMentUDA.CHANGETIME);
        		equipment.setUDA(LLWebUtils.factory(),EquipMentUDA.S_FACTORY);
        		equipment.setUDA(LLConstant.JING_MEN_CODE,EquipMentUDA.AGENCNO);
        		equipment.setUDA(Process.HalfPart,EquipMentUDA.PROCESS);
        		equipment.save();
        		equipRecord++;
        	}
            if(equipRecord==subequipmentList.size()){
             	machineTip=insertDataToEquipStatusTable(rockWellEntityDTO);
             	//equipTip=insertDataToEquipLogTable(rockWellEntityDTO);
          		if(machineTip!="success"){
          			errorTips.add(machineTip);
          		}
          		/*if(equipTip!="success"){
          			errorTips.add(equipTip);
          		}*/
        	}
        }
        if (!ListUtils.isEmpty(deletedList)) {
        	subequipmentList=deletedList;
        	equipRecord=0;
        	for(Map<String, Object> item:subequipmentList){
        		Equipment equipment=getFunction().getEquipmentByName(item.get("equip_name").toString());
        		Equipment fatherEquipment=getFunction().getEquipmentByKey(equip_key);
        		fatherEquipment.removeEquipment(equipment);
        		fatherEquipment.save();
        		equipment.delete(getDBTime(), LLWebUtils.getUserName()+"删除了设备");
        		equipRecord++;
        	}
        	if(equipRecord==subequipmentList.size()){
             	machineTip=insertDataToEquipStatusTable(rockWellEntityDTO);
             	//equipTip=insertDataToEquipLogTable(rockWellEntityDTO);
          		if(machineTip!="success"){
          			errorTips.add(machineTip);
          		}
//          		if(equipTip!="success"){
//          			errorTips.add(equipTip);
//          		}
        	}
        }
        if(errorTips.isEmpty()==false){
        	return errorTips.get(0).toString();
        }
        return "操作成功";
    }
    /**
     * 设备维护-物料类型（通过数据字典code返回代码值）
     * 时永良
     * 2020年3月6日14:47:17
     * @param dictcode
     * @return
     */
    public String getErpcodeByDictcode(String dictcode) {
      Object erpcode =getSession().createSQLQuery(getSQL("getErpcodeByDictcode")).setParameter("dictcode_s", dictcode).uniqueResult();
		if(erpcode==null){
			return null;
		}
		return erpcode.toString();
	}
    
    /**
     * Rock well框架需要调用的函数
     * 2019年05月06日
     * @return
     * 
     */
    public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
    
    /**
     * 创建area和产线的关系
     * 时永良
     * 2020年3月6日14:47:29
     * @param dictcode
     * @return
     * @throws DatasweepException 
     */

    public void addProductLineUnderArea(String areaName,ProductionLine productionLine) throws DatasweepException {
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
    	area.refresh();
		area.addProductionLine(productionLine);
		area.save();
	}
    /**
     * 添加产线和工作中心的关系
     * 时永良
     * 2020年3月6日14:47:35
     * @param productionLine
     * @param workCenterName
     * @throws DatasweepException 
     */
    public void addWorkCenterUnderProductLine(String productionLineName,String workCenterName) throws DatasweepException {
    	com.datasweep.compatibility.client.ProductionLine addproductionLine=getFunction().getProductionLineByName(productionLineName);
    	addproductionLine.refresh();
    	com.datasweep.compatibility.client.WorkCenter addWorkCenter = getFunction().createWorkCenter(workCenterName);
    	addWorkCenter.refresh();
		addWorkCenter.save();
		addproductionLine.addWorkCenter(addWorkCenter);
		addproductionLine.save();
	}
    
    /**
     * Area-从area中删除area与产线关系
     * 时永良
     * 2020年3月6日14:47:41
     * @param areakey
     * @param productionLine
     * @throws Exception
     */
    public void removeProductLineFromArea(String areaName,String productionLine) throws Exception{
    	com.datasweep.compatibility.client.ProductionLine removeProductionLine=getFunction().getProductionLineByName(productionLine);
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
		area.removeProductionLine(removeProductionLine);
		area.save();
    }
    /**
     * Production_Line中删除"产线"及"产线与工作中心"的关系
     * 时永良
     * 2020年3月6日14:47:46
     * @param productionLine
     */
    
    public void deleteProductline(String productionLineName) {
    	com.datasweep.compatibility.client.ProductionLine deleteProductionLine=getFunction().getProductionLineByName(productionLineName);
    	deleteProductionLine.delete(getDBTime(), LLWebUtils.getUserName()+"删除产线");
	}
   /**
    * Work_Center-删除"工作中心"及"工作中心与设备"的关系
    * 时永良
    * 2020年3月6日14:47:52
    * @param workCenterName
    */
    public void deleteWorkCenter(String workCenterName) {
    	com.datasweep.compatibility.client.WorkCenter workCenter=getFunction().getWorkCenterByName(workCenterName);
		workCenter.delete(getDBTime(), LLWebUtils.getUserName()+"删除WC");
	}
    /**
     * 删除所有设备-针对于某条产线
     * 时永良
     * 2020年3月6日14:47:58
     * @param workCenterName
     */
    public void deleteEquipmentAccordingProductLineName(String workCenterName,String plinename) {
    	com.datasweep.compatibility.client.WorkCenter workCenterOfHalfPart=getFunction().getWorkCenterByName(workCenterName);
    	SQLQuery query=createSQLQuery(getSQL("getEquipNameByPlineName"));
  		query.setParameter("p_line_name", plinename);
  		List<Map<String, Object>> list= query.list();
	    for(Map<String, Object> item:list){
		   com.datasweep.compatibility.client.Equipment equipment=getFunction().getEquipmentByName(item.get("EQUIP_NAME").toString());
		   workCenterOfHalfPart.removeEquipment(equipment);
		   workCenterOfHalfPart.save();
    	   equipment.delete(getDBTime(), LLWebUtils.getUserName()+"删除产线时删除了该产线下的设备");
	    }
	}
    public boolean deleteEquipJudge(String plinename) {
    	SQLQuery query=createSQLQuery(getSQL("getEquipNameByPlineName"));
  		query.setParameter("p_line_name", plinename);
  		List<Map<String, Object>> list= query.list();
  		if(query.list().size()==0){
  			 return false;
  		}
		return true;
	}
 	/**
 	 * 获取某条产线对应的工作中心的名称-用于子设备维护
 	 * 时永良
 	 * 2020年3月6日14:48:07
 	 * @param p_line_key
 	 * @return
 	 */
 	public String getWorkCenterByProductLine(String productLineName) {
		return getSession().createSQLQuery(getSQL("getWorkCenterByProductLine")).setParameter("p_line_name", productLineName).uniqueResult().toString();
	}
 	/**
 	 * 判断产线条码规则
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:48:20
 	 */
	public String productLineNameJudge(String productLineName){
 		if(!(productLineName.length()==6)){
 			return productLineName+"产线条码必须是6位";
 		}
 		SQLQuery uniqueMachineJudge=createSQLQuery(getSQL("uniqueMachineJudge"));
 		uniqueMachineJudge.setParameter("machineCode",productLineName);
 		if(uniqueMachineJudge.list().isEmpty()==false){
 			return productLineName+"产线条码已被使用";
 		}
 		String  preIndex=productLineName.substring(0,3);
 		if(LLWebUtils.factory().equals(Factory.FullSteel)){
 			if(preIndex.equals("FAS")==false){
 				return productLineName+"产线条码不符合编码规则：F(全钢)+AS(厂区)+F(设备类型)+2位编号 ,例如'FASF01'";
 			}
 		}
		if(LLWebUtils.factory().equals(Factory.HalfSteel)){
 			if(preIndex.equals("HAS")==false){
 				return productLineName+"产线条码不符合编码规则：H(半钢)+AS(厂区)+F(设备类型)+2位编号,例如'HASF01'";
 			}
 		}
		return "success";
 	}
 	/**
 	 * 生成子设备条码
 	 * 时永良
 	 * 2020年3月6日14:48:29
 	 */
	public String creatEquipName(String productLineName,String equipType){
 		String  preIndex=productLineName.concat("_").concat(equipType).concat("_");
 		String  equipName=serialSrv.serial(preIndex, 2, 1).get(0);
		return equipName;
	}
 	/**
 	 * 子设备条码规则校验
 	 * 时永良
 	 * 2020年3月6日14:48:37
 	 */
	public String equipNameJudge(String productLineName,String equipName,String equipType ){
 		if(!(equipName.length()==23)){
 			return equipName+"子设备条码必须是23位";
 		}
 		/*String preName=productLineName.concat("_").concat(equipType);
 		String preIndex=equipName.substring(0,13);
 		if(preName.equals(preIndex)==false){
 			return equipName+"子设备条码前缀必须为机台条码+子设备类型,例如EASF01_115001";
 		}
 		char forteenth= equipName.charAt(13);//获取字符串的第一个字符
 		if(!(String.valueOf(forteenth).equals("_"))){
 			return equipName+"子设备条码第7位和14位请设置下划线";
 		}*/
 		SQLQuery uniqueEquipJudge=createSQLQuery(getSQL("uniqueEquipJudge"));
 		uniqueEquipJudge.setParameter("equipName",equipName);
 		if(uniqueEquipJudge.list().isEmpty()==false){
 			return equipName.concat("子设备条码已被使用");
 		}
		return "success";
 	}	
	 /**
	  * 往产线状态表内插数据
	  * 时永良
	  * 2020年3月6日14:48:45
	  * @throws Exception 
	  */
	public String insertDataToMachineStatusTable(RockWellEntityDTO rockWellEntityDTO) throws Exception{
		  return machineStatusSrv.saveChanges(rockWellEntityDTO);
	}
	 /**
	  * 往产线信息记录表内插数据
	  * 时永良
	  * 2020年3月6日14:48:50
	 * @throws Exception 
	  */
		
/*	public String insertDataToProductLineLogTable(RockWellEntityDTO rockWellEntityDTO) throws Exception{
		   return productionLinelogSrv.saveChanges(rockWellEntityDTO);
	}*/

	 /**
	  * 往设备状态表内插数据
	  * 时永良
	  * 2020年3月6日14:49:03
	 * @throws Exception 
	  */
		
	public String  insertDataToEquipStatusTable(Map<String, Object> rockWellEntityDTO) throws Exception{
		   return equipstatusSrv.saveChanges(rockWellEntityDTO);
	}
	
	/*public String  deleteDataInEquipStatusTable(String productLineName) throws Exception{
		   return equipstatusSrv.deleteEquip(productLineName);
	}*/
	 /**
	  * 往设备信息记录内插数据
	  * 时永良
	  * 2020年3月6日14:49:09
	 * @throws Exception 
	  */
	/*public String insertDataToEquipLogTable(Map<String, Object> rockWellEntityDTO) throws Exception{
		   return equiplogSrv.saveChanges(rockWellEntityDTO);
	}*/
	/**
	 * 根据数据字典211获取半部件用产线类型的数据字典
	 * 时永良
	 * 2020年3月6日14:49:14
	 * 
	 */
	public List<String> getProductLineType() throws Exception{
		  SQLQuery getProductLineType=createSQLQuery(getSQL("getProductLineType"));
		  return getProductLineType.list();
	}
	
	 /**
	  * 获取半部件用的产线（主界面和产线维护界面）
	  * 时永良
	  * 2020年3月6日14:49:23
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
  	public List<Map<String, Object>>getProductline(Map<String,String> map) throws Exception {
		String p_line_name="";
		String description="";
		String sortname="";
		String sortorder="";
		if(map.size()>0){
			p_line_name=map.get("p_line_name").toString();
			description=map.get("description").toString();
			if(map.containsKey(sortname)){
				sortname="p."+map.get(sortname).toString();
				sortorder=map.get(sortorder).toString();
			}
		}
		Filter filter=new Filter();
		filter.set("lineCode", p_line_name);
		filter.set("description", description);
		filter.set("process_s",Process.HalfPart);
		filter.set("sitename", LLWebUtils.factory());
		filter.setSort(sortname);
		filter.setOrder(sortorder);
  		SQLQuery query=createSQLQuery(getSQL("getProductlineBySitename",filter));
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
  	}
	
	
	/**
	  * 获取半部件的产线
	  * 时永良
	  * 2020年7月16日10:27:56
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
  	public List<Map<String, Object>>getProductline(String process_s) throws Exception {
		Filter filter=new Filter();
	 	filter.set("process_s", "252004");
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
     * 根据产线名称获取产线及产线下设备信息
     * 时永良
     * 2020年3月6日14:49:53
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
	 * 编辑产线时判断有口型板时是否维护了口型板型子设备
	 * 时永良
	 * 2020年3月6日14:50:02
	 * 
	 */
	public boolean plasticJudge(String lineName) {
		SQLQuery query=createSQLQuery(getSQL("plasticJudge"));
		query.setParameter("lineName",lineName);
		query.setParameter("equipType","115003");
		String aaa=query.list().toString();
		if(query.list().size()==0||query.list().isEmpty()==true){
			return false;
		}
		return true;
	}
	/**
	 * 删除产线时判断是否维护了库区
	 * 时永良
	 * 2020年3月6日14:50:08
	 * 
	 */
	public List<String> zoneExistJudge(String[] productLine) {
		List<String> result = new ArrayList<String>();
		for(int i=0;i<productLine.length;i++){
			SQLQuery query=createSQLQuery(getSQL("zoneExistJudge"));
			query.setParameter("productLine",productLine[i]);
			if(LLWebUtils.factory().equals(Factory.FullSteel)){
				query.setParameter("area",Area.FullSteelHalfPartArea);
			}
			else{
				query.setParameter("area",Area.HalfSteelHalfPartArea);
			}
			query.setParameter("process",Process.HalfPart);
			List aaa=query.list();
			if(query.list().size()!=0||query.list().isEmpty()==false){
				result.add(productLine[i].toString());
			}
		}
		return result;
	}
 	/*---------------分割线-------------------*/
 	
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
	  * 2020年3月6日14:50:19
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
     * 2020年3月6日14:50:28
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
 	 * 根据site返回成型的产线信息
 	 * 时永良
 	 * 2020年3月6日14:50:37
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
  	 * 返回子设备维护页面-物料类型的下拉框信息
  	 * 时永良
  	 * 2020年3月6日14:50:45
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
 	 * 通过产线名称拿到产线+产线UDA的信息
 	 * 时永良
 	 * 2020年3月6日14:50:52
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
 	 * 获得半部件用产线
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:50:59
 	 */
	public List<String> getHalfPartProductionLine(){
 		SQLQuery query=createSQLQuery(getSQL("getHalfPartProductionLine"));
 		query.setParameter("process",Process.HalfPart);
		if(LLWebUtils.factory().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
			query.setParameter("factory",Factory.FullSteel);
		}else if(LLWebUtils.factory().equals(Factory.HalfSteel)){
			query.setParameter("factory",Factory.HalfSteel);
		}
		return query.list();
 	}
	
    /**
     * 判断是否可以删除产线，等于0可以删除，大于0不可删除，需先删除产线下的机台设备等
     * 时永良
     * 2020年3月6日14:51:14
     * @param productionLinekey
     * @return
     */
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
	 * 根据数据字典查出所需控制项（211为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy211(String logo) {
 	    String newLogo=logo.substring(0, 1);
		SQLQuery query = createSQLQuery(getSQL("searchBy211"));
		if(newLogo.equals("C")){
			if(logo.substring(2, 3).equals("1")||logo.substring(2, 3).equals("2")||logo.substring(2, 3).equals("3")){
				query.setParameter("logo", "C01");
			}else{
				query.setParameter("logo", "C04");
			}
		}else{
			query.setParameter("logo", newLogo);
		}
		return query.list();
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
 	
 	 //判断新保存的设备机型是否已存在数据库（equipment）
    public List<Map<String,Object>> existsEquipment(String equipName){
    	SQLQuery query=createSQLQuery(getSQL("existsEquipment"));
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
    
    /**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialGroup() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialGroup"));
//		String sfs = "";
//		if (LLWebUtils.factory().equals("1")) {
//			sfs = "%半钢%";
//		} 
//		if (LLWebUtils.factory().equals("2")) {
//			sfs = "%全钢%";
//		}
//		query.setParameter("sfs", sfs);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
}
