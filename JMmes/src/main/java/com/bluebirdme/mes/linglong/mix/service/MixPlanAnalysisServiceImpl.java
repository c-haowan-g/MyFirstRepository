/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.entity.MixPlanAnalysis;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixPlanAnalysisDTO;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 计划库存分析报表_密炼日计划表
 * @author mengh
 * @Date 2020-02-17 11:10:21
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MixPlanAnalysisServiceImpl extends RockWellBaseServiceImpl<MixPlanAnalysis> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return MixPlanAnalysis.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
   /* @RockWellTransactional
    public void saveChanges(MixPlanAnalysisDTO mixplananalysis) throws Exception{
        
        if (!ListUtils.isEmpty(mixplananalysis.getDeleted())) {
            delete(mixplananalysis.getDeleted());
        }
        if (!ListUtils.isEmpty(mixplananalysis.getInserted())) {
            save(mixplananalysis.getInserted());
        }
        if (!ListUtils.isEmpty(mixplananalysis.getUpdated())) {
            update(mixplananalysis.getUpdated());
        }
    
    }*/

}
