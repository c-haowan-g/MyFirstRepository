/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

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
import com.bluebirdme.mes.linglong.finalcheck.entity.Checkgradestorage;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 机检废次品入库确认表
 * @author 徐秉正
 * @Date 2020-09-04 15:18:22
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BgcheckgradestorageServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Checkgradestorage.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
	 * 按汇总查询
	 */
    public Map<String, Object> searchsum(Filter filter, Page page) throws Exception {
    	String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", codeRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", codeTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> codeRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("searchsum") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("searchsum", filter.getFilter());
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

		if (getSQL("searchsum_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("searchsum_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
  
   	
   	
   	/**
  	 * 按详细查询
  	 * 
  	 * @return
  	 */
	 public Map<String, Object> searchall(Filter filter, Page page) throws Exception {
		 String FACTORY = "s_factory_s";

			if (!filter.getFilter().containsKey(FACTORY)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}

			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("rows", typeRowsUDA(filter, page));
			filter.setOrder(null);
			filter.setSort(null);
			ret.put("total", typeTotalUDA(filter, page));
			return ret;

		}

		@SuppressWarnings({ "unchecked" })
		public List<Map<String, Object>> typeRowsUDA(Filter filter, Page page) throws Exception {
			if (getSQL("searchall") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

			String dataSql = getSQL("searchall", filter.getFilter());
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

			if (getSQL("searchall_total") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

			String totalSql = getSQL("searchall_total", filter.getFilter());

			if (page.getTotalRows() == 0L) {

				SQLQuery query = getSession().createSQLQuery(totalSql);
				setParameter(query, filter);
				return ((BigDecimal) query.uniqueResult()).longValue();
			} else {
				return page.getTotalRows();
			}
		}
	    


}
