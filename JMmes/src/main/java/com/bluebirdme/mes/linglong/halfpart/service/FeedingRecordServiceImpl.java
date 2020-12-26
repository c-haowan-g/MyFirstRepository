/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.entity.FeedingRecord;

/**
 * 投料记录
 * 
 * @author 刘朋
 * @Date 2019-20-10 8:34:42
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeedingRecordServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return FeedingRecord.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/*
	 * public List<Map<String, Object>> searchEquipmentCode(){ SQLQuery query =
	 * createSQLQuery(getSQL("searchEquipmentCode"));
	 * query.setParameter("process",Process.HalfPart); String s_factory_s =
	 * LLWebUtils.factory(); query.setParameter("s_factory_s", s_factory_s);
	 * return query.list(); }
	 */

}
