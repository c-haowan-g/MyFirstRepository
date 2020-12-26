/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.constants.SessionConstant;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResultPrint;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 轮胎综合管理
 * 
 * @author wanghaililn
 * @Date 2018-08-10 08:25:07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DynaBalanceCheResultPrintServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return DynaBalanceCheResultPrint.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	
	

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getGradeNum(String beginTime, String endTime, String curingspeccode_s,
			String entbarcode_s) throws Exception {
		Filter filter = new Filter();
		filter.set("begin_created_time", beginTime);
		filter.set("end_created_time", endTime);
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("curingspeccode_s", curingspeccode_s);
		filter.set("entbarcode_s", entbarcode_s);

		SQLQuery query = createSQLQuery(getSQL("getGradeNum", filter.getFilter()));
		query.setParameter("begin_created_time", filter.get("begin_created_time"));
		query.setParameter("end_created_time", filter.get("end_created_time"));
		query.setParameter("s_factory_s", filter.get("s_factory_s"));
		if (curingspeccode_s != "") {
			query.setParameter("curingspeccode_s", filter.get("curingspeccode_s"));
		}
		if (entbarcode_s != "") {
			query.setParameter("entbarcode_s", filter.get("entbarcode_s"));
		}

		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 封装的datagrid数据
	 * 
	 * @Title: getdata
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("null")
	public List<Map<String, Object>> getdata(String beginTime, String endTime, String curingspeccode_s,
			String entbarcode_s) throws Exception {
		Filter filter = new Filter();
		filter.set("begin_created_time", beginTime);
		filter.set("end_created_time", endTime);
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("curingspeccode_s", curingspeccode_s);
		filter.set("entbarcode_s", entbarcode_s);

		SQLQuery query1 = createSQLQuery(getSQL("datagrid_rows", filter.getFilter()));
		query1.setParameter("begin_created_time", filter.get("begin_created_time"));
		query1.setParameter("end_created_time", filter.get("end_created_time"));
		query1.setParameter("s_factory_s", filter.get("s_factory_s"));
		if (curingspeccode_s != "") {
			query1.setParameter("curingspeccode_s", filter.get("curingspeccode_s"));
		}
		if (entbarcode_s != "") {
			query1.setParameter("entbarcode_s", filter.get("entbarcode_s"));
		}

		SQLQuery query2 = createSQLQuery(getSQL("getGradeNum", filter.getFilter()));
		query2.setParameter("begin_created_time", filter.get("begin_created_time"));
		query2.setParameter("end_created_time", filter.get("end_created_time"));
		query2.setParameter("s_factory_s", filter.get("s_factory_s"));
		if (curingspeccode_s != "") {
			query2.setParameter("curingspeccode_s", filter.get("curingspeccode_s"));
		}
		if (entbarcode_s != "") {
			query2.setParameter("entbarcode_s", filter.get("entbarcode_s"));
		}
		List<Map<String, Object>> list1 = query1.list();
		List<Map<String, Object>> list2 = query2.list();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// Map<String, Object> map;
		for (int i = 0; i < list1.size(); i++) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			// 给map初始化，目的是为规定map元素排列顺序，以及为空数据赋0
			map.put("dynamicbalancembarcode_s", list1.get(i).get("DYNAMICBALANCEMBARCODE_S"));
			map.put("curingspeccode_s", list1.get(i).get("CURINGSPECCODE_S"));
			map.put("materialdesc_s", list1.get(i).get("MATERIALDESC_S"));
			map.put("speccount", list1.get(i).get("SPECCOUNT"));
			map.put("acount", 0);
			map.put("a0count", 0);
			map.put("a1count", 0);
			map.put("a2count", 0);
			map.put("a3count", 0);
			map.put("a4count", 0);
			map.put("aRate", 0);// A级品率
			map.put("fpcount", 0);
			map.put("erjcount", 0);
			for (int j = 0; j < list2.size(); j++) {

				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253007")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("acount", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253008")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("a0count", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253009")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("a1count", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253010")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("a2count", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253011")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("a3count", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253014")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("a4count", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253012")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("fpcount", list2.get(j).get("SPECCOUNT"));
				}
				if (list1.get(i).get("CURINGSPECCODE_S").equals(list2.get(j).get("CURINGSPECCODE_S"))
						&& list2.get(j).get("DYNAMICBALANCEGRADECODE_S").equals("253006")
						&& list1.get(i).get("DYNAMICBALANCEMBARCODE_S")
								.equals(list2.get(j).get("DYNAMICBALANCEMBARCODE_S"))) {
					map.put("erjcount", list2.get(j).get("SPECCOUNT"));
				}
				// A级品率计算
				Double aRate = (Double.parseDouble(map.get("acount").toString())
						+ Double.parseDouble(map.get("a1count").toString())
						+ Double.parseDouble(map.get("a2count").toString())
						+ Double.parseDouble(map.get("a3count").toString()) + Double.parseDouble(map.get("a4count")
						.toString())) / Double.parseDouble(map.get("speccount").toString());
				DecimalFormat df = new DecimalFormat("0.00");
				map.put("aRate", df.format(aRate * 100) + "%");
			}
			list.add(map);
		}

		return list;
	}
	
	
	
	 /**
		 * 查询机台，下拉框 根据设备类型查询终检设备 BY 时永良（用于动平衡检测结果汇总机台下拉列表）
		 * 
		 * @Title: SearchEnt
		 * @Description: TODO(描述)
		 * @return: List<Map<String,Object>> 返回类型
		 * 
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> SearchEnt() throws Exception {
			SQLQuery query = createSQLQuery(getSQL("SearchEnt"));
			query.setParameter("s_factory_s", LLWebUtils.factory());
			List<Map<String, Object>> list = query.list();
			return list;
		}
		
		 /**
		 * BY 时永良（根据机台查询其中文名称）
		 * 
		 * @Title: SearchEnt
		 * @Description: TODO(描述)
		 * @return: List<Map<String,Object>> 返回类型
		 * 
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> SearchDescription(String barcode) throws Exception {
			SQLQuery query = createSQLQuery(getSQL("SearchDescription"));
			query.setParameter("s_factory_s", LLWebUtils.factory());
			query.setParameter("barcode", barcode);
			List<Map<String, Object>> list = query.list();
			return list;
		}
		
		
		
		
		
		
		
		@SuppressWarnings("null")
		public Map<String, Object> filter(Filter filter, Page page, List<String> sumFlag) throws Exception {
			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("rows", getRows(filter, page, sumFlag));
			ret.put("total", getTotal(filter, page, sumFlag));
			return ret;
		}
		
		@SuppressWarnings({ "unchecked" })
		public List<Map<String, Object>> getRows(Filter filter, Page page, List<String> sumFlag) throws Exception {

			if(sumFlag.contains("curingmachinecode_s")){
				filter.set("curingmachinecode_s", "curingmachinecode_s");
			}
			if(sumFlag.contains("buildinmachinecode_s")){
				filter.set("buildinmachinecode_s", "buildinmachinecode_s");
			}
			if(sumFlag.contains("dynaBalancemachinecode_s")){
				filter.set("dynaBalancemachinecode_s", "dynaBalancemachinecode_s");
			}
			SQLQuery query = createSQLQuery(getSQL("getRows",filter.getFilter()));
			setParameter(query, filter);
			if (page.getAll() == 0) {
				query.setMaxResults(page.getRows());
				query.setFirstResult((page.getPage() - 1) * page.getRows());
			}
			List<Map<String, Object>> listMap = query.list();
			List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> orgMap : listMap) {
				Map<String, Object> map = new HashMap<>();
				map = TransformUpperCase.transformUpperCase(orgMap);
				returnlist.add(map);
			}
			return returnlist;
		}
		
		public Long getTotal(Filter filter, Page page, List<String> sumFlag) throws Exception {

			if(sumFlag.contains("curingmachinecode_s")){
				filter.set("curingmachinecode_s", "curingmachinecode_s");
			}
			if(sumFlag.contains("buildinmachinecode_s")){
				filter.set("buildinmachinecode_s", "buildinmachinecode_s");
			}
			if(sumFlag.contains("dynaBalancemachinecode_s")){
				filter.set("dynaBalancemachinecode_s", "dynaBalancemachinecode_s");
			}
			if (page.getTotalRows() == 0L) {
				SQLQuery query = getSession().createSQLQuery(getSQL("getTotal",filter.getFilter()));
				setParameter(query, filter);
				return ((BigDecimal) query.uniqueResult()).longValue();
			} else {
				return page.getTotalRows();
			}
		}
}
