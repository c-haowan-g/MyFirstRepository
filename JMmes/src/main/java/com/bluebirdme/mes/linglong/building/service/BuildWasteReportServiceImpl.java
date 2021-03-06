/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.building.entity.BuildWasteReport;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 产出实绩表
 * 
 * @author 刘朋
 * @Date 2019-06-04 13:16:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BuildWasteReportServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return BuildWasteReport.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

}
