/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberGradeDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.JudgeNumberGradeServiceImpl;

/**
 * 动平衡均匀机检测配套标准等级表
 * @author 刘程明
 * @Date 2018-11-13 14:44:43
 */
@Log(code="AT_D_BS_JUDGENUMBERGRADE_LOG",value="动平衡均匀机检测配套标准等级表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/JudgeNumberGrade")
public class JudgeNumberGradeController extends RockWellFunctionalController<JudgeNumberGrade> {
    
    @Resource JudgeNumberGradeServiceImpl judgenumbergradeSrv;

    @Override
    protected RockWellBaseServiceImpl<JudgeNumberGrade> getService() {
        return judgenumbergradeSrv;
    }
    
    
    @Log(code="AT_D_BS_JUDGENUMBERGRADE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody JudgeNumberGradeDTO judgenumbergrade ) throws Exception {
        
        if (judgenumbergradeSrv.saveChanges(judgenumbergrade) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "OK",judgenumbergrade);
		}
		return Response.suc();
        
    }
    @Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid1")
   	public String datagrid(Filter filter,Page page,String judgeno_s,String enttype_s) throws Exception {
   		page.setRows(1000);
   		filter.set("judgeno_s", judgeno_s);
   		filter.set("enttype_s", enttype_s);
   		return GsonTools.toJson(getService().datagrid(filter,page,JudgeNumberGrade.class));
   	}
    @Log(code="comboxMachineGrade",value="从基础数据表查询机台下发等级")
    @RequestMapping("comboxMachineGrade")
   	public String comboxMachineGrade() throws Exception{
    	List<Map<String,Object>> list=judgenumbergradeSrv.getMachineGradeCombox();
   		return toJson(list);
   	}
   	@Log(code="comboxDynamicGrade",value="从工序等级表拉取动平衡等级")
    @RequestMapping("comboxDynamicGrade")
   	public String comboxDynamicGrade() throws Exception{
    	List<Map<String,Object>> list=judgenumbergradeSrv.comboxDynamicGrade();
   		return toJson(list);
   	}
   	
	@Log(code="comboxUniformGrade",value="从工序等级表拉取均匀性等级")
    @RequestMapping("comboxUniformGrade")
   	public String comboxUniformGrade() throws Exception{
    	List<Map<String,Object>> list=judgenumbergradeSrv.comboxUniformGrade();
   		return toJson(list);
   	}
}
