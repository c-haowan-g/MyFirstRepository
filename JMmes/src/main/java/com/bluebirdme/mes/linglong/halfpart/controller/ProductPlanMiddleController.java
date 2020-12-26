/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.Map;

import javax.annotation.Resource;






import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.ProductPlanMiddleServiceImpl;

/**
 * 半部件计划中间表
 * @author 时永良
 * @Date 2020年7月13日11:45:52
 */
@Log(code="AT_A_PM_PRODUCTPLAN_MIDDLE_LOG",value="半部件计划中间表日志")
@RestController
@RequestMapping("halfpart/producttion/specialplancheck")
public class ProductPlanMiddleController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ProductPlanMiddleServiceImpl productplanmiddleSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return productplanmiddleSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return productplanmiddleSrv;
	}
    
    
    @Log(code="AT_A_PM_PRODUCTPLAN_MIDDLE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        productplanmiddleSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    @Override
    @Log(code = "半部件交接班记录初始化查询", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = productplanmiddleSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
}
