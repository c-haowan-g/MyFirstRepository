/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.PolyWeight;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * 密炼胶料产出称量实绩表
 * @author 陈国强
 * @Date 2020-09-17 17:04:06
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PolyWeightServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return PolyWeight.class;
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
        		PolyWeight polyweight=(PolyWeight) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), PolyWeight.class);
        		//polyweight.setCreated_time_t(new Date()); 
        		list.add(polyweight);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		PolyWeight polyweight =(PolyWeight) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), PolyWeight.class);
        		//polyweight.setCreated_time_t(new Date()); 
        		list.add(polyweight);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		PolyWeight polyweight=(PolyWeight) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), PolyWeight.class);
        		//polyweight.setCreated_time_t(new Date()); 
        		update(polyweight);
        	}
        }
    
    }
    public Map<String, Object> filter(Filter filter, Page page)
    	    throws Exception
    	  {
    	String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", rows(filter, page));
		
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", total(filter, page));
	
		return ret;
//    	    filter.set("s_factory_s", LLWebUtils.factory());
//    	    Map result = new HashMap();
//    	    result.put("rows", rows(filter, page));
//    	    result.put("total", total(filter, page));
//    	    return result;
    	  }
    public Map<String, Object> filterpass(Filter filter, Page page)
    	    throws Exception
    	  {
    	String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", rowspass(filter, page));
		
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", totalpass(filter, page));
		
		return ret;
    	  }
    
        @SuppressWarnings({ "unchecked" })
    	  public List<Map<String, Object>> rows(Filter filter, Page page)
    	    throws Exception
    	  {  
        	SQLQuery query = null;
        	if (filter.getFilter().containsKey("equip_code_s")) {
      	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
      	      {if (getSQL("datagridUDA_xlcl") == null)
      			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_xlcl的SQL语句定义");

      		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
      		System.out.println(dataSql);

      		 query = createSQLQuery(dataSql);}
      	      else {
      	    	if (getSQL("datagridUDA_rows") == null)
        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

        		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
        		System.out.println(dataSql);

        		 query = createSQLQuery(dataSql);
      	      }
      	    }
      	    else {
      	    	if (getSQL("datagridUDA_rows") == null)
        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

        		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
        		System.out.println(dataSql);

        		 query = createSQLQuery(dataSql);
      	    }
        	
    		
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
    	   /* String shift_code_s = "";
    	    String equip_code_s = "";
    	    String wweight_type_s = "";
    	    String warning_sgn_s = "";
    	    String material_name_s = "";
    	    String s_factory_s = "";
    	    String prodtype = "";
    	    SQLQuery query = null;
    	    if (filter.getFilter().containsKey("equip_code_s")) {
    	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    	        query = createSQLQuery(getSQL("datagridUDA_xlcl", filter));
    	      else {
    	        query = createSQLQuery(getSQL("datagridUDA_rows", filter));
    	      }
    	    }
    	    else {
    	      query = createSQLQuery(getSQL("datagridUDA_rows", filter));
    	    }

    	    if (((String)filter.getFilter().get("s_factory_s")).toString().equals("0")) {
    	      s_factory_s = "2";
    	      filter.set("s_factory_s", s_factory_s);
    	      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    	    } else {
    	      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    	    }

    	    query.setParameter("receive_time_t", ((String)filter.getFilter().get("receive_time_t")).toString());
    	    query.setParameter("end_time_t", ((String)filter.getFilter().get("end_time_t"))
    	      .toString());
    	    if (filter.getFilter().containsKey("shift_code_s"))
    	    {
    	      shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    	        .toString();
    	      query.setParameter("shift_code_s", shift_code_s);
    	    }
    	    if (filter.getFilter().containsKey("equip_code_s"))
    	    {
    	      equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    	        .toString();
    	      query.setParameter("equip_code_s", equip_code_s);
    	    }
    	    if (filter.getFilter().containsKey("wweight_type_s")) {
    	      wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    	      filter.set("wweight_type_s", searchName(wweight_type_s));
    	      query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    	    }
    	    if (filter.getFilter().containsKey("warning_sgn_s")) {
    	      warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    	      query.setParameter("warning_sgn_s", warning_sgn_s);
    	    }
    	    if (filter.getFilter().containsKey("material_name_s")) {
    	      material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    	      query.setParameter("material_name_s", material_name_s);
    	    }
    	    if (filter.getFilter().containsKey("prodtype")) {
    	      prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    	      query.setParameter("prodtype", prodtype);
    	    }

    	    if (page.getAll() == 0) {
    	      query.setMaxResults(page.getRows());
    	      query.setFirstResult((page.getPage() - 1) * page.getRows());
    	    }
    	    System.out.println(query);
    	    List result = query.list();
    	    return result;*/
    	  }

    	  public Long total(Filter filter, Page page) throws Exception {
    		  SQLQuery query = null;
    		  if (filter.getFilter().containsKey("equip_code_s")) {
      	        if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
      	          {if (getSQL("datagridUDA_totalxlcl") == null)
      				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_totalxlcl的SQL语句定义");

      			String totalSql = getSQL("datagridUDA_totalxlcl", filter.getFilter());

      			if (page.getTotalRows() == 0L) {

      				 query = getSession().createSQLQuery(totalSql);
      				setParameter(query, filter);
      				return ((BigDecimal) query.uniqueResult()).longValue();
      			} else {
      				
      				return page.getTotalRows();
      			}}
      	        else {
      	        	if (getSQL("datagridUDA_total") == null)
        				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

        			String totalSql = getSQL("datagridUDA_total", filter.getFilter());

        			if (page.getTotalRows() == 0L) {

        				 query = getSession().createSQLQuery(totalSql);
        				setParameter(query, filter);
        				return ((BigDecimal) query.uniqueResult()).longValue();
        			} else {
        				
        				return page.getTotalRows();
        			}
      	        }
      	      }
      	      else {
      	    	if (getSQL("datagridUDA_total") == null)
    				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

    			String totalSql = getSQL("datagridUDA_total", filter.getFilter());

    			if (page.getTotalRows() == 0L) {

    				 query = getSession().createSQLQuery(totalSql);
    				setParameter(query, filter);
    				return ((BigDecimal) query.uniqueResult()).longValue();
    			} else {
    				
    				return page.getTotalRows();
    			}
      	      }
    		  
    	    /*if (page.getTotalRows() == 0L) {
    	      String shift_code_s = "";
    	      String equip_code_s = "";
    	      String wweight_type_s = "";
    	      String warning_sgn_s = "";
    	      String start_time_t = "";
    	      String end_time_t = "";
    	      String material_name_s = "";
    	      String prodtype = "";
    	      SQLQuery query = null;

    	      if (filter.getFilter().containsKey("equip_code_s")) {
    	        if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    	          query = getSession().createSQLQuery(getSQL("datagridUDA_totalxlcl", filter));
    	        else {
    	          query = getSession().createSQLQuery(getSQL("datagridUDA_total", filter));
    	        }
    	      }
    	      else {
    	        query = getSession().createSQLQuery(getSQL("datagridUDA_total", filter));
    	      }

    	      query.setParameter("s_factory_s", 
    	        ((String)filter
    	        .getFilter().get("s_factory_s")).toString());
    	      if (filter.getFilter().containsKey("shift_code_s"))
    	      {
    	        shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    	          .toString();
    	        query.setParameter("shift_code_s", shift_code_s);
    	      }
    	      if (filter.getFilter().containsKey("equip_code_s"))
    	      {
    	        equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    	          .toString();
    	        query.setParameter("equip_code_s", equip_code_s);
    	      }
    	      if (filter.getFilter().containsKey("wweight_type_s")) {
    	        wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    	        filter.set("wweight_type_s", searchName(wweight_type_s));
    	        query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    	      }
    	      if (filter.getFilter().containsKey("warning_sgn_s")) {
    	        warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    	        query.setParameter("warning_sgn_s", warning_sgn_s);
    	      }
    	      if (filter.getFilter().containsKey("receive_time_t"))
    	      {
    	        start_time_t = ((String)filter.getFilter().get("receive_time_t"))
    	          .toString();
    	        query.setParameter("receive_time_t", start_time_t);
    	      }
    	      if (filter.getFilter().containsKey("end_time_t")) {
    	        end_time_t = ((String)filter.getFilter().get("end_time_t")).toString();
    	        query.setParameter("end_time_t", end_time_t);
    	      }
    	      if (filter.getFilter().containsKey("material_name_s")) {
    	        material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    	        query.setParameter("material_name_s", material_name_s);
    	      }
    	      if (filter.getFilter().containsKey("prodtype")) {
    	        prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    	        query.setParameter("prodtype", prodtype);
    	      }
    	      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    	    }
    	    return Long.valueOf(page.getTotalRows());*/
    	  }
    	  public List<Map<String, Object>> rowspass(Filter filter, Page page)
    	    	    throws Exception
    	    	  {
    		  SQLQuery query = null;
          	if (filter.getFilter().containsKey("equip_code_s")) {
        	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
        	      {if (getSQL("datagridUDA_xlclhg") == null)
        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_xlclhg的SQL语句定义");

        		String dataSql = getSQL("datagridUDA_xlclhg", filter.getFilter());
        		System.out.println(dataSql);

        		 query = createSQLQuery(dataSql);}
        	      else {
        	    	if (getSQL("datagridUDA_rowshg") == null)
          			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rowshg的SQL语句定义");

          		String dataSql = getSQL("datagridUDA_rowshg", filter.getFilter());
          		System.out.println(dataSql);

          		 query = createSQLQuery(dataSql);
        	      }
        	    }
        	    else {
        	    	if (getSQL("datagridUDA_rowshg") == null)
          			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rowshg的SQL语句定义");

          		String dataSql = getSQL("datagridUDA_rowshg", filter.getFilter());
          		System.out.println(dataSql);

          		 query = createSQLQuery(dataSql);
        	    }
      		
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
      		/*
    	    	    String shift_code_s = "";
    	    	    String equip_code_s = "";
    	    	    String wweight_type_s = "";
    	    	    String warning_sgn_s = "";
    	    	    String material_name_s = "";
    	    	    String s_factory_s = "";
    	    	    String prodtype = "";
    	    	    SQLQuery query = null;
    	    	    if (filter.getFilter().containsKey("equip_code_s")) {
    	    	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    	    	        query = createSQLQuery(getSQL("datagridUDA_xlclhg", filter));
    	    	      else {
    	    	        query = createSQLQuery(getSQL("datagridUDA_rowshg", filter));
    	    	      }
    	    	    }
    	    	    else {
    	    	      query = createSQLQuery(getSQL("datagridUDA_rowshg", filter));
    	    	    }

    	    	    if (((String)filter.getFilter().get("s_factory_s")).toString().equals("0")) {
    	    	      s_factory_s = "2";
    	    	      filter.set("s_factory_s", s_factory_s);
    	    	      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    	    	    } else {
    	    	      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    	    	    }
    	    	    query.setParameter("receive_time_t", 
    	    	      ((String)filter
    	    	      .getFilter().get("receive_time_t")).toString());
    	    	    query.setParameter("end_time_t", ((String)filter.getFilter().get("end_time_t"))
    	    	      .toString());
    	    	    if (filter.getFilter().containsKey("shift_code_s"))
    	    	    {
    	    	      shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    	    	        .toString();
    	    	      query.setParameter("shift_code_s", shift_code_s);
    	    	    }
    	    	    if (filter.getFilter().containsKey("equip_code_s"))
    	    	    {
    	    	      equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    	    	        .toString();
    	    	      query.setParameter("equip_code_s", equip_code_s);
    	    	    }
    	    	    if (filter.getFilter().containsKey("wweight_type_s")) {
    	    	      wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    	    	      filter.set("wweight_type_s", searchName(wweight_type_s));
    	    	      query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    	    	    }
    	    	    if (filter.getFilter().containsKey("warning_sgn_s")) {
    	    	      warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    	    	      query.setParameter("warning_sgn_s", warning_sgn_s);
    	    	    }
    	    	    if (filter.getFilter().containsKey("material_name_s")) {
    	    	      material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    	    	      query.setParameter("material_name_s", material_name_s);
    	    	    }
    	    	    if (filter.getFilter().containsKey("prodtype")) {
    	    	      prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    	    	      query.setParameter("prodtype", prodtype);
    	    	    }

    	    	    if (page.getAll() == 0) {
    	    	      query.setMaxResults(page.getRows());
    	    	      query.setFirstResult((page.getPage() - 1) * page.getRows());
    	    	    }
    	    	    List result = query.list();
    	    	    return result;*/
    	    	  }
    	    	  public Long totalpass(Filter filter, Page page) throws Exception {
    	    		  SQLQuery query = null;
    	    		  if (filter.getFilter().containsKey("equip_code_s")) {
    	      	        if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    	      	          {if (getSQL("datagridUDA_totalxlclhg") == null)
    	      				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_totalxlclhg的SQL语句定义");

    	      			String totalSql = getSQL("datagridUDA_totalxlclhg", filter.getFilter());

    	      			if (page.getTotalRows() == 0L) {

    	      				 query = getSession().createSQLQuery(totalSql);
    	      				setParameter(query, filter);
    	      				return ((BigDecimal) query.uniqueResult()).longValue();
    	      			} else {
    	      				
    	      				return page.getTotalRows();
    	      			}}
    	      	        else {
    	      	        	if (getSQL("datagridUDA_totalhg") == null)
    	        				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_totalhg的SQL语句定义");

    	        			String totalSql = getSQL("datagridUDA_totalhg", filter.getFilter());

    	        			if (page.getTotalRows() == 0L) {

    	        				 query = getSession().createSQLQuery(totalSql);
    	        				setParameter(query, filter);
    	        				return ((BigDecimal) query.uniqueResult()).longValue();
    	        			} else {
    	        				
    	        				return page.getTotalRows();
    	        			}
    	      	        }
    	      	      }
    	      	      else {
    	      	    	if (getSQL("datagridUDA_totalhg") == null)
    	    				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_totalhg的SQL语句定义");

    	    			String totalSql = getSQL("datagridUDA_totalhg", filter.getFilter());

    	    			if (page.getTotalRows() == 0L) {

    	    				 query = getSession().createSQLQuery(totalSql);
    	    				setParameter(query, filter);
    	    				return ((BigDecimal) query.uniqueResult()).longValue();
    	    			} else {
    	    				
    	    				return page.getTotalRows();
    	    			}
    	    			}
    	    	    /*if (page.getTotalRows() == 0L) {
    	    	      String shift_code_s = "";
    	    	      String equip_code_s = "";
    	    	      String wweight_type_s = "";
    	    	      String warning_sgn_s = "";
    	    	      String start_time_t = "";
    	    	      String end_time_t = "";
    	    	      String material_name_s = "";
    	    	      String prodtype = "";
    	    	      SQLQuery query = null;

    	    	      if (filter.getFilter().containsKey("equip_code_s")) {
    	    	        if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    	    	          query = getSession().createSQLQuery(getSQL("datagridUDA_totalxlclhg", filter));
    	    	        else {
    	    	          query = getSession().createSQLQuery(getSQL("datagridUDA_totalhg", filter));
    	    	        }
    	    	      }
    	    	      else {
    	    	        query = getSession().createSQLQuery(getSQL("datagridUDA_totalhg", filter));
    	    	      }

    	    	      query.setParameter("s_factory_s", 
    	    	        ((String)filter
    	    	        .getFilter().get("s_factory_s")).toString());
    	    	      if (filter.getFilter().containsKey("shift_code_s"))
    	    	      {
    	    	        shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    	    	          .toString();
    	    	        query.setParameter("shift_code_s", shift_code_s);
    	    	      }
    	    	      if (filter.getFilter().containsKey("equip_code_s"))
    	    	      {
    	    	        equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    	    	          .toString();
    	    	        query.setParameter("equip_code_s", equip_code_s);
    	    	      }
    	    	      if (filter.getFilter().containsKey("wweight_type_s")) {
    	    	        wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    	    	        filter.set("wweight_type_s", searchName(wweight_type_s));
    	    	        query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    	    	      }
    	    	      if (filter.getFilter().containsKey("warning_sgn_s")) {
    	    	        warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    	    	        query.setParameter("warning_sgn_s", warning_sgn_s);
    	    	      }
    	    	      if (filter.getFilter().containsKey("receive_time_t"))
    	    	      {
    	    	        start_time_t = ((String)filter.getFilter().get("receive_time_t"))
    	    	          .toString();
    	    	        query.setParameter("receive_time_t", start_time_t);
    	    	      }
    	    	      if (filter.getFilter().containsKey("end_time_t")) {
    	    	        end_time_t = ((String)filter.getFilter().get("end_time_t")).toString();
    	    	        query.setParameter("end_time_t", end_time_t);
    	    	      }
    	    	      if (filter.getFilter().containsKey("material_name_s")) {
    	    	        material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    	    	        query.setParameter("material_name_s", material_name_s);
    	    	      }
    	    	      if (filter.getFilter().containsKey("prodtype")) {
    	    	        prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    	    	        query.setParameter("prodtype", prodtype);
    	    	      }
    	    	      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    	    	    }
    	    	    return Long.valueOf(page.getTotalRows());*/
    	    	  }
    	  public String searchName(String ids)
    	  {
    	    SQLQuery query = getSession().createSQLQuery(getSQL("serchname"));
    	    query.setParameter("ids", ids);
    	    return (String)query.uniqueResult();
    	  }
    	  
    	  public Map<String, Object> filterexeprot(Filter filter, Page page) throws Exception {
    		 
        	String FACTORY = "s_factory_s";

    		if (!filter.getFilter().containsKey(FACTORY)) {
    			try {
    				filter.set("s_factory_s", LLWebUtils.factory());
    			} catch (Exception e) {
    				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
    			}
    		}
    		Map<String, Object> ret = new HashMap<String, Object>();
    		ret.put("rows", rowsexeprot(filter, page));
    		
    		filter.setOrder(null);
    		filter.setSort(null);
    		ret.put("total", total(filter, page));
    	
    		return ret;
    			   /* filter.set("s_factory_s", LLWebUtils.factory());
    			    Map result = new HashMap();
    			    result.put("rows", rowsexeprot(filter, page));
    			    result.put("total", total(filter, page));
    			    return result;*/
    			  }

    			  public Map<String, Object> filterexeprots(Filter filter, Page page, Class clazz) throws Exception {
    				  String FACTORY = "s_factory_s";

    		    		if (!filter.getFilter().containsKey(FACTORY)) {
    		    			try {
    		    				filter.set("s_factory_s", LLWebUtils.factory());
    		    			} catch (Exception e) {
    		    				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
    		    			}
    		    		}
    		    		Map<String, Object> ret = new HashMap<String, Object>();
    		    		ret.put("rows", rowsexeprots(filter, page));
    		    		
    		    		filter.setOrder(null);
    		    		filter.setSort(null);
    		    		ret.put("total", totalpass(filter, page));
    		    	
    		    		return ret;
    				  /*filter.set("s_factory_s", LLWebUtils.factory());
    			    Map result = new HashMap();
    			    result.put("rows", rowsexeprots(filter, page, clazz));
    			    result.put("total", totalpass(filter, page));
    			    return result;*/
    			  }

    			  public List<Map<String, Object>> rowsexeprots(Filter filter, Page page)
    			    throws Exception
    			  {
    				  SQLQuery query = null;
    		          	if (filter.getFilter().containsKey("equip_code_s")) {
    		        	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    		        	      {if (getSQL("datagridUDA_xlclhg") == null)
    		        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_xlclhg的SQL语句定义");

    		        		String dataSql = getSQL("datagridUDA_xlclhg", filter.getFilter());
    		        		System.out.println(dataSql);

    		        		 query = createSQLQuery(dataSql);}
    		        	      else {
    		        	    	if (getSQL("datagridUDA_rowshg") == null)
    		          			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rowshg的SQL语句定义");

    		          		String dataSql = getSQL("datagridUDA_rowshg", filter.getFilter());
    		          		System.out.println(dataSql);

    		          		 query = createSQLQuery(dataSql);
    		        	      }
    		        	    }
    		        	    else {
    		        	    	if (getSQL("datagridUDA_rowshg") == null)
    		          			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rowshg的SQL语句定义");

    		          		String dataSql = getSQL("datagridUDA_rowshg", filter.getFilter());
    		          		System.out.println(dataSql);

    		          		 query = createSQLQuery(dataSql);
    		        	    }
    		      		
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
    				  /*String shift_code_s = "";
    			    String equip_code_s = "";
    			    String wweight_type_s = "";
    			    String warning_sgn_s = "";
    			    String material_name_s = "";
    			    String s_factory_s = "";
    			    String prodtype = "";

    			    SQLQuery query = null;
    			    if (filter.getFilter().containsKey("equip_code_s")) {
    			      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    			        query = createSQLQuery(getSQL("datagrid_xlclhg", filter));
    			      else {
    			        query = createSQLQuery(getSQL("datagrid_rowshg", filter));
    			      }
    			    }
    			    else {
    			      query = createSQLQuery(getSQL("datagrid_rowshg", filter));
    			    }

    			    if (((String)filter.getFilter().get("s_factory_s")).toString().equals("0")) {
    			      s_factory_s = "2";
    			      filter.set("s_factory_s", s_factory_s);
    			      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    			    } else {
    			      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    			    }
    			    query.setParameter("receive_time_t", 
    			      ((String)filter
    			      .getFilter().get("receive_time_t")).toString());
    			    query.setParameter("end_time_t", ((String)filter.getFilter().get("end_time_t"))
    			      .toString());
    			    if (filter.getFilter().containsKey("shift_code_s"))
    			    {
    			      shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    			        .toString();
    			      query.setParameter("shift_code_s", shift_code_s);
    			    }
    			    if (filter.getFilter().containsKey("equip_code_s"))
    			    {
    			      equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    			        .toString();
    			      query.setParameter("equip_code_s", equip_code_s);
    			    }
    			    if (filter.getFilter().containsKey("wweight_type_s")) {
    			      wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    			      filter.set("wweight_type_s", searchName(wweight_type_s));
    			      query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    			    }
    			    if (filter.getFilter().containsKey("warning_sgn_s")) {
    			      warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    			      query.setParameter("warning_sgn_s", warning_sgn_s);
    			    }
    			    if (filter.getFilter().containsKey("material_name_s")) {
    			      material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    			      query.setParameter("material_name_s", material_name_s);
    			    }
    			    if (filter.getFilter().containsKey("prodtype")) {
    			      prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    			      query.setParameter("prodtype", prodtype);
    			    }

    			    List result = query.list();
    			    return result;*/
    			  }

    			  public List<Map<String, Object>> rowsexeprot(Filter filter, Page page)
    			    throws Exception
    			  {
    				  SQLQuery query = null;
    		        	if (filter.getFilter().containsKey("equip_code_s")) {
    		      	      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    		      	      {if (getSQL("datagridUDA_xlcl") == null)
    		      			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_xlcl的SQL语句定义");

    		      		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
    		      		System.out.println(dataSql);

    		      		 query = createSQLQuery(dataSql);}
    		      	      else {
    		      	    	if (getSQL("datagridUDA_rows") == null)
    		        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

    		        		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
    		        		System.out.println(dataSql);

    		        		 query = createSQLQuery(dataSql);
    		      	      }
    		      	    }
    		      	    else {
    		      	    	if (getSQL("datagridUDA_rows") == null)
    		        			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

    		        		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
    		        		System.out.println(dataSql);

    		        		 query = createSQLQuery(dataSql);
    		      	    }
    		        	
    		    		
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
    				  /* String shift_code_s = "";
    			    String equip_code_s = "";
    			    String wweight_type_s = "";
    			    String warning_sgn_s = "";
    			    String material_name_s = "";
    			    String s_factory_s = "";
    			    String prodtype = "";
    			    SQLQuery query = null;
    			    if (filter.getFilter().containsKey("equip_code_s")) {
    			      if (((String)filter.getFilter().get("equip_code_s")).toString().contains("902"))
    			        query = createSQLQuery(getSQL("datagrid_xlcl", filter));
    			      else {
    			        query = createSQLQuery(getSQL("datagrid_rows", filter));
    			      }
    			    }
    			    else {
    			      query = createSQLQuery(getSQL("datagrid_rows", filter));
    			    }
    			    if (((String)filter.getFilter().get("s_factory_s")).toString().equals("0")) {
    			      s_factory_s = "2";
    			      filter.set("s_factory_s", s_factory_s);
    			      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    			    } else {
    			      query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s")).toString());
    			    }

    			    query.setParameter("receive_time_t", ((String)filter.getFilter().get("receive_time_t")).toString());
    			    query.setParameter("end_time_t", ((String)filter.getFilter().get("end_time_t"))
    			      .toString());
    			    if (filter.getFilter().containsKey("shift_code_s"))
    			    {
    			      shift_code_s = ((String)filter.getFilter().get("shift_code_s"))
    			        .toString();
    			      query.setParameter("shift_code_s", shift_code_s);
    			    }
    			    if (filter.getFilter().containsKey("equip_code_s"))
    			    {
    			      equip_code_s = ((String)filter.getFilter().get("equip_code_s"))
    			        .toString();
    			      query.setParameter("equip_code_s", equip_code_s);
    			    }
    			    if (filter.getFilter().containsKey("wweight_type_s")) {
    			      wweight_type_s = ((String)filter.getFilter().get("wweight_type_s")).toString();
    			      filter.set("wweight_type_s", searchName(wweight_type_s));
    			      query.setParameter("wweight_type_s", ((String)filter.getFilter().get("wweight_type_s")).toString());
    			    }
    			    if (filter.getFilter().containsKey("warning_sgn_s")) {
    			      warning_sgn_s = ((String)filter.getFilter().get("warning_sgn_s")).toString();
    			      query.setParameter("warning_sgn_s", warning_sgn_s);
    			    }
    			    if (filter.getFilter().containsKey("material_name_s")) {
    			      material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
    			      query.setParameter("material_name_s", material_name_s);
    			    }
    			    if (filter.getFilter().containsKey("prodtype")) {
    			      prodtype = ((String)filter.getFilter().get("prodtype")).toString();
    			      query.setParameter("prodtype", prodtype);
    			    }

    			    List result = query.list();
    			    return result;*/
    			  }
    			  public String exportService(HttpServletRequest request, HttpServletResponse response, List<Map<String, Object>> listUp, List<Map<String, Object>> listDown) throws UnsupportedEncodingException
    			  {
    			    HSSFWorkbook wb = new HSSFWorkbook();
    			    HSSFSheet sheet = wb.createSheet("称量记录信息");
    			    HSSFSheet sheet1 = wb.createSheet("称量合格信息");

    			    request.setCharacterEncoding("UTF-8");
    			    response.setCharacterEncoding("UTF-8");
    			    response.setContentType("application/x-download");

    			    String fileName = "密炼称量过程分析" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + ".xls";
    			    try {
    			      fileName = URLEncoder.encode(fileName, "UTF-8");
    			    } catch (UnsupportedEncodingException e) {
    			      e.printStackTrace();
    			    }
    			    HSSFCellStyle cellStyle = wb.createCellStyle();
    			    HSSFCellStyle cellStyleContent = wb.createCellStyle();

    			    cellStyle.setAlignment(HorizontalAlignment.CENTER);
    			    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

    			    cellStyle.setBorderBottom(BorderStyle.THIN);
    			    cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);
    			    cellStyle.setBorderTop(BorderStyle.THIN);
    			    cellStyle.setBorderRight(BorderStyle.THIN);

    			    cellStyleContent.setAlignment(HorizontalAlignment.CENTER);
    			    cellStyleContent.setVerticalAlignment(VerticalAlignment.CENTER);

    			    cellStyleContent.setBorderBottom(BorderStyle.THIN);
    			    cellStyleContent.setBorderLeft(BorderStyle.DASH_DOT_DOT);
    			    cellStyleContent.setBorderTop(BorderStyle.THIN);
    			    cellStyleContent.setBorderRight(BorderStyle.THIN);

    			    HSSFFont hssfFont = wb.createFont();

    			    hssfFont.setBold(true);
    			    hssfFont.setFontName("宋体");

    			    hssfFont.setFontHeightInPoints((short)13);

    			    HSSFFont hssfFontContent = wb.createFont();
    			    hssfFont.setFontName("宋体");

    			    hssfFontContent.setFontHeightInPoints((short)9);

    			    String[] arr = { "生产日期", "班次", "机台", "总车数", "车数", "配方名称", "是否超差", "称量时间", "物料名称", "设定重量", "实际重量", "设定误差", "实际误差", "称量类型", "生产方式" };
    			    String[] arr1 = { "物料名称", "称量类型", "总车数", "合格数", "不合格数", "合格率", "超上限", "超下限" };

    			    HSSFRow row = sheet.createRow(0);

    			    HSSFRow row1 = sheet1.createRow(0);

    			    for (int j = 0; j < arr.length; j++) {
    			      cellStyle.setFont(hssfFont);
    			      HSSFCell cell = row.createCell((short)j);
    			      cell.setCellStyle(cellStyle);
    			      cell.setCellValue(arr[j]);
    			    }

    			    for (int j = 0; j < arr1.length; j++)
    			    {
    			      cellStyle.setFont(hssfFont);
    			      HSSFCell cell1 = row1.createCell((short)j);
    			      cell1.setCellStyle(cellStyle);
    			      cell1.setCellValue(arr1[j]);
    			    }

    			    for (int j = 0; j < listUp.size(); j++) {
    			      row = sheet.createRow(j + 1);
    			      for (int i = 0; i < arr.length; i++) {
    			        cellStyleContent.setFont(hssfFontContent);
    			        HSSFCell cell = row.createCell((short)i);
    			        cell.setCellStyle(cellStyleContent);

    			        switch (i) {
    			        case 0:
    			          cell.setCellValue(((Map)listUp.get(j)).get("prod_date_s") == null ? "" : ((Map)listUp.get(j)).get("prod_date_s").toString());
    			          break;
    			        case 1:
    			          String SHIFT_CODE_S = "";
    			          if (((Map)listUp.get(j)).get("shift_code_s").equals("302001"))
    			          {
    			            SHIFT_CODE_S = "早班";
    			          }
    			          if (((Map)listUp.get(j)).get("shift_code_s").equals("302002"))
    			          {
    			            SHIFT_CODE_S = "中班";
    			          }
    			          if (((Map)listUp.get(j)).get("shift_code_s").equals("302003"))
    			          {
    			            SHIFT_CODE_S = "晚班";
    			          }
    			          cell.setCellValue(SHIFT_CODE_S);
    			          break;
    			        case 2:
    			          cell.setCellValue(((Map)listUp.get(j)).get("equip_name_s") == null ? "" : ((Map)listUp.get(j)).get("equip_name_s").toString());
    			          break;
    			        case 3:
    			          cell.setCellValue(((Map)listUp.get(j)).get("qty_complete_i") == null ? "" : ((Map)listUp.get(j)).get("qty_complete_i").toString());
    			          break;
    			        case 4:
    			          cell.setCellValue(((Map)listUp.get(j)).get("serial_id_i") == null ? "" : ((Map)listUp.get(j)).get("serial_id_i").toString());
    			          break;
    			        case 5:
    			          cell.setCellValue(((Map)listUp.get(j)).get("recipe_name") == null ? "" : ((Map)listUp.get(j)).get("recipe_name").toString());
    			          break;
    			        case 6:
    			          cell.setCellValue(((Map)listUp.get(j)).get("warning_sgn_s") == null ? "" : ((Map)listUp.get(j)).get("warning_sgn_s").toString());
    			          break;
    			        case 7:
    			          cell.setCellValue(((Map)listUp.get(j)).get("weight_time_s") == null ? "" : ((Map)listUp.get(j)).get("weight_time_s").toString());
    			          break;
    			        case 8:
    			          cell.setCellValue(((Map)listUp.get(j)).get("material_name_s") == null ? "" : ((Map)listUp.get(j)).get("material_name_s").toString());
    			          break;
    			        case 9:
    			          cell.setCellValue(((Map)listUp.get(j)).get("set_weight_s") == null ? "" : ((Map)listUp.get(j)).get("set_weight_s").toString());
    			          break;
    			        case 10:
    			          cell.setCellValue(((Map)listUp.get(j)).get("real_weight_s") == null ? "" : ((Map)listUp.get(j)).get("real_weight_s").toString());
    			          break;
    			        case 11:
    			          cell.setCellValue(((Map)listUp.get(j)).get("error_allow_s") == null ? "" : ((Map)listUp.get(j)).get("error_allow_s").toString());
    			          break;
    			        case 12:
    			          cell.setCellValue(((Map)listUp.get(j)).get("error_out_s") == null ? "" : ((Map)listUp.get(j)).get("error_out_s").toString());
    			          break;
    			        case 13:
    			          cell.setCellValue(((Map)listUp.get(j)).get("dictname_s") == null ? "" : ((Map)listUp.get(j)).get("dictname_s").toString());
    			          break;
    			        case 14:
    			          cell.setCellValue(((Map)listUp.get(j)).get("prodtype") == null ? "" : ((Map)listUp.get(j)).get("prodtype").toString());
    			        }

    			      }

    			    }

    			    for (int j = 0; j < listDown.size(); j++) {
    			      row = sheet1.createRow(j + 1);
    			      for (int i = 0; i < arr.length; i++) {
    			        cellStyleContent.setFont(hssfFontContent);
    			        HSSFCell cell = row.createCell((short)i);
    			        cell.setCellStyle(cellStyleContent);
    			        switch (i) {
    			        case 0:
    			          cell.setCellValue(((Map)listDown.get(j)).get("material_name_s") == null ? "" : ((Map)listDown.get(j)).get("material_name_s").toString());
    			          break;
    			        case 1:
    			          cell.setCellValue(((Map)listDown.get(j)).get("dictname_s") == null ? "" : ((Map)listDown.get(j)).get("dictname_s").toString());
    			          break;
    			        case 2:
    			          cell.setCellValue(((Map)listDown.get(j)).get("qty_complete_i") == null ? "" : ((Map)listDown.get(j)).get("qty_complete_i").toString());
    			          break;
    			        case 3:
    			          cell.setCellValue(((Map)listDown.get(j)).get("goodtotal") == null ? "" : ((Map)listDown.get(j)).get("goodtotal").toString());
    			          break;
    			        case 4:
    			          cell.setCellValue(((Map)listDown.get(j)).get("badtotal") == null ? "" : ((Map)listDown.get(j)).get("badtotal").toString());
    			          break;
    			        case 5:
    			          cell.setCellValue(((Map)listDown.get(j)).get("goodp") == null ? "" : ((Map)listDown.get(j)).get("goodp").toString());
    			          break;
    			        case 6:
    			          cell.setCellValue(((Map)listDown.get(j)).get("up") == null ? "" : ((Map)listDown.get(j)).get("up").toString());
    			          break;
    			        case 7:
    			          cell.setCellValue(((Map)listDown.get(j)).get("down") == null ? "" : ((Map)listDown.get(j)).get("down").toString());
    			        }

    			      }

    			    }

    			    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
    			    try {
    			      OutputStream out = response.getOutputStream();
    			      wb.write(out);
    			      out.close();
    			      System.out.println("输出完成");
    			      return "输出完成";
    			    } catch (Exception e) {
    			      System.out.println("文件输出失败!");
    			      e.printStackTrace();
    			    }return "文件输出失败!";
    			  }
}
