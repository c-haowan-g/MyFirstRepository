/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.persistence.Table;

import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.ReflectUtils;

import com.bluebirdme.core.system.web.BizException;
import com.datasweep.compatibility.client.ATRow;
import com.datasweep.compatibility.client.ATRowFilter;
import com.datasweep.compatibility.client.Server;
import com.datasweep.compatibility.pnuts.Functions;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.objects.MESATObject;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 
 * @author Goofy
 * @Date 2018年8月22日 下午3:06:26
 */
public class RockWellUtils {

	/**
	 * 将实体类集合转为ATRow集合
	 * 
	 * @param list
	 * @return
	 * @throws BizException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> List<ATRow> toATRow(List<T> list) throws BizException, IllegalArgumentException, IllegalAccessException {

		List<ATRow> rows = new ArrayList<ATRow>();

		if (ListUtils.isEmpty(list)) {
			return rows;
		}

		ATDefinition atd = list.get(0).getClass().getAnnotation(ATDefinition.class);

		if (atd == null) {
			throw new BizException(list.get(0).getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		ATRow row;

		List<Field> fields = ReflectUtils.getFields(list.get(0).getClass(), false);

		// ATRow赋值
		for (T t : list) {
			row = new MESATObject() {
				@Override
				public String getATDefinitionName() {
					return name;
				}
			}.getATRow();

			for (Field field : fields) {
				if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
					continue;
				}
				field.setAccessible(true);
				row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(t));
			}

			rows.add(row);
		}

		return rows;
	}

	/**
	 * 将对象转ATRow
	 * 
	 * @param obj
	 * @return
	 * @throws BizException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> ATRow toATRow(T obj) throws Exception {

		ATDefinition atd = obj.getClass().getAnnotation(ATDefinition.class);

		if (atd == null) {
			throw new Exception(obj.getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		List<Field> fields = ReflectUtils.getFields(obj.getClass(), false);

		// ATRow赋值
		ATRow row = new MESATObject() {
			@Override
			public String getATDefinitionName() {
				return name;
			}
		}.getATRow();

		for (Field field : fields) {
			field.setAccessible(true);
			 if(field.getName().toUpperCase().endsWith("_64"))
			 {
				 row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 3), field.get(obj));
			     continue;
			 }
			if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
				continue;
			}
			row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(obj));
		}

		return row;
	}

	public static Functions getFunctions() {
		return PCContext.getFunctions();
	}

	public static UserTransaction getUserTransaction() {
		return (UserTransaction) PCContext.getFunctions().getUserTransaction(true).getResult();
	}

	public static Server getServer() {
		return PCContext.getServerImpl();
	}

	/**
	 * 保存一个对象
	 * 
	 * @param t
	 * @throws Exception
	 */

	public static <T> void save(T t) throws Exception {
		Time time = getFunctions().getDBTime();
		toATRow(t).save(time, "", null);
	}

	/**
	 * 保存多个对象
	 * 
	 * @param list
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws BizException
	 */

	public static <T> void save(List<T> list) throws IllegalArgumentException, IllegalAccessException, BizException {
		Time time = getFunctions().getDBTime();
		List<ATRow> rows = toATRow(list);
		for (ATRow row : rows) {
			row.save(time, "", null);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param obj
	 * @throws Exception
	 */

	public static <T> void update(T obj) throws Exception {

		ATDefinition atd = obj.getClass().getAnnotation(ATDefinition.class);

		Time time = getFunctions().getDBTime();

		if (atd == null) {
			throw new BizException(obj.getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		if (ReflectUtils.getFieldValue(obj, "atr_key") == null) {
			throw new Exception("主键为空,无法查询");
		}

		ATRowFilter filter = new ATRowFilter(getServer(), name);
		filter.forATRowKeyEqualTo((Long) ReflectUtils.getFieldValue(obj, "atr_key"));

		Functions func = getFunctions();

		Vector<ATRow> rows = func.getFilteredATRows(filter, false);

		List<Field> fields = ReflectUtils.getFields(obj.getClass(), false);

		if (rows != null && rows.size() != 0) {

			ATRow row = rows.get(0);

			for (Field field : fields) {
				 if(field.getName().toUpperCase().endsWith("_64"))
				 {
					 field.setAccessible(true);
					 row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 3), field.get(obj));
				     continue;
				 }
				if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
					continue;
				}
				field.setAccessible(true);
				row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(obj));
			}
			row.save(time, "", null);
		}

	}

	/**
	 * 更新非空数据
	 * 
	 * @param obj
	 * @throws Exception
	 */

