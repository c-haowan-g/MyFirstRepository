/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 产线信息表
 * @author 兰颖慧
 * @Date 2019-05-10 08:59:37
 */
@ATDefinition("Production_Line_Log")
@Entity
@XmlRootElement
@Table(name="AT_PRODUCTION_LINE_LOG")
public class HalfpartProductionLineLog extends RockWellBaseEntity{
    
    
    @Comment("启用时间")
    @Column(nullable=true,length=0)
    private Date activetime_t;
    
    @Comment("能力")
    @Column(nullable=true,length=80)
    private String capacity_s;
    
    @Comment("类别")
    @Column(nullable=true,length=80)
    private String category_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changeby_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changetime_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String createby_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date createtime_t;
    
    @Comment("所属部门")
    @Column(nullable=true,length=80)
    private String department_s;
    
    @Comment("描述")
    @Column(nullable=true,length=80)
    private String description_s;
    
    @Comment("厂商")
    @Column(nullable=true,length=80)
    private String factory_s;
    
    @Comment("机台组 ")
    @Column(nullable=true,length=80)
    private String machinegroup_s;
    
    @Comment("设备类型（基础数据211）")
    @Column(nullable=true,length=80)
    private String machinetype_s;
    
    @Comment("制造年月")
    @Column(nullable=true,length=0)
    private Date manufacturingtime_t;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String memo_s;
    
    @Comment("型号")
    @Column(nullable=true,length=80)
    private String model_s;
    
    @Comment("名称")
    @Column(nullable=true,length=80)
    private String name_s;
    
    @Comment("优先级")
    @Column(nullable=true,length=80)
    private String priority_s;
    
    @Comment("所属工序：252004")
    @Column(nullable=true,length=80)
    private String process_s;
    
    @Comment("额定能力")
    @Column(nullable=true,length=80)
    private String remarks_s;
    
    @Comment("责任人")
    @Column(nullable=true,length=80)
    private String responsible_s;
    
    @Comment("使用年限")
    @Column(nullable=true,length=80)
    private String servicelife_s;
    
    @Comment("外形尺寸")
    @Column(nullable=true,length=80)
    private String shape_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("班类别(FIF0 LIFO RANDOM)")
    @Column(nullable=true,length=0)
    private Integer sublot_access_type_i;
    
    @Comment("班能力")
    @Column(nullable=true,length=80)
    private String sublot_capacity_s;
    
    @Comment("重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    public Date getActivetime_t(){
        return activetime_t;
    }
    
    @XmlElement
    public void setActivetime_t(Date activetime_t){
        this.activetime_t=activetime_t;
    }
        
    public String getCapacity_s(){
        return capacity_s;
    }
    
    @XmlElement
    public void setCapacity_s(String capacity_s){
        this.capacity_s=capacity_s;
    }
        
    public String getCategory_s(){
        return category_s;
    }
    
    @XmlElement
    public void setCategory_s(String category_s){
        this.category_s=category_s;
    }
        
    public String getChangeby_s(){
        return changeby_s;
    }
    
    @XmlElement
    public void setChangeby_s(String changeby_s){
        this.changeby_s=changeby_s;
    }
        
    public Date getChangetime_t(){
        return changetime_t;
    }
    
    @XmlElement
    public void setChangetime_t(Date changetime_t){
        this.changetime_t=changetime_t;
    }
        
    public String getCreateby_s(){
        return createby_s;
    }
    
    @XmlElement
    public void setCreateby_s(String createby_s){
        this.createby_s=createby_s;
    }
        
    public Date getCreatetime_t(){
        return createtime_t;
    }
    
    @XmlElement
    public void setCreatetime_t(Date createtime_t){
        this.createtime_t=createtime_t;
    }
        
    public String getDepartment_s(){
        return department_s;
    }
    
    @XmlElement
    public void setDepartment_s(String department_s){
        this.department_s=department_s;
    }
        
    public String getDescription_s(){
        return description_s;
    }
    
    @XmlElement
    public void setDescription_s(String description_s){
        this.description_s=description_s;
    }
        
    public String getFactory_s(){
        return factory_s;
    }
    
    @XmlElement
    public void setFactory_s(String factory_s){
        this.factory_s=factory_s;
    }
        
    public String getMachinegroup_s(){
        return machinegroup_s;
    }
    
    @XmlElement
    public void setMachinegroup_s(String machinegroup_s){
        this.machinegroup_s=machinegroup_s;
    }
        
    public String getMachinetype_s(){
        return machinetype_s;
    }
    
    @XmlElement
    public void setMachinetype_s(String machinetype_s){
        this.machinetype_s=machinetype_s;
    }
        
    public Date getManufacturingtime_t(){
        return manufacturingtime_t;
    }
    
    @XmlElement
    public void setManufacturingtime_t(Date manufacturingtime_t){
        this.manufacturingtime_t=manufacturingtime_t;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getModel_s(){
        return model_s;
    }
    
    @XmlElement
    public void setModel_s(String model_s){
        this.model_s=model_s;
    }
        
    public String getName_s(){
        return name_s;
    }
    
    @XmlElement
    public void setName_s(String name_s){
        this.name_s=name_s;
    }
        
    public String getPriority_s(){
        return priority_s;
    }
    
    @XmlElement
    public void setPriority_s(String priority_s){
        this.priority_s=priority_s;
    }
        
    public String getProcess_s(){
        return process_s;
    }
    
    @XmlElement
    public void setProcess_s(String process_s){
        this.process_s=process_s;
    }
        
    public String getRemarks_s(){
        return remarks_s;
    }
    
    @XmlElement
    public void setRemarks_s(String remarks_s){
        this.remarks_s=remarks_s;
    }
        
    public String getResponsible_s(){
        return responsible_s;
    }
    
    @XmlElement
    public void setResponsible_s(String responsible_s){
        this.responsible_s=responsible_s;
    }
        
    public String getServicelife_s(){
        return servicelife_s;
    }
    
    @XmlElement
    public void setServicelife_s(String servicelife_s){
        this.servicelife_s=servicelife_s;
    }
        
    public String getShape_s(){
        return shape_s;
    }
    
    @XmlElement
    public void setShape_s(String shape_s){
        this.shape_s=shape_s;
    }
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public Integer getSublot_access_type_i(){
        return sublot_access_type_i;
    }
    
    @XmlElement
    public void setSublot_access_type_i(Integer sublot_access_type_i){
        this.sublot_access_type_i=sublot_access_type_i;
    }
        
    public String getSublot_capacity_s(){
        return sublot_capacity_s;
    }
    
    @XmlElement
    public void setSublot_capacity_s(String sublot_capacity_s){
        this.sublot_capacity_s=sublot_capacity_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    
    
    
}
