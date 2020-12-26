package com.bluebirdme.mes.linglong.mix.controller;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixBatchReportAll;
import com.bluebirdme.mes.linglong.mix.entity.MixBatchReportAllEx;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixBatchReportAllDTO;
import com.bluebirdme.mes.linglong.mix.service.MixBatchReportAllServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

@Log(code="MixBatchReportAll_Log", value="批报表_日志")
@RestController
@RequestMapping({"mix/report/mixbatchreportall"})
public class MixBatchReportAllController extends RockWellFunctionalController<MixBatchReportAll>
{

  @Resource
  MixBatchReportAllServiceImpl mixbatchreportallSrv;

  protected RockWellBaseServiceImpl<MixBatchReportAll> getService()
  {
    return this.mixbatchreportallSrv;
  }

/*@Log(code="MixBatchReportAll_Log_SAVE_CHANGES", value="保存数据的增删改", target=LogType.DB)
  @RequestMapping({"saveChanges"})
  public Response saveChanges(@RequestBody MixBatchReportAllDTO mixbatchreportall) throws Exception {
    this.mixbatchreportallSrv.saveChanges(mixbatchreportall);
    return Response.suc();
  }
*/
  @RequestMapping({"getequipcodelist"})
  public String getequipcodelist(String begindate, String enddate)
    throws Exception
  {
    List getequipcodelist = this.mixbatchreportallSrv.getequipcodelist(begindate, enddate);
    return toJson(getequipcodelist);
  }

  @RequestMapping({"getrecipecodelist"})
  public String getrecipecodelist(String begindate, String enddate)
    throws Exception
  {
    List getrecipecodelist = this.mixbatchreportallSrv.getrecipecodelist(begindate, enddate);
    return toJson(getrecipecodelist);
  }

  @RequestMapping({"getrecipecodebycodelist"})
  public String getrecipecodebycodelist(String begindate, String enddate, String equipcode)
    throws Exception
  {
    List getrecipecodebycodelist = this.mixbatchreportallSrv.getrecipecodebycodelist(begindate, enddate, equipcode);
    return toJson(getrecipecodebycodelist);
  }

 @Log(value="批报表生产计划汇总点击查询", code="FUNC_0072", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"datagridclick"})
  public String datagridclick(Filter filter, Page page) throws Exception {
    filter.set("s_factory_s", LLWebUtils.factory());
    return GsonTools.toJson(this.mixbatchreportallSrv.datagridclick(filter, page, MixBatchReportAllEx.class));
  }
}