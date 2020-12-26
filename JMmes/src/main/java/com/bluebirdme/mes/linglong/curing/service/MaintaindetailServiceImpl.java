/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.Maintaindetail;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 设备维修履历
 * @author 周清玉
 * @Date 2019-09-4 09:25:34
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaintaindetailServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Maintaindetail.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
//        if (!ListUtils.isEmpty(maintaindetail.getDeleted())) {
//            delete(maintaindetail.getDeleted());
//        }
//        if (!ListUtils.isEmpty(maintaindetail.getInserted())) {
//            save(maintaindetail.getInserted());
//        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            update(rockWellEntityDTO.getUpdated());
        }
    
    }
    
    public void updateDate(Map<String, Object> map) throws Exception {
    	String atr_key = map.get("atr_key").toString();
    	if (atr_key.equals("")) {
			return;
		}
    	String repick_reason_s=map.get("repick_reason_s").toString();
    	String repick_method_s=map.get("repick_method_s").toString();
    	String repick_position_s=map.get("repick_position_s").toString();
    	String part_info_s=map.get("part_info_s").toString();

    	Map<String,Object> mapWhere = new HashMap<>();
		mapWhere.put("atr_key",Long.valueOf(atr_key));
		Map<String,Object> mapvalue = new HashMap<>();
		mapvalue.put("repick_reason_s", repick_reason_s);
		mapvalue.put("repick_method_s", repick_method_s);
		mapvalue.put("repick_position_s", repick_position_s);
		mapvalue.put("part_info_s", part_info_s);
		update(mapWhere,mapvalue);

    }

    
    public Map<String, Object> datagridTwo(Filter filter, Page page, Class clazz) throws Exception {

  		String FACTORY = "s_factory_s";
  		if (clazz == null) {
  			clazz = getEntity();
  		}
  		if (!filter.getFilter().containsKey(FACTORY)) {
  			if (hasField(FACTORY, clazz)) {
  				try {
  					filter.set("s_factory_s", LLWebUtils.factory());
  				} catch (Exception e) {
  					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
  				}
  			}
  		}
  		Map<String, Object> ret = new HashMap<String, Object>();
  		ret.put("rows", datagridList(filter, page, clazz));
  		filter.setOrder(null);
  		filter.setSort(null);
  		ret.put("total", datagridListCount(filter, page));

  		return ret;
  	}
    
    @SuppressWarnings({ "unchecked" })
   	public <K> List<K> datagridList(Filter filter, Page page, Class<K> clazz) throws Exception {
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
   		if (getSQL("datagrid_list") == null)
   			throw new Exception(getClass() + ".xml中未找到ID为datagrid_list的SQL语句定义");
   		String dataSql = getSQL("datagrid_list", filter.getFilter());
   		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);
   		setParameter(query, filter);
   		if (page.getAll() == 0) {
   			query.setMaxResults(page.getRows());
   			query.setFirstResult((page.getPage() - 1) * page.getRows());
   		}
   		return query.list();
   	}

       
    public Long datagridListCount(Filter filter, Page page) throws Exception {

   		if (getSQL("datagrid_listcount") == null)
   			throw new Exception(getClass() + ".xml中未找到ID为datagrid_listcount的SQL语句定义");

   		String totalSql = getSQL("datagrid_listcount", filter.getFilter());

   		if (page.getTotalRows() == 0L) {

   			SQLQuery query = getSession().createSQLQuery(totalSql);

   			setParameter(query, filter);

   			return ((BigDecimal) query.uniqueResult()).longValue();
   		} else {
   			return page.getTotalRows();
   		}
   	}
}
