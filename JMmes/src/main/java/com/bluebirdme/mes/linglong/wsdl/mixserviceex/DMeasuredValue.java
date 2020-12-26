package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DMeasuredValue complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DMeasuredValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMeasuredValue", propOrder = { "scale", "unitOfMeasure",
		"value" })
public class DMeasuredValue {

	protected int scale;
	protected String unitOfMeasure;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal value;

	/**
	 * Gets the value of the scale property.
	 * 
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * Sets the value of the scale property.
	 * 
	 */
	public void setScale(int value) {
		this.scale = value;
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
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
