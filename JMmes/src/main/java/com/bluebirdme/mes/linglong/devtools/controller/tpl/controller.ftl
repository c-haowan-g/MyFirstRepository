/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package ${packageName}.controller;

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

import ${packageName}.service.${entityName}ServiceImpl;


/**
 * ${comment}
 * @author ${author}
 * @Date ${time}
 */
@Log(code="${logCode}",value="${logName}")
@RestController
@RequestMapping("${url}")
public class ${entityName}Controller extends RockWellFunctionalUDAController<Object> {
    
    @Resource ${entityName}ServiceImpl ${entityName?lower_case}Srv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return ${entityName?lower_case}Srv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return ${entityName?lower_case}Srv;
	}
    
    @Log(code="${logCode}_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        ${entityName?lower_case}Srv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
