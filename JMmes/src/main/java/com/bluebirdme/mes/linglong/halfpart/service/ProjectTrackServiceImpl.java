/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.Projecttrack;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.util.Date;
/**
 * 半部件计划跟踪
 * @author 徐秉正
 * @Date 2020-03-06 16:32:51
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProjectTrackServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv;// 系统参数获取
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Projecttrack.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}
    
    /**
 	 * 查出机台名称显示在JSP页面下拉列表处
 	 * 
 	 * @return
 	 */
 	public List<Map<String, Object>> searchEquipCode() {
 		SQLQuery query = createSQLQuery(getSQL("searchEquipCode"));
 		String s_factory_s=LLWebUtils.factory();
		String agenc_no_s=FactoryConstant.JING_MEN_CODE;
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",agenc_no_s);
		query.setParameter("record_flag_s","A");
 		return query.list();
 	}
 	
 	/**
 	 * 查出日计划号显示在JSP页面下拉列表处
 	 * 
 	 * @return
 	 */
 	public List<Map<String, Object>> searchPlanno() {
 		SQLQuery query = createSQLQuery(getSQL("searchPlanno"));
 		String s_factory_s=LLWebUtils.factory();
		String agenc_no_s=FactoryConstant.JING_MEN_CODE;
		query.setParameter("s_factory_s",s_factory_s);
		query.setParameter("agenc_no_s",agenc_no_s);
		query.setParameter("record_flag_s","A");
 		return query.list();
 	}
 	
}

