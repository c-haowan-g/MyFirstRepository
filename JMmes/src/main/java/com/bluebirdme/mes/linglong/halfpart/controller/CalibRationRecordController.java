/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

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
import com.bluebirdme.mes.linglong.halfpart.service.CalibRationRecordServiceImpl;


/**
 * 半部件校称记录表
 * @author 时永良
 * @Date 2020-12-08 13:34:03
 */
@Log(code="半部件校称记录查询",value="半部件校称记录查询")
@RestController
@RequestMapping("halfpart/report/calibRationRecord/calibrationrecord")
public class CalibRationRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CalibRationRecordServiceImpl calibrationrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return calibrationrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return calibrationrecordSrv;
	}
    
    @Log(code="半部件校称记录查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        calibrationrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    @Override
    @Log(code = "半部件校称记录初始化查询", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
}
