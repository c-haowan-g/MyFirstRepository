package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DResourceStep complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DResourceStep">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="allowFinish" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowNewStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowProcessing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="border" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dcsKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dcsKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dcsListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="enforcement" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="failure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="initialFormKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="labelWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pixelX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pixelY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reasons" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="repair" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="resourceConditionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="resourceStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
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
@XmlType(name = "DResourceStep", propOrder = { "allowFinish", "allowNewStart",
		"allowProcessing", "border", "dcsKeys", "dcsKeysChanged", "dcsListKey",
		"enforcement", "failure", "initialFormKey", "labelWidth", "pixelX",
		"pixelY", "reasons", "repair", "resourceConditionKey",
		"resourceStepKey", "userDefinedAttributes", "workInstructionKeys",
		"workInstructionKeysChanged", "workInstructionListKey" })
public class DResourceStep extends DKeyed {

	protected boolean allowFinish;
	protected boolean allowNewStart;
	protected boolean allowProcessing;
	protected boolean border;
	@XmlElement(type = Long.class)
	protected List<Long> dcsKeys;
	protected boolean dcsKeysChanged;
	protected long dcsListKey;
	protected int enforcement;
	protected boolean failure;
	protected long initialFormKey;
	protected int labelWidth;
	protected int pixelX;
	protected int pixelY;
	@XmlElement(nillable = true)
	protected List<String> reasons;
	protected boolean repair;
	protected long resourceConditionKey;
	protected long resourceStepKey;
	protected DUDAInstance userDefinedAttributes;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

	/**
	 * Gets the value of the allowFinish property.
	 * 
	 */
	public boolean isAllowFinish() {
		return allowFinish;
	}

	/**
	 * Sets the value of the allowFinish property.
	 * 
	 */
	public void setAllowFinish(boolean value) {
		this.allowFinish = value;
	}

	/**
	 * Gets the value of the allowNewStart property.
	 * 
	 */
	public boolean isAllowNewStart() {
		return allowNewStart;
	}

	/**
	 * Sets the value of the allowNewStart property.
	 * 
	 */
	public void setAllowNewStart(boolean value) {
		this.allowNewStart = value;
	}

	/**
	 * Gets the value of the allowProcessing property.
	 * 
	 */
	public boolean isAllowProcessing() {
		return allowProcessing;
	}

	/**
	 * Sets the value of the allowProcessing property.
	 * 
	 */
	public void setAllowProcessing(boolean value) {
		this.allowProcessing = value;
	}

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
	 * Gets the value of the repair property.
	 * 
	 */
	public boolean isRepair() {
		return repair;
	}

	/**
	 * Sets the value of the repair property.
	 * 
	 */
	public void setRepair(boolean value) {
		this.repair = value;
	}

	/**
	 * Gets the value of the resourceConditionKey property.
	 * 
	 */
	public long getResourceConditionKey() {
		return resourceConditionKey;
	}

	/**
	 * Sets the value of the resourceConditionKey property.
	 * 
	 */
	public void setResourceConditionKey(long value) {
		this.resourceConditionKey = value;
	}

	/**
	 * Gets the value of the resourceStepKey property.
	 * 
	 */
	public long getResourceStepKey() {
		return resourceStepKey;
	}

	/**
	 * Sets the value of the resourceStepKey property.
	 * 
	 */
	public void setResourceStepKey(long value) {
		this.resourceStepKey = value;
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
