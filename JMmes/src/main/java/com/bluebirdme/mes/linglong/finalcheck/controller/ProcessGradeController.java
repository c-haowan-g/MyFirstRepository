/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.HashMap;
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
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGradeATO;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ProcessGradeDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.ProcessGradeServiceImpl;

/**
 * 质检工序等级表
 * @author 刘程明
 * @Date 2018-08-16 12:26:07
 */
@Log(code="ZJ_BZGL_ZJGX",value="质检工序等级表")
@RestController
@RequestMapping("finalchenk/standardManagement/processgrade")
public class ProcessGradeController extends RockWellFunctionalController<ProcessGrade> {
    
    @Resource ProcessGradeServiceImpl processgradeSrv;

    @Override
    protected RockWellBaseServiceImpl<ProcessGrade> getService() {
        return processgradeSrv;
    }
    
    
    @Log(code="ZJ_BZGL_ZJGX_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ProcessGradeDTO processgrade ) throws Exception{
        processgradeSrv.saveChanges(processgrade);
        return Response.suc();
    }
    
	@Log(value = "质检工序等级表信息列表查询2", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid2")
	public String datagrid2(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(processgradeSrv.datagrid2(filter, page, ProcessGrade.class));
	}
	
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(processgradeSrv.datagrid(filter, page, ProcessGradeATO.class));
	}
	
	@Log(value = "基础数据工序列表", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("gongxu")
	public String gongxu(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(processgradeSrv.gongxu(filter, page, CoreDictionary.class));
	}
	
	@Log(value = "基础数据等级列表", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("dengji")
	public String dengji(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(processgradeSrv.dengji(filter, page, CoreDictionary.class));
	}
	
	 
    @Log(value = "根据工序获取工序等级维护表里面的数据", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("gradessel")
   	public String gradessel(String ids) {
    	Map<String, Object> filterMap = new HashMap<String, Object>();
    	filterMap.put("proess_i", ids);
    	filterMap.put("s_factory_s", LLWebUtils.factory());
    	filterMap.put("record_flag_s", "A");
   		List<ProcessGrade> list = processgradeSrv.findByMap(filterMap);
   		return toJson(list);
   	}
    
	@RequestMapping("coresel")
	public String coresel(){
		List<Map<String,Object>> list = processgradeSrv.coresel();
		return toJson(list);
	}
	
	
	
	@Log(value = "根据工序删除", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("delgxdj")
   	public int delgxdj(String gxid) {
   		int i = processgradeSrv.delgxdj(gxid);
   		return i;
   	}
}
