/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import com.datasweep.compatibility.client.ATDefinition;
import com.datasweep.compatibility.client.ATRow;
import com.rockwell.mes.commons.base.ifc.objects.MESATObject;

/**
 * 
 * @author Goofy
 * @Date 2018年8月22日 下午3:09:52
 */
public class BaseRow extends MESATObject {


	@Override
	public String getATDefinitionName() {
		return "Test2";
	}

	@Override
	public ATRow getATRow() {
		return super.getATRow();
	}
	
	

}
