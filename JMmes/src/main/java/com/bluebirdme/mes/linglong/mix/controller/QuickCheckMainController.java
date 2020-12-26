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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.QuickCheckMain;
import com.bluebirdme.mes.linglong.mix.service.QuickCheckMainServiceImpl;


/**
 * 密炼胶料快检主表
 * @author 栾和源
 * @Date 2020-12-17 11:15:45
 */
@Log(code="密炼胶料快检主表",value="密炼胶料快检主表")
@RestController
@RequestMapping("mix/qualityManagement/quickCheckMain")
public class QuickCheckMainController extends RockWellFunctionalUDAController<Object> {
    
    @Resource QuickCheckMainServiceImpl quickcheckmainSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return quickcheckmainSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return quickcheckmainSrv;
	}
    
    @Log(code="密炼胶料快检主表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        quickcheckmainSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value = "快检触发查询子表", code = "QuickCheckdetail_Log", target = LogType.CONSOLE)
    @RequestMapping({"datagrid2"})
    public String datagrid2(String id) {
      List<Map<String, Object>> list = this.quickcheckmainSrv.searchById(id);
      return toJson(list);
    }
    
    @Log(value = "快检主表日志2", code = "ALL2", target = LogType.CONSOLE)
    @RequestMapping({"datagrid3"})
    public String datagrid3(Filter filter, Page page) throws Exception {
      filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(this.quickcheckmainSrv.datagrid3(filter, page, QuickCheckMain.class));
    }
  
    
    @RequestMapping({"kjqx"})
    public String kjqx(@RequestBody String[] args, String type) {
      List<Map<String, Object>> listDate = this.quickcheckmainSrv.kjqx(args, type);
      return toJson(listDate);
    }

}
