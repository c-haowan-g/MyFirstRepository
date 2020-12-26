/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.dto.BillOfMaterialUDAUdaDTO;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bom_uda
 * @author 王海霖
 * @Date 2019-06-24 15:06:48
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BillOfMaterialServiceImpl extends RockWellUDABaseServiceImpl<Object> {

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
	
    @RockWellTransactional
    public int saveChanges(BillOfMaterialUDAUdaDTO udadto) throws Exception{
        
        if (!ListUtils.isEmpty(udadto.getDeleted())) {
	         List<Map<String, Object>> listMap=udadto.getDeleted();
	         for(Map<String, Object> item:listMap){}
        }
        if (!ListUtils.isEmpty(udadto.getInserted())) {
             List<Map<String, Object>> listMap=udadto.getInserted();
             for(Map<String, Object> item:listMap){}
        }
        if (!ListUtils.isEmpty(udadto.getUpdated())) {
            List<Map<String, Object>> listMap=udadto.getUpdated();
            for(Map<String, Object> item:listMap){}
        }
        
    	return 1;
    }
    
    public List<Map<String, Object>> datagridBOMCount(String bomkey) throws Exception{
    	
    	if(StringHelper.isNullOrEmpty(bomkey)){
    		System.out.println("bomkey:"+bomkey+"为空！！！");
    		return null;
    	}
    	
    	if (getSQL("datagridBOMCount") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");
        Filter filter=new Filter();
        filter.set("bomkey", bomkey.split("/")[0]);
        filter.set("bomrevision", bomkey.split("/")[1]);
		String dataSql = getSQL("datagridBOMCount", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> listMap =query.list();
		//大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
		for(Map<String,  Object> orgMap :listMap){
			Map<String,  Object> map = new HashMap<>();
			map=TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		for (int i = 0; i < returnlist.size(); i++) {
			Map<String, Object> map = returnlist.get(i);
			if(map.get("bom_name")==null){
				map.put("bom_name", map.get("part_number"));
				map.put("bom_revision", map.get("part_revision"));
				map.remove("state");
			}
		}
		return  returnlist;
    	
    }
    
    public List<Map<String, Object>> treelistQuery(List<Map<String, Object>> list_map) throws Exception{
    	Filter filter = new Filter();
		filter.set("subitemsap_s",list_map.get(0).get("subitemsap_s"));
		filter.set("version_s",list_map.get(1).get("version_s"));
		String dataSql = getSQL("treelistQuery", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list =query.list();
    	return list;
    }
}
