/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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

/**
 * UNIT序列号帮助
 * @author 时永良
 * @Date 2019-07-12 13:12:11
 */
@ATDefinition("AT_SERIALNUMBERHELP")
@Entity
@XmlRootElement
@Table(name="AT_AT_SERIALNUMBERHELP")
public class SerialNumberHelp extends RockWellBaseEntity{
    
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changeby_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String createby_s;
    
    @Comment("描述")
    @Column(nullable=true,length=80)
    private String description_s;
    
    @Comment("工厂标记")
    @Column(nullable=true,length=80)
    private String factoryflag_s;
    
    @Comment("标记")
    @Column(nullable=true,length=80)
    private String flag_s;
    
    @Comment("计数")
    @Column(nullable=true,length=0)
    private Integer serialnumber_i;
    
    public String getChangeby_s(){
        return changeby_s;
    }
    
    @XmlElement
    public void setChangeby_s(String changeby_s){
        this.changeby_s=changeby_s;
    }
        
    public String getCreateby_s() {
		return createby_s;
	}
    @XmlElement
	public void setCreateby_s(String createby_s) {
		this.createby_s = createby_s;
	}

	public String getDescription_s() {
		return description_s;
	}
    @XmlElement
	public void setDescription_s(String description_s) {
		this.description_s = description_s;
	}

	public String getFactoryflag_s(){
        return factoryflag_s;
    }
    
    @XmlElement
    public void setFactoryflag_s(String factoryflag_s){
        this.factoryflag_s=factoryflag_s;
    }
        
    public String getFlag_s(){
        return flag_s;
    }
    
    @XmlElement
    public void setFlag_s(String flag_s){
        this.flag_s=flag_s;
    }

	public Integer getSerialnumber_i() {
		return serialnumber_i;
	}
	@XmlElement
	public void setSerialnumber_i(Integer serialnumber_i) {
		this.serialnumber_i = serialnumber_i;
	}
}
