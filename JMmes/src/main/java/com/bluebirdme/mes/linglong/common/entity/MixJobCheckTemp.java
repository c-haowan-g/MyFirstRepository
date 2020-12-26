/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * 密炼作业准备检查模板表
 * @author 陈国强
 * @Date 2020-09-09 14:49:53
 */
@ATDefinition("MX_MM_JOBCHECKTEMP")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_JOBCHECKTEMP")
public class MixJobCheckTemp extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("检查项编码")
    @Column(nullable=true,length=80)
    private String check_itemcode_s;
    
    @Comment("检查项")
    @Column(nullable=true,length=80)
    private String check_item_s;
    
    @Comment("点检标准")
    @Column(nullable=true,length=2)
    private String check_name_s;
    
    @Comment("工序名称： 079001-母炼线上辅机 079002-母炼线密炼机 079003-终练线上辅机 079004-终练线密炼机 079005-小粉料 079006-手工称料 079007-电子秤")
    @Column(nullable=true,length=80)
    private String check_note_s;
    
    @Comment("点检方法： 081001-目视 081002-耳听 081003-耳听、目视 081004-手摸 081005-手摸、目视 081006-标准砝码 081007-数显表 081008-测湿仪 081009-车报表 081010-温度仪 081011-手试拉绳")
    @Column(nullable=true,length=80)
    private String check_rate_s;
    
    @Comment("点检类别： 080001-设备情况：作业前、中、结束 080002-安全环保：作业前、中、结束 080003-计量器具：玛法、实测重量 080004-卫生：作业前、中、结束 080005-工艺")
    @Column(nullable=true,length=80)
    private String check_type_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=100)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("异常处理： 082001-停机检查 082002-随机修理 082003-停车加油 082004-停车整改 082005-重新校验 082006-停机汇报 082007-开启 082008-清理 082009-调整检查 082010-汇报整理 082011-现场整改 082012-紧固 082013-停机整理")
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
        
    public String getCheck_itemcode_s(){
        return check_itemcode_s;
    }
    
    @XmlElement
    public void setCheck_itemcode_s(String check_itemcode_s){
        this.check_itemcode_s=check_itemcode_s;
    }
        
    public String getCheck_item_s(){
        return check_item_s;
    }
    
    @XmlElement
    public void setCheck_item_s(String check_item_s){
        this.check_item_s=check_item_s;
    }
        
    public String getCheck_name_s(){
        return check_name_s;
    }
    
    @XmlElement
    public void setCheck_name_s(String check_name_s){
        this.check_name_s=check_name_s;
    }
        
    public String getCheck_note_s(){
        return check_note_s;
    }
    
    @XmlElement
    public void setCheck_note_s(String check_note_s){
        this.check_note_s=check_note_s;
    }
        
    public String getCheck_rate_s(){
        return check_rate_s;
    }
    
    @XmlElement
    public void setCheck_rate_s(String check_rate_s){
        this.check_rate_s=check_rate_s;
    }
        
    public String getCheck_type_s(){
        return check_type_s;
    }
    
    @XmlElement
    public void setCheck_type_s(String check_type_s){
        this.check_type_s=check_type_s;
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
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
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
