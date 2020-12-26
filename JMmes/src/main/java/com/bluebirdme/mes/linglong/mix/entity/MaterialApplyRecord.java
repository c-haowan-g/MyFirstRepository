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
 * 密炼领料申请明细
 * @author 王超
 * @Date 2020-08-07 09:11:19
 */
@ATDefinition("MX_PP_MATERIALAPPLY_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_MX_PP_MATERIALAPPLY_RECORD")
public class MaterialApplyRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("领料申请单号：固定字符+工厂+生产日期+班次+四位流水号 例如 YL92019070110001")
    @Column(nullable=true,length=80)
    private String apply_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("用料生产物料编码")
    @Column(nullable=true,length=200)
    private String child_material_code_s;
    
    @Comment("用料生产物料名称")
    @Column(nullable=true,length=200)
    private String child_material_name_s;
    
    @Comment("创建人：发料人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名：发料人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间：发料时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("接收批次")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("接收物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("接收物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("接收数量")
    @Column(nullable=true,length=80)
    private String qty_s;
    
    @Comment("接收单号：领料申请单号+四位流水号 例如：YL920190701100010001")
    @Column(nullable=true,length=80)
    private String receive_no_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
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
    
    @Comment("供应商编号：有两个以上的供应商，则用|分割开供应商代码，如100156|100360|100097 ")
    @Column(nullable=true,length=2000)
    private String supplier_code1_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("接收单位")
    @Column(nullable=true,length=40)
    private String unit_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getApply_no_s(){
        return apply_no_s;
    }
    
    @XmlElement
    public void setApply_no_s(String apply_no_s){
        this.apply_no_s=apply_no_s;
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
        
    public String getChild_material_code_s(){
        return child_material_code_s;
    }
    
    @XmlElement
    public void setChild_material_code_s(String child_material_code_s){
        this.child_material_code_s=child_material_code_s;
    }
        
    public String getChild_material_name_s(){
        return child_material_name_s;
    }
    
    @XmlElement
    public void setChild_material_name_s(String child_material_name_s){
        this.child_material_name_s=child_material_name_s;
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
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getQty_s(){
        return qty_s;
    }
    
    @XmlElement
    public void setQty_s(String qty_s){
        this.qty_s=qty_s;
    }
        
    public String getReceive_no_s(){
        return receive_no_s;
    }
    
    @XmlElement
    public void setReceive_no_s(String receive_no_s){
        this.receive_no_s=receive_no_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
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
        
    public String getSupplier_code1_s(){
        return supplier_code1_s;
    }
    
    @XmlElement
    public void setSupplier_code1_s(String supplier_code1_s){
        this.supplier_code1_s=supplier_code1_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getUnit_s(){
        return unit_s;
    }
    
    @XmlElement
    public void setUnit_s(String unit_s){
        this.unit_s=unit_s;
    }
        
    
    
    
}
