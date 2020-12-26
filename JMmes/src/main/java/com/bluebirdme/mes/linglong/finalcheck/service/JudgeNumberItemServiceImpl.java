/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumber;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberItemDTO;

/**
 * 动平衡均匀机检测配套标准物料表
 * 
 * @author 刘程明
 * @Date 2018-11-13 15:30:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JudgeNumberItemServiceImpl extends RockWellBaseServiceImpl<JudgeNumberItem> {
	@Resource
	JudgeNumberServiceImpl judgeNumSrv;
	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return JudgeNumberItem.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	/**
	 * 通过设备类型、检测标准标号，查询显示规格
	 * 
	 * @Title: getJudgeItems
	 * @Description: TODO(2019-09-21 lp修改)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getJudgeItems(String enttype_s) throws Exception {
		String factoryString = LLWebUtils.factory();
		String agenc_no_sString = FactoryConstant.JING_MEN_CODE;
		SQLQuery query = createSQLQuery(getSQL("getJudgeItems"));
		query.setParameter("s_factory_s", factoryString);
		query.setParameter("agenc_no_s", agenc_no_sString);
		query.setParameter("enttype_s", enttype_s);
		List<Map<String, Object>> list = query.list();
		return list;
	}

	@RockWellTransactional
	public void saveChanges(JudgeNumberItemDTO judgenumberitem) throws Exception {
		String factoryString = LLWebUtils.factory();
		String agenc_no_sString = FactoryConstant.JING_MEN_CODE;
		if (!ListUtils.isEmpty(judgenumberitem.getDeleted())) {
			List<JudgeNumberItem> judgenumberitemList = judgenumberitem.getDeleted();
			for (JudgeNumberItem item : judgenumberitemList) {
				item.setRecord_flag_s("D");
				item.setChanged_by_s(LLWebUtils.getUser().userName);
				item.setChanged_time_t(new Date());
			}
			String judgeNo_s = judgenumberitemList.get(0).getJudgeno_s();
			String entType_s = judgenumberitemList.get(0).getEnttype_s();
			// 获取规格数量，更新judgenumber表里面得规格数
			Where where = new Where();
			where.andEqual("judgeno_s", judgeNo_s);
			where.andEqual("enttype_s", entType_s);
			where.andEqual("s_factory_s", factoryString);
			where.andEqual("agenc_no_s", agenc_no_sString);
			where.andEqual("record_flag_s", "A");
			List<JudgeNumber> judgeRes = judgeNumSrv.findByWhere(where);
			Long judgeNumID = judgeRes.get(0).getAtr_key();
			int itemCount = getJudgeNumByNo(judgeNo_s, entType_s) - judgenumberitemList.size();
			judgeNumSrv.update(judgeNumID, "itemcount_s", String.valueOf(itemCount));
			update(judgenumberitemList);
		}
		if (!ListUtils.isEmpty(judgenumberitem.getInserted())) {
			List<JudgeNumberItem> judgenumberitemList = judgenumberitem.getInserted();
			for (JudgeNumberItem item : judgenumberitemList) {
				item.setS_factory_s(LLWebUtils.factory());
				item.setCreated_by_s(LLWebUtils.getUser().userName);
				item.setCreated_time_t(new Date());
				item.setRecord_flag_s("A");
				item.setArch_flag_s("0");
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
			}
			// 获取规格数量，更新judgenumber表里面得规格数
			String judgeNo_s = judgenumberitemList.get(0).getJudgeno_s();
			String entType_s = judgenumberitemList.get(0).getEnttype_s();
			Where where = new Where();
			where.andEqual("judgeno_s", judgeNo_s);
			where.andEqual("enttype_s", entType_s);
			where.andEqual("s_factory_s", factoryString);
			where.andEqual("agenc_no_s", agenc_no_sString);
			where.andEqual("record_flag_s", "A");
			List<JudgeNumber> judgeRes = judgeNumSrv.findByWhere(where);
			Long judgeNumID = judgeRes.get(0).getAtr_key();
			int itemCount = getJudgeNumByNo(judgeNo_s, entType_s) + judgenumberitemList.size();
			// 更新数量
			judgeNumSrv.update(judgeNumID, "itemcount_s", String.valueOf(itemCount));
			save(judgenumberitemList);
		}
		if (!ListUtils.isEmpty(judgenumberitem.getUpdated())) {
			List<JudgeNumberItem> judgenumberitemList = judgenumberitem.getUpdated();
			for (JudgeNumberItem item : judgenumberitemList) {
				item.setChanged_by_s(LLWebUtils.getUser().userName);
				item.setChanged_time_t(new Date());
			}
			update(judgenumberitemList);
		}

	}

	/**
	 * 获取某规格的数量
	 * 
	 * @param
	 * @return 数量
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private int getJudgeNumByNo(String judgeno_s, String entType_s) throws Exception {
		String factoryString = LLWebUtils.factory();
		String agenc_no_sString = FactoryConstant.JING_MEN_CODE;
		SQLQuery query = getSession().createSQLQuery(getSQL("getJudgeNumByNo"));
		query.setParameter("judgeno_s", judgeno_s);
		query.setParameter("enttype_s", entType_s);
		query.setParameter("s_factory_s", factoryString);
		query.setParameter("agenc_no_s", agenc_no_sString);
		return ((BigDecimal) query.uniqueResult()).intValue();
	}
}
