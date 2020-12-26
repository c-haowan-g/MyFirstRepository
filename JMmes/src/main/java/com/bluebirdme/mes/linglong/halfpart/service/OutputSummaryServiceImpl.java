package com.bluebirdme.mes.linglong.halfpart.service;




import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummaryATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummaryDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_1ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_2ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_3ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_4ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_5ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_6ATO;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

@Service
@Transactional(rollbackFor=Exception.class)
public class OutputSummaryServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return OutputSummary.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(OutputSummaryDTO outputsummary) throws Exception{
        
//        if (!ListUtils.isEmpty(outputsummary.getDeleted())) {
//            delete(outputsummary.getDeleted());
//        }
        if (!ListUtils.isEmpty(outputsummary.getInserted())) {
            save(outputsummary.getInserted());
        }
        if (!ListUtils.isEmpty(outputsummary.getUpdated())) {
            update(outputsummary.getUpdated());
        }
    
    }

	//@SuppressWarnings("unchecked")
	public Map<String, Object> search(Filter filter, Page page, String sumFlag) throws Exception {
		
		filter.set("s_factory_s", LLWebUtils.factory());
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows(filter, page, sumFlag));
		ret.put("total", datagridTotal(filter, page, sumFlag));

		return ret;
	}
    
	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows(Filter filter, Page page, String sumFlag) throws Exception {
		String dataSql = "";
		SQLQuery query = null;
		if("machinecode_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_1_1", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_1ATO.class);
		}
		else if("materialcode_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_1_2", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_2ATO.class);
		}
		else if("outclass_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_1_3", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_3ATO.class);
		}
		else{
			filter.set("s_factory_s", "###");
			dataSql = getSQL("datagrid_rows_1_3", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_3ATO.class);
		}
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		return query.list();
	}
    
	//@SuppressWarnings({ "unchecked" })
	public Long datagridTotal(Filter filter, Page page, String sumFlag) throws Exception {

		String totalSql = "";
		if("machinecode_s".equals(sumFlag)){
			totalSql = getSQL("datagrid_total_1_1", filter.getFilter());
		}
		else if("materialcode_s".equals(sumFlag)){
			totalSql = getSQL("datagrid_total_1_2", filter.getFilter());
		}
		else if("outclass_s".equals(sumFlag)){
			totalSql = getSQL("datagrid_total_1_3", filter.getFilter());
		}
		else{
			filter.set("s_factory_s", "###");
			totalSql = getSQL("datagrid_total_1_3", filter.getFilter());
		}
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
public Map<String, Object> search_1(Filter filter, Page page, String sumFlag) throws Exception {
		
		filter.set("s_factory_s", LLWebUtils.factory());
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows(filter, page, sumFlag));
		ret.put("total", datagridTotal(filter, page, sumFlag));

		return ret;
	}


	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridAllRows(Filter filter, String sumFlag) throws Exception {
		String FACTORY = "s_factory_s";
		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		
		String dataSql = "";
		SQLQuery query = null;
		if("machinecode_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_1", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_1ATO.class);
		}
		else if("materialcode_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_2", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_2ATO.class);
		}
		else if("outclass_s".equals(sumFlag)){
			dataSql = getSQL("datagrid_rows_3", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_3ATO.class);
		}
		else{
			filter.set("s_factory_s", "###");
			dataSql = getSQL("datagrid_rows_3", filter.getFilter());
			query = createSQLQuery(dataSql, OutputSummary_3ATO.class);
		}
		setParameter(query, filter);
		List<Map<String, Object>> list = query.list();
  		List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < list.size(); i++) {
  			newlist.add(TransformUpperCase.transformUpperCase(list.get(i)));
		}
		return (List<K>) newlist;
	}
public Map<String, Object> filter(Filter filter, Page page, List<String> sumFlag) throws Exception {
		
		filter.set("s_factory_s", LLWebUtils.factory());
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", getRows(filter, page, sumFlag));
		ret.put("total", getTotal(filter, page, sumFlag));
		return ret;
	}
@SuppressWarnings({ "unchecked" })
public <K> List<K> datagridRows_1(Filter filter, Page page, String sumFlag) throws Exception {
	String dataSql = "";
	SQLQuery query = null;
	if("machinecode_s".equals(sumFlag)){
		dataSql = getSQL("datagrid_rows_2_1", filter.getFilter());
		query = createSQLQuery(dataSql, OutputSummary_4ATO.class);
	}
	else if("materialcode_s".equals(sumFlag)){
		dataSql = getSQL("datagrid_rows_2_2", filter.getFilter());
		query = createSQLQuery(dataSql, OutputSummary_5ATO.class);
	}
	else if("outclass_s".equals(sumFlag)){
		dataSql = getSQL("datagrid_rows_2_3", filter.getFilter());
		query = createSQLQuery(dataSql, OutputSummary_6ATO.class);
	}
	else{
		filter.set("s_factory_s", "###");
		dataSql = getSQL("datagrid_rows_2_3", filter.getFilter());
		query = createSQLQuery(dataSql, OutputSummary_6ATO.class);
	}
	setParameter(query, filter);
	if (page.getAll() == 0) {
		query.setMaxResults(page.getRows());
		query.setFirstResult((page.getPage() - 1) * page.getRows());
	}
	return query.list();
}

