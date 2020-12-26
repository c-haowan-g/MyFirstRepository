/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import javax.annotation.Resource;
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
import com.bluebirdme.mes.linglong.common.service.CuringdieDrawingServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * PLM硫化模具标识图表
 * @author 周清玉
 * @Date 2019-01-09 15:11:23
 */
@Log(code="PLM硫化模具标识图表",value="PLM硫化模具标识图表")
@RestController
@RequestMapping("common/curingdiedrawing")
public class CuringdieDrawingController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringdieDrawingServiceImpl curingdiedrawingSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingdiedrawingSrv;
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingdiedrawingSrv;
	}
    
	@Log(value = "查询全部数据", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridOn")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(curingdiedrawingSrv.datagridUDA(filter, page));
	}

}
