package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFSMConfiguration complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFSMConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FSMConfigurationItems" type="{dataobjects.common.plantops.datasweep.com}DFSMConfigurationItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FSMConfigurationItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DFSMConfiguration", propOrder = { "deletePrivilegeKey",
		"fsmConfigurationItems", "fsmConfigurationItemsChanged", "objectType",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DFSMConfiguration extends DCategorical {

	protected long deletePrivilegeKey;
	@XmlElement(name = "FSMConfigurationItems", nillable = true)
	protected List<DFSMConfigurationItem> fsmConfigurationItems;
	@XmlElement(name = "FSMConfigurationItemsChanged")
	protected boolean fsmConfigurationItemsChanged;
	protected short objectType;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the fsmConfigurationItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the fsmConfigurationItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFSMConfigurationItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DFSMConfigurationItem }
	 * 
	 * 
	 */
	public List<DFSMConfigurationItem> getFSMConfigurationItems() {
		if (fsmConfigurationItems == null) {
			fsmConfigurationItems = new ArrayList<DFSMConfigurationItem>();
		}
		return this.fsmConfigurationItems;
	}

	/**
	 * Gets the value of the fsmConfigurationItemsChanged property.
	 * 
	 */
	public boolean isFSMConfigurationItemsChanged() {
		return fsmConfigurationItemsChanged;
	}

	/**
	 * Sets the value of the fsmConfigurationItemsChanged property.
	 * 
	 */
	public void setFSMConfigurationItemsChanged(boolean value) {
		this.fsmConfigurationItemsChanged = value;
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
