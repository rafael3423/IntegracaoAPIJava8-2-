
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
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/>
 *         &lt;element name="HotelDetails" type="{http://TekTravel/HotelBookingApi}APIHotelDetails" minOccurs="0"/>
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
    "status",
    "hotelDetails"
})
@XmlRootElement(name = "HotelDetailsResponse")
public class HotelDetailsResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "HotelDetails")
    protected APIHotelDetails hotelDetails;

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade hotelDetails.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelDetails }
     *     
     */
    public APIHotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Define o valor da propriedade hotelDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelDetails }
     *     
     */
    public void setHotelDetails(APIHotelDetails value) {
        this.hotelDetails = value;
    }

}
