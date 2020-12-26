package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DATIndexColumnInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DATIndexColumnInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="column" type="{dataobjects.common.plantops.datasweep.com}DATColumnDefinition" minOccurs="0"/>
 *         &lt;element name="sortDirection" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATIndexColumnInfo", propOrder = { "column", "sortDirection" })
public class DATIndexColumnInfo extends DDataObject {

	protected DATColumnDefinition column;
	protected short sortDirection;

	/**
	 * Gets the value of the column property.
	 * 
	 * @return possible object is {@link DATColumnDefinition }
	 * 
	 */
	public DATColumnDefinition getColumn() {
		return column;
	}

	/**
	 * Sets the value of the column property.
	 * 
	 * @param value
	 *            allowed object is {@link DATColumnDefinition }
	 * 
	 */
	public void setColumn(DATColumnDefinition value) {
		this.column = value;
	}

	/**
	 * Gets the value of the sortDirection property.
	 * 
	 */
	public short getSortDirection() {
		return sortDirection;
	}

	/**
	 * Sets the value of the sortDirection property.
	 * 
	 */
	public void setSortDirection(short value) {
		this.sortDirection = value;
	}

}
