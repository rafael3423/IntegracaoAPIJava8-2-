
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://TekTravel/HotelBookingApi}ArrayOfString5" minOccurs="0"/>
 *         &lt;element name="RoomPromotion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RoomName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomInfo", propOrder = {
    "description",
    "images",
    "roomPromotion",
    "inclusion"
})
public class RoomInfo {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Images")
    protected ArrayOfString5 images;
    @XmlElement(name = "RoomPromotion")
    protected String roomPromotion;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlAttribute(name = "RoomName")
    protected String roomName;
    @XmlAttribute(name = "RoomTypeCode")
    protected String roomTypeCode;

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade images.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getImages() {
        return images;
    }

    /**
     * Define o valor da propriedade images.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setImages(ArrayOfString5 value) {
        this.images = value;
    }

    /**
     * Obtém o valor da propriedade roomPromotion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomPromotion() {
        return roomPromotion;
    }

    /**
     * Define o valor da propriedade roomPromotion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomPromotion(String value) {
        this.roomPromotion = value;
    }

    /**
     * Obtém o valor da propriedade inclusion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInclusion() {
        return inclusion;
    }

    /**
     * Define o valor da propriedade inclusion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInclusion(String value) {
        this.inclusion = value;
    }

    /**
     * Obtém o valor da propriedade roomName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Define o valor da propriedade roomName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * Obtém o valor da propriedade roomTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Define o valor da propriedade roomTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

}
