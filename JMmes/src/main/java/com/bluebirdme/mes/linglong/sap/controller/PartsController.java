/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.service.PartsServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.dto.UdaDto;

/**
 * Part基础物料
 * 
 * @author 周清玉
 * @Date 2019-06-21
 * */
@Log(code = "PartLog", value = "Part基础物料日志")
@RestController
@RequestMapping("Part")
public class PartsController extends RockWellFunctionalUDAController<Object> {

	@Resource
	PartsServiceImpl partSrv;

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return partSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return partSrv;
	}

	@ResponseBody
	@RequestMapping("datagridUDA_Ping")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(partSrv.datagridUDA(filter, page));
	}

	@Log(code = "PartLog_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody UdaDto udaDto) throws Exception {
		partSrv.saveChanges(udaDto);
		return Response.suc();
	}

	/**
	 * 根据物料编码得到物料信息
	 * 
	 * @param partNumber
	 *            物料编码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchByMaterialCode")
	public String searchByMaterialCode(String partNumber) throws Exception {
		// Part part = null;
		String part = null;

		if (partNumber == null || partNumber.equals("undefined")) {
			return toJson(null);
		} else {

			if (partNumber.length() != 9) {
				String nunber = partNumber.substring(0, partNumber.indexOf("("));
				// part =
				// partSrv.getPartByCode(nunber);//通过模型表API查询，存在查询时间慢的问题，所以临时改成SQL查询
				part = partSrv.getPartByCode2(nunber);// 通过模型表SQL查询
			} else {
				// part =
				// partSrv.getPartByCode(partNumber);//通过模型表API查询，存在查询时间慢的问题，所以临时改成SQL查询
				part = partSrv.getPartByCode2(partNumber);// 通过模型表SQL查询
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("MatDescFull", part);
			return toJson(map);
		}

	}

	/**
	 * 
	 * 胎胚物料信息 周清玉 2019年5月15日
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("halbMaterialList")
	public String halbMaterialList() throws Exception {
		List<Map<String, Object>> list = partSrv.halbMaterialList();
		return toJson(list);
	}
	
	/**
	 * 
	 * 胎胚物料信息--成型日计划 whl 2019年12月16日
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("halbMaterialListForDay")
	public String halbMaterialListForDay() throws Exception {
		List<Map<String, Object>> list = partSrv.halbMaterialListForDay();
		return toJson(list);
	}

	@Log(code = "getPartsDatagrid", value = "过滤获取外胎物料")
	@ResponseBody
	@RequestMapping("getPartsDatagrid")
	public String getPartsDatagrid(Filter filter, Page page, String filterRules) throws Exception {
		String factoryString = LLWebUtils.factory();
		if (factoryString.equals("1")) {
			filter.set("matgrp_s", "in:211001,211003");
		}
		if (factoryString.equals("2")) {
			filter.set("matgrp_s", "in:221001,221002");
		}
		//根据厂区获取全部物料
		return GsonTools.toJson(partSrv.getPartsDatagrid(filterRules, filter, page));
	}
	/**
	 * 半部件
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	@RequestMapping("getAllMaterialGroupList")
	public String getAllMaterialGroupList()throws Exception {
		List<Map<String, Object>> getAllMaterialGroupList = partSrv.getAllMaterialGroupList();
		return toJson(getAllMaterialGroupList);
	}
	
	/**
	 * 半部件
	 * 获取半部件模块用的物料组
	 * 兰颖慧
	 * 2019年4月17日
	 * @return
	 */
	@RequestMapping("getMaterialGroupList")
	public String getMaterialGroupList()throws Exception {
		List<Map<String, Object>> getMaterialGrouplist = partSrv.getMaterialGroupList();
		return toJson(getMaterialGrouplist);
	}
}
