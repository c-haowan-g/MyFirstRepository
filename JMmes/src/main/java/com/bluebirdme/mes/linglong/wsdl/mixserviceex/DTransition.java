package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTransition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTransition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nameMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTransition", propOrder = { "auditInfo", "fsmKey",
		"nameMessageId" })
public class DTransition extends DKeyed {

	protected DAuditInfo auditInfo;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	protected String nameMessageId;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the fsmKey property.
	 * 
	 */
	public long getFSMKey() {
		return fsmKey;
	}

	/**
	 * Sets the value of the fsmKey property.
	 * 
	 */
	public void setFSMKey(long value) {
		this.fsmKey = value;
	}

	/**
	 * Gets the value of the nameMessageId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameMessageId() {
		return nameMessageId;
	}

	/**
	 * Sets the value of the nameMessageId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameMessageId(String value) {
		this.nameMessageId = value;
	}

}
