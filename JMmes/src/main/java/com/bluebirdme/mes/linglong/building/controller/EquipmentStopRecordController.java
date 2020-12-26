/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.EquipmentStopRecord;
import com.bluebirdme.mes.linglong.building.service.EquipmentStopRecordServiceImpl;

/**
 * 设备报警停机履历表
 * @author 时永良
 * @Date 2019-04-25 09:29:47
 */
@Log(code="AT_B_EM_EQUIPMENTSTOPRECORD_LOG",value="设备报警停机履历表操作日志")
@RestController
@RequestMapping("building/productionmanagement/equipmentstoprecord")
public class EquipmentStopRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EquipmentStopRecordServiceImpl equipmentstoprecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return equipmentstoprecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	 return equipmentstoprecordSrv;
	}
    @Override
	@Log(value = "设备报警停机查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
