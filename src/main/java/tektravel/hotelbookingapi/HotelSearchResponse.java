
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/>
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfRoomsRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomGuests" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomGuest" minOccurs="0"/>
 *         &lt;element name="HotelResultList" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Result" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "responseTime",
    "language",
    "sessionId",
    "noOfRoomsRequested",
    "cityId",
    "checkInDate",
    "checkOutDate",
    "roomGuests",
    "hotelResultList"
})
@XmlRootElement(name = "HotelSearchResponse")
public class HotelSearchResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "ResponseTime")
    protected String responseTime;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "NoOfRoomsRequested")
    protected String noOfRoomsRequested;
    @XmlElement(name = "CityId")
    protected String cityId;
    @XmlElement(name = "CheckInDate")
    protected String checkInDate;
    @XmlElement(name = "CheckOutDate")
    protected String checkOutDate;
    @XmlElement(name = "RoomGuests")
    protected ArrayOfRoomGuest roomGuests;
    @XmlElement(name = "HotelResultList")
    protected ArrayOfHotelResult hotelResultList;

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade responseTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Define o valor da propriedade responseTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseTime(String value) {
        this.responseTime = value;
    }

    /**
     * Obtém o valor da propriedade language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define o valor da propriedade language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Obtém o valor da propriedade sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Define o valor da propriedade sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Obtém o valor da propriedade noOfRoomsRequested.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfRoomsRequested() {
        return noOfRoomsRequested;
    }

    /**
     * Define o valor da propriedade noOfRoomsRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfRoomsRequested(String value) {
        this.noOfRoomsRequested = value;
    }

    /**
     * Obtém o valor da propriedade cityId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * Define o valor da propriedade cityId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityId(String value) {
        this.cityId = value;
    }

    /**
     * Obtém o valor da propriedade checkInDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * Define o valor da propriedade checkInDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckInDate(String value) {
        this.checkInDate = value;
    }

    /**
     * Obtém o valor da propriedade checkOutDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Define o valor da propriedade checkOutDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckOutDate(String value) {
        this.checkOutDate = value;
    }

    /**
     * Obtém o valor da propriedade roomGuests.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomGuest }
     *     
     */
    public ArrayOfRoomGuest getRoomGuests() {
        return roomGuests;
    }

    /**
     * Define o valor da propriedade roomGuests.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomGuest }
     *     
     */
    public void setRoomGuests(ArrayOfRoomGuest value) {
        this.roomGuests = value;
    }

    /**
     * Obtém o valor da propriedade hotelResultList.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelResult }
     *     
     */
    public ArrayOfHotelResult getHotelResultList() {
        return hotelResultList;
    }

    /**
     * Define o valor da propriedade hotelResultList.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelResult }
     *     
     */
    public void setHotelResultList(ArrayOfHotelResult value) {
        this.hotelResultList = value;
    }

}
