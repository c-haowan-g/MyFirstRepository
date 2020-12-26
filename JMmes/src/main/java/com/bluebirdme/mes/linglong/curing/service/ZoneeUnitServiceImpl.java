/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

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
import com.bluebirdme.mes.linglong.common.entity.ZoneUnit;
import com.bluebirdme.mes.linglong.common.entity.dto.ZoneUnitDTO;
import com.bluebirdme.mes.linglong.common.uda.ZoneUnitUDA;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ZoneeUnit;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.StorageUnit;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 库位信息管理 李迺锟 2019年7月30日
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ZoneeUnitServiceImpl extends BaseServiceImpl<ZoneeUnit> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl serialSrv;// 系统参数获取

	// @Resource FactoryProductLineServiceImpl factoryProductLineServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ZoneUnit.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 库位的增删改操作 李迺锟 2019年7月30日
	 * 
	 * @param cxproductline
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveChanges(ZoneUnitDTO storageUnitDTO) throws Exception {

		List<ZoneUnit> storageUnitList = null;

		if (!ListUtils.isEmpty(storageUnitDTO.getInserted())) {
			storageUnitList = storageUnitDTO.getInserted();
			String zoneName = null; // 库区条码
			String zoneBarcode = null; // 库区划分
			String unitName = null;
			String unitNameJudgeResult = null;
			for (ZoneUnit item : storageUnitList) {
				// zoneInventoryBarcode=item.getInventory_barcode_s();
				// preIndexUnitName=zoneInventoryBarcode.concat("_").concat(zoneBarcode).concat("_");
				// unitCode=serialSrv.serial(zoneName,4,1).get(0).toString();
				// unitCode=serialSrv.serial(preIndexUnitName,3,1).get(0).toString();
				zoneName = item.getStorage_zone_name();
				unitName = item.getStorage_unit_name();
				zoneBarcode = item.getStorage_zone_barcode_s();
				unitNameJudgeResult = unitNameJudge(zoneName, unitName, item.getParent_key());
				if (unitNameJudgeResult.equals("success") == false) {
					return unitNameJudgeResult;
				}
				com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().createStorageUnit(
						item.getStorage_unit_name());
				storageUnit.setDescription(item.getDescription());
				storageUnit.setMaximumStorageDuration(Integer.parseInt(item.getMax_storage_duration()));
				storageUnit.setUDA(item.getCurrent_storage_i(), ZoneUnitUDA.CURRENT_STORAGE);
				storageUnit.setUDA(item.getErpcode_s(), ZoneUnitUDA.ERPCODE); // 存放规格
				storageUnit.setUDA(item.getInventory_materialcode_s(), ZoneUnitUDA.INVENTORY_MATERIALCODE);
				storageUnit.setUDA(item.getLastintime_t(), ZoneUnitUDA.LASTINTIME);
				storageUnit.setUDA(item.getCanuse_s(), ZoneUnitUDA.CANUSE);
				storageUnit.setUDA(item.getLockflag_s(), ZoneUnitUDA.LOCKFLAG);
				storageUnit.setUDA(item.getLockinflag_s(), ZoneUnitUDA.LOCKINFLAG);
				storageUnit.setUDA(item.getLockoutflag_s(), ZoneUnitUDA.LOCKOUTFLAG);
				storageUnit.setUDA(item.getStorage_zone_barcode_s(), ZoneUnitUDA.STORAGE_ZONE_BARCODE);// 库区划分
				storageUnit.setUDA(item.getMachinecode_s(), ZoneUnitUDA.MACHINECODE);
				storageUnit.setUDA(LLWebUtils.getUser().userCode, ZoneUnitUDA.OPERATER);
				storageUnit.setUDA(new Date(), ZoneUnitUDA.OPERATETIME);
				storageUnit.save();
				com.datasweep.compatibility.client.StorageZone storageZone = getFunction().getStorageZoneByKey(
						Long.parseLong(item.getParent_key()));
				storageZone.addStorageUnit(storageUnit);
				storageZone.save();
			}
		}
		if (!ListUtils.isEmpty(storageUnitDTO.getDeleted())) {
			storageUnitList = storageUnitDTO.getDeleted();
			for (ZoneUnit item : storageUnitList) {
				com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().getStorageUnitByKey(
						Long.parseLong(item.getStorage_unit_key()));
				if (item.getParent_key() != null) {
					com.datasweep.compatibility.client.StorageZone storageZone = getFunction().getStorageZoneByKey(
							Long.parseLong(item.getParent_key()));
					storageZone.removeStorageUnit(storageUnit);
					storageZone.save();
				}
				storageUnit.delete(getDBTime(), LLWebUtils.getUser().userCode + "删除了库位");
			}
		}
		if (!ListUtils.isEmpty(storageUnitDTO.getUpdated())) {
			storageUnitList = storageUnitDTO.getUpdated();
			for (ZoneUnit item : storageUnitList) {
				com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().getStorageUnitByKey(
						Long.parseLong(item.getStorage_unit_key()));
				storageUnit.setName(item.getStorage_unit_name());// 修改库位名称
				storageUnit.setDescription(item.getDescription());
				storageUnit.setMaximumStorageDuration(Integer.parseInt(item.getMax_storage_duration()));
				storageUnit.setUDA(item.getCurrent_storage_i(), ZoneUnitUDA.CURRENT_STORAGE);
				storageUnit.setUDA(item.getErpcode_s(), ZoneUnitUDA.ERPCODE); // 存放规格
				storageUnit.setUDA(item.getInventory_materialcode_s(), ZoneUnitUDA.INVENTORY_MATERIALCODE);
				storageUnit.setUDA(item.getLastintime_t(), ZoneUnitUDA.LASTINTIME);
				storageUnit.setUDA(item.getCanuse_s(), ZoneUnitUDA.CANUSE);
				storageUnit.setUDA(item.getLockflag_s(), ZoneUnitUDA.LOCKFLAG);
				storageUnit.setUDA(item.getLockinflag_s(), ZoneUnitUDA.LOCKINFLAG);
				storageUnit.setUDA(item.getLockoutflag_s(), ZoneUnitUDA.LOCKOUTFLAG);
				storageUnit.setUDA(item.getStorage_zone_barcode_s(), ZoneUnitUDA.STORAGE_ZONE_BARCODE);// 库区划分
				storageUnit.setUDA(LLWebUtils.getUser().userCode, ZoneUnitUDA.OPERATER);
				storageUnit.setUDA(new Date(), ZoneUnitUDA.OPERATETIME);
				storageUnit.save();
			}
		}
		return "操作成功";
	}

	/**
	 * 根据库区条码、库位条码、库区划分校验库区条码是否符合规则 李迺锟 2019年7月30日
	 * 
	 * @param zoneName
	 * @param unitName
	 * @param zoneBarcode
	 */
	private String unitNameJudge(String zoneName, String unitName, String parentKey) {
		if (!(unitName.length() == 12)) {
			return "库位条码必须是12位(包含下划线)";
		}
		char seventh = unitName.charAt(7);// 获取字符串的第一个字符
		if (!(String.valueOf(seventh).equals("_"))) {
			return "库位条码第8位请设置下划线";
		}
		String unitPreIndex = unitName.substring(0, 8);
		if (zoneName.concat("_").equals(unitPreIndex) == false) {
			return "库位条码前缀必须与库区条码相同";
		}
		SQLQuery uniqueUnitNameJudge = createSQLQuery(getSQL("uniqueUnitNameJudge"));
		uniqueUnitNameJudge.setParameter("unitName", unitName);
		uniqueUnitNameJudge.setParameter("parent_key", parentKey);
		if (uniqueUnitNameJudge.list().isEmpty() == false) {
			return "库位编码已存在";
		}
		// String unitPreIndex=unitName.substring(0,6);
		return "success";
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	/**
	 * 初始化库位数据，不对外使用 李迺锟 2019年7月30日
	 * 
	 * @param areaName
	 *            area得name，80231B半钢，80231A全钢
	 * @param storageZoneName
	 *            要维护得库区name，自己填，和PD一致就好
	 * @param storageUnitType
	 *            161001是投料，161002是产出
	 * @param unitDescription
	 *            库位描述
	 * @throws Exception
	 */
	/*
	 * @RockWellTransactional public void initializateStorageUnits(String
	 * areaName,String storageZoneName,String storageUnitType,String
	 * unitDescription) throws Exception { //List<Map<String,
	 * Object>>productlineList=
	 * factoryProductLineServiceImpl.getProductlineByAreaName(areaName);
	 * for(Map<String, Object> map:productlineList){ String
	 * productLineName=map.get("p_line_name").toString();
	 * if(unitDescription==null){
	 * unitDescription=map.get("p_line_name").toString()+"产线"+"产出线边库"; } String
	 * storageUnitName =productLineName+"_"+storageUnitType;
	 * com.datasweep.compatibility.client.StorageUnit
	 * storageUnit=getFunction().createStorageUnit(storageUnitName);
	 * storageUnit.setDescription(unitDescription);
	 * storageUnit.setUDA(storageZoneName, "storage_Zone_Barcode");
	 * storageUnit.setUDA(LLWebUtils.getUserName(), "operater");
	 * storageUnit.setUDA(new Date(), "operateTime"); storageUnit.save();
	 * com.datasweep.compatibility.client.StorageZone
	 * storageZone=getFunction().getStorageZoneByName(storageZoneName);
	 * storageZone.addStorageUnit(storageUnit); storageZone.save();
	 * System.out.println("已经维护："+storageZoneName+"产线："+productLineName); }
	 * 
	 * }
	 */
	/**
	 * 获取库区下得库位信息 李迺锟 2019年7月30日
	 * 
	 * @param zonekey
	 *            库区的id
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getUnit(String zonekey, String materialGroup) throws Exception {
		SQLQuery query_1 = createSQLQuery(getSQL("getUnit"));
		query_1.setParameter("parent_key", zonekey);
		TransformUpperCase transformUpperCase = new TransformUpperCase();
		List<Map<String, Object>> result_1 = query_1.list();

		/*
		 * if(result_1.size()==0||result_1.isEmpty()==true){
		 * creatUnitWhenCreatZone(zonekey,materialGroup); }
		 */
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在 李迺锟 2019年7月30日
	 */
	public boolean creatUnitWhenCreatZone(String zonekey, String materialGroup) throws Exception {
		for (int i = 0; i < 2; i++) {
			String inventoryCode = null;
			String unitCode = null;
			if (i == 0) {
				inventoryCode = "112001";// 投入线边库
			}
			if (i == 1) {
				inventoryCode = "112004";// 投入虚拟库
			}
			String unitPre = zonekey.concat("/").concat(materialGroup).concat("/").concat(inventoryCode).concat("/");
			unitCode = serialSrv.serial(unitPre, 3, 1).get(0).toString();
			com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().createStorageUnit(unitCode);
			storageUnit.setMaximumStorageDuration(99);
			storageUnit.setUDA("0", ZoneUnitUDA.CURRENT_STORAGE);
			storageUnit.setUDA("1", ZoneUnitUDA.CANUSE);
			storageUnit.setUDA("0", ZoneUnitUDA.LOCKFLAG);
			storageUnit.setUDA("0", ZoneUnitUDA.LOCKINFLAG);
			storageUnit.setUDA("0", ZoneUnitUDA.LOCKOUTFLAG);
			storageUnit.setUDA(inventoryCode, ZoneUnitUDA.STORAGE_ZONE_BARCODE);// 库区划分
			storageUnit.setUDA(LLWebUtils.getUser().userCode, ZoneUnitUDA.OPERATER);
			storageUnit.setUDA(new Date(), ZoneUnitUDA.OPERATETIME);
			storageUnit.save();
			com.datasweep.compatibility.client.StorageZone storageZone = getFunction().getStorageZoneByKey(
					Long.parseLong(zonekey));
			storageZone.addStorageUnit(storageUnit);
			storageZone.save();
		}
		return true;
	}

	/**
	 * 根据库区key获得库区描述
	 * 
	 */
	public List<String> searchMaterialGroupByZoneKey(String zonekey) throws Exception {
		SQLQuery description = createSQLQuery(getSQL("searchMaterialGroupByZoneKey"));
		description.setParameter("zonekey", zonekey);
		return description.list();
	}

	/**
	 * @param 根据zone
	 *            key 获得 库区名称(存于category字段下)
	 * @return
	 * @throws Exception
	 */
	public String searchZoneNameByZoneKey(String zoneKey) throws Exception {

		SQLQuery zoneNameQuery = getSession().createSQLQuery(getSQL("searchZoneNameByZoneKey"));
		zoneNameQuery.setParameter("zoneKey", Long.parseLong(zoneKey));
		return zoneNameQuery.getComment();
	}

	public String createUnitName(String storagezonekey, String category) {
		String unitPre = category.concat("/").concat(storagezonekey).concat("/").concat("112003");
		String unitCode = serialSrv.serial(unitPre.concat("/"), 3, 1).get(0).toString();
		return unitCode;
	}

	/**
	 * 库位的占用状态操作，用于模具信息管理页面的模具入库占用，1占用，0未占用
	 * 
	 * 刘朋 2020年2月27日
	 * 
	 * @param cxproductline
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String setStorageStatus(ZoneUnitDTO storageUnitDTO) throws Exception {

		List<ZoneUnit> storageUnitList = null;

		if (!ListUtils.isEmpty(storageUnitDTO.getUpdated())) {
			storageUnitList = storageUnitDTO.getUpdated();
			for (ZoneUnit item : storageUnitList) {
				StorageUnit storageUnit = getFunction().getStorageUnitByName(item.getStorage_unit_name());
				storageUnit.setUDA(item.getLockflag_s(), ZoneUnitUDA.LOCKFLAG);
				storageUnit.setUDA(new Date(), ZoneUnitUDA.OPERATETIME);
				storageUnit.setUDA(item.getInventory_materialcode_s(), ZoneUnitUDA.INVENTORY_MATERIALCODE);
				storageUnit.setUDA(item.getInventory_materialname_s(), ZoneUnitUDA.INVENTORY_MATERIALNAME);
				storageUnit.save();
			}
		}
		return "操作成功";
	}
}
