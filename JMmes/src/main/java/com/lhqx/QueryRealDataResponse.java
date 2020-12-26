package com.lhqx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="QueryRealDataResult" type="{http://schemas.datacontract.org/2004/07/PISdkDemo}PIReturnObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "queryRealDataResult" })
@XmlRootElement(name = "QueryRealDataResponse")
public class QueryRealDataResponse {

	@XmlElementRef(name = "QueryRealDataResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
	protected JAXBElement<PIReturnObject> queryRealDataResult;

	/**
	 * Gets the value of the queryRealDataResult property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}
	 *         {@link PIReturnObject }{@code >}
	 * 
	 */
	public JAXBElement<PIReturnObject> getQueryRealDataResult() {
		return queryRealDataResult;
	}

	/**
	 * Sets the value of the queryRealDataResult property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}
	 *            {@link PIReturnObject }{@code >}
	 * 
	 */
	public void setQueryRealDataResult(JAXBElement<PIReturnObject> value) {
		this.queryRealDataResult = ((JAXBElement<PIReturnObject>) value);
	}

}
