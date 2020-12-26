/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringRepairStatistics;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
/**
 * 硫化返修统计
 * @author 葛迎祥
 * @Date 2020-04-09 16:13:18
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CuringRepairStatisticsServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return CuringRepairStatistics.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
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
    public Map<String, Object> datagridUDA3(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA3(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA3(filter, page));
		return ret;
	}
    
    @SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA3(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows3的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows3", filter.getFilter());
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

	public Long datagridTotalUDA3(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_total3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total3的SQL语句定义");
		String totalSql = getSQL("datagridUDA_total3", filter.getFilter());
		
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
}
