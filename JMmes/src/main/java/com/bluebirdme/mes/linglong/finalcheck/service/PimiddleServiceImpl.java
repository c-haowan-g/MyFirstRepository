/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

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
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.finalcheck.entity.Pimiddle;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 割毛中间表
 * @author 周志祥
 * @Date 2019-02-28 13:58:30
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PimiddleServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Pimiddle.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
     * 界面查询用
     * 刘程明
     * 2019年2月28日
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<Map<String,Object>> getPimiddleData(Map<String,Object> list_map) throws Exception{
    	Filter filter = new Filter();
    	filter.set("begin_created_time", list_map.get("begin_created_time").toString());
    	filter.set("end_created_time", list_map.get("end_created_time").toString());
    	if(!list_map.get("class_id_s").toString().isEmpty()){
    		filter.set("class_id_s",list_map.get("class_id_s").toString() );
    	}
    	String sql = getSQL("datagrid_rows", filter.getFilter());
    	SQLQuery query = getSession().createSQLQuery(sql);
    	query.setParameter("begin_created_time", list_map.get("begin_created_time").toString());
    	query.setParameter("end_created_time", list_map.get("end_created_time").toString());
    	if(!list_map.get("class_id_s").toString().isEmpty()){
    		query.setParameter("class_id_s",list_map.get("class_id_s").toString() );
    	}
    	List<Map<String,Object>> listMap =query.list();
		//大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
		for(Map<String,  Object> orgMap :listMap){
			Map<String,  Object> map = new HashMap<>();
			map=TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return  returnlist;
    }
    

}
