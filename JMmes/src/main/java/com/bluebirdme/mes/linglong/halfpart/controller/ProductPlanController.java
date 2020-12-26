/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanExtend;
import com.bluebirdme.mes.linglong.halfpart.proxy.A_Pm_ProductPlanProxy;
import com.bluebirdme.mes.linglong.halfpart.service.*;
import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanExtendDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.sos.A_Pm_ProductPlanWeb;
import com.bluebirdme.mes.linglong.halfpart.entity.sos.SosUrlAddress;

/**
 * 半部件日计划
 * @author 时永良
 * @Date 2019-04-04 14:49:13
 */
@Log(code="AT_A_PM_PRODUCTPLAN_LOG",value="半部件日计划主表")
@RestController
@RequestMapping("halfpart/productionplan/dailyplan")
public class ProductPlanController extends RockWellFunctionalController<ProductPlan> {
    
    @Resource ProductPlanServiceImpl productplanSrv;

    @Override
    protected RockWellBaseServiceImpl<ProductPlan> getService() {
        return productplanSrv;
    }
    
    @Log(code="AT_A_PM_PRODUCTPLAN_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ProductPlanExtendDTO productplan ) throws Exception {
    	String res = productplanSrv.saveChanges(productplan);
        if(!"操作成功".equals(res)){
        	return Response.error("0",res,null);
		}
        return   Response.suc();
    }
  /**
    * select equip_code_s  from table AT_A_PM_ProductPlan
    * (半部件日计划表中筛选机台号 )
    * 2019/04/15
    * Yinghui.Lan
    */
    @RequestMapping("searchEquipmentCode")
    public String searchEquipmentCode(){
    	List<String> equipmentCodeList=productplanSrv.searchEquipmentCode();
    	return toJson(equipmentCodeList);
    }
   /**
    * 
    * @param data
    * @return
    * @throws Exception
    * @author 黄文娟
    * @Date 2019年4月17日 上午11:31:31
    */
    @RequestMapping("saveProductPlan")
   	public A_Pm_ProductPlanWeb saveProductPlan(A_Pm_ProductPlanWeb data) throws Exception {
    	ApplicationContext context=new ClassPathXmlApplicationContext("SOSUrl.xml");
		SosUrlAddress sosUrlAddress=(SosUrlAddress)context.getBean("sosServiceUrl"); 
		String urlPath=sosUrlAddress.getSosUrlPath();
   		A_Pm_ProductPlanProxy a_Pm_ProductPlanProxy = new A_Pm_ProductPlanProxy(urlPath, "com.linglong.halfpart.halfsteel.webservice.A_Pm_ProductPlanWebService");
   	    A_Pm_ProductPlanWeb result = a_Pm_ProductPlanProxy.Save(data);
   		 
   		return result;
   	}
      
