package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DReadInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DReadInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessPrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="approvingUserTicket" type="{dataobjects.common.plantops.datasweep.com}DUserTicket" minOccurs="0"/>
 *         &lt;element name="databaseQueryTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="signatureUserTicket" type="{dataobjects.common.plantops.datasweep.com}DUserTicket" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DReadInfo", propOrder = { "accessPrivilegeKey",
		"approvingUserTicket", "databaseQueryTimeout", "signatureUserTicket" })
public class DReadInfo {

	protected long accessPrivilegeKey;
	protected DUserTicket approvingUserTicket;
	protected int databaseQueryTimeout;
	protected DUserTicket signatureUserTicket;

	/**
	 * Gets the value of the accessPrivilegeKey property.
	 * 
	 */
	public long getAccessPrivilegeKey() {
		return accessPrivilegeKey;
	}

	/**
	 * Sets the value of the accessPrivilegeKey property.
	 * 
	 */
	public void setAccessPrivilegeKey(long value) {
		this.accessPrivilegeKey = value;
	}

	/**
	 * Gets the value of the approvingUserTicket property.
	 * 
	 * @return possible object is {@link DUserTicket }
	 * 
	 */
	public DUserTicket getApprovingUserTicket() {
		return approvingUserTicket;
	}

	/**
	 * Sets the value of the approvingUserTicket property.
	 * 
	 * @param value
	 *            allowed object is {@link DUserTicket }
	 * 
	 */
	public void setApprovingUserTicket(DUserTicket value) {
		this.approvingUserTicket = value;
	}

	/**
	 * Gets the value of the databaseQueryTimeout property.
	 * 
	 */
	public int getDatabaseQueryTimeout() {
		return databaseQueryTimeout;
	}

	/**
	 * Sets the value of the databaseQueryTimeout property.
	 * 
	 */
	public void setDatabaseQueryTimeout(int value) {
		this.databaseQueryTimeout = value;
	}

	/**
	 * Gets the value of the signatureUserTicket property.
	 * 
	 * @return possible object is {@link DUserTicket }
	 * 
	 */
	public DUserTicket getSignatureUserTicket() {
		return signatureUserTicket;
	}

	/**
	 * Sets the value of the signatureUserTicket property.
	 * 
	 * @param value
	 *            allowed object is {@link DUserTicket }
	 * 
	 */
	public void setSignatureUserTicket(DUserTicket value) {
		this.signatureUserTicket = value;
	}

}
