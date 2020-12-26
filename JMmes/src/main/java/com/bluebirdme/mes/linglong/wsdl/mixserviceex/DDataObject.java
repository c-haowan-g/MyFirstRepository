package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DDataObject complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DDataObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="modificationFlag" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DDataObject", propOrder = { "modificationFlag" })
public class DDataObject {

	protected short modificationFlag;

	/**
	 * Gets the value of the modificationFlag property.
	 * 
	 */
	public short getModificationFlag() {
		return modificationFlag;
	}

	/**
	 * Sets the value of the modificationFlag property.
	 * 
	 */
	public void setModificationFlag(short value) {
		this.modificationFlag = value;
	}

}
