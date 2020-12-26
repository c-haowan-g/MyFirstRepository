/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.MaterialsPlusServiceImpl;

/**
 * 物料信息扩展表
 * 
 * @author 周清玉ds
 * @Date 2018-11-15 16:51:18
 */
@Log(code = "MaterialsPlus", value = "物料信息扩展")
@RestController
@RequestMapping("sap/materialsPlus")
public class MaterialsPlusController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MaterialsPlusServiceImpl materialsplusSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return materialsplusSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialsplusSrv;
	}
	
	
	@Log(code = "MaterialsPlus_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		materialsplusSrv.saveChanges(rockWellEntityDTO);
		return Response.suc();
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page) throws Exception {
		Map list = materialsplusSrv.datagridz(filter, page);
		return toJson(list);
	}

	/**
	 * 维护物料失效时间页面查询使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchManageMaterialOutdate")
	public String searchManageMaterialOutdate(Filter filter, Page page) throws Exception {
		Map list = materialsplusSrv.datagridTime(filter, page);
		return toJson(list);
	}
	
	
	/**
	 * 半部件
	 * 获取半部件模块用的物料组
	 * 李迺锟
	 * 2019年8月27日
	 * @return
	 * sap/materials/getMaterialGroupList
	 */
	@RequestMapping("getMaterialGroupList")
	public String getMaterialGroupList()throws Exception {
		List<Map<String, Object>> getMaterialGrouplist = materialsplusSrv.getMaterialGroupList();
		return toJson(getMaterialGrouplist);
	}
	
	/**
	 * 根据物料大类，更新该物料大类下所有物料的时效性 刘程明 2019年2月28日
	 * 
	 * @param materialType
	 * @param smallTime
	 * @param maxTime
	 * @return
	 */
	@RequestMapping("updateByMaterialType")
	public Response updateByMaterialType(String materialType, String smallTime, String maxTime) {
		if (materialsplusSrv.updateByMaterialType(materialType, smallTime, maxTime)) {
			return Response.suc();
		}
		return Response.error(Response.SYS_EXCEPTION, "操作失败", null);
	}

	
}
