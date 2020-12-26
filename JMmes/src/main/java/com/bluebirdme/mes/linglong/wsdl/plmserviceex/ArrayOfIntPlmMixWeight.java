
package com.bluebirdme.mes.linglong.wsdl.plmserviceex;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfInt_Plm_MixWeight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfInt_Plm_MixWeight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Int_Plm_MixWeight" type="{http://tempuri.org/}Int_Plm_MixWeight" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfInt_Plm_MixWeight", namespace = "http://tempuri.org/", propOrder = {
    "intPlmMixWeight"
})
public class ArrayOfIntPlmMixWeight {

    @XmlElement(name = "Int_Plm_MixWeight", namespace = "http://tempuri.org/", nillable = true)
    protected List<IntPlmMixWeight> intPlmMixWeight;

    /**
     * Gets the value of the intPlmMixWeight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intPlmMixWeight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntPlmMixWeight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntPlmMixWeight }
     * 
     * 
     */
    public List<IntPlmMixWeight> getIntPlmMixWeight() {
        if (intPlmMixWeight == null) {
            intPlmMixWeight = new ArrayList<IntPlmMixWeight>();
        }
        return this.intPlmMixWeight;
    }

}
