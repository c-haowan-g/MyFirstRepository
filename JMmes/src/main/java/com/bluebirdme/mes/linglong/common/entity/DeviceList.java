/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * PLM系统设备清单表
 * @author sqj
 * @Date 2019-01-11 13:40:17
 */
@ATDefinition("INT_PLM_DEVICELIST")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_DEVICELIST")
public class DeviceList extends RockWellBaseEntity{
    
    
    @Comment("备用1")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用2")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("设备代码")
    @Column(nullable=true,length=100)
    private String equipmentcode_s;
    
    @Comment("设备名称")
    @Column(nullable=true,length=100)
    private String equipmentname_s;
    
    @Comment("设备类型代码")
    @Column(nullable=true,length=80)
    private String equipmenttypecode_s;
    
    @Comment("设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机")
    @Column(nullable=true,length=80)
    private String equipmenttypename_s;
    
    @Comment("分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3")
    @Column(nullable=true,length=100)
    private String factory_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("工厂 柳州 8003")
    @Column(nullable=true,length=100)
    private String werks_s;
    
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
        
    public String getEquipmentname_s(){
        return equipmentname_s;
    }
    
    @XmlElement
    public void setEquipmentname_s(String equipmentname_s){
        this.equipmentname_s=equipmentname_s;
    }
        
    public String getEquipmenttypecode_s(){
        return equipmenttypecode_s;
    }
    
    @XmlElement
    public void setEquipmenttypecode_s(String equipmenttypecode_s){
        this.equipmenttypecode_s=equipmenttypecode_s;
    }
        
    public String getEquipmenttypename_s(){
        return equipmenttypename_s;
    }
    
    @XmlElement
    public void setEquipmenttypename_s(String equipmenttypename_s){
        this.equipmenttypename_s=equipmenttypename_s;
    }
        
    public String getFactory_s(){
        return factory_s;
    }
    
    @XmlElement
    public void setFactory_s(String factory_s){
        this.factory_s=factory_s;
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
        
    public String getWerks_s(){
        return werks_s;
    }
    
    @XmlElement
    public void setWerks_s(String werks_s){
        this.werks_s=werks_s;
    }
        
    
    
    
}
