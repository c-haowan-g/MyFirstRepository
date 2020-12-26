/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.PlmCuringProcessParameterServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;

/**
 * PLM硫化工艺参数
 * @author 司乔靖
 * @Date 2019-07-16 10:13:23
 */
@Log(code="PLM硫化工艺参数",value="PLM硫化工艺参数")
@RestController
@RequestMapping("curing/baseData/plmCuringProcessParameter")
public class PlmCuringProcessParameterController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmCuringProcessParameterServiceImpl plmcuringprocessparameterSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmcuringprocessparameterSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return plmcuringprocessparameterSrv;
	}
    
	@Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@RequestMapping("datagridUDA2")
	public String datagridUDA2(Filter filter, Page page) throws Exception {
		Map<String,Object> map = plmcuringprocessparameterSrv.datagridUDA(filter, page);
		return GsonTools.toJson(map);
	}
	
	@Log(value = "工艺参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@RequestMapping("datagridUDA3")
	public String datagridUDA3(String route_name) {
		List<Map<String, Object>> list = plmcuringprocessparameterSrv.searchParameter(route_name);
		return toJson(list);
	}
	
    @Log(code="PLM硫化工艺参数_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody UdaDto udaDto ) throws Exception {
        plmcuringprocessparameterSrv.saveChanges(udaDto);
        return Response.suc();
    }
    
    

}
