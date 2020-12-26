/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.common.entity.MaterialsExec;
import com.bluebirdme.mes.linglong.common.service.MaterialsExecServiceImpl;


/**
 * SAP物料主数据执行历史表
 * @author 陈国强
 * @Date 2020-09-07 10:04:40
 */
@Log(code="SAP物料主数据执行历史表",value="SAP物料主数据执行历史表")
@RestController
@RequestMapping("common/materialexec/materialsexec")
public class MaterialsExecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialsExecServiceImpl materialsexecSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialsexecSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialsexecSrv;
	}
    
    @Log(code="SAP物料主数据执行历史表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        materialsexecSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value="sap物料执行历史", code="ALL", target=LogType.CONSOLE)
    @RequestMapping({"datagridhis"})
    public String datagridhis(Filter filter, Page page) throws Exception {
      return GsonTools.toJson(this.materialsexecSrv.datagrid(filter, page, MaterialsExec.class));
    }
    @Log(value="sap物料执行2", code="ALL2", target=LogType.CONSOLE)
    @RequestMapping({"datagrid2"})
    public String datagrid2(Filter filter, Page page) throws Exception {
      return GsonTools.toJson(this.materialsexecSrv.datagrid2(filter, page, MaterialsExec.class));
    }

}
