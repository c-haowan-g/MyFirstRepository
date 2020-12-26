/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanTrimLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanTrimLogServiceImpl;

/**
 * 割毛产量查询表
 * @author 时永良
 * @Date 2018-08-04 18:14:57
 */
@Log(code="ZJ_ZJGL_GM",value="割毛产量查询日志")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/scanTrimLog")
public class ScanTrimLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ScanTrimLogServiceImpl scantrimlogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return scantrimlogSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return scantrimlogSrv;
	}
    
    @Log(code="ZJ_ZJGL_GM_SEARCH",value="查询数据",target = LogType.CONSOLE)
    @RequestMapping("search")
    public Response search(@RequestBody Map<String,Object> list_map) throws Exception{
        return Response.suc(scantrimlogSrv.search(list_map));
    }
}
