/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.io.IOException;
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
import com.bluebirdme.mes.linglong.building.entity.Mouldstock;
import com.bluebirdme.mes.linglong.building.service.MouldstockServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

import freemarker.template.TemplateException;

/**
 * 机头库存表
 * @author lnk
 * @Date 2019-01-11 17:24:50
 */
@Log(code="机头库存表",value="机头库存表")
@RestController
@RequestMapping("cx/zlgl/mouldstock")
public class MouldstockController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MouldstockServiceImpl mouldstockSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mouldstockSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mouldstockSrv;
	}
    @Override
    @Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, RockWellEntityDTO.class));
	}
    
    @RequestMapping("datagridUDA")
   	public String datagridUDA(Filter filter, Page page) throws Exception {
   		return GsonTools.toJson(mouldstockSrv.datagridUDA(filter, page));
   	}
    
    @Log(code="机头库存表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO mouldstock ) throws Exception {
    	int demo = mouldstockSrv.saveChanges(mouldstock);
    	if(demo == -1 ){
    		return Response.error("CF", "CF", "CF");
    	}else if(demo == -2){
    		return Response.error("WG", "WG", "WG");
    	};
    	return Response.suc("OK");
    }
    
    /**
	 * 库存位置的查询
	 * 
	 * @return
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	@RequestMapping("searchbylocation")
	public String searchByModal() throws TemplateException, IOException {
		List<Map<String, Object>> list = mouldstockSrv.searchByLocation();
		return toJson(list);
	}
}
