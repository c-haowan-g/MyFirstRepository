/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

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
import com.bluebirdme.mes.linglong.halfpart.service.StockdifferentlistServiceImpl;


/**
 * 半部件盘库记录差异表
 * @author 徐秉正
 * @Date 2020-03-16 16:45:03
 */
@Log(code="半部件盘库记录差异表",value="半部件盘库记录差异表")
@RestController
@RequestMapping("halfpart/stockdifferentlist/stockdifferentlist")
public class StockdifferentlistController extends RockWellFunctionalUDAController<Object> {
    
    @Resource StockdifferentlistServiceImpl stockdifferentlistSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return stockdifferentlistSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return stockdifferentlistSrv;
	}
    
    @Log(code="半部件盘库记录差异表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        stockdifferentlistSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    /**
     * 获取数据
     * @throws Exception
     */
    @Override
    @Log(value = "查询盘库数据子界面", code = "查询", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter,Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
    }
}
