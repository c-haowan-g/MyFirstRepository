/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.DeviceList;
import com.bluebirdme.mes.linglong.common.service.DeviceListServiceImpl;


/**
 * PLM系统设备清单表
 * @author sqj
 * @Date 2019-01-11 13:40:17
 */
@Log(code="PLM系统设备清单表",value="PLM系统设备清单表")
@RestController
@RequestMapping("common/devicelist")
public class DeviceListController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DeviceListServiceImpl devicelistSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return devicelistSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return devicelistSrv;
	}
    

    @Log(value = "PLM系统设备参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid2")
   	public String datagrid2(String equipmentcodes) {
   		List<Map<String, Object>> list = devicelistSrv.searchByMaterial(equipmentcodes);
   		return toJson(list);
   	}
    
    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
   		return GsonTools.toJson(devicelistSrv.datagrid(filter, page, DeviceList.class));
   	}
    /**
     * 获取设备的code和name的对应关系
     * 周清玉
     * @return
     * @throws Exception
     */
    @RequestMapping("getEquipcodeAndName")
   	public String getEquipcodeAndName() throws Exception {
    	List<Map<String,Object>> list=devicelistSrv.getEquipcodeAndName();
   		return toJson(list);
   	}



	
    
    
}
