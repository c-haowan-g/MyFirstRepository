package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DProducedSublot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DProducedSublot">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="producedQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="producedSublotInfoKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DProducedSublot", propOrder = { "objectType",
		"producedQuantity", "producedSublotInfoKey", "sublotKey" })
public class DProducedSublot extends DKeyed {

	protected short objectType;
	protected DMeasuredValue producedQuantity;
	protected long producedSublotInfoKey;
	protected long sublotKey;

	/**
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the producedQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getProducedQuantity() {
		return producedQuantity;
	}

	/**
	 * Sets the value of the producedQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setProducedQuantity(DMeasuredValue value) {
		this.producedQuantity = value;
	}

	/**
	 * Gets the value of the producedSublotInfoKey property.
	 * 
	 */
	public long getProducedSublotInfoKey() {
		return producedSublotInfoKey;
	}

	/**
	 * Sets the value of the producedSublotInfoKey property.
	 * 
	 */
	public void setProducedSublotInfoKey(long value) {
		this.producedSublotInfoKey = value;
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
