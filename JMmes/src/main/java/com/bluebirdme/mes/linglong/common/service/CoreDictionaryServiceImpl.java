/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.dom4j.DocumentException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;
import com.bluebirdme.mes.linglong.common.entity.dto.CoreDictionaryDTO;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.XmlfilterUtil;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 数据字典表
 * 
 * @author 高飞
 * @Date 2018-08-08 13:40:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CoreDictionaryServiceImpl extends RockWellBaseServiceImpl<CoreDictionary> {

	public final Map<String, String> keyValues = new HashMap<String, String>();
	public final Map<String, String> keyNames = new HashMap<String, String>();

	public String value(String key) {
		if (!keyValues.containsKey(key)) {
			Where where = new Where();
			where.andEqual("dictcode_s", key);
			CoreDictionary dict = unique(where);

			if (dict == null) {
				return null;
			}

			keyValues.put(dict.getDictcode_s(), dict.getErpcode_s());
		}
		return keyValues.get(key);
	}

	public String name(String key) {
		if (!keyNames.containsKey(key)) {
			Where where = new Where();
			where.andEqual("dictcode_s", key);
			CoreDictionary dict = unique(where);
			if (dict == null) {
				return null;
			}
			keyNames.put(dict.getDictcode_s(), dict.getErpcode_s());
		}
		return keyNames.get(key);
	}

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CoreDictionary.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public Map<String, Object> keyValuePair(String... codes) {

		Map<String, Object> kvp = new HashMap<String, Object>();

		Where where = null;

		for (String code : codes) {
			where = new Where();
			where.andStartWith("dictcode_s", code.replace("-", ""));
			where.andEqual("deleted_i", 0);
			for (CoreDictionary child : findByWhere(where)) {
				switch (LanguageProvider.getLanguage()) {
				case "zh":
					kvp.put(code.startsWith("-") ? child.getErpcode_s() : child.getDictcode_s(), child.getDictname_s());
					break;
				case "en":
					kvp.put(code.startsWith("-") ? child.getErpcode_s() : child.getDictcode_s(),
							child.getDictname_en_s());
					break;
				case "th":
					kvp.put(code.startsWith("-") ? child.getErpcode_s() : child.getDictcode_s(),
							child.getDictname_th_s());
					break;
				default:
					kvp.put(code.startsWith("-") ? child.getErpcode_s() : child.getDictcode_s(), child.getDictname_s());
					break;
				}
			}
		}

		return kvp;
	}

	public List<Map<String, Object>> treeWithoutRoot(String code) throws IllegalArgumentException,
			IllegalAccessException {

		Map<String, Object> ret = new HashMap<String, Object>();

		CoreDictionary dict = unique("dictcode_s", code.replace("-", ""));

		if (dict == null || dict.getDeleted_i() == 1) {
			return new ArrayList<Map<String, Object>>();
		}

		List<CoreDictionary> list = new ArrayList<CoreDictionary>();

		Where where = new Where();
		where.andStartWith("dictcode_s", code.replace("-", ""));
		where.andEqual("deleted_i", 0);

		list = findByWhere(where);

		/*
		 * ret = new HashMap<String,Object>(); ret.put("id",
		 * dict.getDictcode_s()); ret.put("text",
		 * dict.getText(LanguageProvider.getLanguage())); ret.put("code",
		 * dict.getDictcode_s()); ret.put("children", children(dict,list));
		 */

		return children(code, dict, list);
	}

	public Map<String, Object> tree(String code) throws IllegalArgumentException, IllegalAccessException {

		Map<String, Object> ret = new HashMap<String, Object>();

		CoreDictionary dict = unique("dictcode_s", code);

		if (dict == null || dict.getDeleted_i() == 1) {
			return ret;
		}

		List<CoreDictionary> list = new ArrayList<CoreDictionary>();

		Where where = new Where();
		where.andStartWith("dictcode_s", code);
		where.andEqual("deleted_i", 0);

		list = findByWhere(where);

		ret = new HashMap<String, Object>();
		ret.put("id", dict.getDictcode_s());
		ret.put("text", dict.getText(LanguageProvider.getLanguage()));
		ret.put("code", dict.getDictcode_s());
		ret.put("children", children(code, dict, list));

		return ret;
	}

	private List<Map<String, Object>> children(String rootCode, CoreDictionary dict, List<CoreDictionary> list)
			throws IllegalArgumentException, IllegalAccessException {

		List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();

		Map<String, Object> child = null;

		if (dict == null || dict.getDeleted_i() == 1) {
			return children;
		}

		if (list.size() == 0) {
			return children;
		}

		for (CoreDictionary _dict : list) {
			if (_dict.getPid_i() != null && _dict.getPid_i().longValue() == dict.getAtr_key().longValue()) {
				child = new HashMap<String, Object>();
				child.put("id", rootCode.startsWith("-") ? _dict.getErpcode_s() : _dict.getDictcode_s());
				child.put("text", _dict.getText(LanguageProvider.getLanguage()));
				child.put("code", rootCode.startsWith("-") ? _dict.getErpcode_s() : _dict.getDictcode_s());
				child.put("children", children(rootCode, _dict, list));
				children.add(child);
			}
		}

		return children;
	}

	/**
	 * 保存字典类别的增删改信息
	 * 
	 * @author Goofy
	 * @Date 2018年7月3日 上午9:25:46
	 * @param dictDTO
	 * @throws Exception
	 */
	@RockWellTransactional
	public List<String> saveChanges(CoreDictionaryDTO dictDTO) throws Exception {

		Filter filter = new Filter();
		Page page = new Page();
		// String url = "";
		// filter.set("configkey", "QueryXMLParamter");
		// List<Map<String, Object>> list =this.datagridRowsUDA(filter, page);
		// url=list.get(0).get("configvalue").toString();
		//
		List<String> repeatCodes = new ArrayList<String>();
		if (!ListUtils.isEmpty(dictDTO.getUpdated())) {
			for (CoreDictionary dict : dictDTO.getUpdated()) {
				if (exist("dictcode_s", dict.getDictcode_s(), dict.getAtr_key())) {
					repeatCodes.add(dict.getDictcode_s());
				}
				dict.setChanged_by_s(WebUtils.getUserName());
				dict.setChanged_time_t(new Date());
			}
		}
		if (!ListUtils.isEmpty(dictDTO.getInserted())) {
			for (CoreDictionary dict : dictDTO.getInserted()) {
				if (exist("dictcode_s", dict.getDictcode_s())) {
					repeatCodes.add(dict.getDictcode_s());
				}
				dict.setCreated_by_s(WebUtils.getUserName());
				dict.setCreated_time_t(new Date());

				// File file=new File(url+"/parameter.xml");
				//
				//
				// //如果文件存在 就获得它的根节点
				// if(file.exists()){
				// List<Map<String, String>> listMaps=
				// queryXMLToList(dict.getDictname_en_s());
				// if(listMaps.size()==0){
				// XmlfilterUtil.add(url, dict.getDictname_en_s(),
				// dict.getDictcode_s(), dict.getDictname_s());
				// }
				// }else {//如果文件不存在
				// XmlfilterUtil.write(url, dict.getDictname_en_s(),
				// dict.getDictcode_s(), dict.getDictname_s());
				// }
			}

		}

		if (!ListUtils.isEmpty(repeatCodes)) {
			return repeatCodes;
		}

		if (!ListUtils.isEmpty(dictDTO.getDeleted())) {
			for (CoreDictionary dict : dictDTO.getDeleted()) {
				dict.setDeleted_i(1);
			}
			update(dictDTO.getDeleted());
		}

		if (!ListUtils.isEmpty(dictDTO.getUpdated())) {
			update(dictDTO.getUpdated());
		}
		if (!ListUtils.isEmpty(dictDTO.getInserted())) {
			save(dictDTO.getInserted());
		}

		return repeatCodes;
	}

	/**
	 * 周清玉 查询xml生成路径
	 * 
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	/**
	 * 周清玉 查询XML文件并返回List<Map<String,String>> code 需要查询的节点
	 * --在本项目中是用了数据字典的英文作为xml节点的
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> queryXMLToList(String code) throws Exception {
		Filter filter = new Filter();
		Page page = new Page();
		String url = "";
		filter.set("configkey", "QueryXMLParamter");
		List<Map<String, Object>> list = this.datagridRowsUDA(filter, page);
		url = list.get(0).get("configvalue").toString();

		String xml = "";
		List<Map<String, String>> listMap = null;
		try {
			xml = XmlfilterUtil.getXml(url + "/parameter.xml");
			if (xml != null && xml.length() > 0) {
				listMap = XmlfilterUtil.resolveXmlToMapList(xml, code);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return listMap;
	}

}
