/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortStoragItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortStoragItemDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.SortStoragItemServiceImpl;
import org.xdemo.app.xutils.ext.GsonTools;

/**
 * 入库规则维护
 * @author 马健斌
 * @Date 2018-08-16 13:07:09
 */
@Log(code="ZJ_BZGL_RKFJ",value="入库规则维护日志")
@RestController
@RequestMapping("finalcheck/reportcenter/sortstorageitem")
public class SortStoragItemController extends RockWellFunctionalController<SortStoragItem> {

    @Resource SortStoragItemServiceImpl sortstorageitemSrv;

    @Override
    protected RockWellBaseServiceImpl<SortStoragItem> getService() {
        return sortstorageitemSrv;
    }


    @Log(code="ZJ_BZGL_RKFJ_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SortStoragItemDTO sortstorageitem ) throws Exception{
        sortstorageitemSrv.saveChanges(sortstorageitem);
        return Response.suc();
    }

    @Log(code="ZJ_BZGL_RKFJ_SAVE_ENTNAME",value="获取分拣道口")
    @RequestMapping("combox_entcode")
   	public String combox_entcode() throws Exception{
    	List<Map<String,Object>> list=sortstorageitemSrv.getEntCodeName();
   		return toJson(list);
   	}
    
    /*@Log(code="ZJ_BZGL_RKFJ_SAVE_ENTNAME",value="获取分拣道口")
    @RequestMapping("datagrid_material_factory")
   	public String getmaterial() throws Exception{
    	List<Map<String,Object>> list=sortstorageitemSrv.getmaterial();
   		return toJson(list);
   	}*/

	@Log(code = "getPartsDatagrid", value = "过滤获取外胎物料")
	@RequestMapping("datagrid_material_factory")
	public String getPartsDatagrid(Filter filter) throws Exception {
		String factoryString = LLWebUtils.factory();
		if (factoryString.equals("1")) {
			filter.set("matgrp_s", "in:211001,211003");
		}
		if (factoryString.equals("2")) {
			filter.set("matgrp_s", "in:221001,221002");
		}
		//根据厂区获取全部物料
		List<Map<String,Object>> resList = sortstorageitemSrv.getPartsDatagrid(filter);
		return GsonTools.toJson(resList);
	}

    @Log(code="ZJ_BZGL_PFGG_SAVE_CHANGES2",value="保存数据至表格",target=LogType.DB)
    @ResponseBody
	@RequestMapping("saveInfo")
    public Response saveInfo(String[] list,String type) throws Exception{
    	//type:0删除，1保存
    	if(list==null){
    		return null;
    	}
    	 if(sortstorageitemSrv.saveChanges2(list,type)){
    		 return Response.suc();
    	 }
    	 return null;
    }

    @Log(value = "根据品号获取质量等级信息", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("exitMaterialCode")
   	public String exitMaterialCode(String materialCode) {
   		List<Map<String,Object>> list = sortstorageitemSrv.findExitGradeCode(materialCode);
   		return toJson(list);
   	}
    @Log(value = "根据物料编码，等级获取机台信息", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("exitEntCode")
   	public String exitEntCode(String materialCode,String gradeCode) {
   		List<Map<String,Object>> list = sortstorageitemSrv.findExitEntCode(materialCode,gradeCode);
   		return toJson(list);
   	}
    @Log(value = "根据品号查询出没有维护的质量等级编码", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("noSelectGradeCode")
   	public String exitEntCode(String itemid_s) {
   		List<Map<String,Object>> list = sortstorageitemSrv.findnoSelectGradeCode(itemid_s);
   		return toJson(list);
   	}
    @Log(value = "根据品号,等级查询出没有维护的设备新选", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("noSelectTracknoCode")
   	public String noSelectTracknoCode(String itemid_s,String gradecode) {
   		List<Map<String,Object>> list = sortstorageitemSrv.findnoSelectTracknoCode(itemid_s,gradecode);
   		return toJson(list);
   	}
}
