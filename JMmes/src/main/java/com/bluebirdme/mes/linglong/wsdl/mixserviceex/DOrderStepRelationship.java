package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOrderStepRelationship complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOrderStepRelationship">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="delay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="destIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="relationShipType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="srcIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toOrderStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOrderStepRelationship", propOrder = { "auditInfo",
		"controlRecipeKey", "delay", "destIndex", "orderStepKey",
		"relationShipType", "srcIndex", "toOrderStepName",
		"userDefinedAttributes" })
public class DOrderStepRelationship extends DKeyed {

	protected DAuditInfo auditInfo;
	protected long controlRecipeKey;
	protected int delay;
	protected int destIndex;
	protected long orderStepKey;
	protected short relationShipType;
	protected int srcIndex;
	protected String toOrderStepName;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
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
	 * Gets the value of the delay property.
	 * 
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * Sets the value of the delay property.
	 * 
	 */
	public void setDelay(int value) {
		this.delay = value;
	}

	/**
	 * Gets the value of the destIndex property.
	 * 
	 */
	public int getDestIndex() {
		return destIndex;
	}

	/**
	 * Sets the value of the destIndex property.
	 * 
	 */
	public void setDestIndex(int value) {
		this.destIndex = value;
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
	 * Gets the value of the relationShipType property.
	 * 
	 */
	public short getRelationShipType() {
		return relationShipType;
	}

	/**
	 * Sets the value of the relationShipType property.
	 * 
	 */
	public void setRelationShipType(short value) {
		this.relationShipType = value;
	}

	/**
	 * Gets the value of the srcIndex property.
	 * 
	 */
	public int getSrcIndex() {
		return srcIndex;
	}

	/**
	 * Sets the value of the srcIndex property.
	 * 
	 */
	public void setSrcIndex(int value) {
		this.srcIndex = value;
	}

	/**
	 * Gets the value of the toOrderStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToOrderStepName() {
		return toOrderStepName;
	}

	/**
	 * Sets the value of the toOrderStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToOrderStepName(String value) {
		this.toOrderStepName = value;
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

}
