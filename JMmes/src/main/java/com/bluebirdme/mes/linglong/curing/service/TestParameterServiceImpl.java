/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.TestParameter;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 页面名称:工艺参数查询
 * 
 * @author whl
 * @Date 2018-09-04 18:37:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestParameterServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return TestParameter.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public int save2(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		BigDecimal rs = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
        List<Object> list=new ArrayList<Object>();//保存对象
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {

			for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
				TestParameter item = (TestParameter) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), getEntity());

				item.getAtr_key();
				/* 更新时间 */
				item.setChanged_time_t(new Date());
				/* 更新人 */
				item.setChanged_by_s(WebUtils.getUser().userCode);
				list.add(item);
			}
			update(list);
			mun = 0;

		}

		return mun;
	}

	/**
	 * 通过日计划状态（已执行），查询生产状态机台
	 * 
	 * @Title: getDataByStatus
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getDataByStatus() throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		SQLQuery query = createSQLQuery(getSQL("getDataByStatus"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 通过机台查找计划号
	 * 
	 * @Title: getPlanByEquip
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getPlanByEquip(String equip_code) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		SQLQuery query = createSQLQuery(getSQL("getPlanByEquip"));
		query.setParameter("s_factory_s", com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
		query.setParameter("equip_code", equip_code);
		return query.list();
	}

	@RockWellTransactional
	public int flagChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		BigDecimal rs = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		TestParameter item = (TestParameter) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(0), getEntity());
		map.put("producting_dayplan_s", item.getProducting_dayplan_s());
		map.put("s_factory_s", LLWebUtils.factory());
		map2.put("test_flag_s", item.getTest_flag_s());
		update(map, map2);
		mun = 0;
		return mun;
	}
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toUserName").toString());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
}
