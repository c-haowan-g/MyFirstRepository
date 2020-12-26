/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * PLM快检标准参数日志主表
 * @author 肖吉朔
 * @Date 2020-08-26 10:00:10
 */
@ATDefinition("INT_PLM_QUICKCHECK_LOG")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_QUICKCHECK_LOG")
public class PlmQuickCheckLog extends RockWellBaseEntity{
    
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("审核人")
    @Column(nullable=true,length=80)
    private String check_by_s;
    
    @Comment("审核人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
    @Comment("审核状态：0-未审核、1-已审核")
    @Column(nullable=true,length=80)
    private String check_state_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("创建日期")
    @Column(nullable=true,length=80)
    private String createdate_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String createuser_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=80)
    private String dummy5_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("检验标准类型：考核标准、检验标准、专检标准")
    @Column(nullable=true,length=80)
    private String inspectionstandardname_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String matername_s;
    
    @Comment("物料版本")
    @Column(nullable=true,length=80)
    private String materrevision_s;
    
    @Comment("物料品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F）")
    @Column(nullable=true,length=80)
    private String matersap_s;
    
    @Comment("物料品号")
    @Column(nullable=true,length=80)
    private String matersap_temp_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=80)
    private String plant_s;
    
    @Comment("配方阶段：ZC-正常、SY-不正常")
    @Column(nullable=true,length=80)
    private String prescriptionstage_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方启停人")
    @Column(nullable=true,length=80)
    private String recipe_by_s;
    
    @Comment("配方编号-13位：Java系统当前时间 例如 1552888628141")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("配方启停人姓名")
    @Column(nullable=true,length=200)
    private String recipe_name_s;
    
    @Comment("配方状态：323001-待用、323002-正用、323003-停用")
    @Column(nullable=true,length=80)
    private String recipe_status_s;
    
    @Comment("配方启停时间")
    @Column(nullable=true,length=0)
    private Date recipe_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
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
        
    public String getCheck_by_s(){
        return check_by_s;
    }
    
    @XmlElement
    public void setCheck_by_s(String check_by_s){
        this.check_by_s=check_by_s;
    }
        
    public String getCheck_name_s(){
        return check_name_s;
    }
    
    @XmlElement
    public void setCheck_name_s(String check_name_s){
        this.check_name_s=check_name_s;
    }
        
    public String getCheck_state_s(){
        return check_state_s;
    }
    
    @XmlElement
    public void setCheck_state_s(String check_state_s){
        this.check_state_s=check_state_s;
    }
        
    public Date getCheck_time_t(){
        return check_time_t;
    }
    
    @XmlElement
    public void setCheck_time_t(Date check_time_t){
        this.check_time_t=check_time_t;
    }
        
    public String getCreatedate_s(){
        return createdate_s;
    }
    
    @XmlElement
    public void setCreatedate_s(String createdate_s){
        this.createdate_s=createdate_s;
    }
        
    public String getCreateuser_s(){
        return createuser_s;
    }
    
    @XmlElement
    public void setCreateuser_s(String createuser_s){
        this.createuser_s=createuser_s;
    }
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInspectionstandardname_s(){
        return inspectionstandardname_s;
    }
    
    @XmlElement
    public void setInspectionstandardname_s(String inspectionstandardname_s){
        this.inspectionstandardname_s=inspectionstandardname_s;
    }
        
    public String getMatername_s(){
        return matername_s;
    }
    
    @XmlElement
    public void setMatername_s(String matername_s){
        this.matername_s=matername_s;
    }
        
    public String getMaterrevision_s(){
        return materrevision_s;
    }
    
    @XmlElement
    public void setMaterrevision_s(String materrevision_s){
        this.materrevision_s=materrevision_s;
    }
        
    public String getMatersap_s(){
        return matersap_s;
    }
    
    @XmlElement
    public void setMatersap_s(String matersap_s){
        this.matersap_s=matersap_s;
    }
        
    public String getMatersap_temp_s(){
        return matersap_temp_s;
    }
    
    @XmlElement
    public void setMatersap_temp_s(String matersap_temp_s){
        this.matersap_temp_s=matersap_temp_s;
    }
        
    public String getPlant_s(){
        return plant_s;
    }
    
    @XmlElement
    public void setPlant_s(String plant_s){
        this.plant_s=plant_s;
    }
        
    public String getPrescriptionstage_s(){
        return prescriptionstage_s;
    }
    
    @XmlElement
    public void setPrescriptionstage_s(String prescriptionstage_s){
        this.prescriptionstage_s=prescriptionstage_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecipe_by_s(){
        return recipe_by_s;
    }
    
    @XmlElement
    public void setRecipe_by_s(String recipe_by_s){
        this.recipe_by_s=recipe_by_s;
    }
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
    }
        
    public String getRecipe_name_s(){
        return recipe_name_s;
    }
    
    @XmlElement
    public void setRecipe_name_s(String recipe_name_s){
        this.recipe_name_s=recipe_name_s;
    }
        
    public String getRecipe_status_s(){
        return recipe_status_s;
    }
    
    @XmlElement
    public void setRecipe_status_s(String recipe_status_s){
        this.recipe_status_s=recipe_status_s;
    }
        
    public Date getRecipe_time_t(){
        return recipe_time_t;
    }
    
    @XmlElement
    public void setRecipe_time_t(Date recipe_time_t){
        this.recipe_time_t=recipe_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
    }
        
    public String getSend_name_s(){
        return send_name_s;
    }
    
    @XmlElement
    public void setSend_name_s(String send_name_s){
        this.send_name_s=send_name_s;
    }
        
    public String getSend_state_s(){
        return send_state_s;
    }
    
    @XmlElement
    public void setSend_state_s(String send_state_s){
        this.send_state_s=send_state_s;
    }
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
    }
        
    
    
    
}
