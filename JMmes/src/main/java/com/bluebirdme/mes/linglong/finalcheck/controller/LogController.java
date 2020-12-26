/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;







import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.LogServiceImpl;


/**
 * 轮胎锁定记录表
 * @author 陈国强
 * @Date 2020-12-02 16:35:01
 */
@Log(code="AT_D_QM_LOCK_LOG",value="轮胎锁定记录表")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/log")
public class LogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource LogServiceImpl logSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return logSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return logSrv;
	}
    
    @Log(code="AT_LOCK_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        logSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
   @Override
   @Log(value = "查询列表",code = "All",target = LogType.CONSOLE)
   @ResponseBody
   @RequestMapping("datagrid")
   public String datagrid(Filter filter,Page page) throws Exception{
	   
	   return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	   
	   
   }
   

}
