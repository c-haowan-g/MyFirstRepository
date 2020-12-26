package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLot">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DTrackable">
 *       &lt;sequence>
 *         &lt;element name="containerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="containerType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="extendedAttributes" type="{dataobjects.common.plantops.datasweep.com}DLotExtended" minOccurs="0"/>
 *         &lt;element name="orderItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outputLotParentLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="outputLotSourceLotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="outputLotTBomItemKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="partNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityClosed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityConsumed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityDestructiveSampled" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityFinished" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityScrapped" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityScrappedConsumed" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantitySerialized" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantityShipped" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TBomKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLot", propOrder = { "containerName", "containerType",
		"extendedAttributes", "orderItem", "orderNumber",
		"outputLotParentLotKey", "outputLotSourceLotKey",
		"outputLotTBomItemKey", "partNumber", "partRevision", "quantity",
		"quantityClosed", "quantityConsumed", "quantityDestructiveSampled",
		"quantityFinished", "quantityScrapped", "quantityScrappedConsumed",
		"quantitySerialized", "quantityShipped", "tBomKey", "type" })
public class DLot extends DTrackable {

	protected String containerName;
	protected short containerType;
	protected DLotExtended extendedAttributes;
	protected String orderItem;
	protected String orderNumber;
	protected long outputLotParentLotKey;
	protected long outputLotSourceLotKey;
	protected long outputLotTBomItemKey;
	protected String partNumber;
	protected String partRevision;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantity;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityClosed;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityConsumed;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityDestructiveSampled;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityFinished;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityScrapped;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityScrappedConsumed;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantitySerialized;
	@XmlElement(required = true, nillable = true)
	protected BigDecimal quantityShipped;
	@XmlElement(name = "TBomKey")
	protected long tBomKey;
	protected short type;

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
	 * Gets the value of the containerType property.
	 * 
	 */
	public short getContainerType() {
		return containerType;
	}

	/**
	 * Sets the value of the containerType property.
	 * 
	 */
	public void setContainerType(short value) {
		this.containerType = value;
	}

	/**
	 * Gets the value of the extendedAttributes property.
	 * 
	 * @return possible object is {@link DLotExtended }
	 * 
	 */
	public DLotExtended getExtendedAttributes() {
		return extendedAttributes;
	}

	/**
	 * Sets the value of the extendedAttributes property.
	 * 
	 * @param value
	 *            allowed object is {@link DLotExtended }
	 * 
	 */
	public void setExtendedAttributes(DLotExtended value) {
		this.extendedAttributes = value;
	}

	/**
	 * Gets the value of the orderItem property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderItem() {
		return orderItem;
	}

	/**
	 * Sets the value of the orderItem property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderItem(String value) {
		this.orderItem = value;
	}

	/**
	 * Gets the value of the orderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Sets the value of the orderNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrderNumber(String value) {
		this.orderNumber = value;
	}

	/**
	 * Gets the value of the outputLotParentLotKey property.
	 * 
	 */
	public long getOutputLotParentLotKey() {
		return outputLotParentLotKey;
	}

	/**
	 * Sets the value of the outputLotParentLotKey property.
	 * 
	 */
	public void setOutputLotParentLotKey(long value) {
		this.outputLotParentLotKey = value;
	}

	/**
	 * Gets the value of the outputLotSourceLotKey property.
	 * 
	 */
	public long getOutputLotSourceLotKey() {
		return outputLotSourceLotKey;
	}

	/**
	 * Sets the value of the outputLotSourceLotKey property.
	 * 
	 */
	public void setOutputLotSourceLotKey(long value) {
		this.outputLotSourceLotKey = value;
	}

	/**
	 * Gets the value of the outputLotTBomItemKey property.
	 * 
	 */
	public long getOutputLotTBomItemKey() {
		return outputLotTBomItemKey;
	}

	/**
	 * Sets the value of the outputLotTBomItemKey property.
	 * 
	 */
	public void setOutputLotTBomItemKey(long value) {
		this.outputLotTBomItemKey = value;
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
	 * Gets the value of the quantityClosed property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityClosed() {
		return quantityClosed;
	}

	/**
	 * Sets the value of the quantityClosed property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityClosed(BigDecimal value) {
		this.quantityClosed = value;
	}

	/**
	 * Gets the value of the quantityConsumed property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityConsumed() {
		return quantityConsumed;
	}

	/**
	 * Sets the value of the quantityConsumed property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityConsumed(BigDecimal value) {
		this.quantityConsumed = value;
	}

	/**
	 * Gets the value of the quantityDestructiveSampled property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityDestructiveSampled() {
		return quantityDestructiveSampled;
	}

	/**
	 * Sets the value of the quantityDestructiveSampled property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityDestructiveSampled(BigDecimal value) {
		this.quantityDestructiveSampled = value;
	}

	/**
	 * Gets the value of the quantityFinished property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityFinished() {
		return quantityFinished;
	}

	/**
	 * Sets the value of the quantityFinished property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityFinished(BigDecimal value) {
		this.quantityFinished = value;
	}

	/**
	 * Gets the value of the quantityScrapped property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityScrapped() {
		return quantityScrapped;
	}

	/**
	 * Sets the value of the quantityScrapped property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityScrapped(BigDecimal value) {
		this.quantityScrapped = value;
	}

	/**
	 * Gets the value of the quantityScrappedConsumed property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityScrappedConsumed() {
		return quantityScrappedConsumed;
	}

	/**
	 * Sets the value of the quantityScrappedConsumed property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityScrappedConsumed(BigDecimal value) {
		this.quantityScrappedConsumed = value;
	}

	/**
	 * Gets the value of the quantitySerialized property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantitySerialized() {
		return quantitySerialized;
	}

	/**
	 * Sets the value of the quantitySerialized property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantitySerialized(BigDecimal value) {
		this.quantitySerialized = value;
	}

	/**
	 * Gets the value of the quantityShipped property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getQuantityShipped() {
		return quantityShipped;
	}

	/**
	 * Sets the value of the quantityShipped property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setQuantityShipped(BigDecimal value) {
		this.quantityShipped = value;
	}

	/**
	 * Gets the value of the tBomKey property.
	 * 
	 */
	public long getTBomKey() {
		return tBomKey;
	}

	/**
	 * Sets the value of the tBomKey property.
	 * 
	 */
	public void setTBomKey(long value) {
		this.tBomKey = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
	}

}
