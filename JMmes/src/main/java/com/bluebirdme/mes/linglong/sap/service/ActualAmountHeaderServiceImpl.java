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
import com.bluebirdme.mes.linglong.sap.entity.ActualAmountHeader;


/**
 * 实装量HEADER 
 * @author 周清玉
 * @Date 2018-12-20 14:52:15
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ActualAmountHeaderServiceImpl extends RockWellBaseServiceImpl<ActualAmountHeader> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ActualAmountHeader.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    

}
