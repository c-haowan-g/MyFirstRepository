/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanMiddle;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 半部件计划中间表
 * @author 兰颖慧
 * @Date 2019-09-06 16:34:34
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductPlanMiddleServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ProductPlanMiddle.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    private List<Map<String, Object>> halfPartMap;// 接收半部件机台信息
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	List<Map<String, Object>> productPlanMiddleList=null;
    	List<Object> productPlanMiddles=new ArrayList<Object>();
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            productPlanMiddleList = rockWellEntityDTO.getDeleted();
        	for(Map<String, Object> newitem:productPlanMiddleList){
        		ProductPlanMiddle item = (ProductPlanMiddle)MapTrunPojo.mapToEntity(newitem, getEntity());
        		if(item!=null){
        			productPlanMiddles.add(item);
        		}
        	}
            delete(productPlanMiddles);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	productPlanMiddleList=rockWellEntityDTO.getInserted();
        	for(Map<String, Object> newitem: productPlanMiddleList){
        		ProductPlanMiddle item = (ProductPlanMiddle)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setChange_by_s(LLWebUtils.getUser().userCode);
        		item.setChange_date_t(new Date());
        		item.setSpare9_s(LLWebUtils.factory());
        		if(item!=null){
        			productPlanMiddles.add(item);
        		}
        	}
            save(productPlanMiddles);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	productPlanMiddleList=rockWellEntityDTO.getUpdated();
        	for(Map<String, Object> newitem: productPlanMiddleList){
        		ProductPlanMiddle item = (ProductPlanMiddle)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setChange_by_s(LLWebUtils.getUser().userCode);
        		item.setChange_date_t(new Date());
        		if(item!=null){
        			productPlanMiddles.add(item);
        		}
        	}
            update(productPlanMiddles);
        }
    
    }

    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
    	String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
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
	
	
	 /**
		 * 查询半部件机台信息
		 */
		@SuppressWarnings("unchecked")
		private List<Map<String, Object>> getHalfPartMap() {

			SQLQuery query=createSQLQuery(getSQL("getHalfPartProductionLine"));
	 		query.setParameter("process",Process.HalfPart);
			if(LLWebUtils.factory().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
				query.setParameter("factory",Factory.FullSteel);
			}else if(LLWebUtils.factory().equals(Factory.HalfSteel)){
				query.setParameter("factory",Factory.HalfSteel);
			}
			halfPartMap=query.list();
			return halfPartMap;
		}
		/**
		 * 
		 * @Title: getBuringName
		 * @Description: TODO(根据硫化机台条码获取硫化机台名称)
		 * @return: String 返回类型
		 * 
		 */
		@SuppressWarnings("unused")
		public String getHalfPartName(String halfpartcode) {
			if(halfpartcode==null){
				return"";
			}
			String result = null;
			if (halfPartMap == null) {
				halfPartMap = getHalfPartMap();
			}
			for (int i = 0; i < halfPartMap.size(); i++) {
				if (halfPartMap.get(i).get("P_LINE_NAME").equals(halfpartcode)) {
					result = halfPartMap.get(i).get("DESCRIPTION").toString();
					break;
				} else {
					result = "";
				}
			}
			return result;
		}
		
		
}
