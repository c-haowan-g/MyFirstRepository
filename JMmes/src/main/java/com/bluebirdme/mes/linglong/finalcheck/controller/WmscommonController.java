/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;








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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.WmscommonServiceImpl;


/**
 * WMS通用履历
 * @author 徐秉正
 * @Date 2020-10-20 17:55:26
 */
@Log(code="WMS推送履历",value="WMS推送履历")
@RestController
@RequestMapping("finalcheck/wmscommon/wmscommon")
public class WmscommonController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WmscommonServiceImpl wmscommonSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return wmscommonSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return wmscommonSrv;
	}
    
    @Log(code="WMS推送履历_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
    	System.out.println("@@@"+filter);
    	filter.set("s_factory_s", LLWebUtils.factory());   
    	return GsonTools.toJson(wmscommonSrv.datagridRowsUDA(filter, page));
    }

}
