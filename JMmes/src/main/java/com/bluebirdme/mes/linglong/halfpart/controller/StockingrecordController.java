/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

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
import com.bluebirdme.mes.linglong.halfpart.service.StockingrecordServiceImpl;


/**
 * 半部件盘库记录
 * @author 徐秉正
 * @Date 2020-03-16 10:33:49
 */
@Log(code="半部件盘库管理",value="半部件盘库管理")
@RestController
@RequestMapping("halfpart/stockingRecord/stockingrecord/stockingrecord")
public class StockingrecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource StockingrecordServiceImpl stockingrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return stockingrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return stockingrecordSrv;
	}
    
    @Log(code="半部件盘库管理_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        stockingrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Override
    @Log(code = "半部件盘库管理", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
   
 // 查出物料组显示在JSP页面下拉列表处
	
 	@Log(code = "searchMaterielgroup", value = "查出物料名称显示在JSP页面下拉列表处")
 	@RequestMapping("searchMaterielgroup")
 	public String searchMaterielgroup() throws Exception {
 		List<Map<String, Object>> list = stockingrecordSrv.searchMaterielgroup();
 		return toJson(stockingrecordSrv.searchMaterielgroup());
 	}
     
}
