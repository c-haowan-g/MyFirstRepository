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
 *         &lt;element name="reciveSiloMaterialSendByMESResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reciveSiloMaterialSendByMESResult" })
@XmlRootElement(name = "reciveSiloMaterialSendByMESResponse", namespace = "http://tempuri.org/")
public class ReciveSiloMaterialSendByMESResponse {

	@XmlElement(namespace = "http://tempuri.org/")
	protected String reciveSiloMaterialSendByMESResult;

	/**
	 * Gets the value of the reciveSiloMaterialSendByMESResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReciveSiloMaterialSendByMESResult() {
		return reciveSiloMaterialSendByMESResult;
	}

	/**
	 * Sets the value of the reciveSiloMaterialSendByMESResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReciveSiloMaterialSendByMESResult(String value) {
		this.reciveSiloMaterialSendByMESResult = value;
	}

}
