
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
 *         &lt;element name="Hotels" type="{http://TekTravel/HotelBookingApi}ArrayOfGiataHotels" minOccurs="0"/>
 *         &lt;element name="HotelDetails" type="{http://TekTravel/HotelBookingApi}ArrayOfAPIHotelDetails" minOccurs="0"/>
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
    "hotels",
    "hotelDetails"
})
@XmlRootElement(name = "TBOHotelCodesResponse")
public class TBOHotelCodesResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "Hotels")
    protected ArrayOfGiataHotels hotels;
    @XmlElement(name = "HotelDetails")
    protected ArrayOfAPIHotelDetails hotelDetails;

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
     * Obtém o valor da propriedade hotels.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGiataHotels }
     *     
     */
    public ArrayOfGiataHotels getHotels() {
        return hotels;
    }

    /**
     * Define o valor da propriedade hotels.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGiataHotels }
     *     
     */
    public void setHotels(ArrayOfGiataHotels value) {
        this.hotels = value;
    }

    /**
     * Obtém o valor da propriedade hotelDetails.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAPIHotelDetails }
     *     
     */
    public ArrayOfAPIHotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Define o valor da propriedade hotelDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAPIHotelDetails }
     *     
     */
    public void setHotelDetails(ArrayOfAPIHotelDetails value) {
        this.hotelDetails = value;
    }

}
