/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.WeightOkRateByCodeServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 胎胚重量合格率查询
 * 
 * @author 王超
 * @Date 2020-01-16 15:15:30
 */
@Log(code = "胎胚重量合格率查询", value = "胎胚重量合格率查询")
@RestController
@RequestMapping("building/productionManagement/weightOkRateByCode")
public class WeightOkRateByCodeController extends RockWellFunctionalUDAController<Object> {

	@Resource
	WeightOkRateByCodeServiceImpl weightokratebycodeSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return weightokratebycodeSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return weightokratebycodeSrv;
	}

	/**
	 * 按机台和物料查询
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 王超
	 */
	@Log(code = "WeightOkRateByCode_searchInit1", value = "查询全部页面初始化使用")
	@RequestMapping("searchInit1")
	public String searchInit1(Filter filter, Page page) throws Exception {
		Map map = weightokratebycodeSrv.datagridUDA(filter, page);
		return toJson(map);
	}
	
	/**
	 * 按机台查询
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 王超
	 */
	@Log(code = "WeightOkRateByCode_searchInit2", value = "查询全部页面初始化使用")
	@RequestMapping("searchInit2")
	public String searchInit2(Filter filter, Page page) throws Exception {
		Map map = weightokratebycodeSrv.datagridUDA1(filter, page);
		return toJson(map);
	}
	
	/**
	 * 按物料拆查询
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 王超
	 */
	@Log(code = "WeightOkRateByCode_searchInit3", value = "查询全部页面初始化使用")
	@RequestMapping("searchInit3")
	public String searchInit3(Filter filter, Page page) throws Exception {
		Map map = weightokratebycodeSrv.datagridUDA2(filter, page);
		return toJson(map);
	}
	
}
