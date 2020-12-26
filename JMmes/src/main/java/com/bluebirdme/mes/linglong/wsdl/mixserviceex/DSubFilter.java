package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSubFilter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSubFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DFilter">
 *       &lt;sequence>
 *         &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="attributeIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSubFilter", propOrder = { "attribute", "attributeIdentifier" })
public class DSubFilter extends DFilter {

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
