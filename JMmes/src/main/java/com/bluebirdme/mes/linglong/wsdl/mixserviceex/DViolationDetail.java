package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DViolationDetail complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DViolationDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fatalErrorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="presentValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requiredValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versioningViolationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="violatingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DViolationDetail", propOrder = { "dataType", "fatalErrorId",
		"objectKey", "objectType", "presentValue", "requiredValue",
		"versioningViolationKey", "violatingId" })
public class DViolationDetail extends DDataObject {

	protected int dataType;
	protected int fatalErrorId;
	protected long objectKey;
	protected short objectType;
	protected String presentValue;
	protected String requiredValue;
	protected long versioningViolationKey;
	protected int violatingId;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public int getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(int value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the fatalErrorId property.
	 * 
	 */
	public int getFatalErrorId() {
		return fatalErrorId;
	}

	/**
	 * Sets the value of the fatalErrorId property.
	 * 
	 */
	public void setFatalErrorId(int value) {
		this.fatalErrorId = value;
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
	 * Gets the value of the presentValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPresentValue() {
		return presentValue;
	}

	/**
	 * Sets the value of the presentValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPresentValue(String value) {
		this.presentValue = value;
	}

	/**
	 * Gets the value of the requiredValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequiredValue() {
		return requiredValue;
	}

	/**
	 * Sets the value of the requiredValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequiredValue(String value) {
		this.requiredValue = value;
	}

	/**
	 * Gets the value of the versioningViolationKey property.
	 * 
	 */
	public long getVersioningViolationKey() {
		return versioningViolationKey;
	}

	/**
	 * Sets the value of the versioningViolationKey property.
	 * 
	 */
	public void setVersioningViolationKey(long value) {
		this.versioningViolationKey = value;
	}

	/**
	 * Gets the value of the violatingId property.
	 * 
	 */
	public int getViolatingId() {
		return violatingId;
	}

	/**
	 * Sets the value of the violatingId property.
	 * 
	 */
	public void setViolatingId(int value) {
		this.violatingId = value;
	}

}
