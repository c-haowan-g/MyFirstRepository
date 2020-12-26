package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DATIndexDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DATIndexDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="columnInfo" type="{dataobjects.common.plantops.datasweep.com}DATIndexColumnInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="constraintType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATIndexDefinition", propOrder = { "columnInfo",
		"constraintType", "description", "lastModifiedTime" })
public class DATIndexDefinition extends DKeyed {

	@XmlElement(nillable = true)
	protected List<DATIndexColumnInfo> columnInfo;
	protected short constraintType;
	protected String description;
	protected DTimestamp lastModifiedTime;

	/**
	 * Gets the value of the columnInfo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the columnInfo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getColumnInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DATIndexColumnInfo }
	 * 
	 * 
	 */
	public List<DATIndexColumnInfo> getColumnInfo() {
		if (columnInfo == null) {
			columnInfo = new ArrayList<DATIndexColumnInfo>();
		}
		return this.columnInfo;
	}

	/**
	 * Gets the value of the constraintType property.
	 * 
	 */
	public short getConstraintType() {
		return constraintType;
	}

	/**
	 * Sets the value of the constraintType property.
	 * 
	 */
	public void setConstraintType(short value) {
		this.constraintType = value;
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

}
