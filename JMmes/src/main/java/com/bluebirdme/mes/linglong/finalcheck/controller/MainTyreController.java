/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.MainTyreServiceImpl;

/**
 * 轮胎主表
 * @author 周清玉	
 * @Date 2018-09-12 17:58:15
 */
@Log(code="AT_C_MM_Curing_MainTyre_Log",value="轮胎主表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/curing")
public class MainTyreController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MainTyreServiceImpl maintyreSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return maintyreSrv;
    }
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return maintyreSrv;
	}

    
    
    @Log(value = "外观一次交检查询方法", code = "appearanceonetimecheckrate", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridappearanceonetimecheckrate")
	public String appearanceonetimecheckrate(Filter filter,Page page) throws Exception {
		String factoryString=LLWebUtils.factory();
      	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
    	filter.set("s_factory_s", factoryString);
  	   	filter.set("agenc_no_s",factoryCodeString );
		return GsonTools.toJson(maintyreSrv.datagridappearanceonetimecheckrate(filter, page));
	}
    
    @Log(value = "硫化外观合格率报表查询方法", code = "getCuringAndAppearanceQualification", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("getCuringAndAppearanceQualification")
  	public String getCuringAndAppearanceQualification(Filter filter,Page page) throws Exception {
        filter.set("s_factory_s", LLWebUtils.factory());
    	filter.set("agenc_no_s",FactoryConstant.JING_MEN_CODE);
  		return GsonTools.toJson(maintyreSrv.dataGridCuringAndAppearanceQualifiMap(filter, page));
  	}

    @RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page)
  			throws Exception {
  		if(filter.getFilter().containsKey("barcode_s")){
  			filter.set("begin_created_time","");
  			filter.set("end_created_time","");
  		}
  		return GsonTools.toJson(maintyreSrv.datagridUDA(filter, page));
  	}


}
