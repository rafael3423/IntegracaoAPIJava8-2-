
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PriceVerification complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PriceVerification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Room" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" use="required" type="{http://TekTravel/HotelBookingApi}PriceVerificationStatus" />
 *       &lt;attribute name="PriceChanged" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="AvailableOnNewPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceVerification", propOrder = {
    "hotelRooms"
})
public class PriceVerification {

    @XmlElement(name = "HotelRooms")
    protected ArrayOfHotelRoom hotelRooms;
    @XmlAttribute(name = "Status", required = true)
    protected PriceVerificationStatus status;
    @XmlAttribute(name = "PriceChanged", required = true)
    protected boolean priceChanged;
    @XmlAttribute(name = "AvailableOnNewPrice", required = true)
    protected boolean availableOnNewPrice;

    /**
     * Obtém o valor da propriedade hotelRooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public ArrayOfHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Define o valor da propriedade hotelRooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link PriceVerificationStatus }
     *     
     */
    public PriceVerificationStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceVerificationStatus }
     *     
     */
    public void setStatus(PriceVerificationStatus value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade priceChanged.
     * 
     */
    public boolean isPriceChanged() {
        return priceChanged;
    }

    /**
     * Define o valor da propriedade priceChanged.
     * 
     */
    public void setPriceChanged(boolean value) {
        this.priceChanged = value;
    }

    /**
     * Obtém o valor da propriedade availableOnNewPrice.
     * 
     */
    public boolean isAvailableOnNewPrice() {
        return availableOnNewPrice;
    }

    /**
     * Define o valor da propriedade availableOnNewPrice.
     * 
     */
    public void setAvailableOnNewPrice(boolean value) {
        this.availableOnNewPrice = value;
    }

}
