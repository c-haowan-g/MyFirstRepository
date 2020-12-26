package com.bluebirdme.mes.linglong.curing.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.curing.entity.ControlDetail;

@Service
@Transactional(rollbackFor = Exception.class)
public class ControlDetailService extends RockWellBaseServiceImpl<ControlDetail>{

	@Resource
	LingLongDataSource llds;

	@Override
	protected Class getEntity() {
		return ControlDetail.class;
	}
	
	@Override
	protected Session getSession() {
		return llds.getSession();
	}
	
	@Override
	protected boolean useCache() {
		return false;
	}
	
	@RockWellTransactional
	public int saveOne(ControlDetail controlDetail) throws Exception {
		save(controlDetail);
		return 0;
		
	}
	
	
}