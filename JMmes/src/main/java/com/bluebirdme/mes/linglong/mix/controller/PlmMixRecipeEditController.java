/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.PlmMixRecipeEditServiceImpl;


/**
 * PLM密炼配方维护表
 * @author 栾和源
 * @Date 2020-08-11 16:43:15
 */
@Log(code="PLM密炼配方管理",value="PLM密炼配方管理")
@RestController
@RequestMapping("mix/qualityManagement/plmmixrecipeedit")
public class PlmMixRecipeEditController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixRecipeEditServiceImpl plmmixrecipeeditSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixrecipeeditSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixrecipeeditSrv;
	}
    
    /**
     * 获取密炼称量调整范围设定信息
     * @author heyuan_luan
     * @return
     * @throws Exception
     */
    @RequestMapping({"getmixrecipeweightrange"})
    public String getmixrecipeweightrange() throws Exception {
      List<Map<String, Object>> list = this.plmmixrecipeeditSrv.getmixrecipeweightrange();
      return GsonTools.toJson(list);
    }
    
    /**
     * 获取物料组
     * @author heyuan_luan
     * @return
     * @throws Exception
     */
    @RequestMapping({"getmaterialgroup"})
    public String getmaterialgroup() throws Exception {
      List<Map<String, Object>> list = this.plmmixrecipeeditSrv.getmaterialgroup();
      return GsonTools.toJson(list);
    }
    
    /**
     * 启用
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "启用", code = "FUNC_009", target = LogType.DB)
    @RequestMapping({"startrecipe"})
    public Response startrecipe(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeeditSrv.startstoprecipe(recipecodelist, "323001"));
    }
    
    /**
     * 停用
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "停用", code = "FUNC_010", target = LogType.DB)
    @RequestMapping({"stoprecipe"})
    public Response stoprecipe(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeeditSrv.startstoprecipe(recipecodelist, "323003"));
    }

}
