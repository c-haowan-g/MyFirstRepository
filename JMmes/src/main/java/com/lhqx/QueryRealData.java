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
@XmlRootElement(name = "QueryRealData")
public class QueryRealData {

	@XmlElementRef(name = "machineid", namespace = "http://tempuri.org/", type = JAXBElement.class)
	protected JAXBElement<String> machineid;
	@XmlElementRef(name = "point", namespace = "http://tempuri.org/", type = JAXBElement.class)
	protected JAXBElement<String> point;
	@XmlElementRef(name = "fromtime", namespace = "http://tempuri.org/", type = JAXBElement.class)
	protected JAXBElement<String> fromtime;
	@XmlElementRef(name = "endtime", namespace = "http://tempuri.org/", type = JAXBElement.class)
	protected JAXBElement<String> endtime;

	/**
	 * Gets the value of the machineid property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getMachineid() {
		return machineid;
	}

	/**
	 * Sets the value of the machineid property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setMachineid(JAXBElement<String> value) {
		this.machineid = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the point property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getPoint() {
		return point;
	}

	/**
	 * Sets the value of the point property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setPoint(JAXBElement<String> value) {
		this.point = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the fromtime property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getFromtime() {
		return fromtime;
	}

	/**
	 * Sets the value of the fromtime property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setFromtime(JAXBElement<String> value) {
		this.fromtime = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the endtime property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getEndtime() {
		return endtime;
	}

	/**
	 * Sets the value of the endtime property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setEndtime(JAXBElement<String> value) {
		this.endtime = ((JAXBElement<String>) value);
	}

}
