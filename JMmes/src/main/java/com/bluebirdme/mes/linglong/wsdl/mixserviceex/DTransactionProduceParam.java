package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTransactionProduceParam complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTransactionProduceParam">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractTransactionParam">
 *       &lt;sequence>
 *         &lt;element name="namedPathKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processStepResourceKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processStepResourceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="produceQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="producedBatchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="producedSublotExpirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="producedSublotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetContainerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetContainerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="targetSublotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userSpecifiedPSCSIKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTransactionProduceParam", propOrder = { "namedPathKey",
		"partKey", "processStepKey", "processStepResourceKey",
		"processStepResourceType", "produceQuantity", "producedBatchName",
		"producedSublotExpirationTime", "producedSublotName", "productionType",
		"targetContainerKey", "targetContainerType", "targetSublotName",
		"userSpecifiedPSCSIKeys" })
public class DTransactionProduceParam extends DAbstractTransactionParam {

	protected long namedPathKey;
	protected long partKey;
	protected long processStepKey;
	protected long processStepResourceKey;
	protected short processStepResourceType;
	protected DMeasuredValue produceQuantity;
	protected String producedBatchName;
	protected DTimestamp producedSublotExpirationTime;
	protected String producedSublotName;
	protected int productionType;
	protected long targetContainerKey;
	protected short targetContainerType;
	protected String targetSublotName;
	@XmlElement(type = Long.class)
	protected List<Long> userSpecifiedPSCSIKeys;

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
	 * Gets the value of the processStepKey property.
	 * 
	 */
	public long getProcessStepKey() {
		return processStepKey;
	}

	/**
	 * Sets the value of the processStepKey property.
	 * 
	 */
	public void setProcessStepKey(long value) {
		this.processStepKey = value;
	}

	/**
	 * Gets the value of the processStepResourceKey property.
	 * 
	 */
	public long getProcessStepResourceKey() {
		return processStepResourceKey;
	}

	/**
	 * Sets the value of the processStepResourceKey property.
	 * 
	 */
	public void setProcessStepResourceKey(long value) {
		this.processStepResourceKey = value;
	}

	/**
	 * Gets the value of the processStepResourceType property.
	 * 
	 */
	public short getProcessStepResourceType() {
		return processStepResourceType;
	}

	/**
	 * Sets the value of the processStepResourceType property.
	 * 
	 */
	public void setProcessStepResourceType(short value) {
		this.processStepResourceType = value;
	}

	/**
	 * Gets the value of the produceQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getProduceQuantity() {
		return produceQuantity;
	}

	/**
	 * Sets the value of the produceQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setProduceQuantity(DMeasuredValue value) {
		this.produceQuantity = value;
	}

	/**
	 * Gets the value of the producedBatchName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProducedBatchName() {
		return producedBatchName;
	}

	/**
	 * Sets the value of the producedBatchName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProducedBatchName(String value) {
		this.producedBatchName = value;
	}

	/**
	 * Gets the value of the producedSublotExpirationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getProducedSublotExpirationTime() {
		return producedSublotExpirationTime;
	}

	/**
	 * Sets the value of the producedSublotExpirationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setProducedSublotExpirationTime(DTimestamp value) {
		this.producedSublotExpirationTime = value;
	}

	/**
	 * Gets the value of the producedSublotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProducedSublotName() {
		return producedSublotName;
	}

	/**
	 * Sets the value of the producedSublotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProducedSublotName(String value) {
		this.producedSublotName = value;
	}

	/**
	 * Gets the value of the productionType property.
	 * 
	 */
	public int getProductionType() {
		return productionType;
	}

	/**
	 * Sets the value of the productionType property.
	 * 
	 */
	public void setProductionType(int value) {
		this.productionType = value;
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
	 * Gets the value of the targetSublotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTargetSublotName() {
		return targetSublotName;
	}

	/**
	 * Sets the value of the targetSublotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTargetSublotName(String value) {
		this.targetSublotName = value;
	}

	/**
	 * Gets the value of the userSpecifiedPSCSIKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the userSpecifiedPSCSIKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getUserSpecifiedPSCSIKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getUserSpecifiedPSCSIKeys() {
		if (userSpecifiedPSCSIKeys == null) {
			userSpecifiedPSCSIKeys = new ArrayList<Long>();
		}
		return this.userSpecifiedPSCSIKeys;
	}

}
