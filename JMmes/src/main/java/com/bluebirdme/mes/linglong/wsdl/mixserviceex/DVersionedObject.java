package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DVersionedObject complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DVersionedObject">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="currentStateEffective" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="effectivityEnd" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="effectivityStart" type="{dataobjects.common.plantops.datasweep.com}DTimestamp" minOccurs="0"/>
 *         &lt;element name="extendedRevision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="linkedKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="linkedType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ralationShipChildren" type="{dataobjects.common.plantops.datasweep.com}DVersionedRelationShipNode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="relationshipParents" type="{dataobjects.common.plantops.datasweep.com}DVersionedRelationShipNode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{dataobjects.common.plantops.datasweep.com}DState" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVersionedObject", propOrder = { "currentStateEffective",
		"effectivityEnd", "effectivityStart", "extendedRevision", "key",
		"linkedKey", "linkedType", "name", "nameExt", "ralationShipChildren",
		"rank", "relationshipParents", "revision", "state", "type" })
public class DVersionedObject extends DDataObject {

	protected boolean currentStateEffective;
	protected DTimestamp effectivityEnd;
	protected DTimestamp effectivityStart;
	protected String extendedRevision;
	protected long key;
	protected long linkedKey;
	protected short linkedType;
	protected String name;
	protected String nameExt;
	@XmlElement(nillable = true)
	protected List<DVersionedRelationShipNode> ralationShipChildren;
	protected int rank;
	@XmlElement(nillable = true)
	protected List<DVersionedRelationShipNode> relationshipParents;
	protected String revision;
	protected DState state;
	protected short type;

	/**
	 * Gets the value of the currentStateEffective property.
	 * 
	 */
	public boolean isCurrentStateEffective() {
		return currentStateEffective;
	}

	/**
	 * Sets the value of the currentStateEffective property.
	 * 
	 */
	public void setCurrentStateEffective(boolean value) {
		this.currentStateEffective = value;
	}

	/**
	 * Gets the value of the effectivityEnd property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityEnd() {
		return effectivityEnd;
	}

	/**
	 * Sets the value of the effectivityEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityEnd(DTimestamp value) {
		this.effectivityEnd = value;
	}

	/**
	 * Gets the value of the effectivityStart property.
	 * 
	 * @return possible object is {@link DTimestamp }
	 * 
	 */
	public DTimestamp getEffectivityStart() {
		return effectivityStart;
	}

	/**
	 * Sets the value of the effectivityStart property.
	 * 
	 * @param value
	 *            allowed object is {@link DTimestamp }
	 * 
	 */
	public void setEffectivityStart(DTimestamp value) {
		this.effectivityStart = value;
	}

	/**
	 * Gets the value of the extendedRevision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExtendedRevision() {
		return extendedRevision;
	}

	/**
	 * Sets the value of the extendedRevision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExtendedRevision(String value) {
		this.extendedRevision = value;
	}

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
	 * Gets the value of the linkedKey property.
	 * 
	 */
	public long getLinkedKey() {
		return linkedKey;
	}

	/**
	 * Sets the value of the linkedKey property.
	 * 
	 */
	public void setLinkedKey(long value) {
		this.linkedKey = value;
	}

	/**
	 * Gets the value of the linkedType property.
	 * 
	 */
	public short getLinkedType() {
		return linkedType;
	}

	/**
	 * Sets the value of the linkedType property.
	 * 
	 */
	public void setLinkedType(short value) {
		this.linkedType = value;
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
	 * Gets the value of the nameExt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNameExt() {
		return nameExt;
	}

	/**
	 * Sets the value of the nameExt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNameExt(String value) {
		this.nameExt = value;
	}

	/**
	 * Gets the value of the ralationShipChildren property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ralationShipChildren property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRalationShipChildren().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersionedRelationShipNode }
	 * 
	 * 
	 */
	public List<DVersionedRelationShipNode> getRalationShipChildren() {
		if (ralationShipChildren == null) {
			ralationShipChildren = new ArrayList<DVersionedRelationShipNode>();
		}
		return this.ralationShipChildren;
	}

	/**
	 * Gets the value of the rank property.
	 * 
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the value of the rank property.
	 * 
	 */
	public void setRank(int value) {
		this.rank = value;
	}

	/**
	 * Gets the value of the relationshipParents property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the relationshipParents property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRelationshipParents().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersionedRelationShipNode }
	 * 
	 * 
	 */
	public List<DVersionedRelationShipNode> getRelationshipParents() {
		if (relationshipParents == null) {
			relationshipParents = new ArrayList<DVersionedRelationShipNode>();
		}
		return this.relationshipParents;
	}

	/**
	 * Gets the value of the revision property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * Sets the value of the revision property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRevision(String value) {
		this.revision = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link DState }
	 * 
	 */
	public DState getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *            allowed object is {@link DState }
	 * 
	 */
	public void setState(DState value) {
		this.state = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 */
	public short getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 */
	public void setType(short value) {
		this.type = value;
	}

}
