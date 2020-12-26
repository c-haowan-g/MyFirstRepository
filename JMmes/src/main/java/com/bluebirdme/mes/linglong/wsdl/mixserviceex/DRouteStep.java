package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRouteStep complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRouteStep">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="border" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="checklistKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cycleDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cycleDurationType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dcsKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dcsKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dcsListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultWorkCenterKeysForProductionLines" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dependencies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="embeddedRouteKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enforcement" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="equipmentKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="failure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="initialFormKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="labelWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pixelX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pixelY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productionLineKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reasons" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="valueAdded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workCenterAssigned" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workCenterKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRouteStep", propOrder = { "border", "checklistKey",
		"cycleDuration", "cycleDurationType", "dcsKeys", "dcsKeysChanged",
		"dcsListKey", "defaultWorkCenterKeysForProductionLines",
		"dependencies", "description", "embeddedRouteKeys", "enforcement",
		"equipmentKeys", "failure", "initialFormKey", "labelWidth",
		"operationKey", "pixelX", "pixelY", "productionLineKeys", "reasons",
		"type", "userDefinedAttributes", "valueAdded", "workCenterAssigned",
		"workCenterKeys", "workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey" })
public class DRouteStep extends DKeyed {

	protected boolean border;
	protected long checklistKey;
	protected int cycleDuration;
	protected int cycleDurationType;
	@XmlElement(type = Long.class)
	protected List<Long> dcsKeys;
	protected boolean dcsKeysChanged;
	protected long dcsListKey;
	@XmlElement(type = Long.class)
	protected List<Long> defaultWorkCenterKeysForProductionLines;
	protected String dependencies;
	protected String description;
	@XmlElement(type = Long.class)
	protected List<Long> embeddedRouteKeys;
	protected int enforcement;
	@XmlElement(nillable = true)
	protected List<Long> equipmentKeys;
	protected boolean failure;
	protected long initialFormKey;
	protected int labelWidth;
	protected long operationKey;
	protected int pixelX;
	protected int pixelY;
	@XmlElement(type = Long.class)
	protected List<Long> productionLineKeys;
	@XmlElement(nillable = true)
	protected List<String> reasons;
	protected short type;
	protected DUDAInstance userDefinedAttributes;
	protected boolean valueAdded;
	protected boolean workCenterAssigned;
	@XmlElement(type = Long.class)
	protected List<Long> workCenterKeys;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

	/**
	 * Gets the value of the border property.
	 * 
	 */
	public boolean isBorder() {
		return border;
	}

	/**
	 * Sets the value of the border property.
	 * 
	 */
	public void setBorder(boolean value) {
		this.border = value;
	}

	/**
	 * Gets the value of the checklistKey property.
	 * 
	 */
	public long getChecklistKey() {
		return checklistKey;
	}

	/**
	 * Sets the value of the checklistKey property.
	 * 
	 */
	public void setChecklistKey(long value) {
		this.checklistKey = value;
	}

	/**
	 * Gets the value of the cycleDuration property.
	 * 
	 */
	public int getCycleDuration() {
		return cycleDuration;
	}

	/**
	 * Sets the value of the cycleDuration property.
	 * 
	 */
	public void setCycleDuration(int value) {
		this.cycleDuration = value;
	}

	/**
	 * Gets the value of the cycleDurationType property.
	 * 
	 */
	public int getCycleDurationType() {
		return cycleDurationType;
	}

	/**
	 * Sets the value of the cycleDurationType property.
	 * 
	 */
	public void setCycleDurationType(int value) {
		this.cycleDurationType = value;
	}

	/**
	 * Gets the value of the dcsKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dcsKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDcsKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getDcsKeys() {
		if (dcsKeys == null) {
			dcsKeys = new ArrayList<Long>();
		}
		return this.dcsKeys;
	}

	/**
	 * Gets the value of the dcsKeysChanged property.
	 * 
	 */
	public boolean isDcsKeysChanged() {
		return dcsKeysChanged;
	}

	/**
	 * Sets the value of the dcsKeysChanged property.
	 * 
	 */
	public void setDcsKeysChanged(boolean value) {
		this.dcsKeysChanged = value;
	}

	/**
	 * Gets the value of the dcsListKey property.
	 * 
	 */
	public long getDcsListKey() {
		return dcsListKey;
	}

	/**
	 * Sets the value of the dcsListKey property.
	 * 
	 */
	public void setDcsListKey(long value) {
		this.dcsListKey = value;
	}

