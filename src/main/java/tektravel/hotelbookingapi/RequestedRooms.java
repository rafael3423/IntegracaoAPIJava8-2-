
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RequestedRooms complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RequestedRooms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}Rate" minOccurs="0"/>
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSuppInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedRooms", propOrder = {
    "roomIndex",
    "roomTypeName",
    "roomTypeCode",
    "ratePlanCode",
    "roomRate",
    "supplements"
})
public class RequestedRooms {

    @XmlElement(name = "RoomIndex")
    protected int roomIndex;
    @XmlElement(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlElement(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlElement(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlElement(name = "RoomRate")
    protected Rate roomRate;
    @XmlElement(name = "Supplements")
    protected ArrayOfSuppInfo supplements;

    /**
     * Obtém o valor da propriedade roomIndex.
     * 
     */
    public int getRoomIndex() {
        return roomIndex;
    }

    /**
     * Define o valor da propriedade roomIndex.
     * 
     */
    public void setRoomIndex(int value) {
        this.roomIndex = value;
    }

    /**
     * Obtém o valor da propriedade roomTypeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * Define o valor da propriedade roomTypeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeName(String value) {
        this.roomTypeName = value;
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

    /**
     * Obtém o valor da propriedade ratePlanCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Define o valor da propriedade ratePlanCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

    /**
     * Obtém o valor da propriedade roomRate.
     * 
     * @return
     *     possible object is
     *     {@link Rate }
     *     
     */
    public Rate getRoomRate() {
        return roomRate;
    }

    /**
     * Define o valor da propriedade roomRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Rate }
     *     
     */
    public void setRoomRate(Rate value) {
        this.roomRate = value;
    }

    /**
     * Obtém o valor da propriedade supplements.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSuppInfo }
     *     
     */
    public ArrayOfSuppInfo getSupplements() {
        return supplements;
    }

    /**
     * Define o valor da propriedade supplements.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSuppInfo }
     *     
     */
    public void setSupplements(ArrayOfSuppInfo value) {
        this.supplements = value;
    }

}
