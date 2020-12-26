/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

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
import com.bluebirdme.mes.linglong.common.uda.ZoneUDA;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Area;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixZonee;
import com.bluebirdme.mes.linglong.mix.entity.dto.MixZoneeDTO;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 库区信息管理 李迺锟 2019年7月30日
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MixZoneeServiceImpl extends BaseServiceImpl<MixZonee> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl serialSrv;// 系统参数获取

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MixZonee.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	String areaName = null;

	/**
	 * 库区的增删改操作 李迺锟 2019年7月30日
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveChanges(MixZoneeDTO storageZoneDTO) throws Exception {
		List<MixZonee> storageZone = null;
		String zoneNameJudgeResult = null;
		if (!ListUtils.isEmpty(storageZoneDTO.getInserted())) {
			storageZone = storageZoneDTO.getInserted();
			for (MixZonee item : storageZone) {
				/*
				 * String category=item.getCategory(); //用于存储产线字段（半部件库区条码）
				 * String materialGroup=item.getMaterialgroup_s();
				 * if(zoneAndMaterialGroupJudge(category,materialGroup)==true){
				 * continue; }
				 */
				// String inventoryBarcode=null;
				// String materialGroup=item.getMaterialgroup_s();
				// String zoneName=category.concat(materialGroup);
				// String
				// zoneName=serialSrv.serial(category,4,1).get(0).toString();
				// item.setStorage_zone_name(zoneName);
