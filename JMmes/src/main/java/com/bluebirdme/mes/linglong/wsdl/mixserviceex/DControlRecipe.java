package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DControlRecipe complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DControlRecipe">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="initialOrderStepReferences" type="{dataobjects.common.plantops.datasweep.com}DGuidReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="masterRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="processBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processOrderItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="producedPartKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="runtimeMFC" type="{dataobjects.common.plantops.datasweep.com}DRuntimeMFC" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sequenceCounter" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="templateRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DControlRecipe", propOrder = { "currentStates",
		"initialOrderStepReferences", "masterRecipeKey", "objectType",
		"processBomKey", "processOrderItemKey", "producedPartKey",
		"runtimeMFC", "sequenceCounter", "targetQuantity", "templateRecipeKey",
		"userDefinedAttributes" })
public class DControlRecipe extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	@XmlElement(nillable = true)
	protected List<DGuidReference> initialOrderStepReferences;
	protected long masterRecipeKey;
	protected short objectType;
	protected long processBomKey;
	protected long processOrderItemKey;
	protected long producedPartKey;
	@XmlElement(nillable = true)
	protected List<DRuntimeMFC> runtimeMFC;
	protected int sequenceCounter;
	protected DMeasuredValue targetQuantity;
	protected long templateRecipeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the initialOrderStepReferences property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the initialOrderStepReferences property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInitialOrderStepReferences().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DGuidReference }
	 * 
	 * 
	 */
	public List<DGuidReference> getInitialOrderStepReferences() {
		if (initialOrderStepReferences == null) {
			initialOrderStepReferences = new ArrayList<DGuidReference>();
		}
		return this.initialOrderStepReferences;
	}

	/**
	 * Gets the value of the masterRecipeKey property.
	 * 
	 */
	public long getMasterRecipeKey() {
		return masterRecipeKey;
	}

	/**
	 * Sets the value of the masterRecipeKey property.
	 * 
	 */
	public void setMasterRecipeKey(long value) {
		this.masterRecipeKey = value;
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
	 * Gets the value of the processBomKey property.
	 * 
	 */
	public long getProcessBomKey() {
		return processBomKey;
	}

	/**
	 * Sets the value of the processBomKey property.
	 * 
	 */
	public void setProcessBomKey(long value) {
		this.processBomKey = value;
	}

	/**
	 * Gets the value of the processOrderItemKey property.
	 * 
	 */
	public long getProcessOrderItemKey() {
		return processOrderItemKey;
	}

	/**
	 * Sets the value of the processOrderItemKey property.
	 * 
	 */
	public void setProcessOrderItemKey(long value) {
		this.processOrderItemKey = value;
	}

	/**
	 * Gets the value of the producedPartKey property.
	 * 
	 */
	public long getProducedPartKey() {
		return producedPartKey;
	}

	/**
	 * Sets the value of the producedPartKey property.
	 * 
	 */
	public void setProducedPartKey(long value) {
		this.producedPartKey = value;
	}

	/**
	 * Gets the value of the runtimeMFC property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the runtimeMFC property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRuntimeMFC().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeMFC }
	 * 
	 * 
	 */
	public List<DRuntimeMFC> getRuntimeMFC() {
		if (runtimeMFC == null) {
			runtimeMFC = new ArrayList<DRuntimeMFC>();
		}
		return this.runtimeMFC;
	}

	/**
	 * Gets the value of the sequenceCounter property.
	 * 
	 */
	public int getSequenceCounter() {
		return sequenceCounter;
	}

	/**
	 * Sets the value of the sequenceCounter property.
	 * 
	 */
	public void setSequenceCounter(int value) {
		this.sequenceCounter = value;
	}

	/**
	 * Gets the value of the targetQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getTargetQuantity() {
		return targetQuantity;
	}

	/**
	 * Sets the value of the targetQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setTargetQuantity(DMeasuredValue value) {
		this.targetQuantity = value;
	}

	/**
	 * Gets the value of the templateRecipeKey property.
	 * 
	 */
	public long getTemplateRecipeKey() {
		return templateRecipeKey;
	}

	/**
	 * Sets the value of the templateRecipeKey property.
	 * 
	 */
	public void setTemplateRecipeKey(long value) {
		this.templateRecipeKey = value;
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
