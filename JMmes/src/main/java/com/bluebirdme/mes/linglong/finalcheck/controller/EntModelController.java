/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.EntModelServiceImpl;

/**
 * 质检设备信息表（工厂模型表） Title: EntModelController
 * 
 * @author penga_liu
 * @Date 2019年9月2日 下午2:42:56
 */
@Log(code = "ZJ_JCGL_SB", value = "质检设备信息表日志")
@RestController
@RequestMapping("finalcheck/baseData/entmodel")
public class EntModelController extends RockWellFunctionalUDAController<Object> {

	@Resource
	EntModelServiceImpl entSrv;

	@Override
	protected RockWellUDABaseServiceImpl<Object> getService() {
		return entSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return entSrv;
	}

	@Log(code = "ZJ_JCGL_SB_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO ent) throws Exception {
		entSrv.saveChanges(ent);
		return Response.suc();
	}

	@Log(code = "ZJ_JCGL_SB_entBarcodeExit", value = "判断设备条码是否存在", target = LogType.CONSOLE)
	@RequestMapping("entBarcodeExit")
	public String entBarcodeExit(String entBarcode) throws Exception {
		List<Map<String, Object>> list = entSrv.entBarcodeExit(entBarcode);
		return toJson(list);
	}

	@Log(code = "ZJ_JCGL_SB_FORCED", value = "强制自动", target = LogType.CONSOLE)
	@RequestMapping("forced")
	public Response forced(Long[] ids, String foreType) throws Exception {
		entSrv.forced(ids, foreType);
		return Response.suc();
	}

	@Log(code = "SearchEnt", value = "机台下拉框", target = LogType.CONSOLE)
	@RequestMapping("SearchEnt")
	public String SearchEnt(String equip_type) throws Exception {
		List<Map<String, Object>> list = entSrv.SearchEnt(equip_type);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("DESCRIPTION", "全部");
		map.put("EQUIP_NAME", "");
		list.add(map);
		return toJson(list);
	}
}
