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
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.finalcheck.entity.EntLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.EntLogDTO;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;

/**
 * 质检设备信息表(终检蓝英接口同步履历)
 * @author 司乔靖
 * @Date 2018-11-27 16:21:40
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EntLogServiceImpl extends RockWellBaseServiceImpl<EntLog> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return EntLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(EntLogDTO entlog) throws Exception{
        
        if (!ListUtils.isEmpty(entlog.getDeleted())) {
            delete(entlog.getDeleted());
        }
        if (!ListUtils.isEmpty(entlog.getInserted())) {
            save(entlog.getInserted());
        }
        if (!ListUtils.isEmpty(entlog.getUpdated())) {
            update(entlog.getUpdated());
        }
    
    }

}
