/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.building.service.TireUpdateResumeServiceImpl;


/**
 * 胎胚重量修改履历表
 * @author 李昂
 * @Date 2020-07-23 08:45:22
 */
@Log(code="胎胚重量修改履历",value="胎胚重量修改履历")
@RestController
@RequestMapping("building/reportquery/tireupdateresume")
public class TireUpdateResumeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TireUpdateResumeServiceImpl tireupdateresumeSrv;
    
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tireupdateresumeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return tireupdateresumeSrv;
	}
    
    @Log(code="胎胚重量修改履历_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        tireupdateresumeSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
   

}
