/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.common.entity.CommonDynamicBalanceEdit;
import com.bluebirdme.mes.linglong.common.service.CommonDynamicBalanceEditServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.dto.CommonDynamicBalanceEditDTO;

/**
 * PLM动平衡标准管理表
 * @author 刘程明
 * @Date 2019-07-09 10:05:32
 */
@Log(code="AT_INT_PLM_DYNAMICBALANCEEDIT_LOG",value="PLM动平衡标准管理表操作日志")
@RestController
@RequestMapping("common/plm/commonplmdynamicbalanceedit")
public class CommonDynamicBalanceEditController extends RockWellFunctionalController<CommonDynamicBalanceEdit> {
    
    @Resource CommonDynamicBalanceEditServiceImpl commondynamicbalanceeditSrv;

    @Override
    protected RockWellBaseServiceImpl<CommonDynamicBalanceEdit> getService() {
        return commondynamicbalanceeditSrv;
    }
    
    
    @Log(code="AT_INT_PLM_DYNAMICBALANCEEDIT_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody CommonDynamicBalanceEditDTO commondynamicbalanceedit ) throws Exception {
        commondynamicbalanceeditSrv.saveChanges(commondynamicbalanceedit);
        return Response.suc();
    }

    /**
     * 下发
     * @param recipecodelist
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年7月1日
     */
    @RequestMapping("letdown")
    public Response letdown(String[] recipecodelist) throws Exception {
        return Response.suc(commondynamicbalanceeditSrv.letdown(recipecodelist));
    }
    
    /**
     * 启用标准--323002启用状态
     * @param recipecodelist
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年7月1日
     */
    @RequestMapping("startstandard")
    public Response startstandard(String[] recipecodelist) throws Exception {
        return Response.suc(commondynamicbalanceeditSrv.standardmanage(recipecodelist,"323002"));
    }
    /**
     * 停用标准--323003停用状态
     * @param recipecodelist
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年7月1日
     */
    @RequestMapping("stopstandard")
    public Response stopstandard(String[] recipecodelist) throws Exception {
        return Response.suc(commondynamicbalanceeditSrv.standardmanage(recipecodelist,"323003"));
    }
}
