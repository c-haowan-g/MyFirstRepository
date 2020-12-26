package com.bluebirdme.mes.linglong.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bluebird.common.DBUtil;
import com.bluebird.dataaccess.TransactionHelper;
import com.datasweep.compatibility.client.Lot;
import com.datasweep.compatibility.client.Order;
import com.datasweep.compatibility.client.Server;
import com.datasweep.compatibility.pnuts.Functions;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * @author naikun_li
 * Unit生成后，产生的SerialNumber根据传入参数区分前缀
 */
public class UnitSerialNumberHelper {
	
	private Long numberSerial;
	private String FactoryFlag;
	private Long numfalg;
	
	
	
	public static void  updateSerialNumber(Lot lot,String falg) throws Exception {
		List<Object> list=new ArrayList<Object>();
		UserTransaction userTransaction =null;
		
		DBUtil dbUtil = new DBUtil();
		
		//根据LOT获得ORDER
		Order order=  lot.getOrder();
		
		//根据order查询日计划。
		Functions functions = PCContext.getFunctions();
		Server server = PCContext.getServerImpl();
		String dayPlanSQL = "select * from B_PP_PRODUCTIONDAYPLAN WHERE Plan_No = '"+order.getOrderNumber()+"'";
		
		ResultSet resultSetPlan = dbUtil.findBySQL(dayPlanSQL,list);
		
		
		if (resultSetPlan != null) {
			userTransaction = TransactionHelper.getUserTransaction(functions);
			//获取日计划中工厂编码
			String factory = resultSetPlan.getString("Plan_No");
			if(factory.equals("")){
				//查询当前序列号。
				try {
					UnitSerialNumberHelper unitSerialNumberHelper = null;
					String  SEL_SQL = "select * from AT_AT_SERIALNUMBERHELP WHERE FALG = '"+falg+"'";
					ResultSet resultSet = dbUtil.findBySQL(SEL_SQL,list);
					if (resultSet == null) {
						throw new Exception("order对应日计划号错误或非成型日计划");
					}
					while (resultSet.next()) {
						unitSerialNumberHelper.FactoryFlag = resultSet.getString("FactoryFlag");
						unitSerialNumberHelper.numberSerial = resultSet.getLong("numberSerial");
						unitSerialNumberHelper.numfalg = 0L;
						break;
					}
					//事务开启
					userTransaction.begin();
					//获取lotkey
					Long lotkey = lot.getKey();
					//根绝lotkey找到lot下units
					String unitSQL = "select * from unit where LOT_KEY = '"+lotkey+"';";
					ResultSet resultSetunit=  dbUtil.findBySQL(unitSQL,list);
					
					if(resultSetunit == null){
						throw new Exception("此lot下没有unit单元存在");
					}
					Long num =0L;
					//循环更新lot下unit的serialnumber
					while(resultSetunit.next()){
						unitSerialNumberHelper.numfalg += 1;
						num = unitSerialNumberHelper.numfalg+unitSerialNumberHelper.numberSerial;
						String Serial_number=unitSerialNumberHelper.FactoryFlag +num;
						String updataunitSQL = "UPDATE UNIT SET SERIAL_NUMBER = '"+Serial_number+"' where UNIT_KEY = '"+resultSet.getLong("unit_ket")+"';";
						dbUtil.executeSQLCommand(updataunitSQL);
					}
					//计数最后一次性更新帮助表中的相关数据
					String updateSerialSQL = "UPDATE AT_AT_SERIALNUMBERHELP SET SERIAL_NUMBER = "+num+"WHERE FALG = '2'";
					dbUtil.executeSQLCommand(updateSerialSQL);
					//事务提交
					userTransaction.commit();
				} catch (Exception e) {
					TransactionHelper.rollBack(userTransaction);
					throw e;
				}finally{
					if (dbUtil != null) {
						dbUtil.ClosePreparedStatement();
					}
				}
			}else{
				throw new Exception("标记为空，请检查");
			}
		}else{
			throw new Exception("order对应日计划号错误或非成型日计划");
		}
	}

}
