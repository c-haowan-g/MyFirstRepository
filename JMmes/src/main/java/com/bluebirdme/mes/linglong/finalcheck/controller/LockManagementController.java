/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;






import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberItemAll;
import com.bluebirdme.mes.linglong.finalcheck.service.LockManagementServiceImpl;


/**
 * 轮胎锁定信息管理表
 * @author 陈国强
 * @Date 2020-12-01 14:24:14
 */
@Log(code="AT_D_QM_LOCK_MANAGEMENT",value="轮胎锁定信息管理表")
@RestController
@RequestMapping("finalcheck/baseData/lockManagement")
public class LockManagementController extends RockWellFunctionalUDAController<Object> {
    
    @Resource LockManagementServiceImpl lockmanagementSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return lockmanagementSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return lockmanagementSrv;
	}
    
    @Log(code="AT_LOCK_MANAGEMENT_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        lockmanagementSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @RequestMapping("getrea")
    public String getrea() throws Exception
    {
    	String w= "252008";
    	List<Map<String, Object>> list = lockmanagementSrv.getreas();
		return toJson(list);
    }

}
