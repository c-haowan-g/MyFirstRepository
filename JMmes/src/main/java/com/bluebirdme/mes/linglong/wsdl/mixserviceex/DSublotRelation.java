package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSublotRelation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSublotRelation">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="inventoryBatchOperationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="orderStepInputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderStepInputType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sourceBatchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceBatchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sourcePartContributorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourcePartKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetBatchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetBatchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="targetSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transformQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSublotRelation", propOrder = { "inventoryBatchOperationKey",
		"lastModifiedTime", "orderStepInputKey", "orderStepInputType",
		"quantity", "sourceBatchKey", "sourceBatchType",
		"sourcePartContributorId", "sourcePartKey", "sourceSublotKey",
		"sublotKey", "targetBatchKey", "targetBatchType", "targetSublotKey",
		"transformQuantity", "type" })
public class DSublotRelation extends DKeyed {

	protected long inventoryBatchOperationKey;
	protected DTimestamp lastModifiedTime;
	protected long orderStepInputKey;
	protected short orderStepInputType;
	protected DMeasuredValue quantity;
	protected long sourceBatchKey;
	protected short sourceBatchType;
	protected String sourcePartContributorId;
	protected long sourcePartKey;
	protected long sourceSublotKey;
	protected long sublotKey;
	protected long targetBatchKey;
	protected short targetBatchType;
	protected long targetSublotKey;
	protected DMeasuredValue transformQuantity;
	protected short type;

	/**
	 * Gets the value of the inventoryBatchOperationKey property.
	 * 
	 */
	public long getInventoryBatchOperationKey() {
		return inventoryBatchOperationKey;
	}

	/**
	 * Sets the value of the inventoryBatchOperationKey property.
	 * 
	 */
	public void setInventoryBatchOperationKey(long value) {
		this.inventoryBatchOperationKey = value;
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
	 * Gets the value of the orderStepInputType property.
	 * 
	 */
	public short getOrderStepInputType() {
		return orderStepInputType;
	}

	/**
	 * Sets the value of the orderStepInputType property.
	 * 
	 */
	public void setOrderStepInputType(short value) {
		this.orderStepInputType = value;
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
	 * Gets the value of the sourcePartContributorId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourcePartContributorId() {
		return sourcePartContributorId;
	}

	/**
	 * Sets the value of the sourcePartContributorId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourcePartContributorId(String value) {
		this.sourcePartContributorId = value;
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
	 * Gets the value of the sublotKey property.
	 * 
	 */
	public long getSublotKey() {
		return sublotKey;
	}

	/**
	 * Sets the value of the sublotKey property.
	 * 
	 */
	public void setSublotKey(long value) {
		this.sublotKey = value;
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
	 * Gets the value of the transformQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getTransformQuantity() {
		return transformQuantity;
	}

	/**
	 * Sets the value of the transformQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setTransformQuantity(DMeasuredValue value) {
		this.transformQuantity = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
	}

}
