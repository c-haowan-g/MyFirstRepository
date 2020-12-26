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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Balandproresult;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 质检动平衡检测结果表(国际计测)
 * 
 * @author 刘朋
 * @Date 2019-01-18 15:32:07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BalandproresultServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Balandproresult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getEntCodeName() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("EntCodeName"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public String getEndNameByEntCode(String entCode) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getEndNameByEntCode"));
		query.setParameter("s_factory_s", "1");
		query.setParameter("entCode", entCode);
		String result = null;
		List<Map<String, Object>> list = query.list();
		for(int i = 0; i < list.size(); i++){
			result = list.get(i).get("DESCRIPTION").toString();
		}
		return result;
	}
	
	//导出重写查询
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA1(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows1", filter.getFilter());
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

	public Long datagridTotalUDA1(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total1", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
}
