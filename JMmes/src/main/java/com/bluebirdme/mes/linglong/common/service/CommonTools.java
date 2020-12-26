/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 通用工具
 * @author 刘程明
 * @Date 2018-07-24 16:54:01
 */
public class CommonTools {
	/**
	 * 日期天数的增减
	 * @param originalDate 原始时间‘yyyyMMdd’格式
	 * @param amount 变化天数
	 * @return 日期字符串
	 * @author 刘程明
	 * @throws ParseException 
	 * @date 2019年5月13日
	 */
   public static String dayCalculation(String originalDate,int amount) throws ParseException {
	   Calendar calendar = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Date date = sdf.parse(originalDate);

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, amount);

		return sdf.format(calendar.getTime());
  }
}
