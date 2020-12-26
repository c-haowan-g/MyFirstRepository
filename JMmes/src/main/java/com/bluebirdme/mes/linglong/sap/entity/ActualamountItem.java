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
 * 实装量ITEM 
 * @author 周清玉
 * @Date 2018-12-12 13:13:46
 */
@ATDefinition("INT_SAP_ActualAmountItem")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_ACTUALAMOUNTITEM")
public class ActualamountItem extends RockWellBaseEntity{

    @Comment("实装批次")
    @Column(nullable=true,length=80)
    private String batch_s;
    
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
    
    @Comment("关联字段")
    @Column(nullable=true,length=0)
    private String headerid_64;
    
    @Comment("物料号")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=80)
    private String plant_s;
    
    @Comment("交货项目")
    @Column(nullable=true,length=80)
    private String posnr_s;
    
    @Comment("发货数量")
    @Column(nullable=true,length=0)
    private String qty_s;
    
    @Comment("库位")
    @Column(nullable=true,length=80)
    private String storageloc_s;

	public String getBatch_s() {
		return batch_s;
	}

	public void setBatch_s(String batch_s) {
		this.batch_s = batch_s;
	}

	public String getDummy1_s() {
		return dummy1_s;
	}

	public void setDummy1_s(String dummy1_s) {
		this.dummy1_s = dummy1_s;
	}

	public String getDummy2_s() {
		return dummy2_s;
	}

	public void setDummy2_s(String dummy2_s) {
		this.dummy2_s = dummy2_s;
	}

	public String getDummy3_s() {
		return dummy3_s;
	}

	public void setDummy3_s(String dummy3_s) {
		this.dummy3_s = dummy3_s;
	}

	public String getDummy4_s() {
		return dummy4_s;
	}

	public void setDummy4_s(String dummy4_s) {
		this.dummy4_s = dummy4_s;
	}

	public String getHeaderid_64() {
		return headerid_64;
	}

	public void setHeaderid_64(String headerid_64) {
		this.headerid_64 = headerid_64;
	}

	public String getMaterialcode_s() {
		return materialcode_s;
	}

	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}

	public String getPlant_s() {
		return plant_s;
	}

	public void setPlant_s(String plant_s) {
		this.plant_s = plant_s;
	}

	public String getPosnr_s() {
		return posnr_s;
	}

	public void setPosnr_s(String posnr_s) {
		this.posnr_s = posnr_s;
	}


	public String getQty_s() {
		return qty_s;
	}

	public void setQty_s(String qty_s) {
		this.qty_s = qty_s;
	}

	public String getStorageloc_s() {
		return storageloc_s;
	}

	public void setStorageloc_s(String storageloc_s) {
		this.storageloc_s = storageloc_s;
	}
    
    
    
}
