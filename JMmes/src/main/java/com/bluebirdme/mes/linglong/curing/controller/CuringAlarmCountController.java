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
import com.bluebirdme.mes.linglong.curing.service.CuringAlarmCountServiceImpl;

/**
 * 硫化报警统计
 * 
 * @author 刘朋
 * @Date 2019-09-11
 */
@Log(code = "curingalarm_long", value = "硫化报警汇总表")
@RestController
@RequestMapping("curing/report/curingalarmcount")
public class CuringAlarmCountController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CuringAlarmCountServiceImpl curingalarmcountSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return curingalarmcountSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return curingalarmcountSrv;
	}

}
