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

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.DotControlServiceImpl;
/**
 * 年周号管控物料
 * @author 周清玉
 * @Date 2018-09-08 15:47:33
 */
@Log(code="DOTControlController",value="年周号管控物料")
@RestController
@RequestMapping("curing/baseData/DotControl")
public class DotControlController extends RockWellFunctionalUDAController<Object> {
    
	@Resource
	DotControlServiceImpl dotcontrolSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return dotcontrolSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return dotcontrolSrv;
	}
    
    
    
    @Log(code = "DOTControl_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (dotcontrolSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
		return Response.suc();
	}

    
    /**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page, Class clazz)throws Exception {
		Map list = dotcontrolSrv.datagridz(filter, page);
		return toJson(list);
	}




	
}
