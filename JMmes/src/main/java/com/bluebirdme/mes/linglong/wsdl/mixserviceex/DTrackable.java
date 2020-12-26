package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTrackable complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTrackable">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="entryTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="equipmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionQueueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="trackedObjectStatusKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="workCenterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTrackable", propOrder = { "auditInfo", "entryTime",
		"equipmentName", "locationName", "operationName", "productionLineName",
		"productionQueueName", "queueName", "reason", "routeKey", "routeName",
		"routeStepName", "state", "status", "trackedObjectStatusKey",
		"userDefinedAttributes", "workCenterName" })
public abstract class DTrackable extends DKeyed {

	protected DAuditInfo auditInfo;
	protected DTimestamp entryTime;
	protected String equipmentName;
	protected String locationName;
	protected String operationName;
	protected String productionLineName;
	protected String productionQueueName;
	protected String queueName;
	protected String reason;
	protected long routeKey;
	protected String routeName;
	protected String routeStepName;
	protected short state;
	protected short status;
	protected long trackedObjectStatusKey;
	protected DUDAInstance userDefinedAttributes;
	protected String workCenterName;

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
	 * Gets the value of the entryTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEntryTime() {
		return entryTime;
	}

	/**
	 * Sets the value of the entryTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEntryTime(DTimestamp value) {
		this.entryTime = value;
	}

	/**
	 * Gets the value of the equipmentName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * Sets the value of the equipmentName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEquipmentName(String value) {
		this.equipmentName = value;
	}

	/**
	 * Gets the value of the locationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the value of the locationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocationName(String value) {
		this.locationName = value;
	}

	/**
	 * Gets the value of the operationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * Sets the value of the operationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOperationName(String value) {
		this.operationName = value;
	}

	/**
	 * Gets the value of the productionLineName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductionLineName() {
		return productionLineName;
	}

	/**
	 * Sets the value of the productionLineName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductionLineName(String value) {
		this.productionLineName = value;
	}

	/**
	 * Gets the value of the productionQueueName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductionQueueName() {
		return productionQueueName;
	}

	/**
	 * Sets the value of the productionQueueName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductionQueueName(String value) {
		this.productionQueueName = value;
	}

	/**
	 * Gets the value of the queueName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * Sets the value of the queueName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setQueueName(String value) {
		this.queueName = value;
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
	 * Gets the value of the routeKey property.
	 * 
	 */
	public long getRouteKey() {
		return routeKey;
	}

	/**
	 * Sets the value of the routeKey property.
	 * 
	 */
	public void setRouteKey(long value) {
		this.routeKey = value;
	}

	/**
	 * Gets the value of the routeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRouteName() {
		return routeName;
	}

	/**
	 * Sets the value of the routeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRouteName(String value) {
		this.routeName = value;
	}

	/**
	 * Gets the value of the routeStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRouteStepName() {
		return routeStepName;
	}

	/**
	 * Sets the value of the routeStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRouteStepName(String value) {
		this.routeStepName = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 */
	public short getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 */
	public void setState(short value) {
		this.state = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 */
	public void setStatus(short value) {
		this.status = value;
	}

	/**
	 * Gets the value of the trackedObjectStatusKey property.
	 * 
	 */
	public long getTrackedObjectStatusKey() {
		return trackedObjectStatusKey;
	}

	/**
	 * Sets the value of the trackedObjectStatusKey property.
	 * 
	 */
	public void setTrackedObjectStatusKey(long value) {
		this.trackedObjectStatusKey = value;
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

	/**
	 * Gets the value of the workCenterName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkCenterName() {
		return workCenterName;
	}

	/**
	 * Sets the value of the workCenterName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkCenterName(String value) {
		this.workCenterName = value;
	}

}
