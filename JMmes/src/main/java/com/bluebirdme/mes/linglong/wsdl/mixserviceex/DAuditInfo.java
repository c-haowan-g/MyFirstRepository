package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAuditInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAuditInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="auditTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="auditTrxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAuditInfo", propOrder = { "auditTime", "auditTrxId" })
public class DAuditInfo extends DDataObject {

	protected DTimestamp auditTime;
	protected String auditTrxId;

	/**
	 * Gets the value of the auditTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getAuditTime() {
		return auditTime;
	}

	/**
	 * Sets the value of the auditTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setAuditTime(DTimestamp value) {
		this.auditTime = value;
	}

	/**
	 * Gets the value of the auditTrxId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuditTrxId() {
		return auditTrxId;
	}

	/**
	 * Sets the value of the auditTrxId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAuditTrxId(String value) {
		this.auditTrxId = value;
	}

}
