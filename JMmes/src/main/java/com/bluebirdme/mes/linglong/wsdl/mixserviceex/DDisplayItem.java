package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDisplayItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDisplayItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="hideContent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hideLabel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="imageKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="labelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labelTextId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sourceAttribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDisplayItem", propOrder = { "hideContent", "hideLabel",
		"imageKey", "labelText", "labelTextId", "location", "source",
		"sourceAttribute", "sourceClass", "sourceName", "taskKey" })
public class DDisplayItem extends DKeyed {

	protected boolean hideContent;
	protected boolean hideLabel;
	protected long imageKey;
	protected String labelText;
	protected String labelTextId;
	protected short location;
	protected short source;
	protected String sourceAttribute;
	protected String sourceClass;
	protected String sourceName;
	protected long taskKey;

	/**
	 * Gets the value of the hideContent property.
	 * 
	 */
	public boolean isHideContent() {
		return hideContent;
	}

	/**
	 * Sets the value of the hideContent property.
	 * 
	 */
	public void setHideContent(boolean value) {
		this.hideContent = value;
	}

	/**
	 * Gets the value of the hideLabel property.
	 * 
	 */
	public boolean isHideLabel() {
		return hideLabel;
	}

	/**
	 * Sets the value of the hideLabel property.
	 * 
	 */
	public void setHideLabel(boolean value) {
		this.hideLabel = value;
	}

	/**
	 * Gets the value of the imageKey property.
	 * 
	 */
	public long getImageKey() {
		return imageKey;
	}

	/**
	 * Sets the value of the imageKey property.
	 * 
	 */
	public void setImageKey(long value) {
		this.imageKey = value;
	}

	/**
	 * Gets the value of the labelText property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelText() {
		return labelText;
	}

	/**
	 * Sets the value of the labelText property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelText(String value) {
		this.labelText = value;
	}

	/**
	 * Gets the value of the labelTextId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabelTextId() {
		return labelTextId;
	}

	/**
	 * Sets the value of the labelTextId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabelTextId(String value) {
		this.labelTextId = value;
	}

	/**
	 * Gets the value of the location property.
	 * 
	 */
	public short getLocation() {
		return location;
	}

	/**
	 * Sets the value of the location property.
	 * 
	 */
	public void setLocation(short value) {
		this.location = value;
	}

	/**
	 * Gets the value of the source property.
	 * 
	 */
	public short getSource() {
		return source;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 */
	public void setSource(short value) {
		this.source = value;
	}

	/**
	 * Gets the value of the sourceAttribute property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourceAttribute() {
		return sourceAttribute;
	}

	/**
	 * Sets the value of the sourceAttribute property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceAttribute(String value) {
		this.sourceAttribute = value;
	}

	/**
	 * Gets the value of the sourceClass property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourceClass() {
		return sourceClass;
	}

	/**
	 * Sets the value of the sourceClass property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceClass(String value) {
		this.sourceClass = value;
	}

	/**
	 * Gets the value of the sourceName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * Sets the value of the sourceName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourceName(String value) {
		this.sourceName = value;
	}

	/**
	 * Gets the value of the taskKey property.
	 * 
	 */
	public long getTaskKey() {
		return taskKey;
	}

	/**
	 * Sets the value of the taskKey property.
	 * 
	 */
	public void setTaskKey(long value) {
		this.taskKey = value;
	}

}
