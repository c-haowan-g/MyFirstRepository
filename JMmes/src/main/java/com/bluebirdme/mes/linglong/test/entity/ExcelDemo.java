/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;

/**
 * 
 * @author Goofy
 * @Date 2018年8月7日 下午4:19:54
 */
@Entity
@Table(name="Demo")
public class ExcelDemo extends RockWellBaseEntity {
	
	@Comment("名称")
	private String name;
	@Comment("数量")
	private Integer count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
