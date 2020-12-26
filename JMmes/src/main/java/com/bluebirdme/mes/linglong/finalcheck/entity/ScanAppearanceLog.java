/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 质检外观扫描履历表
 * @author 马建斌
 * @Date 2018-09-03 14:27:44
 */
@ATDefinition("_D_QM_SCANAPPEARANCELOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_SCANAPPEARANCELOG")
public class ScanAppearanceLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=160)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=160)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MainTyre.BARCODE")
    @Column(nullable=true,length=160)
    private String barcode_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=160)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=160)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=11)
    private Date created_time_t;
    
    @Comment("设备条码：D_EM_Ent.ENTBARCODE")
    @Column(nullable=true,length=160)
    private String entbarcode_s;
    
    @Comment("MES校验错误类型： 259001：轮胎条码 259002：机台信息不存在 259003：规格索引不存在 259004：轮胎状态不允许分配 259005：轮胎规格规则未维护 259006：滑道异常 259007：机台停止 259008：扫描头未读取到条码 259009：其它")
    @Column(nullable=true,length=22)
    private BigDecimal etype_i;
    
    @Comment("质量等级编码")
    @Column(nullable=true,length=22)
    private BigDecimal gradecode_i;
    
    @Comment("班组编号")
    @Column(nullable=true,length=160)
    private String groupcode_s;
    
    @Comment("MES校验是否成功：0-失败，1-成功")
    @Column(nullable=true,length=22)
    private String isok_i;
    
    @Comment("品号")
    @Column(nullable=true,length=160)
    private String itemid_s;
    
    @Comment("当前工序")
    @Column(nullable=true,length=22)
    private BigDecimal proess_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=160)
    private String record_flag_s;
    
    @Comment("MES备注")
    @Column(nullable=true,length=160)
    private String remark_s;
    
    @Comment("班次编号")
    @Column(nullable=true,length=160)
    private String shiftcode_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=160)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=160)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=160)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=160)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=160)
    private String spare5_s;
    
    @Comment("轮胎状态编码：0-待检、1-合格、2-不合格")
    @Column(nullable=true,length=22)
    private BigDecimal statecode_i;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=160)
    private String s_factory_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=160)
    private String tyretype_s;
    
    @Comment("工控下发备注")
    @Column(nullable=true,length=160)
    private String writeinremark_s;
    
    @Comment("工控下发是否成功：0-失败、1-成功")
    @Column(nullable=true,length=22)
    private String writein_i;
    
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
        
    public BigDecimal getEtype_i(){
        return etype_i;
    }
    
    @XmlElement
    public void setEtype_i(BigDecimal etype_i){
        this.etype_i=etype_i;
    }
        
    public BigDecimal getGradecode_i(){
        return gradecode_i;
    }
    
    @XmlElement
    public void setGradecode_i(BigDecimal gradecode_i){
        this.gradecode_i=gradecode_i;
    }
        
    public String getGroupcode_s(){
        return groupcode_s;
    }
    
    @XmlElement
    public void setGroupcode_s(String groupcode_s){
        this.groupcode_s=groupcode_s;
    }
        
    public String getIsok_i(){
        return isok_i;
    }
    
    @XmlElement
    public void setIsok_i(String isok_i){
        this.isok_i=isok_i;
    }
        
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
    public BigDecimal getProess_i(){
        return proess_i;
    }
    
    @XmlElement
    public void setProess_i(BigDecimal proess_i){
        this.proess_i=proess_i;
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
        
    public BigDecimal getStatecode_i(){
        return statecode_i;
    }
    
    @XmlElement
    public void setStatecode_i(BigDecimal statecode_i){
        this.statecode_i=statecode_i;
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
        
    public String getWriteinremark_s(){
        return writeinremark_s;
    }
    
    @XmlElement
    public void setWriteinremark_s(String writeinremark_s){
        this.writeinremark_s=writeinremark_s;
    }
        
    public String getWritein_i(){
        return writein_i;
    }
    
    @XmlElement
    public void setWritein_i(String writein_i){
        this.writein_i=writein_i;
    }
        
    
    
    
}
