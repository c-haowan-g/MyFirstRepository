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
 *         &lt;element name="machineid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="point" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "machineid", "point", "fromtime", "endtime" })
@XmlRootElement(name = "QueryRealData1")
public class QueryRealData1 {

	@XmlElementRef(name = "machineid", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> machineid;
	@XmlElementRef(name = "point", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> point;
	@XmlElementRef(name = "fromtime", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> fromtime;
	@XmlElementRef(name = "endtime", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
	protected JAXBElement<String> endtime;

	/**
	 * 获取machineid属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getMachineid() {
		return machineid;
	}

	/**
	 * 设置machineid属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setMachineid(JAXBElement<String> value) {
		this.machineid = value;
	}

	/**
	 * 获取point属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getPoint() {
		return point;
	}

	/**
	 * 设置point属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setPoint(JAXBElement<String> value) {
		this.point = value;
	}

	/**
	 * 获取fromtime属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getFromtime() {
		return fromtime;
	}

	/**
	 * 设置fromtime属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setFromtime(JAXBElement<String> value) {
		this.fromtime = value;
	}

	/**
	 * 获取endtime属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getEndtime() {
		return endtime;
	}

	/**
	 * 设置endtime属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setEndtime(JAXBElement<String> value) {
		this.endtime = value;
	}

}
