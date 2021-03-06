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
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.building.entity.FeedingCheck_Record;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 投料扫描及校验表
 * @author 司乔靖
 * @Date 2019-02-16 08:53:13
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FeedingCheck_RecordServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return FeedingCheck_Record.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    

}
