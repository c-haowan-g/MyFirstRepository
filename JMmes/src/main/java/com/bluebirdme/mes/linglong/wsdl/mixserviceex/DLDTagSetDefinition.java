package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLDTagSetDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLDTagSetDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tagDefinitions" type="{dataobjects.common.plantops.datasweep.com}DLDTagDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tagSets" type="{dataobjects.common.plantops.datasweep.com}DLDTagSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLDTagSetDefinition", propOrder = { "deletePrivilegeKey",
		"tagDefinitions", "tagSets", "updatePrivilegeKey" })
public class DLDTagSetDefinition extends DCategorical {

	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DLDTagDefinition> tagDefinitions;
	@XmlElement(nillable = true)
	protected List<DLDTagSet> tagSets;
	protected long updatePrivilegeKey;

	/**
	 * Gets the value of the deletePrivilegeKey property.
	 * 
	 */
	public long getDeletePrivilegeKey() {
		return deletePrivilegeKey;
	}

	/**
	 * Sets the value of the deletePrivilegeKey property.
	 * 
	 */
	public void setDeletePrivilegeKey(long value) {
		this.deletePrivilegeKey = value;
	}

	/**
	 * Gets the value of the tagDefinitions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the tagDefinitions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTagDefinitions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DLDTagDefinition }
	 * 
	 * 
	 */
	public List<DLDTagDefinition> getTagDefinitions() {
		if (tagDefinitions == null) {
			tagDefinitions = new ArrayList<DLDTagDefinition>();
		}
		return this.tagDefinitions;
	}

	/**
	 * Gets the value of the tagSets property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the tagSets property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTagSets().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DLDTagSet }
	 * 
	 * 
	 */
	public List<DLDTagSet> getTagSets() {
		if (tagSets == null) {
			tagSets = new ArrayList<DLDTagSet>();
		}
		return this.tagSets;
	}

	/**
	 * Gets the value of the updatePrivilegeKey property.
	 * 
	 */
	public long getUpdatePrivilegeKey() {
		return updatePrivilegeKey;
	}

	/**
	 * Sets the value of the updatePrivilegeKey property.
	 * 
	 */
	public void setUpdatePrivilegeKey(long value) {
		this.updatePrivilegeKey = value;
	}

}
