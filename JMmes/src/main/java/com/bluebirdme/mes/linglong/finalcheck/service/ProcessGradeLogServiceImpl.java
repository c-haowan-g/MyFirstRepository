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

import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGradeLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ProcessGradeLogDTO;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;

/**
 * 质检工序等级表(终检蓝英接口同步履历)
 * @author 司乔靖
 * @Date 2018-11-28 11:37:41
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProcessGradeLogServiceImpl extends RockWellBaseServiceImpl<ProcessGradeLog> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ProcessGradeLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(ProcessGradeLogDTO processgradelog) throws Exception{
        
        if (!ListUtils.isEmpty(processgradelog.getDeleted())) {
            delete(processgradelog.getDeleted());
        }
        if (!ListUtils.isEmpty(processgradelog.getInserted())) {
            save(processgradelog.getInserted());
        }
        if (!ListUtils.isEmpty(processgradelog.getUpdated())) {
            update(processgradelog.getUpdated());
        }
    
    }

}
