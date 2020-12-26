package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAttributeInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAttributeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="attributeDataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="dbColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dbTableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAttributeInfo", propOrder = { "attribute",
		"attributeDataType", "dbColumnName", "dbTableName" })
public class DAttributeInfo extends DDataObject {

	protected short attribute;
	protected short attributeDataType;
	protected String dbColumnName;
	protected String dbTableName;

	/**
	 * Gets the value of the attribute property.
	 * 
	 */
	public short getAttribute() {
		return attribute;
	}

	/**
	 * Sets the value of the attribute property.
	 * 
	 */
	public void setAttribute(short value) {
		this.attribute = value;
	}

	/**
	 * Gets the value of the attributeDataType property.
	 * 
	 */
	public short getAttributeDataType() {
		return attributeDataType;
	}

	/**
	 * Sets the value of the attributeDataType property.
	 * 
	 */
	public void setAttributeDataType(short value) {
		this.attributeDataType = value;
	}

	/**
	 * Gets the value of the dbColumnName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDbColumnName() {
		return dbColumnName;
	}

	/**
	 * Sets the value of the dbColumnName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDbColumnName(String value) {
		this.dbColumnName = value;
	}

	/**
	 * Gets the value of the dbTableName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDbTableName() {
		return dbTableName;
	}

	/**
	 * Sets the value of the dbTableName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDbTableName(String value) {
		this.dbTableName = value;
	}

}
