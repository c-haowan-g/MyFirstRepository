package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSourceSublotInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSourceSublotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="orderStepInputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSourceSublotInfo", propOrder = { "orderStepInputKey",
		"quantity", "sublotKey" })
public class DSourceSublotInfo extends DDataObject {

	protected long orderStepInputKey;
	protected DMeasuredValue quantity;
	protected long sublotKey;

	/**
	 * Gets the value of the orderStepInputKey property.
	 * 
	 */
	public long getOrderStepInputKey() {
		return orderStepInputKey;
	}

	/**
	 * Sets the value of the orderStepInputKey property.
	 * 
	 */
	public void setOrderStepInputKey(long value) {
		this.orderStepInputKey = value;
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
	 * Gets the value of the sublotKey property.
	 * 
	 */
	public long getSublotKey() {
		return sublotKey;
	}

	/**
	 * Sets the value of the sublotKey property.
	 * 
	 */
	public void setSublotKey(long value) {
		this.sublotKey = value;
	}

}
