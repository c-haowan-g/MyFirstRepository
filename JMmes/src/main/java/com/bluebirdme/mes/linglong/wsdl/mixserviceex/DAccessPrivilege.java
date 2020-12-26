package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAccessPrivilege complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAccessPrivilege">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="effectivityEnd" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStart" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="performedBy" type="{dataobjects.common.plantops.datasweep.com}DPerformerESigDefinition" minOccurs="0"/>
 *         &lt;element name="performerKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="performerOrVerifierKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="verifiedBy" type="{dataobjects.common.plantops.datasweep.com}DVerifierESigDefinition" minOccurs="0"/>
 *         &lt;element name="verifierKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAccessPrivilege", propOrder = { "deletePrivilegeKey",
		"effectivityEnd", "effectivityStart", "performedBy", "performerKeys",
		"performerOrVerifierKeysChanged", "updatePrivilegeKey",
		"userDefinedAttributes", "verifiedBy", "verifierKeys" })
public class DAccessPrivilege extends DCategorical {

	protected long deletePrivilegeKey;
	protected DTimestamp effectivityEnd;
	protected DTimestamp effectivityStart;
	protected DPerformerESigDefinition performedBy;
	@XmlElement(type = Long.class)
	protected List<Long> performerKeys;
	protected boolean performerOrVerifierKeysChanged;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	protected DVerifierESigDefinition verifiedBy;
	@XmlElement(type = Long.class)
	protected List<Long> verifierKeys;

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
	 * Gets the value of the effectivityEnd property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityEnd() {
		return effectivityEnd;
	}

	/**
	 * Sets the value of the effectivityEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityEnd(DTimestamp value) {
		this.effectivityEnd = value;
	}

	/**
	 * Gets the value of the effectivityStart property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityStart() {
		return effectivityStart;
	}

	/**
	 * Sets the value of the effectivityStart property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityStart(DTimestamp value) {
		this.effectivityStart = value;
	}

	/**
	 * Gets the value of the performedBy property.
	 * 
	 * @return possible object is {@link DPerformerESigDefinition }
	 * 
	 */
	public DPerformerESigDefinition getPerformedBy() {
		return performedBy;
	}

	/**
	 * Sets the value of the performedBy property.
	 * 
	 * @param value
	 *            allowed object is {@link DPerformerESigDefinition }
	 * 
	 */
	public void setPerformedBy(DPerformerESigDefinition value) {
		this.performedBy = value;
	}

	/**
	 * Gets the value of the performerKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the performerKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPerformerKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getPerformerKeys() {
		if (performerKeys == null) {
			performerKeys = new ArrayList<Long>();
		}
		return this.performerKeys;
	}

	/**
	 * Gets the value of the performerOrVerifierKeysChanged property.
	 * 
	 */
	public boolean isPerformerOrVerifierKeysChanged() {
		return performerOrVerifierKeysChanged;
	}

	/**
	 * Sets the value of the performerOrVerifierKeysChanged property.
	 * 
	 */
	public void setPerformerOrVerifierKeysChanged(boolean value) {
		this.performerOrVerifierKeysChanged = value;
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
	 * Gets the value of the verifiedBy property.
	 * 
	 * @return possible object is {@link DVerifierESigDefinition }
	 * 
	 */
	public DVerifierESigDefinition getVerifiedBy() {
		return verifiedBy;
	}

	/**
	 * Sets the value of the verifiedBy property.
	 * 
	 * @param value
	 *            allowed object is {@link DVerifierESigDefinition }
	 * 
	 */
	public void setVerifiedBy(DVerifierESigDefinition value) {
		this.verifiedBy = value;
	}

	/**
	 * Gets the value of the verifierKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the verifierKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getVerifierKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getVerifierKeys() {
		if (verifierKeys == null) {
			verifierKeys = new ArrayList<Long>();
		}
		return this.verifierKeys;
	}

}
