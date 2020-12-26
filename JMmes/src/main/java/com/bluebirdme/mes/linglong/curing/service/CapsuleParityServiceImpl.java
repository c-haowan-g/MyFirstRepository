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

import org.hibernate.SQLQuery;
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
import com.bluebirdme.mes.linglong.curing.entity.CapsuleStandard;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

/**
 * 
 * @author 李迺锟
 * 胶囊校验位码维护
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CapsuleParityServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CapsuleStandard.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterial() {
		SQLQuery query = createSQLQuery(getSQL("materialQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}
	/**
	 *胶囊规格的查询
	 * 
	 * @return
	 */
	public String searchBycapsule(String value) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchBycapsule"));
		query.setParameter("materialCode_S", value);
		return (String) query.uniqueResult();
	}
	
	
	@RockWellTransactional
	public Integer saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		//胶囊编码
		String material_capsulecode_s=null;
		//校验码
		String parity_code_s = null;
		// atr_key
		Long atr_key = null;
		// Sql
		BigDecimal rs = null;
		BigDecimal rs1 = null;

		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List<String> materialaddString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		List materialaddruplicateList = new ArrayList<>();

		// 删除
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			// set指定的数据
			int con = rockWellEntityDTO.getDeleted().size();
        	List list = new ArrayList<>();
        	
			for (int i = 0; i < con; i++) {
				CapsuleStandard capsulestandard=(CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), CapsuleStandard.class);
				
				capsulestandard.setRecord_flag_s("D");
				
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				capsulestandard.setChanged_time_t(timestamp);
				list.add(capsulestandard);
			}
			update(list);
		}
		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
					int con = rockWellEntityDTO.getInserted().size();
		        	List list = new ArrayList<>();
        	
					for (int i = 0; i < con; i++) {
						CapsuleStandard capsulestandard=(CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), CapsuleStandard.class);
						
						//创建人
						capsulestandard.setCreated_by_s(WebUtils.getUser().userCode);
						// 修改人
						capsulestandard.setChanged_by_s(WebUtils.getUser().userCode);
						capsulestandard.setRecord_flag_s("A");
						HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
						HttpSession session = request.getSession();

						capsulestandard.setS_factory_s(com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
						// 创建时间的添加
						Date date = new Date();
						Timestamp timestamp = DateUtil.dateToTime(date);
						capsulestandard.setCreated_time_t(timestamp);
						capsulestandard.setChanged_time_t(timestamp);
						// 机构编码
						capsulestandard.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
						//校验码
						parity_code_s = capsulestandard.getParity_code_s();
						//胶囊编码
						material_capsulecode_s = capsulestandard.getMaterial_capsulecode_s();
						// 与数据库数据对查重判断
						Where where = new Where();
						where.andEqual("parity_code_s", parity_code_s);
						where.andEqual("record_flag_s", "A");
						where.andEqual("s_factory_s", LLWebUtils.factory());
						List<Map<String, Object>> list2 = findMapByWhere(where);
						
						Where where1 = new Where();
						where1.andEqual("material_capsulecode_s", material_capsulecode_s);
						where1.andEqual("record_flag_s", "A");
						where1.andEqual("s_factory_s", LLWebUtils.factory());
						List<Map<String, Object>> list1 = findMapByWhere(where1);
						
						// 需要查重的条件
						String listString = parity_code_s;
						addString.add(listString);
						ruplicateList.add(listString);
						
						String listmaterial_capsulecode_s=material_capsulecode_s;
						materialaddString.add(listmaterial_capsulecode_s);
						materialaddruplicateList.add(listmaterial_capsulecode_s);
						//
						if (list2.size() != 0) {
							ist = true;
						}
						//
						if (list1.size() != 0) {
							ist = true;
						}
						
						list.add(capsulestandard);

					}

					// 集合去重
					RemoveDuplicate removeDuplicate = new RemoveDuplicate();
					// 去重之后的集合
					if (addString.size() != 1) {
						ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
					}
					// 去重之后的集合
					if (materialaddString.size() != 1) {
						materialaddruplicateList = removeDuplicate.removeDuplicate(materialaddruplicateList);
					}

					if (addString.size() != ruplicateList.size()) {
						ist = true;
					}
					if (materialaddString.size() != materialaddruplicateList.size()) {
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
			// set指定的数据
			int con = rockWellEntityDTO.getUpdated().size();
        	List list = new ArrayList<>();
	
			for (int i = 0; i < con; i++) {
				CapsuleStandard capsulestandard=(CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), CapsuleStandard.class);
				
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				capsulestandard.setChanged_time_t(timestamp);
				// 修改人
				capsulestandard.setChanged_by_s(WebUtils.getUser().userCode);

				//胶囊编码
				material_capsulecode_s = capsulestandard.getMaterial_capsulecode_s();
				// atr_key
				atr_key = capsulestandard.getAtr_key();
				// 与数据库数据对查重判断
				rs1 = (BigDecimal) getSession().createSQLQuery(getSQL("update1"))
						.setParameter("material_capsulecode_s", material_capsulecode_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				// 需要查重的条件
				String listmaterial_capsulecode_s=material_capsulecode_s;
				materialaddString.add(listmaterial_capsulecode_s);
				materialaddruplicateList.add(listmaterial_capsulecode_s);
				//
				if (rs1.intValue() != 0) {
					ist = true;
				}
				list.add(capsulestandard);

			}

			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (materialaddString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(materialaddruplicateList);
			}

			if (materialaddruplicateList.size() != materialaddString.size()) {
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
