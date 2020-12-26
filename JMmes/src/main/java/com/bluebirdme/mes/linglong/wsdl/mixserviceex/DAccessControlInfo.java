package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DAccessControlInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DAccessControlInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="accessLevel" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="checkoutUserKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAccessControlInfo", propOrder = { "accessLevel",
		"checkoutUserKey", "version" })
public class DAccessControlInfo extends DDataObject {

	protected short accessLevel;
	protected long checkoutUserKey;
	protected int version;

	/**
	 * Gets the value of the accessLevel property.
	 * 
	 */
	public short getAccessLevel() {
		return accessLevel;
	}

	/**
	 * Sets the value of the accessLevel property.
	 * 
	 */
	public void setAccessLevel(short value) {
		this.accessLevel = value;
	}

	/**
	 * Gets the value of the checkoutUserKey property.
	 * 
	 */
	public long getCheckoutUserKey() {
		return checkoutUserKey;
	}

	/**
	 * Sets the value of the checkoutUserKey property.
	 * 
	 */
	public void setCheckoutUserKey(long value) {
		this.checkoutUserKey = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 */
	public void setVersion(int value) {
		this.version = value;
	}

}
