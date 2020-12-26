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
import com.bluebirdme.mes.linglong.curing.service.PatchCuringWorkServiceImpl;

/**
 * 硫化工单生产实绩表
 * 
 * @author 周志祥
 * @Date 2018-12-18 14:39:34
 */
@Log(code = "PatchCuringWorkLog", value = "硫化工单生产实绩表")
@RestController
@RequestMapping("curing/report/patchcuringwork")
public class PatchCuringWorkController extends RockWellFunctionalUDAController<Object> {

	@Resource
	PatchCuringWorkServiceImpl patchcuringworkSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return patchcuringworkSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return patchcuringworkSrv;
	}

}
