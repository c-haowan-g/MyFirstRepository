/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;











import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.StatistatementServiceImpl;


/**
 * 质检统计报表
 * @author 徐秉正
 * @Date 2020-07-03 09:31:01
 */
@Log(code="质检统计报表",value="质检统计报表")
@RestController
@RequestMapping("finalcheck/statistatement/statistatement")
public class StatistatementController extends RockWellFunctionalUDAController<Object> {
    
	@Resource
	StatistatementServiceImpl detialSrv;


	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		System.out.println(filter);
		List<Map<String, Object>> list1=detialSrv.appearance(filter, page);
		List<Map<String, Object>> list2=detialSrv.xrayance(filter, page);
		//return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
		//List<Map<String, Object>> list3=list1.addAll(list2);
		//System.out.println("111111111");
		list1.addAll(list2);
		return toJson(list1);
	}
	@RequestMapping("datagrid1")
	public String datagrid1(Filter filter, Page page) throws Exception {
		System.out.println(filter);
		List<Map<String, Object>> list1=detialSrv.appearance1(filter, page);
		List<Map<String, Object>> list2=detialSrv.xrayance1(filter, page);
		//return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
		//List<Map<String, Object>> list3=list1.addAll(list2);
		//System.out.println("111111111");
		list1.addAll(list2);
		return toJson(list1);
	}
	
	
	 @Log(code = "searchUsercode", value = "转换")
	   	@RequestMapping("searchUsercode")
	   	public String searchUsercode(String reas_code) throws Exception {
	   		List<Map<String, Object>> list = detialSrv.searchUsercode(reas_code);
	   		return toJson(list);
	   	} 
	
	 @Log(code = "searchUsercode", value = "转换")
	   	@RequestMapping("searchcode")
	   	public String searchcode() throws Exception {
	   		List<Map<String, Object>> list = detialSrv.searchcode();
	   		return toJson(list);
	   	} 
//	
//	@Log(value = "外观作业查询2", code = "FUNC_0072", target = LogType.CONSOLE)
//	@ResponseBody
//	@RequestMapping("datagrid2")
//	public String datagrid2(Filter filter,Page page) throws Exception {
//		String factoryString=LLWebUtils.factory();
//      	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
//    	filter.set("s_factory_s", factoryString);
//  	   	filter.set("agenc_no_s",factoryCodeString );
////  	   	if(filter.getFilter().containsKey("barcode_s")){
////			filter.set("start_opertime_t","");
////			filter.set("end_opertime_t","");
////		}
//  	   	System.out.println(GsonTools.toJson(detialSrv.datagridUDA(filter, page)));
//		return GsonTools.toJson(detialSrv.datagridUDA(filter, page));
//	}
//

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