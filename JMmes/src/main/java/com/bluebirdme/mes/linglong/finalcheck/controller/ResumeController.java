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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.ResumeServiceImpl;


/**
 * 改判作业履历表
 * @author 徐秉正
 * @Date 2020-05-25 08:07:02
 */
@Log(code="改判作业",value="改判作业")
@RestController
@RequestMapping("finalcheck/resume/resume")
public class ResumeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ResumeServiceImpl resumeSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return resumeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return resumeSrv;
	}
    
    @Log(code="外观改判作业记录履历_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
//    	filter.set("s_factory_s", s_factory_s)
    	filter.set("s_factory_s", LLWebUtils.factory());
        //Map<String,Object> map=getUDAService().datagridUDA(filter, page);
        return GsonTools.toJson(resumeSrv.datagridRowsUDA(filter, page));
    }

}
