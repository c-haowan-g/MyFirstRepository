package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBoxExtended complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBoxExtended">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finishedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="previousNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previousNodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shippedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="userAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBoxExtended", propOrder = { "billAccountKey",
		"buildAccountKey", "category", "comment", "creationTime",
		"description", "finishedTime", "lastModifiedTime", "previousNodeName",
		"previousNodeType", "priority", "shipAccountKey", "shippedTime",
		"userAccountKey" })
public class DBoxExtended extends DDataObject {

	protected long billAccountKey;
	protected long buildAccountKey;
	protected String category;
	protected String comment;
	protected DTimestamp creationTime;
	protected String description;
	protected DTimestamp finishedTime;
	protected DTimestamp lastModifiedTime;
	protected String previousNodeName;
	protected String previousNodeType;
	protected int priority;
	protected long shipAccountKey;
	protected DTimestamp shippedTime;
	protected long userAccountKey;

	/**
	 * Gets the value of the billAccountKey property.
	 * 
	 */
	public long getBillAccountKey() {
		return billAccountKey;
	}

	/**
	 * Sets the value of the billAccountKey property.
	 * 
	 */
	public void setBillAccountKey(long value) {
		this.billAccountKey = value;
	}

	/**
	 * Gets the value of the buildAccountKey property.
	 * 
	 */
	public long getBuildAccountKey() {
		return buildAccountKey;
	}

	/**
	 * Sets the value of the buildAccountKey property.
	 * 
	 */
	public void setBuildAccountKey(long value) {
		this.buildAccountKey = value;
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
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
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
	 * Gets the value of the finishedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getFinishedTime() {
		return finishedTime;
	}

	/**
	 * Sets the value of the finishedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setFinishedTime(DTimestamp value) {
		this.finishedTime = value;
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
	 * Gets the value of the previousNodeName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousNodeName() {
		return previousNodeName;
	}

	/**
	 * Sets the value of the previousNodeName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousNodeName(String value) {
		this.previousNodeName = value;
	}

	/**
	 * Gets the value of the previousNodeType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreviousNodeType() {
		return previousNodeType;
	}

	/**
	 * Sets the value of the previousNodeType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreviousNodeType(String value) {
		this.previousNodeType = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 */
	public void setPriority(int value) {
		this.priority = value;
	}

	/**
	 * Gets the value of the shipAccountKey property.
	 * 
	 */
	public long getShipAccountKey() {
		return shipAccountKey;
	}

	/**
	 * Sets the value of the shipAccountKey property.
	 * 
	 */
	public void setShipAccountKey(long value) {
		this.shipAccountKey = value;
	}

	/**
	 * Gets the value of the shippedTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getShippedTime() {
		return shippedTime;
	}

	/**
	 * Sets the value of the shippedTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setShippedTime(DTimestamp value) {
		this.shippedTime = value;
	}

	/**
	 * Gets the value of the userAccountKey property.
	 * 
	 */
	public long getUserAccountKey() {
		return userAccountKey;
	}

	/**
	 * Sets the value of the userAccountKey property.
	 * 
	 */
	public void setUserAccountKey(long value) {
		this.userAccountKey = value;
	}

}
