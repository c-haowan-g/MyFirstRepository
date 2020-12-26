package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStateProxyMember complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStateProxyMember">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="associationStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="atDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="endTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="stateProxyKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStateProxyMember", propOrder = { "associationStatus",
		"atDefinitionKey", "endTime", "error", "objectKey", "objectType",
		"startTime", "stateProxyKey" })
public class DStateProxyMember extends DKeyed {

	protected int associationStatus;
	protected long atDefinitionKey;
	protected DTimestamp endTime;
	protected String error;
	protected long objectKey;
	protected short objectType;
	protected DTimestamp startTime;
	protected long stateProxyKey;

	/**
	 * Gets the value of the associationStatus property.
	 * 
	 */
	public int getAssociationStatus() {
		return associationStatus;
	}

	/**
	 * Sets the value of the associationStatus property.
	 * 
	 */
	public void setAssociationStatus(int value) {
		this.associationStatus = value;
	}

	/**
	 * Gets the value of the atDefinitionKey property.
	 * 
	 */
	public long getAtDefinitionKey() {
		return atDefinitionKey;
	}

	/**
	 * Sets the value of the atDefinitionKey property.
	 * 
	 */
	public void setAtDefinitionKey(long value) {
		this.atDefinitionKey = value;
	}

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEndTime() {
		return endTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEndTime(DTimestamp value) {
		this.endTime = value;
	}

	/**
	 * Gets the value of the error property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the value of the error property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setError(String value) {
		this.error = value;
	}

	/**
	 * Gets the value of the objectKey property.
	 * 
	 */
	public long getObjectKey() {
		return objectKey;
	}

	/**
	 * Sets the value of the objectKey property.
	 * 
	 */
	public void setObjectKey(long value) {
		this.objectKey = value;
	}

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
	 * Gets the value of the startTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getStartTime() {
		return startTime;
	}

	/**
	 * Sets the value of the startTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setStartTime(DTimestamp value) {
		this.startTime = value;
	}

	/**
	 * Gets the value of the stateProxyKey property.
	 * 
	 */
	public long getStateProxyKey() {
		return stateProxyKey;
	}

	/**
	 * Sets the value of the stateProxyKey property.
	 * 
	 */
	public void setStateProxyKey(long value) {
		this.stateProxyKey = value;
	}

}
