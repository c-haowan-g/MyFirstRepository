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
 *         &lt;element name="reciveMixerMasterByMESResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reciveMixerMasterByMESResult" })
@XmlRootElement(name = "reciveMixerMasterByMESResponse", namespace = "http://tempuri.org/")
public class ReciveMixerMasterByMESResponse {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String reciveMixerMasterByMESResult;

	/**
	 * Gets the value of the reciveMixerMasterByMESResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReciveMixerMasterByMESResult() {
		return reciveMixerMasterByMESResult;
	}

	/**
	 * Sets the value of the reciveMixerMasterByMESResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReciveMixerMasterByMESResult(String value) {
		this.reciveMixerMasterByMESResult = value;
	}

}
