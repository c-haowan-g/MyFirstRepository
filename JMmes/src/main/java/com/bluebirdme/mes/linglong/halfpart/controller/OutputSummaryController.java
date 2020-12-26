package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummaryDTO;
import com.bluebirdme.mes.linglong.halfpart.service.OutputSummaryServiceImpl;

@Log(code="半部件产量汇总查询",value="半部件产量汇总查询")
@RestController
@RequestMapping("halfpart/outputSummary")
public class OutputSummaryController extends RockWellFunctionalUDAController<Object> {
    
    @Resource OutputSummaryServiceImpl outputsummarySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return outputsummarySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return outputsummarySrv;
	}
    @Override
    @Log(code = "半部件全钢产量汇总", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
//    @Log(code="Output_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
//    @RequestMapping("saveChanges")
//    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
//    	outputsummarySrv.saveChanges(rockWellEntityDTO);
//        return Response.suc();
//    }
    @RequestMapping("search")
   	public String search(Filter filter, Page page,String sumFlag) throws Exception {
       	sumFlag = sumFlag.split(",")[0];
       	Map<String,Object> map = outputsummarySrv.search(filter, page,sumFlag);
   		return GsonTools.toJson(map);
   	}

       @RequestMapping("search_1")
   	public String search_1(Filter filter, Page page,String sumFlag) throws Exception {
       	sumFlag = sumFlag.split(",")[0];
       	Map<String,Object> map = outputsummarySrv.search_1(filter, page,sumFlag);
   		return GsonTools.toJson(map);
   	}


	@Log(code="半部件产量汇总查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody OutputSummaryDTO outputsummary ) throws Exception {
        outputsummarySrv.saveChanges(outputsummary);
        return Response.suc();
    }
	
//	//数据导出
//  	@RequestMapping("export")
//  	public String exprot(@RequestParam("s_factory_s")String s_factory_s,@RequestParam("sumFlag")String sumFlag,HttpServletRequest request,
//  			HttpServletResponse response,Filter filter,Page page) throws Exception{
//  		filter.set("s_factory_s", s_factory_s);
//  		sumFlag = sumFlag.split(",")[0];
//  		System.out.println("======"+sumFlag);
//		List listUp = outputsummarySrv.datagridAllRows(filter,sumFlag);
//		outputSummaryExportHandler.exportService(request, response,listUp,sumFlag);
//  		return null;
//  	}
  	@RequestMapping("filter")
	public String filter(Filter filter, Page page, String[] sumFlag) throws Exception {
    	String[] newSumFlag = sumFlag[0].split(",");
        List<String> queryList = Arrays.asList(newSumFlag); //鍏堝皢鏁扮粍杞寲鎴愰泦鍚�
    	Map<String,Object> map = outputsummarySrv.filter(filter, page, queryList);
		return GsonTools.toJson(map);
	}

}
