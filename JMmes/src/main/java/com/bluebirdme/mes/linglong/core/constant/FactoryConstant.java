/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.constant;

import com.bluebirdme.core.system.constants.SessionConstant;

/**
 * 工厂常量
 * 招远 8000；德州 8002  柳州 8003    泰国8004 荆门8023
 * @author Goofy
 * @Date 2018年8月2日 上午10:49:13
 */
public interface FactoryConstant extends SessionConstant {
	/**
	 * 工厂
	 */
	public static final String FACTORY="factory";
	
	/**
	 * 全部工厂，包括全钢、半钢
	 */
	public static final String FACTORY_ALL="0";
	
	/**
	 * 全钢
	 */
	public static final String QUAN_GANG="1";
	
	/**
	 * 半钢
	 */
	public static final String BAN_GANG="2";
	
	public static final String JING_MEN_CODE="8023";
	
	public static final String JING_MEN_NAME="荆门工厂";
    
	public static final String BUILDING="成型机";
}
