/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.finalcheck.entity.SecondarySortAppearanceBeforeLog;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 二次质检外观前分拣履历表
 * @author 孙尊龙
 * @Date 2020-01-21 13:54:15
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SecondarySortAppearanceBeforeLogServiceImpl extends  RockWellUDABaseServiceImpl<Object> {
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SecondarySortAppearanceBeforeLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
}
