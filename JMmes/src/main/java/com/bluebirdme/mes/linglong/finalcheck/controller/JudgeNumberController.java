/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumber;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.JudgeNumberServiceImpl;

/**
 * 动平衡均匀机分级检测页面
 * 
 * @author 李迺锟
 * @Date 2018-11-13 13:24:54
 */
@Log(code = "AT_D_BS_JUDGENUMBER_LOG", value = "动平衡均匀机检测配套标准表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/JudgeNumber")
public class JudgeNumberController extends RockWellFunctionalController<JudgeNumber> {

	@Resource
	JudgeNumberServiceImpl judgenumberSrv;

	@Override
	protected RockWellBaseServiceImpl<JudgeNumber> getService() {
		return judgenumberSrv;
	}

	@Log(code = "AT_D_BS_JUDGENUMBER_LOG_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody JudgeNumberDTO judgenumber) throws Exception {
		return Response.suc(judgenumberSrv.saveChanges(judgenumber));
	}

}
