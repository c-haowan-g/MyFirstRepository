/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanDynaBalanceLog;

import org.xdemo.app.xutils.j2se.ListUtils;

import java.awt.*;
import java.util.Map;

/**
 * 2018
 * @author 王海霖
 * @Date 2018-08-09 15:47:59
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ScanDynaBalanceLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ScanDynaBalanceLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
   
    public Object getDictBy267(){
        String sql = "select * from AT_CM_BS_COREDICTIONARY where dictcode_s like '267%'";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
}
