/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.WorkorderResult;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.MesSapProductionServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 胎胚重量合格率查询
 * 
 * @author 王超
 * @Date 2020-01-16 15:18:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WeightOkRateByCodeServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	// 系统参数获取
	@Resource
	SerialServiceImpl serialSrv;

	@Resource
	LingLongDataSource llds;
	// ERP抛帐表
	@Resource
	MesSapProductionServiceImpl mesSapProductionServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return WorkorderResult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}
	
	
	/**
	 * 按机台和物料查询
	 */
	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> weightParaList = getWeightPara();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			if(map.get("standard_weight_s") == null){
				map.put("max_weight_s", "");
				map.put("min_weight_s", "");
				map.put("weight_ok_s", "");
				map.put("weight_small_s", "");
				map.put("weight_big_s", "");
			}else{
				List<Map<String, Object>> listOkList = new ArrayList<>();
				BigDecimal maxpara = new BigDecimal(weightParaList.get(0).get("valuemax_s").toString().substring(1, weightParaList.get(0).get("valuemax_s").toString().length()));
				BigDecimal minpara = new BigDecimal(weightParaList.get(0).get("valuemin_s").toString().substring(1, weightParaList.get(0).get("valuemin_s").toString().length()));
				BigDecimal valueStandard = new BigDecimal(map.get("standard_weight_s").toString());
				String max = valueStandard.multiply(maxpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				String min = valueStandard.multiply(minpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				if (min.length() < 6) {
					min = '0' + min;
				}
				if (map.get("production_ver_s") != null) {
					listOkList = getOkRateByCode(map.get("equip_code_s").toString(),map.get("material_code_s").toString(),map.get("standard_weight_s").toString(),max,min,map.get("add_flag_s").toString(),filter.get("begintime"),filter.get("endtime"),map.get("production_ver_s").toString(),map.get("material_name_s").toString());
				} else {
					listOkList = getOkRateByCodeP(map.get("equip_code_s").toString(),map.get("material_code_s").toString(),map.get("standard_weight_s").toString(),max,min,map.get("add_flag_s").toString(),filter.get("begintime"),filter.get("endtime"),map.get("material_name_s").toString());
				}
				DecimalFormat df = new DecimalFormat();  
		        df.setMinimumFractionDigits(3);  
		        max = df.format(Double.parseDouble(max)); 
		        min = df.format(Double.parseDouble(min)); 
				map.put("max_weight_s", max);
				map.put("min_weight_s", min);
				map.put("weight_ok_s", listOkList.get(0).get("weight_ok_s"));
				map.put("weight_small_s", listOkList.get(0).get("weight_small_s"));
				map.put("weight_big_s", listOkList.get(0).get("weight_big_s"));
			    float oks = Integer.valueOf(listOkList.get(0).get("weight_ok_s").toString());
				float totals = Integer.valueOf(map.get("total_number_s").toString());
				String rate = oks/totals*100 + "";
				rate = df.format(Double.parseDouble(rate)); 
				map.put("ok_rate_s", rate + "%");
			}
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 按机台查询
	 */
	public Map<String, Object> datagridUDA1(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA1(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA1(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA1(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows1的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows1", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> weightParaList = getWeightPara();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			if(map.get("standard_weight_s") == null){
				map.put("max_weight_s", "");
				map.put("min_weight_s", "");
				map.put("weight_ok_s", "");
				map.put("weight_small_s", "");
				map.put("weight_big_s", "");
			}else{
				List<Map<String, Object>> listOkList = new ArrayList<>();
				BigDecimal maxpara = new BigDecimal(weightParaList.get(0).get("valuemax_s").toString().substring(1, weightParaList.get(0).get("valuemax_s").toString().length()));
				BigDecimal minpara = new BigDecimal(weightParaList.get(0).get("valuemin_s").toString().substring(1, weightParaList.get(0).get("valuemin_s").toString().length()));
				BigDecimal valueStandard = new BigDecimal(map.get("standard_weight_s").toString());
				String max = valueStandard.multiply(maxpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				String min = valueStandard.multiply(minpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				if (min.length() < 6) {
					min = '0' + min;
				}
				listOkList = getOkRateByCode1(map.get("equip_code_s").toString(),map.get("standard_weight_s").toString(),max,min,map.get("add_flag_s").toString(),filter.get("begintime"),filter.get("endtime"));
				DecimalFormat df = new DecimalFormat();  
		        df.setMinimumFractionDigits(3);  
		        max = df.format(Double.parseDouble(max)); 
		        min = df.format(Double.parseDouble(min)); 
				map.put("max_weight_s", max);
				map.put("min_weight_s", min);
				map.put("weight_ok_s", listOkList.get(0).get("weight_ok_s"));
				map.put("weight_small_s", listOkList.get(0).get("weight_small_s"));
				map.put("weight_big_s", listOkList.get(0).get("weight_big_s"));
			    float oks = Integer.valueOf(listOkList.get(0).get("weight_ok_s").toString());
				float totals = Integer.valueOf(map.get("total_number_s").toString());
				String rate = oks/totals*100 + "";
				rate = df.format(Double.parseDouble(rate)); 
				map.put("ok_rate_s", rate + "%");
			}
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA1(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total1的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total1", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
	/**
	 * 按物料查询
	 */
	public Map<String, Object> datagridUDA2(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA2(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA2(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA2(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows2的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> weightParaList = getWeightPara();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			if(map.get("standard_weight_s") == null){
				map.put("max_weight_s", "");
				map.put("min_weight_s", "");
				map.put("weight_ok_s", "");
				map.put("weight_small_s", "");
				map.put("weight_big_s", "");
			}else{
				List<Map<String, Object>> listOkList = new ArrayList<>();
				BigDecimal maxpara = new BigDecimal(weightParaList.get(0).get("valuemax_s").toString().substring(1, weightParaList.get(0).get("valuemax_s").toString().length()));
				BigDecimal minpara = new BigDecimal(weightParaList.get(0).get("valuemin_s").toString().substring(1, weightParaList.get(0).get("valuemin_s").toString().length()));
				BigDecimal valueStandard = new BigDecimal(map.get("standard_weight_s").toString());
				String max = valueStandard.multiply(maxpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				String min = valueStandard.multiply(minpara).setScale(3,BigDecimal.ROUND_HALF_UP).toString();
				if (min.length() < 6) {
					min = '0' + min;
				}
				if (map.get("production_ver_s") != null) {
					listOkList = getOkRateByCode2(map.get("material_code_s").toString(),map.get("standard_weight_s").toString(),max,min,map.get("add_flag_s").toString(),filter.get("begintime"),filter.get("endtime"),map.get("production_ver_s").toString(),map.get("material_name_s").toString());
				} else {
					listOkList = getOkRateByCode2P(map.get("material_code_s").toString(),map.get("standard_weight_s").toString(),max,min,map.get("add_flag_s").toString(),filter.get("begintime"),filter.get("endtime"),map.get("material_name_s").toString());
				}
				DecimalFormat df = new DecimalFormat();  
		        df.setMinimumFractionDigits(3);  
		        max = df.format(Double.parseDouble(max)); 
		        min = df.format(Double.parseDouble(min)); 
				map.put("max_weight_s", max);
				map.put("min_weight_s", min);
				map.put("weight_ok_s", listOkList.get(0).get("weight_ok_s"));
				map.put("weight_small_s", listOkList.get(0).get("weight_small_s"));
				map.put("weight_big_s", listOkList.get(0).get("weight_big_s"));
			    float oks = Integer.valueOf(listOkList.get(0).get("weight_ok_s").toString());
				float totals = Integer.valueOf(map.get("total_number_s").toString());
				String rate = oks/totals*100 + "";
				rate = df.format(Double.parseDouble(rate)); 
				map.put("ok_rate_s", rate + "%");
			}
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA2(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total2的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 查出每种物料对应的重量合格率
	 * @return
	 */
	public List<Map<String, Object>> getOkRateByCode(String equip_code_s, String material_code_s, String standard_weight_s, String max_weight_s, String min_weight_s, String add_flag_s, String begintime, String endtime, String production_ver_s, String material_name_s) {
		SQLQuery query = createSQLQuery(getSQL("getOkRateByCode"));
		query.setParameter("equip_code_s", equip_code_s);
		query.setParameter("material_code_s", material_code_s);
		query.setParameter("standard_weight_s", standard_weight_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		query.setParameter("add_flag_s", add_flag_s);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("begintime", begintime);
		query.setParameter("endtime", endtime);
		query.setParameter("production_ver_s", production_ver_s);
		query.setParameter("material_name_s", material_name_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出每种物料对应的重量合格率
	 * @return
	 */
	public List<Map<String, Object>> getOkRateByCodeP(String equip_code_s, String material_code_s, String standard_weight_s, String max_weight_s, String min_weight_s, String add_flag_s, String begintime, String endtime, String material_name_s) {
		SQLQuery query = createSQLQuery(getSQL("getOkRateByCodeP"));
		query.setParameter("equip_code_s", equip_code_s);
		query.setParameter("material_code_s", material_code_s);
		query.setParameter("standard_weight_s", standard_weight_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		query.setParameter("add_flag_s", add_flag_s);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("begintime", begintime);
		query.setParameter("endtime", endtime);
		query.setParameter("material_name_s", material_name_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出每种物料对应的重量合格率
	 * @return
	 */
	public List<Map<String, Object>> getOkRateByCode1(String equip_code_s, String standard_weight_s, String max_weight_s, String min_weight_s, String add_flag_s, String begintime, String endtime) {
		SQLQuery query = createSQLQuery(getSQL("getOkRateByCode1"));
		query.setParameter("equip_code_s", equip_code_s);
		query.setParameter("standard_weight_s", standard_weight_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		query.setParameter("add_flag_s", add_flag_s);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("begintime", begintime);
		query.setParameter("endtime", endtime);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出每种物料对应的重量合格率
	 * @return
	 */
	public List<Map<String, Object>> getOkRateByCode2(String material_code_s, String standard_weight_s, String max_weight_s, String min_weight_s, String add_flag_s, String begintime, String endtime, String production_ver_s, String material_name_s) {
		SQLQuery query = createSQLQuery(getSQL("getOkRateByCode2"));
		query.setParameter("material_code_s", material_code_s);
		query.setParameter("standard_weight_s", standard_weight_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		query.setParameter("add_flag_s", add_flag_s);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("begintime", begintime);
		query.setParameter("endtime", endtime);
		query.setParameter("production_ver_s", production_ver_s);
		query.setParameter("material_name_s", material_name_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出每种物料对应的重量合格率
	 * @return
	 */
	public List<Map<String, Object>> getOkRateByCode2P(String material_code_s, String standard_weight_s, String max_weight_s, String min_weight_s, String add_flag_s, String begintime, String endtime, String material_name_s) {
		SQLQuery query = createSQLQuery(getSQL("getOkRateByCode2P"));
		query.setParameter("material_code_s", material_code_s);
		query.setParameter("standard_weight_s", standard_weight_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		query.setParameter("add_flag_s", add_flag_s);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("begintime", begintime);
		query.setParameter("endtime", endtime);
		query.setParameter("material_name_s", material_name_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查询胎胚公差参数
	 * @return
	 */
	public List<Map<String, Object>> getWeightPara() {
		SQLQuery query = createSQLQuery(getSQL("getWeightPara"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("parmname_s", "TC000074");
		} else {
			query.setParameter("parmname_s", "TC000632");
		}
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
}
