/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.TestParameter;
import com.bluebirdme.mes.linglong.curing.service.TestParameterServiceImpl;

/**
 * 页面名称:试验胎参数修改页面
 * 
 * @author whl
 * @Date 2018-09-18 18:37:22
 */
@Log(code = "TestParameter", value = "试验胎参数修改")
@RestController
@RequestMapping("curing/ProductionManagement/testParameter/")
public class TestParameterController extends RockWellFunctionalUDAController<Object> {
	// 参数表
	@Resource
	TestParameterServiceImpl testParameterServiceImpl;

	
	/**
	 * 修改方法
	 * 
	 * @Title: saveChanges
	 * @Description: TODO(描述)
	 * @return: Response 返回类型
	 * 
	 */
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		testParameterServiceImpl.save2(rockWellEntityDTO);
		return Response.suc();
	}

	/**
	 * 通过日计划状态（已执行），查询生产状态机台
	 * 
	 * @Title: getDataByStatus
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getDataByStatus")
	public String getDataByStatus() throws Exception {
		List<Map<String, Object>> list = testParameterServiceImpl.getDataByStatus();
		return toJson(list);
	}

	/**
	 * 
	 * 根据机台查询计划号
	 * 
	 * @Title: getPlanByEquip
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getPlanByEquip")
	public String getPlanByEquip(String equip_code) throws Exception {
		List<Map<String, Object>> data = testParameterServiceImpl.getPlanByEquip(equip_code);
		return toJson(data);
	}

	/**
	 * 启用/停用
	 * 
	 * @Title: flagChanges
	 * @Description: TODO(描述)
	 * @return: Response 返回类型
	 * 
	 */
	@RequestMapping("flagChanges")
	public Response flagChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		testParameterServiceImpl.flagChanges(rockWellEntityDTO);
		return Response.suc();
	}
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = testParameterServiceImpl.toUserName(usercode);
		return toJson(list);
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return testParameterServiceImpl;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return testParameterServiceImpl;
	}
}
