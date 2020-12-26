/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 质检病象信息表
 * @author 司乔靖
 * @Date 2018-08-06 10:27:44
 */
@ATDefinition("D_BS_Reas")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_Reas")
public class Reas extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=200)
    private String agenc_no_s;
    
    @Comment("归档标价")
    @Column(nullable=false,length=200)
    private String arch_flag_s;
    
    @Comment("密练")
    @Column(nullable=true,length=200)
    private String banburying_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=200)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("病象类-描述（中文）")
    @Column(nullable=true,length=200)
    private String collet_code_desc_cn_s;
    
    @Comment("病象类-描述（英文）")
    @Column(nullable=true,length=200)
    private String collet_code_desc_en_s;
    
    @Comment("病象类-描述（其它）")
    @Column(nullable=true,length=200)
    private String collet_code_desc_other_s;
    
    @Comment("病象类代码")
    @Column(nullable=false,length=200)
    private String collet_code_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=200)
    private String created_by_s;
    
    @Comment("修改时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("硫化")
    @Column(nullable=true,length=200)
    private String curing_s;
    
    @Comment("预警开关：0-开，1-关")
    @Column(nullable=true,length=200)
    private String dw_is_warm_s;
    
    @Comment("停机-预警数量")
    @Column(nullable=true,length=200)
    private String dw_num1_s;
    
    @Comment("反馈-预警数量")
    @Column(nullable=true,length=200)
    private String dw_num2_s;
    
    @Comment("接收部门")
    @Column(nullable=true,length=200)
    private String dw_receive_dept_s;
    
    @Comment("停机-预警附加条件1：1-同规格,同机台,同班次、2-不同机台，同一病象")
    @Column(nullable=true,length=200)
    private String dw_where1_s;
    
    @Comment("反馈-预警附加条件：1-同规格,同机台,同班次、2-不同机台，同一病象")
    @Column(nullable=true,length=200)
    private String dw_where2_s;
    
    @Comment("预警工段（多选）：3-半制品、4-成型、5-硫化")
    @Column(nullable=true,length=200)
    private String dw_workshop_s;
    
    @Comment("前工序")
    @Column(nullable=true,length=200)
    private String frontend_s;
    
    @Comment("处理措施（中文）")
    @Column(nullable=true,length=200)
    private String handle_cn_s;
    
    @Comment("处理措施（英文）")
    @Column(nullable=true,length=200)
    private String handle_en_s;
    
    @Comment("处理措施（其它）")
    @Column(nullable=true,length=200)
    private String handle_other_s;
    
    @Comment("成型")
    @Column(nullable=true,length=200)
    private String molding_s;
    
    @Comment("原材料")
    @Column(nullable=true,length=200)
    private String raw_s;
    
    @Comment("病象描述（中文）")
    @Column(nullable=true,length=200)
    private String reas_cn_s;
    
    @Comment("病象编号")
    @Column(nullable=false,length=80)
    private String reas_code_s;
    
    @Comment("病象描述（英文）")
    @Column(nullable=true,length=200)
    private String reas_en_s;
    
    @Comment("病象组-描述（中文）")
    @Column(nullable=true,length=200)
    private String reas_grp_desc_cn_s;
    
    @Comment("病象组-描述（英文）")
    @Column(nullable=true,length=200)
    private String reas_grp_desc_en_s;
    
    @Comment("病象组-描述（泰语）")
    @Column(nullable=true,length=200)
    private String reas_grp_desc_other_s;
    
    @Comment("病象组编号")
    @Column(nullable=false,length=80)
    private String reas_grp_type_s;
    
    @Comment("病象描述（其它）")
    @Column(nullable=true,length=200)
    private String reas_other_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=200)
    private String record_flag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=200)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=200)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=200)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=200)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=200)
    private String spare5_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=200)
    private String s_factory_s;
    
    @Comment("测温项")
    @Column(nullable=true,length=200)
    private String thermometric_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=200)
    private String tyre_t_s;
    
     
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
        
     
    public String getBanburying_s(){
        return banburying_s;
    }
    
    @XmlElement
    public void setBanburying_s(String banburying_s){
        this.banburying_s=banburying_s;
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
        
     
    public String getCollet_code_desc_cn_s(){
        return collet_code_desc_cn_s;
    }
    
    @XmlElement
    public void setCollet_code_desc_cn_s(String collet_code_desc_cn_s){
        this.collet_code_desc_cn_s=collet_code_desc_cn_s;
    }
        
     
    public String getCollet_code_desc_en_s(){
        return collet_code_desc_en_s;
    }
    
    @XmlElement
    public void setCollet_code_desc_en_s(String collet_code_desc_en_s){
        this.collet_code_desc_en_s=collet_code_desc_en_s;
    }
        
     
    public String getCollet_code_desc_other_s(){
        return collet_code_desc_other_s;
    }
    
    @XmlElement
    public void setCollet_code_desc_other_s(String collet_code_desc_other_s){
        this.collet_code_desc_other_s=collet_code_desc_other_s;
    }
        
     
    public String getCollet_code_s(){
        return collet_code_s;
    }
    
    @XmlElement
    public void setCollet_code_s(String collet_code_s){
        this.collet_code_s=collet_code_s;
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
        
     
    public String getCuring_s(){
        return curing_s;
    }
    
    @XmlElement
    public void setCuring_s(String curing_s){
        this.curing_s=curing_s;
    }
        
     
    public String getDw_is_warm_s(){
        return dw_is_warm_s;
    }
    
    @XmlElement
    public void setDw_is_warm_s(String dw_is_warm_s){
        this.dw_is_warm_s=dw_is_warm_s;
    }
        
     
    public String getDw_num1_s(){
        return dw_num1_s;
    }
    
    @XmlElement
    public void setDw_num1_s(String dw_num1_s){
        this.dw_num1_s=dw_num1_s;
    }
        
     
    public String getDw_num2_s(){
        return dw_num2_s;
    }
    
    @XmlElement
    public void setDw_num2_s(String dw_num2_s){
        this.dw_num2_s=dw_num2_s;
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
        
     
    public String getFrontend_s(){
        return frontend_s;
    }
    
    @XmlElement
    public void setFrontend_s(String frontend_s){
        this.frontend_s=frontend_s;
    }
        
     
    public String getHandle_cn_s(){
        return handle_cn_s;
    }
    
    @XmlElement
    public void setHandle_cn_s(String handle_cn_s){
        this.handle_cn_s=handle_cn_s;
    }
        
     
    public String getHandle_en_s(){
        return handle_en_s;
    }
    
    @XmlElement
    public void setHandle_en_s(String handle_en_s){
        this.handle_en_s=handle_en_s;
    }
        
     
    public String getHandle_other_s(){
        return handle_other_s;
    }
    
    @XmlElement
    public void setHandle_other_s(String handle_other_s){
        this.handle_other_s=handle_other_s;
    }
        
     
    public String getMolding_s(){
        return molding_s;
    }
    
    @XmlElement
    public void setMolding_s(String molding_s){
        this.molding_s=molding_s;
    }
        
     
    public String getRaw_s(){
        return raw_s;
    }
    
    @XmlElement
    public void setRaw_s(String raw_s){
        this.raw_s=raw_s;
    }
        
     
    public String getReas_cn_s(){
        return reas_cn_s;
    }
    
    @XmlElement
    public void setReas_cn_s(String reas_cn_s){
        this.reas_cn_s=reas_cn_s;
    }
        
     
    public String getReas_code_s(){
        return reas_code_s;
    }
    
    @XmlElement
    public void setReas_code_s(String reas_code_s){
        this.reas_code_s=reas_code_s;
    }
        
     
    public String getReas_en_s(){
        return reas_en_s;
    }
    
    @XmlElement
    public void setReas_en_s(String reas_en_s){
        this.reas_en_s=reas_en_s;
    }
        
     
    public String getReas_grp_desc_cn_s(){
        return reas_grp_desc_cn_s;
    }
    
    @XmlElement
    public void setReas_grp_desc_cn_s(String reas_grp_desc_cn_s){
        this.reas_grp_desc_cn_s=reas_grp_desc_cn_s;
    }
        
     
    public String getReas_grp_desc_en_s(){
        return reas_grp_desc_en_s;
    }
    
    @XmlElement
    public void setReas_grp_desc_en_s(String reas_grp_desc_en_s){
        this.reas_grp_desc_en_s=reas_grp_desc_en_s;
    }
        
     
    public String getReas_grp_desc_other_s(){
        return reas_grp_desc_other_s;
    }
    
    @XmlElement
    public void setReas_grp_desc_other_s(String reas_grp_desc_other_s){
        this.reas_grp_desc_other_s=reas_grp_desc_other_s;
    }
        
     
    public String getReas_grp_type_s(){
        return reas_grp_type_s;
    }
    
    @XmlElement
    public void setReas_grp_type_s(String reas_grp_type_s){
        this.reas_grp_type_s=reas_grp_type_s;
    }
        
     
    public String getReas_other_s(){
        return reas_other_s;
    }
    
    @XmlElement
    public void setReas_other_s(String reas_other_s){
        this.reas_other_s=reas_other_s;
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
        
     
    public String getThermometric_s(){
        return thermometric_s;
    }
    
    @XmlElement
    public void setThermometric_s(String thermometric_s){
        this.thermometric_s=thermometric_s;
    }
        
     
    public String getTyre_t_s(){
        return tyre_t_s;
    }
    
    @XmlElement
    public void setTyre_t_s(String tyre_t_s){
        this.tyre_t_s=tyre_t_s;
    }
        
    
    
    
}
