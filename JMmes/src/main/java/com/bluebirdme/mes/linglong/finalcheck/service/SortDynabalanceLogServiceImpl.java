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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortDynabalanceLog;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检动平衡分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-04 16:17:10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortDynabalanceLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SortDynabalanceLog.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
