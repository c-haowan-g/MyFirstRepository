package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DKeyed complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DKeyed">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectSource" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="parameters" type="{dataobjects.common.plantops.datasweep.com}DParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="siteNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DKeyed", propOrder = { "key", "name", "objectSource",
		"parameters", "siteNumber" })
public abstract class DKeyed extends DDataObject {

	protected long key;
	protected String name;
	protected short objectSource;
	@XmlElement(nillable = true)
	protected List<DParameter> parameters;
	protected int siteNumber;

	/**
	 * Gets the value of the key property.
	 * 
	 */
	public long getKey() {
		return key;
	}

	/**
	 * Sets the value of the key property.
	 * 
	 */
	public void setKey(long value) {
		this.key = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the objectSource property.
	 * 
	 */
	public short getObjectSource() {
		return objectSource;
	}

	/**
	 * Sets the value of the objectSource property.
	 * 
	 */
	public void setObjectSource(short value) {
		this.objectSource = value;
	}

	/**
	 * Gets the value of the parameters property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the parameters property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getParameters().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DParameter }
	 * 
	 * 
	 */
	public List<DParameter> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<DParameter>();
		}
		return this.parameters;
	}

	/**
	 * Gets the value of the siteNumber property.
	 * 
	 */
	public int getSiteNumber() {
		return siteNumber;
	}

	/**
	 * Sets the value of the siteNumber property.
	 * 
	 */
	public void setSiteNumber(int value) {
		this.siteNumber = value;
	}

}
