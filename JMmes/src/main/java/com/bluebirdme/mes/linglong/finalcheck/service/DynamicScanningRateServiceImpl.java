package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;




import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

import org.springframework.transaction.annotation.Transactional;
/**
 * 动平衡扫描率
 * @author 周清玉
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DynamicScanningRateServiceImpl extends RockWellBaseServiceImpl{
	
	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}


	@Override
	protected boolean useCache() {
		return false;
	}


	@Override
	protected Class getEntity() {
		return null;
	}
	
	
	public List<Map<String, Object>> getAll(Filter filter) {
		List<Map<String, Object>> list=null;
		if(filter.get("entname_s")!=null){
			list=getAll2(filter);
		}else{
			list=getAll1(filter);
		}
		return list;
	}
	public List<Map<String, Object>> getAll1(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAll1"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		System.out.println(LLWebUtils.factory()+"-----------------------我是分割线--------------------");
		List<Map<String, Object>> list = query.list();
		return list;
	}
	public List<Map<String, Object>> getAll2(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAll2"));
		query.setParameter("entname_s", filter.get("entname_s"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}
	
	
	
}
