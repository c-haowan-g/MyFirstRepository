/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebird.clientdata.WriteTagData;
import com.bluebird.clientdata.WriteTagResult;
import com.bluebird.clientproxy.LineTagDataProxy;
import com.bluebird.dataaccess.TransactionHelper;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Ent;
import com.bluebirdme.mes.linglong.finalcheck.entity.EquipmetUDA;
import com.datasweep.compatibility.client.Area;
import com.datasweep.compatibility.client.Equipment;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.client.WorkCenter;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 质检设备信息表
 * 
 * @author 刘朋
 * @Date 2018-08-10 07:56:16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EntModelServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Ent.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	/**
	 * 保存方法
	 * 
	 * @param ent
	 *            机台实体类
	 * @throws Exception
	 */
	@RockWellTransactional
	public void saveChanges(RockWellEntityDTO ent) throws Exception {
		if (!ListUtils.isEmpty(ent.getDeleted())) {
			List<Map<String, Object>> entList = ent.getDeleted();
			for (Map<String, Object> item : entList) {
				// 厂区
				Area area = getFunction().getAreaByName(FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "D");
				// 产线
				ProductionLine productionline = getFunction()
						.getProductionLineByName(item.get("equip_key").toString());
				// 工作中心
				WorkCenter workcenter = getFunction().getWorkCenterByName(item.get("equip_key").toString());
				// 设备
				Equipment equipment = getFunction().getEquipmentByKey(Long.valueOf(item.get("equip_key").toString()));
				// 删除厂区与产线关系
				if (area != null) {
					area.removeProductionLine(productionline);
					area.save();
				}
				// 删除产线与工作中心关系
				if (productionline != null) {
					productionline.removeWorkCenter(workcenter);
					productionline.save();
				}
				// 删除工作中心与设备关系
				if (workcenter != null) {
					workcenter.removeEquipment(equipment);
					workcenter.save();
				}
				// 删除所有基础数据
				if (equipment != null) {
					equipment.delete(getDBTime(), LLWebUtils.getUserName() + "删除了质检设备"
							+ item.get("equip_key").toString());
					workcenter.delete(getDBTime(), LLWebUtils.getUserName() + "删除了质检设备关联的工作中心"
							+ item.get("equip_key").toString());
					productionline.delete(getDBTime(),
							LLWebUtils.getUserName() + "删除了质检设备关联的产线" + item.get("equip_key").toString());
				}
			}
		}
		if (!ListUtils.isEmpty(ent.getInserted())) {
			List<Map<String, Object>> entList = ent.getInserted();
			for (Map<String, Object> item : entList) {
				if (item.get("equip_name") != null) {
					Equipment equipment = getFunction().getEquipmentByName(item.get("equip_name").toString());
					if (equipment == null) {
						equipment = getFunction().createEquipment(item.get("equip_name").toString());
						equipment.setName(item.get("equip_name").toString());
						equipment.setUDA(item.get("uda_0").toString(), 0);
						equipment.setUDA(item.get("equip_type_s"), EquipmetUDA.EQUIP_TYPE);
						equipment.setDescription(item.get("description").toString());
						equipment.setUDA(item.get("uda_1").toString(), 1);
						equipment.setUDA(LLWebUtils.getUserName(), 2);
						equipment.setUDA(item.get("status_s").toString(), EquipmetUDA.STATUS);
						equipment.setUDA("1", EquipmetUDA.DEVICE_VALID);
						equipment.setUDA(LLWebUtils.getUserName(), EquipmetUDA.CHANGEBY);
						equipment.setUDA(LLWebUtils.factory(), EquipmetUDA.S_FACTORY);
						equipment.setUDA(FactoryConstant.JING_MEN_CODE, EquipmetUDA.AGENCNO);
						equipment.save();
						Equipment equipsel = getFunction().getEquipmentByName(item.get("equip_name").toString());
						
						ProductionLine productionline = getFunction().createProductionLine(String.valueOf(equipsel.getEquipmentKey()));
						// 关联产线
						productionline.setDescription(item.get("description").toString() + "终检设备关联产线");
						// 关联工作中心
						WorkCenter workcenter = getFunction().createWorkCenter(String.valueOf(equipsel.getEquipmentKey()));
						workcenter.setDescription(item.get("description").toString() + "终检设备关联工作中心");
						workcenter.addEquipment(equipment);
						workcenter.save();
						productionline.addWorkCenter(workcenter);
						productionline.save();
						// 关联厂区
						Area area = getFunction().getAreaByName(
								FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "D");
						area.addProductionLine(productionline);
						area.save();
						if (item.get("equip_type_s").equals("254002")) {
							
						}
					}
				}
			}
		}
		if (!ListUtils.isEmpty(ent.getUpdated())) {
			List<Map<String, Object>> entList = ent.getUpdated();
			for (Map<String, Object> item : entList) {
				Equipment equipment = getFunction().getEquipmentByKey(Long.valueOf(item.get("equip_key").toString()));
				if (equipment == null) {
					continue;
				}
				equipment.setUDA(item.get("uda_0").toString(), 0);
				equipment.setUDA(item.get("equip_type_s"), EquipmetUDA.EQUIP_TYPE);
				equipment.setDescription(item.get("description").toString());
				equipment.setUDA(item.get("uda_1").toString(), 1);
				equipment.setName(item.get("equip_name").toString());
				equipment.setUDA(item.get("status_s").toString(), EquipmetUDA.STATUS);
				equipment.setUDA(LLWebUtils.getUserName(), EquipmetUDA.CHANGEBY);
				equipment.save();
				
				if (item.get("equip_type_s").equals("254002")) {
					// TODO调用下发tag点接口，路径待改，暂时屏蔽
					// changeTagStatus(item.get("equip_name").toString(),
					// item.get("status_s").toString());
				}
			}
		}
	}

	/**
	 * 外观机台保存是否强制下发信息至tag点
	 * 
	 * @param entcode
	 *            机台条码
	 * @param status
	 *            状态，0：否，1:是
	 * @throws Exception
	 */
	private void changeTagStatus(String entcode, String status) throws Exception {
		if (status == "" || entcode == "") {
			throw new Exception("机台信息或状态缺失");
		}
		String webServiceAddress = "http://192.168.55.43:11201/winceService?wsdl";// 全钢分发服务地址
		LineTagDataProxy lineTagDataProxy = new LineTagDataProxy(webServiceAddress, entcode);
		WriteTagData writeTagData = new WriteTagData();
		writeTagData.setLogicalAddress("MesToPlcOnLine");
		writeTagData.setTagValue(status);
		List<WriteTagData> listDate = new ArrayList<>();
		listDate.add(writeTagData);
		try {
			List<WriteTagResult> list = lineTagDataProxy.writeTagDataListToPLC(entcode, listDate);
			if (list.size() == 0 || list == null) {
				throw new Exception("下发信息至Tag点(MesToPlcOnLine)失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> entBarcodeExit(String entbarcode_sString) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("entBarcodeExit"));
		query.setParameter("entbarcode_s", entbarcode_sString);
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 强制开启关闭操作方法
	 * 
	 * @param ids
	 *            界面操作的行ID
	 * @throws Exception
	 */
	public void forced(Long[] ids, String foreType) throws Exception {
		for (int i = 0; i < ids.length; i++) {
			Equipment equipment = getFunction().getEquipmentByKey(ids[i]);
			equipment.setUDA(foreType, EquipmetUDA.DEVICE_VALID);
			equipment.setUDA(LLWebUtils.getUserName(), EquipmetUDA.CHANGEBY);
			UserTransaction userTransaction = null;
			try {
				userTransaction = TransactionHelper.getUserTransaction(getFunction());
				userTransaction.begin();
				// 保存修改履历
				equipment.save();
				userTransaction.commit();
			}catch (Exception ex) {
				if (userTransaction != null) {
					TransactionHelper.rollBack(userTransaction);
				}
				throw ex;
			}
			// TODO调用下发tag点接口，路径待改，暂时屏蔽
			// changeTagStatus(ent.getEntbarcode_s(), foreType);
		}
	}

	/**
	 * 查询机台，下拉框 根据设备类型查询终检设备
	 * 
	 * @Title: SearchEnt
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> SearchEnt(String equip_type) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("SearchEnt"));
		query.setParameter("equip_type_s", equip_type);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list = query.list();
		return list;
	}

}
