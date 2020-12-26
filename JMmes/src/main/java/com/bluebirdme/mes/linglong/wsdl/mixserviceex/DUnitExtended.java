package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUnitExtended complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUnitExtended">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="finishedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="inventoryStatus" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="lastModifierKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lifeCycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldLifecycle" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="onHandStatus" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalParentSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="originalParentUnitKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="originalSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="originalUnitKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="preserializedLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="preserializedLotSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="previousNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousNodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="promisedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="revivedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reworkCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reworkFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shippedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="siteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supplierAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUnitExtended", propOrder = { "billAccountKey",
		"buildAccountKey", "comment", "creationTime", "description",
		"expirationTime", "finishedTime", "inventoryStatus",
		"lastModifiedTime", "lastModifierKey", "lifeCycle", "note",
		"oldLifecycle", "onHandStatus", "orderItem",
		"originalParentSiteNumber", "originalParentUnitKey",
		"originalSiteNumber", "originalUnitKey", "ownerAccountKey",
		"preserializedLotKey", "preserializedLotSiteNumber",
		"previousNodeName", "previousNodeType", "priority", "promisedTime",
		"revivedCount", "reworkCount", "reworkFlag", "shipAccountKey",
		"shippedTime", "siteNumber", "supplierAccountKey", "userAccountKey",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey" })
public class DUnitExtended extends DDataObject {

	protected long billAccountKey;
	protected long buildAccountKey;
	protected String comment;
	protected DTimestamp creationTime;
	protected String description;
	protected DTimestamp expirationTime;
	protected DTimestamp finishedTime;
	protected short inventoryStatus;
	protected DTimestamp lastModifiedTime;
	protected long lastModifierKey;
	protected String lifeCycle;
	protected String note;
	protected short oldLifecycle;
	protected short onHandStatus;
	protected String orderItem;
	protected int originalParentSiteNumber;
	protected long originalParentUnitKey;
	protected int originalSiteNumber;
	protected long originalUnitKey;
	protected long ownerAccountKey;
	protected long preserializedLotKey;
	protected int preserializedLotSiteNumber;
	protected String previousNodeName;
	protected String previousNodeType;
	protected int priority;
	protected DTimestamp promisedTime;
	protected int revivedCount;
	protected int reworkCount;
	protected boolean reworkFlag;
	protected long shipAccountKey;
	protected DTimestamp shippedTime;
	protected int siteNumber;
	protected long supplierAccountKey;
	protected long userAccountKey;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

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
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
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
	 * Gets the value of the inventoryStatus property.
	 * 
	 */
	public short getInventoryStatus() {
		return inventoryStatus;
	}

	/**
	 * Sets the value of the inventoryStatus property.
	 * 
	 */
	public void setInventoryStatus(short value) {
		this.inventoryStatus = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the lastModifierKey property.
	 * 
	 */
	public long getLastModifierKey() {
		return lastModifierKey;
	}

	/**
	 * Sets the value of the lastModifierKey property.
	 * 
	 */
	public void setLastModifierKey(long value) {
		this.lastModifierKey = value;
	}

	/**
	 * Gets the value of the lifeCycle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLifeCycle() {
		return lifeCycle;
	}

	/**
	 * Sets the value of the lifeCycle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLifeCycle(String value) {
		this.lifeCycle = value;
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
	 * Gets the value of the oldLifecycle property.
	 * 
	 */
	public short getOldLifecycle() {
		return oldLifecycle;
	}

	/**
	 * Sets the value of the oldLifecycle property.
	 * 
	 */
	public void setOldLifecycle(short value) {
		this.oldLifecycle = value;
	}

	/**
	 * Gets the value of the onHandStatus property.
	 * 
	 */
	public short getOnHandStatus() {
		return onHandStatus;
	}

	/**
	 * Sets the value of the onHandStatus property.
	 * 
	 */
	public void setOnHandStatus(short value) {
		this.onHandStatus = value;
	}

	/**
	 * Gets the value of the orderItem property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderItem() {
		return orderItem;
	}

	/**
	 * Sets the value of the orderItem property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderItem(String value) {
		this.orderItem = value;
	}

	/**
	 * Gets the value of the originalParentSiteNumber property.
	 * 
	 */
	public int getOriginalParentSiteNumber() {
		return originalParentSiteNumber;
	}

	/**
	 * Sets the value of the originalParentSiteNumber property.
	 * 
	 */
	public void setOriginalParentSiteNumber(int value) {
		this.originalParentSiteNumber = value;
	}

	/**
	 * Gets the value of the originalParentUnitKey property.
	 * 
	 */
	public long getOriginalParentUnitKey() {
		return originalParentUnitKey;
	}

	/**
	 * Sets the value of the originalParentUnitKey property.
	 * 
	 */
	public void setOriginalParentUnitKey(long value) {
		this.originalParentUnitKey = value;
	}

	/**
	 * Gets the value of the originalSiteNumber property.
	 * 
	 */
	public int getOriginalSiteNumber() {
		return originalSiteNumber;
	}

	/**
	 * Sets the value of the originalSiteNumber property.
	 * 
	 */
	public void setOriginalSiteNumber(int value) {
		this.originalSiteNumber = value;
	}

	/**
	 * Gets the value of the originalUnitKey property.
	 * 
	 */
	public long getOriginalUnitKey() {
		return originalUnitKey;
	}

	/**
	 * Sets the value of the originalUnitKey property.
	 * 
	 */
	public void setOriginalUnitKey(long value) {
		this.originalUnitKey = value;
	}

	/**
	 * Gets the value of the ownerAccountKey property.
	 * 
	 */
	public long getOwnerAccountKey() {
		return ownerAccountKey;
	}

	/**
	 * Sets the value of the ownerAccountKey property.
	 * 
	 */
	public void setOwnerAccountKey(long value) {
		this.ownerAccountKey = value;
	}

	/**
	 * Gets the value of the preserializedLotKey property.
	 * 
	 */
	public long getPreserializedLotKey() {
		return preserializedLotKey;
	}

	/**
	 * Sets the value of the preserializedLotKey property.
	 * 
	 */
	public void setPreserializedLotKey(long value) {
		this.preserializedLotKey = value;
	}

	/**
	 * Gets the value of the preserializedLotSiteNumber property.
	 * 
	 */
	public int getPreserializedLotSiteNumber() {
		return preserializedLotSiteNumber;
	}

	/**
	 * Sets the value of the preserializedLotSiteNumber property.
	 * 
	 */
	public void setPreserializedLotSiteNumber(int value) {
		this.preserializedLotSiteNumber = value;
	}

	/**
	 * Gets the value of the previousNodeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousNodeName() {
		return previousNodeName;
	}

	/**
	 * Sets the value of the previousNodeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousNodeName(String value) {
		this.previousNodeName = value;
	}

	/**
	 * Gets the value of the previousNodeType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousNodeType() {
		return previousNodeType;
	}

	/**
	 * Sets the value of the previousNodeType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousNodeType(String value) {
		this.previousNodeType = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 */
	public void setPriority(int value) {
		this.priority = value;
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
	 * Gets the value of the revivedCount property.
	 * 
	 */
	public int getRevivedCount() {
		return revivedCount;
	}

	/**
	 * Sets the value of the revivedCount property.
	 * 
	 */
	public void setRevivedCount(int value) {
		this.revivedCount = value;
	}

	/**
	 * Gets the value of the reworkCount property.
	 * 
	 */
	public int getReworkCount() {
		return reworkCount;
	}

	/**
	 * Sets the value of the reworkCount property.
	 * 
	 */
	public void setReworkCount(int value) {
		this.reworkCount = value;
	}

	/**
	 * Gets the value of the reworkFlag property.
	 * 
	 */
	public boolean isReworkFlag() {
		return reworkFlag;
	}

	/**
	 * Sets the value of the reworkFlag property.
	 * 
	 */
	public void setReworkFlag(boolean value) {
		this.reworkFlag = value;
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
	 * Gets the value of the siteNumber property.
	 * 
	 */
	public int getSiteNumber() {
		return siteNumber;
	}

	/**
	 * Sets the value of the siteNumber property.
	 * 
	 */
	public void setSiteNumber(int value) {
		this.siteNumber = value;
	}

	/**
	 * Gets the value of the supplierAccountKey property.
	 * 
	 */
	public long getSupplierAccountKey() {
		return supplierAccountKey;
	}

	/**
	 * Sets the value of the supplierAccountKey property.
	 * 
	 */
	public void setSupplierAccountKey(long value) {
		this.supplierAccountKey = value;
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

}
