/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.CheckXrayDetailServiceImpl;


/**
 * X光质检信息明细表
 * @author 栾和源
 * @Date 2020-02-24 09:20:21
 */
@Log(code="checkxraydetail",value="checkxraydetail")
@RestController
@RequestMapping("/finalcheck/qualityInspectionRecord/checkXrayDetailLog")
public class CheckXrayDetailController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CheckXrayDetailServiceImpl checkxraydetailSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return checkxraydetailSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return checkxraydetailSrv;
	}
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
       	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
   		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
   	}

}
