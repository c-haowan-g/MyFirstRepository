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
import com.bluebirdme.mes.linglong.building.entity.Wmsoutstore;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 胎胚出库实绩表
 * @author 王海霖
 * @Date 2019-01-14 15:53:15
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WmsoutstoreServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Wmsoutstore.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
   
   

}
