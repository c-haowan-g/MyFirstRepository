/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.building.entity.FormulaRecord;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 工艺参数修改履历表
 * @author 刘程明
 * @Date 2019-04-16 09:18:24
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FormulaRecordServiceImpl extends RockWellBaseServiceImpl<FormulaRecord> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return FormulaRecord.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
}
