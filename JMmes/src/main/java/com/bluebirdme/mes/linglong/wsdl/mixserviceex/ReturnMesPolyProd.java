package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ReturnMesPolyProd complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnMesPolyProd">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}ReturnBase">
 *       &lt;sequence>
 *         &lt;element name="LOT_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnMesPolyProd", namespace = "http://tempuri.org/", propOrder = { "lotno" })
public class ReturnMesPolyProd extends ReturnBase {

	@XmlElement(name = "LOT_NO", namespace = "http://tempuri.org/")
	protected String lotno;

	/**
	 * Gets the value of the lotno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLOTNO() {
		return lotno;
	}

	/**
	 * Sets the value of the lotno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLOTNO(String value) {
		this.lotno = value;
	}

}
