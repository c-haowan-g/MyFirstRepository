package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFlexibleStateModel complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFlexibleStateModel">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="defaultState" type="{dataobjects.common.plantops.datasweep.com}DState" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="failOnNullTransitionInstance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="loggingEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STADefinition" type="{dataobjects.common.plantops.datasweep.com}DSTADefinition" minOccurs="0"/>
 *         &lt;element name="semanticPropertySetKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="semanticPropertySetKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="semanticPropertySetListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="states" type="{dataobjects.common.plantops.datasweep.com}DState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transitionInstances" type="{dataobjects.common.plantops.datasweep.com}DTransitionInstance" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transitions" type="{dataobjects.common.plantops.datasweep.com}DTransition" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "DFlexibleStateModel", propOrder = { "defaultState",
		"deletePrivilegeKey", "failOnNullTransitionInstance", "loggingEnabled",
		"messagePackKey", "staDefinition", "semanticPropertySetKeys",
		"semanticPropertySetKeysChanged", "semanticPropertySetListKey",
		"states", "transitionInstances", "transitions", "updatePrivilegeKey",
		"userDefinedAttributes" })
public class DFlexibleStateModel extends DCategorical {

	protected DState defaultState;
	protected long deletePrivilegeKey;
	protected boolean failOnNullTransitionInstance;
	protected boolean loggingEnabled;
	protected long messagePackKey;
	@XmlElement(name = "STADefinition")
	protected DSTADefinition staDefinition;
	@XmlElement(type = Long.class)
	protected List<Long> semanticPropertySetKeys;
	protected boolean semanticPropertySetKeysChanged;
	protected long semanticPropertySetListKey;
	@XmlElement(nillable = true)
	protected List<DState> states;
	@XmlElement(nillable = true)
	protected List<DTransitionInstance> transitionInstances;
	@XmlElement(nillable = true)
	protected List<DTransition> transitions;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the defaultState property.
	 * 
	 * @return possible object is {@link DState }
	 * 
	 */
	public DState getDefaultState() {
		return defaultState;
	}

	/**
	 * Sets the value of the defaultState property.
	 * 
	 * @param value
	 *            allowed object is {@link DState }
	 * 
	 */
	public void setDefaultState(DState value) {
		this.defaultState = value;
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
	 * Gets the value of the failOnNullTransitionInstance property.
	 * 
	 */
	public boolean isFailOnNullTransitionInstance() {
		return failOnNullTransitionInstance;
	}

	/**
	 * Sets the value of the failOnNullTransitionInstance property.
	 * 
	 */
	public void setFailOnNullTransitionInstance(boolean value) {
		this.failOnNullTransitionInstance = value;
	}

	/**
	 * Gets the value of the loggingEnabled property.
	 * 
	 */
	public boolean isLoggingEnabled() {
		return loggingEnabled;
	}

	/**
	 * Sets the value of the loggingEnabled property.
	 * 
	 */
	public void setLoggingEnabled(boolean value) {
		this.loggingEnabled = value;
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
	 * Gets the value of the staDefinition property.
	 * 
	 * @return possible object is {@link DSTADefinition }
	 * 
	 */
	public DSTADefinition getSTADefinition() {
		return staDefinition;
	}

	/**
	 * Sets the value of the staDefinition property.
	 * 
	 * @param value
	 *            allowed object is {@link DSTADefinition }
	 * 
	 */
	public void setSTADefinition(DSTADefinition value) {
		this.staDefinition = value;
	}

	/**
	 * Gets the value of the semanticPropertySetKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the semanticPropertySetKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSemanticPropertySetKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSemanticPropertySetKeys() {
		if (semanticPropertySetKeys == null) {
			semanticPropertySetKeys = new ArrayList<Long>();
		}
		return this.semanticPropertySetKeys;
	}

	/**
	 * Gets the value of the semanticPropertySetKeysChanged property.
	 * 
	 */
	public boolean isSemanticPropertySetKeysChanged() {
		return semanticPropertySetKeysChanged;
	}

	/**
	 * Sets the value of the semanticPropertySetKeysChanged property.
	 * 
	 */
	public void setSemanticPropertySetKeysChanged(boolean value) {
		this.semanticPropertySetKeysChanged = value;
	}

	/**
	 * Gets the value of the semanticPropertySetListKey property.
	 * 
	 */
	public long getSemanticPropertySetListKey() {
		return semanticPropertySetListKey;
	}

	/**
	 * Sets the value of the semanticPropertySetListKey property.
	 * 
	 */
	public void setSemanticPropertySetListKey(long value) {
		this.semanticPropertySetListKey = value;
	}

	/**
	 * Gets the value of the states property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the states property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DState }
	 * 
	 * 
	 */
	public List<DState> getStates() {
		if (states == null) {
			states = new ArrayList<DState>();
		}
		return this.states;
	}

	/**
	 * Gets the value of the transitionInstances property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the transitionInstances property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTransitionInstances().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTransitionInstance }
	 * 
	 * 
	 */
	public List<DTransitionInstance> getTransitionInstances() {
		if (transitionInstances == null) {
			transitionInstances = new ArrayList<DTransitionInstance>();
		}
		return this.transitionInstances;
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
	 * {@link DTransition }
	 * 
	 * 
	 */
	public List<DTransition> getTransitions() {
		if (transitions == null) {
			transitions = new ArrayList<DTransition>();
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

}
