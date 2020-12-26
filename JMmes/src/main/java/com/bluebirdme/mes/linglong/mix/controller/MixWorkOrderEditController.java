package com.bluebirdme.mes.linglong.mix.controller;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
//import com.bluebirdme.mes.linglong.mix.entity.MixWorkBySetUp;
import com.bluebirdme.mes.linglong.mix.entity.MixWorkOrderEdit;
import com.bluebirdme.mes.linglong.mix.entity.MixWorkOrderEditEX;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixWorkOrderEditDTO;
import com.bluebirdme.mes.linglong.mix.service.MixWorkOrderEditServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

@Log(code="DrTrack_log", value="密炼工单跟踪日志")
@RestController
@RequestMapping({"mix/productionplan/mixworkorderedit"})
public class MixWorkOrderEditController extends RockWellFunctionalController<MixWorkOrderEdit>
{

  @Resource
  MixWorkOrderEditServiceImpl drtrackSrv;

  protected RockWellBaseServiceImpl<MixWorkOrderEdit> getService()
  {
    return this.drtrackSrv;
  }
  /*@Log(code="DrTrack_log_SAVE_CHANGES", value="保存数据的增删改", target=LogType.DB)
  @RequestMapping({"saveChanges"})
  public Response saveChanges(@RequestBody MixWorkOrderEditDTO drtrack) throws Exception {
    this.drtrackSrv.saveChanges(drtrack);
    return Response.suc();
  }*/
  @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"datagrid"})
  public String datagrid(Filter filter, Page page) throws Exception {
    return GsonTools.toJson(getService().datagrid(filter, page, MixWorkOrderEditEX.class));
  }
  @Log(value="小料信息列表查询2", code="FUNC_0072", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"datagrid2"})
  public String datagrid2(Filter filter, Page page) throws Exception { filter.set("s_factory_s", LLWebUtils.factory());
    return GsonTools.toJson(this.drtrackSrv.datagrid2(filter, page, MixWorkOrderEditEX.class)); } 
  /*@Log(value="主机手查询", code="FUNC_0072", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"setup"})
  public String setup(Filter filter, Page page) throws Exception {
    filter.set("s_factory_s", LLWebUtils.factory());
    page.setPage(1);
    page.setRows(200);
    return GsonTools.toJson(this.drtrackSrv.setup(filter, page, MixWorkBySetUp.class));
  }*/
 /* @Log(value="主机手查询2", code="FUNC_0072", target=LogType.CONSOLE)
  @ResponseBody
  @RequestMapping({"setup2"})
  public String setup2(Filter filter, Page page) throws Exception { return GsonTools.toJson(this.drtrackSrv.setup2(filter, page, MixWorkBySetUp.class)); }
*/
  @RequestMapping({"downward"})
  public Response downward(String[] recipecodelist)
    throws Exception
  {
    return Response.suc(this.drtrackSrv.downward(recipecodelist));
  }

  @RequestMapping({"end"})
  public Response end(String[] recipecodelist) throws Exception
  {
    return Response.suc(this.drtrackSrv.end(recipecodelist));
  }

  @RequestMapping({"upward"})
  public Response upward(Long[] ids) throws Exception
  {
    return Response.suc(this.drtrackSrv.upward(ids));
  }

  /*@RequestMapping({"down"})
  public Response down(Long[] ids) throws Exception
  {
    return Response.suc(this.drtrackSrv.down(ids));
  }*/

  @Log(value="批报表详细信息", code="FUNC_015", target=LogType.CONSOLE)
  @RequestMapping({"getbatch"})
  public String getbatch(String recipecode) throws Exception {
    List list = this.drtrackSrv.getbatch(recipecode);
    return GsonTools.toJson(list);
  }

  @Log(value="获取数据字典机台", code="FUNC_015", target=LogType.CONSOLE)
  @RequestMapping({"geterpcode"})
  public String geterpcode() throws Exception {
    List list = this.drtrackSrv.geterpcode();
    return GsonTools.toJson(list);
  }

 /* @RequestMapping({"set"})
  public Response set(String[] ids)
    throws Exception
  {
    return Response.suc(this.drtrackSrv.set(ids));
  }*/

  @RequestMapping({"check"})
  public Response check(String[] recipecodelist) throws Exception
  {
    return Response.suc(this.drtrackSrv.check(recipecodelist));
  }
}