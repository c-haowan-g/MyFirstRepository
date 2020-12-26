package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUserGroupUser complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUserGroupUser">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="groupKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUserGroupUser", propOrder = { "groupKey", "role", "userKey" })
public class DUserGroupUser extends DCategorical {

	protected long groupKey;
	protected String role;
	protected long userKey;

	/**
	 * Gets the value of the groupKey property.
	 * 
	 */
	public long getGroupKey() {
		return groupKey;
	}

	/**
	 * Sets the value of the groupKey property.
	 * 
	 */
	public void setGroupKey(long value) {
		this.groupKey = value;
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
	 * Gets the value of the userKey property.
	 * 
	 */
	public long getUserKey() {
		return userKey;
	}

	/**
	 * Sets the value of the userKey property.
	 * 
	 */
	public void setUserKey(long value) {
		this.userKey = value;
	}

}
