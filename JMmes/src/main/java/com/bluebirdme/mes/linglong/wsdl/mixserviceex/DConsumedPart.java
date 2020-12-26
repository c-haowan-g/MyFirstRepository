package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConsumedPart complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConsumedPart">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="alternateBomItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="consumptionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consumptionType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expirationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="FSMRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FSMTransitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastModifierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partBatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partInvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partSerial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partSublot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partTBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTrackedObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTrackedObjectSiteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="partTrackedObjectStatusKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTrackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scaledQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tbomPartListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DConsumedPart", propOrder = { "alternateBomItemKey",
		"consumptionStatus", "consumptionType", "creatorName",
		"expirationTime", "fsmRelationshipName", "fsmTransitionName",
		"lastComment", "lastModifierName", "operationName", "partBatch",
		"partInvoice", "partKey", "partNumber", "partQuantity", "partRevision",
		"partSerial", "partSublot", "partTBomKey", "partTrackedObjectKey",
		"partTrackedObjectSiteNumber", "partTrackedObjectStatusKey",
		"partTrackedObjectType", "placement", "productionLineName", "routeKey",
		"routeName", "routeStepName", "scaledQuantity", "tbomPartListKey",
		"trackedObjectKey", "trackedObjectType", "workCenterName" })
public class DConsumedPart extends DCategorical {

	protected long alternateBomItemKey;
	protected String consumptionStatus;
	protected int consumptionType;
	protected String creatorName;
	protected DTimestamp expirationTime;
	@XmlElement(name = "FSMRelationshipName")
	protected String fsmRelationshipName;
	@XmlElement(name = "FSMTransitionName")
	protected String fsmTransitionName;
	protected String lastComment;
	protected String lastModifierName;
	protected String operationName;
	protected String partBatch;
	protected String partInvoice;
	protected long partKey;
	protected String partNumber;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal partQuantity;
	protected String partRevision;
	protected String partSerial;
	protected String partSublot;
	protected long partTBomKey;
	protected long partTrackedObjectKey;
	protected int partTrackedObjectSiteNumber;
	protected long partTrackedObjectStatusKey;
	protected String partTrackedObjectType;
	protected String placement;
	protected String productionLineName;
	protected long routeKey;
	protected String routeName;
	protected String routeStepName;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal scaledQuantity;
	protected long tbomPartListKey;
	protected long trackedObjectKey;
	protected String trackedObjectType;
	protected String workCenterName;

	/**
	 * Gets the value of the alternateBomItemKey property.
	 * 
	 */
	public long getAlternateBomItemKey() {
		return alternateBomItemKey;
	}

	/**
	 * Sets the value of the alternateBomItemKey property.
	 * 
	 */
	public void setAlternateBomItemKey(long value) {
		this.alternateBomItemKey = value;
	}

	/**
	 * Gets the value of the consumptionStatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConsumptionStatus() {
		return consumptionStatus;
	}

	/**
	 * Sets the value of the consumptionStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConsumptionStatus(String value) {
		this.consumptionStatus = value;
	}

	/**
	 * Gets the value of the consumptionType property.
	 * 
	 */
	public int getConsumptionType() {
		return consumptionType;
	}

	/**
	 * Sets the value of the consumptionType property.
	 * 
	 */
	public void setConsumptionType(int value) {
		this.consumptionType = value;
	}

