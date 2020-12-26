/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.FeedingRecordServiceImpl;

/**
 * 投料记录
 * 
 * @author 刘朋
 * @Date 2019-20-10 8:34:42
 */
@Log(code = "AT_A_MM_FEEDINGRECORD_LOG", value = "投料记录查询日志")
@RestController
@RequestMapping("halfpart/production/FeedingRecord")
public class FeedingRecordController extends RockWellFunctionalUDAController<Object> {

	@Resource
	FeedingRecordServiceImpl feedingrecordSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return feedingrecordSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return feedingrecordSrv;
	}

	/**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	/*
	 * @Log(code = "searchEquipmentCode", value = "查出机条编码显示在JSP页面下拉列表处")
	 * 
	 * @RequestMapping("searchEquipmentCode") public String
	 * searchEquipmentCode() throws Exception { List<Map<String, Object>> list =
	 * feedingrecordSrv.searchEquipmentCode(); return toJson(list); }
	 */

}
