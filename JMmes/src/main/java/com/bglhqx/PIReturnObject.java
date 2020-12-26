package com.bglhqx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * PIReturnObject complex type的 Java 类。
 * 
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
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
	@XmlElementRef(name = "r_retmsg", namespace = "http://schemas.datacontract.org/2004/07/PISdkDemo", type = JAXBElement.class, required = false)
	protected JAXBElement<String> rRetmsg;
	@XmlElement(name = "r_pidata", required = true, nillable = true)
	protected ArrayOfanyType rPidata;

	/**
	 * 获取rRetcode属性的值。
	 * 
	 */
	public int getRRetcode() {
		return rRetcode;
	}

	/**
	 * 设置rRetcode属性的值。
	 * 
	 */
	public void setRRetcode(int value) {
		this.rRetcode = value;
	}

	/**
	 * 获取rRetmsg属性的值。
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getRRetmsg() {
		return rRetmsg;
	}

	/**
	 * 设置rRetmsg属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setRRetmsg(JAXBElement<String> value) {
		this.rRetmsg = value;
	}

	/**
	 * 获取rPidata属性的值。
	 * 
	 * @return possible object is {@link ArrayOfanyType }
	 * 
	 */
	public ArrayOfanyType getRPidata() {
		return rPidata;
	}

	/**
	 * 设置rPidata属性的值。
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfanyType }
	 * 
	 */
	public void setRPidata(ArrayOfanyType value) {
		this.rPidata = value;
	}

}
