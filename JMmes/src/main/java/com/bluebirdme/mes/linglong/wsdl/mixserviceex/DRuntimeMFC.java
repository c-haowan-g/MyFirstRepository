package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRuntimeMFC complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRuntimeMFC">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DMFC">
 *       &lt;sequence>
 *         &lt;element name="controlRecipeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lowerBoundaryQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="masterRecipeMFCName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *         &lt;element name="replacementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperBoundaryQuantity" type="{dataobjects.common.plantops.datasweep.com}DMeasuredValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRuntimeMFC", propOrder = { "controlRecipeKey",
		"lowerBoundaryQuantity", "masterRecipeMFCName", "quantity",
		"replacementType", "upperBoundaryQuantity" })
public class DRuntimeMFC extends DMFC {

	protected long controlRecipeKey;
	protected DMeasuredValue lowerBoundaryQuantity;
	protected String masterRecipeMFCName;
	protected DMeasuredValue quantity;
	protected String replacementType;
	protected DMeasuredValue upperBoundaryQuantity;

	/**
	 * Gets the value of the controlRecipeKey property.
	 * 
	 */
	public long getControlRecipeKey() {
		return controlRecipeKey;
	}

	/**
	 * Sets the value of the controlRecipeKey property.
	 * 
	 */
	public void setControlRecipeKey(long value) {
		this.controlRecipeKey = value;
	}

	/**
	 * Gets the value of the lowerBoundaryQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getLowerBoundaryQuantity() {
		return lowerBoundaryQuantity;
	}

	/**
	 * Sets the value of the lowerBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setLowerBoundaryQuantity(DMeasuredValue value) {
		this.lowerBoundaryQuantity = value;
	}

	/**
	 * Gets the value of the masterRecipeMFCName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMasterRecipeMFCName() {
		return masterRecipeMFCName;
	}

	/**
	 * Sets the value of the masterRecipeMFCName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMasterRecipeMFCName(String value) {
		this.masterRecipeMFCName = value;
	}

	/**
	 * Gets the value of the quantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setQuantity(DMeasuredValue value) {
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
	 * Gets the value of the upperBoundaryQuantity property.
	 * 
	 * @return possible object is {@link DMeasuredValue }
	 * 
	 */
	public DMeasuredValue getUpperBoundaryQuantity() {
		return upperBoundaryQuantity;
	}

	/**
	 * Sets the value of the upperBoundaryQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link DMeasuredValue }
	 * 
	 */
	public void setUpperBoundaryQuantity(DMeasuredValue value) {
		this.upperBoundaryQuantity = value;
	}

}
