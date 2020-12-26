/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.rockwell.mes.ws.server.Obj;
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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanDynaBalanceLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanDynaBalanceLogServiceImpl;

/**
 * 动平衡扫描履历表
 * @author wanghailin
 * @Date 2018-08-09 15:47:59
 */
@Log(code="ZJ_ZJGL_DPHSMLL",value="动平衡扫描履历日志")
@RestController
@RequestMapping("/finalcheck/qualityInspectionRecord/scanDynaBalanceLog")
public class ScanDynaBalanceLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ScanDynaBalanceLogServiceImpl scandynabalancelogSrv;

    
       
	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		/*if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}*/
		return GsonTools.toJson(scandynabalancelogSrv.datagridUDA(filter, page));
	}



	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return scandynabalancelogSrv;
	}



	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return scandynabalancelogSrv;
	}

	/**
	 * 获取数据字典267
	 * @return
	 */
	@RequestMapping("267")
	public Object getDictBy267(){
		return JSON.toJSON(scandynabalancelogSrv.getDictBy267());
	}
}
