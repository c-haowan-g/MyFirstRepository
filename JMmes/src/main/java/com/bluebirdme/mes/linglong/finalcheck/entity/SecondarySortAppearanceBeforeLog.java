/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 二次质检外观前分拣履历表
 * @author 孙尊龙
 * @Date 2020-01-21 13:54:15
 */
@ATDefinition("D_QM_SORTAPPEARANCELOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_SORTAPPEARANCELOG")
public class SecondarySortAppearanceBeforeLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MainTyre 表 BARCODE")
    @Column(nullable=true,length=80)
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
    
    @Comment("MES校验错误类型：259001：轮胎条码、259002：机台信息不存在、259003：规格索引不存在、259004：轮胎状态不允许分配、259005：轮胎规格规则未维护、59006：滑道异常、259007：机台停止、259008：扫描头未读取到条码、259009：轮胎状态不允许检测、259010：其它")
    @Column(nullable=true,length=0)
    private Integer etype_i;
    
    @Comment("质量等级编码")
    @Column(nullable=false,length=0)
    private Integer gradecd_i;
    
    @Comment("MES校验是否成功：0-失败，1-成功")
    @Column(nullable=false,length=0)
    private Integer isok_i;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("工序")
    @Column(nullable=false,length=0)
    private Integer proess_i;
    
    @Comment("实绩去向：MES_ZJ_Ent 表 ENTBARCODE")
    @Column(nullable=true,length=80)
    private String realmachinebar_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String remark_s;
    
    @Comment("分拣去向：MES_ZJ_Ent 表 ENTBARCODE")
    @Column(nullable=true,length=80)
    private String sortmachinebar_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date sorttime_t;
    
    @Comment("分拣点：260001-割毛前、260002-外观前、260003-外观后、260004-X光后、260005-动平衡前、260006-入库前")
    @Column(nullable=false,length=0)
    private Integer sorttype_i;
    
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
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
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
        
    public Integer getEtype_i(){
        return etype_i;
    }
    
    @XmlElement
    public void setEtype_i(Integer etype_i){
        this.etype_i=etype_i;
    }
        
    public Integer getGradecd_i(){
        return gradecd_i;
    }
    
    @XmlElement
    public void setGradecd_i(Integer gradecd_i){
        this.gradecd_i=gradecd_i;
    }
        
    public Integer getIsok_i(){
        return isok_i;
    }
    
    @XmlElement
    public void setIsok_i(Integer isok_i){
        this.isok_i=isok_i;
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
        
    public String getRealmachinebar_s(){
        return realmachinebar_s;
    }
    
    @XmlElement
    public void setRealmachinebar_s(String realmachinebar_s){
        this.realmachinebar_s=realmachinebar_s;
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
        
    public String getSortmachinebar_s(){
        return sortmachinebar_s;
    }
    
    @XmlElement
    public void setSortmachinebar_s(String sortmachinebar_s){
        this.sortmachinebar_s=sortmachinebar_s;
    }
        
    public Date getSorttime_t(){
        return sorttime_t;
    }
    
    @XmlElement
    public void setSorttime_t(Date sorttime_t){
        this.sorttime_t=sorttime_t;
    }
        
    public Integer getSorttype_i(){
        return sorttype_i;
    }
    
    @XmlElement
    public void setSorttype_i(Integer sorttype_i){
        this.sorttype_i=sorttype_i;
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
