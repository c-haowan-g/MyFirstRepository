/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.Map;

import javax.annotation.Resource;





import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.service.MaterialApplyRecordServiceImpl;


/**
 * 密炼领料申请明细
 * @author 王超
 * @Date 2020-08-07 09:11:19
 */
@Log(code="密炼领料申请明细",value="密炼领料申请明细")
@RestController
@RequestMapping("mix/planManagement/materialApplyRecord")
public class MaterialApplyRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialApplyRecordServiceImpl materialapplyrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialapplyrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialapplyrecordSrv;
	}
    
    @Log(code = "密炼领料管理", value = "信息列表查询")
	@RequestMapping("datagridrows")
	public String datagridrows(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
    	Map map = materialapplyrecordSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    @Log(code="密炼领料申请明细_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        materialapplyrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
