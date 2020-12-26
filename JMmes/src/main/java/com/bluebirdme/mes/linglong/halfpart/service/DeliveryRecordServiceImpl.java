package com.bluebirdme.mes.linglong.halfpart.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.DeliveryRecord;

/**
 * 半部件配送履历
 * 
 * @author 刘朋
 * @Date 2019-03-09 8:20:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeliveryRecordServiceImpl extends RockWellBaseServiceImpl<DeliveryRecord> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return DeliveryRecord.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMachineCode() {
		SQLQuery query = createSQLQuery(getSQL("machineCodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByBatchCode() {
		SQLQuery query = createSQLQuery(getSQL("batchCodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByVehicleCode() {
		SQLQuery query = createSQLQuery(getSQL("vehicleCodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByFromLocation() {
		SQLQuery query = createSQLQuery(getSQL("fromLocationQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

}
