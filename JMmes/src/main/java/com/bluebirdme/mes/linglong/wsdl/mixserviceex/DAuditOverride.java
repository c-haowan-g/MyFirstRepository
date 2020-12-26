package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAuditOverride complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAuditOverride">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="overrideTableType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAuditOverride", propOrder = { "overrideTableType",
		"tableName" })
public class DAuditOverride extends DDataObject {

	protected int overrideTableType;
	protected String tableName;

	/**
	 * Gets the value of the overrideTableType property.
	 * 
	 */
	public int getOverrideTableType() {
		return overrideTableType;
	}

	/**
	 * Sets the value of the overrideTableType property.
	 * 
	 */
	public void setOverrideTableType(int value) {
		this.overrideTableType = value;
	}

	/**
	 * Gets the value of the tableName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * Sets the value of the tableName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTableName(String value) {
		this.tableName = value;
	}

}
