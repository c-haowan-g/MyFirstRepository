/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.Materials;
import com.bluebirdme.mes.linglong.sap.entity.dto.MaterialsDTO;
import com.bluebirdme.mes.linglong.sap.service.MaterialsServiceImpl;

/**
 * SAP物料基础数据
 * 
 * @author 李彦
 * @Date 2018-08-09 11:50:47
 */
@Log(code = "SAP_MATERIALS", value = "SAP物料基础数据日志")
@RestController
@RequestMapping("/sap/materials")
public class MaterialsController extends RockWellFunctionalController<Materials> {

	@Resource
	MaterialsServiceImpl materialsSrv;

	@Override
	protected RockWellBaseServiceImpl<Materials> getService() {
		return materialsSrv;
	}

	@Log(code = "SAP_MATERIALS_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody MaterialsDTO materials) throws Exception {
		materialsSrv.saveChanges(materials);
		return Response.suc();
	}

	// 获取物料代码，动态搜索物料编码
	@RequestMapping("list")
	public String GetMaterialByMaerialCode(String code,String q) throws Exception {
		if(!StringUtils.isBlank(q)){
			code=q;
		}
		Filter filter = new Filter();
		if (!StringUtils.isBlank(code)) {
			filter.set("materialcode_s", "contains:" + code);
		}
		filter.set("mattyp_s", "FERT");
		if (LLWebUtils.factory().equals(LLConstant.QUAN_GANG)) {
			filter.set("matgrp_s", "beginWith:21");
		} else {
			filter.set("matgrp_s", "beginWith:22");
		}
		Page page = new Page();
		return toJson(materialsSrv.datagrid(filter, page, null).get("rows"));
	}


	@Log(code = "datagrid_material", value = "查询物料-分拣规则维护使用")
	@ResponseBody
	@RequestMapping("datagrid_material")
	public String datagrid_material(Filter filter, Page page, String filterRules) throws Exception {
		String factoryString = LLWebUtils.factory();
		String ageno_sString = FactoryConstant.JING_MEN_CODE;
		if (factoryString.equals("1")) {
			filter.set("factory1", "in:211001,211003");
		}
		if (factoryString.equals("2")) {
			filter.set("factory2", "in:221001,221002");
		}
		return GsonTools.toJson(materialsSrv.datagrid2(filterRules, filter, page, Materials.class));
	}

	@Log(code = "datagrid_material_all", value = "查询物料类型FERT")
	@ResponseBody
	@RequestMapping("datagrid_material_all")
	public String datagrid_materialall() throws Exception {
		return GsonTools.toJson(materialsSrv.datagrid3());
	}

	@Log(code = "datagrid_material_factory", value = "根据全钢半钢查询物料类型FERT")
	@ResponseBody
	@RequestMapping("datagrid_material_factory")
	public String datagridmaterialfactory() throws Exception {
		return GsonTools.toJson(materialsSrv.datagrid4());
	}

	/**
	 * 查询未进行翻转的物料信息
	 * 
	 * @Title: dynabalancereversallist
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception
	 * @return: String
	 * @throws
	 * */
	@RequestMapping("dynabalancereversallist")
	public String dynabalancereversallist(String q) throws Exception {
		String factory = LLWebUtils.factory();
		List<Materials> list = materialsSrv.getMaterialsByDynabalancereversal(factory, q);
		return GsonTools.toJson(list);
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 *             周清玉
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page, Class clazz) throws Exception {
		Map list = materialsSrv.datagrid(filter, page, clazz);
		return toJson(list);
	}

	/**
	 * 根据物料编码得到物料信息
	 * 
	 * @param materialCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchByMaterialCode")
	public String searchByMaterialCode(String materialCode) throws Exception {
		List<Map<String, Object>> list = materialsSrv.searchByMaterialCode(materialCode);
		return toJson(list);
	}

	/**
	 * 
	 * 胎胚物料信息 刘程明 2019年3月11日
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("halbMaterialList")
	public String halbMaterialList() throws Exception {
		List<Map<String, Object>> list = materialsSrv.halbMaterialList();
		return toJson(list);
	}
	
	/**
	 * 
	 * 母胶混炼胶物料信息 刘程明 2019年3月11日
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("mixMaterialList")
	public String mixMaterialList() throws Exception {
		List<Map<String, Object>> list = materialsSrv.mixMaterialList();
		return toJson(list);
	}
	
	/**
	 * 半部件
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 * sap/materials/getMaterialGroupList
	 */
	@RequestMapping("getMaterialGroupList")
	public String getMaterialGroupList()throws Exception {
		List<Map<String, Object>> getMaterialGrouplist = materialsSrv.getMaterialGroupList();
		return toJson(getMaterialGrouplist);
	}
	
	/**
	 * 半部件
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 * sap/materials/getMaterialGroupList
	 */
	@RequestMapping("getAllMaterialGroupList")
	public String getAllMaterialGroupList()throws Exception {
		List<Map<String, Object>> getAllMaterialGroupList = materialsSrv.getAllMaterialGroupList();
		return toJson(getAllMaterialGroupList);
	}
	/**
	 * 半部件
	 * 根据物料组（dictcode）获取存放规格（外部编码/erpcode
	 * 兰颖慧
	 * 2019年4月17日
	 * sap/materials/getErpcodebyMaterialGroupList
	 * @return
	 */
	@RequestMapping("getErpcodebyMaterialGroupList")
	public String getErpcodebyMaterialGroupList(String dictcode)throws Exception{
		List<Map<String, Object>> getErpCodelist = materialsSrv.getErpcodebyMaterialGroupList(dictcode);
		return toJson(getErpCodelist);
	}
	/**
	 * 半部件
	 * 获取半部件用所有物料信息
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 * sap/materials/getMaterialList
	 */
	@RequestMapping("getMaterialList")
	public String getMaterialList()throws Exception{
		List<Map<String, Object>> getMaterialList = materialsSrv.getMaterialList();
		return toJson(getMaterialList);
	}
	/**
	 * 半部件
	 * 根据存物料组获取物料信息
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 * sap/materials/getMaterialByMaterialGroupList
	 */
	
	@RequestMapping("getMaterialByMaterialGroupList")
	public String getMaterialByMaterialGroupList(String materialGroup)throws Exception{
		List<Map<String, Object>> getMaterialGroList = materialsSrv.getMaterialByMaterialGroupList(materialGroup);
		return toJson(getMaterialGroList);
	}
	/**
	 * 半部件
	 * 根据存放规格（外部编码/erpcode）获取物料信息-半部件用
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 * sap/materials/getMaterialbyErpcodeList
	 */
	
	@RequestMapping("getMaterialbyErpcodeList")
	public String getMaterialbyErpcodeList(String erpcpde)throws Exception{
		List<Map<String, Object>> getMaterialInfoList = materialsSrv.getMaterialbyErpcodeList(erpcpde);
		return toJson(getMaterialInfoList);
	}
	
	
	/**
	 * 根据物料编码获取物料名称
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	@RequestMapping("getMaterialNameByMaterialCode")
	public String getMaterialNameByMaterialCode(String materialCode)throws Exception{
		List<Map<String, Object>> getMaterialNameByMaterialCodeList = materialsSrv.getMaterialNameByMaterialCode(materialCode);
		return toJson(getMaterialNameByMaterialCodeList);
	}
}


