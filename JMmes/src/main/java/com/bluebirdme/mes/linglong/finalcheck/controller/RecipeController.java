/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
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
import com.bluebirdme.mes.linglong.finalcheck.entity.Recipe;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.RecipeServiceImpl;

/**
 * 配方标准维护
 * @author 司乔靖
 * @Date 2018-08-01 10:00:25
 */
@Log(code="ZJ_BZGL_PFBZ",value="配方标准维护日志")
@RestController
@RequestMapping("finalcheck/standarManagement/recipe")
public class RecipeController extends RockWellFunctionalController<Recipe> {
    
    @Resource RecipeServiceImpl recipeSrv;

    @Override
    protected RockWellBaseServiceImpl<Recipe> getService() {
        return recipeSrv;
    }
    
    @Log(code="ZJ_BZGL_PFBZ_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RecipeDTO recipe ) throws Exception{
        return Response.suc(recipeSrv.saveChanges(recipe));
    }
    /**
     * 根据配方号，获取AT_D_BS_Recipe表ID
     * @param recipe
     * @return
     * @throws Exception
     */
    @Log(code="ZJ_RECIPE",value="获取Recipe表ID")
    @RequestMapping("getRecipeID")
    public String getRecipeID(@RequestBody Recipe recipe)  throws Exception
    {
    	return toJson(recipeSrv.getRecipeID(recipe));
    }
    /**
     * 获取页面第二个tab页的下拉框
     * @return
     * @throws Exception
     */
    @Log(code="comboxRecipeno",value="查询配方号")
    @RequestMapping("comboxRecipeno")
   	public String comboxRecipeno() throws Exception{
    	List<Map<String,Object>> list=recipeSrv.getRecipeno();
   		return toJson(list);
   	}
    

	@Override
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter,Page page) throws Exception {
		page.setRows(1000);
		return GsonTools.toJson(getService().datagrid(filter,page,Recipe.class));
	}
	/**
	 * 
	 * @param recipeno
	 * @param judgeID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveJudgeIDToRecipe")
	public Response saveJudgeIDToRecipe( String recipeno,String judgeID) throws Exception {
		
		if(recipeSrv.saveJudgeIDToRecipe(recipeno,judgeID)){
			return Response.suc();
		}
		return Response.error(Response.SYS_EXCEPTION, "", null);
	}
	
	@Log(code="ZZJ_BZGL_PFBZ_COMBOX_PFCODE",value="获取配方")
	@RequestMapping("combox_entcode")
   	public String combox_entcode() throws Exception{
    	List<Map<String,Object>> list=recipeSrv.getPFCodeName();
   		return toJson(list);
   	}
	@Log(code = "AT_D_BS_Recipe", value = "根据设备类型、配方号查询规格", target = LogType.CONSOLE)
	@RequestMapping("getRecipeItems")
	public String getRecipeItems(String entType, String recipeNumber) throws Exception {
		List<Map<String, Object>> list = recipeSrv.getRecipeItems(entType, recipeNumber);
		return toJson(list);
	}
	
}
