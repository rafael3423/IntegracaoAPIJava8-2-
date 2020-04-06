
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfRoomReq complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRoomReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomReq" type="{http://TekTravel/HotelBookingApi}RoomReq" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRoomReq", propOrder = {
    "roomReq"
})
public class ArrayOfRoomReq {

    @XmlElement(name = "RoomReq", nillable = true)
    protected List<RoomReq> roomReq;

    /**
     * Gets the value of the roomReq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomReq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomReq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomReq }
     * 
     * 
     */
    public List<RoomReq> getRoomReq() {
        if (roomReq == null) {
            roomReq = new ArrayList<RoomReq>();
        }
        return this.roomReq;
    }

}
