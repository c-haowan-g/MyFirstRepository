/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.WorkerLoginRecord;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
/**
 * 操作工登录履历表
 * @author 王超
 * @Date 2020-01-20 09:59:31
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkerLoginRecordServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return WorkerLoginRecord.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    /**
     * 根据创建时间降序排列
     */
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
	 * 查出机台条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchEquipCode() {
		SQLQuery query = createSQLQuery(getSQL("searchEquipCode"));
		System.out.println(getSQL("searchEquipCode").toString());
		return query.list();
	}
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO workerloginrecord) throws Exception {
		int mun = 0;
		boolean ist = false;
		
		if (!ListUtils.isEmpty(workerloginrecord.getDeleted())) {
			List<Map<String, Object>> workerloginrecordslist = workerloginrecord.getDeleted();
			for(Map<String, Object> newitem:workerloginrecordslist){
				WorkerLoginRecord item = (WorkerLoginRecord)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 修改存在状态
				item.setRecord_flag_s("D");
				// 修改创建时间
				Date date = new Date();
				item.setChanged_by_s(WebUtils.getUser().userCode);
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_time_t(timestamp);
				update(item);
			}
		}
		
		if (!ListUtils.isEmpty(workerloginrecord.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> workerloginrecordslist = workerloginrecord.getInserted();
			for(Map<String, Object> newitem:workerloginrecordslist){
				WorkerLoginRecord item = (WorkerLoginRecord)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setRecord_flag_s("A");
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setLogin_type_s("1");
				if (item.getWorker_name_s().toString().equals("")) {
					item.setWorker_name_s(toChangedName(item.getWorker_id_s()).get(0).get("username").toString());
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("equip_code_s", item.getEquip_code_s());
				where.andEqual("atr_key", item.getAtr_key());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);

				if (list.size() > 1) {
					ist = true;
				}
				insertedList.add(item);
			}
			
			if (ist != false) {
				mun = -1;
			} else {
				save(insertedList);
			}

		}

		if (!ListUtils.isEmpty(workerloginrecord.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> workerloginrecordslist = workerloginrecord.getUpdated();
			for(Map<String, Object> newitem:workerloginrecordslist){
				WorkerLoginRecord item = (WorkerLoginRecord)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				if (item.getWorker_name_s().toString().equals("")) {
					item.setWorker_name_s(toChangedName(item.getWorker_id_s()).get(0).get("username").toString());
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("equip_code_s", item.getEquip_code_s());
				where.andEqual("atr_key", item.getAtr_key());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);

				if (list.size() > 1) {
					ist = true;
				}
				insertedList.add(item);
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
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toChangedName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toChangedName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toChangedName").toString());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 查询操作工类型
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toWorkerType(String worker_type_s) {
		SQLQuery query = createSQLQuery(getSQL("toWorkerType"));
		query.setParameter("worker_type_s", worker_type_s);
		System.out.println(getSQL("toWorkerType").toString());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

}
