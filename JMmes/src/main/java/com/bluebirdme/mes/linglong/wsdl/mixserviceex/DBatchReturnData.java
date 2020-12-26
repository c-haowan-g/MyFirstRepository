package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DBatchReturnData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DBatchReturnData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBatch" type="{dataobjects.common.plantops.datasweep.com}DBatch" minOccurs="0"/>
 *         &lt;element name="DSourceSublots" type="{dataobjects.common.plantops.datasweep.com}DSublot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DSublots" type="{dataobjects.common.plantops.datasweep.com}DSublot" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBatchReturnData", propOrder = { "dBatch", "dSourceSublots",
		"dSublots" })
public class DBatchReturnData {

	@XmlElement(name = "DBatch")
	protected DBatch dBatch;
	@XmlElement(name = "DSourceSublots", nillable = true)
	protected List<DSublot> dSourceSublots;
	@XmlElement(name = "DSublots", nillable = true)
	protected List<DSublot> dSublots;

	/**
	 * Gets the value of the dBatch property.
	 * 
	 * @return possible object is {@link DBatch }
	 * 
	 */
	public DBatch getDBatch() {
		return dBatch;
	}

	/**
	 * Sets the value of the dBatch property.
	 * 
	 * @param value
	 *            allowed object is {@link DBatch }
	 * 
	 */
	public void setDBatch(DBatch value) {
		this.dBatch = value;
	}

	/**
	 * Gets the value of the dSourceSublots property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dSourceSublots property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDSourceSublots().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DSublot }
	 * 
	 * 
	 */
	public List<DSublot> getDSourceSublots() {
		if (dSourceSublots == null) {
			dSourceSublots = new ArrayList<DSublot>();
		}
		return this.dSourceSublots;
	}

	/**
	 * Gets the value of the dSublots property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the dSublots property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDSublots().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DSublot }
	 * 
	 * 
	 */
	public List<DSublot> getDSublots() {
		if (dSublots == null) {
			dSublots = new ArrayList<DSublot>();
		}
		return this.dSublots;
	}

}
