/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ecs.xhtml.map;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.clientdata.WriteTagData;
import com.bluebird.clientdata.WriteTagResult;
import com.bluebird.clientdata.MachineConfig;
import com.bluebird.clientdata.ResponeResult;
import com.bluebird.clientproxy.LineTagDataProxy;
import com.bluebird.clientproxy.BuildingProcessDataProxy;
import com.bluebird.dataaccess.TransactionHelper;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.config.BuildingControlConfig;
import com.bluebirdme.mes.linglong.building.entity.BuildingControl;
import com.bluebirdme.mes.linglong.building.entity.Usecontrollog;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 成型机台开关控制管理
 * 
 * @author 时永良
 * @Date 2019-01-12 11:28:38
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BuildingControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return BuildingControl.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	public IFunctionsEx  getFunction(){
	    	return PCContext.getFunctions();
	}
	/**
	 * 机台日志界面查询
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		String s_factory_s=LLWebUtils.factory();
		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
		filter.set("area_name",AGENC_NO_S+s_factory_s+"B");
		filter.set("agenc_no_s",AGENC_NO_S);
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

	/**
	 * 根据数据字典查出所需控制项（196为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy196() {
		SQLQuery query = createSQLQuery(getSQL("searchBy196"));
		return query.list();
	}
	/**
	 * 查出机台名称显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query = createSQLQuery(getSQL("searchDescription"));
		String s_factory_s=LLWebUtils.factory();
		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
		query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",AGENC_NO_S);
		System.out.println(getSQL("searchDescription").toString());
		return query.list();
	}
	/**
	 * 根据菜单管理查出数据（权限）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchFromCoreMenu() {
		String s_factory_s=LLWebUtils.factory();
		SQLQuery query = createSQLQuery(getSQL("searchFromCoreMenu"));
		query.setParameter("url","view?page=building/productionManagement/buildingControl/buildingcontrol&factory="+s_factory_s+"");
		return query.list();
	}
	/**
	 * 查询全部 页面初始化使用
	 * @param machinename_s
	 *        机台名称
	 * @param machinegroup_s
	 *        机台组
	 * @param machinestatus_s
	 *        机台状态
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> searchInit(String machinename_s, String machinegroup_s, String machinestatus_s)
			throws Exception {
		List<Map<String, Object>> list = searchBy196();
		StringBuffer sql = new StringBuffer(
				"SELECT A.*,B.DESCRIPTION as machinename_s,B.P_LINE_NAME,C.machinestatus_s,D.MACHINEGROUP_S as machinegroup_s,D.FACTORY_S,A.CHANGED_TIME_S as changedtime,");
		sql.append("(select DISTINCT US1.USERNAME from AT_CM_EM_PRODUCTCONTROL b LEFT JOIN CORE_USER US1 ON b.CHANGED_BY_S=US1.USERCODE where b.CHANGED_TIME_S=A.CHANGED_TIME_S) as changedby from (select a.MACHINEBARCODE_S");
		for (int i = 0; i < list.size(); i++) {
			String DICTCODE_S = (String) list.get(i).get("DICTCODE_S");
			String DICTNAME_S = (String) list.get(i).get("DICTNAME");
			sql.append(",sum(case when CONTROLITEM_S=" + "'" + DICTCODE_S + "'" + " then CONTROLSTATUS_S end) " + "A"
					+ DICTCODE_S + "" + "");
		}
		sql.append(",max(a.CHANGED_TIME_S) as CHANGED_TIME_S from AT_CM_EM_PRODUCTCONTROL a where a.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "'" +" and a.AGENC_NO_S="+ "'" + FactoryConstant.JING_MEN_CODE + "'" +"group by a.MACHINEBARCODE_S) A right JOIN (SELECT p.DESCRIPTION ,p.P_LINE_NAME,p.P_LINE_KEY FROM AREA c,AREA_PRODUCTION_LINE d,PRODUCTION_LINE p where c.AREA_KEY=d.PARENT_KEY and d.CHILD_KEY=p.P_LINE_KEY and c.AREA_NAME ='"+FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"B') B on A.MACHINEBARCODE_S=B.P_LINE_NAME LEFT JOIN AT_CM_EM_MACHINESTATUS C on A.MACHINEBARCODE_S=C.MACHINEBARCODE_S LEFT JOIN UDA_ProductionLine D on B.P_LINE_KEY=D.OBJECT_KEY where D.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "' and D.Process_s = '252005' ");
		if (machinename_s != null && machinename_s != "") {
			sql.append("and B.DESCRIPTION like '" + machinename_s + "%'");
		}
		if (machinestatus_s != null && machinestatus_s != "") {
			sql.append("and C.MACHINESTATUS_S like '" + machinestatus_s + "%'");
		}
		if (machinegroup_s != null && machinegroup_s != "") {
			sql.append("and D.MACHINEGROUP_S like '" + machinegroup_s + "%'");
		}
		sql.append("order by B.P_LINE_NAME");
		SQLQuery query = createSQLQuery(sql.toString());
		System.out.println("--------------------"+sql.toString());
		List<Map<String, Object>> listALL = query.list();
		return listALL;
	}
    /**
     * 页面开关按钮操作
     * @param updated
     *        选择要修改的数据
     * @return
     * @throws Exception
     */
	@RockWellTransactional
	public String onOff(Map<String, Object> updated) throws Exception {
		List<Map<String, Object>> list = (List<Map<String, Object>>) updated.get("updated");
		String dataOnOffDate = updated.get("dataOnOff").toString();
		Map<String,Object> resultMap=null;
		List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
		// 遍历key,将包含196的截取（去掉第一位的A），保存新的map(196XXX是行转列的控制项)
		for(int i=0;i<list.size();i++){
			resultMap=new HashMap<>();
			for (String key : list.get(i).keySet()) {
				String newKey = key.toLowerCase();
				if (newKey.indexOf("196") != -1) {
					newKey = newKey.substring(1, 7);
				}
				resultMap.put(newKey, list.get(i).get(key));
			}
            resultMapList.add(resultMap); 
		}
		
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		UsecontrollogService usecontrollogService = new UsecontrollogService();
		Usecontrollog usecontrollog = new Usecontrollog();
		BuildingControl buildingControl=new BuildingControl();
		String message=null;
		for(int i=0;i<resultMapList.size();i++){
			resultMap=resultMapList.get(i);
			//"1960181"为单机运行开启按钮
			if(dataOnOffDate.equals("1960181")){
				String webServiceAddress="";
				List<WriteTagData> listDate=new ArrayList<>();
				//报警信息号复位
				WriteTagData control_StopTagData=new WriteTagData();
				control_StopTagData.setLogicalAddress("control_Stop");
				control_StopTagData.setTagValue("0");
				//报警原因复位
				WriteTagData control_MessageTagData=new WriteTagData();
				control_MessageTagData.setLogicalAddress("Control_Message");
				control_MessageTagData.setTagValue("0");
				listDate.add(control_StopTagData);
				listDate.add(control_MessageTagData);
				
				String equiptype="";
				
				if(LLWebUtils.factory().equals("2")){
					webServiceAddress=BuildingControlConfig.HalfwebService;//半钢
					SQLQuery query = createSQLQuery(getSQL("getFactory"));
					query.setParameter("p_line_name", resultMap.get("p_line_name").toString());
					List<Map<String,Object>> listObject=query.list();
					if(listObject!=null&&listObject.size()!=0&&listObject.get(0).get("FACTORY_S")!=null){
						equiptype=listObject.get(0).get("FACTORY_S").toString();
					}
				}else {
					//报警信息号复位
					WriteTagData MES_AllowTireOutHolder_flag=new WriteTagData();
					MES_AllowTireOutHolder_flag.setLogicalAddress("MES_AllowTireOutHolder_flag");
					MES_AllowTireOutHolder_flag.setTagValue("0");
					listDate.add(MES_AllowTireOutHolder_flag);
					webServiceAddress=BuildingControlConfig.FullwebService;//全钢
				}
				
				if(equiptype.equals("VMI")&&LLWebUtils.factory().equals("2")){						 
					try {
						BuildingProcessDataProxy buildingProcessDataProxy = new BuildingProcessDataProxy(BuildingControlConfig.HalfwebService,resultMap.get("p_line_name").toString());//new BuildingProcessDataProxy("http://192.168.51.223:10010/winceService?wsdl",resultMap.get("p_line_name").toString());
						MachineConfig machineConfig = new MachineConfig();
						machineConfig.setMachineCode(resultMap.get("p_line_name").toString());
						System.out.println(resultMap.get("p_line_name").toString());
						ResponeResult result=buildingProcessDataProxy.resetEquipmentStopToVMI(machineConfig);
						if(!result.getResult().equals("1")){
						    return "连接VMI中间表错误"+result.getResult();
						}
					} catch (NoClassDefFoundError e) {
						return "webService错误!"+e.getMessage();
					} catch (Exception e) {
						return "出现其他错误:"+e.getMessage();
					}
				}else{
					LineTagDataProxy lineTagDataProxy=new LineTagDataProxy(webServiceAddress,resultMap.get("p_line_name").toString());
					List<WriteTagResult> list2=lineTagDataProxy.writeTagDataListToPLC(resultMap.get("p_line_name").toString(), listDate);
				}
			}
			for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
				// 传递的按钮参数与控制项key的比较
				if (dataOnOffDate.substring(0, 6).equals(entry.getKey())) {
					if(entry.getValue()==null){
						if (dataOnOffDate.substring(6).equals("0")) {
							buildingControl.setCreated_by_s(WebUtils.getUser().userCode);
							buildingControl.setCreated_time_t(timestamp);
							buildingControl.setRecord_flag_s("A");
							buildingControl.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							buildingControl.setS_factory_s(LLWebUtils.factory());
							buildingControl.setControltype_s("0");
							buildingControl.setControlitem_s(entry.getKey());
							buildingControl.setControlstatus_s(dataOnOffDate.substring(6));
							buildingControl.setControlcode_s(resultMap.get("p_line_name")+entry.getKey());
							buildingControl.setMachinebarcode_s(resultMap.get("p_line_name").toString());
							buildingControl.setChanged_by_s(LLWebUtils.getUser().userCode);
							buildingControl.setChanged_time_s(sdf.format(timestamp));
							save(buildingControl);
							usecontrollog.setMachinebarcode_s(resultMap.get("p_line_name").toString());
							usecontrollog.setCreated_by_s(WebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("0");
							usecontrollog.setS_factory_s(LLWebUtils.factory());
							usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							// 保存修改履历
							usecontrollogService.saveOne(usecontrollog);
							message ="ok";
						}else if(dataOnOffDate.substring(6).equals("1")){
							buildingControl.setCreated_by_s(LLWebUtils.getUser().userCode);
							buildingControl.setCreated_time_t(timestamp);
							buildingControl.setRecord_flag_s("A");
							buildingControl.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							buildingControl.setS_factory_s(LLWebUtils.factory());
							buildingControl.setControltype_s("0");
							buildingControl.setControlitem_s(entry.getKey());
	                        buildingControl.setControlstatus_s(dataOnOffDate.substring(6));
	                        buildingControl.setControlcode_s(resultMap.get("p_line_name")+entry.getKey());
	                        buildingControl.setMachinebarcode_s(resultMap.get("p_line_name").toString());
	                        buildingControl.setChanged_by_s(LLWebUtils.getUser().userCode);
	                        buildingControl.setChanged_time_s(sdf.format(timestamp));
	                        save(buildingControl);
	                        usecontrollog.setMachinebarcode_s(resultMap.get("p_line_name").toString());
							usecontrollog.setCreated_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("0");
							usecontrollog.setS_factory_s(LLWebUtils.factory());
							usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							// 保存修改履历
							usecontrollogService.saveOne(usecontrollog);
							message ="ok";
						}
					}else{
						// dataOnOffDate 按钮 entry.getValue()状态
						// 判断按钮的当前状态，当传递参数与当前状态相同则不更新，不同则更新状态
						if (dataOnOffDate.substring(6).equals(entry.getValue().toString())) {
							message ="已经是当前状态";
						} else {
							usecontrollog.setMachinebarcode_s(resultMap.get("p_line_name").toString());
							usecontrollog.setCreated_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("0");
							usecontrollog.setS_factory_s(LLWebUtils.factory());
							usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							/*sql.append("update AT_CM_EM_PRODUCTCONTROL set CONTROLSTATUS_S =" + dataOnOffDate.substring(6)
									+ ",CHANGED_BY_S=" + "'" + LLWebUtils.getUser().userCode + "',CHANGED_TIME_S=" + "'"
									+ timestamp + "'" + " where CONTROLITEM_S=" + "'" + entry.getKey() + "'"
									+ " and MACHINEBARCODE_S='" + resultMap.get("machinebarcode_s") + "'");*/
							Map<String, Object> mapWhere=new HashMap<>();
							Map<String, Object> mapValue=new HashMap<>();
							mapWhere.put("controlitem_s", entry.getKey());
							mapWhere.put("machinebarcode_s", resultMap.get("machinebarcode_s"));
							mapValue.put("controlstatus_s", dataOnOffDate.substring(6));
							mapValue.put("changed_by_s", LLWebUtils.getUser().userCode);
							mapValue.put("changed_time_s", sdf.format(timestamp));
							UserTransaction userTransaction = null;
							try {
								userTransaction = TransactionHelper.getUserTransaction(getFunction());
								userTransaction.begin();
								// 保存修改履历
								usecontrollogService.saveOne(usecontrollog);
								update(mapWhere, mapValue);
								// 执行更新语句
								//RockWellUtils.execSQL(sql.toString());
								userTransaction.commit();
							}catch (Exception ex) {
								if (userTransaction != null) {
									TransactionHelper.rollBack(userTransaction);
								}
								throw ex;
							}
							message ="ok";
						}
					}
				}
			}
		}
		return message;
	}
}
