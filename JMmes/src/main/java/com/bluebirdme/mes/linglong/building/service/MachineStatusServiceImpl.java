/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.entity.MachineStatus;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 机台信息状态表
 * @author 时永良
 * @Date 2019-03-06 18:31:24
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MachineStatusServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return MachineStatus.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
     * 获取设备状态表中已有物料编码
     * 刘程明
     * 2019年3月7日
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> comboxMaterial() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxMaterial"));
    	query.setParameter("s_factory_s", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
     	return list;
    }

    /**
     * 根据产线条码获取当前机台正在执行的日计划号
     * 刘程明
     * 2019年3月13日
     * @param productline
     * @return
     */
    public String searchplannoByProductLine(String productline) {
    	
    	 Object planno= createSQLQuery(getSQL("searchplannoByProductLine")).setParameter("productline", productline).uniqueResult();
    	if(planno==null){
    		return null;
    	}
    	 return planno.toString();
	}
    
    /**
     * 获取设备状态表中已有物料编码
     * 刘程明
     * 2019年3月7日
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getcxEquipcodetype() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("getcxequipcodetype"));
    	if(LLWebUtils.factory().equals("1")){
    		query.setParameter("dictname_s", "全钢");
    	}else if(LLWebUtils.factory().equals("2")){
    		query.setParameter("dictname_s", "半钢");
    	}
    	List<Map<String, Object>> list=query.list();
     	return list;
    }
    
}
