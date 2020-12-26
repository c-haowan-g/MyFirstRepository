/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.DelayHandleRecordServiceImpl;


/**
 * 半部件延期履历表
 * @author 李德晓
 * @Date 2020-10-07 16:04:13
 */
@Log(code="半部件延期履历",value="半部件延期履历")
@RestController
@RequestMapping("halfpart/baseData/delayHandleRecord")
public class DelayHandleRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DelayHandleRecordServiceImpl delayhandlerecordSrv;
    @Override
    @Log(value = "信息列表查询", code = "半部件延期履历查询", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(delayhandlerecordSrv.datagridUDA(filter, page));
	}
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return delayhandlerecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return delayhandlerecordSrv;
	}
    
    @Log(code="半部件延期履历_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        delayhandlerecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(code = "searchUsercode", value = "查出查出usercode，username并转换")
   	@RequestMapping("searchUsercode")
   	public String searchUsercode() throws Exception {
   		List<Map<String, Object>> list = delayhandlerecordSrv.searchUsercode();
   		return toJson(list);
   	} 

}
