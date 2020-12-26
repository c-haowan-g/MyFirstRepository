package com.bluebirdme.mes.linglong.core;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bluebirdme.core.system.orm.datasource.DataSourceMeta;
import com.bluebirdme.core.system.orm.datasource.DbType;

/**
 * @author Goofy 252887950@qq.com <a href=http://www.xdemo.org>www.xdemo.org</a>
 * @Date 2017年8月24日 下午1:21:21
 */
@Component
public class LingLongDataSource extends DataSourceMeta{
	
	@Resource SessionFactory sf_core;
	
	
	public Session getSession() {
		return sf_core.getCurrentSession();
	}

	
	public DbType dbType() {
		return DbType.ORACLE;
	}
	
	public String dbDesc() {
		return "玲珑MES数据库";
	}


	@Override
	public String id() {
		return "002";
	}
	
	
}
