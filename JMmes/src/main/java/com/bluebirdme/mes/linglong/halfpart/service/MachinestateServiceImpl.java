/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.Machinestate;
import org.xdemo.app.xutils.j2se.ListUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * 机台信息状态表 
 * @author 李新宇
 * @Date 2020-03-04 08:36:33
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MachinestateServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Machinestate.class;
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
        		Machinestate machomestatis=(Machinestate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Machinestate.class);
        		//machomestatis.setCreated_time_t(new Date()); 
        		list.add(machomestatis);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		Machinestate machomestatis =(Machinestate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Machinestate.class);
        		//machomestatis.setCreated_time_t(new Date()); 
        		list.add(machomestatis);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		Machinestate machomestatis=(Machinestate) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Machinestate.class);
        		//machomestatis.setCreated_time_t(new Date()); 
        		update(machomestatis);
        	}
        }
    
    }

    public Map<String, Object> childrenGrid(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", childrenGridRows(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", childrenGridTotal(filter, page));
		return ret;
	}

	private List<Map<String, Object>> childrenGridRows(Filter filter, Page page) throws Exception {
    	if(getSQL("getChildrenGrid_rows") == null){
    		throw new Exception(getClass() + ".xml中未找到ID为getChildrenGrid_rows的SQL语句定义");
		}

    	String sql = getSQL("getChildrenGrid_rows",filter.getFilter());
		System.out.println(sql);
		SQLQuery query = createSQLQuery(sql);
		setParameter(query, filter);
		List<Map<String, Object>> listMap = query.list();
		return listMap;
	}



	private Long childrenGridTotal(Filter filter, Page page) throws Exception {
    	if(getSQL("getChildrenGrid_total") == null){
    		throw new Exception(getClass() + ".xml中未找到ID为getChildrenGrid_total的SQL语句定义");
		}
    	String sql = getSQL("getChildrenGrid_total",filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(sql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	public Object getLineName(){
		String factory=LLWebUtils.factory();
    	String sql = "select DISTINCT  MACHINEBARCODE_S as P_LINE_NAME from AT_CM_EM_MACHINESTATUS where S_FACTORY_S = '"+factory+"' and record_flag_s ='A' and  MACHINEBARCODE_S like '_A%' ";
    	SQLQuery query = createSQLQuery(sql);
    	List<Map<String,Object>> list = query.list();
    	return list;
	}


}
