/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.CheckXrayLog;
import com.bluebirdme.mes.linglong.finalcheck.service.CheckXrayLogServiceImpl;

/**
 * X光检测履历
 * @author 时永良
 * @Date 2018-08-09 07:39:33
 */
@Log(code="ZJ/ZJGL_XGJCLL",value="X光检测履历日志")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/checkXrayLog")
public class CheckXrayLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CheckXrayLogServiceImpl checkxraylogSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return checkxraylogSrv;
	}
    
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return checkxraylogSrv;
    }
    
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	if(filter.getFilter().containsKey("pn_s")){
			filter.set("begin_created_time","");
			filter.set("begin_created_time","");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    @Log(code="ZJ_BZGL_RKFJ_SAVE_ENTNAME",value="获取X光机")
    @RequestMapping("combox_entcode")
   	public String combox_entcode() throws Exception{
    	List<Map<String,Object>> list=checkxraylogSrv.getEntCodeName();
   		return toJson(list);
   	}
}
