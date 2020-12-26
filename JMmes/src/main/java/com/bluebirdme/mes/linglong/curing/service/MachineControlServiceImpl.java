/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ControlDetail;
import com.bluebirdme.mes.linglong.curing.entity.MachineControl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 硫化机台控制管理
 * 
 * @author 时永良
 * @Date 2018-08-10 13:31:38
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MachineControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MachineControl.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 模态框的内容查询
	 * 
	 * @return
	 */
	/*public List<Map<String, Object>> searchByModal() {
		SQLQuery query = createSQLQuery(getSQL("searchByModal"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}*/
	
	
	/**
	 * 根据产线条码查询机台日志
	 * 2020/07/06 栾和源
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchByLine(Filter filter, Page page) throws Exception {
		//filter.set("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", searchByLineUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", searchByLineTotalUDA(filter, page));
		return ret;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> searchByLineUDA(Filter filter, Page page) throws Exception {
		
		if (getSQL("searchByLine") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchByLine的SQL语句定义");
		String dataSql = getSQL("searchByLine", filter.getFilter());
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

	public Long searchByLineTotalUDA(Filter filter, Page page) throws Exception {
		if (getSQL("searchByLineTotal") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchByLineTotal的SQL语句定义");
		String totalSql = getSQL("searchByLineTotal", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}


	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> searchByLineUDA(Filter filter) throws Exception {
		
		if (getSQL("searchByLine") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchByLine的SQL语句定义");

		String dataSql = getSQL("searchByLine", filter.getFilter());

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

	

	@RockWellTransactional
	public List<String> onOff(Map<String, Object> updated) throws Exception {
		List<String> ruturnNum = new ArrayList<>();
		String dataOnOffDate = updated.get("dataOnOff").toString();
		List<Map<String, Object>> machineControlList = (List<Map<String, Object>>) updated.get("updated");
		// 日志的list集合
		List<ControlDetail> listlog = new ArrayList<>();
		for (int i = 0; i < machineControlList.size(); i++) {
			if (machineControlList.get(i).get("mold_heatflag_s") != null) {
				String misString = updateMachineControl(machineControlList.get(i), dataOnOffDate);
				if (misString != null) {
					ruturnNum.add(misString);
				}
			} else {
				saveMachineControl(machineControlList.get(i), dataOnOffDate);
			}
		}

		return ruturnNum;
	}

	/**
	 * 添加控制表的数据 周清玉
	 * 
	 * @param map
	 * @param dataOnOffDate
	 */
	public void saveMachineControl(Map<String, Object> map, String dataOnOffDate) {
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		MachineControl machineControl = new MachineControl();
		String status = "0";
		if (dataOnOffDate.indexOf("打开") != -1) {
			status = "1";
		}
		machineControl.setMold_heatflag_s("0");
		machineControl.setOfflinerunflag_s("0");
		machineControl.setAlarm_controlflag_s("0");
		machineControl.setFirstmold_controlflag_s("0");
		machineControl.setVerification_mark_s("0");
		machineControl.setTyre_timever_s("0");
		machineControl.setTyre_pickver_s("0");
		machineControl.setQs_stop_s("0");
		machineControl.setTyrebar_controlflag_s("0");
		machineControl.setTyre_feeding_s("0");
		machineControl.setSpare7_s("0");
		machineControl.setSpare6_s("0");
		try {
			ControlDetail controlDetail = new ControlDetail();

			if (dataOnOffDate.indexOf("温模") != -1) {
				machineControl.setMold_heatflag_s(status);
				// 添加操作日志
				saveControlDetail("是否温模", status, map.get("p_line_name").toString(), map.get("description").toString());
			} else if (dataOnOffDate.indexOf("单机") != -1) {
				machineControl.setOfflinerunflag_s(status);
				// 添加操作日志
				saveControlDetail("是否单机运行", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("报警") != -1) {
				machineControl.setAlarm_controlflag_s(status);
				// 添加操作日志
				saveControlDetail("是否报警", status, map.get("p_line_name").toString(), map.get("description").toString());
			} else if (dataOnOffDate.indexOf("首模") != -1) {
				machineControl.setFirstmold_controlflag_s(status);
				// 添加操作日志
				saveControlDetail("是否首模操作", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("胎胚放行") != -1) {
				machineControl.setVerification_mark_s(status);
				// 添加操作日志
				saveControlDetail("是否胎胚放行", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("胎胚时效") != -1) {
				machineControl.setTyre_timever_s(status);
				// 添加操作日志
				saveControlDetail("是否胎胚时效", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("胎胚领用") != -1) {
				machineControl.setTyre_pickver_s(status);
				// 添加操作日志
				saveControlDetail("是否胎胚领用", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("后工序") != -1) {
				machineControl.setQs_stop_s(status);
				// 添加操作日志
				saveControlDetail("是否后工序操作", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("后充气受控") != -1) {
				machineControl.setTyrebar_controlflag_s(status);
				// 添加操作日志
				saveControlDetail("后充气是否受控", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("投料管控") != -1) {
				machineControl.setTyre_feeding_s(status);
				// 添加操作日志
				saveControlDetail("是否投料管控", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("质量管控") != -1) {
				machineControl.setSpare7_s(status);
				// 添加操作日志
				saveControlDetail("质量是否受控", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			} else if (dataOnOffDate.indexOf("洗模管控") != -1) {
				machineControl.setSpare6_s(status);
				// 添加操作日志
				saveControlDetail("洗模是否受控", status, map.get("p_line_name").toString(), map.get("description")
						.toString());
			}

			machineControl.setCreated_by_s(WebUtils.getUser().userCode);
			machineControl.setCreated_time_t(timestamp);
			machineControl.setChanged_by_s(WebUtils.getUser().userCode);
			machineControl.setChanged_time_t(timestamp);
			machineControl.setRecord_flag_s("A");
			machineControl.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
			machineControl.setS_factory_s(LLWebUtils.factory());
			machineControl.setProduct_line_s(map.get("p_line_name").toString());
			machineControl.setEquip_code_s(map.get("equip_name").toString());
			machineControl.setBelong_section_s("C");
			machineControl.setIsused_s("214002");
			machineControl.setEquip_ip_s(map.get("ip_s").toString());
			machineControl.setEquip_type_s("211003");
			machineControl.setEquip_name_s(map.get("description").toString());
			machineControl.setEquip_group_s(map.get("p_line_name").toString());
			machineControl.setPlant_s("252006");
			this.saveOne(machineControl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改控制表的数据 周清玉
	 * 
	 * @param map
	 * @param dataOnOffDate
	 */
	public String updateMachineControl(Map<String, Object> map, String dataOnOffDate) {
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		String numMachinecontrol = null;
		String status = "0";
		if (dataOnOffDate.indexOf("打开") != -1) {
			status = "1";
		}

		try {
			// 查询需要修改的数据
			List<Map<String, Object>> list = queryUpdate(map.get("equip_code_s").toString());
			MachineControl machinecontrol = (MachineControl) MapTrunPojo.mapToEntity(list.get(0), MachineControl.class);
			machinecontrol.setChanged_by_s(WebUtils.getUser().userCode);
			machinecontrol.setChanged_time_t(timestamp);

			if (dataOnOffDate.indexOf("温模") != -1) {
				if (machinecontrol.getMold_heatflag_s() == null) {
					machinecontrol.setMold_heatflag_s(status);
					// 添加操作日志
					saveControlDetail("是否温模", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getMold_heatflag_s().equals(status)) {
						machinecontrol.setMold_heatflag_s(status);
						// 添加操作日志
						saveControlDetail("是否温模", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("单机") != -1) {
				if (machinecontrol.getOfflinerunflag_s() == null) {
					machinecontrol.setOfflinerunflag_s(status);
					// 添加操作日志
					saveControlDetail("是否单机运行", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getOfflinerunflag_s().equals(status)) {
						machinecontrol.setOfflinerunflag_s(status);
						// 添加操作日志
						saveControlDetail("是否单机运行", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("报警") != -1) {
				if (machinecontrol.getAlarm_controlflag_s() == null) {
					machinecontrol.setAlarm_controlflag_s(status);
					// 添加操作日志
					saveControlDetail("是否报警", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getAlarm_controlflag_s().equals(status)) {
						machinecontrol.setAlarm_controlflag_s(status);
						// 添加操作日志
						saveControlDetail("是否报警", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("首模") != -1) {
				if (machinecontrol.getFirstmold_controlflag_s() == null) {
					machinecontrol.setFirstmold_controlflag_s(status);
					// 添加操作日志
					saveControlDetail("是否首模操作", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getFirstmold_controlflag_s().equals(status)) {
						machinecontrol.setFirstmold_controlflag_s(status);
						// 添加操作日志
						saveControlDetail("是否首模操作", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("胎胚放行") != -1) {
				if (machinecontrol.getVerification_mark_s() == null) {
					machinecontrol.setVerification_mark_s(status);
					// 添加操作日志
					saveControlDetail("是否胎胚放行", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getVerification_mark_s().equals(status)) {
						machinecontrol.setVerification_mark_s(status);
						// 添加操作日志
						saveControlDetail("是否胎胚放行", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("胎胚时效") != -1) {
				if (machinecontrol.getTyre_timever_s() == null) {
					machinecontrol.setTyre_timever_s(status);
					// 添加操作日志
					saveControlDetail("是否胎胚时效", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getTyre_timever_s().equals(status)) {
						machinecontrol.setTyre_timever_s(status);
						// 添加操作日志
						saveControlDetail("是否胎胚时效", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("胎胚领用") != -1) {
				if (machinecontrol.getTyre_pickver_s() == null) {
					machinecontrol.setTyre_pickver_s(status);
					// 添加操作日志
					saveControlDetail("是否胎胚领用", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getTyre_pickver_s().equals(status)) {
						machinecontrol.setTyre_pickver_s(status);
						// 添加操作日志
						saveControlDetail("是否胎胚领用", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("后工序") != -1) {
				if (machinecontrol.getQs_stop_s() == null) {
					machinecontrol.setQs_stop_s(status);
					// 添加操作日志
					saveControlDetail("是否后工序操作", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getQs_stop_s().equals(status)) {
						machinecontrol.setQs_stop_s(status);
						// 添加操作日志
						saveControlDetail("是否后工序操作", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("后充气受控") != -1) {
				if (machinecontrol.getTyrebar_controlflag_s() == null) {
					machinecontrol.setTyrebar_controlflag_s(status);
					// 添加操作日志
					saveControlDetail("后充气是否受控", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getTyrebar_controlflag_s().equals(status)) {
						machinecontrol.setTyrebar_controlflag_s(status);
						// 添加操作日志
						saveControlDetail("后充气是否受控", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}
			} else if (dataOnOffDate.indexOf("投料管控") != -1) {
				if (machinecontrol.getTyre_feeding_s() == null) {
					machinecontrol.setTyre_feeding_s(status);
					// 添加操作日志
					saveControlDetail("是否投料管控", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getTyre_feeding_s().equals(status)) {
						machinecontrol.setTyre_feeding_s(status);
						// 添加操作日志
						saveControlDetail("是否投料管控", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}

			} else if (dataOnOffDate.indexOf("质量管控") != -1) {
				if (machinecontrol.getSpare7_s() == null) {
					machinecontrol.setSpare7_s(status);
					// 添加操作日志
					saveControlDetail("质量是否受控", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getSpare7_s().equals(status)) {
						machinecontrol.setSpare7_s(status);
						// 添加操作日志
						saveControlDetail("质量是否受控", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}

			} else if (dataOnOffDate.indexOf("洗模管控") != -1) {
				if (machinecontrol.getSpare6_s() == null) {
					machinecontrol.setSpare6_s(status);
					// 添加操作日志
					saveControlDetail("洗模是否受控", status, map.get("p_line_name").toString(), map.get("description")
							.toString());
				} else {
					if (!machinecontrol.getSpare6_s().equals(status)) {
						machinecontrol.setSpare6_s(status);
						// 添加操作日志
						saveControlDetail("洗模是否受控", status, map.get("p_line_name").toString(), map.get("description")
								.toString());
					} else {
						numMachinecontrol = machinecontrol.getEquip_code_s();
						return numMachinecontrol;
					}
				}

			}
			update(machinecontrol);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return numMachinecontrol;
	}

	/**
	 * 添加操作日志
	 * 
	 * @param operate_item
	 *            操作项
	 * @param operate_status
	 *            操作状态
	 * @param p_line_name
	 *            产线条码
	 * @param description
	 *            机台描述 周清玉
	 */
	public void saveControlDetail(String operate_item, String operate_status, String p_line_name, String description) {
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		ControlDetailService controlDetailService = new ControlDetailService();
		ControlDetail controlDetail = new ControlDetail();
		controlDetail.setOperate_item_s(operate_item);
		controlDetail.setOperate_status_s(operate_status);
		controlDetail.setEquip_code_s(p_line_name);
		controlDetail.setEquip_name_s(description);

		try {
			// 修改人
			controlDetail.setChanged_by_s(WebUtils.getUser().userCode);
			// 维护时间
			controlDetail.setChanged_time_t(timestamp);
			controlDetail.setS_factory_s(LLWebUtils.factory());
			controlDetail.setRecord_flag_s("A");
			controlDetailService.saveOne(controlDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询开关要修改的数据
	 * 
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryUpdate(String equip_code_s) throws Exception {
		Filter filter = new Filter();
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("equip_code_s", equip_code_s);
		if (getSQL("queryUpdate") == null)
			throw new Exception(getClass() + ".xml中未找到ID为queryUpdate的SQL语句定义");

		String dataSql = getSQL("queryUpdate", filter.getFilter());
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

	@RockWellTransactional
	public int saveOne(MachineControl machineControl) throws Exception {
		save(machineControl);
		return 0;
	}

	public Map<String, Object> datagridUDA2(Filter filter, Page page) throws Exception {
		filter.set("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));

		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		filter.set("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

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
		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total2的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 查询产线左右摸
	 * 
	 * @param lineCode
	 *            产线条码
	 * @return
	 */

	public List<MachineControl> machines(String lineCode) {

		Where w = new Where();
		w.andEqual("record_flag_s", "A");
		w.andEqual("agenc_no_s", FactoryConstant.JING_MEN_CODE);
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("product_line_s", lineCode);
		List<Object> list = findByWhere(w);
		Object ob = (Object) list;
		List<MachineControl> listMachineControl = (List<MachineControl>) ob;
		return listMachineControl;
	}

	/**
	 * 产线名称的查询
	 * 
	 * @return
	 */
	public String searchByProductLine(String value) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchByProductLine"));
		query.setParameter("product_line_s", value);
		return (String) query.uniqueResult();
	}

	/**
	 * 根据机台名称查询当前机台的日计划号
	 * 
	 * @return
	 */
	public String searchplannoByProductLine(String product_line_s) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchplannoByProductLine"));
		query.setParameter("product_line_s", product_line_s);
		return (String) query.uniqueResult();
	}

	/**
	 * 查出产线编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchProductionLine() throws Exception {
		Filter filter = new Filter();
		filter.set("process_s", "252006");
		filter.set("sitename", LLWebUtils.factory());
		System.out.println(getSQL("getProductlineBySitename", filter));

		SQLQuery query = createSQLQuery(getSQL("getProductlineBySitename", filter));
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}
}
