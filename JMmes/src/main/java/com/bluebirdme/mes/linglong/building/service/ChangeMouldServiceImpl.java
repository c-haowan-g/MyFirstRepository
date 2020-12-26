/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.building.entity.ChangeMould;
import com.bluebirdme.mes.linglong.building.entity.CxProductionDayPlan;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 换工装计划表
 * @author wanghailin
 * @Date 2019-03-08 13:58:56
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ChangeMouldServiceImpl extends RockWellUDABaseServiceImpl<Object> {
	
	@Resource SerialServiceImpl serialSrv;// 系统参数获取
    @Resource LingLongDataSource llds;
    @Resource CxProductionDayPlanServiceImpl cxProductionDayPlanServiceImpl;
    @Override
    protected Session getSession() {
        return llds.getSession();
    }
    @Override
    protected Class getEntity() {
        return ChangeMould.class;
    }
    @Override
    protected boolean useCache() {
        return false;
    }
    /**
     * 通过计划号获取日计划信息
     * @param planNo 计划号
     * @return
     * @author whl
     * @throws Exception 
     * @date 2019年4月16日
     */
    private CxProductionDayPlan getProductionPlanByPlanno(String planNo) throws Exception{
    	List<Object> list=cxProductionDayPlanServiceImpl.findByField("plan_no_s", planNo);
    	Object ob = (Object) list;
		List<CxProductionDayPlan> CxProductionDayPlanlist = (List<CxProductionDayPlan>)ob ;
    	if(CxProductionDayPlanlist.size()!=1){
    		return null;
    	}
    	return CxProductionDayPlanlist.get(0);
    }
    
    @RockWellTransactional
    public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	StringBuffer errorMsg=new StringBuffer();
    	 List<Map<String, Object>>changeMouldList=null;
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	 changeMouldList=rockWellEntityDTO.getInserted();
        	for(Map<String, Object> newitem:changeMouldList){
        		ChangeMould item = (ChangeMould)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setS_factory_s(LLWebUtils.factory());  //设置全钢半钢 1/2
        		item.setAgenc_no_s(LLConstant.JING_MEN_CODE);  //设置机构代码8023
        		item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);//record
        		item.setCreated_by_s(LLWebUtils.getUser().userCode); //创建人
        		item.setCreated_time_t(new Date());  //创建时间
        		item.setPlan_status_s("170001"); //设置换工装计划状态为未审核170001 审核170002换工装中170003已关闭170004
        		
        		CxProductionDayPlan cxProductionDayPlan= getProductionPlanByPlanno(item.getProduction_plan_no_s());
        	    if(cxProductionDayPlan==null){
        	    	errorMsg.append(item.getProduction_plan_no_s()+"日计划信息获取失败");
        	    }
        	    item.setMaterial_code_s(cxProductionDayPlan.getMaterial_code_s());
        	    String materialName = cxProductionDayPlan.getMaterial_desc_s();
        	    if(materialName.length()>79){
        	    	materialName = materialName.substring(0, 77);
        	    }
        	    item.setMaterial_name_s(materialName);//超长  截取   后期修改字段长度-20200515-whl
        	    item.setMaterial_spec_s(cxProductionDayPlan.getSpecification_s());
        	    item.setPlan_queue_s(cxProductionDayPlan.getPlan_queue_i().toString());//设置换工装序列号
        		item.setChangetime_s(cxProductionDayPlan.getProduction_date_s());  //设置换工装时间
        		
        	    String workorderno=serialSrv.serial("BG"+item.getProduction_plan_no_s(),4, 1).get(0).toString();
        	    item.setPlan_no_s(workorderno);
        	    save(item);
        	}
            
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	changeMouldList=rockWellEntityDTO.getUpdated();
        	//由于换工装的人也用的修改人的字段，所以不对修改字段更新
            update(changeMouldList);
        }
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	 changeMouldList=rockWellEntityDTO.getDeleted();
        	for(Map<String, Object> newitem:changeMouldList){
        		ChangeMould item = (ChangeMould)MapTrunPojo.mapToEntity(newitem, getEntity());
        		if(item.getPlan_status_s().toString().equals("170001")==true){
        			item.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
        		}else{
        			errorMsg.append(item.getExcute_time_t()+"|"+item.getPlan_no_s()+"该计划的状态不可删除"+"<br/>");
        			continue;
        		}
        		update(item);
        	}
        }
        if(errorMsg.length()>0){
        	return errorMsg.toString();
        }
        return "操作成功";
    }

     /*      
      * 换工装审核
      * whl-2019/03/13
      *
      */
      public void audit(Long[] ids) throws Exception{
    	  List<Object> planList =findByIds(ids);
    	  for(Object item:planList){
    		  if (item instanceof ChangeMould) {
    			  ChangeMould newItem = (ChangeMould) item;
    			  newItem.setPlan_status_s("170002");
    			  newItem.setAudit_by_s(LLWebUtils.getUser().userCode);
    			  newItem.setAudit_time_t(new Date());
			   }
    	  }
    	  update(planList);
      }
      /*      
       * 撤销审核
       * whl-2019/03/13
       *
       */
       public void cancelAudit(Long[] ids) throws Exception{
          List<Object> planList =findByIds(ids);
          Object ob = (Object) planList;
  		  List<ChangeMould> list = (List<ChangeMould>)ob ;
          	 for(ChangeMould item:list){
          		item.setPlan_status_s("170001");
          		item.setAudit_by_s(null);
          		item.setAudit_time_t(null);
          		update(item);
          	 }
        }
       /*      
        * 换工装关闭
        * whl-2019/03/13
        *
        */
        public void close(Long[] ids) throws Exception{
           List<Object> planList =findByIds(ids);
           	 for(Object item:planList){
           		 if(item instanceof ChangeMould){
           			 ChangeMould newItem=(ChangeMould) item;
           			 newItem.setPlan_status_s("170004");
           			 newItem.setChanged_by_s(LLWebUtils.getUser().userCode);
             		 newItem.setChanged_time_t(new Date());
           		 }
           		  
           	 }
           	update(planList);
        }
        /**   
         * 从成型日计划表获取根据当前时间以及机台编码获取成型日计划号
         * 兰颖慧-2019/03/13
         *
         */
        @SuppressWarnings("unchecked")
		public List<String> getMoldDailyPlanCode(String equipCode,String changeMouldDate){
        	    
        		SQLQuery query = createSQLQuery(getSQL("getMoldDailyPlanCode"));
        		query.setParameter("equipcode", equipCode);
        		query.setParameter("changemoulddate", changeMouldDate);
        		return query.list();
        	
        }
        /**   
         * 查询成型日计划号-供查询用
         * 兰颖慧-2019/03/16
         *
         */
        @SuppressWarnings("unchecked")
		public List<String> searchMoldDailyPlanCode(){
        		SQLQuery query = createSQLQuery(getSQL("searchMoldDailyPlanCode"));
        		return query.list();
        	
        }
        /**
         * 根据成型日计划号从成型日计划表中获取物料编码
         * 兰颖慧2019/03/21
         */
		public List<String> searchMaterialInfoByPlanNo(String planNo){
    		SQLQuery queryMaterialCode = createSQLQuery(getSQL("searchMaterialInfoByPlanNo"));
    		queryMaterialCode.setParameter("planNo", planNo);
    		return queryMaterialCode.list();
        }
        /**
         * 根据成型日计划号从成型日计划表中获取物料名称
         * 兰颖慧2019/03/21
         */
		@SuppressWarnings("unchecked")
		public List<String> searchMaterialNameByPlanCode(String planNo){
    		SQLQuery queryMaterialName = createSQLQuery(getSQL("searchMaterialNameByPlanCode"));
    		queryMaterialName.setParameter("planNo", planNo);
    		List<String> a=queryMaterialName.list();
    		return queryMaterialName.list();
        }
		/**
		 * 判断某一日计划是否已经做了换工装计划
		 * @param planno 日计划号
		 * @return
		 * @author 刘程明
		 * @date 2019年4月16日
		 */
		public boolean isCxDayPlanExitInChangePlan(String planno){
			 List list = getSession().createSQLQuery(getSQL("isCxDayPlanExitInChangePlan"))
	         			.setParameter("planno", planno).list();
			 String  changeMoldStatus=null;
	         if(list!=null&&list.size()!=0){
	        	 changeMoldStatus=list.get(0).toString();
	         }			
	     	  if(StringHelper.isNullOrEmpty(changeMoldStatus)){
	     		 return false;
	     	  }
	     	  //换工装计划状态是已关闭，且对应的日计划状态是执行中，则可以做换工装计划
	     	  if(changeMoldStatus.equals("170004")){
	     		 String  cxDayPlanStatus =getSession().createSQLQuery(getSQL("getDayPlanStatusByPlanno"))
		         			.setParameter("planno", planno)
		         			.uniqueResult().toString();
		     	  if(cxDayPlanStatus.isEmpty()){
		     		 return false;
		     	  }
		     	  if(cxDayPlanStatus.equals("152003")){
		     		  return false;
		     	  }
	     	  }
			return true;
		}
}
