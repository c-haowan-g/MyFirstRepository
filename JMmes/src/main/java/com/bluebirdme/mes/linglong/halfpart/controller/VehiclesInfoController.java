/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.hibernate.SQLQuery;
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
import com.bluebirdme.mes.linglong.halfpart.service.VehiclesInfoServiceImpl;


/**
 * 半部件工装载具信息
 * @author 栾和源
 * @Date 2020-03-03 15:56:00
 */
@Log(code="半部件工装载具信息",value="半部件工装载具信息")
@RestController
@RequestMapping("halfpart/basedata/vehiclesinfo")
public class VehiclesInfoController extends RockWellFunctionalUDAController<Object> {
    
    @Resource VehiclesInfoServiceImpl vehiclesinfoSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return vehiclesinfoSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return vehiclesinfoSrv;
	}
    
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
       	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
   		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
   	}
    
    
    @Log(code="半部件工装载具信息_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        vehiclesinfoSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    /**
	 * 载具条码重复性校验
	 * @return 标识  1不重复可添加/0已存在不可添加
	 */
	@RequestMapping("checkVehiclesBarcode")
	public String checkVehiclesBarcode(String vehiclesBarcode,String atrkey) {
		int i = vehiclesinfoSrv.checkVehiclesBarcode(vehiclesBarcode,atrkey);
		return Integer.toString(i);
	}
    
    /**
	 * 批量导入载具条码
	 * @return 
	 * @Title: 
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("BatchAdd")
	public Response BatchAdd(String vehicles_type_z,String vehicles_type_c,String startCode,String endCode,String capacity,String printflag,String myIndexA,String myIndexB) throws Exception {
		
		return Response.suc(vehiclesinfoSrv.BatchAdd(vehicles_type_z,vehicles_type_c,startCode,endCode,capacity,printflag,myIndexA,myIndexB));
	}
    
    /**
	  * 查出载具类型和存放库位显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchDescription", value = "查出载具类型和存放库位显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		
		List<Map<String, Object>> list = vehiclesinfoSrv.searchDescription();
		return toJson(list);
	}

	/**
     * 从基础数据表(at_cm_bs_coredictionary)表中查询功能名称和功能代码
     * 
     * @return
     */
    @RequestMapping("searchMethodName")
    public String searchMethodName(){
        List<String> methodNameList = vehiclesinfoSrv.searchMethodName();
        String list=toJson(methodNameList);
        return list;
    }
	
	/**
     * 从库位设置表(storage_unit)表中查询库存地址
     * 
     * @return
     */
    @RequestMapping("location")
    public String searchLocation(){
        List<String> locationList = vehiclesinfoSrv.searchLocation();
        String list=toJson(locationList);
        return list;
    }
   	
    
}
