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
 *         &lt;element name="recivePolyProdByMesResult" type="{http://tempuri.org/}ReturnMesPolyProd" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "recivePolyProdByMesResult" })
@XmlRootElement(name = "recivePolyProdByMesResponse", namespace = "http://tempuri.org/")
public class RecivePolyProdByMesResponse {

	@XmlElement(namespace = "http://tempuri.org/")
	protected ReturnMesPolyProd recivePolyProdByMesResult;

	/**
	 * Gets the value of the recivePolyProdByMesResult property.
	 * 
	 * @return possible object is {@link ReturnMesPolyProd }
	 * 
	 */
	public ReturnMesPolyProd getRecivePolyProdByMesResult() {
		return recivePolyProdByMesResult;
	}

	/**
	 * Sets the value of the recivePolyProdByMesResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ReturnMesPolyProd }
	 * 
	 */
	public void setRecivePolyProdByMesResult(ReturnMesPolyProd value) {
		this.recivePolyProdByMesResult = value;
	}

}
