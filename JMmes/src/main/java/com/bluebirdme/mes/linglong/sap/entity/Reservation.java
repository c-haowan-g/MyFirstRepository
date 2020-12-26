/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity;

 	
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * 发布预留到 MES 系统（SAP->MES）
 * @author 周清玉
 * @Date 2019-03-21 11:45:52
 */
@ATDefinition("INT_SAP_RESERVATION")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_RESERVATION")
public class Reservation extends RockWellBaseEntity{
    
    
    @Comment("批次号")
    @Column(nullable=true,length=80)
    private String batch_s;
    
    @Comment("成本中心")
    @Column(nullable=true,length=80)
    private String costcenter_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String dummy5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String dummy6_s;
    
    @Comment("需求日期")
    @Column(nullable=true,length=80)
    private String demondsdate_s;
    
    @Comment("需求部门")
    @Column(nullable=true,length=80)
    private String department_s;
    
    @Comment("预留字段 1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留字段 2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留字段 3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("余留字段 4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("是否发货")
    @Column(nullable=true,length=80)
    private String isdeliver_s;
    
    @Comment("物料号")
    @Column(nullable=true,length=80)
    private String matcode_s;
    
    @Comment("移动类型")
    @Column(nullable=true,length=80)
    private String movtype_s;
    
    @Comment("订 单（财务）")
    @Column(nullable=true,length=80)
    private String order_s;
    
    @Comment("发出工厂")
    @Column(nullable=true,length=80)
    private String plantfrom_s;
    
    @Comment("接收工厂")
    @Column(nullable=true,length=80)
    private String plantto_s;
    
    @Comment("转入数量")
    @Column(nullable=true,length=80)
    private String qty_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("预留单行号")
    @Column(nullable=true,length=80)
    private String reseritem_s;
    
    @Comment("预留单号")
    @Column(nullable=true,length=80)
    private String reserno_s;
    
    @Comment("发出库存地点")
    @Column(nullable=true,length=80)
    private String storlocfrom_s;
    
    @Comment("收 货 库 存 地点")
    @Column(nullable=true,length=80)
    private String storlocto_s;
    
    @Comment("计量单位")
    @Column(nullable=true,length=80)
    private String unit_s;
    
    public String getBatch_s(){
        return batch_s;
    }
    
    @XmlElement
    public void setBatch_s(String batch_s){
        this.batch_s=batch_s;
    }
        
    public String getCostcenter_s(){
        return costcenter_s;
    }
    
    @XmlElement
    public void setCostcenter_s(String costcenter_s){
        this.costcenter_s=costcenter_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getDummy6_s(){
        return dummy6_s;
    }
    
    @XmlElement
    public void setDummy6_s(String dummy6_s){
        this.dummy6_s=dummy6_s;
    }
        
    public String getDemondsdate_s(){
        return demondsdate_s;
    }
    
    @XmlElement
    public void setDemondsdate_s(String demondsdate_s){
        this.demondsdate_s=demondsdate_s;
    }
        
    public String getDepartment_s(){
        return department_s;
    }
    
    @XmlElement
    public void setDepartment_s(String department_s){
        this.department_s=department_s;
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
        
    public String getIsdeliver_s(){
        return isdeliver_s;
    }
    
    @XmlElement
    public void setIsdeliver_s(String isdeliver_s){
        this.isdeliver_s=isdeliver_s;
    }
        
    public String getMatcode_s(){
        return matcode_s;
    }
    
    @XmlElement
    public void setMatcode_s(String matcode_s){
        this.matcode_s=matcode_s;
    }
        
    public String getMovtype_s(){
        return movtype_s;
    }
    
    @XmlElement
    public void setMovtype_s(String movtype_s){
        this.movtype_s=movtype_s;
    }
        
    public String getOrder_s(){
        return order_s;
    }
    
    @XmlElement
    public void setOrder_s(String order_s){
        this.order_s=order_s;
    }
        
    public String getPlantfrom_s(){
        return plantfrom_s;
    }
    
    @XmlElement
    public void setPlantfrom_s(String plantfrom_s){
        this.plantfrom_s=plantfrom_s;
    }
        
    public String getPlantto_s(){
        return plantto_s;
    }
    
    @XmlElement
    public void setPlantto_s(String plantto_s){
        this.plantto_s=plantto_s;
    }
        
    public String getQty_s(){
        return qty_s;
    }
    
    @XmlElement
    public void setQty_s(String qty_s){
        this.qty_s=qty_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReseritem_s(){
        return reseritem_s;
    }
    
    @XmlElement
    public void setReseritem_s(String reseritem_s){
        this.reseritem_s=reseritem_s;
    }
        
    public String getReserno_s(){
        return reserno_s;
    }
    
    @XmlElement
    public void setReserno_s(String reserno_s){
        this.reserno_s=reserno_s;
    }
        
    public String getStorlocfrom_s(){
        return storlocfrom_s;
    }
    
    @XmlElement
    public void setStorlocfrom_s(String storlocfrom_s){
        this.storlocfrom_s=storlocfrom_s;
    }
        
    public String getStorlocto_s(){
        return storlocto_s;
    }
    
    @XmlElement
    public void setStorlocto_s(String storlocto_s){
        this.storlocto_s=storlocto_s;
    }
        
    public String getUnit_s(){
        return unit_s;
    }
    
    @XmlElement
    public void setUnit_s(String unit_s){
        this.unit_s=unit_s;
    }
        
    
    
    
}
