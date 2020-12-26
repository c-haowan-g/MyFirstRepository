/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;


import java.math.BigDecimal;
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
import com.bluebirdme.mes.linglong.curing.entity.VulcanizationGradeYieldPrint;
import com.bluebirdme.mes.linglong.curing.entity.dto.WorkOrderResultParam;

/**
 * 硫化工单生产实绩表
 * @author 王海霖
 * @Date 2018-11-10 11:17:18
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VulcanizationGradeYieldPrintServiceImpl extends RockWellBaseServiceImpl<VulcanizationGradeYieldPrint> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected Class getEntity() {
        return VulcanizationGradeYieldPrint.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
   /**
    * 获取弹窗数据
    * @param filter
    * @param page
    * @return
    * @throws Exception
    */
    @SuppressWarnings("unchecked")
	public List<WorkOrderResultParam> getProductionDayPlanByParamter(Filter filter, Page page)throws Exception{
    	filter.set("s_factory_s", LLWebUtils.factory());
    	SQLQuery query=createSQLQuery(getSQL("datagrid_rows2", filter),WorkOrderResultParam.class);
    	setParameter(query,filter);
    	return query.list();
    }
    
    /**
     * 获取数据
     */
	@SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page, @SuppressWarnings("rawtypes") Class clazz) throws Exception {

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
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}
	/**
	 * 需查找数据
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
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
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
		
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}
	/**
	 * 数据总条数
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

}
