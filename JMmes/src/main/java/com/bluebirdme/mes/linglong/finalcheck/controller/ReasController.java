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
import com.bluebirdme.mes.linglong.finalcheck.entity.Reas;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ReasDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.ReasServiceImpl;

/**
 * 质检病象信息表
 * @author 司乔靖
 * @Date 2018-08-05 13:14:26
 */
@Log(code="ZJ_JCGL_BX",value="质检病象信息表日志")
@RestController
@RequestMapping("finalcheck/baseData/reas")
public class ReasController extends RockWellFunctionalController<Reas> {
    
    @Resource ReasServiceImpl reasSrv;

    @Override
    protected RockWellBaseServiceImpl<Reas> getService() {
        return reasSrv;
    }
    
    
    @Log(code="ZJ_JCGL_BX_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ReasDTO reas ) throws Exception{
        reasSrv.saveChanges(reas);
        return Response.suc();
    }
    
    @Log(code="comboxReasCodeDesc",value="查询病象编号和病象描述对应关系")
    @RequestMapping("comboxReasCodeDesc")
   	public String comboxReasCodeDesc() throws Exception{
    	List<Map<String,Object>> list=reasSrv.getComboxReasCodeDesc();
   		return toJson(list);
   	}
    
    @Log(code="comboxReasCodeDescWg",value="//查看外观病象")
    @RequestMapping("comboxReasCodeDescWg")
    public String comboxReasCodeDescWg() throws Exception{
    	List<Map<String,Object>> list=reasSrv.comboxReasCodeDescWg();
    	return toJson(list);
    }
    
    @Log(code="comboxReasCodeDescXray",value="查看X光病象")
    @RequestMapping("comboxReasCodeDescXray")
    public String comboxReasCodeDescXray() throws Exception{
    	List<Map<String,Object>> list=reasSrv.comboxReasCodeDescXray();
    	return toJson(list);
    }

}
