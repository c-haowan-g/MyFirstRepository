/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.sap.entity.Customer;
import com.bluebirdme.mes.linglong.sap.entity.dto.CustomerDTO;

/**
 * 客户主数据信息
 * 
 * @author 刘朋
 * @Date 2018-09-25 15:16:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl extends RockWellBaseServiceImpl<Customer> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Customer.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public void saveChanges(CustomerDTO customer) throws Exception {

		if (!ListUtils.isEmpty(customer.getDeleted())) {
			delete(customer.getDeleted());
		}
		if (!ListUtils.isEmpty(customer.getInserted())) {
			save(customer.getInserted());
		}
		if (!ListUtils.isEmpty(customer.getUpdated())) {
			update(customer.getUpdated());
		}

	}

}
