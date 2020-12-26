/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;

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
import com.bluebirdme.mes.linglong.building.service.ChangeMouldServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.ChangeMould;

/**
 * 换工装计划表
 * @author 王海霖
 * @Date 2019-03-12 13:58:56
 */
@Log(code="AT_B_PP_CHANGEMOULD_LOG",value="换工装计划表操作日志")
@RestController
@RequestMapping("building/productionplan/changemould")
public class ChangeMouldController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ChangeMouldServiceImpl changemouldSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return changemouldSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return changemouldSrv;
	}

    
    @Override
	@Log(value = "换工装计划查询", code = "changemouldplandatagrid", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    @Log(code="AT_B_PP_CHANGEMOULD_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        return Response.suc(changemouldSrv.saveChanges(rockWellEntityDTO));
    }
    
  /*    
   *  计划审核 
   *  兰颖慧-2019/03/13
   *  
   */
    
	@Log(code = "CX_CHANGEMOULD_SHENHE", value = "换工装计划审核", target = LogType.DB)
	@RequestMapping("audit")
	public Response audit(Long[] ids) throws Exception {
    	changemouldSrv.audit(ids);
		return Response.suc();
	}
	  /*    
	   *  计划取消审核 
	   *  兰颖慧-2019/03/13
	   *  
	   */
	@Log(code = "CX_CHANGEMOULD_CANCEL_SHENHE", value = "换工装计划取消审核", target = LogType.DB)
	@RequestMapping("cancelAudit")
	public Response cancelAudit(Long[] ids) throws Exception {
		changemouldSrv.cancelAudit(ids);
		return Response.suc();
	}
	  /*    
	   *  计划关闭 
	   *  兰颖慧-2019/03/13
	   *  
	   */
	@Log(code = "CX_CHANGEMOULD_CLOSE", value = "换工装计划关闭", target = LogType.DB)
	@RequestMapping("close")
	public Response close(Long[] ids) throws Exception {
		changemouldSrv.close(ids);
		return Response.suc();
	}
	
    /**   
     * 从成型日计划表获取根据查询栏确定的换工装时间以及机台编码获取成型日计划号
     * 兰颖慧-2019/03/13
     *
     */
	@RequestMapping("getMoldDailyPlanCode")
	public String getMoldDailyPlanCode(String equipCode,String changeMouldDate){
		List<String> list = changemouldSrv.getMoldDailyPlanCode(equipCode,changeMouldDate);
		return toJson(list);
	}
    /**   
     * 查询栏获取成型日计划号
     * 兰颖慧-2019/03/13
     *
     */
	@RequestMapping("searchMoldDailyPlanCode")
	public String searchMoldDailyPlanCode() throws Exception {
		List<String> list = changemouldSrv.searchMoldDailyPlanCode();
		return toJson(list);
	}
	

    /**
     * 根据成型日计划号从成型日计划表中获取物料编码
     * 兰颖慧2019/03/21
     */
	@RequestMapping("searchMaterialInfoByPlanNo")
	public String searchMaterialInfoByPlanNo(String planno) throws Exception {
		List<String> list = changemouldSrv.searchMaterialInfoByPlanNo(planno);
		return toJson(list);
	}
	
	/**
	 * 判断某一日计划是否已经做了换工装计划
	 * @param planno 日计划号
	 * @return
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年4月16日
	 */
	@RequestMapping("isCxDayPlanExitInChangePlan")
	public boolean isCxDayPlanExitInChangePlan(String planno) throws Exception {
		 boolean result=changemouldSrv.isCxDayPlanExitInChangePlan(planno);
		return result;
	}

	
}
