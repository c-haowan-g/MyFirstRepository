package com.bluebirdme.mes.linglong.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 抽象出业务的公共方法
 * 
 * @author qingyu_zhou
 * @param <T>
 */
public abstract class RockWellUDABaseServiceImpl<T> extends RockWellBaseServiceImpl<Object> {

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

	/**
	 * 多个ID字符串，逗号分割，批量删除
	 * 
	 * @param ids
	 * @RockWellTransactional
	 * @SuppressWarnings("unchecked") public void deleteUDA(String ids,Class<?>
	 *                                clazz) { RockWellUtils.delete(clazz, ids);
	 *                                }
	 * @RockWellTransactional public void deleteUDA(List<T> list) throws
	 *                        IllegalArgumentException, IllegalAccessException,
	 *                        NoSuchFieldException, SecurityException { T obj =
	 *                        null; StringBuffer sb = new StringBuffer(); int i
	 *                        = 0; for (T t : list) { sb.append((i++ == 0 ? "" :
	 *                        ",") + ReflectUtils.getFieldValue(t, idField()));
	 *                        obj = t; }
	 *                        this.deleteUDA(sb.toString(),obj.getClass()); }
	 */

}
