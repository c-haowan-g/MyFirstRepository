package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPart complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPart">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="alternatePartGroups" type="{dataobjects.common.plantops.datasweep.com}DAlternatePartGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alternateParts" type="{dataobjects.common.plantops.datasweep.com}DAlternatePart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="billAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bomRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bomTrackedMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="buildAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="carrierClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="consumptionDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumptionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentStates" type="{dataobjects.common.plantops.datasweep.com}DObjectState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="effectivityEnd" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStart" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logicallyEmptyQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="mixingType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="replacementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revived" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shelfLife" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipAccountKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="standardCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="storageClassEnforced" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="storageUnitClassKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePrivilegeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userAccountKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *         &lt;element name="warrantyPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="workInstructionKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workInstructionKeysChanged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="workInstructionListKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPart", propOrder = { "alternatePartGroups", "alternateParts",
		"billAccountKey", "bomKey", "bomName", "bomRevision", "bomTrackedMode",
		"buildAccountKey", "carrierClassKey", "consumptionDuration",
		"consumptionType", "currentStates", "deletePrivilegeKey",
		"effectivityEnd", "effectivityStart", "extendedRevision",
		"logicallyEmptyQuantity", "mixingType", "partNumber", "partRevision",
		"quantity", "replacementType", "revision", "revived", "shelfLife",
		"shipAccountKey", "standardCost", "storageClassEnforced",
		"storageUnitClassKey", "unitOfMeasure", "updatePrivilegeKey",
		"userAccountKeys", "userDefinedAttributes", "warrantyPeriod",
		"workInstructionKeys", "workInstructionKeysChanged",
		"workInstructionListKey" })
public class DPart extends DCategorical {

	@XmlElement(nillable = true)
	protected List<DAlternatePartGroup> alternatePartGroups;
	@XmlElement(nillable = true)
	protected List<DAlternatePart> alternateParts;
	protected long billAccountKey;
	protected long bomKey;
	protected String bomName;
	protected String bomRevision;
	protected int bomTrackedMode;
	protected long buildAccountKey;
	protected long carrierClassKey;
	protected int consumptionDuration;
	protected String consumptionType;
	@XmlElement(nillable = true)
	protected List<DObjectState> currentStates;
	protected long deletePrivilegeKey;
	protected DTimestamp effectivityEnd;
	protected DTimestamp effectivityStart;
	protected String extendedRevision;
	protected DMeasuredValue logicallyEmptyQuantity;
	protected short mixingType;
	protected String partNumber;
	protected String partRevision;
	protected int quantity;
	protected String replacementType;
	protected String revision;
	protected boolean revived;
	protected int shelfLife;
	protected long shipAccountKey;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal standardCost;
	protected boolean storageClassEnforced;
	protected long storageUnitClassKey;
	protected String unitOfMeasure;
	protected long updatePrivilegeKey;
	@XmlElement(type = Long.class)
	protected List<Long> userAccountKeys;
	protected DUDAInstance userDefinedAttributes;
	protected int warrantyPeriod;
	@XmlElement(type = Long.class)
	protected List<Long> workInstructionKeys;
	protected boolean workInstructionKeysChanged;
	protected long workInstructionListKey;

	/**
	 * Gets the value of the alternatePartGroups property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the alternatePartGroups property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAlternatePartGroups().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAlternatePartGroup }
	 * 
	 * 
	 */
	public List<DAlternatePartGroup> getAlternatePartGroups() {
		if (alternatePartGroups == null) {
			alternatePartGroups = new ArrayList<DAlternatePartGroup>();
		}
		return this.alternatePartGroups;
	}

	/**
	 * Gets the value of the alternateParts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the alternateParts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAlternateParts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DAlternatePart }
	 * 
	 * 
	 */
	public List<DAlternatePart> getAlternateParts() {
		if (alternateParts == null) {
			alternateParts = new ArrayList<DAlternatePart>();
		}
		return this.alternateParts;
	}

	/**
	 * Gets the value of the billAccountKey property.
	 * 
	 */
	public long getBillAccountKey() {
		return billAccountKey;
	}

