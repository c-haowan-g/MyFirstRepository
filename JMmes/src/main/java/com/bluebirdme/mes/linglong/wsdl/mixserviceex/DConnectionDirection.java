package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DConnectionDirection complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DConnectionDirection">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="connectionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="destinationPortKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourcePortKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DConnectionDirection", propOrder = { "connectionKey",
		"destinationPortKey", "sourcePortKey" })
public class DConnectionDirection extends DKeyed {

	protected long connectionKey;
	protected long destinationPortKey;
	protected long sourcePortKey;

	/**
	 * Gets the value of the connectionKey property.
	 * 
	 */
	public long getConnectionKey() {
		return connectionKey;
	}

	/**
	 * Sets the value of the connectionKey property.
	 * 
	 */
	public void setConnectionKey(long value) {
		this.connectionKey = value;
	}

	/**
	 * Gets the value of the destinationPortKey property.
	 * 
	 */
	public long getDestinationPortKey() {
		return destinationPortKey;
	}

	/**
	 * Sets the value of the destinationPortKey property.
	 * 
	 */
	public void setDestinationPortKey(long value) {
		this.destinationPortKey = value;
	}

	/**
	 * Gets the value of the sourcePortKey property.
	 * 
	 */
	public long getSourcePortKey() {
		return sourcePortKey;
	}

	/**
	 * Sets the value of the sourcePortKey property.
	 * 
	 */
	public void setSourcePortKey(long value) {
		this.sourcePortKey = value;
	}

}
