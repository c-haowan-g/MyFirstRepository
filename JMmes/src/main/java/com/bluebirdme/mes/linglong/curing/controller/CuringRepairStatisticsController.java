/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CuringRepairStatisticsServiceImpl;


/**
 * 硫化返修统计
 * @author 葛迎祥
 * @Date 2020-04-09 16:13:18
 */
@Log(code="AT_C_QM_REPAIR_STATISTICS",value="硫化返修统计")
@RestController
@RequestMapping("curing/ReportQuery/CuringRepairStatistics")
public class CuringRepairStatisticsController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringRepairStatisticsServiceImpl curingrepairstatisticsSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingrepairstatisticsSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingrepairstatisticsSrv;
	}
    
    
    @Log(code = "AT_C_QM_REPAIR_STATISTICS", value = "查询全部页面初始化使用")
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
    	Map map = new HashMap();
    	if(filter.get("month_s")!=null){
			filter.set("month_s", filter.get("month_s").replace("-", ""));
		}
    	if(filter.getFilter().containsKey("work_id") && filter.getFilter().containsKey("material_code")){
    		map = curingrepairstatisticsSrv.datagridUDA(filter, page);
    	} else if(filter.getFilter().containsKey("work_id") && !filter.getFilter().containsKey("material_code")){
    		map = curingrepairstatisticsSrv.datagridUDA2(filter, page);
    	} else if(!filter.getFilter().containsKey("work_id") && filter.getFilter().containsKey("material_code")){
    		map = curingrepairstatisticsSrv.datagridUDA3(filter, page);
    	} else {
    		map = curingrepairstatisticsSrv.datagridUDA(filter, page);
    	}
    	return toJson(map);
	}
}
