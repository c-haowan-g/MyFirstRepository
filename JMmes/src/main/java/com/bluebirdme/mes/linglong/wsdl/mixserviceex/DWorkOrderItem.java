package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkOrderItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkOrderItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bomRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="finishedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plannedFinishTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="plannedProductionLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plannedRoute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plannedRouteKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="plannedStartTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="preciseQuantityClosed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="preciseQuantityFinished" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="preciseQuantityInProgress" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="preciseQuantityOrdered" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="preciseQuantityShipped" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityClosed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantityFinished" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantityInProgress" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantityOrdered" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantityShipped" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="scheduledFinishTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="scheduledStartTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shippedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="userAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DWorkOrderItem", propOrder = { "auditInfo", "billAccountKey",
		"bomName", "bomRevision", "buildAccountKey", "creationTime",
		"finishedTime", "lastModifiedTime", "note", "orderKey", "orderState",
		"partNumber", "partRevision", "plannedFinishTime",
		"plannedProductionLine", "plannedRoute", "plannedRouteKey",
		"plannedStartTime", "preciseQuantityClosed", "preciseQuantityFinished",
		"preciseQuantityInProgress", "preciseQuantityOrdered",
		"preciseQuantityShipped", "quantityClosed", "quantityFinished",
		"quantityInProgress", "quantityOrdered", "quantityShipped", "revision",
		"scheduledFinishTime", "scheduledStartTime", "shipAccountKey",
		"shippedTime", "state", "status", "userAccountKey",
		"userDefinedAttributes" })
public class DWorkOrderItem extends DKeyed {

	protected DAuditInfo auditInfo;
	protected long billAccountKey;
	protected String bomName;
	protected String bomRevision;
	protected long buildAccountKey;
	protected DTimestamp creationTime;
	protected DTimestamp finishedTime;
	protected DTimestamp lastModifiedTime;
	protected String note;
	protected long orderKey;
	protected String orderState;
	protected String partNumber;
	protected String partRevision;
	protected DTimestamp plannedFinishTime;
	protected String plannedProductionLine;
	protected String plannedRoute;
	protected long plannedRouteKey;
	protected DTimestamp plannedStartTime;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal preciseQuantityClosed;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal preciseQuantityFinished;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal preciseQuantityInProgress;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal preciseQuantityOrdered;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal preciseQuantityShipped;
	protected int quantityClosed;
	protected int quantityFinished;
	protected int quantityInProgress;
	protected int quantityOrdered;
	protected int quantityShipped;
	protected int revision;
	protected DTimestamp scheduledFinishTime;
	protected DTimestamp scheduledStartTime;
	protected long shipAccountKey;
	protected DTimestamp shippedTime;
	protected short state;
	protected short status;
	protected long userAccountKey;
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
	 * Gets the value of the billAccountKey property.
	 * 
	 */
	public long getBillAccountKey() {
		return billAccountKey;
	}

	/**
	 * Sets the value of the billAccountKey property.
	 * 
	 */
	public void setBillAccountKey(long value) {
		this.billAccountKey = value;
	}

	/**
	 * Gets the value of the bomName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the value of the bomName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBomName(String value) {
		this.bomName = value;
	}

	/**
	 * Gets the value of the bomRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBomRevision() {
		return bomRevision;
	}

	/**
	 * Sets the value of the bomRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBomRevision(String value) {
		this.bomRevision = value;
	}

	/**
	 * Gets the value of the buildAccountKey property.
	 * 
	 */
	public long getBuildAccountKey() {
		return buildAccountKey;
	}

	/**
	 * Sets the value of the buildAccountKey property.
	 * 
	 */
	public void setBuildAccountKey(long value) {
		this.buildAccountKey = value;
	}

	/**
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
	}

	/**
	 * Gets the value of the finishedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getFinishedTime() {
		return finishedTime;
	}

	/**
	 * Sets the value of the finishedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setFinishedTime(DTimestamp value) {
		this.finishedTime = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the note property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the value of the note property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNote(String value) {
		this.note = value;
	}

	/**
	 * Gets the value of the orderKey property.
	 * 
	 */
	public long getOrderKey() {
		return orderKey;
	}

	/**
	 * Sets the value of the orderKey property.
	 * 
	 */
	public void setOrderKey(long value) {
		this.orderKey = value;
	}

	/**
	 * Gets the value of the orderState property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderState() {
		return orderState;
	}

	/**
	 * Sets the value of the orderState property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderState(String value) {
		this.orderState = value;
	}

	/**
	 * Gets the value of the partNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * Sets the value of the partNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartNumber(String value) {
		this.partNumber = value;
	}

	/**
	 * Gets the value of the partRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartRevision() {
		return partRevision;
	}

	/**
	 * Sets the value of the partRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartRevision(String value) {
		this.partRevision = value;
	}

	/**
	 * Gets the value of the plannedFinishTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getPlannedFinishTime() {
		return plannedFinishTime;
	}

	/**
	 * Sets the value of the plannedFinishTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setPlannedFinishTime(DTimestamp value) {
		this.plannedFinishTime = value;
	}

	/**
	 * Gets the value of the plannedProductionLine property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlannedProductionLine() {
		return plannedProductionLine;
	}

	/**
	 * Sets the value of the plannedProductionLine property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlannedProductionLine(String value) {
		this.plannedProductionLine = value;
	}

	/**
	 * Gets the value of the plannedRoute property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlannedRoute() {
		return plannedRoute;
	}

	/**
	 * Sets the value of the plannedRoute property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlannedRoute(String value) {
		this.plannedRoute = value;
	}

	/**
	 * Gets the value of the plannedRouteKey property.
	 * 
	 */
	public long getPlannedRouteKey() {
		return plannedRouteKey;
	}

