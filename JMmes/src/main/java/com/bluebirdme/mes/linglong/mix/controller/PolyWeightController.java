/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;











import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.bluebirdme.mes.linglong.mix.entity.PolyWeight;
import com.bluebirdme.mes.linglong.mix.service.PolyWeightServiceImpl;


/**
 * 密炼胶料产出称量实绩表
 * @author 陈国强
 * @Date 2020-09-17 17:04:06
 */
@Log(code="AT_MX_MM_POLYWEIGHT_PROD_LOG",value="密炼胶料产出称量实绩表日志")
@RestController
@RequestMapping("mix/report/weighingprocess")
public class PolyWeightController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PolyWeightServiceImpl polyweightSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return polyweightSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return polyweightSrv;
	}
    
    @Log(code="AT_MX_MM_POLYWEIGHT_PROD_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        polyweightSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value = "UDA数据查询功能", code = "ALL", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"filter"})
    public String filter(Filter filter, Page page) throws Exception {
      Map<String,Object> result = this.polyweightSrv.filter(filter, page);
      
      return toJson(result);
    }
    @Log(value = "UDA数据查询功能", code = "ALL", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"filterpass"})
    public String filterpass(Filter filter, Page page) throws Exception {
      Map result = this.polyweightSrv.filterpass(filter, page);
      return GsonTools.toJson(result);
    }
    @ResponseBody
    @RequestMapping({"exprot"})
    public String exprot(@RequestParam("s_factory_s") String s_factory_s, @RequestParam("receive_time_t") String receive_time_t, @RequestParam("end_time_t") String end_time_t, @RequestParam("shift_code_s") String shift_code_s, @RequestParam("equip_code_s") String equip_code_s, @RequestParam("wweight_type_s") String wweight_type_s, @RequestParam("warning_sgn_s") String warning_sgn_s, @RequestParam("material_name_s") String material_name_s, HttpServletRequest request, HttpServletResponse response, Filter filter, Page page)
      throws Exception
    {
      filter.set("s_factory_s", s_factory_s);
      filter.set("receive_time_t", receive_time_t);
      filter.set("end_time_t", end_time_t);
      filter.set("shift_code_s", shift_code_s);
      filter.set("equip_code_s", equip_code_s);
      filter.set("wweight_type_s", this.polyweightSrv.searchName(wweight_type_s));
      filter.set("warning_sgn_s", warning_sgn_s);
      filter.set("material_name_s", material_name_s);
      Map mapUp = this.polyweightSrv.filterexeprot(filter, page);
      Map mapDown = this.polyweightSrv.filterexeprots(filter, page, PolyWeight.class);

      List listUp = (List)mapUp.get("rows");
      List listDown = (List)mapDown.get("rows");
      this.polyweightSrv.exportService(request, response, listUp, listDown);
      return null;
    }

}
