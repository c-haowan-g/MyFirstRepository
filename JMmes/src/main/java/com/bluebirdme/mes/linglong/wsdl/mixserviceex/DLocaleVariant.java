package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLocaleVariant complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLocaleVariant">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="localeVariant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLocaleVariant", propOrder = { "localeVariant",
		"systemDefined" })
public class DLocaleVariant extends DKeyed {

	protected String localeVariant;
	protected boolean systemDefined;

	/**
	 * Gets the value of the localeVariant property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocaleVariant() {
		return localeVariant;
	}

	/**
	 * Sets the value of the localeVariant property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocaleVariant(String value) {
		this.localeVariant = value;
	}

	/**
	 * Gets the value of the systemDefined property.
	 * 
	 */
	public boolean isSystemDefined() {
		return systemDefined;
	}

	/**
	 * Sets the value of the systemDefined property.
	 * 
	 */
	public void setSystemDefined(boolean value) {
		this.systemDefined = value;
	}

}
