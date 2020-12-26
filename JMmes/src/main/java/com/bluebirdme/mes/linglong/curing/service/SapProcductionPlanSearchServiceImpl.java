/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

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
import com.bluebirdme.mes.linglong.curing.entity.SapProcductionPlanSearch;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 硫化月计划查询
 * @author 时永良
 * @Date 2018-08-25 10:00:04
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SapProcductionPlanSearchServiceImpl extends RockWellBaseServiceImpl<SapProcductionPlanSearch> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SapProcductionPlanSearch.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    
    @SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows(Filter filter, Page page, Class<K> clazz) throws Exception {
    	if(filter.get("month_i")!=null&&filter.get("month_i")!=""){
    		String month_i=	filter.get("month_i");
        	filter.set("month_i", month_i.replace("-", ""));
    	}  	
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
		if (getSQL("datagrid_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
		String dataSql = getSQL("datagrid_rows", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
			List<Map<String,Object>> list =query.list();
		return query.list();
	}

}
