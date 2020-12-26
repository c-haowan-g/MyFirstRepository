/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.building.entity.Zoneb;
import com.bluebirdme.mes.linglong.building.entity.dto.ZonebDTO;
import com.bluebirdme.mes.linglong.building.uda.ZonebUDA;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Area;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Tip;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
/**
 * 库区信息管理
 * 李迺锟
 * 2019年7月30日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ZonebServiceImpl extends BaseServiceImpl<Zoneb> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv;// 系统参数获取
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Zoneb.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
   
    public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
    String areaName=null;
    /**
     * 库区的增删改操作
     * 李迺锟
     * 2019年7月30日
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveChanges(ZonebDTO storageZoneDTO) throws Exception{
    	List<Zoneb> storageZone=null;
    	String zoneNameJudgeResult=null;
    	if (!ListUtils.isEmpty(storageZoneDTO.getInserted())) {
        	storageZone=storageZoneDTO.getInserted();
        	for(Zoneb item:storageZone){
				/*String category=item.getCategory(); //用于存储产线字段（半部件库区条码）
				String materialGroup=item.getMaterialgroup_s();
				if(zoneAndMaterialGroupJudge(category,materialGroup)==true){
					continue;
				}*/
				//String inventoryBarcode=null;
        		//String materialGroup=item.getMaterialgroup_s();
        		//String zoneName=category.concat(materialGroup);
        		//String zoneName=serialSrv.serial(category,4,1).get(0).toString();
        		//item.setStorage_zone_name(zoneName);
        		zoneNameJudgeResult=zoneNameJudge(item.getStorage_zone_name(),item.getS_factory_s(),item.getStorage_zone_key());
        		if(zoneNameJudgeResult.equals("success")==false){
        			return zoneNameJudgeResult;
        		}
        		com.datasweep.compatibility.client.StorageZone insertStorageZone=getFunction().createStorageZone(item.getStorage_zone_name());
        		insertStorageZone.setCategory(item.getCategory());
        		insertStorageZone.setDescription(item.getDescription());//库区描述
        		insertStorageZone.setUDA(item.getMaterialgroup_s(),ZonebUDA.MATERIALGROUP); //库区物料组                              
        		insertStorageZone.setUDA(item.getIs_allow_child_stock_s(),ZonebUDA.IS_ALLOW_CHILD_STOCK); //是否包含子库
        		insertStorageZone.setUDA(item.getRemarks_s(),ZonebUDA.REMARKS);              //备注
        		insertStorageZone.setUDA(LLWebUtils.getUser().userCode,ZonebUDA.OPERATER);        //操作人uda
        		insertStorageZone.setUDA(item.getStorage_type_s(), ZonebUDA.STORAGE_TYPE);    //库区种类
        		insertStorageZone.setUDA(new Date(),ZonebUDA.OPERATETIME);                   //操作时间uda
        		insertStorageZone.setUDA(item.getS_factory_s(),ZonebUDA.S_FACTORY);   
        		insertStorageZone.setUDA(LLConstant.JING_MEN_CODE,ZonebUDA.AGENCNO);
        		insertStorageZone.setUDA(Process.HalfPart,ZonebUDA.PROCESS);                 //半部件工序
        		//inventoryBarcode=item.getCategory().concat("_").concat(item.getMaterialgroup_s());
        		//insertStorageZone.setUDA(inventoryBarcode,StorageZoneUDA.INVENTORY_BARCODE); //库区逻辑条码，同模型表中的storage_zone_name
        		//insertStorageZone.setUDA(item.getStorage_zone_name(),StorageZoneUDA.STORAGE_ZONE_BARCODE);  //库区条码，同模型表中的category
        		insertStorageZone.save();
        		/*
        		 * 在area中插入库区
        		 */
        		
        		if(item.getS_factory_s().equals(Factory.FullSteel)){
        			areaName=Area.FullSteelBuildingArea;
        		}else if(item.getS_factory_s().equals(Factory.HalfSteel)){
        			areaName=Area.HalfSteelBuildingArea;
        		}
        		com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
        		area.addStorageZone(insertStorageZone);
        		area.save();
        	}
        }
        if (!ListUtils.isEmpty(storageZoneDTO.getDeleted())) {
            
        	if (!ListUtils.isEmpty(storageZoneDTO.getDeleted())) {
            	storageZone=storageZoneDTO.getDeleted();
            	for(Zoneb item:storageZone){
            		if(item.getS_factory_s().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
            			areaName=Area.FullSteelBuildingArea;
            		}else if(item.getS_factory_s().equals(Factory.HalfSteel)){
            			areaName=Area.HalfSteelBuildingArea;
            		}
            	}
            }
        	
    		
    		com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
    		List<String> errorTips = new ArrayList<>();
        	for(Zoneb item:storageZone){
        		com.datasweep.compatibility.client.StorageZone deleteStorageZone =getFunction().getStorageZoneByKey(Long.parseLong(item.getStorage_zone_key()));
	            area.removeStorageZone(deleteStorageZone);      //删除area中维护的库区
	            area.save();
        		deleteStorageZone.delete(getDBTime(),LLWebUtils.getUser().userCode+Tip.DELETEZONE); //删除库区
            		
        	}
        }
 
        if (!ListUtils.isEmpty(storageZoneDTO.getUpdated())) {
        	storageZone=storageZoneDTO.getUpdated();
        	String inventoryBarcode=null;
        	for(Zoneb item:storageZone){
        		zoneNameJudgeResult=zoneNameJudge(item.getStorage_zone_name(),item.getS_factory_s(),item.getStorage_zone_key());
        		if(zoneNameJudgeResult.equals("success")==false){
        			return zoneNameJudgeResult;
        		}
        		com.datasweep.compatibility.client.StorageZone updateStorageZone=getFunction().getStorageZoneByKey(Long.parseLong(item.getStorage_zone_key()));
        		if(updateStorageZone==null){
        			continue;
        		}
        		updateStorageZone.setName(item.getStorage_zone_name());//修改库区名称
        		updateStorageZone.setUDA(item.getStorage_type_s(), ZonebUDA.STORAGE_TYPE);
        		updateStorageZone.setCategory(item.getCategory());//用于存半部件库区条码
        		updateStorageZone.setDescription(item.getDescription());//库区描述
        		updateStorageZone.setUDA(item.getMaterialgroup_s(),ZonebUDA.MATERIALGROUP); //库区物料组                              
        		updateStorageZone.setUDA(item.getIs_allow_child_stock_s(),ZonebUDA.IS_ALLOW_CHILD_STOCK); //是否包含子库
        		updateStorageZone.setUDA(item.getRemarks_s(),ZonebUDA.REMARKS);              //备注
        		updateStorageZone.setUDA(LLWebUtils.getUser().userCode,ZonebUDA.OPERATER);        //操作人uda
        		updateStorageZone.setUDA(new Date(),ZonebUDA.OPERATETIME);                   //操作时间uda
        		updateStorageZone.setUDA(item.getS_factory_s(),ZonebUDA.S_FACTORY);  
        		updateStorageZone.save();
        	}
        }
		return "success";
    }
    /**
     * 判断库区下是否存在库位
     * 
     */
    public boolean unitExists(String zonekey){
    	SQLQuery unitExistsListQuery= createSQLQuery(getSQL("getUnitByZoneKey"));
    	unitExistsListQuery.setParameter("storage_zone_key", zonekey);
    	List<Map<String, Object>> unitExistsList=unitExistsListQuery.list();
    	if(unitExistsList.isEmpty()==true){
    		return false;
    	}
    	return true;
    }
    
    /**
     * 
     * 返回库区信息
     * 李迺锟
     * 2019/04/18
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<Zoneb> getZone(String category,String description) throws Exception {
		SQLQuery query=createSQLQuery(getSQL("getZone"),Zoneb.class);
		Filter filter = new Filter();
		
		if(LLWebUtils.factory().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
			areaName=Area.FullSteelBuildingArea;
			query.setParameter("area_name",areaName);
		}else if(LLWebUtils.factory().equals(Factory.HalfSteel)){
			areaName=Area.HalfSteelBuildingArea;
			query.setParameter("area_name",areaName);
		}
		if(category!=null&&category!=""){
    		query.setParameter("category",category);
    	}else{
    		query.setParameter("category","");
    	}
    	if(description!=null&&description!=""){
    		query.setParameter("description",description);
    	}else{
    		query.setParameter("description","");
    	}
    		
		List<Zoneb> test=query.list();
		return query.list();
	}

    
    
   /**
    * 删除某库区下的所有库位
    * 李迺锟
    * 2019年4月17日
    * @param zonekey
    * @throws Exception
    */
    @SuppressWarnings("unchecked")
	public void deleteUnitByZoneKey(String zonekey) throws Exception {
    	com.datasweep.compatibility.client.StorageZone deletestoragezone=getFunction().getStorageZoneByKey(Long.parseLong(zonekey));
    	deletestoragezone.delete(getDBTime(), "删除库区");
		List<Map<String, Object>> unitIDList= createSQLQuery(getSQL("getUnitByZoneKey")).setParameter("storage_zone_key", zonekey).list();
    	if(unitIDList.size()==0){
    		return;
    	}
    	for (Map<String, Object> map : unitIDList) {
    		
    	    String testString=map.toString();
    	    if(testString.contains("null")){
    	    	continue;
    	    }
    		
    		Long unitID=Long.parseLong(map.get("CHILD_KEY").toString());
    		com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().getStorageUnitByKey(unitID);
    		storageUnit.delete(getDBTime(), LLWebUtils.getUser().userCode+"删除库位");
    	}
    	
	}
    /**
     * 为查询栏添加查询方法
     * 2019-05-23
     * 李迺锟
     * 
     */
    
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchZoneByCategoryAndZoneName(String category,String description) throws Exception{
    	Filter filter = new Filter();
    	if(category!=null&&category!=""){
    		filter.set("category",category);
    	}
    	if(description!=null&&description!=""){
    		filter.set("description",description);
    	}
		System.out.println(getSQL("searchZoneByCategoryAndZoneName",filter));
  		SQLQuery query=createSQLQuery(getSQL("searchZoneByCategoryAndZoneName",filter));
    	if(category!=null&&category!=""){
    		query.setParameter("category",category);
    	}
    	if(description!=null&&description!=""){
    		query.setParameter("description",description);
    	}
    	
    	if(LLWebUtils.factory().equals(Factory.FullSteel)){
			query.setParameter("area_name",Area.FullSteelBuildingArea);
		}
		else{
			query.setParameter("area_name",Area.HalfSteelBuildingArea);
		}
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
    }
	
	
	public List<String> searchZoneName() throws Exception{

    	SQLQuery searchZoneName=createSQLQuery(getSQL("searchZoneName"));
		if(LLWebUtils.factory().equals(Factory.FullSteel)){
			searchZoneName.setParameter("area_name",Area.FullSteelBuildingArea);
		}
		else{
			searchZoneName.setParameter("area_name",Area.HalfSteelBuildingArea);
		}
    	return searchZoneName.list();
    }
	
	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在
	 * 李迺锟
	 * 2019年5月25日
	 */
	public boolean zoneAndMaterialGroupJudge(String zoneName,String materialGroup) {
		SQLQuery zoneAndMaterialGroupJudge=createSQLQuery(getSQL("zoneAndMaterialGroupJudge"));
		zoneAndMaterialGroupJudge.setParameter("zoneName",zoneName);
		zoneAndMaterialGroupJudge.setParameter("materialGroup",materialGroup);
		if(zoneAndMaterialGroupJudge.list().size()==0||zoneAndMaterialGroupJudge.list().isEmpty()==true){
			return false;
		}
		return true;
	}
	
	/**库区编码规则校验
	 * 李迺锟
	 * 2019年6月21日
	 */
	public String zoneNameJudge(String zoneName,String factory,String key) {
		String areaName=null;
 		if(!(zoneName.length()==6)){
 			return "库区条码必须是6位";
 		}
 		System.out.println(Factory.HalfSteel);
 		System.out.println(LLWebUtils.factory());
 		String  unitPreIndex=zoneName.substring(0,3);
 		SQLQuery uniqueZoneNameJudge=createSQLQuery(getSQL("uniqueZoneNameJudge"));
 		if(factory.equals(Factory.FullSteel)){
 	 		if(unitPreIndex.equals("FKB")){
 				//areaName=Area.FullSteelHalfPartArea;
 				//uniqueZoneNameJudge.setParameter("area_name",areaName);
 				uniqueZoneNameJudge.setParameter("zoneName",zoneName);
 				if(uniqueZoneNameJudge.list().isEmpty() && key == null){
 					return "success";
 				}else if (key != null){
 					return "success";
 				}
 				
 	 			return "库区编码已被使用"; 
 	 		}
 	 		return "全钢库区编码规则：F:全钢 KB";
 		}
		if(factory.equals(Factory.HalfSteel)){
			if(unitPreIndex.equals("HKB")){
				uniqueZoneNameJudge.setParameter("zoneName",zoneName);
 				if(uniqueZoneNameJudge.list().isEmpty()){
 					return "success";
 				}
 	 		}
 		    return "半钢库区编码规则：H:半钢 KB";
 		}

        return "success";
	}
	/**
	 * 删除库区时校验该产线及物料组相关的当前日期及以后的日计划是否存在
	 * 李迺锟
	 * 2019年6月12日
	 */
	public boolean productPlanExistJudge(String zoneCode,String materialGroupCode) {
		SQLQuery query=createSQLQuery(getSQL("productPlanExistJudge"));
		query.setParameter("zoneCode",zoneCode);
		query.setParameter("materialGroupCode",materialGroupCode);
		if(query.list().size()==0||query.list().isEmpty()==true){
			return true;
		}
		return false;
	}
}



