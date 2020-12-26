package com.bluebirdme.mes.linglong.util;
/**
 * 周清玉 qingyu_zhou
 * 
 * 2019-08-09
 * 
 */
import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.*;



public class MapTrunPojo {
	
	/**
	     * 实体对象转成Map
	       	周清玉
	     * @param obj 实体对象
	     * @return
	     */
	public static Map<String, Object> entityToMap(Object obj) {
			Map<String, Object> map = new HashMap<>();
            if (obj == null) {
            	return map;
            	}
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            try {
				for (Field field : fields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
				}
			} catch (Exception e) {
			e.printStackTrace();
			}
            return map;
	}
	
	 /**
	     * Map转成实体对象
		 * 周清玉
	     * @param map map实体对象包含属性
	     * @param clazz 实体对象类型
	     * @return
	     */
	public static Object mapToEntity(Map<String, Object> map, Class<?> clazz) {
		return JSON.parseObject(JSON.toJSONString(map), clazz);
	}

	/**
	 * 获取本类以及父类的所有属性
	 * @param object  clazz.newInstance()
	 * 周清玉
	 * @return
	 */
	public static Field[] getAllFields(Object object){
		  Class clazz = object.getClass();
		  List<Field> fieldList = new ArrayList<>();
		  while (clazz != null){
		    fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
		    clazz = clazz.getSuperclass();
		  }
		  Field[] fields = new Field[fieldList.size()];
		  fieldList.toArray(fields);
		  return fields;
		}
	
		/**
		 * 将Object转换为Map
		 * @param object
		 * 周清玉
		 * @return
		 */
		public static Map<String,String> ObjectToMap(Object o){
			Map<String,String> map=new HashMap<String, String>();
			Field[] fields=o.getClass().getDeclaredFields();
			try {
				for (int i=0;i<fields.length;i++) {
						String name=fields[i].getName();
						Field field=o.getClass().getDeclaredField(name);
						field.setAccessible(true);
						if (null!=field){
							map.put(name,field.get(o).toString());
						}
					}
				}catch(Exception e){
					e.getMessage();
				}
				return map;
		}
	
	
	
}
