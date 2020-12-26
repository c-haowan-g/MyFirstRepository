/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import client.LZMESFLUSHPRODUCT;
import client.LZMESPRODUCT;
import client.HALFSTEELLZMESPRODUCT;
import client.HALFSTEELLZMESFLUSHPRODUCT;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDdetail;
import com.bluebirdme.mes.linglong.curing.entity.WorkOrderResult;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.lhqx.ArrayOfanyType;
import com.lhqx.PIReturnObject;
import com.lhqx.WSImplement;
import com.lhqx.WSInterface;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 生产明细查询
 * 
 * @author 时永良
 * @Date 2018-09-10 11:45:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkOrderResultServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	// 系统参数获取
	@Resource
	SerialServiceImpl serialSrv;

	// 硫化ERP抛帐表
	@Resource
	MesSapProductionServiceImpl mesSapProductionServiceImpl;

	// 硫化报产冲产明细表
	@Resource
	ProductionDdetailServiceImpl productionDdetailServiceImpl;

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return WorkOrderResult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	/**
	 * 页面初始化查询
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> datagridTwo(Filter filter, Page page) throws Exception {

		/*
		 * String FACTORY = "s_factory_s";
		 * 
		 * if (!filter.getFilter().containsKey(FACTORY)) { try {
		 * filter.set("s_factory_s", LLWebUtils.factory()); } catch (Exception
		 * e) { throw new
		 * Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录"); } }
		 */

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsTwo(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalTwo(filter, page));
		return ret;
	}

	/**
	 * 页面初初始化查询
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsTwo(Filter filter, Page page) throws Exception {
		if (filter.getFilter().containsKey("tyre_barcode_s")) {
			filter.set("begin_mold_checktime", "");
			filter.set("end_mold_checktime", "");
		}
		if (getSQL("datagrid_rowsTwo") == null) {
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rowsTwo的SQL语句定义");
		}
		if (LLWebUtils.factory().equals("1")) {
			filter.set("s_factory_s", "1");
		} else {
			filter.set("s_factory_s", "2");
		}
		String dataSql = getSQL("datagrid_rowsTwo", filter.getFilter());
		System.out.println(dataSql);
		SQLQuery query = createSQLQuery(dataSql);
		//20201026 添加查询条件，模具编码 王超
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

	public Long datagridTotalTwo(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_totalTwo") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_totalTwo的SQL语句定义");

		String totalSql = getSQL("datagrid_totalTwo", filter.getFilter());
		
		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			//20201026 添加查询条件，模具编码 王超
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 机台编码的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByEquipCode() {
		SQLQuery query = createSQLQuery(getSQL("searchByEquipCode"));
		query.setParameter("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 物料编码的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterial() {
		SQLQuery query = createSQLQuery(getSQL("searchByMaterial"));
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 硫化曲线数据的查询
	 * 
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings({ "unchecked", "null" })
	public List<Map<String, Object>> lhqx(Map<String, Object> map) throws ParseException {
		// 全钢曲线服务
		PIReturnObject rbwdvalue = null;
		PIReturnObject rhwdvalue = null;
		PIReturnObject nyvalue = null;
		PIReturnObject nwvalue = null;
		PIReturnObject bxvalue = null;
		WSInterface portType = null;
		// 半钢曲线服务
		com.bglhqx.PIReturnObject bg_rbwdvalue = null;
		com.bglhqx.PIReturnObject bg_rhwdvalue = null;
		com.bglhqx.PIReturnObject bg_nyvalue = null;
		com.bglhqx.PIReturnObject bg_nwvalue = null;
		com.bglhqx.PIReturnObject bg_bxvalue = null;
		com.bglhqx.WSInterface bg_portType = null;
		if (LLWebUtils.factory().equals("1")) {
			WSImplement service = new WSImplement();
			portType = service.getBasicHttpBindingWSInterface();
		} else if (LLWebUtils.factory().equals("2")) {
			com.bglhqx.WSImplement service = new com.bglhqx.WSImplement();
			bg_portType = service.getBasicHttpBindingWSInterface();
		}
		String codes = null;
		String jth = null;
		String rbwd = null;// 热板温度数据点
		String rhwd = null;// 热环温度数据点
		String ny = null;// 内压数据点
		String nw = null;// 内温数据点
		String bx = null;// 步序
		String equip_code_s = map.get("equip_code_s").toString();// 获取机台编码
		if (equip_code_s.substring(3, 4) != null) {
			codes = equip_code_s.substring(3, 4);
			jth = equip_code_s.substring(3, 6);
			String position = equip_code_s.substring(6);
			if (LLWebUtils.factory().equals("2")) {
				if (position.equals("L")) {
					// if (codes.equals("G") || codes.equals("H") ||
					// codes.equals("I") || codes.equals("J")
					// // || codes.equals("K") || codes.equals("L")) {
					// rbwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth
					// + ".Technology.LeftHotBoardTemperatureView";
					// rhwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftHotRingView";
					// ny = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftInnerPressureView";
					// nw = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftInnerTemperatureView";
					// bx = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftStepView";
					// } else {
					// rbwd = "LLJM_SCADA:QGOPC003:Curing" + jth + ".Curing" +
					// jth
					// + ".Technology.LeftHotBoardTemperatureView";
					// rhwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftHotRingView";
					// ny = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftInnerPressureView";
					// nw = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftInnerTemperatureView";
					// bx = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.LeftStepView";
					// }
					rbwd = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftHotBoardTemperatureView";
					rhwd = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftHotRingView";
					ny = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftInnerPressureView";
					nw = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftInnerTemperatureView";
					bx = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftStepView";
				} else if (position.equals("R")) {
					// if (codes.equals("G") || codes.equals("H") ||
					// codes.equals("I") || codes.equals("J")
					// || codes.equals("K") || codes.equals("L")) {
					// rbwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth
					// + ".Technology.RightHotBoardTemperatureView";
					// rhwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightHotRingView";
					// ny = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightInnerPressureView";
					// nw = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightInnerTemperatureView";
					// bx = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightStepView";
					// } else {
					// rbwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
					// + ".Technology.RightHotBoardTemperatureView";
					// rhwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightHotRingView";
					// ny = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightInnerPressureView";
					// nw = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightInnerTemperatureView";
					// bx = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth +
					// ".Technology.RightStepView";
					// }
					rbwd = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightHotBoardTemperatureView";
					rhwd = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightHotRingView";
					ny = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightInnerPressureView";
					nw = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightInnerTemperatureView";
					bx = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightStepView";
				}
			} else if (LLWebUtils.factory().equals("1")) {
				if (position.equals("L")) {
					if (codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						rbwd = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftHotBoardTemperatureView";
						rhwd = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
						ny = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
						nw = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftInnerTemperatureView";
						bx = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";
					} else {
						rbwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftHotBoardTemperatureView";
						rhwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
						ny = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
						nw = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftInnerTemperatureView";
						bx = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";

					}
				} else if (position.equals("R")) {
					if (codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						rbwd = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.RightHotBoardTemperatureView";
						rhwd = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
						ny = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.RightInnerPressureView";
						nw = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.RightInnerTemperatureView";
						bx = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";
					} else {
						rbwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.RightHotBoardTemperatureView";
						rhwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
						ny = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightInnerPressureView";
						nw = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.RightInnerTemperatureView";
						bx = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";

					}
				}
			}

		}

		// 获取硫化开始时间
		String curing_closemoulddate_t = map.get("curing_closemoulddate_t").toString().replace("-", "");
		curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(" ", "");
		curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(":", "");

		// 获取硫化结束时间
		String curing_openmoulddate_t = map.get("curing_openmoulddate_t").toString().replace("-", "");
		curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(" ", "");
		curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(":", "");
		// 曲线测试 当步序偏移的时候，调整时间参数 20200615 刘朋
		if (LLWebUtils.factory().equals("1")) {
			rbwdvalue = portType.queryRealData(equip_code_s, rbwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热板温度的数据
			rhwdvalue = portType.queryRealData(equip_code_s, rhwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热环温度的数据
			nyvalue = portType.queryRealData(equip_code_s, ny, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内压的数据
			nwvalue = portType.queryRealData(equip_code_s, nw, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内温的数据
			bxvalue = portType.queryRealData(equip_code_s, bx, curing_closemoulddate_t, curing_openmoulddate_t);// 获取步序的数据
			// 若步序开始大于1，就加适当加减
			if (1 <= Integer.parseInt(bxvalue.getRPidata().getAnyType().get(0).toString().split(":")[1])) {

				// 获取硫化开始时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate = format.parse(map.get("curing_closemoulddate_t").toString());
				System.out.println("startDate____________" + startDate);
				Calendar startCalendar = Calendar.getInstance();
				startCalendar.setTime(startDate);
				startCalendar.add(Calendar.SECOND, -15);// 当前时间减去n秒
				curing_closemoulddate_t = format.format(startCalendar.getTime()).replace("-", "");
				curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(" ", "");
				curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(":", "");
				System.out.println("curing_closemoulddate_t__________" + curing_closemoulddate_t);
				// 获取硫化结束时间
				Date enddate = format.parse(map.get("curing_openmoulddate_t").toString());
				System.out.println("enddate____________" + enddate);
				Calendar endCalendar = Calendar.getInstance();
				endCalendar.setTime(enddate);
				endCalendar.add(Calendar.SECOND, 15);// 当前时间加n秒
				curing_openmoulddate_t = format.format(endCalendar.getTime()).replace("-", "");
				curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(" ", "");
				curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(":", "");
				System.out.println("curing_openmoulddate_t_______________" + curing_openmoulddate_t);

				rbwdvalue = portType.queryRealData(equip_code_s, rbwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热板温度的数据
				rhwdvalue = portType.queryRealData(equip_code_s, rhwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热环温度的数据
				nyvalue = portType.queryRealData(equip_code_s, ny, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内压的数据
				nwvalue = portType.queryRealData(equip_code_s, nw, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内温的数据
				bxvalue = portType.queryRealData(equip_code_s, bx, curing_closemoulddate_t, curing_openmoulddate_t);// 获取步序的数据
			}
		} else if (LLWebUtils.factory().equals("2")) {
			bg_rbwdvalue = bg_portType.queryRealData(equip_code_s, rbwd, curing_closemoulddate_t,
					curing_openmoulddate_t);// 获取热板温度的数据
			bg_rhwdvalue = bg_portType.queryRealData(equip_code_s, rhwd, curing_closemoulddate_t,
					curing_openmoulddate_t);// 获取热环温度的数据
			bg_nyvalue = bg_portType.queryRealData(equip_code_s, ny, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内压的数据
			bg_nwvalue = bg_portType.queryRealData(equip_code_s, nw, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内温的数据
			bg_bxvalue = bg_portType.queryRealData(equip_code_s, bx, curing_closemoulddate_t, curing_openmoulddate_t);// 获取步序的数据

		}
		// 全钢接口
		ArrayOfanyType arry = null;
		ArrayOfanyType arry1 = null;
		ArrayOfanyType arry2 = null;
		ArrayOfanyType arry3 = null;
		ArrayOfanyType arry4 = null;
		// 半钢接口
		com.bglhqx.ArrayOfanyType bg_arry = null;
		com.bglhqx.ArrayOfanyType bg_arry1 = null;
		com.bglhqx.ArrayOfanyType bg_arry2 = null;
		com.bglhqx.ArrayOfanyType bg_arry3 = null;
		com.bglhqx.ArrayOfanyType bg_arry4 = null;
		List<Object> bb = null;
		List<Object> bb1 = null;
		List<Object> bb2 = null;
		List<Object> bb3 = null;
		List<Object> bb4 = null;

		if (LLWebUtils.factory().equals("1")) {
			arry = rbwdvalue.getRPidata();
			bb = arry.getAnyType();

			arry1 = rhwdvalue.getRPidata();
			bb1 = arry1.getAnyType();

			arry2 = nyvalue.getRPidata();
			bb2 = arry2.getAnyType();

			arry3 = nwvalue.getRPidata();
			bb3 = arry3.getAnyType();

			arry4 = bxvalue.getRPidata();
			bb4 = arry4.getAnyType();
		} else if (LLWebUtils.factory().equals("2")) {
			bg_arry = bg_rbwdvalue.getRPidata();
			bb = bg_arry.getAnyType();

			bg_arry1 = bg_rhwdvalue.getRPidata();
			bb1 = bg_arry1.getAnyType();

			bg_arry2 = bg_nyvalue.getRPidata();
			bb2 = bg_arry2.getAnyType();

			bg_arry3 = bg_nwvalue.getRPidata();
			bb3 = bg_arry3.getAnyType();

			bg_arry4 = bg_bxvalue.getRPidata();

			bb4 = bg_arry4.getAnyType();
		}
		int numle = 0;
		String engresult = null;
		if (LLWebUtils.factory().equals("1")) {
			for (int i = 0; i < bb4.size(); i++) {
				String a = bb4.get(i).toString().split(":")[1];
				Double falg = Double.valueOf(a);
				if (numle != 0) {
					a = "13.88";
					bb4.set(i, bb4.get(i).toString().split(":")[0] + ":" + a);
				}
				if (falg > 13.0D) {
					numle = 1;
				}
			}
		}
		// else if (LLWebUtils.factory().equals("2")) {
		// for (int i = 0; i < bb4.size(); i++) {
		// System.out.println("-----===--==-=-=-=-=-=----" +
		// bb4.get(i).toString());
		// String a = bb4.get(i).toString().split(":")[1];
		// Double falg = Double.valueOf(a);
		// if (numle != 0) {
		// a = "9.88";
		// bb4.set(i, bb4.get(i).toString().split(":")[0] + ":" + a);
		// }
		// if (falg > 9.0D) {
		// numle = 1;
		// }
		// }
		// }
		Integer[] numbers = { bb.size(), bb1.size(), bb2.size(), bb3.size(), bb4.size() };
		int max = (int) Collections.max(Arrays.asList(numbers));// 取最大值
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();// 定义返回结果
		String date = null;
		for (int i = 0; i < max; i++) {
			Map<String, Object> res = new HashMap<String, Object>();
			try {
				if (i < bb.size()) {
					date = bb.get(i).toString().split(":")[0].substring(8);
					StringBuilder sb = new StringBuilder(date);
					sb.insert(2, ":");
					sb.insert(5, ":");
					res.put("date", sb);
					res.put("rbwd", bb.get(i).toString().split(":")[1]);
				}
				if (i < bb1.size()) {
					res.put("rhwd", bb1.get(i).toString().split(":")[1]);
				}
				if (i < bb2.size()) {
					res.put("ny", bb2.get(i).toString().split(":")[1]);
				}
				if (i < bb3.size()) {
					res.put("nw", bb3.get(i).toString().split(":")[1]);
				}
				if (i < bb4.size()) {
					res.put("bx", bb4.get(i).toString().split(":")[1]);
				}
				result.add(res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return result;
	}

	/**
	 * 定型压力
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> dxyl(Map<String, Object> map) {
		// 先根据轮胎条码拿到机械臂转入时间
		/*
		 * SQLQuery query =
		 * getSession().createSQLQuery(getSQL("searchmaintyreextend"));
		 * query.setParameter("barcode_s", map.get("barcode_s").toString());
		 * List<Map<String, Object>> listMap=query.list(); if(listMap==null){
		 * return null; }
		 */
		String sql = "select to_char(RESERVEDATE_1_T,'yyyy-MM-dd hh24:mi:ss') from at_c_mm_maintyre_Extend t where t.barcode_s = '"
				+ map.get("barcode_s").toString() + "'";
		List<Object> listObject = getSession().createSQLQuery(sql).list();
		if (listObject.size() == 0 || listObject == null) {
			return null;
		} else if (listObject.size() == 1) {
			Object obj = listObject.get(0);
			if (listObject.get(0) == null) {
				return null;
			}
		}
		String begintime = listObject.get(0).toString();
		String sql1 = "select to_char(RESERVEDATE_2_T,'yyyy-MM-dd hh24:mi:ss') from at_c_mm_maintyre_Extend t where t.barcode_s = '"
				+ map.get("barcode_s").toString() + "' AND RESERVEDATE_2_T IS NOT NULL";
		List<Object> listObject1 = getSession().createSQLQuery(sql1).list();
		String endtime = "";
		if (listObject1.size() == 0 || listObject1 == null) {
			return null;
		} else if (listObject1.size() == 1) {
			//Object obj = listObject1.get(0);
			if (listObject1.get(0) == null) {
				return null;
			}
			endtime = listObject1.get(0).toString();
		}
		// 全钢接口
		PIReturnObject ylvalue_qg = null;
		WSInterface portType_qg = null;
		// 半钢接口
		com.bglhqx.PIReturnObject ylvalue_bg = null;
		com.bglhqx.WSInterface portType_bg = null;

		if (LLWebUtils.factory().equals("1")) {
			WSImplement service_qg = new WSImplement();
			portType_qg = service_qg.getBasicHttpBindingWSInterface();
		} else if (LLWebUtils.factory().equals("2")) {
			com.bglhqx.WSImplement service = new com.bglhqx.WSImplement();
			portType_bg = service.getBasicHttpBindingWSInterface();
		}
		String codes = null;
		String jth = null;
		String dxyl = null;// 定性压力据点
		String date = null;

		String equip_code_s = map.get("equip_code_s").toString();// 获取机台编码
		if (equip_code_s.substring(3, 4) != null) {
			codes = equip_code_s.substring(3, 4);
			jth = equip_code_s.substring(3, 6);
			String position = equip_code_s.substring(6);
			if (LLWebUtils.factory().equals("2")) {
				if (position.equals("L")) {
					// if (codes.equals("G") || codes.equals("H") ||
					// codes.equals("I") || codes.equals("J")
					// || codes.equals("K") || codes.equals("L")) {
					// dxyl = "LLBG:BGOPC01:Curing" + jth + ".Curing" + jth
					// + ".Technology.LeftBuildingPressureView";
					// } else {
					dxyl = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.LeftBuildingPressureView";
					// }
				} else if (position.equals("R")) {
					// if (codes.equals("G") || codes.equals("H") ||
					// codes.equals("I") || codes.equals("J")
					// || codes.equals("K") || codes.equals("L")) {
					// dxyl = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth
					// + ".Technology.LeftBuildingPressureView";
					// } else {
					dxyl = "LLBG:BGOPC01:" + jth + "." + jth + ".Technology.RightBuildingPressureView";
					// }
				}
			} else if (LLWebUtils.factory().equals("1")) {
				if (position.equals("L")) {
					if (codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						dxyl = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftBuildingPressureView";
					} else {
						dxyl = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftBuildingPressureView";

					}
				} else if (position.equals("R")) {
					if (codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						dxyl = "LLJM_SCADA:OPC001:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftBuildingPressureView";
					} else {
						dxyl = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
								+ ".Technology.LeftBuildingPressureView";

					}
				}
			}
		}

		// 获取硫化开始时间
		begintime = begintime.replace("-", "");
		begintime = begintime.replace(" ", "");
		begintime = begintime.replace(":", "");

		// 获取硫化结束时间
		endtime = endtime.replace("-", "");
		endtime = endtime.replace(" ", "");
		endtime = endtime.replace(":", "");
		// 全钢接口
		ArrayOfanyType arry_qg = null;
		// 半钢接口
		com.bglhqx.ArrayOfanyType arry_bg = null;
		List<Object> bb = null;

		if (LLWebUtils.factory().equals("1")) {
			ylvalue_qg = portType_qg.queryRealData(equip_code_s, dxyl, begintime, endtime);// 获取定型压力的数据
			arry_qg = ylvalue_qg.getRPidata();
			bb = arry_qg.getAnyType();
		} else if (LLWebUtils.factory().equals("2")) {
			ylvalue_bg = portType_bg.queryRealData(equip_code_s, dxyl, begintime, endtime);// 获取定型压力的数据
			arry_bg = ylvalue_bg.getRPidata();
			bb = arry_bg.getAnyType();
		}

		Integer[] numbers = { bb.size() };
		int max = (int) Collections.max(Arrays.asList(numbers));// 取最大值
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();// 定义返回结果
		List<String> dataList = new ArrayList<String>();
		dataList.add(listObject.get(0).toString());
		dataList.add(listObject1.get(0).toString());
		for (int i = 0; i < max; i++) {
			Map<String, Object> res = new HashMap<String, Object>();
			try {
				if (i < bb.size()) {
					date = bb.get(i).toString().split(":")[0].substring(8);
					StringBuilder sb = new StringBuilder(date);
					sb.insert(2, ":");
					sb.insert(5, ":");
					res.put("dates", sb);
					res.put("yl", bb.get(i).toString().split(":")[1]);
				}
				if (i < dataList.size()) {
					res.put("date", dataList.get(i));
				}
				result.add(res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return result;
	}

	/**
	 * 查询固化数据
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> guhuaData(String beginTime, String endTime, String material_code_s,
			String class_id_s, String post_date_s) throws Exception {
		// +"post_date_s = '" +post_date_s+"'"
		String sql = "SELECT " + "  0 atr_key,'' serid_s,MATERIAL_CODE_S, " + "	PRODUCTIONVER_S, "
				+ "	MATERIAL_NAME_S, " + "	CLASS_ID_S, " + "	COUNT (1) TOTAL " + "FROM " + "	AT_C_MM_WorkOrderResult "
				+ "WHERE " + "	CURING_CLOSEMOULDDATE_T BETWEEN to_date('"
				+ beginTime
				+ "','yyyy-MM-dd HH24:mi:ss') "
				+ "AND to_date('"
				+ endTime
				+ "','yyyy-MM-dd HH24:mi:ss') "
				+ " AND CLASS_ID_S ='"
				+ class_id_s
				+ "'"
				+ "AND ( "
				+ "	SOLIDIF_YFLAG_S = '0' "
				+ "	OR SOLIDIF_YFLAG_S IS NULL "
				+ ") and patch_curingflag_s='1'  and MATERIAL_CODE_S like '%"
				+ material_code_s
				+ "%' and S_FACTORY_S='"
				+ LLWebUtils.factory()
				+ "' and record_flag_s='A'"
				+ " GROUP BY "
				+ "	MATERIAL_CODE_S, "
				+ "	MATERIAL_NAME_S, "
				+ "	PRODUCTIONVER_S, "
				+ "	CLASS_ID_S"
				+ " order by CLASS_ID_S,MATERIAL_CODE_S,PRODUCTIONVER_S ";
		System.out.println(sql);
		SQLQuery query = createSQLQuery(sql);
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
	 * 查询报产信息数据
	 */
	public Map<String, Object> datagridUDAThree(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridUDARowsThree(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridUDATotalThree(filter, page));

		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridUDARowsThree(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDARowsThree") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDARowsThree的SQL语句定义");

		String dataSql = getSQL("datagridUDARowsThree", filter.getFilter());

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

	public Long datagridUDATotalThree(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDATotalThree") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDATotalThree的SQL语句定义");

		String totalSql = getSQL("datagridUDATotalThree", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	// 查询//
	public Map<String, Object> bcreport(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridBcreport(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridBcreportTotal(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridBcreport(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_rows_bcreport") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows_bcreport的SQL语句定义");
		String dataSql = getSQL("datagrid_rows_bcreport", filter.getFilter());
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

	public Long datagridBcreportTotal(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total_bcreport") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total_bcreport的SQL语句定义");

		String totalSql = getSQL("datagrid_total_bcreport", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	// 查询//
	public Map<String, Object> ccreport(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridCcreport(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridCcreportTotal(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridCcreport(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_rows_ccreport") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows_ccreport的SQL语句定义");
		String dataSql = getSQL("datagrid_rows_ccreport", filter.getFilter());
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

	public Long datagridCcreportTotal(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total_ccreport") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total_ccreport的SQL语句定义");

		String totalSql = getSQL("datagrid_total_ccreport", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 硫化产量报产,根据选中行更新,调用林海林提供jar包（上报）
	 * 
	 * @throws Exception
	 */
	public void reporttosapBySelectRow(String[] batchidlist) throws Exception {
		// 1、点击报产上报按钮，将AT_INT_SAP_MESSAPPRODUCTION表中固化状态改为已固化
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("(");
		for (String item : batchidlist) {
			sbBuffer.append("'" + item + "',");
		}
		String insql = sbBuffer.toString().substring(0, sbBuffer.toString().length() - 1);
		insql = insql + ")";
		String sql = "update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1',t.operate_usernane_s='"
				+ WebUtils.getUser().userName + "',t.operate_time_s='" + getDateTime() + "' where t.batch_id_s in"
				+ insql + " and t.record_flag_s='A'";
		RockWellUtils.execSQL(sql);

		// 2、查询集成报产表中对应的上报状态
		String sql1 = "select record_sap_flag_s,batch_id_s from AT_INT_SAP_MESSAPPRODUCTION where batch_id_s in "
				+ insql + " and record_flag_s='A'";
		SQLQuery query1 = createSQLQuery(sql1);
		List<Map<String, Object>> listMap1 = query1.list();
		for (int i = 0; i < listMap1.size(); i++) {
			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("0")) {
				// 3、调用报产接口，接口中查询已经固化并且上报状态是未读取的数据
				if(LLWebUtils.factory().equals("1")){//全钢
					LZMESPRODUCT curing = new LZMESPRODUCT();// 报产接口
					curing.executeRequest();
				}
				if(LLWebUtils.factory().equals("2")){//半钢
					HALFSTEELLZMESPRODUCT halfSteelCuring=new HALFSTEELLZMESPRODUCT();
					halfSteelCuring.executeRequest();
				}
				
			}
			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("1")
					|| listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("3")) {
				// 4、调用报产接口，接口中查询已经固化并且上报状态是已读取或错误的数据
				if(LLWebUtils.factory().equals("1")){//全钢
					LZMESPRODUCT curing = new LZMESPRODUCT();// 报产接口
					curing.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
				}
				if(LLWebUtils.factory().equals("2")){//半钢
					HALFSTEELLZMESPRODUCT halfSteelCuring=new HALFSTEELLZMESPRODUCT();
					halfSteelCuring.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
				}
			}
		}

	}

	/**
	 * 硫化产量冲产,根据选中行更新,调用林海林提供jar包（上报）
	 * 
	 * @throws Exception
	 */
	public void reflushtosapBySelectRow(String[] batchidlist) throws Exception {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("(");
		for (String item : batchidlist) {
			sbBuffer.append("'" + item + "',");
		}
		String insql = sbBuffer.toString().substring(0, sbBuffer.toString().length() - 1);
		insql = insql + ")";
		String sql2 = "update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1',t.operate_usernane_s='"
				+ WebUtils.getUser().userName + "',t.operate_time_s='" + getDateTime() + "'where t.batch_id_s in"
				+ insql + " and t.record_flag_s='A'";
		RockWellUtils.execSQL(sql2);
		// 1、查询集成报产表中对应的上报状态
		String sql1 = "select record_sap_flag_s,batch_id_s from AT_INT_SAP_MESSAPPRODUCTION where batch_id_s in "
				+ insql + " and record_flag_s='A'";
		SQLQuery query1 = createSQLQuery(sql1);
		List<Map<String, Object>> listMap1 = query1.list();
		for (int i = 0; i < listMap1.size(); i++) {
			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("0")) {
				// 2、调用冲产接口，接口中查询已经固化并且上报状态是未读取的数据
				if(LLWebUtils.factory().equals("1")){//全钢
					LZMESFLUSHPRODUCT curing = new LZMESFLUSHPRODUCT();// 冲产接口
					curing.executeRequest();
				}
				if(LLWebUtils.factory().equals("2")){//半钢
					HALFSTEELLZMESFLUSHPRODUCT halfSteelCuring = new HALFSTEELLZMESFLUSHPRODUCT();// 冲产接口
					halfSteelCuring.executeRequest();
				}
			}
			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("1")
					|| listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("3")) {
				// 3、调用冲产接口，接口中查询已经固化并且上报状态是已读取或错误的数据
				if(LLWebUtils.factory().equals("1")){//全钢
					LZMESFLUSHPRODUCT curing = new LZMESFLUSHPRODUCT();// 冲产接口
					curing.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
				}
				if(LLWebUtils.factory().equals("2")){//半钢
					HALFSTEELLZMESFLUSHPRODUCT halfSteelCuring = new HALFSTEELLZMESFLUSHPRODUCT();// 冲产接口
					halfSteelCuring.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
				}
			}
		}
//		// 4、加5秒延迟，用于MES接收到SAP返回消息存进数据库时间,再次查询上报状态
//		Thread.currentThread().sleep(5000);
//		List<Map<String, Object>> listMap2 = query1.list();
//		List array = null;
//		for (int i = 0; i < listMap2.size(); i++) {
//			array = new ArrayList<>();
//			if (!listMap2.get(i).get("RECORD_SAP_FLAG_S").equals("2")) {
//				continue;
//			} else {
//				array.add(listMap2.get(i).get("BATCH_ID_S"));
//				// 5、若上报状态为2（成功），修改产出表对应轮胎条码的固化状态为未固化，则在报产固化界面能查询出数据
//				StringBuffer sql = new StringBuffer(
//						"select TYRE_BARCODE_S from at_C_MM_ProductionDetail where SERIAL_NUMBER_S in (");
//				for (int x = 0; x < array.size(); ++x) {
//					for (Map m : listMap2) {
//						if (array.get(x).equals(m.get("BATCH_ID_S"))) {
//							sql.append("'" + array.get(x) + "',");
//						}
//					}
//				}
//				sql.deleteCharAt(sql.length() - 1);
//				sql.append(") and record_flag_s='A'");
//				SQLQuery query = createSQLQuery(sql.toString());
//				List<Map<String, Object>> listMap = query.list();
//				String tyreBarcode = "";
//				for (int j = 0; j < listMap.size(); j++) {
//					tyreBarcode = listMap.get(j).get("TYRE_BARCODE_S").toString();
//					String updateWorkorderresultSql = String.format(
//							"update at_c_mm_workorderresult t set t.solidif_yflag_s = '0'"
//									+ " where t.record_flag_s = '%s' " + " and t.s_factory_s='%s' "
//									+ " and t.agenc_no_s='%s'  " + " and t.tyre_barcode_s='%s' ",
//							LLConstant.Record_Flag.AVAILIABLE, LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
//							tyreBarcode);
//					RockWellUtils.execSQL(updateWorkorderresultSql);
//				}
//			}
//		}
	}
	/**
	 * 冲产上报之后将返回成功的数据从生产实绩表变成未固化
	 * 
	 * @throws Exception
	 */
	public void repeattosapBySelectRow(String[] batchidlist) throws Exception {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("(");
		for (String item : batchidlist) {
			sbBuffer.append("'" + item + "',");
		}
		String insql = sbBuffer.toString().substring(0, sbBuffer.toString().length() - 1);
		insql = insql + ")";
//		String sql2 = "update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1',t.operate_usernane_s='"
//				+ WebUtils.getUser().userName + "',t.operate_time_s='" + getDateTime() + "'where t.batch_id_s in"
//				+ insql + " and t.record_flag_s='A'";
//		RockWellUtils.execSQL(sql2);
		// 1、查询集成报产表中对应的上报状态
		String sql1 = "select record_sap_flag_s,batch_id_s from AT_INT_SAP_MESSAPPRODUCTION where batch_id_s in "
				+ insql + " and record_flag_s='A'";
		SQLQuery query1 = createSQLQuery(sql1);
//		List<Map<String, Object>> listMap1 = query1.list();
//		for (int i = 0; i < listMap1.size(); i++) {
//			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("0")) {
//				// 2、调用冲产接口，接口中查询已经固化并且上报状态是未读取的数据
//				if(LLWebUtils.factory().equals("1")){//全钢
//					LZMESFLUSHPRODUCT curing = new LZMESFLUSHPRODUCT();// 冲产接口
//					curing.executeRequest();
//				}
//				if(LLWebUtils.factory().equals("2")){//半钢
//					HALFSTEELLZMESFLUSHPRODUCT halfSteelCuring = new HALFSTEELLZMESFLUSHPRODUCT();// 冲产接口
//					halfSteelCuring.executeRequest();
//				}
//			}
//			if (listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("1")
//					|| listMap1.get(i).get("RECORD_SAP_FLAG_S").equals("3")) {
//				// 3、调用冲产接口，接口中查询已经固化并且上报状态是已读取或错误的数据
//				if(LLWebUtils.factory().equals("1")){//全钢
//					LZMESFLUSHPRODUCT curing = new LZMESFLUSHPRODUCT();// 冲产接口
//					curing.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
//				}
//				if(LLWebUtils.factory().equals("2")){//半钢
//					HALFSTEELLZMESFLUSHPRODUCT halfSteelCuring = new HALFSTEELLZMESFLUSHPRODUCT();// 冲产接口
//					halfSteelCuring.executeRequestByBatchId(listMap1.get(i).get("BATCH_ID_S").toString());
//				}
//			}
//		}
//		// 4、加5秒延迟，用于MES接收到SAP返回消息存进数据库时间,再次查询上报状态
//		Thread.currentThread().sleep(5000);
		List<Map<String, Object>> listMap2 = query1.list();
		List array = null;
		for (int i = 0; i < listMap2.size(); i++) {
			array = new ArrayList<>();
			if (!listMap2.get(i).get("RECORD_SAP_FLAG_S").equals("2")) {
				continue;
			} else {
				array.add(listMap2.get(i).get("BATCH_ID_S"));
				// 5、若上报状态为2（成功），修改产出表对应轮胎条码的固化状态为未固化，则在报产固化界面能查询出数据
				StringBuffer sql = new StringBuffer(
						"select TYRE_BARCODE_S from at_C_MM_ProductionDetail where SERIAL_NUMBER_S in (");
				for (int x = 0; x < array.size(); ++x) {
					for (Map m : listMap2) {
						if (array.get(x).equals(m.get("BATCH_ID_S"))) {
							sql.append("'" + array.get(x) + "',");
						}
					}
				}
				sql.deleteCharAt(sql.length() - 1);
				sql.append(") and record_flag_s='A'");
				SQLQuery query = createSQLQuery(sql.toString());
				List<Map<String, Object>> listMap = query.list();
				String tyreBarcode = "";
				for (int j = 0; j < listMap.size(); j++) {
					tyreBarcode = listMap.get(j).get("TYRE_BARCODE_S").toString();
					String updateWorkorderresultSql = String.format(
							"update at_c_mm_workorderresult t set t.solidif_yflag_s = '0'"
									+ " where t.record_flag_s = '%s' " + " and t.s_factory_s='%s' "
									+ " and t.agenc_no_s='%s'  " + " and t.tyre_barcode_s='%s' ",
							LLConstant.Record_Flag.AVAILIABLE, LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
							tyreBarcode);
					RockWellUtils.execSQL(updateWorkorderresultSql);
				}
			}
		}
		//修改产量固化与sap抛帐表（避免多次添加数据）
		String sql3 = "update AT_INT_SAP_MESSAPPRODUCTION t set t.spare5_s = '1' where t.batch_id_s in"
					+ insql + " and t.record_flag_s='A'";
		RockWellUtils.execSQL(sql3);
	}
	/**
	 * 固化操作
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
	public String curing(Map<String, Object> workOrderResultReportDTO) throws Exception {
		String beginTime = workOrderResultReportDTO.get("begintime").toString();
		String endTime = workOrderResultReportDTO.get("endtime").toString();
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO.get("selectedrows");
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}

		String materialCode = null;
		String classId = null;
		String productionver = null;
		String materialName = null;
		String spare6_s = null;
		String total = null;
		String serialno=null;
		String workorderno=null;
		boolean flag = false;
		for (Map<String, Object> item : selectRows) {
			// 一个固化产生一个报产流水号
			if(LLWebUtils.factory().equals("1")){//全钢
				serialno = getBatch_id();
			}
			if(LLWebUtils.factory().equals("2")){//半钢
				serialno = getBGBatch_id();
			}
			if (item.get("productionver_s") == null) {
				throw new Exception("生产版本为空，不允许报产");
			}
			if (item.get("material_code_s") != null && item.get("material_code_s") != "") {
				materialCode = item.get("material_code_s").toString();
			}
			if (item.get("class_id_s") != null && item.get("class_id_s") != "") {
				classId = item.get("class_id_s").toString();
			}
			if (item.get("productionver_s") != null && item.get("productionver_s") != "") {
				productionver = item.get("productionver_s").toString();
			}
			if (item.get("material_name_s") != null && item.get("material_name_s") != "") {
				materialName = item.get("material_name_s").toString();
			}
			if (item.get("spare6_s") != null && item.get("spare6_s") != "") {
				spare6_s = item.get("spare6_s").toString();// 用于区分外胎是否为试验胎，0不是，1是
			} else {
				spare6_s = "0";
			}
			if (item.get("total") != null && item.get("total") != "") {
				total = item.get("total").toString();
			}
			List<Map<String, Object>> list = productionDetailByCuring(item, beginTime, endTime);
			for (int i = 0; i < list.size(); i++) {
				ProductionDdetail productionDdetail = new ProductionDdetail();
				productionDdetail.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				productionDdetail.setS_factory_s(LLWebUtils.factory());
				productionDdetail.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				productionDdetail.setTyre_barcode_s(list.get(i).get("tyre_barcode_s").toString());
				productionDdetail.setEquip_code_s(list.get(i).get("equip_code_s").toString());
				productionDdetail.setCuring_grade_s(list.get(i).get("spare5_s").toString());
				productionDdetail.setMaterial_code_s(list.get(i).get("material_code_s").toString());
				productionDdetail.setMaterial_name_s(list.get(i).get("material_name_s").toString());
				productionDdetail.setProduct_date_s(list.get(i).get("product_date_s").toString());
				productionDdetail.setPatch_curingflag_s(list.get(i).get("patch_curingflag_sato").toString());
				productionDdetail.setSerial_number_s(serialno);
				productionDdetail.setSpare1_s("252006");// 备用字段1
														// 被用于存放工序数据：252006硫化/成型252005
				productionDdetail.setSpare2_s("01");// 备用字段2
													// 被用于存放区分报产，冲产数据:01:报产，02：冲产
				productionDdetailServiceImpl.save(productionDdetail);
			}
			String updateWorkorderresultSql = String.format(
					"update at_c_mm_workorderresult t set t.solidif_yflag_s = '1', t.spare1_s = '%s'"
							+ " where t.record_flag_s = '%s' " + " and t.s_factory_s='%s' "
							+ " and t.agenc_no_s='%s'  " + " and t.material_code_s='%s' " + " and t.class_id_s='%s' "
							+ " and t.productionver_s='%s' " + " and nvl(t.solidif_yflag_s,0)='0' "
							+ " and t.curing_openmoulddate_t between to_date('%s','YYYY-mm-dd HH24:MI:SS')  "
							+ " and to_date('%s','YYYY-mm-dd HH24:MI:SS') " + " and t.patch_curingflag_s='0' "
							+ " and t.material_name_s='%s' ",
					serialno, LLConstant.Record_Flag.AVAILIABLE, LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
					materialCode, classId, productionver, beginTime, endTime, materialName);
			if (materialCode != null && classId != null && productionver != null && beginTime != null
					&& endTime != null) {
				// 更新硫化实绩表。更新（1）固化标识为已固化（2）固化流水号
				RockWellUtils.execSQL(updateWorkorderresultSql);

				// 一个规格产生一个报产工单号
				if(LLWebUtils.factory().equals("1")){//全钢
					workorderno = getSerid();
				}
				if(LLWebUtils.factory().equals("2")){//半钢
					workorderno = getBGSerid();
				}
				// 向AT_INT_SAP_MESSAPPRODUCTION表写入数据
				MesSapProduction mesSapProduction = new MesSapProduction();
				mesSapProduction.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				mesSapProduction.setS_factory_s(LLWebUtils.factory());
				mesSapProduction.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				mesSapProduction.setSerid_s(workorderno);// 每一种规格带一个工单号
				mesSapProduction.setProduct_type_s("01");// 01:报产，02：冲产
				mesSapProduction.setPlant_s(LLConstant.JING_MEN_CODE);// 工厂号
				// SAP品号（18位的物料编码，生产实绩表里的物料编码不可以直接用，因sap报产的时候不会识别这个，需要根据物料编码从sap物料信息表查对应的列MATERIALSHORT_S）
				mesSapProduction.setMaterial_code_s(getMaterialShort(materialCode));// 物料编码（18位）
				mesSapProduction.setMaterial_name_s(materialName);// 物料名称
				mesSapProduction.setPro_version_s(productionver);// 生产版本
				mesSapProduction.setQuantity_f(total);// 实际数量
				mesSapProduction.setActual_quantity_f(total);// 实际固化数量
				if (judgeDateIsLastMonth()) {
					mesSapProduction.setPost_date_s(getDateAddOne());// 过账日期
				} else {
					mesSapProduction.setPost_date_s(getDate());// 过账日期
				}
				mesSapProduction.setDoc_date_s(getDate());// 凭证日期（默认当前日期
															// YYYYmmdd）

				if (LLWebUtils.factory().equals("1")) {
					if (spare6_s.equals("0")) {
						mesSapProduction.setStorage_loc_s("H290");// 线边库-下线库位：全钢外胎H290;
					} else {
						mesSapProduction.setStorage_loc_s("H291");// 线边库-下线库位：全钢外胎,并且是试验胎H291;
					}
				} else if (LLWebUtils.factory().equals("2")) {
					if (spare6_s.equals("0")) {
						mesSapProduction.setStorage_loc_s("H190");// 线边库-下线库位：半钢外胎H190;
					} else {
						mesSapProduction.setStorage_loc_s("H191");// 线边库-下线库位：半钢外胎,并且是试验胎H191;
					}
				}
				mesSapProduction.setBatch_s("1111");// 产品下线批次,湖北为1111
				mesSapProduction.setHeadtxt_s(classId + getDateTime() + WebUtils.getUser().userCode);// 班次+时间+操作人（系统）
				mesSapProduction.setRecord_sap_flag_s("0");// 记录标示（0:SAP未读取;1:：已读取；2：正常；3:错误)
				/*
				 * mesSapProduction.setOperate_userid_s(WebUtils.getUser().userCode
				 * );// 操作工编号
				 * mesSapProduction.setOperate_usernane_s(WebUtils.getUser
				 * ().userName);// 操作工姓名
				 * mesSapProduction.setOperate_time_s(getDateTime());// 操作时间
				 */mesSapProduction.setBatch_id_s(serialno);// 设置流水号
				mesSapProduction.setProcess_s("252006");// 报工工序:252006硫化/成型252005
				mesSapProduction.setReverser_flag_s("0");// 冲销标识:默认 0 0否1是
				mesSapProduction.setSolid_flag_s("0");// 固化标识（0 未固化 1已固化）
				mesSapProduction.setClass_id_s(classId);// 生产班次
				mesSapProduction.setRush_serid_s(materialCode);// 物料编码
				mesSapProduction.setDummy1_s(beginTime);
				mesSapProduction.setDummy2_s(endTime);
				mesSapProduction.setSpare4_s("0");// 区分是否补硫化1：是0：否
				// 保存到ERP抛帐表
				mesSapProductionServiceImpl.save(mesSapProduction);
				flag = true;
			}
		}// 物料编码循环终止括号
		if (flag = false) {
			return "操作失败，可能原因：硫化班次为空！";
		} else {
			return "操作成功";
		}
	}

	/**
	 * 报产固化时查询明细
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
	public List<Map<String, Object>> productionDetailByCuring(Map<String, Object> workOrderResultReportDTO,
			String beginTime, String endTime) throws Exception {
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO.get("selectedrows");
		if (beginTime.isEmpty() || endTime.isEmpty()) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String materialCode = workOrderResultReportDTO.get("material_code_s").toString();
		String classId = workOrderResultReportDTO.get("class_id_s").toString();
		String productionver = workOrderResultReportDTO.get("productionver_s").toString();
		String materialName = workOrderResultReportDTO.get("material_name_s").toString();
		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai"));
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		query.setParameter("classId", classId);
		query.setParameter("productionver", productionver);
		query.setParameter("materialCode", materialCode);
		query.setParameter("materialName", materialName);
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
	 * 明细窗口
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
	public List<Map<String, Object>> productionDetail(Map<String, Object> workOrderResultReportDTO) throws Exception {
		String beginTime = workOrderResultReportDTO.get("begintime").toString();
		String endTime = workOrderResultReportDTO.get("endtime").toString();
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO.get("selectedrows");
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String classId = selectRows.get(0).get("class_id_s").toString();
		String productionver = selectRows.get(0).get("productionver_s").toString();
		String materialCode = selectRows.get(0).get("material_code_s").toString();
		String materialName = selectRows.get(0).get("material_name_s").toString();

		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai"));
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		query.setParameter("classId", classId);
		query.setParameter("productionver", productionver);
		query.setParameter("materialCode", materialCode);
		query.setParameter("materialName", materialName);
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
	 * 明细窗口（主页面第五个按钮）
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @throws Exception
	 */
	@RockWellTransactional
	public List<Map<String, Object>> productionDetail2(Map<String, Object> workOrderResultReportDTO) throws Exception {
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO.get("selectedrows");
		String serialNumber = selectRows.get(0).get("batch_id_s").toString();
		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai2"));
		query.setParameter("serialNumber", serialNumber);
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
	 * 时间转换成java.sql.Date
	 * 
	 * @param strDate
	 *            时间字符
	 * @return
	 * @throws ParseException
	 */
	public java.util.Date strToDate(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(strDate);
		return date;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 获取当前年
	 * 
	 * @return
	 */
	public String getDateYear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(new Date());
	}

	/**
	 * 获取当前年月日
	 * 
	 * @return
	 */
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

	/**
	 * 获取当前年月日加一天
	 * 
	 * @return
	 */
	public String getDateAddOne() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		return format.format(c.getTime());
	}

	/**
	 * 根据物料编码返回18位物料编码
	 * 
	 * @param materialcode
	 * @return
	 * @throws Exception
	 */
	public String getMaterialShort(String materialcode) throws Exception {
		Part part = getFunction().getPart(materialcode);
		if (part == null) {
			throw new Exception(materialcode + "的物料编码不存在");
		}
		return (String) part.getUDA("MaterialShort");
	}

	/**
	 * 判断今天是否是每月最后一天的下午4点后、24点前
	 * 
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public Boolean judgeDateIsLastMonth() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 24hh");
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastmonthday = format.format(calendar.getTime());

		DateFormat df = new SimpleDateFormat("yyyy-MM-DD 24hh");
		Date monthlasttimestart = df.parse(lastmonthday + " 16:00:00");
		Date monthlasttimeend = df.parse(lastmonthday + " 23:59:59");

		Date nowDate = df.parse(df.format(new Date()));
		if (nowDate.getTime() > monthlasttimestart.getTime() && nowDate.getTime() < monthlasttimeend.getTime()) {
			return true;
		}

		return false;
	}

	public String subStr(String str, int start) {
		if (str == null || str.equals("") || str.length() == 0) {
			return "";
		}
		if (start < str.length()) {
			return str.substring(start);
		} else {
			return "";
		}
	}

	/**
	 * 自动生成全钢报产流水号
	 * 
	 * @return
	 */
	public String getSerid() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getSerid"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("SERID") != null) {
				max_code = listMap.get(0).get("SERID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 12);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 10000 + endNum + 1;
					comment_code = "JMMES" + uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = "JMMES" + uid_pfix + "0001";
				}
			} else {
				comment_code = "JMMES" + uid_pfix + "0001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}

	/**
	 * 自动生成全钢上传批次号
	 * 
	 * @return
	 */
	public String getBatch_id() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBatch_id"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("BATCHID") != null) {
				max_code = listMap.get(0).get("BATCHID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 13);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 100000 + endNum + 1;
					comment_code = uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = uid_pfix + "00001";
				}
			} else {
				comment_code = uid_pfix + "00001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}

	/**
	 * 自动生成半钢报产流水号
	 * 
	 * @return
	 */
	public String getBGSerid() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBGSerid"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("SERID") != null) {
				max_code = listMap.get(0).get("SERID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 12);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 10000 + endNum + 1;
					comment_code = "JMBGM" + uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = "JMBGM" + uid_pfix + "0001";
				}
			} else {
				comment_code = "JMBGM" + uid_pfix + "0001";
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}
	
	/**
	 * 自动生成半钢上传批次号
	 * 
	 * @return
	 */
	public String getBGBatch_id() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBGBatch_id"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("BATCHID") != null) {
				max_code = listMap.get(0).get("BATCHID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 13);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 100000 + endNum + 1;
					comment_code ="BG"+ uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code ="BG"+ uid_pfix + "00001";
				}
			} else {
				comment_code ="BG"+ uid_pfix + "00001";
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}
	/**
	 * 查出模具条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMoldCode() {
		SQLQuery query = createSQLQuery(getSQL("searchMoldCode"));
	    query.setParameter("factory", LLWebUtils.factory());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
}