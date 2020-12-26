package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSemanticPropertyOverride complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSemanticPropertyOverride">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="overrideDataValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="semanticPropertyKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSemanticPropertyOverride", propOrder = { "dataType",
		"overrideDataValue", "parentKey", "parentType", "semanticPropertyKey" })
public class DSemanticPropertyOverride extends DKeyed {

	protected short dataType;
	protected String overrideDataValue;
	protected long parentKey;
	protected short parentType;
	protected long semanticPropertyKey;

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
	 * Gets the value of the overrideDataValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOverrideDataValue() {
		return overrideDataValue;
	}

	/**
	 * Sets the value of the overrideDataValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOverrideDataValue(String value) {
		this.overrideDataValue = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the parentType property.
	 * 
	 */
	public short getParentType() {
		return parentType;
	}

	/**
	 * Sets the value of the parentType property.
	 * 
	 */
	public void setParentType(short value) {
		this.parentType = value;
	}

	/**
	 * Gets the value of the semanticPropertyKey property.
	 * 
	 */
	public long getSemanticPropertyKey() {
		return semanticPropertyKey;
	}

	/**
	 * Sets the value of the semanticPropertyKey property.
	 * 
	 */
	public void setSemanticPropertyKey(long value) {
		this.semanticPropertyKey = value;
	}

}
