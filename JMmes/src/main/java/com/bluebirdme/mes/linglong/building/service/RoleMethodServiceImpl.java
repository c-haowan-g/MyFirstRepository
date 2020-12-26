/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.building.entity.ChangeMould;
import com.bluebirdme.mes.linglong.building.entity.RoleMethod;

import org.xdemo.app.xutils.j2se.ListUtils;
import org.hibernate.SQLQuery;

/**
 * 角色功能对应表
 * @author 兰颖慧
 * @Date 2019-03-18 09:12:58
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleMethodServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected Class getEntity() {
        return RoleMethod.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
        if(filter.getFilter().get("method_name_s")!=null){
        	ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
        	filter.set("method_name_s", exportCombox.getDictname(filter.getFilter().get("method_name_s").toString()));
        }
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    @RockWellTransactional
    public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())){
        	List<Map<String, Object>> roleMethodList=rockWellEntityDTO.getInserted();
        	List<Object> roleMetheds=new ArrayList<Object>();//保存对象
        	List<String> newRoleNameList=new ArrayList<>();
        	List<String> newMethodNameList=new ArrayList<>();
        	List<String> result =new ArrayList<>();
        	for(Map<String, Object> newitem:roleMethodList){
        		RoleMethod item = (RoleMethod)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setS_factory_s(LLWebUtils.factory());  //设置全钢半钢 1/2
        		item.setAgenc_no_s(LLConstant.JING_MEN_CODE);  //设置机构代码8023
        		item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);//数据状态A/D        		
        		item.setCreated_by_s(LLWebUtils.getUser().userCode); //创建人
        		item.setCreated_time_t(new Date());  //创建时间
        		//调用where方法进行数据库查重
        		String newRoleName=item.getRole_name_s(); 	
        		String newMethodName=item.getMethod_name_s(); 	
				if(duplicationCheck(newRoleName,newMethodName)==true){
					result.add("角色权限配置数据库已存在");
					continue;
				}
				if(newRoleNameList.contains(newRoleName)&&newMethodNameList.contains(newMethodName)==true) //界面新增行判重
				{
					result.add("角色权限配置界面内已存在");
					continue;
				}else{
			         newRoleNameList.add(newRoleName);
			         newMethodNameList.add(newMethodName);
			         roleMetheds.add(item);
				}
        	}
        	boolean fuck=result.isEmpty();
			if(fuck==true){
		         save(roleMetheds);
		         return "操作成功";
			}else{
				 return result.toString();
			}
        }
    	
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List<Map<String, Object>> roleMethodList=rockWellEntityDTO.getDeleted();
        	List<Object> roleMetheds=new ArrayList<Object>();//保存对象
        	for(Map<String, Object> newitem:roleMethodList){
        		RoleMethod item = (RoleMethod)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
        		roleMetheds.add(item);
        		//item.setRecord_flag_s("D");
        	}
        	//save(roleMethodList);
           update(roleMetheds);
           return "操作成功";
        } 

        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	List<Map<String, Object>> roleMethodListUp=rockWellEntityDTO.getUpdated();
        	List<Object> roleMetheds=new ArrayList<Object>();//保存对象
        	List<String> newRoleNameList=new ArrayList<>();
        	List<String> newMethodNameList=new ArrayList<>();
        	List<String> result =new ArrayList<>();
        	for(Map<String, Object> newitem:roleMethodListUp){
        		RoleMethod item = (RoleMethod)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setChanged_by_s(LLWebUtils.getUser().userCode); //修改人
        		item.setChanged_time_t(new Date());  //修改时间
        		String roleName=item.getRole_name_s(); 	
        		String methodName=item.getMethod_name_s(); 	
				
				if(duplicationCheck(roleName,methodName)==true){
					result.add("角色权限配置数据库已存在");
					continue;
				}
				if(newRoleNameList.contains(roleName)&&newMethodNameList.contains(methodName)==true) //界面新增行判重
				{
					result.add("角色权限配置界面内已存在");
					continue;
				}else{
			         newRoleNameList.add(roleName);
			         newMethodNameList.add(methodName);
			         roleMetheds.add(item);
				}
        	}
			if(result.isEmpty()==true){
				 update(roleMetheds);
		         return "操作成功";
			}else{
				 return result.toString();
			}
        }
		return "未执行任何操作";
    }
    /**
     * 数据库内数据判重
     * 兰颖慧-2019/03/19
     * @return 
     * @throws Exception
     */
	public boolean duplicationCheck(String roleName,String methodName) throws Exception {
		Where where1 = new Where();  
		where1.andEqual("role_name_s", roleName);
		where1.andEqual("method_name_s", methodName);
		where1.andEqual("record_flag_s", "A");   
		where1.andEqual("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = findMapByWhere(where1); //
		if (list.size() != 0) //数据库内判重
		{  
			return true;
		}
		else{
			return false;
		}
	}
    
    /**
     * 从CORE_ROLE表中查询角色名称和角色ID
     * 兰颖慧-2019/03/18
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String> searchRoleName(){
    	SQLQuery roleNameQuery=createSQLQuery(getSQL("searchRoleName"));
    	return roleNameQuery.list();
    } 
	
    /**
     * 从基础数据表(at_cm_bs_coredictionary)表中查询功能名称和功能代码
     * 兰颖慧-2019/03/18
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String> searchMethodName(){
    	SQLQuery methodNameQuery=createSQLQuery(getSQL("searchMethodName"));
    	return methodNameQuery.list();
    } 

}
