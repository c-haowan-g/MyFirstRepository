/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.text.MessageFormat;
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
import com.bluebirdme.mes.linglong.curing.entity.CuringMainTyre;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 轮胎综合管理
 * 
 * @author qingyu_zhou
 * @Date 2018-08-10 08:25:07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MainTyreServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CuringMainTyre.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 外观一次交检查询方法
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> datagridappearanceonetimecheckrate(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page));
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
	public List<Map<String, Object>> datagridRows2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass()
					+ MessageFormat.format(".xml中未找到ID为{0}的SQL语句定义", "datagrid_CuringAndAppearanceDatarows"));

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
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

	/**
	 * 硫化外观合格率查询
	 * 
	 * @author 方漠林
	 * @date 2018-12-14 8:59:20
	 * @param filter
	 *            筛选条件
	 * @param page
	 *            分页实体类
	 * @param clazz
	 *            实体类类型
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> dataGridCuringAndAppearanceQualifiMap(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridCuringAndAppearanceRows(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridCuringAnadAppearanceLongTotal(filter, page));

		return ret;
	}

	/**
	 * 获取硫化终检合格率查询数据的行数量
	 * 
	 * @author 方漠林
	 * @date 2018-12-14 9:17:20
	 * @param filter
	 *            查询条件
	 * @param page
	 *            分页实体类
	 * @return 行的总和
	 * @throws Exception
	 */
	public Long datagridCuringAnadAppearanceLongTotal(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_CuringAndAppearanceTotal") == null)
			throw new Exception(getClass()
					+ MessageFormat.format(".xml中未找到ID为{0}的SQL语句定义", "datagrid_CuringAndAppearanceTotal"));
		String totalSql = getSQL("datagrid_CuringAndAppearanceTotal", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 获取硫化终检合格率查询数据
	 * 
	 * @author 周清玉
	 * @date 2019-08-12 9:17:20
	 * @param filter
	 *            查询条件
	 * @param page
	 *            分页实体类
	 * @param clazz
	 *            查询的实体数据类型
	 * @return 行的总和
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridCuringAndAppearanceRows(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_CuringAndAppearanceDatarows") == null)
			throw new Exception(getClass()
					+ MessageFormat.format(".xml中未找到ID为{0}的SQL语句定义", "datagrid_CuringAndAppearanceDatarows"));

		String dataSql = getSQL("datagrid_CuringAndAppearanceDatarows", filter.getFilter());
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
