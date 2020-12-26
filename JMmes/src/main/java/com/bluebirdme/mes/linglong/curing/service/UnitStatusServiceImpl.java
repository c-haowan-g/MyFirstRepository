/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.datasweep.compatibility.client.Unit;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * unit状态测试
 * 
 * @author penga_liu
 * 
 * @Date 2019年6月23日 下午1:39:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UnitStatusServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl serialSrv;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return null;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	@SuppressWarnings("deprecation")
	public void updateSerialStatus(String scan_serial_number, String orderitem, String step, String reason, String flag) {

		// Lot lot = getFunction().getLotByName("Lot_BWCY2019070023001");
		// lot.addOneUnit(scan_serial_number);
		// lot.save();
		Time time = new Time();
		Unit unit = null;
		Unit checkunit = null;
		List<Map<String, Object>> unitList = getUnitByitem(orderitem);// 查询所有unit
		Map<String, Object> NativeSerialnum = changeSerialNumber(orderitem);// 查询未关联unit
		Map<String, Object> checkUnit = checkUnit(orderitem, scan_serial_number);// 查询未关联unit
		if (flag.equals("1")) {
			if (checkUnit != null) {
				unit = getFunction().getUnitBySerialNumber(checkUnit.get("SERIAL_NUMBER").toString());
			} else {
				if (NativeSerialnum != null) {
					unit = getFunction().getUnitBySerialNumber(NativeSerialnum.get("SERIAL_NUMBER").toString());
					unit.setUDA(scan_serial_number, 0);// 将扫描条码更新到查询条码的备用字段列，作为关联
					unit.save();

				}
			}
			unit.startAtOperation(time, step, step + "开始生产" + time, true);
		} else if (flag.equals("0")) {
			for (int i = 0; i < unitList.size(); i++) {
				if (unitList.get(i).get("UDA_0") != null) {
					if (unitList.get(i).get("UDA_0").equals(scan_serial_number)) {
						unit = getFunction().getUnitBySerialNumber(unitList.get(i).get("SERIAL_NUMBER").toString());
					}
				}
			}
			unit.completeAtOperation(time, step, step + reason, step + "结束生产" + time);
			// unit.changeOnHandStatusToBad(time, reason +
			// "onHand");//坏的
			// unit.finish(time, reason, "生产完成");
		}
		if (step.equals("c")) {
			unit.close(time, reason, "生产关闭");
		} else if (step.equals("f")) {
			unit.finish(time, reason, "生产完成");
		} else if (step.equals("s")) {
			unit.ship(time, reason, "发货完成");
		}

	}

	// 扫描修改工单生成条码
	public Map<String, Object> changeSerialNumber(String orderitem) {
		SQLQuery list = createSQLQuery(getSQL("getSerialNumByItem"));
		List returnlist = list.setParameter("orderitem", orderitem).list();
		Map serialNum = null;
		if (returnlist.size() > 0) {
			serialNum = (HashMap<String, Object>) list.list().get(0);
		}
		return serialNum;
	}

	// 获取工单下所有unit
	public List<Map<String, Object>> getUnitByitem(String orderitem) {
		SQLQuery list = createSQLQuery(getSQL("getUnitByItem"));
		List unitlist = list.setParameter("orderitem", orderitem).list();
		return unitlist;
	}

	// 获取工单下指定Unit是否存在
	public Map<String, Object> checkUnit(String orderitem, String barCode) {
		SQLQuery list = createSQLQuery(getSQL("checkUnit"));
		list.setParameter("orderitem", orderitem);
		list.setParameter("barCode", barCode);
		Map serialNum = null;
		if (list.list().size() > 0) {
			serialNum = (HashMap<String, Object>) list.list().get(0);
		}
		return serialNum;
	}
}
