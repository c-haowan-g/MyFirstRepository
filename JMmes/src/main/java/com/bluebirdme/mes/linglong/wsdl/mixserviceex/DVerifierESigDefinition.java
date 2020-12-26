package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVerifierESigDefinition complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVerifierESigDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DESignatureDefinition">
 *       &lt;sequence>
 *         &lt;element name="timeInterval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVerifierESigDefinition", propOrder = { "timeInterval" })
public class DVerifierESigDefinition extends DESignatureDefinition {

	protected int timeInterval;

	/**
	 * Gets the value of the timeInterval property.
	 * 
	 */
	public int getTimeInterval() {
		return timeInterval;
	}

	/**
	 * Sets the value of the timeInterval property.
	 * 
	 */
	public void setTimeInterval(int value) {
		this.timeInterval = value;
	}

}
