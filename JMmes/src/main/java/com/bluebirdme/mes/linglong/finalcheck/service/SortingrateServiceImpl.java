/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.Sortingrate;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * 分拣扫描率报表
 * @author 徐秉正
 * @Date 2020-11-16 16:33:06
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortingrateServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Sortingrate.class;
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
        		Sortingrate sortingrate=(Sortingrate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Sortingrate.class);
        		//sortingrate.setCreated_time_t(new Date()); 
        		list.add(sortingrate);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		Sortingrate sortingrate =(Sortingrate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Sortingrate.class);
        		//sortingrate.setCreated_time_t(new Date()); 
        		list.add(sortingrate);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		Sortingrate sortingrate=(Sortingrate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Sortingrate.class);
        		//sortingrate.setCreated_time_t(new Date()); 
        		update(sortingrate);
        	}
        }
    
    
    
    }
    
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchcode() throws Exception{
    	
    	SQLQuery query = createSQLQuery(getSQL("searchcode"));
    	//query.setParameter("reas_code", reas_code);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchcodewg() throws Exception{
    	
    	SQLQuery query = createSQLQuery(getSQL("searchcodewg"));
    	//query.setParameter("reas_code", reas_code);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
	
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchcodegm() throws Exception{
    	
    	SQLQuery query = createSQLQuery(getSQL("searchcodegm"));
    	//query.setParameter("reas_code", reas_code);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchcodexg() throws Exception{
    	
    	SQLQuery query = createSQLQuery(getSQL("searchcodexg"));
    	//query.setParameter("reas_code", reas_code);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
	public List<Map<String, Object>> getAll(Filter filter) {
		List<Map<String, Object>> list=null;
		if(filter.get("entname_s")!=null){
			list=getAll2(filter);
		}else{
			list=getAll1(filter);
		}
		return list;
	}
	public List<Map<String, Object>> getAll1(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAll1"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		System.out.println(LLWebUtils.factory()+"-----------------------我是分割线--------------------");
		List<Map<String, Object>> list = query.list();
		return list;
	}
	public List<Map<String, Object>> getAll2(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAll2"));
		query.setParameter("entname_s", filter.get("entname_s"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}
	
	//外观分拣点
	public List<Map<String, Object>> getAlla(Filter filter) {
		List<Map<String, Object>> list=null;
		if(filter.get("wgentname_s")!=null){
			list=getAlla2(filter);
		}else{
			list=getAlla1(filter);
		}
		return list;
	}
	public List<Map<String, Object>> getAlla1(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAlla1"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		System.out.println(LLWebUtils.factory()+"-----------------------我是分割线--------------------");
		List<Map<String, Object>> list = query.list();
		return list;
	}
	public List<Map<String, Object>> getAlla2(Filter filter) {
		SQLQuery query = createSQLQuery(getSQL("getAlla2"));
		query.setParameter("wgentname_s", filter.get("wgentname_s"));
		query.setParameter("start_time", filter.get("start_time"));
		query.setParameter("end_time", filter.get("end_time"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}

	//X光分拣
 
		public List<Map<String, Object>> getAllx(Filter filter) {
			List<Map<String, Object>> list=null;
			if(filter.get("xgentname_s")!=null){
				list=getAllx2(filter);
			}else{
				list=getAllx1(filter);
			}
			return list;
		}
		public List<Map<String, Object>> getAllx1(Filter filter) {
			SQLQuery query = createSQLQuery(getSQL("getAllx1"));
			query.setParameter("start_time", filter.get("start_time"));
			query.setParameter("end_time", filter.get("end_time"));
			query.setParameter("s_factory_s", LLWebUtils.factory());
			System.out.println(LLWebUtils.factory()+"-----------------------我是分割线--------------------");
			List<Map<String, Object>> list = query.list();
			return list;
		}
		public List<Map<String, Object>> getAllx2(Filter filter) {
			SQLQuery query = createSQLQuery(getSQL("getAllx2"));
			query.setParameter("xgentname_s", filter.get("xgentname_s"));
			query.setParameter("start_time", filter.get("start_time"));
			query.setParameter("end_time", filter.get("end_time"));
			query.setParameter("s_factory_s", LLWebUtils.factory());
			List<Map<String, Object>> list = query.list();
			return list;
		}
		
		//割毛分拣
		 
				public List<Map<String, Object>> getAllgm(Filter filter) {
					List<Map<String, Object>> list=null;
					if(filter.get("gmentname_s")!=null){
						list=getAllgm2(filter);
					}else{
						list=getAllgm1(filter);
					}
					return list;
				}
				public List<Map<String, Object>> getAllgm1(Filter filter) {
					SQLQuery query = createSQLQuery(getSQL("getAllgm1"));
					query.setParameter("start_time", filter.get("start_time"));
					query.setParameter("end_time", filter.get("end_time"));
					query.setParameter("s_factory_s", LLWebUtils.factory());
					System.out.println(LLWebUtils.factory()+"-----------------------我是分割线--------------------");
					List<Map<String, Object>> list = query.list();
					return list;
				}
				public List<Map<String, Object>> getAllgm2(Filter filter) {
					SQLQuery query = createSQLQuery(getSQL("getAllgm2"));
					query.setParameter("gmentname_s", filter.get("gmentname_s"));
					query.setParameter("start_time", filter.get("start_time"));
					query.setParameter("end_time", filter.get("end_time"));
					query.setParameter("s_factory_s", LLWebUtils.factory());
					List<Map<String, Object>> list = query.list();
					return list;
				}
		
		
}
