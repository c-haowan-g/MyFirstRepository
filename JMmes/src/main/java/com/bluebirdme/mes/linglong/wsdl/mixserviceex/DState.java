package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DState complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DState">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nameMessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overrideValues" type="{dataobjects.common.plantops.datasweep.com}DSemanticPropertyOverride" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="semanticPropertyKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="semanticPropertyKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="semanticPropertyListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="stateExitExpression" type="{dataobjects.common.plantops.datasweep.com}DStateExitExpression" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DState", propOrder = { "auditInfo", "fsmKey", "nameMessageId",
		"overrideValues", "semanticPropertyKeys",
		"semanticPropertyKeysChanged", "semanticPropertyListKey",
		"stateExitExpression" })
public class DState extends DKeyed {

	protected DAuditInfo auditInfo;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	protected String nameMessageId;
	@XmlElement(nillable = true)
	protected List<DSemanticPropertyOverride> overrideValues;
	@XmlElement(type = Long.class)
	protected List<Long> semanticPropertyKeys;
	protected boolean semanticPropertyKeysChanged;
	protected long semanticPropertyListKey;
	protected DStateExitExpression stateExitExpression;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the fsmKey property.
	 * 
	 */
	public long getFSMKey() {
		return fsmKey;
	}

	/**
	 * Sets the value of the fsmKey property.
	 * 
	 */
	public void setFSMKey(long value) {
		this.fsmKey = value;
	}

	/**
	 * Gets the value of the nameMessageId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameMessageId() {
		return nameMessageId;
	}

	/**
	 * Sets the value of the nameMessageId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameMessageId(String value) {
		this.nameMessageId = value;
	}

	/**
	 * Gets the value of the overrideValues property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the overrideValues property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOverrideValues().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSemanticPropertyOverride }
	 * 
	 * 
	 */
	public List<DSemanticPropertyOverride> getOverrideValues() {
		if (overrideValues == null) {
			overrideValues = new ArrayList<DSemanticPropertyOverride>();
		}
		return this.overrideValues;
	}

	/**
	 * Gets the value of the semanticPropertyKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the semanticPropertyKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSemanticPropertyKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSemanticPropertyKeys() {
		if (semanticPropertyKeys == null) {
			semanticPropertyKeys = new ArrayList<Long>();
		}
		return this.semanticPropertyKeys;
	}

	/**
	 * Gets the value of the semanticPropertyKeysChanged property.
	 * 
	 */
	public boolean isSemanticPropertyKeysChanged() {
		return semanticPropertyKeysChanged;
	}

	/**
	 * Sets the value of the semanticPropertyKeysChanged property.
	 * 
	 */
	public void setSemanticPropertyKeysChanged(boolean value) {
		this.semanticPropertyKeysChanged = value;
	}

	/**
	 * Gets the value of the semanticPropertyListKey property.
	 * 
	 */
	public long getSemanticPropertyListKey() {
		return semanticPropertyListKey;
	}

	/**
	 * Sets the value of the semanticPropertyListKey property.
	 * 
	 */
	public void setSemanticPropertyListKey(long value) {
		this.semanticPropertyListKey = value;
	}

	/**
	 * Gets the value of the stateExitExpression property.
	 * 
	 * @return possible object is {@link DStateExitExpression }
	 * 
	 */
	public DStateExitExpression getStateExitExpression() {
		return stateExitExpression;
	}

	/**
	 * Sets the value of the stateExitExpression property.
	 * 
	 * @param value
	 *            allowed object is {@link DStateExitExpression }
	 * 
	 */
	public void setStateExitExpression(DStateExitExpression value) {
		this.stateExitExpression = value;
	}

}
