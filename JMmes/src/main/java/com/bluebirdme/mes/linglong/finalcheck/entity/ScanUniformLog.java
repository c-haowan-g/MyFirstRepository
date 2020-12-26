/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 质检均匀性扫描履历表-全钢
 * @author 刘朋
 * @Date 2019-09-12 09:49:19
 */
@ATDefinition("D_QM_SCANUNIFORMLOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_SCANUNIFORMLOG")
public class ScanUniformLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MainTyre 表 BARCODE")
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
    
    @Comment("设备ID：质检设备信息表主键ID")
    @Column(nullable=true,length=80)
    private String entbarcode_s;
    
    @Comment("MES校验错误类型： 1:轮胎条码 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配")
    @Column(nullable=true,length=80)
    private String etype_s;
    
    @Comment("质量等级编码")
    @Column(nullable=true,length=0)
    private Integer gradecd_i;
    
    @Comment("班组编号")
    @Column(nullable=true,length=80)
    private String groupcode_s;
    
    @Comment("MES校验是否成功：0-失败，1-成功")
    @Column(nullable=true,length=80)
    private String isok_s;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("当前工序")
    @Column(nullable=true,length=0)
    private Integer proess_i;
    
    @Comment("配方号：D_BS_Recipe 表 ID")
    @Column(nullable=true,length=0)
    private Integer recipeno_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("MES备注")
    @Column(nullable=true,length=80)
    private String remark_s;
    
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
    
    @Comment("轮胎状态编码：0-待检、1-合格、2-不合格")
    @Column(nullable=true,length=0)
    private Integer statecd_i;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=80)
    private String tyretype_s;
    
    @Comment("外胎重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    @Comment("工控下发备注")
    @Column(nullable=true,length=80)
    private String writeinremark_s;
    
    @Comment("工控下发是否成功：0-失败、1-成功")
    @Column(nullable=true,length=80)
    private String writein_s;
    
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
        
    public String getEntbarcode_s(){
        return entbarcode_s;
    }
    
    @XmlElement
    public void setEntbarcode_s(String entbarcode_s){
        this.entbarcode_s=entbarcode_s;
    }
        
    public String getEtype_s(){
        return etype_s;
    }
    
    @XmlElement
    public void setEtype_s(String etype_s){
        this.etype_s=etype_s;
    }
        
    public Integer getGradecd_i(){
        return gradecd_i;
    }
    
    @XmlElement
    public void setGradecd_i(Integer gradecd_i){
        this.gradecd_i=gradecd_i;
    }
        
    public String getGroupcode_s(){
        return groupcode_s;
    }
    
    @XmlElement
    public void setGroupcode_s(String groupcode_s){
        this.groupcode_s=groupcode_s;
    }
        
    public String getIsok_s(){
        return isok_s;
    }
    
    @XmlElement
    public void setIsok_s(String isok_s){
        this.isok_s=isok_s;
    }
        
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
    public Integer getProess_i(){
        return proess_i;
    }
    
    @XmlElement
    public void setProess_i(Integer proess_i){
        this.proess_i=proess_i;
    }
        
    public Integer getRecipeno_i(){
        return recipeno_i;
    }
    
    @XmlElement
    public void setRecipeno_i(Integer recipeno_i){
        this.recipeno_i=recipeno_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
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
        
    public Integer getStatecd_i(){
        return statecd_i;
    }
    
    @XmlElement
    public void setStatecd_i(Integer statecd_i){
        this.statecd_i=statecd_i;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyretype_s(){
        return tyretype_s;
    }
    
    @XmlElement
    public void setTyretype_s(String tyretype_s){
        this.tyretype_s=tyretype_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    public String getWriteinremark_s(){
        return writeinremark_s;
    }
    
    @XmlElement
    public void setWriteinremark_s(String writeinremark_s){
        this.writeinremark_s=writeinremark_s;
    }
        
    public String getWritein_s(){
        return writein_s;
    }
    
    @XmlElement
    public void setWritein_s(String writein_s){
        this.writein_s=writein_s;
    }
        
    
    
    
}
