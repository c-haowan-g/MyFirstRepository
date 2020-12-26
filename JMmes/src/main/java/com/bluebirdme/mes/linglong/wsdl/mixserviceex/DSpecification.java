package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSpecification complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSpecification">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="lowerBoundary" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="lowerControlLimit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="lowerSpecLimit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="upperBoundary" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="upperControlLimit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="upperSpecLimit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSpecification", propOrder = { "lowerBoundary",
		"lowerControlLimit", "lowerSpecLimit", "upperBoundary",
		"upperControlLimit", "upperSpecLimit" })
public class DSpecification extends DKeyed {

	@XmlElement(required = true, nillable = true)
	protected BigDecimal lowerBoundary;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal lowerControlLimit;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal lowerSpecLimit;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal upperBoundary;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal upperControlLimit;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal upperSpecLimit;

	/**
	 * Gets the value of the lowerBoundary property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getLowerBoundary() {
		return lowerBoundary;
	}

	/**
	 * Sets the value of the lowerBoundary property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setLowerBoundary(BigDecimal value) {
		this.lowerBoundary = value;
	}

	/**
	 * Gets the value of the lowerControlLimit property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getLowerControlLimit() {
		return lowerControlLimit;
	}

	/**
	 * Sets the value of the lowerControlLimit property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setLowerControlLimit(BigDecimal value) {
		this.lowerControlLimit = value;
	}

	/**
	 * Gets the value of the lowerSpecLimit property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getLowerSpecLimit() {
		return lowerSpecLimit;
	}

	/**
	 * Sets the value of the lowerSpecLimit property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setLowerSpecLimit(BigDecimal value) {
		this.lowerSpecLimit = value;
	}

	/**
	 * Gets the value of the upperBoundary property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getUpperBoundary() {
		return upperBoundary;
	}

	/**
	 * Sets the value of the upperBoundary property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setUpperBoundary(BigDecimal value) {
		this.upperBoundary = value;
	}

	/**
	 * Gets the value of the upperControlLimit property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getUpperControlLimit() {
		return upperControlLimit;
	}

	/**
	 * Sets the value of the upperControlLimit property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setUpperControlLimit(BigDecimal value) {
		this.upperControlLimit = value;
	}

	/**
	 * Gets the value of the upperSpecLimit property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getUpperSpecLimit() {
		return upperSpecLimit;
	}

	/**
	 * Sets the value of the upperSpecLimit property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setUpperSpecLimit(BigDecimal value) {
		this.upperSpecLimit = value;
	}

}
