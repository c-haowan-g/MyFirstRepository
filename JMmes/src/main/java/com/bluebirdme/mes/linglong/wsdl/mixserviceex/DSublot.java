package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSublot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSublot">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="batchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="batchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="carrierKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="containerEntryTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="containerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="initialQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="joinedEndTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="joinedStartTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="loadedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="loadedTimeLong" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="logicallyEmpty" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logicallyEmptyQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="potency" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="quantityConsumed" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="quantityScrappedConsumed" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotStorageHistoryKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="workingSublot" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSublot", propOrder = { "batchKey", "batchType", "carrierKey",
		"containerEntryTime", "containerKey", "containerType", "currentStates",
		"expirationTime", "initialQuantity", "joinedEndTime",
		"joinedStartTime", "loadedTime", "loadedTimeLong", "logicallyEmpty",
		"logicallyEmptyQuantity", "potency", "quantity", "quantityConsumed",
		"quantityScrappedConsumed", "sublotStorageHistoryKey",
		"userDefinedAttributes", "workingSublot" })
public class DSublot extends DCategorical {

	protected long batchKey;
	protected short batchType;
	protected long carrierKey;
	protected DTimestamp containerEntryTime;
	protected long containerKey;
	protected String containerType;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected DTimestamp expirationTime;
	protected DMeasuredValue initialQuantity;
	protected DTimestamp joinedEndTime;
	protected DTimestamp joinedStartTime;
	protected DTimestamp loadedTime;
	protected long loadedTimeLong;
	protected boolean logicallyEmpty;
	protected DMeasuredValue logicallyEmptyQuantity;
	protected DMeasuredValue potency;
	protected DMeasuredValue quantity;
	protected DMeasuredValue quantityConsumed;
	protected DMeasuredValue quantityScrappedConsumed;
	protected long sublotStorageHistoryKey;
	protected DUDAInstance userDefinedAttributes;
	protected boolean workingSublot;

	/**
	 * Gets the value of the batchKey property.
	 * 
	 */
	public long getBatchKey() {
		return batchKey;
	}

	/**
	 * Sets the value of the batchKey property.
	 * 
	 */
	public void setBatchKey(long value) {
		this.batchKey = value;
	}

	/**
	 * Gets the value of the batchType property.
	 * 
	 */
	public short getBatchType() {
		return batchType;
	}

	/**
	 * Sets the value of the batchType property.
	 * 
	 */
	public void setBatchType(short value) {
		this.batchType = value;
	}

	/**
	 * Gets the value of the carrierKey property.
	 * 
	 */
	public long getCarrierKey() {
		return carrierKey;
	}

	/**
	 * Sets the value of the carrierKey property.
	 * 
	 */
	public void setCarrierKey(long value) {
		this.carrierKey = value;
	}

	/**
	 * Gets the value of the containerEntryTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getContainerEntryTime() {
		return containerEntryTime;
	}

	/**
	 * Sets the value of the containerEntryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setContainerEntryTime(DTimestamp value) {
		this.containerEntryTime = value;
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
	 * Gets the value of the initialQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getInitialQuantity() {
		return initialQuantity;
	}

	/**
	 * Sets the value of the initialQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setInitialQuantity(DMeasuredValue value) {
		this.initialQuantity = value;
	}

	/**
	 * Gets the value of the joinedEndTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getJoinedEndTime() {
		return joinedEndTime;
	}

	/**
	 * Sets the value of the joinedEndTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setJoinedEndTime(DTimestamp value) {
		this.joinedEndTime = value;
	}

	/**
	 * Gets the value of the joinedStartTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getJoinedStartTime() {
		return joinedStartTime;
	}

	/**
	 * Sets the value of the joinedStartTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setJoinedStartTime(DTimestamp value) {
		this.joinedStartTime = value;
	}

	/**
	 * Gets the value of the loadedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLoadedTime() {
		return loadedTime;
	}

	/**
	 * Sets the value of the loadedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLoadedTime(DTimestamp value) {
		this.loadedTime = value;
	}

	/**
	 * Gets the value of the loadedTimeLong property.
	 * 
	 */
	public long getLoadedTimeLong() {
		return loadedTimeLong;
	}

	/**
	 * Sets the value of the loadedTimeLong property.
	 * 
	 */
	public void setLoadedTimeLong(long value) {
		this.loadedTimeLong = value;
	}

	/**
	 * Gets the value of the logicallyEmpty property.
	 * 
	 */
	public boolean isLogicallyEmpty() {
		return logicallyEmpty;
	}

	/**
	 * Sets the value of the logicallyEmpty property.
	 * 
	 */
	public void setLogicallyEmpty(boolean value) {
		this.logicallyEmpty = value;
	}

	/**
	 * Gets the value of the logicallyEmptyQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getLogicallyEmptyQuantity() {
		return logicallyEmptyQuantity;
	}

	/**
	 * Sets the value of the logicallyEmptyQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setLogicallyEmptyQuantity(DMeasuredValue value) {
		this.logicallyEmptyQuantity = value;
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
	 * Gets the value of the quantityConsumed property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantityConsumed() {
		return quantityConsumed;
	}

	/**
	 * Sets the value of the quantityConsumed property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantityConsumed(DMeasuredValue value) {
		this.quantityConsumed = value;
	}

	/**
	 * Gets the value of the quantityScrappedConsumed property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantityScrappedConsumed() {
		return quantityScrappedConsumed;
	}

	/**
	 * Sets the value of the quantityScrappedConsumed property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantityScrappedConsumed(DMeasuredValue value) {
		this.quantityScrappedConsumed = value;
	}

	/**
	 * Gets the value of the sublotStorageHistoryKey property.
	 * 
	 */
	public long getSublotStorageHistoryKey() {
		return sublotStorageHistoryKey;
	}

	/**
	 * Sets the value of the sublotStorageHistoryKey property.
	 * 
	 */
	public void setSublotStorageHistoryKey(long value) {
		this.sublotStorageHistoryKey = value;
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
	 * Gets the value of the workingSublot property.
	 * 
	 */
	public boolean isWorkingSublot() {
		return workingSublot;
	}

	/**
	 * Sets the value of the workingSublot property.
	 * 
	 */
	public void setWorkingSublot(boolean value) {
		this.workingSublot = value;
	}

}
