/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.DictcodeConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringMainTyre;
import com.bluebirdme.mes.linglong.curing.entity.QualityDegrade;
import com.bluebirdme.mes.linglong.curing.entity.WorkOrderResult;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGradeAll;
import com.bluebirdme.mes.linglong.finalcheck.service.MainTyreServiceImpl;
import com.ibm.icu.text.SimpleDateFormat;
import com.lhqx.ArrayOfanyType;
import com.lhqx.PIReturnObject;
import com.lhqx.WSImplement;
import com.lhqx.WSInterface;

import freemarker.template.TemplateException;

/**
 * 质量降级汇总表
 * 
 * @author 刘朋
 * @Date 2019-03-13 08:33:42
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QualityDegradeServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;
	@Resource
	MainTyreServiceImpl mainTyreServiceImpl;
	@Resource
	QualityDegradeServiceImpl qualityDegradeServiceImpl;
	@Resource
	WorkOrderResultServiceImpl workOrderResultServiceImpl;

	@Override
	protected Class getEntity() {
		// TODO Auto-generated method stub
		return QualityDegrade.class;
	}

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 根据轮胎明细查询
	 * 
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterial(Map<String, Object> map) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchDetailByCode"));
		query.setParameter("barcode_s", map.get("barcode_s").toString());
		query.setParameter("proess_s", DictcodeConstant.DICT252006);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	/**
	 * 根据轮胎号查询动平衡降级明细
	 * 
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> searchDynabakanceByCode(Map<String, Object> map) {
		String factory = LLWebUtils.factory();
		SQLQuery query = null;
		if (factory.equals("1")) {
			query = getSession().createSQLQuery(getSQL("searchDynabakanceByCode_qg"));
		} else {
			query = getSession().createSQLQuery(getSQL("searchDynabakanceByCode_bg"));
		}
		query.setParameter("barcode_s", map.get("barcode_s").toString());
		query.setParameter("proess_s", DictcodeConstant.DICT252006);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	/**
	 * 根据轮胎号查询外观降级明细
	 * 
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> searchDetialByCode(Map<String, Object> map) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchDetialByCode"));
		query.setParameter("barcode_s", map.get("barcode_s").toString());
		query.setParameter("proess_s", DictcodeConstant.DICT252006);
		// query.setParameter("pro_type_s", map.get("type").toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	/**
	 * 获取所有等级
	 * 
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> getlist() {
		SQLQuery query = getSession().createSQLQuery(getSQL("findProcessgrade"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	/**
	 * 通过条码、工序查询轮胎信息
	 * 
	 * @Title: getMainTyre
	 * @Description: TODO(描述)
	 * @return: SQLQuery 返回类型
	 * @throws Exception
	 * @throws IOException
	 * @throws TemplateException
	 * 
	 */
	public List<CuringMainTyre> getMainTyre(String barcode_s, String process) throws TemplateException, Exception {
		Filter filter = new Filter();
		filter.set("barcode_s", barcode_s);
		SQLQuery query = createSQLQuery(getSQL("findMaintyreByCode", filter.getFilter()), CuringMainTyre.class);
		query.setParameter("barcode_s", barcode_s);
		query.setParameter("proess_s", DictcodeConstant.DICT252006);
		return query.list();
	}

	/**
	 * 审核操作
	 * 
	 * @param map
	 * @throws Exception
	 */
	public void isAuding(Map<String, Object> map) throws Exception {
		String barcode_s = map.get("barcode_s").toString();// 获取轮胎条码
		if (barcode_s.equals("")) {
			return;
		}
		// 更新轮胎主表
		// Filter filter = new Filter();
		// filter.set("barcode_s", barcode_s);
		// SQLQuery query = createSQLQuery(getSQL("findMaintyreByCode",
		// filter.getFilter()), CuringMainTyre.class);
		// query.setParameter("barcode_s", barcode_s);
		// query.setParameter("proess_s", DictcodeConstant.DICT252006);
		List<CuringMainTyre> list = getMainTyre(barcode_s, DictcodeConstant.DICT252006);
		if (list.size() == 1) {
			CuringMainTyre maintype = list.get(0);
			maintype.setAtpresentgradecode_s(map.get("gradecode").toString());
			String grade = getGrade(maintype, map.get("gradecode").toString());
			maintype.setQuality_grade_s(grade);
			mainTyreServiceImpl.update(maintype);
		}
		// 更新硫化工单生产实际表
		Filter filter = new Filter();
		filter.set("barcode_s", barcode_s);
		SQLQuery query1 = createSQLQuery(getSQL("findWorkOrderPrintByCode", filter.getFilter()), WorkOrderResult.class);
		query1.setParameter("barcode_s", barcode_s);
		List<WorkOrderResult> listWork = query1.list();
		if (listWork.size() == 1) {
			// WorkOrderResult workOrderResult=listWork.get(0);
			String updateWorkorderresultSql = String.format("update at_c_mm_workorderresult set spare5_s='"
					+ map.get("gradecode").toString() + "' where tyre_barcode_s='" + barcode_s + "'");
			System.out.println(updateWorkorderresultSql);
			RockWellUtils.execSQL(updateWorkorderresultSql); // RockWellUtils.execSQL():更新数据库内表的函数
		}

		// 更新报警中间表
		Filter filterQuality = new Filter();
		filterQuality.set("atr_key", map.get("atr_key").toString());
		SQLQuery query2 = createSQLQuery(getSQL("findQualityDegradeByAtrkey", filterQuality.getFilter()),
				QualityDegrade.class);
		query2.setParameter("atr_key", map.get("atr_key").toString());
		List<QualityDegrade> listQuality = query2.list();
		if (listQuality.size() == 1) {
			QualityDegrade qualityDegrade = listQuality.get(0);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// System.out.println(sdf.format(new Date()));
			String str = sdf.format(new Date());
			String updateWorkorderresultSql = String.format("update AT_C_MM_QUALITYDEGRADE "
					+ "set auditing_status_s=2,AUDITING_USERID_S='" + LLWebUtils.getUser().getUserCode()
					+ "' ,AUDITING_TIME_T=TO_DATE('" + str + "','yyyy-MM-dd hh:mi:ss')" + " where atr_key='"
					+ map.get("atr_key").toString() + "'");
			RockWellUtils.execSQL(updateWorkorderresultSql); // RockWellUtils.execSQL():更新数据库内表的函数
		}

	}

	/**
	 * 修改轮胎主表中 总等级与硫化等级 撤销审核操作
	 * 
	 * @param ids
	 *            界面操作的行ID
	 * @throws Exception
	 */
	public void forced(Map<String, Object> map) throws Exception {
		String barcode_s = map.get("barcode_s").toString();// 获取轮胎条码
		if (barcode_s.equals("")) {
			return;
		}
		// Filter filter = new Filter();
		// filter.set("barcode_s", barcode_s);
		// SQLQuery query = createSQLQuery(getSQL("findMaintyreByCode",
		// filter.getFilter()), CuringMainTyre.class);
		// query.setParameter("barcode_s", barcode_s);
		//
		CuringMainTyre maintype = new CuringMainTyre();
		List<CuringMainTyre> list = getMainTyre(barcode_s, DictcodeConstant.DICT252006);
		if (list.size() == 1) {
			maintype = list.get(0);
			maintype.setAtpresentgradecode_s("253007");

			String grade = getGrade(maintype, null);
			if (StringHelper.isNullOrEmpty(grade)) {
				maintype.setQuality_grade_s("253007");
			} else {
				maintype.setQuality_grade_s(grade);
			}
			mainTyreServiceImpl.update(maintype);
		}
		// 更新硫化工单生产实际表
		Filter filter = new Filter();
		filter.set("barcode_s", barcode_s);
		SQLQuery query1 = createSQLQuery(getSQL("findWorkOrderPrintByCode", filter.getFilter()), WorkOrderResult.class);
		query1.setParameter("barcode_s", barcode_s);
		List<WorkOrderResult> listWork = query1.list();
		if (listWork.size() == 1) {
			String updateWorkorderresultSql = String.format("update at_c_mm_workorderresult set spare5_s='" + 253007
					+ "' where tyre_barcode_s='" + barcode_s + "'");
			System.out.println(updateWorkorderresultSql);
			RockWellUtils.execSQL(updateWorkorderresultSql); // RockWellUtils.execSQL():更新数据库内表的函数

		}

		// 更新报警中间表
		Filter filterQuality = new Filter();
		filterQuality.set("atr_key", map.get("atr_key").toString());
		SQLQuery query2 = createSQLQuery(getSQL("findQualityDegradeByAtrkey", filterQuality.getFilter()),
				QualityDegrade.class);
		query2.setParameter("atr_key", map.get("atr_key").toString());
		List<QualityDegrade> listQuality = query2.list();
		if (listQuality.size() == 1) {
			QualityDegrade qualityDegrade = listQuality.get(0);
			/*
			 * qualityDegrade.setJudge_userid_s(LLWebUtils.getUser().getUserCode(
			 * )+""+LLWebUtils.getUser().getUserName());
			 * qualityDegrade.setJudge_time_t(new Date());
			 * qualityDegrade.setAuditing_status_s("1");//未审核
			 * update(qualityDegrade);
			 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String str = sdf.format(new Date());
			// str=str.substring(5,6).equals("0")==true?str.substring(0,5)+""+str.substring(6):str;
			System.out.println(str);
			String updateWorkorderresultSql = String.format("update AT_C_MM_QUALITYDEGRADE "
					+ "set auditing_status_s=1,JUDGE_USERID_S='" + LLWebUtils.getUser().getUserCode()
					+ "' ,JUDGE_TIME_T=TO_DATE('" + str + "','yyyy-MM-dd hh:mi:ss')" + " where atr_key='"
					+ map.get("atr_key").toString() + "'");
			System.out.println(updateWorkorderresultSql);
			RockWellUtils.execSQL(updateWorkorderresultSql); // RockWellUtils.execSQL():更新数据库内表的函数
		}

	}

	/**
	 * 查询质量等级
	 * 
	 * @param maintyre
	 * @param grade
	 * @return
	 * @throws Exception
	 */
	public String getGrade(CuringMainTyre maintyre, String gradecode) throws Exception {
		Filter filter = new Filter();
		SQLQuery query = createSQLQuery(getSQL("findprocessgradedesc", filter.getFilter()), ProcessGradeAll.class);
		List<ProcessGradeAll> list = query.list();
		int sort;
		String appsort = "0";// 外观
		String dyna = "0";// 动平衡
		String updatagrade = "0";
		// 动平衡信息
		@SuppressWarnings("unchecked")
		List<CuringMainTyre> balance_mainTyrelist = getMainTyre(maintyre.getTyrebarcode_s(),
				DictcodeConstant.DICT252010);
		CuringMainTyre balance_mainTyre = balance_mainTyrelist.get(0);
		// 外观信息
		@SuppressWarnings("unchecked")
		List<CuringMainTyre> appearance_mainTyrelist = getMainTyre(maintyre.getTyrebarcode_s(),
				DictcodeConstant.DICT252008);
		CuringMainTyre appearance_mainTyre = appearance_mainTyrelist.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (!StringHelper.isNullOrEmpty(balance_mainTyre.getAtpresentgradecode_s())) {
				if (balance_mainTyre.getAtpresentgradecode_s().equals("253009")) {
					dyna = "5";
				} else if (list.get(i).getGradecode_i().toString().equals(balance_mainTyre.getAtpresentgradecode_s())) {
					dyna = list.get(i).getSort_i().toString();
				}
				if (list.get(i).getGradecode_i().toString().equals(appearance_mainTyre.getAtpresentgradecode_s())) {
					appsort = list.get(i).getSort_i().toString();
				}
				if (gradecode != null) {
					if (list.get(i).getGradecode_i().toString().equals(gradecode)) {
						updatagrade = list.get(i).getSort_i().toString();
					}
				}
			}
		}
		sort = Integer.parseInt(appsort) > Integer.parseInt(dyna) ? Integer.parseInt(appsort) : Integer.parseInt(dyna);
		if (gradecode != null) {
			sort = Integer.parseInt(updatagrade) > sort ? Integer.parseInt(updatagrade) : sort;
		}
		System.out.println(sort);
		if (sort == 0) {
			return gradecode;
		}
		switch (sort) {
		case 5:
			return "253007";
		case 6:
			return "253009";
		case 10:
			return "253008";
		case 12:
			return "253012";
		case 13:
			return "253013";
		case 11:
			return "253006";
		}
		return "253007";
	}

	/**
	 * 硫化曲线数据的查询
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "null" })
	public List<Map<String, Object>> wirteHx(Map<String, Object> map) throws Exception {
		String barcode_s = map.get("tyreCode").toString();// 获取轮胎条码
		if (barcode_s.equals("")) {
			return null;
		}
		// Filter filter = new Filter();
		// filter.set("barcode_s", barcode_s);
		// SQLQuery query = createSQLQuery(getSQL("findMaintyreByCode",
		// filter.getFilter()), CuringMainTyre.class);
		// query.setParameter("barcode_s", barcode_s);
		List<CuringMainTyre> list = getMainTyre(barcode_s, DictcodeConstant.DICT252006);
		if (list.size() == 1) {
			PIReturnObject rbwdvalue;
			PIReturnObject rhwdvalue;
			PIReturnObject nyvalue;
			PIReturnObject nwvalue;
			PIReturnObject bxvalue;
			WSImplement service = new WSImplement();
			WSInterface portType = service.getBasicHttpBindingWSInterface();
			String codes = null;
			String jth = null;
			String rbwd = null;// 热板温度数据点
			String rhwd = null;// 热环温度数据点
			String ny = null;// 内压数据点
			String nw = null;// 内温数据点
			String bx = null;// 步序
			String equip_code_s = list.get(0).getMachinecode_s();// 获取机台编码
			if (equip_code_s.substring(3, 4) != null) {
				codes = equip_code_s.substring(3, 4);
				jth = equip_code_s.substring(3, 6);
				String position = equip_code_s.substring(6);
				if (LLWebUtils.factory().equals("2")) {
					if (position.equals("L")) {
						if (codes.equals("G") || codes.equals("H") || codes.equals("I") || codes.equals("J")
								|| codes.equals("K") || codes.equals("L")) {
							rbwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftHotBoardTemperatureView";
							rhwd = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
							ny = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
							nw = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftInnerTemperatureView";
							bx = "BGSCADA:BGOPC56:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";
						} else {
							rbwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftHotBoardTemperatureView";
							rhwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
							ny = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
							nw = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftInnerTemperatureView";
							bx = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";
						}
					} else if (position.equals("R")) {
						if (codes.equals("G") || codes.equals("H") || codes.equals("I") || codes.equals("J")
								|| codes.equals("K") || codes.equals("L")) {
							rbwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightHotBoardTemperatureView";
							rhwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
							ny = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerPressureView";
							nw = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerTemperatureView";
							bx = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";
						} else {
							rbwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightHotBoardTemperatureView";
							rhwd = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
							ny = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerPressureView";
							nw = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerTemperatureView";
							bx = "BGSCADA:BGOPC34:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";
						}
					}
				} else if (LLWebUtils.factory().equals("1")) {
					if (position.equals("L")) {
						/*if (codes.equals("D") || codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						*/	rbwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftHotBoardTemperatureView";
							rhwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
							ny = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
							nw = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftInnerTemperatureView";
							bx = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";
						/*} else {
							rbwd = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftHotBoardTemperatureView";
							rhwd = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth + ".Technology.LeftHotRingView";
							ny = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth + ".Technology.LeftInnerPressureView";
							nw = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth
									+ ".Technology.LeftInnerTemperatureView";
							bx = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth + ".Technology.LeftStepView";
						}*/
					} else if (position.equals("R")) {
						/*if (codes.equals("D") || codes.equals("E") || codes.equals("F") || codes.equals("G")) {
						*/	rbwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightHotBoardTemperatureView";
							rhwd = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
							ny = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerPressureView";
							nw = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerTemperatureView";
							bx = "LLJM_SCADA:OPC003:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";
						/*} else {
							rbwd = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightHotBoardTemperatureView";
							rhwd = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth + ".Technology.RightHotRingView";
							ny = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerPressureView";
							nw = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth
									+ ".Technology.RightInnerTemperatureView";
							bx = "QGSCADA:QGOPC12:Curing" + jth + ".Curing" + jth + ".Technology.RightStepView";
						}*/
					}
				}

			}

			// 获取硫化开始时间
			String curing_closemoulddate_t = list.get(0).getStarttime_t()// map.get("curing_closemoulddate_t")
					.toString().replace("-", "");
			curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(" ", "");
			curing_closemoulddate_t = curing_closemoulddate_t.toString().replace(":", "");
			curing_closemoulddate_t = curing_closemoulddate_t.substring(0, curing_closemoulddate_t.indexOf("."));
			// 获取硫化结束时间
			String curing_openmoulddate_t = list.get(0).getOvertime_t().toString().replace("-", "");
			curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(" ", "");
			curing_openmoulddate_t = curing_openmoulddate_t.toString().replace(":", "");
			curing_openmoulddate_t = curing_openmoulddate_t.substring(0, curing_openmoulddate_t.indexOf("."));
			rbwdvalue = portType.queryRealData(equip_code_s, rbwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热板温度的数据
			rhwdvalue = portType.queryRealData(equip_code_s, rhwd, curing_closemoulddate_t, curing_openmoulddate_t);// 获取热环温度的数据
			nyvalue = portType.queryRealData(equip_code_s, ny, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内压的数据
			nwvalue = portType.queryRealData(equip_code_s, nw, curing_closemoulddate_t, curing_openmoulddate_t);// 获取内温的数据
			bxvalue = portType.queryRealData(equip_code_s, bx, curing_closemoulddate_t, curing_openmoulddate_t);// 获取步序的数据
			ArrayOfanyType arry = rbwdvalue.getRPidata();

			List<Object> bb = arry.getAnyType();

			ArrayOfanyType arry1 = rhwdvalue.getRPidata();
			List<Object> bb1 = arry1.getAnyType();

			ArrayOfanyType arry2 = nyvalue.getRPidata();
			List<Object> bb2 = arry2.getAnyType();

			ArrayOfanyType arry3 = nwvalue.getRPidata();
			List<Object> bb3 = arry3.getAnyType();

			ArrayOfanyType arry4 = bxvalue.getRPidata();
			List<Object> bb4 = arry4.getAnyType();

			int numle = 0;
			String engresult = null;
			for(int i = 0 ; i<bb4.size();i++){
				String a = bb4.get(i).toString().split(":")[1];
				Double falg = Double.valueOf(a);

				if(numle != 0 ){
					a="13.88";
					bb4.set(i,bb4.get(i).toString().split(":")[0]+":"+a);
				}
				if (falg > 13.0D){
					numle = 1;
				}
			}
			Integer[] numbers = { bb.size(), bb1.size(), bb2.size(), bb3.size() };
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
					res.put("list", list.get(0));
					result.add(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
			return result;
		}
		return null;
	}

}
