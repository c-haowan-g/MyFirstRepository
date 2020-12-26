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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.VehiclesDetailInfoServiceImpl;


/**
 * 口型板规格对应信息表
 * @author 栾和源
 * @Date 2020-03-04 11:27:02
 */
@Log(code="口型板规格对应信息表",value="口型板规格对应信息表")
@RestController
@RequestMapping("halfpart/basedata/vehiclesDetailInfo")
public class VehiclesDetailInfoController extends RockWellFunctionalUDAController<Object> {
    
    @Resource VehiclesDetailInfoServiceImpl vehiclesdetailinfoSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return vehiclesdetailinfoSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return vehiclesdetailinfoSrv;
	}
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
       	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
   		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
   	}
    
    
    @Log(code="口型板规格对应信息维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        
    	if (vehiclesdetailinfoSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复",null);
		}
		return Response.suc();
    }
    
    /**
	  * 查出口型板条码、口型板规格显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchVehiclesDescription", value = "查出口型板条码、口型板规格显示在JSP页面下拉列表处")
	@RequestMapping("searchVehiclesDescription")
	public String searchVehiclesDescription() throws Exception {
		
		List<Map<String, Object>> list = vehiclesdetailinfoSrv.searchVehiclesDescription();
		return toJson(list);
	}

	
	/**
	  * 查出物料规格显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchMaterialDescription", value = "查出物料规格显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialDescription")
	public String searchMaterialDescription() throws Exception {
		
		List<Map<String, Object>> list = vehiclesdetailinfoSrv.searchMaterialDescription();
		return toJson(list);
	}
	
	
	
}
