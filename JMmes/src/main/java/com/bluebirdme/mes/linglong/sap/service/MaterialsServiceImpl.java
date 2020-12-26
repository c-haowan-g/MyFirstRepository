/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.math.BigDecimal;
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
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.Materials;
import com.bluebirdme.mes.linglong.sap.entity.dto.MaterialsDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.MaretialGroup;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;

import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * SAP物料基础数据
 * 
 * @author 李彦
 * @Date 2018-08-09 11:50:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialsServiceImpl extends RockWellBaseServiceImpl<Materials> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Materials.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public void saveChanges(MaterialsDTO materials) throws Exception {

		if (!ListUtils.isEmpty(materials.getDeleted())) {
			delete(materials.getDeleted());
		}
		if (!ListUtils.isEmpty(materials.getInserted())) {
			save(materials.getInserted());
		}
		if (!ListUtils.isEmpty(materials.getInserted())) {
			update(materials.getInserted());
		}

	}

	public Map<String, Object> datagrid2(String filterRules, Filter filter,
			Page page, Class clazz) throws Exception {
		if (!StringUtils.isEmpty(filterRules)) {
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(filterRules).getAsJsonArray();
			FilterRule rule = null;
			Gson gson = new Gson();
			for (JsonElement obj : array) {
				rule = gson.fromJson(obj, FilterRule.class);
				// op:支持 contains,beginwith,endwith |
				// 不支持equal,notequal,less,lessorequal,greater,greaterorequal
				filter.set(rule.getField(),
						rule.getOp() + ":" + rule.getValue());
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid2_count") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid2_count", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	// 根据代码获取物料信息
	public List<Materials> getMaterialByCode(String code) {
		// TODO Auto-generated method stub
		return this.findByField("materialcode_s", code);

	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> datagrid3() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("datagrid_material_all"));
		List<Map<String, Object>> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> datagrid4() throws Exception {
		String SQL="";
		String factory = LLWebUtils.factory();
		if (factory.equals("1")) {
			// 全钢
			SQL = "select t.* from AT_INT_SAP_MATERIALS t where 1=1 AND t.mattyp_s ='FERT' AND t.Matgrp_s in ( '211001','211003')  ";
		} else if (factory.equals("2")) {
			// 半钢
			SQL = "select t.* from AT_INT_SAP_MATERIALS t where 1=1 AND t.mattyp_s ='FERT' AND t.Matgrp_s in ( '221001','221002') ";
		}
		SQLQuery query = createSQLQuery(SQL);

		List<Map<String, Object>> list = query.list();

		return list;
		
	}

	/**
	 * 获取第四个页面的抽检比例
	 * 
	 * @param itemid_s
	 *            物料ID
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchByMaterialCode(String materialCode)
			throws Exception {
		SQLQuery query = getSession().createSQLQuery(
				getSQL("searchByMaterialCode"));
		query.setParameter("materialCode", materialCode);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	public List<Materials> getMaterialsByDynabalancereversal(String factory,String q)
			throws Exception {
		String string = "";
		if (factory.equals("1")) {
			// 全钢
			string = "select t.* from AT_INT_SAP_MATERIALS t where 1=1 AND t.mattyp_s ='FERT' AND t.Matgrp_s in ( '211001','211003')  ";
			string += " AND  not exists (select t1.materialcode_s from AT_D_BS_DynaBalanceReversal t1 where 1=1 AND t.materialcode_s =t1.materialcode_s AND t1.RECORD_FLAG_S ='A' AND t1.s_Factory_s='1')";
		} else if (factory.equals("2")) {
			// 半钢
			string = "select t.* from AT_INT_SAP_MATERIALS t where 1=1 AND t.mattyp_s ='FERT' AND t.Matgrp_s in ( '221001','221002') ";
			string += " AND  not exists (select t1.materialcode_s from AT_D_BS_DynaBalanceReversal t1 where 1=1 AND t.materialcode_s =t1.materialcode_s AND t1.RECORD_FLAG_S ='A' AND t1.s_Factory_s='2')";
		}
		SQLQuery query = createSQLQuery(string, Materials.class);

		List<Materials> list = query.list();

		return list;
	}
	
	/**
	 * 返回胎胚物料信息
	 * 刘程明
	 * 2019年3月11日
	 * @return
	 */
	public List<Map<String, Object>> halbMaterialList(){
		SQLQuery query = getSession().createSQLQuery(
				getSQL("halbMaterialList"));
		if(LLWebUtils.factory().equals("1")){
			query.setParameter("MatGrp_S", "301024");
		}
		else{
			query.setParameter("MatGrp_S", "302001");
		}
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	/**
	 * 返回母胶混炼胶
	 * @return
	 * @author 刘程明
	 * @date 2019年8月13日
	 */
	public List<Map<String, Object>> mixMaterialList(){
		SQLQuery query = getSession().createSQLQuery(
				getSQL("mixMaterialList"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	
	/**
	 * 获取半部件模块用的物料组
	 * whl 20200609
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getMaterialGroupList(){
		SQLQuery materialGroupQuery = getSession().createSQLQuery(getSQL("getMaterialGroupList"));
		materialGroupQuery.setParameter("erpcode_s_q",MaretialGroup.FullSteelHalfPartMaterialGroup);
		materialGroupQuery.setParameter("erpcode_s_b",MaretialGroup.HalfSteelHalfPartMaterialGroup);
		materialGroupQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialGroupQuery.list();
	}
	
	/**
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getAllMaterialGroupList(){
		SQLQuery materialGroupQuery = getSession().createSQLQuery(getSQL("getAllMaterialGroupList"));
		materialGroupQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialGroupQuery.list();
	}
	/**
	 * 根据物料组（dictcode）获取存放规格（外部编码/erpcode）
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getErpcodebyMaterialGroupList(String dictcode){
		SQLQuery erpCodequery = getSession().createSQLQuery(getSQL("getErpcodebyMaterialGroupList"));
		erpCodequery.setParameter("dictcode_s",dictcode);
		erpCodequery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return erpCodequery.list();
	}
	/**
	 * 根据存放规格（外部编码/erpcode）获取物料信息
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getMaterialbyErpcodeList(String erpcpde){
		SQLQuery materialInfoQuery = getSession().createSQLQuery(getSQL("getMaterialbyErpcodeList"));
		materialInfoQuery.setParameter("matgrp_s",erpcpde);
		materialInfoQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialInfoQuery.list();
	}
	/**
	 * 获取半部件用的所有物料信息
	 * whl 半钢全钢获取全部物料使用
	 * 2019年4月17日
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getMaterialList(){
		
		if(LLWebUtils.factory().equals(Factory.FullSteel)){
			SQLQuery materialQuery = getSession().createSQLQuery(getSQL("getFullStealMaterialList"));
			materialQuery.setParameter("erpcode_s_q",MaretialGroup.FullSteelHalfPartMaterialGroup);
			materialQuery.setParameter("erpcode_s_b",MaretialGroup.HalfSteelHalfPartMaterialGroup);
			materialQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			return materialQuery.list();
		}
		else{
			SQLQuery materialQuery = getSession().createSQLQuery(getSQL("getHalfStealMaterialList"));
			materialQuery.setParameter("erpcode_s_q",MaretialGroup.FullSteelHalfPartMaterialGroup);
			materialQuery.setParameter("erpcode_s_b",MaretialGroup.HalfSteelHalfPartMaterialGroup);
			materialQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			return materialQuery.list();
		}

	}
	/**
	 * 根据物料组获取物料信息
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getMaterialByMaterialGroupList(String materialGroup){
		SQLQuery materialDictQuery = getSession().createSQLQuery(getSQL("getMaterialByMaterialGroupList"));
		if(LLWebUtils.factory().equals(Factory.FullSteel)){
			materialDictQuery.setParameter("erpcode_s",MaretialGroup.FullSteelHalfPartMaterialGroup);
		}
		else{
			materialDictQuery.setParameter("erpcode_s",MaretialGroup.HalfSteelHalfPartMaterialGroup);
		}
		materialDictQuery.setParameter("dictcode_s",materialGroup);
		materialDictQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialDictQuery.list();
	}
	/**
	 * 根据物料编码获取物料名称
	 * 兰颖慧
	 * 2019年4月23日
	 * @return
	 */
	public List<Map<String, Object>> getMaterialNameByMaterialCode(String materialCode){
		SQLQuery materialNameQuery = getSession().createSQLQuery(getSQL("getMaterialNameByMaterialCode"));
		materialNameQuery.setParameter("materialCode",materialCode);
		return materialNameQuery.list();
	}
}
