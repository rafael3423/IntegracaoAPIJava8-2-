
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomReq complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Guest" type="{http://TekTravel/HotelBookingApi}AmendGuestReq" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Amend" use="required" type="{http://TekTravel/HotelBookingApi}RoomRequested" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomReq", propOrder = {
    "guest"
})
public class RoomReq {

    @XmlElement(name = "Guest")
    protected List<AmendGuestReq> guest;
    @XmlAttribute(name = "Amend", required = true)
    protected RoomRequested amend;

    /**
     * Gets the value of the guest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmendGuestReq }
     * 
     * 
     */
    public List<AmendGuestReq> getGuest() {
        if (guest == null) {
            guest = new ArrayList<AmendGuestReq>();
        }
        return this.guest;
    }

    /**
     * Obtém o valor da propriedade amend.
     * 
     * @return
     *     possible object is
     *     {@link RoomRequested }
     *     
     */
    public RoomRequested getAmend() {
        return amend;
    }

    /**
     * Define o valor da propriedade amend.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomRequested }
     *     
     */
    public void setAmend(RoomRequested value) {
        this.amend = value;
    }

}
