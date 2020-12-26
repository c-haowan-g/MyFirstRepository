/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;

import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGradeLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ProcessGradeLogServiceImpl;

import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ProcessGradeLogDTO;

/**
 * 质检工序等级表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 11:37:41
 */
@Log(code="AT_D_BS_PROCESSGRADE_LOG",value="质检工序等级表日志")
@RestController
@RequestMapping("finalcheck/standardmagement/processgradelog")
public class ProcessGradeLogController extends RockWellFunctionalController<ProcessGradeLog> {
    
    @Resource ProcessGradeLogServiceImpl processgradelogSrv;

    @Override
    protected RockWellBaseServiceImpl<ProcessGradeLog> getService() {
        return processgradelogSrv;
    }
    
    
    @Log(code="AT_D_BS_PROCESSGRADE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ProcessGradeLogDTO processgradelog ) throws Exception {
        processgradelogSrv.saveChanges(processgradelog);
        return Response.suc();
    }

}
