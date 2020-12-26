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
import com.bluebirdme.mes.linglong.material.service.RawMaterialInventoryStateServiceImpl;


/**
 * 原材料库存状态
 * @author 李昂
 * @Date 2020-08-18 10:09:24
 */
@Log(code="AT_RM_WH_ITEM_INV",value="原材料库存状态")
@RestController
@RequestMapping("material/digitalSignage/RawMaterialInventoryState")
public class RawMaterialInventoryStateController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RawMaterialInventoryStateServiceImpl rawmaterialinventorystateSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return rawmaterialinventorystateSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return rawmaterialinventorystateSrv;
	}
    
    @Log(code="AT_RM_WH_ITEM_INV_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        rawmaterialinventorystateSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
      page.setPage(1);
      page.setRows(1000);
      return GsonTools.toJson(getService().datagrid(filter, page, RawMaterialInventoryState.class));
    }

}
