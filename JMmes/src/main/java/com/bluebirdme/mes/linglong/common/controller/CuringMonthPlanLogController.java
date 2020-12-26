/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.service.CuringMonthPlanLogServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.CuringMonthPlanLog;
import com.bluebirdme.mes.linglong.common.entity.dto.CuringMonthPlanLogDTO;


/**
 * 轮胎主表(同步硫化月计划实际产量及已过动平衡量)
 * @author 李迺锟
 * @Date 2019-02-20 17:30:34
 */
@Log(code="AT_C_MM_MAINTYRE_QTYLOG_LOG",value="硫化月计划量更新日志")
@RestController
@RequestMapping("common/interfacelog/curingmonthplan")
public class CuringMonthPlanLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringMonthPlanLogServiceImpl curingmonthplanlogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingmonthplanlogSrv;
    }
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingmonthplanlogSrv;
	}
    
	@RequestMapping("searchBy")//这个方法是跟高飞封装的方法一样的
	public String searchByEntName(Filter filter, Page page)throws Exception {
		Map list = curingmonthplanlogSrv.datagridUDA(filter, page);
		return toJson(list);
	}
    /*searchBy：调用Debug*/

}
