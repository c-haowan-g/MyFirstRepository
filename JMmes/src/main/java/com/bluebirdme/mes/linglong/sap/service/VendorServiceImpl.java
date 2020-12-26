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
import com.bluebirdme.mes.linglong.sap.entity.Vendor;
import com.bluebirdme.mes.linglong.sap.entity.dto.VendorDTO;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 供应商信息表
 * @author 周清玉
 * @Date 2018-09-25 10:28:55
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VendorServiceImpl extends RockWellBaseServiceImpl<Vendor> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Vendor.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(VendorDTO vendor) throws Exception{
        
        if (!ListUtils.isEmpty(vendor.getDeleted())) {
            delete(vendor.getDeleted());
        }
        if (!ListUtils.isEmpty(vendor.getInserted())) {
            save(vendor.getInserted());
        }
        if (!ListUtils.isEmpty(vendor.getUpdated())) {
            update(vendor.getUpdated());
        }
    
    }

}
