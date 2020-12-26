/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.DotRecordServiceImpl;

/**
 * 年周号履历
 * 
 * @author 刘朋
 * @Date 2019-09-11
 */
@Log(code = "dotrecord_log", value = "年周号履历查询")
@RestController
@RequestMapping("curing/dotrecord")
public class DotRecordController extends RockWellFunctionalUDAController<Object> {

	@Resource
	DotRecordServiceImpl dotrecordSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return dotrecordSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return dotrecordSrv;
	}

	@Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(dotrecordSrv.datagridUDA(filter, page));
	}
}
