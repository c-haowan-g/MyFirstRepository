package com.bglhqx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * anonymous complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
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

	@XmlElementRef(name = "QueryRealDataResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<PIReturnObject> queryRealDataResult;

	/**
	 * 获取queryRealDataResult属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}
	 *         {@link PIReturnObject }{@code >}
	 * 
	 */
	public JAXBElement<PIReturnObject> getQueryRealDataResult() {
		return queryRealDataResult;
	}

	/**
	 * 设置queryRealDataResult属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}
	 *            {@link PIReturnObject }{@code >}
	 * 
	 */
	public void setQueryRealDataResult(JAXBElement<PIReturnObject> value) {
		this.queryRealDataResult = value;
	}

}
