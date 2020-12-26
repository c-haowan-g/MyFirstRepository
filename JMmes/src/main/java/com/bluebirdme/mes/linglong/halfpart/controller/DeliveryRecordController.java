package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.halfpart.entity.DeliveryRecord;
import com.bluebirdme.mes.linglong.halfpart.service.DeliveryRecordServiceImpl;

/**
 * 半部件配送履历
 * 
 * @author 刘朋
 * @Date 2020-03-09 08:20:56
 */
@Log(code = "半部件配送履历", value = "半部件配送履历")
@RestController
@RequestMapping("halfpart/deliveryRecord")
public class DeliveryRecordController extends RockWellFunctionalController<DeliveryRecord> {

	@Resource
	DeliveryRecordServiceImpl deliveryrecordSrv;

	@Override
	protected RockWellBaseServiceImpl<DeliveryRecord> getService() {
		return deliveryrecordSrv;
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByMachineCode")
	public String searchByMachineCode() {
		List<Map<String, Object>> list = deliveryrecordSrv.searchByMachineCode();
		return toJson(list);
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByBatchCode")
	public String searchByBatchCode() {
		List<Map<String, Object>> list = deliveryrecordSrv.searchByBatchCode();
		return toJson(list);
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByVehicleCode")
	public String searchByVehicleCode() {
		List<Map<String, Object>> list = deliveryrecordSrv.searchByVehicleCode();
		return toJson(list);
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByFromLocation")
	public String searchByFromLocation() {
		List<Map<String, Object>> list = deliveryrecordSrv.searchByFromLocation();
		return toJson(list);
	}
}
