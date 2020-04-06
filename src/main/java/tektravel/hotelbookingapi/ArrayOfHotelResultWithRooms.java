
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfHotel_ResultWithRooms complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHotel_ResultWithRooms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelResult" type="{http://TekTravel/HotelBookingApi}Hotel_ResultWithRooms" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHotel_ResultWithRooms", propOrder = {
    "hotelResult"
})
public class ArrayOfHotelResultWithRooms {

    @XmlElement(name = "HotelResult", nillable = true)
    protected List<HotelResultWithRooms> hotelResult;

    /**
     * Gets the value of the hotelResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelResultWithRooms }
     * 
     * 
     */
    public List<HotelResultWithRooms> getHotelResult() {
        if (hotelResult == null) {
            hotelResult = new ArrayList<HotelResultWithRooms>();
        }
        return this.hotelResult;
    }

}
