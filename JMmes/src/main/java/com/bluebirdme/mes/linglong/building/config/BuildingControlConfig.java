package com.bluebirdme.mes.linglong.building.config;

/**
 * 成型机控制机台按钮，单机运行webService调用
 * 
 * @author qingyu_zhou
 * 
 */
public class BuildingControlConfig {
	/**
	 * HalfwebService 半钢webService路径
	 */
	public static String HalfwebService = "http://192.168.86.44:10800/winceService?wsdl";
	/**
	 * FullwebService 全钢webService路径
	 */
	// public static String FullwebService =
	// "http://192.168.86.5:11051/winceService?wsdl";
	public static String FullwebService = "http://192.168.86.10:11051/winceService?wsdl";
}
