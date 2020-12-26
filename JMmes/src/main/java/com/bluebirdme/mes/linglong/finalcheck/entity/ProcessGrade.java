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

/**
 * 质检工序等级表
 * @author 刘程明
 * @Date 2018-08-16 12:26:07
 */
@ATDefinition("D_BS_ProcessGrade")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_ProcessGrade")
public class ProcessGrade extends RockWellBaseEntity{
	
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=160)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=160)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=160)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=160)
    private String created_b_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=11)
    private Date created_time_t;
    
    @Comment("质量等级编码")
    @Column(nullable=false,length=22)
    private BigDecimal gradecode_i;
    
    @Comment("质量等级描述")
    @Column(nullable=true,length=200)
    private String gradedesc_s;
    
    @Comment("工序描述")
    @Column(nullable=true,length=200)
    private String proessdesc_s;
    
    @Comment("工序")
    @Column(nullable=false,length=22)
    private String proess_i;
    
    @Comment("记录标记，A可用，D删除")
    @Column(nullable=false,length=160)
    private String record_flag_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String remark_s;
    
    @Comment("优先级")
    @Column(nullable=true,length=22)
    private BigDecimal sort_i;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=160)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=160)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=160)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=160)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=160)
    private String spare5_s;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=160)
    private String s_factory_s;
    
   
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
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
        
    public String getCreated_b_s(){
        return created_b_s;
    }
    
    @XmlElement
    public void setCreated_b_s(String created_b_s){
        this.created_b_s=created_b_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public BigDecimal getGradecode_i(){
        return gradecode_i;
    }
    
    @XmlElement
    public void setGradecode_i(BigDecimal gradecode_i){
        this.gradecode_i=gradecode_i;
    }
        
    public String getGradedesc_s(){
        return gradedesc_s;
    }
    
    @XmlElement
    public void setGradedesc_s(String gradedesc_s){
        this.gradedesc_s=gradedesc_s;
    }
        
    public String getProessdesc_s(){
        return proessdesc_s;
    }
    
    @XmlElement
    public void setProessdesc_s(String proessdesc_s){
        this.proessdesc_s=proessdesc_s;
    }
        
    
        
    public String getProess_i() {
		return proess_i;
	}

	public void setProess_i(String proess_i) {
		this.proess_i = proess_i;
	}

	public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
    }
        
    public BigDecimal getSort_i(){
        return sort_i;
    }
    
    @XmlElement
    public void setSort_i(BigDecimal sort_i){
        this.sort_i=sort_i;
    }
        
    public String getSpare1_s(){
        return spare1_s;
    }
    
    @XmlElement
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
    public String getSpare2_s(){
        return spare2_s;
    }
    
    @XmlElement
    public void setSpare2_s(String spare2_s){
        this.spare2_s=spare2_s;
    }
        
    public String getSpare3_s(){
        return spare3_s;
    }
    
    @XmlElement
    public void setSpare3_s(String spare3_s){
        this.spare3_s=spare3_s;
    }
        
    public String getSpare4_s(){
        return spare4_s;
    }
    
    @XmlElement
    public void setSpare4_s(String spare4_s){
        this.spare4_s=spare4_s;
    }
        
    public String getSpare5_s(){
        return spare5_s;
    }
    
    @XmlElement
    public void setSpare5_s(String spare5_s){
        this.spare5_s=spare5_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
  
    
}
