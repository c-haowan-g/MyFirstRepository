package com.test;

import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		
		//开始时间
		Date fromdate = new Date();
		//结束时间
		Long todate = System.currentTimeMillis() + 254 * 60000;
		//停车时长
		long min = (todate - fromdate.getTime())/60000;
		//整小时
		long z = min/60;
		//余数分钟
		long l = min%60;
		System.out.println("停车时间：" + z + "小时零" + l + "分钟");
		System.out.println("计费标准：每小时10元，大于等于15分钟按一小时计费");
		if (l < 15) {
			System.out.println("停车费用：" + z*10 + "元");
		} else {
			System.out.println("停车费用：" + (z + 1)*10 + "元");
		}
	}
	
//	public static boolean isNullOrEmpty(String str) {
//		if (str == null) {
//			return true;
//		}
//		if (str.isEmpty()) {
//			return true;
//		}
//		return false;
//	}

}
