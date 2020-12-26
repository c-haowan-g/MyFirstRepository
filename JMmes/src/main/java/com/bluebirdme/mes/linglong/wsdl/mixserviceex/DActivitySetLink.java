package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DActivitySetLink complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DActivitySetLink">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="fromGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DActivitySetLink", propOrder = { "fromGuid", "toGuid",
		"userDefinedAttributes" })
public class DActivitySetLink extends DKeyed {

	protected String fromGuid;
	protected String toGuid;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the fromGuid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFromGuid() {
		return fromGuid;
	}

	/**
	 * Sets the value of the fromGuid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFromGuid(String value) {
		this.fromGuid = value;
	}

	/**
	 * Gets the value of the toGuid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToGuid() {
		return toGuid;
	}

	/**
	 * Sets the value of the toGuid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToGuid(String value) {
		this.toGuid = value;
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
