package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DParameter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="dcsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="decimalScale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="definitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ownerKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ownerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="routeStepKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="specifiction" type="{dataobjects.common.plantops.datasweep.com}DSpecification" minOccurs="0"/>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DParameter", propOrder = { "dataType", "dcsName",
		"decimalScale", "definitionKey", "group", "objectType", "ownerKey",
		"ownerType", "routeStepKeys", "specifiction", "unitOfMeasure",
		"userDefinedAttributes", "value" })
public class DParameter extends DCategorical {

	protected short dataType;
	protected String dcsName;
	protected int decimalScale;
	protected long definitionKey;
	protected String group;
	protected short objectType;
	protected long ownerKey;
	protected short ownerType;
	@XmlElement(type = Long.class)
	protected List<Long> routeStepKeys;
	protected DSpecification specifiction;
	protected String unitOfMeasure;
	protected DUDAInstance userDefinedAttributes;
	protected String value;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public short getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(short value) {
		this.dataType = value;
	}

	/**
	 * Gets the value of the dcsName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDcsName() {
		return dcsName;
	}

	/**
	 * Sets the value of the dcsName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDcsName(String value) {
		this.dcsName = value;
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
	 * Gets the value of the definitionKey property.
	 * 
	 */
	public long getDefinitionKey() {
		return definitionKey;
	}

	/**
	 * Sets the value of the definitionKey property.
	 * 
	 */
	public void setDefinitionKey(long value) {
		this.definitionKey = value;
	}

	/**
	 * Gets the value of the group property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the value of the group property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGroup(String value) {
		this.group = value;
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
	 * Gets the value of the ownerKey property.
	 * 
	 */
	public long getOwnerKey() {
		return ownerKey;
	}

	/**
	 * Sets the value of the ownerKey property.
	 * 
	 */
	public void setOwnerKey(long value) {
		this.ownerKey = value;
	}

	/**
	 * Gets the value of the ownerType property.
	 * 
	 */
	public short getOwnerType() {
		return ownerType;
	}

	/**
	 * Sets the value of the ownerType property.
	 * 
	 */
	public void setOwnerType(short value) {
		this.ownerType = value;
	}

	/**
	 * Gets the value of the routeStepKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the routeStepKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRouteStepKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getRouteStepKeys() {
		if (routeStepKeys == null) {
			routeStepKeys = new ArrayList<Long>();
		}
		return this.routeStepKeys;
	}

	/**
	 * Gets the value of the specifiction property.
	 * 
	 * @return possible object is {@link DSpecification }
	 * 
	 */
	public DSpecification getSpecifiction() {
		return specifiction;
	}

	/**
	 * Sets the value of the specifiction property.
	 * 
	 * @param value
	 *            allowed object is {@link DSpecification }
	 * 
	 */
	public void setSpecifiction(DSpecification value) {
		this.specifiction = value;
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
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
