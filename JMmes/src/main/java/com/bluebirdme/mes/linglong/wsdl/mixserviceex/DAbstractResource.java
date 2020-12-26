package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractResource complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractResource">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="completeTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="pauseTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="previousState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceConditionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceRouteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceStatusKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="resourceStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sublotCapacity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
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
@XmlType(name = "DAbstractResource", propOrder = { "completeTime", "pauseTime",
		"previousState", "previousStatus", "priority", "reason",
		"resourceConditionName", "resourceRouteName", "resourceStatusKey",
		"resourceStepName", "startTime", "state", "status", "sublotCapacity",
		"userDefinedAttributes" })
public abstract class DAbstractResource extends DCategorical {

	protected DTimestamp completeTime;
	protected DTimestamp pauseTime;
	protected String previousState;
	protected String previousStatus;
	protected int priority;
	protected String reason;
	protected String resourceConditionName;
	protected String resourceRouteName;
	protected long resourceStatusKey;
	protected String resourceStepName;
	protected DTimestamp startTime;
	protected String state;
	protected String status;
	protected DMeasuredValue sublotCapacity;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the pauseTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getPauseTime() {
		return pauseTime;
	}

	/**
	 * Sets the value of the pauseTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setPauseTime(DTimestamp value) {
		this.pauseTime = value;
	}

	/**
	 * Gets the value of the previousState property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousState() {
		return previousState;
	}

	/**
	 * Sets the value of the previousState property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousState(String value) {
		this.previousState = value;
	}

	/**
	 * Gets the value of the previousStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousStatus() {
		return previousStatus;
	}

	/**
	 * Sets the value of the previousStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousStatus(String value) {
		this.previousStatus = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 */
	public void setPriority(int value) {
		this.priority = value;
	}

	/**
	 * Gets the value of the reason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the value of the reason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReason(String value) {
		this.reason = value;
	}

	/**
	 * Gets the value of the resourceConditionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceConditionName() {
		return resourceConditionName;
	}

	/**
	 * Sets the value of the resourceConditionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceConditionName(String value) {
		this.resourceConditionName = value;
	}

	/**
	 * Gets the value of the resourceRouteName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceRouteName() {
		return resourceRouteName;
	}

	/**
	 * Sets the value of the resourceRouteName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceRouteName(String value) {
		this.resourceRouteName = value;
	}

	/**
	 * Gets the value of the resourceStatusKey property.
	 * 
	 */
	public long getResourceStatusKey() {
		return resourceStatusKey;
	}

	/**
	 * Sets the value of the resourceStatusKey property.
	 * 
	 */
	public void setResourceStatusKey(long value) {
		this.resourceStatusKey = value;
	}

	/**
	 * Gets the value of the resourceStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResourceStepName() {
		return resourceStepName;
	}

	/**
	 * Sets the value of the resourceStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResourceStepName(String value) {
		this.resourceStepName = value;
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
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setState(String value) {
		this.state = value;
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
	 * Gets the value of the sublotCapacity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getSublotCapacity() {
		return sublotCapacity;
	}

	/**
	 * Sets the value of the sublotCapacity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setSublotCapacity(DMeasuredValue value) {
		this.sublotCapacity = value;
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
