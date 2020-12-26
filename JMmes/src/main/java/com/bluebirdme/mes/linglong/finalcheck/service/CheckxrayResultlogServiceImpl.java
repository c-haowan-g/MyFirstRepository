/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.CheckxrayResultlog;
import org.xdemo.app.xutils.j2se.ListUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * X光质检信息日志查询
 * @author 李新宇
 * @Date 2020-04-15 10:51:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CheckxrayResultlogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return CheckxrayResultlog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
                //将MAP转换为实体
                CheckxrayResultlog checkxrayresultlog = (CheckxrayResultlog) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), CheckxrayResultlog.class);
                //checkxrayresultlog.setCreated_time_t(new Date());
                list.add(checkxrayresultlog);
            }
            delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
                //将MAP转换为实体
                CheckxrayResultlog checkxrayresultlog = (CheckxrayResultlog) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), CheckxrayResultlog.class);
                //checkxrayresultlog.setCreated_time_t(new Date());
                list.add(checkxrayresultlog);
            }
            save(list);
        }
        /**
         *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
         */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
                //将MAP转换为实体
                CheckxrayResultlog checkxrayresultlog = (CheckxrayResultlog) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), CheckxrayResultlog.class);
                //checkxrayresultlog.setCreated_time_t(new Date());
                update(checkxrayresultlog);
            }
        }

    }
}
