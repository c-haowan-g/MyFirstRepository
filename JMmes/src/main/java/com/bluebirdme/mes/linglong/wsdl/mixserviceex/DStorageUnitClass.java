package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStorageUnitClass complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStorageUnitClass">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="storageUnitClassStorageUnits" type="{dataobjects.common.plantops.datasweep.com}DStorageUnitClassStorageUnit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storageUnitClassStorageUnitsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "DStorageUnitClass", propOrder = { "currentStates",
		"deletePrivilegeKey", "storageUnitClassStorageUnits",
		"storageUnitClassStorageUnitsChanged", "updatePrivilegeKey",
		"userDefinedAttributes" })
public class DStorageUnitClass extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DStorageUnitClassStorageUnit> storageUnitClassStorageUnits;
	protected boolean storageUnitClassStorageUnitsChanged;
	protected long updatePrivilegeKey;
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
	 * Gets the value of the storageUnitClassStorageUnits property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the storageUnitClassStorageUnits property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getStorageUnitClassStorageUnits().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DStorageUnitClassStorageUnit }
	 * 
	 * 
	 */
	public List<DStorageUnitClassStorageUnit> getStorageUnitClassStorageUnits() {
		if (storageUnitClassStorageUnits == null) {
			storageUnitClassStorageUnits = new ArrayList<DStorageUnitClassStorageUnit>();
		}
		return this.storageUnitClassStorageUnits;
	}

	/**
	 * Gets the value of the storageUnitClassStorageUnitsChanged property.
	 * 
	 */
	public boolean isStorageUnitClassStorageUnitsChanged() {
		return storageUnitClassStorageUnitsChanged;
	}

	/**
	 * Sets the value of the storageUnitClassStorageUnitsChanged property.
	 * 
	 */
	public void setStorageUnitClassStorageUnitsChanged(boolean value) {
		this.storageUnitClassStorageUnitsChanged = value;
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
