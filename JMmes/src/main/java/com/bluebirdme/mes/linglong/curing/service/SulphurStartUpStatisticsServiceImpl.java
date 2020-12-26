/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.SulphurStartUpStatisticsDetailed;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 硫化开车统计
 * 
 * @author syl
 * @Date 2018-12-12 16:43:15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SulphurStartUpStatisticsServiceImpl extends RockWellBaseServiceImpl<SulphurStartUpStatisticsDetailed> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SulphurStartUpStatisticsDetailed.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 机台数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByEquipCode() {
		SQLQuery query = createSQLQuery(getSQL("equipCode"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("record_flag_s", "A");
		return query.list();
	}

	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (clazz == null) {
			clazz = getEntity();
		}

		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		System.out.println(datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
		System.out.println(dataSql);
		System.out.println(LLWebUtils.factory());
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);
		
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total2的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	public Map<String, Object> datagrid3(Filter filter, Page page, Class clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (clazz == null) {
			clazz = getEntity();
		}

		if (!filter.getFilter().containsKey(FACTORY)) {

			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows3(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal3(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows3(Filter filter, Page page, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {

			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		System.out.println(LLWebUtils.factory());
		if (getSQL("datagrid_rows3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows3的SQL语句定义");

		String dataSql = getSQL("datagrid_rows3", filter.getFilter());
		System.out.println(filter);
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	public Long datagridTotal3(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total3的SQL语句定义");

		String totalSql = getSQL("datagrid_total3", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter) throws Exception {
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
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