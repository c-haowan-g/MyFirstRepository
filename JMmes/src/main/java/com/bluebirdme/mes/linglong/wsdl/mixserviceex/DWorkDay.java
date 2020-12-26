package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkDay complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkDay">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DKeyed">
 *       &lt;sequence>
 *         &lt;element name="auditInfo" type="{dataobjects.common.plantops.datasweep.com}DAuditInfo" minOccurs="0"/>
 *         &lt;element name="dayIndex" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="workEvents" type="{dataobjects.common.plantops.datasweep.com}DWorkEvent" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "DWorkDay", propOrder = { "auditInfo", "dayIndex",
		"workEvents", "workScheduleKey" })
public class DWorkDay extends DKeyed {

	protected DAuditInfo auditInfo;
	protected short dayIndex;
	@XmlElement(nillable = true)
	protected List<DWorkEvent> workEvents;
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
	 * Gets the value of the dayIndex property.
	 * 
	 */
	public short getDayIndex() {
		return dayIndex;
	}

	/**
	 * Sets the value of the dayIndex property.
	 * 
	 */
	public void setDayIndex(short value) {
		this.dayIndex = value;
	}

	/**
	 * Gets the value of the workEvents property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workEvents property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkEvents().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DWorkEvent }
	 * 
	 * 
	 */
	public List<DWorkEvent> getWorkEvents() {
		if (workEvents == null) {
			workEvents = new ArrayList<DWorkEvent>();
		}
		return this.workEvents;
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
