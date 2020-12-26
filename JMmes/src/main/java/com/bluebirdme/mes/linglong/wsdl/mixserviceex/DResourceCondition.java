package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DResourceCondition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DResourceCondition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="allowProcessing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dcsKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dcsKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dcsListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="failure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="imageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="initialFormKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="repair" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DResourceCondition", propOrder = { "accessControlInfo",
		"allowProcessing", "dcsKeys", "dcsKeysChanged", "dcsListKey",
		"deletePrivilegeKey", "failure", "imageKey", "initialFormKey",
		"repair", "updatePrivilegeKey", "userDefinedAttributes",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey" })
public class DResourceCondition extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected boolean allowProcessing;
	@XmlElement(type = Long.class)
	protected List<Long> dcsKeys;
	protected boolean dcsKeysChanged;
	protected long dcsListKey;
	protected long deletePrivilegeKey;
	protected boolean failure;
	protected long imageKey;
	protected long initialFormKey;
	protected boolean repair;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

	/**
	 * Gets the value of the accessControlInfo property.
	 * 
	 * @return possible object is {@link DAccessControlInfo }
	 * 
	 */
	public DAccessControlInfo getAccessControlInfo() {
		return accessControlInfo;
	}

	/**
	 * Sets the value of the accessControlInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAccessControlInfo }
	 * 
	 */
	public void setAccessControlInfo(DAccessControlInfo value) {
		this.accessControlInfo = value;
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
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
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
	 * Gets the value of the imageKey property.
	 * 
	 */
	public long getImageKey() {
		return imageKey;
	}

	/**
	 * Sets the value of the imageKey property.
	 * 
	 */
	public void setImageKey(long value) {
		this.imageKey = value;
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
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
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
