package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPropagationDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPropagationDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FSMRelationshipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ignoreIfTransitionNameDoesNotExist" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="transitionInstanceKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="transitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPropagationDefinition", propOrder = { "auditInfo",
		"expression", "fsmRelationshipName",
		"ignoreIfTransitionNameDoesNotExist", "objectType",
		"transitionInstanceKey", "transitionName" })
public class DPropagationDefinition extends DKeyed {

	protected DAuditInfo auditInfo;
	protected String expression;
	@XmlElement(name = "FSMRelationshipName")
	protected String fsmRelationshipName;
	protected boolean ignoreIfTransitionNameDoesNotExist;
	protected short objectType;
	protected long transitionInstanceKey;
	protected String transitionName;

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
	 * Gets the value of the expression property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Sets the value of the expression property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExpression(String value) {
		this.expression = value;
	}

	/**
	 * Gets the value of the fsmRelationshipName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFSMRelationshipName() {
		return fsmRelationshipName;
	}

	/**
	 * Sets the value of the fsmRelationshipName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFSMRelationshipName(String value) {
		this.fsmRelationshipName = value;
	}

	/**
	 * Gets the value of the ignoreIfTransitionNameDoesNotExist property.
	 * 
	 */
	public boolean isIgnoreIfTransitionNameDoesNotExist() {
		return ignoreIfTransitionNameDoesNotExist;
	}

	/**
	 * Sets the value of the ignoreIfTransitionNameDoesNotExist property.
	 * 
	 */
	public void setIgnoreIfTransitionNameDoesNotExist(boolean value) {
		this.ignoreIfTransitionNameDoesNotExist = value;
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
	 * Gets the value of the transitionInstanceKey property.
	 * 
	 */
	public long getTransitionInstanceKey() {
		return transitionInstanceKey;
	}

	/**
	 * Sets the value of the transitionInstanceKey property.
	 * 
	 */
	public void setTransitionInstanceKey(long value) {
		this.transitionInstanceKey = value;
	}

	/**
	 * Gets the value of the transitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransitionName() {
		return transitionName;
	}

	/**
	 * Sets the value of the transitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransitionName(String value) {
		this.transitionName = value;
	}

}
