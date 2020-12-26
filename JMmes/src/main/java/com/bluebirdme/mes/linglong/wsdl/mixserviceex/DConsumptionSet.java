package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConsumptionSet complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConsumptionSet">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="bomItems" type="{dataobjects.common.plantops.datasweep.com}DRuntimeBomItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="compatible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="overrideEffectivityEnforcement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="overrideMaxReplacementPercentEnforcement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="overrideReplacementType" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConsumptionSet", propOrder = { "bomItems", "compatible",
		"overrideEffectivityEnforcement",
		"overrideMaxReplacementPercentEnforcement", "overrideReplacementType" })
public class DConsumptionSet extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DRuntimeBomItem> bomItems;
	protected boolean compatible;
	protected boolean overrideEffectivityEnforcement;
	protected boolean overrideMaxReplacementPercentEnforcement;
	protected boolean overrideReplacementType;

	/**
	 * Gets the value of the bomItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bomItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBomItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRuntimeBomItem }
	 * 
	 * 
	 */
	public List<DRuntimeBomItem> getBomItems() {
		if (bomItems == null) {
			bomItems = new ArrayList<DRuntimeBomItem>();
		}
		return this.bomItems;
	}

	/**
	 * Gets the value of the compatible property.
	 * 
	 */
	public boolean isCompatible() {
		return compatible;
	}

	/**
	 * Sets the value of the compatible property.
	 * 
	 */
	public void setCompatible(boolean value) {
		this.compatible = value;
	}

	/**
	 * Gets the value of the overrideEffectivityEnforcement property.
	 * 
	 */
	public boolean isOverrideEffectivityEnforcement() {
		return overrideEffectivityEnforcement;
	}

	/**
	 * Sets the value of the overrideEffectivityEnforcement property.
	 * 
	 */
	public void setOverrideEffectivityEnforcement(boolean value) {
		this.overrideEffectivityEnforcement = value;
	}

	/**
	 * Gets the value of the overrideMaxReplacementPercentEnforcement property.
	 * 
	 */
	public boolean isOverrideMaxReplacementPercentEnforcement() {
		return overrideMaxReplacementPercentEnforcement;
	}

	/**
	 * Sets the value of the overrideMaxReplacementPercentEnforcement property.
	 * 
	 */
	public void setOverrideMaxReplacementPercentEnforcement(boolean value) {
		this.overrideMaxReplacementPercentEnforcement = value;
	}

	/**
	 * Gets the value of the overrideReplacementType property.
	 * 
	 */
	public boolean isOverrideReplacementType() {
		return overrideReplacementType;
	}

	/**
	 * Sets the value of the overrideReplacementType property.
	 * 
	 */
	public void setOverrideReplacementType(boolean value) {
		this.overrideReplacementType = value;
	}

}
