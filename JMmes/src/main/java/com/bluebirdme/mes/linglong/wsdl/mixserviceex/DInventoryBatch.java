package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryBatch complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryBatch">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="complete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="containerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="managementStyle" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="potency" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="removedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="sublotSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="withdrawalBatchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="withdrawalSublotPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workingSublotPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DInventoryBatch", propOrder = { "complete", "containerKey",
		"containerType", "currentStates", "expirationTime", "managementStyle",
		"objectType", "partKey", "potency", "quantity", "removedTime",
		"sublotSequenceNumber", "userDefinedAttributes", "withdrawalBatchName",
		"withdrawalSublotPrefix", "workingSublotPrefix" })
public class DInventoryBatch extends DCategorical {

	protected boolean complete;
	protected long containerKey;
	protected String containerType;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected DTimestamp expirationTime;
	protected short managementStyle;
	protected short objectType;
	protected long partKey;
	protected DMeasuredValue potency;
	protected DMeasuredValue quantity;
	protected DTimestamp removedTime;
	protected int sublotSequenceNumber;
	protected DUDAInstance userDefinedAttributes;
	protected String withdrawalBatchName;
	protected String withdrawalSublotPrefix;
	protected String workingSublotPrefix;

	/**
	 * Gets the value of the complete property.
	 * 
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * Sets the value of the complete property.
	 * 
	 */
	public void setComplete(boolean value) {
		this.complete = value;
	}

	/**
	 * Gets the value of the containerKey property.
	 * 
	 */
	public long getContainerKey() {
		return containerKey;
	}

	/**
	 * Sets the value of the containerKey property.
	 * 
	 */
	public void setContainerKey(long value) {
		this.containerKey = value;
	}

	/**
	 * Gets the value of the containerType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerType() {
		return containerType;
	}

	/**
	 * Sets the value of the containerType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerType(String value) {
		this.containerType = value;
	}

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
	 * Gets the value of the expirationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExpirationTime() {
		return expirationTime;
	}

	/**
	 * Sets the value of the expirationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExpirationTime(DTimestamp value) {
		this.expirationTime = value;
	}

	/**
	 * Gets the value of the managementStyle property.
	 * 
	 */
	public short getManagementStyle() {
		return managementStyle;
	}

	/**
	 * Sets the value of the managementStyle property.
	 * 
	 */
	public void setManagementStyle(short value) {
		this.managementStyle = value;
	}

	/**
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the partKey property.
	 * 
	 */
	public long getPartKey() {
		return partKey;
	}

	/**
	 * Sets the value of the partKey property.
	 * 
	 */
	public void setPartKey(long value) {
		this.partKey = value;
	}

	/**
	 * Gets the value of the potency property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getPotency() {
		return potency;
	}

	/**
	 * Sets the value of the potency property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setPotency(DMeasuredValue value) {
		this.potency = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantity(DMeasuredValue value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the removedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getRemovedTime() {
		return removedTime;
	}

	/**
	 * Sets the value of the removedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setRemovedTime(DTimestamp value) {
		this.removedTime = value;
	}

	/**
	 * Gets the value of the sublotSequenceNumber property.
	 * 
	 */
	public int getSublotSequenceNumber() {
		return sublotSequenceNumber;
	}

	/**
	 * Sets the value of the sublotSequenceNumber property.
	 * 
	 */
	public void setSublotSequenceNumber(int value) {
		this.sublotSequenceNumber = value;
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
	 * Gets the value of the withdrawalBatchName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWithdrawalBatchName() {
		return withdrawalBatchName;
	}

	/**
	 * Sets the value of the withdrawalBatchName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWithdrawalBatchName(String value) {
		this.withdrawalBatchName = value;
	}

	/**
	 * Gets the value of the withdrawalSublotPrefix property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWithdrawalSublotPrefix() {
		return withdrawalSublotPrefix;
	}

	/**
	 * Sets the value of the withdrawalSublotPrefix property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWithdrawalSublotPrefix(String value) {
		this.withdrawalSublotPrefix = value;
	}

	/**
	 * Gets the value of the workingSublotPrefix property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkingSublotPrefix() {
		return workingSublotPrefix;
	}

	/**
	 * Sets the value of the workingSublotPrefix property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkingSublotPrefix(String value) {
		this.workingSublotPrefix = value;
	}

}
