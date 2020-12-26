package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDataDictionaryClass complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDataDictionaryClass">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="beanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customizerClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDictionaryElements" type="{dataobjects.common.plantops.datasweep.com}DDataDictionaryElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultObjectKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="elementsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nameSpace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DDataDictionaryClass", propOrder = { "accessControlInfo",
		"beanName", "categoryId", "customizerClassName",
		"dataDictionaryElements", "defaultObjectKey", "deletePrivilegeKey",
		"editable", "elementsChanged", "messagePackKey", "nameSpace",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DDataDictionaryClass extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected String beanName;
	protected String categoryId;
	protected String customizerClassName;
	@XmlElement(nillable = true)
	protected List<DDataDictionaryElement> dataDictionaryElements;
	protected long defaultObjectKey;
	protected long deletePrivilegeKey;
	protected boolean editable;
	protected boolean elementsChanged;
	protected long messagePackKey;
	protected String nameSpace;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the beanName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBeanName() {
		return beanName;
	}

	/**
	 * Sets the value of the beanName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBeanName(String value) {
		this.beanName = value;
	}

	/**
	 * Gets the value of the categoryId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the value of the categoryId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategoryId(String value) {
		this.categoryId = value;
	}

	/**
	 * Gets the value of the customizerClassName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomizerClassName() {
		return customizerClassName;
	}

	/**
	 * Sets the value of the customizerClassName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomizerClassName(String value) {
		this.customizerClassName = value;
	}

	/**
	 * Gets the value of the dataDictionaryElements property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dataDictionaryElements property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDataDictionaryElements().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DDataDictionaryElement }
	 * 
	 * 
	 */
	public List<DDataDictionaryElement> getDataDictionaryElements() {
		if (dataDictionaryElements == null) {
			dataDictionaryElements = new ArrayList<DDataDictionaryElement>();
		}
		return this.dataDictionaryElements;
	}

	/**
	 * Gets the value of the defaultObjectKey property.
	 * 
	 */
	public long getDefaultObjectKey() {
		return defaultObjectKey;
	}

	/**
	 * Sets the value of the defaultObjectKey property.
	 * 
	 */
	public void setDefaultObjectKey(long value) {
		this.defaultObjectKey = value;
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
	 * Gets the value of the editable property.
	 * 
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets the value of the editable property.
	 * 
	 */
	public void setEditable(boolean value) {
		this.editable = value;
	}

	/**
	 * Gets the value of the elementsChanged property.
	 * 
	 */
	public boolean isElementsChanged() {
		return elementsChanged;
	}

	/**
	 * Sets the value of the elementsChanged property.
	 * 
	 */
	public void setElementsChanged(boolean value) {
		this.elementsChanged = value;
	}

	/**
	 * Gets the value of the messagePackKey property.
	 * 
	 */
	public long getMessagePackKey() {
		return messagePackKey;
	}

	/**
	 * Sets the value of the messagePackKey property.
	 * 
	 */
	public void setMessagePackKey(long value) {
		this.messagePackKey = value;
	}

	/**
	 * Gets the value of the nameSpace property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameSpace() {
		return nameSpace;
	}

	/**
	 * Sets the value of the nameSpace property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameSpace(String value) {
		this.nameSpace = value;
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
