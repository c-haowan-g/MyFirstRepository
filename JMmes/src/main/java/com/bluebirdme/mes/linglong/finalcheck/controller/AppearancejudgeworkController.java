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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.AppearancejudgeworkServiceImpl;


/**
 * 外观改判作业记录履历
 * @author 徐秉正
 * @Date 2020-05-15 13:22:56
 */
@Log(code="外观改判作业记录履历",value="外观改判作业记录履历")
@RestController
@RequestMapping("finalcheck/appearancejudgework/appearancejudgework")
public class AppearancejudgeworkController extends RockWellFunctionalUDAController<Object> {
    
    @Resource AppearancejudgeworkServiceImpl appearancejudgeworkSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return appearancejudgeworkSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return appearancejudgeworkSrv;
	}
    
    @Log(code="外观改判作业记录履历_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("datagrid")
//    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
//        appearancejudgeworkSrv.saveChanges(rockWellEntityDTO);
//        return Response.suc();
//    }
    public String datagrid(Filter filter, Page page) throws Exception {
        //Map<String,Object> map=getUDAService().datagridUDA(filter, page);
        return GsonTools.toJson(appearancejudgeworkSrv.datagridRowsUDA(filter, page));
    }

}
