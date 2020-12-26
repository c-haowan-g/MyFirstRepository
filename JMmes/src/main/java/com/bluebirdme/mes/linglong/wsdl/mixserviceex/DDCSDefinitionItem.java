package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDCSDefinitionItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDCSDefinitionItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lowerBoundary" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lowerControl" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lowerSpec" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="prompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="textLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="textMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="upperBoundary" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="upperControl" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="upperSpec" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDCSDefinitionItem", propOrder = { "category", "description",
		"lowerBoundary", "lowerControl", "lowerSpec", "mandatory", "prompt",
		"target", "textLength", "textMask", "type", "upperBoundary",
		"upperControl", "upperSpec", "workInstructionKeys",
		"workInstructionKeysChanged", "workInstructionListKey" })
public class DDCSDefinitionItem extends DKeyed {

	protected String category;
	protected String description;
	protected double lowerBoundary;
	protected double lowerControl;
	protected double lowerSpec;
	protected boolean mandatory;
	protected String prompt;
	protected double target;
	protected int textLength;
	protected String textMask;
	protected short type;
	protected double upperBoundary;
	protected double upperControl;
	protected double upperSpec;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

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
	 * Gets the value of the lowerBoundary property.
	 * 
	 */
	public double getLowerBoundary() {
		return lowerBoundary;
	}

	/**
	 * Sets the value of the lowerBoundary property.
	 * 
	 */
	public void setLowerBoundary(double value) {
		this.lowerBoundary = value;
	}

	/**
	 * Gets the value of the lowerControl property.
	 * 
	 */
	public double getLowerControl() {
		return lowerControl;
	}

	/**
	 * Sets the value of the lowerControl property.
	 * 
	 */
	public void setLowerControl(double value) {
		this.lowerControl = value;
	}

	/**
	 * Gets the value of the lowerSpec property.
	 * 
	 */
	public double getLowerSpec() {
		return lowerSpec;
	}

	/**
	 * Sets the value of the lowerSpec property.
	 * 
	 */
	public void setLowerSpec(double value) {
		this.lowerSpec = value;
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
	 * Gets the value of the prompt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * Sets the value of the prompt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrompt(String value) {
		this.prompt = value;
	}

	/**
	 * Gets the value of the target property.
	 * 
	 */
	public double getTarget() {
		return target;
	}

	/**
	 * Sets the value of the target property.
	 * 
	 */
	public void setTarget(double value) {
		this.target = value;
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
	 * Gets the value of the textMask property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTextMask() {
		return textMask;
	}

	/**
	 * Sets the value of the textMask property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTextMask(String value) {
		this.textMask = value;
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
	 * Gets the value of the upperBoundary property.
	 * 
	 */
	public double getUpperBoundary() {
		return upperBoundary;
	}

	/**
	 * Sets the value of the upperBoundary property.
	 * 
	 */
	public void setUpperBoundary(double value) {
		this.upperBoundary = value;
	}

	/**
	 * Gets the value of the upperControl property.
	 * 
	 */
	public double getUpperControl() {
		return upperControl;
	}

	/**
	 * Sets the value of the upperControl property.
	 * 
	 */
	public void setUpperControl(double value) {
		this.upperControl = value;
	}

	/**
	 * Gets the value of the upperSpec property.
	 * 
	 */
	public double getUpperSpec() {
		return upperSpec;
	}

	/**
	 * Sets the value of the upperSpec property.
	 * 
	 */
	public void setUpperSpec(double value) {
		this.upperSpec = value;
	}

	/**
	 * Gets the value of the workInstructionKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workInstructionKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkInstructionKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getWorkInstructionKeys() {
		if (workInstructionKeys == null) {
			workInstructionKeys = new ArrayList<Long>();
		}
		return this.workInstructionKeys;
	}

	/**
	 * Gets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public boolean isWorkInstructionKeysChanged() {
		return workInstructionKeysChanged;
	}

	/**
	 * Sets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public void setWorkInstructionKeysChanged(boolean value) {
		this.workInstructionKeysChanged = value;
	}

	/**
	 * Gets the value of the workInstructionListKey property.
	 * 
	 */
	public long getWorkInstructionListKey() {
		return workInstructionListKey;
	}

	/**
	 * Sets the value of the workInstructionListKey property.
	 * 
	 */
	public void setWorkInstructionListKey(long value) {
		this.workInstructionListKey = value;
	}

}
