/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.math.BigDecimal;
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
import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.MaretialGroup;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.test.entity.dto.UdaDto;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.ui.Time;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * Part基础物料
 * 
 * @author 周清玉
 * @Date 2019-06-21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PartsServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

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

	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	// 根据代码获取物料信息
	public Part getPartByCode(String code) {
		return getFunction().getPart(code);
	}

	// 根据代码获取物料信息
	public String getPartByCode2(String code) {
		SQLQuery query = getSession().createSQLQuery(getSQL("getPartByCode"));
		query.setParameter("partCode", code);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list().get(0).toString();
	}

	/**
	 * 返回胎胚物料信息 周清玉 2019年8月15日
	 * 
	 * @return
	 */
	public List<Map<String, Object>> halbMaterialList() {
		SQLQuery query = getSession().createSQLQuery(getSQL("halbMaterialList"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("MatGrp_S", "301024");
		} else {
			query.setParameter("MatGrp_S", "302001");
		}
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	/**
	 * 返回胎胚物料信息-成型日计划 whl 2019年12月16日
	 * 
	 * @return
	 */
	public List<Map<String, Object>> halbMaterialListForDay() {
		SQLQuery query = getSession().createSQLQuery(getSQL("halbMaterialListForDay"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("MatGrp_S", "301024");
		} else {
			query.setParameter("MatGrp_S", "302001");
		}
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	public Map<String, Object> getPartsDatagrid(String filterRules, Filter filter, Page page) throws Exception {
		if (!StringUtils.isEmpty(filterRules)) {
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(filterRules).getAsJsonArray();
			FilterRule rule = null;
			Gson gson = new Gson();
			for (JsonElement obj : array) {
				rule = gson.fromJson(obj, FilterRule.class);
				// op:支持 contains,beginwith,endwith |
				// 不支持equal,notequal,less,lessorequal,greater,greaterorequal
				filter.set(rule.getField(), rule.getOp() + ":" + rule.getValue());
			}
			filter.set("s_factory_s", LLWebUtils.factory());
			filter.set("agenc_no_s", FactoryConstant.JING_MEN_CODE);
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", getParts_rows(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", getParts_total(filter, page));
		return ret;
	}

	public Long getParts_total(Filter filter, Page page) throws Exception {

		if (getSQL("getParts_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为getParts_total的SQL语句定义");

		String totalSql = getSQL("getParts_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> getParts_rows(Filter filter, Page page) throws Exception {
		if (getSQL("getParts_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为getParts_rows的SQL语句定义");

		String dataSql = getSQL("getParts_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
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
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	public List<Map<String, Object>> getMaterialGroupList(){
		SQLQuery materialGroupQuery = getSession().createSQLQuery(getSQL("getMaterialGroupList"));
		if(LLWebUtils.factory().equals(Factory.FullSteel)){
			materialGroupQuery.setParameter("erpcode_s",MaretialGroup.FullSteelHalfPartMaterialGroup);
		}
		else{
			materialGroupQuery.setParameter("erpcode_s",MaretialGroup.HalfSteelHalfPartMaterialGroup);
		}
		materialGroupQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return materialGroupQuery.list();
	}
}
