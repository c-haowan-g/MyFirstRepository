package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFlowLotExtended complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFlowLotExtended">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="finishedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="inventoryStatus" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="lastModifierKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="motherLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onHandStatus" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ownerAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="previousNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousNodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="promisedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="quantityYieldFinished" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityYieldInitial" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="reworkCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reworkFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shippedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="splitParentLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DFlowLotExtended", propOrder = { "billAccountKey",
		"buildAccountKey", "comment", "containerKey", "creationTime",
		"description", "expirationTime", "finishedTime", "inventoryStatus",
		"lastModifiedTime", "lastModifierKey", "motherLotKey", "note",
		"onHandStatus", "ownerAccountKey", "previousNodeName",
		"previousNodeType", "priority", "promisedTime",
		"quantityYieldFinished", "quantityYieldInitial", "reworkCount",
		"reworkFlag", "shipAccountKey", "shippedTime", "splitParentLotKey",
		"supplierAccountKey", "userAccountKey", "workInstructionKeys",
		"workInstructionKeysChanged", "workInstructionListKey" })
public class DFlowLotExtended extends DDataObject {

	protected long billAccountKey;
	protected long buildAccountKey;
	protected String comment;
	protected long containerKey;
	protected DTimestamp creationTime;
	protected String description;
	protected DTimestamp expirationTime;
	protected DTimestamp finishedTime;
	protected short inventoryStatus;
	protected DTimestamp lastModifiedTime;
	protected long lastModifierKey;
	protected long motherLotKey;
	protected String note;
	protected short onHandStatus;
	protected long ownerAccountKey;
	protected String previousNodeName;
	protected String previousNodeType;
	protected int priority;
	protected DTimestamp promisedTime;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityYieldFinished;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityYieldInitial;
	protected int reworkCount;
	protected boolean reworkFlag;
	protected long shipAccountKey;
	protected DTimestamp shippedTime;
	protected long splitParentLotKey;
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
	 * Gets the value of the motherLotKey property.
	 * 
	 */
	public long getMotherLotKey() {
		return motherLotKey;
	}

	/**
	 * Sets the value of the motherLotKey property.
	 * 
	 */
	public void setMotherLotKey(long value) {
		this.motherLotKey = value;
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
	 * Gets the value of the quantityYieldFinished property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityYieldFinished() {
		return quantityYieldFinished;
	}

	/**
	 * Sets the value of the quantityYieldFinished property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityYieldFinished(BigDecimal value) {
		this.quantityYieldFinished = value;
	}

	/**
	 * Gets the value of the quantityYieldInitial property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityYieldInitial() {
		return quantityYieldInitial;
	}

	/**
	 * Sets the value of the quantityYieldInitial property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityYieldInitial(BigDecimal value) {
		this.quantityYieldInitial = value;
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
	 * Gets the value of the splitParentLotKey property.
	 * 
	 */
	public long getSplitParentLotKey() {
		return splitParentLotKey;
	}

	/**
	 * Sets the value of the splitParentLotKey property.
	 * 
	 */
	public void setSplitParentLotKey(long value) {
		this.splitParentLotKey = value;
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
