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
 * PLM半部件工艺表
 * @author 葛迎祥
 * @Date 2020-06-16 14:06:43
 */
@ATDefinition("INT_PLM_HALFPARTPROCESS")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_HALFPARTPROCESS")
public class HalfPartProcess extends RockWellBaseEntity{
    
    
    @Comment("半部件描述名")
    @Column(nullable=true,length=80)
    private String assemname_s;
    
    @Comment("半部件物料编码")
    @Column(nullable=true,length=80)
    private String assempdmmat_s;
    
    @Comment("SAP品号-储胎9位品号")
    @Column(nullable=true,length=80)
    private String assemsapmat_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=80)
    private String assemsapmat_temp_s;
    
    @Comment("生效日期")
    @Column(nullable=true,length=80)
    private String createdate_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String createuser_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("设备代码")
    @Column(nullable=true,length=80)
    private String equipmentcode_s;
    
    @Comment("失效日期")
    @Column(nullable=true,length=80)
    private String expireddate_s;
    
    @Comment("分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3")
    @Column(nullable=true,length=80)
    private String factory_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=false,length=80)
    private String id_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String modifier_s;
    
    @Comment("工艺路线名称")
    @Column(nullable=true,length=80)
    private String processroute_s;
    
    @Comment("工艺版本号")
    @Column(nullable=true,length=80)
    private String processversion_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("版本号")
    @Column(nullable=true,length=80)
    private String version_s;
    
    @Comment("工厂 柳州 8003")
    @Column(nullable=true,length=80)
    private String werks_s;
    
    public String getAssemname_s(){
        return assemname_s;
    }
    
    @XmlElement
    public void setAssemname_s(String assemname_s){
        this.assemname_s=assemname_s;
    }
        
    public String getAssempdmmat_s(){
        return assempdmmat_s;
    }
    
    @XmlElement
    public void setAssempdmmat_s(String assempdmmat_s){
        this.assempdmmat_s=assempdmmat_s;
    }
        
    public String getAssemsapmat_s(){
        return assemsapmat_s;
    }
    
    @XmlElement
    public void setAssemsapmat_s(String assemsapmat_s){
        this.assemsapmat_s=assemsapmat_s;
    }
        
    public String getAssemsapmat_temp_s(){
        return assemsapmat_temp_s;
    }
    
    @XmlElement
    public void setAssemsapmat_temp_s(String assemsapmat_temp_s){
        this.assemsapmat_temp_s=assemsapmat_temp_s;
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
        
    public String getEquipmentcode_s(){
        return equipmentcode_s;
    }
    
    @XmlElement
    public void setEquipmentcode_s(String equipmentcode_s){
        this.equipmentcode_s=equipmentcode_s;
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
