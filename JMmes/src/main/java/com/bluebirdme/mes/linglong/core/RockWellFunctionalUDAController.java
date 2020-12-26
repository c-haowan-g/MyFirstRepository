package com.bluebirdme.mes.linglong.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 抽象出业务的公共方法
 * 
 * @author qingyu_zhou
 * @param <T>
 */
public abstract class RockWellFunctionalUDAController<T> extends RockWellFunctionalController<T> {

	protected abstract RockWellUDABaseServiceImpl<T> getUDAService();

	@Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
