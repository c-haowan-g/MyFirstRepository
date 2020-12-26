/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

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
import com.bluebirdme.mes.linglong.material.entity.MixMaterial;
import com.bluebirdme.mes.linglong.material.service.MixMaterialServiceImpl;



/**
 * PLM密炼物料表
 * @author 李德晓
 * @Date 2020-08-05 13:04:58
 */
@Log(code="PLM密炼物料表",value="PLM密炼物料表")
@RestController
@RequestMapping("material/baseDate/mixmaterial/mixmaterial")
public class MixMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixMaterialServiceImpl mixmaterialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixmaterialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixmaterialSrv;
	}
    
    @Log(code="原材料物料维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixmaterialSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value = "密炼配方下发", code = "FUNC_011", target = LogType.DB)
    @RequestMapping("downward")
    public Response downward(String[] mixmaterialList) throws Exception {
        return Response.suc(mixmaterialSrv.downward(mixmaterialList));
    }
    @Log(value = "在用物料筛选查询", code = "FUNC_007", target = LogType.DB)
    @RequestMapping("findByMaterial")
    public String findByMaterial(Filter filter, Page page) throws Exception {
//        Response response= Response.suc(mixmaterialSrv.findByMaterial(filter, page, MixMaterial.class));
        return GsonTools.toJson(mixmaterialSrv.findByMaterial(filter, page, MixMaterial.class));
//        return response;
    }
    @Override
    @Log(code = "原材料物料维护", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}

}
