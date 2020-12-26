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
 * Java class for DTemplateBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTemplateBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBomItem">
 *       &lt;sequence>
 *         &lt;element name="alternateBomItems" type="{dataobjects.common.plantops.datasweep.com}DTemplateAlternateBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bomRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bomTrackedMode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="consumptionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumptionPlans" type="{dataobjects.common.plantops.datasweep.com}DTemplateConsumptionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="handleKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="partAssociationType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partTBomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partTBomRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productionPlans" type="{dataobjects.common.plantops.datasweep.com}DTemplateProductionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="quantityConsumed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="remainingConsumptionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTemplateBomItem", propOrder = { "alternateBomItems",
		"bomName", "bomRevision", "bomTrackedMode", "consumptionDuration",
		"consumptionPlans", "creationTime", "handleKey", "lastModifiedTime",
		"partAssociationType", "partKey", "partTBomKey", "partTBomName",
		"partTBomRevision", "productionPlans", "quantityConsumed",
		"remainingConsumptionDuration", "status", "subBomKey" })
public class DTemplateBomItem extends DAbstractBomItem {

	@XmlElement(nillable = true)
	protected List<DTemplateAlternateBomItem> alternateBomItems;
	protected String bomName;
	protected String bomRevision;
	protected short bomTrackedMode;
	protected int consumptionDuration;
	@XmlElement(nillable = true)
	protected List<DTemplateConsumptionPlan> consumptionPlans;
	protected DTimestamp creationTime;
	protected long handleKey;
	protected DTimestamp lastModifiedTime;
	protected short partAssociationType;
	protected long partKey;
	protected long partTBomKey;
	protected String partTBomName;
	protected String partTBomRevision;
	@XmlElement(nillable = true)
	protected List<DTemplateProductionPlan> productionPlans;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityConsumed;
	protected int remainingConsumptionDuration;
	protected String status;
	protected long subBomKey;

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
	 * {@link DTemplateAlternateBomItem }
	 * 
	 * 
	 */
	public List<DTemplateAlternateBomItem> getAlternateBomItems() {
		if (alternateBomItems == null) {
			alternateBomItems = new ArrayList<DTemplateAlternateBomItem>();
		}
		return this.alternateBomItems;
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
	 * {@link DTemplateConsumptionPlan }
	 * 
	 * 
	 */
	public List<DTemplateConsumptionPlan> getConsumptionPlans() {
		if (consumptionPlans == null) {
			consumptionPlans = new ArrayList<DTemplateConsumptionPlan>();
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
	 * Gets the value of the handleKey property.
	 * 
	 */
	public long getHandleKey() {
		return handleKey;
	}

	/**
	 * Sets the value of the handleKey property.
	 * 
	 */
	public void setHandleKey(long value) {
		this.handleKey = value;
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
	 * Gets the value of the partTBomName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartTBomName() {
		return partTBomName;
	}

	/**
	 * Sets the value of the partTBomName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartTBomName(String value) {
		this.partTBomName = value;
	}

	/**
	 * Gets the value of the partTBomRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartTBomRevision() {
		return partTBomRevision;
	}

	/**
	 * Sets the value of the partTBomRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartTBomRevision(String value) {
		this.partTBomRevision = value;
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
	 * {@link DTemplateProductionPlan }
	 * 
	 * 
	 */
	public List<DTemplateProductionPlan> getProductionPlans() {
		if (productionPlans == null) {
			productionPlans = new ArrayList<DTemplateProductionPlan>();
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
	 * Gets the value of the subBomKey property.
	 * 
	 */
	public long getSubBomKey() {
		return subBomKey;
	}

	/**
	 * Sets the value of the subBomKey property.
	 * 
	 */
	public void setSubBomKey(long value) {
		this.subBomKey = value;
	}

}
