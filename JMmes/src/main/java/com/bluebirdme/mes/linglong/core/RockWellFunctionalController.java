package com.bluebirdme.mes.linglong.core;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.base.entity.BaseEntity;
import com.bluebirdme.core.system.base.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 抽象出业务的公共方法
 * @author Goofy 252887950@qq.com www.xdemo.org
 * @Date 2017年9月5日 下午5:29:22
 */
public abstract class RockWellFunctionalController<T> extends BaseController<T>{
	
	public Object idValue(T t){
		return ((RockWellBaseEntity)t).getAtr_key();
	}
	
	public String idField() {
		return "id";
	}
	
	/**
	 * ExcelFormatter
	 */
	public Map<String,Class<? extends IExcelValueFormatter>> formatter=new HashMap<String, Class<? extends IExcelValueFormatter>>(); 

	protected abstract RockWellBaseServiceImpl<T> getService();

	@Log(value = "保存或更新信息", code = "FUNC_001", target = LogType.DB)
	@ResponseBody
	@RequestMapping("save")
	public Response save(T t) throws Exception {
		if (idValue(t) != null) {
			getService().update(t);
		} else {
			getService().save(t);
		}
		return Response.suc(t);
	}

	@Log(value = "删除信息", code = "FUNC_003", target = LogType.DB)
	@ResponseBody
	@RequestMapping("delete")
	public Response delete(String ids) {
		getService().delete(ids);
		return Response.suc();
	}

	@Log(value = "根据ID查询信息", code = "FUNC_005", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("{id}")
	public Response findById(@PathVariable("id") Long id) {
		return Response.suc(getService().findById(id));
	}

	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, null));
	}

	@Log(value = "信息列表查询", code = "FUNC_008", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid/filterRow")
	public String datagrid(String filterRules,Filter filter, Page page, String sort, String order) throws Exception {
		if (!StringUtils.isEmpty(filterRules)) {
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(filterRules).getAsJsonArray();
			FilterRule rule = null;
			Gson gson = new Gson();
			for (JsonElement obj : array) {
				rule = gson.fromJson(obj, FilterRule.class);
				//op:支持 contains,beginwith,endwith	| 不支持equal,notequal,less,lessorequal,greater,greaterorequal
				filter.set(rule.getField(), rule.getOp()+":"+rule.getValue());
			}
		}
		if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
			filter.setSort(sort);
			filter.setOrder(order);
		}
		return GsonTools.toJson(getService().datagrid(filter, page, null));
	}

	public ModelAndView view(String page, ModelMap model) {
		return new ModelAndView(page, model);
	}
	
}
