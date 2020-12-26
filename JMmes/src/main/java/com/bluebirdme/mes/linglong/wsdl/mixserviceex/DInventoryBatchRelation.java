package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryBatchRelation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryBatchRelation">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="inventoryBatchOperation" type="{dataobjects.common.plantops.datasweep.com}DInventoryBatchOperation" minOccurs="0"/>
 *         &lt;element name="sourceInventoryBatchItemInfo" type="{dataobjects.common.plantops.datasweep.com}DInventoryBatchItemInfo" minOccurs="0"/>
 *         &lt;element name="targetInventoryBatchItemInfo" type="{dataobjects.common.plantops.datasweep.com}DInventoryBatchItemInfo" minOccurs="0"/>
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
@XmlType(name = "DInventoryBatchRelation", propOrder = {
		"inventoryBatchOperation", "sourceInventoryBatchItemInfo",
		"targetInventoryBatchItemInfo", "type" })
public class DInventoryBatchRelation extends DKeyed {

	protected DInventoryBatchOperation inventoryBatchOperation;
	protected DInventoryBatchItemInfo sourceInventoryBatchItemInfo;
	protected DInventoryBatchItemInfo targetInventoryBatchItemInfo;
	protected short type;

	/**
	 * Gets the value of the inventoryBatchOperation property.
	 * 
	 * @return possible object is {@link DInventoryBatchOperation }
	 * 
	 */
	public DInventoryBatchOperation getInventoryBatchOperation() {
		return inventoryBatchOperation;
	}

	/**
	 * Sets the value of the inventoryBatchOperation property.
	 * 
	 * @param value
	 *            allowed object is {@link DInventoryBatchOperation }
	 * 
	 */
	public void setInventoryBatchOperation(DInventoryBatchOperation value) {
		this.inventoryBatchOperation = value;
	}

	/**
	 * Gets the value of the sourceInventoryBatchItemInfo property.
	 * 
	 * @return possible object is {@link DInventoryBatchItemInfo }
	 * 
	 */
	public DInventoryBatchItemInfo getSourceInventoryBatchItemInfo() {
		return sourceInventoryBatchItemInfo;
	}

	/**
	 * Sets the value of the sourceInventoryBatchItemInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DInventoryBatchItemInfo }
	 * 
	 */
	public void setSourceInventoryBatchItemInfo(DInventoryBatchItemInfo value) {
		this.sourceInventoryBatchItemInfo = value;
	}

	/**
	 * Gets the value of the targetInventoryBatchItemInfo property.
	 * 
	 * @return possible object is {@link DInventoryBatchItemInfo }
	 * 
	 */
	public DInventoryBatchItemInfo getTargetInventoryBatchItemInfo() {
		return targetInventoryBatchItemInfo;
	}

	/**
	 * Sets the value of the targetInventoryBatchItemInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DInventoryBatchItemInfo }
	 * 
	 */
	public void setTargetInventoryBatchItemInfo(DInventoryBatchItemInfo value) {
		this.targetInventoryBatchItemInfo = value;
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
