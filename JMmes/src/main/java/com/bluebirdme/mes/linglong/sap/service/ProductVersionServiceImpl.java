/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.sap.entity.ProductVersion;
import com.bluebirdme.mes.linglong.sap.entity.dto.ProductVersionDTO;

/**
 * SAP下发生产版本
 * 
 * @author 刘朋
 * @Date 2018-09-22 16:49:09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductVersionServiceImpl extends
		RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ProductVersion.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	
	/**
	 * search ProductionVer from table AT_INT_SAP_PRODUCTVERSION in Sap
	 * 从sap下发生产版本表中获取生产版本号
	 * 2019/04/24
	 * Yinghui.Lan
	 */
    public List<String> searchProductionVersion(){
    	SQLQuery productionVersionQuery = createSQLQuery(getSQL("searchProductionVersion"));
		return productionVersionQuery.list();
    }
}
