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

import com.bluebirdme.mes.linglong.finalcheck.entity.EntLog;
import com.bluebirdme.mes.linglong.finalcheck.service.EntLogServiceImpl;

import com.bluebirdme.mes.linglong.finalcheck.entity.dto.EntLogDTO;

/**
 * 质检设备信息表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-27 16:21:40
 */
@Log(code="AT_D_EM_ENT_LOG_LOG",value="质检设备信息表(终检蓝英接口同步履历)运行日志")
@RestController
@RequestMapping("finalcheck/baseData/entlog")
public class EntLogController extends RockWellFunctionalController<EntLog> {
    
    @Resource EntLogServiceImpl entlogSrv;

    @Override
    protected RockWellBaseServiceImpl<EntLog> getService() {
        return entlogSrv;
    }
    
    
    @Log(code="AT_D_EM_ENT_LOG_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody EntLogDTO entlog ) throws Exception {
        entlogSrv.saveChanges(entlog);
        return Response.suc();
    }

}
