/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.sap.entity.PlmDynamicBalance;
import com.bluebirdme.mes.linglong.sap.entity.dto.PlmDynamicBalanceDTO;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * PLM动平衡参数表
 * @author 刘程明
 * @Date 2018-12-05 14:25:20
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlmDynamicBalanceServiceImpl extends RockWellBaseServiceImpl<PlmDynamicBalance> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return PlmDynamicBalance.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(PlmDynamicBalanceDTO plmdynamicbalance) throws Exception{
        
        if (!ListUtils.isEmpty(plmdynamicbalance.getDeleted())) {
            delete(plmdynamicbalance.getDeleted());
        }
        if (!ListUtils.isEmpty(plmdynamicbalance.getInserted())) {
            save(plmdynamicbalance.getInserted());
        }
        if (!ListUtils.isEmpty(plmdynamicbalance.getUpdated())) {
            update(plmdynamicbalance.getUpdated());
        }
    
    }

}
