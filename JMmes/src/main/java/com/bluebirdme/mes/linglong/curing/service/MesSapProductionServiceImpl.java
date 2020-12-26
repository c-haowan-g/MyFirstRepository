/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;

/**
 * 产量固化与SAP抛帐
 * 
 * @author 时永良
 * @Date 2019-8-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MesSapProductionServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MesSapProduction.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	/**
	 * 版本更改
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param materialCodelist
	 *            要进行固化的物料编码数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveVersion(List<MesSapProduction> list) throws Exception {
		String pro_version_s_new=null;
		String atr_key=null;
		boolean flag = false;
		for (MesSapProduction item : list) {
			pro_version_s_new=item.getPro_version_s();
			atr_key=String.valueOf(item.getAtr_key());
			String updateVersiontSql = String.format(
					"update AT_INT_SAP_MESSAPPRODUCTION set pro_version_s = '%s'"
							+ " where atr_key = '%s' ",
							pro_version_s_new,atr_key);
			RockWellUtils.execSQL(updateVersiontSql);
			flag = true;
		}
		if(flag){
			return "操作成功";
		}
		return "操作失败";
	}
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> searchBy(Filter filter) throws Exception {
		if (getSQL("searchBy") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchBy的SQL语句定义");
		filter.set("s_factory_s", LLWebUtils.factory());
		String dataSql = getSQL("searchBy", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
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
}
