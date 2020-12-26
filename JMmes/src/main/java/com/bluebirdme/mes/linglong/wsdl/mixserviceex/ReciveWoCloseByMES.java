package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wo_No" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="close_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="close_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "user", "password", "woNo", "closeBy",
		"closeName" })
@XmlRootElement(name = "reciveWoCloseByMES", namespace = "http://tempuri.org/")
public class ReciveWoCloseByMES {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String user;
	@XmlElement(namespace = "http://tempuri.org/")
	protected String password;
	@XmlElement(name = "wo_No", namespace = "http://tempuri.org/")
	protected String woNo;
	@XmlElement(name = "close_By", namespace = "http://tempuri.org/")
	protected String closeBy;
	@XmlElement(name = "close_Name", namespace = "http://tempuri.org/")
	protected String closeName;

	/**
	 * Gets the value of the user property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the value of the user property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUser(String value) {
		this.user = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the woNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWoNo() {
		return woNo;
	}

	/**
	 * Sets the value of the woNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWoNo(String value) {
		this.woNo = value;
	}

	/**
	 * Gets the value of the closeBy property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCloseBy() {
		return closeBy;
	}

	/**
	 * Sets the value of the closeBy property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCloseBy(String value) {
		this.closeBy = value;
	}

	/**
	 * Gets the value of the closeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCloseName() {
		return closeName;
	}

	/**
	 * Sets the value of the closeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCloseName(String value) {
		this.closeName = value;
	}

}
