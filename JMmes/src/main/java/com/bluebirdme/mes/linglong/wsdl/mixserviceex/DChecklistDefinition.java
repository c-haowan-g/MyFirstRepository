package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DChecklistDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DChecklistDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractChecklist">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="checklistItems" type="{dataobjects.common.plantops.datasweep.com}DChecklistDefinitionItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="checklistItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DChecklistDefinition", propOrder = { "accessControlInfo",
		"checklistItems", "checklistItemsChanged", "deletePrivilegeKey",
		"updatePrivilegeKey" })
public class DChecklistDefinition extends DAbstractChecklist {

	protected DAccessControlInfo accessControlInfo;
	@XmlElement(nillable = true)
	protected List<DChecklistDefinitionItem> checklistItems;
	protected boolean checklistItemsChanged;
	protected long deletePrivilegeKey;
	protected long updatePrivilegeKey;

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
	 * Gets the value of the checklistItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the checklistItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChecklistItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DChecklistDefinitionItem }
	 * 
	 * 
	 */
	public List<DChecklistDefinitionItem> getChecklistItems() {
		if (checklistItems == null) {
			checklistItems = new ArrayList<DChecklistDefinitionItem>();
		}
		return this.checklistItems;
	}

	/**
	 * Gets the value of the checklistItemsChanged property.
	 * 
	 */
	public boolean isChecklistItemsChanged() {
		return checklistItemsChanged;
	}

	/**
	 * Sets the value of the checklistItemsChanged property.
	 * 
	 */
	public void setChecklistItemsChanged(boolean value) {
		this.checklistItemsChanged = value;
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

}
