//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.23 at 02:12:45 PM EET 
//


package com.arma.uetds_boot.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for yukBildirimiDetayiResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="yukBildirimiDetayiResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://uetds.unetws.udhb.gov.tr/}uetdsEsyaWsYukBildirimDetayiSonuc" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "yukBildirimiDetayiResponse", propOrder = {
    "_return"
})
public class YukBildirimiDetayiResponse {

    @XmlElement(name = "return")
    protected UetdsEsyaWsYukBildirimDetayiSonuc _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link UetdsEsyaWsYukBildirimDetayiSonuc }
     *     
     */
    public UetdsEsyaWsYukBildirimDetayiSonuc getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link UetdsEsyaWsYukBildirimDetayiSonuc }
     *     
     */
    public void setReturn(UetdsEsyaWsYukBildirimDetayiSonuc value) {
        this._return = value;
    }

}