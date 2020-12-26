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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortGradeLog;
import com.bluebirdme.mes.linglong.finalcheck.service.SortGradeLogServiceImpl;

import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortGradeLogDTO;

/**
 * 质检分检等级规则表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 13:33:09
 */
@Log(code="AT_D_BS_SORTGRADE_LOG",value="蓝英分拣规则接口日志")
@RestController
@RequestMapping("finalcheck/standardmagement/sortgradelog")
public class SortGradeLogController extends RockWellFunctionalController<SortGradeLog> {
    
    @Resource SortGradeLogServiceImpl sortgradelogSrv;

    @Override
    protected RockWellBaseServiceImpl<SortGradeLog> getService() {
        return sortgradelogSrv;
    }
    
    
    @Log(code="AT_D_BS_SORTGRADE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SortGradeLogDTO sortgradelog ) throws Exception {
        sortgradelogSrv.saveChanges(sortgradelog);
        return Response.suc();
    }

}
