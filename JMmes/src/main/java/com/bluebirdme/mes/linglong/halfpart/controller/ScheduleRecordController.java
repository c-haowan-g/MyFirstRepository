/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;




import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.service.ScheduleRecordServiceImpl;


/**
 * 半部件物流调度履历查询
 * @author 孙尊龙
 * @Date 2020-07-14 14:33:02
 */
@Log(code="AT_A_MM_SCHEDULERECORD_LOG",value="半部件物流调度履历查询日志")
@RestController
@RequestMapping("halfpart/stockmanagement/ScheduleRecord")
public class ScheduleRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ScheduleRecordServiceImpl schedulerecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return schedulerecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return schedulerecordSrv;
	}
    
    @Log(code="AT_A_MM_SCHEDULERECORD_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        schedulerecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    // 查出半部件机台名称显示在JSP页面下拉列表处
	
 	@Log(code = "searchLine", value = "查出半部件机台名称显示在JSP页面下拉列表处")
 	@RequestMapping("searchLine")
 	public String searchMaterielgroup() throws Exception {
 		
 		if(LLWebUtils.factory().equals("1")){
 			return toJson(schedulerecordSrv.searchLine());	
 		}
 		if(LLWebUtils.factory().equals("2")){
 			return toJson(schedulerecordSrv.searchLine2());	
 		}
 		return "";
 	}

}
