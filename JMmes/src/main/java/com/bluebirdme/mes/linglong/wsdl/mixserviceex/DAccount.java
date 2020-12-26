package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAccount complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="contactAddresses" type="{dataobjects.common.plantops.datasweep.com}DContactAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastYearRevenue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="numberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAccount", propOrder = { "contactAddresses",
		"deletePrivilegeKey", "id", "lastYearRevenue", "numberOfEmployees",
		"sicCode", "status", "updatePrivilegeKey", "userDefinedAttributes" })
public class DAccount extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DContactAddress> contactAddresses;
	protected long deletePrivilegeKey;
	protected String id;
	protected double lastYearRevenue;
	protected int numberOfEmployees;
	protected String sicCode;
	protected String status;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the contactAddresses property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the contactAddresses property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getContactAddresses().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DContactAddress }
	 * 
	 * 
	 */
	public List<DContactAddress> getContactAddresses() {
		if (contactAddresses == null) {
			contactAddresses = new ArrayList<DContactAddress>();
		}
		return this.contactAddresses;
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
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the lastYearRevenue property.
	 * 
	 */
	public double getLastYearRevenue() {
		return lastYearRevenue;
	}

	/**
	 * Sets the value of the lastYearRevenue property.
	 * 
	 */
	public void setLastYearRevenue(double value) {
		this.lastYearRevenue = value;
	}

	/**
	 * Gets the value of the numberOfEmployees property.
	 * 
	 */
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	/**
	 * Sets the value of the numberOfEmployees property.
	 * 
	 */
	public void setNumberOfEmployees(int value) {
		this.numberOfEmployees = value;
	}

	/**
	 * Gets the value of the sicCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSicCode() {
		return sicCode;
	}

	/**
	 * Sets the value of the sicCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSicCode(String value) {
		this.sicCode = value;
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

}
