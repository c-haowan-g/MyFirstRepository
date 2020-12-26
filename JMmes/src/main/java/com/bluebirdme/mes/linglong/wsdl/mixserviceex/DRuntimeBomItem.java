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
 * Java class for DRuntimeBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBomItem">
 *       &lt;sequence>
 *         &lt;element name="alternateBomItems" type="{dataobjects.common.plantops.datasweep.com}DRuntimeAlternateBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bomTrackedMode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="consumedParts" type="{dataobjects.common.plantops.datasweep.com}DConsumedPart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="consumptionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumptionPlans" type="{dataobjects.common.plantops.datasweep.com}DRuntimeConsumptionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="partAssociationType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="productionPlans" type="{dataobjects.common.plantops.datasweep.com}DRuntimeProductionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="quantityConsumed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="remainingConsumptionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackedObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRuntimeBomItem", propOrder = { "alternateBomItems",
		"bomTrackedMode", "consumedParts", "consumptionDuration",
		"consumptionPlans", "creationTime", "lastModifiedTime",
		"partAssociationType", "partKey", "partTBomKey", "productionPlans",
		"quantityConsumed", "remainingConsumptionDuration", "status",
		"trackedObjectKey", "trackedObjectType" })
public class DRuntimeBomItem extends DAbstractBomItem {

	@XmlElement(nillable = true)
	protected List<DRuntimeAlternateBomItem> alternateBomItems;
	protected short bomTrackedMode;
	@XmlElement(nillable = true)
	protected List<DConsumedPart> consumedParts;
	protected int consumptionDuration;
	@XmlElement(nillable = true)
	protected List<DRuntimeConsumptionPlan> consumptionPlans;
	protected DTimestamp creationTime;
	protected DTimestamp lastModifiedTime;
	protected short partAssociationType;
	protected long partKey;
	protected long partTBomKey;
	@XmlElement(nillable = true)
	protected List<DRuntimeProductionPlan> productionPlans;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityConsumed;
	protected int remainingConsumptionDuration;
	protected String status;
	protected long trackedObjectKey;
	protected String trackedObjectType;

	/**
	 * Gets the value of the alternateBomItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the alternateBomItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAlternateBomItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeAlternateBomItem }
	 * 
	 * 
	 */
	public List<DRuntimeAlternateBomItem> getAlternateBomItems() {
		if (alternateBomItems == null) {
			alternateBomItems = new ArrayList<DRuntimeAlternateBomItem>();
		}
		return this.alternateBomItems;
	}

	/**
	 * Gets the value of the bomTrackedMode property.
	 * 
	 */
	public short getBomTrackedMode() {
		return bomTrackedMode;
	}

	/**
	 * Sets the value of the bomTrackedMode property.
	 * 
	 */
	public void setBomTrackedMode(short value) {
		this.bomTrackedMode = value;
	}

	/**
	 * Gets the value of the consumedParts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the consumedParts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConsumedParts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConsumedPart }
	 * 
	 * 
	 */
	public List<DConsumedPart> getConsumedParts() {
		if (consumedParts == null) {
			consumedParts = new ArrayList<DConsumedPart>();
		}
		return this.consumedParts;
	}

	/**
	 * Gets the value of the consumptionDuration property.
	 * 
	 */
	public int getConsumptionDuration() {
		return consumptionDuration;
	}

	/**
	 * Sets the value of the consumptionDuration property.
	 * 
	 */
	public void setConsumptionDuration(int value) {
		this.consumptionDuration = value;
	}

	/**
	 * Gets the value of the consumptionPlans property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the consumptionPlans property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConsumptionPlans().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeConsumptionPlan }
	 * 
	 * 
	 */
	public List<DRuntimeConsumptionPlan> getConsumptionPlans() {
		if (consumptionPlans == null) {
			consumptionPlans = new ArrayList<DRuntimeConsumptionPlan>();
		}
		return this.consumptionPlans;
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
	 * Gets the value of the partAssociationType property.
	 * 
	 */
	public short getPartAssociationType() {
		return partAssociationType;
	}

	/**
	 * Sets the value of the partAssociationType property.
	 * 
	 */
	public void setPartAssociationType(short value) {
		this.partAssociationType = value;
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
	 * Gets the value of the productionPlans property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productionPlans property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductionPlans().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeProductionPlan }
	 * 
	 * 
	 */
	public List<DRuntimeProductionPlan> getProductionPlans() {
		if (productionPlans == null) {
			productionPlans = new ArrayList<DRuntimeProductionPlan>();
		}
		return this.productionPlans;
	}

	/**
	 * Gets the value of the quantityConsumed property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityConsumed() {
		return quantityConsumed;
	}

	/**
	 * Sets the value of the quantityConsumed property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityConsumed(BigDecimal value) {
		this.quantityConsumed = value;
	}

	/**
	 * Gets the value of the remainingConsumptionDuration property.
	 * 
	 */
	public int getRemainingConsumptionDuration() {
		return remainingConsumptionDuration;
	}

	/**
	 * Sets the value of the remainingConsumptionDuration property.
	 * 
	 */
	public void setRemainingConsumptionDuration(int value) {
		this.remainingConsumptionDuration = value;
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

}
