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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixWorkBySetUp;
import com.bluebirdme.mes.linglong.mix.service.WorkOrderEditServiceImpl;


/**
 * 密炼工单跟踪
 * @author 王超
 * @Date 2020-08-07 09:08:35
 */
@Log(code="密炼工单跟踪",value="密炼工单跟踪")
@RestController
@RequestMapping("mix/planManagement/workOrderEdit")
public class WorkOrderEditController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WorkOrderEditServiceImpl workordereditSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return workordereditSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workordereditSrv;
	}
    
    @Log(code="密炼工单跟踪_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        workordereditSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    //重新下发
    @Log(code = "重新下发工单", value = "重新下发工单")
   	@RequestMapping("downward")
    public Response downward(String[] recipecodelist) throws Exception {
    	return Response.suc(workordereditSrv.downward(recipecodelist));
   	}
    
    @Log(code = "胶料计划", value = "信息列表查询")
	@RequestMapping("datagridjl")
	public String datagridjl(Filter filter, Page page) throws Exception {    	
    	Map map = workordereditSrv.datagridUDAjl(filter, page);
		return toJson(map);
	}
	
    @Log(code = "小料计划", value = "信息列表查询")
	@RequestMapping("datagridxl")
	public String datagridxl(Filter filter, Page page) throws Exception {
    	Map map = workordereditSrv.datagridUDAxl(filter, page);
		return toJson(map);
	}
    
    @Log(value = "主机手查询实时", code = "FUNC_0072", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("setup")
    public String setup(Filter filter, Page page) throws Exception {
	    filter.set("s_factory_s", LLWebUtils.factory());
	    page.setPage(1);
	    page.setRows(200);
	    return GsonTools.toJson(workordereditSrv.setup(filter, page, MixWorkBySetUp.class));
    }
    
    @Log(value = "主机手查询历史", code = "FUNC_0072", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("setup2")
    public String setup2(Filter filter, Page page) throws Exception {
    	return GsonTools.toJson(workordereditSrv.setup2(filter, page, MixWorkBySetUp.class));
    }
    
    @Log(value = "获取数据字典机台", code = "FUNC_015", target = LogType.CONSOLE)
    @RequestMapping("geterpcode")
    public String geterpcode() throws Exception {
        List<Map<String, Object>> list = workordereditSrv.geterpcode();
        return GsonTools.toJson(list);
    }
    
    //设置主机手保存
    @RequestMapping("set")
    public Response set(String[] ids) throws Exception {
      return Response.suc(workordereditSrv.set(ids));
    }
    
    //关闭工单
    @RequestMapping("end")
    public Response end(String[] recipecodelist) throws Exception {
      return Response.suc(workordereditSrv.end(recipecodelist));
    }
    
    //上移
    @RequestMapping("upward")
    public Response upward(String[] recipecodelist) throws Exception {
      return Response.suc(workordereditSrv.upward(recipecodelist));
    }
    
    //下移
    @RequestMapping("down")
    public Response down(String[] recipecodelist) throws Exception {
      return Response.suc(workordereditSrv.down(recipecodelist));
    }
    
    //批报表详细信息
    @Log(value = "批报表详细信息", code = "FUNC_015", target = LogType.CONSOLE)
    @RequestMapping("getbatch")
    public String getbatch(String recipecode) throws Exception {
        List<Map<String, Object>> list = workordereditSrv.getbatch(recipecode);
        return GsonTools.toJson(list);
    }
    
    //校验主机手设置
    @RequestMapping({"check"})
    public Response check(String[] recipecodelist) throws Exception {
      return Response.suc(workordereditSrv.check(recipecodelist));
    }

}
