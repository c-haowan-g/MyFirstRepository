/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.AlertsrecordServiceImpl;

/**
 * 硫化报警信息表
 * 
 * @author 刘朋
 * @Date 2018-11-27 16:07:15
 */
@Log(code = "ALERTSRECORD", value = "硫化机台报警查询")
@RestController
@RequestMapping("curing/report/alertsrecord")
public class AlertsrecordController extends RockWellFunctionalUDAController<Object> {

	@Resource
	AlertsrecordServiceImpl alertsrecordSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return alertsrecordSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return alertsrecordSrv;
	}

}
