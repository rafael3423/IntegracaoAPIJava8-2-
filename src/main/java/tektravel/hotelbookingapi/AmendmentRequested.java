
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendmentRequested complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AmendmentRequested">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckIn" type="{http://TekTravel/HotelBookingApi}CheckInRes" minOccurs="0"/>
 *         &lt;element name="CheckOut" type="{http://TekTravel/HotelBookingApi}CheckOutRes" minOccurs="0"/>
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomRes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentRequested", propOrder = {
    "checkIn",
    "checkOut",
    "rooms"
})
public class AmendmentRequested {

    @XmlElement(name = "CheckIn")
    protected CheckInRes checkIn;
    @XmlElement(name = "CheckOut")
    protected CheckOutRes checkOut;
    @XmlElement(name = "Rooms")
    protected ArrayOfRoomRes rooms;

    /**
     * Obtém o valor da propriedade checkIn.
     * 
     * @return
     *     possible object is
     *     {@link CheckInRes }
     *     
     */
    public CheckInRes getCheckIn() {
        return checkIn;
    }

    /**
     * Define o valor da propriedade checkIn.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckInRes }
     *     
     */
    public void setCheckIn(CheckInRes value) {
        this.checkIn = value;
    }

    /**
     * Obtém o valor da propriedade checkOut.
     * 
     * @return
     *     possible object is
     *     {@link CheckOutRes }
     *     
     */
    public CheckOutRes getCheckOut() {
        return checkOut;
    }

    /**
     * Define o valor da propriedade checkOut.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckOutRes }
     *     
     */
    public void setCheckOut(CheckOutRes value) {
        this.checkOut = value;
    }

    /**
     * Obtém o valor da propriedade rooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomRes }
     *     
     */
    public ArrayOfRoomRes getRooms() {
        return rooms;
    }

    /**
     * Define o valor da propriedade rooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomRes }
     *     
     */
    public void setRooms(ArrayOfRoomRes value) {
        this.rooms = value;
    }

}
