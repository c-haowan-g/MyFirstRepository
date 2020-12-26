package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUDADefinitionItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUDADefinitionItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultListValue" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="listSupport" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="referredObjectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="textLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUDADefinitionItem", propOrder = { "category",
		"defaultListValue", "defaultValue", "description", "listKey",
		"listSupport", "name", "objectType", "referredObjectId", "textLength",
		"type" })
public class DUDADefinitionItem extends DDataObject {

	protected String category;
	@XmlElement(nillable = true)
	protected List<String> defaultListValue;
	protected String defaultValue;
	protected String description;
	protected long listKey;
	protected boolean listSupport;
	protected String name;
	protected short objectType;
	protected long referredObjectId;
	protected int textLength;
	protected short type;

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
	 * Gets the value of the defaultListValue property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the defaultListValue property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDefaultListValue().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getDefaultListValue() {
		if (defaultListValue == null) {
			defaultListValue = new ArrayList<String>();
		}
		return this.defaultListValue;
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
	 * Gets the value of the listKey property.
	 * 
	 */
	public long getListKey() {
		return listKey;
	}

	/**
	 * Sets the value of the listKey property.
	 * 
	 */
	public void setListKey(long value) {
		this.listKey = value;
	}

	/**
	 * Gets the value of the listSupport property.
	 * 
	 */
	public boolean isListSupport() {
		return listSupport;
	}

	/**
	 * Sets the value of the listSupport property.
	 * 
	 */
	public void setListSupport(boolean value) {
		this.listSupport = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
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
	 * Gets the value of the referredObjectId property.
	 * 
	 */
	public long getReferredObjectId() {
		return referredObjectId;
	}

	/**
	 * Sets the value of the referredObjectId property.
	 * 
	 */
	public void setReferredObjectId(long value) {
		this.referredObjectId = value;
	}

	/**
	 * Gets the value of the textLength property.
	 * 
	 */
	public int getTextLength() {
		return textLength;
	}

	/**
	 * Sets the value of the textLength property.
	 * 
	 */
	public void setTextLength(int value) {
		this.textLength = value;
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

}
