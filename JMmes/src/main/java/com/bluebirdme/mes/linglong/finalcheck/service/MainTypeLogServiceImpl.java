/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 轮胎主表(终检蓝英接口同步历史履历)
 * 
 * @author 时永良
 * @Date 2019-05-13 10:15:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MainTypeLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return null;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
}
