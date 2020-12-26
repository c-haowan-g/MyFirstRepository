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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortItemLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortItemLogDTO;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;

/**
 * 质检分拣物料规则表(终检蓝英接口同步履历)
 * @author 司乔靖
 * @Date 2018-11-28 14:52:17
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortItemLogServiceImpl extends RockWellBaseServiceImpl<SortItemLog> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SortItemLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(SortItemLogDTO sortitemlog) throws Exception{
        
        if (!ListUtils.isEmpty(sortitemlog.getDeleted())) {
            delete(sortitemlog.getDeleted());
        }
        if (!ListUtils.isEmpty(sortitemlog.getInserted())) {
            save(sortitemlog.getInserted());
        }
        if (!ListUtils.isEmpty(sortitemlog.getUpdated())) {
            update(sortitemlog.getUpdated());
        }
    
    }

}
