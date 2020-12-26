/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Response;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.curing.entity.AutoJudgeDatas;
import com.bluebirdme.mes.linglong.curing.service.AutoJudgeDataServiceImpl;

/**
 * 硫化报警参数(零售)
 * 
 * @author 时永良
 * @Date 2019年7月19日08:52:01
 */
@Log(code = "AutoJudgeData", value = "AutoJudgeData")
@RestController
@RequestMapping("curing/baseData/autoJudgeDataRE")
public class AutoJudgeDataController extends RockWellFunctionalController<AutoJudgeDatas> {

	@Resource
	AutoJudgeDataServiceImpl autojudgedatasSrv;

	@Override
	protected RockWellBaseServiceImpl<AutoJudgeDatas> getService() {
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
		//清空数据库数据
	    String sql="TRUNCATE TABLE AT_C_QM_AUTOJUDGEDATA";
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
		//autoJudgeDataOther.updateNyylTime(autojudgedatasSrv.listTime);
		return null;
	}
}
