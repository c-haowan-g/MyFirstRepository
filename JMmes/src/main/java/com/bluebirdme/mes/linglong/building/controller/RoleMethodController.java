/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.RoleMethod;
import com.bluebirdme.mes.linglong.building.service.RoleMethodServiceImpl;

/**
 * 角色功能对应表
 * @author wanghailin
 * @Date 2019-03-18 09:12:58
 */
@Log(code="RoleMethodLog",value="角色功能")
@RestController
@RequestMapping("roleMethodUrl")
public class RoleMethodController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RoleMethodServiceImpl rolemethodSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return rolemethodSrv;
	}
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return rolemethodSrv;
	}
	
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(rolemethodSrv.datagridUDA(filter, page));
	}
    
    @Log(code="RoleMethodLog_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception{
    	String result= rolemethodSrv.saveChanges(rockWellEntityDTO);
    	return Response.suc(result);
    }
    /**
     * 从CORE_ROLE表中查询角色名称和角色ID
     * 兰颖慧-2019/03/18
     * @return
     */
    @RequestMapping("searchRoleName")
    public String searchRoleName(){
        List<String> roleNameList = rolemethodSrv.searchRoleName();
        String list=toJson(roleNameList);
        return list;
    }
    /**
     * 从基础数据表(at_cm_bs_coredictionary)表中查询功能名称和功能代码
     * 兰颖慧-2019/03/18
     * @return
     */
    @RequestMapping("searchMethodName")
    public String searchMethodName(){
        List<String> methodNameList = rolemethodSrv.searchMethodName();
        String list=toJson(methodNameList);
        return list;
    }
	
}
