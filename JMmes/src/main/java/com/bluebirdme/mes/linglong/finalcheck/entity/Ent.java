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
 * 质检设备信息表
 * @author 司乔靖
 * @Date 2018-08-10 07:56:16
 */
@ATDefinition("D_EM_Ent")
@Entity
@XmlRootElement
@Table(name="AT_D_EM_Ent")
public class Ent extends RockWellBaseEntity{
    
    
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
    
    @Comment("机台条码")
    @Column(nullable=false,length=80)
    private String entbarcode_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String entname_s;
    
    @Comment("设备类：0-割毛，1-外观，2-X光机、3-动平衡、4-均匀性、5-动均一体、6-入库")
    @Column(nullable=false,length=0)
    private String enttype_i;
    
    @Comment("工作状态：0-正常、1-停用、2-换轮辋、3-检修")
    @Column(nullable=false,length=0)
    private String iswork_i;
    
    @Comment("程序开发逻辑名称")
    @Column(nullable=true,length=80)
    private String logical_address_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("轮辋编号：D_BS_Rim 表 RIMNO")
    @Column(nullable=true,length=0)
    private Integer rimno_i;
    
    @Comment("序号")
    @Column(nullable=false,length=0)
    private Integer sortnum_i;
    
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
    
    @Comment("备用字段5.")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("下发道口号：1-8号分别为，1,2,3,4,5,6,7,8")
    @Column(nullable=true,length=80)
    private String tackno_s;
    
     
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
        
     
    public String getEntbarcode_s(){
        return entbarcode_s;
    }
    
    @XmlElement
    public void setEntbarcode_s(String entbarcode_s){
        this.entbarcode_s=entbarcode_s;
    }
        
     
    public String getEntname_s(){
        return entname_s;
    }
    
    @XmlElement
    public void setEntname_s(String entname_s){
        this.entname_s=entname_s;
    }
        
     
    public String getEnttype_i(){
        return enttype_i;
    }
    
    @XmlElement
    public void setEnttype_i(String enttype_i){
        this.enttype_i=enttype_i;
    }
        
     
    public String getIswork_i(){
        return iswork_i;
    }
    
    @XmlElement
    public void setIswork_i(String iswork_i){
        this.iswork_i=iswork_i;
    }
        
     
    public String getLogical_address_s(){
        return logical_address_s;
    }
    
    @XmlElement
    public void setLogical_address_s(String logical_address_s){
        this.logical_address_s=logical_address_s;
    }
        
     
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
     
    public Integer getRimno_i(){
        return rimno_i;
    }
    
    @XmlElement
    public void setRimno_i(Integer rimno_i){
        this.rimno_i=rimno_i;
    }
        
     
    public Integer getSortnum_i(){
        return sortnum_i;
    }
    
    @XmlElement
    public void setSortnum_i(Integer sortnum_i){
        this.sortnum_i=sortnum_i;
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
        
     
    public String getTackno_s(){
        return tackno_s;
    }
    
    @XmlElement
    public void setTackno_s(String tackno_s){
        this.tackno_s=tackno_s;
    }
        
    
    
    
}
