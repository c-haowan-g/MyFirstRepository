package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DPartQuantityOnHand complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DPartQuantityOnHand">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="badQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="containerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerSubType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goodQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DPartQuantityOnHand", propOrder = { "badQuantity",
		"containerName", "containerSubType", "containerType", "goodQuantity",
		"partNumber", "partRevision" })
public class DPartQuantityOnHand extends DDataObject {

	@XmlElement(required = true, nillable = true)
	protected BigDecimal badQuantity;
	protected String containerName;
	protected String containerSubType;
	protected String containerType;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal goodQuantity;
	protected String partNumber;
	protected String partRevision;

	/**
	 * Gets the value of the badQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBadQuantity() {
		return badQuantity;
	}

	/**
	 * Sets the value of the badQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBadQuantity(BigDecimal value) {
		this.badQuantity = value;
	}

	/**
	 * Gets the value of the containerName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * Sets the value of the containerName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerName(String value) {
		this.containerName = value;
	}

	/**
	 * Gets the value of the containerSubType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerSubType() {
		return containerSubType;
	}

	/**
	 * Sets the value of the containerSubType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerSubType(String value) {
		this.containerSubType = value;
	}

	/**
	 * Gets the value of the containerType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getContainerType() {
		return containerType;
	}

	/**
	 * Sets the value of the containerType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setContainerType(String value) {
		this.containerType = value;
	}

	/**
	 * Gets the value of the goodQuantity property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getGoodQuantity() {
		return goodQuantity;
	}

	/**
	 * Sets the value of the goodQuantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setGoodQuantity(BigDecimal value) {
		this.goodQuantity = value;
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

}
