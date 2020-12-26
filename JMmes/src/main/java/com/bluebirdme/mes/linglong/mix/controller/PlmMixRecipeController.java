/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import javax.annotation.Resource;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.PlmMixRecipeServiceImpl;


/**
 * PLM密炼配方集成表
 * @author 栾和源
 * @Date 2020-08-08 14:03:08
 */
@Log(code="PLM密炼配方集成",value="PLM密炼配方集成")
@RestController
@RequestMapping("mix/qualityManagement/plmmixrecipe")
public class PlmMixRecipeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixRecipeServiceImpl plmmixrecipeSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixrecipeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixrecipeSrv;
	}
    /**
     * 审核
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "审核", code = "FUNC_009", target = LogType.DB)
    @RequestMapping({"audit"})
    public Response audit(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeSrv.audit(recipecodelist, "1"));
    }
    /**
     * 撤销审核
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "撤销审核", code = "FUNC_010", target = LogType.DB)
    @RequestMapping({"cancelaudit"})
    public Response cancelaudit(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeSrv.audit(recipecodelist, "0"));
    }
    
    /**
     * 密炼配方下发
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "密炼配方下发", code = "FUNC_011", target = LogType.DB)
    @RequestMapping({"downward"})
    public Response downward(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeSrv.downward(recipecodelist));
    }
    
    /**
     * 密炼配方重新下发
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "密炼配方重新下发", code = "FUNC_011", target = LogType.DB)
    @RequestMapping({"reissue"})
    public Response reissue(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeSrv.reissue(recipecodelist));
    }
    
    /**
     * 待用
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    @Log(value = "待用", code = "FUNC_009", target = LogType.DB)
    @RequestMapping({"startrecipe"})
    public Response startrecipe(String[] recipecodelist) throws Exception {
    	return Response.suc(this.plmmixrecipeSrv.startstoprecipe(recipecodelist, "323001"));
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
    	return Response.suc(this.plmmixrecipeSrv.startstoprecipe(recipecodelist, "323003"));
    }

}
