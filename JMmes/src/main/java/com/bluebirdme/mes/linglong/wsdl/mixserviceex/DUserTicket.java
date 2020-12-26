package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserTicket complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trxTicket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUserTicket", propOrder = { "ticket", "trxTicket" })
public class DUserTicket {

	protected String ticket;
	protected String trxTicket;

	/**
	 * Gets the value of the ticket property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * Sets the value of the ticket property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTicket(String value) {
		this.ticket = value;
	}

	/**
	 * Gets the value of the trxTicket property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrxTicket() {
		return trxTicket;
	}

	/**
	 * Sets the value of the trxTicket property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrxTicket(String value) {
		this.trxTicket = value;
	}

}
