/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.MouldSpec;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import freemarker.template.TemplateException;

/**
 * 机头规格对应关系表
 * 
 * @author lnk
 * @Date 2019-01-14 15:22:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MouldSpecServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MouldSpec.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public List<Map<String, Object>> searchByMaterialConbox(Filter filter)
			throws TemplateException, IOException {
		SQLQuery query = createSQLQuery(getSQL("searchByMaterialConbox"));
		return query.list();
	}


	public List<Map<String, Object>> searchByMaterial(Filter filter)
			throws TemplateException, IOException {
		String a =LLWebUtils.factory();
		if (LLWebUtils.factory().equals(FactoryConstant.BAN_GANG)) {
			SQLQuery query = createSQLQuery(getSQL("materialQuery"));
			if (filter.get("slmaterialcode_s") == null) {
				filter.set("slmaterialcode_s", "");
			}
			if (filter.get("ltgg") == null) {
				filter.set("ltgg", "");
			}
			if (filter.get("oldmatcode_s") == null) {
				filter.set("oldmatcode_s", "");
			}
			if (filter.get("parmname_s") == null) {
				filter.set("parmname_s", "");
			}
			if (filter.get("value_s") == null) {
				filter.set("value_s", "200");
			}
			if (filter.get("value_s2") == null) {
				filter.set("value_s2", "1300");
			}
			System.out.println(filter.get("value_s2").toString());
			query.setParameter("slmaterialcode_s",
					filter.get("slmaterialcode_s").toString());
			query.setParameter("oldmatcode_s", filter.get("oldmatcode_s")
					.toString());
			query.setParameter("parmname_s", filter.get("parmname_s")
					.toString());
			query.setParameter("value_s", filter.get("value_s").toString());
			query.setParameter("value_s2", filter.get("value_s2").toString());
			query.setParameter("ltgg", filter.get("ltgg").toString());
			return query.list();
		} else if (LLWebUtils.factory().equals(FactoryConstant.QUAN_GANG)) {
			SQLQuery query = createSQLQuery(getSQL("materialQueryquangang"));
			if (filter.get("slmaterialcode_s") == null) {
				filter.set("slmaterialcode_s", "");
			}
			if (filter.get("ltgg") == null) {
				filter.set("ltgg", "");
			}
			if (filter.get("oldmatcode_s") == null) {
				filter.set("oldmatcode_s", "");
			}
			if (filter.get("parmname_s") == null) {
				filter.set("parmname_s", "");
			}
			if (filter.get("value_s") == null) {
				filter.set("value_s", "200");
			}
			if (filter.get("value_s2") == null) {
				filter.set("value_s2", "1300");
			}
			
			query.setParameter("slmaterialcode_s",
					filter.get("slmaterialcode_s").toString());
			query.setParameter("oldmatcode_s", filter.get("oldmatcode_s")
					.toString());
			query.setParameter("parmname_s", filter.get("parmname_s")
					.toString());
			query.setParameter("value_s", filter.get("value_s").toString());
			query.setParameter("value_s2", filter.get("value_s2").toString());
			return query.list();
		}else{
			return null;
		}
	}

	public List<Map<String, Object>> searchBycapsule()
			throws TemplateException, IOException {
		SQLQuery query = createSQLQuery(getSQL("capsuleQuery"));
		query.setParameter("factory", LLWebUtils.factory());
		return query.list();
	}

	public List<Map<String, Object>> searchBycapsule2(String capsulel)
			throws TemplateException, IOException {
		SQLQuery query = createSQLQuery(getSQL("capsuleQuery2"));
		query.setParameter("capsulel", capsulel);
		return query.list();
	}

	public List<Map<String, Object>> searchByMaterial2(String capsulel)
			throws TemplateException, IOException {
		SQLQuery query = createSQLQuery(getSQL("materquary"));
		query.setParameter("capsulel", capsulel);
		return query.list();
	}

	@RockWellTransactional
	public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		String capsule_code_s = null;
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List<Map<String, Object>> mouldsspecslist = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:mouldsspecslist){
				MouldSpec item = (MouldSpec)MapTrunPojo.mapToEntity(newitem, getEntity());
        			// 修改存在状态
				item.setRecord_flag_s("D");
				// 修改创建时间
				Date date = new Date();
				item.setChanged_by_s(
						WebUtils.getUser().userCode);
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_time_t(timestamp);
				update(item);
			}
		}
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			
			List<Map<String, Object>> mouldsspecslist = rockWellEntityDTO.getInserted();
			for(Map<String, Object> newitem:mouldsspecslist){
					// 添加创建人
				MouldSpec item = (MouldSpec)MapTrunPojo.mapToEntity(newitem, getEntity());
        		
				item.setCreated_by_s(
						WebUtils.getUser().userCode);
				// 添加时间
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setCreated_time_t(timestamp);
				// 默认参数
				item.setRecord_flag_s("A");
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(
						FactoryConstant.JING_MEN_CODE);
				item.getCapsule_code_s();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("capsule_code_s", capsule_code_s);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("material_code_s", item
						.getMaterial_code_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				addString.add(capsule_code_s	
						+ item.getMaterial_code_s());
				ruplicateList.add(capsule_code_s
						+ item.getMaterial_code_s());

				if (list.size() != 0) {
					ist = true;
				}
				insertedList.add(item);
			}
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
			
			if (ist != false) {
				mun = -1;
			} else {
				save(insertedList);
			}

		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> mouldsspecslist = rockWellEntityDTO.getUpdated();
			for(Map<String, Object> newitem:mouldsspecslist){
				MouldSpec item = (MouldSpec)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_by_s(
						WebUtils.getUser().userCode);
				item.setCreated_time_t(timestamp);
				capsule_code_s = item.getCapsule_code_s();
				// atr_key = mouldstockslist.get(i).getAtr_key();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("capsule_code_s", capsule_code_s);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("material_code_s", item
						.getMaterial_code_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				addString.add(capsule_code_s
						+ item.getMaterial_code_s());
				ruplicateList.add(capsule_code_s
						+ item.getMaterial_code_s());
				if (list.size() != 0) {
					ist = true;
				}
				insertedList.add(newitem);
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
				update(insertedList);
			}
		}
		return mun;

	}
	
	
	/**
	 * 修改导出功能
	 */
	 public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
	        if(filter.getFilter().get("method_name_s")!=null){
	        	ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
	        	filter.set("method_name_s", exportCombox.getDictname(filter.getFilter().get("method_name_s").toString()));
	        }
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

}
