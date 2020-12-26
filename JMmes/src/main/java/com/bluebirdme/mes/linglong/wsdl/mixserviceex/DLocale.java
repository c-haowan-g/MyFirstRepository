package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLocale complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLocale">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="localeCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="localeLanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeVariant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLocale", propOrder = { "deletePrivilegeKey",
		"localeCountryCode", "localeKey", "localeLanguageCode",
		"localeVariant", "systemDefined", "updatePrivilegeKey" })
public class DLocale extends DCategorical {

	protected long deletePrivilegeKey;
	protected String localeCountryCode;
	protected long localeKey;
	protected String localeLanguageCode;
	protected String localeVariant;
	protected boolean systemDefined;
	protected long updatePrivilegeKey;

	/**
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
	}

	/**
	 * Gets the value of the localeCountryCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocaleCountryCode() {
		return localeCountryCode;
	}

	/**
	 * Sets the value of the localeCountryCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocaleCountryCode(String value) {
		this.localeCountryCode = value;
	}

	/**
	 * Gets the value of the localeKey property.
	 * 
	 */
	public long getLocaleKey() {
		return localeKey;
	}

	/**
	 * Sets the value of the localeKey property.
	 * 
	 */
	public void setLocaleKey(long value) {
		this.localeKey = value;
	}

	/**
	 * Gets the value of the localeLanguageCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocaleLanguageCode() {
		return localeLanguageCode;
	}

	/**
	 * Sets the value of the localeLanguageCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocaleLanguageCode(String value) {
		this.localeLanguageCode = value;
	}

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

	/**
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
	}

}
