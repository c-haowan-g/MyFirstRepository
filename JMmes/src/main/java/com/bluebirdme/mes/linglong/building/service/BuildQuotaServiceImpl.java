/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
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

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.BuildQuota;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 成型定额表
 * 
 * @author qingyu_zhou
 * @Date 2019-08-15 09:40:52
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BuildQuotaServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return BuildQuota.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				BuildQuota buildQuota = (BuildQuota) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i),
						BuildQuota.class);
				buildQuota.setRecord_flag_s_s("D");
				list.add(buildQuota);
			}
			update(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				BuildQuota buildQuota = (BuildQuota) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i),
						BuildQuota.class);
				buildQuota.setCreated_by_s(LLWebUtils.getUserName());
				buildQuota.setS_factory_s(LLWebUtils.factory());
				buildQuota.setCreated_time_t(new Date());
				list.add(buildQuota);
			}
			save(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
			for (int i = 0; i < con; i++) {
				BuildQuota buildQuota = (BuildQuota) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
						BuildQuota.class);
				buildQuota.setCreated_by_s(LLWebUtils.getUserName());
				System.out.println(LLWebUtils.getUserName());
				buildQuota.setS_factory_s(LLWebUtils.factory());
				System.out.println(LLWebUtils.factory());
				update(buildQuota);
			}
		}

	}

	/**
	 * 查询报产信息数据
	 */

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> datagrid3() throws Exception {
		SQLQuery query = createSQLQuery(getSQL("datagrid_material_all"));
		List<Map<String, Object>> list = query.list();
		return list;
	}

	public List<Map<String, Object>> searchByMaterial(String materialcode_s) {
		SQLQuery query = getSession().createSQLQuery(getSQL("curingparameterm"));
		query.setParameter("materialcode_s", materialcode_s);
		return query.list();
	}

	/**
	 * 根据成型胎胚编码 查询外胎规格
	 * 
	 * @param materialcode_s
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialByCode(String materialcode_s) {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchmaterialbycode"));
		query.setParameter("materialcode_s", materialcode_s);
		return query.list();
	}

	/**
	 * 查询成型厂商
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchEquipTypeList() {
		SQLQuery query = getSession().createSQLQuery(getSQL("searchequiptypelist"));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRows4(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal4(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRows4(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_row4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_row4的SQL语句定义");

		String dataSql = getSQL("datagrid_row4", filter.getFilter());
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

	public Long datagridTotal4(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total4的SQL语句定义");

		String totalSql = getSQL("datagrid_total4", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
}
