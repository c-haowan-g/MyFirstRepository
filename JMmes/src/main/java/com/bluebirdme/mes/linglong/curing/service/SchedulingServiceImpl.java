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

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.Scheduling;

/**
 * 人员排班查询
 * 
 * @author 时永良
 * @Date 2018-08-020 14:39:09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SchedulingServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Scheduling.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 
	 * @Title: getEqu
	 * @Description: TODO(未领用机台)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getEqu() {
		SQLQuery query = createSQLQuery(getSQL("getEqu"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}
}
