/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.TyreReasCountRecordServiceImpl;


/**
 * 外观检测统计病象条码数量
 * @author 李昂
 * @Date 2020-07-27 13:15:13
 */
@Log(code="AT_D_QM_TYREREASCOUNT",value="硫化后工序履历")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/tyrereascountrecord")
public class TyreReasCountRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TyreReasCountRecordServiceImpl tyrereascountrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tyrereascountrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return tyrereascountrecordSrv;
	}
    
    @Log(code="AT_D_QM_TYREREASCOUNT_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        tyrereascountrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
