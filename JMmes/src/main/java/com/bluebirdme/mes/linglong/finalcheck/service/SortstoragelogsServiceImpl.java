package com.bluebirdme.mes.linglong.finalcheck.service;

/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.finalcheck.entity.SortStorageLogs;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检入库分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-07 14:24:38
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortstoragelogsServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SortStorageLogs.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
