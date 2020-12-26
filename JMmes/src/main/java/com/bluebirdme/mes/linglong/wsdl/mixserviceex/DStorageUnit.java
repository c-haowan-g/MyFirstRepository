package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStorageUnit complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStorageUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="connections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="durabilityType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="graphInfos" type="{dataobjects.common.plantops.datasweep.com}DGraphInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="graphInfosChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="locationKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="logicallyEmptyQtyChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logicallyEmptyQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="maximumStorageDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minimumStorageDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mobilityType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partClassChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="partClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ports" type="{dataobjects.common.plantops.datasweep.com}DPort" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sublotAccessType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sublotCapacity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="sublotCapacityChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DStorageUnit", propOrder = { "connections", "currentStates",
		"deletePrivilegeKey", "durabilityType", "graphInfos",
		"graphInfosChanged", "locationKey", "logicallyEmptyQtyChanged",
		"logicallyEmptyQuantity", "maximumStorageDuration",
		"minimumStorageDuration", "mobilityType", "partClassChanged",
		"partClassKey", "ports", "sublotAccessType", "sublotCapacity",
		"sublotCapacityChanged", "updatePrivilegeKey", "userDefinedAttributes" })
public class DStorageUnit extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DConnection> connections;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected short durabilityType;
	@XmlElement(nillable = true)
	protected List<DGraphInfo> graphInfos;
	protected boolean graphInfosChanged;
	protected long locationKey;
	protected boolean logicallyEmptyQtyChanged;
	protected DMeasuredValue logicallyEmptyQuantity;
	protected int maximumStorageDuration;
	protected int minimumStorageDuration;
	protected short mobilityType;
	protected boolean partClassChanged;
	protected long partClassKey;
	@XmlElement(nillable = true)
	protected List<DPort> ports;
	protected short sublotAccessType;
	protected DMeasuredValue sublotCapacity;
	protected boolean sublotCapacityChanged;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the durabilityType property.
	 * 
	 */
	public short getDurabilityType() {
		return durabilityType;
	}

	/**
	 * Sets the value of the durabilityType property.
	 * 
	 */
	public void setDurabilityType(short value) {
		this.durabilityType = value;
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
	 * Gets the value of the logicallyEmptyQtyChanged property.
	 * 
	 */
	public boolean isLogicallyEmptyQtyChanged() {
		return logicallyEmptyQtyChanged;
	}

	/**
	 * Sets the value of the logicallyEmptyQtyChanged property.
	 * 
	 */
	public void setLogicallyEmptyQtyChanged(boolean value) {
		this.logicallyEmptyQtyChanged = value;
	}

	/**
	 * Gets the value of the logicallyEmptyQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getLogicallyEmptyQuantity() {
		return logicallyEmptyQuantity;
	}

	/**
	 * Sets the value of the logicallyEmptyQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setLogicallyEmptyQuantity(DMeasuredValue value) {
		this.logicallyEmptyQuantity = value;
	}

	/**
	 * Gets the value of the maximumStorageDuration property.
	 * 
	 */
	public int getMaximumStorageDuration() {
		return maximumStorageDuration;
	}

	/**
	 * Sets the value of the maximumStorageDuration property.
	 * 
	 */
	public void setMaximumStorageDuration(int value) {
		this.maximumStorageDuration = value;
	}

	/**
	 * Gets the value of the minimumStorageDuration property.
	 * 
	 */
	public int getMinimumStorageDuration() {
		return minimumStorageDuration;
	}

	/**
	 * Sets the value of the minimumStorageDuration property.
	 * 
	 */
	public void setMinimumStorageDuration(int value) {
		this.minimumStorageDuration = value;
	}

	/**
	 * Gets the value of the mobilityType property.
	 * 
	 */
	public short getMobilityType() {
		return mobilityType;
	}

	/**
	 * Sets the value of the mobilityType property.
	 * 
	 */
	public void setMobilityType(short value) {
		this.mobilityType = value;
	}

	/**
	 * Gets the value of the partClassChanged property.
	 * 
	 */
	public boolean isPartClassChanged() {
		return partClassChanged;
	}

	/**
	 * Sets the value of the partClassChanged property.
	 * 
	 */
	public void setPartClassChanged(boolean value) {
		this.partClassChanged = value;
	}

	/**
	 * Gets the value of the partClassKey property.
	 * 
	 */
	public long getPartClassKey() {
		return partClassKey;
	}

	/**
	 * Sets the value of the partClassKey property.
	 * 
	 */
	public void setPartClassKey(long value) {
		this.partClassKey = value;
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
	 * Gets the value of the sublotCapacity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getSublotCapacity() {
		return sublotCapacity;
	}

	/**
	 * Sets the value of the sublotCapacity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setSublotCapacity(DMeasuredValue value) {
		this.sublotCapacity = value;
	}

	/**
	 * Gets the value of the sublotCapacityChanged property.
	 * 
	 */
	public boolean isSublotCapacityChanged() {
		return sublotCapacityChanged;
	}

	/**
	 * Sets the value of the sublotCapacityChanged property.
	 * 
	 */
	public void setSublotCapacityChanged(boolean value) {
		this.sublotCapacityChanged = value;
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

}
