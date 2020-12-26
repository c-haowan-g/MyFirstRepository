/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.MachineCheckRecord;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;

/**
 * 开班检查表
 * @author 周清玉
 * @Date 2019-08-09 08:42:13
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MachineCheckRecordServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return MachineCheckRecord.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	int con = rockWellEntityDTO.getDeleted().size();
        	List list = new ArrayList<>();
        	for (int i = 0; i < con; i++) {
        		MachineCheckRecord checkRecord=(MachineCheckRecord) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MachineCheckRecord.class);
        		checkRecord.setCreated_time_t(new Date()); 
        		list.add(checkRecord);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	int con = rockWellEntityDTO.getInserted().size();
        	List list = new ArrayList<>();
        	for (int i = 0; i < con; i++) {
        		MachineCheckRecord checkRecord=(MachineCheckRecord) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), MachineCheckRecord.class);
        		checkRecord.setCreated_time_t(new Date()); 
        		list.add(checkRecord);
        	}
        	save(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	int con = rockWellEntityDTO.getUpdated().size();
        	for (int i = 0; i < con; i++) {
        		MachineCheckRecord checkRecord=(MachineCheckRecord) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MachineCheckRecord.class);
        		checkRecord.setCreated_time_t(new Date()); 
        		update(checkRecord);
        	}
        }
    
    }

}
