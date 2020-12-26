/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberItemAll;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberItemDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.JudgeNumberItemServiceImpl;

/**
 * 动平衡均匀机分级检测检测标准页面
 * 
 * @author 李迺锟
 * @Date 2018-11-13 15:30:47
 */
@Log(code = "AT_D_BS_JUDGENUMBERITEM_LOG", value = "动平衡均匀机检测配套标准物料表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/JudgeNumberItem")
public class JudgeNumberItemController extends RockWellFunctionalController<JudgeNumberItem> {

	@Resource
	JudgeNumberItemServiceImpl judgenumberitemSrv;

	@Override
	protected RockWellBaseServiceImpl<JudgeNumberItem> getService() {
		return judgenumberitemSrv;
	}

	@Log(code = "AT_D_BS_JUDGENUMBERITEM_LOG_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody JudgeNumberItemDTO judgenumberitem) throws Exception {
		judgenumberitemSrv.saveChanges(judgenumberitem);
		return Response.suc();
	}

	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@RequestMapping("datagrid1")
	public String datagrid(Filter filter, Page page, String judgeno_s, String enttype_s) throws Exception {
		page.setRows(1000);
		filter.set("judgeno_s", judgeno_s);
		filter.set("enttype_s", enttype_s);
		return GsonTools.toJson(getService().datagrid(filter, page, JudgeNumberItemAll.class));
	}

	@Log(code = "AT_D_BS_JUDGENUMBERITEM_LOG_SAVE_GETITEM", value = "根据设备类型、检测标准编号查询规格", target = LogType.CONSOLE)
	@RequestMapping("getJudgeItems")
	public String getJudgeItems(String entType) throws Exception {
		List<Map<String, Object>> list = judgenumberitemSrv.getJudgeItems(entType);
		return toJson(list);
	}
}
