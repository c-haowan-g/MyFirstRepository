package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractConsumptionPlan complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractConsumptionPlan">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="bomItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lowerAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="referenceDesignators" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceDesignatorsKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="routeStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="upperAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="userDefinedAttributes" type="{dataobjects.common.plantops.datasweep.com}DUDAInstance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAbstractConsumptionPlan", propOrder = { "bomItemKey",
		"bomKey", "lowerAmount", "referenceDesignators",
		"referenceDesignatorsKey", "routeStepKey", "targetAmount",
		"unitOfMeasure", "upperAmount", "userDefinedAttributes" })
public class DAbstractConsumptionPlan extends DKeyed {

	protected long bomItemKey;
	protected long bomKey;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal lowerAmount;
	protected String referenceDesignators;
	protected long referenceDesignatorsKey;
	protected long routeStepKey;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal targetAmount;
	protected String unitOfMeasure;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal upperAmount;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the bomItemKey property.
	 * 
	 */
	public long getBomItemKey() {
		return bomItemKey;
	}

	/**
	 * Sets the value of the bomItemKey property.
	 * 
	 */
	public void setBomItemKey(long value) {
		this.bomItemKey = value;
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
	 * Gets the value of the lowerAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getLowerAmount() {
		return lowerAmount;
	}

	/**
	 * Sets the value of the lowerAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setLowerAmount(BigDecimal value) {
		this.lowerAmount = value;
	}

	/**
	 * Gets the value of the referenceDesignators property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceDesignators() {
		return referenceDesignators;
	}

	/**
	 * Sets the value of the referenceDesignators property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReferenceDesignators(String value) {
		this.referenceDesignators = value;
	}

	/**
	 * Gets the value of the referenceDesignatorsKey property.
	 * 
	 */
	public long getReferenceDesignatorsKey() {
		return referenceDesignatorsKey;
	}

	/**
	 * Sets the value of the referenceDesignatorsKey property.
	 * 
	 */
	public void setReferenceDesignatorsKey(long value) {
		this.referenceDesignatorsKey = value;
	}

	/**
	 * Gets the value of the routeStepKey property.
	 * 
	 */
	public long getRouteStepKey() {
		return routeStepKey;
	}

	/**
	 * Sets the value of the routeStepKey property.
	 * 
	 */
	public void setRouteStepKey(long value) {
		this.routeStepKey = value;
	}

	/**
	 * Gets the value of the targetAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	/**
	 * Sets the value of the targetAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTargetAmount(BigDecimal value) {
		this.targetAmount = value;
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
	 * Gets the value of the upperAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getUpperAmount() {
		return upperAmount;
	}

	/**
	 * Sets the value of the upperAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setUpperAmount(BigDecimal value) {
		this.upperAmount = value;
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

}
