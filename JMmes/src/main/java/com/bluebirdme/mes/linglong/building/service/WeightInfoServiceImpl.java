/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.DoubleProduction;
import com.bluebirdme.mes.linglong.building.entity.UpdateWorkOrderResultReport;
import com.bluebirdme.mes.linglong.building.entity.WorkOrderResultReport;
import com.bluebirdme.mes.linglong.building.entity.WorkorderResult;
import com.bluebirdme.mes.linglong.building.entity.dto.UpdateWorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.entity.dto.WorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;
import com.bluebirdme.mes.linglong.curing.service.MesSapProductionServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 成型胎胚重量合格率（机台）
 * 
 * @author 栾和源
 * @Date 2020-01-15 11:22:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WeightInfoServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	// 系统参数获取
	@Resource
	SerialServiceImpl serialSrv;

	@Resource
	LingLongDataSource llds;
	// ERP抛帐表
	@Resource
	MesSapProductionServiceImpl mesSapProductionServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return WorkorderResult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	
	/**
	 * 通过工艺配方查出胎胚重量公差参数
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getWeightData() {
		SQLQuery query = createSQLQuery(getSQL("getWeightData"));
		System.out.println(getSQL("getWeightData").toString());
		return query.list();
	}
	
	
	/**
	 * 统计胎坯重量合格率
	 * 
	 * @return
	 */

	public List<Map<String, Object>> getWeightPercent(String begin_time,String end_time,String equip_code_s,String material_code_s,String max_weight_s,String min_weight_s) {
		SQLQuery query = createSQLQuery(getSQL("getWeightPercent"));
		query.setParameter("begintime", begin_time);
		query.setParameter("endtime", end_time);
		query.setParameter("equip_code_s", equip_code_s);
		query.setParameter("material_code_s", material_code_s);
		query.setParameter("max_weight_s", max_weight_s);
		query.setParameter("min_weight_s", min_weight_s);
		
		System.out.println(getSQL("getWeightPercent").toString());

		return query.list();
	}
	
	/**
	 * 根据物料编码查物料名称
	 * 
	 * @return
	 */

	public List<Map<String, Object>> getMaterialName(String begin_time,String end_time,String material_code_s) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialName"));
		query.setParameter("begintime", begin_time);
		query.setParameter("endtime", end_time);
		query.setParameter("material_code_s", material_code_s);
		System.out.println(getSQL("getWeightPercent").toString());

		return query.list();
	}
	

	/**
	 * 查询胎胚信息数据
	 */

	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
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

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	
}
