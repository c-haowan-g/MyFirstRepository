package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTransferSublotInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTransferSublotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="contributorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transformQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTransferSublotInfo", propOrder = { "contributorId",
		"partKey", "quantity", "sublotKey", "transformQuantity" })
public class DTransferSublotInfo extends DDataObject {

	protected String contributorId;
	protected long partKey;
	protected DMeasuredValue quantity;
	protected long sublotKey;
	protected DMeasuredValue transformQuantity;

	/**
	 * Gets the value of the contributorId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContributorId() {
		return contributorId;
	}

	/**
	 * Sets the value of the contributorId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContributorId(String value) {
		this.contributorId = value;
	}

	/**
	 * Gets the value of the partKey property.
	 * 
	 */
	public long getPartKey() {
		return partKey;
	}

	/**
	 * Sets the value of the partKey property.
	 * 
	 */
	public void setPartKey(long value) {
		this.partKey = value;
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

	/**
	 * Gets the value of the transformQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getTransformQuantity() {
		return transformQuantity;
	}

	/**
	 * Sets the value of the transformQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setTransformQuantity(DMeasuredValue value) {
		this.transformQuantity = value;
	}

}
