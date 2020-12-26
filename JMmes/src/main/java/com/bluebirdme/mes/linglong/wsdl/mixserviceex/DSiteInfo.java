package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSiteInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSiteInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="siteHostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSiteInfo", propOrder = { "siteHostName", "siteId",
		"siteNumber" })
public class DSiteInfo {

	protected String siteHostName;
	protected String siteId;
	protected int siteNumber;

	/**
	 * Gets the value of the siteHostName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSiteHostName() {
		return siteHostName;
	}

	/**
	 * Sets the value of the siteHostName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSiteHostName(String value) {
		this.siteHostName = value;
	}

	/**
	 * Gets the value of the siteId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * Sets the value of the siteId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSiteId(String value) {
		this.siteId = value;
	}

	/**
	 * Gets the value of the siteNumber property.
	 * 
	 */
	public int getSiteNumber() {
		return siteNumber;
	}

	/**
	 * Sets the value of the siteNumber property.
	 * 
	 */
	public void setSiteNumber(int value) {
		this.siteNumber = value;
	}

}
