package com.bluebirdme.mes.linglong.curing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CuringMoldServiceImpl;
import com.print.client.PrintResponse;
import com.print.client.WebPrintService;
import com.print.client.WebPrintServiceService;

/**
 * @author 李迺锟
 * 
 * @Date 2018年7月20日 上午11:06:50
 */
@Log(code = "LH_EM_CURINGMOLD", value = "模具信息维护")
@RestController
@RequestMapping("curing/moldmanagement/curingmold")
public class CuringMoldController  extends RockWellFunctionalUDAController<Object> {
	// 模具信息维护
	@Resource
	CuringMoldServiceImpl curingMoldServiceImpl;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return curingMoldServiceImpl;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return curingMoldServiceImpl;
	}
	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getCuringMold")
	public String datagrid(Filter filter, Page page, Class clazz) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	/**
	 * 
	 * @Title: saveChanges
	 * @Description: TODO(增删改)
	 * @return: Response 返回类型
	 * @throws Exception
	 * 
	 */
	@RequestMapping("saveAll")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (curingMoldServiceImpl.save2(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复", rockWellEntityDTO);
		}
		return Response.suc();
	}

	/**
	 * 
	 * @Title: getErpCode
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getErpCode")
	public String getErpCode(@RequestBody String dictcode_s) throws Exception {
		String data = curingMoldServiceImpl.getErpCode(dictcode_s);
		return toJson(data);
	}

	/**
	 * 
	 * @Title: CheckMoldCode
	 * @Description: TODO(验证模具条码)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("CheckMoldCode")
	public String CheckMoldCode(String mold_code) throws Exception {
		int data = curingMoldServiceImpl.CheckMoldCode(mold_code);
		return toJson(data);
	}

	/**
	 * 
	 * @Title: comboxMoldspec
	 * @Description: TODO(查询模具规格)
	 * @return: String 返回类型
	 * 
	 */
	@Log(code = "comboxMoldspec", value = "查询模具规格")
	@RequestMapping("comboxMoldspec")
	public String comboxMoldspec() throws Exception {
		List<Map<String, Object>> list = curingMoldServiceImpl.comboxMoldspec();
		return toJson(list);
	}

	/**
	 * 下拉框花纹
	 * 
	 * @Title: comboxPattern
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("comboxPattern")
	public String comboxPattern() throws Exception {
		List<Map<String, Object>> list = curingMoldServiceImpl.comboxPattern();
		return toJson(list);
	}
	@RequestMapping("comboxCJ")
	public String comboxCJ() throws Exception {
		List<Map<String, Object>> list = curingMoldServiceImpl.comboxCJ();
		return toJson(list);
	}
	@Log(code = "getCjBySpecandPatt", value = "根据规格花纹查询层级信息")
	@RequestMapping("getCjBySpecandPatt")
	public String getCjBySpecandPatt(String thspec_s,String patt) throws Exception {
		List<Map<String, Object>> list = curingMoldServiceImpl.getCjBySpecandPatt(thspec_s,patt);
		return toJson(list);
	}
	
	/**
	 * 
	 * @Title: comboxMoldLocation
	 * @Description: TODO(查询模具库位)
	 * @return: String 返回类型
	 * 
	 */
	@Log(code = "comboxMoldLocation", value = "查询模具库位")
	@RequestMapping("comboxMoldLocation")
	public String comboxMoldLocation() throws Exception {
		List<Map<String, Object>> list = curingMoldServiceImpl.comboxMoldLocation();
		return toJson(list);
	}

	/**
	 * 
	 * @Title: getPattByspec
	 * @Description: TODO(规格查花纹)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getPattByspec")
	public String getPattByspec(String thspec_s) throws Exception {
		List<Map<String, Object>> data = curingMoldServiceImpl.getPattByspec(thspec_s);
		return toJson(data);
	}

	/**
	 * 
	 * @Title: getSpecBypatt
	 * @Description: TODO(花纹查规格)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getSpecBypatt")
	public String getSpecBypatt(@RequestBody String patt) throws Exception {
		List<Map<String, Object>> data = curingMoldServiceImpl.getSpecBypatt(patt.replace("\"", ""));
		return toJson(data);
	}

	/**
	 * 接收前端选择的数据，调用服务接口，打印模具条码
	 * 
	 * @Title: printBarCode
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("printBarCode")
	public String printBarCode(@RequestBody String barCodeList) throws Exception {
		// 数据处理，去掉\及两端引号
		barCodeList = barCodeList.replace("\\", "");
		barCodeList = barCodeList.substring(1, barCodeList.length()); // 去掉第一个 "
		barCodeList = barCodeList.substring(0, barCodeList.length() - 1); // 去掉最后一个
		Map<String, Object> maplist = JSON.parseObject(barCodeList);
		List<Object> objs = (List<Object>) maplist.get("barCodeList");
		Map map = new HashMap();
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		for (Object obj : objs) {
			Map<String, Object> newparams = new HashMap<String, Object>();
			Map<String, Object> params = JSON.parseObject(obj.toString());
			newparams.put("barcode", params.get("mold_code_s"));
			listmap.add(newparams);
		}
		map.put("list", listmap);
		JSONObject json = new JSONObject(map);

		// 调用打印服务接口
		WebPrintServiceService service = new WebPrintServiceService();
		WebPrintService hs = service.getWebPrintServicePort();
		// 数据库定义的模具条码打印代号
		String fileCode = "MJDY0001";

		PrintResponse response = hs.printInvoke(fileCode, json.toString());
		if (response.isSuccess()) {
			System.out.println("打印成功................." + response.getMessage());
			return "1";
		} else {
			System.out.println("打印失败................." + response.getMessage());
			return "0";

		}

	}
}
