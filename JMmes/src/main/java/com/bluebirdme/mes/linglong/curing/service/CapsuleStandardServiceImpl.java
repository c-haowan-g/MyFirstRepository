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

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
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
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 胶囊工艺标准
 * 
 * @author 李迺锟
 * @Date 2018-08-03 14:53:59
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CapsuleStandardServiceImpl extends RockWellUDABaseServiceImpl<Object> {

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

	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 增删改
	 * 
	 * @param capsulestandardDTO
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		// 胶囊编码
		String material_capsulecode_s = null;
		// atr_key
		Long atr_key = null;
		// Sql
		BigDecimal rs1 = null;

		// 页面多行同时添加时的查重判断
		List<String> materialaddString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		List materialaddruplicateList = new ArrayList<>();

		// 删除
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			// set指定的数据
			int con = rockWellEntityDTO.getDeleted().size();
			List list = new ArrayList<>();

			for (int i = 0; i < con; i++) {
				CapsuleStandard capsulestandard = (CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO
						.getDeleted().get(i), CapsuleStandard.class);
				capsulestandard.setRecord_flag_s("D");
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				capsulestandard.setChanged_time_t(timestamp);
				list.add(capsulestandard);
			}
			update(list);
		}
		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			// set指定的数据
			int con = rockWellEntityDTO.getInserted().size();
			List list = new ArrayList<>();

			for (int i = 0; i < con; i++) {
				CapsuleStandard capsulestandard = (CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO
						.getInserted().get(i), CapsuleStandard.class);
				// 创建人
				capsulestandard.setCreated_by_s(WebUtils.getUser().userCode);
				// 修改人
				capsulestandard.setChanged_by_s(WebUtils.getUser().userCode);
				capsulestandard.setRecord_flag_s("A");
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				HttpSession session = request.getSession();

				capsulestandard.setS_factory_s(com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				capsulestandard.setCreated_time_t(timestamp);
				capsulestandard.setChanged_time_t(timestamp);
				// 机构编码
				capsulestandard.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				// 胶囊编码
				material_capsulecode_s = capsulestandard.getMaterial_capsulecode_s();

				Where where1 = new Where();
				where1.andEqual("material_capsulecode_s", material_capsulecode_s);
				where1.andEqual("record_flag_s", "A");
				where1.andEqual("s_factory_s", LLWebUtils.factory());
				List<Map<String, Object>> list1 = findMapByWhere(where1);

				// 需要查重的条件

				String listmaterial_capsulecode_s = material_capsulecode_s;
				materialaddString.add(listmaterial_capsulecode_s);
				materialaddruplicateList.add(listmaterial_capsulecode_s);
				//
				if (list1.size() != 0) {
					ist = true;
				}
				list.add(capsulestandard);

			}

			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (materialaddString.size() != 1) {
				materialaddruplicateList = removeDuplicate.removeDuplicate(materialaddruplicateList);
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
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			// set指定的数据
			int con = rockWellEntityDTO.getUpdated().size();
			List list = new ArrayList<>();

			for (int i = 0; i < con; i++) {
				CapsuleStandard capsulestandard = (CapsuleStandard) MapTrunPojo.mapToEntity(rockWellEntityDTO
						.getUpdated().get(i), CapsuleStandard.class);
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				capsulestandard.setChanged_time_t(timestamp);
				// 修改人
				capsulestandard.setChanged_by_s(WebUtils.getUser().userCode);

				// 胶囊编码
				material_capsulecode_s = capsulestandard.getMaterial_capsulecode_s();
				// atr_key
				atr_key = capsulestandard.getAtr_key();
				// 与数据库数据对查重判断
				rs1 = (BigDecimal) getSession().createSQLQuery(getSQL("update1"))
						.setParameter("material_capsulecode_s", material_capsulecode_s)
						.setParameter("s_factory_s", LLWebUtils.factory()).setParameter("atr_key", atr_key)
						.uniqueResult();

				// 需要查重的条件
				String listmaterial_capsulecode_s = material_capsulecode_s;
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

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterial() {
		SQLQuery query = createSQLQuery(getSQL("materialQuery"));
		// 胶囊组判断：全钢308001，半钢308002\104002
		if (LLWebUtils.factory().equals("1")) {
			String[] str = new String[] {"308001"};
			query.setParameterList("erpcode_s", str);
		} else {
			String[] str = new String[] {"308002","104002"};
			query.setParameterList("erpcode_s", str);
		}
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	/**
	 * 胶囊规格的查询
	 * 
	 * @return
	 */
	public String searchBycapsule(String value) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchBycapsule"));
		query.setParameter("materialCode_S", value);
		return (String) query.uniqueResult();
	}

	/**
	 * 根据胶囊物料编码查询胶囊校验位码
	 * 
	 * @return
	 */
	public String searchCodeByMaterial(String value) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchCodeByMaterial"));
		query.setParameter("materialCode_S", value);
		return (String) query.uniqueResult();
	}

	/**
	 * 供应商的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByVendor() {
		SQLQuery query = createSQLQuery(getSQL("searchByVendor"));
		return query.list();
	}
}
