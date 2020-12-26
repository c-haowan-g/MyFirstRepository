/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanDTO;
import com.bluebirdme.mes.linglong.halfpart.service.ProductPlanAutoMakingServiceImpl;

/**
 * 半部件日计划倒退功能
 * 
 * @author 刘朋
 * @Date 2020-03-11 08:49:13
 */
@Log(code = "PUSHPRODUCTPLAN_LOG", value = "半部件日计划倒退")
@RestController
@RequestMapping("halfpart/productionplan/automaking")
public class ProductPlanAutoMakingController extends RockWellFunctionalController<ProductPlan> {

	@Resource
	ProductPlanAutoMakingServiceImpl automakingplanSrv;

	@Override
	protected RockWellBaseServiceImpl<ProductPlan> getService() {
		return automakingplanSrv;
	}

	@RequestMapping("planAutoMaking")
	public String planAutoMaking(String halfPartDate, String buildingDate, String model) throws Exception {
		if (model.equals("date")) {
			return toJson(automakingplanSrv.planAutoMakingAccordingToDate(buildingDate, halfPartDate));
		} else if (model.equals("class")) {
			return toJson(automakingplanSrv.planAutoMakingAccordingToClass(buildingDate, halfPartDate));
		} else {
			return toJson("请确定倒推模式");
		}
	}

	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody ProductPlanDTO productplan) throws Exception {
		automakingplanSrv.saveChanges(productplan);
		return Response.suc();
	}
}
