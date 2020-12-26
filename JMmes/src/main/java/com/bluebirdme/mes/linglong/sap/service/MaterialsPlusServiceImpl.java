/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.MaretialGroup;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.MaterialsPlus;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 物料信息扩展表
 * 
 * @author 周清玉
 * @Date 2018-11-15 16:51:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialsPlusServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MaterialsPlus.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		List<Map<String, Object>> listMap = rockWellEntityDTO.getUpdated();

		for (Map<String, Object> mapOne : listMap) {

			MaterialsPlus item =(MaterialsPlus) MapTrunPojo.mapToEntity(mapOne, getEntity());
			// 操作人fdf
			item.setChanged_by_s(WebUtils.getUser().userCode);
			// 机构代码
			item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
			/*
			 * // 工厂 不更新 item.setS_factory_s(LLWebUtils.factory());
			 */
			// 记录标志
			item.setRecord_flag_s("A");

			if (item.getBeadwidth_d() == null) {
				item.setBeadwidth_d("0");
			}
			if (item.getInnerdia_d() == null) {
				item.setInnerdia_d("0");
			}
			if (item.getOuterdia_d() == null) {
				item.setOuterdia_d("0");
			}
			if (item.getTyreheight_d() == null) {
				item.setTyreheight_d("0");
			}
			if (item.getTyrewidth_d() == null) {
				item.setTyrewidth_d("0");
			}

			// 修改时间的添加
			item.setChanged_time_t(new Date());

			List<Object> list = this.findByField("materialcode_s", item.getMaterialcode_s());
			List<MaterialsPlus> listTEntity = new ArrayList<>();
			for (Object object : list) {
				Map map = MapTrunPojo.ObjectToMap(object);
				MaterialsPlus materialsPlus =(MaterialsPlus) MapTrunPojo.mapToEntity(map, getEntity());
				listTEntity.add(materialsPlus);
			}
			
			if (!ListUtils.isEmpty(listTEntity)) {
				update(item);
			} else {
				save(item);
			}
		}

	}

	public Map<String, Object> datagridz(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsz(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalz(filter, page));
		return ret;
	}

	public List<Map<String, Object>> datagridRowsz(Filter filter, Page page) throws Exception {
		
		if (getSQL("datagrid_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String,Object>> listMap =query.list();
		//大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
		for(Map<String,  Object> orgMap :listMap){
			Map<String,  Object> map = new HashMap<>();
			map=TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return  returnlist;
	}

	public Long datagridTotalz(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
		String totalSql = getSQL("datagrid_total", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 根据物料编码查询内径外径截面高
	 * 
	 * @param materialCode
	 *            物料编码
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getMaterialPlusParams(String materialCode) throws Exception {
		List<Map<String, Object>> params = createSQLQuery(getSQL("getMaterialPlusParams")).setParameter("materialCode",
				materialCode).list();
		return params;
	}

	public Map<String, Object> datagridTime(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsTime(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalTime(filter, page));
		return ret;
	}

	public List<Map<String, Object>> datagridRowsTime(Filter filter, Page page) throws Exception {
		
		if (getSQL("datagrid_rowstime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rowstime", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String,Object>> listMap =query.list();
		//大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
		for(Map<String,  Object> orgMap :listMap){
			Map<String,  Object> map = new HashMap<>();
			map=TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return  returnlist;
	}

	public Long datagridTotalTime(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_totaltime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
		String totalSql = getSQL("datagrid_totaltime", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 根据物料大类更新该大类下所有物料的时效性 刘程明 2019年2月28日
	 * 
	 * @param materialType
	 *            物料大类外部编码
	 * @param smallTime
	 *            最小存放时间
	 * @param maxTime
	 *            最大存放时间
	 * @return
	 */
	public Boolean updateByMaterialType(String materialType, String smallTime, String maxTime) {
		String updateByMaterialTypeSql = String.format("update at_int_sap_materialsplus t"
				+ "  set t.smalltime_f = '%s' , t.overtime_f = '%s',t.changed_by_s='%s',t.changed_time_t=sysdate"
				+ "  where t.materialcode_s in" + "(select m.materialcode_s from   at_int_sap_materials m where"
				+ " m.matgrp_s='%s')", smallTime, maxTime, WebUtils.getUser().userCode, materialType);
		try {
			RockWellUtils.execSQL(updateByMaterialTypeSql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Map<String, Object>> getMaterialGroupList(){
		SQLQuery materialGroupQuery = getSession().createSQLQuery(getSQL("getMaterialGroupList"));
		if(LLWebUtils.factory().equals(Factory.FullSteel)){
			//materialGroupQuery.setParameter("erpcode_s",MaretialGroup.FullSteelHalfPartMaterialGroup);
		}
		else{
			//materialGroupQuery.setParameter("erpcode_s",MaretialGroup.HalfSteelHalfPartMaterialGroup);
		}
		materialGroupQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialGroupQuery.list();
	}

}
