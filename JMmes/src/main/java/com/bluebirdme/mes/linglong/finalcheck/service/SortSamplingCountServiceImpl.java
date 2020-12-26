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
import com.bluebirdme.mes.linglong.finalcheck.entity.SortSamplingCount;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortSamplingCountDTO;

/**
 * 质检分拣抽检计数表
 * @author 刘程明
 * @Date 2019-04-25 16:35:26
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortSamplingCountServiceImpl extends RockWellBaseServiceImpl<SortSamplingCount> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SortSamplingCount.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(SortSamplingCountDTO sortsamplingcount) throws Exception{
        
        if (!ListUtils.isEmpty(sortsamplingcount.getDeleted())) {
            delete(sortsamplingcount.getDeleted());
        }
        if (!ListUtils.isEmpty(sortsamplingcount.getInserted())) {
            save(sortsamplingcount.getInserted());
        }
        if (!ListUtils.isEmpty(sortsamplingcount.getUpdated())) {
            update(sortsamplingcount.getUpdated());
        }
    
    }

}
