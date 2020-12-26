/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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
 * 成型工艺参数配方查询
 * @author 马建斌
 * @Date 2018-08-31 08:40:14
 */
@ATDefinition("INT_PLM_BUILDINGPROCESS")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_BUILDINGPROCESS")
public class BuilDingProcess extends RockWellBaseEntity{
    
    
    @Comment("生效时间")
    @Column(nullable=true,length=160)
    private String createdate_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=160)
    private String createuser_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=200)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=200)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=200)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=200)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=200)
    private String dummy5_s;
    
    @Comment("设备类型代码 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机")
    @Column(nullable=true,length=160)
    private String equipmentcode_s;
    
    @Comment("设备类型代码")
    @Column(nullable=true,length=160)
    private String equipmenttypecode_s;
    
    @Comment("失效时间")
    @Column(nullable=true,length=160)
    private String expireddate_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=160)
    private String factory_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=false,length=160)
    private String id_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=160)
    private String modifier_s;
    
    @Comment("PDM物料编码")
    @Column(nullable=true,length=160)
    private String pdmmat_s;
    
    @Comment("工艺路线名称")
    @Column(nullable=true,length=160)
    private String processroute_s;
    
    @Comment("工艺版本号")
    @Column(nullable=true,length=160)
    private String processversion_s;
    
    @Comment("接收时间")
    @Column(nullable=false,length=11)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=160)
    private String record_flag_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=160)
    private String sapmat_s;
    
    @Comment("产品阶段 试制 01 试产 02 投产03")
    @Column(nullable=true,length=160)
    private String stage_s;
    
    @Comment("版本号")
    @Column(nullable=true,length=160)
    private String version_s;
    
    @Comment("分厂 柳州 8003")
    @Column(nullable=true,length=160)
    private String werks_s;
    
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
        
    public String getEquipmentcode_s(){
        return equipmentcode_s;
    }
    
    @XmlElement
    public void setEquipmentcode_s(String equipmentcode_s){
        this.equipmentcode_s=equipmentcode_s;
    }
        
    public String getEquipmenttypecode_s(){
        return equipmenttypecode_s;
    }
    
    @XmlElement
    public void setEquipmenttypecode_s(String equipmenttypecode_s){
        this.equipmenttypecode_s=equipmenttypecode_s;
    }
        
    public String getExpireddate_s(){
        return expireddate_s;
    }
    
    @XmlElement
    public void setExpireddate_s(String expireddate_s){
        this.expireddate_s=expireddate_s;
    }
        
    public String getFactory_s(){
        return factory_s;
    }
    
    @XmlElement
    public void setFactory_s(String factory_s){
        this.factory_s=factory_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getModifier_s(){
        return modifier_s;
    }
    
    @XmlElement
    public void setModifier_s(String modifier_s){
        this.modifier_s=modifier_s;
    }
        
    public String getPdmmat_s(){
        return pdmmat_s;
    }
    
    @XmlElement
    public void setPdmmat_s(String pdmmat_s){
        this.pdmmat_s=pdmmat_s;
    }
        
    public String getProcessroute_s(){
        return processroute_s;
    }
    
    @XmlElement
    public void setProcessroute_s(String processroute_s){
        this.processroute_s=processroute_s;
    }
        
    public String getProcessversion_s(){
        return processversion_s;
    }
    
    @XmlElement
    public void setProcessversion_s(String processversion_s){
        this.processversion_s=processversion_s;
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
        
    public String getSapmat_s(){
        return sapmat_s;
    }
    
    @XmlElement
    public void setSapmat_s(String sapmat_s){
        this.sapmat_s=sapmat_s;
    }
        
    public String getStage_s(){
        return stage_s;
    }
    
    @XmlElement
    public void setStage_s(String stage_s){
        this.stage_s=stage_s;
    }
        
    public String getVersion_s(){
        return version_s;
    }
    
    @XmlElement
    public void setVersion_s(String version_s){
        this.version_s=version_s;
    }
        
    public String getWerks_s(){
        return werks_s;
    }
    
    @XmlElement
    public void setWerks_s(String werks_s){
        this.werks_s=werks_s;
    }
        
    
    
    
}
