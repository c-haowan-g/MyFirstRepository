package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DLiteLot complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DLiteLot">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="lotKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="trackedObjectStatusKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DLiteLot", propOrder = { "lotKey", "trackedObjectStatusKey" })
public class DLiteLot extends DDataObject {

	protected long lotKey;
	protected long trackedObjectStatusKey;

	/**
	 * Gets the value of the lotKey property.
	 * 
	 */
	public long getLotKey() {
		return lotKey;
	}

	/**
	 * Sets the value of the lotKey property.
	 * 
	 */
	public void setLotKey(long value) {
		this.lotKey = value;
	}

	/**
	 * Gets the value of the trackedObjectStatusKey property.
	 * 
	 */
	public long getTrackedObjectStatusKey() {
		return trackedObjectStatusKey;
	}

	/**
	 * Sets the value of the trackedObjectStatusKey property.
	 * 
	 */
	public void setTrackedObjectStatusKey(long value) {
		this.trackedObjectStatusKey = value;
	}

}
