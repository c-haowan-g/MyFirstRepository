/**
 * 王海霖
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;

import javax.annotation.Resource;
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
import com.bluebirdme.mes.linglong.building.entity.ClassPlan;
import com.bluebirdme.mes.linglong.building.service.ClassPlanServiceImpl;

/**
 * 成型班次计划表
 * @author 王海霖
 * @Date 2019-08-06 08:17:31
 */
@Log(code="成型班次计划表",value="成型班次计划表")
@RestController
@RequestMapping("building/productionmanagement/classplan")
public class ClassPlanController extends  RockWellFunctionalUDAController<Object> {
    
    @Resource ClassPlanServiceImpl classplanSrv;

    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return classplanSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return classplanSrv;
	}
    
    @Log(code="成型班次计划表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        classplanSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Override
  	@Log(value = "班次计划查询", code = "classplandatagrid", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
  		return GsonTools.toJson(classplanSrv.datagridUDA(filter, page));
  	}
    
    /**
     * 查询日计划号
     * @return
     * @throws Exception
     */
    @RequestMapping("searchPlanCode")
    public String searchPlanCode() throws Exception {
    	List<String> a=classplanSrv.searchPlanCode();
        return toJson(classplanSrv.searchPlanCode());
    }
    /**
     * 查询工单号
     * @return
     * @throws Exception
     */
    @RequestMapping("searchOrderCode")
    public String searchOrderCode() throws Exception {
    	List<String> b=classplanSrv.searchOrderCode();
    	return toJson(classplanSrv.searchOrderCode());
    }
    /**
     * 查询物料编码号
     * @return
     * @throws Exception
     */
    @RequestMapping("searchMaterialCode")
    public String searchMaterialCode() throws Exception {
    	List<String> c=classplanSrv.searchMaterialCode();
    	return toJson(classplanSrv.searchMaterialCode());
    }

	
}
