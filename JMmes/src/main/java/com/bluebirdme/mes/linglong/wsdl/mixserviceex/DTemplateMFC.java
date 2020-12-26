package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DTemplateMFC complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DTemplateMFC">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="carrierClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finalProduct" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="matchPattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchTarget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="referenceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="successorKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DTemplateMFC", propOrder = { "carrierClassKey", "category",
		"description", "finalProduct", "inStepKey", "matchPattern",
		"matchTarget", "matchValue", "outStepKey", "partClassKey",
		"referenceType", "successorKey", "type", "userDefinedAttributes" })
public class DTemplateMFC extends DKeyed {

	protected long carrierClassKey;
	protected String category;
	protected String description;
	protected boolean finalProduct;
	protected long inStepKey;
	protected String matchPattern;
	protected String matchTarget;
	protected String matchValue;
	protected long outStepKey;
	protected long partClassKey;
	protected short referenceType;
	protected long successorKey;
	protected short type;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the carrierClassKey property.
	 * 
	 */
	public long getCarrierClassKey() {
		return carrierClassKey;
	}

	/**
	 * Sets the value of the carrierClassKey property.
	 * 
	 */
	public void setCarrierClassKey(long value) {
		this.carrierClassKey = value;
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
	 * Gets the value of the finalProduct property.
	 * 
	 */
	public boolean isFinalProduct() {
		return finalProduct;
	}

	/**
	 * Sets the value of the finalProduct property.
	 * 
	 */
	public void setFinalProduct(boolean value) {
		this.finalProduct = value;
	}

	/**
	 * Gets the value of the inStepKey property.
	 * 
	 */
	public long getInStepKey() {
		return inStepKey;
	}

	/**
	 * Sets the value of the inStepKey property.
	 * 
	 */
	public void setInStepKey(long value) {
		this.inStepKey = value;
	}

	/**
	 * Gets the value of the matchPattern property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMatchPattern() {
		return matchPattern;
	}

	/**
	 * Sets the value of the matchPattern property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMatchPattern(String value) {
		this.matchPattern = value;
	}

	/**
	 * Gets the value of the matchTarget property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMatchTarget() {
		return matchTarget;
	}

	/**
	 * Sets the value of the matchTarget property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMatchTarget(String value) {
		this.matchTarget = value;
	}

	/**
	 * Gets the value of the matchValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMatchValue() {
		return matchValue;
	}

	/**
	 * Sets the value of the matchValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMatchValue(String value) {
		this.matchValue = value;
	}

	/**
	 * Gets the value of the outStepKey property.
	 * 
	 */
	public long getOutStepKey() {
		return outStepKey;
	}

	/**
	 * Sets the value of the outStepKey property.
	 * 
	 */
	public void setOutStepKey(long value) {
		this.outStepKey = value;
	}

	/**
	 * Gets the value of the partClassKey property.
	 * 
	 */
	public long getPartClassKey() {
		return partClassKey;
	}

	/**
	 * Sets the value of the partClassKey property.
	 * 
	 */
	public void setPartClassKey(long value) {
		this.partClassKey = value;
	}

	/**
	 * Gets the value of the referenceType property.
	 * 
	 */
	public short getReferenceType() {
		return referenceType;
	}

	/**
	 * Sets the value of the referenceType property.
	 * 
	 */
	public void setReferenceType(short value) {
		this.referenceType = value;
	}

	/**
	 * Gets the value of the successorKey property.
	 * 
	 */
	public long getSuccessorKey() {
		return successorKey;
	}

	/**
	 * Sets the value of the successorKey property.
	 * 
	 */
	public void setSuccessorKey(long value) {
		this.successorKey = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
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
