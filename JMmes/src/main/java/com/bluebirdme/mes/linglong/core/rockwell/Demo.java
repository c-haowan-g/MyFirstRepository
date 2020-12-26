/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import java.util.Date;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;

/**
 * @author Goofy
 * @Date 2018年8月23日 下午1:10:25
 */
@ATDefinition("DEMO")
public class Demo extends RockWellBaseEntity{
	
	private String code_s;
	
	private Date time_t;

	public String getCode_s() {
		return code_s;
	}

	public void setCode_s(String code_s) {
		this.code_s = code_s;
	}

	public Date getTime_t() {
		return time_t;
	}

	public void setTime_t(Date time_t) {
		this.time_t = time_t;
	}

}
