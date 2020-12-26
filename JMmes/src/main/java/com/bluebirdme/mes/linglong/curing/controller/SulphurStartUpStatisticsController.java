/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.curing.entity.SulphurStartUpStatisticsDetailed;
import com.bluebirdme.mes.linglong.curing.entity.SulphurStartUpStatisticsSummarize;
import com.bluebirdme.mes.linglong.curing.service.SulphurStartUpStatisticsServiceImpl;

/**
 * 硫化开车统计
 * 
 * @author syl
 * @Date 2018-12-12 16:38:24
 */
@Log(code = "SulphurStartUpStatistics", value = "SulphurStartUpStatistics")
@RestController
@RequestMapping("lh/bb/lhkctj")
public class SulphurStartUpStatisticsController extends RockWellFunctionalController<SulphurStartUpStatisticsDetailed> {

	@Resource
	SulphurStartUpStatisticsServiceImpl sulphurstartupstatisticsSrv;

	@Override
	protected RockWellBaseServiceImpl<SulphurStartUpStatisticsDetailed> getService() {
		return sulphurstartupstatisticsSrv;
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping("searchBy") public String searchByEntName(Filter filter,
	 * Page page, Class clazz)throws Exception { Map list =
	 * sulphurstartupstatisticsSrv.datagrid(filter, page,
	 * SulphurStartUpStatisticsATO.class); return toJson(list); }
	 */

	/**
	 * 查询硫化开车统计汇总页面
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy2")
	public String searchByEntName2(Filter filter, Page page, Class clazz) throws Exception {
		Map list = sulphurstartupstatisticsSrv.datagrid2(filter, page, SulphurStartUpStatisticsSummarize.class);
		return toJson(list);
	}

	/**
	 * 查询硫化开车统计详细页面
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy3")
	public String searchByEntName3(Filter filter, Page page, Class clazz) throws Exception {
		Map list = sulphurstartupstatisticsSrv.datagrid3(filter, page, SulphurStartUpStatisticsDetailed.class);
		return toJson(list);
	}

	/**
	 * 机台数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByEquipCode")
	public String searchByModal() {
		List<Map<String, Object>> list = sulphurstartupstatisticsSrv.searchByEquipCode();
		return toJson(list);
	}
	
	/**
	 * 带条件查询全部
	 * 
	 * @return
	 */
	@RequestMapping("searchBy")
	public String searchBy(String start_time,String end_time,String equip_code_s) throws Exception{
		Filter filter = new Filter();
		filter.set("start_time", start_time).set("end_time", end_time).set("equip_code_s", equip_code_s);
		List<Map<String, Object>> list = sulphurstartupstatisticsSrv.datagridRowsUDA(filter);
		return toJson(list);
	}

}
