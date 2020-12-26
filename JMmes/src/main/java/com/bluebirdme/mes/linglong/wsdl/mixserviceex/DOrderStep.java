package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOrderStep complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOrderStep">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orderStepInputs" type="{dataobjects.common.plantops.datasweep.com}DOrderStepInput" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderStepOutputs" type="{dataobjects.common.plantops.datasweep.com}DOrderStepOutput" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderStepRelationships" type="{dataobjects.common.plantops.datasweep.com}DOrderStepRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="siblingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="srcOrderStepRelationships" type="{dataobjects.common.plantops.datasweep.com}DOrderStepRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stepIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DOrderStep", propOrder = { "controlRecipeKey",
		"currentStates", "objectType", "orderStepInputs", "orderStepOutputs",
		"orderStepRelationships", "routeStepKey", "sequenceNumber",
		"siblingNumber", "srcOrderStepRelationships", "stepIndex",
		"userDefinedAttributes" })
public class DOrderStep extends DCategorical {

	protected long controlRecipeKey;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected short objectType;
	@XmlElement(nillable = true)
	protected List<DOrderStepInput> orderStepInputs;
	@XmlElement(nillable = true)
	protected List<DOrderStepOutput> orderStepOutputs;
	@XmlElement(nillable = true)
	protected List<DOrderStepRelationship> orderStepRelationships;
	protected long routeStepKey;
	protected int sequenceNumber;
	protected int siblingNumber;
	@XmlElement(nillable = true)
	protected List<DOrderStepRelationship> srcOrderStepRelationships;
	protected int stepIndex;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the orderStepInputs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepInputs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepInputs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DOrderStepInput }
	 * 
	 * 
	 */
	public List<DOrderStepInput> getOrderStepInputs() {
		if (orderStepInputs == null) {
			orderStepInputs = new ArrayList<DOrderStepInput>();
		}
		return this.orderStepInputs;
	}

	/**
	 * Gets the value of the orderStepOutputs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepOutputs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepOutputs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DOrderStepOutput }
	 * 
	 * 
	 */
	public List<DOrderStepOutput> getOrderStepOutputs() {
		if (orderStepOutputs == null) {
			orderStepOutputs = new ArrayList<DOrderStepOutput>();
		}
		return this.orderStepOutputs;
	}

	/**
	 * Gets the value of the orderStepRelationships property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orderStepRelationships property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderStepRelationships().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DOrderStepRelationship }
	 * 
	 * 
	 */
	public List<DOrderStepRelationship> getOrderStepRelationships() {
		if (orderStepRelationships == null) {
			orderStepRelationships = new ArrayList<DOrderStepRelationship>();
		}
		return this.orderStepRelationships;
	}

	/**
	 * Gets the value of the routeStepKey property.
	 * 
	 */
	public long getRouteStepKey() {
		return routeStepKey;
	}

	/**
	 * Sets the value of the routeStepKey property.
	 * 
	 */
	public void setRouteStepKey(long value) {
		this.routeStepKey = value;
	}

	/**
	 * Gets the value of the sequenceNumber property.
	 * 
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets the value of the sequenceNumber property.
	 * 
	 */
	public void setSequenceNumber(int value) {
		this.sequenceNumber = value;
	}

	/**
	 * Gets the value of the siblingNumber property.
	 * 
	 */
	public int getSiblingNumber() {
		return siblingNumber;
	}

	/**
	 * Sets the value of the siblingNumber property.
	 * 
	 */
	public void setSiblingNumber(int value) {
		this.siblingNumber = value;
	}

	/**
	 * Gets the value of the srcOrderStepRelationships property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the srcOrderStepRelationships property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSrcOrderStepRelationships().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DOrderStepRelationship }
	 * 
	 * 
	 */
	public List<DOrderStepRelationship> getSrcOrderStepRelationships() {
		if (srcOrderStepRelationships == null) {
			srcOrderStepRelationships = new ArrayList<DOrderStepRelationship>();
		}
		return this.srcOrderStepRelationships;
	}

	/**
	 * Gets the value of the stepIndex property.
	 * 
	 */
	public int getStepIndex() {
		return stepIndex;
	}

	/**
	 * Sets the value of the stepIndex property.
	 * 
	 */
	public void setStepIndex(int value) {
		this.stepIndex = value;
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
