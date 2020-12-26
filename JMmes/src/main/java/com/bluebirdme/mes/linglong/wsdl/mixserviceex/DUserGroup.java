package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserGroup complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
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
@XmlType(name = "DUserGroup", propOrder = { "currentStates",
		"deletePrivilegeKey", "displayName", "emailAddress", "shiftKey",
		"updatePrivilegeKey", "userDefinedAttributes", "userGroupUsers",
		"userGroupUsersChanged" })
public class DUserGroup extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected String displayName;
	protected String emailAddress;
	protected long shiftKey;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
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
	 * Gets the value of the displayName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the value of the displayName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * Gets the value of the emailAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the value of the emailAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmailAddress(String value) {
		this.emailAddress = value;
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
