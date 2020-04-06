
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsNearBySearchAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GuestNationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomGuests" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomGuest" minOccurs="0"/>
 *         &lt;element name="PreferredCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResultCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Filters" type="{http://TekTravel/HotelBookingApi}HotelSearchWithRoomsFilters" minOccurs="0"/>
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsCancellationPolicyRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "checkInDate",
    "checkOutDate",
    "countryName",
    "cityName",
    "cityId",
    "isNearBySearchAllowed",
    "noOfRooms",
    "guestNationality",
    "roomGuests",
    "preferredCurrencyCode",
    "resultCount",
    "filters",
    "responseTime",
    "isCancellationPolicyRequired"
})
@XmlRootElement(name = "HotelSearchWithRoomsRequest")
public class HotelSearchWithRoomsRequest {

    @XmlElement(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlElement(name = "CityId")
    protected int cityId;
    @XmlElement(name = "IsNearBySearchAllowed")
    protected boolean isNearBySearchAllowed;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "GuestNationality")
    protected String guestNationality;
    @XmlElement(name = "RoomGuests")
    protected ArrayOfRoomGuest roomGuests;
    @XmlElement(name = "PreferredCurrencyCode")
    protected String preferredCurrencyCode;
    @XmlElement(name = "ResultCount")
    protected int resultCount;
    @XmlElement(name = "Filters")
    protected HotelSearchWithRoomsFilters filters;
    @XmlElement(name = "ResponseTime")
    protected int responseTime;
    @XmlElement(name = "IsCancellationPolicyRequired")
    protected boolean isCancellationPolicyRequired;

    /**
     * Obtém o valor da propriedade checkInDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Define o valor da propriedade checkInDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Obtém o valor da propriedade checkOutDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Define o valor da propriedade checkOutDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Obtém o valor da propriedade countryName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Define o valor da propriedade countryName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Obtém o valor da propriedade cityName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Define o valor da propriedade cityName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Obtém o valor da propriedade cityId.
     * 
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Define o valor da propriedade cityId.
     * 
     */
    public void setCityId(int value) {
        this.cityId = value;
    }

    /**
     * Obtém o valor da propriedade isNearBySearchAllowed.
     * 
     */
    public boolean isIsNearBySearchAllowed() {
        return isNearBySearchAllowed;
    }

    /**
     * Define o valor da propriedade isNearBySearchAllowed.
     * 
     */
    public void setIsNearBySearchAllowed(boolean value) {
        this.isNearBySearchAllowed = value;
    }

    /**
     * Obtém o valor da propriedade noOfRooms.
     * 
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Define o valor da propriedade noOfRooms.
     * 
     */
    public void setNoOfRooms(int value) {
        this.noOfRooms = value;
    }

    /**
     * Obtém o valor da propriedade guestNationality.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestNationality() {
        return guestNationality;
    }

    /**
     * Define o valor da propriedade guestNationality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestNationality(String value) {
        this.guestNationality = value;
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
     * Obtém o valor da propriedade preferredCurrencyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    /**
     * Define o valor da propriedade preferredCurrencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredCurrencyCode(String value) {
        this.preferredCurrencyCode = value;
    }

    /**
     * Obtém o valor da propriedade resultCount.
     * 
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * Define o valor da propriedade resultCount.
     * 
     */
    public void setResultCount(int value) {
        this.resultCount = value;
    }

    /**
     * Obtém o valor da propriedade filters.
     * 
     * @return
     *     possible object is
     *     {@link HotelSearchWithRoomsFilters }
     *     
     */
    public HotelSearchWithRoomsFilters getFilters() {
        return filters;
    }

    /**
     * Define o valor da propriedade filters.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelSearchWithRoomsFilters }
     *     
     */
    public void setFilters(HotelSearchWithRoomsFilters value) {
        this.filters = value;
    }

    /**
     * Obtém o valor da propriedade responseTime.
     * 
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * Define o valor da propriedade responseTime.
     * 
     */
    public void setResponseTime(int value) {
        this.responseTime = value;
    }

    /**
     * Obtém o valor da propriedade isCancellationPolicyRequired.
     * 
     */
    public boolean isIsCancellationPolicyRequired() {
        return isCancellationPolicyRequired;
    }

    /**
     * Define o valor da propriedade isCancellationPolicyRequired.
     * 
     */
    public void setIsCancellationPolicyRequired(boolean value) {
        this.isCancellationPolicyRequired = value;
    }

}
