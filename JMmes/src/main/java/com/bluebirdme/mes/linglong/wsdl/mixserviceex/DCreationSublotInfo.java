package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DCreationSublotInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DCreationSublotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="carrierKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="containerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DCreationSublotInfo", propOrder = { "carrierKey",
		"containerKey", "containerType", "expirationTime", "quantity",
		"sublotName" })
public class DCreationSublotInfo extends DDataObject {

	protected long carrierKey;
	protected long containerKey;
	protected short containerType;
	protected DTimestamp expirationTime;
	protected DMeasuredValue quantity;
	protected String sublotName;

	/**
	 * Gets the value of the carrierKey property.
	 * 
	 */
	public long getCarrierKey() {
		return carrierKey;
	}

	/**
	 * Sets the value of the carrierKey property.
	 * 
	 */
	public void setCarrierKey(long value) {
		this.carrierKey = value;
	}

	/**
	 * Gets the value of the containerKey property.
	 * 
	 */
	public long getContainerKey() {
		return containerKey;
	}

	/**
	 * Sets the value of the containerKey property.
	 * 
	 */
	public void setContainerKey(long value) {
		this.containerKey = value;
	}

	/**
	 * Gets the value of the containerType property.
	 * 
	 */
	public short getContainerType() {
		return containerType;
	}

	/**
	 * Sets the value of the containerType property.
	 * 
	 */
	public void setContainerType(short value) {
		this.containerType = value;
	}

	/**
	 * Gets the value of the expirationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExpirationTime() {
		return expirationTime;
	}

	/**
	 * Sets the value of the expirationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExpirationTime(DTimestamp value) {
		this.expirationTime = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantity(DMeasuredValue value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the sublotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSublotName() {
		return sublotName;
	}

	/**
	 * Sets the value of the sublotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSublotName(String value) {
		this.sublotName = value;
	}

}
