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
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanAppearanceLog;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 质检外观扫描履历表
 * @author 王海霖
 * @Date 2018-09-03 14:27:44
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ScanAppearanceLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ScanAppearanceLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
   
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName(String spare1_s) throws Exception
    {
    	String factoryString=LLWebUtils.factory();
      	String agenc_no_sString =FactoryConstant.JING_MEN_CODE;
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	query.setParameter("spare1_s", spare1_s);
		query.setParameter("s_factory_s", factoryString);
		query.setParameter("agenc_no_s", agenc_no_sString);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	List<Map<String, Object>> list=query.list();
		return list;
    }
}
