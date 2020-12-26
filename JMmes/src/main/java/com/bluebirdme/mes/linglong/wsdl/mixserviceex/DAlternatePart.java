package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAlternatePart complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAlternatePart">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="conversionFactor" type="{dataobjects.common.plantops.datasweep.com}DUoMConversion" minOccurs="0"/>
 *         &lt;element name="maxReplacementPercent" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DAlternatePart", propOrder = { "auditInfo",
		"conversionFactor", "maxReplacementPercent", "parentKey", "parentType",
		"partNumber", "partRevision", "userDefinedAttributes" })
public class DAlternatePart extends DKeyed {

	protected DAuditInfo auditInfo;
	protected DUoMConversion conversionFactor;
	protected DMeasuredValue maxReplacementPercent;
	protected long parentKey;
	protected short parentType;
	protected String partNumber;
	protected String partRevision;
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
	 * Gets the value of the conversionFactor property.
	 * 
	 * @return possible object is {@link DUoMConversion }
	 * 
	 */
	public DUoMConversion getConversionFactor() {
		return conversionFactor;
	}

	/**
	 * Sets the value of the conversionFactor property.
	 * 
	 * @param value
	 *            allowed object is {@link DUoMConversion }
	 * 
	 */
	public void setConversionFactor(DUoMConversion value) {
		this.conversionFactor = value;
	}

	/**
	 * Gets the value of the maxReplacementPercent property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getMaxReplacementPercent() {
		return maxReplacementPercent;
	}

	/**
	 * Sets the value of the maxReplacementPercent property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setMaxReplacementPercent(DMeasuredValue value) {
		this.maxReplacementPercent = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the parentType property.
	 * 
	 */
	public short getParentType() {
		return parentType;
	}

	/**
	 * Sets the value of the parentType property.
	 * 
	 */
	public void setParentType(short value) {
		this.parentType = value;
	}

	/**
	 * Gets the value of the partNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * Sets the value of the partNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartNumber(String value) {
		this.partNumber = value;
	}

	/**
	 * Gets the value of the partRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartRevision() {
		return partRevision;
	}

	/**
	 * Sets the value of the partRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartRevision(String value) {
		this.partRevision = value;
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
