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
 *         &lt;element name="MesPolyProd" type="{http://tempuri.org/}MesPolyProd" minOccurs="0"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PassWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "mesPolyProd", "userName", "passWord" })
@XmlRootElement(name = "recivePolyProdByMes", namespace = "http://tempuri.org/")
public class RecivePolyProdByMes {

	@XmlElement(name = "MesPolyProd", namespace = "http://tempuri.org/")
	protected MesPolyProd mesPolyProd;
	@XmlElement(name = "UserName", namespace = "http://tempuri.org/")
	protected String userName;
	@XmlElement(name = "PassWord", namespace = "http://tempuri.org/")
	protected String passWord;

	/**
	 * Gets the value of the mesPolyProd property.
	 * 
	 * @return possible object is {@link MesPolyProd }
	 * 
	 */
	public MesPolyProd getMesPolyProd() {
		return mesPolyProd;
	}

	/**
	 * Sets the value of the mesPolyProd property.
	 * 
	 * @param value
	 *            allowed object is {@link MesPolyProd }
	 * 
	 */
	public void setMesPolyProd(MesPolyProd value) {
		this.mesPolyProd = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
	 * Gets the value of the passWord property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * Sets the value of the passWord property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassWord(String value) {
		this.passWord = value;
	}

}
