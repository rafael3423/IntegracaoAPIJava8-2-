
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de BookingOptions complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="BookingOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FixedFormat" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RoomCombination" type="{http://TekTravel/HotelBookingApi}RoomCombination" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingOptions", propOrder = {
    "fixedFormat",
    "roomCombination"
})
public class BookingOptions {

    @XmlElement(name = "FixedFormat")
    protected boolean fixedFormat;
    @XmlElement(name = "RoomCombination")
    protected List<RoomCombination> roomCombination;

    /**
     * Obtém o valor da propriedade fixedFormat.
     * 
     */
    public boolean isFixedFormat() {
        return fixedFormat;
    }

    /**
     * Define o valor da propriedade fixedFormat.
     * 
     */
    public void setFixedFormat(boolean value) {
        this.fixedFormat = value;
    }

    /**
     * Gets the value of the roomCombination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomCombination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomCombination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomCombination }
     * 
     * 
     */
    public List<RoomCombination> getRoomCombination() {
        if (roomCombination == null) {
            roomCombination = new ArrayList<RoomCombination>();
        }
        return this.roomCombination;
    }

}
