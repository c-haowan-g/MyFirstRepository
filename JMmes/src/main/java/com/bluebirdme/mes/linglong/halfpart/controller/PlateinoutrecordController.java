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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.service.PlateinoutrecordServiceImpl;


/**
 * 半部件调拨记录查询
 * @author 徐秉正
 * @Date 2020-03-13 10:58:42
 */
@Log(code="plateinoutrecord",value="半部件调拨记录")
@RestController
@RequestMapping("halfpart/plateinoutrecord/plateinoutrecords")
public class PlateinoutrecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlateinoutrecordServiceImpl plateinoutrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plateinoutrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plateinoutrecordSrv;
	}
    
    @Log(code="plateinoutrecord_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plateinoutrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Override
    @Log(code = "半部件机台物料维护", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    // 查出物料编码显示在JSP页面下拉列表处
	 
	@Log(code = "searchMaterielcode", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterielcode")
	public String searchMaterielcode() throws Exception {
		if(LLWebUtils.factory().equals("1")){
			return toJson(plateinoutrecordSrv.searchMaterielcode());	
		}
		if(LLWebUtils.factory().equals("2")){
			return toJson(plateinoutrecordSrv.searchMaterielcode2());	
		}
		return "";
	}
	 //查出物料名称显示在JSP页面下拉列表处
	
	@Log(code = "searchMaterielname", value = "查出物料名称显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterielname")
	public String searchMaterielname() throws Exception {
		if(LLWebUtils.factory().equals("1")){
			return toJson(plateinoutrecordSrv.searchMaterielname());	
		}
		if(LLWebUtils.factory().equals("2")){
			return toJson(plateinoutrecordSrv.searchMaterielname2());	
		}
		return "";
	}
	// 查出物料组显示在JSP页面下拉列表处
	
	@Log(code = "searchMaterielgroup", value = "查出物料名称显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterielgroup")
	public String searchMaterielgroup() throws Exception {
		
		if(LLWebUtils.factory().equals("1")){
			return toJson(plateinoutrecordSrv.searchMaterielgroup());	
		}
		if(LLWebUtils.factory().equals("2")){
			return toJson(plateinoutrecordSrv.searchMaterielgroup2());	
		}
		return "";
	}
    

    
}
