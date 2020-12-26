package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DReportDataDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DReportDataDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="DReportDataDefinitionVariables" type="{dataobjects.common.plantops.datasweep.com}DReportDataDefinitionVariable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="messagePackKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reportDataDefinitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDataDefinitionRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="variablesChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DReportDataDefinition", propOrder = { "accessControlInfo",
		"dReportDataDefinitionVariables", "deletePrivilegeKey",
		"messagePackKey", "reportDataDefinitionName",
		"reportDataDefinitionRevision", "status", "updatePrivilegeKey",
		"userDefinedAttributes", "variablesChanged" })
public class DReportDataDefinition extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	@XmlElement(name = "DReportDataDefinitionVariables", nillable = true)
	protected List<DReportDataDefinitionVariable> dReportDataDefinitionVariables;
	protected long deletePrivilegeKey;
	protected long messagePackKey;
	protected String reportDataDefinitionName;
	protected String reportDataDefinitionRevision;
	protected String status;
	protected long updatePrivilegeKey;
	protected DUDAInstance userDefinedAttributes;
	protected boolean variablesChanged;

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
	 * Gets the value of the dReportDataDefinitionVariables property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dReportDataDefinitionVariables property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDReportDataDefinitionVariables().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DReportDataDefinitionVariable }
	 * 
	 * 
	 */
	public List<DReportDataDefinitionVariable> getDReportDataDefinitionVariables() {
		if (dReportDataDefinitionVariables == null) {
			dReportDataDefinitionVariables = new ArrayList<DReportDataDefinitionVariable>();
		}
		return this.dReportDataDefinitionVariables;
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
	 * Gets the value of the reportDataDefinitionName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReportDataDefinitionName() {
		return reportDataDefinitionName;
	}

	/**
	 * Sets the value of the reportDataDefinitionName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReportDataDefinitionName(String value) {
		this.reportDataDefinitionName = value;
	}

	/**
	 * Gets the value of the reportDataDefinitionRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReportDataDefinitionRevision() {
		return reportDataDefinitionRevision;
	}

	/**
	 * Sets the value of the reportDataDefinitionRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReportDataDefinitionRevision(String value) {
		this.reportDataDefinitionRevision = value;
	}

	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStatus(String value) {
		this.status = value;
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
	 * Gets the value of the variablesChanged property.
	 * 
	 */
	public boolean isVariablesChanged() {
		return variablesChanged;
	}

	/**
	 * Sets the value of the variablesChanged property.
	 * 
	 */
	public void setVariablesChanged(boolean value) {
		this.variablesChanged = value;
	}

}
