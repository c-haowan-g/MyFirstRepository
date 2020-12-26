package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRoute complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRoute">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultProductionLineKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="effectivityEnd" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStart" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="enforcement" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iconSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="initialFormKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="productionLineKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reasons" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resourceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeArcs" type="{dataobjects.common.plantops.datasweep.com}DRouteArc" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeQueues" type="{dataobjects.common.plantops.datasweep.com}DRouteQueue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="routeSteps" type="{dataobjects.common.plantops.datasweep.com}DRouteStep" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
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
@XmlType(name = "DRoute", propOrder = { "accessControlInfo", "currentStates",
		"defaultProductionLineKey", "deletePrivilegeKey", "effectivityEnd",
		"effectivityStart", "enforcement", "extendedRevision", "iconSize",
		"initialFormKey", "productionLineKeys", "reasons", "resourceType",
		"revision", "routeArcs", "routeQueues", "routeSteps", "state",
		"updatePrivilegeKey", "userDefinedAttributes", "workCenterKeys",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey" })
public class DRoute extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long defaultProductionLineKey;
	protected long deletePrivilegeKey;
	protected DTimestamp effectivityEnd;
	protected DTimestamp effectivityStart;
	protected int enforcement;
	protected String extendedRevision;
	protected int iconSize;
	protected long initialFormKey;
	@XmlElement(type = Long.class)
	protected List<Long> productionLineKeys;
	@XmlElement(nillable = true)
	protected List<String> reasons;
	protected short resourceType;
	protected String revision;
	@XmlElement(nillable = true)
	protected List<DRouteArc> routeArcs;
	@XmlElement(nillable = true)
	protected List<DRouteQueue> routeQueues;
	@XmlElement(nillable = true)
	protected List<DRouteStep> routeSteps;
	protected String state;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	@XmlElement(nillable = true)
	protected List<Long> workCenterKeys;
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
	 * Gets the value of the defaultProductionLineKey property.
	 * 
	 */
	public long getDefaultProductionLineKey() {
		return defaultProductionLineKey;
	}

	/**
	 * Sets the value of the defaultProductionLineKey property.
	 * 
	 */
	public void setDefaultProductionLineKey(long value) {
		this.defaultProductionLineKey = value;
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
	 * Gets the value of the extendedRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtendedRevision() {
		return extendedRevision;
	}

	/**
	 * Sets the value of the extendedRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtendedRevision(String value) {
		this.extendedRevision = value;
	}

	/**
	 * Gets the value of the iconSize property.
	 * 
	 */
	public int getIconSize() {
		return iconSize;
	}

	/**
	 * Sets the value of the iconSize property.
	 * 
	 */
	public void setIconSize(int value) {
		this.iconSize = value;
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
	 * Gets the value of the resourceType property.
	 * 
	 */
	public short getResourceType() {
		return resourceType;
	}

	/**
	 * Sets the value of the resourceType property.
	 * 
	 */
	public void setResourceType(short value) {
		this.resourceType = value;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevision(String value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the routeArcs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the routeArcs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRouteArcs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRouteArc }
	 * 
	 * 
	 */
	public List<DRouteArc> getRouteArcs() {
		if (routeArcs == null) {
			routeArcs = new ArrayList<DRouteArc>();
		}
		return this.routeArcs;
	}

	/**
	 * Gets the value of the routeQueues property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the routeQueues property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRouteQueues().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRouteQueue }
	 * 
	 * 
	 */
	public List<DRouteQueue> getRouteQueues() {
		if (routeQueues == null) {
			routeQueues = new ArrayList<DRouteQueue>();
		}
		return this.routeQueues;
	}

	/**
	 * Gets the value of the routeSteps property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the routeSteps property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRouteSteps().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRouteStep }
	 * 
	 * 
	 */
	public List<DRouteStep> getRouteSteps() {
		if (routeSteps == null) {
			routeSteps = new ArrayList<DRouteStep>();
		}
		return this.routeSteps;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setState(String value) {
		this.state = value;
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