	/**
	 * Sets the value of the billAccountKey property.
	 * 
	 */
	public void setBillAccountKey(long value) {
		this.billAccountKey = value;
	}

	/**
	 * Gets the value of the bomKey property.
	 * 
	 */
	public long getBomKey() {
		return bomKey;
	}

	/**
	 * Sets the value of the bomKey property.
	 * 
	 */
	public void setBomKey(long value) {
		this.bomKey = value;
	}

	/**
	 * Gets the value of the bomName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the value of the bomName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBomName(String value) {
		this.bomName = value;
	}

	/**
	 * Gets the value of the bomRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBomRevision() {
		return bomRevision;
	}

	/**
	 * Sets the value of the bomRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBomRevision(String value) {
		this.bomRevision = value;
	}

	/**
	 * Gets the value of the bomTrackedMode property.
	 * 
	 */
	public int getBomTrackedMode() {
		return bomTrackedMode;
	}

	/**
	 * Sets the value of the bomTrackedMode property.
	 * 
	 */
	public void setBomTrackedMode(int value) {
		this.bomTrackedMode = value;
	}

	/**
	 * Gets the value of the buildAccountKey property.
	 * 
	 */
	public long getBuildAccountKey() {
		return buildAccountKey;
	}

	/**
	 * Sets the value of the buildAccountKey property.
	 * 
	 */
	public void setBuildAccountKey(long value) {
		this.buildAccountKey = value;
	}

	/**
	 * Gets the value of the carrierClassKey property.
	 * 
	 */
	public long getCarrierClassKey() {
		return carrierClassKey;
	}

	/**
	 * Sets the value of the carrierClassKey property.
	 * 
	 */
	public void setCarrierClassKey(long value) {
		this.carrierClassKey = value;
	}

	/**
	 * Gets the value of the consumptionDuration property.
	 * 
	 */
	public int getConsumptionDuration() {
		return consumptionDuration;
	}

	/**
	 * Sets the value of the consumptionDuration property.
	 * 
	 */
	public void setConsumptionDuration(int value) {
		this.consumptionDuration = value;
	}

