/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import com.bluebird.clientdata.MachineConfig;
import com.bluebird.clientdata.ResponeResult;
import com.bluebird.clientproxy.PartProessDataProxy;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.Usecontrollog;
import com.bluebirdme.mes.linglong.building.service.UsecontrollogService;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfpartControl;
import com.bluebirdme.mes.linglong.halfpart.entity.Productcontrol;
import com.bluebirdme.mes.linglong.util.DateUtil;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 机台控制开关表
 * @author 时永良
 * @Date 2020年8月18日08:18:10
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfpartControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return HalfpartControl.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    /**
	 * 根据数据字典查出所需控制项（119为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy119() {
		SQLQuery query = createSQLQuery(getSQL("searchBy119"));
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
		query.setParameter("url","view?page=halfpart/productionManagement/halfpartControl/halfpartcontrol&factory="+s_factory_s+"");
		return query.list();
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
		query.setParameter("area_name","8023"+s_factory_s+"A");
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",AGENC_NO_S);
		return query.list();
	}
	
	/**
	 * 查出机台条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query = createSQLQuery(getSQL("searchDescription"));
		String s_factory_s=LLWebUtils.factory();
		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
		query.setParameter("area_name","8023"+s_factory_s+"A");
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",AGENC_NO_S);
		return query.list();
	}
	
    /**
  	 * 查询全部 页面初始化使用
  	 * @param machinecode_s
  	 *        机台条码
  	 * @param machinetype_s
  	 *        机台类型
  	 * @param machinestatus_s
  	 *        机台状态
  	 * @return
  	 * @throws Exception
  	 */
	public List<Map<String, Object>> searchInit(String machinecode_s,String machinetype_s,String machinestatus_s)
			throws Exception {
		List<Map<String, Object>> list = searchBy119();
		StringBuffer sql = new StringBuffer(
				"SELECT A.*,B.P_LINE_NAME as MACHINECODE_S,B.CATEGORY as MACHINETYPE_S,C.MACHINESTATUS_S as MACHINESTATUS_S,D.PROCESS_S as PROCESS_S,A.CHANGED_TIME_S as changedtime,");
		sql.append("(select DISTINCT US1.USERNAME from AT_CM_EM_PRODUCTCONTROL b LEFT JOIN CORE_USER US1 ON b.CHANGED_BY_S=US1.USERCODE where b.CHANGED_TIME_S=A.CHANGED_TIME_S) as changedby from (select a.MACHINEBARCODE_S");
		for (int i = 0; i < list.size(); i++) {
			String DICTCODE_S = (String) list.get(i).get("DICTCODE_S");
			String DICTNAME_S = (String) list.get(i).get("DICTNAME");
			sql.append(",sum(case when CONTROLITEM_S=" + "'" + DICTCODE_S + "'" + " then CONTROLSTATUS_S end) " + "A"
					+ DICTCODE_S + "" + "");
		}
		sql.append(",max(a.CHANGED_TIME_S) as CHANGED_TIME_S from AT_CM_EM_PRODUCTCONTROL a where a.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "'" +" and a.AGENC_NO_S="+ "'" + FactoryConstant.JING_MEN_CODE + "'" +"group by a.MACHINEBARCODE_S) A right JOIN (SELECT p.DESCRIPTION ,p.P_LINE_NAME,p.P_LINE_KEY,p.CATEGORY FROM AREA c,AREA_PRODUCTION_LINE d,PRODUCTION_LINE p where c.AREA_KEY=d.PARENT_KEY and d.CHILD_KEY=p.P_LINE_KEY and c.AREA_NAME ='8023"+LLWebUtils.factory()+"A') B on A.MACHINEBARCODE_S=B.P_LINE_NAME LEFT JOIN AT_CM_EM_MACHINESTATUS C on B.P_LINE_NAME=C.MACHINEBARCODE_S LEFT JOIN UDA_ProductionLine D on B.P_LINE_KEY=D.OBJECT_KEY where D.S_FACTORY_S=" + "'" + LLWebUtils.factory() + "' and D.Process_s = '252004' and C.record_flag_s='A' ");
		if (machinecode_s != null && machinecode_s != "") {
			sql.append("and B.P_LINE_NAME like '" + machinecode_s + "%'");
		}
		if (machinetype_s != null && machinetype_s != "") {
			sql.append("and B.CATEGORY like '" + machinetype_s + "%'");
		}
		if (machinestatus_s != null && machinestatus_s != "") {
			sql.append("and C.MACHINESTATUS_S like '" + machinestatus_s + "%'");
		}
		sql.append("order by B.CATEGORY");
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
		Map<String,Object> resultMap=null;
		List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
		// 遍历key,将包含119的截取（去掉第一位的A），保存新的map(119XXX是行转列的控制项)
		for(int i=0;i<list.size();i++){
			resultMap=new HashMap<>();
			for (String key : list.get(i).keySet()) {
				String newKey = key.toLowerCase();
				if (newKey.indexOf("119") != -1) {
					newKey = newKey.substring(1, 7);
				}
				resultMap.put(newKey, list.get(i).get(key));
			}
            resultMapList.add(resultMap); 
		}
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		StringBuffer sql = null;
		UsecontrollogService usecontrollogService = new UsecontrollogService();
		Usecontrollog usecontrollog = new Usecontrollog();
		Productcontrol productControl =new Productcontrol();
		String message=null;
		for(int i=0;i<resultMapList.size();i++){
			sql=new StringBuffer();
			resultMap=resultMapList.get(i);
			String webServiceAddress="";
			if(LLWebUtils.factory().equals("2")){
				webServiceAddress="http://192.168.71.20:11012/winceService?wsdl";//半钢
			}
			
			//1190010是投料控制关闭按钮
			if(dataOnOffDate.equals("1190010")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			//1190020是产出控制关闭按钮
			if(dataOnOffDate.equals("1190020")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveToolingStopAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			
			
			//1190030是投料量控制关闭按钮
			if(dataOnOffDate.equals("1190030")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			
			//1190090是投料规格检验停机关闭按钮
			if(dataOnOffDate.equals("1190090")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			
			//1190100是物料时效性停机关闭按钮
			if(dataOnOffDate.equals("1190100")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			
			//1190110是物料质量校验停机关闭按钮
			if(dataOnOffDate.equals("1190110")){
				try {
					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,resultMap.get("machinecode_s").toString());
					MachineConfig machineConfig = new MachineConfig();
					machineConfig.setMachineCode(resultMap.get("machinecode_s").toString());
					ResponeResult result=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
					if(!result.getResult().equals("OK")){
					    return "连接后台服务报错";
					}
				}catch(Exception e) {
					return "出现其他错误:"+e.getMessage();
				}	
			}
			
			for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
				// 传递的按钮参数与控制项key的比较
				if (dataOnOffDate.substring(0, 6).equals(entry.getKey())) {
					if(entry.getValue()==null){
						if (dataOnOffDate.substring(6).equals("0")) {
							System.out.println(resultMap.get("machinecode_s").toString());
                            productControl.setCreated_by_s(WebUtils.getUser().userCode);
                            productControl.setCreated_time_t(timestamp);
                            productControl.setRecord_flag_s("A");
                            productControl.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
                            productControl.setS_factory_s(LLWebUtils.factory());
                            productControl.setControltype_s("0");
                            productControl.setControlitem_s(entry.getKey());
                            productControl.setControlstatus_s(dataOnOffDate.substring(6));
                            productControl.setControlcode_s(resultMap.get("machinecode_s")+entry.getKey());
                            productControl.setMachinebarcode_s(resultMap.get("machinecode_s").toString());
                            productControl.setChanged_by_s(LLWebUtils.getUser().userCode);
                            productControl.setChanged_time_s(sdf.format(timestamp));
                            save(productControl);
							usecontrollog.setMachinebarcode_s(resultMap.get("machinecode_s").toString());
							usecontrollog.setCreated_by_s(WebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("3");
							usecontrollog.setS_factory_s(LLWebUtils.factory());
							usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							// 保存修改履历
							usecontrollogService.saveOne(usecontrollog);
							message ="ok";
						}else if(dataOnOffDate.substring(6).equals("1")){
							System.out.println(resultMap.get("machinecode_s"));
							productControl.setCreated_by_s(LLWebUtils.getUser().userCode);
	                        productControl.setCreated_time_t(timestamp);
	                        productControl.setRecord_flag_s("A");
	                        productControl.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
	                        productControl.setS_factory_s(LLWebUtils.factory());
	                        productControl.setControltype_s("0");
	                        productControl.setControlitem_s(entry.getKey());
	                        productControl.setControlstatus_s(dataOnOffDate.substring(6));
	                        productControl.setControlcode_s(resultMap.get("machinecode_s")+entry.getKey());
	                        productControl.setMachinebarcode_s(resultMap.get("machinecode_s").toString());
	                        productControl.setChanged_by_s(LLWebUtils.getUser().userCode);
                            productControl.setChanged_time_s(sdf.format(timestamp));
                            save(productControl);
	                        usecontrollog.setMachinebarcode_s(resultMap.get("machinecode_s").toString());
							usecontrollog.setCreated_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("3");
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
							usecontrollog.setMachinebarcode_s(resultMap.get("machinecode_s").toString());
							usecontrollog.setCreated_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setCreated_time_t(timestamp);
							usecontrollog.setControlitem_s(entry.getKey());
							usecontrollog.setControlstatus_s(dataOnOffDate.substring(6));
							usecontrollog.setChanged_by_s(LLWebUtils.getUser().userCode);
							usecontrollog.setChanged_time_t(timestamp);
							usecontrollog.setRecord_flag_s("A");
							usecontrollog.setControltype_s("3");
							usecontrollog.setS_factory_s(LLWebUtils.factory());
							usecontrollog.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
							sql.append("update AT_CM_EM_PRODUCTCONTROL set CONTROLSTATUS_S =" + dataOnOffDate.substring(6)
									+ ",CHANGED_BY_S=" + "'" + LLWebUtils.getUser().userCode + "',CHANGED_TIME_S=" + "'"
									+ timestamp + "'" + " where CONTROLITEM_S=" + "'" + entry.getKey() + "'"
									+ " and MACHINEBARCODE_S='" + resultMap.get("machinebarcode_s") + "'");
							// 保存修改履历
							usecontrollogService.saveOne(usecontrollog);
							// 执行更新语句
							RockWellUtils.execSQL(sql.toString());
							message ="ok";
						}
					}
				}
			}
		}
		return message;
	}
}
