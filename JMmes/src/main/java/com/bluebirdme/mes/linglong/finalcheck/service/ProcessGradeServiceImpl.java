/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.ProcessGradeDTO;

import freemarker.template.TemplateException;

/**
 * 质检工序等级维护表
 * 
 * @author 刘程明
 * @Date 2018-08-16 12:26:07
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProcessGradeServiceImpl extends
RockWellBaseServiceImpl<ProcessGrade> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ProcessGrade.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public void saveChanges(ProcessGradeDTO processgrade) throws Exception {

		if (!ListUtils.isEmpty(processgrade.getDeleted())) {
			delete(processgrade.getDeleted());
		}
		if (!ListUtils.isEmpty(processgrade.getInserted())) {
			String factoryString = LLWebUtils.factory();
			String factoryCodeString = FactoryConstant.JING_MEN_CODE;
			List<ProcessGrade> ProcessGradeList = processgrade.getInserted();
			for (ProcessGrade item : ProcessGradeList) {
				item.setCreated_time_t(new Date());
				item.setCreated_b_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setProess_i(item.getProess_i());
				item.setGradedesc_s(item.getGradedesc_s());
				item.setS_factory_s(factoryString);
				item.setAgenc_no_s(factoryCodeString);
				//item.setSort_i(BigDecimal.valueOf(0));
				item.setSort_i(BigDecimal.valueOf(getReasCodeMaxValue(item.getGradecode_i())));
			}
			save(ProcessGradeList);
		}
		if (!ListUtils.isEmpty(processgrade.getUpdated())) {
			List<ProcessGrade> ProcessGradeList = processgrade.getUpdated();
			for (ProcessGrade item : ProcessGradeList) {
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
			}
			update(ProcessGradeList);
		}

	}
	
	 /**
     * 获取优先级最大值
     * @return 最大值
     * @throws Exception 
     * @throws TemplateException 
     */
    
    @SuppressWarnings("unchecked")
    public int getReasCodeMaxValue(BigDecimal dictcode_s) throws Exception
    {
  	   	Filter filter = new Filter();
  	   	filter.set("dictcode_s", dictcode_s);
    	SQLQuery query=createSQLQuery(getSQL("core_code",filter.getFilter()));
    	query.setParameter("dictcode_s", filter.get("dictcode_s"));
    	List<Map<String, Object>> list=query.list();
        
    	for(Map<String,Object> map :list){
    		for(String key:map.keySet()){
    			int result=  Integer.parseInt(map.get(key).toString());
			   return  result;
			}
    	}
    	return 0;
    }
	

	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	public Map<String, Object> gongxu(Filter filter, Page page, Class clazz)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows3(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal3(filter, page));

		return ret;
	}

	public Long datagridTotal3(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total3") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total3", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows3(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid_rows3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows3", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	public Map<String, Object> dengji(Filter filter, Page page, Class clazz)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows4(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal4(filter, page));

		return ret;
	}

	public Long datagridTotal4(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total4") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total4", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows4(Filter filter, Page page, Class<K> clazz)
			throws Exception {

		if (getSQL("datagrid_rows4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows4", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
				: clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	/*public List<Map<String, Object>> gradessel(String ids) {
		SQLQuery query = getSession().createSQLQuery(getSQL("gradessel"));
		query.setParameter("ids", ids);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}*/

	public List<Map<String, Object>> coresel() {
		SQLQuery query = getSession().createSQLQuery(getSQL("coresel"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	

	
	@SuppressWarnings("unchecked")
	public int delgxdj(String gxid) {
		try {
			RockWellUtils.deleteproess(getEntity(), gxid,"proess_i");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
