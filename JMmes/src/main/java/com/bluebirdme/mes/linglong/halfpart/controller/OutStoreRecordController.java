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

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.OutStoreRecordServiceImpl;


/**
 * 半部件出库记录
 * @author 王超
 * @Date 2020-03-05 09:19:29
 */
@Log(code="半部件出库记录",value="半部件出库记录")
@RestController
@RequestMapping("halfpart/stockManagement/outStoreRecord")
public class OutStoreRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource OutStoreRecordServiceImpl outstorerecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return outstorerecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return outstorerecordSrv;
	}
    
    @Override
    @Log(code = "半部件出库记录", value = "半部件出库记录")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    /**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialCode", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialCode")
	public String searchMaterialCode() throws Exception {
		List<Map<String, Object>> list = outstorerecordSrv.searchMaterialCode();
		return toJson(list);
	}
	
	/**
	 * 查出物料名称显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialName", value = "查出物料名称显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialName")
	public String searchMaterialName() throws Exception {
		List<Map<String, Object>> list = outstorerecordSrv.searchMaterialName();
		return toJson(list);
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialGroup", value = "查出物料组显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialGroup")
	public String searchMaterialGroup() throws Exception {
		List<Map<String, Object>> list = outstorerecordSrv.searchMaterialGroup();
		return toJson(list);
	}

}
