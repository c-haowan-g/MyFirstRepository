/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.pnuts.xml.newDocument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.FactoryProductLine;
import com.bluebirdme.mes.linglong.common.entity.RockWellFactoryModel;
import com.bluebirdme.mes.linglong.common.service.RockWellFactoryModelServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 工厂模型表
 * @author 刘程明
 * @Date 2019-07-30 10:51:23
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MixFactoryModelServiceImpl  extends BaseServiceImpl<RockWellFactoryModel>  {

    @Resource LingLongDataSource llds;
    @Override
	protected Class getEntity() {
    	 return FactoryProductLine.class;
	}

	@Override
	protected Session getSession() {
		 return llds.getSession();
	}
	@Override
	protected boolean useCache() {
		 return false;
	}
    /**
     * 根据工段+匹配字符，获取产线信息
     * @param areaname
     * @param matchlist 匹配的是pline_name
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年8月13日
     */
    public List<Map<String,Object>> getProductionInfoByAreaNameAndMatchlist(String areaname,String[] matchlist) throws Exception{
    	StringBuffer sql=new StringBuffer();
    	  sql.append("select   a.area_name,a.description areadescription,p.p_line_name,p.description,up.*");
    	  sql.append(" from area a, area_production_line l2, production_line p,uda_productionline up");
    	  sql.append(" where l2.parent_key = a.area_key");
    	  sql.append(" and l2.child_key = p.p_line_key");
    	  sql.append(" and p.p_line_key=up.object_key(+)");
          if(matchlist!=null&&matchlist.length>0){
        	  String matchString="";
        	  sql.append(" and REGEXP_LIKE(p.p_line_name, '(");
        	  for(int i=0;i<matchlist.length;i++){
        		  matchString=matchString+matchlist[i].toString()+"|";
        	  }
        	  sql.append(matchString.substring(0, matchString.length()-1).trim());
          	  sql.append(")') ");
          }
          if(areaname.equals("")){       	  
          }else{
          sql.append(" and a.area_name='");
          sql.append(areaname+"'");
          }
          sql.append(" order by p.p_line_name");
    	
          SQLQuery query=createSQLQuery(sql.toString());
	      List<Map<String, Object>> res=query.list();
	      List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
	      for (int i = 0; i < res.size(); i++) {
	  			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
	  		}
  		return list_new;
    }
    
    /**
     * 根据工段+匹配字符，获取库区信息
     * @param areaname
     * @param matchlist 匹配的是storage_zone_name
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年8月13日
     */
    public List<Map<String,Object>> getStorageZoneInfoByAreaNameAndMatchlist(String areaname,String[] matchlist) throws Exception{
    	StringBuffer sql=new StringBuffer();
    	  sql.append("select a.area_name,\r\n" + 
    	  		"       a.description areadescription,\r\n" + 
    	  		"       p.storage_zone_name,\r\n" + 
    	  		"       p.description,\r\n" + 
    	  		"       up.*\r\n" + 
    	  		"  from area                 a,\r\n" + 
    	  		"       area_storage_zone l2,\r\n" + 
    	  		"       storage_zone      p,\r\n" + 
    	  		"       uda_storagezone   up\r\n" + 
    	  		" where l2.parent_key = a.area_key\r\n" + 
    	  		"   and l2.child_key = p.storage_zone_key\r\n" + 
    	  		"   and p.storage_zone_key = up.object_key(+) ");
          if(matchlist!=null&&matchlist.length>0){
        	  String matchString="";
        	  sql.append(" and REGEXP_LIKE(p.storage_zone_name, '(");
        	  for(int i=0;i<matchlist.length;i++){
        		  matchString=matchString+matchlist[i].toString()+"|";
        	  }
        	  sql.append(matchString.substring(0, matchString.length()-1).trim());
          	  sql.append(")') ");
          }
          sql.append(" and a.area_name='");
          sql.append(areaname+"'");
          sql.append(" order by p.storage_zone_name");
    	
          SQLQuery query=createSQLQuery(sql.toString());
	      List<Map<String, Object>> res=query.list();
	      List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
	      for (int i = 0; i < res.size(); i++) {
	  			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
	  		}
  		return list_new;
    }
    
    //根据机台类型获取机台信息
	public List<Map<String,Object>> getMixProductionInfo(String plantype) throws Exception{
		try {
			//051001-小料计划 051002-硫磺计划 051003-胶料计划
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
		    	if(plantype.equals("051003")){
					matchlist=new String[]{"E0101","E0102","E0103","E0104","E0105","E0106","E0107","E0108"};
				}
				if(plantype.equals("051002")){
					matchlist=new String[]{"E0201","E0202","E0203"};
				}
				if(plantype.equals("051001")){
					matchlist=new String[]{"E0204","E0205","E0206"};
				}
				//胶料和小料
				if(plantype.equals("051003051001")){
					matchlist=new String[]{"E01","E02"};
				}
				//密炼配灌维护界面机台要求显示胶料与硫磺
				if(plantype.equals("051004")) {
					matchlist=new String[]{"E01","E0201","E0202","E0203"};
				}
		    }else{
		    	areaname="80032MX";
		    	if(plantype.equals("051003")){
					matchlist=new String[]{"90101","90102","90103","90104","90105","90106","90107","90108"};
				}
				if(plantype.equals("051002")){
					matchlist=new String[]{"90201","90202","90203"};
				}
				if(plantype.equals("051001")){
					matchlist=new String[]{"90204","90205","90206"};
				}
				//密炼配灌维护界面机台要求显示胶料与硫磺
				if(plantype.equals("051004")) {
					matchlist=new String[]{"901","90201","90202","90203"};
				}
				//胶料和小料
				if(plantype.equals("051003051001")){
					matchlist=new String[]{"9010","9020"};
				}
				//门尼硫变
				if(plantype.equals("908907")){
					matchlist=new String[]{"908","907"};
				}
		    }//半钢
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
    //根据类型获取库区信息
	public List<Map<String,Object>> getStorageZoneInfo(String zonetype) throws Exception{
		try {
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
		    	if(zonetype.equals("926")){
					matchlist=new String[]{"EM926"};
				}
				if(zonetype.equals("927")){
					matchlist=new String[]{"EM927"};
				}
				if(zonetype.equals("928")){
					matchlist=new String[]{"EM928"};
				}
				if(zonetype.equals("929")){
					matchlist=new String[]{"EM929"};
				}
				if(zonetype.equals("930")){
					matchlist=new String[]{"EM930"};
				}if(zonetype.equals("")){
					matchlist=new String[]{"EM926","EM927","EM928","EM929","EM930"};
				}
				//全钢
		    }else{
		    	areaname="80032MX";
		    	if(zonetype.equals("926")){
					matchlist=new String[]{"9M926"};
				}
				if(zonetype.equals("927")){
					matchlist=new String[]{"9M927"};
				}
				if(zonetype.equals("928")){
					matchlist=new String[]{"9M928"};
				}
				if(zonetype.equals("929")){
					matchlist=new String[]{"9M929"};
				}
				if(zonetype.equals("930")){
					matchlist=new String[]{"9M930"};
				}if(zonetype.equals("")){
					matchlist=new String[]{"9M926","9M927","9M928","9M929","9M930"};
				}
		    }//半钢
			return getStorageZoneInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public List<Map<String,Object>> getMixProductionInfo() throws Exception{
		try {
			//051001-小料计划 051002-硫磺计划 051003-胶料计划
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
		    	matchlist=new String[]{"E0204","E0205","E0206","E0201","E0202","E0203"};
		    }else{
		    	areaname="80032MX";
				matchlist=new String[]{"90204","90205","90206","90201","90202","90203"};
		    }//半钢
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Map<String,Object>> getRfidByPlinename() throws Exception{
		try {			
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
		    	matchlist=new String[]{"E0101","E0102","E0103","E0104","E0106","E0107","E0108"};
		    }else{
		    	areaname="80032MX";
				matchlist=new String[]{"90101","90102","90103","90104","90106","90107","90108"};
		    }//半钢
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Map<String,Object>> getplmByPlinename() throws Exception{
		try {			
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
		    	matchlist=new String[]{"E0101","E0102","E0103","E0104","E0105","E0106","E0107","E0108","E0201","E0202","E0203","E0204","E0205","E0206"};
		    }else{
		    	areaname="80032MX";
				matchlist=new String[]{"90101","90102","90103","90104","90105","90106","90107","90108","90201","90202","90203","90204","90205","90206"};
		    }//半钢
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 获取所有plm机台
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getplmByPlinenameall() throws Exception{
		try {			
			String areaname="";
			String[] matchlist =null;
			
		    	matchlist=new String[]{"E0101","E0102","E0103","E0104","E0105","E0106","E0107","E0108","E0201","E0202","E0203","E0204","E0205","E0206",
		    			"90101","90102","90103","90104","90105","90106","90107","90108","90201","90202","90203","90204","90205","90206"};

			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
    //根据计划类型获取对应的机台列表
	public List<Map<String,Object>> getHopperInfoByPlinename(String plinename) throws Exception{
		StringBuffer sql=new StringBuffer();
		sql.append("select e.* from production_line p, p_line_work_center l3, work_center w,work_center_equipment l4, equipment e ");
		sql.append("  where l4.parent_key = w.wc_key ");
		sql.append("  and l4.child_key = e.equip_key ");
		sql.append("  and l3.parent_key = p.p_line_key ");
		sql.append("  and l3.child_key = w.wc_key ");
		sql.append("  and p.p_line_name like'%");
		sql.append(plinename);
		sql.append("%' order by to_number(e.equip_name)");
		SQLQuery query=createSQLQuery(sql.toString());
	      List<Map<String, Object>> res=query.list();
	      List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
	      for (int i = 0; i < res.size(); i++) {
	  			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
	  		}
  		return list_new;
	}
	/**
	 * 根据库区名称获取库位信息--给LC用
	 * @param zonename 库区name,例如：一楼炭黑库对应005006，传入005006
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMixStorageUnitByZoneName(String zonename) throws Exception{
		 SQLQuery query=createSQLQuery(getSQL("getStorageUnitByZoneName"));
		  query.setParameter("zonename", zonename);
	      List<Map<String, Object>> res=query.list();
	      List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
	      for (int i = 0; i < res.size(); i++) {
	  			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
	  		}
  		return list_new;
	}
	/**
	 * //获取密炼所有库区，底层根据全钢半钢区分
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getMixStorageZone() throws Exception{
		try {
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80031MX";
			    matchlist=new String[]{"E05"};
			
		    }else{
		    	areaname="80032MX";
				matchlist=new String[]{"005"};
				
		    }//半钢
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
}
