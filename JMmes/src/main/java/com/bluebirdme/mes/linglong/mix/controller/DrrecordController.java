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
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.DrrecordServiceImpl;


/**
 * 密炼投料履历
 * @author 栾和源
 * @Date 2020-08-03 11:41:49
 */
@Log(code="密炼投料履历",value="密炼投料履历")
@RestController
@RequestMapping("mix/productionManagement/drrecord")
public class DrrecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DrrecordServiceImpl drrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return drrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return drrecordSrv;
	}
    
   /**
    * 加载密炼机台信息 
    * 栾和源
    * 2020-08-03
    */
    @RequestMapping("getMixProductionInfo")
   	public String getMixProductionInfo(String plantype) throws Exception{
    	List<Map<String,Object>> list=drrecordSrv.getMixProductionInfo(plantype);
   		return toJson(list);
   	} 
   

}
