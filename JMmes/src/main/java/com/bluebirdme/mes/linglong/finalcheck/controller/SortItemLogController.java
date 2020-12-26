/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortItemLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortItemLogDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.SortItemLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;

/**
 * 质检分拣物料规则表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 14:52:17
 */
@Log(code="AT_D_BS_SORTITEM_LOG",value="质检分拣物料规则日志")
@RestController
@RequestMapping("finalcheck/standardmagement/sortitemlog")
public class SortItemLogController extends RockWellFunctionalController<SortItemLog> {
    
    @Resource SortItemLogServiceImpl sortitemlogSrv;

    @Override
    protected RockWellBaseServiceImpl<SortItemLog> getService() {
        return sortitemlogSrv;
    }
    
    
    @Log(code="AT_D_BS_SORTITEM_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SortItemLogDTO sortitemlog ) throws Exception {
        sortitemlogSrv.saveChanges(sortitemlog);
        return Response.suc();
    }

}
