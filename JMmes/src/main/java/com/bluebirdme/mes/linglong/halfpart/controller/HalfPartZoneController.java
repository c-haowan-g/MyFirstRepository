/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartZone;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartZoneDTO;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartZoneServiceImpl;

/**
 * 半部件库区库位信息管理
 * @author 李新宇
 * @Date 2020-03-04 13:41:24
 */
@Log(code="storagezoneunit",value="storagezoneunit")
@RestController
@RequestMapping("halfpart/basedata/storagezonemanager")
public class HalfPartZoneController extends FunctionalController<HalfPartZone> {
    
    @Resource HalfPartZoneServiceImpl szoneSrv;
	@Override
	protected BaseServiceImpl<HalfPartZone> getService() {
		return szoneSrv;
	}
	
    @Log(code="StorageZone_Save",value="保存库区数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody HalfPartZoneDTO storageZone ) throws Exception {
        return Response.suc(szoneSrv.saveChanges(storageZone));
    }
    
	/**
	 * 获取库区信息
	 * 李新宇
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("zone")
	public String zone() throws Exception{
		List<HalfPartZone> test=szoneSrv.getZone();
		return toJson(szoneSrv.getZone());
	}
	/**
	 * 为查询栏添加查询方法
	 * 李新宇
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("searchZoneByCategoryAndZoneName")
   	public String searchZoneByType(String category,String description) throws Exception {
        return toJson(szoneSrv.searchZoneByCategoryAndZoneName(category,description));
   	}	
	/**
	 * 获得库区名称：storageZoneName
	 * 李新宇
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchZoneName")
   	public String searchZoneName() throws Exception {
        return toJson(szoneSrv.searchZoneName());
   	}	
	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在
	 * 李新宇
	 * 2019年5月25日
	 */
	@RequestMapping("zoneAndMaterialGroupJudge")
	public String zoneAndMaterialGroupJudge(String zoneName,String materialGroup)throws Exception{
		boolean result=szoneSrv.zoneAndMaterialGroupJudge(zoneName,materialGroup);
		return toJson(result);
	}
	/**
	 * 删除库区时校验该产线及物料组相关的当前日期及以后的日计划是否存在
	 * 李新宇
	 * 2019年6月12日
	 */
	@RequestMapping("productPlanExistJudge")
	public String productPlanExistJudge(String zoneCode,String materialGroupCode)throws Exception{
		boolean result=szoneSrv.productPlanExistJudge(zoneCode,materialGroupCode);
		return toJson(result);
	}


}
