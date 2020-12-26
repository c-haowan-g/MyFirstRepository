/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pnuts.xml.newDocument;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.material.service.TestTaskPushServiceImpl;
import com.bluebirdme.mes.linglong.material.entity.TestTaskDenial;
import com.bluebirdme.mes.linglong.material.entity.TestTaskDetial;
import com.bluebirdme.mes.linglong.material.entity.TestTaskPush;
import com.bluebirdme.mes.linglong.material.service.TestTaskDenialServiceImpl;
import com.bluebirdme.mes.linglong.material.service.TestTaskDetialServiceImpl;



/**
 * TDM检测任务执行表[MES发WMS]
 * @author 李昂
 * @Date 2020-08-11 08:21:36
 */
@Log(code="TDM检测任务管理",value="TDM检测任务管理")
@RestController
@RequestMapping("material/qualityManagement/testtaskpush")
public class TestTaskPushController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TestTaskPushServiceImpl testtaskpushSrv;
    
    @Resource
    TestTaskDenialServiceImpl testTaskDenialService;

   

    @Resource
    TestTaskDetialServiceImpl testTaskDetailService;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return testtaskpushSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return testtaskpushSrv;
	}
    
    @Log(code="TDM检测任务管理_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        testtaskpushSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    //数据导出
    @SuppressWarnings("unchecked")
    @RequestMapping("export")
    public String export(@RequestParam("mesbusinesscode_s")String mesbusinesscode_s, HttpServletRequest request,
                         HttpServletResponse response, Filter filter, Page page) throws Exception{
        System.out.println(mesbusinesscode_s+"单号");
        filter.set("mesbusinesscode_s",mesbusinesscode_s);
        /*filter.set("s_factory_s", "0");*/
        Filter filter2=new Filter();
        filter2.set("mesbusinesscode_s",mesbusinesscode_s);
        Map mapPush = testtaskpushSrv.datagrid(filter, page,TestTaskPush.class);
        
        Map mapDenial = testTaskDenialService.datagrid(filter2, page,TestTaskDenial.class);
        
        Map mapDetail = testTaskDetailService.datagrid(filter2, page,TestTaskDetial.class);
        
        List<TestTaskPush> listPush = (List<TestTaskPush>) mapPush.get("rows");
        List<TestTaskDenial> listDenial = (List<TestTaskDenial>) mapDenial.get("rows");
       
        List<TestTaskDetial> listDetail = (List<TestTaskDetial>) mapDetail.get("rows");
        
        //将数据字典编码转换为名称
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");

        testtaskpushSrv.exportService(mesbusinesscode_s, request, response,listPush,listDenial,listDetail);
        return null;
    }

}
