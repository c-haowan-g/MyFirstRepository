/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.WorkerLoginRecordServiceImpl;


/**
 * 操作工登录履历表
 * @author 王超
 * @Date 2020-01-20 09:59:31
 */
@Log(code="半部件全钢操作工登录履历",value="半部件全钢操作工登录履历")
@RestController
@RequestMapping("halfpart/productionManagement/workerLoginRecord")
public class WorkerLoginRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WorkerLoginRecordServiceImpl workerloginrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return workerloginrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workerloginrecordSrv;
	}
    
    @Override
    @Log(code = "半部件全钢操作工登录履历", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = workerloginrecordSrv.datagridUDA(filter, page);
		return toJson(map);
		
	}
    
    @Log(code="半部件全钢操作工登录履历",value="保存数据的增删改")
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO workerloginrecord) throws Exception {
    	if (workerloginrecordSrv.saveChanges(workerloginrecord) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",workerloginrecord);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 查出机台条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchEquipCode", value = "查出机台条码显示在JSP页面下拉列表处")
	@RequestMapping("searchEquipCode")
	public String searchEquipCode() throws Exception {
		List<Map<String, Object>> list = workerloginrecordSrv.searchEquipCode();
		return toJson(list);
	}
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toChangedName", value = "根据用户号码查询姓名")
	@RequestMapping("toChangedName")
	public String toChangedName(String usercode) throws Exception {
		List<Map<String, Object>> list = workerloginrecordSrv.toChangedName(usercode);
		return toJson(list);
	}

}
