
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelCancellationPolicies complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="HotelCancellationPolicies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelNorms" type="{http://TekTravel/HotelBookingApi}ArrayOfString2" minOccurs="0"/>
 *         &lt;element name="CancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCancellationPolicies", propOrder = {
    "hotelNorms",
    "cancelPolicies"
})
public class HotelCancellationPolicies {

    @XmlElement(name = "HotelNorms")
    protected ArrayOfString2 hotelNorms;
    @XmlElement(name = "CancelPolicies")
    protected CancelPolicies cancelPolicies;

    /**
     * Obtém o valor da propriedade hotelNorms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString2 }
     *     
     */
    public ArrayOfString2 getHotelNorms() {
        return hotelNorms;
    }

    /**
     * Define o valor da propriedade hotelNorms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString2 }
     *     
     */
    public void setHotelNorms(ArrayOfString2 value) {
        this.hotelNorms = value;
    }

    /**
     * Obtém o valor da propriedade cancelPolicies.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicies }
     *     
     */
    public CancelPolicies getCancelPolicies() {
        return cancelPolicies;
    }

    /**
     * Define o valor da propriedade cancelPolicies.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicies }
     *     
     */
    public void setCancelPolicies(CancelPolicies value) {
        this.cancelPolicies = value;
    }

}
