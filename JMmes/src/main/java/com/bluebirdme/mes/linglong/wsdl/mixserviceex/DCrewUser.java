package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DCrewUser complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DCrewUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentUser" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticket" type="{dataobjects.common.plantops.datasweep.com}DUserTicket" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DCrewUser", propOrder = { "currentUser", "role", "ticket" })
public class DCrewUser {

	protected boolean currentUser;
	protected String role;
	protected DUserTicket ticket;

	/**
	 * Gets the value of the currentUser property.
	 * 
	 */
	public boolean isCurrentUser() {
		return currentUser;
	}

	/**
	 * Sets the value of the currentUser property.
	 * 
	 */
	public void setCurrentUser(boolean value) {
		this.currentUser = value;
	}

	/**
	 * Gets the value of the role property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the value of the role property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRole(String value) {
		this.role = value;
	}

	/**
	 * Gets the value of the ticket property.
	 * 
	 * @return possible object is {@link DUserTicket }
	 * 
	 */
	public DUserTicket getTicket() {
		return ticket;
	}

	/**
	 * Sets the value of the ticket property.
	 * 
	 * @param value
	 *            allowed object is {@link DUserTicket }
	 * 
	 */
	public void setTicket(DUserTicket value) {
		this.ticket = value;
	}

}
