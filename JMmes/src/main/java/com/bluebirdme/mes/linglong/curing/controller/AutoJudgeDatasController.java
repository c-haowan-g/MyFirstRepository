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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.curing.service.AutoJudgeDatasServiceImpl;

/**
 * 硫化报警参数（配套）
 * 
 * @author 时永良
 * @Date 2019年7月19日08:51:44
 */
@Log(code = "AutoJudgeData", value = "AutoJudgeData")
@RestController
@RequestMapping("curing/baseData/autoJudgeDataOE")
public class AutoJudgeDatasController extends RockWellFunctionalUDAController<Object> {

	@Resource
	AutoJudgeDatasServiceImpl autojudgedatasSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return autojudgedatasSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return autojudgedatasSrv;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping("searchBy")
	public String searchBy() {
		List<Map<String, Object>> list = autojudgedatasSrv.searchBy();
		return toJson(list);
	}

	/**
	 * 清空数据
	 * 
	 * @return
	 */
	@RequestMapping("deleteChanges")
	public Response deleteChanges(@RequestBody String dataMate) {
		// 清空数据库数据
		String sql = "TRUNCATE TABLE AT_C_QM_AUTOJUDGEDATA";
		RockWellUtils.execSQL(sql);
		return Response.suc();
	}

	/**
	 * 
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateRb")
	public String updateRb(@RequestBody List<Map<String, Object>> list_map) throws Exception {
		autojudgedatasSrv.updateAll(list_map);
		// autoJudgeDatasOther.updateNyylTime(autojudgedatasSrv.listTime);
		return null;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByREorOE")
	public String searchByREorOE(String type) {
		List<Map<String, Object>> list = autojudgedatasSrv.searchByREorOE(type);
		return toJson(list);
	}

	/**
	 * 
	 * 全钢
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateQRb")
	public String updateQRb(String type, @RequestBody List<Map<String, Object>> list_map) throws Exception {
		System.out.println(type);
		autojudgedatasSrv.updateAllQ(type, list_map);
		return null;
	}

}
