/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.ArrayList;
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
import com.bluebirdme.mes.linglong.curing.entity.Alertinformation;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 硫化机台报警查询(设备报警信息表)
 * 
 * @author 时永良
 * @Date 2018-12-21 09:12:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AlertinformationServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Alertinformation.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	
	/**
	 * 根据病象编号查询病象名称
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getReasNameByCode(String reas_code) {
		SQLQuery query = createSQLQuery(getSQL("getReasNameByCode"));
		query.setParameter("reas_code", reas_code);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

}
