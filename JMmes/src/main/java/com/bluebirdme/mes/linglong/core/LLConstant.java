/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;

/**
 * 
 * @author Goofy
 * @Date 2018年8月2日 上午10:44:29
 */
public interface LLConstant extends FactoryConstant {
	
	/**
	 * 记录状态
	 * @author Goofy
	 * @Date 2018年9月10日 下午6:34:36
	 */
	public final static class Record_Flag{
		/**
		 * 删除
		 */
		public final static String DELETED="D";
		/**
		 * 可用、有效的
		 */
		public final static String AVAILIABLE="A";
	}
	
}
