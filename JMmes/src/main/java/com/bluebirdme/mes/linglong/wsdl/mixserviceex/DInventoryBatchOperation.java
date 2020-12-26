package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryBatchOperation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryBatchOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="actualSourceQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="actualTargetQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="actualTransformQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="complete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="completeTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="goalQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="goalTransformQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="namedPathKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="operationType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderStepInputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderStepOutputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="potency" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="producedSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sourceBatchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceBatchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sourceContainerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceContainerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sourceContributorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourcePartKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sublotSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetBatchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetBatchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="targetContainerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetContainerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="targetSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="withdrawalSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DInventoryBatchOperation", propOrder = {
		"actualSourceQuantity", "actualTargetQuantity",
		"actualTransformQuantity", "complete", "completeTime", "currentStates",
		"expirationTime", "goalQuantity", "goalTransformQuantity",
		"namedPathKey", "objectType", "operationType", "orderStepInputKey",
		"orderStepKey", "orderStepOutputKey", "partKey", "potency",
		"producedSublotKey", "quantity", "sourceBatchKey", "sourceBatchType",
		"sourceContainerKey", "sourceContainerType", "sourceContributorId",
		"sourcePartKey", "sourceSublotKey", "sourceType", "startTime",
		"status", "sublotSequenceNumber", "targetBatchKey", "targetBatchType",
		"targetContainerKey", "targetContainerType", "targetSublotKey",
		"targetType", "userDefinedAttributes", "withdrawalSublotKey" })
public class DInventoryBatchOperation extends DCategorical {

	protected DMeasuredValue actualSourceQuantity;
	protected DMeasuredValue actualTargetQuantity;
	protected DMeasuredValue actualTransformQuantity;
	protected boolean complete;
	protected DTimestamp completeTime;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected DTimestamp expirationTime;
	protected DMeasuredValue goalQuantity;
	protected DMeasuredValue goalTransformQuantity;
	protected long namedPathKey;
	protected short objectType;
	protected short operationType;
	protected long orderStepInputKey;
	protected long orderStepKey;
	protected long orderStepOutputKey;
	protected long partKey;
	protected DMeasuredValue potency;
	protected long producedSublotKey;
	protected DMeasuredValue quantity;
	protected long sourceBatchKey;
	protected short sourceBatchType;
	protected long sourceContainerKey;
	protected short sourceContainerType;
	protected String sourceContributorId;
	protected long sourcePartKey;
	protected long sourceSublotKey;
	protected short sourceType;
	protected DTimestamp startTime;
	protected String status;
	protected int sublotSequenceNumber;
	protected long targetBatchKey;
	protected short targetBatchType;
	protected long targetContainerKey;
	protected short targetContainerType;
	protected long targetSublotKey;
	protected short targetType;
	protected DUDAInstance userDefinedAttributes;
	protected long withdrawalSublotKey;

	/**
	 * Gets the value of the actualSourceQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getActualSourceQuantity() {
		return actualSourceQuantity;
	}

	/**
	 * Sets the value of the actualSourceQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setActualSourceQuantity(DMeasuredValue value) {
		this.actualSourceQuantity = value;
	}

	/**
	 * Gets the value of the actualTargetQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getActualTargetQuantity() {
		return actualTargetQuantity;
	}

	/**
	 * Sets the value of the actualTargetQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setActualTargetQuantity(DMeasuredValue value) {
		this.actualTargetQuantity = value;
	}

	/**
	 * Gets the value of the actualTransformQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getActualTransformQuantity() {
		return actualTransformQuantity;
	}

	/**
	 * Sets the value of the actualTransformQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setActualTransformQuantity(DMeasuredValue value) {
		this.actualTransformQuantity = value;
	}

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
	 * Gets the value of the completeTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCompleteTime() {
		return completeTime;
	}

	/**
	 * Sets the value of the completeTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCompleteTime(DTimestamp value) {
		this.completeTime = value;
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
	 * Gets the value of the goalQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getGoalQuantity() {
		return goalQuantity;
	}

	/**
	 * Sets the value of the goalQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setGoalQuantity(DMeasuredValue value) {
		this.goalQuantity = value;
	}

	/**
	 * Gets the value of the goalTransformQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getGoalTransformQuantity() {
		return goalTransformQuantity;
	}

	/**
	 * Sets the value of the goalTransformQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setGoalTransformQuantity(DMeasuredValue value) {
		this.goalTransformQuantity = value;
	}

	/**
	 * Gets the value of the namedPathKey property.
	 * 
	 */
	public long getNamedPathKey() {
		return namedPathKey;
	}

