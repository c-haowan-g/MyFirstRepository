/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.constants.SessionConstant;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.Sortltem;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeItemDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 质检配方规格表
 * 
 * @author 刘程明
 * @Date 2018-08-08 14:16:57
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RecipeItemServiceImpl extends RockWellBaseServiceImpl<RecipeItem> {

	@Resource
	LingLongDataSource llds;
	@Resource
	RecipeServiceImpl recipeSrv;
	@Resource SortltemServiceImpl sortltemServiceImpl;
	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return RecipeItem.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	 @RockWellTransactional
	public void saveChanges(RecipeItemDTO recipeitem) throws Exception {

		if (!ListUtils.isEmpty(recipeitem.getDeleted())) {
			delete(recipeitem.getDeleted());
		}
		if (!ListUtils.isEmpty(recipeitem.getInserted())) {
			save(recipeitem.getInserted());
		}
		if (!ListUtils.isEmpty(recipeitem.getUpdated())) {
			update(recipeitem.getUpdated());
		}

	}
	 @RockWellTransactional
	public String saveChanges2(RecipeItemDTO recipeitem) throws Exception {

		List<RecipeItem> recipeitemList=null;
		long recipeID = -1;
		
		if (!ListUtils.isEmpty(recipeitem.getDeleted())) {
			recipeitemList = recipeitem.getDeleted();
			for(RecipeItem list:recipeitemList){
    			List<Sortltem> sortltemList = sortltemServiceImpl.findByField("itemid_s", list.getItemid_s());
    			if(sortltemList.size()==0){
        			break;
        		}
    			sortltemServiceImpl.delete(sortltemList);
    		}
			delete(recipeitem.getDeleted());
			recipeID=recipeitemList.get(0).getRecipeid_i();
			int itemCount = getRecipeNoByID(String.valueOf(recipeID),recipeitem.getEnttype())-recipeitemList.size();
			recipeSrv.update(recipeID, "num_i", itemCount);
		}
		if (!ListUtils.isEmpty(recipeitem.getInserted())) {

			recipeitemList = recipeitem.getInserted();

			for (RecipeItem item : recipeitemList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setRecord_flag_s("A");
				item.setArch_flag_s("0");
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
			}
			save(recipeitemList);
			recipeID=recipeitemList.get(0).getRecipeid_i();
			int itemCount = getRecipeNoByID(String.valueOf(recipeID),recipeitem.getEnttype())+recipeitemList.size();
			recipeSrv.update(recipeID, "num_i", itemCount);
		}
		
		return "操作成功";
	} 
	 /**
	  * 获取某规格的数量
	  * @param recipeID recipe表ID
	  * @return 数量
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	private int getRecipeNoByID(String recipeID,String entType) throws Exception {
		SQLQuery query = getSession().createSQLQuery(getSQL("recipe_no_countbyid"));
		query.setParameter("recipeid_i", recipeID);
		query.setParameter("entType", entType);
		return ((BigDecimal) query.uniqueResult()).intValue();
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

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

		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}
	
	
	
	
	public Map<String, Object> datagrid3(String filterRules,Filter filter, Page page, Class clazz)
			throws Exception {
		if (!StringUtils.isEmpty(filterRules)) {
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(filterRules).getAsJsonArray();
			FilterRule rule = null;
			Gson gson = new Gson();
			for (JsonElement obj : array) {
				rule = gson.fromJson(obj, FilterRule.class);
				//op:支持 contains,beginwith,endwith	| 不支持equal,notequal,less,lessorequal,greater,greaterorequal
				filter.set(rule.getField(), rule.getOp()+":"+rule.getValue());
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows3(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal3(filter, page));

		return ret;
	}

	public Long datagridTotal3(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total3") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total3的SQL语句定义");

		String totalSql = getSQL("datagrid_total3", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows3(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid_rows3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows3的SQL语句定义");

		String dataSql = getSQL("datagrid_rows3", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);
        System.out.println("----------"+dataSql);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
        
		return query.list();
	}
	
	
	/**
	 * 外观前、X光前使用
	 * @param filterRules
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> datagrid4(String filterRules,Filter filter, Page page, Class clazz)
			throws Exception {
		if (!StringUtils.isEmpty(filterRules)) {
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(filterRules).getAsJsonArray();
			FilterRule rule = null;
			Gson gson = new Gson();
			for (JsonElement obj : array) {
				rule = gson.fromJson(obj, FilterRule.class);
				//op:支持 contains,beginwith,endwith	| 不支持equal,notequal,less,lessorequal,greater,greaterorequal
				filter.set(rule.getField(), rule.getOp()+":"+rule.getValue());
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows4(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal4(filter, page));

		return ret;
	}

	public Long datagridTotal4(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total4") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total4的SQL语句定义");

		String totalSql = getSQL("datagrid_total4", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows4(Filter filter, Page page, Class<K> clazz)
			throws Exception {
		if (getSQL("datagrid_rows4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows4的SQL语句定义");

		String dataSql = getSQL("datagrid_rows4", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);
        System.out.println("----------"+dataSql);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
        
		return query.list();
	}

}
