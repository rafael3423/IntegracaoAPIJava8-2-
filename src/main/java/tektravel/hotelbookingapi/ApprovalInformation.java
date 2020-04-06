
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ApprovalInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ApprovalInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomPriceRes" minOccurs="0"/>
 *         &lt;element name="TotalPrice" type="{http://TekTravel/HotelBookingApi}TotalPrice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApprovalInformation", propOrder = {
    "rooms",
    "totalPrice"
})
public class ApprovalInformation {

    @XmlElement(name = "Rooms")
    protected ArrayOfRoomPriceRes rooms;
    @XmlElement(name = "TotalPrice")
    protected TotalPrice totalPrice;

    /**
     * Obtém o valor da propriedade rooms.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomPriceRes }
     *     
     */
    public ArrayOfRoomPriceRes getRooms() {
        return rooms;
    }

    /**
     * Define o valor da propriedade rooms.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomPriceRes }
     *     
     */
    public void setRooms(ArrayOfRoomPriceRes value) {
        this.rooms = value;
    }

    /**
     * Obtém o valor da propriedade totalPrice.
     * 
     * @return
     *     possible object is
     *     {@link TotalPrice }
     *     
     */
    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    /**
     * Define o valor da propriedade totalPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalPrice }
     *     
     */
    public void setTotalPrice(TotalPrice value) {
        this.totalPrice = value;
    }

}