    /**
     * getDataByMaterialName
     * 根据物料名称获取物料编码
     * 2019/04/24
     * Yinghui.Lan
     */
    @RequestMapping("getDataByMaterialName")
    public String getDataByMaterialName(String materialName){
    	List<String> getDataByMaterialNameList=productplanSrv.getDataByMaterialName(materialName);
    	return toJson(getDataByMaterialNameList);
    }
    /**
     * getDataByMaterialName
     * 根据物料编码获取物料名称
     * 2019/04/24
     * Yinghui.Lan
     */
    @RequestMapping("getDataByMaterialCode")
    public String getDataByMaterialCode(String materialCode){
    	List<String> getDataByMaterialCodeList=productplanSrv.getDataByMaterialCode(materialCode);
    	return toJson(getDataByMaterialCodeList);
    }
    /**
     * checkByMaterialCode
     * 根据物料编码进行相关校验后获取物料名称、工艺版本号、配方版本、 生产版本（SAP下发版本号）
     * 2019/04/24
     * Yinghui.Lan
     */
    @RequestMapping("getCheckedDataByMaterialCode")
    public String getCheckedDataByMaterialCode(String materialCode,String productStage)throws Exception{
    	List<String> getCheckedDataByMaterialCode=productplanSrv.getCheckedDataByMaterialCode(materialCode,productStage);
    	return toJson(getCheckedDataByMaterialCode);
    }
	/**
	 * 注意：前期上线工艺版本等还不完善
	 * getDataByMaterialCode
	 * 跟物料编码校验生产版本、BOM物料存在性及是否BOM有效期
	 * Yinghui.Lan
	 * @throws Exception 
	 */
    @RequestMapping("getProductVersion")
    public String getProductVersion(String materialCode)throws Exception{
    	List<String> getProductVersion=productplanSrv.getProductVersion(materialCode);
    	String aaa = toJson(getProductVersion);
    	return toJson(getProductVersion);
    }
	/**
	 * 根据物料编码校验生产版本是否存在 
	 * 跟物料编码进行相关校验
	 * Yinghui.Lan
	 * @throws Exception 
	 */
    @RequestMapping("checkBomAndVersion")
    public String checkBomAndVersion(String materialCode,String productStage,String productVersion)throws Exception{
    	String checkBomAndVersion=productplanSrv.checkBomAndVersion(materialCode,productStage,productVersion);
    	return toJson(checkBomAndVersion);
    }
	/**
	 * 根据物料编码校验BOM存在性和有效期 、以及工艺版本和配方版本是否存在
	 * 跟物料编码进行相关校验
	 * Yinghui.Lan
	 * @throws Exception 
	 */
    @RequestMapping("checkDataByMaterialCode")
    public String checkDataByMaterialCode(String materialCode,String productStage)throws Exception{
    	String checkDataByMaterialCode=productplanSrv.checkDataByMaterialCode(materialCode,productStage);
    	return toJson(checkDataByMaterialCode);
    }
    /**
     * Creates daily-plan code based on the production data that selected in the query bar
     * 根据查询栏选定的生产日期生成日计划号
     * 2019/04/15
     * Yinghui.Lan
     * @throws Exception 
     */
    
     @RequestMapping("createPlanCode")
     public String createPlanCode(String planData){
     	List<String> createPlanCodeList=productplanSrv.createPlanCode(planData);
     	return toJson(createPlanCodeList);
     } 
     /**
      * Creates daily-plan code based on the production data that selected in the query bar
      * 根据查询栏选定的生产日期生成日计划号
      * 2019/04/15
      * Yinghui.Lan
      * @throws Exception 
      */
     
      @RequestMapping("createPlanNoWhenCopy")
      public String createPlanNoWhenCopy(String planData,int num){
      	List<String> createPlanList=productplanSrv.createPlanNoWhenCopy(planData,num);
      	return toJson(createPlanList);
      } 
     /**
      * 
      * 根据查询栏选定的生产日期获取最大顺序号
      * 2019/04/15
      * Yinghui.Lan
      * @throws Exception 
      */
     @RequestMapping("getMaxPlanOrder")
     public String getMaxPlanOrder(String planData) throws Exception{
      	List<String> getMaxPlanOrder=productplanSrv.getMaxPlanOrder(planData);
      	return toJson(getMaxPlanOrder);
      }
     
    /**
     * 根据物料组获得超产百分比
     * 兰颖慧
     * get Over-Percent By Material-Group
     * Yinghui.Lan
     * 2019/04/24
     * 
     */
     @RequestMapping("getOverPercentByMaterialGroup")
     public String getOverPercentByMaterialGroup(String materialGroup){
     	List<String> overPercentList=productplanSrv.getOverPercentByMaterialGroup(materialGroup);
     	return toJson(overPercentList);
     }
   /**
    * 根据日期，机台号和班次获取数据
	* 兰颖慧
	* 2019-05-21
	*/
	@RequestMapping("getSortingData")
	public String getSortingData(Page page,String planDate, String equipCode, String classCode) throws Exception{
		Map<String, Object> getSortingData=productplanSrv.getSortingData(page,planDate,equipCode,classCode);
	  	return toJson(getSortingData);
	}
   /**    
    *  半部件日计划审核
    *  兰颖慧-2019/04/25
    *  
    */
 	@RequestMapping("audit")
 	public Response audit(Long[] ids) throws Exception {
 		productplanSrv.audit(ids);
 		return Response.suc();
 	}
 	
