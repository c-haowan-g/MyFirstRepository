/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.entity.dto.ZoneUnitDTO;
import com.bluebirdme.mes.linglong.curing.entity.ZoneeUnit;
import com.bluebirdme.mes.linglong.curing.service.ZoneeUnitServiceImpl;

/**
 * 
 * @author naikun_li
 * 
 */

@Log(code = "SUnit", value = "硫化库位操作日志")
@RestController
@RequestMapping("curing/basedata/storageunitmanager")
public class ZoneeUnitController extends FunctionalController<ZoneeUnit> {

	@Resource
	ZoneeUnitServiceImpl stoUnitSrv;

	@Override
	protected ZoneeUnitServiceImpl getService() {
		return stoUnitSrv;
	}

	@Log(code = "StorageUnit_Save", value = "保存库区数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody ZoneUnitDTO storageUnitDTO) throws Exception {
		return Response.suc(stoUnitSrv.saveChanges(storageUnitDTO));
	}

	/**
	 * 获取库位信息 李迺锟 2019年4月17日
	 * 
	 * @param plinekey
	 *            库区ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("unit")
	public String unit(String zonekey, String materialGroup) throws Exception {
		return toJson(stoUnitSrv.getUnit(zonekey, materialGroup));
	}

	/**
	 * 初始化数据使用，不对外使用 李迺锟 2019年4月17日
	 * 
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping("initializateStorageUnits") public void
	 * initializateStorageUnits() throws Exception{ String areaName="80232B";
	 * String storageZoneName= "StorageZoneBGIn"; String storageUnitType=
	 * "161001"; String unitDescription= null;
	 * stoUnitSrv.initializateStorageUnits
	 * (areaName,storageZoneName,storageUnitType,unitDescription); }
	 */

	/**
	 * 根据库区key获得物料组 李迺锟 2019年4月17日
	 */
	@RequestMapping("searchMaterialGroupByZoneKey")
	public String searchMaterialGroupByZoneKey(String zonekey) throws Exception {
		return toJson(stoUnitSrv.searchMaterialGroupByZoneKey(zonekey));
	}

	/**
	 * 前台获取category生成库位名称 李迺锟 2019年4月17日
	 */
	@RequestMapping("createUnitName")
	public String createUnitName(String materialGroup, String category) throws Exception {
		String unitCode = stoUnitSrv.createUnitName(materialGroup, category);
		return toJson(unitCode);
	}

	/**
	 * 修改模具库位占用状态lockflag_s： 1占用，0未占用
	 * 
	 * 刘朋 2020/2/27
	 */
	@RequestMapping("setStorageStatus")
	public Response setStorageStatus(@RequestBody ZoneUnitDTO storageUnitDTO) throws Exception {
		return Response.suc(stoUnitSrv.setStorageStatus(storageUnitDTO));
	}

}
