/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.constant;

/**
 * 半部件建 2019/04/18 维护内容：工序、
 * 
 * @author兰颖慧
 * 
 */
public interface HalfPartCommon {

	public final static class Process {
		/**
		 * 工序 2019/04/18
		 * 
		 * @author兰颖慧
		 */
		public final static String Mix = "252003"; // 密炼
		public final static String HalfPart = "252004"; // 半部件
		public final static String Building = "252005"; // 成型
		public final static String Curing = "252006"; // 硫化
		public final static String CutHairs = "252007"; // 割毛
		public final static String Appearance = "252008"; // 外观
		public final static String XRay = "252009"; // X光
		public final static String DynamicBalance = "252010"; // 动平衡
		public final static String Uniformity = "252011"; // 均匀性
	}

	public final static class Factory {
		/**
		 * 全钢和半钢 2019/04/18
		 * 
		 * @author兰颖慧
		 */
		public final static String FullSteel = "1"; // 全钢
		public final static String HalfSteel = "2"; // 半钢
	}

	public final static class Area {
		/**
		 * area 2019/04/18
		 * 
		 * @author兰颖慧
		 */
		public final static String FullSteelHalfPartArea = "80231A"; // 全钢
		public final static String HalfSteelHalfPartArea = "80232A"; // 半钢
		public final static String FullSteelBuildingArea = "80231B"; // 全钢
		public final static String HalfSteelBuildingArea = "80232B"; // 半钢
		public final static String HalfSteelCuringArea = "80232C"; // 半钢
		public final static String FullSteelCuringArea = "80231C"; // 全钢
		public final static String FullSteelMixArea = "80231MX"; // 全钢
		public final static String HalfSteelMixArea = "80232MX"; // 半钢

	}

	public final static class Tip {
		/**
		 * Tip 2019/04/18
		 * 
		 * @author兰颖慧
		 */
		public final static String DELETEZONE = "删除了库区"; // 删除库区
	}

	public final static class MaretialGroup {
		/**
		 * MaretialGroup 2019/04/18
		 * 
		 * @author兰颖慧
		 */
		public final static String FullSteelHalfPartMaterialGroup = "301%"; // 全钢半部件
		public final static String HalfSteelHalfPartMaterialGroup = "302%"; // 半钢半部件
	}

	public final static class StatusDescrip {
		/**
		 * statusDescrip 使用状态 2019/04/29
		 * 
		 * @author兰颖慧
		 */

		public final static String used = "已使用";
		public final static String free = "未使用";
	}

	public final static class Auto {
		/**
		 * statusDescrip 是否自动 2019/04/29
		 * 
		 * @author兰颖慧
		 */
		public final static String positive = "是";
		public final static String negative = "否";
	}
}
