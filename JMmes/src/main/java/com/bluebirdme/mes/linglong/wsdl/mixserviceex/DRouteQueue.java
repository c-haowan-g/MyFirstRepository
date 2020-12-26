package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DRouteQueue complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DRouteQueue">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="autoStart" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultProductionQueueKeysForProductionLines" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="estDurationToCompletion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pixelX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pixelY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productionLineKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productionQueueAssigned" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="productionQueueKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="queueCapacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="queueDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="routeKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "DRouteQueue", propOrder = { "autoStart",
		"defaultProductionQueueKeysForProductionLines",
		"estDurationToCompletion", "pixelX", "pixelY", "productionLineKeys",
		"productionQueueAssigned", "productionQueueKeys", "queueCapacity",
		"queueDuration", "routeKey", "type", "userDefinedAttributes" })
public class DRouteQueue extends DKeyed {

	protected boolean autoStart;
	@XmlElement(type = Long.class)
	protected List<Long> defaultProductionQueueKeysForProductionLines;
	protected int estDurationToCompletion;
	protected int pixelX;
	protected int pixelY;
	@XmlElement(type = Long.class)
	protected List<Long> productionLineKeys;
	protected boolean productionQueueAssigned;
	@XmlElement(type = Long.class)
	protected List<Long> productionQueueKeys;
	protected int queueCapacity;
	protected int queueDuration;
	protected long routeKey;
	protected short type;
	protected DUDAInstance userDefinedAttributes;

	/**
	 * Gets the value of the autoStart property.
	 * 
	 */
	public boolean isAutoStart() {
		return autoStart;
	}

	/**
	 * Sets the value of the autoStart property.
	 * 
	 */
	public void setAutoStart(boolean value) {
		this.autoStart = value;
	}

	/**
	 * Gets the value of the defaultProductionQueueKeysForProductionLines
	 * property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the
	 * defaultProductionQueueKeysForProductionLines property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDefaultProductionQueueKeysForProductionLines().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getDefaultProductionQueueKeysForProductionLines() {
		if (defaultProductionQueueKeysForProductionLines == null) {
			defaultProductionQueueKeysForProductionLines = new ArrayList<Long>();
		}
		return this.defaultProductionQueueKeysForProductionLines;
	}

	/**
	 * Gets the value of the estDurationToCompletion property.
	 * 
	 */
	public int getEstDurationToCompletion() {
		return estDurationToCompletion;
	}

	/**
	 * Sets the value of the estDurationToCompletion property.
	 * 
	 */
	public void setEstDurationToCompletion(int value) {
		this.estDurationToCompletion = value;
	}

	/**
	 * Gets the value of the pixelX property.
	 * 
	 */
	public int getPixelX() {
		return pixelX;
	}

	/**
	 * Sets the value of the pixelX property.
	 * 
	 */
	public void setPixelX(int value) {
		this.pixelX = value;
	}

	/**
	 * Gets the value of the pixelY property.
	 * 
	 */
	public int getPixelY() {
		return pixelY;
	}

	/**
	 * Sets the value of the pixelY property.
	 * 
	 */
	public void setPixelY(int value) {
		this.pixelY = value;
	}

	/**
	 * Gets the value of the productionLineKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productionLineKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductionLineKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getProductionLineKeys() {
		if (productionLineKeys == null) {
			productionLineKeys = new ArrayList<Long>();
		}
		return this.productionLineKeys;
	}

	/**
	 * Gets the value of the productionQueueAssigned property.
	 * 
	 */
	public boolean isProductionQueueAssigned() {
		return productionQueueAssigned;
	}

	/**
	 * Sets the value of the productionQueueAssigned property.
	 * 
	 */
	public void setProductionQueueAssigned(boolean value) {
		this.productionQueueAssigned = value;
	}

	/**
	 * Gets the value of the productionQueueKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the productionQueueKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProductionQueueKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getProductionQueueKeys() {
		if (productionQueueKeys == null) {
			productionQueueKeys = new ArrayList<Long>();
		}
		return this.productionQueueKeys;
	}

	/**
	 * Gets the value of the queueCapacity property.
	 * 
	 */
	public int getQueueCapacity() {
		return queueCapacity;
	}

	/**
	 * Sets the value of the queueCapacity property.
	 * 
	 */
	public void setQueueCapacity(int value) {
		this.queueCapacity = value;
	}

	/**
	 * Gets the value of the queueDuration property.
	 * 
	 */
	public int getQueueDuration() {
		return queueDuration;
	}

	/**
	 * Sets the value of the queueDuration property.
	 * 
	 */
	public void setQueueDuration(int value) {
		this.queueDuration = value;
	}

	/**
	 * Gets the value of the routeKey property.
	 * 
	 */
	public long getRouteKey() {
		return routeKey;
	}

	/**
	 * Sets the value of the routeKey property.
	 * 
	 */
	public void setRouteKey(long value) {
		this.routeKey = value;
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
