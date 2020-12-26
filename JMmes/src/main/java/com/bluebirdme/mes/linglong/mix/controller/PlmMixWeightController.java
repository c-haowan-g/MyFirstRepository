/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

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
import com.bluebirdme.mes.linglong.mix.service.PlmMixWeightServiceImpl;


/**
 * PLM密炼称量集成表
 * @author 栾和源
 * @Date 2020-08-10 11:09:01
 */
@Log(code="PLM密炼称量集成",value="PLM密炼称量集成")
@RestController
@RequestMapping("mix/qualityManagement/plmmixweight")
public class PlmMixWeightController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixWeightServiceImpl plmmixweightSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixweightSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixweightSrv;
	}
    
    @Log(code="PLM密炼称量集成_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmmixweightSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    /**
     * 称重修改
     * @author heyuan_luan
     * @param ids
     * @param weight
     * @return
     * @throws Exception
     */
    @Log(value = "称重修改", code = "FUNC_011", target = LogType.DB)
    @RequestMapping({"changeweight"})
    public Response changeweight(String[] ids, String[] weight) throws Exception {
    	return Response.suc(this.plmmixweightSrv.changeweight(ids, weight));
    }
    
    
    /**
     * 称量范围修改
     * @author heyuan_luan
     * @param ids
     * @param weight
     * @return
     * @throws Exception
     */
    @Log(value = "称量范围修改", code = "FUNC_011", target = LogType.DB)
    @RequestMapping({"submitweighing"})
    public Response submitweighing(String[] ids, String[] weight) throws Exception {
      return Response.suc(this.plmmixweightSrv.submitweighing(ids, weight));
    }
}
