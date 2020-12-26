package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSublotQuantityHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSublotQuantityHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="beginTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="endTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trxId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trxName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSublotQuantityHistory", propOrder = { "beginTime", "endTime",
		"quantity", "sublotKey", "trxId", "trxName" })
public class DSublotQuantityHistory extends DCategorical {

	protected DTimestamp beginTime;
	protected DTimestamp endTime;
	protected DMeasuredValue quantity;
	protected long sublotKey;
	protected String trxId;
	protected String trxName;

	/**
	 * Gets the value of the beginTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * Sets the value of the beginTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setBeginTime(DTimestamp value) {
		this.beginTime = value;
	}

	/**
	 * Gets the value of the endTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEndTime() {
		return endTime;
	}

	/**
	 * Sets the value of the endTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEndTime(DTimestamp value) {
		this.endTime = value;
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
	 * Gets the value of the trxId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrxId() {
		return trxId;
	}

	/**
	 * Sets the value of the trxId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrxId(String value) {
		this.trxId = value;
	}

	/**
	 * Gets the value of the trxName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrxName() {
		return trxName;
	}

	/**
	 * Sets the value of the trxName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrxName(String value) {
		this.trxName = value;
	}

}
