package com.bluebirdme.mes.linglong.building.service;

import javax.annotation.Resource;
import java.util.*;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.building.entity.EquipmentRealTime;
import org.xdemo.app.xutils.j2se.ListUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * 设备报警停机实时表
 *
 * @author 李新宇
 * @Date 2020-01-20 09:33:58
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EquipmentRealTimeServiceImpl extends RockWellUDABaseServiceImpl<Object> {


    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return EquipmentRealTime.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    /**
     * 获取全部机台条码
     *
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getEquipCodeList() throws Exception {
        if (getSQL("equipCode_list") == null) {
            throw new Exception(getClass() + ".xml中未找到ID为equipCode_list的SQL语句定义");
        }

        String SQL = getSQL("equipCode_list");
        System.out.println(SQL);
        Query query = createSQLQuery(SQL);
        return query.list();
    }


    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
                //将MAP转换为实体
                EquipmentRealTime equipmentrealtime = (EquipmentRealTime) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), EquipmentRealTime.class);
                //equipmentrealtime.setCreated_time_t(new Date());
                list.add(equipmentrealtime);
            }
            delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
                //将MAP转换为实体
                EquipmentRealTime equipmentrealtime = (EquipmentRealTime) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), EquipmentRealTime.class);
                //equipmentrealtime.setCreated_time_t(new Date());
                list.add(equipmentrealtime);
            }
            save(list);
        }
        /**
         *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
         */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
                //将MAP转换为实体
                EquipmentRealTime equipmentrealtime = (EquipmentRealTime) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), EquipmentRealTime.class);
                //equipmentrealtime.setCreated_time_t(new Date());
                update(equipmentrealtime);
            }
        }

    }

}
