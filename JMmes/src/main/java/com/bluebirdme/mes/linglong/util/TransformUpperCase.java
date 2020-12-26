package com.bluebirdme.mes.linglong.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author 周清玉 大写转小写
 */
public class TransformUpperCase {
	// 大写转小写
	public static Map<String, Object> transformUpperCase(
			Map<String, Object> orgMap) {
		Map<String, Object> resultMap = new HashMap<>();

		if (orgMap == null || orgMap.isEmpty()) {
			return resultMap;
		}

		Set<String> keySet = orgMap.keySet();
		for (String key : keySet) {
			String newKey = key.toLowerCase();
			// newKey = newKey.replace("_", "");

			resultMap.put(newKey, orgMap.get(key));
		}

		return resultMap;
	}
}
