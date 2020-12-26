package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTrxInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTrxInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessPrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="approvingUserRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvingUserTicket" type="{dataobjects.common.plantops.datasweep.com}DUserTicket" minOccurs="0"/>
 *         &lt;element name="crewTicket" type="{dataobjects.common.plantops.datasweep.com}DCrewTicket" minOccurs="0"/>
 *         &lt;element name="overrideSemanticPropertyAccessPrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DTrxInfo", propOrder = { "accessPrivilegeKey",
		"approvingUserRole", "approvingUserTicket", "crewTicket",
		"overrideSemanticPropertyAccessPrivilegeKey", "shiftKey",
		"signatureUserTicket" })
public class DTrxInfo {

	protected long accessPrivilegeKey;
	protected String approvingUserRole;
	protected DUserTicket approvingUserTicket;
	protected DCrewTicket crewTicket;
	protected long overrideSemanticPropertyAccessPrivilegeKey;
	protected long shiftKey;
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
	 * Gets the value of the approvingUserRole property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getApprovingUserRole() {
		return approvingUserRole;
	}

	/**
	 * Sets the value of the approvingUserRole property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApprovingUserRole(String value) {
		this.approvingUserRole = value;
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
	 * Gets the value of the crewTicket property.
	 * 
	 * @return possible object is {@link DCrewTicket }
	 * 
	 */
	public DCrewTicket getCrewTicket() {
		return crewTicket;
	}

	/**
	 * Sets the value of the crewTicket property.
	 * 
	 * @param value
	 *            allowed object is {@link DCrewTicket }
	 * 
	 */
	public void setCrewTicket(DCrewTicket value) {
		this.crewTicket = value;
	}

	/**
	 * Gets the value of the overrideSemanticPropertyAccessPrivilegeKey
	 * property.
	 * 
	 */
	public long getOverrideSemanticPropertyAccessPrivilegeKey() {
		return overrideSemanticPropertyAccessPrivilegeKey;
	}

	/**
	 * Sets the value of the overrideSemanticPropertyAccessPrivilegeKey
	 * property.
	 * 
	 */
	public void setOverrideSemanticPropertyAccessPrivilegeKey(long value) {
		this.overrideSemanticPropertyAccessPrivilegeKey = value;
	}

	/**
	 * Gets the value of the shiftKey property.
	 * 
	 */
	public long getShiftKey() {
		return shiftKey;
	}

	/**
	 * Sets the value of the shiftKey property.
	 * 
	 */
	public void setShiftKey(long value) {
		this.shiftKey = value;
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
