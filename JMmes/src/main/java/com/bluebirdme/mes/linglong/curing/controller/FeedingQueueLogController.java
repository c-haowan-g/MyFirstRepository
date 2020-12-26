/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.Map;

import javax.annotation.Resource;



import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.curing.service.FeedingQueueLogServiceImpl;


/**
 * 硫化扫描日志
 * @author 李新宇
 * @Date 2020-02-20 15:23:30
 */
@Log(code="硫化扫描日志",value="硫化扫描日志")
@RestController
@RequestMapping("curing/ReportQuery/FeedingQueueLog/feedingqueuelog")
public class FeedingQueueLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource FeedingQueueLogServiceImpl feedingqueuelogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return feedingqueuelogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return feedingqueuelogSrv;
	}
    
    @Override
    @Log(code = "硫化扫描日志", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    /*@Log(code="硫化扫描日志_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        feedingqueuelogSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }*/

}
