/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.entity.Machine_Formula;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 成型工艺配方查询
 * @author whl
 * @Date 2019-02-18 13:47:29
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class Machine_FormulaServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Machine_Formula.class;
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
	public List<Map<String, Object>> searchByEquipCode() {
		SQLQuery query = createSQLQuery(getSQL("equipCodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("agenc_no_s", FactoryConstant.JING_MEN_CODE);
		return query.list();
	}
	
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterialCode() {
		SQLQuery query = createSQLQuery(getSQL("materialCodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}
	
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByProductionStep() {
		SQLQuery query = createSQLQuery(getSQL("productionStepQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list=query.list();
		List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> resultMap=new HashMap<String, Object>();
		for(int i=0;i<list.size();i++){
			resultMap=list.get(i);
			for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
				if(entry.getValue().equals("01")){
					resultMap.put("PRODUCTION_STEP_NAME", "试制");
				}
				if(entry.getValue().equals("02")){
					resultMap.put("PRODUCTION_STEP_NAME", "试产");
				}
				if(entry.getValue().equals("03")){
					resultMap.put("PRODUCTION_STEP_NAME", "投产");
				}
			}
			resultMapList.add(resultMap);
		}
		return resultMapList;
	}
	
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByVersion() {
		SQLQuery query = createSQLQuery(getSQL("versionQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 根据机台条码查询右侧详细数据
	 * @param equipcode_s
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterialCode_s(String equipcode_s,String materialcode_s,String productionstep_s,String versions) {
		SQLQuery query = createSQLQuery(getSQL("curingparameterm"));
		query.setParameter("equipcode_s", equipcode_s);
		query.setParameter("materialcode_s", materialcode_s);
		query.setParameter("productionstep_s", productionstep_s);
		query.setParameter("versions", versions);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridAllRows(Filter filter, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";
		
		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_all_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_all_rows", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		return query.list();
	}
	
}
