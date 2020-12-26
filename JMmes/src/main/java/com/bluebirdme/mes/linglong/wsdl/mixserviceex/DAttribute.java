package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAttribute complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="attributeIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAttribute", propOrder = { "attribute", "attributeIdentifier" })
public class DAttribute {

	protected short attribute;
	protected String attributeIdentifier;

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
	 * Gets the value of the attributeIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAttributeIdentifier() {
		return attributeIdentifier;
	}

	/**
	 * Sets the value of the attributeIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAttributeIdentifier(String value) {
		this.attributeIdentifier = value;
	}

}
