/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 年周号管控物料
 * @author 周清玉
 * @Date 2018-09-08 15:47:33
 */
@ATDefinition("C_MM_DOTControl")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_DOTCONTROL")
public class DotControl extends RockWellBaseEntity{
    
    
    @Comment("修改人")
    @Column(nullable=true,length=160)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=160)
    private String dummy1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=160)
    private String dummy2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=160)
    private String dummy3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=160)
    private String dummy4_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=160)
    private String material_code_s;
    
    @Comment("是否有效")
    @Column(nullable=true,length=160)
    private String isvlid_s;
    


	public String getIsvlid_s() {
		return isvlid_s;
	}

	public void setIsvlid_s(String isvlid_s) {
		this.isvlid_s = isvlid_s;
	}

	@Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=160)
    private String record_flag_s;
    
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    @XmlElement
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    
    
    
}