	/**
	 * Gets the value of the defaultWorkCenterKeysForProductionLines property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the defaultWorkCenterKeysForProductionLines
	 * property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDefaultWorkCenterKeysForProductionLines().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getDefaultWorkCenterKeysForProductionLines() {
		if (defaultWorkCenterKeysForProductionLines == null) {
			defaultWorkCenterKeysForProductionLines = new ArrayList<Long>();
		}
		return this.defaultWorkCenterKeysForProductionLines;
	}

	/**
	 * Gets the value of the dependencies property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDependencies() {
		return dependencies;
	}

	/**
	 * Sets the value of the dependencies property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDependencies(String value) {
		this.dependencies = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the embeddedRouteKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the embeddedRouteKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEmbeddedRouteKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getEmbeddedRouteKeys() {
		if (embeddedRouteKeys == null) {
			embeddedRouteKeys = new ArrayList<Long>();
		}
		return this.embeddedRouteKeys;
	}

	/**
	 * Gets the value of the enforcement property.
	 * 
	 */
	public int getEnforcement() {
		return enforcement;
	}

	/**
	 * Sets the value of the enforcement property.
	 * 
	 */
	public void setEnforcement(int value) {
		this.enforcement = value;
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
	 * Gets the value of the failure property.
	 * 
	 */
	public boolean isFailure() {
		return failure;
	}

	/**
	 * Sets the value of the failure property.
	 * 
	 */
	public void setFailure(boolean value) {
		this.failure = value;
	}

	/**
	 * Gets the value of the initialFormKey property.
	 * 
	 */
	public long getInitialFormKey() {
		return initialFormKey;
	}

	/**
	 * Sets the value of the initialFormKey property.
	 * 
	 */
	public void setInitialFormKey(long value) {
		this.initialFormKey = value;
	}

	/**
	 * Gets the value of the labelWidth property.
	 * 
	 */
	public int getLabelWidth() {
		return labelWidth;
	}

	/**
	 * Sets the value of the labelWidth property.
	 * 
	 */
	public void setLabelWidth(int value) {
		this.labelWidth = value;
	}

	/**
	 * Gets the value of the operationKey property.
	 * 
	 */
	public long getOperationKey() {
		return operationKey;
	}

	/**
	 * Sets the value of the operationKey property.
	 * 
	 */
	public void setOperationKey(long value) {
		this.operationKey = value;
	}

	/**
	 * Gets the value of the pixelX property.
	 * 
	 */
	public int getPixelX() {
		return pixelX;
	}

	/**
	 * Sets the value of the pixelX property.
	 * 
	 */
	public void setPixelX(int value) {
		this.pixelX = value;
	}

	/**
	 * Gets the value of the pixelY property.
	 * 
	 */
	public int getPixelY() {
		return pixelY;
	}

	/**
	 * Sets the value of the pixelY property.
	 * 
	 */
	public void setPixelY(int value) {
		this.pixelY = value;
	}

	/**
	 * Gets the value of the productionLineKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productionLineKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductionLineKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getProductionLineKeys() {
		if (productionLineKeys == null) {
			productionLineKeys = new ArrayList<Long>();
		}
		return this.productionLineKeys;
	}

	/**
	 * Gets the value of the reasons property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the reasons property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getReasons().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getReasons() {
		if (reasons == null) {
			reasons = new ArrayList<String>();
		}
		return this.reasons;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
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

	/**
	 * Gets the value of the valueAdded property.
	 * 
	 */
	public boolean isValueAdded() {
		return valueAdded;
	}

	/**
	 * Sets the value of the valueAdded property.
	 * 
	 */
	public void setValueAdded(boolean value) {
		this.valueAdded = value;
	}

	/**
	 * Gets the value of the workCenterAssigned property.
	 * 
	 */
	public boolean isWorkCenterAssigned() {
		return workCenterAssigned;
	}

	/**
	 * Sets the value of the workCenterAssigned property.
	 * 
	 */
	public void setWorkCenterAssigned(boolean value) {
		this.workCenterAssigned = value;
	}

	/**
	 * Gets the value of the workCenterKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workCenterKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkCenterKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getWorkCenterKeys() {
		if (workCenterKeys == null) {
			workCenterKeys = new ArrayList<Long>();
		}
		return this.workCenterKeys;
	}

	/**
	 * Gets the value of the workInstructionKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workInstructionKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkInstructionKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getWorkInstructionKeys() {
		if (workInstructionKeys == null) {
			workInstructionKeys = new ArrayList<Long>();
		}
		return this.workInstructionKeys;
	}

	/**
	 * Gets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public boolean isWorkInstructionKeysChanged() {
		return workInstructionKeysChanged;
	}

	/**
	 * Sets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public void setWorkInstructionKeysChanged(boolean value) {
		this.workInstructionKeysChanged = value;
	}

	/**
	 * Gets the value of the workInstructionListKey property.
	 * 
	 */
	public long getWorkInstructionListKey() {
		return workInstructionListKey;
	}

	/**
	 * Sets the value of the workInstructionListKey property.
	 * 
	 */
	public void setWorkInstructionListKey(long value) {
		this.workInstructionListKey = value;
	}

}
