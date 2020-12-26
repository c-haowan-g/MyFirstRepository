/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.dataaccess.TransactionHelper;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.uda.EquipmentUDA;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.entity.Usecontrollog;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.datasweep.compatibility.client.Equipment;
import com.datasweep.compatibility.client.EquipmentFilter;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 成型机台投料口控制管理
 * 
 * @author 时永良
 * @Date 2019年1月28日16:25:55
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeederNoseControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

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
    public IFunctionsEx  getFunction(){
	    	return PCContext.getFunctions();
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
	public List<Map<String, Object>> searchByModal() {
		SQLQuery query = createSQLQuery(getSQL("searchByModal"));
		String s_factory_s=LLWebUtils.factory();
		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
		query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",AGENC_NO_S);
		return query.list();
	}
	/**
	 * 根据数据字典查出所需控制项
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByDictionary() {
		if(LLWebUtils.factory().equals("1")){
			SQLQuery query = createSQLQuery(getSQL("searchBy199"));
			return query.list();
		}else if(LLWebUtils.factory().equals("2")){
			SQLQuery query = createSQLQuery(getSQL("searchBy198"));
			return query.list();
		}
		return null;
	}
	/**
	 * 根据数据字典查出所需控制项（199为数据字典中代码号）全钢
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy199() {
		SQLQuery query = createSQLQuery(getSQL("searchBy199"));
		return query.list();
	}
	/**
	 * 根据数据字典查出所需控制项（198为数据字典中代码号）半钢
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy198() {
		SQLQuery query = createSQLQuery(getSQL("searchBy198"));
		return query.list();
	}
	/**
	 * 根据菜单管理查出数据
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchFromCoreMenu() {
		String s_factory_s=LLWebUtils.factory();
		SQLQuery query = createSQLQuery(getSQL("searchFromCoreMenu"));
		query.setParameter("url","view?page=building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol&factory="+s_factory_s+"");
		return query.list();
	}
	/**
	 * 查询全部 页面初始化使用
	 * @param machinename_s
	 *        机台名称
	 * @param machinegroup_s
	 *        机台组
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> searchInit(String machinename_s, String machinegroup_s)
			throws Exception {
		List<Map<String, Object>> quanGangList = searchBy199();
		List<Map<String, Object>> buanGangList = searchBy198();
		StringBuffer sql = new StringBuffer(
				"SELECT A.*,B.DESCRIPTION as machinename_s,B.P_LINE_NAME,D.MACHINEGROUP_S as machinegroup_s");
		sql.append(" from (select a.productionline_code_s");
		if(LLWebUtils.factory().equals("1")){
			for (int i = 0; i < quanGangList.size(); i++) {
				String DICTCODE_S = (String) quanGangList.get(i).get("DICTCODE_S");
				String DICTNAME_S = (String) quanGangList.get(i).get("DICTNAME");
				sql.append(",sum(case when configclassmes_s=" + "'" + DICTCODE_S + "'" + " then configstatus_s end) " + "A"
						+ DICTCODE_S + "" + "");
			}
			sql.append(" from UDA_EQUIPMENT a where a.EQUIP_TYPE_S ='161001' and a.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "'" +" and a.AGENCNO_S="+ "'" + FactoryConstant.JING_MEN_CODE + "'" +"group by a.productionline_code_s) A right JOIN (SELECT p.DESCRIPTION ,p.P_LINE_NAME,p.P_LINE_KEY FROM AREA c,AREA_PRODUCTION_LINE d,PRODUCTION_LINE p where c.AREA_KEY=d.PARENT_KEY and d.CHILD_KEY=p.P_LINE_KEY and c.AREA_NAME ='80231B') B on substr(A.productionline_code_s,0,instr(A.productionline_code_s,'_',1,1)-1)=B.P_LINE_NAME LEFT JOIN UDA_ProductionLine D on B.P_LINE_KEY=D.OBJECT_KEY where D.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "' and D.Process_s = '252005' ");
		}else if(LLWebUtils.factory().equals("2")){
			for (int i = 0; i < buanGangList.size(); i++) {
				String DICTCODE_S = (String) buanGangList.get(i).get("DICTCODE_S");
				String DICTNAME_S = (String) buanGangList.get(i).get("DICTNAME");
				sql.append(",sum(case when configclassmes_s=" + "'" + DICTCODE_S + "'" + " then configstatus_s end) " + "A"
						+ DICTCODE_S + "" + "");
			}
			sql.append(" from UDA_EQUIPMENT a where a.EQUIP_TYPE_S ='161001' and a.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "'" +" and a.AGENCNO_S="+ "'" + FactoryConstant.JING_MEN_CODE + "'" +"group by a.productionline_code_s) A right JOIN (SELECT p.DESCRIPTION ,p.P_LINE_NAME,p.P_LINE_KEY FROM AREA c,AREA_PRODUCTION_LINE d,PRODUCTION_LINE p where c.AREA_KEY=d.PARENT_KEY and d.CHILD_KEY=p.P_LINE_KEY and c.AREA_NAME ='80232B') B on substr(A.productionline_code_s,0,instr(A.productionline_code_s,'_',1,1)-1)=B.P_LINE_NAME LEFT JOIN UDA_ProductionLine D on B.P_LINE_KEY=D.OBJECT_KEY where D.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "' and D.Process_s = '252005' ");
		}
		if (machinename_s != null && machinename_s != "") {
			sql.append("and B.DESCRIPTION like '" + machinename_s + "%'");	
		}
		if (machinegroup_s != null && machinegroup_s != "") {
			sql.append("and D.MACHINEGROUP_S like '" + machinegroup_s + "%'");
		}
		sql.append("order by B.P_LINE_NAME");
		SQLQuery query = createSQLQuery(sql.toString());
		System.out.println(sql.toString());
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
		Map<String, Object> resultMap = null;
		List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
		// 遍历key,将包含198的截取（去掉第一位的A），保存新的map(198XXX是行转列的控制项)
		if(LLWebUtils.factory().equals("1")){
			for(int i=0;i<list.size();i++){
				resultMap=new HashMap<>();
				for (String key : list.get(i).keySet()) {
					String newKey = key.toLowerCase();
					if (newKey.indexOf("199") != -1) {
						newKey = newKey.substring(1, 7);
					}
					resultMap.put(newKey, list.get(i).get(key));
				}
				resultMapList.add(resultMap); 
			}
		}else if(LLWebUtils.factory().equals("2")){
			for(int i=0;i<list.size();i++){
				resultMap=new HashMap<>();
				for (String key : list.get(i).keySet()) {
					String newKey = key.toLowerCase();
					if (newKey.indexOf("198") != -1) {
						newKey = newKey.substring(1, 7);
					}
					resultMap.put(newKey, list.get(i).get(key));
				}
				resultMapList.add(resultMap); 
			}
		}
		
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);

		UsecontrollogService usecontrollogService = new UsecontrollogService();
		Usecontrollog usecontrollog = new Usecontrollog();
		
		List<Map<String, Object>> quanGangList = searchBy199();
		List<Map<String, Object>> buanGangList = searchBy198();
		String message=null;
		for(int i=0;i<resultMapList.size();i++){
			resultMap=resultMapList.get(i);
			for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
				// 传递的按钮参数与控制项key的比较
					if (dataOnOffDate.substring(0, 6).equals(entry.getKey())) {
						if(entry.getValue()==null){
							if(LLWebUtils.factory().equals("1")){
								for (int j = 0; j < quanGangList.size(); j++) {
									String DICTCODE_S = (String) quanGangList.get(j).get("DICTCODE_S");
									String DICTNAME_S = (String) quanGangList.get(j).get("DICTNAME");
									if(DICTCODE_S.equals(dataOnOffDate.substring(0, 6))){
										 List<Map<String, Object>> b=this.searchDescriptionByProductionlineCode(resultMap.get("p_line_name").toString());
										 message =b.get(0).get("DESCRIPTION")+" 机台下无  "+DICTNAME_S+"投料口";
										 return message;
									}
								}
							}else if(LLWebUtils.factory().equals("2")){
								for (int j = 0; j < buanGangList.size(); j++) {
									String DICTCODE_S = (String) buanGangList.get(j).get("DICTCODE_S");
									String DICTNAME_S = (String) buanGangList.get(j).get("DICTNAME");
									if(DICTCODE_S.equals(dataOnOffDate.substring(0, 6))){
										 List<Map<String, Object>> b=this.searchDescriptionByProductionlineCode(resultMap.get("p_line_name").toString());
										 message =b.get(0).get("DESCRIPTION")+" 机台下无  "+DICTNAME_S+"投料口";
										 return message;
									}
								}
							}
						}else{
							// dataOnOffDate 按钮 entry.getValue()状态
							// 判断按钮的当前状态，当传递参数与当前状态相同则不更新，不同则更新状态
							if (dataOnOffDate.substring(6).equals(entry.getValue().toString())) {
								 message ="已经是当前状态";
							} else {
								usecontrollog.setMachinebarcode_s(resultMap.get("p_line_name").toString());
								usecontrollog.setCreated_by_s(WebUtils.getUser().userCode);
								usecontrollog.setCreated_time_t(timestamp);
								usecontrollog.setControlitem_s(entry.getKey());
								usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
								usecontrollog.setChanged_by_s(WebUtils.getUser().userCode);
								usecontrollog.setChanged_time_t(timestamp);
								usecontrollog.setRecord_flag_s("A");
								usecontrollog.setControltype_s("1");
								usecontrollog.setS_factory_s(LLWebUtils.factory());
								usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
								UserTransaction userTransaction = null;
								try {
									userTransaction = TransactionHelper.getUserTransaction(getFunction());
									userTransaction.begin();
									if(resultMap.get("productionline_code_s")!=null){
										EquipmentFilter filter=getFunction().createEquipmentFilter();
										filter.forUdaEqualTo(EquipmentUDA.CONFIGCLASSMES, entry.getKey());
										filter.forUdaEqualTo(EquipmentUDA.PRODUCTIONLINE_CODE, resultMap.get("productionline_code_s").toString());
										@SuppressWarnings("unchecked")
										Vector<Equipment> feederNoseEquipments=filter.exec();
										Equipment equipment=feederNoseEquipments.get(0);
									    equipment.setUDA(dataOnOffDate.substring(6),EquipmentUDA.CONFIGSTATUS);
										equipment.save();
										usecontrollogService.saveOne(usecontrollog);
									}
									userTransaction.commit();
								}catch (Exception ex) {
									if (userTransaction != null) {
										TransactionHelper.rollBack(userTransaction);
									}
									throw ex;
								}
								/*sql.append("update UDA_EQUIPMENT set configstatus_s =" + dataOnOffDate.substring(6)
									    + " where configclassmes_s=" + "'" + entry.getKey() + "'"
										+ " and productionline_code_s='" + resultMap.get("productionline_code_s") + "'");*/
								
								//RockWellUtils.execSQL(sql.toString());
								message ="ok";
							}
						}	
					}
			}
		}
		return message;
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
	 * 根据产线编号关联产线表查出产线名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescriptionByProductionlineCode(String productionline_code){
		SQLQuery query = createSQLQuery(getSQL("searchDescriptionByProductionlineCode"));
		String s_factory_s=LLWebUtils.factory();
		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
		query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
		query.setParameter("p_line_name",productionline_code);
		return query.list();
	}
}
