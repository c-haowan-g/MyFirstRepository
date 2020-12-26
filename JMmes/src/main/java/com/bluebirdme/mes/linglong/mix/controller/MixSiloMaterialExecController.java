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
import com.bluebirdme.mes.linglong.mix.entity.MixSiloMaterialExec;
import com.bluebirdme.mes.linglong.mix.service.MixSiloMaterialExecServiceImpl;


/**
 * 密炼料仓物料维护下发历史表
 * @author 陈国强
 * @Date 2020-09-01 11:05:23
 */
@Log(code="MixSiloMaterialExec_Log",value="密炼料仓物料维护下发日志")
@RestController
@RequestMapping("mix/MixSiloMaterialExec")
public class MixSiloMaterialExecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixSiloMaterialExecServiceImpl mixsilomaterialexecSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixsilomaterialexecSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixsilomaterialexecSrv;
	}
    
    @Log(code="MixSiloMaterialExec_Log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixsilomaterialexecSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="密炼料仓物料维护下发日志2", code="ALL2", target=LogType.CONSOLE)
    @RequestMapping({"datagrid2"})
    public String datagrid2(Filter filter, Page page) throws Exception {
      return GsonTools.toJson(this.mixsilomaterialexecSrv.datagridUDA(filter, page));
    }
    @Log(value="密炼料仓物料维护下发日志His", code="ALLHis", target=LogType.CONSOLE)
    @RequestMapping({"datagridHis"})
    public String datagridHis(Filter filter, Page page) throws Exception {
      return GsonTools.toJson(this.mixsilomaterialexecSrv.datagrid(filter, page, MixSiloMaterialExec.class));
    }
/*
    @Log(value="密炼料仓物料维护下发日志", code="ALL", target=LogType.CONSOLE)
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception {
      new DefaultTime().addTime(filter);
      return GsonTools.toJson(this.mixsilomaterialexecSrv.datagrid(filter, page, MixSiloMaterialExec.class));
    }*/
}
