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

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.Ent;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.EntDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.EntServiceImpl;

/**
 * 质检设备信息表
 * @author 司乔靖
 * @Date 2018-08-10 07:56:16
 */
@Log(code="ZJ_JCGL_SB",value="质检设备信息表日志")
@RestController
@RequestMapping("finalcheck/baseData/ent")
public class EntController extends RockWellFunctionalController<Ent> {
    
    @Resource EntServiceImpl entSrv;

    @Override
    protected RockWellBaseServiceImpl<Ent> getService() {
        return entSrv;
    }
    
    
    @Log(code="ZJ_JCGL_SB_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody EntDTO ent ) throws Exception{
        entSrv.saveChanges(ent);
        return Response.suc();
    }
    
    @Log(code="ZJ_JCGL_SB_entBarcodeExit",value="判断设备条码是否存在",target=LogType.CONSOLE)
    @RequestMapping("entBarcodeExit")
   	public String entBarcodeExit(String entBarcode) throws Exception{
    	List<Map<String,Object>> list=entSrv.entBarcodeExit(entBarcode);
   		return toJson(list);
   	}
    @Log(code="ZJ_JCGL_SB_FORCED",value="强制自动",target=LogType.CONSOLE)
    @RequestMapping("forced")
   	public Response forced(Long[] ids,String foreType) throws Exception{
    	entSrv.forced(ids,foreType);
   		return Response.suc();
   	}
}
