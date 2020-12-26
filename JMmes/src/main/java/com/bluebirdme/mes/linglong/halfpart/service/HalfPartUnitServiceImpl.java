package com.bluebirdme.mes.linglong.halfpart.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.FactoryProductLineServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.bluebirdme.mes.linglong.core.RockWellUDA.StorageUnitUDA;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartUnit;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartUnitDTO;

import org.xdemo.app.xutils.j2se.ListUtils;
/**
 * 库位信息管理
 * @author 李新宇
 * @Date 2019-04-17 10:02:27
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfPartUnitServiceImpl extends BaseServiceImpl<HalfPartUnit> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv;// 系统参数获取
    @Resource FactoryProductLineServiceImpl factoryProductLineServiceImpl;
    @Resource HalfPartInventoryAccountServiceImpl ledgerSrv;// 库存台账
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }
    @Override
    protected Class getEntity() {
        return HalfPartUnit.class;
    }
    @Override
    protected boolean useCache() {
        return false;
    }
    /**
     * 库位的增删改操作
     * 李新宇
     * 2019年4月17日
     * @param cxproductline
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    public String saveChanges(HalfPartUnitDTO storageUnitDTO) throws Exception{
        
    	List<HalfPartUnit> storageUnitList=null;
		boolean ex_flag = false;
        if (!ListUtils.isEmpty(storageUnitDTO.getInserted())) {
        	storageUnitList=storageUnitDTO.getInserted();
        	String zoneName=null;  //库区条码
        	String zoneBarcode=null;  //库区划分
        	String unitName=null;
        	String unitNameJudgeResult=null;
        	for(HalfPartUnit item:storageUnitList){
        		/*if("112002".equals(item.getStorage_zone_barcode_s())){
					SQLQuery query = getSession().createSQLQuery(getSQL("uniqueOutputLineBank"));
					BigDecimal unique = (BigDecimal)query.setParameter("machine",item.getMachinecode_s()).uniqueResult();
					if(unique != null && unique.intValue()!=0){
						ex_flag = true;
						continue;
					}
				}*/
				String subItemName = item.getStorage_unit_name().substring(item.getStorage_unit_name().indexOf("_") + 1, item.getStorage_unit_name().length());
				if("".equals(subItemName.trim())){
					throw new Exception("库位名称格式不正确");
				}
        		zoneName=item.getStorage_zone_name();
        		unitName=item.getStorage_unit_name();
        		zoneBarcode=item.getStorage_zone_barcode_s();
        		unitNameJudgeResult=unitNameJudge(zoneName,unitName,item.getParent_key());
        		if(unitNameJudgeResult.equals("success")==false){
        			throw new Exception(unitNameJudgeResult);
        		}
        		com.datasweep.compatibility.client.StorageUnit storageUnit=getFunction().createStorageUnit(item.getStorage_unit_name());
        		storageUnit.setDescription(item.getDescription());
        		storageUnit.setMaximumStorageDuration(Integer.parseInt(item.getMax_storage_duration()));
        		storageUnit.setUDA(item.getCurrent_storage_i(),StorageUnitUDA.CURRENT_STORAGE);
        		storageUnit.setUDA(item.getErpcode_s(),StorageUnitUDA.ERPCODE); //存放规格
        		storageUnit.setUDA(item.getInventory_materialcode_s(),StorageUnitUDA.INVENTORY_MATERIALCODE);
        		storageUnit.setUDA(item.getInventory_materialname_s(),StorageUnitUDA.INVENTORY_MATERIALNAME);
        		storageUnit.setUDA(item.getLastintime_t(),StorageUnitUDA.LASTINTIME);
        		storageUnit.setUDA(item.getCanuse_s(),StorageUnitUDA.CANUSE);
        		storageUnit.setUDA(item.getLockflag_s(),StorageUnitUDA.LOCKFLAG);
        		storageUnit.setUDA(item.getLockinflag_s(),StorageUnitUDA.LOCKINFLAG);
        		storageUnit.setUDA(item.getLockoutflag_s(),StorageUnitUDA.LOCKOUTFLAG);
        		storageUnit.setUDA(item.getStorage_zone_barcode_s(),StorageUnitUDA.STORAGE_ZONE_BARCODE);//库区划分
        		storageUnit.setUDA(item.getMachinecode_s(),StorageUnitUDA.MACHINECODE);
        		storageUnit.setUDA(LLWebUtils.getUser().userCode, StorageUnitUDA.OPERATER);
        		storageUnit.setUDA(new Date(),StorageUnitUDA.OPERATETIME);
        		storageUnit.save();
        		com.datasweep.compatibility.client.StorageZone storageZone=getFunction().getStorageZoneByKey(Long.parseLong(item.getParent_key()));
        		storageZone.addStorageUnit(storageUnit);
    			storageZone.save();
        	}
        }
        if (!ListUtils.isEmpty(storageUnitDTO.getDeleted())) {
        	storageUnitList=storageUnitDTO.getDeleted();
        	for(HalfPartUnit item:storageUnitList){
        		com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().getStorageUnitByKey(Long.parseLong(item.getStorage_unit_key()));
        		if(item.getParent_key()!=null){
        			com.datasweep.compatibility.client.StorageZone storageZone=getFunction().getStorageZoneByKey(Long.parseLong(item.getParent_key()));
        			storageZone.removeStorageUnit(storageUnit);
        			storageZone.save();
        		}
        		storageUnit.delete(getDBTime(),LLWebUtils.getUser().userCode+"删除了库位");
        	}
        }
        if (!ListUtils.isEmpty(storageUnitDTO.getUpdated())) {
        	storageUnitList=storageUnitDTO.getUpdated();
        	for(HalfPartUnit item:storageUnitList){
				String subItemName = item.getStorage_unit_name().substring(item.getStorage_unit_name().indexOf("_") + 1, item.getStorage_unit_name().length());
				if("".equals(subItemName.trim())){
					throw new Exception("库位名称格式不正确");
				}
				/*if("112002".equals(item.getStorage_zone_barcode_s())){
					SQLQuery query = getSession().createSQLQuery(getSQL("uniqueOutputLineBank"));
					query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
					Map<String,Object> unique = (Map<String, Object>) query.setParameter("machine",item.getMachinecode_s()).uniqueResult();
					if(unique!=null && !unique.get("storage_unit_key".toUpperCase()).equals(item.getStorage_unit_key())){
						continue;
					}
				}*/
        		com.datasweep.compatibility.client.StorageUnit storageUnit=getFunction().getStorageUnitByKey(Long.parseLong(item.getStorage_unit_key()));
        		storageUnit.setDescription(item.getDescription());
        		storageUnit.setMaximumStorageDuration(Integer.parseInt(item.getMax_storage_duration()));
        		storageUnit.setUDA(item.getCurrent_storage_i(),StorageUnitUDA.CURRENT_STORAGE);
        		storageUnit.setUDA(item.getErpcode_s(),StorageUnitUDA.ERPCODE); //存放规格
        		storageUnit.setUDA(item.getInventory_materialcode_s(),StorageUnitUDA.INVENTORY_MATERIALCODE);
        		storageUnit.setUDA(item.getInventory_materialname_s(),StorageUnitUDA.INVENTORY_MATERIALNAME);
        		storageUnit.setUDA(item.getLastintime_t(),StorageUnitUDA.LASTINTIME);
        		storageUnit.setUDA(item.getCanuse_s(),StorageUnitUDA.CANUSE);
        		storageUnit.setUDA(item.getLockflag_s(),StorageUnitUDA.LOCKFLAG);
        		storageUnit.setUDA(item.getLockinflag_s(),StorageUnitUDA.LOCKINFLAG);
        		storageUnit.setUDA(item.getLockoutflag_s(),StorageUnitUDA.LOCKOUTFLAG);
        		storageUnit.setUDA(item.getStorage_zone_barcode_s(),StorageUnitUDA.STORAGE_ZONE_BARCODE);//库区划分
        		storageUnit.setUDA(item.getMachinecode_s(),StorageUnitUDA.MACHINECODE);
        		storageUnit.setUDA(LLWebUtils.getUserName(), StorageUnitUDA.OPERATER);
        		storageUnit.setUDA(new Date(), StorageUnitUDA.OPERATETIME);
        		storageUnit.save();
        	}
        }
        if(ex_flag) {
        	throw new Exception("选择的机台中已有产出线边库!");
		}
        return "操作成功";
    }
    
    /**
     * 根据库区条码、库位条码、库区划分校验库区条码是否符合规则
     * 李新宇
     * 2019-06-21
     * @param zoneName
     * @param unitName
     * @param zoneBarcode
     */
    private String unitNameJudge(String zoneName, String unitName,String parentKey) {

 		char seventh= unitName.charAt(6);//获取字符串的第一个字符
 		String  unitPreIndex=unitName.substring(0,7);
 		SQLQuery uniqueUnitNameJudge=createSQLQuery(getSQL("uniqueUnitNameJudge"));
 		uniqueUnitNameJudge.setParameter("unitName",unitName);
		if(uniqueUnitNameJudge.list().isEmpty()==false){
			return "库位编码已存在";
		}
 		//String  unitPreIndex=unitName.substring(0,6);
		return "success";
	}
	public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
   /**
    * 初始化库位数据，不对外使用
    * 李新宇
    * 2019年4月17日
    * @param areaName area得name，80031B半钢，80031A全钢
    * @param storageZoneName 要维护得库区name，自己填，和PD一致就好
    * @param storageUnitType 161001是投料，161002是产出
    * @param unitDescription 库位描述
    * @throws Exception
    */
    @RockWellTransactional
    public void initializateStorageUnits(String areaName,String storageZoneName,String storageUnitType,String unitDescription) throws Exception {
    	List<Map<String, Object>>productlineList= factoryProductLineServiceImpl.getProductlineByAreaName(areaName);
		for(Map<String, Object> map:productlineList){
			String productLineName=map.get("p_line_name").toString();
			if(unitDescription==null){
				unitDescription=map.get("p_line_name").toString()+"产线"+"产出线边库";
			}
			String storageUnitName =productLineName+"_"+storageUnitType;
			com.datasweep.compatibility.client.StorageUnit storageUnit=getFunction().createStorageUnit(storageUnitName);
    		storageUnit.setDescription(unitDescription);
    		storageUnit.setUDA(storageZoneName, "storage_Zone_Barcode");
    		storageUnit.setUDA(LLWebUtils.getUserName(), "operater");
    		storageUnit.setUDA(new Date(), "operateTime");
    		storageUnit.save();
    		com.datasweep.compatibility.client.StorageZone storageZone=getFunction().getStorageZoneByName(storageZoneName);
    		storageZone.addStorageUnit(storageUnit);
			storageZone.save();
			System.out.println("已经维护："+storageZoneName+"产线："+productLineName);
		}
		
	}
    /**
     * 获取库区下得库位信息
     * 李新宇
     * 2019年4月17日
     * @param zonekey 库区的id
     * @return
     * @throws Exception
     */
 	public List<Map<String, Object>>getUnit(String zonekey,String materialGroup) throws Exception {
  		SQLQuery query_1=createSQLQuery(getSQL("getUnit"));
  		query_1.setParameter("parent_key", zonekey);
  		TransformUpperCase transformUpperCase=new TransformUpperCase();
  		List<Map<String, Object>> result_1=query_1.list();
  		
  		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
  	}
 	
	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在
	 * 李新宇
	 * 2019年5月25日
	 */
	public boolean creatUnitWhenCreatZone(String zonekey, String materialGroup) throws Exception{
		for(int i=0;i<2;i++){
			String inventoryCode=null;
			String unitCode =null;
			if(i==0){
				inventoryCode="112001";//投入线边库
			}
			if(i==1){
				inventoryCode="112004";//投入虚拟库
			}
			String unitPre=zonekey.concat("_").concat(materialGroup).concat("_").concat(inventoryCode).concat("_");
			unitCode=serialSrv.serial(unitPre,3,1).get(0).toString();
			com.datasweep.compatibility.client.StorageUnit storageUnit=getFunction().createStorageUnit(unitCode);
			storageUnit.setMaximumStorageDuration(99);
			storageUnit.setUDA("0",StorageUnitUDA.CURRENT_STORAGE);
			storageUnit.setUDA("1",StorageUnitUDA.CANUSE);
			storageUnit.setUDA("0",StorageUnitUDA.LOCKFLAG);
			storageUnit.setUDA("0",StorageUnitUDA.LOCKINFLAG);
			storageUnit.setUDA("0",StorageUnitUDA.LOCKOUTFLAG);
			storageUnit.setUDA(inventoryCode,StorageUnitUDA.STORAGE_ZONE_BARCODE);//库区划分
			storageUnit.setUDA(LLWebUtils.getUser().userCode, StorageUnitUDA.OPERATER);
			storageUnit.setUDA(new Date(),StorageUnitUDA.OPERATETIME);
			storageUnit.save();
			com.datasweep.compatibility.client.StorageZone storageZone=getFunction().getStorageZoneByKey(Long.parseLong(zonekey));
			storageZone.addStorageUnit(storageUnit);
			storageZone.save();
		}
		return true;
	}
 	
 	/**
 	 * 根据库区key获得库区描述
 	 * 
 	 */
 	public List<String> searchMaterialGroupByZoneKey(String zonekey) throws Exception{
 	    SQLQuery description=createSQLQuery(getSQL("searchMaterialGroupByZoneKey"));
 	    description.setParameter("zonekey", zonekey);
 	    return description.list();
 	}
    /**
     * @param 根据zone key 获得 库区名称(存于category字段下)
     * @return
     * @throws Exception
     */
	public String searchZoneNameByZoneKey(String zoneKey) throws Exception{

    	SQLQuery zoneNameQuery= getSession().createSQLQuery(getSQL("searchZoneNameByZoneKey"));
    	zoneNameQuery.setParameter("zoneKey",Long.parseLong(zoneKey));
    	return zoneNameQuery.getComment();
    }
	public String createUnitName(String storagezonekey,String category) {
		String unitPre=category.concat("_").concat(storagezonekey).concat("_").concat("112003");
		String unitCode=serialSrv.serial(unitPre.concat("_"),3,1).get(0).toString();
		return unitCode;
	}
	
	/**
     * 通过库区找到载具
     * 葛迎祥
     * 2020年7月22日
     * @param zonekey 库区的id
     * @return
     * @throws Exception
     */
	public List<Map<String, Object>> findVechineByZone(String zonekey)
			throws Exception {
		SQLQuery query_1 = createSQLQuery(getSQL("findVechineByZone"));
		query_1.setParameter("location_s", zonekey);
		TransformUpperCase transformUpperCase = new TransformUpperCase();
		List<Map<String, Object>> result_1 = query_1.list();

		List<Map<String, Object>> list_1 = new ArrayList();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase((Map) result_1.get(i)));
		}
		return list_1;
	}
	
	/**
     * 通过传库区条码获取库位信息
     * 葛迎祥
     * 2020年7月22日
     * @param zonekey 库区的id
     * @return
     * @throws Exception
     */
 	public String getZoneList(String zonekey) throws Exception {
  		SQLQuery query=createSQLQuery(getSQL("getZoneList"));
  		query.setParameter("zonekey", zonekey);
  		List<Map<String, Object>> result=query.list();
  		
  		String unitString = "";
  		int totalNum = 0;
  		for (int i = 0; i < result.size(); i++) {
  			Map<String, Object> mapUnit = result.get(i);
  			
  			Filter filter = new Filter();
//  	  		filter.set("s_factory_s", LLWebUtils.factory());
  	  		filter.set("location_s", mapUnit.get("STORAGE_UNIT_NAME").toString());
  	  		Page page = new Page();
	  	  	page.setAll(1);// 取消分页
  	  		Map map = new HashMap();
  	  		List<Map<String, Object>> listMap = ledgerSrv.datagridRowsUDA(filter,page,map);
  	  		totalNum = listMap.size();
  			
  			// 库位名称
  			String storage_unit_name = mapUnit.get("STORAGE_UNIT_NAME").toString();
  			// 物料名称
  			String inventory_materialname_s = mapUnit.get("INVENTORY_MATERIALNAME_S").toString() == null ? "无" : mapUnit.get("INVENTORY_MATERIALNAME_S").toString();
  			
  			unitString += "<div>";
  			unitString += 	"<svg width=\"2400\" height=\"60\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"> ";
  			unitString += 		"<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\" ";
  			unitString += 			"y=\"20\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"+ storage_unit_name +"</text> ";
  			unitString += 		"<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\" ";
  			unitString += 			"y=\"35\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"+ inventory_materialname_s +"</text>";
  			unitString += 		"<text xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\" ";
  			unitString += 			"y=\"50\" x=\"10\" stroke-width=\"0\" stroke=\"#000\" fill=\"#000000\">"+ totalNum +"</text>";
  			
  			int len = 150;
  			for (int j = 0; j < listMap.size(); j++) {
  				Map<String, Object> curMapUnit = listMap.get(j);
  				
  				String batchcode = (String) curMapUnit.get("barcode_s");// 批次号
  				Object yl_num_f_obj = curMapUnit.get("yl_num_f");
  				String yl_num_f = yl_num_f_obj.toString() == null ? "0" : yl_num_f_obj.toString() ;// 产出米数
  				String created_by_s = (String) curMapUnit.get("created_by_s");// 用户
  				String equip_code_s = (String) curMapUnit.get("equip_code_s");// 产线(机台)编号
  				String lenStr = String.valueOf(len);
  				
  				unitString += 		"<g>";
  				unitString += 		"<title>批次号："+ batchcode +"</title>";
  				unitString += 		"<image id=\"0\" xlink:href=\"resources/images/redcar.png\" x=\""+ lenStr +"\" y=\"30\" height=\"30\" width=\"40\" ";
  				unitString += 			"onclick=\"alert('"+ batchcode +"')\"></image>  </g>";
  				unitString += 		"<text font-weight=\"bold\" xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\" ";
  				unitString += 			"y=\"10\" x=\""+ lenStr +"\" stroke-width=\"0\" stroke=\"#000\" fill=\"#bf0000\">"+ equip_code_s +","+ created_by_s +"</text>";
  				unitString += 		"<text font-weight=\"bold\" xml:space=\"preserve\" text-anchor=\"start\" font-family=\"'Times New Roman', Times, serif\" font-size=\"12\" ";
  				unitString += 			"y=\"20\" x=\""+ lenStr +"\" stroke-width=\"0\" stroke=\"#000\" fill=\"#bf0000\">??,"+ yl_num_f +"</text>";
  				
  				len += 85;
			}
  			
  			unitString += 		"<line id=\"a\" y2=\"60\" x2=\"150\" y1=\"60\" x1=\"2400\" stroke-width=\"2.5\" stroke=\"#000\" fill=\"none\"></line>";
  			unitString += 	"</svg>";
  			unitString += "</div>";
		}
  		
		return unitString;
  	}
	
}
		