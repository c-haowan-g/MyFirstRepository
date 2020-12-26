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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.bluebirdme.mes.linglong.mix.service.CarriersServiceImpl;

/**
 * 密炼载具信息表
 * @author 王超
 * @Date 2020-08-03 15:27:50
 */
@Log(code="密炼载具信息表",value="密炼载具信息表")
@RestController
@RequestMapping("mix/baseData/carriers")
public class CarriersController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CarriersServiceImpl carriersSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return carriersSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return carriersSrv;
	}
    
    @Override
    @Log(code = "密炼载具信息", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    @Log(code="密炼载具信息表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	if (carriersSrv.saveChanges(rockWellEntityDTO) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = carriersSrv.toUserName(usercode);
		return toJson(list);
	}

}
