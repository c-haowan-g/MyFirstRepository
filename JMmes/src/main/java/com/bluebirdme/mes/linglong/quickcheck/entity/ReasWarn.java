/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.entity;

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
 * 病象预警等级表
 * @author 肖吉朔
 * @Date 2020-08-07 13:21:10
 */
@ATDefinition("D_BS_ReasWarn")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_REASWARN")
public class ReasWarn extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("等级描述")
    @Column(nullable=true,length=80)
    private String dw_grade_desc_s;
    
    @Comment("等级编码 type = 24")
    @Column(nullable=true,length=80)
    private String dw_grade_s;
    
    @Comment("预警开关：0-开，1-关")
    @Column(nullable=true,length=80)
    private String dw_is_warm_s;
    
    @Comment("停机-数量")
    @Column(nullable=false,length=0)
    private Integer dw_num1_i;
    
    @Comment("反馈-预警数量")
    @Column(nullable=false,length=0)
    private Integer dw_num2_i;
    
    @Comment("状态-工序描述")
    @Column(nullable=true,length=80)
    private String dw_proess_desc_s;
    
    @Comment("状态-工序编码 type = 39")
    @Column(nullable=true,length=80)
    private String dw_proess_s;
    
    @Comment("原因组描述")
    @Column(nullable=true,length=80)
    private String dw_reas_grp_desc_s;
    
    @Comment("原因组类型")
    @Column(nullable=true,length=80)
    private String dw_reas_grp_type_s;
    
    @Comment("接收部门")
    @Column(nullable=true,length=80)
    private String dw_receive_dept_s;
    
    @Comment("停机-预警附加条件：1-同规格,同机台,同班次、2-不同机台，同一病象  type = 114 eg 1,2,3")
    @Column(nullable=true,length=80)
    private String dw_where1_s;
    
    @Comment("反馈-预警附加条件：1-同规格,同机台,同班次、2-不同机台，同一病象  type = 114 eg 1,2,3")
    @Column(nullable=true,length=80)
    private String dw_where2_s;
    
    @Comment("预警工段（多选）：1-原材料、2-密炼、3-半制品、4-成型、5-硫化   type = 117 eg 3,4")
    @Column(nullable=true,length=80)
    private String dw_workshop_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
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
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDw_grade_desc_s(){
        return dw_grade_desc_s;
    }
    
    @XmlElement
    public void setDw_grade_desc_s(String dw_grade_desc_s){
        this.dw_grade_desc_s=dw_grade_desc_s;
    }
        
    public String getDw_grade_s(){
        return dw_grade_s;
    }
    
    @XmlElement
    public void setDw_grade_s(String dw_grade_s){
        this.dw_grade_s=dw_grade_s;
    }
        
    public String getDw_is_warm_s(){
        return dw_is_warm_s;
    }
    
    @XmlElement
    public void setDw_is_warm_s(String dw_is_warm_s){
        this.dw_is_warm_s=dw_is_warm_s;
    }
        
    public Integer getDw_num1_i(){
        return dw_num1_i;
    }
    
    @XmlElement
    public void setDw_num1_i(Integer dw_num1_i){
        this.dw_num1_i=dw_num1_i;
    }
        
    public Integer getDw_num2_i(){
        return dw_num2_i;
    }
    
    @XmlElement
    public void setDw_num2_i(Integer dw_num2_i){
        this.dw_num2_i=dw_num2_i;
    }
        
    public String getDw_proess_desc_s(){
        return dw_proess_desc_s;
    }
    
    @XmlElement
    public void setDw_proess_desc_s(String dw_proess_desc_s){
        this.dw_proess_desc_s=dw_proess_desc_s;
    }
        
    public String getDw_proess_s(){
        return dw_proess_s;
    }
    
    @XmlElement
    public void setDw_proess_s(String dw_proess_s){
        this.dw_proess_s=dw_proess_s;
    }
        
    public String getDw_reas_grp_desc_s(){
        return dw_reas_grp_desc_s;
    }
    
    @XmlElement
    public void setDw_reas_grp_desc_s(String dw_reas_grp_desc_s){
        this.dw_reas_grp_desc_s=dw_reas_grp_desc_s;
    }
        
    public String getDw_reas_grp_type_s(){
        return dw_reas_grp_type_s;
    }
    
    @XmlElement
    public void setDw_reas_grp_type_s(String dw_reas_grp_type_s){
        this.dw_reas_grp_type_s=dw_reas_grp_type_s;
    }
        
    public String getDw_receive_dept_s(){
        return dw_receive_dept_s;
    }
    
    @XmlElement
    public void setDw_receive_dept_s(String dw_receive_dept_s){
        this.dw_receive_dept_s=dw_receive_dept_s;
    }
        
    public String getDw_where1_s(){
        return dw_where1_s;
    }
    
    @XmlElement
    public void setDw_where1_s(String dw_where1_s){
        this.dw_where1_s=dw_where1_s;
    }
        
    public String getDw_where2_s(){
        return dw_where2_s;
    }
    
    @XmlElement
    public void setDw_where2_s(String dw_where2_s){
        this.dw_where2_s=dw_where2_s;
    }
        
    public String getDw_workshop_s(){
        return dw_workshop_s;
    }
    
    @XmlElement
    public void setDw_workshop_s(String dw_workshop_s){
        this.dw_workshop_s=dw_workshop_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
