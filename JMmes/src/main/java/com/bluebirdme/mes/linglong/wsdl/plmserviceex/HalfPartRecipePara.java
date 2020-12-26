
package com.bluebirdme.mes.linglong.wsdl.plmserviceex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for HalfPartRecipePara complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HalfPartRecipePara">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOGICALADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARMCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARMNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EQUIPMENTCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EQUIPMENTTYPECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARMTYPECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARMTYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REMARK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUEMAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUEMIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUEMAXSIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALUEMINSIGN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANGED_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANGED_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RECORD_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_FACTORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AGENC_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HalfPartRecipePara", namespace = "http://tempuri.org/", propOrder = {
    "id",
    "basetype",
    "logicaladdress",
    "parmcode",
    "parmname",
    "unit",
    "equipmentcode",
    "equipmenttypecode",
    "parmtypecode",
    "parmtypename",
    "remark",
    "value",
    "valuemax",
    "valuemin",
    "valuemaxsign",
    "valueminsign",
    "changedby",
    "changedtime",
    "recordflag",
    "sfactory",
    "agencno"
})
public class HalfPartRecipePara {

    @XmlElement(name = "ID", namespace = "http://tempuri.org/")
    protected String id;
    @XmlElement(name = "BASETYPE", namespace = "http://tempuri.org/")
    protected String basetype;
    @XmlElement(name = "LOGICALADDRESS", namespace = "http://tempuri.org/")
    protected String logicaladdress;
    @XmlElement(name = "PARMCODE", namespace = "http://tempuri.org/")
    protected String parmcode;
    @XmlElement(name = "PARMNAME", namespace = "http://tempuri.org/")
    protected String parmname;
    @XmlElement(name = "UNIT", namespace = "http://tempuri.org/")
    protected String unit;
    @XmlElement(name = "EQUIPMENTCODE", namespace = "http://tempuri.org/")
    protected String equipmentcode;
    @XmlElement(name = "EQUIPMENTTYPECODE", namespace = "http://tempuri.org/")
    protected String equipmenttypecode;
    @XmlElement(name = "PARMTYPECODE", namespace = "http://tempuri.org/")
    protected String parmtypecode;
    @XmlElement(name = "PARMTYPENAME", namespace = "http://tempuri.org/")
    protected String parmtypename;
    @XmlElement(name = "REMARK", namespace = "http://tempuri.org/")
    protected String remark;
    @XmlElement(name = "VALUE", namespace = "http://tempuri.org/")
    protected String value;
    @XmlElement(name = "VALUEMAX", namespace = "http://tempuri.org/")
    protected String valuemax;
    @XmlElement(name = "VALUEMIN", namespace = "http://tempuri.org/")
    protected String valuemin;
    @XmlElement(name = "VALUEMAXSIGN", namespace = "http://tempuri.org/")
    protected String valuemaxsign;
    @XmlElement(name = "VALUEMINSIGN", namespace = "http://tempuri.org/")
    protected String valueminsign;
    @XmlElement(name = "CHANGED_BY", namespace = "http://tempuri.org/")
    protected String changedby;
    @XmlElement(name = "CHANGED_TIME", namespace = "http://tempuri.org/")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar changedtime;
    @XmlElement(name = "RECORD_FLAG", namespace = "http://tempuri.org/")
    protected String recordflag;
    @XmlElement(name = "S_FACTORY", namespace = "http://tempuri.org/")
    protected String sfactory;
    @XmlElement(name = "AGENC_NO", namespace = "http://tempuri.org/")
    protected String agencno;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the basetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBASETYPE() {
        return basetype;
    }

    /**
     * Sets the value of the basetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBASETYPE(String value) {
        this.basetype = value;
    }

    /**
     * Gets the value of the logicaladdress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOGICALADDRESS() {
        return logicaladdress;
    }

    /**
     * Sets the value of the logicaladdress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOGICALADDRESS(String value) {
        this.logicaladdress = value;
    }

    /**
     * Gets the value of the parmcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARMCODE() {
        return parmcode;
    }

    /**
     * Sets the value of the parmcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARMCODE(String value) {
        this.parmcode = value;
    }

    /**
     * Gets the value of the parmname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARMNAME() {
        return parmname;
    }

    /**
     * Sets the value of the parmname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARMNAME(String value) {
        this.parmname = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNIT() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNIT(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the equipmentcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEQUIPMENTCODE() {
        return equipmentcode;
    }

    /**
     * Sets the value of the equipmentcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEQUIPMENTCODE(String value) {
        this.equipmentcode = value;
    }

    /**
     * Gets the value of the equipmenttypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEQUIPMENTTYPECODE() {
        return equipmenttypecode;
    }

    /**
     * Sets the value of the equipmenttypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEQUIPMENTTYPECODE(String value) {
        this.equipmenttypecode = value;
    }

    /**
     * Gets the value of the parmtypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARMTYPECODE() {
        return parmtypecode;
    }

    /**
     * Sets the value of the parmtypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARMTYPECODE(String value) {
        this.parmtypecode = value;
    }

    /**
     * Gets the value of the parmtypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARMTYPENAME() {
        return parmtypename;
    }

    /**
     * Sets the value of the parmtypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARMTYPENAME(String value) {
        this.parmtypename = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMARK() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMARK(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUE() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUE(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the valuemax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEMAX() {
        return valuemax;
    }

    /**
     * Sets the value of the valuemax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEMAX(String value) {
        this.valuemax = value;
    }

    /**
     * Gets the value of the valuemin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEMIN() {
        return valuemin;
    }

    /**
     * Sets the value of the valuemin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEMIN(String value) {
        this.valuemin = value;
    }

    /**
     * Gets the value of the valuemaxsign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEMAXSIGN() {
        return valuemaxsign;
    }

    /**
     * Sets the value of the valuemaxsign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEMAXSIGN(String value) {
        this.valuemaxsign = value;
    }

    /**
     * Gets the value of the valueminsign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALUEMINSIGN() {
        return valueminsign;
    }

    /**
     * Sets the value of the valueminsign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALUEMINSIGN(String value) {
        this.valueminsign = value;
    }

    /**
     * Gets the value of the changedby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANGEDBY() {
        return changedby;
    }

    /**
     * Sets the value of the changedby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANGEDBY(String value) {
        this.changedby = value;
    }

    /**
     * Gets the value of the changedtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCHANGEDTIME() {
        return changedtime;
    }

    /**
     * Sets the value of the changedtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCHANGEDTIME(XMLGregorianCalendar value) {
        this.changedtime = value;
    }

    /**
     * Gets the value of the recordflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECORDFLAG() {
        return recordflag;
    }

    /**
     * Sets the value of the recordflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECORDFLAG(String value) {
        this.recordflag = value;
    }

    /**
     * Gets the value of the sfactory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFACTORY() {
        return sfactory;
    }

    /**
     * Sets the value of the sfactory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFACTORY(String value) {
        this.sfactory = value;
    }

    /**
     * Gets the value of the agencno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGENCNO() {
        return agencno;
    }

    /**
     * Sets the value of the agencno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGENCNO(String value) {
        this.agencno = value;
    }

}
