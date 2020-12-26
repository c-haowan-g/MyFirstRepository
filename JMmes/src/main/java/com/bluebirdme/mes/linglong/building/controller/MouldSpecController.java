/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.bluebirdme.mes.linglong.building.entity.MouldSpec;
import com.bluebirdme.mes.linglong.building.service.MouldSpecServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

import freemarker.template.TemplateException;

/**
 * 机头规格对应关系表
 * @author lnk
 * @Date 2019-01-14 15:22:26
 */
@Log(code="机头规格对应关系表",value="机头规格对应关系表")
@RestController
@RequestMapping("cx/zlgl/mouldspec")
public class MouldSpecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MouldSpecServiceImpl mouldspecSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mouldspecSrv;
    }
    
   
    @Override
    @Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, RockWellEntityDTO.class));
	}
    
    @Log(code="机头规格对应关系表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO mouldspec ) throws Exception {
      
        if (mouldspecSrv.saveChanges(mouldspec) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",mouldspec);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 修改导出功能
     * @throws Exception 
	 */
	
    @RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(mouldspecSrv.datagridUDA(filter, page));
	}
    
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	@RequestMapping("searchByMaterial")
	public String searchByModal(Filter filter) throws TemplateException, IOException {
		List<Map<String, Object>> list = mouldspecSrv.searchByMaterial(filter);
		return toJson(list);
	}


	/**
	 * 下拉框物料查询
	 *
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping("searchByMaterialConbox")
	public String searchByMaterialConbox(Filter filter) throws TemplateException, IOException {
		List<Map<String, Object>> list = mouldspecSrv.searchByMaterialConbox(filter);
		return toJson(list);
	}


	
	/**
	 * 机头的查询
	 * 
	 * @return
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	@RequestMapping("searchByCapsulel")
	public String searchBycapsule() throws TemplateException, IOException {
	
		List<Map<String, Object>> list = mouldspecSrv.searchBycapsule();
		return toJson(list);
	}
	
	@RequestMapping("searchByCapsulel2")
	public String searchBycapsule2(String capsulel) throws TemplateException, IOException {
	
		List<Map<String, Object>> list = mouldspecSrv.searchBycapsule2(capsulel);
		
		return GsonTools.toJson(list);
	}
	
	@RequestMapping("searchByMaterial2")
	public String searchByMaterial2(String capsulel) throws TemplateException, IOException {
	
		List<Map<String, Object>> list = mouldspecSrv.searchByMaterial2(capsulel);
		
		return GsonTools.toJson(list);
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return mouldspecSrv;
	}

	
	
}










