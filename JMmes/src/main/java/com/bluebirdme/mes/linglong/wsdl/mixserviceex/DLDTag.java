package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLDTag complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLDTag">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="tagDefinition" type="{dataobjects.common.plantops.datasweep.com}DLDTagDefinition" minOccurs="0"/>
 *         &lt;element name="tagPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tagSetDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tagSetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLDTag", propOrder = { "lastModifiedTime", "tagDefinition",
		"tagPath", "tagSetDefinitionKey", "tagSetKey" })
public class DLDTag extends DKeyed {

	protected DTimestamp lastModifiedTime;
	protected DLDTagDefinition tagDefinition;
	protected String tagPath;
	protected long tagSetDefinitionKey;
	protected long tagSetKey;

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the tagDefinition property.
	 * 
	 * @return possible object is {@link DLDTagDefinition }
	 * 
	 */
	public DLDTagDefinition getTagDefinition() {
		return tagDefinition;
	}

	/**
	 * Sets the value of the tagDefinition property.
	 * 
	 * @param value
	 *            allowed object is {@link DLDTagDefinition }
	 * 
	 */
	public void setTagDefinition(DLDTagDefinition value) {
		this.tagDefinition = value;
	}

	/**
	 * Gets the value of the tagPath property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTagPath() {
		return tagPath;
	}

	/**
	 * Sets the value of the tagPath property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTagPath(String value) {
		this.tagPath = value;
	}

	/**
	 * Gets the value of the tagSetDefinitionKey property.
	 * 
	 */
	public long getTagSetDefinitionKey() {
		return tagSetDefinitionKey;
	}

	/**
	 * Sets the value of the tagSetDefinitionKey property.
	 * 
	 */
	public void setTagSetDefinitionKey(long value) {
		this.tagSetDefinitionKey = value;
	}

	/**
	 * Gets the value of the tagSetKey property.
	 * 
	 */
	public long getTagSetKey() {
		return tagSetKey;
	}

	/**
	 * Sets the value of the tagSetKey property.
	 * 
	 */
	public void setTagSetKey(long value) {
		this.tagSetKey = value;
	}

}
