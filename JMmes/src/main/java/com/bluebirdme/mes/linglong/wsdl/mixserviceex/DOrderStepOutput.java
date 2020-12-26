package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOrderStepOutput complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOrderStepOutput">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="actualQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="carrierClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderStepInputReferences" type="{dataobjects.common.plantops.datasweep.com}DGuidReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="plannedQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="processingType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="producedSublotInfoItems" type="{dataobjects.common.plantops.datasweep.com}DProducedSublotInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="runtimeMFCKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceSpecifier" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="storageUnitClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DOrderStepOutput", propOrder = { "actualQuantity",
		"auditInfo", "carrierClassKey", "controlRecipeKey", "currentStates",
		"objectType", "orderStepInputReferences", "orderStepKey", "partKey",
		"plannedQuantity", "processingType", "producedSublotInfoItems",
		"runtimeMFCKey", "sourceSpecifier", "storageUnitClassKey",
		"userDefinedAttributes" })
public class DOrderStepOutput extends DKeyed {

	protected DMeasuredValue actualQuantity;
	protected DAuditInfo auditInfo;
	protected long carrierClassKey;
	protected long controlRecipeKey;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected short objectType;
	@XmlElement(nillable = true)
	protected List<DGuidReference> orderStepInputReferences;
	protected long orderStepKey;
	protected long partKey;
	protected DMeasuredValue plannedQuantity;
	protected int processingType;
	@XmlElement(nillable = true)
	protected List<DProducedSublotInfo> producedSublotInfoItems;
	protected long runtimeMFCKey;
	protected short sourceSpecifier;
	protected long storageUnitClassKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the actualQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getActualQuantity() {
		return actualQuantity;
	}

	/**
	 * Sets the value of the actualQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setActualQuantity(DMeasuredValue value) {
		this.actualQuantity = value;
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
	 * Gets the value of the carrierClassKey property.
	 * 
	 */
	public long getCarrierClassKey() {
		return carrierClassKey;
	}

	/**
	 * Sets the value of the carrierClassKey property.
	 * 
	 */
	public void setCarrierClassKey(long value) {
		this.carrierClassKey = value;
	}

	/**
	 * Gets the value of the controlRecipeKey property.
	 * 
	 */
	public long getControlRecipeKey() {
		return controlRecipeKey;
	}

	/**
	 * Sets the value of the controlRecipeKey property.
	 * 
	 */
	public void setControlRecipeKey(long value) {
		this.controlRecipeKey = value;
	}

	/**
	 * Gets the value of the currentStates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the currentStates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCurrentStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DObjectState }
	 * 
	 * 
	 */
	public List<DObjectState> getCurrentStates() {
		if (currentStates == null) {
			currentStates = new ArrayList<DObjectState>();
		}
		return this.currentStates;
	}

	/**
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the orderStepInputReferences property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepInputReferences property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepInputReferences().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DGuidReference }
	 * 
	 * 
	 */
	public List<DGuidReference> getOrderStepInputReferences() {
		if (orderStepInputReferences == null) {
			orderStepInputReferences = new ArrayList<DGuidReference>();
		}
		return this.orderStepInputReferences;
	}

	/**
	 * Gets the value of the orderStepKey property.
	 * 
	 */
	public long getOrderStepKey() {
		return orderStepKey;
	}

	/**
	 * Sets the value of the orderStepKey property.
	 * 
	 */
	public void setOrderStepKey(long value) {
		this.orderStepKey = value;
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
	 * Gets the value of the plannedQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getPlannedQuantity() {
		return plannedQuantity;
	}

	/**
	 * Sets the value of the plannedQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setPlannedQuantity(DMeasuredValue value) {
		this.plannedQuantity = value;
	}

	/**
	 * Gets the value of the processingType property.
	 * 
	 */
	public int getProcessingType() {
		return processingType;
	}

	/**
	 * Sets the value of the processingType property.
	 * 
	 */
	public void setProcessingType(int value) {
		this.processingType = value;
	}

	/**
	 * Gets the value of the producedSublotInfoItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the producedSublotInfoItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProducedSublotInfoItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DProducedSublotInfo }
	 * 
	 * 
	 */
	public List<DProducedSublotInfo> getProducedSublotInfoItems() {
		if (producedSublotInfoItems == null) {
			producedSublotInfoItems = new ArrayList<DProducedSublotInfo>();
		}
		return this.producedSublotInfoItems;
	}

	/**
	 * Gets the value of the runtimeMFCKey property.
	 * 
	 */
	public long getRuntimeMFCKey() {
		return runtimeMFCKey;
	}

	/**
	 * Sets the value of the runtimeMFCKey property.
	 * 
	 */
	public void setRuntimeMFCKey(long value) {
		this.runtimeMFCKey = value;
	}

	/**
	 * Gets the value of the sourceSpecifier property.
	 * 
	 */
	public short getSourceSpecifier() {
		return sourceSpecifier;
	}

	/**
	 * Sets the value of the sourceSpecifier property.
	 * 
	 */
	public void setSourceSpecifier(short value) {
		this.sourceSpecifier = value;
	}

	/**
	 * Gets the value of the storageUnitClassKey property.
	 * 
	 */
	public long getStorageUnitClassKey() {
		return storageUnitClassKey;
	}

	/**
	 * Sets the value of the storageUnitClassKey property.
	 * 
	 */
	public void setStorageUnitClassKey(long value) {
		this.storageUnitClassKey = value;
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
