/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import groovy.sql.Sql;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ecs.xhtml.object;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.pnuts.xml.newDocument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;


/**
 * Route-Arc
 * @author 时永良
 * @Date 2019-08-08 16:01:32
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RouteServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
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
	
	public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
    List<Map<String, Object>> listmap1=null;
    public List<Map<String, Object>> datagridUDA1(String routeName) throws Exception{
    	Filter filter = new Filter();
		filter.set("routename",routeName);
		String dataSql = getSQL("datagridUDA_rows1", filter.getFilter());
		listmap1=new ArrayList<>();
		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list =query.list();
		//起点是 表 route_queue 最小的atr_key，用来去route_arc中当做from_node_key查询to_node_key
		if(list.size()!=0){
			String toNodeKey=list.get(0).get("TO_NODE_KEY").toString();
			String fromNodeKey=list.get(0).get("FROM_NODE_KEY").toString();
			Map<String , String> map=new HashMap<>();
			datagridUDA2(routeName,toNodeKey,fromNodeKey,map);//用来递归查询（起始点的to_node_key 当做 from_node_key 查询）
		}
		
		List<Map<String,Object>> list1=new ArrayList<>();
		for(int i=0;i<listmap1.size();i++){
			    Map<String, Object> map1=new HashMap<>();
				String dataSql1 = getSQL("datagridUDA_rows");
				SQLQuery query1 = createSQLQuery(dataSql1);
				query1.setParameter("fromNodeKey",listmap1.get(i).get("num"));//将查询得到的from_node_key当做条件去查询operation表中description字段用来页面显示名称
				if(query1.list().size()!=0){
					map1=(Map<String, Object>)query1.list().get(0);
					list1.add(map1);
				}
		}
    	return list1;
    }
   
	
    public void datagridUDA2(String routeName,String toNodeKey,String fromNodeKey,  Map map){
    	
       if (map.get(fromNodeKey)!=null && map.get(fromNodeKey).equals(toNodeKey)){//路径已经存在了，直接返回（保证一条线只存在一次）
    	   return;
       }
       else{
    	   map.put(fromNodeKey,toNodeKey);
       }
       SQLQuery query = createSQLQuery(getSQL("datagridUDA_rows2"));
       query.setParameter("toNodeKey",toNodeKey);
       List<Map<String,Object>> list =query.list();
     	
     		
     	
       	Map<String , Object> map2=new HashMap<>();
     	map2.put("num", fromNodeKey);
     	listmap1.add(map2);
     	
     		if(list.size()==0){
             	System.out.println("结束");
             }else{
                //调用自己
                for(int i=0;i<list.size();i++){
             		datagridUDA2(routeName,list.get(i).get("TO_NODE_KEY").toString(),list.get(i).get("FROM_NODE_KEY").toString(),map);
                }
             }
     	
     }
    	
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getRouteName() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("getRouteName"));
    	List<Map<String, Object>> list=query.list();
		return list;
    }
}
