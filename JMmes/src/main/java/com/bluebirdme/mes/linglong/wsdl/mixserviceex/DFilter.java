package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DFilter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="distinctOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="filterByUTC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maxResultCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="objectIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objectSource" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="objectType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="orFilters" type="{dataobjects.common.plantops.datasweep.com}DFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderByUTC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pagingFilterRowCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pagingFilterStartRow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parameters" type="{dataobjects.common.plantops.datasweep.com}DFilterParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchConstraints" type="{dataobjects.common.plantops.datasweep.com}DFilterSearchConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortConstraints" type="{dataobjects.common.plantops.datasweep.com}DFilterSortConstraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="withContainedOjbect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DFilter", propOrder = { "distinctOnly", "filterByUTC",
		"maxResultCount", "objectIdentifier", "objectSource", "objectType",
		"orFilters", "orderByUTC", "pagingFilterRowCount",
		"pagingFilterStartRow", "parameters", "searchConstraints",
		"sortConstraints", "withContainedOjbect" })
public class DFilter {

	protected boolean distinctOnly;
	protected boolean filterByUTC;
	protected int maxResultCount;
	protected String objectIdentifier;
	protected short objectSource;
	protected short objectType;
	@XmlElement(nillable = true)
	protected List<DFilter> orFilters;
	protected boolean orderByUTC;
	protected int pagingFilterRowCount;
	protected int pagingFilterStartRow;
	@XmlElement(nillable = true)
	protected List<DFilterParameter> parameters;
	@XmlElement(nillable = true)
	protected List<DFilterSearchConstraint> searchConstraints;
	@XmlElement(nillable = true)
	protected List<DFilterSortConstraint> sortConstraints;
	protected boolean withContainedOjbect;

	/**
	 * Gets the value of the distinctOnly property.
	 * 
	 */
	public boolean isDistinctOnly() {
		return distinctOnly;
	}

	/**
	 * Sets the value of the distinctOnly property.
	 * 
	 */
	public void setDistinctOnly(boolean value) {
		this.distinctOnly = value;
	}

	/**
	 * Gets the value of the filterByUTC property.
	 * 
	 */
	public boolean isFilterByUTC() {
		return filterByUTC;
	}

	/**
	 * Sets the value of the filterByUTC property.
	 * 
	 */
	public void setFilterByUTC(boolean value) {
		this.filterByUTC = value;
	}

	/**
	 * Gets the value of the maxResultCount property.
	 * 
	 */
	public int getMaxResultCount() {
		return maxResultCount;
	}

	/**
	 * Sets the value of the maxResultCount property.
	 * 
	 */
	public void setMaxResultCount(int value) {
		this.maxResultCount = value;
	}

	/**
	 * Gets the value of the objectIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getObjectIdentifier() {
		return objectIdentifier;
	}

	/**
	 * Sets the value of the objectIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setObjectIdentifier(String value) {
		this.objectIdentifier = value;
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
	 * Gets the value of the objectType property.
	 * 
	 */
	public short getObjectType() {
		return objectType;
	}

	/**
	 * Sets the value of the objectType property.
	 * 
	 */
	public void setObjectType(short value) {
		this.objectType = value;
	}

	/**
	 * Gets the value of the orFilters property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the orFilters property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrFilters().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DFilter }
	 * 
	 * 
	 */
	public List<DFilter> getOrFilters() {
		if (orFilters == null) {
			orFilters = new ArrayList<DFilter>();
		}
		return this.orFilters;
	}

	/**
	 * Gets the value of the orderByUTC property.
	 * 
	 */
	public boolean isOrderByUTC() {
		return orderByUTC;
	}

	/**
	 * Sets the value of the orderByUTC property.
	 * 
	 */
	public void setOrderByUTC(boolean value) {
		this.orderByUTC = value;
	}

	/**
	 * Gets the value of the pagingFilterRowCount property.
	 * 
	 */
	public int getPagingFilterRowCount() {
		return pagingFilterRowCount;
	}

	/**
	 * Sets the value of the pagingFilterRowCount property.
	 * 
	 */
	public void setPagingFilterRowCount(int value) {
		this.pagingFilterRowCount = value;
	}

	/**
	 * Gets the value of the pagingFilterStartRow property.
	 * 
	 */
	public int getPagingFilterStartRow() {
		return pagingFilterStartRow;
	}

	/**
	 * Sets the value of the pagingFilterStartRow property.
	 * 
	 */
	public void setPagingFilterStartRow(int value) {
		this.pagingFilterStartRow = value;
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
	 * {@link DFilterParameter }
	 * 
	 * 
	 */
	public List<DFilterParameter> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<DFilterParameter>();
		}
		return this.parameters;
	}

	/**
	 * Gets the value of the searchConstraints property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the searchConstraints property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSearchConstraints().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DFilterSearchConstraint }
	 * 
	 * 
	 */
	public List<DFilterSearchConstraint> getSearchConstraints() {
		if (searchConstraints == null) {
			searchConstraints = new ArrayList<DFilterSearchConstraint>();
		}
		return this.searchConstraints;
	}

	/**
	 * Gets the value of the sortConstraints property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the sortConstraints property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSortConstraints().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DFilterSortConstraint }
	 * 
	 * 
	 */
	public List<DFilterSortConstraint> getSortConstraints() {
		if (sortConstraints == null) {
			sortConstraints = new ArrayList<DFilterSortConstraint>();
		}
		return this.sortConstraints;
	}

	/**
	 * Gets the value of the withContainedOjbect property.
	 * 
	 */
	public boolean isWithContainedOjbect() {
		return withContainedOjbect;
	}

	/**
	 * Sets the value of the withContainedOjbect property.
	 * 
	 */
	public void setWithContainedOjbect(boolean value) {
		this.withContainedOjbect = value;
	}

}
