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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortGradeDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.SortGradeServiceImpl;

/**
 * 质检分拣等级规则表
 * @author 刘程明
 * @Date 2018-08-16 12:23:33
 */
@Log(code="ZJ_BZGL_FJDJ",value="质检分拣等级规则表")
@RestController
@RequestMapping("finalcheck/reportcenter/sortgrade")
public class SortGradeController extends RockWellFunctionalController<SortGrade> {
    
    @Resource SortGradeServiceImpl sortgradeSrv;

    @Override
    protected RockWellBaseServiceImpl<SortGrade> getService() {
        return sortgradeSrv;
    }
    
    
    @Log(code="ZJ_BZGL_FJDJ_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SortGradeDTO sortgrade ) throws Exception{
        sortgradeSrv.saveChanges(sortgrade);
        return Response.suc();
    }

}
