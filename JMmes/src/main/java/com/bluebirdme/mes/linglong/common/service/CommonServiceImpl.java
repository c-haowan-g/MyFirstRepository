/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;


/**
 * 通用信息查询
 * @author 刘程明
 * @Date 2018-07-24 16:54:01
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CommonServiceImpl extends RockWellBaseServiceImpl<T> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return null;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getCombox_BuringEntCode() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("BuringEntCodeName"));
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	List<Map<String, Object>> list=query.list();
		return list;
    }
  //获取用户信息
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getComboxUser() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxUser"));
    	List<Map<String, Object>> list=query.list();
	return list;
    }
    //获取特定设备信息
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEnttypeName(String enttype) throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("getenttypeName"));
    	query.setParameter("s_factory_s", LLWebUtils.factory());
    	query.setParameter("enttype", enttype);
    	String SQL=query.getQueryString();
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    
    public List<Object> getProductVersionByMaterialCode(String materialCode){
    	if(materialCode.indexOf("_")>0){
    		materialCode=materialCode.substring(0,materialCode.indexOf("_"));
    	}
//    	SQLQuery q=createSQLQuery("select PRODUCTION_VER_S from AT_INT_SAP_PRODUCTVERSION where MATERIAL_CODE_S='"+materialCode+"' and MATSTATUS_S='' and MKSP_S='' ");
    	SQLQuery q=getSession().createSQLQuery("select PRODUCTION_VER_S from AT_INT_SAP_PRODUCTVERSION where MATERIAL_CODE_S='"+materialCode+"'");
    	return q.list();
    }
    
}
