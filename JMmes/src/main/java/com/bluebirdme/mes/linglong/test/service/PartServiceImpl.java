/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.test.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.dto.UdaDto;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import org.xdemo.app.xutils.j2se.ListUtils;

import java.util.List;
import java.util.Map;

/**
 * 20190620新封装
 * @author 周清玉
 * @Date 2019-06-20 10:12:20
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PartServiceImpl extends RockWellUDABaseServiceImpl<Object> {

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
    public int saveChanges(UdaDto udadto) throws Exception{
        
        if (!ListUtils.isEmpty(udadto.getDeleted())) {
	         List<Map<String, Object>> listMap=udadto.getDeleted();
	         for(Map<String, Object> item:listMap){
	        	 Part part = getFunction().createPart();
	         }
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

}
