
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReturnNewCityCodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countryCode",
    "returnNewCityCodes"
})
@XmlRootElement(name = "DestinationCityListRequest")
public class DestinationCityListRequest {

    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "ReturnNewCityCodes")
    protected String returnNewCityCodes;

    /**
     * Obtém o valor da propriedade countryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Define o valor da propriedade countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Obtém o valor da propriedade returnNewCityCodes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnNewCityCodes() {
        return returnNewCityCodes;
    }

    /**
     * Define o valor da propriedade returnNewCityCodes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnNewCityCodes(String value) {
        this.returnNewCityCodes = value;
    }

}
