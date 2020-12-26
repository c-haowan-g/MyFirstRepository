
package com.bluebirdme.mes.linglong.wsdl.plmserviceex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.bluebirdme.mes.linglong.building.entity.BuildRecipePara;


/**
 * <p>Java class for ArrayOfBuildRecipePara complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBuildRecipePara">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuildRecipePara" type="{http://tempuri.org/}BuildRecipePara" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBuildRecipePara", namespace = "http://tempuri.org/", propOrder = {
    "buildRecipePara"
})
public class ArrayOfBuildRecipePara {

    @XmlElement(name = "BuildRecipePara", namespace = "http://tempuri.org/", nillable = true)
    protected List<BuildRecipePara> buildRecipePara;

    /**
     * Gets the value of the buildRecipePara property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buildRecipePara property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuildRecipePara().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuildRecipePara }
     * 
     * 
     */
    public List<BuildRecipePara> getBuildRecipePara() {
        if (buildRecipePara == null) {
            buildRecipePara = new ArrayList<BuildRecipePara>();
        }
        return this.buildRecipePara;
    }

}
