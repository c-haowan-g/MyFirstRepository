/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
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
import com.bluebirdme.mes.linglong.building.service.BuildQuotaServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 成型定额表
 * @author qingyu_zhou
 * @Date 2019-06-05 09:40:52
 */
@Log(code="BuildQuota_log",value="成型定额_log")
@RestController
@RequestMapping("building/qualitymanagement/buildquota")
public class BuildQuotaController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BuildQuotaServiceImpl buildquotaSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildquotaSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildquotaSrv;
	}
    
    @Log(code="BuildQuota_log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        buildquotaSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    @Log(value = "个人台账", code = "ALL", target = LogType.CONSOLE)
   	@RequestMapping("searchsingleyield")
   	public String searchsingleyield(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
   		return GsonTools.toJson(buildquotaSrv.datagrid2(filter, page));
   	}
	
	@Log(value = "成型工艺参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@RequestMapping("datagrid2")
	public String datagrid2(String materialcode_s) {
	   	List<Map<String, Object>> list = buildquotaSrv.searchByMaterial(materialcode_s);
	   	if(list.size()!=0){
	   		System.out.println(list);
	   	};
	   	return toJson(list);
	}
	
	@Log(value = "根据胎胚编码查询外胎规格", code = "", target = LogType.CONSOLE)
	@RequestMapping("datagrid3")
	public String datagrid3(String materialcode_s) {
	   	List<Map<String, Object>> list = buildquotaSrv.searchMaterialByCode(materialcode_s);
	   	return toJson(list);
	}
	
	@Log(value = "查询成型所有厂商", code = "", target = LogType.CONSOLE)
	@RequestMapping("searchEquipTypeList")
	public String getMaterialList()throws Exception{
		List<Map<String, Object>> getMaterialList = buildquotaSrv.searchEquipTypeList();
		return toJson(getMaterialList);
	}


	
}
