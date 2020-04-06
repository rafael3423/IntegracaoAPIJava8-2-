
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AOTNumbers complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AOTNumbers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntlCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DomesticCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OfficeHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Emergency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AOTNumbers", propOrder = {
    "country",
    "contact",
    "intlCall",
    "domesticCall",
    "localCall",
    "officeHours",
    "emergency",
    "language"
})
public class AOTNumbers {

    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Contact")
    protected String contact;
    @XmlElement(name = "IntlCall")
    protected String intlCall;
    @XmlElement(name = "DomesticCall")
    protected String domesticCall;
    @XmlElement(name = "LocalCall")
    protected String localCall;
    @XmlElement(name = "OfficeHours")
    protected String officeHours;
    @XmlElement(name = "Emergency")
    protected String emergency;
    @XmlElement(name = "Language")
    protected String language;

    /**
     * Obtém o valor da propriedade country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define o valor da propriedade country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Obtém o valor da propriedade contact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Define o valor da propriedade contact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Obtém o valor da propriedade intlCall.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntlCall() {
        return intlCall;
    }

    /**
     * Define o valor da propriedade intlCall.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntlCall(String value) {
        this.intlCall = value;
    }

    /**
     * Obtém o valor da propriedade domesticCall.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticCall() {
        return domesticCall;
    }

    /**
     * Define o valor da propriedade domesticCall.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticCall(String value) {
        this.domesticCall = value;
    }

    /**
     * Obtém o valor da propriedade localCall.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalCall() {
        return localCall;
    }

    /**
     * Define o valor da propriedade localCall.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalCall(String value) {
        this.localCall = value;
    }

    /**
     * Obtém o valor da propriedade officeHours.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Define o valor da propriedade officeHours.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeHours(String value) {
        this.officeHours = value;
    }

    /**
     * Obtém o valor da propriedade emergency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergency() {
        return emergency;
    }

    /**
     * Define o valor da propriedade emergency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergency(String value) {
        this.emergency = value;
    }

    /**
     * Obtém o valor da propriedade language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define o valor da propriedade language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
