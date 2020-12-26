package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRuntimeActivitySetStep complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeActivitySetStep">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DRuntimeActivitySetBase">
 *       &lt;sequence>
 *         &lt;element name="activationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="activitySetStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="blobItems" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="deactivationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="refActivityClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refRuntimeActivitySetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="runtimeActivitySetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRuntimeActivitySetStep", propOrder = { "activationTime",
		"activitySetStepKey", "blobItems", "deactivationTime",
		"refActivityClassName", "refRuntimeActivitySetKey",
		"runtimeActivitySetKey", "transitionKey" })
public class DRuntimeActivitySetStep extends DRuntimeActivitySetBase {

	protected DTimestamp activationTime;
	protected long activitySetStepKey;
	protected byte[] blobItems;
	protected DTimestamp deactivationTime;
	protected String refActivityClassName;
	protected long refRuntimeActivitySetKey;
	protected long runtimeActivitySetKey;
	protected long transitionKey;

	/**
	 * Gets the value of the activationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getActivationTime() {
		return activationTime;
	}

	/**
	 * Sets the value of the activationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setActivationTime(DTimestamp value) {
		this.activationTime = value;
	}

	/**
	 * Gets the value of the activitySetStepKey property.
	 * 
	 */
	public long getActivitySetStepKey() {
		return activitySetStepKey;
	}

	/**
	 * Sets the value of the activitySetStepKey property.
	 * 
	 */
	public void setActivitySetStepKey(long value) {
		this.activitySetStepKey = value;
	}

	/**
	 * Gets the value of the blobItems property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getBlobItems() {
		return blobItems;
	}

	/**
	 * Sets the value of the blobItems property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setBlobItems(byte[] value) {
		this.blobItems = ((byte[]) value);
	}

	/**
	 * Gets the value of the deactivationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getDeactivationTime() {
		return deactivationTime;
	}

	/**
	 * Sets the value of the deactivationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setDeactivationTime(DTimestamp value) {
		this.deactivationTime = value;
	}

	/**
	 * Gets the value of the refActivityClassName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRefActivityClassName() {
		return refActivityClassName;
	}

	/**
	 * Sets the value of the refActivityClassName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefActivityClassName(String value) {
		this.refActivityClassName = value;
	}

	/**
	 * Gets the value of the refRuntimeActivitySetKey property.
	 * 
	 */
	public long getRefRuntimeActivitySetKey() {
		return refRuntimeActivitySetKey;
	}

	/**
	 * Sets the value of the refRuntimeActivitySetKey property.
	 * 
	 */
	public void setRefRuntimeActivitySetKey(long value) {
		this.refRuntimeActivitySetKey = value;
	}

	/**
	 * Gets the value of the runtimeActivitySetKey property.
	 * 
	 */
	public long getRuntimeActivitySetKey() {
		return runtimeActivitySetKey;
	}

	/**
	 * Sets the value of the runtimeActivitySetKey property.
	 * 
	 */
	public void setRuntimeActivitySetKey(long value) {
		this.runtimeActivitySetKey = value;
	}

	/**
	 * Gets the value of the transitionKey property.
	 * 
	 */
	public long getTransitionKey() {
		return transitionKey;
	}

	/**
	 * Sets the value of the transitionKey property.
	 * 
	 */
	public void setTransitionKey(long value) {
		this.transitionKey = value;
	}

}
