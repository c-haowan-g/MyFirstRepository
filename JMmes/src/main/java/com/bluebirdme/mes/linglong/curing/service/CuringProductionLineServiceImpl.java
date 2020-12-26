/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.building.uda.EquipmentUDA;
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
import com.bluebirdme.mes.linglong.curing.uda.ProductionLineUDA;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Equipment;
import com.datasweep.compatibility.client.EquipmentClass;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.client.WorkCenter;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 硫化产线设备维护页面
 * 
 * @author 时永良
 * @Date 2019-07-13 09:55:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringProductionLineServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return null;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	/**
	 * 获取硫化的产线 时永良 2019年3月5日
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getProductline(Map<String,String> map) throws Exception {
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
		filter.set("process_s",Process.Curing);
		filter.set("sitename", LLWebUtils.factory());
		filter.setSort(sortname);
		filter.setOrder(sortorder);

		SQLQuery query = createSQLQuery(getSQL("getProductlineBySitename", filter));
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}

	/**
	 * 获取产线下设备信息,通过产线名称 时永良 2019年1月24日
	 * 
	 * @param plinekey
	 *            产线的id
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquipByProductlineName(String plinename) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getEquipByProductlineName"));
		query.setParameter("p_line_name", plinename);
		// TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}

	/**
	 * 获取产线下设备信息(投料口、产出口),通过equip_key 时永良 2019年1月24日
	 * 
	 * @param equipKey
	 *            equipment的id
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getEquipByEquipKey(String equipKey) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getEquipByEquipKey"));
		query.setParameter("equipKey", equipKey);
		// TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}

	/**
	 * 根据工段（AREA）名称返回产线信息 时永良 2019年3月5日
	 * 
	 * @param areaname
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getProductlineByAreaName(String areaname) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getProductlineByAreaName"));
		query.setParameter("area_name", areaname);
		// TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}

	/**
	 * 产线的增删改操作 时永良 2019年2月15日
	 * 
	 * @param cxproductline
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveProductLineChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

		List<Map<String, Object>> cxProductLineList = null;
		String productionNameJudgeResult=null;
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			cxProductLineList = rockWellEntityDTO.getDeleted();
			List<String> errormsg = new ArrayList<>();
			for (Map<String, Object> item : cxProductLineList) {
				ProductionLine productionLine = getFunction().getProductionLineByName(
						item.get("p_line_name").toString());
				if (productionLine == null) {
					errormsg.add(item.get("p_line_name").toString() + "产线编码不存在，不允许删除");
					continue;
				}
				int num=isDeleteProductionLine(String.valueOf(productionLine.getProductionLineKey()));
        		if(num==0){
        			// 先从area中删除他们俩的关系
    				removeProductlineFromArea(item.get("area_name").toString(), item.get("p_line_name").toString());
    				// 产线层及产线层和WC层关系删除删除
    				deleteProductline(item.get("p_line_name").toString());
    				// WC层删除及WC和设备层关系删除
    				String workCenterName = item.get("p_line_name").toString() + "WC1";
    				deleteEquipmentFromWorkCenter(workCenterName, item.get("p_line_name").toString());
    				deleteWorkCenter(workCenterName);
        		}else{
       			 return ""+productionLine.getName()+"产线下有未删除的机台设备，请先去设备机型维护中删除对应的机台设备！";
       		    }
			}

			if (errormsg.size() != 0) {
				return errormsg.toString();
			}

		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			cxProductLineList = rockWellEntityDTO.getInserted();
			List<String> errormsg = new ArrayList<>();
			String msg="";
			// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
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
        		for (Map<String, Object> item : cxProductLineList) {
    				ProductionLine productionLine = getFunction().createProductionLine(item.get("p_line_name").toString());
    				productionLine.setDescription(item.get("description").toString());
    				productionLine.setUDA(item.get("machinegroup_s").toString(), ProductionLineUDA.MACHINEGROUP);
    				// 设置产线的UDA
    				productionLine.setUDA(item.get("memo_s").toString(), ProductionLineUDA.MEMO);
    				productionLine.setUDA(LLWebUtils.getUserName(), ProductionLineUDA.CREATEBY);
    				productionLine.setUDA(new Date(),ProductionLineUDA.CREATETIME);
    				productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
    				productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductionLineUDA.AGENCNO);
    				productionLine.setUDA(FactoryCommonConstant.CURING_PROCESS, ProductionLineUDA.PROCESS);
    				productionLine.save();
    				if (item.get("area_name") == null || item.get("area_name") == "") {
    					String areaName = FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C";
    					// 在area添加产线
    					areaAddProductline(areaName, productionLine);
    				} else {
    					// 在area添加产线
    					areaAddProductline(item.get("area_name").toString(), productionLine);
    				}
    				// 产线中新增工作中心
    				String workcentername = item.get("p_line_name").toString() + "WC1";
    				productLineAddWorkcenter(item.get("p_line_name").toString(), workcentername);
    			}
        	}
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			cxProductLineList = rockWellEntityDTO.getUpdated();
			List<String> errormsg = new ArrayList();
			for (Map<String, Object> item : cxProductLineList) {
				ProductionLine productionLine = getFunction().getProductionLineByName(
						item.get("p_line_name").toString());
				if (productionLine == null) {
					errormsg.add(item.get("p_line_name").toString() + "产线编码不存在，不允许更新");
					continue;
				}
				if (item.containsKey(item.get("category"))) {
					productionLine.setCategory(item.get("category").toString());
				}
				productionLine.setName(item.get("p_line_name").toString());// 修改名称
				productionLine.setDescription(item.get("description").toString());// 修改描述
				productionLine.setUDA(item.get("machinegroup_s").toString(), ProductionLineUDA.MACHINEGROUP);
				productionLine.setUDA(item.get("memo_s").toString(), ProductionLineUDA.MEMO);
				productionLine.setUDA(LLWebUtils.getUserName(), ProductionLineUDA.CHANGEBY);
				productionLine.setUDA(new Date(), ProductionLineUDA.CHANGETIME);
				productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
				productionLine.setUDA(LLConstant.JING_MEN_CODE, ProductionLineUDA.AGENCNO);
				productionLine.setUDA(FactoryCommonConstant.CURING_PROCESS, ProductionLineUDA.PROCESS);
				productionLine.save();
			}
			if (errormsg.size() != 0) {
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
 	 		if(unitPreIndex.equals("FCS")){
 	 			/*uniqueProductionNameJudge.setParameter("productionName",productionName);
 				if(uniqueProductionNameJudge.list().isEmpty()){
 					return "success";
 				}
 	 			return "产线编码已存在"; */
 	 			return "success";
 	 		}
 	 		return "全钢硫化产线编码规则：全钢:F,设备类型 :CS";
 		}
		if(factory.equals(Factory.HalfSteel)){
			if(unitPreIndex.equals("HCS")){
				/*uniqueProductionNameJudge.setParameter("productionName",productionName);
 				if(uniqueProductionNameJudge.list().isEmpty()){
 					return "success";
 				}
 				return "产线编码已存在"; */
				return "success";
 	 		}
 		    return "半钢硫化产线编码规则：半钢:H,设备类型 :CS";
 		}
        return "success";
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
	/**
	 * 删除area和产线之间的关系 时永良 2019年2月15日
	 * 
	 * @param areakey
	 * @param productionLine
	 * @throws Exception
	 */
	public void removeProductlineFromArea(String areaname, String productionLinename) throws Exception {
		com.datasweep.compatibility.client.ProductionLine removeproductionLine = getFunction().getProductionLineByName(
				productionLinename);
		com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaname);
		area.removeProductionLine(removeproductionLine);
		area.save();

	}

	/**
	 * 删除产线层，和产线层和WC的关系，但是WC层没有删除 时永良 2019年2月15日
	 * 
	 * @param productionLine
	 */
	public void deleteProductline(String productionLineName) {
		com.datasweep.compatibility.client.ProductionLine deleteProductionLine = getFunction().getProductionLineByName(
				productionLineName);
		deleteProductionLine.delete(getDBTime(), LLWebUtils.getUserName() + "删除产线");
	}

	/**
	 * 删除wc 时永良 2019年2月15日
	 * 
	 * @param workCenterName
	 */
	public void deleteWorkCenter(String workCenterName) {
		com.datasweep.compatibility.client.WorkCenter workCenter = getFunction().getWorkCenterByName(workCenterName);
		workCenter.delete(getDBTime(), LLWebUtils.getUserName() + "删除WC");
	}

	/**
	 * 删除某一产线下-某一工作中心下所有设备 时永良 2019年2月15日
	 * 
	 * @param workCenterName
	 */
	public void deleteEquipmentFromWorkCenter(String workCenterName, String plinename) {
		com.datasweep.compatibility.client.WorkCenter workCenter = getFunction().getWorkCenterByName(workCenterName);

		SQLQuery query = createSQLQuery(getSQL("getEquipNameByPlineName"));
		query.setParameter("p_line_name", plinename);
		List<Map<String, Object>> list = query.list();
		for (Map<String, Object> item : list) {
			com.datasweep.compatibility.client.Equipment equipment = getFunction().getEquipmentByName(
					item.get("EQUIP_NAME").toString());
			workCenter.removeEquipment(equipment);
			workCenter.save();
			equipment.delete(getDBTime(), LLWebUtils.getUserName() + "删除产线时删除了该产线下的设备");
		}

	}

	/**
	 * area中增加productline 时永良 2019年2月15日
	 * 
	 * @param areakey
	 * @param productline
	 */
	public void areaAddProductline(String areaname, ProductionLine productionLine) {
		// 在area添加产线
		com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaname);
		area.addProductionLine(productionLine);
		area.save();
	}

	/**
	 * 产线中新增工作中心 时永良 2019年2月15日
	 * 
	 * @param productionLine
	 * @param workCenterName
	 */
	public void productLineAddWorkcenter(String productionLineName, String workCenterName) {
		com.datasweep.compatibility.client.ProductionLine addproductionLine = getFunction().getProductionLineByName(
				productionLineName);
		com.datasweep.compatibility.client.WorkCenter addWorkCenter = getFunction().createWorkCenter(workCenterName);
		addWorkCenter.save();
		addproductionLine.addWorkCenter(addWorkCenter);
		addproductionLine.save();
	}

	/**
	 * 父设备机型的增删改操作 时永良 2019年2月15日
	 * 
	 * @param cxproductline
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveEquipmentModelChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

		List<Map<String, Object>> subequipmentList = null;
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			subequipmentList = rockWellEntityDTO.getDeleted();
			for (Map<String, Object> item : subequipmentList) {
				final String plinename = item.get("p_line_name").toString();
				Equipment equipment = getFunction().getEquipmentByName(item.get("equip_name").toString());
				int num = isDeleteFatherEquipment(String.valueOf(equipment.getEquipmentKey()));
				if (num == 0) {
					WorkCenter workCenter = getFunction().getWorkCenterByName(getProductlineWCName(plinename));
					workCenter.removeEquipment(equipment);
					workCenter.save();
					EquipmentClass equipmentClass = getFunction().getEquipmentClassByName(
							item.get("machinetype_s").toString());
					equipmentClass.removeEquipment(equipment);
					equipmentClass.save();
					equipment.delete(getDBTime(), LLWebUtils.getUserName() + "删除了设备");
				} else {
					return "" + equipment.getName() + "设备机器下有未删除的投料口、产出口等，请先去投料口、产出口维护中删除对应的投料口、产出口等！";
				}
			}
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			subequipmentList = rockWellEntityDTO.getInserted();
			List<String> errormsg= new ArrayList<>();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	String msg="";
        	for(Map<String, Object> item:subequipmentList){
        		//设备名称 产线编码+设备编码
        		String equipName=item.get("equip_name").toString(); 
        		addString.add(equipName);
        		ruplicateList.add(equipName);
        		Equipment equipment=getFunction().createEquipment(equipName);
        		List<Map<String,Object>> list=existsEquipment(equipment.getName());
        		if(list.size()!=0){
        			msg="存在重复的设备编码！";
        			errormsg.add(msg);
        		}
        		List<Map<String,Object>> ipList=existsIp(item.get("ip_address_s").toString());
        		if(ipList.size()!=0){
        			if(!ipList.get(0).get("EQUIP_NAME").toString().substring(0, 6).equals(item.get("p_line_name").toString())){
        				msg="存在重复的设备IP！";
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
        		msg="存在重复的设备编码！";
    			errormsg.add(msg);
        	}
        	if(errormsg.size()!=0){
        		return errormsg.get(0).toString();
        	}else{
        		for (Map<String, Object> item : subequipmentList) {
    				// 设备名称 产线编码+设备编码
    				final String plinename = item.get("p_line_name").toString();
    				String equipName = item.get("equip_name").toString();
    				String description = item.get("description").toString();
    				Equipment equipment = getFunction().createEquipment(equipName);
    				List<Map<String, Object>> list = existsEquipment(equipment.getName());
    				if (list.size() != 0) {
    					return "存在重复的成型机型！";
    				} else {
    					equipment.setUDA(LLWebUtils.getUserName(), EquipmentUDA.CHANGEBY);
    					Date date = new Date();
    					Timestamp timestamp = DateUtil.dateToTime(date);
    					equipment.setUDA(timestamp, EquipmentUDA.CHANGETIME);
    					equipment.setDescription(description);
    					equipment.setUDA(item.get("ip_address_s").toString(), EquipmentUDA.IP_ADDRESS);
    					equipment.setUDA(item.get("status_s").toString(), EquipmentUDA.STATUS);
    					equipment.setUDA(FactoryEquipmentConstant.CURING, EquipmentUDA.EQUIP_TYPE);
    					equipment.setUDA(FactoryCommonConstant.CURING_PROCESS, EquipmentUDA.PROCESS);
    					equipment.save();
    					WorkCenter workCenter = getFunction().getWorkCenterByName(getProductlineWCName(plinename));
    					workCenter.addEquipment(equipment);
    					workCenter.save();
    					EquipmentClass equipmentClass = getFunction().getEquipmentClassByName(
    							item.get("machinetype_s").toString());
    					if (equipmentClass == null) {
    						EquipmentClass addEquipmentClass = getFunction().createEquipmentClass(
    								item.get("machinetype_s").toString());
    						addEquipmentClass.addEquipment(equipment);
    						addEquipmentClass.save();
    					} else {
    						equipmentClass.addEquipment(equipment);
    						equipmentClass.save();
    					}
    				}

    			}
        	}
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			subequipmentList = rockWellEntityDTO.getUpdated();
			List<String> errormsg= new ArrayList<>();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	String msg="";
        	for(Map<String, Object> item:subequipmentList){
        		//设备名称 产线编码+设备编码
        		String equipName=item.get("equip_name").toString(); 
        		addString.add(equipName);
        		ruplicateList.add(equipName);
        		Equipment equipment=getFunction().createEquipment(equipName);
        		List<Map<String,Object>> list=existsEquipment(equipment.getName());
        		if(list.size()!=0){
        			if(!list.get(0).get("EQUIP_KEY").toString().equals(item.get("equip_key").toString())){
        				msg="存在重复的设备编码！";
            			errormsg.add(msg);
        			}
        		}
        		List<Map<String,Object>> ipList=existsIp(item.get("ip_address_s").toString());
        		if(ipList.size()!=0){
        			if(!ipList.get(0).get("EQUIP_NAME").toString().substring(0, 6).equals(item.get("p_line_name").toString())){
        				msg="存在重复的设备IP！";
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
        		msg="存在重复的设备编码！";
    			errormsg.add(msg);
        	}
        	if(errormsg.size()!=0){
        		return errormsg.get(0).toString();
        	}else{
        		for (Map<String, Object> item : subequipmentList) {
    				String equipName = item.get("equip_name").toString();
    				String equipKey = item.get("equip_key").toString();
    				Equipment equipment = getFunction().getEquipmentByKey(Long.valueOf(equipKey));
    				if (equipment == null) {
    					continue;
    				}
    				String description = item.get("description").toString();
    				equipment.setName(equipName);
    				equipment.setDescription(description);
    				equipment.setUDA(LLWebUtils.getUserName(), EquipmentUDA.CHANGEBY);
    				Date date = new Date();
    				Timestamp timestamp = DateUtil.dateToTime(date);
    				equipment.setUDA(timestamp, EquipmentUDA.CHANGETIME);
    				equipment.setUDA(item.get("ip_address_s").toString(), EquipmentUDA.IP_ADDRESS);
    				equipment.setUDA(item.get("status_s").toString(), EquipmentUDA.STATUS);
    				equipment.setUDA(FactoryEquipmentConstant.CURING, EquipmentUDA.EQUIP_TYPE);
    				equipment.setUDA(FactoryCommonConstant.CURING_PROCESS, EquipmentUDA.PROCESS);
    				equipment.save();
    				// 修改机台类型的时候，页面设备类字段跟equipment_class表在equipment_class_equip产生关系，删除旧关系，新增新关系
    				EquipmentClass equipmentClass = getFunction().getEquipmentClassByName(
    						item.get("machinetype_s").toString());
    				String equipClassKey = getEquipmentClassKeyByEquipkey(equipKey).get(0).get("EQUIP_CLASS_KEY")
    						.toString();
    				EquipmentClass oldEquipmentClass = getFunction().getEquipmentClassByKey(Long.valueOf(equipClassKey));
    				if (equipmentClass == null) {
    					oldEquipmentClass.removeEquipment(equipment);
    					oldEquipmentClass.save();
    					EquipmentClass addEquipmentClass = getFunction().createEquipmentClass(
    							item.get("machinetype_s").toString());
    					addEquipmentClass.addEquipment(equipment);
    					addEquipmentClass.save();
    				} else {
    					oldEquipmentClass.removeEquipment(equipment);
    					oldEquipmentClass.save();
    					equipmentClass.addEquipment(equipment);
    					equipmentClass.save();
    				}
    			}
        	}
		}
		return "操作成功";
	}

	// 判断是否可以删除父设备，等于0可以删除，大于0不可删除，需先删除父设备下的投料口、产出口等
	public int isDeleteFatherEquipment(String equipkey) {
		SQLQuery query = createSQLQuery(getSQL("isDeleteFatherEquipment"));
		query.setParameter("equipkey", equipkey);
		List<Map<String, Object>> list = query.list();
		if (list.get(0).get("COUNT(1)").toString().equals("0")) {
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
	// 判断新保存的设备机型是否已存在数据库（equipment）
	public List<Map<String, Object>> existsEquipment(String equipName) {
		SQLQuery query = createSQLQuery(getSQL("existsEquipment"));
		query.setParameter("equipName", equipName);
		List<Map<String, Object>> list = query.list();
		return list;
	}
	// 判断新保存的设备ip是否已存在数据库（equipment）
		public List<Map<String, Object>> existsIp(String ip) {
			SQLQuery query = createSQLQuery(getSQL("existsIp"));
			query.setParameter("ip", ip);
			List<Map<String, Object>> list = query.list();
			return list;
		}
	// 通过equipment表中equipkey查询equipmentclass表的equipclasskey
	public List<Map<String, Object>> getEquipmentClassKeyByEquipkey(String equipkey) {
		SQLQuery query = createSQLQuery(getSQL("getEquipmentClassKeyByEquipkey"));
		query.setParameter("equipkey", equipkey);
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 获取产线下工作中心的名称 时永良 2019年2月15日
	 * 
	 * @param p_line_key
	 * @return
	 */
	public String getProductlineWCName(String plinename) {
		return getSession().createSQLQuery(getSQL("getProductlineWCName")).setParameter("p_line_name", plinename)
				.uniqueResult().toString();
	}

	/**
	 * 子设备的增删改操作 时永良 2019年2月15日
	 * 
	 * @param cxproductline
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveEquipmentChanges(Map<String, Object> rockWellEntityDTO) throws Exception {
		List<Map<String, Object>> deletedList = (List<Map<String, Object>>) rockWellEntityDTO.get("deleted");
		List<Map<String, Object>> insertedList = (List<Map<String, Object>>) rockWellEntityDTO.get("inserted");
		List<Map<String, Object>> updatedList = (List<Map<String, Object>>) rockWellEntityDTO.get("updated");
		String equipkey = rockWellEntityDTO.get("equipKey").toString();
		Long equip_key = Long.valueOf(equipkey);
		if (!ListUtils.isEmpty(deletedList)) {
			for (Map<String, Object> item : deletedList) {
				Equipment equipment = getFunction().getEquipmentByName(item.get("equip_name").toString());
				Equipment fatherEquipment = getFunction().getEquipmentByKey(equip_key);
				fatherEquipment.removeEquipment(equipment);
				fatherEquipment.save();
				equipment.delete(getDBTime(), LLWebUtils.getUserName() + "删除了设备");
			}
		}
		if (!ListUtils.isEmpty(insertedList)) {
			for (Map<String, Object> item : insertedList) {
				// 设备名称 产线编码+设备类型+物料大类
				final String plinename = item.get("p_line_name").toString();
				String equipName = plinename + "_" + item.get("equip_type_s").toString();
				Equipment equipment = getFunction().createEquipment(equipName);
				equipment.setDescription(item.get("description").toString());
				equipment.setUDA(item.get("equip_type_s").toString(), EquipmentUDA.EQUIP_TYPE);
				equipment.setUDA(item.get("remark_s").toString(), EquipmentUDA.REMARK);
				equipment.setUDA(item.get("device_valid_s").toString(), EquipmentUDA.DEVICE_VALID);
				equipment.setUDA(LLWebUtils.getUserName(), EquipmentUDA.CHANGEBY);
				equipment.setUDA(new Date(), EquipmentUDA.CHANGETIME);
				equipment.setUDA(LLWebUtils.factory(), EquipmentUDA.S_FACTORY);
				equipment.setUDA(LLConstant.JING_MEN_CODE, EquipmentUDA.AGENCNO);
				equipment.setUDA(FactoryCommonConstant.CURING_PROCESS, EquipmentUDA.PROCESS);
				equipment.save();
				// 将子设备投料口、产出口放入设备机型中
				Equipment fatherEquipment = getFunction().getEquipmentByKey(equip_key);
				fatherEquipment.addEquipment(equipment);
				fatherEquipment.save();
			}
		}
		if (!ListUtils.isEmpty(updatedList)) {
			for (Map<String, Object> item : updatedList) {
				Equipment equipment = getFunction().getEquipmentByName(item.get("equip_name").toString());
				if (equipment == null) {
					continue;
				}
				String newName = StringUtils.substringBeforeLast(item.get("equip_name").toString(), "_");
				String newEquipName = newName + "_" + item.get("equip_type_s").toString();
				equipment.setName(newEquipName);
				equipment.setDescription(item.get("description").toString());
				equipment.setUDA(item.get("equip_type_s").toString(), EquipmentUDA.EQUIP_TYPE);
				equipment.setUDA(item.get("remark_s").toString(), EquipmentUDA.REMARK);
				equipment.setUDA(item.get("device_valid_s").toString(), EquipmentUDA.DEVICE_VALID);
				equipment.setUDA(LLWebUtils.getUserName(), EquipmentUDA.CHANGEBY);
				equipment.setUDA(new Date(), EquipmentUDA.CHANGETIME);
				equipment.setUDA(LLWebUtils.factory(), EquipmentUDA.S_FACTORY);
				equipment.setUDA(LLConstant.JING_MEN_CODE, EquipmentUDA.AGENCNO);
				equipment.setUDA(FactoryCommonConstant.CURING_PROCESS, EquipmentUDA.PROCESS);
				equipment.save();
			}
		}
		return "操作成功";
	}

	/**
	 * 查出机台编码,机台名称显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query = createSQLQuery(getSQL("searchDescription"));
		String s_factory_s = LLWebUtils.factory();
		String AGENC_NO_S = FactoryConstant.JING_MEN_CODE;
		query.setParameter("area_name", "8023" + s_factory_s + "C");
		query.setParameter("s_factory_s", s_factory_s);
		query.setParameter("agenc_no_s", AGENC_NO_S);
		System.out.println(getSQL("searchDescription").toString());
		return query.list();
	}
	
	/**
	 * 根据数据字典查出所需控制项（320为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy320(String logo) {
		SQLQuery query = createSQLQuery(getSQL("searchBy320"));
		query.setParameter("logo", logo);
		return query.list();
	}
}
