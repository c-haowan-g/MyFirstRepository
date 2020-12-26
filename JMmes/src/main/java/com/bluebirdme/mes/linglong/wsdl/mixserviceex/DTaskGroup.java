package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTaskGroup complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTaskGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="jumpPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="jumpPageImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="largeImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortDescriptionMsgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smallImageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startTaskKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="taskGroupTaskRelationships" type="{dataobjects.common.plantops.datasweep.com}DTaskGroupTaskRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskGroupTaskRelationshipsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "DTaskGroup", propOrder = { "deletePrivilegeKey", "jumpPage",
		"jumpPageImageKey", "largeImageKey", "messagePackKey",
		"shortDescription", "shortDescriptionMsgId", "smallImageKey",
		"startTaskKey", "taskGroupTaskRelationships",
		"taskGroupTaskRelationshipsChanged", "toolTip", "toolTipMsgId",
		"updatePrivilegeKey", "userDefinedAttributes" })
public class DTaskGroup extends DCategorical {

	protected long deletePrivilegeKey;
	protected boolean jumpPage;
	protected long jumpPageImageKey;
	protected long largeImageKey;
	protected long messagePackKey;
	protected String shortDescription;
	protected String shortDescriptionMsgId;
	protected long smallImageKey;
	protected long startTaskKey;
	@XmlElement(nillable = true)
	protected List<DTaskGroupTaskRelationship> taskGroupTaskRelationships;
	protected boolean taskGroupTaskRelationshipsChanged;
	protected String toolTip;
	protected String toolTipMsgId;
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
	 * Gets the value of the jumpPage property.
	 * 
	 */
	public boolean isJumpPage() {
		return jumpPage;
	}

	/**
	 * Sets the value of the jumpPage property.
	 * 
	 */
	public void setJumpPage(boolean value) {
		this.jumpPage = value;
	}

	/**
	 * Gets the value of the jumpPageImageKey property.
	 * 
	 */
	public long getJumpPageImageKey() {
		return jumpPageImageKey;
	}

	/**
	 * Sets the value of the jumpPageImageKey property.
	 * 
	 */
	public void setJumpPageImageKey(long value) {
		this.jumpPageImageKey = value;
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
	 * Gets the value of the startTaskKey property.
	 * 
	 */
	public long getStartTaskKey() {
		return startTaskKey;
	}

	/**
	 * Sets the value of the startTaskKey property.
	 * 
	 */
	public void setStartTaskKey(long value) {
		this.startTaskKey = value;
	}

	/**
	 * Gets the value of the taskGroupTaskRelationships property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the taskGroupTaskRelationships property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTaskGroupTaskRelationships().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTaskGroupTaskRelationship }
	 * 
	 * 
	 */
	public List<DTaskGroupTaskRelationship> getTaskGroupTaskRelationships() {
		if (taskGroupTaskRelationships == null) {
			taskGroupTaskRelationships = new ArrayList<DTaskGroupTaskRelationship>();
		}
		return this.taskGroupTaskRelationships;
	}

	/**
	 * Gets the value of the taskGroupTaskRelationshipsChanged property.
	 * 
	 */
	public boolean isTaskGroupTaskRelationshipsChanged() {
		return taskGroupTaskRelationshipsChanged;
	}

	/**
	 * Sets the value of the taskGroupTaskRelationshipsChanged property.
	 * 
	 */
	public void setTaskGroupTaskRelationshipsChanged(boolean value) {
		this.taskGroupTaskRelationshipsChanged = value;
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
