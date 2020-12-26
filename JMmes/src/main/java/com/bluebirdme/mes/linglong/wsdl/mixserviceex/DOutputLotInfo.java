package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DOutputLotInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DOutputLotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="bomItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="carrierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="routeStepKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOutputLotInfo", propOrder = { "bomItemKey", "carrierName",
		"lotName", "partNumber", "partRevision", "quantity", "routeStepKey" })
public class DOutputLotInfo extends DDataObject {

	protected long bomItemKey;
	protected String carrierName;
	protected String lotName;
	protected String partNumber;
	protected String partRevision;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantity;
	protected long routeStepKey;

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
	 * Gets the value of the carrierName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCarrierName() {
		return carrierName;
	}

	/**
	 * Sets the value of the carrierName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCarrierName(String value) {
		this.carrierName = value;
	}

	/**
	 * Gets the value of the lotName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLotName() {
		return lotName;
	}

	/**
	 * Sets the value of the lotName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLotName(String value) {
		this.lotName = value;
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
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantity(BigDecimal value) {
		this.quantity = value;
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

}
