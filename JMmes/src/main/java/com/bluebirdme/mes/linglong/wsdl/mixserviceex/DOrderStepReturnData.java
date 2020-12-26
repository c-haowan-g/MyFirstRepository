package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOrderStepReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOrderStepReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="container" type="{dataobjects.common.plantops.datasweep.com}DISublotContainer" minOccurs="0"/>
 *         &lt;element name="inventoryBatch" type="{dataobjects.common.plantops.datasweep.com}DInventoryBatch" minOccurs="0"/>
 *         &lt;element name="orderStep" type="{dataobjects.common.plantops.datasweep.com}DOrderStep" minOccurs="0"/>
 *         &lt;element name="orderStepInputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderStepOutputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transactionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOrderStepReturnData", propOrder = { "container",
		"inventoryBatch", "orderStep", "orderStepInputKey",
		"orderStepOutputKey", "transactionName" })
public class DOrderStepReturnData {

	protected DISublotContainer container;
	protected DInventoryBatch inventoryBatch;
	protected DOrderStep orderStep;
	protected long orderStepInputKey;
	protected long orderStepOutputKey;
	protected String transactionName;

	/**
	 * Gets the value of the container property.
	 * 
	 * @return possible object is {@link DISublotContainer }
	 * 
	 */
	public DISublotContainer getContainer() {
		return container;
	}

	/**
	 * Sets the value of the container property.
	 * 
	 * @param value
	 *            allowed object is {@link DISublotContainer }
	 * 
	 */
	public void setContainer(DISublotContainer value) {
		this.container = value;
	}

	/**
	 * Gets the value of the inventoryBatch property.
	 * 
	 * @return possible object is {@link DInventoryBatch }
	 * 
	 */
	public DInventoryBatch getInventoryBatch() {
		return inventoryBatch;
	}

	/**
	 * Sets the value of the inventoryBatch property.
	 * 
	 * @param value
	 *            allowed object is {@link DInventoryBatch }
	 * 
	 */
	public void setInventoryBatch(DInventoryBatch value) {
		this.inventoryBatch = value;
	}

	/**
	 * Gets the value of the orderStep property.
	 * 
	 * @return possible object is {@link DOrderStep }
	 * 
	 */
	public DOrderStep getOrderStep() {
		return orderStep;
	}

	/**
	 * Sets the value of the orderStep property.
	 * 
	 * @param value
	 *            allowed object is {@link DOrderStep }
	 * 
	 */
	public void setOrderStep(DOrderStep value) {
		this.orderStep = value;
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
	 * Gets the value of the transactionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * Sets the value of the transactionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionName(String value) {
		this.transactionName = value;
	}

}
