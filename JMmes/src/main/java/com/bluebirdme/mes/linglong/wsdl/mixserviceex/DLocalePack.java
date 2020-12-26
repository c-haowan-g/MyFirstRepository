package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLocalePack complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLocalePack">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="displayFontName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayFontSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="localeCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="localeLanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localeVariantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{dataobjects.common.plantops.datasweep.com}DLocaleMessage" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "DLocalePack", propOrder = { "displayFontName",
		"displayFontSize", "localeCountryCode", "localeKey",
		"localeLanguageCode", "localeVariantCode", "messages", "systemDefined" })
public class DLocalePack extends DKeyed {

	protected String displayFontName;
	protected int displayFontSize;
	protected String localeCountryCode;
	protected long localeKey;
	protected String localeLanguageCode;
	protected String localeVariantCode;
	@XmlElement(nillable = true)
	protected List<DLocaleMessage> messages;
	protected boolean systemDefined;

	/**
	 * Gets the value of the displayFontName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisplayFontName() {
		return displayFontName;
	}

	/**
	 * Sets the value of the displayFontName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisplayFontName(String value) {
		this.displayFontName = value;
	}

	/**
	 * Gets the value of the displayFontSize property.
	 * 
	 */
	public int getDisplayFontSize() {
		return displayFontSize;
	}

	/**
	 * Sets the value of the displayFontSize property.
	 * 
	 */
	public void setDisplayFontSize(int value) {
		this.displayFontSize = value;
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
	 * Gets the value of the localeVariantCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocaleVariantCode() {
		return localeVariantCode;
	}

	/**
	 * Sets the value of the localeVariantCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocaleVariantCode(String value) {
		this.localeVariantCode = value;
	}

	/**
	 * Gets the value of the messages property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the messages property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMessages().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DLocaleMessage }
	 * 
	 * 
	 */
	public List<DLocaleMessage> getMessages() {
		if (messages == null) {
			messages = new ArrayList<DLocaleMessage>();
		}
		return this.messages;
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
