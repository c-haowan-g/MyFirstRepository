/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.CuringProcessParameter;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * PLM硫化工艺参数
 * @author 司乔靖
 * @Date 2019-07-16 10:13:23
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlmCuringProcessParameterServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
	protected Session getSession() {
    	return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return null;
	}
	
	public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
	
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
    	String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				System.out.println(LLWebUtils.factory());
				if(LLWebUtils.factory().equals("1")){
					filter.set("s_factory_s", "H2");
				}else{
					filter.set("s_factory_s", "in:H1,H3");
				}
				
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
    	
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}
    
    //查询参数列表
    public List<Map<String, Object>> searchParameter(String route_name) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchParameter"));
		query.setParameter("route_name", route_name);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> l = query.list();
		List<Map<String, Object>> newl = new ArrayList<>();
		for(int i = 0; i<l.size();i++){
			Map<String, Object> m = l.get(i);
			Map<String, Object> newm = new HashMap<String, Object>();
			for (String key: m.keySet()){
				Object value = m.get(key);
				String newk = key.toLowerCase();
				newm.put(newk, value);
			}
			newl.add(newm);
		}
		return newl;
	}
    
    @RockWellTransactional
    public int saveChanges(UdaDto udadto) throws Exception{
        
        if (!ListUtils.isEmpty(udadto.getDeleted())) {
	         List<Map<String, Object>> listMap=udadto.getDeleted();
	         for(Map<String, Object> item:listMap){}
        }
        if (!ListUtils.isEmpty(udadto.getInserted())) {
             List<Map<String, Object>> listMap=udadto.getInserted();
             for(Map<String, Object> item:listMap){}
        }
        if (!ListUtils.isEmpty(udadto.getUpdated())) {
            List<Map<String, Object>> listMap=udadto.getUpdated();
            for(Map<String, Object> item:listMap){}
        }
        
    	return 1;
    }

    /**
   	 * 查询硫化总时间
   	 * @param s_Factory
   	 * @param dailyPlanCode
   	 * @param lhProcId
   	 * @param cxProcId
   	 * @throws Exception
   	 */
   	public String getCurringFullTimeParams( String lhProcId) throws Exception {
   		@SuppressWarnings("unchecked")
   		List<Map<String, Object>> params = createSQLQuery(getSQL("getCurringFullTimeParams")).
   												setParameter("lhProcId", lhProcId).list();
   		String curringFullTimeString="无硫化总时间信息";
   		for(Map<String,Object> map :params){
       		for(String key:map.keySet()){
       			if(map.get(key).toString()!=""){
       				curringFullTimeString=map.get(key).toString();
       			};
   			}
       	}
   		 return  curringFullTimeString;
   	}
   	
   	@RockWellTransactional
	public void deleteParams(String dailyPlanCode){
		RockWellUtils.execSQL("delete from AT_C_MM_PlanCuringParameter where producting_dayplan_s='"+dailyPlanCode+"'"+"and s_factory_s="+"'"+LLWebUtils.factory()+"'");
	}
   	/**
   	 * 周清玉 根据成型或硫化工艺路线查询工艺参数并下发
   	 * @param s_Factory
   	 * @param dailyPlanCode
   	 * @param lhProcId
   	 * @param cxProcId
   	 * @throws Exception
   	 */
   	@RockWellTransactional
	public void saveParams(String s_Factory,String dailyPlanCode, String lhProcId, String cxProcId,String material_code,int direction) throws Exception {
   		System.out.println(getSQL("getParams")+"--------------------");
   		@SuppressWarnings("unchecked")
		List<Map<String, Object>> params = createSQLQuery(getSQL("getParams")).
											setParameter("cxProcId", cxProcId).
											  setParameter("s_Factory_s", s_Factory).
											  
												setParameter("lhProcId", lhProcId).list();
		List<Object> list = new ArrayList<Object>();
		for(Map<String,Object> map:params){
			list.add(new CuringProcessParameter(dailyPlanCode,map,material_code ,direction));
		}
		super.save(list);
	}
   	
   	@RockWellTransactional
	public void saveTestParams(String s_Factory,String planno,String productDate, String productionline, String materialcode,int direction) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> params = createSQLQuery(getSQL("getTestParams"))
				                             .setParameter("s_Factory_s", s_Factory)
		                                     .setParameter("productDate", productDate)
		                                     .setParameter("productionline", productionline)
		                                     .setParameter("materialcode", materialcode).list();
		List<Object> list = new ArrayList<Object>();
		for(Map<String,Object> map:params){
			list.add(new CuringProcessParameter(s_Factory,planno,map,materialcode, direction));
		}
		   
		super.save(list);
	}
}
