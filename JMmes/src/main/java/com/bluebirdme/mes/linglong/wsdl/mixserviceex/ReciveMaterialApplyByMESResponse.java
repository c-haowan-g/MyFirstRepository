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
 *         &lt;element name="reciveMaterialApplyByMESResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reciveMaterialApplyByMESResult" })
@XmlRootElement(name = "reciveMaterialApplyByMESResponse", namespace = "http://tempuri.org/")
public class ReciveMaterialApplyByMESResponse {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String reciveMaterialApplyByMESResult;

	/**
	 * Gets the value of the reciveMaterialApplyByMESResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReciveMaterialApplyByMESResult() {
		return reciveMaterialApplyByMESResult;
	}

	/**
	 * Sets the value of the reciveMaterialApplyByMESResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReciveMaterialApplyByMESResult(String value) {
		this.reciveMaterialApplyByMESResult = value;
	}

}
