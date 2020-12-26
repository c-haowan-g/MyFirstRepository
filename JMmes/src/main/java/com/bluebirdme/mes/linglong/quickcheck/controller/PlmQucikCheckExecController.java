/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.controller;

import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.quickcheck.entity.PlmQuickCheckExec;
import com.bluebirdme.mes.linglong.quickcheck.service.PlmQucikCheckExecServiceImpl;


/**
 * PLM快检标准参数执行表
 * @author 肖吉朔
 * @Date 2020-08-08 11:10:40
 */
@Log(code="111",value="PLM快检标准参数执行表")
@RestController
@RequestMapping("/quickcheck/plmexec")
public class PlmQucikCheckExecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmQucikCheckExecServiceImpl execSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return execSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return execSrv;
	}
   
        
    @Log(code="111_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        execSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid2"})
    public String datagrid2(Filter filter, Page page) throws Exception { 
    	return GsonTools.toJson(getService().datagrid2(filter, page, PlmQuickCheckExec.class)); 
    } 
    
    
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagridhis"})
    public String datagridhis(Filter filter, Page page) throws Exception {
      return GsonTools.toJson(getService().datagrid(filter, page, PlmQuickCheckExec.class));
    }
   

}
