/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

import com.bluebirdme.core.system.annotations.Comment;


public class JudgeNumberItemAll extends JudgeNumberItem{
    
	//配方号
    private String recipeno_s;

	public String getRecipeno_s() {
		return recipeno_s;
	}

	public void setRecipeno_s(String recipeno_s) {
		this.recipeno_s = recipeno_s;
	}
   
    
}
