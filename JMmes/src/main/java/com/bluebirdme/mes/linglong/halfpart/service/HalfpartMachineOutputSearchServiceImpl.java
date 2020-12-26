/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfpartMachineOutputSearch;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
/**
 * 半部件产出实绩
 * @author 李德晓
 * @Date 2020-03-17 16:05:04
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfpartMachineOutputSearchServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return HalfpartMachineOutputSearch.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		HalfpartMachineOutputSearch halfpartmachineoutputsearch=(HalfpartMachineOutputSearch) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), HalfpartMachineOutputSearch.class);
        		
        		Date date = new Date(); 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = sdf.format(date);
        		
        		Map<String,Object> map = new HashMap<String,Object>();
        		map.put("PLANNO_S", halfpartmachineoutputsearch.getPlanno_s());
        		map.put("MATERSPEC_S", halfpartmachineoutputsearch.getMaterspec_s());
        		List<Object> updatelist= findByMap(map);
        		for(Object item : updatelist){
        			HalfpartMachineOutputSearch output = (HalfpartMachineOutputSearch)item;
        			if(output.getOutputtime_t() != null){
        				output.setSpare3_s(halfpartmachineoutputsearch.getSpare3_s());
        				output.setSpare4_s(LLWebUtils.getUser().getUserName());
        				output.setSpare7_s(format);
        			}
        		}
        		update(updatelist);
        	}
        }
    }
    
    /**
	 * 查出机台名称显示在JSP页面下拉列表处！
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query =  createSQLQuery(getSQL("searchDescription"));
		return query.list();
	}
	 /**
		 * 查出物料编码显示在JSP页面下拉列表处
		 * 
		 * @return
		 */
		public List<Map<String, Object>> searchMaterialcode_s() {
			SQLQuery query =  createSQLQuery(getSQL("searchMaterialcode_s"));
			return query.list();
		}
		public List<Map<String, Object>> searchMaterialcode_sb() {
			SQLQuery query =  createSQLQuery(getSQL("searchMaterialcode_sb"));
			return query.list();
		}
		 /**
		 * 查出规格显示在JSP页面下拉列表处
		 * 
		 * @return
		 */
		public List<Map<String, Object>> searchMaterspec_s() {
			SQLQuery query =  createSQLQuery(getSQL("searchMaterspec_s"));
			return query.list();
		}
		public List<Map<String, Object>> searchMaterspec_sb() {
			SQLQuery query =  createSQLQuery(getSQL("searchMaterspec_sb"));
			return query.list();
		}
		 /**
		 * 查出查出usercode，username并转换
		 * 
		 * @return
		 */
		public List<Map<String, Object>> searchUsercode() {
			SQLQuery query =  createSQLQuery(getSQL("searchUsercode"));
			return query.list();
		}

}
