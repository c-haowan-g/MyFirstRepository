/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.PlanDayParameter;

/**
 * 日计划信息（用于工艺参数设置页面）
 * 
 * @author 周清玉
 * @Date 2019-07-15 08:33:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PlanDayParameterServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return PlanDayParameter.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
