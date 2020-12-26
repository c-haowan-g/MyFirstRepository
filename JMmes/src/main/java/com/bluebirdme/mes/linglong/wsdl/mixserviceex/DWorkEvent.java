package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkEvent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="hour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="semanticPropertyKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="semanticPropertyKeysForShifts" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shiftKeys" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workScheduleKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DWorkEvent", propOrder = { "auditInfo", "hour", "minute",
		"parentKey", "parentType", "semanticPropertyKeys",
		"semanticPropertyKeysForShifts", "shiftKeys", "workScheduleKey" })
public class DWorkEvent extends DKeyed {

	protected DAuditInfo auditInfo;
	protected int hour;
	protected int minute;
	protected long parentKey;
	protected short parentType;
	@XmlElement(type = Long.class)
	protected List<Long> semanticPropertyKeys;
	@XmlElement(type = Long.class)
	protected List<Long> semanticPropertyKeysForShifts;
	@XmlElement(type = Long.class)
	protected List<Long> shiftKeys;
	protected long workScheduleKey;

	/**
	 * Gets the value of the auditInfo property.
	 * 
	 * @return possible object is {@link DAuditInfo }
	 * 
	 */
	public DAuditInfo getAuditInfo() {
		return auditInfo;
	}

	/**
	 * Sets the value of the auditInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link DAuditInfo }
	 * 
	 */
	public void setAuditInfo(DAuditInfo value) {
		this.auditInfo = value;
	}

	/**
	 * Gets the value of the hour property.
	 * 
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Sets the value of the hour property.
	 * 
	 */
	public void setHour(int value) {
		this.hour = value;
	}

	/**
	 * Gets the value of the minute property.
	 * 
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Sets the value of the minute property.
	 * 
	 */
	public void setMinute(int value) {
		this.minute = value;
	}

	/**
	 * Gets the value of the parentKey property.
	 * 
	 */
	public long getParentKey() {
		return parentKey;
	}

	/**
	 * Sets the value of the parentKey property.
	 * 
	 */
	public void setParentKey(long value) {
		this.parentKey = value;
	}

	/**
	 * Gets the value of the parentType property.
	 * 
	 */
	public short getParentType() {
		return parentType;
	}

	/**
	 * Sets the value of the parentType property.
	 * 
	 */
	public void setParentType(short value) {
		this.parentType = value;
	}

	/**
	 * Gets the value of the semanticPropertyKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the semanticPropertyKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSemanticPropertyKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSemanticPropertyKeys() {
		if (semanticPropertyKeys == null) {
			semanticPropertyKeys = new ArrayList<Long>();
		}
		return this.semanticPropertyKeys;
	}

	/**
	 * Gets the value of the semanticPropertyKeysForShifts property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the semanticPropertyKeysForShifts property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSemanticPropertyKeysForShifts().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getSemanticPropertyKeysForShifts() {
		if (semanticPropertyKeysForShifts == null) {
			semanticPropertyKeysForShifts = new ArrayList<Long>();
		}
		return this.semanticPropertyKeysForShifts;
	}

	/**
	 * Gets the value of the shiftKeys property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the shiftKeys property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getShiftKeys().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getShiftKeys() {
		if (shiftKeys == null) {
			shiftKeys = new ArrayList<Long>();
		}
		return this.shiftKeys;
	}

	/**
	 * Gets the value of the workScheduleKey property.
	 * 
	 */
	public long getWorkScheduleKey() {
		return workScheduleKey;
	}

	/**
	 * Sets the value of the workScheduleKey property.
	 * 
	 */
	public void setWorkScheduleKey(long value) {
		this.workScheduleKey = value;
	}

}
