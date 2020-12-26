package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DCarrier complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DCarrier">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="boxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="carrierCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connections" type="{dataobjects.common.plantops.datasweep.com}DConnection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="graphInfos" type="{dataobjects.common.plantops.datasweep.com}DGraphInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="graphInfosChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="locationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partialLotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ports" type="{dataobjects.common.plantops.datasweep.com}DPort" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sublotAccessType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sublotCapacity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="unitCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "DCarrier", propOrder = { "boxCount", "capacity",
		"carrierCount", "comment", "connections", "currentStates",
		"deletePrivilegeKey", "graphInfos", "graphInfosChanged",
		"locationName", "lotCount", "parentKey", "parentName",
		"partialLotCount", "ports", "quantity", "sublotAccessType",
		"sublotCapacity", "type", "unitCount", "updatePrivilegeKey",
		"userDefinedAttributes" })
public class DCarrier extends DCategorical {

	protected int boxCount;
	protected int capacity;
	protected int carrierCount;
	protected String comment;
	@XmlElement(nillable = true)
	protected List<DConnection> connections;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DGraphInfo> graphInfos;
	protected boolean graphInfosChanged;
	protected String locationName;
	protected int lotCount;
	protected long parentKey;
	protected String parentName;
	protected int partialLotCount;
	@XmlElement(nillable = true)
	protected List<DPort> ports;
	protected int quantity;
	protected short sublotAccessType;
	protected DMeasuredValue sublotCapacity;
	protected short type;
	protected int unitCount;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the boxCount property.
	 * 
	 */
	public int getBoxCount() {
		return boxCount;
	}

	/**
	 * Sets the value of the boxCount property.
	 * 
	 */
	public void setBoxCount(int value) {
		this.boxCount = value;
	}

	/**
	 * Gets the value of the capacity property.
	 * 
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the value of the capacity property.
	 * 
	 */
	public void setCapacity(int value) {
		this.capacity = value;
	}

	/**
	 * Gets the value of the carrierCount property.
	 * 
	 */
	public int getCarrierCount() {
		return carrierCount;
	}

	/**
	 * Sets the value of the carrierCount property.
	 * 
	 */
	public void setCarrierCount(int value) {
		this.carrierCount = value;
	}

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
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
	 * Gets the value of the lotCount property.
	 * 
	 */
	public int getLotCount() {
		return lotCount;
	}

	/**
	 * Sets the value of the lotCount property.
	 * 
	 */
	public void setLotCount(int value) {
		this.lotCount = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the parentName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * Sets the value of the parentName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setParentName(String value) {
		this.parentName = value;
	}

	/**
	 * Gets the value of the partialLotCount property.
	 * 
	 */
	public int getPartialLotCount() {
		return partialLotCount;
	}

	/**
	 * Sets the value of the partialLotCount property.
	 * 
	 */
	public void setPartialLotCount(int value) {
		this.partialLotCount = value;
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
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value) {
		this.quantity = value;
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
	 * Gets the value of the unitCount property.
	 * 
	 */
	public int getUnitCount() {
		return unitCount;
	}

	/**
	 * Sets the value of the unitCount property.
	 * 
	 */
	public void setUnitCount(int value) {
		this.unitCount = value;
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
