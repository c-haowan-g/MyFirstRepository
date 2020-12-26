package com.bluebirdme.mes.linglong.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.entity.Menu;
import com.bluebirdme.core.common.service.MenuServiceImpl;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.login.entity.RoleIndexes;

/**
 * @author Goofy
 * @Date 2019年4月2日 下午12:21:43
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleIndexesServiceImpl extends BaseServiceImpl<RoleIndexes> {

	@Resource
	LingLongDataSource ds;
	
	@Resource
	MenuServiceImpl menuSrv;
	
	@Override
	protected Class getEntity() {
		return RoleIndexes.class;
	}

	@Override
	protected Session getSession() {
		return ds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	
	public List<String> getIndexes(Long roleId){
		List<String> list=new ArrayList<String>();
		List<RoleIndexes> indexes=findByField("roleId", roleId);
		for(RoleIndexes r:indexes){
			list.add(r.getMenuId().toString());
		}
		return list;
	}

}
