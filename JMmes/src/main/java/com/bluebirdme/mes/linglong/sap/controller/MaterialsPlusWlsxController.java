/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.sap.entity.MaterialsPlus;
import com.bluebirdme.mes.linglong.sap.service.MaterialsPlusServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.MaterialsPlusWlsxServiceImpl;

/**
 * 物料信息扩展表
 * @author 周志祥
 * @Date 2019-07-02 08:23:35
 */
@Log(code="MaterialsPlus_log",value="物料信息扩展表_log")
@RestController
@RequestMapping("sap/materialTimelinessMaintain")
public class MaterialsPlusWlsxController extends RockWellFunctionalUDAController<Object> {
    
	@Resource MaterialsPlusWlsxServiceImpl materialsplusSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialsplusSrv;
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialsplusSrv;
	}

    /**
     * 物料组维护的改
     * @param rockWellEntityDTO
     * @return
     * @throws Exception
     */
    
    @Log(code = "MaterialsPlus_SAVE_CHANGES", value = "保存数据的增删改",target=LogType.DB)
   	@RequestMapping("saveChanges")
   	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
       	materialsplusSrv.saveChanges(rockWellEntityDTO);
   		return Response.suc();
   	}

    /**
     * 单物料维护的增删改
     * @param rockWellEntityDTO
     * @return
     * @throws Exception
     */

    @Log(code = "MaterialsPlus_SAVE_CHANGES", value = "保存数据的增删改",target=LogType.DB)
	@RequestMapping("savesingleChanges")
	public Response savesingleChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
    	materialsplusSrv.savesingleChanges(rockWellEntityDTO);
		return Response.suc();
	}

    /**
	 * 单物料维护失效时间页面查询使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchManageMaterialOutdate1")
	public String searchManageMaterialOutdate1(Filter filter, Page page)throws Exception {
		Map list = materialsplusSrv.datagridTime(filter, page);
		return toJson(list);
	}
	
	/**
	 * 物料组维护失效时间页面查询使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchManageMaterialOutdate")
	public String searchManageMaterialOutdate(Filter filter, Page page)throws Exception {
		Map list = materialsplusSrv.datagridGroupTime(filter, page);
		return toJson(list);
	}
	
	/**
	 * 
	 * 胎胚物料信息 周志祥 2019年6月26日
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sapMaterialList")
	public String halbMaterialList() throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.SapMaterialList();
		return toJson(list);
	}
}
