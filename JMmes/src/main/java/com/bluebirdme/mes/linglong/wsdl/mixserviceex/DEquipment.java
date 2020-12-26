package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DEquipment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DEquipment">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractResource">
 *       &lt;sequence>
 *         &lt;element name="capacity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="connections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="equipmentKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="graphInfos" type="{dataobjects.common.plantops.datasweep.com}DGraphInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="graphInfosChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="locationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="locationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ports" type="{dataobjects.common.plantops.datasweep.com}DPort" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productionQueueKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublotAccessType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="tool" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="workCenterKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="workCenterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="workScheduleKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DEquipment", propOrder = { "capacity", "connections",
		"currentStates", "deletePrivilegeKey", "equipmentKeys", "graphInfos",
		"graphInfosChanged", "locationKey", "locationName", "ports",
		"productionQueueKeys", "sublotAccessType", "tool",
		"updatePrivilegeKey", "workCenterKey", "workCenterName",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey", "workScheduleKey" })
public class DEquipment extends DAbstractResource {

	protected DMeasuredValue capacity;
	@XmlElement(nillable = true)
	protected List<DConnection> connections;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	@XmlElement(type = Long.class)
	protected List<Long> equipmentKeys;
	@XmlElement(nillable = true)
	protected List<DGraphInfo> graphInfos;
	protected boolean graphInfosChanged;
	protected long locationKey;
	protected String locationName;
	@XmlElement(nillable = true)
	protected List<DPort> ports;
	@XmlElement(nillable = true)
	protected List<Long> productionQueueKeys;
	protected short sublotAccessType;
	protected boolean tool;
	protected long updatePrivilegeKey;
	protected long workCenterKey;
	protected String workCenterName;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;
	protected long workScheduleKey;

	/**
	 * Gets the value of the capacity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getCapacity() {
		return capacity;
	}

	/**
	 * Sets the value of the capacity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setCapacity(DMeasuredValue value) {
		this.capacity = value;
	}

	/**
	 * Gets the value of the connections property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the connections property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConnections().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DConnection }
	 * 
	 * 
	 */
	public List<DConnection> getConnections() {
		if (connections == null) {
			connections = new ArrayList<DConnection>();
		}
		return this.connections;
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
	 * Gets the value of the graphInfos property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the graphInfos property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getGraphInfos().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DGraphInfo }
	 * 
	 * 
	 */
	public List<DGraphInfo> getGraphInfos() {
		if (graphInfos == null) {
			graphInfos = new ArrayList<DGraphInfo>();
		}
		return this.graphInfos;
	}

	/**
	 * Gets the value of the graphInfosChanged property.
	 * 
	 */
	public boolean isGraphInfosChanged() {
		return graphInfosChanged;
	}

	/**
	 * Sets the value of the graphInfosChanged property.
	 * 
	 */
	public void setGraphInfosChanged(boolean value) {
		this.graphInfosChanged = value;
	}

	/**
	 * Gets the value of the locationKey property.
	 * 
	 */
	public long getLocationKey() {
		return locationKey;
	}

	/**
	 * Sets the value of the locationKey property.
	 * 
	 */
	public void setLocationKey(long value) {
		this.locationKey = value;
	}

	/**
	 * Gets the value of the locationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the value of the locationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLocationName(String value) {
		this.locationName = value;
	}

	/**
	 * Gets the value of the ports property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ports property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPorts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DPort }
	 * 
	 * 
	 */
	public List<DPort> getPorts() {
		if (ports == null) {
			ports = new ArrayList<DPort>();
		}
		return this.ports;
	}

	/**
	 * Gets the value of the productionQueueKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productionQueueKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductionQueueKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getProductionQueueKeys() {
		if (productionQueueKeys == null) {
			productionQueueKeys = new ArrayList<Long>();
		}
		return this.productionQueueKeys;
	}

	/**
	 * Gets the value of the sublotAccessType property.
	 * 
	 */
	public short getSublotAccessType() {
		return sublotAccessType;
	}

	/**
	 * Sets the value of the sublotAccessType property.
	 * 
	 */
	public void setSublotAccessType(short value) {
		this.sublotAccessType = value;
	}

	/**
	 * Gets the value of the tool property.
	 * 
	 */
	public boolean isTool() {
		return tool;
	}

	/**
	 * Sets the value of the tool property.
	 * 
	 */
	public void setTool(boolean value) {
		this.tool = value;
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
	 * Gets the value of the workCenterKey property.
	 * 
	 */
	public long getWorkCenterKey() {
		return workCenterKey;
	}

	/**
	 * Sets the value of the workCenterKey property.
	 * 
	 */
	public void setWorkCenterKey(long value) {
		this.workCenterKey = value;
	}

	/**
	 * Gets the value of the workCenterName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkCenterName() {
		return workCenterName;
	}

	/**
	 * Sets the value of the workCenterName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkCenterName(String value) {
		this.workCenterName = value;
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

	/**
	 * Gets the value of the workScheduleKey property.
	 * 
	 */
	public long getWorkScheduleKey() {
		return workScheduleKey;
	}

	/**
	 * Sets the value of the workScheduleKey property.
	 * 
	 */
	public void setWorkScheduleKey(long value) {
		this.workScheduleKey = value;
	}

}
