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
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudge;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeJudgeDTO;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 质检动平衡检测标准表-全钢
 * @author 刘程明
 * @Date 2018-12-05 10:52:49
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RecipeJudgeServiceImpl extends RockWellBaseServiceImpl<RecipeJudge> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return RecipeJudge.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RecipeJudgeDTO recipejudge) throws Exception{
        
        if (!ListUtils.isEmpty(recipejudge.getDeleted())) {
            delete(recipejudge.getDeleted());
        }
        if (!ListUtils.isEmpty(recipejudge.getInserted())) {
            save(recipejudge.getInserted());
        }
        if (!ListUtils.isEmpty(recipejudge.getUpdated())) {
            update(recipejudge.getUpdated());
        }
    
    }

}
