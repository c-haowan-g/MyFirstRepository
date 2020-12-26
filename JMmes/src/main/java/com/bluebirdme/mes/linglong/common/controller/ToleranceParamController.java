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
import com.bluebirdme.mes.linglong.common.service.ToleranceParamServiceImpl;


/**
 * PLM公差参数项表
 * @author 周清玉
 * @Date 2019-01-11 13:40:17
 */
@Log(code="PLM公差参数表",value="PLM公差参数表")
@RestController
@RequestMapping("common/toleranceparam")
public class ToleranceParamController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ToleranceParamServiceImpl toleranceparamSrv;

    @Override
    protected ToleranceParamServiceImpl getService() {
        return toleranceparamSrv;
    }
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return toleranceparamSrv;
	}

    @Log(value = "PLM公差参数项表", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid2")
   	public String datagrid2(String ids) {
   		List<Map<String, Object>> list = toleranceparamSrv.searchByMaterial(ids);
   		return toJson(list);
   	}
    
    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
   		return GsonTools.toJson(toleranceparamSrv.datagridUDA(filter, page));
   	}



    
    
}
