/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.PlmHalfpartRecipePara;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * PLM半部件配方下发基础参数表
 * @author 李德晓
 * @Date 2020-03-16 15:31:45
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlmHalfpartRecipeParaServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return PlmHalfpartRecipePara.class;
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
        		PlmHalfpartRecipePara plmhalfpartrecipepara=(PlmHalfpartRecipePara) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), PlmHalfpartRecipePara.class);
        		//plmhalfpartrecipepara.setCreated_time_t(new Date()); 
        		list.add(plmhalfpartrecipepara);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		PlmHalfpartRecipePara plmhalfpartrecipepara =(PlmHalfpartRecipePara) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), PlmHalfpartRecipePara.class);
        		//plmhalfpartrecipepara.setCreated_time_t(new Date()); 
        		list.add(plmhalfpartrecipepara);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		PlmHalfpartRecipePara plmhalfpartrecipepara=(PlmHalfpartRecipePara) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), PlmHalfpartRecipePara.class);
        		plmhalfpartrecipepara.setChanged_by_s(LLWebUtils.getUser().userName);
        		plmhalfpartrecipepara.setChanged_time_t(new Date());
        		//plmhalfpartrecipepara.setCreated_time_t(new Date()); 
        		update(plmhalfpartrecipepara);
        	}
        }
    
    }
    /**
   	 * 查出设备类型名称显示在JSP页面下拉列表处
   	 * 
   	 * @return
   	 */
   	public List<Map<String, Object>> searchEquipmenttypecode_s() {
   		SQLQuery query =  createSQLQuery(getSQL("searchEquipmenttypecode_s"));
   		return query.list();
   	}
   	/**
   	 * 查出参数类型名称
   	 * 
   	 * @return
   	 */
   	public List<Map<String, Object>> searchBasetype_s() {
   		SQLQuery query =  createSQLQuery(getSQL("searchBasetype_s"));
   		return query.list();
   	}


}
