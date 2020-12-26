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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortAppearanceBeforeLog;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检外观前分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-07 11:38:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortAppearanceBeforeLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SortAppearanceBeforeLog.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
