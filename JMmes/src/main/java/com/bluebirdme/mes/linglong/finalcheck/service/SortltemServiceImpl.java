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
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortSamplingCount;
import com.bluebirdme.mes.linglong.finalcheck.entity.Sortltem;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortltemTab4;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortltemDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortltemTab4DTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 分拣规则维护页面
 * @author 刘程明
 * @Date 2018-08-15 09:28:58
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortltemServiceImpl extends RockWellBaseServiceImpl<Sortltem> {

    @Resource LingLongDataSource llds;
    @Resource SortSamplingCountServiceImpl sortSamplingCountServiceImpl;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Sortltem.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    @RockWellTransactional
    public void saveChanges(SortltemDTO sortltem) throws Exception{
        
    	 if (!ListUtils.isEmpty(sortltem.getDeleted())) {
    		 delete(sortltem.getDeleted());
         }
         if (!ListUtils.isEmpty(sortltem.getInserted())) {
         	List<Sortltem> sortltemList = sortltem.getInserted();
         	for(Sortltem item:sortltemList)
         	{
         		item.setS_factory_s(LLWebUtils.factory());
         		item.setCreated_by_s(LLWebUtils.getUser().userCode);
         		item.setCreated_time_t(new Date());
         		item.setRecord_flag_s("A");
         		item.setArch_flag_s("0");
         		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
         	}
             save(sortltemList);
         }
         if (!ListUtils.isEmpty(sortltem.getUpdated())) {
         	List<Sortltem> sortltemList = sortltem.getUpdated();
         	for(Sortltem item:sortltemList)
         	{
         		item.setChanged_by_s(LLWebUtils.getUser().userCode);
         		item.setChanged_time_t(new Date());
         	}
             update(sortltemList);
         }
    
    }
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName(String spare1_s) throws Exception
    {
    	String factoryString=LLWebUtils.factory();
      	String agenc_no_sString =FactoryConstant.JING_MEN_CODE;
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	query.setParameter("spare1_s", spare1_s);
		query.setParameter("s_factory_s", factoryString);
		query.setParameter("agenc_no_s", agenc_no_sString);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName3() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName3"));
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    
    /**
     * 获取第四个页面的抽检比例
     * @param itemid_s 物料ID
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getNum_i(String itemid_s,String station_i) throws Exception
    {
    	String factoryString=LLWebUtils.factory();
      	String agenc_no_sString =FactoryConstant.JING_MEN_CODE;
		SQLQuery query = getSession().createSQLQuery(getSQL("getNum_i"));
		query.setParameter("itemid_s", itemid_s);
		query.setParameter("station_i", station_i);
		query.setParameter("s_factory_s", factoryString);
		query.setParameter("agenc_no_s", agenc_no_sString);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
    }
    
    
    
    @SuppressWarnings("unchecked")
	public Map<String, Object> datagrid4(Filter filter, Page page, Class clazz) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows4(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal4(filter, page));

		return ret;
	}

	public Long datagridTotal4(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total4的SQL语句定义");

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
	public <K> List<K> datagridRows4(Filter filter, Page page, Class<K> clazz) throws Exception {

		if (getSQL("datagrid_rows4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows4的SQL语句定义");

		String dataSql = getSQL("datagrid_rows4", filter.getFilter());
		
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		System.out.println("AAAAAAAA"+query.getQueryString());
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> datagrid1(String filterRules,Filter filter, Page page, Class clazz) throws Exception {
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

		ret.put("rows", datagridRows1(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal1(filter, page));

		return ret;
	}

	public Long datagridTotal1(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total1的SQL语句定义");

		String totalSql = getSQL("datagrid_total1", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows1(Filter filter, Page page, Class<K> clazz) throws Exception {

		if (getSQL("datagrid_rows1") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows1的SQL语句定义");

		String dataSql = getSQL("datagrid_rows1", filter.getFilter());
		
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);
        System.out.println(dataSql);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}
	 /**
     * 第五个页面更新比例
     * @param itemid_s 物料ID
     * @param num_i 比例
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    @SuppressWarnings("unchecked")
    public void updateNum_i5(SortltemTab4DTO sortltemtab4) throws Exception {
    	
    	 if (!ListUtils.isEmpty(sortltemtab4.getUpdated())) {
          	List<SortltemTab4> sortltemTab4List = sortltemtab4.getUpdated();
          	for(SortltemTab4 item:sortltemTab4List){
          		List<Sortltem>  sortItemList = findByField("ITEMID_S", item.getItemid_s());
            	for(Sortltem item1:sortItemList)
             	{
             		//item1.setNum_i(item.getNum_i());
             		 item1.setSpare3_s(item.getSpare3_s().toString());
             	}
            	update(sortItemList);
            	
            	//更新质检分拣抽检计数表
            	Where where = new Where();
            	where.andEqual("s_factory_s", LLWebUtils.factory());
            	where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
            	where.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
            	where.andEqual("itemid_s", item.getItemid_s());
            	where.andEndWith("station_s", sortltemtab4.getEnttype());
            	List<SortSamplingCount>  sortSamplingCountList = sortSamplingCountServiceImpl.findByWhere(where);
            	if(sortSamplingCountList.size()==0||sortSamplingCountList==null){
            		//不存在则新增
            		SortSamplingCount insertSortSamplingCount=new SortSamplingCount();
            		insertSortSamplingCount.setAgenc_no_s(LLConstant.JING_MEN_CODE);
            		insertSortSamplingCount.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
            		insertSortSamplingCount.setS_factory_s(LLWebUtils.factory());
            		insertSortSamplingCount.setArch_flag_s("1");
            		insertSortSamplingCount.setCreated_by_s("admin");
            		insertSortSamplingCount.setCreated_time_t(new Date());
            		//insertSortSamplingCount.setNum_i(item.getNum_i().intValue());
            		 insertSortSamplingCount.setSpare3_s(item.getSpare3_s().toString());
            		insertSortSamplingCount.setItemid_s(item.getItemid_s());
            		insertSortSamplingCount.setStation_s(sortltemtab4.getEnttype());
            		sortSamplingCountServiceImpl.save(insertSortSamplingCount);
            	}else{
            		//存在则更新
            		for(SortSamplingCount item2:sortSamplingCountList)
                	 {
                		//item2.setNum_i(item.getNum_i().intValue());
                		 item2.setSpare3_s(item.getSpare3_s().toString());
                		item2.setStation_s(sortltemtab4.getEnttype());
                		item2.setChanged_by_s(LLWebUtils.getUserName());
                		item2.setChanged_time_t(new Date());
                	 }
               	    sortSamplingCountServiceImpl.update(sortSamplingCountList);
            	}
          	}
          }
    }
	  /**
     * 第四个页面更新比例
     * @param itemid_s 物料ID
     * @param num_i 比例
     * @return
     * @throws Exception
     */
    @RockWellTransactional
    @SuppressWarnings("unchecked")
    public void updateNum_i(SortltemTab4DTO sortltemtab4) throws Exception {
    	
    	 if (!ListUtils.isEmpty(sortltemtab4.getUpdated())) {
          	List<SortltemTab4> sortltemTab4List = sortltemtab4.getUpdated();
          	for(SortltemTab4 item:sortltemTab4List){
          		System.out.println(sortltemtab4.getEnttype());
          		Where sortltemWhere = new Where();
          		sortltemWhere.andEqual("itemid_s", item.getItemid_s());
          		sortltemWhere.andEndWith("station_i", sortltemtab4.getEnttype());
          		List<Sortltem>  sortItemList = findByWhere(sortltemWhere);
            	for(Sortltem item1:sortItemList)
             	{
             		item1.setNum_i(item.getNum_i());
             	}
            	update(sortItemList);
            	
            	//更新质检分拣抽检计数表
            	Where where = new Where();
            	where.andEqual("s_factory_s", LLWebUtils.factory());
            	where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
            	where.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
            	where.andEqual("itemid_s", item.getItemid_s());
            	where.andEndWith("station_s", sortltemtab4.getEnttype());
            	List<SortSamplingCount>  sortSamplingCountList = sortSamplingCountServiceImpl.findByWhere(where);
            	if(sortSamplingCountList.size()==0||sortSamplingCountList==null){
            		//不存在则新增
            		SortSamplingCount insertSortSamplingCount=new SortSamplingCount();
            		insertSortSamplingCount.setAgenc_no_s(LLConstant.JING_MEN_CODE);
            		insertSortSamplingCount.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
            		insertSortSamplingCount.setS_factory_s(LLWebUtils.factory());
            		insertSortSamplingCount.setArch_flag_s("1");
            		insertSortSamplingCount.setCreated_by_s("admin");
            		insertSortSamplingCount.setCreated_time_t(new Date());
            		insertSortSamplingCount.setNum_i(item.getNum_i().intValue());
            		insertSortSamplingCount.setItemid_s(item.getItemid_s());
            		insertSortSamplingCount.setStation_s(sortltemtab4.getEnttype());
            		sortSamplingCountServiceImpl.save(insertSortSamplingCount);
            	}else{
            		//存在则更新
            		for(SortSamplingCount item2:sortSamplingCountList)
                	 {
                		item2.setNum_i(item.getNum_i().intValue());
                		item2.setSample_num_i(0);
                		item2.setStation_s(sortltemtab4.getEnttype());
                		item2.setChanged_by_s(LLWebUtils.getUserName());
                		item2.setChanged_time_t(new Date());
                	 }
               	    sortSamplingCountServiceImpl.update(sortSamplingCountList);
            	}
          	}
          }
	}
    /**
	 * 查询机台，下拉框 根据设备类型查询终检设备 BY 时永良（新增，用于分拣规则维护-规格维护-机台下拉列表）
	 * 
	 * @Title: SearchEnt
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> SearchEnt(String equip_type) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("SearchEnt"));
		query.setParameter("uda_0", equip_type);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}
	

}
