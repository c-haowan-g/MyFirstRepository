package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DUoMConversion complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DUoMConversion">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="factor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="scale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourceDUnitOfMeasure" type="{dataobjects.common.plantops.datasweep.com}DUnitOfMeasure" minOccurs="0"/>
 *         &lt;element name="targetDUnitOfMeasure" type="{dataobjects.common.plantops.datasweep.com}DUnitOfMeasure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DUoMConversion", propOrder = { "factor", "offset", "scale",
		"sourceDUnitOfMeasure", "targetDUnitOfMeasure" })
public class DUoMConversion extends DCategorical {

	@XmlElement(required = true, nillable = true)
	protected BigDecimal factor;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal offset;
	protected int scale;
	protected DUnitOfMeasure sourceDUnitOfMeasure;
	protected DUnitOfMeasure targetDUnitOfMeasure;

	/**
	 * Gets the value of the factor property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getFactor() {
		return factor;
	}

	/**
	 * Sets the value of the factor property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setFactor(BigDecimal value) {
		this.factor = value;
	}

	/**
	 * Gets the value of the offset property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getOffset() {
		return offset;
	}

	/**
	 * Sets the value of the offset property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setOffset(BigDecimal value) {
		this.offset = value;
	}

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
	 * Gets the value of the sourceDUnitOfMeasure property.
	 * 
	 * @return possible object is {@link DUnitOfMeasure }
	 * 
	 */
	public DUnitOfMeasure getSourceDUnitOfMeasure() {
		return sourceDUnitOfMeasure;
	}

	/**
	 * Sets the value of the sourceDUnitOfMeasure property.
	 * 
	 * @param value
	 *            allowed object is {@link DUnitOfMeasure }
	 * 
	 */
	public void setSourceDUnitOfMeasure(DUnitOfMeasure value) {
		this.sourceDUnitOfMeasure = value;
	}

	/**
	 * Gets the value of the targetDUnitOfMeasure property.
	 * 
	 * @return possible object is {@link DUnitOfMeasure }
	 * 
	 */
	public DUnitOfMeasure getTargetDUnitOfMeasure() {
		return targetDUnitOfMeasure;
	}

	/**
	 * Sets the value of the targetDUnitOfMeasure property.
	 * 
	 * @param value
	 *            allowed object is {@link DUnitOfMeasure }
	 * 
	 */
	public void setTargetDUnitOfMeasure(DUnitOfMeasure value) {
		this.targetDUnitOfMeasure = value;
	}

}
