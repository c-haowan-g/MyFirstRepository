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
import com.bluebirdme.mes.linglong.material.entity.RawMaterialInventoryState;
import com.bluebirdme.mes.linglong.material.entity.RawMaterialWarning;
import com.bluebirdme.mes.linglong.material.service.RawMaterialWarningServiceImpl;


/**
 * 原材料库存操作履历表
 * @author 李德晓
 * @Date 2020-08-28 10:39:14
 */
@Log(code="原材料库存操作履历表",value="原材料库存操作履历表")
@RestController
@RequestMapping("material/digitalSignage/rawmaterialwarning")
public class RawMaterialWarningController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RawMaterialWarningServiceImpl rawmaterialwarningSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return rawmaterialwarningSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return rawmaterialwarningSrv;
	}
    
    @Log(code="原材料库存操作履历表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        rawmaterialwarningSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
      page.setPage(1);
      page.setRows(1000);
      //return GsonTools.toJson(getService().datagrid(filter, page, RawMaterialWarning.class));
      return GsonTools.toJson(rawmaterialwarningSrv.datagridUDA(filter, page));
    }

}
