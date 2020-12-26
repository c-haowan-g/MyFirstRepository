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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.bluebirdme.mes.linglong.halfpart.service.ToleranceMaintenanceServiceImpl;


/**
 * 半部件砝码公差维护表
 * @author 时永良
 * @Date 2020-12-04 14:58:57
 */
@Log(code="半部件砝码公差维护",value="半部件砝码公差维护")
@RestController
@RequestMapping("halfpart/baseData/tolerancemaintenance/toleranceMaintenance")
public class ToleranceMaintenanceController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ToleranceMaintenanceServiceImpl tolerancemaintenanceSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tolerancemaintenanceSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return tolerancemaintenanceSrv;
	}
    
    @Log(code="半部件砝码公差维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        tolerancemaintenanceSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    
    @Log(code = "半部件砝码公差维护初始化查询", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagridByProcess")
	public String datagrid(@RequestParam("process")String process, Filter filter, Page page) throws Exception {
    	filter.set("spare1_s", process);
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    
    /**
 	 * 获得半部件用产线
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:52:24
 	 * 
 	 */
	@RequestMapping("getBuildingProductionLine")
 	public String getHalfPartProductionLine() throws Exception{
		List<String> list=tolerancemaintenanceSrv.getBuildingProductionLine();
		return toJson(list);
 	}
}
