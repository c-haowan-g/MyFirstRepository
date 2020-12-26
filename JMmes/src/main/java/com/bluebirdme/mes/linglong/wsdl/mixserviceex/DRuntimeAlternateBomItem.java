package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRuntimeAlternateBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeAlternateBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractAlternateBomItem">
 *       &lt;sequence>
 *         &lt;element name="partAssociationType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRuntimeAlternateBomItem", propOrder = {
		"partAssociationType", "partKey", "trackedObjectKey",
		"trackedObjectType" })
public class DRuntimeAlternateBomItem extends DAbstractAlternateBomItem {

	protected short partAssociationType;
	protected long partKey;
	protected long trackedObjectKey;
	protected String trackedObjectType;

	/**
	 * Gets the value of the partAssociationType property.
	 * 
	 */
	public short getPartAssociationType() {
		return partAssociationType;
	}

	/**
	 * Sets the value of the partAssociationType property.
	 * 
	 */
	public void setPartAssociationType(short value) {
		this.partAssociationType = value;
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
	 * Gets the value of the trackedObjectKey property.
	 * 
	 */
	public long getTrackedObjectKey() {
		return trackedObjectKey;
	}

	/**
	 * Sets the value of the trackedObjectKey property.
	 * 
	 */
	public void setTrackedObjectKey(long value) {
		this.trackedObjectKey = value;
	}

	/**
	 * Gets the value of the trackedObjectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrackedObjectType() {
		return trackedObjectType;
	}

	/**
	 * Sets the value of the trackedObjectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrackedObjectType(String value) {
		this.trackedObjectType = value;
	}

}
