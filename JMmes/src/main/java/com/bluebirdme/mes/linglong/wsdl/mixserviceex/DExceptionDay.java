package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DExceptionDay complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DExceptionDay">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DWorkDay">
 *       &lt;sequence>
 *         &lt;element name="exceptionDate" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DExceptionDay", propOrder = { "exceptionDate" })
public class DExceptionDay extends DWorkDay {

	protected DTimestamp exceptionDate;

	/**
	 * Gets the value of the exceptionDate property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getExceptionDate() {
		return exceptionDate;
	}

	/**
	 * Sets the value of the exceptionDate property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setExceptionDate(DTimestamp value) {
		this.exceptionDate = value;
	}

}
