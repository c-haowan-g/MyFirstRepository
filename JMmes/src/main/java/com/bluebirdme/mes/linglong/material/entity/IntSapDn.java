/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * 发布内向交货单到 MES 系统（SAP->MES）行项目信息
 * @author 李昂
 * @Date 2020-08-05 08:23:47
 */
@ATDefinition("INT_SAP_DN")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_DN")
public class IntSapDn extends RockWellBaseEntity{
    
    
    @Comment("单据日期")
    @Column(nullable=true,length=80)
    private String deliverydate_s;
    
    @Comment("交货数量")
    @Column(nullable=true,length=80)
    private String deliveryqty_s;
    
    @Comment("ERP 内向交货单行号")
    @Column(nullable=true,length=80)
    private String dnitem_s;
    
    @Comment("ERP内向交货单号")
    @Column(nullable=true,length=80)
    private String dnno_s;
    
    @Comment("预留字段 1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留字段 2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留字段 3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("预留字段 4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("供货批号")
    @Column(nullable=true,length=80)
    private String lotno_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String matid_s;
    
    @Comment("ERP 采购订单行号")
    @Column(nullable=true,length=80)
    private String referenceitem_s;
    
    @Comment("ERP 采购订单号")
    @Column(nullable=true,length=80)
    private String referenceno_s;
    
    @Comment("出货单单号")
    @Column(nullable=true,length=80)
    private String salordid_s;
    
    @Comment("出货单行号")
    @Column(nullable=true,length=80)
    private String salorditem_s;
    
    @Comment("供应商编号")
    @Column(nullable=true,length=80)
    private String suppliercode_s;
    
    public String getDeliverydate_s(){
        return deliverydate_s;
    }
    
    @XmlElement
    public void setDeliverydate_s(String deliverydate_s){
        this.deliverydate_s=deliverydate_s;
    }
        
    public String getDeliveryqty_s(){
        return deliveryqty_s;
    }
    
    @XmlElement
    public void setDeliveryqty_s(String deliveryqty_s){
        this.deliveryqty_s=deliveryqty_s;
    }
        
    public String getDnitem_s(){
        return dnitem_s;
    }
    
    @XmlElement
    public void setDnitem_s(String dnitem_s){
        this.dnitem_s=dnitem_s;
    }
        
    public String getDnno_s(){
        return dnno_s;
    }
    
    @XmlElement
    public void setDnno_s(String dnno_s){
        this.dnno_s=dnno_s;
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
        
    public String getLotno_s(){
        return lotno_s;
    }
    
    @XmlElement
    public void setLotno_s(String lotno_s){
        this.lotno_s=lotno_s;
    }
        
    public String getMatid_s(){
        return matid_s;
    }
    
    @XmlElement
    public void setMatid_s(String matid_s){
        this.matid_s=matid_s;
    }
        
    public String getReferenceitem_s(){
        return referenceitem_s;
    }
    
    @XmlElement
    public void setReferenceitem_s(String referenceitem_s){
        this.referenceitem_s=referenceitem_s;
    }
        
    public String getReferenceno_s(){
        return referenceno_s;
    }
    
    @XmlElement
    public void setReferenceno_s(String referenceno_s){
        this.referenceno_s=referenceno_s;
    }
        
    public String getSalordid_s(){
        return salordid_s;
    }
    
    @XmlElement
    public void setSalordid_s(String salordid_s){
        this.salordid_s=salordid_s;
    }
        
    public String getSalorditem_s(){
        return salorditem_s;
    }
    
    @XmlElement
    public void setSalorditem_s(String salorditem_s){
        this.salorditem_s=salorditem_s;
    }
        
    public String getSuppliercode_s(){
        return suppliercode_s;
    }
    
    @XmlElement
    public void setSuppliercode_s(String suppliercode_s){
        this.suppliercode_s=suppliercode_s;
    }
        
    
    
    
}
