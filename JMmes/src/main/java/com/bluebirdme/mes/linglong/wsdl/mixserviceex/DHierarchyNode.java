package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DHierarchyNode complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DHierarchyNode">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="levelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentNodeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DHierarchyNode", propOrder = { "key", "levelName", "name",
		"parentNodeKey", "parentNodeName" })
public class DHierarchyNode extends DDataObject {

	protected long key;
	protected String levelName;
	protected String name;
	protected long parentNodeKey;
	protected String parentNodeName;

	/**
	 * Gets the value of the key property.
	 * 
	 */
	public long getKey() {
		return key;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 */
	public void setKey(long value) {
		this.key = value;
	}

	/**
	 * Gets the value of the levelName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * Sets the value of the levelName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLevelName(String value) {
		this.levelName = value;
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
	 * Gets the value of the parentNodeKey property.
	 * 
	 */
	public long getParentNodeKey() {
		return parentNodeKey;
	}

	/**
	 * Sets the value of the parentNodeKey property.
	 * 
	 */
	public void setParentNodeKey(long value) {
		this.parentNodeKey = value;
	}

	/**
	 * Gets the value of the parentNodeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getParentNodeName() {
		return parentNodeName;
	}

	/**
	 * Sets the value of the parentNodeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setParentNodeName(String value) {
		this.parentNodeName = value;
	}

}