public Long datagridTotal_1(Filter filter, Page page, String sumFlag) throws Exception {

	String totalSql = "";
	if("machinecode_s".equals(sumFlag)){
		totalSql = getSQL("datagrid_total_2_1", filter.getFilter());
	}
	else if("materialcode_s".equals(sumFlag)){
		totalSql = getSQL("datagrid_total_2_2", filter.getFilter());
	}
	else if("outclass_s".equals(sumFlag)){
		totalSql = getSQL("datagrid_total_2_3", filter.getFilter());
	}
	else{
		filter.set("s_factory_s", "###");
		totalSql = getSQL("datagrid_total_2_3", filter.getFilter());
	}
	
	if (page.getTotalRows() == 0L) {
		SQLQuery query = getSession().createSQLQuery(totalSql);
		setParameter(query, filter);
		return ((BigDecimal) query.uniqueResult()).longValue();
	} else {
		return page.getTotalRows();
	}
}

@SuppressWarnings({ "unchecked" })
public <K> List<K> getRows(Filter filter, Page page, List<String> sumFlag) throws Exception {

	if(sumFlag.contains("machinecode_s")){
		filter.set("machinecode_s", "machinecode_s");
	}
	if(sumFlag.contains("materialcode_s")){
		filter.set("materialcode_s", "materialcode_s");
	}
	if(sumFlag.contains("outclass_s")){
		filter.set("outclass_s","outclass_s");
	}
	
	SQLQuery query = createSQLQuery(getSQL("getRows",filter.getFilter()));
	setParameter(query, filter);
	if (page.getAll() == 0) {
		query.setMaxResults(page.getRows());
		query.setFirstResult((page.getPage() - 1) * page.getRows());
	}
	List<Map<String, Object>> list = query.list();
		List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			newlist.add(TransformUpperCase.transformUpperCase(list.get(i)));
	}
	return (List<K>) newlist;
}

public Long getTotal(Filter filter, Page page, List<String> sumFlag) throws Exception {

	if(sumFlag.contains("machinecode_s")){
		filter.set("machinecode_s", "machinecode_s");
	}
	if(sumFlag.contains("materialcode_s")){
		filter.set("materialcode_s","materialcode_s");
	}
	if(sumFlag.contains("outclass_s")){
		filter.set("outclass_s", "outclass_s");
	}
	
	if (page.getTotalRows() == 0L) {
		SQLQuery query = getSession().createSQLQuery(getSQL("getTotal",filter.getFilter()));
		setParameter(query, filter);
		return ((BigDecimal) query.uniqueResult()).longValue();
	} else {
		return page.getTotalRows();
	}
}

@SuppressWarnings({ "unchecked" })
public <K> List<K> getRows1(Filter filter, Page page, List<String> sumFlag) throws Exception {

	if(sumFlag.contains("machinecode_s")){
		filter.set("machinecode_s","machinecode_s");
		filter.set("machinecode_s_s","machinecode_s");
	}
	if(sumFlag.contains("materialcode_s")){
		filter.set("materialcode_s","materialcode_s");
		filter.set("materialcode_s_s","materialcode_s");
	}
	if(sumFlag.contains("outclass_s")){
		filter.set("outclass_s","outclass_s");
		filter.set("outclass_s_s","outclass_s");
	}
	
	SQLQuery query = createSQLQuery(getSQL("getRows",filter.getFilter()),OutputSummaryATO.class);
	setParameter(query, filter);
	if (page.getAll() == 0) {
		query.setMaxResults(page.getRows());
		query.setFirstResult((page.getPage() - 1) * page.getRows());
	}
	query.setParameter("s_factory_s", LLWebUtils.factory());
	query.setParameter("start_time",filter.get("start_time"));
	query.setParameter("end_time",filter.get("end_time"));
	if(sumFlag.contains("machinecode_s")){
		query.setParameter("machinecode_s",filter.get("machinecode_s").toString());
		query.setParameter("machinecode_s_s",filter.get("machinecode_s").toString());
	}
	if(sumFlag.contains("materialcode_s")){
		query.setParameter("materialcode_s",filter.get("materialcode_s").toString());
		query.setParameter("materialcode_s_s",filter.get("materialcode_s").toString());
	}
	if(sumFlag.contains("outclass_s")){
		query.setParameter("outclass_s",filter.get("outclass_s").toString());
		query.setParameter("outclass_s_s",filter.get("outclass_s").toString());
	}
	
	System.out.print(query.toString());
	return query.list();
}
}