//				zoneNameJudgeResult = zoneNameJudge(item.getStorage_zone_name(), item.getS_factory_s(),
//						item.getStorage_type_s());
//				if (zoneNameJudgeResult.equals("success") == false) {
//					return zoneNameJudgeResult;
//				}
				com.datasweep.compatibility.client.StorageZone insertStorageZone = getFunction().createStorageZone(
						item.getStorage_zone_name());
				insertStorageZone.setCategory(item.getCategory());
				insertStorageZone.setDescription(item.getDescription());// 库区描述
				insertStorageZone.setUDA(item.getMaterialgroup_s(), ZoneUDA.MATERIALGROUP); // 库区物料组
				insertStorageZone.setUDA(item.getIs_allow_child_stock_s(), ZoneUDA.IS_ALLOW_CHILD_STOCK); // 是否包含子库
				insertStorageZone.setUDA(item.getRemarks_s(), ZoneUDA.REMARKS); // 备注
				insertStorageZone.setUDA(LLWebUtils.getUser().userCode, ZoneUDA.OPERATER); // 操作人uda
				insertStorageZone.setUDA(item.getStorage_type_s(), ZoneUDA.STORAGE_TYPE); // 库区种类
				insertStorageZone.setUDA(new Date(), ZoneUDA.OPERATETIME); // 操作时间uda
				insertStorageZone.setUDA(LLWebUtils.factory(), ZoneUDA.S_FACTORY);
				insertStorageZone.setUDA(LLConstant.JING_MEN_CODE, ZoneUDA.AGENCNO);
				insertStorageZone.setUDA(Process.Mix, ZoneUDA.PROCESS); // 半部件工序
				// inventoryBarcode=item.getCategory().concat("_").concat(item.getMaterialgroup_s());
				// insertStorageZone.setUDA(inventoryBarcode,StorageZoneUDA.INVENTORY_BARCODE);
				// //库区逻辑条码，同模型表中的storage_zone_name
				// insertStorageZone.setUDA(item.getStorage_zone_name(),StorageZoneUDA.STORAGE_ZONE_BARCODE);
				// //库区条码，同模型表中的category
				insertStorageZone.save();
				/*
				 * 在area中插入库区
				 */
				if (LLWebUtils.factory().equals(Factory.FullSteel)) {
					areaName = Area.FullSteelMixArea;
				} else if (LLWebUtils.factory().equals(Factory.HalfSteel)) {
					areaName = Area.HalfSteelMixArea;
				}
				com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
				area.addStorageZone(insertStorageZone);
				area.save();
				/*
				 * if(item.getS_factory_s().equals(Factory.FullSteel)){
				 * areaName=Area.FullSteelHalfPartArea; }else
				 * if(item.getS_factory_s().equals(Factory.HalfSteel)){
				 * areaName=Area.HalfSteelHalfPartArea; }
				 * com.datasweep.compatibility.client.Area area =
				 * getFunction().getAreaByName(areaName);
				 *//*
					 * area.addStorageZone(insertStorageZone); area.save();
					 */
			}
		}
		if (!ListUtils.isEmpty(storageZoneDTO.getDeleted())) {

			if (!ListUtils.isEmpty(storageZoneDTO.getDeleted())) {
				storageZone = storageZoneDTO.getDeleted();
				for (MixZonee item : storageZone) {
					if (LLWebUtils.factory().equals(Factory.FullSteel)) { // 根据全钢和半钢区分area
						areaName = Area.FullSteelMixArea;
					} else if (LLWebUtils.factory().equals(Factory.HalfSteel)) {
						areaName = Area.HalfSteelMixArea;
					}
				}
			}

			com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaName);
			List<String> errorTips = new ArrayList<>();
			for (MixZonee item : storageZone) {
				com.datasweep.compatibility.client.StorageZone deleteStorageZone = getFunction().getStorageZoneByKey(
						Long.parseLong(item.getStorage_zone_key()));
				area.removeStorageZone(deleteStorageZone); // 删除area中维护的库区
				area.save();
				this.deleteUnitByZoneKey(item.getStorage_zone_key());

			}
		}

		if (!ListUtils.isEmpty(storageZoneDTO.getUpdated())) {
			storageZone = storageZoneDTO.getUpdated();
			String inventoryBarcode = null;
			for (MixZonee item : storageZone) {
				com.datasweep.compatibility.client.StorageZone updateStorageZone = getFunction().getStorageZoneByKey(
						Long.parseLong(item.getStorage_zone_key()));
				if (updateStorageZone == null) {
					continue;
				}
				updateStorageZone.setName(item.getStorage_zone_name());// 修改库区名称
				updateStorageZone.setUDA(item.getStorage_type_s(), ZoneUDA.STORAGE_TYPE);
				updateStorageZone.setCategory(item.getCategory());// 用于存半部件库区条码
				updateStorageZone.setDescription(item.getDescription());// 库区描述
				updateStorageZone.setUDA(item.getMaterialgroup_s(), ZoneUDA.MATERIALGROUP); // 库区物料组
				updateStorageZone.setUDA(item.getIs_allow_child_stock_s(), ZoneUDA.IS_ALLOW_CHILD_STOCK); // 是否包含子库
				updateStorageZone.setUDA(item.getRemarks_s(), ZoneUDA.REMARKS); // 备注
				updateStorageZone.setUDA(LLWebUtils.getUser().userCode, ZoneUDA.OPERATER); // 操作人uda
				updateStorageZone.setUDA(new Date(), ZoneUDA.OPERATETIME); // 操作时间uda
				updateStorageZone.setUDA(item.getS_factory_s(), ZoneUDA.S_FACTORY);
				// inventoryBarcode=item.getCategory().concat("_").concat(item.getMaterialgroup_s());
				// updateStorageZone.setUDA(inventoryBarcode,StorageZoneUDA.INVENTORY_BARCODE);
				// //库区逻辑条码，同模型表中的storage_zone_name
				// updateStorageZone.setUDA(item.getStorage_zone_name(),StorageZoneUDA.STORAGE_ZONE_BARCODE);
				// //库区条码，同模型表中的category
				updateStorageZone.save();
			}
		}
		return "success";
	}

	/**
	 * 判断库区下是否存在库位
	 * 
	 */
	public boolean unitExists(String zonekey) {
		SQLQuery unitExistsListQuery = createSQLQuery(getSQL("getUnitByZoneKey"));
		unitExistsListQuery.setParameter("storage_zone_key", zonekey);
		List<Map<String, Object>> unitExistsList = unitExistsListQuery.list();
		if (unitExistsList.isEmpty() == true) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * 返回库区信息 李迺锟 2019/04/18
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MixZonee> getZone() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getZone"), MixZonee.class);
		if (LLWebUtils.factory().equals(Factory.FullSteel)) { // 根据全钢和半钢区分area
			areaName = Area.FullSteelMixArea;
			query.setParameter("area_name", areaName);
		} else if (LLWebUtils.factory().equals(Factory.HalfSteel)) {
			areaName = Area.HalfSteelMixArea;
			query.setParameter("area_name", areaName);
		}
		List<MixZonee> test = query.list();
		return query.list();
	}

	/**
	 * 删除某库区下的所有库位 李迺锟 2019年4月17日
	 * 
	 * @param zonekey
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void deleteUnitByZoneKey(String zonekey) throws Exception {
		com.datasweep.compatibility.client.StorageZone deletestoragezone = getFunction().getStorageZoneByKey(
				Long.parseLong(zonekey));
		deletestoragezone.delete(getDBTime(), "删除库区");
		List<Map<String, Object>> unitIDList = createSQLQuery(getSQL("getUnitByZoneKey")).setParameter(
				"storage_zone_key", zonekey).list();
		if (unitIDList.size() == 0) {
			return;
		}
		for (Map<String, Object> map : unitIDList) {

			String testString = map.toString();
			if (testString.contains("null")) {
				continue;
			}

			Long unitID = Long.parseLong(map.get("CHILD_KEY").toString());
			com.datasweep.compatibility.client.StorageUnit storageUnit = getFunction().getStorageUnitByKey(unitID);
			storageUnit.delete(getDBTime(), LLWebUtils.getUser().userCode + "删除库位");
		}

	}

	/**
	 * 为查询栏添加查询方法 2019-05-23 李迺锟
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchZoneByCategoryAndZoneName(String category, String description)
			throws Exception {
		Filter filter = new Filter();
		if (category != null && category != "") {
			filter.set("category", category);
		}
		if (description != null && description != "") {
			filter.set("description", description);
		}
		System.out.println(getSQL("searchZoneByCategoryAndZoneName", filter));
		SQLQuery query = createSQLQuery(getSQL("searchZoneByCategoryAndZoneName", filter));
		if (category != null && category != "") {
			query.setParameter("category", category);
		}
		if (description != null && description != "") {
			query.setParameter("description", description);
		}
		if (LLWebUtils.factory().equals(Factory.FullSteel)) {
			query.setParameter("area_name", Area.FullSteelMixArea);
		} else {
			query.setParameter("area_name", Area.HalfSteelMixArea);
		}
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}

	public List<String> searchZoneName() throws Exception {

		SQLQuery searchZoneName = createSQLQuery(getSQL("searchZoneName"));
		if (LLWebUtils.factory().equals(Factory.FullSteel)) {
			searchZoneName.setParameter("area_name", Area.FullSteelMixArea);
		} else {
			searchZoneName.setParameter("area_name", Area.HalfSteelMixArea);
		}
		return searchZoneName.list();
	}

	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在 李迺锟 2019年5月25日
	 */
	public boolean zoneAndMaterialGroupJudge(String zoneName, String materialGroup) {
		SQLQuery zoneAndMaterialGroupJudge = createSQLQuery(getSQL("zoneAndMaterialGroupJudge"));
		zoneAndMaterialGroupJudge.setParameter("zoneName", zoneName);
		zoneAndMaterialGroupJudge.setParameter("materialGroup", materialGroup);
		if (zoneAndMaterialGroupJudge.list().size() == 0 || zoneAndMaterialGroupJudge.list().isEmpty() == true) {
			return false;
		}
		return true;
	}

	/**
	 * 库区编码规则校验 李迺锟 2019年6月21日
	 */
	public String zoneNameJudge(String zoneName, String factory, String stronge) {
		String areaName = null;
		factory = LLWebUtils.factory();
		if (zoneName.length() != 7) {
			if (factory.equals("1")) {
				return "库区条码必须是7位，例：模具库区FKCM001、胶囊库区FKCJ001";
			} else {
				return "库区条码必须是7位，例：模具库区HKCM001、胶囊库区HKCJ001";
			}
		}
		String unitPreIndex = zoneName.substring(0, 4);
		SQLQuery uniqueZoneNameJudge = createSQLQuery(getSQL("uniqueZoneNameJudge"));
		if (factory.equals(Factory.FullSteel)) {
			if (stronge.equals("227001")) {
				if (unitPreIndex.equals("FKCM")) {
					// areaName=Area.FullSteelHalfPartArea;
					// uniqueZoneNameJudge.setParameter("area_name",areaName);
					uniqueZoneNameJudge.setParameter("zoneName", zoneName);
					if (uniqueZoneNameJudge.list().isEmpty()) {
						return "success";
					} else {
						return "模具库编码规则：FKCM001";
					}
				}
			} else {
				if (unitPreIndex.equals("FKCJ")) {
					// areaName=Area.FullSteelHalfPartArea;
					// uniqueZoneNameJudge.setParameter("area_name",areaName);
					uniqueZoneNameJudge.setParameter("zoneName", zoneName);
					if (uniqueZoneNameJudge.list().isEmpty()) {
						return "success";
					} else {
						
						return "胶囊库编码规则：FKCJ001";
					}
				}
			}
			return "库区编码已被使用";
		}
		if (factory.equals(Factory.HalfSteel)) {
			if (stronge.equals("227001")) {
				if (unitPreIndex.equals("HKCM")) {
					// areaName=Area.FullSteelHalfPartArea;
					// uniqueZoneNameJudge.setParameter("area_name",areaName);
					uniqueZoneNameJudge.setParameter("zoneName", zoneName);
					if (uniqueZoneNameJudge.list().isEmpty()) {
						return "success";
					} else {
						return "模具库编码规则：HKCM001";
					}
				}
			} else {
				if (unitPreIndex.equals("HKCJ")) {
					// areaName=Area.FullSteelHalfPartArea;
					// uniqueZoneNameJudge.setParameter("area_name",areaName);
					uniqueZoneNameJudge.setParameter("zoneName", zoneName);
					if (uniqueZoneNameJudge.list().isEmpty()) {
						return "success";
					} else {
						
						return "胶囊库编码规则：HKCJ001";
					}
				}
			}
			return "库区编码已被使用";
		}

		return "success";
	}

	/**
	 * 删除库区时校验该产线及物料组相关的当前日期及以后的日计划是否存在 李迺锟 2019年6月12日
	 */
	public boolean productPlanExistJudge(String zoneCode, String materialGroupCode) {
		SQLQuery query = createSQLQuery(getSQL("productPlanExistJudge"));
		query.setParameter("zoneCode", zoneCode);
		query.setParameter("materialGroupCode", materialGroupCode);
		if (query.list().size() == 0 || query.list().isEmpty() == true) {
			return true;
		}
		return false;
	}
}
