
package com.bluebirdme.mes.linglong.wsdl.plmserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHalfPartRecipePara complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHalfPartRecipePara">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HalfPartRecipePara" type="{http://tempuri.org/}HalfPartRecipePara" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHalfPartRecipePara", namespace = "http://tempuri.org/", propOrder = {
    "halfPartRecipePara"
})
public class ArrayOfHalfPartRecipePara {

    @XmlElement(name = "HalfPartRecipePara", namespace = "http://tempuri.org/", nillable = true)
    protected List<HalfPartRecipePara> halfPartRecipePara;

    /**
     * Gets the value of the halfPartRecipePara property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the halfPartRecipePara property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHalfPartRecipePara().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HalfPartRecipePara }
     * 
     * 
     */
    public List<HalfPartRecipePara> getHalfPartRecipePara() {
        if (halfPartRecipePara == null) {
            halfPartRecipePara = new ArrayList<HalfPartRecipePara>();
        }
        return this.halfPartRecipePara;
    }

}
