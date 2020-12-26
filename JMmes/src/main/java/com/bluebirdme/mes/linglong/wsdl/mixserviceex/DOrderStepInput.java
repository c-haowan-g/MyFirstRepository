package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOrderStepInput complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOrderStepInput">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="actualQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="attachSublotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="attachTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="attachUserKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="contributorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderStepOutputReferences" type="{dataobjects.common.plantops.datasweep.com}DGuidReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="partKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="plannedQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="processingType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="runtimeMFCKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DOrderStepInput", propOrder = { "actualQuantity",
		"attachSublotKey", "attachTime", "attachUserKey", "auditInfo",
		"contributorID", "controlRecipeKey", "currentStates", "objectType",
		"orderStepKey", "orderStepOutputReferences", "partKey",
		"plannedQuantity", "processingType", "runtimeMFCKey",
		"userDefinedAttributes" })
public class DOrderStepInput extends DKeyed {

	protected DMeasuredValue actualQuantity;
	protected long attachSublotKey;
	protected DTimestamp attachTime;
	protected long attachUserKey;
	protected DAuditInfo auditInfo;
	protected String contributorID;
	protected long controlRecipeKey;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected short objectType;
	protected long orderStepKey;
	@XmlElement(nillable = true)
	protected List<DGuidReference> orderStepOutputReferences;
	protected long partKey;
	protected DMeasuredValue plannedQuantity;
	protected int processingType;
	protected long runtimeMFCKey;
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
	 * Gets the value of the attachSublotKey property.
	 * 
	 */
	public long getAttachSublotKey() {
		return attachSublotKey;
	}

	/**
	 * Sets the value of the attachSublotKey property.
	 * 
	 */
	public void setAttachSublotKey(long value) {
		this.attachSublotKey = value;
	}

	/**
	 * Gets the value of the attachTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getAttachTime() {
		return attachTime;
	}

	/**
	 * Sets the value of the attachTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setAttachTime(DTimestamp value) {
		this.attachTime = value;
	}

	/**
	 * Gets the value of the attachUserKey property.
	 * 
	 */
	public long getAttachUserKey() {
		return attachUserKey;
	}

	/**
	 * Sets the value of the attachUserKey property.
	 * 
	 */
	public void setAttachUserKey(long value) {
		this.attachUserKey = value;
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
	 * Gets the value of the contributorID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContributorID() {
		return contributorID;
	}

	/**
	 * Sets the value of the contributorID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContributorID(String value) {
		this.contributorID = value;
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
	 * Gets the value of the orderStepOutputReferences property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepOutputReferences property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepOutputReferences().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DGuidReference }
	 * 
	 * 
	 */
	public List<DGuidReference> getOrderStepOutputReferences() {
		if (orderStepOutputReferences == null) {
			orderStepOutputReferences = new ArrayList<DGuidReference>();
		}
		return this.orderStepOutputReferences;
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
