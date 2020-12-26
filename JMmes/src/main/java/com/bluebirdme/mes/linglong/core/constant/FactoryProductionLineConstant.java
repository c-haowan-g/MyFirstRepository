/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.constant;

import com.bluebirdme.core.system.constants.SessionConstant;

/**
 * 产线相关常量设置
 * @author lcm
 *
 */
public interface FactoryProductionLineConstant extends SessionConstant {

    public final static class FactoryCommonConstant{
    	public static final String HALFPART_PROCESS="252004";//半部件
    	public static final String BUILDING_PROCESS="252005";//成型
    	public static final String CURING_PROCESS="252006";//硫化
   	}
    
	public final static class FactoryProductLineConstant{
		
	}
	
    public final static class FactoryEquipmentConstant{
    	public static final String BUILDING="211002";//成型
    	public static final String CURING="211003";//硫化
	}
}
