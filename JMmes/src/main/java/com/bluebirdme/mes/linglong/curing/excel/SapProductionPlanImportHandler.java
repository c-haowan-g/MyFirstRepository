package com.bluebirdme.mes.linglong.curing.excel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.common.service.SystemConfigServiceImpl;
import com.bluebirdme.core.system.excel.ExcelContent;
import com.bluebirdme.core.system.excel.ExcelImportHandler;
import com.bluebirdme.core.system.excel.ImportErrorMessage;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringProductionMonthPlan;
import com.bluebirdme.mes.linglong.curing.entity.dto.CuringProductionMonthPlanDTO;
import com.bluebirdme.mes.linglong.curing.service.CuringProductionMonthPlanServiceImpl;
import com.datasweep.compatibility.client.DatasweepException;
import com.datasweep.compatibility.client.Part;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * @author lp
 * 
 */
public class SapProductionPlanImportHandler extends ExcelImportHandler {
	private CuringProductionMonthPlanServiceImpl srv = (CuringProductionMonthPlanServiceImpl) SpringContext
			.getBean("curingProductionMonthPlanServiceImpl");
	Part part = null;
	private SerialServiceImpl serialSrv = (SerialServiceImpl) SpringContext.getBean("serialServiceImpl");
	private SystemConfigServiceImpl cnfigSrv = (SystemConfigServiceImpl) SpringContext
			.getBean("systemConfigServiceImpl");

	List<CuringProductionMonthPlan> dataList = new ArrayList<CuringProductionMonthPlan>();
	List<CuringProductionMonthPlan> excelList = new ArrayList<CuringProductionMonthPlan>();
	List<CuringProductionMonthPlan> dbList = null;

	private List<ImportErrorMessage> errorMessages = new ArrayList<ImportErrorMessage>();

	@Override
	public List<ImportErrorMessage> validate(ExcelContent content) {
		DealExcelModel(content);
		return errorMessages;
	}

	@Override
	public void toDB(ExcelContent content) throws Exception {
		if (!dataList.isEmpty()) {
			// srv.save(dataList);
			CuringProductionMonthPlanDTO plandto = new CuringProductionMonthPlanDTO();
			plandto.setInserted(dataList);
			srv.saveChanges(plandto);
		}
	}

	// 按照模板处理导入的Excel文档
	private void DealExcelModel(ExcelContent content) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");

