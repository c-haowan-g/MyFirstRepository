/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

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
import com.bluebirdme.mes.linglong.finalcheck.entity.Detial;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 首模检测查询
 * 
 * @author whl
 * @Date 2018-08-07 17:18:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DetialServiceImpl extends RockWellUDABaseServiceImpl<Object> {

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


	@SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
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

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {

		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		return query.list();
	}

	//查询返修品
	public Map<String, Object> datagridUDA1(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsGroupUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalGroupUDA(filter, page));
		return ret;

	}
    
    @SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsGroupUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridgroupUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridgroupUDA_rows的SQL语句定义");

//		String sfs = "";
//		if (LLWebUtils.factory().equals("1")) {
//			sfs = "%半钢%";
//		} 
//		if (LLWebUtils.factory().equals("2")) {
//			sfs = "%全钢%";
//		}
//		filter.set("sfs", sfs);
		String dataSql = getSQL("datagridgroupUDA_rows", filter.getFilter());
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

	public Long datagridTotalGroupUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridgroupUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridgroupUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridgroupUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
}
