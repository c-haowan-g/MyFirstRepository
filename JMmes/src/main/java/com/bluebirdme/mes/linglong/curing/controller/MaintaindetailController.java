/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.MaintaindetailServiceImpl;

/**
 * 设备维修履历
 * @author 周清玉
 * @Date 2019-09-4 09:25:34
 */
@Log(code="Maintaindetail_log",value="设备维修履历日志")
@RestController
@RequestMapping("curing/ReportQuery/maintaindetail")
public class MaintaindetailController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaintaindetailServiceImpl maintaindetailSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return maintaindetailSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return maintaindetailSrv;
	}
    
    @Log(code="Maintaindetail_log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        maintaindetailSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

	@RequestMapping("updateDate")
   	public Response isAuding(@RequestBody Map<String,Object> list_map) throws Exception {
		maintaindetailSrv.updateDate(list_map);
		return Response.suc();
   	}
	
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page)throws Exception {
			return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
//	
//	
//	@RequestMapping("datagridTwo")
//	public String datagridTwo(Filter filter, Page page)throws Exception {
//		Map map = maintaindetailSrv.datagridTwo(filter, page, MaintaindetailCount.class);
//		return toJson(map);
//	}


	
	
}
