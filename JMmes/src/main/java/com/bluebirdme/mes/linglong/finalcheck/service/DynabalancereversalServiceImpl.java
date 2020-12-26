/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.bluebirdme.mes.linglong.building.entity.EquipmentRealTime;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import org.apache.ecs.wml.P;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Dynabalancereversal;

/**
 * 质检动平衡翻转维护
 * 
 * @author 马建斌
 * @Date 2018-10-12 10:21:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DynabalancereversalServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Dynabalancereversal.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/*@RockWellTransactional
	public void saveChanges(DynabalancereversalDTO dynabalancereversal) throws Exception {
		BigDecimal rs = null;
		if (!ListUtils.isEmpty(dynabalancereversal.getUpdated())) {
			List<DynabalancereversalATO> reasList = dynabalancereversal.getUpdated();
			for(Dynabalancereversal item : reasList){
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				RockWellUtils.update(item);
			}
		}else if(!ListUtils.isEmpty(dynabalancereversal.getInserted())){
			//新增
			List<DynabalancereversalATO> cereList = dynabalancereversal.getInserted();
			for (DynabalancereversalATO item : cereList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setRecord_flag_s("A");
				item.setArch_flag_s("0");
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setReversalvalue_s(item.getReversalvalue_s());
				item.setMaterialcode_s(item.getMaterialcode_s());
				item.setMaterialdesc_s(item.getMaterialdesc_s());
				save(item);
			}
		}else if(!ListUtils.isEmpty(dynabalancereversal.getDeleted())){
			//删除
			List<DynabalancereversalATO> cereList = dynabalancereversal.getDeleted();
			for (Dynabalancereversal item : cereList) {
				item.setRecord_flag_s("D");
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				RockWellUtils.update(item);
			}
			//update(cereList);
		}

	}*/

	@RockWellTransactional
	public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
				//将MAP转换为实体
				Dynabalancereversal dynabalancereversal = (Dynabalancereversal) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Dynabalancereversal.class);
				dynabalancereversal.setRecord_flag_s("D");
				dynabalancereversal.setChanged_by_s(LLWebUtils.getUser().userCode);
				dynabalancereversal.setChanged_time_t(new Date());
				list.add(dynabalancereversal);
			}
			delete(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
				//将MAP转换为实体
				Dynabalancereversal dynabalancereversal = (Dynabalancereversal) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Dynabalancereversal.class);
				dynabalancereversal.setS_factory_s(LLWebUtils.factory());
				dynabalancereversal.setRecord_flag_s("A");
				dynabalancereversal.setArch_flag_s("0");
				dynabalancereversal.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				dynabalancereversal.setChanged_by_s(LLWebUtils.getUser().userCode);
				dynabalancereversal.setChanged_time_t(new Date());
				dynabalancereversal.setCreated_by_s(LLWebUtils.getUser().userCode);
				dynabalancereversal.setCreated_time_t(new Date());
				dynabalancereversal.setReversalvalue_s(dynabalancereversal.getReversalvalue_s());
				dynabalancereversal.setMaterialcode_s(dynabalancereversal.getMaterialcode_s());
				dynabalancereversal.setMaterialdesc_s(dynabalancereversal.getMaterialdesc_s());
				list.add(dynabalancereversal);
			}
			save(list);
		}
		/**
		 *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
		 */
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
				//将MAP转换为实体
				Dynabalancereversal dynabalancereversal = (Dynabalancereversal) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Dynabalancereversal.class);
				dynabalancereversal.setChanged_by_s(LLWebUtils.getUser().userCode);
				dynabalancereversal.setChanged_time_t(new Date());
				update(dynabalancereversal);
			}
		}

	}

	public int checkCode(String code){
		String sql = "select count(1) from AT_D_BS_DYNABALANCEREVERSAL where MaterialCode_S = " +code;
		SQLQuery query = getSession().createSQLQuery(sql);
		BigDecimal res = (BigDecimal)query.uniqueResult();
		return res.intValue();
	}

}
