package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTask complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTask">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="confirmOnDelete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="displayItems" type="{dataobjects.common.plantops.datasweep.com}DDisplayItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="displayItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="helpDocument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hideMasthead" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hideNavigator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hideTaskPanel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="largeImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pausable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortDescriptionMsgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smallImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="stoppable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="taskItemChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="taskItems" type="{dataobjects.common.plantops.datasweep.com}DTaskItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskPermittedPrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="toolTip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toolTipMsgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DTask", propOrder = { "confirmOnDelete", "deletePrivilegeKey",
		"displayItems", "displayItemsChanged", "helpDocument", "hideMasthead",
		"hideNavigator", "hideTaskPanel", "largeImageKey", "messagePackKey",
		"pausable", "shortDescription", "shortDescriptionMsgId",
		"smallImageKey", "stoppable", "taskItemChanged", "taskItems",
		"taskPermittedPrivilegeKey", "taskType", "toolTip", "toolTipMsgId",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DTask extends DCategorical {

	protected boolean confirmOnDelete;
	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DDisplayItem> displayItems;
	protected boolean displayItemsChanged;
	protected String helpDocument;
	protected boolean hideMasthead;
	protected boolean hideNavigator;
	protected boolean hideTaskPanel;
	protected long largeImageKey;
	protected long messagePackKey;
	protected boolean pausable;
	protected String shortDescription;
	protected String shortDescriptionMsgId;
	protected long smallImageKey;
	protected boolean stoppable;
	protected boolean taskItemChanged;
	@XmlElement(nillable = true)
	protected List<DTaskItem> taskItems;
	protected long taskPermittedPrivilegeKey;
	protected short taskType;
	protected String toolTip;
	protected String toolTipMsgId;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the confirmOnDelete property.
	 * 
	 */
	public boolean isConfirmOnDelete() {
		return confirmOnDelete;
	}

	/**
	 * Sets the value of the confirmOnDelete property.
	 * 
	 */
	public void setConfirmOnDelete(boolean value) {
		this.confirmOnDelete = value;
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
	 * Gets the value of the displayItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the displayItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDisplayItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DDisplayItem }
	 * 
	 * 
	 */
	public List<DDisplayItem> getDisplayItems() {
		if (displayItems == null) {
			displayItems = new ArrayList<DDisplayItem>();
		}
		return this.displayItems;
	}

	/**
	 * Gets the value of the displayItemsChanged property.
	 * 
	 */
	public boolean isDisplayItemsChanged() {
		return displayItemsChanged;
	}

	/**
	 * Sets the value of the displayItemsChanged property.
	 * 
	 */
	public void setDisplayItemsChanged(boolean value) {
		this.displayItemsChanged = value;
	}

	/**
	 * Gets the value of the helpDocument property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHelpDocument() {
		return helpDocument;
	}

	/**
	 * Sets the value of the helpDocument property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHelpDocument(String value) {
		this.helpDocument = value;
	}

	/**
	 * Gets the value of the hideMasthead property.
	 * 
	 */
	public boolean isHideMasthead() {
		return hideMasthead;
	}

	/**
	 * Sets the value of the hideMasthead property.
	 * 
	 */
	public void setHideMasthead(boolean value) {
		this.hideMasthead = value;
	}

	/**
	 * Gets the value of the hideNavigator property.
	 * 
	 */
	public boolean isHideNavigator() {
		return hideNavigator;
	}

	/**
	 * Sets the value of the hideNavigator property.
	 * 
	 */
	public void setHideNavigator(boolean value) {
		this.hideNavigator = value;
	}

	/**
	 * Gets the value of the hideTaskPanel property.
	 * 
	 */
	public boolean isHideTaskPanel() {
		return hideTaskPanel;
	}

	/**
	 * Sets the value of the hideTaskPanel property.
	 * 
	 */
	public void setHideTaskPanel(boolean value) {
		this.hideTaskPanel = value;
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
	 * Gets the value of the pausable property.
	 * 
	 */
	public boolean isPausable() {
		return pausable;
	}

	/**
	 * Sets the value of the pausable property.
	 * 
	 */
	public void setPausable(boolean value) {
		this.pausable = value;
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
	 * Gets the value of the stoppable property.
	 * 
	 */
	public boolean isStoppable() {
		return stoppable;
	}

	/**
	 * Sets the value of the stoppable property.
	 * 
	 */
	public void setStoppable(boolean value) {
		this.stoppable = value;
	}

	/**
	 * Gets the value of the taskItemChanged property.
	 * 
	 */
	public boolean isTaskItemChanged() {
		return taskItemChanged;
	}

	/**
	 * Sets the value of the taskItemChanged property.
	 * 
	 */
	public void setTaskItemChanged(boolean value) {
		this.taskItemChanged = value;
	}

	/**
	 * Gets the value of the taskItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the taskItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTaskItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTaskItem }
	 * 
	 * 
	 */
	public List<DTaskItem> getTaskItems() {
		if (taskItems == null) {
			taskItems = new ArrayList<DTaskItem>();
		}
		return this.taskItems;
	}

	/**
	 * Gets the value of the taskPermittedPrivilegeKey property.
	 * 
	 */
	public long getTaskPermittedPrivilegeKey() {
		return taskPermittedPrivilegeKey;
	}

	/**
	 * Sets the value of the taskPermittedPrivilegeKey property.
	 * 
	 */
	public void setTaskPermittedPrivilegeKey(long value) {
		this.taskPermittedPrivilegeKey = value;
	}

	/**
	 * Gets the value of the taskType property.
	 * 
	 */
	public short getTaskType() {
		return taskType;
	}

	/**
	 * Sets the value of the taskType property.
	 * 
	 */
	public void setTaskType(short value) {
		this.taskType = value;
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
