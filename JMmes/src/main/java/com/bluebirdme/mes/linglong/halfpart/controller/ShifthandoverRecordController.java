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

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.ShifthandoverRecordServiceImpl;


/**
 * 半部件交接班记录表
 * @author 时永良
 * @Date 2020-07-05 10:43:26
 */
@Log(code="半部件交接班记录表",value="半部件交接班记录表")
@RestController
@RequestMapping("halfpart/productionManagement/shifthandoverRecord")
public class ShifthandoverRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ShifthandoverRecordServiceImpl shifthandoverrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return shifthandoverrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return shifthandoverrecordSrv;
	}
    
    @Override
    @Log(code = "半部件交接班记录初始化查询", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
}
