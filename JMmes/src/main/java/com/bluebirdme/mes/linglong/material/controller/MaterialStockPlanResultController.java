/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

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
import com.bluebirdme.mes.linglong.material.service.MaterialStockPlanResultServiceImpl;


/**
 * 盘库结果管理
 * @author 李德晓
 * @Date 2020-08-10 13:18:12
 */
@Log(code="盘库结果管理",value="盘库结果管理")
@RestController
@RequestMapping("material/stockMangement/materialstockplanpesult")
public class MaterialStockPlanResultController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialStockPlanResultServiceImpl materialstockplanresultSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialstockplanresultSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialstockplanresultSrv;
	}
    @Override
    @Log(value = "信息列表查询", code = "信息列表查询", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    @Log(code="盘库结果管理_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        materialstockplanresultSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    /*@RequestMapping({"lock"})
    public Response lock(Long[] ids) throws Exception {
      return Response.suc(this.materialstockplanresultSrv.lock(ids));
    }
    
    @RequestMapping({"onsave"})
    public Response onsave(Long[] ids) throws Exception {
      return Response.suc(this.materialstockplanresultSrv.onsave(ids));
    }
  }*/

}
