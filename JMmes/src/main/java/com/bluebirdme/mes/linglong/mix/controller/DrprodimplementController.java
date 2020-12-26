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
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.DrprodimplementServiceImpl;


/**
 * 密炼胶料产出车次实绩表
 * @author 栾和源
 * @Date 2020-08-04 13:14:19
 */
@Log(code="密炼胶料产出车次实绩",value="密炼胶料产出车次实绩")
@RestController
@RequestMapping("mix/productionManagement/drprodimplement")
public class DrprodimplementController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DrprodimplementServiceImpl drprodimplementSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return drprodimplementSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return drprodimplementSrv;
	}
    
    @Log(code="密炼胶料产出车次实绩_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        drprodimplementSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    /**
     * 密炼胶料产出车次实绩表
     * @author 陈国强
     * @Date 2020-09-16 13:14:19
     */
    @RequestMapping({"ccqx"})
    public String lhqx(@RequestBody Map<String, Object> list_map)
    {
      List listDate = this.drprodimplementSrv.ccqx(list_map);
      return toJson(listDate);
    }
    @Log(value="查询代码数据字典", code="FUNC_016", target=LogType.CONSOLE)
    @RequestMapping({"getDictFormatter"})
    public String getDictFormatter(String dictcode) throws Exception {
      List list = this.drprodimplementSrv.getDictFormatter(dictcode);
      return GsonTools.toJson(list);
    }

}
