package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractChecklist complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractChecklist">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="checkboxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="checkboxHeadings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="commentHeading" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataItemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataItemHeadings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="descriptionHeading" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemHeading" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAbstractChecklist", propOrder = { "checkboxCount",
		"checkboxHeadings", "commentHeading", "dataItemCount",
		"dataItemHeadings", "descriptionHeading", "itemHeading" })
public abstract class DAbstractChecklist extends DCategorical {

	protected int checkboxCount;
	@XmlElement(nillable = true)
	protected List<String> checkboxHeadings;
	protected String commentHeading;
	protected int dataItemCount;
	@XmlElement(nillable = true)
	protected List<String> dataItemHeadings;
	protected String descriptionHeading;
	protected String itemHeading;

	/**
	 * Gets the value of the checkboxCount property.
	 * 
	 */
	public int getCheckboxCount() {
		return checkboxCount;
	}

	/**
	 * Sets the value of the checkboxCount property.
	 * 
	 */
	public void setCheckboxCount(int value) {
		this.checkboxCount = value;
	}

	/**
	 * Gets the value of the checkboxHeadings property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the checkboxHeadings property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCheckboxHeadings().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getCheckboxHeadings() {
		if (checkboxHeadings == null) {
			checkboxHeadings = new ArrayList<String>();
		}
		return this.checkboxHeadings;
	}

	/**
	 * Gets the value of the commentHeading property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCommentHeading() {
		return commentHeading;
	}

	/**
	 * Sets the value of the commentHeading property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCommentHeading(String value) {
		this.commentHeading = value;
	}

	/**
	 * Gets the value of the dataItemCount property.
	 * 
	 */
	public int getDataItemCount() {
		return dataItemCount;
	}

	/**
	 * Sets the value of the dataItemCount property.
	 * 
	 */
	public void setDataItemCount(int value) {
		this.dataItemCount = value;
	}

	/**
	 * Gets the value of the dataItemHeadings property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dataItemHeadings property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDataItemHeadings().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getDataItemHeadings() {
		if (dataItemHeadings == null) {
			dataItemHeadings = new ArrayList<String>();
		}
		return this.dataItemHeadings;
	}

	/**
	 * Gets the value of the descriptionHeading property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescriptionHeading() {
		return descriptionHeading;
	}

	/**
	 * Sets the value of the descriptionHeading property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescriptionHeading(String value) {
		this.descriptionHeading = value;
	}

	/**
	 * Gets the value of the itemHeading property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getItemHeading() {
		return itemHeading;
	}

	/**
	 * Sets the value of the itemHeading property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setItemHeading(String value) {
		this.itemHeading = value;
	}

}
