/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.service;

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
import com.bluebirdme.mes.linglong.material.entity.MaterialInventory;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * 原材料库存表
 * @author 李德晓
 * @Date 2020-08-06 12:12:08
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaterialInventoryServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return MaterialInventory.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
        		//将MAP转换为实体
        		MaterialInventory materialinventory=(MaterialInventory) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MaterialInventory.class);
        		//materialinventory.setCreated_time_t(new Date()); 
        		list.add(materialinventory);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		MaterialInventory materialinventory =(MaterialInventory) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), MaterialInventory.class);
        		//materialinventory.setCreated_time_t(new Date()); 
        		list.add(materialinventory);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		MaterialInventory materialinventory=(MaterialInventory) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MaterialInventory.class);
        		//materialinventory.setCreated_time_t(new Date()); 
        		update(materialinventory);
        	}
        }
    
    }
   
    public List<Map<String, Object>> findStorageMaterial(String store_type_s) {
        SQLQuery query = createSQLQuery(getSQL("findStorageMaterial"));
        query.setParameter("store_type_s", store_type_s);
        List<Map<String, Object>> res = query.list();
        return res;
      }
     
      public List<Map<String, Object>> findStorageSupplier(String store_type_s, String material_code_s) {
        SQLQuery query = createSQLQuery(getSQL("findStorageSupplier"));
        query.setParameter("store_type_s", store_type_s);
        query.setParameter("material_code_s", material_code_s);
        List<Map<String, Object>> res = query.list();
        return res;
      }
      
      /*public List<Map<String, Object>> findCancelQuery(String barcode) {
        SQLQuery query = createSQLQuery(getSQL("findCancelQuery"));
        query.setParameter("supplier_lot_no_s", barcode);
        List<Map<String, Object>> res = query.list();
        return res;
      }*/
      
     /* public String rawClear(MaterialInventory materialInventory) {
        String id = materialInventory.getId_s();
        String userName = (WebUtils.getUser()).userName;
        String userCode = (WebUtils.getUser()).userCode;
        WMSWSInterface portType = (new WMSWSImplementService()).getWMSWSImplementPort();
        String message = portType.reciveRAWClearWarehouseByMES(id, userCode, userName, "", "", "", "", "");
        return message;
      }
      
      public String qualityRelease(MaterialInventory m) {
        String barCode = m.getSupplier_lot_no_s();
        String storeCode = m.getStore_code_s();
        String stateCode = m.getState_code_s();
        String reasCode = m.getReas_code_s();
        String spare7 = m.getSpare7_s();
        String userName = (WebUtils.getUser()).userName;
        String userCode = (WebUtils.getUser()).userCode;
        WMSWSImplementService wsexinterface = new WMSWSImplementService();
        MESWSInterface portType = wsexinterface.getWMSWSImplementPort();
        MaterialInventory materialInventory = new MaterialInventory();
        String state = "";
        try {
          state = portType.reciveRAWReleaseWarehouseByPDA(barCode, storeCode, stateCode, reasCode, userCode, userName, spare7, "", "", "", "");
          materialInventory.setSpare10_s(state);
        } catch (Exception e) {
          state = e.getMessage();
        } 
        return state;
      }*/
     
      public List<Map<String, Object>> getStoreUnit(String store_type_s) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getStoreUnit"));
        query.setParameter("store_type_s", store_type_s);
        return query.list();
      }
      public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

  		/*String FACTORY = "s_factory_s";

  		if (!filter.getFilter().containsKey(FACTORY)) {
  			try {
  				filter.set("s_factory_s", LLWebUtils.factory());
  			} catch (Exception e) {
  				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
  			}
  		}*/


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
  	public Map<String, Object> datagridhis(Filter filter, Page page, Class<?> clazz) throws Exception {
  	    Map<String, Object> ret = new HashMap<>();
  	    ret.put("rows", datagridRowsHis(filter, page, clazz));
  	    filter.setOrder(null);
  	    filter.setSort(null);
  	    ret.put("total", datagridTotalHis(filter, page));
  	    return ret;
  	  }
  	public <K> List<K> datagridRowsHis(Filter filter, Page page, Class<K> clazz) throws Exception {
  	    if (getSQL("datagrid_rowshis") == null)
  	      throw new Exception(getClass() + ".xml"); 
  	    String dataSql = getSQL("datagrid_rowshis", filter.getFilter());
  	    SQLQuery query = createSQLQuery(dataSql, (clazz == null) ? getEntity() : clazz);
  	    setParameter(query, filter);
  	    if (page.getAll() == 0) {
  	      query.setMaxResults(page.getRows());
  	      query.setFirstResult((page.getPage() - 1) * page.getRows());
  	    } 
  	    return query.list();
  	  }
  	public Long datagridTotalHis(Filter filter, Page page) throws Exception {
  	    if (getSQL("datagrid_totalhis") == null)
  	      throw new Exception(getClass() + ".xml"); 
  	    String totalSql = getSQL("datagrid_totalhis", filter.getFilter());
  	    if (page.getTotalRows() == 0L) {
  	      SQLQuery query = getSession().createSQLQuery(totalSql);
  	      setParameter(query, filter);
  	      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
  	    } 
  	    return Long.valueOf(page.getTotalRows());
  	  }

    }