		SimpleDateFormat dayFormatter = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		int rowIndex = 1;
		ImportErrorMessage errMsg = null;
		// 解析行数据
		for (Map<Integer, String> row : content.getRows()) {
			errMsg = null;
			CuringProductionMonthPlan spp = new CuringProductionMonthPlan();
			spp.setS_factory_s(LLWebUtils.factory());
			spp.setCreated_by_s(WebUtils.getUserName());
			spp.setCreated_time_t(new Date());
			spp.setRecord_flag_s("A");
			spp.setPlan_status_s("217002");

			// 解析列数据
			for (int i = 0; i < row.size(); i++) {
				// ERP品号
				if (i == 0) {
					System.out.println(row.get(i).toString());
					if (!row.get(i).isEmpty()) {
						part = PCContext.getFunctions().getPart(row.get(i).toString());
					}
					if (part == null) {
						errMsg = new ImportErrorMessage();
						errMsg.setColumn(i + 1);
						errMsg.setRow(rowIndex + 1);
						errMsg.setMessage(LanguageProvider.getMessage("tip.unknownMaterialCode"));
						errorMessages.add(errMsg);
						continue;
					} else {
						System.out.println(part.getName().substring(0, 9));
						spp.setMaterial_code_s(part.getName().substring(0, 9));
						spp.setMaterial_name_s(part.getDescription());
						try {
							spp.setSpecification_s(part.getUDA("MaterialSpec").toString());
							if (part.getUDA("CJ") != null) {
								spp.setLayclass_s(part.getUDA("CJ").toString());
							}
							spp.setFlowershape_s(part.getUDA("Pattern").toString());
						} catch (DatasweepException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				// 月计划数量
				if (i == 2) {
					try {
						spp.setQuantity_plan_f(BigDecimal.valueOf(Double.valueOf(row.get(i).toString())));
					} catch (Exception e) {
						errMsg = new ImportErrorMessage();
						errMsg.setColumn(i + 1);
						errMsg.setRow(rowIndex + 1);
						errMsg.setMessage(LanguageProvider.getMessage("tip.invalid"));
						errorMessages.add(errMsg);
					}

				}
				// 计划开始时间
				if (i == 3) {
					if (row.get(i).replace("-", "").replace("/", "").length() != 8) {
						errMsg = new ImportErrorMessage();
						errMsg.setRow(rowIndex + 1);
						errMsg.setColumn(i + 1);
						errMsg.setMessage(LanguageProvider.getMessage("tip.invalidDateFormat"));
						errorMessages.add(errMsg);
					} else {
						try {
							spp.setPlan_starttime_t(dayFormatter.parse(row.get(i).replace("-", "").replace("/", "")
									+ " 00:00:00"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				}
				// 计划结束时间
				if (i == 4) {
					if (row.get(i).replace("-", "").replace("/", "").length() != 8) {
						errMsg = new ImportErrorMessage();
						errMsg.setRow(rowIndex + 1);
						errMsg.setColumn(i + 1);
						errMsg.setMessage(LanguageProvider.getMessage("tip.invalidDateFormat"));
						errorMessages.add(errMsg);
					} else {
						try {
							spp.setPlan_endtime_t(dayFormatter.parse(row.get(i).replace("-", "").replace("/", "")
									+ " 23:59:59"));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				}
			}
			String materialcode = row.get(0).toString();
			String materialdesc = row.get(1).toString();
			String count = row.get(2).toString();
			String starttime = row.get(3).toString();
			String endtime = row.get(4).toString();
			if (!materialcode.isEmpty() && !materialdesc.isEmpty() && !count.isEmpty() && !starttime.isEmpty()
					&& !endtime.isEmpty()) {
				// 设置月计划号
				String month = dateFormat.format(spp.getPlan_starttime_t());
				try {
					spp.setPlanno_month_s(serialSrv.serial("LHYJH", month));
				} catch (Exception e1) {
					errMsg = new ImportErrorMessage();
					errMsg.setColumn(0);
					errMsg.setRow(rowIndex);
					errMsg.setMessage(LanguageProvider.getMessage("tip.cannotGetMonthlyPlanCode"));
					errorMessages.add(errMsg);
				}
				// 月份
				try {
					spp.setMonth_i(Integer.parseInt(dateFormat.format(spp.getPlan_starttime_t())));
					// 如果月份或者年份不一致，不允许导入
					if (spp.getPlan_starttime_t().getYear() != spp.getPlan_endtime_t().getYear()
							|| spp.getPlan_starttime_t().getMonth() != spp.getPlan_endtime_t().getMonth()) {
						errMsg = new ImportErrorMessage();
						errMsg.setRow(rowIndex + 1);
						errMsg.setColumn(4);
						errMsg.setMessage(LanguageProvider.getMessage("tip.differentYearOrMonth"));
						errorMessages.add(errMsg);
					}

					// 起止时间大小问题
					if (spp.getPlan_starttime_t().after(spp.getPlan_endtime_t())) {
						errMsg = new ImportErrorMessage();
						errMsg.setRow(rowIndex + 1);
						errMsg.setColumn(4);
						errMsg.setMessage(LanguageProvider.getMessage("tip.startTimeLargeThanEndTime"));
						errorMessages.add(errMsg);
					}
				} catch (Exception e) {
				}

				// 分厂
				spp.setPlant_s(LLWebUtils.factory());
				// 机构编号
				spp.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				// 机构名称
				spp.setAgen_name_s(FactoryConstant.JING_MEN_NAME);
				// 计划状态
				spp.setPlan_status_s("217002");
				// 超额百分比
				spp.setOverproduction_percent_s(cnfigSrv.get("LH_YJH_OVERSTEP_PERCENT"));

				// 如果没有错误，那么在校验是否有时间段重复的，如果没有重复，放到集合中去
				if (errMsg == null) {

					String validMaterialInfo = srv.validMaterial2(spp.getMaterial_code_s());

					if (!StringUtils.isBlank(validMaterialInfo)) {
						errMsg = new ImportErrorMessage();
						errMsg.setRow(rowIndex + 1);
						errMsg.setMessage(validMaterialInfo);
						errorMessages.add(errMsg);
					} else {
						if (dbList == null) {
							Where w = new Where();
							w.andEqual("agenc_no_s", FactoryConstant.JING_MEN_CODE);
							w.andEqual("s_factory_s", LLWebUtils.factory());
							w.andEqual("month_i", spp.getMonth_i());
							w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);

							dbList = srv.findByWhere(w);

						}

						CuringProductionMonthPlan valid = valid(spp);
						if (valid == null) {
							dataList.add(spp);

						} else {
							errMsg = new ImportErrorMessage();
							errMsg.setRow(rowIndex + 1);
							errMsg.setMessage(LanguageProvider.getMessage("tip.RepeatPlanTime") + "[ "
									+ valid.getMaterial_code_s() + "["
									+ dayFormatter.format(valid.getPlan_starttime_t()) + "~"
									+ dayFormatter.format(valid.getPlan_endtime_t()) + "] " + spp.getMaterial_code_s()
									+ "[" + dayFormatter.format(spp.getPlan_starttime_t()) + "~"
									+ dayFormatter.format(spp.getPlan_endtime_t()) + " ]");
							errorMessages.add(errMsg);
						}
					}

				}
				excelList.add(spp);

				rowIndex++;
			}
		}

	}

	public CuringProductionMonthPlan valid(CuringProductionMonthPlan spp) {
		for (CuringProductionMonthPlan spp_ : excelList) {
			if (spp.getMaterial_code_s().equals(spp_.getMaterial_code_s())) {
				if (spp.getPlan_starttime_t().after(spp_.getPlan_endtime_t())
						|| spp.getPlan_endtime_t().before(spp_.getPlan_starttime_t())) {
					// Here is ok

				} else {
					return spp_;
				}
			}
		}
		for (CuringProductionMonthPlan spp_ : dbList) {
			if (spp.getMaterial_code_s().equals(spp_) && spp_.getRecord_flag_s().equals("A")) {
				if (spp.getPlan_starttime_t().after(spp_.getPlan_endtime_t())
						|| spp.getPlan_endtime_t().before(spp_.getPlan_starttime_t())) {
					// Here is ok

				} else {
					return spp_;
				}
			}
		}
		return null;
	}
}
