
package com.bluebirdme.mes.linglong.wsdl.plmserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Int_Plm_MixWeight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Int_Plm_MixWeight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RECIPE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ViscosityStandard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Child_matercode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Child_MaterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Supply_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BC_Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Error_Allow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Weight_Prop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Set_weight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChildIsMixed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Into_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Into_routing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChildPrescriptionStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEGRAD_WEIGHT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEGRAD_ALLOW" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dummy1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dummy2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dummy3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dummy4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dummy5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Int_Plm_MixWeight", namespace = "http://tempuri.org/", propOrder = {
    "recipecode",
    "viscosityStandard",
    "childMatercode",
    "childMaterName",
    "supplyCode",
    "bcVersion",
    "weightType",
    "weightId",
    "errorAllow",
    "weightProp",
    "setWeight",
    "childIsMixed",
    "intoType",
    "intoRouting",
    "childPrescriptionStage",
    "degradweight",
    "degradallow",
    "dummy1",
    "dummy2",
    "dummy3",
    "dummy4",
    "dummy5"
})
public class IntPlmMixWeight {

    @XmlElement(name = "RECIPE_CODE", namespace = "http://tempuri.org/")
    protected String recipecode;
    @XmlElement(name = "ViscosityStandard", namespace = "http://tempuri.org/")
    protected String viscosityStandard;
    @XmlElement(name = "Child_matercode", namespace = "http://tempuri.org/")
    protected String childMatercode;
    @XmlElement(name = "Child_MaterName", namespace = "http://tempuri.org/")
    protected String childMaterName;
    @XmlElement(name = "Supply_code", namespace = "http://tempuri.org/")
    protected String supplyCode;
    @XmlElement(name = "BC_Version", namespace = "http://tempuri.org/")
    protected String bcVersion;
    @XmlElement(name = "Weight_type", namespace = "http://tempuri.org/")
    protected String weightType;
    @XmlElement(name = "Weight_id", namespace = "http://tempuri.org/")
    protected String weightId;
    @XmlElement(name = "Error_Allow", namespace = "http://tempuri.org/")
    protected String errorAllow;
    @XmlElement(name = "Weight_Prop", namespace = "http://tempuri.org/")
    protected String weightProp;
    @XmlElement(name = "Set_weight", namespace = "http://tempuri.org/")
    protected String setWeight;
    @XmlElement(name = "ChildIsMixed", namespace = "http://tempuri.org/")
    protected String childIsMixed;
    @XmlElement(name = "Into_type", namespace = "http://tempuri.org/")
    protected String intoType;
    @XmlElement(name = "Into_routing", namespace = "http://tempuri.org/")
    protected String intoRouting;
    @XmlElement(name = "ChildPrescriptionStage", namespace = "http://tempuri.org/")
    protected String childPrescriptionStage;
    @XmlElement(name = "DEGRAD_WEIGHT", namespace = "http://tempuri.org/")
    protected String degradweight;
    @XmlElement(name = "DEGRAD_ALLOW", namespace = "http://tempuri.org/")
    protected String degradallow;
    @XmlElement(name = "Dummy1", namespace = "http://tempuri.org/")
    protected String dummy1;
    @XmlElement(name = "Dummy2", namespace = "http://tempuri.org/")
    protected String dummy2;
    @XmlElement(name = "Dummy3", namespace = "http://tempuri.org/")
    protected String dummy3;
    @XmlElement(name = "Dummy4", namespace = "http://tempuri.org/")
    protected String dummy4;
    @XmlElement(name = "Dummy5", namespace = "http://tempuri.org/")
    protected String dummy5;

