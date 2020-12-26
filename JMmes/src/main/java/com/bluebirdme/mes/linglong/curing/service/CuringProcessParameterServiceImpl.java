/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringProcessParameter;

/**
 * 
 * @author Goofy
 * @Date 2018年9月12日 下午3:11:47
 */
@Service
public class CuringProcessParameterServiceImpl extends RockWellBaseServiceImpl<CuringProcessParameter> {
	
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
		return CuringProcessParameter.class;
	}

	@RockWellTransactional
	public void saveParams(String s_Factory,String dailyPlanCode, String lhProcId, String cxProcId) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> params = createSQLQuery(getSQL("getParams")).
											setParameter("cxProcId", cxProcId).
											  setParameter("s_Factory_s", s_Factory).
												setParameter("lhProcId", lhProcId).list();
		
		List<CuringProcessParameter> list = new ArrayList<CuringProcessParameter>();
		for(Map<String,Object> map:params){
			list.add(new CuringProcessParameter(dailyPlanCode,map));
		}
		
		super.save(list);
	}
	/**
	 * 
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

	@RockWellTransactional
	public void saveTestParams(String s_Factory,String planno,String productDate, String productionline, String materialcode,int direction) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> params = createSQLQuery(getSQL("getTestParams"))
				                             .setParameter("s_Factory_s", s_Factory)
		                                     .setParameter("productDate", productDate)
		                                     .setParameter("productionline", productionline)
		                                     .setParameter("materialcode", materialcode).list();
		List<CuringProcessParameter> list = new ArrayList<CuringProcessParameter>();
		for(Map<String,Object> map:params){
			list.add(new CuringProcessParameter(s_Factory,planno,map,materialcode,direction));
		}
		
		super.save(list);
	}
	
}
