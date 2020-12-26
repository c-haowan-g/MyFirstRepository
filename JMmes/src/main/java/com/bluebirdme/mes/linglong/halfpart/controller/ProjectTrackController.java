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
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.entity.Projecttrack;
import com.bluebirdme.mes.linglong.halfpart.service.ProjectTrackServiceImpl;


/**
 * 半部件计划跟踪
 * @author 徐秉正
 * @Date 2020-03-06 16:32:51
 */
@Log(code="AT_A_PM_PRODUCTPLAN_LOG",value="半部件计划跟踪")
@RestController
@RequestMapping("halfpart/productionplan/projecttrack")
public class ProjectTrackController extends RockWellFunctionalUDAController<Object> {
	
    @Resource ProjectTrackServiceImpl projecttrackSrv;

//    @Override
//    protected RockWellBaseServiceImpl<Object> getService() {
//        return projecttrackSrv;
//    }
    
    
   	 //查询全部 页面初始化使用
   	 
   	 
//    @Log(code="ProjectTrack_searchInit",value="查询全部 页面初始化使用")
//   	@RequestMapping("searchInit")
//   	public String searchInit(Filter filter, Page page, Class clazz)throws Exception {
//    	Map map = projecttrackSrv.datagrid(filter, page, ProductPlanATO.class);
//    	return toJson(map);
//    }
//    
    @Log(code="ProjectTrack_searchInit",value="查询全部 页面初始化使用")
   	@RequestMapping("searchInit")
   	public String searchInit(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
    	return toJson(map);
    }
    
    // 查出机台名称显示在JSP页面下拉列表处
	 
	@Log(code = "searchEquipCode", value = "查出机台名称显示在JSP页面下拉列表处")
	@RequestMapping("searchEquipCode")
	public String searchEquipCode() throws Exception {
		List<Map<String, Object>> list = projecttrackSrv.searchEquipCode();
		return toJson(list);
	}
	
	 /**
	  * 查出日计划号显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchPlanno", value = "查出日计划号显示在JSP页面下拉列表处")
	@RequestMapping("searchPlanno")
	public String searchPlanno() throws Exception {
		List<Map<String, Object>> list = projecttrackSrv.searchPlanno();
		return toJson(list);
	}


	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return projecttrackSrv;
	}


	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return projecttrackSrv;
	}
	
	
//	 @RequestMapping("datagridUDA")
//		public String datagridUDA(Filter filter, Page page) throws Exception {
//			return GsonTools.toJson(projecttrackSrv.datagridRowsUDA(filter, page));
//		}
}
