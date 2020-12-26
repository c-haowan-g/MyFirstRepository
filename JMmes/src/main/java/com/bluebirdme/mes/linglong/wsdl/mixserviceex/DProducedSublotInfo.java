package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DProducedSublotInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DProducedSublotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="batchKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderStepOutputKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processOrderItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="producedQuantities" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublotKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trxTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="userKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DProducedSublotInfo", propOrder = { "batchKey", "comment",
		"controlRecipeKey", "objectType", "orderStepOutputKey",
		"processOrderItemKey", "producedQuantities", "sublotKeys", "trxTime",
		"userKey" })
public class DProducedSublotInfo extends DKeyed {

	protected long batchKey;
	protected String comment;
	protected long controlRecipeKey;
	protected short objectType;
	protected long orderStepOutputKey;
	protected long processOrderItemKey;
	@XmlElement(nillable = true)
	protected List<DMeasuredValue> producedQuantities;
	@XmlElement(type = Long.class)
	protected List<Long> sublotKeys;
	protected DTimestamp trxTime;
	protected long userKey;

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
	 * Gets the value of the controlRecipeKey property.
	 * 
	 */
	public long getControlRecipeKey() {
		return controlRecipeKey;
	}

	/**
	 * Sets the value of the controlRecipeKey property.
	 * 
	 */
	public void setControlRecipeKey(long value) {
		this.controlRecipeKey = value;
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
	 * Gets the value of the processOrderItemKey property.
	 * 
	 */
	public long getProcessOrderItemKey() {
		return processOrderItemKey;
	}

	/**
	 * Sets the value of the processOrderItemKey property.
	 * 
	 */
	public void setProcessOrderItemKey(long value) {
		this.processOrderItemKey = value;
	}

	/**
	 * Gets the value of the producedQuantities property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the producedQuantities property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProducedQuantities().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DMeasuredValue }
	 * 
	 * 
	 */
	public List<DMeasuredValue> getProducedQuantities() {
		if (producedQuantities == null) {
			producedQuantities = new ArrayList<DMeasuredValue>();
		}
		return this.producedQuantities;
	}

	/**
	 * Gets the value of the sublotKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sublotKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSublotKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSublotKeys() {
		if (sublotKeys == null) {
			sublotKeys = new ArrayList<Long>();
		}
		return this.sublotKeys;
	}

	/**
	 * Gets the value of the trxTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getTrxTime() {
		return trxTime;
	}

	/**
	 * Sets the value of the trxTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setTrxTime(DTimestamp value) {
		this.trxTime = value;
	}

	/**
	 * Gets the value of the userKey property.
	 * 
	 */
	public long getUserKey() {
		return userKey;
	}

	/**
	 * Sets the value of the userKey property.
	 * 
	 */
	public void setUserKey(long value) {
		this.userKey = value;
	}

}
