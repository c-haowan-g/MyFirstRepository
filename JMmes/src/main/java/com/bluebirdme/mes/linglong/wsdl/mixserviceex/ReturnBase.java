package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ReturnBase complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnBase", namespace = "http://tempuri.org/", propOrder = {
		"errorCode", "errorMessage" })
public class ReturnBase {

	@XmlElement(name = "ErrorCode", namespace = "http://tempuri.org/")
	protected String errorCode;
	@XmlElement(name = "ErrorMessage", namespace = "http://tempuri.org/")
	protected String errorMessage;

	/**
	 * Gets the value of the errorCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the value of the errorCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorCode(String value) {
		this.errorCode = value;
	}

	/**
	 * Gets the value of the errorMessage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the value of the errorMessage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorMessage(String value) {
		this.errorMessage = value;
	}

}