	public static <T> void updateNotNull(T obj) throws Exception {

		ATDefinition atd = obj.getClass().getAnnotation(ATDefinition.class);

		Time time = getFunctions().getDBTime();

		if (atd == null) {
			throw new BizException(obj.getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		if (ReflectUtils.getFieldValue(obj, "atr_key") == null) {
			throw new Exception("主键为空,无法查询");
		}

		ATRowFilter filter = new ATRowFilter(getServer(), name);
		filter.forATRowKeyEqualTo((Long) ReflectUtils.getFieldValue(obj, "atr_key"));

		Functions func = getFunctions();

		Vector<ATRow> rows = func.getFilteredATRows(filter, false);

		List<Field> fields = ReflectUtils.getFields(obj.getClass(), false);

		if (rows != null && rows.size() != 0) {

			ATRow row = rows.get(0);

			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
					continue;
				}
				if (field.get(obj) == null) {
					continue;
				}
				row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(obj));
			}
			row.save(time, "", null);
		}

	}

	/**
	 * 更新数据
	 * 
	 * @param list
	 * @throws Exception
	 */

	public static <T> void update(List<T> list) throws Exception {

		ATDefinition atd = list.get(0).getClass().getAnnotation(ATDefinition.class);

		Time time = getFunctions().getDBTime();

		if (atd == null) {
			throw new BizException(list.get(0).getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		ATRowFilter filter = new ATRowFilter(getServer(), name);
		filter.forATRowKeyEqualTo((Long) ReflectUtils.getFieldValue(list.get(0), "atr_key"));

		Functions func = getFunctions();

		Vector<ATRow> rows = func.getFilteredATRows(filter, false);

		List<Field> fields = ReflectUtils.getFields(list.get(0).getClass(), false);

		Map<Long, T> listMap = new HashMap<Long, T>();

		for (T t : list) {
			listMap.put((Long) ReflectUtils.getFieldValue(t, "atr_key"), t);
		}

		if (rows != null && rows.size() != 0) {

			for (ATRow row : rows) {
				for (Field field : fields) {
					if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
						continue;
					}
					field.setAccessible(true);
					row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(listMap.get((Long) row.getValue("atr_key"))));
				}
				row.save(time, "", null);
			}

		}

	}

	/**
	 * 更新数据
	 * 
	 * @param list
	 * @throws Exception
	 */

	public static <T> void updateNotNull(List<T> list) throws Exception {

		ATDefinition atd = list.get(0).getClass().getAnnotation(ATDefinition.class);

		Time time = getFunctions().getDBTime();

		if (atd == null) {
			throw new BizException(list.get(0).getClass().getName() + "上找不到@ATDefinition注解");
		}

		// RockWell 维护的表名
		final String name = atd.value();

		ATRowFilter filter = new ATRowFilter(getServer(), name);
		filter.forATRowKeyEqualTo((Long) ReflectUtils.getFieldValue(list.get(0), "atr_key"));

		Functions func = getFunctions();

		Vector<ATRow> rows = func.getFilteredATRows(filter, false);

		List<Field> fields = ReflectUtils.getFields(list.get(0).getClass(), false);

		Map<Long, T> listMap = new HashMap<Long, T>();

		for (T t : list) {
			listMap.put((Long) ReflectUtils.getFieldValue(t, "atr_key"), t);
		}

		if (rows != null && rows.size() != 0) {

			for (ATRow row : rows) {
				for (Field field : fields) {
					if (field.getName().toUpperCase().endsWith("_U") || field.getName().toUpperCase().endsWith("_Z")) {
						continue;
					}
					field.setAccessible(true);
					if (field.get(listMap.get((Long) row.getValue("atr_key"))) == null) {
						continue;
					}
					row.setValue(field.getName().toUpperCase().substring(0, field.getName().length() - 2), field.get(listMap.get((Long) row.getValue("atr_key"))));
				}
				row.save(time, "", null);
			}
		}
	}

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 */

	public static void execSQL(String... sql) {
		getFunctions().executeStatements(sql);
	}

	/**
	 * 以逗号分隔的ID
	 * 
	 * @param ids
	 */
	public static <T> void delete(Class<T> clazz, String ids) {
		execSQL("delete from " + getTableName(clazz) + " where atr_key in (" + ids + ")");
	}
	
	public static <T> void deleteproess(Class<T> clazz, String ids,String columnname) {
		execSQL("delete from " + getTableName(clazz) + " where "+columnname+"="+ids);
	}

	/**
	 * 获取实体类对应的数据库表名
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> String getTableName(Class<T> clazz) {
		return clazz.getAnnotation(Table.class).name();
	}

	/**
	 * 获取定义的表名
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> String getATDefinition(Class<T> clazz) throws Exception {
		ATDefinition atd = clazz.getAnnotation(ATDefinition.class);
		if (atd == null) {
			throw new Exception(clazz.getName() + "上找不到@ATDefinition注解");
		}
		return atd.value();
	}

}
