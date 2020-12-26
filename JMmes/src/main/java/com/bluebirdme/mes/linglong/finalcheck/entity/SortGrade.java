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
 * 质检分拣等级规则表
 * @author 刘程明
 * @Date 2018-08-16 12:23:33
 */
@ATDefinition("D_BS_SortGrade")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_SortGrade")
public class SortGrade extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=160)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=40)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=40)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=40)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=11)
    private Date created_time_t;
    
    @Comment("D_ZJ_Ent 表 ID")
    @Column(nullable=true,length=160)
    private String entbarcode_s;
    
    @Comment("质量等级编码")
    @Column(nullable=false,length=22)
    private BigDecimal gradecd_i;
    
    @Comment("质量等级描述")
    @Column(nullable=true,length=240)
    private String gradedesc_s;
    
    @Comment("下工序处理：0-允许，1-不允许")
    @Column(nullable=false,length=22)
    private BigDecimal ischeck_i;
    
    @Comment("工序描述")
    @Column(nullable=true,length=240)
    private String proessdesc_s;
    
    @Comment("工序")
    @Column(nullable=false,length=22)
    private BigDecimal proess_i;
    
    @Comment("记录标志，A当前可检，D历史可检")
    @Column(nullable=false,length=40)
    private String record_flag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=40)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=40)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=40)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=40)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=40)
    private String spare5_s;
    
    @Comment("分拣点描述")
    @Column(nullable=true,length=240)
    private String stationdesc_s;
    
    @Comment("分拣点：0-割毛前、1-外观前、4-动均前、5-入库前")
    @Column(nullable=false,length=22)
    private BigDecimal station_i;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=40)
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
        
    public BigDecimal getGradecd_i(){
        return gradecd_i;
    }
    
    @XmlElement
    public void setGradecd_i(BigDecimal gradecd_i){
        this.gradecd_i=gradecd_i;
    }
        
    public String getGradedesc_s(){
        return gradedesc_s;
    }
    
    @XmlElement
    public void setGradedesc_s(String gradedesc_s){
        this.gradedesc_s=gradedesc_s;
    }
        
    public BigDecimal getIscheck_i(){
        return ischeck_i;
    }
    
    @XmlElement
    public void setIscheck_i(BigDecimal ischeck_i){
        this.ischeck_i=ischeck_i;
    }
        
    public String getProessdesc_s(){
        return proessdesc_s;
    }
    
    @XmlElement
    public void setProessdesc_s(String proessdesc_s){
        this.proessdesc_s=proessdesc_s;
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
        
    public String getStationdesc_s(){
        return stationdesc_s;
    }
    
    @XmlElement
    public void setStationdesc_s(String stationdesc_s){
        this.stationdesc_s=stationdesc_s;
    }
        
    public BigDecimal getStation_i(){
        return station_i;
    }
    
    @XmlElement
    public void setStation_i(BigDecimal station_i){
        this.station_i=station_i;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
}
