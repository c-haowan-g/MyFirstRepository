/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynamicBalance;
import com.bluebirdme.mes.linglong.finalcheck.service.DynamicBalanceServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.DynamicBalanceDTO;

/**
 * PLM动平衡参数表
 * @author 赵怀浩
 * @Date 2018-11-28 09:19:33
 */
@Log(code="AT_INT_PLM_DYNAMICBALANCE_LOG",value="PLM动平衡参数表操作日志")
@RestController
@RequestMapping("finalcheck/standarManagement/dynamicbalance")
public class DynamicBalanceController extends RockWellFunctionalController<DynamicBalance> {
    
    @Resource DynamicBalanceServiceImpl dynamicbalanceSrv;

    @Override
    protected RockWellBaseServiceImpl<DynamicBalance> getService() {
        return dynamicbalanceSrv;
    }
    
    
    @Log(code="AT_INT_PLM_DYNAMICBALANCE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody DynamicBalanceDTO dynamicbalance ) throws Exception {
        dynamicbalanceSrv.saveChanges(dynamicbalance);
        return Response.suc();
    }
    
    /**
     * 根据配方号，查询PLM动平衡检测参数
     * @param judgeid 判定标准ID：INT_PLM_DYNAMICBALANCE.ATR_KEY
     * @return
     * @throws Exception
     */
    @Log(code="AT_INT_PLM_DYNAMICBALANCE_LOG_SEARCH",value="根据配方表记录的动平衡参数ID查询PLM参数",target=LogType.CONSOLE)
    @RequestMapping("searchplmdynamicbalance")
   	public String searchplmdynamicbalance(String judgeid) throws Exception{
    	List<Map<String,Object>> list=dynamicbalanceSrv.searchplmdynamicbalance(judgeid);
   		return  GsonTools.toJson(list);
   	}

}
