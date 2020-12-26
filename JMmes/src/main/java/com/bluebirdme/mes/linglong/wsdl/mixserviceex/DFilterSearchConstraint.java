package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFilterSearchConstraint complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFilterSearchConstraint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attribute" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="attributeIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comparisonOperator" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orSearchConstraints" type="{dataobjects.common.plantops.datasweep.com}DFilterSearchConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="otherAttribute" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="subFilter" type="{dataobjects.common.plantops.datasweep.com}DSubFilter" minOccurs="0"/>
 *         &lt;element name="values" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DFilterSearchConstraint", propOrder = { "attribute",
		"attributeIdentifier", "comparisonOperator", "orSearchConstraints",
		"otherAttribute", "subFilter", "values" })
public class DFilterSearchConstraint {

	protected short attribute;
	protected String attributeIdentifier;
	protected short comparisonOperator;
	@XmlElement(nillable = true)
	protected List<DFilterSearchConstraint> orSearchConstraints;
	protected short otherAttribute;
	protected DSubFilter subFilter;
	@XmlElement(nillable = true)
	protected List<String> values;

	/**
	 * Gets the value of the attribute property.
	 * 
	 */
	public short getAttribute() {
		return attribute;
	}

	/**
	 * Sets the value of the attribute property.
	 * 
	 */
	public void setAttribute(short value) {
		this.attribute = value;
	}

	/**
	 * Gets the value of the attributeIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAttributeIdentifier() {
		return attributeIdentifier;
	}

	/**
	 * Sets the value of the attributeIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAttributeIdentifier(String value) {
		this.attributeIdentifier = value;
	}

	/**
	 * Gets the value of the comparisonOperator property.
	 * 
	 */
	public short getComparisonOperator() {
		return comparisonOperator;
	}

	/**
	 * Sets the value of the comparisonOperator property.
	 * 
	 */
	public void setComparisonOperator(short value) {
		this.comparisonOperator = value;
	}

	/**
	 * Gets the value of the orSearchConstraints property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orSearchConstraints property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrSearchConstraints().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DFilterSearchConstraint }
	 * 
	 * 
	 */
	public List<DFilterSearchConstraint> getOrSearchConstraints() {
		if (orSearchConstraints == null) {
			orSearchConstraints = new ArrayList<DFilterSearchConstraint>();
		}
		return this.orSearchConstraints;
	}

	/**
	 * Gets the value of the otherAttribute property.
	 * 
	 */
	public short getOtherAttribute() {
		return otherAttribute;
	}

	/**
	 * Sets the value of the otherAttribute property.
	 * 
	 */
	public void setOtherAttribute(short value) {
		this.otherAttribute = value;
	}

	/**
	 * Gets the value of the subFilter property.
	 * 
	 * @return possible object is {@link DSubFilter }
	 * 
	 */
	public DSubFilter getSubFilter() {
		return subFilter;
	}

	/**
	 * Sets the value of the subFilter property.
	 * 
	 * @param value
	 *            allowed object is {@link DSubFilter }
	 * 
	 */
	public void setSubFilter(DSubFilter value) {
		this.subFilter = value;
	}

	/**
	 * Gets the value of the values property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the values property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getValues().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getValues() {
		if (values == null) {
			values = new ArrayList<String>();
		}
		return this.values;
	}

}
