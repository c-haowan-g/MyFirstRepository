/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.entity.Plan;
import com.bluebirdme.mes.linglong.mix.service.PlanServiceImpl;

/**
 * 密炼日计划表
 * 
 * @author 王超
 * @Date 2020-08-04 16:31:44
 */
@Log(code = "密炼日计划编制", value = "密炼日计划编制")
@RestController
@RequestMapping("mix/planManagement/dayPlan")
public class PlanController extends RockWellFunctionalUDAController<Object> {

	@Resource
	PlanServiceImpl planSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return planSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return planSrv;
	}

	@Log(code = "密炼日计划编制_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO)
			throws Exception {
		if (planSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复",
					rockWellEntityDTO);
		}
		return Response.suc("OK");
	}

	@Log(code = "密炼日计划编制_下发", value = "下发")
	@RequestMapping({ "downwardbysos" })
	public Response downwardbysos(String[] ids) throws Exception {
		return Response.suc(planSrv.downwardbysos(ids));
	}

	@Log(code = "生成领料计划", value = "生成领料计划", target = LogType.DB)
	@RequestMapping("producerecivelist")
	public Response producerecivelist(String[] ids) throws Exception {
		return Response.suc(this.planSrv.producerecivelist(ids));
	}

	/**
	 * 密炼机台列表查询
	 * 
	 * @return
	 */
	@Log(code = "searchMixEquip", value = "查出密炼机台列表显示在JSP页面下拉列表处")
	@RequestMapping("searchMixEquip")
	public String searchMixEquip() throws Exception {
		List<Map<String, Object>> list = planSrv.searchMixEquip();
		return toJson(list);
	}

	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = planSrv.toUserName(usercode);
		return toJson(list);
	}

	/**
	 * 根据机台查询胶料密炼配方
	 * 
	 * @return
	 */
	@Log(code = "mixJLMaterialList", value = "根据机台查询胶料密炼配方")
	@RequestMapping("mixJLMaterialList")
	public String mixJLMaterialList(String equipcode) throws Exception {
		List<Map<String, Object>> list = planSrv.mixJLMaterialList(equipcode);
		return toJson(list);
	}

	/**
	 * 根据机台查询小料密炼配方
	 * 
	 * @return
	 */
	@Log(code = "mixXLMaterialList", value = "根据机台查询小料密炼配方")
	@RequestMapping("mixXLMaterialList")
	public String mixXLMaterialList(String equipcode, String mater_type_s)
			throws Exception {
		List<Map<String, Object>> list = planSrv.mixXLMaterialList(equipcode,
				mater_type_s);
		return toJson(list);
	}

	/**
	 * 根据物料编码查询名称
	 * 
	 * @return
	 */
	@Log(code = "getMaterialNameByCode", value = "根据物料编码查询名称")
	@RequestMapping("getMaterialNameByCode")
	public String getMaterialNameByCode(String materialcode) throws Exception {
		List<Map<String, Object>> list = planSrv
				.getMaterialNameByCode(materialcode);
		return toJson(list);
	}

	/**
	 * 获取密炼日计划最大顺序号
	 * 
	 * @return
	 */
	@Log(code = "getMixDayPlanMaxSeq", value = "获取密炼日计划最大顺序号")
	@RequestMapping("getMixDayPlanMaxSeq")
	public int getMixDayPlanMaxSeq(String plandate, String equipcode) {
		return planSrv.getMixDayPlanMaxSeq(plandate, equipcode);
	}

	/**
	 * 上移
	 * 
	 * @return
	 */
	@RequestMapping({ "upward" })
	public Response upward(String[] ids) throws Exception {
		return Response.suc(planSrv.upward(ids));
	}

	/**
	 * 下移
	 * 
	 * @return
	 */
	@RequestMapping({ "down" })
	public Response down(String[] ids) throws Exception {
		return Response.suc(planSrv.down(ids));
	}

	/**
	 * 获取配方,快检下拉列表
	 * 
	 * @return
	 */
	@Log(code = "getAddInfoList", value = "获取配方,快检下拉列表")
	@RequestMapping("getAddInfoList")
	public Response getAddInfoList(String equipcode, String materialcode,
			String palntype) throws Exception {
		Object[] list = planSrv.getAddInfoList(equipcode, materialcode,
				palntype);
		return Response.suc(list);
	}

	/**
	 * 配方选择事件
	 * 
	 * @return
	 */
	@Log(code = "getAddInfoListByRecipecode", value = "配方选择事件")
	@RequestMapping("getAddInfoListByRecipecode")
	public Response getAddInfoListByRecipecode(String recipecode,
			String productdate) throws Exception {
		return planSrv.getAddInfoListByRecipecode(recipecode, productdate);
	}

	/**
	 * 计划校验查重
	 * 
	 * @return
	 */
	@Log(code = "validEquipcodeExitInPlan", value = "计划校验查重")
	@RequestMapping("validEquipcodeExitInPlan")
	public Response validEquipcodeExitInPlan(String plandate, String equipment,
			String materialcode, String recipecode) {
		return Response.suc(planSrv.validEquipcodeExitInPlan(plandate,
				equipment, materialcode, recipecode));
	}

	/**
	 * 等同物料查询
	 * 
	 * @return
	 */
	@Log(value = "查询等同物料信息", code = "getEqualMaterialcode")
	@RequestMapping("getEqualMaterialcode")
	public String getEqualMaterialcode(String recipecode, String equipcode,
			String materialcode) throws Exception {
		List<Map<String, Object>> list = planSrv.getEqualMaterialcode(
				recipecode, equipcode);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).get("DUMMY2_S").toString().equals("0")) {
					continue;
				}
				List<Map<String, Object>> list1 = planSrv
						.getEqualMaterialLevel(materialcode);
				if (list1.size() > 0) {
					if (Integer.valueOf(list.get(i).get("GRADE_I").toString()) > Integer
							.valueOf(list1.get(0).get("GRADE_I").toString())) {
						list.remove(i);
					}
				}
			}
		}
		return GsonTools.toJson(list);
	}

	/**
	 * 日计划复制
	 * 
	 * @return
	 */
	@Log(value = "日计划复制", code = "copy")
	@RequestMapping("copy")
	public Response copy(Filter filter, String plantype, String todate,
			Page page) throws Exception {
		filter.set("plan_type_s", plantype);
		List<Plan> copyPlanList = planSrv.copy(filter, todate, page);
		Object[] res = new Object[] { copyPlanList };
		return Response.suc(res);
	}

	@Log(code = "胶料计划", value = "信息列表查询")
	@RequestMapping("datagridjl")
	public String datagridjl(Filter filter, Page page) throws Exception {
		Map map = planSrv.datagridUDAjl(filter, page);
		return toJson(map);
	}

	@Log(code = "小料计划", value = "信息列表查询")
	@RequestMapping("datagridxl")
	public String datagridxl(Filter filter, Page page) throws Exception {
		Map map = planSrv.datagridUDAxl(filter, page);
		return toJson(map);
	}

	/**
	 * 获取密炼物料信息
	 * 
	 * @return
	 */
	@Log(code = "getMixMatInfo", value = "获取密炼物料信息")
	@RequestMapping({ "getMixMatInfo" })
	public String getMixMatInfo() throws Exception {
		List<Map<String, Object>> list = planSrv.getMixMatInfo();
		return toJson(list);
	}

	/**
	 * 获取胶料机台信息
	 * 
	 * @return
	 */
	@Log(code = "getJlEquipList", value = "获取胶料机台信息")
	@RequestMapping({ "getJlEquipList" })
	public String getJlEquipList(String plantype) throws Exception {
		List<Map<String, Object>> list = planSrv.getJlEquipList(plantype);
		return toJson(list);
	}

	/**
	 * 获取小料机台信息
	 * 
	 * @return
	 */
	@Log(code = "getXlEquipList", value = "获取小料机台信息")
	@RequestMapping({ "getXlEquipList" })
	public String getXlEquipList() throws Exception {
		List<Map<String, Object>> list = planSrv.getXlEquipList();
		return toJson(list);
	}

	@RequestMapping({ "getplmByPlinenameall" })
	public String getplmByPlinenameall() throws Exception {
		List<Map<String, Object>> list = planSrv.getplmByPlinenameall();
		return toJson(list);
	}

}
