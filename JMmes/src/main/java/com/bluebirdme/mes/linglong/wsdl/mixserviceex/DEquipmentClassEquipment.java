package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DEquipmentClassEquipment complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DEquipmentClassEquipment">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractClassItem">
 *       &lt;sequence>
 *         &lt;element name="temp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DEquipmentClassEquipment", propOrder = { "temp" })
public class DEquipmentClassEquipment extends DAbstractClassItem {

	protected int temp;

	/**
	 * Gets the value of the temp property.
	 * 
	 */
	public int getTemp() {
		return temp;
	}

	/**
	 * Sets the value of the temp property.
	 * 
	 */
	public void setTemp(int value) {
		this.temp = value;
	}

}
