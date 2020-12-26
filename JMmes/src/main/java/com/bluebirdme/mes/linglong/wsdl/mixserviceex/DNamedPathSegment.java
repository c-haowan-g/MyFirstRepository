package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DNamedPathSegment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DNamedPathSegment">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DCategorical">
 *       &lt;sequence>
 *         &lt;element name="connectionKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="destinationPortKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourcePortKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "DNamedPathSegment", propOrder = { "connectionKey",
		"destinationPortKey", "index", "parentKey", "sourcePortKey",
		"userDefinedAttributes" })
public class DNamedPathSegment extends DCategorical {

	protected long connectionKey;
	protected long destinationPortKey;
	protected int index;
	protected long parentKey;
	protected long sourcePortKey;
	protected DUDAInstance userDefinedAttributes;

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
	 * Gets the value of the index property.
	 * 
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the value of the index property.
	 * 
	 */
	public void setIndex(int value) {
		this.index = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
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