   /**    
    *  半部件日计划一键复制
    *  兰颖慧-2019/04/25
    *  
    */
 	@RequestMapping("oneClickCopy")
 	public Response oneClickCopy(String fromPlanDate,String toPlanDate) throws Exception {
 		productplanSrv.oneClickCopy(fromPlanDate,toPlanDate);
 		return Response.suc();
 	}
    /**    
     *  半部件日计划一键审核
     *  兰颖慧-2019/04/25
     *  
     */
  	@RequestMapping("oneClickAudit")
  	public Response oneClickAudit(String planDate) throws Exception {
  		productplanSrv.oneClickAudit(planDate);
  		return Response.suc();
  	}
    /**    
     *  半部件日计划一键撤销审核
     *  兰颖慧-2019/04/25
     *  
     */
  	@RequestMapping("oneClickCancelAudit")
  	public Response oneClickCancelAudit(String planDate) throws Exception {
  		productplanSrv.oneClickCancelAudit(planDate);
  		return Response.suc();
  	}
   /**  
    *  半部件日计划计划取消审核 
    *  兰颖慧-2019/04/25
    *  
    */
 	@RequestMapping("auditCancel")
 	public Response cancelAudit(Long[] ids) throws Exception {
 		productplanSrv.cancelAudit(ids);
 		return Response.suc();
 	}
  /**    
   *  半部件日计划关闭
   *  兰颖慧-2019/08/21
   *  
   */
 	@RequestMapping("planClose")
 	public Response planClose(Long[] ids) throws Exception {
 		productplanSrv.planClose(ids);
 		return Response.suc();
 	}
	/**
	 * 获取同一机台下的全部物料组
	 * 兰颖慧
	 * 2019-05-30
	 */
 	@RequestMapping("getAllMaterialGroupUnderZone")
	 public String getAllMaterialGroupUnderZone(String zoneName) throws Exception{
   	 List<Map<String, Object>> result=productplanSrv.getAllMaterialGroupUnderZone(zoneName);
     	 return toJson(result);
    }
	/**
	 * 获取同一机台下的全部物料组
	 * 兰颖慧
	 * 2019-05-30
	 */
 	@RequestMapping("getAllMaterialGroupWithoutZone")
	 public String getAllMaterialGroupWithoutZone() throws Exception{
   	 List<Map<String, Object>> result=productplanSrv.getAllMaterialGroupWithoutZone();
     	 return toJson(result);
    }
	/**
     * 复制后页面重新加载复制后的数据
     * 2019-06-10
     * 兰颖慧
	 */
 	@RequestMapping("reLoadCopyPlan")
	 public String reLoadCopyPlan(String newDate) throws Exception{
   	 List<Map<String, Object>> result=productplanSrv.reLoadCopyPlan(newDate);
     	 return toJson(result);
    }
	/**
	 * 根据物料编码获取物料描述、物料规格以及对应物料组编码
	 * 兰颖慧
	 * 2019年7月8日
	 * @return
	 */
	@RequestMapping("getMatInfoByMatCode")
	public String getMatInfoByMatCode(String materialCode)throws Exception{
		List<Map<String, Object>> getMatInfoByMatCode = productplanSrv.getMatInfoByMatCode(materialCode);
		return toJson(getMatInfoByMatCode);
	}
	/**
	 * 根据物料描述获取物料编码、物料规格以及对应物料组编码
	 * 兰颖慧
	 * 2019年7月8日
	 * @return
	 */
	@RequestMapping("getMatInfoByMatDesc")
	public String getMatInfoByMatDesc(String materialDesc)throws Exception{
		List<Map<String, Object>> getMatInfoByMatDesc = productplanSrv.getMatInfoByMatDesc(materialDesc);
		return toJson(getMatInfoByMatDesc);
	}
	/**
	 * 根据物料规格获取物料编码、物料描述以及对应物料组编码
	 * 兰颖慧
	 * 2019年7月8日
	 * @return
	 */
	@RequestMapping("getMatInfoByMatSpec")
	public String getMatInfoByMatSpec(String materialSpec)throws Exception{
		List<Map<String, Object>> getMatInfoByMatSpec = productplanSrv.getMatInfoByMatSpec(materialSpec);
		return toJson(getMatInfoByMatSpec);
	}
	/**
	 * 获取计划信息
	 * 兰颖慧
	 * 2019年8月30日
	 * @return
	 */
	@RequestMapping("getPlanInfoList")
	public String getPlanInfoList(Filter filter,Page page,Class clazz)throws Exception{
		Map<String, Object> getPlanInfoList = productplanSrv.getPlanInfoList(filter,page,ProductPlanExtend.class);
		return toJson(getPlanInfoList);
	}
}
