/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ShutDownSet;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

/**
 * 硫化报警停机参数
 * 
 * @author 时永良
 * @Date 2018-08-20 08:42:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShutDownSetServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ShutDownSet.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public Integer saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		// 轮胎判级
		String judge_lever_s = null;
		// atr_key
		Long atr_key = null;
		// Sql
		BigDecimal rs = null;
		/**
		 * 带有默认值的数据
		 */
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();

		// 删除
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		ShutDownSet shutDownSet=(ShutDownSet) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), ShutDownSet.class);
        		shutDownSet.setRecord_flag_s("D");
        		// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				shutDownSet.setChanged_time_t(timestamp);
				list.add(shutDownSet);
        	}
        	update(list);
		}
		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		ShutDownSet shutDownSet=(ShutDownSet) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), ShutDownSet.class);
        		//创建人
        		shutDownSet.setCreated_by_s(WebUtils.getUser().userCode);
        		// 修改人
        		shutDownSet.setChanged_by_s(WebUtils.getUser().userCode);
        		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				HttpSession session = request.getSession();
				shutDownSet.setS_factory_s(LLWebUtils.factory());
				shutDownSet.setRecord_flag_s("A");
				// 机构编码
				shutDownSet.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				shutDownSet.setCreated_time_t(timestamp);
				shutDownSet.setChanged_time_t(timestamp);
				// 轮胎判级
				judge_lever_s=shutDownSet.getJudge_lever_s();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("judge_lever_s", judge_lever_s);
				where.andEqual("record_flag_s", "A");
				where.andEqual("s_factory_s", LLWebUtils.factory());
				List<Map<String, Object>> mapList = findMapByWhere(where);
				// 需要查重的条件
				String listString = judge_lever_s;

				addString.add(listString);
				ruplicateList.add(listString);
				//
				if (mapList.size() != 0) {
					ist = true;
				}
				list.add(shutDownSet);
        	}
        	// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);

			}

			if (addString.size() != ruplicateList.size()) {
				ist = true;
			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				save(list);
			}
		}
        //修改
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		ShutDownSet shutDownSet=(ShutDownSet) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), ShutDownSet.class);
        		// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				shutDownSet.setChanged_time_t(timestamp);
				shutDownSet.setChanged_by_s(WebUtils.getUser().userCode);
				// 轮胎判级
				judge_lever_s=shutDownSet.getJudge_lever_s();
				// atr_key
				atr_key = shutDownSet.getAtr_key();
				// 与数据库数据对查重判断

				rs = (BigDecimal) getSession().createSQLQuery(getSQL("update"))
						.setParameter("judge_lever_s", judge_lever_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				// 需要查重的条件
				String listString = judge_lever_s;

				addString.add(listString);
				ruplicateList.add(listString);
				//
				if (rs.intValue() != 0) {
					ist = true;
				}
				list.add(shutDownSet);
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		ist = true;
        	}
        	// 页面输入与数据库的查重
        	if (ist != false) {
        		mun = -1;
        	} else {
        		update(list);
        	}
		}
		return mun;
	}

}
