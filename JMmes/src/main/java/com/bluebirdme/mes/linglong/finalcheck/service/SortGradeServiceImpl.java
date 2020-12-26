/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortGradeDTO;

/**
 * 分拣等级维护
 * @author lcm
 * @Date 2018-08-16 12:23:33
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SortGradeServiceImpl extends RockWellBaseServiceImpl<SortGrade> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SortGrade.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    @RockWellTransactional
    public void saveChanges(SortGradeDTO sortgrade) throws Exception{
        
    	List<SortGrade> sortgradeList=null;
        if (!ListUtils.isEmpty(sortgrade.getDeleted())) {
        	
 			delete(sortgrade.getDeleted()); 
        }
        if (!ListUtils.isEmpty(sortgrade.getInserted())) {
        	
        	sortgradeList = sortgrade.getInserted();

			for (SortGrade item : sortgradeList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setRecord_flag_s("A");
				item.setArch_flag_s("0");
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
			}
			save(sortgradeList);
            
        }
        if (!ListUtils.isEmpty(sortgrade.getUpdated())) {
            sortgradeList = sortgrade.getUpdated();
 			for (SortGrade item : sortgradeList) {
 				item.setChanged_by_s(LLWebUtils.getUser().userCode);
 				item.setChanged_time_t(new Date());
 			}
			update(sortgradeList);
        }
    
    }

}
