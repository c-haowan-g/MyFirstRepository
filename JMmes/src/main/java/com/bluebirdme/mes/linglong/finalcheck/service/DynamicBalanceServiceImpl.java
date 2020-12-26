/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynamicBalance;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.DynamicBalanceDTO;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * PLM动平衡参数表
 * @author 赵怀浩
 * @Date 2018-11-28 09:19:33
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DynamicBalanceServiceImpl extends RockWellBaseServiceImpl<DynamicBalance> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return DynamicBalance.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(DynamicBalanceDTO dynamicbalance) throws Exception{
        
        if (!ListUtils.isEmpty(dynamicbalance.getDeleted())) {
            delete(dynamicbalance.getDeleted());
        }
        if (!ListUtils.isEmpty(dynamicbalance.getInserted())) {
            save(dynamicbalance.getInserted());
        }
        if (!ListUtils.isEmpty(dynamicbalance.getUpdated())) {
            update(dynamicbalance.getUpdated());
        }
    
    }
    /**
     * 根据配方号返回PLM动平衡参数
     * @param recipeno 配方号
     * @return 动平衡参数
     * @throws Exception 
     */
    public List<Map<String,Object>> searchplmdynamicbalance(String judgeid) throws Exception{
    	if(judgeid.equals("null")){
    		return null;
    	}
    	SQLQuery query=createSQLQuery(getSQL("searchplmdynamicbalance"),DynamicBalance.class);
    	query.setParameter("atr_key", judgeid);
    	List<Map<String, Object>> list=query.list();
    	return list;
    }

}
