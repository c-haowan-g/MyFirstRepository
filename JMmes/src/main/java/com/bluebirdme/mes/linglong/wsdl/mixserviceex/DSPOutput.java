package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DSPOutput complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DSPOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameters" type="{dataobjects.common.plantops.datasweep.com}DSPParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resultSets" type="{dataobjects.common.plantops.datasweep.com}DDataSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnValue" type="{dataobjects.common.plantops.datasweep.com}DSPParameter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSPOutput", propOrder = { "parameters", "resultSets",
		"returnValue" })
public class DSPOutput {

	@XmlElement(nillable = true)
	protected List<DSPParameter> parameters;
	@XmlElement(nillable = true)
	protected List<DDataSet> resultSets;
	protected DSPParameter returnValue;

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
	 * {@link DSPParameter }
	 * 
	 * 
	 */
	public List<DSPParameter> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<DSPParameter>();
		}
		return this.parameters;
	}

	/**
	 * Gets the value of the resultSets property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the resultSets property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getResultSets().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DDataSet }
	 * 
	 * 
	 */
	public List<DDataSet> getResultSets() {
		if (resultSets == null) {
			resultSets = new ArrayList<DDataSet>();
		}
		return this.resultSets;
	}

	/**
	 * Gets the value of the returnValue property.
	 * 
	 * @return possible object is {@link DSPParameter }
	 * 
	 */
	public DSPParameter getReturnValue() {
		return returnValue;
	}

	/**
	 * Sets the value of the returnValue property.
	 * 
	 * @param value
	 *            allowed object is {@link DSPParameter }
	 * 
	 */
	public void setReturnValue(DSPParameter value) {
		this.returnValue = value;
	}

}
