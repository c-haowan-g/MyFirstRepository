package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DXRefResults complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DXRefResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="atRowCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="boxCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="controlRecipeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderStepCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="results" type="{dataobjects.common.plantops.datasweep.com}DXRefResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="STAInstanceCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sublotCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tbomCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DXRefResults", propOrder = { "atRowCount", "boxCount",
		"controlRecipeCount", "lotCount", "orderStepCount", "results",
		"staInstanceCount", "sublotCount", "tbomCount", "unitCount" })
public class DXRefResults {

	protected int atRowCount;
	protected int boxCount;
	protected int controlRecipeCount;
	protected int lotCount;
	protected int orderStepCount;
	@XmlElement(nillable = true)
	protected List<DXRefResult> results;
	@XmlElement(name = "STAInstanceCount")
	protected int staInstanceCount;
	protected int sublotCount;
	protected int tbomCount;
	protected int unitCount;

	/**
	 * Gets the value of the atRowCount property.
	 * 
	 */
	public int getAtRowCount() {
		return atRowCount;
	}

	/**
	 * Sets the value of the atRowCount property.
	 * 
	 */
	public void setAtRowCount(int value) {
		this.atRowCount = value;
	}

	/**
	 * Gets the value of the boxCount property.
	 * 
	 */
	public int getBoxCount() {
		return boxCount;
	}

	/**
	 * Sets the value of the boxCount property.
	 * 
	 */
	public void setBoxCount(int value) {
		this.boxCount = value;
	}

	/**
	 * Gets the value of the controlRecipeCount property.
	 * 
	 */
	public int getControlRecipeCount() {
		return controlRecipeCount;
	}

	/**
	 * Sets the value of the controlRecipeCount property.
	 * 
	 */
	public void setControlRecipeCount(int value) {
		this.controlRecipeCount = value;
	}

	/**
	 * Gets the value of the lotCount property.
	 * 
	 */
	public int getLotCount() {
		return lotCount;
	}

	/**
	 * Sets the value of the lotCount property.
	 * 
	 */
	public void setLotCount(int value) {
		this.lotCount = value;
	}

	/**
	 * Gets the value of the orderStepCount property.
	 * 
	 */
	public int getOrderStepCount() {
		return orderStepCount;
	}

	/**
	 * Sets the value of the orderStepCount property.
	 * 
	 */
	public void setOrderStepCount(int value) {
		this.orderStepCount = value;
	}

	/**
	 * Gets the value of the results property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the results property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getResults().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DXRefResult }
	 * 
	 * 
	 */
	public List<DXRefResult> getResults() {
		if (results == null) {
			results = new ArrayList<DXRefResult>();
		}
		return this.results;
	}

	/**
	 * Gets the value of the staInstanceCount property.
	 * 
	 */
	public int getSTAInstanceCount() {
		return staInstanceCount;
	}

	/**
	 * Sets the value of the staInstanceCount property.
	 * 
	 */
	public void setSTAInstanceCount(int value) {
		this.staInstanceCount = value;
	}

	/**
	 * Gets the value of the sublotCount property.
	 * 
	 */
	public int getSublotCount() {
		return sublotCount;
	}

	/**
	 * Sets the value of the sublotCount property.
	 * 
	 */
	public void setSublotCount(int value) {
		this.sublotCount = value;
	}

	/**
	 * Gets the value of the tbomCount property.
	 * 
	 */
	public int getTbomCount() {
		return tbomCount;
	}

	/**
	 * Sets the value of the tbomCount property.
	 * 
	 */
	public void setTbomCount(int value) {
		this.tbomCount = value;
	}

	/**
	 * Gets the value of the unitCount property.
	 * 
	 */
	public int getUnitCount() {
		return unitCount;
	}

	/**
	 * Sets the value of the unitCount property.
	 * 
	 */
	public void setUnitCount(int value) {
		this.unitCount = value;
	}

}
