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
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.QualityDegradeServiceImpl;

/**
 * 质量降级汇总表
 * 
 * @author 刘朋
 * @Date 2019-03-13 08:33:42
 */
@Log(code = "qualitydegrade_log", value = "质量降级汇总")
@RestController
@RequestMapping("curing/report/qualitydegrade")
public class QualityDegradeController extends RockWellFunctionalUDAController<Object> {

	@Resource
	QualityDegradeServiceImpl qualitydegradeSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return qualitydegradeSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return qualitydegradeSrv;
	}

	// @Override
	// @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	// @ResponseBody
	// @RequestMapping("datagridUDA")
	// public String datagrid(Filter filter, Page page) throws Exception {
	// if (filter.getFilter().containsKey("barcode_s")) {
	// filter.set("begin_created_time", "");
	// filter.set("end_created_time", "");
	// }
	// filter.set("s_factory_s", LLWebUtils.factory());
	// return GsonTools.toJson(qualitydegradeSrv.datagridUDA(filter, page));
	// }

	/**
	 * 获取硫化曲线数据
	 * 
	 * @param list_map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("wirteHx")
	public String lhqx(@RequestBody Map<String, Object> list_map) throws Exception {
		List<Map<String, Object>> listDate = qualitydegradeSrv.wirteHx(list_map);
		return toJson(listDate);
	}

	/**
	 * 查询明细
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@Log(value = "明细查询", code = "FUNC_007", target = LogType.CONSOLE)
	@RequestMapping("searchDetail")
	public String searchDetail(@RequestBody Map<String, Object> list_map) throws Exception {
		List<Map<String, Object>> list = qualitydegradeSrv.searchByMaterial(list_map);
		return toJson(list);
	}

	/**
	 * 根据轮胎号查询动平衡明细
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchDynabakanceByCode")
	public String searchDynabakanceByCode(@RequestBody Map<String, Object> list_map) throws Exception {
		List<Map<String, Object>> list = qualitydegradeSrv.searchDynabakanceByCode(list_map);
		return toJson(list);
	}

	/**
	 * 根据轮胎号查询外观降级明细
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchDetialByCode")
	public String searchDetialByCode(@RequestBody Map<String, Object> list_map) throws Exception {
		List<Map<String, Object>> list = qualitydegradeSrv.searchDetialByCode(list_map);
		return toJson(list);
	}

	/**
	 * 根据轮胎号查询 进行修改数据
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("forced")
	public Response forced(@RequestBody Map<String, Object> list_map) throws Exception {
		qualitydegradeSrv.forced(list_map);
		return Response.suc();
	}

	/**
	 * 根据轮胎号查询 进行修改数据
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("update")
	public Response update(@RequestBody Map<String, Object> list_map) throws Exception {
		qualitydegradeSrv.forced(list_map);
		return Response.suc();
	}

	/**
	 * 审核
	 * 
	 * @param barcode_s
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isAuding")
	public Response isAuding(@RequestBody Map<String, Object> list_map) throws Exception {
		qualitydegradeSrv.isAuding(list_map);
		return Response.suc();
	}

	@RequestMapping("getlist")
	public String list() throws Exception {
		List<Map<String, Object>> list = qualitydegradeSrv.getlist();
		return toJson(list);
	}

}
