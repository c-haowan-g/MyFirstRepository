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

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.finalcheck.entity.Judge;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeVO;

/**
 * 判定标准维护
 * @author 刘程明
 * @Date 2018-08-01 13:48:20
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JudgeServiceImpl extends RockWellBaseServiceImpl<Judge> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Judge.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    @RockWellTransactional
    public void saveChanges(JudgeVO judge) throws Exception{
        
        if (!ListUtils.isEmpty(judge.getDeleted())) {
            delete(judge.getDeleted());
        }
        if (!ListUtils.isEmpty(judge.getInserted())) {
            save(judge.getInserted());
        }
        if (!ListUtils.isEmpty(judge.getUpdated())) {
            update(judge.getUpdated());
        }
    
    }

}
