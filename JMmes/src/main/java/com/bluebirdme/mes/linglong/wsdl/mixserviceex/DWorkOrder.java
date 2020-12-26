package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkOrder">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="closeType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="closedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enteredTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="finishedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderItems" type="{dataobjects.common.plantops.datasweep.com}DWorkOrderItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promisedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shippedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="shippingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="userAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DWorkOrder", propOrder = { "address1", "address2",
		"addressName", "addressState", "billAccountKey", "buildAccountKey",
		"city", "closeType", "closedTime", "comment", "contactPerson",
		"contactPhone", "customer", "emailAddress", "enteredTime",
		"finishedTime", "note", "orderItems", "orderState", "promisedTime",
		"shipAccountKey", "shippedTime", "shippingMethod", "startTime",
		"state", "status", "userAccountKey", "userDefinedAttributes",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey", "zipCode" })
public class DWorkOrder extends DCategorical {

	protected String address1;
	protected String address2;
	protected String addressName;
	protected String addressState;
	protected long billAccountKey;
	protected long buildAccountKey;
	protected String city;
	protected short closeType;
	protected DTimestamp closedTime;
	protected String comment;
	protected String contactPerson;
	protected String contactPhone;
	protected String customer;
	protected String emailAddress;
	protected DTimestamp enteredTime;
	protected DTimestamp finishedTime;
	protected String note;
	@XmlElement(nillable = true)
	protected List<DWorkOrderItem> orderItems;
	protected String orderState;
	protected DTimestamp promisedTime;
	protected long shipAccountKey;
	protected DTimestamp shippedTime;
	protected String shippingMethod;
	protected DTimestamp startTime;
	protected short state;
	protected short status;
	protected long userAccountKey;
	protected DUDAInstance userDefinedAttributes;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;
	protected String zipCode;

	/**
	 * Gets the value of the address1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the value of the address1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress1(String value) {
		this.address1 = value;
	}

	/**
	 * Gets the value of the address2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the value of the address2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress2(String value) {
		this.address2 = value;
	}

	/**
	 * Gets the value of the addressName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressName() {
		return addressName;
	}

	/**
	 * Sets the value of the addressName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddressName(String value) {
		this.addressName = value;
	}

	/**
	 * Gets the value of the addressState property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressState() {
		return addressState;
	}

	/**
	 * Sets the value of the addressState property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddressState(String value) {
		this.addressState = value;
	}

	/**
	 * Gets the value of the billAccountKey property.
	 * 
	 */
	public long getBillAccountKey() {
		return billAccountKey;
	}

	/**
	 * Sets the value of the billAccountKey property.
	 * 
	 */
	public void setBillAccountKey(long value) {
		this.billAccountKey = value;
	}

	/**
	 * Gets the value of the buildAccountKey property.
	 * 
	 */
	public long getBuildAccountKey() {
		return buildAccountKey;
	}

	/**
	 * Sets the value of the buildAccountKey property.
	 * 
	 */
	public void setBuildAccountKey(long value) {
		this.buildAccountKey = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCity(String value) {
		this.city = value;
	}

	/**
	 * Gets the value of the closeType property.
	 * 
	 */
	public short getCloseType() {
		return closeType;
	}

	/**
	 * Sets the value of the closeType property.
	 * 
	 */
	public void setCloseType(short value) {
		this.closeType = value;
	}

	/**
	 * Gets the value of the closedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getClosedTime() {
		return closedTime;
	}

	/**
	 * Sets the value of the closedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setClosedTime(DTimestamp value) {
		this.closedTime = value;
	}

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
	}

	/**
	 * Gets the value of the contactPerson property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * Sets the value of the contactPerson property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContactPerson(String value) {
		this.contactPerson = value;
	}

	/**
	 * Gets the value of the contactPhone property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * Sets the value of the contactPhone property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContactPhone(String value) {
		this.contactPhone = value;
	}

	/**
	 * Gets the value of the customer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Sets the value of the customer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomer(String value) {
		this.customer = value;
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
	 * Gets the value of the enteredTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEnteredTime() {
		return enteredTime;
	}

	/**
	 * Sets the value of the enteredTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEnteredTime(DTimestamp value) {
		this.enteredTime = value;
	}

	/**
	 * Gets the value of the finishedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getFinishedTime() {
		return finishedTime;
	}

	/**
	 * Sets the value of the finishedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setFinishedTime(DTimestamp value) {
		this.finishedTime = value;
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
	 * Gets the value of the orderItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DWorkOrderItem }
	 * 
	 * 
	 */
	public List<DWorkOrderItem> getOrderItems() {
		if (orderItems == null) {
			orderItems = new ArrayList<DWorkOrderItem>();
		}
		return this.orderItems;
	}

	/**
	 * Gets the value of the orderState property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderState() {
		return orderState;
	}

	/**
	 * Sets the value of the orderState property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderState(String value) {
		this.orderState = value;
	}

	/**
	 * Gets the value of the promisedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getPromisedTime() {
		return promisedTime;
	}

	/**
	 * Sets the value of the promisedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setPromisedTime(DTimestamp value) {
		this.promisedTime = value;
	}

	/**
	 * Gets the value of the shipAccountKey property.
	 * 
	 */
	public long getShipAccountKey() {
		return shipAccountKey;
	}

	/**
	 * Sets the value of the shipAccountKey property.
	 * 
	 */
	public void setShipAccountKey(long value) {
		this.shipAccountKey = value;
	}

	/**
	 * Gets the value of the shippedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getShippedTime() {
		return shippedTime;
	}

	/**
	 * Sets the value of the shippedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setShippedTime(DTimestamp value) {
		this.shippedTime = value;
	}

	/**
	 * Gets the value of the shippingMethod property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * Sets the value of the shippingMethod property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShippingMethod(String value) {
		this.shippingMethod = value;
	}

	/**
	 * Gets the value of the startTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getStartTime() {
		return startTime;
	}

	/**
	 * Sets the value of the startTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setStartTime(DTimestamp value) {
		this.startTime = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 */
	public short getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 */
	public void setState(short value) {
		this.state = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 */
	public void setStatus(short value) {
		this.status = value;
	}

	/**
	 * Gets the value of the userAccountKey property.
	 * 
	 */
	public long getUserAccountKey() {
		return userAccountKey;
	}

	/**
	 * Sets the value of the userAccountKey property.
	 * 
	 */
	public void setUserAccountKey(long value) {
		this.userAccountKey = value;
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
	 * Gets the value of the workInstructionKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workInstructionKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkInstructionKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getWorkInstructionKeys() {
		if (workInstructionKeys == null) {
			workInstructionKeys = new ArrayList<Long>();
		}
		return this.workInstructionKeys;
	}

	/**
	 * Gets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public boolean isWorkInstructionKeysChanged() {
		return workInstructionKeysChanged;
	}

	/**
	 * Sets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public void setWorkInstructionKeysChanged(boolean value) {
		this.workInstructionKeysChanged = value;
	}

	/**
	 * Gets the value of the workInstructionListKey property.
	 * 
	 */
	public long getWorkInstructionListKey() {
		return workInstructionListKey;
	}

	/**
	 * Sets the value of the workInstructionListKey property.
	 * 
	 */
	public void setWorkInstructionListKey(long value) {
		this.workInstructionListKey = value;
	}

	/**
	 * Gets the value of the zipCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the value of the zipCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setZipCode(String value) {
		this.zipCode = value;
	}

}
