
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfRoomGuest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRoomGuest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomGuest" type="{http://TekTravel/HotelBookingApi}RoomGuest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRoomGuest", propOrder = {
    "roomGuest"
})
public class ArrayOfRoomGuest {

    @XmlElement(name = "RoomGuest", nillable = true)
    protected List<RoomGuest> roomGuest;

    /**
     * Gets the value of the roomGuest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomGuest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomGuest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomGuest }
     * 
     * 
     */
    public List<RoomGuest> getRoomGuest() {
        if (roomGuest == null) {
            roomGuest = new ArrayList<RoomGuest>();
        }
        return this.roomGuest;
    }

}
