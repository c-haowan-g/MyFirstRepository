package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUser complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUser">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="failedLoginAttemptCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="initialFormKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noteKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passwordChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="passwordDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="passwordExpiration" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="passwordHistory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passwordModifiable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="securityMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityRealm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusChangeTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="statusChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="userExpiration" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="userGroupUsers" type="{dataobjects.common.plantops.datasweep.com}DUserGroupUser" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userGroupUsersChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUser", propOrder = { "currentStates", "deletePrivilegeKey",
		"email", "failedLoginAttemptCount", "firstName", "initialFormKey",
		"lastName", "loginCount", "note", "noteKey", "password",
		"passwordChanged", "passwordDuration", "passwordExpiration",
		"passwordHistory", "passwordModifiable", "securityMask",
		"securityRealm", "shiftKey", "status", "statusChangeTime",
		"statusChanged", "transactionId", "updatePrivilegeKey",
		"userDefinedAttributes", "userExpiration", "userGroupUsers",
		"userGroupUsersChanged" })
public class DUser extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected String email;
	protected int failedLoginAttemptCount;
	protected String firstName;
	protected long initialFormKey;
	protected String lastName;
	protected int loginCount;
	protected String note;
	protected long noteKey;
	protected String password;
	protected boolean passwordChanged;
	protected int passwordDuration;
	protected DTimestamp passwordExpiration;
	protected String passwordHistory;
	protected boolean passwordModifiable;
	protected String securityMask;
	protected String securityRealm;
	protected long shiftKey;
	protected String status;
	protected DTimestamp statusChangeTime;
	protected boolean statusChanged;
	protected String transactionId;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	protected DTimestamp userExpiration;
	@XmlElement(nillable = true)
	protected List<DUserGroupUser> userGroupUsers;
	protected boolean userGroupUsersChanged;

	/**
	 * Gets the value of the currentStates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the currentStates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCurrentStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DObjectState }
	 * 
	 * 
	 */
	public List<DObjectState> getCurrentStates() {
		if (currentStates == null) {
			currentStates = new ArrayList<DObjectState>();
		}
		return this.currentStates;
	}

	/**
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the failedLoginAttemptCount property.
	 * 
	 */
	public int getFailedLoginAttemptCount() {
		return failedLoginAttemptCount;
	}

	/**
	 * Sets the value of the failedLoginAttemptCount property.
	 * 
	 */
	public void setFailedLoginAttemptCount(int value) {
		this.failedLoginAttemptCount = value;
	}

	/**
	 * Gets the value of the firstName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of the firstName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * Gets the value of the initialFormKey property.
	 * 
	 */
	public long getInitialFormKey() {
		return initialFormKey;
	}

	/**
	 * Sets the value of the initialFormKey property.
	 * 
	 */
	public void setInitialFormKey(long value) {
		this.initialFormKey = value;
	}

	/**
	 * Gets the value of the lastName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the value of the lastName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastName(String value) {
		this.lastName = value;
	}

	/**
	 * Gets the value of the loginCount property.
	 * 
	 */
	public int getLoginCount() {
		return loginCount;
	}

	/**
	 * Sets the value of the loginCount property.
	 * 
	 */
	public void setLoginCount(int value) {
		this.loginCount = value;
	}

	/**
	 * Gets the value of the note property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the value of the note property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNote(String value) {
		this.note = value;
	}

	/**
	 * Gets the value of the noteKey property.
	 * 
	 */
	public long getNoteKey() {
		return noteKey;
	}

	/**
	 * Sets the value of the noteKey property.
	 * 
	 */
	public void setNoteKey(long value) {
		this.noteKey = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the passwordChanged property.
	 * 
	 */
	public boolean isPasswordChanged() {
		return passwordChanged;
	}

	/**
	 * Sets the value of the passwordChanged property.
	 * 
	 */
	public void setPasswordChanged(boolean value) {
		this.passwordChanged = value;
	}

	/**
	 * Gets the value of the passwordDuration property.
	 * 
	 */
	public int getPasswordDuration() {
		return passwordDuration;
	}

	/**
	 * Sets the value of the passwordDuration property.
	 * 
	 */
	public void setPasswordDuration(int value) {
		this.passwordDuration = value;
	}

	/**
	 * Gets the value of the passwordExpiration property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getPasswordExpiration() {
		return passwordExpiration;
	}

	/**
	 * Sets the value of the passwordExpiration property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setPasswordExpiration(DTimestamp value) {
		this.passwordExpiration = value;
	}

	/**
	 * Gets the value of the passwordHistory property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPasswordHistory() {
		return passwordHistory;
	}

	/**
	 * Sets the value of the passwordHistory property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPasswordHistory(String value) {
		this.passwordHistory = value;
	}

	/**
	 * Gets the value of the passwordModifiable property.
	 * 
	 */
	public boolean isPasswordModifiable() {
		return passwordModifiable;
	}

	/**
	 * Sets the value of the passwordModifiable property.
	 * 
	 */
	public void setPasswordModifiable(boolean value) {
		this.passwordModifiable = value;
	}

	/**
	 * Gets the value of the securityMask property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSecurityMask() {
		return securityMask;
	}

	/**
	 * Sets the value of the securityMask property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSecurityMask(String value) {
		this.securityMask = value;
	}

	/**
	 * Gets the value of the securityRealm property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSecurityRealm() {
		return securityRealm;
	}

	/**
	 * Sets the value of the securityRealm property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSecurityRealm(String value) {
		this.securityRealm = value;
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
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Gets the value of the statusChangeTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getStatusChangeTime() {
		return statusChangeTime;
	}

	/**
	 * Sets the value of the statusChangeTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setStatusChangeTime(DTimestamp value) {
		this.statusChangeTime = value;
	}

	/**
	 * Gets the value of the statusChanged property.
	 * 
	 */
	public boolean isStatusChanged() {
		return statusChanged;
	}

	/**
	 * Sets the value of the statusChanged property.
	 * 
	 */
	public void setStatusChanged(boolean value) {
		this.statusChanged = value;
	}

	/**
	 * Gets the value of the transactionId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the value of the transactionId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
	}

	/**
	 * Gets the value of the userDefinedAttributes property.
	 * 
	 * @return possible object is {@link DUDAInstance }
	 * 
	 */
	public DUDAInstance getUserDefinedAttributes() {
		return userDefinedAttributes;
	}

	/**
	 * Sets the value of the userDefinedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUDAInstance }
	 * 
	 */
	public void setUserDefinedAttributes(DUDAInstance value) {
		this.userDefinedAttributes = value;
	}

	/**
	 * Gets the value of the userExpiration property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getUserExpiration() {
		return userExpiration;
	}

	/**
	 * Sets the value of the userExpiration property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setUserExpiration(DTimestamp value) {
		this.userExpiration = value;
	}

	/**
	 * Gets the value of the userGroupUsers property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the userGroupUsers property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getUserGroupUsers().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DUserGroupUser }
	 * 
	 * 
	 */
	public List<DUserGroupUser> getUserGroupUsers() {
		if (userGroupUsers == null) {
			userGroupUsers = new ArrayList<DUserGroupUser>();
		}
		return this.userGroupUsers;
	}

	/**
	 * Gets the value of the userGroupUsersChanged property.
	 * 
	 */
	public boolean isUserGroupUsersChanged() {
		return userGroupUsersChanged;
	}

	/**
	 * Sets the value of the userGroupUsersChanged property.
	 * 
	 */
	public void setUserGroupUsersChanged(boolean value) {
		this.userGroupUsersChanged = value;
	}

}
