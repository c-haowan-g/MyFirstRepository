/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.curing.entity.FeedingQueueLog;
import org.xdemo.app.xutils.j2se.ListUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * 硫化扫描日志
 *
 * @author 李新宇
 * @Date 2020-02-20 15:23:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeedingQueueLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return FeedingQueueLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    /**
     * 接收RockWell返回的数据拼接投料人信息
     * @param filter
     * @param page
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
        List<Map<String, Object>> returnlist = super.datagridRowsUDA(filter,page);
        for (int i = 0; i < returnlist.size(); i++) {
            if (returnlist.get(i).get("username") != null) {
                String created_by_s = (String) returnlist.get(i).get("created_by_s");
                
                returnlist.get(i).put("created_by_s", created_by_s + returnlist.get(i).get("username"));
                
                if(returnlist.get(i).get("product_operator_s") != null){
                	String product_operator_s = (String) returnlist.get(i).get("product_operator_s");
                	returnlist.get(i).put("product_operator_s", product_operator_s + returnlist.get(i).get("username"));
                }
            }
        }
        return returnlist;
    }

}
