/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.finalcheck.service.SecondarySortAppearanceBeforeLogServiceImpl;


/**
 * 二次质检外观前分拣履历表
 * @author 孙尊龙
 * @Date 2020-01-21 13:54:15
 */
@Log(code="AT_D_QM_SORTAPPEARANCELOG",value="二次质检外观前分拣履历表")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/secondarySortAppearanceBeforeLog")
public class SecondarySortAppearanceBeforeLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource 
    SecondarySortAppearanceBeforeLogServiceImpl secondarysortappearancebeforelogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return secondarysortappearancebeforelogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return secondarysortappearancebeforelogSrv;
	}
    
    @RequestMapping("getSecondarySortAppearanceBeforeLog")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

}
