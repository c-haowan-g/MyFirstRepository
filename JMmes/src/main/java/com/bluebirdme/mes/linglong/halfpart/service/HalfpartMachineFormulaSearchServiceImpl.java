/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.building.entity.BuildingOverDateSearch;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfpartMachineFormulaSearch;


import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 半部件机台工艺参数查询
 * @author 李德晓
 * @Date 2020-03-11 15:06:47
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfpartMachineFormulaSearchServiceImpl extends  RockWellUDABaseServiceImpl<Object> {
    @Resource LingLongDataSource llds;
    @Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return BuildingOverDateSearch.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

    /**
	 * 查出物料编码在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchMaterial_code_s() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterial_code_s"));		
		return query.list();
	}
	 /**
		 * 查出产品阶段在JSP页面下拉列表处
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> searchProduction_step_s() {
			SQLQuery query = createSQLQuery(getSQL("searchProduction_step_s"));		
			return query.list();
		}
		/**
		 * 查出机台名称在JSP页面下拉列表处
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> searchEquip_code_s() {
			SQLQuery query = createSQLQuery(getSQL("searchEquip_code_s"));	
			return query.list();
		}
		/**
		 * 查出物料名称在JSP页面下拉列表处
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> searchMaterial_desc_s() {
			SQLQuery query = createSQLQuery(getSQL("searchMaterial_desc_s"));		
			return query.list();
		}

   

}
