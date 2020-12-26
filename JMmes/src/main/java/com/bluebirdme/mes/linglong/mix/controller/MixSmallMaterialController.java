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
import com.bluebirdme.mes.linglong.mix.entity.MixSmallMaterial;
import com.bluebirdme.mes.linglong.mix.service.MixSmallMaterialServiceImpl;


/**
 * 密炼小料库存实时表
 * @author 陈国强
 * @Date 2020-08-29 08:25:16
 */
@Log(code="AT_MX_WH_ITEM_INV",value="密炼小料库存实时表")
@RestController
@RequestMapping("mix/digitalSignage/mixsmallmaterial")
public class MixSmallMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixSmallMaterialServiceImpl mixsmallmaterialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixsmallmaterialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixsmallmaterialSrv;
	}
    
    @Log(code="AT_MX_WH_ITEM_INV_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixsmallmaterialSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
      page.setPage(1);
      page.setRows(1000);
      return GsonTools.toJson(getService().datagrid(filter, page, MixSmallMaterial.class));
    }

}
