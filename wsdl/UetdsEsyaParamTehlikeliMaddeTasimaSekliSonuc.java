//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.23 at 02:12:45 PM EET 
//


package com.arma.uetds_boot.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sonucKodu" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sonucMesaji" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tehlikeliMaddeTasimaSekliListesi" type="{http://uetds.unetws.udhb.gov.tr/}cstParamEsyaTehlikeliMaddeTasimaSekli" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc", propOrder = {
    "sonucKodu",
    "sonucMesaji",
    "tehlikeliMaddeTasimaSekliListesi"
})
public class UetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc {

    protected int sonucKodu;
    protected String sonucMesaji;
    @XmlElement(nillable = true)
    protected List<CstParamEsyaTehlikeliMaddeTasimaSekli> tehlikeliMaddeTasimaSekliListesi;

    /**
     * Gets the value of the sonucKodu property.
     * 
     */
    public int getSonucKodu() {
        return sonucKodu;
    }

    /**
     * Sets the value of the sonucKodu property.
     * 
     */
    public void setSonucKodu(int value) {
        this.sonucKodu = value;
    }

    /**
     * Gets the value of the sonucMesaji property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSonucMesaji() {
        return sonucMesaji;
    }

    /**
     * Sets the value of the sonucMesaji property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSonucMesaji(String value) {
        this.sonucMesaji = value;
    }

    /**
     * Gets the value of the tehlikeliMaddeTasimaSekliListesi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tehlikeliMaddeTasimaSekliListesi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTehlikeliMaddeTasimaSekliListesi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CstParamEsyaTehlikeliMaddeTasimaSekli }
     * 
     * 
     */
    public List<CstParamEsyaTehlikeliMaddeTasimaSekli> getTehlikeliMaddeTasimaSekliListesi() {
        if (tehlikeliMaddeTasimaSekliListesi == null) {
            tehlikeliMaddeTasimaSekliListesi = new ArrayList<CstParamEsyaTehlikeliMaddeTasimaSekli>();
        }
        return this.tehlikeliMaddeTasimaSekliListesi;
    }

}
