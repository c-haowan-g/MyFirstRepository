package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DInventoryBatchReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DInventoryBatchReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batches" type="{dataobjects.common.plantops.datasweep.com}DBatch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="container" type="{dataobjects.common.plantops.datasweep.com}DISublotContainer" minOccurs="0"/>
 *         &lt;element name="inventoryBatches" type="{dataobjects.common.plantops.datasweep.com}DInventoryBatch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublotRelations" type="{dataobjects.common.plantops.datasweep.com}DSublotRelation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublots" type="{dataobjects.common.plantops.datasweep.com}DSublot" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DInventoryBatchReturnData", propOrder = { "batches",
		"container", "inventoryBatches", "sublotRelations", "sublots" })
public class DInventoryBatchReturnData {

	@XmlElement(nillable = true)
	protected List<DBatch> batches;
	protected DISublotContainer container;
	@XmlElement(nillable = true)
	protected List<DInventoryBatch> inventoryBatches;
	@XmlElement(nillable = true)
	protected List<DSublotRelation> sublotRelations;
	@XmlElement(nillable = true)
	protected List<DSublot> sublots;

	/**
	 * Gets the value of the batches property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the batches property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBatches().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DBatch }
	 * 
	 * 
	 */
	public List<DBatch> getBatches() {
		if (batches == null) {
			batches = new ArrayList<DBatch>();
		}
		return this.batches;
	}

	/**
	 * Gets the value of the container property.
	 * 
	 * @return possible object is {@link DISublotContainer }
	 * 
	 */
	public DISublotContainer getContainer() {
		return container;
	}

	/**
	 * Sets the value of the container property.
	 * 
	 * @param value
	 *            allowed object is {@link DISublotContainer }
	 * 
	 */
	public void setContainer(DISublotContainer value) {
		this.container = value;
	}

	/**
	 * Gets the value of the inventoryBatches property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the inventoryBatches property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInventoryBatches().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DInventoryBatch }
	 * 
	 * 
	 */
	public List<DInventoryBatch> getInventoryBatches() {
		if (inventoryBatches == null) {
			inventoryBatches = new ArrayList<DInventoryBatch>();
		}
		return this.inventoryBatches;
	}

	/**
	 * Gets the value of the sublotRelations property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sublotRelations property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSublotRelations().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSublotRelation }
	 * 
	 * 
	 */
	public List<DSublotRelation> getSublotRelations() {
		if (sublotRelations == null) {
			sublotRelations = new ArrayList<DSublotRelation>();
		}
		return this.sublotRelations;
	}

	/**
	 * Gets the value of the sublots property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sublots property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSublots().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DSublot }
	 * 
	 * 
	 */
	public List<DSublot> getSublots() {
		if (sublots == null) {
			sublots = new ArrayList<DSublot>();
		}
		return this.sublots;
	}

}
