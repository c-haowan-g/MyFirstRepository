/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.AppearancewcstomeslogServiceImpl;


/**
 * 外检WCS交互日志表
 * @author 徐秉正
 * @Date 2019-12-23 10:06:53
 */
@Log(code="外检WCS交互日志表",value="外检WCS交互日志表")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/appearancewcstomeslog")
public class AppearancewcstomeslogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource AppearancewcstomeslogServiceImpl appearancewcstomeslogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return appearancewcstomeslogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return appearancewcstomeslogSrv;
	}
    
//    @Override
//   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
//   	@ResponseBody
//   	@RequestMapping("datagrid")
//   	public String datagrid(Filter filter, Page page) throws Exception {
//       	if(filter.getFilter().containsKey("barcode_s")){
//   			filter.set("begin_created_time","");
//   			filter.set("end_created_time","");
//   		}
//   		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
//   	}
    
    @RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
//    	Map list = getUDAService().datagridUDA(filter, page);
//		return toJson(list);
	}
    
   
}











