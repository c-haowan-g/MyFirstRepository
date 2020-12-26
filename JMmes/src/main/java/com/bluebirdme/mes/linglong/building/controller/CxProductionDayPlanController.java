/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.CxProductionDayPlan;
import com.bluebirdme.mes.linglong.building.service.CxProductionDayPlanServiceImpl;

/**
 * 成型日计划表
 * @author 时永良
 * @Date 2019年7月31日10:09:45
 */
@Log(code="CX_RJH",value="成型日计划")
@RestController
@RequestMapping("building/productionPlan/productiondayplan")
public class CxProductionDayPlanController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CxProductionDayPlanServiceImpl cxproductiondayplanSrv;
   
    
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return cxproductiondayplanSrv;
    }
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return cxproductiondayplanSrv;
	}
	
	@Override
	@Log(value = "成型日计划查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(cxproductiondayplanSrv.datagridUDA(filter, page));
	}
    
    @Log(code="CX_RJH_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        return Response.suc(cxproductiondayplanSrv.saveChanges(rockWellEntityDTO));
    }
    
	/**
	 * 根据设备条码和日期获取当前条件下的日计划号
	 * 刘程明
	 * 2019年3月15日
	 * @param equipCode 设备条码例如:9BSA01
	 * @param productDate 时期:例如:20190311
	 * @return
	 */
	@RequestMapping("searchDayplannoByEquipCodeAndPlanDate")
	public String searchDayplannoByEquipCodeAndPlanDate(String equipCode,String productDate) {
		List<String> list = cxproductiondayplanSrv.searchDayplannoByEquipCodeAndPlanDate(equipCode,productDate);
		return toJson(list);
	}
	
	@Log(code = "CX_RJH_AUDIT", value = "成型日计划审核", target = LogType.DB)
	@RequestMapping("audit")
	public Response audit(Long[] ids) throws Exception {
		cxproductiondayplanSrv.audit(ids);
		return Response.suc();
	}

	@Log(code = "CX_RJH_CANCEL_AUDIT", value = "成型日计划取消审核", target = LogType.DB)
	@RequestMapping("cancelAudit")
	public Response cancelAudit(Long[] ids) throws Exception {
		cxproductiondayplanSrv.cancelAudit(ids);
		return Response.suc();
	}
	@Log(value = "复制信息", code = "LH_RJG_COPY", target = LogType.DB)
	@RequestMapping("copy")
	public Response copy(Filter filter,String todate,Page page) throws Exception {
		List<CxProductionDayPlan>copyPlanList= cxproductiondayplanSrv.copy(filter,todate, page);
		List<CxProductionDayPlan> temp1=new ArrayList<>();
		for(int i=0;i<copyPlanList.size();i++){
			temp1.add(copyPlanList.get(i));
		}
		List<CxProductionDayPlan> temp2=new ArrayList<>();
		for(int i=0;i<copyPlanList.size();i++){
			temp2.add(copyPlanList.get(i));
		}
		ArrayList<String> noproductionverlist=new ArrayList<String>();
		ArrayList<String> outdatemateriallist=new ArrayList<String>();
		noproductionverlist=cxproductiondayplanSrv.costNoProductionVerList(temp1);//无生产版本信息的物料编码列表
		outdatemateriallist=cxproductiondayplanSrv.costOutDateMaterialList(temp2);//物料失效的物料编码列表
		Object[] res = new Object[]{copyPlanList,noproductionverlist,outdatemateriallist};
		return Response.suc(res);
	}
	
	/**
	 * 获取物料编码版本
	 * 刘程明
	 * 2019年3月15日
	 * @param materialcode 物料编码
	 * @param productionstep 产品阶段 例:03
	 * @return
	 */
	@RequestMapping("getMaterialVersionByCodeAndStep")
	public String getMaterialVersionByCodeAndStep(String materialcode,String productionstep) throws Exception {
		List<String> list = cxproductiondayplanSrv.getMaterialVersionByCodeAndStep(materialcode,productionstep);
		return toJson(list);
	}
	
	/**
	 * 获取工艺配方索引ID
	 * 刘程明
	 * 2019年3月15日
	 * @param materialcode 物料编码
	 * @param productionstep 产品阶段：03
	 * @param version : 胎胚版本 A/B/C
	 * @return
	 */
	@RequestMapping("getPlmBuildingProcessID")
	public String getPlmBuildingProcessID(String materialcode,String productionstep,String version) {
		List<String> list = cxproductiondayplanSrv.getPlmBuildingProcessID(materialcode,productionstep,version);
		return toJson(list);
	}
	/**
	 * 获取成本收集器
	 * 刘程明
	 * 2019年3月15日
	 * @param materialcode 物料编码
	 * @return
	 */
	@RequestMapping("getCostcollector")
	public String getCostcollector(String materialcode) {
		List<String> list = cxproductiondayplanSrv.getCostcollector(materialcode);
		return toJson(list);
	}
	
	//获取-307基础数据
	@RequestMapping("get307BaseData")
	public String getProductionStepBaseData() {
		List<String> list = cxproductiondayplanSrv.getProductionStepBaseData();
		return toJson(list);
	}
	//获取328基础数据
	@RequestMapping("get328BaseData")
	public String getCustomerBaseData() {
		List<String> list = cxproductiondayplanSrv.getCustomerBaseData();
		return toJson(list);
	}
	
	/**
	 * 根据时间，机台，计划号—>获取前一计划的顺序号
	 * 刘程明
	 * 2019年3月27日
	 * @param planno
	 * @param equipCode
	 * @param productDate
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("getPlanqueueByAfterPlanqueue")
    public Response getPlanqueueByAfterPlanqueue(String currentplanqueue,String equipCode,String productDate) throws Exception {
        return Response.suc(cxproductiondayplanSrv.getPlanqueueByAfterPlanqueue(currentplanqueue,equipCode,productDate));
    }
    
    /**
     * 获取日计划顺序号
     * 刘程明
     * 2019年3月31日
     * @param euipcode
     * @param productdate
     * @return
     */
    @RequestMapping("getPlanqueue")
    public String getPlanqueue(String equipcode,String productdate) {
    	return cxproductiondayplanSrv.getPlanqueue(equipcode,productdate);
	}
    
    /**
	 * 选择物料编码后，根据产品阶段，带出成本收集器
	 * 刘程明
	 * 2019年3月15日
	 * @param materialcode 物料编码
	 * @param productStep 产品阶段 03投产 02 试产 01 试制
	 * @return
	 */

	@RequestMapping("getCostcollectorByMaterialAndStep")
	public String getCostcollectorByMaterialAndStep(String materialcode,String productStep) {
		List<String> list = cxproductiondayplanSrv.getCostcollectorByMaterialAndStep(materialcode,productStep);
		return toJson(list);
	}
    
	    /**
		 * 选择物料编码后，计划生产日期，带出月计划号
		 * 刘程明
		 * 2019年3月15日
		 * @param materialcode 物料编码
		 * @param productDate 计划生产日期
		 * @return
		 */
		@RequestMapping("monthlyPlanToCxProductionDayPlan")
		public String monthlyPlanToCxProductionDayPlan(String materialcode,String productDate) {
			List<Map<String,Object>> list = cxproductiondayplanSrv.monthlyPlanToCxProductionDayPlan(materialcode,productDate);
			return toJson(list);
		}
		
		 /**
		 * 选择物料编码后，计划生产日期，带出订单子项编号
		 * 刘程明
		 * 2019年3月15日
		 * @param materialcode 物料编码
		 * @param productDate 计划生产日期
		 * @return
		 */
		@RequestMapping("orderNumberToCxProductionDayPlan")
		public String orderNumberToCxProductionDayPlan(String materialcode,String productDate) {
			List<String> list = cxproductiondayplanSrv.orderNumberToCxProductionDayPlan(materialcode,productDate);
			return toJson(list);
		}
		
		@RequestMapping("treelistQuery")
		public String treelistQuery(String subitemsap_s,String productionStep) throws Exception {
			List<Map<String, Object>> list=cxproductiondayplanSrv.treelistQuery(subitemsap_s,productionStep);
			return toJson(list);
		}
		
		@RequestMapping("treelistQuery2")
		public String treelistQuery2(@RequestBody List<Map<String, Object>> list_map) throws Exception {
			List<Map<String, Object>> list=cxproductiondayplanSrv.treelistQuery2(list_map);
			return toJson(list);
		}
		
		/**
		 * 根据计划日期（月份）来查询出全部硫化月计划号
		 * 时永良
		 * 2019年3月15日
		 * @param productDate 计划生产日期
		 * @return
		 */
		@RequestMapping("searchPlanNoMonthByMonthPlan")
		public String searchPlanNoMonthByMonthPlan() {
			List<Map<String, Object>> list = cxproductiondayplanSrv.searchPlanNoMonthByMonthPlan();
			return toJson(list);
		}
		
		/**
		 * 根据月计划号查出对应的工单子项（工单表的工单号等于月计划号）
		 * 时永良
		 * 2019年3月15日
		 * @param monthPlanNo 月计划号
		 * @return
		 */
		@RequestMapping("getOrderItenByMonthPlanNo")
		public String getOrderItenByMonthPlanNo(String monthPlanNo) {
			List<Map<String, Object>> list = cxproductiondayplanSrv.getOrderItenByMonthPlanNo(monthPlanNo);
			return toJson(list);
		}
		
		/**
		 * 根据月计划号查出对应的物料编码
		 * 时永良
		 * 2019年3月15日
		 * @param monthPlanNo 月计划号
		 * @return
		 */
		@RequestMapping("getPartNumberByMonthPlanNo")
		public String getPartNumberByMonthPlanNo(String monthPlanNo) {
			List<Map<String, Object>> list = cxproductiondayplanSrv.getPartNumberByMonthPlanNo(monthPlanNo);
			return toJson(list);
		}
		
		
		/**
		 * 主页面使用(根据胎胚物料编码带出唯一产品阶段、成本收集器、胎胚版本号，若有多个不带出)
		 * 时永良
		 * 2019年3月15日
		 * @param monthPlanNo 月计划号
		 * @return
		 */
		@RequestMapping("getProductionStepByMaterialcode")
		public String getProductionStepByMaterialcode(String materialcode) {
			List<Map<String, Object>> list = cxproductiondayplanSrv.getProductionStepByMaterialcode(materialcode);
			return toJson(list);
		}

		/**
		 * 主页面使用(根据胎胚物料编码分别查询BOM和成本收集器，若无BOM则提示联系技术人员，若无成本收集器则提示联系财务人员)
		 * 时永良
		 * 2019年3月15日
		 * @param monthPlanNo 月计划号
		 * @return
		 */
		@RequestMapping("getBOMorProductionverByMaterialcode")
		public String getBOMorProductionverByMaterialcode(String materialcode) {
			String message = cxproductiondayplanSrv.getBOMorProductionverByMaterialcode(materialcode);
			return toJson(message);
		}
}
