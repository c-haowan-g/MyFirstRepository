package com.bluebirdme.mes.linglong.halfpart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.mes.linglong.building.service.CxProductionDayPlanServiceImpl;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.DictcodeConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanLog;
import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanDTO;

/**
 * 半部件日计划倒退
 * 
 * @author 刘朋
 * @Date 2020-04-20 08:49:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductPlanAutoMakingServiceImpl extends RockWellBaseServiceImpl<ProductPlan> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl serialSrv;// 系统参数获取
	@Resource
	CoreDictionaryServiceImpl dictSrv;
	@Resource
	CxProductionDayPlanServiceImpl cxproductiondayplanSrv;// 成型日计划
	@Resource
	ProductPlanServiceImpl productPlanSrv;// 半部件计划
	@Resource
	ProductPlanLogServiceImpl productPlanLogSrv;// 半部件计划

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ProductPlan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public String saveChanges(ProductPlanDTO productplan) throws Exception {
		List<ProductPlan> productPlanList = new ArrayList<>();
		if (!ListUtils.isEmpty(productplan.getInserted())) {
			productPlanList = productplan.getInserted();
			for (ProductPlan item : productPlanList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setChanged_time_t(new Date());
				item.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				item.setBuildingrecord_s("0");
				item.setPlanfinish_f("0");
				item.setPlanquantity_f(0f);
			}
			save(productPlanList);
		}
		if (!ListUtils.isEmpty(productplan.getDeleted())) {
			productPlanList = productplan.getDeleted();
			for (ProductPlan item : productPlanList) {
				item.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
			}
			update(productPlanList);
		}
		if (!ListUtils.isEmpty(productplan.getUpdated())) {
			productPlanList = productplan.getUpdated();
			for (ProductPlan item : productPlanList) {
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
			}
			update(productPlanList);
		}
		return "操作成功";
	}

	/**
	 * 弹窗提示，字体颜色设置
	 * 
	 * 0错误红色，1正确黑色，2警告橙色
	 * 
	 * @Title: infoStyle
	 * @Description:
	 * @return: String 返回类型
	 * 
	 */
	private String infoStyle(Integer type, String msg) {
		String color = "";
		if (type.equals(0)) {
			color = "<font color=ff0000>";// 错误
		} else if (type.equals(1)) {
			color = "<font color=000000 >";// 正确
		} else if (type.equals(2)) {
			color = "<font color=f7df09>";// 警告
		}
		return color + msg + "<br>";
	}

	List<ProductPlan> productPlanList_Morn = new ArrayList<>();// 新增的日计划列表
	List<ProductPlan> productPlanList_Noon = new ArrayList<>();// 新增的日计划列表
	List<ProductPlan> productPlanList_Even = new ArrayList<>();// 新增的日计划列表
	static String buildingMaterialCode = ""; // 父物料编码（成型物料编码）
	static String buildingMaterialVersion = ""; // 父物料版本（胎胚版本/成型物料版本）
	static String buildingProductStage = ""; // 产品阶段：proPhase
	static String buildingSapVersion = ""; // SAP下发版本号（成本收集器）
	static String customerFlagCommon = "328001";
	static String customerFlagSpecial1 = "328001";
	static String customerFlagSpecial2 = "328001";
	static String mornClass = "118001";
	static String noonClass = "118002";
	static String evenClass = "118003";
	float mornCoefficient = 0f;
	float noonCoefficient = 0f;
	float evenCoefficient = 0f;
	float validTimeCoefficient = 0f;
	float settingRate = 0f;
	Map<String, Object> machineHourMap_Morn = new HashMap<String, Object>();// 创建机台可用时长实时记录表
	Map<String, Object> machineHourMap_Noon = new HashMap<String, Object>();// 创建机台可用时长实时记录表
	Map<String, Object> machineHourMap_Even = new HashMap<String, Object>();// 创建机台可用时长实时记录表
	// 构建早中晚三个物料信息List
	List<Map<String, Object>> mornSubMaterialInfoCommon = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> noonSubMaterialInfoCommon = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> evenSubMaterialInfoCommon = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> mornSubMaterialInfoSpecial = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> noonSubMaterialInfoSpecial = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> evenSubMaterialInfoSpecial = new ArrayList<Map<String, Object>>();
	// 定义变量
	List<Map<String, Object>> subMaterialInfoSpecial = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> subMaterialInfoCommon = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> machineInfoListSpecial = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> machineInfoListCommon = new ArrayList<Map<String, Object>>();
	StringBuffer errorInfoOverall = new StringBuffer();
	List<ProductPlanLog> productPlanLogList = new ArrayList<>();// 异常记录实体
	String buildingDateOverall = "";
	String halfPartDateOverall = "";

	/****************** 按日汇总成型日计划并排产 ******************************/
	/**
	 * 计划按天倒推主函数 刘朋 2019/04/20
	 * 
	 * @return
	 * @throws Exception
	 */
	public String planAutoMakingAccordingToDate(String buildingDate, String halfPartDate) throws Exception {
		mornSubMaterialInfoCommon.clear();
		noonSubMaterialInfoCommon.clear();
		evenSubMaterialInfoCommon.clear();
		subMaterialInfoCommon.clear();
		machineInfoListCommon.clear();
		mornSubMaterialInfoSpecial.clear();
		noonSubMaterialInfoSpecial.clear();
		evenSubMaterialInfoSpecial.clear();
		subMaterialInfoSpecial.clear();
		machineInfoListSpecial.clear();
		machineHourMap_Morn.clear();
		machineHourMap_Noon.clear();
		machineHourMap_Even.clear();
		productPlanList_Morn.clear();
		productPlanList_Noon.clear();
		productPlanList_Even.clear();
		productPlanLogList.clear();
		int errorlength = errorInfoOverall.length();// 取得字符串的长度
		errorInfoOverall.delete(0, errorlength); // 删除字符串从errorInfoOverall处的内容
		buildingDateOverall = buildingDate;
		halfPartDateOverall = halfPartDate;
		/**
		 * Step_1:倒推前校验
		 */
		// 判断是否有已执行的半部件计划,如果有，结束倒推
		planStatusCheckBeforePlanAutoMaking();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}
		// 判断是否存在已审核的成型计划，如果没有，结束倒推
		getBuildingPlan();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}
		// 判断是否维护单班排产系数、机台有效时间系数以及库存满足率阈值，
		// 如果维护，并设置单班排产系数、机台有效时间系数、库存满足率阈值全局变量
		setCoefficient();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}
		/**
		 * Step_2:获取子物料信息(有客户标识+无客户标识)
		 */
		getSubMaterialInfoByDate("1");// 有客户标识
		getSubMaterialInfoByDate("0");// 无客户标识

		/**
		 * Step_3:获得子物料对应的主副产机台及产能信息(有客户标识+无客户标识)并排产
		 */
		// 有客户标识
		if (subMaterialInfoSpecial.isEmpty() == false) {
			getMachineInfoListSpecial();
			if (machineInfoListSpecial.isEmpty() == false) {
				customerSpecialByDate();
			} else {
				errorInfoOverall.append(infoStyle(0, "请联系相关人员维护特殊客户(例如福特)的半部件物料的主副产机台及其产能"));
			}
		}
		// 无客户标识
		if (subMaterialInfoCommon.isEmpty() == false) {
			getMachineInfoListCommon();
			if (machineInfoListCommon.isEmpty() == false) {
				customerCommonByDate();
			} else {
				errorInfoOverall.append(infoStyle(0, "请联系相关人员维护半部件物料的主副产机台及其产能"));
			}
		}

		/**
		 * Step_4:对排好的计划重新设置日计划号和顺序号
		 */
		resetPlanNoAndOrder(productPlanList_Morn, productPlanList_Noon, productPlanList_Even);

		/**
		 * Step_5:存储异常信息
		 */
		productPlanLogSrv.save(productPlanLogList);

		/**
		 * Step_6:返回提示信息
		 */
		if (errorInfoOverall.toString() == null) {
			return "操作成功";
		}
		return errorInfoOverall.toString();
	}

	/**
	 * 校验半部件计划日期是否有半部件计划已在执行(或已暂停、已关闭)，如果有则报错不允许倒推
	 * 说明：(104003:已下发;104004：已执行;104005:已暂停；104006：已关闭 刘朋
	 * 
	 * @throws Exception
	 */
	public void planStatusCheckBeforePlanAutoMaking() throws Exception {
		SQLQuery planStatusCheckBeforePlanAutoMaking = createSQLQuery(getSQL("getExecutedPlan"));
		planStatusCheckBeforePlanAutoMaking.setParameter("halfPartDate", halfPartDateOverall);
		planStatusCheckBeforePlanAutoMaking.setParameter("factory", LLWebUtils.factory());
		if (planStatusCheckBeforePlanAutoMaking.list().size() != 0
				|| planStatusCheckBeforePlanAutoMaking.list().isEmpty() == false) {
			errorInfoOverall.append(infoStyle(0, halfPartDateOverall + "日已有半部件计划执行，不可倒推"));
		}
	}

	/**
	 * 根据成型计划日期获取成型日计划信息，如果不存在成型计划报错 2019/07/19 刘朋
	 * 
	 * @throws Exception
	 */
	private void getBuildingPlan() throws Exception {
		Where where = new Where();
		where.andEqual("production_date_s", buildingDateOverall);
		where.andEqual("s_factory_s", LLWebUtils.factory());
		where.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		where.andEqual("status_s", DictcodeConstant.DICT152002);// 计划状态
		List<Object> buildingPlanList = cxproductiondayplanSrv.findByWhere(where);
		if (buildingPlanList.isEmpty() || buildingPlanList.toString() == null || buildingPlanList.toString() == "") {
			errorInfoOverall.append(infoStyle(0, "成型计划日期" + buildingDateOverall + "无已审核的成型日计划，请联系成型计划员核查相关情况"));
		}
	}

	/**
	 * 判断是否维护单班排产系数、机台有效时间系数以及库存满足率阈值， 如果维护，
	 * 
	 * 并设置单班排产系数、机台有效时间系数、库存满足率阈值全局变量 2019/07/19 刘朋
	 * 
	 * @throws Exception
	 */
	public void setCoefficient() throws Exception {
		SQLQuery getCoefficient = createSQLQuery(getSQL("getCoefficient"));
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> getCoefficientList = getCoefficient.list();
		if (getCoefficientList.isEmpty()) {
			errorInfoOverall.append(infoStyle(0, "排产相关系数（单班排产系数、机台有效时间、库存满足率阈值）查询失败，请核对数据字典"));
			return;
		}
		Map<String, Object> coefficientMap = getCoefficientList.get(0);
		if (coefficientMap.get("MORNCOEFFICIENT") == null) {
			errorInfoOverall.append(infoStyle(0, "根据基础数据字典131，查询到的早班班排产系数值为空，请核实"));
			return;
		}
		if (coefficientMap.get("NOONCOEFFICIENT") == null) {
			errorInfoOverall.append(infoStyle(0, "根据基础数据字典131，查询到的中班班排产系数值为空，请核实"));
			return;
		}
		if (coefficientMap.get("EVENCOEFFICIENT") == null) {
			errorInfoOverall.append(infoStyle(0, "根据基础数据字典131，查询到的晚班班排产系数值为空，请核实"));
			return;
		}
		if (coefficientMap.get("VALIDTIMECOEFFICIENT") == null) {
			errorInfoOverall.append(infoStyle(0, "根据基础数据字典132，查询到机台有效小时系数值为空，请核实"));
			return;
		}
		if (coefficientMap.get("SETTINGRATE") == null) {
			errorInfoOverall.append(infoStyle(0, "根据基础数据字典135，查询到物料库存满足率阈值值为空，请核实"));
			return;
		}
		mornCoefficient = Float.parseFloat(coefficientMap.get("MORNCOEFFICIENT").toString());
		noonCoefficient = Float.parseFloat(coefficientMap.get("NOONCOEFFICIENT").toString());
		evenCoefficient = Float.parseFloat(coefficientMap.get("EVENCOEFFICIENT").toString());
		validTimeCoefficient = Float.parseFloat(coefficientMap.get("VALIDTIMECOEFFICIENT").toString());
		settingRate = Float.parseFloat(coefficientMap.get("SETTINGRATE").toString());
	}

	/**
	 * 获取早中晚三班物料信息 刘朋 2019/07/29
	 * 
	 * @param customerFlag
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void getSubMaterialInfoByDate(String customerFlag) throws NumberFormatException, Exception {
		float mornFillRate = 0f;
		float noonFillRate = 0f;
		float evenFillRate = 0f;
		String subMaterial = "";
		String subMaterial_1 = "";
		String customer = "";
		float materialStock = 0f;
		float demandCapacity = 0f;
		float mornDemandCapacity = 0f;
		float noonDemandCapacity = 0f;
		float evenDemandCapacity = 0f;
		/**
		 * 获取成型计划有客户标识的物料信息并排序
		 */
		if (customerFlag.equals("1")) {
			// Step_1:获取子件物料信息
			SQLQuery getSubMaterialInfo = createSQLQuery(getSQL("getSubMaterialInfoSpecial"));
			getSubMaterialInfo.setParameter("buildingDate", buildingDateOverall);
			getSubMaterialInfo.setParameter("customerFlag", customerFlagCommon);
			getSubMaterialInfo.setParameter("factory", LLWebUtils.factory());
			getSubMaterialInfo.setParameter("werks_s", LLConstant.JING_MEN_CODE);
			subMaterialInfoSpecial = getSubMaterialInfo.list();
			// Step_2:获取子件物料的当前库存量
			SQLQuery getStock = createSQLQuery(getSQL("getFillRateSpecialByDate"));
			getStock.setParameter("buildingDate", buildingDateOverall);
			getStock.setParameter("customerFlag", customerFlagCommon);
			getStock.setParameter("factory", LLWebUtils.factory());
			getStock.setParameter("werks_s", LLConstant.JING_MEN_CODE);
			List<Map<String, Object>> stockList = getStock.list();
			Map<String, Object> subMaterialInfoMap = new HashMap<>();
			/*
			 * Step_3根据Step_2中物料的库存量计算物料早中晚三个班的库存满足率
			 * 
			 * 根据总需求量以及单班排产系数计算三班的需求量
			 * 
			 * 构造早中晚三班的物料信息
			 */
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				// 定义物料对应的三班Map
				Map<String, Object> mornSubMaterialInfoMap = new HashMap<>();// 早
				Map<String, Object> noonSubMaterialInfoMap = new HashMap<>();// 中
				Map<String, Object> evenSubMaterialInfoMap = new HashMap<>();// 晚
				// 获取物料Map
				subMaterialInfoMap = subMaterialInfoSpecial.get(i);
				// 在Map中取物料编码
				subMaterial = subMaterialInfoMap.get("SUBMATERIAL").toString();
				// 在Map中获取客户标识
				customer = subMaterialInfoMap.get("CUSTOMER_FLAG_S").toString();
				// 在Map中取当前物料的当天总需求量
				demandCapacity = Float.parseFloat(subMaterialInfoSpecial.get(i).get("DEMANDCAPACITY").toString());
				// 按天计算单班需求量
				mornDemandCapacity = demandCapacity * mornCoefficient;// 早
				noonDemandCapacity = demandCapacity * noonCoefficient;// 中
				evenDemandCapacity = demandCapacity * evenCoefficient;// 晚
				// 循环
				for (int j = 0; j < stockList.size(); j++) {
					subMaterial_1 = stockList.get(j).get("SUBMATERIAL").toString();
					if (subMaterial.equals(subMaterial_1)) {
						materialStock = Float.parseFloat(stockList.get(j).get("STOCK").toString());// 获得当前物料的库存量
						// 计算当前物料的三班库存满足率
						mornFillRate = materialStock / mornDemandCapacity;// 早
						noonFillRate = materialStock / noonDemandCapacity;// 中
						evenFillRate = materialStock / evenDemandCapacity;// 晚
						// 设置Map物料编码
						mornSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						noonSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						evenSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						// 设置Map单班总需求量
						mornSubMaterialInfoMap.put("DEMANDCAPACITY", mornDemandCapacity);
						noonSubMaterialInfoMap.put("DEMANDCAPACITY", noonDemandCapacity);
						evenSubMaterialInfoMap.put("DEMANDCAPACITY", evenDemandCapacity);
						// 设置Map单班库存满足率
						mornSubMaterialInfoMap.put("FILLRATE", mornFillRate);
						noonSubMaterialInfoMap.put("FILLRATE", noonFillRate);
						evenSubMaterialInfoMap.put("FILLRATE", evenFillRate);
						// 设置Map客户标识
						mornSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						noonSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						evenSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						// 将三班Map加到对应List中
						mornSubMaterialInfoSpecial.add(i, mornSubMaterialInfoMap);
						noonSubMaterialInfoSpecial.add(i, noonSubMaterialInfoMap);
						evenSubMaterialInfoSpecial.add(i, evenSubMaterialInfoMap);
						break;
					}
				}
			}
			// Step_4:对三班的物料信息根据库存满足率逆排序(物料的库存满足率越大，排产优先级越低)
			float fillRate1 = 0f;
			float fillRate2 = 0f;
			for (int i = 0; i < subMaterialInfoSpecial.size() - 1; i++) {
				for (int j = 0; j < subMaterialInfoSpecial.size() - i - 1; j++) {
					// 重新声明传参对象
					Map<String, Object> mornSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> mornSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> tempMapMorn = new HashMap<String, Object>();
					Map<String, Object> tempMapNoon = new HashMap<String, Object>();
					Map<String, Object> tempMapEven = new HashMap<String, Object>();
					/*** 早班排序 ***/
					mornSubMaterialInfoMap1 = mornSubMaterialInfoSpecial.get(j);
					mornSubMaterialInfoMap2 = mornSubMaterialInfoSpecial.get(j + 1);
					// 获取相邻两个Map的库存满足率
					fillRate1 = Float.parseFloat(mornSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(mornSubMaterialInfoMap2.get("FILLRATE").toString());
					// 比较两个库存满足率的大小,冒泡排序
					if (fillRate1 > fillRate2) {
						tempMapMorn = mornSubMaterialInfoMap2;
						mornSubMaterialInfoSpecial.set(j + 1, mornSubMaterialInfoMap1);
						mornSubMaterialInfoSpecial.set(j, tempMapMorn);
					}
					/*** 中班排序 ***/
					noonSubMaterialInfoMap1 = noonSubMaterialInfoSpecial.get(j);
					noonSubMaterialInfoMap2 = noonSubMaterialInfoSpecial.get(j + 1);
					fillRate1 = Float.parseFloat(noonSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(noonSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapNoon = noonSubMaterialInfoMap2;
						noonSubMaterialInfoSpecial.set(j + 1, noonSubMaterialInfoMap1);
						noonSubMaterialInfoSpecial.set(j, tempMapNoon);
					}
					/*** 晚班排序 ***/
					evenSubMaterialInfoMap1 = evenSubMaterialInfoSpecial.get(j);
					evenSubMaterialInfoMap2 = evenSubMaterialInfoSpecial.get(j + 1);
					fillRate1 = Float.parseFloat(evenSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(evenSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapEven = evenSubMaterialInfoMap2;
						evenSubMaterialInfoSpecial.set(j + 1, evenSubMaterialInfoMap1);
						evenSubMaterialInfoSpecial.set(j, tempMapEven);
					}
				}
			}
			// Step_5:对三班的物料信息根据换上胶案数量排序(库存满足率大于阈值的物料,按照换上胶案数量逆排序)
			String priorMaterial = "";
			String laterMaterial = "";
			String laterMaterial_1 = "";
			Integer leastPlasticAddNum = 1000;
			Integer plasticAddNum = 0;
			Integer plasticAddNum_1 = 0;
			Map<String, Object> middleMapMorn = new HashMap<>();
			Map<String, Object> middleMapNoon = new HashMap<>();
			Map<String, Object> middleMapEven = new HashMap<>();
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取前一天的早班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(noonSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						SQLQuery getLastDaySubMaterial = createSQLQuery(getSQL("getLastDaySubMaterial"));
						getLastDaySubMaterial.setParameter("halfPartDate",
								String.valueOf(Integer.parseInt(halfPartDateOverall) - 1));
						getLastDaySubMaterial.setParameter("classCode", mornClass);
						getLastDaySubMaterial.setParameter("factory", LLWebUtils.factory());
						if (getLastDaySubMaterial.list().isEmpty()) {
							errorInfoOverall.append(infoStyle(0,
									String.valueOf(Integer.parseInt(halfPartDateOverall) - 1) + "无早班计划,"
											+ halfPartDateOverall + "日中班的第一个排产物料取库存满足率最低者"));
							continue;
						} else {
							priorMaterial = getLastDaySubMaterial.uniqueResult().toString();
						}
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = noonSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = noonSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapNoon = noonSubMaterialInfoSpecial.get(0);
								noonSubMaterialInfoSpecial.set(0, noonSubMaterialInfoSpecial.get(j + 1));
								noonSubMaterialInfoSpecial.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = noonSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = noonSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapNoon = noonSubMaterialInfoSpecial.get(i);
							noonSubMaterialInfoSpecial.set(i, noonSubMaterialInfoSpecial.get(i + j));
							noonSubMaterialInfoSpecial.set(i + j, middleMapNoon);
						}
					}
				}
			}
			// 按库存满足率排序后的晚班物料按换上教案数量排序;注意：第一个对比物料取当天的中班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(evenSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = noonSubMaterialInfoSpecial.get(noonSubMaterialInfoSpecial.size() - 1)
								.toString();
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = evenSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = evenSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapEven = evenSubMaterialInfoSpecial.get(0);
								evenSubMaterialInfoSpecial.set(0, mornSubMaterialInfoSpecial.get(j + 1));
								evenSubMaterialInfoSpecial.set(j + 1, middleMapEven);
							}
						}
						continue;
					}
					priorMaterial = evenSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = evenSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapEven = evenSubMaterialInfoSpecial.get(i);
							evenSubMaterialInfoSpecial.set(i, evenSubMaterialInfoSpecial.get(i + j));
							evenSubMaterialInfoSpecial.set(i + j, middleMapEven);
						}
					}
				}
			}
			// 按库存满足率排序后的早班物料按换上教案数量排序;注意：第一个对比物料取当天的晚班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(mornSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = evenSubMaterialInfoSpecial.get(evenSubMaterialInfoSpecial.size() - 1)
								.get("SUBMATERIAL").toString();
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = mornSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = mornSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapMorn = mornSubMaterialInfoSpecial.get(0);
								mornSubMaterialInfoSpecial.set(0, mornSubMaterialInfoSpecial.get(j + 1));
								mornSubMaterialInfoSpecial.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = mornSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = mornSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapMorn = mornSubMaterialInfoSpecial.get(i);
							mornSubMaterialInfoSpecial.set(i, mornSubMaterialInfoSpecial.get(i + j));
							mornSubMaterialInfoSpecial.set(i + j, middleMapMorn);
						}
					}
				}
			}
		} else {
			/**
			 * 获取无客户标识的物料信息并排序
			 */
			// Step_1:获取子件物料信息List-A1
			SQLQuery getSubMaterialInfo = createSQLQuery(getSQL("getSubMaterialInfoCommon"));
			getSubMaterialInfo.setParameter("buildingDate", buildingDateOverall);
			getSubMaterialInfo.setParameter("customerFlag", customerFlagCommon);
			getSubMaterialInfo.setParameter("factory", LLWebUtils.factory());
			getSubMaterialInfo.setParameter("werks_s", LLConstant.JING_MEN_CODE);
			subMaterialInfoCommon = getSubMaterialInfo.list();
			// Step_2:获取子件物料的当前库存量
			SQLQuery getStock = createSQLQuery(getSQL("getFillRateCommonByDate"));
			getStock.setParameter("buildingDate", buildingDateOverall);
			getStock.setParameter("customerFlag", customerFlagCommon);
			getStock.setParameter("factory", LLWebUtils.factory());
			getStock.setParameter("werks_s", LLConstant.JING_MEN_CODE);
			List<Map<String, Object>> stockList = getStock.list();
			Map<String, Object> subMaterialInfoMap = new HashMap<>();
			/*
			 * Step_3根据Step_2中物料的库存量计算物料早中晚三个班的库存满足率根据总需求量以及单班排产系数计算三班的需求量
			 * 构造早中晚三班的物料信息
			 */
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				// 定义物料对应的三班Map
				Map<String, Object> mornSubMaterialInfoMap = new HashMap<>();// 早
				Map<String, Object> noonSubMaterialInfoMap = new HashMap<>();// 中
				Map<String, Object> evenSubMaterialInfoMap = new HashMap<>();// 晚
				// 获取物料Map
				subMaterialInfoMap = subMaterialInfoCommon.get(i);
				// 在Map中取物料编码
				subMaterial = subMaterialInfoMap.get("SUBMATERIAL").toString();
				// 在Map中获取客户标识
				customer = subMaterialInfoMap.get("CUSTOMER_FLAG_S").toString();
				// 在Map中取当前物料的当天总需求量
				demandCapacity = Float.parseFloat(subMaterialInfoCommon.get(i).get("DEMANDCAPACITY").toString());
				// 按天计算单班需求量
				mornDemandCapacity = demandCapacity * mornCoefficient;// 早
				noonDemandCapacity = demandCapacity * noonCoefficient;// 中
				evenDemandCapacity = demandCapacity * evenCoefficient;// 晚
				// 循环
				for (int j = 0; j < stockList.size(); j++) {
					subMaterial_1 = stockList.get(j).get("SUBMATERIAL").toString();
					if (subMaterial.equals(subMaterial_1)) {
						materialStock = Float.parseFloat(stockList.get(j).get("STOCK").toString());// 获得当前物料的库存量
						// 计算当前物料的三班库存满足率
						mornFillRate = materialStock / mornDemandCapacity;// 早
						noonFillRate = materialStock / noonDemandCapacity;// 中
						evenFillRate = materialStock / evenDemandCapacity;// 晚
						// 设置Map物料编码
						mornSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						noonSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						evenSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						// 设置Map单班总需求量
						mornSubMaterialInfoMap.put("DEMANDCAPACITY", mornDemandCapacity);
						noonSubMaterialInfoMap.put("DEMANDCAPACITY", noonDemandCapacity);
						evenSubMaterialInfoMap.put("DEMANDCAPACITY", evenDemandCapacity);
						// 设置Map单班库存满足率
						mornSubMaterialInfoMap.put("FILLRATE", mornFillRate);
						noonSubMaterialInfoMap.put("FILLRATE", noonFillRate);
						evenSubMaterialInfoMap.put("FILLRATE", evenFillRate);
						// 设置Map客户标识
						mornSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						noonSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						evenSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						// 将三班Map加到对应List中
						mornSubMaterialInfoCommon.add(i, mornSubMaterialInfoMap);
						noonSubMaterialInfoCommon.add(i, noonSubMaterialInfoMap);
						evenSubMaterialInfoCommon.add(i, evenSubMaterialInfoMap);
						break;
					}
				}
			}
			// Step_4:对三班的物料信息根据库存满足率逆排序(物料的库存满足率越大，排产优先级越低)
			float fillRate1 = 0f;
			float fillRate2 = 0f;
			for (int i = 0; i < subMaterialInfoCommon.size() - 1; i++) {
				for (int j = 0; j < subMaterialInfoCommon.size() - i - 1; j++) {
					// 重新声明传参对象
					Map<String, Object> mornSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> mornSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> tempMapMorn = new HashMap<String, Object>();
					Map<String, Object> tempMapNoon = new HashMap<String, Object>();
					Map<String, Object> tempMapEven = new HashMap<String, Object>();
					/*** 早班排序 ***/
					mornSubMaterialInfoMap1 = mornSubMaterialInfoCommon.get(j);
					mornSubMaterialInfoMap2 = mornSubMaterialInfoCommon.get(j + 1);
					// 获取相邻两个Map的库存满足率
					fillRate1 = Float.parseFloat(mornSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(mornSubMaterialInfoMap2.get("FILLRATE").toString());
					// 比较两个库存满足率的大小,冒泡排序
					if (fillRate1 > fillRate2) {
						tempMapMorn = mornSubMaterialInfoMap2;
						mornSubMaterialInfoCommon.set(j + 1, mornSubMaterialInfoMap1);
						mornSubMaterialInfoCommon.set(j, tempMapMorn);
					}
					/*** 中班排序 ***/
					noonSubMaterialInfoMap1 = noonSubMaterialInfoCommon.get(j);
					noonSubMaterialInfoMap2 = noonSubMaterialInfoCommon.get(j + 1);
					fillRate1 = Float.parseFloat(noonSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(noonSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapNoon = noonSubMaterialInfoMap2;
						noonSubMaterialInfoCommon.set(j + 1, noonSubMaterialInfoMap1);
						noonSubMaterialInfoCommon.set(j, tempMapNoon);
					}
					/*** 晚班排序 ***/
					evenSubMaterialInfoMap1 = evenSubMaterialInfoCommon.get(j);
					evenSubMaterialInfoMap2 = evenSubMaterialInfoCommon.get(j + 1);
					fillRate1 = Float.parseFloat(evenSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(evenSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapEven = evenSubMaterialInfoMap2;
						evenSubMaterialInfoCommon.set(j + 1, evenSubMaterialInfoMap1);
						evenSubMaterialInfoCommon.set(j, tempMapEven);
					}
				}
			}
			// Step_5:对三班的物料信息根据换上胶案数量排序(库存满足率大于阈值的物料,按照换上胶案数量逆排序)
			String priorMaterial = "";
			String laterMaterial = "";
			String laterMaterial_1 = "";
			Integer leastPlasticAddNum = 1000;
			Integer plasticAddNum = 0;
			Integer plasticAddNum_1 = 0;
			Map<String, Object> middleMapMorn = new HashMap<>();
			Map<String, Object> middleMapNoon = new HashMap<>();
			Map<String, Object> middleMapEven = new HashMap<>();
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取昨天的早班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(noonSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						SQLQuery getLastDaySubMaterial = createSQLQuery(getSQL("getLastDaySubMaterial"));
						getLastDaySubMaterial.setParameter("halfPartDate",
								String.valueOf(Integer.parseInt(halfPartDateOverall) - 1));
						getLastDaySubMaterial.setParameter("classCode", mornClass);
						getLastDaySubMaterial.setParameter("factory", LLWebUtils.factory());
						if (getLastDaySubMaterial.list().isEmpty()) {
							errorInfoOverall.append(infoStyle(0,
									String.valueOf(Integer.parseInt(halfPartDateOverall) - 1) + "无早班计划,"
											+ halfPartDateOverall + "日中班的第一个排产物料取库存满足率最低者"));
							continue;
						} else {
							priorMaterial = getLastDaySubMaterial.uniqueResult().toString();
						}
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = noonSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = noonSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapNoon = noonSubMaterialInfoCommon.get(0);
								noonSubMaterialInfoCommon.set(0, noonSubMaterialInfoCommon.get(j + 1));
								noonSubMaterialInfoCommon.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = noonSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = noonSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapNoon = noonSubMaterialInfoCommon.get(i);
							noonSubMaterialInfoCommon.set(i, noonSubMaterialInfoCommon.get(i + j));
							noonSubMaterialInfoCommon.set(i + j, middleMapNoon);
						}
					}
				}
			}
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取今天的中班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(evenSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = noonSubMaterialInfoCommon.get(noonSubMaterialInfoCommon.size() - 1).toString();
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = evenSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = evenSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapEven = evenSubMaterialInfoCommon.get(0);
								evenSubMaterialInfoCommon.set(0, mornSubMaterialInfoCommon.get(j + 1));
								evenSubMaterialInfoCommon.set(j + 1, middleMapEven);
							}
						}
						continue;
					}
					priorMaterial = evenSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = evenSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapEven = evenSubMaterialInfoCommon.get(i);
							evenSubMaterialInfoCommon.set(i, evenSubMaterialInfoCommon.get(i + j));
							evenSubMaterialInfoCommon.set(i + j, middleMapEven);
						}
					}
				}
			}
			// 按库存满足率排序后的早班物料按换上教案数量排序;注意：第一个对比物料取当天的晚班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(mornSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = evenSubMaterialInfoCommon.get(evenSubMaterialInfoCommon.size() - 1).toString();
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = mornSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = mornSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapMorn = mornSubMaterialInfoCommon.get(0);
								mornSubMaterialInfoCommon.set(0, mornSubMaterialInfoCommon.get(j + 1));
								mornSubMaterialInfoCommon.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = mornSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = mornSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapMorn = mornSubMaterialInfoCommon.get(i);
							mornSubMaterialInfoCommon.set(i, mornSubMaterialInfoCommon.get(i + j));
							mornSubMaterialInfoCommon.set(i + j, middleMapMorn);
						}
					}
				}
			}
		}
	}

	/**
	 * 根据物料编码获得换上胶案数量 刘朋 2019/07/19
	 * 
	 * @param firstMaterial
	 * @param secondMaterial
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getPlasticAddNum(String firstMaterial, String secondMaterial) {
		Integer plasticAddNum = 0;
		SQLQuery getPlasticAddNum = createSQLQuery(getSQL("getPlasticAddNum"));
		getPlasticAddNum.setParameter("firstMaterial", firstMaterial);
		getPlasticAddNum.setParameter("secondMaterial", secondMaterial);
		List<Map<String, Object>> getPlasticAddNumResult = getPlasticAddNum.list();
		plasticAddNum = Integer.parseInt(getPlasticAddNumResult.get(0).get("DIFFERENTNUM").toString());
		return plasticAddNum;
	}

	/**
	 * Step_3_1 根据无客户标识的成型计划汇总子物料对应的产能机台信息 刘朋 2019/07/29
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void getMachineInfoListCommon() {
		// Step_5:遍历子物料List-A（已根据库存满足率排序），获得子物料和主、副机台的产能关系List-C,
		Map<String, Object> machineInfoMap = new HashMap<String, Object>();
		String subMaterial_group = "";// 物料组code
		String subMaterial_groupName = "";// 物料组名称
		String hostMachine = "heiheihei";
		String viceMachine = "";
		float hostCapacity = 0f;
		float viceCapacity = 0f;
		SQLQuery getMachineInfo = createSQLQuery(getSQL("getMachineInfoCommon"));
		getMachineInfo.setParameter("buildingDate", buildingDateOverall);
		getMachineInfo.setParameter("customerFlag", customerFlagCommon);
		getMachineInfo.setParameter("factory", LLWebUtils.factory());
		getMachineInfo.setParameter("werks_s", LLConstant.JING_MEN_CODE);
		machineInfoListCommon = getMachineInfo.list();
		SQLQuery getMachineCapacity = createSQLQuery(getSQL("getMachineCapacity"));// 根据子料编码和机台条码获取机台产能
		getMachineCapacity.setParameter("factory", LLWebUtils.factory());
		List<Map<String, Object>> machineCapacityList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < machineInfoListCommon.size(); i++) {
			hostMachine = "";
			viceMachine = "";
			machineInfoMap = machineInfoListCommon.get(i);
			subMaterial_group = machineInfoMap.get("MATGRP_S").toString();// 获取子物料物料组
			subMaterial_groupName = machineInfoMap.get("DICTNAME_S").toString();// 获取子物料物料组
			if (machineInfoMap.get("HOSTMACHINE") != null) {
				hostMachine = machineInfoMap.get("HOSTMACHINE").toString();// 获取子物料维护的主机台
				// 查询主机台的产能
				getMachineCapacity.setParameter("matgrp_s", subMaterial_group);
				getMachineCapacity.setParameter("machine", hostMachine);
				machineCapacityList = getMachineCapacity.list();
				if (machineCapacityList.isEmpty()) {
					errorInfoOverall.append(infoStyle(0, "机台-" + hostMachine + "未维护与物料-" + subMaterial_groupName
							+ "的产能关系,无法排产"));
					inputProductPlanLog(subMaterial_groupName, "", "", hostMachine, "", "", "物料和机台未维护产能关系");
				} else {
					hostCapacity = Float.parseFloat(machineCapacityList.get(0).get("CAPACITY").toString());
					machineInfoMap.replace("HOSTCAPACITY", hostCapacity);
					machineInfoListCommon.set(i, machineInfoMap);
				}
			}
			// 查询副机台的产能（返回结果的副机台不一定存在）
			if (machineInfoMap.get("VICEMACHINE") != null) { // 获取子物料维护的副机台
				viceMachine = machineInfoMap.get("VICEMACHINE").toString();// 根据子料编码和机台条码获取机台产能
				getMachineCapacity.setParameter("matgrp_s", subMaterial_group);
				getMachineCapacity.setParameter("machine", viceMachine);
				machineCapacityList = getMachineCapacity.list();
				if (machineCapacityList.isEmpty()) {
					errorInfoOverall.append(infoStyle(0, "机台-" + hostMachine + "未维护与物料-" + subMaterial_groupName
							+ "的产能关系,无法排产"));
					inputProductPlanLog(subMaterial_groupName, "", "", hostMachine, "", "", "物料和机台未维护产能关系");
				} else {
					viceCapacity = Float.parseFloat(machineCapacityList.get(0).get("CAPACITY").toString());
					machineInfoMap.replace("VICECAPACITY", viceCapacity);
					machineInfoListCommon.set(i, machineInfoMap);
				}
			}
		}
	}

	/**
	 * Step_3_2 根据有客户标识的成型计划汇总子物料对应的产能机台信息 刘朋 2019/07/29
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void getMachineInfoListSpecial() {
		String subMaterial = "";
		String customer = "";
		if (subMaterialInfoSpecial.isEmpty()) {
			return;
		}
		for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
			subMaterial = subMaterialInfoSpecial.get(i).get("SUBMATERIAL").toString();
			customer = subMaterialInfoSpecial.get(i).get("CUSTOMER_FLAG_S").toString();
			SQLQuery getMahcineInfoBySubMaterial = createSQLQuery(getSQL("getMahcineInfoBySubMaterial"));
			getMahcineInfoBySubMaterial.setParameter("subMaterial", subMaterial);
			getMahcineInfoBySubMaterial.setParameter("customer", customer);
			List<Map<String, Object>> getMahcineInfoBySubMaterialList = getMahcineInfoBySubMaterial.list();
			if (getMahcineInfoBySubMaterialList.isEmpty() == false) {
				machineInfoListSpecial.add(getMahcineInfoBySubMaterialList.get(0));
			} else {
				errorInfoOverall.append(infoStyle(0, "客户-" + customer + "未维护物料-" + subMaterial + "的主产机台"));
				inputProductPlanLog(subMaterial, "", customer, "", "", "", "未维护该客户该物料的主产机台");
				continue;
			}
		}
	}

	/**
	 * Step_4_2 有客户标识计划排产 刘朋 2019/04/20
	 * 
	 * @throws Exception
	 */
	private void customerSpecialByDate() throws Exception {
		Map<String, Object> subMaterialInfoMapMorn = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapNoon = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapEven = new HashMap<String, Object>();
		Map<String, Object> machineInfoMap = new HashMap<String, Object>();
		String subMaterialMorn = "";
		String subMaterialMorn_1 = "";
		String subMaterialNoon = "";
		String subMaterialNoon_1 = "";
		String subMaterialEven = "";
		String subMaterialEven_1 = "";
		int listSize = 0;
		listSize = mornSubMaterialInfoSpecial.size();// mornSubMaterialInfoSpecial.size()=noonSubMaterialInfoSpecial,size()=evenSubMaterialInfoSpecial.size()
		/**
		 * 从排序好的早中晚三班物料信息列中逐一获取物料信息并分早中晚三班排产
		 */
		for (int i = 0; i < listSize; i++) {
			// 1.获取物料信息List中的第i个Map
			subMaterialInfoMapMorn = mornSubMaterialInfoSpecial.get(i);
			subMaterialInfoMapNoon = noonSubMaterialInfoSpecial.get(i);
			subMaterialInfoMapEven = evenSubMaterialInfoSpecial.get(i);
			// 2.获取当前物料的物料编码
			subMaterialMorn = subMaterialInfoMapMorn.get("SUBMATERIAL").toString();
			subMaterialNoon = subMaterialInfoMapNoon.get("SUBMATERIAL").toString();
			subMaterialEven = subMaterialInfoMapEven.get("SUBMATERIAL").toString();
			// 3.根据物料编码在机台产能信息列表匹配该物料对应的机台信息，并分早中晚三班排产
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialNoon_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialNoon_1.equals(subMaterialNoon)) {
					// 中班排产
					List<ProductPlan> planList_Noon = productionScheduling_Noon(subMaterialInfoMapNoon, machineInfoMap);
					if (planList_Noon != null) {
						for (int m = 0; m < planList_Noon.size(); m++) {
							productPlanList_Noon.add(planList_Noon.get(m));
						}
					}
				}
			}
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialEven_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialEven_1.equals(subMaterialEven)) {
					// 晚班排产
					List<ProductPlan> planList_Even = productionScheduling_Even(subMaterialInfoMapEven, machineInfoMap);
					if (planList_Even != null) {
						for (int m = 0; m < planList_Even.size(); m++) {
							productPlanList_Even.add(planList_Even.get(m));
						}
					}
				}
			}
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialMorn_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialMorn_1.equals(subMaterialMorn)) {
					// 早班排产
					List<ProductPlan> planList_Morn = productionScheduling_Morn(subMaterialInfoMapMorn, machineInfoMap);
					if (planList_Morn != null) {
						for (int m = 0; m < planList_Morn.size(); m++) {
							productPlanList_Morn.add(planList_Morn.get(m));
						}
					}
				}
			}
		}
	}

	/**
	 * Step_4_1 无客户标识计划排产 刘朋 2019/04/20
	 * 
	 * @throws Exception
	 */
	private void customerCommonByDate() throws Exception {
		Map<String, Object> subMaterialInfoMapMorn = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapNoon = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapEven = new HashMap<String, Object>();
		Map<String, Object> machineInfoMap = new HashMap<String, Object>();
		String subMaterialMorn = "";
		String subMaterialMorn_1 = "";
		String subMaterialNoon = "";
		String subMaterialNoon_1 = "";
		String subMaterialEven = "";
		String subMaterialEven_1 = "";
		int listSize = 0;
		listSize = mornSubMaterialInfoCommon.size();// mornSubMaterialInfoSpecial.size()=noonSubMaterialInfoSpecial,size()=evenSubMaterialInfoSpecial.size()
		/**
		 * 从排序好的早中晚三班物料信息列中逐一获取物料信息并分早中晚三班排产
		 */
		for (int i = 0; i < listSize; i++) {
			// 1.获取物料信息List中的第i个Map
			subMaterialInfoMapMorn = mornSubMaterialInfoCommon.get(i);
			subMaterialInfoMapNoon = noonSubMaterialInfoCommon.get(i);
			subMaterialInfoMapEven = evenSubMaterialInfoCommon.get(i);
			// 2.获取当前物料的物料编码
			subMaterialMorn = subMaterialInfoMapMorn.get("SUBMATERIAL").toString();
			subMaterialNoon = subMaterialInfoMapNoon.get("SUBMATERIAL").toString();
			subMaterialEven = subMaterialInfoMapEven.get("SUBMATERIAL").toString();
			// 3.根据物料编码在机台产能信息列表匹配该物料对应的机台信息，并分早中晚三班排产
			// 中班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialNoon_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialNoon_1.equals(subMaterialNoon)) {
					List<ProductPlan> planList_Noon = productionScheduling_Noon(subMaterialInfoMapNoon, machineInfoMap);
					if (planList_Noon != null) {
						for (int m = 0; m < planList_Noon.size(); m++) {
							productPlanList_Noon.add(planList_Noon.get(m));
						}
					}
				}
			}
			// 晚班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialEven_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialEven_1.equals(subMaterialEven)) {
					List<ProductPlan> planList_Even = productionScheduling_Even(subMaterialInfoMapEven, machineInfoMap);
					if (planList_Even != null) {
						for (int m = 0; m < planList_Even.size(); m++) {
							productPlanList_Even.add(planList_Even.get(m));
						}
					}
				}
			}
			// 早班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialMorn_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialMorn_1.equals(subMaterialMorn)) {
					List<ProductPlan> planList_Morn = productionScheduling_Morn(subMaterialInfoMapMorn, machineInfoMap);
					if (planList_Morn != null) {
						for (int m = 0; m < planList_Morn.size(); m++) {
							productPlanList_Morn.add(planList_Morn.get(m));
						}
					}
				}
			}
		}
	}

	/**
	 * 中班排产并创建计划 刘朋 2019/07/26
	 * 
	 * @param subMaterialInfoMapNoon
	 * @param machineInfoMap
	 * @return
	 * @throws Exception
	 */
	public List<ProductPlan> productionScheduling_Noon(Map<String, Object> subMaterialInfoMapNoon,
			Map<String, Object> machineInfoMap) throws Exception {
		// 创建计划对象
		ProductPlan productPlan = new ProductPlan();// 构建日计划存储对象
		List<ProductPlan> productPlanList = new ArrayList<>();
		float minusHourOnHost = 0f;
		// 在subMaterialInfoMapNoon中获取物料编码、客户标识、中班需求量
		String subMaterial = "";
		String customerFlag = "";
		float classCapacity = 0f;
		// 物料编码
		subMaterial = subMaterialInfoMapNoon.get("SUBMATERIAL").toString();
		// 客户标识
		customerFlag = subMaterialInfoMapNoon.get("CUSTOMER_FLAG_S").toString();
		// 中班需求量
		classCapacity = Float.valueOf(subMaterialInfoMapNoon.get("DEMANDCAPACITY").toString());
		// 在machineInfoMap中获取主产机台、副产机台、主产机台有效小时产能、副产机台有效小时产能
		String hostMachine = "";
		String viceMachine = "";
		// 主产机台
		if (machineInfoMap.get("HOSTMACHINE") != null) {
			hostMachine = machineInfoMap.get("HOSTMACHINE").toString();
		} else {
			errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "未维护主副产机台信息，请前往机台物料维护界面维护"));
			inputProductPlanLog(subMaterial, "", noonClass, "", "", "", "未维护主副产机台信息");
			return null;
		}
		// 主产机台有效小时产能
		float hostCapacity = Float.parseFloat(machineInfoMap.get("HOSTCAPACITY").toString()) * validTimeCoefficient;
		// 副产机台有效小时产能
		float viceCapacity = Float.parseFloat(machineInfoMap.get("VICECAPACITY").toString()) * validTimeCoefficient;
		// 相关中间量存储对象
		float hourOnHost = 0f;// 主产机台需求小时
		float hourOnVice = 0f;// 副产机台需求小时
		float latestHourOnHost = 0f;// 主产机台可用小时
		float latestHourOnVice = 0f;// 副产机台可用小时
		float remainOnVice;// 最终未排产量
		// 子物料排产到机台
		if (hostCapacity != 0f) {
			hourOnHost = classCapacity / hostCapacity;
		} else {
			// errorInfoOverall.append(infoStyle(0, "机台-" + hostMachine +
			// "未维护与物料-" + subMaterial + "的产能关系,无法排产到中班"));
			inputProductPlanLog(subMaterial, "", noonClass, hostMachine, "", "", "物料和机台未维护产能关系");
			return null;
		}
		// 当主产机台不存在时，直排产到副产机台
		if (hostMachine == "") {
			if (machineInfoMap.get("VICEMACHINE") != null) {
				viceMachine = machineInfoMap.get("VICEMACHINE").toString();
				hourOnVice = classCapacity / viceCapacity;
				if (hourOnVice <= 8f) {
					machineHourMap_Noon.put(viceMachine, 8f - hourOnVice);
					productPlan = setPlan(viceMachine, subMaterial, hourOnVice * viceCapacity, noonClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
				} else {
					machineHourMap_Noon.put(viceMachine, 0);
					productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, noonClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
					remainOnVice = hourOnVice * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice + "的需求量无法排产到中班"));
					inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(remainOnVice), "有剩余需求未排产");
					return productPlanList;
				}
			} else {
				errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + classCapacity + "的需求量无法排产到中班"));
				inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(classCapacity), "有剩余需求未排产");
				return productPlanList;
			}
		}
		// step3-计算子物料按班排到主产机台所需的小时
		if (machineHourMap_Noon.containsKey(hostMachine)) {// 如果当前机台已有被使用记录
			latestHourOnHost = Float.parseFloat(machineHourMap_Noon.get(hostMachine).toString());// 获取机台的当前小时产能
			if (hourOnHost <= latestHourOnHost) {// 如果主机台剩余小时数足够排产，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Noon.replace(hostMachine, latestHourOnHost - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, noonClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台剩余小时数不能满足排产，先按照主机台剩余小时排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Noon.replace(hostMachine, 0f);// 更新主机台剩余小时数
				productPlan = setPlan(hostMachine, subMaterial, latestHourOnHost * hostCapacity, noonClass,
						customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - latestHourOnHost;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					if (machineInfoMap.containsKey(viceMachine)) {
						latestHourOnVice = Float.parseFloat(machineHourMap_Noon.get(viceMachine).toString());
						if (hourOnVice <= latestHourOnVice) {
							machineHourMap_Noon.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Noon.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到中班"));
							inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求未排产");
							return productPlanList;
						}
					} else {
						if (hourOnVice <= 8f) {
							machineHourMap_Noon.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Noon.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, noonClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到中班"));
							inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求未排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到中班"));
					inputProductPlanLog(subMaterial, "", noonClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有剩余需求未排产");
					return productPlanList;
				}
			}
		} else {// 如果当前机台没有被使用记录
			if (hourOnHost <= 8f) {// 如果需求小时小于8h，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Noon.put(hostMachine, 8f - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, noonClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台8h不能满足排产，先排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Noon.put(hostMachine, 0f);// 更新主机台剩余小时数
				productPlan = setPlan(hostMachine, subMaterial, 8f * hostCapacity, noonClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - 8f;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					// 当前副机台是否有使用记录
					if (machineInfoMap.containsKey(viceMachine)) {// 有使用记录
						latestHourOnVice = Float.parseFloat(machineHourMap_Noon.get(viceMachine).toString());// 获取机台的当前小时产能
						if (hourOnVice <= latestHourOnVice) {// 如果副机台剩余小时数足够排产，直接排到副机台，并更新副机台剩余小时数
							machineHourMap_Noon.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {// 副机台剩余小时数不能满足排产，按照副机台剩余小时排到副机台，并更新副机台剩余小时数为0
							machineHourMap_Noon.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到中班"));
							inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求未排产");
							return productPlanList;
						}
					} else {
						// 无使用记录，如果需求小时小于8h，直接排到副机台，并更新副机台剩余小时数
						if (hourOnVice <= 8f) {
							machineHourMap_Noon.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, noonClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {// 如果副机台8h不能满足排产，更新副机台剩余小时数为0，提示无法排产原因
							machineHourMap_Noon.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, noonClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到中班"));
							inputProductPlanLog(subMaterial, "", noonClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求未排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到中班"));
					inputProductPlanLog(subMaterial, "", noonClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有剩余需求未排产");
					return productPlanList;
				}
			}
		}
		return productPlanList;
	}

	/**
	 * 晚班排产并创建计划 刘朋 2019/07/26
	 * 
	 * @param subMaterialInfoMapEven
	 * @param machineInfoMap
	 * @return
	 * @throws Exception
	 */
	public List<ProductPlan> productionScheduling_Even(Map<String, Object> subMaterialInfoMapEven,
			Map<String, Object> machineInfoMap) throws Exception {
		// 创建计划对象
		ProductPlan productPlan = new ProductPlan();// 构建日计划存储对象
		List<ProductPlan> productPlanList = new ArrayList<>();
		float minusHourOnHost = 0f;
		// 在subMaterialInfoMapNoon中获取物料编码、客户标识、中班需求量
		String subMaterial = "";
		String customerFlag = "";
		float classCapacity = 0f;
		// 物料编码
		subMaterial = subMaterialInfoMapEven.get("SUBMATERIAL").toString();
		// 客户标识
		customerFlag = subMaterialInfoMapEven.get("CUSTOMER_FLAG_S").toString();
		// 中班需求量
		classCapacity = Float.valueOf(subMaterialInfoMapEven.get("DEMANDCAPACITY").toString());
		// 在machineInfoMap中获取主产机台、副产机台、主产机台有效小时产能、副产机台有效小时产能
		String hostMachine = "";
		String viceMachine = "";
		// 主产机台
		if (machineInfoMap.get("HOSTMACHINE") != null) {
			hostMachine = machineInfoMap.get("HOSTMACHINE").toString();
		} else {
			errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "未维护主副产机台信息，请前往机台物料维护界面维护"));
			inputProductPlanLog(subMaterial, "", evenClass, "", "", "", "未维护主副产机台信息");
			return null;
		}
		// 主产机台有效小时产能
		float hostCapacity = Float.parseFloat(machineInfoMap.get("HOSTCAPACITY").toString()) * validTimeCoefficient;
		// 副产机台有效小时产能
		float viceCapacity = Float.parseFloat(machineInfoMap.get("VICECAPACITY").toString()) * validTimeCoefficient;
		// 相关中间量存储对象
		float hourOnHost = 0f;// 主产机台需求小时
		float hourOnVice = 0f;// 副产机台需求小时
		float latestHourOnHost = 0f;// 主产机台可用小时
		float latestHourOnVice = 0f;// 副产机台可用小时
		float remainOnVice;// 最终未排产量
		// 子物料排产到机台
		if (hostCapacity != 0f) {
			hourOnHost = classCapacity / hostCapacity;
		} else {
			errorInfoOverall.append(infoStyle(0, "机台-" + hostMachine + "未维护与物料-" + subMaterial + "的产能关系,无法排产到晚班"));
			inputProductPlanLog(subMaterial, "", evenClass, hostMachine, "", "", "物料和机台的产能关系");
			return productPlanList;
		}
		// 当主产机台不存在时，直排产到副产机台
		if (hostMachine == "") {
			if (machineInfoMap.get("VICEMACHINE") != null) {
				viceMachine = machineInfoMap.get("VICEMACHINE").toString();
				hourOnVice = classCapacity / viceCapacity;
				if (hourOnVice <= 8f) {
					machineHourMap_Even.put(viceMachine, 8f - hourOnVice);
					productPlan = setPlan(viceMachine, subMaterial, hourOnVice * viceCapacity, evenClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
				} else {
					machineHourMap_Even.put(viceMachine, 0);
					productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, evenClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
					remainOnVice = hourOnVice * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice + "的需求量无法排产到晚班"));
					inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice), "有剩余需求未排产");
					return productPlanList;
				}
			} else {
				errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + classCapacity + "的需求量无法排产到晚班"));
				inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(classCapacity), "有剩余需求未排产");
				return productPlanList;
			}
		}
		// step3-计算子物料按班排到主产机台所需的小时
		if (machineHourMap_Even.containsKey(hostMachine)) {// 如果当前机台已有被使用记录
			latestHourOnHost = Float.parseFloat(machineHourMap_Even.get(hostMachine).toString());// 获取机台的当前小时产能
			if (hourOnHost <= latestHourOnHost) {// 如果主机台剩余小时数足够排产，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Even.replace(hostMachine, latestHourOnHost - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, evenClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台剩余小时数不能满足排产，先按照主机台剩余小时排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Even.replace(hostMachine, 0f);// 更新主机台剩余小时数
				productPlan = setPlan(hostMachine, subMaterial, latestHourOnHost * hostCapacity, evenClass,
						customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - latestHourOnHost;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					if (machineInfoMap.containsKey(viceMachine)) {
						latestHourOnVice = Float.parseFloat(machineHourMap_Even.get(viceMachine).toString());
						if (hourOnVice <= latestHourOnVice) {
							machineHourMap_Even.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Even.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到晚班"));
							inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求量无法排产");
							return productPlanList;
						}
					} else {
						if (hourOnVice <= 8f) {
							machineHourMap_Even.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Even.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, evenClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到晚班"));
							inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求量无法排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到晚班"));
					inputProductPlanLog(subMaterial, "", evenClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有剩余需求量无法排产");
					return productPlanList;
				}
			}
		} else {// 如果当前机台没有被使用记录
			if (hourOnHost <= 8f) {// 如果需求小时小于8h，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Even.put(hostMachine, 8f - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, evenClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台8h不能满足排产，先排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Even.put(hostMachine, 0f);// 更新主机台剩余小时数
				productPlan = setPlan(hostMachine, subMaterial, 8f * hostCapacity, evenClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - 8f;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					if (machineInfoMap.containsKey(viceMachine)) {
						latestHourOnVice = Float.parseFloat(machineHourMap_Even.get(viceMachine).toString());
						if (hourOnVice <= latestHourOnVice) {
							machineHourMap_Even.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Even.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到晚班"));
							inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求量无法排产");
							return productPlanList;
						}
					} else {
						if (hourOnVice <= 8f) {
							machineHourMap_Even.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, evenClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Even.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, evenClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到晚班"));
							inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice),
									"有剩余需求量无法排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到晚班"));
					inputProductPlanLog(subMaterial, "", evenClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有剩余需求量无法排产");
					return productPlanList;
				}
			}
		}
		return productPlanList;
	}

	/**
	 * 早班排产并创建计划 刘朋 2019/07/26
	 * 
	 * @param subMaterialInfoMapMorn
	 * @param machineInfoMap
	 * @return
	 * @throws Exception
	 */
	public List<ProductPlan> productionScheduling_Morn(Map<String, Object> subMaterialInfoMapMorn,
			Map<String, Object> machineInfoMap) throws Exception {
		// 创建计划对象
		ProductPlan productPlan = new ProductPlan();// 构建日计划存储对象
		List<ProductPlan> productPlanList = new ArrayList<>();
		float minusHourOnHost = 0f;
		// 在subMaterialInfoMapMorn中获取物料编码、客户标识、中班需求量
		String subMaterial = "";
		String customerFlag = "";
		float classCapacity = 0f;
		// 物料编码
		subMaterial = subMaterialInfoMapMorn.get("SUBMATERIAL").toString();
		// 客户标识
		customerFlag = subMaterialInfoMapMorn.get("CUSTOMER_FLAG_S").toString();
		// 中班需求量
		classCapacity = Float.valueOf(subMaterialInfoMapMorn.get("DEMANDCAPACITY").toString());
		// 在machineInfoMap中获取主产机台、副产机台、主产机台有效小时产能、副产机台有效小时产能
		String hostMachine = "";
		String viceMachine = "";
		// 主产机台
		if (machineInfoMap.get("HOSTMACHINE") != null) {
			hostMachine = machineInfoMap.get("HOSTMACHINE").toString();
		} else {
			// errorInfoOverall.append(infoStyle(0,"物料-"+subMaterial+"未维护主副产机台信息，请前往机台物料维护界面维护"));
			inputProductPlanLog(subMaterial, "", mornClass, "", "", "", "未维护主副产机台信息");
			return null;
		}
		// 主产机台有效小时产能
		float hostCapacity = Float.parseFloat(machineInfoMap.get("HOSTCAPACITY").toString()) * validTimeCoefficient;
		// 副产机台有效小时产能
		float viceCapacity = Float.parseFloat(machineInfoMap.get("VICECAPACITY").toString()) * validTimeCoefficient;
		// 相关中间量存储对象
		float hourOnHost = 0f;// 主产机台需求小时
		float hourOnVice = 0f;// 副产机台需求小时
		float latestHourOnHost = 0f;// 主产机台可用小时
		float latestHourOnVice = 0f;// 副产机台可用小时
		float remainOnVice;// 最终未排产量
		// 子物料排产到机台
		if (hostCapacity != 0f) {
			hourOnHost = classCapacity / hostCapacity;
		} else {
			errorInfoOverall.append(infoStyle(0, "机台-" + hostMachine + "未维护与物料-" + subMaterial + "的产能关系,无法排产到早班"));
			inputProductPlanLog(subMaterial, "", "", hostMachine, "", "", "未维护机台和物料的产能关系");
			return productPlanList;
		}
		// 当主产机台不存在时，直排产到副产机台
		if (hostMachine == "") {
			if (machineInfoMap.get("VICEMACHINE") != null) {
				viceMachine = machineInfoMap.get("VICEMACHINE").toString();
				hourOnVice = classCapacity / viceCapacity;
				if (hourOnVice <= 8f) {
					machineHourMap_Morn.put(viceMachine, 8f - hourOnVice);
					productPlan = setPlan(viceMachine, subMaterial, hourOnVice * viceCapacity, mornClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
				} else {
					machineHourMap_Morn.put(viceMachine, 0);
					productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, mornClass, customerFlag);
					if (productPlan != null) {
						productPlanList.add(productPlan);
					}
					remainOnVice = hourOnVice * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice + "的需求量无法排产到早班"));
					inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(remainOnVice), "有剩余需求未排产");
					return productPlanList;
				}
			} else {
				errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + classCapacity + "的需求量无法排产到早班"));
				inputProductPlanLog(subMaterial, "", evenClass, "", "", String.valueOf(classCapacity), "有剩余需求未排产");
				return productPlanList;
			}
		}
		// step3-计算子物料按班排到主产机台所需的小时
		if (machineHourMap_Morn.containsKey(hostMachine)) {// 如果当前机台已有被使用记录
			latestHourOnHost = Float.parseFloat(machineHourMap_Morn.get(hostMachine).toString());// 获取机台的当前小时产能
			if (hourOnHost <= latestHourOnHost) {// 如果主机台剩余小时数足够排产，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Morn.replace(hostMachine, latestHourOnHost - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, mornClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台剩余小时数不能满足排产，先按照主机台剩余小时排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Morn.replace(hostMachine, 0f);// 更新主机台剩余小时数
				productPlan = setPlan(hostMachine, subMaterial, latestHourOnHost * hostCapacity, mornClass,
						customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - latestHourOnHost;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					if (machineInfoMap.containsKey(viceMachine)) {
						latestHourOnVice = Float.parseFloat(machineHourMap_Morn.get(viceMachine).toString());
						if (hourOnVice <= latestHourOnVice) {
							machineHourMap_Morn.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Morn.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到早班"));
							inputProductPlanLog(subMaterial, "", mornClass, "", "", String.valueOf(remainOnVice),
									"有多余物料未排产");
							return productPlanList;
						}
					} else {
						if (hourOnVice <= 8f) {
							machineHourMap_Morn.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Morn.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, mornClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到早班"));
							inputProductPlanLog(subMaterial, "", mornClass, "", "", String.valueOf(remainOnVice),
									"有多余物料未排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到早班"));
					inputProductPlanLog(subMaterial, "", mornClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有多余物料未排产");
					return productPlanList;
				}
			}
		} else {// 如果当前机台没有被使用记录
			if (hourOnHost <= 8f) {// 如果需求小时小于8h，直接排到主机台，并更新主机台剩余小时数
				machineHourMap_Morn.put(hostMachine, 8f - hourOnHost);
				productPlan = setPlan(hostMachine, subMaterial, classCapacity, mornClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
			} else {// 如果主机台8h不能满足排产，先排到主机台，并更新主机台剩余小时数为0，再将剩余需求排到副机台
					// 先排产主机台
				machineHourMap_Morn.put(hostMachine, 0f);// 更新主机台剩余小时数
				// machineHourMap_Morn.replace(hostMachine,0f);
				productPlan = setPlan(hostMachine, subMaterial, 8f * hostCapacity, mornClass, customerFlag);
				if (productPlan != null) {
					productPlanList.add(productPlan);
				}
				// 再将剩余量排产到副机台
				minusHourOnHost = hourOnHost - 8f;// 主机台无法排产的小时
				if ((machineInfoMap.get("VICEMACHINE") != null) && (viceCapacity != 0f)) {// 先判断是否有副产机台，以及是否维护了产能，如果没有就不用排产了
					viceMachine = machineInfoMap.get("VICEMACHINE").toString();
					hourOnVice = minusHourOnHost * hostCapacity / viceCapacity;
					if (machineInfoMap.containsKey(viceMachine)) {
						latestHourOnVice = Float.parseFloat(machineHourMap_Morn.get(viceMachine).toString());
						if (hourOnVice <= latestHourOnVice) {
							machineHourMap_Morn.replace(viceMachine, latestHourOnVice - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Morn.replace(viceMachine, 0f);
							productPlan = setPlan(viceMachine, subMaterial, latestHourOnVice * viceCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - latestHourOnVice * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到早班"));
							inputProductPlanLog(subMaterial, "", mornClass, "", "", String.valueOf(remainOnVice),
									"有多余物料未排产");
							return productPlanList;
						}
					} else {
						if (hourOnVice <= 8f) {
							machineHourMap_Morn.put(viceMachine, 8f - hourOnVice);
							productPlan = setPlan(viceMachine, subMaterial, minusHourOnHost * hostCapacity, mornClass,
									customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
						} else {
							machineHourMap_Morn.put(viceMachine, 0);
							productPlan = setPlan(viceMachine, subMaterial, 8f * viceCapacity, mornClass, customerFlag);
							if (productPlan != null) {
								productPlanList.add(productPlan);
							}
							remainOnVice = minusHourOnHost * hostCapacity - 8f * viceCapacity;// 副机台无法排产的量
							errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + remainOnVice
									+ "的需求量无法排产到早班"));
							inputProductPlanLog(subMaterial, "", mornClass, "", "", String.valueOf(remainOnVice),
									"有多余物料未排产");
							return productPlanList;
						}
					}
				} else {
					errorInfoOverall.append(infoStyle(0, "物料-" + subMaterial + "有" + minusHourOnHost * hostCapacity
							+ "的需求量无法排产到早班"));
					inputProductPlanLog(subMaterial, "", mornClass, "", "",
							String.valueOf(minusHourOnHost * hostCapacity), "有多余物料未排产");
					return productPlanList;
				}
			}
		}
		return productPlanList;
	}

	/**
	 * Step_5 删除原有计划并对排好的计划重新设置计划号和顺序号 刘朋 2019/04/20
	 * 
	 * @param mornProductPlan
	 * @param noonProductPlan
	 * @param evenProductPlan
	 * @throws Exception
	 */
	private void resetPlanNoAndOrder(List<ProductPlan> mornProductPlan, List<ProductPlan> noonProductPlan,
			List<ProductPlan> evenProductPlan) throws Exception {
		// 1.删除原有计划
		removeExitingPlan();
		// 2.对构造的计划进行重新设置计划顺序号
		Integer mornOrder = 0;
		Integer noonOrder = 0;
		Integer evenOrder = 0;
		SQLQuery orderQuery = createSQLQuery(getSQL("getMaxPlanOrder"));
		orderQuery.setParameter("planData", halfPartDateOverall);
		orderQuery.setParameter("factory", LLWebUtils.factory());
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> orderList = orderQuery.list();
		if (orderList.get(0).get("MORNORDER") != null) {
			mornOrder = Integer.valueOf(orderList.get(0).get("MORNORDER").toString());
		}
		if (orderList.get(0).get("NOONORDER") != null) {
			noonOrder = Integer.valueOf(orderList.get(0).get("NOONORDER").toString());
		}
		if (orderList.get(0).get("EVENORDER") != null) {
			evenOrder = Integer.valueOf(orderList.get(0).get("EVENORDER").toString());
		}
		for (int i = 0; i < productPlanList_Morn.size(); i++) {
			productPlanList_Morn.get(i).setPlan_order_i(mornOrder + i + 1);
		}
		for (int i = 0; i < productPlanList_Noon.size(); i++) {
			productPlanList_Noon.get(i).setPlan_order_i(noonOrder + i + 1);
		}
		for (int i = 0; i < productPlanList_Even.size(); i++) {
			productPlanList_Even.get(i).setPlan_order_i(evenOrder + i + 1);
		}
		/*
		 * String M_morn=""; String M_noon=""; String M_even=""; String
		 * E_morn=""; String E_noon=""; String E_even=""; boolean M_result=true;
		 * boolean E_result=true; for(int
		 * i=0;i<productPlanList_Morn.size();i++){
		 * M_morn=productPlanList_Morn.get(i).getMaterialcode_s().toString();
		 * E_morn=productPlanList_Morn.get(i).getEquip_code_s().toString();
		 * for(int j=0;i<productPlanList_Noon.size();i++){
		 * M_noon=productPlanList_Noon.get(j).getMaterialcode_s().toString();
		 * E_noon=productPlanList_Noon.get(j).getEquip_code_s().toString();
		 * for(int k=0;i<productPlanList_Even.size();i++){
		 * M_even=productPlanList_Even.get(k).getMaterialcode_s().toString();
		 * E_even=productPlanList_Even.get(k).getEquip_code_s().toString();
		 * M_result=M_morn.equals(M_noon)&&M_morn.equals(M_even);
		 * E_result=E_morn.equals(E_noon)&&E_morn.equals(E_even);
		 * if(M_result&&E_result){
		 * productPlanList_Morn.get(i).setSpare3_s(String.valueOf(i));
		 * productPlanList_Noon.get(i).setSpare3_s(String.valueOf(i));
		 * productPlanList_Even.get(i).setSpare3_s(String.valueOf(i)); } } } }
		 */
		// 3.对构造的计划进行重新设置计划号
		Integer count = 1;
		for (int i = 0; i < productPlanList_Noon.size(); i++) {// 2.1.设置中班计划顺序号
			if (count <= 9) {
				productPlanList_Noon.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("000").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 9 && count < 100) {
				productPlanList_Noon.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("00").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 99 && count < 1000) {
				productPlanList_Noon.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("0").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 999 && count < 9999) {
				productPlanList_Noon.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat(String.valueOf(count++)));
				continue;
			}
		}
		for (int i = 0; i < productPlanList_Even.size(); i++) {// 2.1.设置晚班计划顺序号
			if (count <= 9) {
				productPlanList_Even.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("000").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 9 && count < 100) {
				productPlanList_Even.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("00").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 99 && count < 1000) {
				productPlanList_Even.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("0").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 999 && count < 9999) {
				productPlanList_Even.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat(String.valueOf(count++)));
				continue;
			}
		}
		for (int i = 0; i < productPlanList_Morn.size(); i++) {// 2.1.设置早班计划顺序号
			if (count <= 9) {
				productPlanList_Morn.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("000").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 9 && count < 100) {
				productPlanList_Morn.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("00").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 99 && count < 1000) {
				productPlanList_Morn.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat("0").concat(String.valueOf(count++)));
				continue;
			}
			if (count > 999 && count < 9999) {
				productPlanList_Morn.get(i).setPlanno_s(
						"AP1".concat(halfPartDateOverall).concat(String.valueOf(count++)));
				continue;
			}
		}
		// 4.保存新增计划
		productPlanSrv.save(productPlanList_Morn);
		productPlanSrv.save(productPlanList_Noon);
		productPlanSrv.save(productPlanList_Even);
	}

	/**
	 * 删除原先已经存在的计划 刘朋 2019/04/20
	 */
	private void removeExitingPlan() {
		// 删除原来生成过的记录
		RockWellUtils.execSQL("delete from  AT_A_PM_PRODUCTPLAN where PLANDATE_S='" + halfPartDateOverall
				+ "' and S_FACTORY_S='" + LLWebUtils.factory() + "' " + "and BUILDINGRECORD_S='1'");
	}

	/**
	 * 进行物料校验并构造单条日计划 刘朋 2019-07-23
	 * 
	 * @param machine
	 * @param subMaterial
	 * @param demandCapacity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ProductPlan setPlan(String machine, String subMaterial, float demandCapacity, String classCode,
			String customerFlag) throws Exception {
		if (demandCapacity == 0f) {
			return null;
		}
		// 1.根据物料编码校验BOM存在性
		SQLQuery bomExistCheck = createSQLQuery(getSQL("bomExistCheck"));
		bomExistCheck.setParameter("materialCode", subMaterial);
		if (bomExistCheck.list().isEmpty()) {
			if (classCode.equals(noonClass)) {
				errorInfoOverall.append(infoStyle(0, "半部件物料-" + subMaterial + "缺少密炼子物料"));
			}
			inputProductPlanLog(subMaterial, customerFlag, classCode, "", "", "", "缺少密炼子物料");
			return null;
		}
		// 2.根据物料编码校验BOM有效期
		SQLQuery bomValidCheck = createSQLQuery(getSQL("bomValidCheck"));
		bomValidCheck.setParameter("materialCode", subMaterial);
		if (bomValidCheck.list().isEmpty()) {
			if (classCode.equals(noonClass)) {
				errorInfoOverall.append(infoStyle(0, "半部件物料-" + subMaterial + "已失效"));
			}
			inputProductPlanLog(subMaterial, customerFlag, classCode, "", "", "", "物料已失效");
			return null;
		}
		// 3.根据物料编码得到产品阶段和生产版本（接收时间是最新的）
		SQLQuery getProVersionAndStage = createSQLQuery(getSQL("getProVersionAndStage"));
		getProVersionAndStage.setParameter("materialCode", subMaterial);
		if (getProVersionAndStage.list().isEmpty()) {
			if (classCode.equals(noonClass)) {
				errorInfoOverall.append(infoStyle(0, "半部件物料-" + subMaterial + "无有效的产品阶段及生产版本信息"));
			}
			inputProductPlanLog(subMaterial, customerFlag, classCode, "", "", "", "物料无有效的产品阶段及生产版本信息");
			return null;
		}
		List<Map<String, Object>> getProVersionAndStageList = getProVersionAndStage.list();
		String productVersion = "";
		String productStage = "";
		if (getProVersionAndStageList.get(0).get("PRODUCTVERSION") != null) {
			productVersion = getProVersionAndStageList.get(0).get("PRODUCTVERSION").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'生产版本'时出错");
		}
		if (getProVersionAndStageList.get(0).get("PRODUCTSTAGE") != null) {
			productStage = getProVersionAndStageList.get(0).get("PRODUCTSTAGE").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'产品阶段'时出错");
		}
		// 4.根据物料编码得到工艺版本和配方版本
		String processVersion = "";
		String processVersionID = "";
		String formulaVersion = "";
		SQLQuery getProVersionFormulaVersionID = createSQLQuery(getSQL("getProVersionFormulaVersionID"));
		getProVersionFormulaVersionID.setParameter("materialCode", subMaterial);
		/**
		 * 临时校验
		 */
		if (getProVersionFormulaVersionID.list().isEmpty()) {
			processVersion = "111";// --临时
			processVersionID = "111";// --临时
			formulaVersion = "111";// --临时
		} else {
			List<Map<String, Object>> getProVersionFormulaVersionIDList = getProVersionFormulaVersionID.list();
			if (getProVersionFormulaVersionIDList.get(0).get("PRODUCTVERSION") != null) {
				processVersion = getProVersionFormulaVersionIDList.get(0).get("PRODUCTVERSION").toString();
			} else {
				processVersion = "111";
			}
			if (getProVersionFormulaVersionIDList.get(0).get("PROCESSVERSIONID") != null) {
				processVersionID = getProVersionFormulaVersionIDList.get(0).get("PROCESSVERSIONID").toString();
			} else {
				processVersionID = "111";
			}
			if (getProVersionFormulaVersionIDList.get(0).get("FORMULAVERSION") != null) {
				formulaVersion = getProVersionFormulaVersionIDList.get(0).get("FORMULAVERSION").toString();
			} else {
				formulaVersion = "111";
			}
		}
		/**
		 * 规范校验
		 */
		/*
		 * if(getProVersionFormulaVersionID.list().isEmpty()){
		 * errorInfoOverall.append
		 * (infoStyle(0,"半部件物料-"+subMaterial+"无有效的工艺版本和配方版本信息"));
		 * inputProductPlanLog
		 * (subMaterial,customerFlag,classCode,"","","","物料无有效的产品阶段及生产版本信息");
		 * return null; } List<Map<String,Object>>
		 * getProVersionFormulaVersionIDList
		 * =getProVersionFormulaVersionID.list();
		 * if(getProVersionFormulaVersionIDList
		 * .get(0).get("PRODUCTVERSION")!=null){
		 * processVersion=getProVersionFormulaVersionIDList
		 * .get(0).get("PRODUCTVERSION").toString(); }else{
		 * processVersion="111"; }
		 * if(getProVersionFormulaVersionIDList.get(0).get
		 * ("PROCESSVERSIONID")!=null){
		 * processVersionID=getProVersionFormulaVersionIDList
		 * .get(0).get("PROCESSVERSIONID").toString(); }else{
		 * processVersionID="111"; }
		 * if(getProVersionFormulaVersionIDList.get(0).
		 * get("FORMULAVERSION")!=null){
		 * formulaVersion=getProVersionFormulaVersionIDList
		 * .get(0).get("FORMULAVERSION").toString(); }else{
		 * formulaVersion="111"; }
		 */
		// 5.根据物料编码获取计划量超产百分比
		SQLQuery getOverPercent = createSQLQuery(getSQL("getOverPercent"));
		getOverPercent.setParameter("materialCode", subMaterial);
		if (getOverPercent.list().isEmpty()) {
			if (classCode.equals(noonClass)) {
				errorInfoOverall.append(infoStyle(0, "半部件物料-" + subMaterial + "无有效的计划量超产百分比数据"));
			}
			inputProductPlanLog(subMaterial, customerFlag, classCode, "", "", "", "无有效的计划量超产百分比数据");
			return null;
		}
		float overPercent = 0f;
		List<Map<String, Object>> getOverPercentList = getOverPercent.list();
		if (getOverPercentList.get(0).get("SORTNO_I") != null) {
			overPercent = Float.parseFloat(getOverPercentList.get(0).get("SORTNO_I").toString());
		} else {
			throw new Exception("倒推构建单条计划设定'计划量超产百分比'时出错");
		}
		// 6.根据物料编码获得物料名称、物料描述、物料规格、物料组编码、物料组名称
		SQLQuery getMaterialInfo = createSQLQuery(getSQL("getMaterialInfo"));
		getMaterialInfo.setParameter("materialCode", subMaterial);
		List<Map<String, Object>> getMaterialInfoList = getMaterialInfo.list();
		String materialDesc = "";
		String materialSpec = "";
		String materialGroupCode = "";
		String materialGroupDesc = "";
		if (getMaterialInfoList.isEmpty()) {
			if (classCode.equals(noonClass)) {
				errorInfoOverall.append(infoStyle(0, "半部件物料-" + subMaterial + "物料相关信息拉取失败"));
			}
			inputProductPlanLog(subMaterial, customerFlag, classCode, "", "", "", "物料信息拉取失败");
			return null;
		}
		if (getMaterialInfoList.get(0).get("MATERIALDESC") != null) {
			materialDesc = getMaterialInfoList.get(0).get("MATERIALDESC").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'物料描述'时出错");
		}
		if (getMaterialInfoList.get(0).get("MATERIALSPEC") != null) {
			materialSpec = getMaterialInfoList.get(0).get("MATERIALSPEC").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'物料规格'时出错");
		}
		if (getMaterialInfoList.get(0).get("MATERIALGROUPCODE") != null) {
			materialGroupCode = getMaterialInfoList.get(0).get("MATERIALGROUPCODE").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'物料组编码'时出错");
		}
		if (getMaterialInfoList.get(0).get("MATERIALGROUPDESC") != null) {
			materialGroupDesc = getMaterialInfoList.get(0).get("MATERIALGROUPDESC").toString();
		} else {
			throw new Exception("倒推构建单条计划设定'物料组名称'时出错");
		}
		// 7.设置计划信息
		ProductPlan plan = new ProductPlan();
		plan.setS_factory_s(LLWebUtils.factory());
		plan.setCreated_by_s(LLWebUtils.getUser().userCode);
		plan.setChanged_by_s(LLWebUtils.getUser().userCode);
		plan.setCreated_time_t(new Date());
		plan.setChanged_time_t(new Date());
		plan.setAgenc_no_s(LLConstant.JING_MEN_CODE);
		plan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
		plan.setBuildingrecord_s("1");// 成型倒退标识：1
		plan.setPlanfinish_f("0");
		plan.setEquip_code_s(machine);
		SQLQuery equipNameQuery = createSQLQuery(getSQL("getEquipNameByEquipCode"));
		equipNameQuery.setParameter("machine", machine);
		List<Map<String, Object>> equipName = equipNameQuery.list();
		if (equipName.size() > 0) {
			plan.setSpare1_s(equipName.get(0).get("DESCRIPTION").toString());
		}
		plan.setHandflag_s("1");
		plan.setPlanno_s("1");// 计划号
		// plan.setPlanno_s(serialSrv.serial("AP"+halfPartDate, 4,
		// 1).get(0).toString());//计划号
		plan.setStatus_s("104001");// 计划状态-未审核
		plan.setPlan_order_i(1);// 顺序号
		plan.setSapversion_s(productVersion);// 生产版本（sap下发版本）
		plan.setProductstage_s(productStage);// 产品阶段
		plan.setParaversion_s(processVersion);// 工艺版本
		plan.setParameterid_s(processVersionID);// 工艺版本ID
		plan.setRepiceno_s(formulaVersion);// 配方版本(bom_版本)
		plan.setMaterialcode_s(subMaterial);// 物料编码
		plan.setMaterialname_s(materialDesc);// 物料名称
		plan.setSpecification_s(materialSpec);// 物料规格
		plan.setMaterialgroup_s(materialGroupCode);// 物料组编码
		plan.setMaterialdesc_s(materialGroupDesc);// 物料组名称
		plan.setOverpercent_f(overPercent); // 计划量超产百分比
		plan.setPlanquantityconfirm_f(demandCapacity);// 确认计划量
		plan.setPlanquantity_f(demandCapacity);// 倒推计划量
		plan.setPlandate_s(halfPartDateOverall);
		plan.setClasscode_s(classCode);
		plan.setCustomerflag_s(customerFlag);
		return plan;
	}

	/****************** 按班汇总成型日计划并排产 ******************************/
	public String planAutoMakingAccordingToClass(String buildingDate, String halfPartDate) throws Exception {
		mornSubMaterialInfoCommon.clear();
		noonSubMaterialInfoCommon.clear();
		evenSubMaterialInfoCommon.clear();
		subMaterialInfoCommon.clear();
		machineInfoListCommon.clear();
		mornSubMaterialInfoSpecial.clear();
		noonSubMaterialInfoSpecial.clear();
		evenSubMaterialInfoSpecial.clear();
		subMaterialInfoSpecial.clear();
		machineInfoListSpecial.clear();
		machineHourMap_Morn.clear();
		machineHourMap_Noon.clear();
		machineHourMap_Even.clear();
		productPlanList_Morn.clear();
		productPlanList_Noon.clear();
		productPlanList_Even.clear();
		productPlanLogList.clear();
		int errorlength = errorInfoOverall.length();// 取得字符串的长度
		errorInfoOverall.delete(0, errorlength); // 删除字符串从errorInfoOverall处的内容
		buildingDateOverall = buildingDate;
		halfPartDateOverall = halfPartDate;
		/**
		 * Step_1:倒推前校验
		 */
		// 判断是否有已执行的半部件计划,如果有，结束倒推
		planStatusCheckBeforePlanAutoMaking();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}
		// 判断是否存在已审核的成型计划，如果没有，结束倒推
		getBuildingPlan();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}
		// 判断是否维护单班排产系数、机台有效时间系数以及库存满足率阈值，如果维护，并设置单班排产系数、机台有效时间系数、库存满足率阈值全局变量
		setCoefficient();
		if (errorInfoOverall.length() > 0) {
			return errorInfoOverall.toString();
		}

		/**
		 * Step_2:获取子物料信息(有客户标识+无客户标识)
		 */
		getSubMaterialInfoByClass("1");// 有客户标识
		getSubMaterialInfoByClass("0");// 无客户标识

		/**
		 * Step_3:获得子物料对应的主副产机台及产能信息(有客户标识+无客户标识)并排产
		 */
		if (subMaterialInfoSpecial.isEmpty() == false) {
			getMachineInfoListSpecial(); // 获得有客户标识的机台信息
			if (machineInfoListSpecial.isEmpty() == false) {
				// Step_4:根据Step_1和Step_2两表的内容对有客户标识的计划排产
				customerSpecialByClass();
			} else {
				errorInfoOverall.append(infoStyle(0, "请联系相关人员维护特殊客户(例如福特)的半部件物料的主副产机台及其产能"));
			}
		}
		if (subMaterialInfoCommon.isEmpty() == false) {
			getMachineInfoListCommon(); // 获得无客户标识的机台信息
			if (machineInfoListCommon.isEmpty() == false) {
				// Step_5:根据Step_1和Step_2两表的内容对无客户标识的计划排产
				customerCommonByClass();
			} else {
				errorInfoOverall.append(infoStyle(0, "请联系相关人员维护半部件物料的主副产机台及其产能"));
			}
		}

		/**
		 * Step_4:对排好的计划重新设置日计划号和顺序号
		 */
		resetPlanNoAndOrder(productPlanList_Morn, productPlanList_Noon, productPlanList_Even);

		/**
		 * Step_5:存储异常信息
		 */
		if (errorInfoOverall.toString() == null) {
			return "操作成功";
		}

		/**
		 * Step_6:返回提示信息
		 */
		return errorInfoOverall.toString();
	}

	/**
	 * Step_2 获取已根据库存满足率排序的子料信息 刘朋 2019/07/29
	 * 
	 * @param customerFlag
	 *            (0:无客户标识;1：有客户标识)
	 * @return
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	@SuppressWarnings("unchecked")
	public void getSubMaterialInfoByClass(String customerFlag) throws NumberFormatException, Exception {
		float mornFillRate = 0f;
		float noonFillRate = 0f;
		float evenFillRate = 0f;
		String subMaterial = "";
		String subMaterial_1 = "";
		String customer = "";
		float materialStock = 0f;
		float mornDemandCapacity = 0f;
		float noonDemandCapacity = 0f;
		float evenDemandCapacity = 0f;
		/**
		 * 获取有客户标识的物料信息并排序
		 */
		if (customerFlag.equals("1")) {
			// Step_1:获取子件物料信息
			SQLQuery getSubMaterialInfo = createSQLQuery(getSQL("getSubMaterialInfoAccordingClassSpecial"));
			getSubMaterialInfo.setParameter("buildingDate", buildingDateOverall);
			getSubMaterialInfo.setParameter("customerFlag", customerFlagCommon);
			getSubMaterialInfo.setParameter("factory", LLWebUtils.factory());
			subMaterialInfoSpecial = getSubMaterialInfo.list();
			// Step_2:获取子件物料的当前库存量
			SQLQuery getStock = createSQLQuery(getSQL("getFillRateSpecialByDate"));
			getStock.setParameter("buildingDate", buildingDateOverall);
			getStock.setParameter("customerFlag", customerFlagCommon);
			getStock.setParameter("factory", LLWebUtils.factory());
			List<Map<String, Object>> stockList = getStock.list();
			Map<String, Object> subMaterialInfoMap = new HashMap<>();
			/*
			 * Step_3根据Step_2中物料的库存量计算物料早中晚三个班的库存满足率根据总需求量以及单班排产系数计算三班的需求量
			 * 构造早中晚三班的物料信息
			 */
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				// 定义物料对应的三班Map
				Map<String, Object> mornSubMaterialInfoMap = new HashMap<>();// 早
				Map<String, Object> noonSubMaterialInfoMap = new HashMap<>();// 中
				Map<String, Object> evenSubMaterialInfoMap = new HashMap<>();// 晚
				// 获取物料Map
				subMaterialInfoMap = subMaterialInfoSpecial.get(i);
				// 在Map中取物料编码
				subMaterial = subMaterialInfoMap.get("SUBMATERIAL").toString();
				// 在Map中获取客户标识
				customer = subMaterialInfoMap.get("CUSTOMER_FLAG_S").toString();
				// 在Map中取当前物料的单班需求量
				mornDemandCapacity = Float.parseFloat(subMaterialInfoSpecial.get(i).get("MORNDEMANDCAPACITY")
						.toString());// 早
				noonDemandCapacity = Float.parseFloat(subMaterialInfoSpecial.get(i).get("NOONDEMANDCAPACITY")
						.toString());// 中
				evenDemandCapacity = Float.parseFloat(subMaterialInfoSpecial.get(i).get("EVENDEMANDCAPACITY")
						.toString());// 晚
				// 循环
				for (int j = 0; j < stockList.size(); j++) {
					subMaterial_1 = stockList.get(j).get("SUBMATERIAL").toString();
					if (subMaterial.equals(subMaterial_1)) {
						materialStock = Float.parseFloat(stockList.get(j).get("STOCK").toString());// 获得当前物料的库存量
						// 计算当前物料的三班库存满足率
						mornFillRate = materialStock / mornDemandCapacity;// 早
						noonFillRate = materialStock / noonDemandCapacity;// 中
						evenFillRate = materialStock / evenDemandCapacity;// 晚
						// 设置Map物料编码
						mornSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						noonSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						evenSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						// 设置Map单班总需求量
						mornSubMaterialInfoMap.put("DEMANDCAPACITY", mornDemandCapacity);
						noonSubMaterialInfoMap.put("DEMANDCAPACITY", noonDemandCapacity);
						evenSubMaterialInfoMap.put("DEMANDCAPACITY", evenDemandCapacity);
						// 设置Map单班库存满足率
						mornSubMaterialInfoMap.put("FILLRATE", mornFillRate);
						noonSubMaterialInfoMap.put("FILLRATE", noonFillRate);
						evenSubMaterialInfoMap.put("FILLRATE", evenFillRate);
						// 设置Map客户标识
						mornSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						noonSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						evenSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						// 将三班Map加到对应List中
						mornSubMaterialInfoSpecial.add(i, mornSubMaterialInfoMap);
						noonSubMaterialInfoSpecial.add(i, noonSubMaterialInfoMap);
						evenSubMaterialInfoSpecial.add(i, evenSubMaterialInfoMap);
						break;
					}
				}
			}
			// Step_4:对三班的物料信息根据库存满足率逆排序(物料的库存满足率越大，排产优先级越低)
			float fillRate1 = 0f;
			float fillRate2 = 0f;
			for (int i = 0; i < subMaterialInfoSpecial.size() - 1; i++) {
				for (int j = 0; j < subMaterialInfoSpecial.size() - i - 1; j++) {
					// 重新声明传参对象
					Map<String, Object> mornSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> mornSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> tempMapMorn = new HashMap<String, Object>();
					Map<String, Object> tempMapNoon = new HashMap<String, Object>();
					Map<String, Object> tempMapEven = new HashMap<String, Object>();
					/*** 早班排序 ***/
					mornSubMaterialInfoMap1 = mornSubMaterialInfoSpecial.get(j);
					mornSubMaterialInfoMap2 = mornSubMaterialInfoSpecial.get(j + 1);
					// 获取相邻两个Map的库存满足率
					fillRate1 = Float.parseFloat(mornSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(mornSubMaterialInfoMap2.get("FILLRATE").toString());
					// 比较两个库存满足率的大小,冒泡排序
					if (fillRate1 > fillRate2) {
						tempMapMorn = mornSubMaterialInfoMap2;
						mornSubMaterialInfoSpecial.set(j + 1, mornSubMaterialInfoMap1);
						mornSubMaterialInfoSpecial.set(j, tempMapMorn);
					}
					/*** 中班排序 ***/
					noonSubMaterialInfoMap1 = noonSubMaterialInfoSpecial.get(j);
					noonSubMaterialInfoMap2 = noonSubMaterialInfoSpecial.get(j + 1);
					fillRate1 = Float.parseFloat(noonSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(noonSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapNoon = noonSubMaterialInfoMap2;
						noonSubMaterialInfoSpecial.set(j + 1, noonSubMaterialInfoMap1);
						noonSubMaterialInfoSpecial.set(j, tempMapNoon);
					}
					/*** 晚班排序 ***/
					evenSubMaterialInfoMap1 = evenSubMaterialInfoSpecial.get(j);
					evenSubMaterialInfoMap2 = evenSubMaterialInfoSpecial.get(j + 1);
					fillRate1 = Float.parseFloat(evenSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(evenSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapEven = evenSubMaterialInfoMap2;
						evenSubMaterialInfoSpecial.set(j + 1, evenSubMaterialInfoMap1);
						evenSubMaterialInfoSpecial.set(j, tempMapEven);
					}
				}
			}
			// Step_5:对三班的物料信息根据换上胶案数量排序(库存满足率大于阈值的物料,按照换上胶案数量逆排序)
			String priorMaterial = "";
			String laterMaterial = "";
			String laterMaterial_1 = "";
			Integer leastPlasticAddNum = 1000;
			Integer plasticAddNum = 0;
			Integer plasticAddNum_1 = 0;
			Map<String, Object> middleMapMorn = new HashMap<>();
			Map<String, Object> middleMapNoon = new HashMap<>();
			Map<String, Object> middleMapEven = new HashMap<>();
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取前一天的早班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(noonSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						SQLQuery getLastDaySubMaterial = createSQLQuery(getSQL("getLastDaySubMaterial"));
						getLastDaySubMaterial.setParameter("halfPartDate",
								String.valueOf(Integer.parseInt(halfPartDateOverall) - 1));
						getLastDaySubMaterial.setParameter("classCode", mornClass);
						getLastDaySubMaterial.setParameter("factory", LLWebUtils.factory());
						if (getLastDaySubMaterial.list().isEmpty()) {
							errorInfoOverall.append(infoStyle(0,
									String.valueOf(Integer.parseInt(halfPartDateOverall) - 1) + "无早班计划,"
											+ halfPartDateOverall + "日中班的第一个排产物料取库存满足率最低者"));
							continue;
						} else {
							priorMaterial = getLastDaySubMaterial.uniqueResult().toString();
						}
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = noonSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = noonSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapNoon = noonSubMaterialInfoSpecial.get(0);
								noonSubMaterialInfoSpecial.set(0, noonSubMaterialInfoSpecial.get(j + 1));
								noonSubMaterialInfoSpecial.set(j + 1, middleMapNoon);
							}
						}
						continue;
					}
					priorMaterial = noonSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = noonSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapNoon = noonSubMaterialInfoSpecial.get(i);
							noonSubMaterialInfoSpecial.set(i, noonSubMaterialInfoSpecial.get(i + j));
							noonSubMaterialInfoSpecial.set(i + j, middleMapNoon);
						}
					}
				}
			}
			// 按库存满足率排序后的晚班物料按换上教案数量排序;注意：第一个对比物料取当天的中班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(evenSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,第一个对比物料取当天的中班物料
						priorMaterial = noonSubMaterialInfoSpecial.get(noonSubMaterialInfoSpecial.size() - 1)
								.toString();
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = evenSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = evenSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapEven = evenSubMaterialInfoSpecial.get(0);
								evenSubMaterialInfoSpecial.set(0, evenSubMaterialInfoSpecial.get(j + 1));
								evenSubMaterialInfoSpecial.set(j + 1, middleMapEven);
							}
						}
						continue;
					}
					priorMaterial = evenSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = evenSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapEven = evenSubMaterialInfoSpecial.get(i);
							evenSubMaterialInfoSpecial.set(i, evenSubMaterialInfoSpecial.get(i + j));
							evenSubMaterialInfoSpecial.set(i + j, middleMapEven);
						}
					}
				}
			}
			// 按库存满足率排序后的早班物料按换上教案数量排序;注意：第一个对比物料取当天的晚班物料
			for (int i = 0; i < subMaterialInfoSpecial.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(mornSubMaterialInfoSpecial.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,第一个对比物料取当天的晚班物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = evenSubMaterialInfoSpecial.get(evenSubMaterialInfoSpecial.size() - 1)
								.toString();
						for (int j = 0; j < subMaterialInfoSpecial.size() - 1; j++) {
							laterMaterial = mornSubMaterialInfoSpecial.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = mornSubMaterialInfoSpecial.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapMorn = mornSubMaterialInfoSpecial.get(0);
								mornSubMaterialInfoSpecial.set(0, mornSubMaterialInfoSpecial.get(j + 1));
								mornSubMaterialInfoSpecial.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = mornSubMaterialInfoSpecial.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoSpecial.size() - i; j++) {
						laterMaterial = mornSubMaterialInfoSpecial.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapMorn = mornSubMaterialInfoSpecial.get(i);
							mornSubMaterialInfoSpecial.set(i, mornSubMaterialInfoSpecial.get(i + j));
							mornSubMaterialInfoSpecial.set(i + j, middleMapMorn);
						}
					}
				}
			}
		} else {
			/**
			 * 获取无客户标识的物料信息并排序
			 */
			SQLQuery getSubMaterialInfo = createSQLQuery(getSQL("getSubMaterialInfoAccordingClassCommon"));
			// Step_1:获取子件物料信息
			getSubMaterialInfo.setParameter("buildingDate", buildingDateOverall);
			getSubMaterialInfo.setParameter("customerFlag", customerFlagCommon);
			getSubMaterialInfo.setParameter("factory", LLWebUtils.factory());
			subMaterialInfoCommon = getSubMaterialInfo.list();
			// Step_2:获取子件物料的当前库存量
			SQLQuery getStock = createSQLQuery(getSQL("getFillRateCommonByDate"));
			getStock.setParameter("buildingDate", buildingDateOverall);
			getStock.setParameter("customerFlag", customerFlagCommon);
			getStock.setParameter("factory", LLWebUtils.factory());
			List<Map<String, Object>> stockList = getStock.list();
			Map<String, Object> subMaterialInfoMap = new HashMap<>();
			/*
			 * Step_3根据Step_2中物料的库存量计算物料早中晚三个班的库存满足率根据总需求量以及单班排产系数计算三班的需求量
			 * 构造早中晚三班的物料信息
			 */
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				// 定义物料对应的三班Map
				Map<String, Object> mornSubMaterialInfoMap = new HashMap<>();// 早
				Map<String, Object> noonSubMaterialInfoMap = new HashMap<>();// 中
				Map<String, Object> evenSubMaterialInfoMap = new HashMap<>();// 晚
				// 获取物料Map
				subMaterialInfoMap = subMaterialInfoCommon.get(i);
				// 在Map中取物料编码
				subMaterial = subMaterialInfoMap.get("SUBMATERIAL").toString();
				// 在Map中客户标识
				customer = subMaterialInfoMap.get("CUSTOMER_FLAG_S").toString();
				// 在Map中取当前物料的单班需求量
				mornDemandCapacity = Float
						.parseFloat(subMaterialInfoCommon.get(i).get("MORNDEMANDCAPACITY").toString());// 早
				noonDemandCapacity = Float
						.parseFloat(subMaterialInfoCommon.get(i).get("NOONDEMANDCAPACITY").toString());// 中
				evenDemandCapacity = Float
						.parseFloat(subMaterialInfoCommon.get(i).get("EVENDEMANDCAPACITY").toString());// 晚
				// 循环
				for (int j = 0; j < stockList.size(); j++) {
					subMaterial_1 = stockList.get(j).get("SUBMATERIAL").toString();
					if (subMaterial.equals(subMaterial_1)) {
						materialStock = Float.parseFloat(stockList.get(j).get("STOCK").toString());// 获得当前物料的库存量
						// 计算当前物料的三班库存满足率
						mornFillRate = materialStock / mornDemandCapacity;// 早
						noonFillRate = materialStock / noonDemandCapacity;// 中
						evenFillRate = materialStock / evenDemandCapacity;// 晚
						// 设置Map物料编码
						mornSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						noonSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						evenSubMaterialInfoMap.put("SUBMATERIAL", subMaterial);
						// 设置Map单班总需求量
						mornSubMaterialInfoMap.put("DEMANDCAPACITY", mornDemandCapacity);
						noonSubMaterialInfoMap.put("DEMANDCAPACITY", noonDemandCapacity);
						evenSubMaterialInfoMap.put("DEMANDCAPACITY", evenDemandCapacity);
						// 设置Map单班库存满足率
						mornSubMaterialInfoMap.put("FILLRATE", mornFillRate);
						noonSubMaterialInfoMap.put("FILLRATE", noonFillRate);
						evenSubMaterialInfoMap.put("FILLRATE", evenFillRate);
						// 设置Map客户标识
						mornSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						noonSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						evenSubMaterialInfoMap.put("CUSTOMER_FLAG_S", customer);
						// 将三班Map加到对应List中
						mornSubMaterialInfoCommon.add(i, mornSubMaterialInfoMap);
						noonSubMaterialInfoCommon.add(i, noonSubMaterialInfoMap);
						evenSubMaterialInfoCommon.add(i, evenSubMaterialInfoMap);
						break;
					}
				}
			}
			// Step_4:对三班的物料信息根据库存满足率逆排序(物料的库存满足率越大，排产优先级越低)
			float fillRate1 = 0f;
			float fillRate2 = 0f;
			for (int i = 0; i < subMaterialInfoCommon.size() - 1; i++) {
				for (int j = 0; j < subMaterialInfoCommon.size() - i - 1; j++) {
					// 重新声明传参对象
					Map<String, Object> mornSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> mornSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> noonSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap1 = new HashMap<String, Object>();
					Map<String, Object> evenSubMaterialInfoMap2 = new HashMap<String, Object>();
					Map<String, Object> tempMapMorn = new HashMap<String, Object>();
					Map<String, Object> tempMapNoon = new HashMap<String, Object>();
					Map<String, Object> tempMapEven = new HashMap<String, Object>();
					/*** 早班排序 ***/
					mornSubMaterialInfoMap1 = mornSubMaterialInfoCommon.get(j);
					mornSubMaterialInfoMap2 = mornSubMaterialInfoCommon.get(j + 1);
					// 获取相邻两个Map的库存满足率
					fillRate1 = Float.parseFloat(mornSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(mornSubMaterialInfoMap2.get("FILLRATE").toString());
					// 比较两个库存满足率的大小,冒泡排序
					if (fillRate1 > fillRate2) {
						tempMapMorn = mornSubMaterialInfoMap2;
						mornSubMaterialInfoCommon.set(j + 1, mornSubMaterialInfoMap1);
						mornSubMaterialInfoCommon.set(j, tempMapMorn);
					}
					/*** 中班排序 ***/
					noonSubMaterialInfoMap1 = noonSubMaterialInfoCommon.get(j);
					noonSubMaterialInfoMap2 = noonSubMaterialInfoCommon.get(j + 1);
					fillRate1 = Float.parseFloat(noonSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(noonSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapNoon = noonSubMaterialInfoMap2;
						noonSubMaterialInfoCommon.set(j + 1, noonSubMaterialInfoMap1);
						noonSubMaterialInfoCommon.set(j, tempMapNoon);
					}
					/*** 晚班排序 ***/
					evenSubMaterialInfoMap1 = evenSubMaterialInfoCommon.get(j);
					evenSubMaterialInfoMap2 = evenSubMaterialInfoCommon.get(j + 1);
					fillRate1 = Float.parseFloat(evenSubMaterialInfoMap1.get("FILLRATE").toString());
					fillRate2 = Float.parseFloat(evenSubMaterialInfoMap2.get("FILLRATE").toString());
					if (fillRate1 > fillRate2) {
						tempMapEven = evenSubMaterialInfoMap2;
						evenSubMaterialInfoCommon.set(j + 1, evenSubMaterialInfoMap1);
						evenSubMaterialInfoCommon.set(j, tempMapEven);
					}
				}
			}
			// Step_5:对三班的物料信息根据换上胶案数量排序(库存满足率大于阈值的物料,按照换上胶案数量逆排序)
			String priorMaterial = "";
			String laterMaterial = "";
			String laterMaterial_1 = "";
			Integer leastPlasticAddNum = 1000;
			Integer plasticAddNum = 0;
			Integer plasticAddNum_1 = 0;
			Map<String, Object> middleMapMorn = new HashMap<>();
			Map<String, Object> middleMapNoon = new HashMap<>();
			Map<String, Object> middleMapEven = new HashMap<>();
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取前一天的早班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(noonSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						// 查询前一天的早班最后计划的物料做第一个被比较的物料
						SQLQuery getLastDaySubMaterial = createSQLQuery(getSQL("getLastDaySubMaterial"));
						getLastDaySubMaterial.setParameter("halfPartDate",
								String.valueOf(Integer.parseInt(halfPartDateOverall) - 1));
						getLastDaySubMaterial.setParameter("classCode", mornClass);
						getLastDaySubMaterial.setParameter("factory", LLWebUtils.factory());
						if (getLastDaySubMaterial.list().isEmpty()) {
							errorInfoOverall.append(infoStyle(0,
									String.valueOf(Integer.parseInt(halfPartDateOverall) - 1) + "无早班计划,"
											+ halfPartDateOverall + "日中班的第一个排产物料取库存满足率最低者"));
							continue;
						} else {
							priorMaterial = getLastDaySubMaterial.uniqueResult().toString();
						}
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = noonSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = noonSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapNoon = noonSubMaterialInfoCommon.get(0);
								noonSubMaterialInfoCommon.set(0, noonSubMaterialInfoCommon.get(j + 1));
								noonSubMaterialInfoCommon.set(j + 1, middleMapNoon);
							}
						}
						continue;
					}
					priorMaterial = noonSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = noonSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapNoon = noonSubMaterialInfoCommon.get(i);
							noonSubMaterialInfoCommon.set(i, noonSubMaterialInfoCommon.get(i + j));
							noonSubMaterialInfoCommon.set(i + j, middleMapNoon);
						}
					}
				}
			}
			// 按库存满足率排序后的晚班物料按换上教案数量排序;注意：第一个对比物料取当天的中班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(evenSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,第一个对比物料取当天的中班物料
						priorMaterial = noonSubMaterialInfoCommon.get(noonSubMaterialInfoCommon.size() - 1).toString();
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = evenSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = evenSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapEven = evenSubMaterialInfoCommon.get(0);
								evenSubMaterialInfoCommon.set(0, evenSubMaterialInfoCommon.get(j + 1));
								evenSubMaterialInfoCommon.set(j + 1, middleMapEven);
							}
						}
						continue;
					}
					priorMaterial = evenSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = evenSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapEven = evenSubMaterialInfoCommon.get(i);
							evenSubMaterialInfoCommon.set(i, evenSubMaterialInfoCommon.get(i + j));
							evenSubMaterialInfoCommon.set(i + j, middleMapEven);
						}
					}
				}
			}
			// 按库存满足率排序后的中班物料按换上教案数量排序;注意：第一个对比物料取当天的晚班物料
			for (int i = 0; i < subMaterialInfoCommon.size(); i++) {
				leastPlasticAddNum = 1000;
				fillRate1 = Float.parseFloat(mornSubMaterialInfoCommon.get(i).get("FILLRATE").toString());
				if (fillRate1 > settingRate) {
					if (i == 0) {
						// 当i=0时,说明当前物料的库存满足率都大于设定值,因此取前一天的早班最后计划的物料做第一个被比较的物料
						priorMaterial = evenSubMaterialInfoCommon.get(evenSubMaterialInfoCommon.size() - 1).toString();
						for (int j = 0; j < subMaterialInfoCommon.size() - 1; j++) {
							laterMaterial = mornSubMaterialInfoCommon.get(0).get("SUBMATERIAL").toString();
							laterMaterial_1 = mornSubMaterialInfoCommon.get(j + 1).get("SUBMATERIAL").toString();
							plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
							plasticAddNum_1 = getPlasticAddNum(priorMaterial, laterMaterial_1);
							if (plasticAddNum_1 < plasticAddNum) {
								middleMapMorn = mornSubMaterialInfoCommon.get(0);
								mornSubMaterialInfoCommon.set(0, mornSubMaterialInfoCommon.get(j + 1));
								mornSubMaterialInfoCommon.set(j + 1, middleMapMorn);
							}
						}
						continue;
					}
					priorMaterial = mornSubMaterialInfoCommon.get(i - 1).get("SUBMATERIAL").toString();
					for (int j = 0; j < subMaterialInfoCommon.size() - i; j++) {
						laterMaterial = mornSubMaterialInfoCommon.get(i + j).get("SUBMATERIAL").toString();
						plasticAddNum = getPlasticAddNum(priorMaterial, laterMaterial);
						if (plasticAddNum < leastPlasticAddNum) {
							leastPlasticAddNum = plasticAddNum;
							middleMapMorn = mornSubMaterialInfoCommon.get(i);
							mornSubMaterialInfoCommon.set(i, mornSubMaterialInfoCommon.get(i + j));
							mornSubMaterialInfoCommon.set(i + j, middleMapMorn);
						}
					}
				}
			}
		}
	}

	/**
	 * 对有客户标识的计划排产
	 * 
	 * @Title: customerSpecialByClass
	 * @Description: TODO(描述)
	 * @return: void 返回类型
	 * 
	 */
	private void customerSpecialByClass() throws Exception {
		Map<String, Object> subMaterialInfoMapMorn = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapNoon = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapEven = new HashMap<String, Object>();
		String subMaterialMorn = "";
		String subMaterialMorn_1 = "";
		String subMaterialNoon = "";
		String subMaterialNoon_1 = "";
		String subMaterialEven = "";
		String subMaterialEven_1 = "";
		Map<String, Object> machineInfoMap = new HashMap<String, Object>();
		int listSize = 0;
		listSize = mornSubMaterialInfoSpecial.size();// mornSubMaterialInfoSpecial.size()=noonSubMaterialInfoSpecial,size()=evenSubMaterialInfoSpecial.size()
		/**
		 * 从排序好的早中晚三班物料信息列中逐一获取物料信息并分早中晚三班排产
		 */
		for (int i = 0; i < listSize; i++) {
			// 1.获取物料信息List中的第i个Map
			subMaterialInfoMapMorn = mornSubMaterialInfoSpecial.get(i);
			subMaterialInfoMapNoon = mornSubMaterialInfoSpecial.get(i);
			subMaterialInfoMapEven = mornSubMaterialInfoSpecial.get(i);
			// 2.获取当前物料的物料编码
			subMaterialMorn = subMaterialInfoMapMorn.get("SUBMATERIAL").toString();
			subMaterialNoon = subMaterialInfoMapNoon.get("SUBMATERIAL").toString();
			subMaterialEven = subMaterialInfoMapEven.get("SUBMATERIAL").toString();
			/**
			 * 4.根据物料编码在机台产能表List—B中匹配该物料对应机台的小时产能
			 */
			// 中班排产
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialNoon_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialNoon_1.equals(subMaterialNoon)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Noon = productionScheduling_Noon(subMaterialInfoMapNoon, machineInfoMap);
					if (planList_Noon != null) {
						for (int m = 0; m < planList_Noon.size(); m++) {
							productPlanList_Noon.add(planList_Noon.get(m));
						}
					}
				}
			}
			// 晚班排产
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialEven_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialEven_1.equals(subMaterialEven)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Even = productionScheduling_Even(subMaterialInfoMapEven, machineInfoMap);
					if (planList_Even != null) {
						for (int m = 0; m < planList_Even.size(); m++) {
							productPlanList_Even.add(planList_Even.get(m));
						}
					}
				}
			}
			// 早班排产
			for (int j = 0; j < machineInfoListSpecial.size(); j++) {
				machineInfoMap = machineInfoListSpecial.get(j);
				subMaterialMorn_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialMorn_1.equals(subMaterialMorn)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Morn = productionScheduling_Morn(subMaterialInfoMapMorn, machineInfoMap);
					if (planList_Morn != null) {
						for (int m = 0; m < planList_Morn.size(); m++) {
							productPlanList_Morn.add(planList_Morn.get(m));
						}
					}
				}
			}
		}
	}

	/**
	 * 对无客户标识的计划排产
	 * 
	 * @Title: customerCommonByClass
	 * @Description: TODO(描述)
	 * @return: void 返回类型
	 * 
	 */
	private void customerCommonByClass() throws Exception {
		Map<String, Object> subMaterialInfoMapMorn = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapNoon = new HashMap<String, Object>();
		Map<String, Object> subMaterialInfoMapEven = new HashMap<String, Object>();
		String subMaterialMorn = "";
		String subMaterialMorn_1 = "";
		String subMaterialNoon = "";
		String subMaterialNoon_1 = "";
		String subMaterialEven = "";
		String subMaterialEven_1 = "";
		Map<String, Object> machineInfoMap = new HashMap<String, Object>();
		int listSize = 0;
		listSize = mornSubMaterialInfoCommon.size();// mornSubMaterialInfoSpecial.size()=noonSubMaterialInfoSpecial,size()=evenSubMaterialInfoSpecial.size()
		/**
		 * 从排序好的早中晚三班物料信息列中逐一获取物料信息并分早中晚三班排产
		 */
		for (int i = 0; i < listSize; i++) {
			// 1.获取物料信息List中的第i个Map
			subMaterialInfoMapMorn = mornSubMaterialInfoCommon.get(i);
			subMaterialInfoMapNoon = noonSubMaterialInfoCommon.get(i);
			subMaterialInfoMapEven = evenSubMaterialInfoCommon.get(i);
			// 2.获取当前物料的物料编码
			subMaterialMorn = subMaterialInfoMapMorn.get("SUBMATERIAL").toString();
			subMaterialNoon = subMaterialInfoMapNoon.get("SUBMATERIAL").toString();
			subMaterialEven = subMaterialInfoMapEven.get("SUBMATERIAL").toString();
			/**
			 * 4.根据物料编码在机台产能表List—B中匹配该物料对应机台的小时产能
			 */
			// 中班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialNoon_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialNoon_1.equals(subMaterialNoon)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Noon = productionScheduling_Noon(subMaterialInfoMapNoon, machineInfoMap);
					if (planList_Noon != null) {
						for (int m = 0; m < planList_Noon.size(); m++) {
							productPlanList_Noon.add(planList_Noon.get(m));
						}
					}
				}
			}
			// 晚班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialEven_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialEven_1.equals(subMaterialEven)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Even = productionScheduling_Even(subMaterialInfoMapEven, machineInfoMap);
					if (planList_Even != null) {
						for (int m = 0; m < planList_Even.size(); m++) {
							productPlanList_Even.add(planList_Even.get(m));
						}
					}
				}
			}
			// 早班排产
			for (int j = 0; j < machineInfoListCommon.size(); j++) {
				machineInfoMap = machineInfoListCommon.get(j);
				subMaterialMorn_1 = machineInfoMap.get("SUBMATERIAL").toString(); // 获得机台产能信息List中
				if (subMaterialMorn_1.equals(subMaterialMorn)) {
					// 8.根据4中计算的单班需求量排产
					List<ProductPlan> planList_Morn = productionScheduling_Morn(subMaterialInfoMapMorn, machineInfoMap);
					if (planList_Morn != null) {
						for (int m = 0; m < planList_Morn.size(); m++) {
							productPlanList_Morn.add(planList_Morn.get(m));
						}
					}
				}
			}
		}
	}

	public void inputProductPlanLog(String materialCode, String classCode, String customer, String hostMachine,
			String viceMachine, String surplusDemand, String exceptionalDesc) {
		ProductPlanLog planLog = new ProductPlanLog();
		planLog.setS_factory_s(LLWebUtils.factory());
		planLog.setCreated_by_s(LLWebUtils.getUser().userCode);
		planLog.setCreated_time_t(new Date());
		planLog.setAgenc_no_s(LLConstant.JING_MEN_CODE);
		planLog.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
		planLog.setMaterialcode_s(materialCode);// 物料编码
		planLog.setClasscode_s(classCode);// 班次
		planLog.setCustomerflag_s(customer);// 客户标识
		planLog.setHostmachine_s(hostMachine); // 主产机台
		planLog.setVicemachine_s(viceMachine); // 副产机台
		planLog.setSurplusdemand_s(surplusDemand); // 剩余未排产量
		planLog.setExceptionaldesc_s(exceptionalDesc);// 异常描述
		productPlanLogList.add(planLog);
	}
}
