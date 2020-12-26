package com.bluebirdme.mes.linglong.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.datasweep.compatibility.ui.Time;

/**
 * 
 * @author 周清玉 时间转换util
 * 
 */
public class DateUtil {

	/**
	 * 将String字符串转换为java.util.Date格式日期
	 * 
	 * @param strDate
	 *            表示日期的字符串
	 * @param dateFormat
	 *            传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
	 * @return java.util.Date类型日期对象（如果转换失败则返回null）
	 */
	public static java.util.Date strToUtilDate(String strDate, String dateFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		java.util.Date date = null;
		try {
			date = sf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
	 * 
	 * @param strDate
	 *            表示日期的字符串
	 * @param dateFormat
	 *            传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
	 * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
	 */
	public static java.sql.Timestamp strToSqlDate(String strDate, String dateFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		java.util.Date date = null;
		try {
			date = sf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
		return dateSQL;
	}

	/**
	 * 将java.util.Date对象转化为String字符串
	 * 
	 * @param date
	 *            要格式的java.util.Date对象
	 * @param strFormat
	 *            输出的String字符串格式的限定（如："yyyy-MM-dd HH:mm:ss"）
	 * @return 表示日期的字符串
	 */
	public static String dateToStr(java.util.Date date, String strFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(strFormat);
		String str = sf.format(date);
		return str;
	}

	/**
	 * 将java.sql.Timestamp对象转化为String字符串
	 * 
	 * @param time
	 *            要格式的java.sql.Timestamp对象
	 * @param strFormat
	 *            输出的String字符串格式的限定（如："yyyy-MM-dd HH:mm:ss"）
	 * @return 表示日期的字符串
	 */
	public static String dateToStr(java.sql.Timestamp time, String strFormat) {
		DateFormat df = new SimpleDateFormat(strFormat);
		String str = df.format(time);
		return str;
	}

	/**
	 * 将java.sql.Timestamp对象转化为java.util.Date对象
	 * 
	 * @param time
	 *            要转化的java.sql.Timestamp对象
	 * @return 转化后的java.util.Date对象
	 */
	public static java.util.Date timeToDate(java.sql.Timestamp time) {
		return time;
	}

	/**
	 * 将java.util.Date对象转化为java.sql.Timestamp对象
	 * 
	 * @param date
	 *            要转化的java.util.Date对象
	 * @return 转化后的java.sql.Timestamp对象
	 */
	public static java.sql.Timestamp dateToTime(java.util.Date date) {
		String strDate = dateToStr(date, "yyyy-MM-dd HH:mm:ss");
		return strToSqlDate(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回表示系统当前时间的java.util.Date对象
	 * 
	 * @return 返回表示系统当前时间的java.util.Date对象
	 */
	public static java.util.Date nowDate() {
		return new java.util.Date();
	}

	/**
	 * 返回表示系统当前时间的java.sql.Timestamp对象
	 * 
	 * @return 返回表示系统当前时间的java.sql.Timestamp对象
	 */
	public static java.sql.Timestamp nowTime() {
		return dateToTime(new java.util.Date());
	}

	/**
	 * 格式化时间，date装换time
	 * 
	 * @Title: formatterTime
	 * @Description: TODO(描述)
	 * @return: Time 返回类型
	 * 
	 */
	public Time formatterTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.HOUR_OF_DAY);
		int sec = c.get(Calendar.SECOND);
		Calendar calendar = new GregorianCalendar(year, month, day, hours, min, sec);
		Time time = new Time(calendar);
		return time;
	}
}
