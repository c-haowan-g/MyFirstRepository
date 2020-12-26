package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DActivitySetVariable complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DActivitySetVariable">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="customPersistenceClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inputVariable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="outputVariable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="persistenceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="setupVariable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tagDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DActivitySetVariable", propOrder = { "customPersistenceClass",
		"dataType", "defaultValue", "description", "inputVariable",
		"outputVariable", "persistenceType", "setupVariable",
		"tagDefinitionKey", "userDefinedAttributes" })
public class DActivitySetVariable extends DKeyed {

	protected String customPersistenceClass;
	protected String dataType;
	protected String defaultValue;
	protected String description;
	protected boolean inputVariable;
	protected boolean outputVariable;
	protected int persistenceType;
	protected boolean setupVariable;
	protected long tagDefinitionKey;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the customPersistenceClass property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomPersistenceClass() {
		return customPersistenceClass;
	}

	/**
	 * Sets the value of the customPersistenceClass property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomPersistenceClass(String value) {
		this.customPersistenceClass = value;
	}

	/**
	 * Gets the value of the dataType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDataType(String value) {
		this.dataType = value;
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
	 * Gets the value of the inputVariable property.
	 * 
	 */
	public boolean isInputVariable() {
		return inputVariable;
	}

	/**
	 * Sets the value of the inputVariable property.
	 * 
	 */
	public void setInputVariable(boolean value) {
		this.inputVariable = value;
	}

	/**
	 * Gets the value of the outputVariable property.
	 * 
	 */
	public boolean isOutputVariable() {
		return outputVariable;
	}

	/**
	 * Sets the value of the outputVariable property.
	 * 
	 */
	public void setOutputVariable(boolean value) {
		this.outputVariable = value;
	}

	/**
	 * Gets the value of the persistenceType property.
	 * 
	 */
	public int getPersistenceType() {
		return persistenceType;
	}

	/**
	 * Sets the value of the persistenceType property.
	 * 
	 */
	public void setPersistenceType(int value) {
		this.persistenceType = value;
	}

	/**
	 * Gets the value of the setupVariable property.
	 * 
	 */
	public boolean isSetupVariable() {
		return setupVariable;
	}

	/**
	 * Sets the value of the setupVariable property.
	 * 
	 */
	public void setSetupVariable(boolean value) {
		this.setupVariable = value;
	}

	/**
	 * Gets the value of the tagDefinitionKey property.
	 * 
	 */
	public long getTagDefinitionKey() {
		return tagDefinitionKey;
	}

	/**
	 * Sets the value of the tagDefinitionKey property.
	 * 
	 */
	public void setTagDefinitionKey(long value) {
		this.tagDefinitionKey = value;
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