	/**
	 * Gets the value of the consumptionType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConsumptionType() {
		return consumptionType;
	}

	/**
	 * Sets the value of the consumptionType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConsumptionType(String value) {
		this.consumptionType = value;
	}

	/**
	 * Gets the value of the currentStates property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the currentStates property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCurrentStates().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DObjectState }
	 * 
	 * 
	 */
	public List<DObjectState> getCurrentStates() {
		if (currentStates == null) {
			currentStates = new ArrayList<DObjectState>();
		}
		return this.currentStates;
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
	 * Gets the value of the effectivityEnd property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityEnd() {
		return effectivityEnd;
	}

	/**
	 * Sets the value of the effectivityEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityEnd(DTimestamp value) {
		this.effectivityEnd = value;
	}

	/**
	 * Gets the value of the effectivityStart property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityStart() {
		return effectivityStart;
	}

	/**
	 * Sets the value of the effectivityStart property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityStart(DTimestamp value) {
		this.effectivityStart = value;
	}

	/**
	 * Gets the value of the extendedRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtendedRevision() {
		return extendedRevision;
	}

	/**
	 * Sets the value of the extendedRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtendedRevision(String value) {
		this.extendedRevision = value;
	}

	/**
	 * Gets the value of the logicallyEmptyQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getLogicallyEmptyQuantity() {
		return logicallyEmptyQuantity;
	}

	/**
	 * Sets the value of the logicallyEmptyQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setLogicallyEmptyQuantity(DMeasuredValue value) {
		this.logicallyEmptyQuantity = value;
	}

	/**
	 * Gets the value of the mixingType property.
	 * 
	 */
	public short getMixingType() {
		return mixingType;
	}

	/**
	 * Sets the value of the mixingType property.
	 * 
	 */
	public void setMixingType(short value) {
		this.mixingType = value;
	}

	/**
	 * Gets the value of the partNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * Sets the value of the partNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartNumber(String value) {
		this.partNumber = value;
	}

	/**
	 * Gets the value of the partRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPartRevision() {
		return partRevision;
	}

	/**
	 * Sets the value of the partRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPartRevision(String value) {
		this.partRevision = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the replacementType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReplacementType() {
		return replacementType;
	}

	/**
	 * Sets the value of the replacementType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReplacementType(String value) {
		this.replacementType = value;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevision(String value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the revived property.
	 * 
	 */
	public boolean isRevived() {
		return revived;
	}

	/**
	 * Sets the value of the revived property.
	 * 
	 */
	public void setRevived(boolean value) {
		this.revived = value;
	}

	/**
	 * Gets the value of the shelfLife property.
	 * 
	 */
	public int getShelfLife() {
		return shelfLife;
	}

	/**
	 * Sets the value of the shelfLife property.
	 * 
	 */
	public void setShelfLife(int value) {
		this.shelfLife = value;
	}

	/**
	 * Gets the value of the shipAccountKey property.
	 * 
	 */
	public long getShipAccountKey() {
		return shipAccountKey;
	}

	/**
	 * Sets the value of the shipAccountKey property.
	 * 
	 */
	public void setShipAccountKey(long value) {
		this.shipAccountKey = value;
	}

	/**
	 * Gets the value of the standardCost property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getStandardCost() {
		return standardCost;
	}

	/**
	 * Sets the value of the standardCost property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setStandardCost(BigDecimal value) {
		this.standardCost = value;
	}

	/**
	 * Gets the value of the storageClassEnforced property.
	 * 
	 */
	public boolean isStorageClassEnforced() {
		return storageClassEnforced;
	}

	/**
	 * Sets the value of the storageClassEnforced property.
	 * 
	 */
	public void setStorageClassEnforced(boolean value) {
		this.storageClassEnforced = value;
	}

	/**
	 * Gets the value of the storageUnitClassKey property.
	 * 
	 */
	public long getStorageUnitClassKey() {
		return storageUnitClassKey;
	}

	/**
	 * Sets the value of the storageUnitClassKey property.
	 * 
	 */
	public void setStorageUnitClassKey(long value) {
		this.storageUnitClassKey = value;
	}

	/**
	 * Gets the value of the unitOfMeasure property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * Sets the value of the unitOfMeasure property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnitOfMeasure(String value) {
		this.unitOfMeasure = value;
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

	/**
	 * Gets the value of the userAccountKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the userAccountKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getUserAccountKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getUserAccountKeys() {
		if (userAccountKeys == null) {
			userAccountKeys = new ArrayList<Long>();
		}
		return this.userAccountKeys;
	}

	/**
	 * Gets the value of the userDefinedAttributes property.
	 * 
	 * @return possible object is {@link DUDAInstance }
	 * 
	 */
	public DUDAInstance getUserDefinedAttributes() {
		return userDefinedAttributes;
	}

	/**
	 * Sets the value of the userDefinedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DUDAInstance }
	 * 
	 */
	public void setUserDefinedAttributes(DUDAInstance value) {
		this.userDefinedAttributes = value;
	}

	/**
	 * Gets the value of the warrantyPeriod property.
	 * 
	 */
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * Sets the value of the warrantyPeriod property.
	 * 
	 */
	public void setWarrantyPeriod(int value) {
		this.warrantyPeriod = value;
	}

	/**
	 * Gets the value of the workInstructionKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workInstructionKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkInstructionKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getWorkInstructionKeys() {
		if (workInstructionKeys == null) {
			workInstructionKeys = new ArrayList<Long>();
		}
		return this.workInstructionKeys;
	}

	/**
	 * Gets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public boolean isWorkInstructionKeysChanged() {
		return workInstructionKeysChanged;
	}

	/**
	 * Sets the value of the workInstructionKeysChanged property.
	 * 
	 */
	public void setWorkInstructionKeysChanged(boolean value) {
		this.workInstructionKeysChanged = value;
	}

	/**
	 * Gets the value of the workInstructionListKey property.
	 * 
	 */
	public long getWorkInstructionListKey() {
		return workInstructionListKey;
	}

	/**
	 * Sets the value of the workInstructionListKey property.
	 * 
	 */
	public void setWorkInstructionListKey(long value) {
		this.workInstructionListKey = value;
	}

}
