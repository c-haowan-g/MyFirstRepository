package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DListItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DListItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="itemOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DListItem", propOrder = { "itemOrder", "itemValue" })
public class DListItem extends DDataObject {

	protected int itemOrder;
	protected String itemValue;

	/**
	 * Gets the value of the itemOrder property.
	 * 
	 */
	public int getItemOrder() {
		return itemOrder;
	}

	/**
	 * Sets the value of the itemOrder property.
	 * 
	 */
	public void setItemOrder(int value) {
		this.itemOrder = value;
	}

	/**
	 * Gets the value of the itemValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getItemValue() {
		return itemValue;
	}

	/**
	 * Sets the value of the itemValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setItemValue(String value) {
		this.itemValue = value;
	}

}
