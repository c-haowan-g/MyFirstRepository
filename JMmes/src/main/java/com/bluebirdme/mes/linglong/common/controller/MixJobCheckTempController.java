/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.List;

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
import com.bluebirdme.mes.linglong.common.service.MixJobCheckTempServiceImpl;


/**
 * 密炼作业准备检查模板表
 * @author 陈国强
 * @Date 2020-09-09 14:49:53
 */
@Log(code="MixJobCheckTemp_Log",value="密炼作业准备检查模板日志")
@RestController
@RequestMapping("common/MixJobCheckTemp")
public class MixJobCheckTempController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixJobCheckTempServiceImpl mixjobchecktempSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixjobchecktempSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixjobchecktempSrv;
	}
    
    @Log(code="MixJobCheckTemp_Log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixjobchecktempSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(code="MixJobCheckTemp_Log_SAVE_CHANGES", value="获取检查编码最大值", target=LogType.DB)
    @RequestMapping({"getMaxCode"})
    public String getMaxCode(String check_note_s) throws Exception {
      List list = this.mixjobchecktempSrv.findMaxCheckItem(check_note_s);
      return toJson(list);
    }
}
