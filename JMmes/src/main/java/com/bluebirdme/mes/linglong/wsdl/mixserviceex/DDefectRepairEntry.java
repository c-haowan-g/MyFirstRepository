package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDefectRepairEntry complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDefectRepairEntry">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="defectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectLocationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectOperationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectRouteKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defectRouteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectRouteStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectSubLocationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defectUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="repairCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairLocationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairOperationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairRouteKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="repairRouteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairRouteStepName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repairUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repaired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="testInstanceKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DDefectRepairEntry", propOrder = { "auditInfo",
		"creationTime", "defectCode", "defectComment", "defectLocationName",
		"defectOperationName", "defectRouteKey", "defectRouteName",
		"defectRouteStepName", "defectSubLocationName", "defectUserName",
		"lastModifiedTime", "repairCode", "repairComment",
		"repairLocationName", "repairOperationName", "repairRouteKey",
		"repairRouteName", "repairRouteStepName", "repairUserName", "repaired",
		"testInstanceKey", "userDefinedAttributes" })
public class DDefectRepairEntry extends DKeyed {

	protected DAuditInfo auditInfo;
	protected DTimestamp creationTime;
	protected String defectCode;
	protected String defectComment;
	protected String defectLocationName;
	protected String defectOperationName;
	protected long defectRouteKey;
	protected String defectRouteName;
	protected String defectRouteStepName;
	protected String defectSubLocationName;
	protected String defectUserName;
	protected DTimestamp lastModifiedTime;
	protected String repairCode;
	protected String repairComment;
	protected String repairLocationName;
	protected String repairOperationName;
	protected long repairRouteKey;
	protected String repairRouteName;
	protected String repairRouteStepName;
	protected String repairUserName;
	protected boolean repaired;
	protected long testInstanceKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
	}

	/**
	 * Gets the value of the defectCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectCode() {
		return defectCode;
	}

	/**
	 * Sets the value of the defectCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectCode(String value) {
		this.defectCode = value;
	}

	/**
	 * Gets the value of the defectComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectComment() {
		return defectComment;
	}

	/**
	 * Sets the value of the defectComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectComment(String value) {
		this.defectComment = value;
	}

	/**
	 * Gets the value of the defectLocationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectLocationName() {
		return defectLocationName;
	}

	/**
	 * Sets the value of the defectLocationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectLocationName(String value) {
		this.defectLocationName = value;
	}

	/**
	 * Gets the value of the defectOperationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectOperationName() {
		return defectOperationName;
	}

	/**
	 * Sets the value of the defectOperationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectOperationName(String value) {
		this.defectOperationName = value;
	}

	/**
	 * Gets the value of the defectRouteKey property.
	 * 
	 */
	public long getDefectRouteKey() {
		return defectRouteKey;
	}

	/**
	 * Sets the value of the defectRouteKey property.
	 * 
	 */
	public void setDefectRouteKey(long value) {
		this.defectRouteKey = value;
	}

	/**
	 * Gets the value of the defectRouteName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectRouteName() {
		return defectRouteName;
	}

	/**
	 * Sets the value of the defectRouteName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectRouteName(String value) {
		this.defectRouteName = value;
	}

	/**
	 * Gets the value of the defectRouteStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectRouteStepName() {
		return defectRouteStepName;
	}

	/**
	 * Sets the value of the defectRouteStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectRouteStepName(String value) {
		this.defectRouteStepName = value;
	}

	/**
	 * Gets the value of the defectSubLocationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectSubLocationName() {
		return defectSubLocationName;
	}

	/**
	 * Sets the value of the defectSubLocationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectSubLocationName(String value) {
		this.defectSubLocationName = value;
	}

	/**
	 * Gets the value of the defectUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefectUserName() {
		return defectUserName;
	}

	/**
	 * Sets the value of the defectUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefectUserName(String value) {
		this.defectUserName = value;
	}

	/**
	 * Gets the value of the lastModifiedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * Sets the value of the lastModifiedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setLastModifiedTime(DTimestamp value) {
		this.lastModifiedTime = value;
	}

	/**
	 * Gets the value of the repairCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairCode() {
		return repairCode;
	}

	/**
	 * Sets the value of the repairCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairCode(String value) {
		this.repairCode = value;
	}

	/**
	 * Gets the value of the repairComment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairComment() {
		return repairComment;
	}

	/**
	 * Sets the value of the repairComment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairComment(String value) {
		this.repairComment = value;
	}

	/**
	 * Gets the value of the repairLocationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairLocationName() {
		return repairLocationName;
	}

	/**
	 * Sets the value of the repairLocationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairLocationName(String value) {
		this.repairLocationName = value;
	}

	/**
	 * Gets the value of the repairOperationName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairOperationName() {
		return repairOperationName;
	}

	/**
	 * Sets the value of the repairOperationName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairOperationName(String value) {
		this.repairOperationName = value;
	}

	/**
	 * Gets the value of the repairRouteKey property.
	 * 
	 */
	public long getRepairRouteKey() {
		return repairRouteKey;
	}

	/**
	 * Sets the value of the repairRouteKey property.
	 * 
	 */
	public void setRepairRouteKey(long value) {
		this.repairRouteKey = value;
	}

	/**
	 * Gets the value of the repairRouteName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairRouteName() {
		return repairRouteName;
	}

	/**
	 * Sets the value of the repairRouteName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairRouteName(String value) {
		this.repairRouteName = value;
	}

	/**
	 * Gets the value of the repairRouteStepName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairRouteStepName() {
		return repairRouteStepName;
	}

	/**
	 * Sets the value of the repairRouteStepName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairRouteStepName(String value) {
		this.repairRouteStepName = value;
	}

	/**
	 * Gets the value of the repairUserName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRepairUserName() {
		return repairUserName;
	}

	/**
	 * Sets the value of the repairUserName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRepairUserName(String value) {
		this.repairUserName = value;
	}

	/**
	 * Gets the value of the repaired property.
	 * 
	 */
	public boolean isRepaired() {
		return repaired;
	}

	/**
	 * Sets the value of the repaired property.
	 * 
	 */
	public void setRepaired(boolean value) {
		this.repaired = value;
	}

	/**
	 * Gets the value of the testInstanceKey property.
	 * 
	 */
	public long getTestInstanceKey() {
		return testInstanceKey;
	}

	/**
	 * Sets the value of the testInstanceKey property.
	 * 
	 */
	public void setTestInstanceKey(long value) {
		this.testInstanceKey = value;
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
