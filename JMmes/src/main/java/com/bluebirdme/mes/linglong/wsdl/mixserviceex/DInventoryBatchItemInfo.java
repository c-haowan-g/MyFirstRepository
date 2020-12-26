package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryBatchItemInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryBatchItemInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DInventoryBatch">
 *       &lt;sequence>
 *         &lt;element name="batchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="batchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="batchType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="containerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderStepKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sublotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DInventoryBatchItemInfo", propOrder = { "batchKey",
		"batchName", "batchType", "containerName", "orderStepKeys",
		"sublotKey", "sublotName" })
public class DInventoryBatchItemInfo extends DInventoryBatch {

	protected long batchKey;
	protected String batchName;
	protected short batchType;
	protected String containerName;
	@XmlElement(type = Long.class)
	protected List<Long> orderStepKeys;
	protected long sublotKey;
	protected String sublotName;

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
	 * Gets the value of the batchName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBatchName() {
		return batchName;
	}

	/**
	 * Sets the value of the batchName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBatchName(String value) {
		this.batchName = value;
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
	 * Gets the value of the containerName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * Sets the value of the containerName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerName(String value) {
		this.containerName = value;
	}

	/**
	 * Gets the value of the orderStepKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getOrderStepKeys() {
		if (orderStepKeys == null) {
			orderStepKeys = new ArrayList<Long>();
		}
		return this.orderStepKeys;
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
	 * Gets the value of the sublotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSublotName() {
		return sublotName;
	}

	/**
	 * Sets the value of the sublotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSublotName(String value) {
		this.sublotName = value;
	}

}
