package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractBomItem">
 *       &lt;sequence>
 *         &lt;element name="alternateBomItems" type="{dataobjects.common.plantops.datasweep.com}DAlternateBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="consumptionPlans" type="{dataobjects.common.plantops.datasweep.com}DConsumptionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productionPlans" type="{dataobjects.common.plantops.datasweep.com}DProductionPlan" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBomItem", propOrder = { "alternateBomItems", "auditInfo",
		"consumptionPlans", "productionPlans" })
public class DBomItem extends DAbstractBomItem {

	@XmlElement(nillable = true)
	protected List<DAlternateBomItem> alternateBomItems;
	protected DAuditInfo auditInfo;
	@XmlElement(nillable = true)
	protected List<DConsumptionPlan> consumptionPlans;
	@XmlElement(nillable = true)
	protected List<DProductionPlan> productionPlans;

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
	 * {@link DAlternateBomItem }
	 * 
	 * 
	 */
	public List<DAlternateBomItem> getAlternateBomItems() {
		if (alternateBomItems == null) {
			alternateBomItems = new ArrayList<DAlternateBomItem>();
		}
		return this.alternateBomItems;
	}

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
	 * {@link DConsumptionPlan }
	 * 
	 * 
	 */
	public List<DConsumptionPlan> getConsumptionPlans() {
		if (consumptionPlans == null) {
			consumptionPlans = new ArrayList<DConsumptionPlan>();
		}
		return this.consumptionPlans;
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
	 * {@link DProductionPlan }
	 * 
	 * 
	 */
	public List<DProductionPlan> getProductionPlans() {
		if (productionPlans == null) {
			productionPlans = new ArrayList<DProductionPlan>();
		}
		return this.productionPlans;
	}

}
