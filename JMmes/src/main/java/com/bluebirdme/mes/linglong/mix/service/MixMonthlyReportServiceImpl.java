/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import com.bluebirdme.core.system.web.Filter;
import com.sun.xml.xsom.impl.scd.Iterators;

import java.util.Map;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.MixMonthlyReport;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * 密炼月产量表
 * @author 陈国强
 * @Date 2020-08-21 08:25:16
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MixMonthlyReportServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return MixMonthlyReport.class;
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
        		MixMonthlyReport mixmonthlyreport=(MixMonthlyReport) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MixMonthlyReport.class);
        		//mixmonthlyreport.setCreated_time_t(new Date()); 
        		list.add(mixmonthlyreport);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		MixMonthlyReport mixmonthlyreport =(MixMonthlyReport) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), MixMonthlyReport.class);
        		//mixmonthlyreport.setCreated_time_t(new Date()); 
        		list.add(mixmonthlyreport);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		MixMonthlyReport mixmonthlyreport=(MixMonthlyReport) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MixMonthlyReport.class);
        		//mixmonthlyreport.setCreated_time_t(new Date()); 
        		update(mixmonthlyreport);
        	}
        }
    
    }
    public List<Iterators.Map<String, Object>> getAll(Filter filter)
    {
      List list = null;
      list = getAll1(filter);

      return list;
    }
    public List<Iterators.Map<String, Object>> getAll1(Filter filter)
    {
      String month = filter.get("month_s").toString();
      String month_s = month.replace("-", "");
      SQLQuery query = createSQLQuery(getSQL("datagrid_rows"));
      query.setParameter("month_s", month_s);

      List list = query.list();
      return list;
    }
    public List<Iterators.Map<String, Object>> getmasternamelist(String begindate)
    	    throws Exception
    	  {
    	    SQLQuery query = createSQLQuery(getSQL("getmasternamelist"));
    	    String date = begindate.replace("-", "");
    	    query.setParameter("month_s", date);
    	    return query.list();
    	  }
    public List<Iterators.Map<String, Object>> getmaterialspeclist(String begindate)
    	    throws Exception
    	  {
    	    SQLQuery query = createSQLQuery(getSQL("getmaterialspeclist"));
    	    String[] strs = begindate.split("_");
    	    String spare1_s = strs[1];
    	    begindate = begindate.substring(0, begindate.length() - 2);
    	    String date = begindate.replace("-", "");
    	    query.setParameter("month_s", date);
    	    query.setParameter("spare1_s", spare1_s);
    	    return query.list();
    	  }
    
    public List<Map<String, Object>> getMixProductionInfo(String plantype) throws Exception
    {
      try
      {
        String areaname = "";
        String[] matchlist = null;

        if (LLWebUtils.factory().equals("1")) {
          areaname = "80231MX";
          if (plantype.equals("051003")) {
            matchlist = new String[] { "E0101", "E0102", "E0103", "E0104", "E0105", "E0106", "E0107", "E0108" };
          }
          if (plantype.equals("051002")) {
            matchlist = new String[] { "E0201", "E0202", "E0203" };
          }
          if (plantype.equals("051001")) {
            matchlist = new String[] { "E0204", "E0205", "E0206" };
          }

          if (plantype.equals("051003051001")) {
            matchlist = new String[] { "E01", "E02" };
          }

          if (plantype.equals("051004"))
            matchlist = new String[] { "E01", "E0201", "E0202", "E0203", "E34", "E35" };
        }
        else {
          areaname = "80232MX";
          if (plantype.equals("051003")) {
            matchlist = new String[] { "90101", "90102", "90103", "90104", "90105", "90106", "90107", "90108" };
          }
          if (plantype.equals("051002")) {
            matchlist = new String[] { "90201", "90202", "90203" };
          }
          if (plantype.equals("051001")) {
            matchlist = new String[] { "90204", "90205", "90206" };
          }

          if (plantype.equals("051004")) {
            matchlist = new String[] { "90101", "90102", "90103", "90104", "90105", "90106", "90107", "90108", "90201", "90202", "90203", "934", "935" };
          }

          if (plantype.equals("051003051001")) {
            matchlist = new String[] { "9010", "9020" };
          }

          if (plantype.equals("908907")) {
            matchlist = new String[] { "908", "907" };
          }
        }
        return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist); } catch (Exception e) {
      }
      return null;
    }
    public List<Map<String, Object>> getRfidByPlinename() throws Exception
    {
      try {
        String areaname = "";
        String[] matchlist = null;

        if (LLWebUtils.factory().equals("1")) {
          areaname = "80231MX";
          matchlist = new String[] { "E0101", "E0102", "E0103", "E0104", "E0106", "E0107", "E0108" };
        } else {
          areaname = "80232MX";
          matchlist = new String[] { "90101", "90102", "90103", "90104", "90106", "90107", "90108" };
        }
        return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist); } catch (Exception e) {
      }
      return null;
    }
    public List<Map<String, Object>> getMixXLProductionInfo() throws Exception
    {
      try
      {
        String areaname = "";
        String[] matchlist = null;

        if (LLWebUtils.factory().equals("1")) {
          areaname = "80231MX";
          matchlist = new String[] { "E0204", "E0205", "E0206", "E0201", "E0202", "E0203", "E34", "E35" };
        } else {
          areaname = "80232MX";
          matchlist = new String[] { "90204", "90205", "90206", "90201", "90202", "90203", "934", "935" };
        }
        return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist); } catch (Exception e) {
      }
      return null;
    }
    public List<Map<String, Object>> getProductionInfoByAreaNameAndMatchlist(String areaname, String[] matchlist)
    	    throws Exception
    	  {
    	    StringBuffer sql = new StringBuffer();
    	    sql.append("select   a.area_name,a.description areadescription,p.p_line_name,p.description,up.*");
    	    sql.append(" from area a, area_production_line l2, production_line p,uda_productionline up");
    	    sql.append(" where l2.parent_key = a.area_key");
    	    sql.append(" and l2.child_key = p.p_line_key");
    	    sql.append(" and p.p_line_key=up.object_key(+)");
    	    if ((matchlist != null) && (matchlist.length > 0)) {
    	      String matchString = "";
    	      sql.append(" and REGEXP_LIKE(p.p_line_name, '(");
    	      for (int i = 0; i < matchlist.length; i++) {
    	        matchString = matchString + matchlist[i].toString() + "|";
    	      }
    	      sql.append(matchString.substring(0, matchString.length() - 1).trim());
    	      sql.append(")') ");
    	    }
    	    if (!areaname.equals(""))
    	    {
    	      sql.append(" and a.area_name='");
    	      sql.append(areaname + "'");
    	    }
    	    sql.append(" order by p.p_line_name");

    	    SQLQuery query = createSQLQuery(sql.toString());
    	    List res = query.list();
    	    List list_new = new ArrayList();
    	    for (int i = 0; i < res.size(); i++) {
    	      list_new.add(TransformUpperCase.transformUpperCase((java.util.Map<String, Object>)res.get(i)));
    	    }
    	    return list_new;
    	  }

}
