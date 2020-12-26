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
 * 实装量HEADER 
 * @author 周清玉
 * @Date 2018-12-20 14:52:15
 */
@ATDefinition("INT_SAP_ActualAmountHeader")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_ACTUALAMOUNTHEADER")
public class ActualAmountHeader extends RockWellBaseEntity{
    
    
    @Comment("实际出库日期")
    @Column(nullable=true,length=80)
    private String deliverydate_s;
    
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
    
    @Comment("客户编码（售达方）")
    @Column(nullable=true,length=80)
    private String kunag_s;
    
    @Comment("客户名称 ")
    @Column(nullable=true,length=80)
    private String name1_s;
    
    @Comment("退货标识")
    @Column(nullable=true,length=80)
    private String srflag_s;
    
    @Comment("交货")
    @Column(nullable=true,length=80)
    private String vbeln_s;
    
    public String getDeliverydate_s(){
        return deliverydate_s;
    }
    
    @XmlElement
    public void setDeliverydate_s(String deliverydate_s){
        this.deliverydate_s=deliverydate_s;
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
        
    public String getKunag_s(){
        return kunag_s;
    }
    
    @XmlElement
    public void setKunag_s(String kunag_s){
        this.kunag_s=kunag_s;
    }
        
    public String getName1_s(){
        return name1_s;
    }
    
    @XmlElement
    public void setName1_s(String name1_s){
        this.name1_s=name1_s;
    }
        
    public String getSrflag_s(){
        return srflag_s;
    }
    
    @XmlElement
    public void setSrflag_s(String srflag_s){
        this.srflag_s=srflag_s;
    }
        
    public String getVbeln_s(){
        return vbeln_s;
    }
    
    @XmlElement
    public void setVbeln_s(String vbeln_s){
        this.vbeln_s=vbeln_s;
    }
        
    
    
    
}
