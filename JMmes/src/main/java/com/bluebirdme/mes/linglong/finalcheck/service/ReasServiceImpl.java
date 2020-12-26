/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Reas;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ReasDTO;

import freemarker.template.TemplateException;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 质检病象信息表
 * @author 司乔靖
 * @Date 2018-08-05 13:14:26
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ReasServiceImpl extends RockWellBaseServiceImpl<Reas> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Reas.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    @RockWellTransactional
    public void saveChanges(ReasDTO reas) throws Exception{
        
        if (!ListUtils.isEmpty(reas.getDeleted())) {
        	List<Reas> reasList = reas.getDeleted();
        	for(Reas item:reasList)
        	{
        		item.setRecord_flag_s("D");
        		item.setChanged_by_s(LLWebUtils.getUser().userCode);
        		item.setChanged_time_t(new Date());
        		if(item.getCollet_code_s().equals("262001")){
            		item.setCollet_code_desc_cn_s("外观病象");
            	}else if(item.getCollet_code_s().equals("262004")){
            		item.setCollet_code_desc_cn_s("X光病象");
            	}
        		
        	}
            update(reasList);
        }
        if (!ListUtils.isEmpty(reas.getInserted())) {
        	List<Reas> reasList = reas.getInserted();
        	int maxCode=getReasCodeMaxValue();
        	for(Reas item:reasList)
        	{
        		maxCode=maxCode+1;
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setCreated_by_s(LLWebUtils.getUser().userCode);
        		item.setCreated_time_t(new Date());
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setSpare5_s("0");
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		item.setReas_code_s(String.valueOf(maxCode));
        		item.setReas_grp_desc_cn_s("外观病象");
        		if(item.getCollet_code_s().equals("262001")){
            		item.setCollet_code_desc_cn_s("外观病象");
            	}else if(item.getCollet_code_s().equals("262004")){
            		item.setCollet_code_desc_cn_s("X光病象");
            	}
        	}
            save(reasList);
        }
        if (!ListUtils.isEmpty(reas.getUpdated())) {
        	List<Reas> reasList = reas.getUpdated();
        	for(Reas item:reasList)
        	{
        		item.setChanged_by_s(LLWebUtils.getUser().userCode);
        		item.setChanged_time_t(new Date());
        		//if(item.getCollet_code_s().equals("262001")){
        		if(item.getCollet_code_s().equals("262001")){
            		item.setCollet_code_desc_cn_s("外观病象");
            	}else if(item.getCollet_code_s().equals("262004")){
            		item.setCollet_code_desc_cn_s("X光病象");
            	}
        	}
            update(reasList);
        }
    
    }
    /**
     * 获取病象编号最大值
     * @return 最大值
     * @throws Exception 
     * @throws TemplateException 
     */
    @SuppressWarnings("unchecked")
    public int getReasCodeMaxValue() throws Exception
    {
    	String factoryString=LLWebUtils.factory();
      	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
  	   	Filter filter = new Filter();
  	   	filter.set("s_factory_s", factoryString);
  	   	filter.set("agenc_no_s",factoryCodeString );
    	SQLQuery query=createSQLQuery(getSQL("reas_code_max",filter.getFilter()));
    	query.setParameter("s_factory_s", filter.get("s_factory_s"));
     	query.setParameter("agenc_no_s",filter.get("agenc_no_s") );
    	List<Map<String, Object>> list=query.list();
        
    	for(Map<String,Object> map :list){
    		for(String key:map.keySet()){
    			int result=  Integer.parseInt(map.get(key).toString());
			   return  result;
			}
    	}
    	return 0;
    }
  
    //病象号和病象描述关系
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getComboxReasCodeDesc() throws Exception
    {
    	String lan=LanguageProvider.getLanguage(); 
    	List<Map<String, Object>> list = null;
    	if(lan.equals("zh")){
    		SQLQuery query=createSQLQuery(getSQL("comboxReasCodeDescCn"));
    		query.setParameter("s_factory_s", LLWebUtils.factory());
    		 list=query.list();
    	}
    	else if(lan.equals("en")){
    		SQLQuery query=createSQLQuery(getSQL("comboxReasCodeDescEn"));
    		query.setParameter("s_factory_s", LLWebUtils.factory());
    		 list=query.list();
    	}
    	else {
    		SQLQuery query=createSQLQuery(getSQL("comboxReasCodeDescOther"));
    		query.setParameter("s_factory_s", LLWebUtils.factory());
    		list=query.list();
    	}
	    return list;
    }
    
    //查看外观病象
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> comboxReasCodeDescWg() throws Exception
    {
    	List<Map<String, Object>> list = null;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("WGREASCODE", "0");
    	map.put("WGREASDESC", "全部");
		SQLQuery query=createSQLQuery(getSQL("comboxReasCodeDescwg"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		list=query.list();
		list.add(0,map);
	    return list;
    }
    
    //查看X光病象
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> comboxReasCodeDescXray() throws Exception
    {
    	List<Map<String, Object>> list = null;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("XRAYREASCODE", "0");
    	map.put("XRAYREASDESC", "全部");
		SQLQuery query=createSQLQuery(getSQL("comboxReasCodeDescxray"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		list=query.list();
		list.add(0,map);
	    return list;
    }
    
    
}
