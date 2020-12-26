/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.Drrecord;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * 密炼投料履历
 * @author 栾和源
 * @Date 2020-08-03 11:41:49
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DrrecordServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	/**
	 *ServiceImpl可以继承RockWellBaseServiceImpl,RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候，返回值为List<Map<String,Object>>类型。
	 RockWellBaseServiceImpl使用datagrid查询返回的是List<T>类型，这个类型是根据Controller里面，调用datagrid
	 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Drrecord.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
     * 加载密炼机台信息 
     * 栾和源
     * 2020-08-03
     */
	public List<Map<String,Object>> getMixProductionInfo(String plantype) throws Exception{
		try {
			//051001-小料计划 051002-硫磺计划 051003-胶料计划
			String areaname="";
			String[] matchlist =null;
			//全钢
		    if(LLWebUtils.factory().equals("1")){
		    	areaname="80231MX";
		    	if(plantype.equals("051003")){
					matchlist=new String[]{"F0101","F0102","F0103","F0104","F0105","F0106","F0107","F0108"};
				}
				if(plantype.equals("051002")){
					matchlist=new String[]{"F0201","F0202","F0203"};
				}
				if(plantype.equals("051001")){
					matchlist=new String[]{"F0204","F0205","F0206"};
				}
				//胶料和小料
				if(plantype.equals("051003051001")){
					matchlist=new String[]{"F01","F02"};
				}
				//密炼配灌维护界面机台要求显示胶料与硫磺
				if(plantype.equals("051004")) {
					matchlist=new String[]{"F01","F02"};
				}
		    }else{
		    	//半钢
		    	areaname="80232MX";
		    	if(plantype.equals("051003")){
					matchlist=new String[]{"H0101","H0102","H0103","H0104","H0105","H0106","H0107","H0108"};
				}
				if(plantype.equals("051002")){
					matchlist=new String[]{"H0201","H0202","H0203"};
				}
				if(plantype.equals("051001")){
					matchlist=new String[]{"H0204","H0205","H0206"};
				}
				//密炼配灌维护界面机台要求显示胶料与硫磺
				if(plantype.equals("051004")) {
					matchlist=new String[]{"H01","H0201","H0202","H0203"};
				}
				//胶料和小料
				if(plantype.equals("051003051001")){
					matchlist=new String[]{"H010","H020"};
				}
				//门尼硫变
				if(plantype.equals("H08907")){
					matchlist=new String[]{"H08","H07"};
				}
		    }
			return getProductionInfoByAreaNameAndMatchlist(areaname,matchlist);
		} catch (Exception e) {
			return null;
		}
	}
   
    /**
     * 根据工段+匹配字符，获取产线信息
     * @param areaname
     * @param matchlist 匹配的是pline_name
     * @return
     * @throws Exception
     * @author 栾和源
     * @date 2020年8月3日
     */
    public List<Map<String,Object>> getProductionInfoByAreaNameAndMatchlist(String areaname,String[] matchlist) throws Exception{
    	StringBuffer sql=new StringBuffer();
    	  sql.append("select   a.area_name,a.description areadescription,p.p_line_name,p.description");
    	  sql.append(" from area a, area_production_line l2, production_line p");
    	  sql.append(" where l2.parent_key = a.area_key");
    	  sql.append(" and l2.child_key = p.p_line_key");
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
          System.out.println(sql.toString());
          SQLQuery query=createSQLQuery(sql.toString());
	      List<Map<String, Object>> res=query.list();
	      List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
	      for (int i = 0; i < res.size(); i++) {
	  			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
	  		}
  		return list_new;
    }
    

}
