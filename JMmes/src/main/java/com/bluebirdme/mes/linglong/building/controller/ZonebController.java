/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;
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
import com.bluebirdme.mes.linglong.building.entity.Zoneb;
import com.bluebirdme.mes.linglong.building.entity.dto.ZonebDTO;
import com.bluebirdme.mes.linglong.building.service.ZonebServiceImpl;



/**
 * 库区信息管理
 * @author 李迺锟
 * @Date 2019-04-17 10:02:27
 */
@Log(code="StorageZone",value="库区操作操作日志")
@RestController
@RequestMapping("building/basedata/storagezonemanager")
public class ZonebController extends FunctionalController<Zoneb> {
    
    @Resource ZonebServiceImpl szoneSrv;
	@Override
	protected BaseServiceImpl<Zoneb> getService() {
		return szoneSrv;
	}
	
    @Log(code="StorageZone_Save",value="保存库区数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ZonebDTO storageZone ) throws Exception {
        return Response.suc(szoneSrv.saveChanges(storageZone));
    }
    
	/**
	 * 获取库区信息
	 * 李迺锟
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("zone")
	public String zone() throws Exception{
		return null;
	}
	/**
	 * 为查询栏添加查询方法
	 * 李迺锟
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("searchZoneByCategoryAndZoneName")
   	public String searchZoneByType(String category,String description) throws Exception {
        return toJson(szoneSrv.searchZoneByCategoryAndZoneName(category,description));
   	}	
	/**
	 * 获得库区名称：storageZoneName
	 * 李迺锟
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchZoneName")
   	public String searchZoneName() throws Exception {
        return toJson(szoneSrv.searchZoneName());
   	}	
	/**
	 * 选择物料组时根据当前机台条码校验当前机台对应的物料组是否已存在
	 * 李迺锟
	 * 2019年5月25日
	 */
	@RequestMapping("zoneAndMaterialGroupJudge")
	public String zoneAndMaterialGroupJudge(String zoneName,String materialGroup)throws Exception{
		boolean result=szoneSrv.zoneAndMaterialGroupJudge(zoneName,materialGroup);
		return toJson(result);
	}
	/**
	 * 删除库区时校验该产线及物料组相关的当前日期及以后的日计划是否存在
	 * 李迺锟
	 * 2019年6月12日
	 */
	@RequestMapping("productPlanExistJudge")
	public String productPlanExistJudge(String zoneCode,String materialGroupCode)throws Exception{
		boolean result=szoneSrv.productPlanExistJudge(zoneCode,materialGroupCode);
		return toJson(result);
	}
	
	
}
