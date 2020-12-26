package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DATColumnDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DATColumnDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="nullable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="referencedKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="referencedType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="textLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATColumnDefinition", propOrder = { "dataType",
		"defaultValue", "description", "lastModifiedTime", "nullable",
		"referencedKey", "referencedType", "textLength" })
public class DATColumnDefinition extends DKeyed {

	protected short dataType;
	protected String defaultValue;
	protected String description;
	protected DTimestamp lastModifiedTime;
	protected boolean nullable;
	protected long referencedKey;
	protected short referencedType;
	protected int textLength;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public short getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(short value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the defaultValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the value of the defaultValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}

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
	 * Gets the value of the nullable property.
	 * 
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * Sets the value of the nullable property.
	 * 
	 */
	public void setNullable(boolean value) {
		this.nullable = value;
	}

	/**
	 * Gets the value of the referencedKey property.
	 * 
	 */
	public long getReferencedKey() {
		return referencedKey;
	}

	/**
	 * Sets the value of the referencedKey property.
	 * 
	 */
	public void setReferencedKey(long value) {
		this.referencedKey = value;
	}

	/**
	 * Gets the value of the referencedType property.
	 * 
	 */
	public short getReferencedType() {
		return referencedType;
	}

	/**
	 * Sets the value of the referencedType property.
	 * 
	 */
	public void setReferencedType(short value) {
		this.referencedType = value;
	}

	/**
	 * Gets the value of the textLength property.
	 * 
	 */
	public int getTextLength() {
		return textLength;
	}

	/**
	 * Sets the value of the textLength property.
	 * 
	 */
	public void setTextLength(int value) {
		this.textLength = value;
	}

}
