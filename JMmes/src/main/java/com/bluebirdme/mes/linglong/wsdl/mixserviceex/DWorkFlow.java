package com.bluebirdme.mes.linglong.wsdl.mixserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DWorkFlow complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="DWorkFlow">
 *   &lt;complexContent>
 *     &lt;extension base="{dataobjects.common.plantops.datasweep.com}DAbstractResource">
 *       &lt;sequence>
 *         &lt;element name="workFlowObjects" type="{dataobjects.common.plantops.datasweep.com}DWorkFlowObject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DWorkFlow", propOrder = { "workFlowObjects" })
public class DWorkFlow extends DAbstractResource {

	@XmlElement(nillable = true)
	protected List<DWorkFlowObject> workFlowObjects;

	/**
	 * Gets the value of the workFlowObjects property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the workFlowObjects property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getWorkFlowObjects().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DWorkFlowObject }
	 * 
	 * 
	 */
	public List<DWorkFlowObject> getWorkFlowObjects() {
		if (workFlowObjects == null) {
			workFlowObjects = new ArrayList<DWorkFlowObject>();
		}
		return this.workFlowObjects;
	}

}
