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
 *发货单及发货实绩查询
 * @author 周清玉
 * @Date 2018-12-12 11:55:10
 */
@ATDefinition("INT_SAP_PlanDNHeader")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_PLANDNHEADER")
public class PlandnHeader extends RockWellBaseEntity{
    
    
	@Comment("客户编码(售达方）")
    @Column(nullable=true,length=80)
    private String customerid_s;
    
    @Comment("凭证日期")
    @Column(nullable=true,length=80)
    private String docdate_s;
    
    @Comment("预留字段true")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留字段2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留字段3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("预留字段4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("发货单号")
    @Column(nullable=true,length=80)
    private String snno_s;
    
    @Comment("退货标识（X）")
    @Column(nullable=true,length=80)
    private String srflag_s;

	public String getCustomerid_s() {
		return customerid_s;
	}

	public void setCustomerid_s(String customerid_s) {
		this.customerid_s = customerid_s;
	}

	public String getDocdate_s() {
		return docdate_s;
	}

	public void setDocdate_s(String docdate_s) {
		this.docdate_s = docdate_s;
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

	public String getSnno_s() {
		return snno_s;
	}

	public void setSnno_s(String snno_s) {
		this.snno_s = snno_s;
	}

	public String getSrflag_s() {
		return srflag_s;
	}

	public void setSrflag_s(String srflag_s) {
		this.srflag_s = srflag_s;
	}
    

    
    
}
