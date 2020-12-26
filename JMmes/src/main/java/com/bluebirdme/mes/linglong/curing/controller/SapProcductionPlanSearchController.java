/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.curing.entity.SapProcductionPlanSearch;
import com.bluebirdme.mes.linglong.curing.service.SapProcductionPlanSearchServiceImpl;

/**
 * 硫化月计划查询
 * @author hailin_wang
 * @Date 2018-08-25 10:00:04
 */
@Log(code="LH_SCJH_YJHS",value="硫化月机划查询")
@RestController
@RequestMapping("curing/productionPlan/monthlyPlanQuery")
public class SapProcductionPlanSearchController extends RockWellFunctionalController<SapProcductionPlanSearch> {
    
    @Resource SapProcductionPlanSearchServiceImpl sapprocductionplansearchSrv;

    @Override
    protected RockWellBaseServiceImpl<SapProcductionPlanSearch> getService() {
        return sapprocductionplansearchSrv;
    }
}
