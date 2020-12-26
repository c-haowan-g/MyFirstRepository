package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DATDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DATDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="accessControlInfo" type="{dataobjects.common.plantops.datasweep.com}DAccessControlInfo" minOccurs="0"/>
 *         &lt;element name="atColumnDefinitions" type="{dataobjects.common.plantops.datasweep.com}DATColumnDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="atColumnDefinitionsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="atIndexDefinitions" type="{dataobjects.common.plantops.datasweep.com}DATIndexDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="atIndexDefinitionsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="atVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autoNameCreation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dataManagementType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dependentATDefinitions" type="{dataobjects.common.plantops.datasweep.com}DATDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dependentATDefinitionsChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="growthType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="loggingLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="productColumnPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="staticData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supportStateProxy" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DATDefinition", propOrder = { "accessControlInfo",
		"atColumnDefinitions", "atColumnDefinitionsChanged",
		"atIndexDefinitions", "atIndexDefinitionsChanged", "atVersion",
		"author", "autoNameCreation", "dataManagementType",
		"deletePrivilegeKey", "dependentATDefinitions",
		"dependentATDefinitionsChanged", "growthType", "loggingLevel",
		"parentKey", "productColumnPrefix", "staticData", "supportStateProxy",
		"type", "updatePrivilegeKey" })
public class DATDefinition extends DCategorical {

	protected DAccessControlInfo accessControlInfo;
	@XmlElement(nillable = true)
	protected List<DATColumnDefinition> atColumnDefinitions;
	protected boolean atColumnDefinitionsChanged;
	@XmlElement(nillable = true)
	protected List<DATIndexDefinition> atIndexDefinitions;
	protected boolean atIndexDefinitionsChanged;
	protected int atVersion;
	protected String author;
	protected boolean autoNameCreation;
	protected short dataManagementType;
	protected long deletePrivilegeKey;
	@XmlElement(nillable = true)
	protected List<DATDefinition> dependentATDefinitions;
	protected boolean dependentATDefinitionsChanged;
	protected short growthType;
	protected short loggingLevel;
	protected long parentKey;
	protected String productColumnPrefix;
	protected boolean staticData;
	protected boolean supportStateProxy;
	protected short type;
	protected long updatePrivilegeKey;

	/**
	 * Gets the value of the accessControlInfo property.
	 * 
	 * @return possible object is {@link DAccessControlInfo }
	 * 
	 */
	public DAccessControlInfo getAccessControlInfo() {
		return accessControlInfo;
	}

	/**
	 * Sets the value of the accessControlInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAccessControlInfo }
	 * 
	 */
	public void setAccessControlInfo(DAccessControlInfo value) {
		this.accessControlInfo = value;
	}

	/**
	 * Gets the value of the atColumnDefinitions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the atColumnDefinitions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAtColumnDefinitions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DATColumnDefinition }
	 * 
	 * 
	 */
	public List<DATColumnDefinition> getAtColumnDefinitions() {
		if (atColumnDefinitions == null) {
			atColumnDefinitions = new ArrayList<DATColumnDefinition>();
		}
		return this.atColumnDefinitions;
	}

	/**
	 * Gets the value of the atColumnDefinitionsChanged property.
	 * 
	 */
	public boolean isAtColumnDefinitionsChanged() {
		return atColumnDefinitionsChanged;
	}

	/**
	 * Sets the value of the atColumnDefinitionsChanged property.
	 * 
	 */
	public void setAtColumnDefinitionsChanged(boolean value) {
		this.atColumnDefinitionsChanged = value;
	}

	/**
	 * Gets the value of the atIndexDefinitions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the atIndexDefinitions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAtIndexDefinitions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DATIndexDefinition }
	 * 
	 * 
	 */
	public List<DATIndexDefinition> getAtIndexDefinitions() {
		if (atIndexDefinitions == null) {
			atIndexDefinitions = new ArrayList<DATIndexDefinition>();
		}
		return this.atIndexDefinitions;
	}

	/**
	 * Gets the value of the atIndexDefinitionsChanged property.
	 * 
	 */
	public boolean isAtIndexDefinitionsChanged() {
		return atIndexDefinitionsChanged;
	}

	/**
	 * Sets the value of the atIndexDefinitionsChanged property.
	 * 
	 */
	public void setAtIndexDefinitionsChanged(boolean value) {
		this.atIndexDefinitionsChanged = value;
	}

	/**
	 * Gets the value of the atVersion property.
	 * 
	 */
	public int getAtVersion() {
		return atVersion;
	}

	/**
	 * Sets the value of the atVersion property.
	 * 
	 */
	public void setAtVersion(int value) {
		this.atVersion = value;
	}

	/**
	 * Gets the value of the author property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the value of the author property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAuthor(String value) {
		this.author = value;
	}

	/**
	 * Gets the value of the autoNameCreation property.
	 * 
	 */
	public boolean isAutoNameCreation() {
		return autoNameCreation;
	}

	/**
	 * Sets the value of the autoNameCreation property.
	 * 
	 */
	public void setAutoNameCreation(boolean value) {
		this.autoNameCreation = value;
	}

	/**
	 * Gets the value of the dataManagementType property.
	 * 
	 */
	public short getDataManagementType() {
		return dataManagementType;
	}

	/**
	 * Sets the value of the dataManagementType property.
	 * 
	 */
	public void setDataManagementType(short value) {
		this.dataManagementType = value;
	}

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
	 * Gets the value of the dependentATDefinitions property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dependentATDefinitions property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDependentATDefinitions().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DATDefinition }
	 * 
	 * 
	 */
	public List<DATDefinition> getDependentATDefinitions() {
		if (dependentATDefinitions == null) {
			dependentATDefinitions = new ArrayList<DATDefinition>();
		}
		return this.dependentATDefinitions;
	}

	/**
	 * Gets the value of the dependentATDefinitionsChanged property.
	 * 
	 */
	public boolean isDependentATDefinitionsChanged() {
		return dependentATDefinitionsChanged;
	}

	/**
	 * Sets the value of the dependentATDefinitionsChanged property.
	 * 
	 */
	public void setDependentATDefinitionsChanged(boolean value) {
		this.dependentATDefinitionsChanged = value;
	}

	/**
	 * Gets the value of the growthType property.
	 * 
	 */
	public short getGrowthType() {
		return growthType;
	}

	/**
	 * Sets the value of the growthType property.
	 * 
	 */
	public void setGrowthType(short value) {
		this.growthType = value;
	}

	/**
	 * Gets the value of the loggingLevel property.
	 * 
	 */
	public short getLoggingLevel() {
		return loggingLevel;
	}

	/**
	 * Sets the value of the loggingLevel property.
	 * 
	 */
	public void setLoggingLevel(short value) {
		this.loggingLevel = value;
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
	 * Gets the value of the productColumnPrefix property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductColumnPrefix() {
		return productColumnPrefix;
	}

	/**
	 * Sets the value of the productColumnPrefix property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductColumnPrefix(String value) {
		this.productColumnPrefix = value;
	}

	/**
	 * Gets the value of the staticData property.
	 * 
	 */
	public boolean isStaticData() {
		return staticData;
	}

	/**
	 * Sets the value of the staticData property.
	 * 
	 */
	public void setStaticData(boolean value) {
		this.staticData = value;
	}

	/**
	 * Gets the value of the supportStateProxy property.
	 * 
	 */
	public boolean isSupportStateProxy() {
		return supportStateProxy;
	}

	/**
	 * Sets the value of the supportStateProxy property.
	 * 
	 */
	public void setSupportStateProxy(boolean value) {
		this.supportStateProxy = value;
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
