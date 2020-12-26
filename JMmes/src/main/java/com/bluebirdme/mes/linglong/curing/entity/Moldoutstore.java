/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 模具出库记录
 * @author whl
 * @Date 2018-10-03 15:16:26
 */
@ATDefinition("C_WH_MOLDOUTSTORE")
@Entity
@XmlRootElement
@Table(name="AT_C_WH_MOLDOUTSTORE")
public class Moldoutstore extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("块")
    @Column(nullable=true,length=80)
    private String block_s;
    
    @Comment("板")
    @Column(nullable=true,length=80)
    private String board_s;
    
    @Comment("电缆")
    @Column(nullable=true,length=80)
    private String cable_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("模具出库班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("模具花纹")
    @Column(nullable=true,length=100)
    private String flower_pattern_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String memo_s;
    
    @Comment("模具的条码/二维码/RFID芯片等，唯一")
    @Column(nullable=false,length=80)
    private String mold_bar_s;
    
    @Comment("模具编号")
    @Column(nullable=false,length=80)
    private String mold_code_s;
    
    @Comment("模具名称")
    @Column(nullable=true,length=200)
    private String mold_desc_s;
    
    @Comment("模具规格")
    @Column(nullable=true,length=200)
    private String mold_spec_s;
    
    @Comment("模具状态")
    @Column(nullable=true,length=80)
    private String mold_status_s;
    
    @Comment("出库流水")
    @Column(nullable=true,length=80)
    private String outstore_record_id_s;
    
    @Comment("模具出库时间")
    @Column(nullable=true,length=80)
    private String outstore_time_s;
    
    @Comment("模具出库人")
    @Column(nullable=true,length=80)
    private String outstore_worker_s;
    
    @Comment("层级")
    @Column(nullable=true,length=80)
    private String ply_s;
    
    @Comment("生产日期")
    @Column(nullable=true,length=8)
    private String product_date_s;
    
    @Comment("出库目的")
    @Column(nullable=true,length=80)
    private String purpose_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("模具出库班组")
    @Column(nullable=true,length=80)
    private String shift_id_s;
    
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
    
    @Comment("储位地址")
    @Column(nullable=true,length=80)
    private String storeplace_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("商标")
    @Column(nullable=true,length=80)
    private String trad_remark_s;
    
    @Comment("托盘条码")
    @Column(nullable=true,length=80)
    private String tray_code_s;
    
    @Comment("风型")
    @Column(nullable=true,length=80)
    private String wind_type_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBlock_s(){
        return block_s;
    }
    
    @XmlElement
    public void setBlock_s(String block_s){
        this.block_s=block_s;
    }
        
    public String getBoard_s(){
        return board_s;
    }
    
    @XmlElement
    public void setBoard_s(String board_s){
        this.board_s=board_s;
    }
        
    public String getCable_s(){
        return cable_s;
    }
    
    @XmlElement
    public void setCable_s(String cable_s){
        this.cable_s=cable_s;
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
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
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
        
    public String getFlower_pattern_s(){
        return flower_pattern_s;
    }
    
    @XmlElement
    public void setFlower_pattern_s(String flower_pattern_s){
        this.flower_pattern_s=flower_pattern_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMold_bar_s(){
        return mold_bar_s;
    }
    
    @XmlElement
    public void setMold_bar_s(String mold_bar_s){
        this.mold_bar_s=mold_bar_s;
    }
        
    public String getMold_code_s(){
        return mold_code_s;
    }
    
    @XmlElement
    public void setMold_code_s(String mold_code_s){
        this.mold_code_s=mold_code_s;
    }
        
    public String getMold_desc_s(){
        return mold_desc_s;
    }
    
    @XmlElement
    public void setMold_desc_s(String mold_desc_s){
        this.mold_desc_s=mold_desc_s;
    }
        
    public String getMold_spec_s(){
        return mold_spec_s;
    }
    
    @XmlElement
    public void setMold_spec_s(String mold_spec_s){
        this.mold_spec_s=mold_spec_s;
    }
        
    public String getMold_status_s(){
        return mold_status_s;
    }
    
    @XmlElement
    public void setMold_status_s(String mold_status_s){
        this.mold_status_s=mold_status_s;
    }
        
    public String getOutstore_record_id_s(){
        return outstore_record_id_s;
    }
    
    @XmlElement
    public void setOutstore_record_id_s(String outstore_record_id_s){
        this.outstore_record_id_s=outstore_record_id_s;
    }
        
    public String getOutstore_time_s(){
        return outstore_time_s;
    }
    
    @XmlElement
    public void setOutstore_time_s(String outstore_time_s){
        this.outstore_time_s=outstore_time_s;
    }
        
    public String getOutstore_worker_s(){
        return outstore_worker_s;
    }
    
    @XmlElement
    public void setOutstore_worker_s(String outstore_worker_s){
        this.outstore_worker_s=outstore_worker_s;
    }
        
    public String getPly_s(){
        return ply_s;
    }
    
    @XmlElement
    public void setPly_s(String ply_s){
        this.ply_s=ply_s;
    }
        
    public String getProduct_date_s(){
        return product_date_s;
    }
    
    @XmlElement
    public void setProduct_date_s(String product_date_s){
        this.product_date_s=product_date_s;
    }
        
    public String getPurpose_s(){
        return purpose_s;
    }
    
    @XmlElement
    public void setPurpose_s(String purpose_s){
        this.purpose_s=purpose_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getShift_id_s(){
        return shift_id_s;
    }
    
    @XmlElement
    public void setShift_id_s(String shift_id_s){
        this.shift_id_s=shift_id_s;
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
        
    public String getStoreplace_s(){
        return storeplace_s;
    }
    
    @XmlElement
    public void setStoreplace_s(String storeplace_s){
        this.storeplace_s=storeplace_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTrad_remark_s(){
        return trad_remark_s;
    }
    
    @XmlElement
    public void setTrad_remark_s(String trad_remark_s){
        this.trad_remark_s=trad_remark_s;
    }
        
    public String getTray_code_s(){
        return tray_code_s;
    }
    
    @XmlElement
    public void setTray_code_s(String tray_code_s){
        this.tray_code_s=tray_code_s;
    }
        
    public String getWind_type_s(){
        return wind_type_s;
    }
    
    @XmlElement
    public void setWind_type_s(String wind_type_s){
        this.wind_type_s=wind_type_s;
    }
        
    
    
    
}
