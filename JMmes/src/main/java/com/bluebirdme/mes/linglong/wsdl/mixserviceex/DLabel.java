package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLabel complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLabel">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="labelDesignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelDesignRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reprintCounter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="scrapped" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLabel", propOrder = { "description", "guid", "labelData",
		"labelDesignName", "labelDesignRevision", "objectKey", "objectType",
		"reprintCounter", "scrapped", "userDefinedAttributes" })
public class DLabel extends DKeyed {

	protected String description;
	protected String guid;
	protected byte[] labelData;
	protected String labelDesignName;
	protected String labelDesignRevision;
	protected long objectKey;
	protected String objectType;
	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer reprintCounter;
	@XmlElement(required = true, type = Boolean.class, nillable = true)
	protected Boolean scrapped;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the guid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the value of the guid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGuid(String value) {
		this.guid = value;
	}

	/**
	 * Gets the value of the labelData property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getLabelData() {
		return labelData;
	}

	/**
	 * Sets the value of the labelData property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setLabelData(byte[] value) {
		this.labelData = ((byte[]) value);
	}

	/**
	 * Gets the value of the labelDesignName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelDesignName() {
		return labelDesignName;
	}

	/**
	 * Sets the value of the labelDesignName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelDesignName(String value) {
		this.labelDesignName = value;
	}

	/**
	 * Gets the value of the labelDesignRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelDesignRevision() {
		return labelDesignRevision;
	}

	/**
	 * Sets the value of the labelDesignRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelDesignRevision(String value) {
		this.labelDesignRevision = value;
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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectType(String value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the reprintCounter property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getReprintCounter() {
		return reprintCounter;
	}

	/**
	 * Sets the value of the reprintCounter property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setReprintCounter(Integer value) {
		this.reprintCounter = value;
	}

	/**
	 * Gets the value of the scrapped property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isScrapped() {
		return scrapped;
	}

	/**
	 * Sets the value of the scrapped property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setScrapped(Boolean value) {
		this.scrapped = value;
	}

	/**
	 * Gets the value of the userDefinedAttributes property.
	 * 
	 * @return possible object is {@link DUDAInstance }
	 * 
	 */
	public DUDAInstance getUserDefinedAttributes() {
		return userDefinedAttributes;
	}

	/**
	 * Sets the value of the userDefinedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUDAInstance }
	 * 
	 */
	public void setUserDefinedAttributes(DUDAInstance value) {
		this.userDefinedAttributes = value;
	}

}
