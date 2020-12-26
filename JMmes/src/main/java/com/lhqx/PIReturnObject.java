package com.lhqx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PIReturnObject complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="PIReturnObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r_retcode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="r_retmsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="r_pidata" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfanyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PIReturnObject", namespace = "http://schemas.datacontract.org/2004/07/PISdkDemo", propOrder = {
		"rRetcode", "rRetmsg", "rPidata" })
public class PIReturnObject {

	@XmlElement(name = "r_retcode")
	protected int rRetcode;
	@XmlElementRef(name = "r_retmsg", namespace = "http://schemas.datacontract.org/2004/07/PISdkDemo", type = JAXBElement.class)
	protected JAXBElement<String> rRetmsg;
	@XmlElement(name = "r_pidata", required = true, nillable = true)
	protected ArrayOfanyType rPidata;

	/**
	 * Gets the value of the rRetcode property.
	 * 
	 */
	public int getRRetcode() {
		return rRetcode;
	}

	/**
	 * Sets the value of the rRetcode property.
	 * 
	 */
	public void setRRetcode(int value) {
		this.rRetcode = value;
	}

	/**
	 * Gets the value of the rRetmsg property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getRRetmsg() {
		return rRetmsg;
	}

	/**
	 * Sets the value of the rRetmsg property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setRRetmsg(JAXBElement<String> value) {
		this.rRetmsg = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the rPidata property.
	 * 
	 * @return possible object is {@link ArrayOfanyType }
	 * 
	 */
	public ArrayOfanyType getRPidata() {
		return rPidata;
	}

	/**
	 * Sets the value of the rPidata property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfanyType }
	 * 
	 */
	public void setRPidata(ArrayOfanyType value) {
		this.rPidata = value;
	}

}
