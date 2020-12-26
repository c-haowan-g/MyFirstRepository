/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 硫化工单查询
 * 
 * @author penga_liu
 * 
 * @Date 2019年7月18日 下午4:10:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringWorkOrderServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl serialSrv;

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
		return null;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	@RockWellTransactional
	public int saveChanges(UdaDto udadto) throws Exception {

		if (!ListUtils.isEmpty(udadto.getDeleted())) {
			List<Map<String, Object>> listMap = udadto.getDeleted();
			for (Map<String, Object> item : listMap) {
			}
		}
		if (!ListUtils.isEmpty(udadto.getInserted())) {
			List<Map<String, Object>> listMap = udadto.getInserted();
			for (Map<String, Object> item : listMap) {
			}
		}
		if (!ListUtils.isEmpty(udadto.getUpdated())) {
			List<Map<String, Object>> listMap = udadto.getUpdated();
			for (Map<String, Object> item : listMap) {
			}
		}

		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> particularsByMonthPlan(String monthPlan) {
		SQLQuery list = createSQLQuery(getSQL("particularsBymonthPlan"));
		list.setParameter("monthPlan", monthPlan);

		return list.list();
	}

}
