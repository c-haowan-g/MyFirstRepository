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
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.service.EmbryoOverDateWarningServiceImpl;


/**
 * 胎胚超期预警
 * @author 李德晓
 * @Date 2020-07-06 13:52:23
 */
@Log(code="胎胚超期预警",value="胎胚超期预警")
@RestController
@RequestMapping("building/overDateWarning/embryooverdatewarning")
public class EmbryoOverDateWarningController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EmbryoOverDateWarningServiceImpl embryooverdatewarningSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return embryooverdatewarningSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return embryooverdatewarningSrv;
	}
    
    @Log(code="胎胚超期预警_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        embryooverdatewarningSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
  		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
  	}
   

}
