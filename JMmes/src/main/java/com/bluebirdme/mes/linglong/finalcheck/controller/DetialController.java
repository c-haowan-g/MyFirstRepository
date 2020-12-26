/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.DetialServiceImpl;

/**
 * 首模检测查询+外观作业履历查询
 * 
 * @author whl
 * @Date 2018-08-07 17:18:05
 */
@Log(code = "AT_D_EM_Detial", value = "外观作业查询")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/appearanceOperatingDetial")
public class DetialController extends RockWellFunctionalUDAController<Object> {

	@Resource
	DetialServiceImpl detialSrv;


	
	
	@Log(value = "外观作业查询2", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid2")
	public String datagrid2(Filter filter,Page page) throws Exception {
		String factoryString=LLWebUtils.factory();
      	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
    	filter.set("s_factory_s", factoryString);
  	   	filter.set("agenc_no_s",factoryCodeString );
  	   	if(filter.getFilter().containsKey("barcode_s")){
			filter.set("start_opertime_t","");
			filter.set("end_opertime_t","");
		}
  	   	System.out.println(GsonTools.toJson(detialSrv.datagridUDA(filter, page)));
		return GsonTools.toJson(detialSrv.datagridUDA(filter, page));
	}
	 @Override
	    @Log(code = "外观作业履历", value = "返修品查询")
		@ResponseBody
		@RequestMapping("fanxiuSearch")
		public String datagridUDA(Filter filter, Page page) throws Exception {
	    	Map map = detialSrv.datagridUDA1(filter, page);
			return toJson(map);
		}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return detialSrv;
	}


	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return detialSrv;
	}

}
