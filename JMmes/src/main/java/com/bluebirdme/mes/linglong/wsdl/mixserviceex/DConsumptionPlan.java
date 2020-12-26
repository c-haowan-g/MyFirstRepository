package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConsumptionPlan complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConsumptionPlan">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractConsumptionPlan">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="temp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConsumptionPlan", propOrder = { "auditInfo", "temp" })
public class DConsumptionPlan extends DAbstractConsumptionPlan {

	protected DAuditInfo auditInfo;
	protected int temp;

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
	 * Gets the value of the temp property.
	 * 
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Sets the value of the temp property.
	 * 
	 */
	public void setTemp(int value) {
		this.temp = value;
	}

}
