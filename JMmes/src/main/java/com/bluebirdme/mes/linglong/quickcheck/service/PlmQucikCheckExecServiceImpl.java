/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.service;

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
import com.bluebirdme.mes.linglong.quickcheck.entity.PlmQuickCheckExec;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * PLM快检标准参数执行表
 * @author 肖吉朔
 * @Date 2020-08-08 11:10:40
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlmQucikCheckExecServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return PlmQuickCheckExec.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {


		if (clazz == null) {
			clazz = getEntity();
		}

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}
    public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");

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
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";
		
		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
		
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
        		//将MAP转换为实体
        		PlmQuickCheckExec exec=(PlmQuickCheckExec) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), PlmQuickCheckExec.class);
        		//exec.setCreated_time_t(new Date()); 
        		list.add(exec);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		PlmQuickCheckExec exec =(PlmQuickCheckExec) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), PlmQuickCheckExec.class);
        		//exec.setCreated_time_t(new Date()); 
        		list.add(exec);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		PlmQuickCheckExec exec=(PlmQuickCheckExec) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), PlmQuickCheckExec.class);
        		if(exec.getSend_state_s().equals("1")){
        			//当前台传输下发数据为1时，表示要进行下发
        			exec.setSend_time_t(new Date());
        			exec.setSend_name_s(LLWebUtils.getUser().userName);
        			exec.setSend_by_s(LLWebUtils.getUser().userCode);
        			exec.setSend_state_s("1");
        			update(exec);
        		}if(exec.getSend_state_s().equals("0")){
        			exec.setCheck_time_t(new Date());
            		exec.setCheck_name_s(LLWebUtils.getUser().userName);
            		exec.setCheck_by_s(LLWebUtils.getUser().userCode);
            		
            		update(exec);
        		}
        		
        	}
        }
    
    }

  
	
	

}