	/**
	 * Sets the value of the namedPathKey property.
	 * 
	 */
	public void setNamedPathKey(long value) {
		this.namedPathKey = value;
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
	 * Gets the value of the operationType property.
	 * 
	 */
	public short getOperationType() {
		return operationType;
	}

	/**
	 * Sets the value of the operationType property.
	 * 
	 */
	public void setOperationType(short value) {
		this.operationType = value;
	}

	/**
	 * Gets the value of the orderStepInputKey property.
	 * 
	 */
	public long getOrderStepInputKey() {
		return orderStepInputKey;
	}

	/**
	 * Sets the value of the orderStepInputKey property.
	 * 
	 */
	public void setOrderStepInputKey(long value) {
		this.orderStepInputKey = value;
	}

	/**
	 * Gets the value of the orderStepKey property.
	 * 
	 */
	public long getOrderStepKey() {
		return orderStepKey;
	}

	/**
	 * Sets the value of the orderStepKey property.
	 * 
	 */
	public void setOrderStepKey(long value) {
		this.orderStepKey = value;
	}

	/**
	 * Gets the value of the orderStepOutputKey property.
	 * 
	 */
	public long getOrderStepOutputKey() {
		return orderStepOutputKey;
	}

	/**
	 * Sets the value of the orderStepOutputKey property.
	 * 
	 */
	public void setOrderStepOutputKey(long value) {
		this.orderStepOutputKey = value;
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
	 * Gets the value of the producedSublotKey property.
	 * 
	 */
	public long getProducedSublotKey() {
		return producedSublotKey;
	}

	/**
	 * Sets the value of the producedSublotKey property.
	 * 
	 */
	public void setProducedSublotKey(long value) {
		this.producedSublotKey = value;
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
	 * Gets the value of the sourceBatchKey property.
	 * 
	 */
	public long getSourceBatchKey() {
		return sourceBatchKey;
	}

	/**
	 * Sets the value of the sourceBatchKey property.
	 * 
	 */
	public void setSourceBatchKey(long value) {
		this.sourceBatchKey = value;
	}

	/**
	 * Gets the value of the sourceBatchType property.
	 * 
	 */
	public short getSourceBatchType() {
		return sourceBatchType;
	}

	/**
	 * Sets the value of the sourceBatchType property.
	 * 
	 */
	public void setSourceBatchType(short value) {
		this.sourceBatchType = value;
	}

	/**
	 * Gets the value of the sourceContainerKey property.
	 * 
	 */
	public long getSourceContainerKey() {
		return sourceContainerKey;
	}

	/**
	 * Sets the value of the sourceContainerKey property.
	 * 
	 */
	public void setSourceContainerKey(long value) {
		this.sourceContainerKey = value;
	}

	/**
	 * Gets the value of the sourceContainerType property.
	 * 
	 */
	public short getSourceContainerType() {
		return sourceContainerType;
	}

	/**
	 * Sets the value of the sourceContainerType property.
	 * 
	 */
	public void setSourceContainerType(short value) {
		this.sourceContainerType = value;
	}

	/**
	 * Gets the value of the sourceContributorId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourceContributorId() {
		return sourceContributorId;
	}

	/**
	 * Sets the value of the sourceContributorId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceContributorId(String value) {
		this.sourceContributorId = value;
	}

	/**
	 * Gets the value of the sourcePartKey property.
	 * 
	 */
	public long getSourcePartKey() {
		return sourcePartKey;
	}

	/**
	 * Sets the value of the sourcePartKey property.
	 * 
	 */
	public void setSourcePartKey(long value) {
		this.sourcePartKey = value;
	}

	/**
	 * Gets the value of the sourceSublotKey property.
	 * 
	 */
	public long getSourceSublotKey() {
		return sourceSublotKey;
	}

	/**
	 * Sets the value of the sourceSublotKey property.
	 * 
	 */
	public void setSourceSublotKey(long value) {
		this.sourceSublotKey = value;
	}

	/**
	 * Gets the value of the sourceType property.
	 * 
	 */
	public short getSourceType() {
		return sourceType;
	}

	/**
	 * Sets the value of the sourceType property.
	 * 
	 */
	public void setSourceType(short value) {
		this.sourceType = value;
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
	 * Gets the value of the targetBatchKey property.
	 * 
	 */
	public long getTargetBatchKey() {
		return targetBatchKey;
	}

	/**
	 * Sets the value of the targetBatchKey property.
	 * 
	 */
	public void setTargetBatchKey(long value) {
		this.targetBatchKey = value;
	}

	/**
	 * Gets the value of the targetBatchType property.
	 * 
	 */
	public short getTargetBatchType() {
		return targetBatchType;
	}

	/**
	 * Sets the value of the targetBatchType property.
	 * 
	 */
	public void setTargetBatchType(short value) {
		this.targetBatchType = value;
	}

	/**
	 * Gets the value of the targetContainerKey property.
	 * 
	 */
	public long getTargetContainerKey() {
		return targetContainerKey;
	}

	/**
	 * Sets the value of the targetContainerKey property.
	 * 
	 */
	public void setTargetContainerKey(long value) {
		this.targetContainerKey = value;
	}

	/**
	 * Gets the value of the targetContainerType property.
	 * 
	 */
	public short getTargetContainerType() {
		return targetContainerType;
	}

	/**
	 * Sets the value of the targetContainerType property.
	 * 
	 */
	public void setTargetContainerType(short value) {
		this.targetContainerType = value;
	}

	/**
	 * Gets the value of the targetSublotKey property.
	 * 
	 */
	public long getTargetSublotKey() {
		return targetSublotKey;
	}

	/**
	 * Sets the value of the targetSublotKey property.
	 * 
	 */
	public void setTargetSublotKey(long value) {
		this.targetSublotKey = value;
	}

	/**
	 * Gets the value of the targetType property.
	 * 
	 */
	public short getTargetType() {
		return targetType;
	}

	/**
	 * Sets the value of the targetType property.
	 * 
	 */
	public void setTargetType(short value) {
		this.targetType = value;
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
	 * Gets the value of the withdrawalSublotKey property.
	 * 
	 */
	public long getWithdrawalSublotKey() {
		return withdrawalSublotKey;
	}

	/**
	 * Sets the value of the withdrawalSublotKey property.
	 * 
	 */
	public void setWithdrawalSublotKey(long value) {
		this.withdrawalSublotKey = value;
	}

}
