/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItemAll;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItemRAll;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeItemDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.RecipeItemServiceImpl;

/**
 * 质检配方规格表
 * 
 * @author 司乔靖
 * @Date 2018-08-08 14:16:57
 */
@Log(code = "ZJ_BZGL_PFGG", value = "质检配方规格表日志")
@RestController
@RequestMapping("finalcheck/baseData/recipeItem")
public class RecipeItemController extends RockWellFunctionalController<RecipeItem> {

	@Resource
	RecipeItemServiceImpl recipeitemSrv;

	@Override
	protected RockWellBaseServiceImpl<RecipeItem> getService() {
		return recipeitemSrv;
	}

	@Log(code = "ZJ_BZGL_PFGG_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RecipeItemDTO recipeitem) throws Exception {
		recipeitemSrv.saveChanges(recipeitem);
		return Response.suc();
	}

	@Log(code = "ZJ_BZGL_PFGG_SAVE_CHANGES2", value = "保存数据的移动", target = LogType.DB)
	@RequestMapping("saveChanges2")
	public Response saveChanges2(@RequestBody RecipeItemDTO recipeitem) throws Exception {
		return Response.suc(recipeitemSrv.saveChanges2(recipeitem));
	}

	@Override
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, RecipeItemAll.class));
	}

	@Log(value = "信息列表查询2", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid2")
	public String datagrid2(String entType, String recipeno_s, Filter filter, Page page) throws Exception {
		String factoryString = LLWebUtils.factory();
		String factoryCodeString = FactoryConstant.JING_MEN_CODE;
		filter.set("enttype_i", entType);
		filter.set("recipeno_s", recipeno_s);
		filter.set("s_factory_s", factoryString);
		filter.set("agenc_no_s", factoryCodeString);

		System.out.println(recipeitemSrv.datagrid2(filter, page, RecipeItemAll.class));
		return GsonTools.toJson(recipeitemSrv.datagrid2(filter, page, RecipeItemAll.class));
	}

	@Log(value = "信息列表查询3", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid3")
	public String datagrid3(Filter filter, Page page, String filterRules) throws Exception {
		String entCode=filter.get("entbarcode_s").toString();
		String entType=null;
		if (entCode.indexOf("FDPH") > -1) {
			entType="254004";
		}
		else if (entCode.indexOf("FLM") > -1) {
			entType="254004";
		}
		else if (entCode.indexOf("FJYX") > -1) {
			entType="254005";
		}
		//外观前使用动平衡的配方
		else if (entCode.indexOf("FWG") > -1) {
			entType="254004";
		}
		//X光前使用动平衡的配方
		else if (entCode.indexOf("FXG") > -1) {
			entType="254004";
		}
		else if (entCode.indexOf("FGM") > -1) {
			entType="254001";
		}
		else{
			entType="";
		}
		String factoryString = LLWebUtils.factory();
		String factoryCodeString = FactoryConstant.JING_MEN_CODE;
		filter.set("s_factory_s", factoryString);
		filter.set("agenc_no_s", factoryCodeString);
		filter.set("entType", entType);
		if(entCode.indexOf("FWG") > -1||entCode.indexOf("FXG") > -1){
			return GsonTools.toJson(recipeitemSrv.datagrid4(filterRules, filter, page, RecipeItemRAll.class));
		}
		return GsonTools.toJson(recipeitemSrv.datagrid3(filterRules, filter, page, RecipeItemRAll.class));
	}
}
