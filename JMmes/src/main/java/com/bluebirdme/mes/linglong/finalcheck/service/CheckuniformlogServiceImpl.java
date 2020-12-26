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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Checkuniformlog;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 质检均匀机检测履历表_全钢
 * @author 时永良
 * @Date 2019-05-02 10:00:12
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CheckuniformlogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Checkuniformlog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	query.setParameter("s_factory_s", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    
    @SuppressWarnings("unchecked")
	public String getEndNameByEntCode(String entCode) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getEndNameByEntCode"));
		query.setParameter("s_factory_s", "1");
		query.setParameter("entCode", entCode);
		String result = null;
		List<Map<String, Object>> list = query.list();
		for(int i = 0; i < list.size(); i++){
			result = list.get(i).get("DESCRIPTION").toString();
		}
		return result;
	}
}
