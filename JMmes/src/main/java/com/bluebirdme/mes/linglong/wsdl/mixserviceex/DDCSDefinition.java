package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDCSDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDCSDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="definitionItems" type="{dataobjects.common.plantops.datasweep.com}DDCSDefinitionItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="definitionItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="staticData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DDCSDefinition", propOrder = { "accessControlInfo", "author",
		"definitionItems", "definitionItemsChanged", "deletePrivilegeKey",
		"staticData", "updatePrivilegeKey", "workInstructionKeys",
		"workInstructionKeysChanged", "workInstructionListKey" })
public class DDCSDefinition extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected String author;
	@XmlElement(nillable = true)
	protected List<DDCSDefinitionItem> definitionItems;
	protected boolean definitionItemsChanged;
	protected long deletePrivilegeKey;
	protected boolean staticData;
	protected long updatePrivilegeKey;
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
	 * Gets the value of the author property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the value of the author property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAuthor(String value) {
		this.author = value;
	}

	/**
	 * Gets the value of the definitionItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the definitionItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDefinitionItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DDCSDefinitionItem }
	 * 
	 * 
	 */
	public List<DDCSDefinitionItem> getDefinitionItems() {
		if (definitionItems == null) {
			definitionItems = new ArrayList<DDCSDefinitionItem>();
		}
		return this.definitionItems;
	}

	/**
	 * Gets the value of the definitionItemsChanged property.
	 * 
	 */
	public boolean isDefinitionItemsChanged() {
		return definitionItemsChanged;
	}

	/**
	 * Sets the value of the definitionItemsChanged property.
	 * 
	 */
	public void setDefinitionItemsChanged(boolean value) {
		this.definitionItemsChanged = value;
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
	 * Gets the value of the staticData property.
	 * 
	 */
	public boolean isStaticData() {
		return staticData;
	}

	/**
	 * Sets the value of the staticData property.
	 * 
	 */
	public void setStaticData(boolean value) {
		this.staticData = value;
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
