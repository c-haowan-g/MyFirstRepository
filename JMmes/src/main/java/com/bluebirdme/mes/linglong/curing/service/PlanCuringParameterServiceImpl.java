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
import com.bluebirdme.mes.linglong.curing.entity.PlanCuringParameter;

/**
 * 页面名称:工艺参数查询
 * 
 * @author wanghalin
 * @Date 2018-09-04 18:37:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PlanCuringParameterServiceImpl extends
		RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return PlanCuringParameter.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 通过品号查询参数
	 * 
	 * @Title: getParameterBySapmat_s
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getParameterBySapmat_s(String sapmat_s)
			throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getParameterBySapmat_s"));
		query.setParameter("sapmat_s", sapmat_s);
		return query.list();
	}
	
	
	/**
	 * 获取色标线对应关系
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getColorMarkingLine()
			throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getColorMarkingLine"));
		return query.list();
	}
}
