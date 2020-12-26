/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.building.entity.ClassPlan;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 成型班次计划表
 * @author 王海霖
 * @Date 2019-08-06 08:17:31
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ClassPlanServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ClassPlan.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	List<Map<String, Object>> classPlanList=null;
    	List<Object> changeClassPlans=new ArrayList<Object>();
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	classPlanList=rockWellEntityDTO.getDeleted();
        	for (Map<String, Object> map : classPlanList) {
        		ClassPlan classPlan =(ClassPlan) MapTrunPojo.mapToEntity(map, getEntity());
        		if(classPlan!=null){
        			changeClassPlans.add(classPlan);
        		}
			}
            delete(changeClassPlans);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	classPlanList=rockWellEntityDTO.getInserted();
        	for (Map<String, Object> map : classPlanList) {
        		ClassPlan classPlan =(ClassPlan) MapTrunPojo.mapToEntity(map, getEntity());
        		if(classPlan!=null){
        			changeClassPlans.add(classPlan);
        		}
			}
            save(changeClassPlans);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            //update(classplan.getUpdated());
        }
    
    }
    
    
    /**
     * 查询日计划号
     * @return
     */
    public List<String> searchPlanCode(){
		SQLQuery planCode=createSQLQuery(getSQL("searchPlanCode"));
    	return planCode.list();
    }
    /**
     * 查询工单号
     * @return
     */
    public List<String> searchOrderCode(){
		SQLQuery orderCode=createSQLQuery(getSQL("searchOrderCode"));
    	return orderCode.list();
    }
    /**
     * 查询物料编码
     * @return
     */
    public List<String> searchMaterialCode(){
		SQLQuery materialCode=createSQLQuery(getSQL("searchMaterialCode"));
    	return materialCode.list();
    }
    
    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
		
		  String FACTORY = "s_factory_s";
		
		  if (!filter.getFilter().containsKey(FACTORY)) { 
			  try {
				  filter.set("s_factory_s", LLWebUtils.factory()); 
			  }
		      catch (Exception e) { 
		          throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录"); 
		      } 
		  }
		 

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

}
