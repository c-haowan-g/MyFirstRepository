/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanAppearanceLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanAppearanceLogServiceImpl;

/**
 * 质检外观扫描履历表
 * @author 王海霖
 * @Date 2018-09-03 14:27:44
 */
@Log(code="ZJ_ZJGL_ZJWGSMLL",value="质检外观扫描履历表日志")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/scanAppearanceLog")
public class ScanAppearanceLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ScanAppearanceLogServiceImpl scanappearancelogSrv;

    
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}
		return GsonTools.toJson(scanappearancelogSrv.datagridUDA(filter, page));
	}
    
    /**
     * 查询第一个tab页,上方查询区域的机台下拉框
     * @return
     * @throws Exception
     */
    @Log(code="ZJ_BJZL_FJGZ_ENTCODENAME",value="获取机台条码和名称对应关系")
    @RequestMapping("combox_entcode")
   	public String combox_entcode(String spare1_s) throws Exception{
    	List<Map<String,Object>> list=scanappearancelogSrv.getEntCodeName(spare1_s);
   		return toJson(list);
   	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return scanappearancelogSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return scanappearancelogSrv;
	}

}
