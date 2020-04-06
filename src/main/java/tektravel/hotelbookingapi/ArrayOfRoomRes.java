
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfRoomRes complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRoomRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomRes" type="{http://TekTravel/HotelBookingApi}RoomRes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRoomRes", propOrder = {
    "roomRes"
})
public class ArrayOfRoomRes {

    @XmlElement(name = "RoomRes", nillable = true)
    protected List<RoomRes> roomRes;

    /**
     * Gets the value of the roomRes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomRes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomRes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomRes }
     * 
     * 
     */
    public List<RoomRes> getRoomRes() {
        if (roomRes == null) {
            roomRes = new ArrayList<RoomRes>();
        }
        return this.roomRes;
    }

}
