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

import com.bluebirdme.mes.linglong.finalcheck.entity.SortGradeLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortGradeLogDTO;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;

/**
 * 质检分检等级规则表(终检蓝英接口同步履历)
 * @author 司乔靖
 * @Date 2018-11-28 13:33:09
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortGradeLogServiceImpl extends RockWellBaseServiceImpl<SortGradeLog> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SortGradeLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(SortGradeLogDTO sortgradelog) throws Exception{
        
        if (!ListUtils.isEmpty(sortgradelog.getDeleted())) {
            delete(sortgradelog.getDeleted());
        }
        if (!ListUtils.isEmpty(sortgradelog.getInserted())) {
            save(sortgradelog.getInserted());
        }
        if (!ListUtils.isEmpty(sortgradelog.getUpdated())) {
            update(sortgradelog.getUpdated());
        }
    
    }

}
