/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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
 * PLM配方下发基础参数表
 * @author 刘程明
 * @Date 2019-06-18 17:20:07
 */
@ATDefinition("INT_PLM_BUILDRECIPEPARA")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_BUILDRECIPEPARA")
public class BuildRecipePara extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("参数类型：1-成型")
    @Column(nullable=true,length=80)
    private String basetype_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("设备代码")
    @Column(nullable=true,length=80)
    private String equipmentcode_s;
    
    @Comment("设备类型名称： 22-全钢一次发成型机 23-半钢VMI一次发成型机 24-半钢克虏伯一次发成型机 25-半钢二次法成型机")
    @Column(nullable=true,length=80)
    private String equipmenttypecode_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=0)
    private Integer id_i;
    
    @Comment("上下限是否启用：A-是、D-否")
    @Column(nullable=true,length=80)
    private String is_max_min_s;
    
    @Comment("上限值逻辑地址描述")
    @Column(nullable=true,length=80)
    private String logicaladdress_max_name_s;
    
    @Comment("上限值逻辑地址")
    @Column(nullable=true,length=80)
    private String logicaladdress_max_s;
    
    @Comment("下限值逻辑地址描述")
    @Column(nullable=true,length=80)
    private String logicaladdress_min_name_s;
    
    @Comment("下限值逻辑地址")
    @Column(nullable=true,length=80)
    private String logicaladdress_min_s;
    
    @Comment("标准值逻辑地址")
    @Column(nullable=true,length=80)
    private String logicaladdress_s;
    
    @Comment("参数CODE")
    @Column(nullable=true,length=80)
    private String parmcode_s;
    
    @Comment("参数中文名称")
    @Column(nullable=true,length=80)
    private String parmname_s;
    
    @Comment("参数类型代码")
    @Column(nullable=true,length=80)
    private String parmtypecode_s;
    
    @Comment("参数类型名称： 1000-施工显示参数 1001-施工控制参数 1002-接头定位角度显示参数 2000-施工显示参数 2001-施工控制参数 2002-接头定位角度控制参数 2003-接头定位角度显示参数 2004-施工显示参数 2005-施工显示参数 2006-施工显示参数 2007-施工显示参数 2008-施工显示参数 2009-施工显示参数")
    @Column(nullable=true,length=80)
    private String parmtypename_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("标准值逻辑地址描述")
    @Column(nullable=true,length=80)
    private String remark_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("单位")
    @Column(nullable=true,length=80)
    private String unit_s;
    
    @Comment("参数最大值操作符 0 不包含、1包含")
    @Column(nullable=true,length=80)
    private String valuemaxsign_s;
    
    @Comment("参数最大值")
    @Column(nullable=true,length=80)
    private String valuemax_s;
    
    @Comment("参数最小值操作符")
    @Column(nullable=true,length=80)
    private String valueminsign_s;
    
    @Comment("参数最小值")
    @Column(nullable=true,length=80)
    private String valuemin_s;
    
    @Comment("参数值")
    @Column(nullable=true,length=80)
    private String value_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBasetype_s(){
        return basetype_s;
    }
    
    @XmlElement
    public void setBasetype_s(String basetype_s){
        this.basetype_s=basetype_s;
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
        
    public Integer getId_i(){
        return id_i;
    }
    
    @XmlElement
    public void setId_i(Integer id_i){
        this.id_i=id_i;
    }
        
    public String getIs_max_min_s(){
        return is_max_min_s;
    }
    
    @XmlElement
    public void setIs_max_min_s(String is_max_min_s){
        this.is_max_min_s=is_max_min_s;
    }
        
    public String getLogicaladdress_max_name_s(){
        return logicaladdress_max_name_s;
    }
    
    @XmlElement
    public void setLogicaladdress_max_name_s(String logicaladdress_max_name_s){
        this.logicaladdress_max_name_s=logicaladdress_max_name_s;
    }
        
    public String getLogicaladdress_max_s(){
        return logicaladdress_max_s;
    }
    
    @XmlElement
    public void setLogicaladdress_max_s(String logicaladdress_max_s){
        this.logicaladdress_max_s=logicaladdress_max_s;
    }
        
    public String getLogicaladdress_min_name_s(){
        return logicaladdress_min_name_s;
    }
    
    @XmlElement
    public void setLogicaladdress_min_name_s(String logicaladdress_min_name_s){
        this.logicaladdress_min_name_s=logicaladdress_min_name_s;
    }
        
    public String getLogicaladdress_min_s(){
        return logicaladdress_min_s;
    }
    
    @XmlElement
    public void setLogicaladdress_min_s(String logicaladdress_min_s){
        this.logicaladdress_min_s=logicaladdress_min_s;
    }
        
    public String getLogicaladdress_s(){
        return logicaladdress_s;
    }
    
    @XmlElement
    public void setLogicaladdress_s(String logicaladdress_s){
        this.logicaladdress_s=logicaladdress_s;
    }
        
    public String getParmcode_s(){
        return parmcode_s;
    }
    
    @XmlElement
    public void setParmcode_s(String parmcode_s){
        this.parmcode_s=parmcode_s;
    }
        
    public String getParmname_s(){
        return parmname_s;
    }
    
    @XmlElement
    public void setParmname_s(String parmname_s){
        this.parmname_s=parmname_s;
    }
        
    public String getParmtypecode_s(){
        return parmtypecode_s;
    }
    
    @XmlElement
    public void setParmtypecode_s(String parmtypecode_s){
        this.parmtypecode_s=parmtypecode_s;
    }
        
    public String getParmtypename_s(){
        return parmtypename_s;
    }
    
    @XmlElement
    public void setParmtypename_s(String parmtypename_s){
        this.parmtypename_s=parmtypename_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getUnit_s(){
        return unit_s;
    }
    
    @XmlElement
    public void setUnit_s(String unit_s){
        this.unit_s=unit_s;
    }
        
    public String getValuemaxsign_s(){
        return valuemaxsign_s;
    }
    
    @XmlElement
    public void setValuemaxsign_s(String valuemaxsign_s){
        this.valuemaxsign_s=valuemaxsign_s;
    }
        
    public String getValuemax_s(){
        return valuemax_s;
    }
    
    @XmlElement
    public void setValuemax_s(String valuemax_s){
        this.valuemax_s=valuemax_s;
    }
        
    public String getValueminsign_s(){
        return valueminsign_s;
    }
    
    @XmlElement
    public void setValueminsign_s(String valueminsign_s){
        this.valueminsign_s=valueminsign_s;
    }
        
    public String getValuemin_s(){
        return valuemin_s;
    }
    
    @XmlElement
    public void setValuemin_s(String valuemin_s){
        this.valuemin_s=valuemin_s;
    }
        
    public String getValue_s(){
        return value_s;
    }
    
    @XmlElement
    public void setValue_s(String value_s){
        this.value_s=value_s;
    }
        
    
    
    
}
