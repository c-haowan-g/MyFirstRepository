package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DActivitySet complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DActivitySet">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="autoRestart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="effectivityEnd" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStart" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="links" type="{dataobjects.common.plantops.datasweep.com}DActivitySetLink" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="persistenceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rwTagSetDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="steps" type="{dataobjects.common.plantops.datasweep.com}DActivitySetStep" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tagSetDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="textID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transitions" type="{dataobjects.common.plantops.datasweep.com}DActivitySetTransition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="variables" type="{dataobjects.common.plantops.datasweep.com}DActivitySetVariable" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DActivitySet", propOrder = { "accessControlInfo",
		"autoRestart", "currentStates", "deletePrivilegeKey", "effectivityEnd",
		"effectivityStart", "extendedRevision", "guid", "links",
		"messagePackKey", "persistenceType", "revision",
		"rwTagSetDefinitionKey", "steps", "tagSetDefinitionKey", "text",
		"textID", "transitions", "updatePrivilegeKey", "userDefinedAttributes",
		"variables" })
public class DActivitySet extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	protected boolean autoRestart;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected DTimestamp effectivityEnd;
	protected DTimestamp effectivityStart;
	protected String extendedRevision;
	protected String guid;
	@XmlElement(nillable = true)
	protected List<DActivitySetLink> links;
	protected long messagePackKey;
	protected int persistenceType;
	protected String revision;
	protected long rwTagSetDefinitionKey;
	@XmlElement(nillable = true)
	protected List<DActivitySetStep> steps;
	protected long tagSetDefinitionKey;
	protected String text;
	protected String textID;
	@XmlElement(nillable = true)
	protected List<DActivitySetTransition> transitions;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	@XmlElement(nillable = true)
	protected List<DActivitySetVariable> variables;

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
	 * Gets the value of the autoRestart property.
	 * 
	 */
	public boolean isAutoRestart() {
		return autoRestart;
	}

	/**
	 * Sets the value of the autoRestart property.
	 * 
	 */
	public void setAutoRestart(boolean value) {
		this.autoRestart = value;
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
	 * Gets the value of the effectivityEnd property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityEnd() {
		return effectivityEnd;
	}

	/**
	 * Sets the value of the effectivityEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityEnd(DTimestamp value) {
		this.effectivityEnd = value;
	}

	/**
	 * Gets the value of the effectivityStart property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityStart() {
		return effectivityStart;
	}

	/**
	 * Sets the value of the effectivityStart property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityStart(DTimestamp value) {
		this.effectivityStart = value;
	}

	/**
	 * Gets the value of the extendedRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtendedRevision() {
		return extendedRevision;
	}

	/**
	 * Sets the value of the extendedRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtendedRevision(String value) {
		this.extendedRevision = value;
	}

	/**
	 * Gets the value of the guid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the value of the guid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGuid(String value) {
		this.guid = value;
	}

	/**
	 * Gets the value of the links property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the links property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLinks().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DActivitySetLink }
	 * 
	 * 
	 */
	public List<DActivitySetLink> getLinks() {
		if (links == null) {
			links = new ArrayList<DActivitySetLink>();
		}
		return this.links;
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
	 * Gets the value of the persistenceType property.
	 * 
	 */
	public int getPersistenceType() {
		return persistenceType;
	}

	/**
	 * Sets the value of the persistenceType property.
	 * 
	 */
	public void setPersistenceType(int value) {
		this.persistenceType = value;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevision(String value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the rwTagSetDefinitionKey property.
	 * 
	 */
	public long getRwTagSetDefinitionKey() {
		return rwTagSetDefinitionKey;
	}

	/**
	 * Sets the value of the rwTagSetDefinitionKey property.
	 * 
	 */
	public void setRwTagSetDefinitionKey(long value) {
		this.rwTagSetDefinitionKey = value;
	}

	/**
	 * Gets the value of the steps property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the steps property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSteps().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DActivitySetStep }
	 * 
	 * 
	 */
	public List<DActivitySetStep> getSteps() {
		if (steps == null) {
			steps = new ArrayList<DActivitySetStep>();
		}
		return this.steps;
	}

	/**
	 * Gets the value of the tagSetDefinitionKey property.
	 * 
	 */
	public long getTagSetDefinitionKey() {
		return tagSetDefinitionKey;
	}

	/**
	 * Sets the value of the tagSetDefinitionKey property.
	 * 
	 */
	public void setTagSetDefinitionKey(long value) {
		this.tagSetDefinitionKey = value;
	}

	/**
	 * Gets the value of the text property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the value of the text property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setText(String value) {
		this.text = value;
	}

	/**
	 * Gets the value of the textID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTextID() {
		return textID;
	}

	/**
	 * Sets the value of the textID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTextID(String value) {
		this.textID = value;
	}

	/**
	 * Gets the value of the transitions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the transitions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTransitions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DActivitySetTransition }
	 * 
	 * 
	 */
	public List<DActivitySetTransition> getTransitions() {
		if (transitions == null) {
			transitions = new ArrayList<DActivitySetTransition>();
		}
		return this.transitions;
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

	/**
	 * Gets the value of the variables property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the variables property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getVariables().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DActivitySetVariable }
	 * 
	 * 
	 */
	public List<DActivitySetVariable> getVariables() {
		if (variables == null) {
			variables = new ArrayList<DActivitySetVariable>();
		}
		return this.variables;
	}

}
