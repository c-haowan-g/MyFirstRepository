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
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.CuringAlarmCountAll;

/**
 * 质量降级汇总表
 * 
 * @author 周志祥
 * @Date 2019-03-19 08:57:05
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringAlarmCountServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CuringAlarmCountAll.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
