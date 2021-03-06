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
 * 判定标准维护
 * @author 刘程明
 * @Date 2018-08-01 13:48:20
 */
@ATDefinition("D_BS_Judge")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_Judge")
public class Judge extends RockWellBaseEntity{
    
    
    @Comment("设备类：0-割毛，1-外观，2-X光机、3-动平衡、4-均匀性、5-动均一体、6-入库")
    @Column(nullable=false,length=0)
    private Integer enttype_i;
    
    @Comment("配套方式：0-配套、1-零售")
    @Column(nullable=false,length=0)
    private Integer judgetype_i;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("花纹")
    @Column(nullable=true,length=80)
    private String flowershape_s;
    
    @Comment("版本")
    @Column(nullable=false,length=80)
    private String ver_id_s;
    
    @Comment("状态：0-新建、1-审核、2-正式")
    @Column(nullable=false,length=80)
    private String ver_state_s;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2.")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5.")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("归档标记")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
     
    public Integer getEnttype_i(){
        return enttype_i;
    }
    
    @XmlElement
    public void setEnttype_i(Integer enttype_i){
        this.enttype_i=enttype_i;
    }
        
     
    public Integer getJudgetype_i(){
        return judgetype_i;
    }
    
    @XmlElement
    public void setJudgetype_i(Integer judgetype_i){
        this.judgetype_i=judgetype_i;
    }
        
     
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
     
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
     
    public String getFlowershape_s(){
        return flowershape_s;
    }
    
    @XmlElement
    public void setFlowershape_s(String flowershape_s){
        this.flowershape_s=flowershape_s;
    }
        
     
    public String getVer_id_s(){
        return ver_id_s;
    }
    
    @XmlElement
    public void setVer_id_s(String ver_id_s){
        this.ver_id_s=ver_id_s;
    }
        
     
    public String getVer_state_s(){
        return ver_state_s;
    }
    
    @XmlElement
    public void setVer_state_s(String ver_state_s){
        this.ver_state_s=ver_state_s;
    }
        
     
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
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
        
     
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
     
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
     
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    
    
    
}
