package com.bluebirdme.mes.linglong.building.service;

import java.lang.Exception;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.client.PartClass;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
/**
 * 验证成型数据有效性类
 * @author 刘程明
 *
 */
@SuppressWarnings("rawtypes")
@Service
@Transactional(rollbackFor=Exception.class)
public class BuildingValidDataToolsServiceImpl extends  RockWellBaseServiceImpl {
		@Resource
		LingLongDataSource llds;
	  
	    @Override
	    protected Session getSession() {
	        return llds.getSession();
	    }
	
	    @Override
		protected Class getEntity() {
			// TODO Auto-generated method stub
	    	 return null;
		}
	
	    @Override
	    protected boolean useCache() {
	        return false;
	    }
	 
	  
	  
	  
	
     /**
      * 校验BOM是否有效,同时校验BOM是否过期
      * 刘程明
      * 2019年3月14日
      * @param materialCode 物料编码
      * @param materialVer 物料版本
      * @param productionStep 产品阶段
      * @return true是有效，false是无效
      */
     
     public Boolean validBomExit(String materialCode,String materialVer,String productionStep)throws Exception{
    	 if(materialCode.isEmpty()||materialVer.isEmpty()||productionStep.isEmpty()){
    		throw new Exception("validBomExit方法有参数为空");
    	 }
    	 int count = ((BigDecimal) getSession().createSQLQuery(getSQL("searchPLMBOM"))
    			 .setParameter("materialcode", materialCode)
    			  .setParameter("materialver", materialVer)
    			   .setParameter("productionstep", productionStep)
    			 .uniqueResult()).intValue();
    	 if(count<=0){
    		return false;
    	 }
    	 return true;
     }
     
 	/**
 	 * 校验MES的生产版本是否存在于SAP生产版本中
 	 * 刘程明
 	 * 2019年3月14日
 	 * @param materialCode
 	 * @param productionver
 	 * @return true是存在，false是不存在
 	 * @throws Exception 
 	 */
    @SuppressWarnings("unchecked")
	public Boolean validProductionVerFromBomAndSAP(String materialCode,String productionver) throws Exception{
     	 if(materialCode.isEmpty()||productionver.isEmpty()){
      		throw new Exception("validProductionVerFromBomAndSAP方法有参数为空");
      	 }
     	 try{
     		//---------验证SAP生产版本-----------//
         	 String  sapProductionVer =getSession().createSQLQuery(getSQL("searchSAPProductionVer"))
         			.setParameter("materialcode", materialCode)
         			.setParameter("productionver", productionver).uniqueResult().toString();
         	  if(sapProductionVer.isEmpty()){
         		 return false;
         	  }
         	  //-----------验证PLM中的生产版本-------------//
    		List<Map<String, Object>> plmproverlist= getSession().createSQLQuery(getSQL("searchPLMProductionVer"))
    			.setParameter("materialcode", materialCode)
    			.setParameter("productionver", productionver).list();
         	  if(plmproverlist.size()==0){
         	    return false;
         	  }
     	 }catch(Exception e){
     		 return false;
     	 }
     	 
     	  return true;
      }
     
     /**
      * 校验物料是否过期失效
      * 刘程明
      * 2019年3月14日
      * @param materialCode
      * @return true是未失效；false是已经失效
      * @throws Exception
      */
     public Boolean validMaterialOutDate(String materialCode)throws Exception{
    	 if(materialCode.isEmpty()){
    		throw new Exception("validMaterialOutDate方法的物料编码为空");
    	 }
    	 int count = ((BigDecimal) getSession().createSQLQuery(getSQL("validMaterialOutdate"))
    			 .setParameter("materialcode", materialCode)
    			 .uniqueResult()).intValue();
    	 if(count>0){
    		 return false;
    	 }
    	 return true;
     }
     /**
      * 校验用户下的特殊需求
      * 刘程明
      * 2019年3月15日
      * @param equipCode 设备条码
      * @param customerMark 用户标识
      * @return
      * @throws Exception
      */
     public Boolean validCustomerDemand(String equipCode,String customerMark) throws Exception {
    	if(customerMark.isEmpty()){
    		throw new Exception("validCustomerDemand方法的用户信息为空");
    	}
    	//无客户标识的不进行校验
    	if(customerMark.equals("328001")){
    		return true;
    	}
    	 int count = ((BigDecimal) getSession().createSQLQuery(getSQL("validCustomerDemand"))
    			 .setParameter("equipcode", equipCode)
    			 .setParameter("customermark", customerMark)
    			 .uniqueResult()).intValue();
    	if(count<=0){
    		return false;
    	}
		return true;
	}