	/**
	 * Gets the value of the creatorName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * Sets the value of the creatorName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCreatorName(String value) {
		this.creatorName = value;
	}

	/**
	 * Gets the value of the expirationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExpirationTime() {
		return expirationTime;
	}

	/**
	 * Sets the value of the expirationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExpirationTime(DTimestamp value) {
		this.expirationTime = value;
	}

	/**
	 * Gets the value of the fsmRelationshipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSMRelationshipName() {
		return fsmRelationshipName;
	}

	/**
	 * Sets the value of the fsmRelationshipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSMRelationshipName(String value) {
		this.fsmRelationshipName = value;
	}

	/**
	 * Gets the value of the fsmTransitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSMTransitionName() {
		return fsmTransitionName;
	}

	/**
	 * Sets the value of the fsmTransitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSMTransitionName(String value) {
		this.fsmTransitionName = value;
	}

	/**
	 * Gets the value of the lastComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastComment() {
		return lastComment;
	}

	/**
	 * Sets the value of the lastComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastComment(String value) {
		this.lastComment = value;
	}

	/**
	 * Gets the value of the lastModifierName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastModifierName() {
		return lastModifierName;
	}

	/**
	 * Sets the value of the lastModifierName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLastModifierName(String value) {
		this.lastModifierName = value;
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
	 * Gets the value of the partBatch property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartBatch() {
		return partBatch;
	}

	/**
	 * Sets the value of the partBatch property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartBatch(String value) {
		this.partBatch = value;
	}

	/**
	 * Gets the value of the partInvoice property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartInvoice() {
		return partInvoice;
	}

	/**
	 * Sets the value of the partInvoice property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartInvoice(String value) {
		this.partInvoice = value;
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
	 * Gets the value of the partQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPartQuantity() {
		return partQuantity;
	}

	/**
	 * Sets the value of the partQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPartQuantity(BigDecimal value) {
		this.partQuantity = value;
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
	 * Gets the value of the partSerial property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartSerial() {
		return partSerial;
	}

	/**
	 * Sets the value of the partSerial property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartSerial(String value) {
		this.partSerial = value;
	}

	/**
	 * Gets the value of the partSublot property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartSublot() {
		return partSublot;
	}

	/**
	 * Sets the value of the partSublot property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartSublot(String value) {
		this.partSublot = value;
	}

	/**
	 * Gets the value of the partTBomKey property.
	 * 
	 */
	public long getPartTBomKey() {
		return partTBomKey;
	}

	/**
	 * Sets the value of the partTBomKey property.
	 * 
	 */
	public void setPartTBomKey(long value) {
		this.partTBomKey = value;
	}

	/**
	 * Gets the value of the partTrackedObjectKey property.
	 * 
	 */
	public long getPartTrackedObjectKey() {
		return partTrackedObjectKey;
	}

	/**
	 * Sets the value of the partTrackedObjectKey property.
	 * 
	 */
	public void setPartTrackedObjectKey(long value) {
		this.partTrackedObjectKey = value;
	}

	/**
	 * Gets the value of the partTrackedObjectSiteNumber property.
	 * 
	 */
	public int getPartTrackedObjectSiteNumber() {
		return partTrackedObjectSiteNumber;
	}

	/**
	 * Sets the value of the partTrackedObjectSiteNumber property.
	 * 
	 */
	public void setPartTrackedObjectSiteNumber(int value) {
		this.partTrackedObjectSiteNumber = value;
	}

	/**
	 * Gets the value of the partTrackedObjectStatusKey property.
	 * 
	 */
	public long getPartTrackedObjectStatusKey() {
		return partTrackedObjectStatusKey;
	}

	/**
	 * Sets the value of the partTrackedObjectStatusKey property.
	 * 
	 */
	public void setPartTrackedObjectStatusKey(long value) {
		this.partTrackedObjectStatusKey = value;
	}

	/**
	 * Gets the value of the partTrackedObjectType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartTrackedObjectType() {
		return partTrackedObjectType;
	}

	/**
	 * Sets the value of the partTrackedObjectType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartTrackedObjectType(String value) {
		this.partTrackedObjectType = value;
	}

	/**
	 * Gets the value of the placement property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlacement() {
		return placement;
	}

	/**
	 * Sets the value of the placement property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPlacement(String value) {
		this.placement = value;
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
	 * Gets the value of the scaledQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getScaledQuantity() {
		return scaledQuantity;
	}

	/**
	 * Sets the value of the scaledQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setScaledQuantity(BigDecimal value) {
		this.scaledQuantity = value;
	}

	/**
	 * Gets the value of the tbomPartListKey property.
	 * 
	 */
	public long getTbomPartListKey() {
		return tbomPartListKey;
	}

	/**
	 * Sets the value of the tbomPartListKey property.
	 * 
	 */
	public void setTbomPartListKey(long value) {
		this.tbomPartListKey = value;
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
