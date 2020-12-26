package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DStateChangeResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DStateChangeResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DDataObject">
 *       &lt;sequence>
 *         &lt;element name="backInfo" type="{dataobjects.common.plantops.datasweep.com}DVersionBackInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FSMReturnType" type="{dataobjects.common.plantops.datasweep.com}DTransitionReturnData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="versionError" type="{dataobjects.common.plantops.datasweep.com}DVersioningViolation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DStateChangeResponse", propOrder = { "backInfo",
		"fsmReturnType", "versionError" })
public class DStateChangeResponse extends DDataObject {

	@XmlElement(nillable = true)
	protected List<DVersionBackInfo> backInfo;
	@XmlElement(name = "FSMReturnType", nillable = true)
	protected List<DTransitionReturnData> fsmReturnType;
	@XmlElement(nillable = true)
	protected List<DVersioningViolation> versionError;

	/**
	 * Gets the value of the backInfo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the backInfo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBackInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersionBackInfo }
	 * 
	 * 
	 */
	public List<DVersionBackInfo> getBackInfo() {
		if (backInfo == null) {
			backInfo = new ArrayList<DVersionBackInfo>();
		}
		return this.backInfo;
	}

	/**
	 * Gets the value of the fsmReturnType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the fsmReturnType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFSMReturnType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DTransitionReturnData }
	 * 
	 * 
	 */
	public List<DTransitionReturnData> getFSMReturnType() {
		if (fsmReturnType == null) {
			fsmReturnType = new ArrayList<DTransitionReturnData>();
		}
		return this.fsmReturnType;
	}

	/**
	 * Gets the value of the versionError property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the versionError property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getVersionError().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DVersioningViolation }
	 * 
	 * 
	 */
	public List<DVersioningViolation> getVersionError() {
		if (versionError == null) {
			versionError = new ArrayList<DVersioningViolation>();
		}
		return this.versionError;
	}

}
