/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.finalcheck.service.UfmDBResultServiceImpl;

/**
 * * 动平衡均匀机检测配套标准物料表
 * @author 周清玉
 *
 */
@Log(code="ufmdbresult_log",value="均匀性动平衡查询结果日志")
@RestController
@RequestMapping("finalcheck/reportCenter/ufmdbresult")
public class UfmDBResultController extends RockWellFunctionalUDAController<Object> {
    
    @Resource UfmDBResultServiceImpl ufmdbresultSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return ufmdbresultSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	 return ufmdbresultSrv;
	}
    

    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}


	

    
}
