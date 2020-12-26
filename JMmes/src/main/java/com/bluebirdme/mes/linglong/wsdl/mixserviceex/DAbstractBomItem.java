package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="alternateChangeFlag" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consumptionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="decimalScale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enforceEffectiveConsumption" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lowerBoundaryQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="maxPercentEnforcementType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processingType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="recordConsumption" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="referenceDesignators" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceDesignatorsKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="replacementType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperBoundaryQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
@XmlType(name = "DAbstractBomItem", propOrder = { "alternateChangeFlag",
		"bomKey", "category", "consumptionType", "decimalScale", "description",
		"enforceEffectiveConsumption", "lowerBoundaryQuantity",
		"maxPercentEnforcementType", "partNumber", "partRevision",
		"processingType", "quantity", "recordConsumption",
		"referenceDesignators", "referenceDesignatorsKey", "replacementType",
		"unitOfMeasure", "upperBoundaryQuantity", "userDefinedAttributes" })
public abstract class DAbstractBomItem extends DKeyed {

	protected long alternateChangeFlag;
	protected long bomKey;
	protected String category;
	protected String consumptionType;
	protected int decimalScale;
	protected String description;
	protected boolean enforceEffectiveConsumption;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal lowerBoundaryQuantity;
	protected short maxPercentEnforcementType;
	protected String partNumber;
	protected String partRevision;
	protected short processingType;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantity;
	protected boolean recordConsumption;
	protected String referenceDesignators;
	protected long referenceDesignatorsKey;
	protected short replacementType;
	protected String unitOfMeasure;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal upperBoundaryQuantity;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the alternateChangeFlag property.
	 * 
	 */
	public long getAlternateChangeFlag() {
		return alternateChangeFlag;
	}

	/**
	 * Sets the value of the alternateChangeFlag property.
	 * 
	 */
	public void setAlternateChangeFlag(long value) {
		this.alternateChangeFlag = value;
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
	 * Gets the value of the consumptionType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConsumptionType() {
		return consumptionType;
	}

	/**
	 * Sets the value of the consumptionType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConsumptionType(String value) {
		this.consumptionType = value;
	}

	/**
	 * Gets the value of the decimalScale property.
	 * 
	 */
	public int getDecimalScale() {
		return decimalScale;
	}

	/**
	 * Sets the value of the decimalScale property.
	 * 
	 */
	public void setDecimalScale(int value) {
		this.decimalScale = value;
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
	 * Gets the value of the enforceEffectiveConsumption property.
	 * 
	 */
	public boolean isEnforceEffectiveConsumption() {
		return enforceEffectiveConsumption;
	}

	/**
	 * Sets the value of the enforceEffectiveConsumption property.
	 * 
	 */
	public void setEnforceEffectiveConsumption(boolean value) {
		this.enforceEffectiveConsumption = value;
	}

	/**
	 * Gets the value of the lowerBoundaryQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getLowerBoundaryQuantity() {
		return lowerBoundaryQuantity;
	}

	/**
	 * Sets the value of the lowerBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setLowerBoundaryQuantity(BigDecimal value) {
		this.lowerBoundaryQuantity = value;
	}

	/**
	 * Gets the value of the maxPercentEnforcementType property.
	 * 
	 */
	public short getMaxPercentEnforcementType() {
		return maxPercentEnforcementType;
	}

	/**
	 * Sets the value of the maxPercentEnforcementType property.
	 * 
	 */
	public void setMaxPercentEnforcementType(short value) {
		this.maxPercentEnforcementType = value;
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
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantity(BigDecimal value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the recordConsumption property.
	 * 
	 */
	public boolean isRecordConsumption() {
		return recordConsumption;
	}

	/**
	 * Sets the value of the recordConsumption property.
	 * 
	 */
	public void setRecordConsumption(boolean value) {
		this.recordConsumption = value;
	}

	/**
	 * Gets the value of the referenceDesignators property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceDesignators() {
		return referenceDesignators;
	}

	/**
	 * Sets the value of the referenceDesignators property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReferenceDesignators(String value) {
		this.referenceDesignators = value;
	}

	/**
	 * Gets the value of the referenceDesignatorsKey property.
	 * 
	 */
	public long getReferenceDesignatorsKey() {
		return referenceDesignatorsKey;
	}

	/**
	 * Sets the value of the referenceDesignatorsKey property.
	 * 
	 */
	public void setReferenceDesignatorsKey(long value) {
		this.referenceDesignatorsKey = value;
	}

	/**
	 * Gets the value of the replacementType property.
	 * 
	 */
	public short getReplacementType() {
		return replacementType;
	}

	/**
	 * Sets the value of the replacementType property.
	 * 
	 */
	public void setReplacementType(short value) {
		this.replacementType = value;
	}

	/**
	 * Gets the value of the unitOfMeasure property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * Sets the value of the unitOfMeasure property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnitOfMeasure(String value) {
		this.unitOfMeasure = value;
	}

	/**
	 * Gets the value of the upperBoundaryQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getUpperBoundaryQuantity() {
		return upperBoundaryQuantity;
	}

	/**
	 * Sets the value of the upperBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setUpperBoundaryQuantity(BigDecimal value) {
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
