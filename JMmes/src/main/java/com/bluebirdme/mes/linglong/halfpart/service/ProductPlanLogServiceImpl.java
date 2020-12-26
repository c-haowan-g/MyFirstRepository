/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanLog;
import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanLogDTO;

/**
 * 半部件日计划倒推异常记录表
 * 
 * @author 刘朋
 * @Date 2020-03-11 16:01:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductPlanLogServiceImpl extends RockWellBaseServiceImpl<ProductPlanLog> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ProductPlanLog.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public void saveChanges(ProductPlanLogDTO productplanlog) throws Exception {
		List<ProductPlanLog> productPlanLogList = new ArrayList<>();
		if (!ListUtils.isEmpty(productplanlog.getInserted())) {
			productPlanLogList = productplanlog.getInserted();
			for (ProductPlanLog item : productPlanLogList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			}
			save(productPlanLogList);
		}
	}

}
