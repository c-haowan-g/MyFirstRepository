package com.bluebirdme.mes.linglong.mix.controller;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixCarReport;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixCarReportDTO;
import com.bluebirdme.mes.linglong.mix.service.MixCarReportServiceImpl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

@Log(code="MixCarReport_Log", value="密炼车报表")
@RestController
@RequestMapping({"mix/MixCarReport"})
public class MixCarReportController extends RockWellFunctionalController<MixCarReport>
{

  @Resource
  MixCarReportServiceImpl mixcarreportSrv;

  protected RockWellBaseServiceImpl<MixCarReport> getService()
  {
    return this.mixcarreportSrv;
  }

 /* @Log(code="MixCarReport_Log_SAVE_CHANGES", value="保存数据的增删改", target=LogType.DB)
  @RequestMapping({"saveChanges"})
  public Response saveChanges(@RequestBody MixCarReportDTO mixcarreport) throws Exception {
    this.mixcarreportSrv.saveChanges(mixcarreport);
    return Response.suc();
  }*/

  @RequestMapping({"ljqx"})
  public String ljqx(@RequestBody Map<String, Object> list_map)
  {
    List listDate = this.mixcarreportSrv.ljqx(list_map);
    return toJson(listDate);
  }
  @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"datagrid"})
  public String datagrid(Filter filter, Page page) throws Exception { String pageNum = filter.get("page");
    if (null == pageNum) {
      pageNum = String.valueOf(1);
    }
    Map map = filter.getFilter();
    map.remove("page");
    Filter filterNew = new Filter();
    filterNew.setFilter(map);
    filterNew.set("s_factory_s", LLWebUtils.factory());
    page.setRows(1);
    page.setPage(Integer.valueOf(pageNum).intValue());
    return GsonTools.toJson(getService().datagrid(filterNew, page, null));
  }

  @Log(value="通过条码获取密炼信息日志", code="ALLHis", target=LogType.CONSOLE)
  @RequestMapping({"findByBarcode"})
  public String findByBarcode(Filter filter, Page page)
    throws Exception
  {
    return GsonTools.toJson(this.mixcarreportSrv.findByBarcode(filter, page, MixCarReport.class));
  }

  @RequestMapping({"getrecipecodebycodelist"})
  public String getrecipecodebycodelist(String begindate, String enddate, String equipcode)
    throws Exception
  {
    List getrecipecodebycodelist = this.mixcarreportSrv.getrecipecodebycodelist(begindate, enddate, equipcode);
    return toJson(getrecipecodebycodelist);
  }
}