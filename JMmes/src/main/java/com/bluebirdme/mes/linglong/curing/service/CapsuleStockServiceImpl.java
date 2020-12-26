/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CapsuleStock;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * 胶囊库存管理
 * 
 * @author 李迺锟
 * @Date 2018-08-01 17:56:14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CapsuleStockServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CapsuleStock.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 
	 * @Title: saveChanges
	 * @Description: TODO(增删改)
	 * @return: int 返回类型
	 * @throws Exception
	 * 
	 */
	@RockWellTransactional
	public Integer save2(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		// 会话
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		int mun = 0;
		BigDecimal rs = null;

		// 删除,修改记录标志
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
        	List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CapsuleStock capsulestock=(CapsuleStock) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), CapsuleStock.class);
					/* 更新时间 */
				capsulestock.setChanged_time_t(new Date());
				capsulestock.setRecord_flag_s("D");
				list.add(capsulestock);
			}
			update(list);
		}
		// 修改
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
        	List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CapsuleStock capsulestock=(CapsuleStock) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), CapsuleStock.class);
				
				String capsule_id_s = capsulestock.getCapsule_id_s();
				Long atr_key = capsulestock.getAtr_key();

				/* 更新人 */
				capsulestock.setChanged_by_s(WebUtils.getUser().userCode);
				/* 更新时间 */
				capsulestock.setChanged_time_t(new Date());
				/*
				 * // 通过库存条码查询是否有重复数据 rs = (BigDecimal) getSession()
				 * .createSQLQuery(getSQL("select_capsuleStock_1"))
				 * .setParameter("capsule_id_s", capsule_id_s)
				 * .setParameter("atr_key", atr_key).uniqueResult();
				 */
				list.add(capsulestock);
			}

			// if (rs.intValue() > 0) {
			// mun = -1;
			// } else {
			update(list);
			// mun = 0;
			// }
		}
		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
        	List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CapsuleStock capsulestock=(CapsuleStock) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), CapsuleStock.class);
				
				String capsule_id_s = capsulestock.getCapsule_id_s();
				// 通过库存条码查询是否有重复数据
				/*
				 * rs = (BigDecimal) getSession()
				 * .createSQLQuery(getSQL("select_capsuleStock_2"))
				 * .setParameter("capsule_id_s", capsule_id_s) .uniqueResult();
				 */
				/* 机构编码：默认8023 荆门 */
				capsulestock.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				/* 厂区 */
				capsulestock.setS_factory_s(
								com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
				/* 创建人 */
				capsulestock.setCreated_by_s(WebUtils.getUser().userCode);
				/* 入库人 ,同创建人 */
				capsulestock.setUser_id_s(WebUtils.getUser().userCode);
				list.add(capsulestock);
			}

			// if (rs.intValue() > 0) {
			// mun = -1;
			// } else {
			save(list);
			// }
		}
		return mun;
	}

	/**
	 * 
	 * @Title: getMaterialCode
	 * @Description: TODO(物料编码下拉框)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	public List<Map<String, Object>> getMaterialCode() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("comboxMaterialCode"));
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 
	 * @Title: getMaterialCode
	 * @Description: TODO(胶囊规格下拉框)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	public List<Map<String, Object>> getComboxCapsule_spec() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("comboxCapsule_spec"));
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 
	 * @Title: getSpecByFactory
	 * @Description: TODO(根据厂商，查询规格)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String getSpecByFactory(String capsule_factory) throws Exception {
		// 会话
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		SQLQuery query = getSession()
				.createSQLQuery(getSQL("getSpecByFactory"));
		query.setParameter("capsule_factory_s", capsule_factory);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return (String) query.uniqueResult();
	}

	/**
	 * 
	 * @Title: getDataByspec
	 * @Description: TODO(根据规格从胶囊工艺标准表查询校验码、编码)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDataByspec(String spec) throws Exception {
		// 会话
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		SQLQuery query = createSQLQuery(getSQL("getDataByspec"));
		query.setParameter("capsule_spec", spec);
		query.setParameter("s_factory_s",LLWebUtils.factory());
		return (Map<String, Object>) query.uniqueResult();
	}

	/**
	 * 
	 * @Title: countStock
	 * @Description: TODO(统计即时库存)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> countStock() {
		// 会话
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		SQLQuery query = createSQLQuery(getSQL("countStock"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 胶囊库存下拉框
	 * 
	 * @Title: CapsuleLocation
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> CapsuleLocation() throws Exception {
		// 会话
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();

		SQLQuery query = createSQLQuery(getSQL("CapsuleLocation"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}
}
