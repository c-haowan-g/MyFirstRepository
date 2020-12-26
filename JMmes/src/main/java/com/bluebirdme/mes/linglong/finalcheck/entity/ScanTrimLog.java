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
 *割毛产量查询表
 * @author 马健斌
 * @Date 2018-08-04 18:14:57
 */
@ATDefinition("D_QM_ScanTrimLog")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_ScanTrimLog")
public class ScanTrimLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标价")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MES_MainTyre 表 BARCODE")
    @Column(nullable=false,length=80)
    private String barcode_s;
    
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
    
    @Comment("MES_ZJ_Ent 表 ID")
    @Column(nullable=false,length=0)
    private Integer entid_i;
    
    @Comment("班组编号")
    @Column(nullable=true,length=80)
    private String groupcode_s;
    
    @Comment("分配索引号(!~1000)")
    @Column(nullable=false,length=0)
    private Integer index_i;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("轮胎状态编码")
    @Column(nullable=false,length=80)
    private String itemstate_s;
    
    @Comment("检测X光机台条码")
    @Column(nullable=true,length=80)
    private String machinebar_s;
    
    @Comment("当前工序")
    @Column(nullable=false,length=80)
    private String proess_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("班次编号")
    @Column(nullable=true,length=80)
    private String shiftcode_s;
    
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
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=80)
    private String tyretypecode_s;
    
    @Comment("外胎重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
     
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
        
     
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
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
        
     
    public Integer getEntid_i(){
        return entid_i;
    }
    
    @XmlElement
    public void setEntid_i(Integer entid_i){
        this.entid_i=entid_i;
    }
        
     
    public String getGroupcode_s(){
        return groupcode_s;
    }
    
    @XmlElement
    public void setGroupcode_s(String groupcode_s){
        this.groupcode_s=groupcode_s;
    }
        
     
    public Integer getIndex_i(){
        return index_i;
    }
    
    @XmlElement
    public void setIndex_i(Integer index_i){
        this.index_i=index_i;
    }
        
     
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
     
    public String getItemstate_s(){
        return itemstate_s;
    }
    
    @XmlElement
    public void setItemstate_s(String itemstate_s){
        this.itemstate_s=itemstate_s;
    }
        
     
    public String getMachinebar_s(){
        return machinebar_s;
    }
    
    @XmlElement
    public void setMachinebar_s(String machinebar_s){
        this.machinebar_s=machinebar_s;
    }
        
     
    public String getProess_s(){
        return proess_s;
    }
    
    @XmlElement
    public void setProess_s(String proess_s){
        this.proess_s=proess_s;
    }
        
     
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
     
    public String getShiftcode_s(){
        return shiftcode_s;
    }
    
    @XmlElement
    public void setShiftcode_s(String shiftcode_s){
        this.shiftcode_s=shiftcode_s;
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
        
     
    public String getTyretypecode_s(){
        return tyretypecode_s;
    }
    
    @XmlElement
    public void setTyretypecode_s(String tyretypecode_s){
        this.tyretypecode_s=tyretypecode_s;
    }
        
     
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    
    
    
}
