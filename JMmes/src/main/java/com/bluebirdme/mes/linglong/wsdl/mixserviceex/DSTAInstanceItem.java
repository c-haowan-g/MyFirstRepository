package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTAInstanceItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTAInstanceItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="blobData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="listSupport" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valueList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTAInstanceItem", propOrder = { "blobData", "dataType",
		"listSupport", "name", "objectType", "value", "valueList" })
public class DSTAInstanceItem extends DDataObject {

	protected byte[] blobData;
	protected short dataType;
	protected boolean listSupport;
	protected String name;
	protected short objectType;
	protected String value;
	@XmlElement(nillable = true)
	protected List<String> valueList;

	/**
	 * Gets the value of the blobData property.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getBlobData() {
		return blobData;
	}

	/**
	 * Sets the value of the blobData property.
	 * 
	 * @param value
	 *            allowed object is byte[]
	 */
	public void setBlobData(byte[] value) {
		this.blobData = ((byte[]) value);
	}

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
	 * Gets the value of the listSupport property.
	 * 
	 */
	public boolean isListSupport() {
		return listSupport;
	}

	/**
	 * Sets the value of the listSupport property.
	 * 
	 */
	public void setListSupport(boolean value) {
		this.listSupport = value;
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
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the value of the valueList property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the valueList property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getValueList().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getValueList() {
		if (valueList == null) {
			valueList = new ArrayList<String>();
		}
		return this.valueList;
	}

}
