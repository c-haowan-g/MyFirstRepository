/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.QualityinfoServiceImpl;


/**
 * AT_A_QM_QUALITYINFO
 * @author 葛迎祥
 * @Date 2020-06-28 16:55:16
 */
@Log(code="AT_A_QM_QUALITYINFO",value="AT_A_QM_QUALITYINFO")
@RestController
@RequestMapping("halfpart/productionManagement/qualityinfo")
public class QualityinfoController extends RockWellFunctionalUDAController<Object> {
    
    @Resource QualityinfoServiceImpl qualityinfoSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return qualityinfoSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return qualityinfoSrv;
	}
    
    @Log(code="AT_A_QM_QUALITYINFO_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        String result = qualityinfoSrv.saveChanges(rockWellEntityDTO);
        if(result.equals("error")){
        	return Response.error("no", "no", "no");
        }
        return Response.suc();
    }
    
    // 获取最大病象编号
    @Log(code="getMaxNo",value="获取最大病象编号")
    @RequestMapping("getMaxNo")
    public String getMaxNo() throws Exception {
    	List<Map<String, Object>> mapList = qualityinfoSrv.getMaxNo();
    	String maxNo = "";
    	for (int i = 0; i < mapList.size(); i++) {
    		Map<String, Object> map = mapList.get(i);
    		maxNo = (String) map.get("SICKELEPHANTS_NO_S");
		}
        return maxNo;
    }
    
}
