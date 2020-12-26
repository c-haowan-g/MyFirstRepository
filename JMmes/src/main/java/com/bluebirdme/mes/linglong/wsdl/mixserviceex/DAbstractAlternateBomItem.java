package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAbstractAlternateBomItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAbstractAlternateBomItem">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="bomItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxReplacementPercent" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ratio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
@XmlType(name = "DAbstractAlternateBomItem", propOrder = { "bomItemKey",
		"bomKey", "maxReplacementPercent", "partNumber", "partRevision",
		"ratio", "userDefinedAttributes" })
public class DAbstractAlternateBomItem extends DKeyed {

	protected long bomItemKey;
	protected long bomKey;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal maxReplacementPercent;
	protected String partNumber;
	protected String partRevision;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal ratio;
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
	 * Gets the value of the maxReplacementPercent property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getMaxReplacementPercent() {
		return maxReplacementPercent;
	}

	/**
	 * Sets the value of the maxReplacementPercent property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setMaxReplacementPercent(BigDecimal value) {
		this.maxReplacementPercent = value;
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
	 * Gets the value of the ratio property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getRatio() {
		return ratio;
	}

	/**
	 * Sets the value of the ratio property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setRatio(BigDecimal value) {
		this.ratio = value;
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
