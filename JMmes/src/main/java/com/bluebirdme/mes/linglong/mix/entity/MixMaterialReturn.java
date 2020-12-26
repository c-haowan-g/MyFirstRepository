/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼退料登记表
 * @author 栾和源
 * @Date 2020-08-07 16:31:49
 */
@ATDefinition("MX_MM_POLY_RETURN")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_POLY_RETURN")
public class MixMaterialReturn extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=2)
    private String arch_flag_s;
    
    @Comment("载具条码")
    @Column(nullable=true,length=40)
    private String carrier_code_s;
    
    @Comment("胶案重量")
    @Column(nullable=true,length=0)
    private String carrier_weight_f;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=100)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=100)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=0)
    private Date expiry_date_t;
    
    @Comment("班组：301001-甲班、301002-乙班、301003-丙班")
    @Column(nullable=true,length=80)
    private String group_code_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("是否色标与胶号一样：0-否、1-是")
    @Column(nullable=true,length=20)
    private String is_colorcode_s;
    
    @Comment("是否存在杂物：0-否、1-是")
    @Column(nullable=true,length=20)
    private String is_impurity_s;
    
    @Comment("是否已打印流转卡（扉子）：0-否、1-是")
    @Column(nullable=true,length=20)
    private String is_print_s;
    
    @Comment("是否为机头返回胶：0-否、1-是")
    @Column(nullable=true,length=20)
    private String is_return_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=40)
    private String lot_no_s;
    
    @Comment("主机手")
    @Column(nullable=true,length=80)
    private String master_by_s;
    
    @Comment("主机手姓名")
    @Column(nullable=true,length=200)
    private String master_name_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("备注")
    @Column(nullable=true,length=600)
    private String memo_s;
    
    @Comment("净重")
    @Column(nullable=true,length=0)
    private String net_weight_f;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date prod_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("登记类型：078001-返回胶、078002-退库")
    @Column(nullable=true,length=80)
    private String return_type_s;
    
    @Comment("班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String shift_code_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    @Comment("皮重")
    @Column(nullable=true,length=0)
    private String tare_weight_f;
    
    @Comment("退回工区：077001-密炼、077002-半部件、077003-成型")
    @Column(nullable=true,length=20)
    private String workarea_s;
    
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
        
    public String getCarrier_weight_f(){
        return carrier_weight_f;
    }
    
    @XmlElement
    public void setCarrier_weight_f(String carrier_weight_f){
        this.carrier_weight_f=carrier_weight_f;
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
        
    public Date getExpiry_date_t(){
        return expiry_date_t;
    }
    
    @XmlElement
    public void setExpiry_date_t(Date expiry_date_t){
        this.expiry_date_t=expiry_date_t;
    }
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIs_colorcode_s(){
        return is_colorcode_s;
    }
    
    @XmlElement
    public void setIs_colorcode_s(String is_colorcode_s){
        this.is_colorcode_s=is_colorcode_s;
    }
        
    public String getIs_impurity_s(){
        return is_impurity_s;
    }
    
    @XmlElement
    public void setIs_impurity_s(String is_impurity_s){
        this.is_impurity_s=is_impurity_s;
    }
        
    public String getIs_print_s(){
        return is_print_s;
    }
    
    @XmlElement
    public void setIs_print_s(String is_print_s){
        this.is_print_s=is_print_s;
    }
        
    public String getIs_return_s(){
        return is_return_s;
    }
    
    @XmlElement
    public void setIs_return_s(String is_return_s){
        this.is_return_s=is_return_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
    }
        
    public String getMaster_by_s(){
        return master_by_s;
    }
    
    @XmlElement
    public void setMaster_by_s(String master_by_s){
        this.master_by_s=master_by_s;
    }
        
    public String getMaster_name_s(){
        return master_name_s;
    }
    
    @XmlElement
    public void setMaster_name_s(String master_name_s){
        this.master_name_s=master_name_s;
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
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getNet_weight_f(){
        return net_weight_f;
    }
    
    @XmlElement
    public void setNet_weight_f(String net_weight_f){
        this.net_weight_f=net_weight_f;
    }
        
    public Date getProd_time_t(){
        return prod_time_t;
    }
    
    @XmlElement
    public void setProd_time_t(Date prod_time_t){
        this.prod_time_t=prod_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReturn_type_s(){
        return return_type_s;
    }
    
    @XmlElement
    public void setReturn_type_s(String return_type_s){
        this.return_type_s=return_type_s;
    }
        
    public String getShift_code_s(){
        return shift_code_s;
    }
    
    @XmlElement
    public void setShift_code_s(String shift_code_s){
        this.shift_code_s=shift_code_s;
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
        
    public String getTare_weight_f(){
        return tare_weight_f;
    }
    
    @XmlElement
    public void setTare_weight_f(String tare_weight_f){
        this.tare_weight_f=tare_weight_f;
    }
        
    public String getWorkarea_s(){
        return workarea_s;
    }
    
    @XmlElement
    public void setWorkarea_s(String workarea_s){
        this.workarea_s=workarea_s;
    }
        
    
    
    
}
