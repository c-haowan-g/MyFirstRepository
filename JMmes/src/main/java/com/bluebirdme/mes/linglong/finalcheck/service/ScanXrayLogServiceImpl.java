/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanXrayLog;


/**
 * X光扫描履历表
 * @author 时永良
 * @Date 2018-08-05 09:07:46
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ScanXrayLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ScanXrayLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
}
