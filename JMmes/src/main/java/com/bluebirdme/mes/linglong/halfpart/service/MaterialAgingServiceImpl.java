/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.MaterialAging;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 半部件物料时效维护
 * @author 王超
 * @Date 2020-03-06 11:24:18
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaterialAgingServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	/**
	 *ServiceImpl可以继承RockWellBaseServiceImpl,RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候，返回值为List<Map<String,Object>>类型。
	 RockWellBaseServiceImpl使用datagrid查询返回的是List<T>类型，这个类型是根据Controller里面，调用datagrid
	 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return MaterialAging.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO materialsplus) throws Exception{
        
        int mun = 0;
        Boolean ist = false;
		
		if (!ListUtils.isEmpty(materialsplus.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> materialplusllist = materialsplus.getUpdated();
			for(Map<String, Object> newitem:materialplusllist){
				MaterialAging item = (MaterialAging)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setS_factory_s(LLWebUtils.factory());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				// 与数据库数据对查重判断
//				Where where = new Where();
//				where.andEqual("s_factory_s", LLWebUtils.factory());
//				where.andEqual("record_flag_s", "A");
//				where.andEqual("materialcode_s", item.getMaterialcode_s());
//				where.andEqual("smalltime_f", item.getSmalltime_f());
//				where.andEqual("overtime_f", item.getOvertime_f());
//				where.andEqual("spare1_s", item.getSpare1_s());
//				List<Map<String, Object>> list = findMapByWhere(where);
//				System.err.println(list);
//
//				if (list.size() > 0) {
//					ist = true;
//				}
				
				insertedList.add(item);
			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				update(insertedList);
			}
		}
		return mun;
    
    }
    
    @RockWellTransactional
    public int saveChanges1(RockWellEntityDTO materialsplus, String smalltime, String overtime, String spare1_s, String spare2_s) throws Exception{
        
        int mun = 0;
        Boolean ist = false;
		
		if (!ListUtils.isEmpty(materialsplus.getUpdated())) { 
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> materialplusllist = materialsplus.getUpdated();
			for(Map<String, Object> newitem:materialplusllist){
				MaterialAging item = (MaterialAging)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setS_factory_s(LLWebUtils.factory());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setSmalltime_f(smalltime);
				item.setOvertime_f(overtime);
//				item.setSpare1_s("1");
//				item.setSpare4_s("2");
				item.setSpare7_s(spare1_s);
				item.setSpare8_s(spare2_s);
				// 与数据库数据对查重判断
//				Where where = new Where();
//				where.andEqual("s_factory_s", LLWebUtils.factory());
//				where.andEqual("record_flag_s", "A");
//				where.andEqual("materialcode_s", item.getMaterialcode_s());
//				where.andEqual("smalltime_f", item.getSmalltime_f());
//				where.andEqual("overtime_f", item.getOvertime_f());
//				where.andEqual("spare1_s", item.getSpare1_s());
//				List<Map<String, Object>> list = findMapByWhere(where);
//				System.err.println(list);
//
//				if (list.size() > 0) {
//					ist = true;
//				}
				
				insertedList.add(item);
			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				update(insertedList);
			}
		}
		return mun;
    
    }
    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}
    
    @SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");
		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
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

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
    public Map<String, Object> datagridUDA1(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsGroupUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalGroupUDA(filter, page));
		return ret;

	}
    
    @SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsGroupUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridgroupUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridgroupUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridgroupUDA_rows", filter.getFilter());
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

	public Long datagridTotalGroupUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridgroupUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridgroupUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridgroupUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
    /**
	 * 查出物料规格显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialSpec() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialSpec"));
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialCode() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialCode"));
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialGroup() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialGroup"));
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料编号查询规格
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMaterialSpecByCode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialSpecByCode"));
		query.setParameter("materialcode", materialcode);
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料编号查询物料信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getInfoByCode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getInfoByCode"));
		query.setParameter("materialcode", materialcode);
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料编号查询物料组内的物料
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchSameGroupByCode(String materialgroup) {
		SQLQuery query = createSQLQuery(getSQL("searchSameGroupByCode"));
		query.setParameter("materialgroup", materialgroup);
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	public void savepartclass(String materialgroup, String smalltime,
			String overtime, String spare1_s, String spare2_s) {
		SQLQuery query = createSQLQuery(getSQL("savepartclass"));
		query.setParameter("materialgroup", materialgroup);
		query.setParameter("smalltime", smalltime);
		query.setParameter("overtime", overtime);
		query.setParameter("spare1_s", spare1_s);
		query.setParameter("spare2_s", spare2_s);
		query.executeUpdate();
	}

}
