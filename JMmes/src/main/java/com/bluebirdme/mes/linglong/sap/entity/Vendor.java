/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity;

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
 * 供应商信息表
 * @author 周清玉
 * @Date 2018-09-25 10:28:55
 */
@ATDefinition("INT_SAP_VENDOR")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_VENDOR")
public class Vendor extends RockWellBaseEntity{
    
    
    @Comment("通信地址")
    @Column(nullable=true,length=200)
    private String address1_s;
    
    @Comment("采购员编号")
    @Column(nullable=true,length=80)
    private String buyerid_s;
    
    @Comment("采购员名")
    @Column(nullable=true,length=80)
    private String buyername_s;
    
    @Comment("创建日期")
    @Column(nullable=true,length=80)
    private String cdate_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=80)
    private String ctime_s;
    
    @Comment("公司代码")
    @Column(nullable=true,length=80)
    private String companycode_s;
    
    @Comment("联络人")
    @Column(nullable=true,length=80)
    private String contactor_s;
    
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
    
    @Comment("Email")
    @Column(nullable=true,length=80)
    private String email_s;
    
    @Comment("传真")
    @Column(nullable=true,length=80)
    private String fax_s;
    
    @Comment("通信邮编")
    @Column(nullable=true,length=80)
    private String postalcode_s;
    
    @Comment("采购组织")
    @Column(nullable=true,length=80)
    private String pur_org_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String remark_s;
    
    @Comment("供应商删除状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("供应商编号")
    @Column(nullable=true,length=80)
    private String suppliercode_s;
    
    @Comment("供应商全称")
    @Column(nullable=true,length=200)
    private String suppliername_s;
    
    @Comment("供应商简称")
    @Column(nullable=true,length=80)
    private String suppliernick_s;
    
    @Comment("供应商全称英文")
    @Column(nullable=true,length=200)
    private String supplier_name_en_s;
    
    @Comment("供应商全称泰文")
    @Column(nullable=true,length=200)
    private String supplier_name_th_s;
    
    @Comment("供应商简称英文")
    @Column(nullable=true,length=200)
    private String supplier_nick_en_s;
    
    @Comment("供应商简称泰文")
    @Column(nullable=true,length=200)
    private String supplier_nick_th_s;
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date synchronous_time_t;
    
    @Comment("税号")
    @Column(nullable=true,length=80)
    private String taxid_s;
    
    @Comment("联系电话")
    @Column(nullable=true,length=80)
    private String tel1_s;
    
    @Comment("最后修改日期")
    @Column(nullable=true,length=80)
    private String udate_s;
    
    @Comment("最后修改时间")
    @Column(nullable=true,length=80)
    private String utime_s;
    
    public String getAddress1_s(){
        return address1_s;
    }
    
    @XmlElement
    public void setAddress1_s(String address1_s){
        this.address1_s=address1_s;
    }
        
    public String getBuyerid_s(){
        return buyerid_s;
    }
    
    @XmlElement
    public void setBuyerid_s(String buyerid_s){
        this.buyerid_s=buyerid_s;
    }
        
    public String getBuyername_s(){
        return buyername_s;
    }
    
    @XmlElement
    public void setBuyername_s(String buyername_s){
        this.buyername_s=buyername_s;
    }
        
    public String getCdate_s(){
        return cdate_s;
    }
    
    @XmlElement
    public void setCdate_s(String cdate_s){
        this.cdate_s=cdate_s;
    }
        
    public String getCtime_s(){
        return ctime_s;
    }
    
    @XmlElement
    public void setCtime_s(String ctime_s){
        this.ctime_s=ctime_s;
    }
        
    public String getCompanycode_s(){
        return companycode_s;
    }
    
    @XmlElement
    public void setCompanycode_s(String companycode_s){
        this.companycode_s=companycode_s;
    }
        
    public String getContactor_s(){
        return contactor_s;
    }
    
    @XmlElement
    public void setContactor_s(String contactor_s){
        this.contactor_s=contactor_s;
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
        
    public String getEmail_s(){
        return email_s;
    }
    
    @XmlElement
    public void setEmail_s(String email_s){
        this.email_s=email_s;
    }
        
    public String getFax_s(){
        return fax_s;
    }
    
    @XmlElement
    public void setFax_s(String fax_s){
        this.fax_s=fax_s;
    }
        
    public String getPostalcode_s(){
        return postalcode_s;
    }
    
    @XmlElement
    public void setPostalcode_s(String postalcode_s){
        this.postalcode_s=postalcode_s;
    }
        
    public String getPur_org_s(){
        return pur_org_s;
    }
    
    @XmlElement
    public void setPur_org_s(String pur_org_s){
        this.pur_org_s=pur_org_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getSuppliercode_s(){
        return suppliercode_s;
    }
    
    @XmlElement
    public void setSuppliercode_s(String suppliercode_s){
        this.suppliercode_s=suppliercode_s;
    }
        
    public String getSuppliername_s(){
        return suppliername_s;
    }
    
    @XmlElement
    public void setSuppliername_s(String suppliername_s){
        this.suppliername_s=suppliername_s;
    }
        
    public String getSuppliernick_s(){
        return suppliernick_s;
    }
    
    @XmlElement
    public void setSuppliernick_s(String suppliernick_s){
        this.suppliernick_s=suppliernick_s;
    }
        
    public String getSupplier_name_en_s(){
        return supplier_name_en_s;
    }
    
    @XmlElement
    public void setSupplier_name_en_s(String supplier_name_en_s){
        this.supplier_name_en_s=supplier_name_en_s;
    }
        
    public String getSupplier_name_th_s(){
        return supplier_name_th_s;
    }
    
    @XmlElement
    public void setSupplier_name_th_s(String supplier_name_th_s){
        this.supplier_name_th_s=supplier_name_th_s;
    }
        
    public String getSupplier_nick_en_s(){
        return supplier_nick_en_s;
    }
    
    @XmlElement
    public void setSupplier_nick_en_s(String supplier_nick_en_s){
        this.supplier_nick_en_s=supplier_nick_en_s;
    }
        
    public String getSupplier_nick_th_s(){
        return supplier_nick_th_s;
    }
    
    @XmlElement
    public void setSupplier_nick_th_s(String supplier_nick_th_s){
        this.supplier_nick_th_s=supplier_nick_th_s;
    }
        
    public Date getSynchronous_time_t(){
        return synchronous_time_t;
    }
    
    @XmlElement
    public void setSynchronous_time_t(Date synchronous_time_t){
        this.synchronous_time_t=synchronous_time_t;
    }
        
    public String getTaxid_s(){
        return taxid_s;
    }
    
    @XmlElement
    public void setTaxid_s(String taxid_s){
        this.taxid_s=taxid_s;
    }
        
    public String getTel1_s(){
        return tel1_s;
    }
    
    @XmlElement
    public void setTel1_s(String tel1_s){
        this.tel1_s=tel1_s;
    }
        
    public String getUdate_s(){
        return udate_s;
    }
    
    @XmlElement
    public void setUdate_s(String udate_s){
        this.udate_s=udate_s;
    }
        
    public String getUtime_s(){
        return utime_s;
    }
    
    @XmlElement
    public void setUtime_s(String utime_s){
        this.utime_s=utime_s;
    }
        
    
    
    
}
