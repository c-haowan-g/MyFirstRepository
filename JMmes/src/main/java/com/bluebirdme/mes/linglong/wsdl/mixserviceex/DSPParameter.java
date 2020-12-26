package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSPParameter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSPParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resultSetValue" type="{dataobjects.common.plantops.datasweep.com}DDataSet" minOccurs="0"/>
 *         &lt;element name="simpleValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSPParameter", propOrder = { "dataType", "name",
		"resultSetValue", "simpleValue", "type" })
public class DSPParameter {

	protected short dataType;
	protected String name;
	protected DDataSet resultSetValue;
	protected String simpleValue;
	protected short type;

	/**
	 * Gets the value of the dataType property.
	 * 
	 */
	public short getDataType() {
		return dataType;
	}

	/**
	 * Sets the value of the dataType property.
	 * 
	 */
	public void setDataType(short value) {
		this.dataType = value;
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
	 * Gets the value of the resultSetValue property.
	 * 
	 * @return possible object is {@link DDataSet }
	 * 
	 */
	public DDataSet getResultSetValue() {
		return resultSetValue;
	}

	/**
	 * Sets the value of the resultSetValue property.
	 * 
	 * @param value
	 *            allowed object is {@link DDataSet }
	 * 
	 */
	public void setResultSetValue(DDataSet value) {
		this.resultSetValue = value;
	}

	/**
	 * Gets the value of the simpleValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSimpleValue() {
		return simpleValue;
	}

	/**
	 * Sets the value of the simpleValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSimpleValue(String value) {
		this.simpleValue = value;
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
