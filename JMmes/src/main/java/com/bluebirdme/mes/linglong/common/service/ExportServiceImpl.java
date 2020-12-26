package com.bluebirdme.mes.linglong.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 导出下拉框文本转换
 * 
 * @author 刘朋
 * @Date 2018-08-09 14:32:07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExportServiceImpl extends RockWellBaseServiceImpl<T> {
	private List<Map<String, Object>> dictAllMap;// 接收基础数据字典
	private List<Map<String, Object>> userAllMap;// 接收用户信息
	private List<Map<String, Object>> buringMap;// 接收硫化机台信息
	private List<Map<String, Object>> zjMachineMap;// 接收终检机台信息

	/**
	 * ，查询基础数据字典全
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getDictMap() {
		SQLQuery query = createSQLQuery(getSQL("getDictnameAll"));
		dictAllMap = query.list();
		return dictAllMap;
	}

	/**
	 * 查询用户字典全
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getUserMap() {
		SQLQuery queryuser = createSQLQuery(getSQL("getUsernameAll"));
		userAllMap = queryuser.list();
		return userAllMap;
	}

	/**
	 * 查询硫化机台信息
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getBuringMap() {

		SQLQuery query = createSQLQuery(getSQL("getBuringNameAll"));
		String factory = LLWebUtils.factory();
		query.setParameter("s_factory_s", factory);
		buringMap = query.list();
		return buringMap;
	}

	/**
	 * 查询终检机台信息
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getZJMachineMap() {

		SQLQuery query = createSQLQuery(getSQL("getZJMachineNameAll"));
		String factory = LLWebUtils.factory();
		query.setParameter("s_factory_s", factory);
		zjMachineMap = query.list();
		return zjMachineMap;
	}

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return null;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 
	 * @Title: getDictname
	 * @Description: TODO(数据字典，导出下拉框文本转换)
	 * @return: String 返回类型
	 * 
	 */

	@SuppressWarnings("unchecked")
	public String getDictname(String dictcode) throws Exception {
		if(dictcode==null){
			return"";
		}
		SQLQuery query = getSession().createSQLQuery(getSQL("getDictname"));
		query.setParameter("dictcode", dictcode);
		return (String) query.uniqueResult();
	}

	/**
	 * 根据基础数据字典code获取name
	 * 
	 * @param dictCode
	 *            基础数据字典code
	 * @return dictname
	 */
	@SuppressWarnings("unused")
	public String getDictName(String dictCode) {
		if(dictCode==null){
			return"";
		}
		String result = null;
		if (dictAllMap == null) {
			dictAllMap = getDictMap();
		}
		for (int i = 0; i < dictAllMap.size(); i++) {
			if (dictAllMap.get(i).get("DICTCODE_S").equals(dictCode)) {
				result = dictAllMap.get(i).get("DICTNAME").toString();
				break;
			} else {
				result = "";
			}
		}
		return result;
	}

	/**
	 * 根据用户代码获取用户名称 lcm刘程明样式
	 * 
	 * @param userCode
	 *            用户代码
	 * @return 用户名称 lcm刘程明样式
	 */
	@SuppressWarnings("unused")
	public String getUserName(String userCode) {
		if(userCode==null){
			return"";
		}
		String result = null;
		if (userAllMap == null) {
			userAllMap = getUserMap();
		}
		for (int i = 0; i < userAllMap.size(); i++) {
			if (userAllMap.get(i).get("USERCODE").equals(userCode)) {
				result = userAllMap.get(i).get("USERNAME").toString();
				break;
			} else {
				result = "";
			}
		}
		return result;
	}

	/**
	 * 
	 * @Title: getBuringName
	 * @Description: TODO(根据硫化机台条码获取硫化机台名称)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unused")
	public String getBuringName(String buringcode) {
		if(buringcode==null){
			return"";
		}
		String result = null;
		if (buringMap == null) {
			buringMap = getBuringMap();
		}
		for (int i = 0; i < buringMap.size(); i++) {
			if (buringMap.get(i).get("EQUIP_CODE_S").equals(buringcode)) {
				result = buringMap.get(i).get("EQUIP_NAME_S").toString();
				break;
			} else {
				result = "";
			}
		}
		return result;
	}

	/**
	 * 
	 * @Title: getBuringName
	 * @Description: TODO(根据硫化机台条码获取硫化机台名称)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unused")
	public String getZJMachineName(String zjmachinecode) {
		if(zjmachinecode==null){
			return"";
		}
		String result = null;
		if (zjMachineMap == null) {
			zjMachineMap = getZJMachineMap();
		}
		for (int i = 0; i < zjMachineMap.size(); i++) {
			if (zjMachineMap.get(i).get("ENTBARCODE_S").equals(zjmachinecode)) {
				result = zjMachineMap.get(i).get("ENTNAME_S").toString();
				break;
			} else {
				result = "";
			}
		}
		return result;
	}
}
