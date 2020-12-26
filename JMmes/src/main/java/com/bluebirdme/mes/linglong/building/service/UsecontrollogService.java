package com.bluebirdme.mes.linglong.building.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.building.entity.Usecontrollog;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsecontrollogService extends RockWellBaseServiceImpl<Usecontrollog>{

	@Resource
	LingLongDataSource llds;
	@Override
	protected Class getEntity() {
		return Usecontrollog.class;
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
	public int saveOne(Usecontrollog usecontrollog) throws Exception {
		save(usecontrollog);
		return 0;
		
	}
	
	
}