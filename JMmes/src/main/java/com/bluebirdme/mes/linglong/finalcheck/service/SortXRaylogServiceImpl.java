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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortXRaylog;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检X光分拣履历表
 * 
 * @author lnk
 * @Date 2019-01-04 16:06:03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortXRaylogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SortXRaylog.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
