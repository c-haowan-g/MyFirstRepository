package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTrackedObjectStepHistory complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTrackedObjectStepHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="boxRevision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="completeComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="completePauseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="completeQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="completeReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="completeShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="completeTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="completeUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equipmentKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="equipmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startPauseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="startShiftKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="startUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackedObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DTrackedObjectStepHistory", propOrder = { "boxRevision",
		"completeComment", "completeCount", "completePauseDuration",
		"completeQuantity", "completeReason", "completeShiftKey",
		"completeTime", "completeUserName", "equipmentKeys", "equipmentName",
		"operationName", "productionLineName", "routeKey", "routeName",
		"routeStepName", "startComment", "startCount", "startPauseDuration",
		"startQuantity", "startShiftKey", "startTime", "startUserName",
		"trackedObjectKey", "trackedObjectType", "workCenterName" })
public class DTrackedObjectStepHistory extends DKeyed {

	protected int boxRevision;
	protected String completeComment;
	protected int completeCount;
	protected int completePauseDuration;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal completeQuantity;
	protected String completeReason;
	protected long completeShiftKey;
	protected DTimestamp completeTime;
	protected String completeUserName;
	@XmlElement(type = Long.class)
	protected List<Long> equipmentKeys;
	protected String equipmentName;
	protected String operationName;
	protected String productionLineName;
	protected long routeKey;
	protected String routeName;
	protected String routeStepName;
	protected String startComment;
	protected int startCount;
	protected int startPauseDuration;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal startQuantity;
	protected long startShiftKey;
	protected DTimestamp startTime;
	protected String startUserName;
	protected long trackedObjectKey;
	protected String trackedObjectType;
	protected String workCenterName;

	/**
	 * Gets the value of the boxRevision property.
	 * 
	 */
	public int getBoxRevision() {
		return boxRevision;
	}

	/**
	 * Sets the value of the boxRevision property.
	 * 
	 */
	public void setBoxRevision(int value) {
		this.boxRevision = value;
	}

	/**
	 * Gets the value of the completeComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteComment() {
		return completeComment;
	}

	/**
	 * Sets the value of the completeComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteComment(String value) {
		this.completeComment = value;
	}

	/**
	 * Gets the value of the completeCount property.
	 * 
	 */
	public int getCompleteCount() {
		return completeCount;
	}

	/**
	 * Sets the value of the completeCount property.
	 * 
	 */
	public void setCompleteCount(int value) {
		this.completeCount = value;
	}

	/**
	 * Gets the value of the completePauseDuration property.
	 * 
	 */
	public int getCompletePauseDuration() {
		return completePauseDuration;
	}

	/**
	 * Sets the value of the completePauseDuration property.
	 * 
	 */
	public void setCompletePauseDuration(int value) {
		this.completePauseDuration = value;
	}

	/**
	 * Gets the value of the completeQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCompleteQuantity() {
		return completeQuantity;
	}

	/**
	 * Sets the value of the completeQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCompleteQuantity(BigDecimal value) {
		this.completeQuantity = value;
	}

	/**
	 * Gets the value of the completeReason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteReason() {
		return completeReason;
	}

	/**
	 * Sets the value of the completeReason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteReason(String value) {
		this.completeReason = value;
	}

	/**
	 * Gets the value of the completeShiftKey property.
	 * 
	 */
	public long getCompleteShiftKey() {
		return completeShiftKey;
	}

	/**
	 * Sets the value of the completeShiftKey property.
	 * 
	 */
	public void setCompleteShiftKey(long value) {
		this.completeShiftKey = value;
	}

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
	 * Gets the value of the completeUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompleteUserName() {
		return completeUserName;
	}

	/**
	 * Sets the value of the completeUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompleteUserName(String value) {
		this.completeUserName = value;
	}

	/**
	 * Gets the value of the equipmentKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the equipmentKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEquipmentKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getEquipmentKeys() {
		if (equipmentKeys == null) {
			equipmentKeys = new ArrayList<Long>();
		}
		return this.equipmentKeys;
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
	 * Gets the value of the startComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStartComment() {
		return startComment;
	}

	/**
	 * Sets the value of the startComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStartComment(String value) {
		this.startComment = value;
	}

	/**
	 * Gets the value of the startCount property.
	 * 
	 */
	public int getStartCount() {
		return startCount;
	}

	/**
	 * Sets the value of the startCount property.
	 * 
	 */
	public void setStartCount(int value) {
		this.startCount = value;
	}

	/**
	 * Gets the value of the startPauseDuration property.
	 * 
	 */
	public int getStartPauseDuration() {
		return startPauseDuration;
	}

	/**
	 * Sets the value of the startPauseDuration property.
	 * 
	 */
	public void setStartPauseDuration(int value) {
		this.startPauseDuration = value;
	}

	/**
	 * Gets the value of the startQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getStartQuantity() {
		return startQuantity;
	}

	/**
	 * Sets the value of the startQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setStartQuantity(BigDecimal value) {
		this.startQuantity = value;
	}

	/**
	 * Gets the value of the startShiftKey property.
	 * 
	 */
	public long getStartShiftKey() {
		return startShiftKey;
	}

	/**
	 * Sets the value of the startShiftKey property.
	 * 
	 */
	public void setStartShiftKey(long value) {
		this.startShiftKey = value;
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
	 * Gets the value of the startUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStartUserName() {
		return startUserName;
	}

	/**
	 * Sets the value of the startUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStartUserName(String value) {
		this.startUserName = value;
	}

	/**
	 * Gets the value of the trackedObjectKey property.
	 * 
	 */
	public long getTrackedObjectKey() {
		return trackedObjectKey;
	}

	/**
	 * Sets the value of the trackedObjectKey property.
	 * 
	 */
	public void setTrackedObjectKey(long value) {
		this.trackedObjectKey = value;
	}

	/**
	 * Gets the value of the trackedObjectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrackedObjectType() {
		return trackedObjectType;
	}

	/**
	 * Sets the value of the trackedObjectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrackedObjectType(String value) {
		this.trackedObjectType = value;
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
