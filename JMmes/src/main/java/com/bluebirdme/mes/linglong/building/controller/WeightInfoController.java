/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.building.entity.dto.UpdateWorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.entity.dto.WorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.service.WeightInfoServiceImpl;
import com.bluebirdme.mes.linglong.building.service.WorkorderResultServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 成型胎胚重量合格率（机台）
 * 
 * @author 栾和源
 * @Date 2020-01-15 11:22:25
 */
@Log(code = "成型生成实绩查询", value = "成型生成实绩查询")
@RestController
@RequestMapping("building/productionManagement/weightInfo")
public class WeightInfoController extends RockWellFunctionalUDAController<Object> {

	@Resource
	WeightInfoServiceImpl weightinfoSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return weightinfoSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return weightinfoSrv;
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 *             
	 */
	@Log(code = "WorkorderResult_searchInit", value = "查询全部 页面初始化使用")
	@RequestMapping("searchInit")
	public String searchInit(Filter filter, Page page) throws Exception {
		Map map = weightinfoSrv.datagridUDA(filter, page);
		return toJson(map);
	}

	
	
	/**
	 * 通过工艺配方查出胎胚重量公差参数
	 * 
	 * @return
	 */
	@Log(code = "getWeightData", value = "通过工艺配方查出胎胚重量公差参数")
	@RequestMapping("getWeightData")
	public String getWeightData() throws Exception {
		List<Map<String, Object>> list = weightinfoSrv.getWeightData();
		return toJson(list);
	}
	
	
	/**
	 * 统计胎坯重量合格率
	 * 
	 * @return
	 */
	@Log(code = "getWeightPercent", value = "统计胎坯重量合格率")
	@RequestMapping("getWeightPercent")
	public String getWeightPercent(@RequestParam String begin_time,@RequestParam String end_time,@RequestParam String equip_code_s,@RequestParam String material_code_s,@RequestParam String max_weight_s,@RequestParam String min_weight_s) throws Exception {
		List<Map<String, Object>> list = weightinfoSrv.getWeightPercent(begin_time,end_time,equip_code_s, material_code_s,  max_weight_s, min_weight_s);
		
		return toJson(list);
	}


	/**
	 * 根据物料编码查物料名称
	 * 
	 * @return
	 */
	@Log(code = "getMaterialName", value = "统计胎坯重量合格率")
	@RequestMapping("getMaterialName")
	public String getMaterialName(@RequestParam String begin_time,@RequestParam String end_time,@RequestParam String material_code_s) throws Exception {
		List<Map<String, Object>> list = weightinfoSrv.getMaterialName(begin_time,end_time,material_code_s);
		
		return toJson(list);
	}
	


}
