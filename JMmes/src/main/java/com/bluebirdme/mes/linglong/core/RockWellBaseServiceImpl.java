package com.bluebirdme.mes.linglong.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ArrayUtils;
import org.xdemo.app.xutils.j2se.ReflectUtils;

import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.orm.datasource.DbMeta;
import com.bluebirdme.core.system.orm.sql.Update;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * @author Goofy 252887950@qq.com <a href=http://www.xdemo.org>www.xdemo.org</a>
 * @Date 2017年8月31日 上午8:36:03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public abstract class RockWellBaseServiceImpl<T> extends DbMeta {

	public String idField() {
		return "atr_key";
	}

	public Object idValue(T t) {
		return ((RockWellBaseEntity) t).getAtr_key();
	}
	
	public String msg(String i18nCode){
		return LanguageProvider.getMessage(i18nCode);
	}
	
	public String msg(String i18nCode,Object[] values){
		return LanguageProvider.getMessage(i18nCode,values);
	}

	/**
	 * 保存一个对象
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void save(T t) throws Exception {
		RockWellUtils.save(t);
	}

	/**
	 * 保存一个对象集合
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void save(List<T> list) throws Exception {
		for (T t : list) {
			save(t);
		}
	}

	/**
	 * 更新非空字段
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void updateNotNull(T t) throws Exception {
		RockWellUtils.updateNotNull(t);
	}

	/**
	 * 更新非空字段
	 * 
	 * @param T
	 *            []
	 * @throws Exception
	 */
	@RockWellTransactional
	public void updateNotNull(T[] array) throws Exception {
		RockWellUtils.updateNotNull(ArrayUtils.asList(array));
	}

	/**
	 * 更新非空字段
	 * 
	 * @param List
	 *            <T>
	 * @throws Exception
	 */
	@RockWellTransactional
	public void updateNotNull(List<T> list) throws Exception {
		for (T t : list) {
			updateNotNull(t);
		}
	}

	/**
	 * 更新对象
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(T t) throws Exception {
		RockWellUtils.update(t);
	}

	/**
	 * 更新对象数组
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(T[] array) throws Exception {
		for (T t : array)
			RockWellUtils.update(t);
	}

	/**
	 * 更新对象集合
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(List<T> list) throws Exception {
		for (T t : list)
			update(t);
	}

	/**
	 * 通过ID字段值，更新指定的字段
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(Long id, String field, Object val) throws Exception {
		T t = findById(id);
		ReflectUtils.setFieldValue(t, field, val);
		update(t);
	}
	
	/**
	 * 通过ID字段值，更新指定的字段
	 * 
	 * @param t
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(String ids, String field, Object val) throws Exception {
		T t=null;
		for(String sid:ids.split(",")){
			t = findById(Long.parseLong(sid));
			ReflectUtils.setFieldValue(t, field, val);
			update(t);
		}
	}

	/**
	 * 通过ID去更新多个值
	 * 
	 * @param id
	 * @param values
	 *            key-value
	 * @throws Exception
	 */
	@RockWellTransactional
	public void update(Long id, Map<String, Object> values) throws Exception {
		T t = findById(id);
		for (String k : values.keySet()) {
			ReflectUtils.setFieldValue(t, k, values.get(k));
		}
		update(t);
	}

	/**
	 * 多个ID字符串，逗号分割，批量删除
	 * 
	 * @param ids
	 */
	@RockWellTransactional
	@SuppressWarnings("unchecked")
	public void delete(String ids) {
		RockWellUtils.delete(getEntity(), ids);
	}

	@RockWellTransactional
	public void delete(List<T> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (T t : list) {
			sb.append((i++ == 0 ? "" : ",") + ReflectUtils.getFieldValue(t, idField()));
		}
		delete(sb.toString());
	}

	/**
	 * Long ID数组批量删除
	 * 
	 * @param ids
	 */
	@RockWellTransactional
	public void delete(Long[] ids) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (Long id : ids) {
			sb.append((i++ == 0 ? "" : ",") + id);
		}
		delete(sb.toString());
	}

	/**
	 * 字符串 ID数组批量删除
	 * 
	 * @param ids
	 */
	@RockWellTransactional
	public void delete(String[] ids) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (String id : ids) {
			sb.append((i++ == 0 ? "" : ",") + id);
		}
		delete(sb.toString());
	}

	@RockWellTransactional
	public void update(Map<String, Object> condition, Map<String, Object> values) throws Exception {

		List<T> list = findByMap(condition);

		for (T t : list) {
			for (String k : values.keySet()) {
				ReflectUtils.setFieldValue(t, k, values.get(k));
			}
		}

		update(list);
	}

	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		T t=(T) getSession().createQuery("From " + getEntityName() + " where " + idField() + "=" + id).uniqueResult();
		getSession().evict(t);
		return t;
	}
	
	public void evict(T t){
		if(t!=null)
		getSession().evict(t);
	}
	
	public void evict(List<T> list){
		for(T t:list){
			evict(t);
		}
	}
	
	public T query(Query q){
		@SuppressWarnings("unchecked")
		T t=(T) q.uniqueResult();
		evict(t);
		return t;
	}
	
	public List<T> queryList(Query q){
		@SuppressWarnings("unchecked")
		List<T> list=q.list();
		evict(list);
		return list;
	}

	public List<T> findByWhere(Where where) {
		return queryList(getSession().createQuery("From " + getEntityName() + " where 1=1 " + where.format()));
	}

	public List<T> findByIds(String ids) {
		Long[] idArray = new Long[ids.split(",").length];
		int i = 0;
		for (String id : ids.split(","))
			idArray[i++] = Long.parseLong(id);
		return findByIds(idArray);
	}

	public List<T> findByIds(Long[] ids) {
		return queryList(getSession().createQuery("From " + getEntityName() + " where " + idField() + " in (:ids)").setParameterList("ids", ids));
	}

	public List<T> findByField(String field, Object value) {
		return queryList(getSession().createQuery("From " + getEntityName() + " where " + field + "=:" + field).setParameter(field, value));
	}

	public List<T> findByStart(String field, String value) {
		return queryList(getSession().createQuery("From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, value + "%"));
	}

	public T unique(String field, String value) {
		return query(getSession().createQuery("From " + getEntityName() + " where " + field + "=:" + field).setParameter(field, value));
	}

	public T unique(Map<String, Object> values) {

		StringBuffer sb = new StringBuffer("From " + getEntityName() + " where 1=1");

		for (String k : values.keySet()) {
			sb.append(" and " + k + "=:" + k);
		}

		Query query = getSession().createQuery(sb.toString());

		for (String k : values.keySet()) {
			query.setParameter(k, values.get(k));
		}

		return query(query);
	}

	public T unique(Where where) {

		StringBuffer sb = new StringBuffer("From " + getEntityName() + " where 1=1");

		sb.append(" " + where.format());

		Query query = getSession().createQuery(sb.toString());
		
		return query(query);
	}

	public List<T> findAll() {
		return queryList(getSession().createQuery("From " + getEntityName()));
	}

	public List<T> findByEnd(String field, String value) {
		Query q=getSession().createQuery("From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, "%" + value);
		return queryList(q);
	}

	public List<T> findByLike(String field, String value) {
		Query q=getSession().createQuery("From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, "%" + value + "%");
		return queryList(q);
	}

	public List<T> findByField(String field, Object[] values) {
		Query q=getSession().createQuery("From " + getEntityName() + " where " + field + " in (:" + field + ")").setParameterList(field, values);
		return queryList(q);
	}

	public List<T> findByMap(Map<String, Object> values) {
		StringBuffer sb = new StringBuffer("From " + getEntityName() + " where 1=1");
		for (String k : values.keySet()) {
			sb.append(" and " + k + "=:" + k);
		}
		Query query = getSession().createQuery(sb.toString());
		for (String k : values.keySet()) {
			query.setParameter(k, values.get(k));
		}
		return queryList(query);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> findMapById(Long id) {
		return (Map<String, Object>) getSession().createSQLQuery("select * From " + getEntityName() + " where " + idField() + "=" + id).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByWhere(Where where) {
		return getSession().createSQLQuery("select * From " + getTableName() + " where 1=1 " + where.format()).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List<Map<String, Object>> findMapByIds(String ids) {
		Long[] idArray = new Long[ids.split(",").length];
		return findMapByIds(idArray);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByIds(Long[] ids) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + idField() + " in (:ids)").setParameterList("ids", ids).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByField(String field, String value) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + field + "=:" + field).setParameter(field, value).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByFields(Map<String, Object> values) {
		StringBuffer sb = new StringBuffer("select * From " + getEntityName() + " where 1=1");
		for (String k : values.keySet()) {
			sb.append(" and " + k + "=:" + k);
		}
		Query query = getSession().createSQLQuery(sb.toString());
		for (String k : values.keySet()) {
			query.setParameter(k, values.get(k));
		}
		return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByField(String field, Object[] values) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + field + " in (:" + field + ")").setParameterList(field, values).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByStart(String field, String value) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, value + "%").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByEnd(String field, String value) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, "%" + value).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByLike(String field, String value) {
		return getSession().createSQLQuery("select * From " + getEntityName() + " where " + field + " like :" + field).setParameter(field, "%" + value + "%").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public Map<String, Object> datagrid(Filter filter, Page page, Class clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (clazz == null) {
			clazz = getEntity();
		}

		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}

		/*if (!filter.getFilter().containsKey("agenc_no_s")) {

			if (hasField("agenc_no_s", clazz)) {
				filter.set("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			}
		}

		if (!filter.getFilter().containsKey("record_flag_s")) {

			if (hasField(FACTORY, clazz)) {
				filter.set("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			}
		}*/

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRows(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal(filter, page));

		return ret;
	}
	
	public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {


		if (clazz == null) {
			clazz = getEntity();
		}


		/*if (!filter.getFilter().containsKey("agenc_no_s")) {

			if (hasField("agenc_no_s", clazz)) {
				filter.set("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			}
		}

		if (!filter.getFilter().containsKey("record_flag_s")) {

			if (hasField(FACTORY, clazz)) {
				filter.set("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			}
		}*/

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal(filter, page));

		return ret;
	}
	
	
	public Map<String, Object> datagrid3(Filter filter, Page page, Class<?> clazz) throws Exception {
		Map<String, Object> ret = new HashMap<>();
		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));
		return ret;
	}
	
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {
		if (getSQL("datagrid_rows2") == null) {
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
		}
		String dataSql = getSQL("datagrid_rows2", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, (clazz == null) ? getEntity() : clazz);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
		    query.setFirstResult((page.getPage() - 1) * page.getRows());
		} 
		return query.list();
	}
	
	public Long datagridTotal2(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_total2") == null) {
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
		}
		     
		String totalSql = getSQL("datagrid_total2", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
		    setParameter(query, filter);
		    return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
		} 
		return Long.valueOf(page.getTotalRows());
	}
	

	public Long datagridTotal(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");

		String totalSql = getSQL("datagrid_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows(Filter filter, Page page, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";
		
		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");

		String dataSql = getSQL("datagrid_rows", filter.getFilter());
		
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}

	protected void setParameter(SQLQuery query, Filter filter) {
		filter.getFilter().remove("sort");
		filter.getFilter().remove("order");
		Iterator<Entry<String, String>> it = filter.getFilter().entrySet().iterator();
		Entry<String, String> entry = null;
		while (it.hasNext()) {
			entry = it.next();
			if (entry.getValue().startsWith("in:")) {
				query.setParameterList(entry.getKey(), entry.getValue().substring(3).split(","));
			} else if (entry.getValue().startsWith("contains:")) {
				query.setParameter(entry.getKey(), "%" + entry.getValue().substring(9) + "%");
			} else if (entry.getValue().startsWith("beginWith:")) {
				query.setParameter(entry.getKey(), entry.getValue().substring(10) + "%");
			} else if (entry.getValue().startsWith("endWith:")) {
				query.setParameter(entry.getKey(), "%" + entry.getValue().substring(8));
			} else {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}

	public boolean exist(String key, Object val) {
		String sql = "select count(1) from  " + getTableName() + " where " + key + "=:" + key;

		SQLQuery query = getSession().createSQLQuery(sql);

		query.setParameter(key, val).uniqueResult();

		long count = ((BigDecimal) query.uniqueResult()).longValue();

		return count == 0 ? false : true;
	}

	public boolean exist(String key, Object val, Long id) {
		String sql = "select count(1) from  " + getTableName() + " where " + key + "=:" + key + " and " + idField() + "<>" + id;

		SQLQuery query = getSession().createSQLQuery(sql);

		query.setParameter(key, val).uniqueResult();

		long count = ((BigDecimal) query.uniqueResult()).longValue();
		System.out.println(count);
		return count == 0 ? false : true;
	}

	/**
	 * 创建SQLQuery查询 MAP返回类型
	 * 
	 * @param sql
	 * @return
	 */
	protected SQLQuery createSQLQuery(String sql) {
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query;
	}

	/**
	 * 创建SQLQuery查询,转为实体类
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	protected SQLQuery createSQLQuery(String sql, Class dto) throws Exception {
		SQLQuery query = getSession().createSQLQuery(sql);
		addScalar(query, dto);
		query.setResultTransformer(Transformers.aliasToBean(dto));
		return query;
	}

	void addScalar(SQLQuery query, Class clazz) throws Exception {
		clazz = clazz == null ? getEntity() : clazz;
		query.setResultTransformer(Transformers.aliasToBean(clazz));

		List<Field> fields = ReflectUtils.getFields(clazz, true);

		String type = null;

		for (Field field : fields) {

			type = field.getType().getSimpleName().toUpperCase();

			switch (type) {
			case "BYTE":
				query.addScalar(field.getName(), StandardBasicTypes.BYTE);
				break;
			case "SHORT":
				query.addScalar(field.getName(), StandardBasicTypes.SHORT);
				break;
			case "INTEGER":
				query.addScalar(field.getName(), StandardBasicTypes.INTEGER);
				break;
			case "FLOAT":
				query.addScalar(field.getName(), StandardBasicTypes.FLOAT);
				break;
			case "DOUBLE":
				query.addScalar(field.getName(), StandardBasicTypes.DOUBLE);
				break;
			case "LONG":
				query.addScalar(field.getName(), StandardBasicTypes.LONG);
				break;
			case "BIGDECIMAL":
				query.addScalar(field.getName(), StandardBasicTypes.BIG_DECIMAL);
				break;
			case "CLOB":
			case "STRING":
				query.addScalar(field.getName(), StandardBasicTypes.STRING);
				break;
			case "DATETIME":
			case "DATE":
				query.addScalar(field.getName(), StandardBasicTypes.TIMESTAMP);
				break;
			case "BOOLEAN":
				query.addScalar(field.getName(), StandardBasicTypes.BOOLEAN);
				break;
			default:
				throw new Exception("无法确定的数据类型，请手动实现类型映射");
			}
		}
	}

	/**
	 * 创建Query查询
	 * 
	 * @param sql
	 * @return
	 */
	protected Query createHQLQuery(String hql) {
		return getSession().createQuery(hql);
	}

	/**
	 * 校验某个类是否有某个字段
	 * 
	 * @param field
	 *            字段名称
	 * @param clazz
	 *            Class类
	 * @return boolean
	 */
	public boolean hasField(String field, Class clazz) {
		try {
			
			if (clazz.getDeclaredField(field) != null) {
				return true;
			}
			return false;
		} catch (NoSuchFieldException | SecurityException e) {
			if (clazz.getSuperclass() != Object.class) {
				return hasField(field, clazz.getSuperclass());
			}
			return false;
		}
	}

}
