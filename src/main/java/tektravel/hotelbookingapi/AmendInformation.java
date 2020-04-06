
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AmendInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckIn" type="{http://TekTravel/HotelBookingApi}CheckInReq" minOccurs="0"/>
 *         &lt;element name="CheckOut" type="{http://TekTravel/HotelBookingApi}CheckOutReq" minOccurs="0"/>
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomReq" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendInformation", propOrder = {
    "checkIn",
    "checkOut",
    "rooms"
})
public class AmendInformation {

    @XmlElement(name = "CheckIn")
    protected CheckInReq checkIn;
    @XmlElement(name = "CheckOut")
    protected CheckOutReq checkOut;
    @XmlElement(name = "Rooms")
    protected ArrayOfRoomReq rooms;

    /**
     * Obtém o valor da propriedade checkIn.
     * 
     * @return
     *     possible object is
     *     {@link CheckInReq }
     *     
     */
    public CheckInReq getCheckIn() {
        return checkIn;
    }

    /**
     * Define o valor da propriedade checkIn.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckInReq }
     *     
     */
    public void setCheckIn(CheckInReq value) {
        this.checkIn = value;
    }

    /**
     * Obtém o valor da propriedade checkOut.
     * 
     * @return
     *     possible object is
     *     {@link CheckOutReq }
     *     
     */
    public CheckOutReq getCheckOut() {
        return checkOut;
    }

    /**
     * Define o valor da propriedade checkOut.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckOutReq }
     *     
     */
    public void setCheckOut(CheckOutReq value) {
        this.checkOut = value;
    }

    /**
     * Obtém o valor da propriedade rooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomReq }
     *     
     */
    public ArrayOfRoomReq getRooms() {
        return rooms;
    }

    /**
     * Define o valor da propriedade rooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomReq }
     *     
     */
    public void setRooms(ArrayOfRoomReq value) {
        this.rooms = value;
    }

}
