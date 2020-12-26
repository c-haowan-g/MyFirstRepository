package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DProcessBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DProcessBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="alternatePartGroups" type="{dataobjects.common.plantops.datasweep.com}DAlternatePartGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alternateParts" type="{dataobjects.common.plantops.datasweep.com}DAlternatePart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="doScaling" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lowerBoundaryQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processingType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="replacementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperBoundaryQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
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
@XmlType(name = "DProcessBomItem", propOrder = { "alternatePartGroups",
		"alternateParts", "auditInfo", "bomKey", "category", "description",
		"doScaling", "lowerBoundaryQuantity", "partNumber", "partRevision",
		"processingType", "quantity", "replacementType",
		"upperBoundaryQuantity", "userDefinedAttributes" })
public class DProcessBomItem extends DKeyed {

	@XmlElement(nillable = true)
	protected List<DAlternatePartGroup> alternatePartGroups;
	@XmlElement(nillable = true)
	protected List<DAlternatePart> alternateParts;
	protected DAuditInfo auditInfo;
	protected long bomKey;
	protected String category;
	protected String description;
	protected boolean doScaling;
	protected DMeasuredValue lowerBoundaryQuantity;
	protected String partNumber;
	protected String partRevision;
	protected short processingType;
	protected DMeasuredValue quantity;
	protected String replacementType;
	protected DMeasuredValue upperBoundaryQuantity;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the alternatePartGroups property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the alternatePartGroups property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAlternatePartGroups().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAlternatePartGroup }
	 * 
	 * 
	 */
	public List<DAlternatePartGroup> getAlternatePartGroups() {
		if (alternatePartGroups == null) {
			alternatePartGroups = new ArrayList<DAlternatePartGroup>();
		}
		return this.alternatePartGroups;
	}

	/**
	 * Gets the value of the alternateParts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the alternateParts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAlternateParts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAlternatePart }
	 * 
	 * 
	 */
	public List<DAlternatePart> getAlternateParts() {
		if (alternateParts == null) {
			alternateParts = new ArrayList<DAlternatePart>();
		}
		return this.alternateParts;
	}

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
	 * Gets the value of the bomKey property.
	 * 
	 */
	public long getBomKey() {
		return bomKey;
	}

	/**
	 * Sets the value of the bomKey property.
	 * 
	 */
	public void setBomKey(long value) {
		this.bomKey = value;
	}

	/**
	 * Gets the value of the category property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the value of the category property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategory(String value) {
		this.category = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the doScaling property.
	 * 
	 */
	public boolean isDoScaling() {
		return doScaling;
	}

	/**
	 * Sets the value of the doScaling property.
	 * 
	 */
	public void setDoScaling(boolean value) {
		this.doScaling = value;
	}

	/**
	 * Gets the value of the lowerBoundaryQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getLowerBoundaryQuantity() {
		return lowerBoundaryQuantity;
	}

	/**
	 * Sets the value of the lowerBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setLowerBoundaryQuantity(DMeasuredValue value) {
		this.lowerBoundaryQuantity = value;
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
	 * Gets the value of the processingType property.
	 * 
	 */
	public short getProcessingType() {
		return processingType;
	}

	/**
	 * Sets the value of the processingType property.
	 * 
	 */
	public void setProcessingType(short value) {
		this.processingType = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantity(DMeasuredValue value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the replacementType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReplacementType() {
		return replacementType;
	}

	/**
	 * Sets the value of the replacementType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReplacementType(String value) {
		this.replacementType = value;
	}

	/**
	 * Gets the value of the upperBoundaryQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getUpperBoundaryQuantity() {
		return upperBoundaryQuantity;
	}

	/**
	 * Sets the value of the upperBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setUpperBoundaryQuantity(DMeasuredValue value) {
		this.upperBoundaryQuantity = value;
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
