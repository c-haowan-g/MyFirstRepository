/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.finalcheck.entity.Detial;


import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 质检统计报表
 * @author 徐秉正
 * @Date 2020-07-03 09:31:01
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StatistatementServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Detial.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 转换
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchUsercode(String reas_code) {
		SQLQuery query =  createSQLQuery(getSQL("searchUsercode"));
		query.setParameter("reas_code", reas_code);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchcode()throws Exception{
    	
    	SQLQuery query = createSQLQuery(getSQL("searchcode"));
    	//query.setParameter("reas_code", reas_code);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
    
	
	
//	@SuppressWarnings("unchecked")
//	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {
//
//		Map<String, Object> ret = new HashMap<String, Object>();
//
//		ret.put("rows", datagridRows2(filter, page, clazz));
//		filter.setOrder(null);
//		filter.setSort(null);
//		ret.put("total", datagridTotal2(filter, page));
//
//		return ret;
//	}
//
//	public Long datagridTotal2(Filter filter, Page page) throws Exception {
//
//		if (getSQL("datagrid_total2") == null)
//			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total2的SQL语句定义");
//
//		String totalSql = getSQL("datagrid_total2", filter.getFilter());
//
//		if (page.getTotalRows() == 0L) {
//
//			SQLQuery query = getSession().createSQLQuery(totalSql);
//
//			setParameter(query, filter);
//
//			return ((BigDecimal) query.uniqueResult()).longValue();
//		} else {
//			return page.getTotalRows();
//		}
//	}
//
//	@SuppressWarnings({ "unchecked" })
//	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {
//
//		if (getSQL("datagrid_rows2") == null)
//			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");
//
//		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
//
//		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);
//
//		setParameter(query, filter);
//
//		if (page.getAll() == 0) {
//			query.setMaxResults(page.getRows());
//			query.setFirstResult((page.getPage() - 1) * page.getRows());
//		}
//		return query.list();
//	}

	public Map<String, Object> appear(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", appearance(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", appertotalance(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> appearance(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid1_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid1_rows的SQL语句定义");

		String dataSql = getSQL("datagrid1_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
	public Long appertotalance(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid1_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid1_total的SQL语句定义");

		String totalSql = getSQL("datagrid1_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
	
	public Map<String, Object> xray(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", xrayance(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", xraytotalance(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> xrayance(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid2_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid2_rows的SQL语句定义");

		String dataSql = getSQL("datagrid2_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
	public Long xraytotalance(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid2_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid2_total的SQL语句定义");

		String totalSql = getSQL("datagrid2_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	//详细
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> appearance1(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid3_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid1_rows的SQL语句定义");

		String dataSql = getSQL("datagrid3_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
   //x光
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> xrayance1(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid4_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid2_rows的SQL语句定义");

		String dataSql = getSQL("datagrid4_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

}