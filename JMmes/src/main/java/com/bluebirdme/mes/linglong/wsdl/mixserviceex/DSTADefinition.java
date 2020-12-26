package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSTADefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSTADefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="FSMKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STADefinitionIndexes" type="{dataobjects.common.plantops.datasweep.com}DSTADefinitionIndex" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="STADefinitionIndexesChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STADefinitionItems" type="{dataobjects.common.plantops.datasweep.com}DSTADefinitionItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="STADefinitionItemsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STAInstanceTableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSTADefinition", propOrder = { "auditInfo", "fsmKey",
		"staDefinitionIndexes", "staDefinitionIndexesChanged",
		"staDefinitionItems", "staDefinitionItemsChanged",
		"staInstanceTableName" })
public class DSTADefinition extends DKeyed {

	protected DAuditInfo auditInfo;
	@XmlElement(name = "FSMKey")
	protected long fsmKey;
	@XmlElement(name = "STADefinitionIndexes", nillable = true)
	protected List<DSTADefinitionIndex> staDefinitionIndexes;
	@XmlElement(name = "STADefinitionIndexesChanged")
	protected boolean staDefinitionIndexesChanged;
	@XmlElement(name = "STADefinitionItems", nillable = true)
	protected List<DSTADefinitionItem> staDefinitionItems;
	@XmlElement(name = "STADefinitionItemsChanged")
	protected boolean staDefinitionItemsChanged;
	@XmlElement(name = "STAInstanceTableName")
	protected String staInstanceTableName;

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
	 * Gets the value of the fsmKey property.
	 * 
	 */
	public long getFSMKey() {
		return fsmKey;
	}

	/**
	 * Sets the value of the fsmKey property.
	 * 
	 */
	public void setFSMKey(long value) {
		this.fsmKey = value;
	}

	/**
	 * Gets the value of the staDefinitionIndexes property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the staDefinitionIndexes property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSTADefinitionIndexes().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSTADefinitionIndex }
	 * 
	 * 
	 */
	public List<DSTADefinitionIndex> getSTADefinitionIndexes() {
		if (staDefinitionIndexes == null) {
			staDefinitionIndexes = new ArrayList<DSTADefinitionIndex>();
		}
		return this.staDefinitionIndexes;
	}

	/**
	 * Gets the value of the staDefinitionIndexesChanged property.
	 * 
	 */
	public boolean isSTADefinitionIndexesChanged() {
		return staDefinitionIndexesChanged;
	}

	/**
	 * Sets the value of the staDefinitionIndexesChanged property.
	 * 
	 */
	public void setSTADefinitionIndexesChanged(boolean value) {
		this.staDefinitionIndexesChanged = value;
	}

	/**
	 * Gets the value of the staDefinitionItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the staDefinitionItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSTADefinitionItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DSTADefinitionItem }
	 * 
	 * 
	 */
	public List<DSTADefinitionItem> getSTADefinitionItems() {
		if (staDefinitionItems == null) {
			staDefinitionItems = new ArrayList<DSTADefinitionItem>();
		}
		return this.staDefinitionItems;
	}

	/**
	 * Gets the value of the staDefinitionItemsChanged property.
	 * 
	 */
	public boolean isSTADefinitionItemsChanged() {
		return staDefinitionItemsChanged;
	}

	/**
	 * Sets the value of the staDefinitionItemsChanged property.
	 * 
	 */
	public void setSTADefinitionItemsChanged(boolean value) {
		this.staDefinitionItemsChanged = value;
	}

	/**
	 * Gets the value of the staInstanceTableName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSTAInstanceTableName() {
		return staInstanceTableName;
	}

	/**
	 * Sets the value of the staInstanceTableName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSTAInstanceTableName(String value) {
		this.staInstanceTableName = value;
	}

}
