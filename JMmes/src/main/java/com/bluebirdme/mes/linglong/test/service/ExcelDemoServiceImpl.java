/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.bluebirdme.core.common.CoreDataSource;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.ExcelDemo;

/**
 * 
 * @author Goofy
 * @Date 2018年8月7日 下午4:24:02
 */
@Service
public class ExcelDemoServiceImpl extends RockWellBaseServiceImpl<ExcelDemo> {
	
	@Resource LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return ExcelDemo.class;
	}

}
