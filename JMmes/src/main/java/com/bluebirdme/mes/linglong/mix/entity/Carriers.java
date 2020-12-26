/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼载具信息表
 * @author 王超
 * @Date 2020-08-03 15:27:50
 */
@ATDefinition("MX_EM_CARRIERS")
@Entity
@XmlRootElement
@Table(name="AT_MX_EM_CARRIERS")
public class Carriers extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("工器具的条码/二维码/RFID芯片等，唯一")
    @Column(nullable=true,length=80)
    private String carrier_code_s;
    
    @Comment("工器具名称")
    @Column(nullable=true,length=200)
    private String carrier_desc_s;
    
    @Comment("载具类型")
    @Column(nullable=true,length=20)
    private String carrier_type_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("自身重量")
    @Column(nullable=true,length=0)
    private String dead_weight_f;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("状态")
    @Column(nullable=true,length=3)
    private String isuse_s;
    
    @Comment("最大装载数量")
    @Column(nullable=true,length=0)
    private Integer load_maxnum_i;
    
    @Comment("载具位置备注")
    @Column(nullable=true,length=80)
    private String location_remark_s;
    
    @Comment("载具位置： 085001-立库 085002-密炼一楼 085003-密炼二楼 085004-密炼三楼 085005-A区 085006-B区")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("反馈备注")
    @Column(nullable=true,length=2000)
    private String return_remark_s;
    
    @Comment("反馈状态：0-无请求、1-未反馈、2-已反馈")
    @Column(nullable=true,length=80)
    private String return_state_s;
    
    @Comment("反馈时间")
    @Column(nullable=true,length=0)
    private Date return_time_t;
    
    @Comment("下发人")
    @Column(nullable=true,length=100)
    private String send_by_s;
    
    @Comment("下发区分：In-入库、Out-出库")
    @Column(nullable=true,length=80)
    private String send_flag_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("RFID读取错误类型： 076001-载具条码现场贴错 076002-载具条码流转错误 076003-其它")
    @Column(nullable=true,length=200)
    private String spare1_s;
    
    @Comment("RFID读取备注")
    @Column(nullable=true,length=200)
    private String spare2_s;
    
    @Comment("RFID流转次数")
    @Column(nullable=true,length=200)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=200)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=200)
    private String spare5_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=5)
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
        
    public String getCarrier_code_s(){
        return carrier_code_s;
    }
    
    @XmlElement
    public void setCarrier_code_s(String carrier_code_s){
        this.carrier_code_s=carrier_code_s;
    }
        
    public String getCarrier_desc_s(){
        return carrier_desc_s;
    }
    
    @XmlElement
    public void setCarrier_desc_s(String carrier_desc_s){
        this.carrier_desc_s=carrier_desc_s;
    }
        
    public String getCarrier_type_s(){
        return carrier_type_s;
    }
    
    @XmlElement
    public void setCarrier_type_s(String carrier_type_s){
        this.carrier_type_s=carrier_type_s;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public String getChanged_name_s(){
        return changed_name_s;
    }
    
    @XmlElement
    public void setChanged_name_s(String changed_name_s){
        this.changed_name_s=changed_name_s;
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
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDead_weight_f(){
        return dead_weight_f;
    }
    
    @XmlElement
    public void setDead_weight_f(String dead_weight_f){
        this.dead_weight_f=dead_weight_f;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIsuse_s(){
        return isuse_s;
    }
    
    @XmlElement
    public void setIsuse_s(String isuse_s){
        this.isuse_s=isuse_s;
    }
        
    public Integer getLoad_maxnum_i(){
        return load_maxnum_i;
    }
    
    @XmlElement
    public void setLoad_maxnum_i(Integer load_maxnum_i){
        this.load_maxnum_i=load_maxnum_i;
    }
        
    public String getLocation_remark_s(){
        return location_remark_s;
    }
    
    @XmlElement
    public void setLocation_remark_s(String location_remark_s){
        this.location_remark_s=location_remark_s;
    }
        
    public String getLocation_s(){
        return location_s;
    }
    
    @XmlElement
    public void setLocation_s(String location_s){
        this.location_s=location_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReturn_remark_s(){
        return return_remark_s;
    }
    
    @XmlElement
    public void setReturn_remark_s(String return_remark_s){
        this.return_remark_s=return_remark_s;
    }
        
    public String getReturn_state_s(){
        return return_state_s;
    }
    
    @XmlElement
    public void setReturn_state_s(String return_state_s){
        this.return_state_s=return_state_s;
    }
        
    public Date getReturn_time_t(){
        return return_time_t;
    }
    
    @XmlElement
    public void setReturn_time_t(Date return_time_t){
        this.return_time_t=return_time_t;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
    }
        
    public String getSend_flag_s(){
        return send_flag_s;
    }
    
    @XmlElement
    public void setSend_flag_s(String send_flag_s){
        this.send_flag_s=send_flag_s;
    }
        
    public String getSend_name_s(){
        return send_name_s;
    }
    
    @XmlElement
    public void setSend_name_s(String send_name_s){
        this.send_name_s=send_name_s;
    }
        
    public String getSend_state_s(){
        return send_state_s;
    }
    
    @XmlElement
    public void setSend_state_s(String send_state_s){
        this.send_state_s=send_state_s;
    }
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
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