	/**
	 * Sets the value of the plannedRouteKey property.
	 * 
	 */
	public void setPlannedRouteKey(long value) {
		this.plannedRouteKey = value;
	}

	/**
	 * Gets the value of the plannedStartTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getPlannedStartTime() {
		return plannedStartTime;
	}

	/**
	 * Sets the value of the plannedStartTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setPlannedStartTime(DTimestamp value) {
		this.plannedStartTime = value;
	}

	/**
	 * Gets the value of the preciseQuantityClosed property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPreciseQuantityClosed() {
		return preciseQuantityClosed;
	}

	/**
	 * Sets the value of the preciseQuantityClosed property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPreciseQuantityClosed(BigDecimal value) {
		this.preciseQuantityClosed = value;
	}

	/**
	 * Gets the value of the preciseQuantityFinished property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPreciseQuantityFinished() {
		return preciseQuantityFinished;
	}

	/**
	 * Sets the value of the preciseQuantityFinished property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPreciseQuantityFinished(BigDecimal value) {
		this.preciseQuantityFinished = value;
	}

	/**
	 * Gets the value of the preciseQuantityInProgress property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPreciseQuantityInProgress() {
		return preciseQuantityInProgress;
	}

	/**
	 * Sets the value of the preciseQuantityInProgress property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPreciseQuantityInProgress(BigDecimal value) {
		this.preciseQuantityInProgress = value;
	}

	/**
	 * Gets the value of the preciseQuantityOrdered property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPreciseQuantityOrdered() {
		return preciseQuantityOrdered;
	}

	/**
	 * Sets the value of the preciseQuantityOrdered property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPreciseQuantityOrdered(BigDecimal value) {
		this.preciseQuantityOrdered = value;
	}

	/**
	 * Gets the value of the preciseQuantityShipped property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPreciseQuantityShipped() {
		return preciseQuantityShipped;
	}

	/**
	 * Sets the value of the preciseQuantityShipped property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPreciseQuantityShipped(BigDecimal value) {
		this.preciseQuantityShipped = value;
	}

	/**
	 * Gets the value of the quantityClosed property.
	 * 
	 */
	public int getQuantityClosed() {
		return quantityClosed;
	}

	/**
	 * Sets the value of the quantityClosed property.
	 * 
	 */
	public void setQuantityClosed(int value) {
		this.quantityClosed = value;
	}

	/**
	 * Gets the value of the quantityFinished property.
	 * 
	 */
	public int getQuantityFinished() {
		return quantityFinished;
	}

	/**
	 * Sets the value of the quantityFinished property.
	 * 
	 */
	public void setQuantityFinished(int value) {
		this.quantityFinished = value;
	}

	/**
	 * Gets the value of the quantityInProgress property.
	 * 
	 */
	public int getQuantityInProgress() {
		return quantityInProgress;
	}

	/**
	 * Sets the value of the quantityInProgress property.
	 * 
	 */
	public void setQuantityInProgress(int value) {
		this.quantityInProgress = value;
	}

	/**
	 * Gets the value of the quantityOrdered property.
	 * 
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * Sets the value of the quantityOrdered property.
	 * 
	 */
	public void setQuantityOrdered(int value) {
		this.quantityOrdered = value;
	}

	/**
	 * Gets the value of the quantityShipped property.
	 * 
	 */
	public int getQuantityShipped() {
		return quantityShipped;
	}

	/**
	 * Sets the value of the quantityShipped property.
	 * 
	 */
	public void setQuantityShipped(int value) {
		this.quantityShipped = value;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 */
	public int getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 */
	public void setRevision(int value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the scheduledFinishTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getScheduledFinishTime() {
		return scheduledFinishTime;
	}

	/**
	 * Sets the value of the scheduledFinishTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setScheduledFinishTime(DTimestamp value) {
		this.scheduledFinishTime = value;
	}

	/**
	 * Gets the value of the scheduledStartTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getScheduledStartTime() {
		return scheduledStartTime;
	}

	/**
	 * Sets the value of the scheduledStartTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setScheduledStartTime(DTimestamp value) {
		this.scheduledStartTime = value;
	}

	/**
	 * Gets the value of the shipAccountKey property.
	 * 
	 */
	public long getShipAccountKey() {
		return shipAccountKey;
	}

	/**
	 * Sets the value of the shipAccountKey property.
	 * 
	 */
	public void setShipAccountKey(long value) {
		this.shipAccountKey = value;
	}

	/**
	 * Gets the value of the shippedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getShippedTime() {
		return shippedTime;
	}

	/**
	 * Sets the value of the shippedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setShippedTime(DTimestamp value) {
		this.shippedTime = value;
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
	 * Gets the value of the userAccountKey property.
	 * 
	 */
	public long getUserAccountKey() {
		return userAccountKey;
	}

	/**
	 * Sets the value of the userAccountKey property.
	 * 
	 */
	public void setUserAccountKey(long value) {
		this.userAccountKey = value;
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
