/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.SapReturnResultServiceImpl;

/**
 * 硫化冲产表
 * 
 * @author 时永良
 * @Date 2019-03-26 13:31:11
 */
@Log(code = "AT_C_MM_SAPRETURNRESULT_LOG", value = "硫化冲产表")
@RestController
@RequestMapping("curing/ProductionManagement/sap_return_result")
public class SapReturnResultController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SapReturnResultServiceImpl sapreturnresultSrv;

	// 系统参数获取
	@Resource
	SerialServiceImpl serialSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sapreturnresultSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sapreturnresultSrv;
	}

	/**
	 * 对应硫化与SAP集成报产第三个按钮，冲产固化，查询
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchReplenishData")
	public String searchReplenishData(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("agenc_no_s", LLConstant.JING_MEN_CODE);
		Map list = sapreturnresultSrv.searchReplenishData(filter, page);
		return toJson(list);
	}

	/**
	 * 对应硫化与SAP集成报产第三个按钮，冲产固化，固化
	 * 
	 * @param rockWellEntityDTO
	 * @return
	 * @throws Exception
	 */
	@Log(code = "AT_C_MM_SAPRETURNRESULT_LOG_GUHUA", value = "保存固化数据", target = LogType.DB)
	@RequestMapping(value = "guhua")
	public Response saveChanges(@RequestBody Map<String, Object> rockWellEntityDTO) throws Exception {
		String message=sapreturnresultSrv.guhua(rockWellEntityDTO);
		return Response.error(Response.SYS_EXCEPTION,message,null);
	}
     
	/**
	 * 对应硫化与SAP集成报产第三个按钮，冲产固化，明细
	 * @param beginTime
	 * @param endTime
	 * @param lineCode
	 * @return
	 * @throws Exception 
	 */
	@Log(code="AT_C_MM_SAPRETURNRESULT_LOG_DETAIL",value="硫化冲产明细查询",target=LogType.DB)
	@RequestMapping("productionDetail")
	public String productionDetail(@RequestBody Map<String,Object> workOrderResultReportDTO) throws Exception {
		List<Map<String,Object>> list=sapreturnresultSrv.productionDetail(workOrderResultReportDTO);
		return toJson(list);
	}
	/**
	 * 报工单号
	 * 
	 * @param code
	 *            报工单代码
	 * @param type
	 *            报工类型
	 * @return
	 */
	@Log(code = "AT_C_MM_SAPRETURNRESULT_CODE", value = "查询报工单号", target = LogType.DB)
	@RequestMapping(value = "code", method = RequestMethod.POST)
	public String getWorkOrderCode(String q, String type) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map;

		List<Object> codes = sapreturnresultSrv.getWorkOrderCode(q, type);
		map = new HashMap<String, Object>();
		try {
			String serialno = serialSrv.serial("BUILDINGNUM");
			map.put("text", serialno);
			map.put("value", serialno);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // serial():产生报产流水号方法
		/*
		 * if(codes==null||codes.size()==0){ map.put("text", "LZMES"+new
		 * SimpleDateFormat("YYYYMMdd").format(new Date())+"0001");
		 * map.put("value", "LZMES"+new SimpleDateFormat("YYYYMMdd").format(new
		 * Date())+"0001"); list.add(map); }
		 */
		/*
		 * for(Object o:codes){ //map=new HashMap<String, Object>();
		 * map.put("text", o); map.put("value", o); list.add(map); }
		 */

		return toJson(list);
	}

	@RequestMapping(value = "guhua", method = RequestMethod.GET)
	public Response guhuaData(String beginTime, String endTime, String material_code_s) throws Exception {
		return Response.suc(sapreturnresultSrv.guhuaData(beginTime, endTime, material_code_s));
	}
}
