/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;
import com.bluebirdme.mes.linglong.common.entity.dto.CoreDictionaryDTO;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
/**
 * 数据字典表
 * 
 * @author 高飞
 * @Date 2018-08-08 13:40:24
 */
@Log(code = "DICT", value = "字典管理")
@RestController
@RequestMapping("/dict/")
public class CoreDictionaryController extends RockWellFunctionalController<CoreDictionary> {

	@Resource
	CoreDictionaryServiceImpl dictSrv;
	@Override
	protected RockWellBaseServiceImpl<CoreDictionary> getService() {
		return dictSrv;
	}

	@NoLogin
	@RequestMapping("{codes}.js")
	public String json(@PathVariable("codes") String codes[]) {
		response.setHeader("Content-Type", "application/javascript;charset=UTF-8");
		Map<String, Object> dict = dictSrv.keyValuePair(codes);
		return "var SYS_DICT=" + toJson(dict) + ";\n function dictFormat(code){return SYS_DICT[code];}\n" + "console.clear();\n" + "console.log(\"字典类别:" + Arrays.toString(codes) + "\");\n" + "console.log(\"共:" + dict.size() + " 个键值对\");\n" + "console.log(\"使用方法:\");\n"
				+ "console.log(\"方式一：var text=SYS_DICT[224003]\");\n" + "console.log(\"方式二：var text=dictFormat(224003)\");\n";
	}

	@RequestMapping("code/{code}")
	public String dict(@PathVariable("code") String code) throws IllegalArgumentException, IllegalAccessException {
		return toJson(dictSrv.treeWithoutRoot(code));
	}

	@RequestMapping("tree")
	public String dict(Long id) {
		List<CoreDictionary> list = null;
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
		if (id == null) {
			Where w = new Where();
			w.andIsNull("pid_i");
			list = dictSrv.findByWhere(w);


			Map<String, Object> root = new HashMap<String, Object>();
			root.put("id", -1);
			root.put("text", "数据字典");
			root.put("code", "");

			Map<String, Object> map = new HashMap<String, Object>();
			for (CoreDictionary dict : list) {
				map = new HashMap<String, Object>();
				map.put("id", dict.getAtr_key());
				map.put("text", dict.getText());
				map.put("code", dict.getDictcode_s());
				map.put("state", "closed");
				children.add(map);
			}
			root.put("children", children);
			ret.add(root);
		} else {
			list = dictSrv.findByField("pid_i", id);
			Map<String, Object> map = new HashMap<String, Object>();
			for (CoreDictionary dict : list) {
				map = new HashMap<String, Object>();
				map.put("id", dict.getAtr_key());
				map.put("text", dict.getText());
				map.put("code", dict.getDictcode_s());
				map.put("state", "closed");
				ret.add(map);
			}
		}
		Collections.sort(ret,new Comparator<Map<String,Object>>(){
			@Override
			public int compare(Map<String,Object>m1,Map<String,Object>m2){
				return m1.get("code").toString().compareTo(m2.get("code").toString());
			}
		});
		return toJson(ret);
	}

	@Log(code = "DICT_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody CoreDictionaryDTO coredictionary) throws Exception {
		List<String> repeatCodes = dictSrv.saveChanges(coredictionary);
		if (!ListUtils.isEmpty(repeatCodes)) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复", repeatCodes);
		}
		return Response.suc();
	}
}
