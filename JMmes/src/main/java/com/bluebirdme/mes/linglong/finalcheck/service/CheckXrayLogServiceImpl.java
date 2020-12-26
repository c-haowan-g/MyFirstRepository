/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.CheckXrayLog;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * X光检测履历
 * @author 时永良
 * @Date 2018-08-09 07:39:33
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CheckXrayLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return CheckXrayLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	List<Map<String, Object>> list=query.list();
		return list;
    }

}
