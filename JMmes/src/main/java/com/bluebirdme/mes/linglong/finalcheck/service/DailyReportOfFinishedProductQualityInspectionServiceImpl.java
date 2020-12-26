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

import com.bluebirdme.core.system.constants.SessionConstant;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DailyReportOfFinishedProductQualityInspection;

/**
 * 成品质量检查日报表
 * 
 * @author wanghailin
 * @Date 2018-12-3 09:41:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DailyReportOfFinishedProductQualityInspectionServiceImpl extends
RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return DailyReportOfFinishedProductQualityInspection.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
    @SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total2的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		System.out.println(query.getQueryString());
		return query.list();
	}
}
