package com.bluebirdme.mes.linglong.util;

import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author 周清玉 将list集合去重
 * 
 */
public class RemoveDuplicate {

	// 循环list中的所有元素然后删除重复
	public static List removeDuplicate(List list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).equals(list.get(i))) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	// 通过HashSet踢除重复元素
	public static List removeDuplicate2(List list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		return list;
	}
}
