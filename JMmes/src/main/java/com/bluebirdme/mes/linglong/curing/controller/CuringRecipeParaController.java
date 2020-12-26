/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringRecipePara;
import com.bluebirdme.mes.linglong.curing.entity.dto.CuringRecipeParaDTO;
import com.bluebirdme.mes.linglong.curing.service.CuringRecipeParaServiceImpl;

/**
 * PLM配方下发基础参数表
 * 
 * @author 刘朋
 * 修改人   :徐秉正
 * @Date 2018-09-27 10:55:48
 */
@Log(code = "AT_INT_PLM_CURINGRECIPEPARA", value = "PLM配方下发基础参数")
@RestController
@RequestMapping("curing/baseData/curingRecipePara")
public class CuringRecipeParaController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CuringRecipeParaServiceImpl curingrecipeparaSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return curingrecipeparaSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingrecipeparaSrv;
	}
	
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(curingrecipeparaSrv.datagridUDA(filter, page));
	}
	
	@Log(code = "AT_INT_PLM_CURINGRECIPEPARA_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(
			@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (curingrecipeparaSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复",
					rockWellEntityDTO);
		}
		return Response.suc();
	}

}
