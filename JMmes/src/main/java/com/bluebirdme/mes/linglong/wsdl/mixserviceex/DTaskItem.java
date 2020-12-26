package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTaskItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTaskItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="accessPrivilege1Key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="accessPrivilege2Key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="accessPrivilege3Key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="activitySetKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="backVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filterCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filterKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="formKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="largeImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortDescriptionMsgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smallImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskItemType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="taskKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="toolTip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toolTipMsgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DTaskItem", propOrder = { "accessPrivilege1Key",
		"accessPrivilege2Key", "accessPrivilege3Key", "activitySetKey",
		"backVariable", "className", "filterCategory", "filterKey", "formKey",
		"largeImageKey", "maxRows", "shortDescription",
		"shortDescriptionMsgId", "smallImageKey", "taskItemType", "taskKey",
		"toolTip", "toolTipMsgId" })
public class DTaskItem extends DKeyed {

	protected long accessPrivilege1Key;
	protected long accessPrivilege2Key;
	protected long accessPrivilege3Key;
	protected long activitySetKey;
	protected String backVariable;
	protected String className;
	protected String filterCategory;
	protected long filterKey;
	protected long formKey;
	protected long largeImageKey;
	protected int maxRows;
	protected String shortDescription;
	protected String shortDescriptionMsgId;
	protected long smallImageKey;
	protected short taskItemType;
	protected long taskKey;
	protected String toolTip;
	protected String toolTipMsgId;

	/**
	 * Gets the value of the accessPrivilege1Key property.
	 * 
	 */
	public long getAccessPrivilege1Key() {
		return accessPrivilege1Key;
	}

	/**
	 * Sets the value of the accessPrivilege1Key property.
	 * 
	 */
	public void setAccessPrivilege1Key(long value) {
		this.accessPrivilege1Key = value;
	}

	/**
	 * Gets the value of the accessPrivilege2Key property.
	 * 
	 */
	public long getAccessPrivilege2Key() {
		return accessPrivilege2Key;
	}

	/**
	 * Sets the value of the accessPrivilege2Key property.
	 * 
	 */
	public void setAccessPrivilege2Key(long value) {
		this.accessPrivilege2Key = value;
	}

	/**
	 * Gets the value of the accessPrivilege3Key property.
	 * 
	 */
	public long getAccessPrivilege3Key() {
		return accessPrivilege3Key;
	}

	/**
	 * Sets the value of the accessPrivilege3Key property.
	 * 
	 */
	public void setAccessPrivilege3Key(long value) {
		this.accessPrivilege3Key = value;
	}

	/**
	 * Gets the value of the activitySetKey property.
	 * 
	 */
	public long getActivitySetKey() {
		return activitySetKey;
	}

	/**
	 * Sets the value of the activitySetKey property.
	 * 
	 */
	public void setActivitySetKey(long value) {
		this.activitySetKey = value;
	}

	/**
	 * Gets the value of the backVariable property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBackVariable() {
		return backVariable;
	}

	/**
	 * Sets the value of the backVariable property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBackVariable(String value) {
		this.backVariable = value;
	}

	/**
	 * Gets the value of the className property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the value of the className property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setClassName(String value) {
		this.className = value;
	}

	/**
	 * Gets the value of the filterCategory property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFilterCategory() {
		return filterCategory;
	}

	/**
	 * Sets the value of the filterCategory property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFilterCategory(String value) {
		this.filterCategory = value;
	}

	/**
	 * Gets the value of the filterKey property.
	 * 
	 */
	public long getFilterKey() {
		return filterKey;
	}

	/**
	 * Sets the value of the filterKey property.
	 * 
	 */
	public void setFilterKey(long value) {
		this.filterKey = value;
	}

	/**
	 * Gets the value of the formKey property.
	 * 
	 */
	public long getFormKey() {
		return formKey;
	}

	/**
	 * Sets the value of the formKey property.
	 * 
	 */
	public void setFormKey(long value) {
		this.formKey = value;
	}

	/**
	 * Gets the value of the largeImageKey property.
	 * 
	 */
	public long getLargeImageKey() {
		return largeImageKey;
	}

	/**
	 * Sets the value of the largeImageKey property.
	 * 
	 */
	public void setLargeImageKey(long value) {
		this.largeImageKey = value;
	}

	/**
	 * Gets the value of the maxRows property.
	 * 
	 */
	public int getMaxRows() {
		return maxRows;
	}

	/**
	 * Sets the value of the maxRows property.
	 * 
	 */
	public void setMaxRows(int value) {
		this.maxRows = value;
	}

	/**
	 * Gets the value of the shortDescription property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * Sets the value of the shortDescription property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShortDescription(String value) {
		this.shortDescription = value;
	}

	/**
	 * Gets the value of the shortDescriptionMsgId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShortDescriptionMsgId() {
		return shortDescriptionMsgId;
	}

	/**
	 * Sets the value of the shortDescriptionMsgId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setShortDescriptionMsgId(String value) {
		this.shortDescriptionMsgId = value;
	}

	/**
	 * Gets the value of the smallImageKey property.
	 * 
	 */
	public long getSmallImageKey() {
		return smallImageKey;
	}

	/**
	 * Sets the value of the smallImageKey property.
	 * 
	 */
	public void setSmallImageKey(long value) {
		this.smallImageKey = value;
	}

	/**
	 * Gets the value of the taskItemType property.
	 * 
	 */
	public short getTaskItemType() {
		return taskItemType;
	}

	/**
	 * Sets the value of the taskItemType property.
	 * 
	 */
	public void setTaskItemType(short value) {
		this.taskItemType = value;
	}

	/**
	 * Gets the value of the taskKey property.
	 * 
	 */
	public long getTaskKey() {
		return taskKey;
	}

	/**
	 * Sets the value of the taskKey property.
	 * 
	 */
	public void setTaskKey(long value) {
		this.taskKey = value;
	}

	/**
	 * Gets the value of the toolTip property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToolTip() {
		return toolTip;
	}

	/**
	 * Sets the value of the toolTip property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToolTip(String value) {
		this.toolTip = value;
	}

	/**
	 * Gets the value of the toolTipMsgId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getToolTipMsgId() {
		return toolTipMsgId;
	}

	/**
	 * Sets the value of the toolTipMsgId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setToolTipMsgId(String value) {
		this.toolTipMsgId = value;
	}

}
