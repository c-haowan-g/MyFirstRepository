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
import com.bluebirdme.mes.linglong.finalcheck.service.XrayMaintainServiceImpl;

import java.util.List;
import java.util.Map;


/**
 * X光检测数据维护表
 * @author 时永良
 * @Date 2020-02-21 16:09:51
 */
@Log(code="XrayMaintainController",value="X光检测数据维护表")
@RestController
@RequestMapping("finalcheck/baseData/xrayMaintain")
public class XrayMaintainController extends RockWellFunctionalUDAController<Object> {
    
    @Resource XrayMaintainServiceImpl xraymaintainSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return xraymaintainSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return xraymaintainSrv;
	}
    
    @Log(code="X光检测数据维护表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        String message = xraymaintainSrv.saveChanges(rockWellEntityDTO);
        return Response.error(Response.SYS_EXCEPTION,message,null);
    }

    /**
     *
     * 外胎物料信息--X光检测数据维护
     * 时永良 2020年2月22日
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("fertMaterialList")
    public String fertMaterialList() throws Exception {
        List<Map<String, Object>> list = xraymaintainSrv.fertMaterialList();
        return toJson(list);
    }


}
