/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.Judge;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeVO;
import com.bluebirdme.mes.linglong.finalcheck.service.JudgeServiceImpl;

/**
 * 判定标准维护
 * @author 刘程明
 * @Date 2018-08-01 13:48:20
 */
@Log(code="ZJ_BZGL_PDBZ",value="判定标准维护页面日志")
@RestController
@RequestMapping("finalcheck/reportCenter/Judge")
public class JudgeController extends RockWellFunctionalController<Judge> {
    
    @Resource JudgeServiceImpl judgeSrv;

    @Override
    protected RockWellBaseServiceImpl<Judge> getService() {
        return judgeSrv;
    }
    
    
    @Log(code="ZJ_BZGL_PDBZ_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody JudgeVO judge ) throws Exception{
        judgeSrv.saveChanges(judge);
        return Response.suc();
    }

    @Override
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return toJson(judgeSrv.datagrid(filter, page,JudgeDTO.class));
	}
}
