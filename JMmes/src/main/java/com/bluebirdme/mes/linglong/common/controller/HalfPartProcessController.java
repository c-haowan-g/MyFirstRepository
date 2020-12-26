/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.bluebirdme.mes.linglong.common.service.HalfPartProcessServiceImpl;


/**
 * PLM半部件工艺表
 * @author 葛迎祥
 * @Date 2020-06-16 14:06:43
 */
@Log(code="AT_INT_PLM_HALFPARTPROCESS",value="AT_INT_PLM_HALFPARTPROCESS")
@RestController
@RequestMapping("common/halfPartProcess/halfpartprocess")
public class HalfPartProcessController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfPartProcessServiceImpl halfpartprocessSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return halfpartprocessSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return halfpartprocessSrv;
	}
    
    @Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(halfpartprocessSrv.datagridUDA(filter, page));
	}
    
    @Log(value = "PLM半部件工艺参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid2")
   	public String datagrid2(String ids) {
   		List<Map<String, Object>> list = halfpartprocessSrv.searchByMaterial(ids);
   		return toJson(list);
   	}

}
