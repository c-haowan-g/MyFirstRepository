/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.Ledger;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * (半部件)库存台账
 * @author 栾和源
 * @Date 2020-03-05 16:11:38
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class LedgerServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Ledger.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    /**
   	 * 按物料编码和库存类型查询
   	 * 
   	 * @return
   	 */
    
    public Map<String, Object> searchAll(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", allRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", allTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> allRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("searchAll") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("searchAll", filter.getFilter());
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

	public Long allTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("searchAll_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("searchAll_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
   	 * 按物料编码查询
   	 * 
   	 * @return
   	 */
    
    public Map<String, Object> searchByMaterialCode(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", codeRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", codeTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> codeRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("searchByMaterialCode") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("searchByMaterialCode", filter.getFilter());
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

	public Long codeTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("searchByMaterialCode_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("searchByMaterialCode_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
  
   	
   	
   	/**
  	 * 按库存类型查询
  	 * 
  	 * @return
  	 */
	 public Map<String, Object> searchByStockType(Filter filter, Page page) throws Exception {

			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("rows", typeRowsUDA(filter, page));
			filter.setOrder(null);
			filter.setSort(null);
			ret.put("total", typeTotalUDA(filter, page));
			return ret;

		}

		@SuppressWarnings({ "unchecked" })
		public List<Map<String, Object>> typeRowsUDA(Filter filter, Page page) throws Exception {
			if (getSQL("searchByStockType") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

			String dataSql = getSQL("searchByStockType", filter.getFilter());
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

		public Long typeTotalUDA(Filter filter, Page page) throws Exception {

			if (getSQL("searchByStockType_total") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

			String totalSql = getSQL("searchByStockType_total", filter.getFilter());

			if (page.getTotalRows() == 0L) {

				SQLQuery query = getSession().createSQLQuery(totalSql);
				setParameter(query, filter);
				return ((BigDecimal) query.uniqueResult()).longValue();
			} else {
				return page.getTotalRows();
			}
		}

		public List<Map<String, Object>> getSummaryInfo(List<String> summaryConditionList, Map<String, String> queryMap) {
		    String sqlCommon = "";
		    if (LLWebUtils.factory().equals("1"))
		      sqlCommon = "sum(l_num_f) current_num_f from AT_A_SM_LEDGER t where t.RECORD_FLAG_S='A' and t.S_FACTORY_S='1' and t.stocktype_s in('112003','112002')";
		    else {
		      sqlCommon = "sum(l_num_f) current_num_f from AT_A_SM_LEDGER t where t.RECORD_FLAG_S='A' and t.S_FACTORY_S='2' and t.stocktype_s in('112003','112002') ";
		    }
		    String sqlSelect = "select ";
		    String sqlGroup = "group by ";
		    String sqlOrder = "";
		    Integer length = Integer.valueOf(summaryConditionList.size());
		    Integer count = Integer.valueOf(0);
		    String equip_code_s = ((String)queryMap.get("equip_code_s")).toString();
		    String equipdescription_s = ((String)queryMap.get("equipdescription_s")).toString();
		    String location_s = ((String)queryMap.get("location_s")).toString();
		    String materielcode_s = ((String)queryMap.get("materielcode_s")).toString();
		    String materielname_s = ((String)queryMap.get("materielname_s")).toString();
		    String sortname = "";
		    String sortorder = "";
		    if (queryMap.containsKey(sortname)) {
		      sortname = " order by " + ((String)queryMap.get("sortname")).toString();
		      sortorder = ((String)queryMap.get("sortorder")).toString();
		    }
		    if (!sortname.isEmpty()) {
		      sqlOrder = sqlOrder + " " + sortname + " " + sortorder;
		    }

		    if (!equip_code_s.isEmpty()) {
		      sqlCommon = sqlCommon + "and t.equip_code_s like '%" + equip_code_s + "%'";
		    }
		    if (!equipdescription_s.isEmpty()) {
		      sqlCommon = sqlCommon + "and t.equipdescription_s like '%" + equipdescription_s + "%'";
		    }
		    if (!location_s.isEmpty()) {
		      sqlCommon = sqlCommon + "and t.location_s like '%" + location_s + "%'";
		    }
		    if (!materielcode_s.isEmpty()) {
		      sqlCommon = sqlCommon + "and t.materielcode_s like '%" + materielcode_s + "%'";
		    }
		    if (!materielname_s.isEmpty())
		      sqlCommon = sqlCommon + "and t.materielname_s like '%" + materielname_s + "%'";
		    Integer localInteger1;
		    Integer localInteger2;
		    if (summaryConditionList.contains("barcode_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.barcode_s,";
		        sqlGroup = sqlGroup + "t.barcode_s";
		      } else {
		        sqlSelect = sqlSelect + "t.barcode_s,";
		        sqlGroup = sqlGroup + "t.barcode_s,";
		      }
		    }
		    if (summaryConditionList.contains("vehicles_code_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.vehicles_code_s,";
		        sqlGroup = sqlGroup + "t.vehicles_code_s";
		      } else {
		        sqlSelect = sqlSelect + "t.vehicles_code_s,";
		        sqlGroup = sqlGroup + "t.vehicles_code_s,";
		      }
		    }
		    if (summaryConditionList.contains("materielcode_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.materielcode_s,";
		        sqlGroup = sqlGroup + "t.materielcode_s";
		      } else {
		        sqlSelect = sqlSelect + "t.materielcode_s,";
		        sqlGroup = sqlGroup + "t.materielcode_s,";
		      }
		    }
		    if (summaryConditionList.contains("materielname_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.materielname_s,";
		        sqlGroup = sqlGroup + "t.materielname_s";
		      } else {
		        sqlSelect = sqlSelect + "t.materielname_s,";
		        sqlGroup = sqlGroup + "t.materielname_s,";
		      }
		    }
		    if (summaryConditionList.contains("quality_status_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.quality_status_s,";
		        sqlGroup = sqlGroup + "t.quality_status_s";
		      } else {
		        sqlSelect = sqlSelect + "t.quality_status_s,";
		        sqlGroup = sqlGroup + "t.quality_status_s,";
		      }
		    }
		    if (summaryConditionList.contains("equip_code_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.equip_code_s,";
		        sqlGroup = sqlGroup + "t.equip_code_s";
		      } else {
		        sqlSelect = sqlSelect + "t.equip_code_s,";
		        sqlGroup = sqlGroup + "t.equip_code_s,";
		      }
		    }
		    if (summaryConditionList.contains("equipdescription_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.equipdescription_s,";
		        sqlGroup = sqlGroup + "t.equipdescription_s";
		      } else {
		        sqlSelect = sqlSelect + "t.equipdescription_s,";
		        sqlGroup = sqlGroup + "t.equipdescription_s,";
		      }
		    }
		    if (summaryConditionList.contains("mainoperator_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.mainoperator_s,";
		        sqlGroup = sqlGroup + "t.mainoperator_s";
		      } else {
		        sqlSelect = sqlSelect + "t.mainoperator_s,";
		        sqlGroup = sqlGroup + "t.mainoperator_s,";
		      }
		    }
		    if (summaryConditionList.contains("location_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.location_s,";
		        sqlGroup = sqlGroup + "t.location_s";
		      } else {
		        sqlSelect = sqlSelect + "t.location_s,";
		        sqlGroup = sqlGroup + "t.location_s,";
		      }
		    }
		    if (summaryConditionList.contains("productiondate_t")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.productiondate_t,";
		        sqlGroup = sqlGroup + "t.productiondate_t";
		      } else {
		        sqlSelect = sqlSelect + "t.productiondate_t,";
		        sqlGroup = sqlGroup + "t.productiondate_t,";
		      }
		    }
		    if (summaryConditionList.contains("outputtime_t")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.outputtime_t,";
		        sqlGroup = sqlGroup + "t.outputtime_t";
		      } else {
		        sqlSelect = sqlSelect + "t.outputtime_t,";
		        sqlGroup = sqlGroup + "t.outputtime_t,";
		      }
		    }
		    if (summaryConditionList.contains("stocktype_s")) {
		      localInteger1 = count; localInteger2 = count = Integer.valueOf(count.intValue() + 1);
		      if (count == length) {
		        sqlSelect = sqlSelect + "t.stocktype_s,";
		        sqlGroup = sqlGroup + "t.stocktype_s";
		      } else {
		        sqlSelect = sqlSelect + "t.stocktype_s,";
		        sqlGroup = sqlGroup + "t.stocktype_s,";
		      }
		    }
		    SQLQuery query = createSQLQuery(sqlSelect + " " + sqlCommon + " " + sqlGroup + " " + sqlOrder);
		    List result = query.list();
		    List newlist = new ArrayList();
		    for (int i = 0; i < result.size(); i++) {
		      newlist.add(TransformUpperCase.transformUpperCase((Map)result.get(i)));
		    }
		    return newlist;
		  }
	    

}