    /**
     * Gets the value of the recipecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECIPECODE() {
        return recipecode;
    }

    /**
     * Sets the value of the recipecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECIPECODE(String value) {
        this.recipecode = value;
    }

    /**
     * Gets the value of the viscosityStandard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViscosityStandard() {
        return viscosityStandard;
    }

    /**
     * Sets the value of the viscosityStandard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViscosityStandard(String value) {
        this.viscosityStandard = value;
    }

    /**
     * Gets the value of the childMatercode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildMatercode() {
        return childMatercode;
    }

    /**
     * Sets the value of the childMatercode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildMatercode(String value) {
        this.childMatercode = value;
    }

    /**
     * Gets the value of the childMaterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildMaterName() {
        return childMaterName;
    }

    /**
     * Sets the value of the childMaterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildMaterName(String value) {
        this.childMaterName = value;
    }

    /**
     * Gets the value of the supplyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplyCode() {
        return supplyCode;
    }

    /**
     * Sets the value of the supplyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplyCode(String value) {
        this.supplyCode = value;
    }

    /**
     * Gets the value of the bcVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBCVersion() {
        return bcVersion;
    }

    /**
     * Sets the value of the bcVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBCVersion(String value) {
        this.bcVersion = value;
    }

    /**
     * Gets the value of the weightType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightType() {
        return weightType;
    }

    /**
     * Sets the value of the weightType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightType(String value) {
        this.weightType = value;
    }

    /**
     * Gets the value of the weightId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightId() {
        return weightId;
    }

    /**
     * Sets the value of the weightId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightId(String value) {
        this.weightId = value;
    }

    /**
     * Gets the value of the errorAllow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorAllow() {
        return errorAllow;
    }

    /**
     * Sets the value of the errorAllow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorAllow(String value) {
        this.errorAllow = value;
    }

    /**
     * Gets the value of the weightProp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightProp() {
        return weightProp;
    }

    /**
     * Sets the value of the weightProp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightProp(String value) {
        this.weightProp = value;
    }

    /**
     * Gets the value of the setWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetWeight() {
        return setWeight;
    }

    /**
     * Sets the value of the setWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetWeight(String value) {
        this.setWeight = value;
    }

    /**
     * Gets the value of the childIsMixed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildIsMixed() {
        return childIsMixed;
    }

    /**
     * Sets the value of the childIsMixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildIsMixed(String value) {
        this.childIsMixed = value;
    }

    /**
     * Gets the value of the intoType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntoType() {
        return intoType;
    }

    /**
     * Sets the value of the intoType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntoType(String value) {
        this.intoType = value;
    }

    /**
     * Gets the value of the intoRouting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntoRouting() {
        return intoRouting;
    }

    /**
     * Sets the value of the intoRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntoRouting(String value) {
        this.intoRouting = value;
    }

    /**
     * Gets the value of the childPrescriptionStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildPrescriptionStage() {
        return childPrescriptionStage;
    }

    /**
     * Sets the value of the childPrescriptionStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildPrescriptionStage(String value) {
        this.childPrescriptionStage = value;
    }

    /**
     * Gets the value of the degradweight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEGRADWEIGHT() {
        return degradweight;
    }

    /**
     * Sets the value of the degradweight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEGRADWEIGHT(String value) {
        this.degradweight = value;
    }

    /**
     * Gets the value of the degradallow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEGRADALLOW() {
        return degradallow;
    }

    /**
     * Sets the value of the degradallow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEGRADALLOW(String value) {
        this.degradallow = value;
    }

    /**
     * Gets the value of the dummy1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDummy1() {
        return dummy1;
    }

    /**
     * Sets the value of the dummy1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDummy1(String value) {
        this.dummy1 = value;
    }

    /**
     * Gets the value of the dummy2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDummy2() {
        return dummy2;
    }

    /**
     * Sets the value of the dummy2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDummy2(String value) {
        this.dummy2 = value;
    }

    /**
     * Gets the value of the dummy3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDummy3() {
        return dummy3;
    }

    /**
     * Sets the value of the dummy3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDummy3(String value) {
        this.dummy3 = value;
    }

    /**
     * Gets the value of the dummy4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDummy4() {
        return dummy4;
    }

    /**
     * Sets the value of the dummy4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDummy4(String value) {
        this.dummy4 = value;
    }

    /**
     * Gets the value of the dummy5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDummy5() {
        return dummy5;
    }

    /**
     * Sets the value of the dummy5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDummy5(String value) {
        this.dummy5 = value;
    }

}
