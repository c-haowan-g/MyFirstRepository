package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDataDictionaryElement complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDataDictionaryElement">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="choiceList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDictionaryClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="editable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="editorClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hidden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="validationConfiguration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validatorClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDataDictionaryElement", propOrder = { "categoryId",
		"choiceList", "dataDictionaryClassKey", "defaultValue", "editable",
		"editorClassName", "hidden", "lastModifiedTime", "length", "mandatory",
		"userDefinedAttributes", "validationConfiguration",
		"validatorClassName" })
public class DDataDictionaryElement extends DKeyed {

	protected String categoryId;
	protected String choiceList;
	protected long dataDictionaryClassKey;
	protected String defaultValue;
	protected boolean editable;
	protected String editorClassName;
	protected boolean hidden;
	protected DTimestamp lastModifiedTime;
	protected int length;
	protected boolean mandatory;
	protected DUDAInstance userDefinedAttributes;
	protected String validationConfiguration;
	protected String validatorClassName;

	/**
	 * Gets the value of the categoryId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the value of the categoryId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategoryId(String value) {
		this.categoryId = value;
	}

	/**
	 * Gets the value of the choiceList property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChoiceList() {
		return choiceList;
	}

	/**
	 * Sets the value of the choiceList property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChoiceList(String value) {
		this.choiceList = value;
	}

	/**
	 * Gets the value of the dataDictionaryClassKey property.
	 * 
	 */
	public long getDataDictionaryClassKey() {
		return dataDictionaryClassKey;
	}

	/**
	 * Sets the value of the dataDictionaryClassKey property.
	 * 
	 */
	public void setDataDictionaryClassKey(long value) {
		this.dataDictionaryClassKey = value;
	}

	/**
	 * Gets the value of the defaultValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the value of the defaultValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}

	/**
	 * Gets the value of the editable property.
	 * 
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets the value of the editable property.
	 * 
	 */
	public void setEditable(boolean value) {
		this.editable = value;
	}

	/**
	 * Gets the value of the editorClassName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEditorClassName() {
		return editorClassName;
	}

	/**
	 * Sets the value of the editorClassName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEditorClassName(String value) {
		this.editorClassName = value;
	}

	/**
	 * Gets the value of the hidden property.
	 * 
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the value of the hidden property.
	 * 
	 */
	public void setHidden(boolean value) {
		this.hidden = value;
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
	 * Gets the value of the length property.
	 * 
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 */
	public void setLength(int value) {
		this.length = value;
	}

	/**
	 * Gets the value of the mandatory property.
	 * 
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * Sets the value of the mandatory property.
	 * 
	 */
	public void setMandatory(boolean value) {
		this.mandatory = value;
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
	 * Gets the value of the validationConfiguration property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValidationConfiguration() {
		return validationConfiguration;
	}

	/**
	 * Sets the value of the validationConfiguration property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValidationConfiguration(String value) {
		this.validationConfiguration = value;
	}

	/**
	 * Gets the value of the validatorClassName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValidatorClassName() {
		return validatorClassName;
	}

	/**
	 * Sets the value of the validatorClassName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValidatorClassName(String value) {
		this.validatorClassName = value;
	}

}
