/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.common.entity.PersonLog;
import com.bluebirdme.mes.linglong.common.entity.dto.PersonLogDTO;
import com.bluebirdme.mes.linglong.common.service.PersonLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 用户管理日志表
 * 
 * @author 时永良
 * @Date 2018-10-17 10:49:36
 */
@Log(code = "AT_INT_HR_PERSON_LOG", value = "用户接口日志页面")
@RestController
@RequestMapping("common/PersonLog")
public class PersonLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	PersonLogServiceImpl personlogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return personlogSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return personlogSrv;
	}
	/**
	 * 
	 * @Title: 页面初始化
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getData")
	public String datagrid(Filter filter, Page page)
			throws Exception {
		return GsonTools.toJson(personlogSrv.datagridUDA(filter, page));
	}
}