    /**
     * 检验扩展表的物料是否维护物料时效性-判断PART_CLASS中是否有有效时间
     * 刘程明-whl
     * 2019年3月18日-2020/04/27
     * @param materialCode
     * @return
     */
    @SuppressWarnings("unchecked")
    @RockWellTransactional
	public Boolean validMaterialPlusDate(String materialCode) {
    	IFunctionsEx functions = PCContext.getFunctions();
    	//获取part_class的有效时间
    	Part part = functions.getPart(materialCode);
    	//获取物料大类
    	Vector partClass = functions.getFilteredPartClasses(functions.createPartClassFilter().forPartEqualTo(part.getPartKey()));
    	//判断物料大类的有效期是否设置
    	if(partClass == null || partClass.size() == 0 ){
    		return false;
    	}
    	PartClass object = (PartClass)partClass.get(0);
    	//如果物料大类中未维护
    	if(object.getUDA(0) == null || object.getUDA(1) == null){
    		//判断是否维护单物料有效时间
    		List<Map<String, Object>> materialDateList= createSQLQuery(getSQL("searchMaterialPlusDateList"))
        			.setParameter("materialcode", materialCode).list();
        	if(materialDateList==null||materialDateList.size()==0){
        		return false;
        	}else if(materialDateList.get(0).get("SMALLTIME")==null||materialDateList.get(0).get("SMALLTIME").toString()==""){
        		return false;
        	}else if(materialDateList.get(0).get("OVERTIME")==null||materialDateList.get(0).get("OVERTIME").toString()==""){
        		return false;
        	}
    	}
    	
    	return true;
	}
 /**
  * 验证成型工艺参数是否存在
  * 刘程明
  * 2019年3月30日
  * @param materialCode 物料编码
  * @param version 版本
  * @param productionVer 生产版本
  * @return
  */
    @RockWellTransactional
   	public Boolean validCurringBuildingProcessIsExit(String materialCode,String materialVer,String productionVer) {
    	String ageno=LLConstant.JING_MEN_CODE;
    	int count = ((BigDecimal) getSession().createSQLQuery(getSQL("validCurringBuildingProcessIsExit"))
    			 .setParameter("werks_s", ageno)
    			 .setParameter("version_s", materialVer)
    			 .setParameter("materialCode", materialCode)
    			 .setParameter("productionVer", productionVer)
    			 .uniqueResult()).intValue();
    	if(count<=0){
    		return false;
    	}
		return true;
    }
    /**
     * （1）验证成型日计划胎胚编码在硫化月计划存在（2）验证成型日计划日期处于 硫化月计划开始日期-1天和结束日期之间
     * @param materialCode 胎胚物料编码
     * @param productDate 生产日期
     * @return
     */
    public Boolean validCurringMonthPlanMaterialCodeAndProductDate(String materialCode,String productDate){
    	String month_i=productDate.substring(0, 6);//月份，例201904
    	int monthPlanCount = ((BigDecimal) getSession().createSQLQuery(getSQL("validCurringMonthPlanMaterialCodeAndProductDate"))
    		  .setParameter("s_factory_s", LLWebUtils.factory())
   			 .setParameter("month_i", month_i)
   			 .setParameter("subitemsap_s", materialCode)
   			 .setParameter("productDate", productDate)
   			 .uniqueResult()).intValue();
    	if(monthPlanCount<=0){
    		return false;
    	}
		return true;
    }
    /**
     * 从硫化月计划中查出月计划号，将之存入成型日计划表中
     * 时永良
     * 2019年8月1日08:01:26
     * @param cxPlan
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> monthlyPlanToCxProductionDayPlan(String materialCode,String productDate){
    	String month_i=productDate.substring(0, 6);//月份，例201904
    	@SuppressWarnings("unchecked")
		List<Map<String,Object>> monthPlan = getSession().createSQLQuery(getSQL("monthlyPlanToCxProductionDayPlan"))
    		 .setParameter("s_factory_s", LLWebUtils.factory())
   			 .setParameter("month_i", month_i)
   			 .setParameter("subitemsap_s", materialCode)
   			 .setParameter("productDate", productDate).list();
    	if(monthPlan!=null){
    		return monthPlan;
    	}
		return null;
    }
    /**
     * 从工单子项中（work_order_items）查出订单子项编号（order_item），将之存入成型日计划表中
     * 时永良
     * 2019年8月1日08:01:26
     * @param cxPlan
     * @return
     * @throws Exception
     */
    public String orderNumberToCxProductionDayPlan(String materialCode,String productDate){
    	String orderNumber = ((String) getSession().createSQLQuery(getSQL("orderNumberToCxProductionDayPlan"))
   			 .setParameter("subitemsap_s", materialCode)
   			 .setParameter("productDate", productDate)
   			 .uniqueResult());
    	if(orderNumber!=null){
    		return orderNumber;
    	}
		return null;
    }
    
	
}
