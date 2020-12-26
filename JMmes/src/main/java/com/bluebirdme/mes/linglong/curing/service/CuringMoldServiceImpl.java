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
import com.bluebirdme.mes.linglong.curing.entity.CuringMold;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * @author peng_liu
 * 
 * @Date 2018年7月20日 上午9:44:14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringMoldServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Class getEntity() {
		// TODO Auto-generated method stub
		return CuringMold.class;
	}

	@Override
	protected Session getSession() {
		// TODO Auto-generated method stub
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		// TODO Auto-generated method stub
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	public Time getDBTime() {
		return getFunction().getDBTime();
	}

	/**
	 * 
	 * @Title: save2
	 * @Description: TODO(增删改)
	 * @return: int 返回类型
	 * @throws Exception
	 * 
	 */
	@RockWellTransactional
	public int save2(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		BigDecimal rs = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CuringMold curingmold = (CuringMold) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i),
						CuringMold.class);
				/* 更新时间 */
				curingmold.setChanged_time_t(new Date());
				curingmold.setRecord_flag_s("D");
				list.add(curingmold);
			}
			update(list);
		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {

			int con = rockWellEntityDTO.getUpdated().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CuringMold curingmold = (CuringMold) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
						CuringMold.class);

				String code = curingmold.getMold_code_s();
				Long atr_key = curingmold.getAtr_key();
				/* 更新时间 */
				curingmold.setChanged_time_t(new Date());
				/* 更新人 */
				curingmold.setChanged_by_s(WebUtils.getUser().userCode);
				// 通过库存条码查询是否有重复数据
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("select_CuringMold1"))
						.setParameter("s_factory_s", LLWebUtils.factory()).setParameter("mold_code_s", code)
						.setParameter("atr_key", atr_key).uniqueResult();
				list.add(curingmold);
			}

			if (rs.intValue() > 0) {
				mun = -1;
			} else {
				update(list);
				mun = 0;
			}
		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CuringMold curingmold = (CuringMold) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i),
						CuringMold.class);
				String code = curingmold.getMold_code_s();
				/* 机构编码：默认8023 荆门 */
				curingmold.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				/* 创建时间 */
				curingmold.setCreated_time_t(new Date());
				/* 创建人 */
				curingmold.setCreated_by_s(WebUtils.getUser().userCode);
				/* 厂区 */
				curingmold.setS_factory_s(com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
				/* 模具条码 */
				String moldCode = curingmold.getMold_code_s();
				// 模具编号
				String moldId = curingmold.getMold_id_s();
				// 模具编号默认与条码相同
				if (moldId.isEmpty()) {
					curingmold.setMold_id_s(moldCode);
				}
				// 通过库存条码查询是否有重复数据
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("select_CuringMold2"))
						.setParameter("s_factory_s", LLWebUtils.factory()).setParameter("mold_code_s", code)
						.uniqueResult();
				list.add(curingmold);
			}

			if (rs.intValue() > 0) {
				mun = -1;
			} else {
				save(list);
			}
		}

		return mun;

	}

	/**
	 * 
	 * @Title: getErpCode
	 * @Description: TODO(洗模类型数据查询)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String getErpCode(String dictcode_s) throws Exception {
		SQLQuery query = getSession().createSQLQuery(getSQL("getErpCode"));
		query.setParameter("dictcode_s", dictcode_s);
		return (String) query.uniqueResult();
	}

	/**
	 * 
	 * @Title: CheckMoldCode
	 * @Description: TODO(通过模具条码验证是否有重复数据)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int CheckMoldCode(String mold_code) throws Exception {
		int mun = 0;
		BigDecimal rs = null;
		// 通过库存条码查询是否有重复数据
		rs = (BigDecimal) getSession().createSQLQuery(getSQL("select_CuringMold2"))
				.setParameter("mold_code_s", mold_code).setParameter("s_factory_s", LLWebUtils.factory())
				.uniqueResult();

		if (rs.intValue() > 0) {
			mun = -1;
		} else {
			mun = 0;
		}
		return mun;
	}

	/**
	 * 
	 * @Title: getMaterialCode
	 * @Description: TODO(模具规格)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	public List<Map<String, Object>> comboxMoldspec() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("comboxMoldspec"));
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 下拉框，花纹
	 * 
	 * @Title: comboxPattern
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	public List<Map<String, Object>> comboxPattern() throws Exception {

		SQLQuery query = createSQLQuery(getSQL("comboxPattern"));
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 界面层级下拉框
	 * 
	 * @return 层级信息
	 * @throws Exception
	 */
	public List<Map<String, Object>> comboxCJ() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("comboxCJ"));
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 
	 * @Title: comboxMoldLocation
	 * @Description: TODO(库存位置)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> comboxMoldLocation() throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		SQLQuery query = createSQLQuery(getSQL("comboxMoldLocation"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 
	 * @Title: getDataBy
	 * @Description: TODO(根据规格查询花纹)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getPattByspec(String thspec_s) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getPattByspec"));
		query.setParameter("thspec_s", thspec_s);
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		return query.list();
	}

	/**
	 * 
	 * @Title: getSpecBypatt
	 * @Description: TODO(根据花纹查规格)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSpecBypatt(String patt) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getSpecBypatt"));
		query.setParameter("patt", patt);
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		return query.list();
	}

	/**
	 * 根据规格花纹，查出层级
	 * 
	 * @param thspec_s
	 *            规格
	 * @param patt
	 *            花纹
	 * @return 层级信息
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCjBySpecandPatt(String thspec_s, String patt) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getCjBySpecandPatt"));
		query.setParameter("patt", patt);
		query.setParameter("thspec_s", thspec_s);
		String s_factory_s = LLWebUtils.factory();
		String[] paraStringsQ = new String[2];
		paraStringsQ[0] = "211001";
		paraStringsQ[1] = "211003";

		String[] paraStringsB = new String[2];
		paraStringsB[0] = "221001";
		paraStringsB[1] = "221002";
		if (s_factory_s.equals("1")) {
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if (s_factory_s.equals("2")) {
			query.setParameterList("matgrp_s", paraStringsB);
		}
		return query.list();
	}

	/**
	 * 
	 * @Title: checkSpec
	 * @Description: TODO(验证规格是否存在)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String checkSpec(String Spec) throws Exception {
		SQLQuery query = getSession().createSQLQuery(getSQL("checkSpec"));
		query.setParameter("materialspec", Spec);
		return (String) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<CuringMold> findDataById(Long id[]) {
		SQLQuery query = createSQLQuery(getSQL("findDataById"));
		query.setParameterList("atr_key", id);
		return query.list();
	}

}
