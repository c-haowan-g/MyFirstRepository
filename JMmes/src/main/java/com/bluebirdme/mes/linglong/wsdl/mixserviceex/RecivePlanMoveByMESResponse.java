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
 *         &lt;element name="recivePlanMoveByMESResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "recivePlanMoveByMESResult" })
@XmlRootElement(name = "recivePlanMoveByMESResponse", namespace = "http://tempuri.org/")
public class RecivePlanMoveByMESResponse {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String recivePlanMoveByMESResult;

	/**
	 * Gets the value of the recivePlanMoveByMESResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRecivePlanMoveByMESResult() {
		return recivePlanMoveByMESResult;
	}

	/**
	 * Sets the value of the recivePlanMoveByMESResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRecivePlanMoveByMESResult(String value) {
		this.recivePlanMoveByMESResult = value;
	}

}
