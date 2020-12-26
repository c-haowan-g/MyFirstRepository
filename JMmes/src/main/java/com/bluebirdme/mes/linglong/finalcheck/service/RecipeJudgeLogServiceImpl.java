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
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudgeLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeJudgeLogDTO;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 质检配方判定标准表-全钢
 * @author 刘程明
 * @Date 2018-12-06 11:37:48
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RecipeJudgeLogServiceImpl extends RockWellBaseServiceImpl<RecipeJudgeLog> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return RecipeJudgeLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RecipeJudgeLogDTO recipejudgelog) throws Exception{
        
        if (!ListUtils.isEmpty(recipejudgelog.getDeleted())) {
            delete(recipejudgelog.getDeleted());
        }
        if (!ListUtils.isEmpty(recipejudgelog.getInserted())) {
            save(recipejudgelog.getInserted());
        }
        if (!ListUtils.isEmpty(recipejudgelog.getUpdated())) {
            update(recipejudgelog.getUpdated());
        }
    
    }

}
