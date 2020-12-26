package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DATRow complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DATRow">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="atDefinitionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="dataCells" type="{dataobjects.common.plantops.datasweep.com}DATCell" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dependentATRows" type="{dataobjects.common.plantops.datasweep.com}DATRow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detailRows" type="{dataobjects.common.plantops.datasweep.com}DATRow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastModifiedTime" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="purgeStatus" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATRow", propOrder = { "atDefinitionKey", "auditInfo",
		"creationTime", "dataCells", "dependentATRows", "detailRows",
		"lastModifiedTime", "parentKey", "purgeStatus", "type" })
public class DATRow extends DKeyed {

	protected long atDefinitionKey;
	protected DAuditInfo auditInfo;
	protected DTimestamp creationTime;
	@XmlElement(nillable = true)
	protected List<DATCell> dataCells;
	@XmlElement(nillable = true)
	protected List<DATRow> dependentATRows;
	@XmlElement(nillable = true)
	protected List<DATRow> detailRows;
	protected DTimestamp lastModifiedTime;
	protected long parentKey;
	protected boolean purgeStatus;
	protected short type;

	/**
	 * Gets the value of the atDefinitionKey property.
	 * 
	 */
	public long getAtDefinitionKey() {
		return atDefinitionKey;
	}

	/**
	 * Sets the value of the atDefinitionKey property.
	 * 
	 */
	public void setAtDefinitionKey(long value) {
		this.atDefinitionKey = value;
	}

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
	 * Gets the value of the creationTime property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * Sets the value of the creationTime property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setCreationTime(DTimestamp value) {
		this.creationTime = value;
	}

	/**
	 * Gets the value of the dataCells property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dataCells property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDataCells().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DATCell }
	 * 
	 * 
	 */
	public List<DATCell> getDataCells() {
		if (dataCells == null) {
			dataCells = new ArrayList<DATCell>();
		}
		return this.dataCells;
	}

	/**
	 * Gets the value of the dependentATRows property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dependentATRows property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDependentATRows().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DATRow }
	 * 
	 * 
	 */
	public List<DATRow> getDependentATRows() {
		if (dependentATRows == null) {
			dependentATRows = new ArrayList<DATRow>();
		}
		return this.dependentATRows;
	}

	/**
	 * Gets the value of the detailRows property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the detailRows property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDetailRows().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DATRow }
	 * 
	 * 
	 */
	public List<DATRow> getDetailRows() {
		if (detailRows == null) {
			detailRows = new ArrayList<DATRow>();
		}
		return this.detailRows;
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

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the purgeStatus property.
	 * 
	 */
	public boolean isPurgeStatus() {
		return purgeStatus;
	}

	/**
	 * Sets the value of the purgeStatus property.
	 * 
	 */
	public void setPurgeStatus(boolean value) {
		this.purgeStatus = value;
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
