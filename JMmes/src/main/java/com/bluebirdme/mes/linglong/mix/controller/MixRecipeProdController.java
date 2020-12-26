/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

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
import com.bluebirdme.mes.linglong.mix.service.MixRecipeProdServiceImpl;


/**
 * 密炼小料产出实绩表
 * @author 陈国强
 * @Date 2020-09-14 08:37:19
 */
@Log(code="MixRecipeProd_Log",value="密炼小料车产出实绩_日志")
@RestController
@RequestMapping("mix/productionManagement/mixrecipeprod")
public class MixRecipeProdController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixRecipeProdServiceImpl mixrecipeprodSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixrecipeprodSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixrecipeprodSrv;
	}
    
    @Log(code="MixRecipeProd_Log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixrecipeprodSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception { 
    	filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(getUDAService().datagridUDA(filter, page)); }


}
