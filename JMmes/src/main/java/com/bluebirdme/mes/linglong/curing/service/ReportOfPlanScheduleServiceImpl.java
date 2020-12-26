/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ReportOfPlanSchedule;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 硫化生产日计划
 * @author 时永良
 * @Date 2018-10-08 15:46:14
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ReportOfPlanScheduleServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ReportOfPlanSchedule.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
	/**
	 * 产线编码的查询（AT_C_MM_MACHINECONTROL中的Product_Line_s）
	 * 时永良-2019/7/17
	 * @return
	 */
	@RequestMapping("searchByProductLine")
	public List<Map<String, Object>> searchByProductLine() {
		SQLQuery query = createSQLQuery(getSQL("searchByProductLine"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> list=query.list();
		return list;
	}
}
