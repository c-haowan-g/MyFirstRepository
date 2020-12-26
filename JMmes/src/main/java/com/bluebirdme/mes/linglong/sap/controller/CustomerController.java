/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.sap.entity.Customer;
import com.bluebirdme.mes.linglong.sap.entity.dto.CustomerDTO;
import com.bluebirdme.mes.linglong.sap.service.CustomerServiceImpl;

/**
 * 客户主数据信息
 * 
 * @author 刘朋
 * @Date 2018-09-25 15:16:48
 */
@Log(code = "Customer", value = "客户主数据信息")
@RestController
@RequestMapping("sap/common/customer")
public class CustomerController extends RockWellFunctionalController<Customer> {

	@Resource
	CustomerServiceImpl customerSrv;

	@Override
	protected RockWellBaseServiceImpl<Customer> getService() {
		return customerSrv;
	}

	@Log(code = "Customer_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody CustomerDTO customer)
			throws Exception {
		customerSrv.saveChanges(customer);
		return Response.suc();
	}

}
