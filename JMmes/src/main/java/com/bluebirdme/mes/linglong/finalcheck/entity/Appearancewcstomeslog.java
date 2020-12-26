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
 * 外检WCS交互日志表
 * @author 徐秉正
 * @Date 2019-12-23 10:06:53
 */
@ATDefinition("D_QM_APPEARANCEWCSTOMESLOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_APPEARANCEWCSTOMESLOG")
public class Appearancewcstomeslog extends RockWellBaseEntity{
    
    
    @Comment("病象分类编码")
    @Column(nullable=true,length=32)
    private String diseaseclasscode_s;
    
    @Comment("病象分类名称")
    @Column(nullable=true,length=100)
    private String diseaseclassname_s;
    
    @Comment("病象编码")
    @Column(nullable=true,length=32)
    private String diseasecode_s;
    
    @Comment("病象名称")
    @Column(nullable=true,length=100)
    private String diseasename_s;
    
    @Comment("外检质量等级")
    @Column(nullable=true,length=32)
    private String gradecode_s;
    
    @Comment("外检等级描述")
    @Column(nullable=true,length=32)
    private String gradeinfo_s;
    
    @Comment("主键ID")
    @Column(nullable=false,length=32)
    private String id_s;
    
    @Comment("外检人")
    @Column(nullable=true,length=32)
    private String inspectopr_s;
    
    @Comment("外检时间")
    @Column(nullable=true,length=80)
    private String inspecttime_s;
    
    @Comment("外检机台")
    @Column(nullable=true,length=32)
    private String machinecode_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=32)
    private String materialcode_s;
    
    @Comment("是否有效")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("MES信息")
    @Column(nullable=true,length=200)
    private String synerr_s;
    
    @Comment("同步标志位")
    @Column(nullable=true,length=10)
    private String synflag_s;
    
    @Comment("外检班次")
    @Column(nullable=true,length=32)
    private String teamcode_s;
    
    @Comment("外检班组")
    @Column(nullable=true,length=32)
    private String team_s;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=32)
    private String tirecode_s;
    
    @Comment("规格描述")
    @Column(nullable=true,length=100)
    private String tirestand_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=200)
    private String ud1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=200)
    private String ud2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=200)
    private String ud3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=200)
    private String ud4_s;
    
    public String getDiseaseclasscode_s(){
        return diseaseclasscode_s;
    }
    
    @XmlElement
    public void setDiseaseclasscode_s(String diseaseclasscode_s){
        this.diseaseclasscode_s=diseaseclasscode_s;
    }
        
    public String getDiseaseclassname_s(){
        return diseaseclassname_s;
    }
    
    @XmlElement
    public void setDiseaseclassname_s(String diseaseclassname_s){
        this.diseaseclassname_s=diseaseclassname_s;
    }
        
    public String getDiseasecode_s(){
        return diseasecode_s;
    }
    
    @XmlElement
    public void setDiseasecode_s(String diseasecode_s){
        this.diseasecode_s=diseasecode_s;
    }
        
    public String getDiseasename_s(){
        return diseasename_s;
    }
    
    @XmlElement
    public void setDiseasename_s(String diseasename_s){
        this.diseasename_s=diseasename_s;
    }
        
    public String getGradecode_s(){
        return gradecode_s;
    }
    
    @XmlElement
    public void setGradecode_s(String gradecode_s){
        this.gradecode_s=gradecode_s;
    }
        
    public String getGradeinfo_s(){
        return gradeinfo_s;
    }
    
    @XmlElement
    public void setGradeinfo_s(String gradeinfo_s){
        this.gradeinfo_s=gradeinfo_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInspectopr_s(){
        return inspectopr_s;
    }
    
    @XmlElement
    public void setInspectopr_s(String inspectopr_s){
        this.inspectopr_s=inspectopr_s;
    }
        
    public String getInspecttime_s(){
        return inspecttime_s;
    }
    
    @XmlElement
    public void setInspecttime_s(String inspecttime_s){
        this.inspecttime_s=inspecttime_s;
    }
        
    public String getMachinecode_s(){
        return machinecode_s;
    }
    
    @XmlElement
    public void setMachinecode_s(String machinecode_s){
        this.machinecode_s=machinecode_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSynerr_s(){
        return synerr_s;
    }
    
    @XmlElement
    public void setSynerr_s(String synerr_s){
        this.synerr_s=synerr_s;
    }
        
    public String getSynflag_s(){
        return synflag_s;
    }
    
    @XmlElement
    public void setSynflag_s(String synflag_s){
        this.synflag_s=synflag_s;
    }
        
    public String getTeamcode_s(){
        return teamcode_s;
    }
    
    @XmlElement
    public void setTeamcode_s(String teamcode_s){
        this.teamcode_s=teamcode_s;
    }
        
    public String getTeam_s(){
        return team_s;
    }
    
    @XmlElement
    public void setTeam_s(String team_s){
        this.team_s=team_s;
    }
        
    public String getTirecode_s(){
        return tirecode_s;
    }
    
    @XmlElement
    public void setTirecode_s(String tirecode_s){
        this.tirecode_s=tirecode_s;
    }
        
    public String getTirestand_s(){
        return tirestand_s;
    }
    
    @XmlElement
    public void setTirestand_s(String tirestand_s){
        this.tirestand_s=tirestand_s;
    }
        
    public String getUd1_s(){
        return ud1_s;
    }
    
    @XmlElement
    public void setUd1_s(String ud1_s){
        this.ud1_s=ud1_s;
    }
        
    public String getUd2_s(){
        return ud2_s;
    }
    
    @XmlElement
    public void setUd2_s(String ud2_s){
        this.ud2_s=ud2_s;
    }
        
    public String getUd3_s(){
        return ud3_s;
    }
    
    @XmlElement
    public void setUd3_s(String ud3_s){
        this.ud3_s=ud3_s;
    }
        
    public String getUd4_s(){
        return ud4_s;
    }
    
    @XmlElement
    public void setUd4_s(String ud4_s){
        this.ud4_s=ud4_s;
    }
        
    
    
    
}
