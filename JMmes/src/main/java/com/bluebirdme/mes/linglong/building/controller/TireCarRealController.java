/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.service.TireCarRealServiceImpl;

/**
 * 成型胎胚车信息查询
 * @author 王超
 * @Date 2020-07-10 10:09:16
 */
@Log(code="成型胎胚车信息查询",value="成型胎胚车信息查询")
@RestController
@RequestMapping("building/reportquery/tirecarreal")
public class TireCarRealController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TireCarRealServiceImpl tirecarrealSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tirecarrealSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return tirecarrealSrv;
	}
    
    @Log(code = "成型胎胚车信息查询", value = "成型胎胚车信息查询")
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		Map<String, Object> map = tirecarrealSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    /**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = tirecarrealSrv.toUserName(usercode);
		return toJson(list);
	}

}
