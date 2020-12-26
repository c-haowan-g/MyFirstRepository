package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTADefinitionIndex complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTADefinitionIndex">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="columnInfo" type="{dataobjects.common.plantops.datasweep.com}DSTADefinitionIndexColumn" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="columnNamesChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STADefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTADefinitionIndex", propOrder = { "auditInfo", "columnInfo",
		"columnNamesChanged", "description", "staDefinitionKey" })
public class DSTADefinitionIndex extends DKeyed {

	protected DAuditInfo auditInfo;
	@XmlElement(nillable = true)
	protected List<DSTADefinitionIndexColumn> columnInfo;
	protected boolean columnNamesChanged;
	protected String description;
	@XmlElement(name = "STADefinitionKey")
	protected long staDefinitionKey;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

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
	 * {@link DSTADefinitionIndexColumn }
	 * 
	 * 
	 */
	public List<DSTADefinitionIndexColumn> getColumnInfo() {
		if (columnInfo == null) {
			columnInfo = new ArrayList<DSTADefinitionIndexColumn>();
		}
		return this.columnInfo;
	}

	/**
	 * Gets the value of the columnNamesChanged property.
	 * 
	 */
	public boolean isColumnNamesChanged() {
		return columnNamesChanged;
	}

	/**
	 * Sets the value of the columnNamesChanged property.
	 * 
	 */
	public void setColumnNamesChanged(boolean value) {
		this.columnNamesChanged = value;
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
	 * Gets the value of the staDefinitionKey property.
	 * 
	 */
	public long getSTADefinitionKey() {
		return staDefinitionKey;
	}

	/**
	 * Sets the value of the staDefinitionKey property.
	 * 
	 */
	public void setSTADefinitionKey(long value) {
		this.staDefinitionKey = value;
	}

}
