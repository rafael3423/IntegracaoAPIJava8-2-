
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de APIHotelDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="APIHotelDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attractions" type="{http://TekTravel/HotelBookingApi}ArrayOfString3" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelFacilities" type="{http://TekTravel/HotelBookingApi}ArrayOfString4" minOccurs="0"/>
 *         &lt;element name="HotelPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImageUrls" type="{http://TekTravel/HotelBookingApi}ArrayOfImageUrlDetails" minOccurs="0"/>
 *         &lt;element name="Map" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PinCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomInfo" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomInfo" minOccurs="0"/>
 *         &lt;element name="RoomFacilities" type="{http://TekTravel/HotelBookingApi}ArrayOfString6" minOccurs="0"/>
 *         &lt;element name="Services" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HotelWebsiteUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripAdvisorRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TripAdvisorReviewURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelRating" use="required" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIHotelDetails", propOrder = {
    "address",
    "hotelLocation",
    "attractions",
    "countryName",
    "countryCode",
    "description",
    "email",
    "faxNumber",
    "hotelFacilities",
    "hotelPolicy",
    "image",
    "imageUrls",
    "map",
    "phoneNumber",
    "pinCode",
    "roomInfo",
    "roomFacilities",
    "services",
    "hotelWebsiteUrl",
    "tripAdvisorRating",
    "tripAdvisorReviewURL",
    "cityName"
})
public class APIHotelDetails {

    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "HotelLocation")
    protected String hotelLocation;
    @XmlElement(name = "Attractions")
    protected ArrayOfString3 attractions;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "FaxNumber")
    protected String faxNumber;
    @XmlElement(name = "HotelFacilities")
    protected ArrayOfString4 hotelFacilities;
    @XmlElement(name = "HotelPolicy")
    protected String hotelPolicy;
    @XmlElement(name = "Image")
    protected String image;
    @XmlElement(name = "ImageUrls")
    protected ArrayOfImageUrlDetails imageUrls;
    @XmlElement(name = "Map")
    protected String map;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "PinCode")
    protected String pinCode;
    @XmlElement(name = "RoomInfo")
    protected ArrayOfRoomInfo roomInfo;
    @XmlElement(name = "RoomFacilities")
    protected ArrayOfString6 roomFacilities;
    @XmlElement(name = "Services")
    protected String services;
    @XmlElement(name = "HotelWebsiteUrl")
    protected String hotelWebsiteUrl;
    @XmlElement(name = "TripAdvisorRating")
    protected String tripAdvisorRating;
    @XmlElement(name = "TripAdvisorReviewURL")
    protected String tripAdvisorReviewURL;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelName")
    protected String hotelName;
    @XmlAttribute(name = "HotelRating", required = true)
    protected HotelInfoHotelRating hotelRating;

    /**
     * Obtém o valor da propriedade address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o valor da propriedade address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Obtém o valor da propriedade hotelLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelLocation() {
        return hotelLocation;
    }

    /**
     * Define o valor da propriedade hotelLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelLocation(String value) {
        this.hotelLocation = value;
    }

    /**
     * Obtém o valor da propriedade attractions.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString3 }
     *     
     */
    public ArrayOfString3 getAttractions() {
        return attractions;
    }

    /**
     * Define o valor da propriedade attractions.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString3 }
     *     
     */
    public void setAttractions(ArrayOfString3 value) {
        this.attractions = value;
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
     * Obtém o valor da propriedade countryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Define o valor da propriedade countryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

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
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtém o valor da propriedade faxNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Define o valor da propriedade faxNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Obtém o valor da propriedade hotelFacilities.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString4 }
     *     
     */
    public ArrayOfString4 getHotelFacilities() {
        return hotelFacilities;
    }

    /**
     * Define o valor da propriedade hotelFacilities.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString4 }
     *     
     */
    public void setHotelFacilities(ArrayOfString4 value) {
        this.hotelFacilities = value;
    }

    /**
     * Obtém o valor da propriedade hotelPolicy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPolicy() {
        return hotelPolicy;
    }

    /**
     * Define o valor da propriedade hotelPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPolicy(String value) {
        this.hotelPolicy = value;
    }

    /**
     * Obtém o valor da propriedade image.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Define o valor da propriedade image.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Obtém o valor da propriedade imageUrls.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfImageUrlDetails }
     *     
     */
    public ArrayOfImageUrlDetails getImageUrls() {
        return imageUrls;
    }

    /**
     * Define o valor da propriedade imageUrls.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfImageUrlDetails }
     *     
     */
    public void setImageUrls(ArrayOfImageUrlDetails value) {
        this.imageUrls = value;
    }

    /**
     * Obtém o valor da propriedade map.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMap() {
        return map;
    }

    /**
     * Define o valor da propriedade map.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMap(String value) {
        this.map = value;
    }

    /**
     * Obtém o valor da propriedade phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Define o valor da propriedade phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Obtém o valor da propriedade pinCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Define o valor da propriedade pinCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinCode(String value) {
        this.pinCode = value;
    }

    /**
     * Obtém o valor da propriedade roomInfo.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomInfo }
     *     
     */
    public ArrayOfRoomInfo getRoomInfo() {
        return roomInfo;
    }

    /**
     * Define o valor da propriedade roomInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomInfo }
     *     
     */
    public void setRoomInfo(ArrayOfRoomInfo value) {
        this.roomInfo = value;
    }

    /**
     * Obtém o valor da propriedade roomFacilities.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString6 }
     *     
     */
    public ArrayOfString6 getRoomFacilities() {
        return roomFacilities;
    }

    /**
     * Define o valor da propriedade roomFacilities.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString6 }
     *     
     */
    public void setRoomFacilities(ArrayOfString6 value) {
        this.roomFacilities = value;
    }

    /**
     * Obtém o valor da propriedade services.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServices() {
        return services;
    }

    /**
     * Define o valor da propriedade services.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServices(String value) {
        this.services = value;
    }

    /**
     * Obtém o valor da propriedade hotelWebsiteUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelWebsiteUrl() {
        return hotelWebsiteUrl;
    }

    /**
     * Define o valor da propriedade hotelWebsiteUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelWebsiteUrl(String value) {
        this.hotelWebsiteUrl = value;
    }

    /**
     * Obtém o valor da propriedade tripAdvisorRating.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorRating() {
        return tripAdvisorRating;
    }

    /**
     * Define o valor da propriedade tripAdvisorRating.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorRating(String value) {
        this.tripAdvisorRating = value;
    }

    /**
     * Obtém o valor da propriedade tripAdvisorReviewURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorReviewURL() {
        return tripAdvisorReviewURL;
    }

    /**
     * Define o valor da propriedade tripAdvisorReviewURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorReviewURL(String value) {
        this.tripAdvisorReviewURL = value;
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
     * Obtém o valor da propriedade hotelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Define o valor da propriedade hotelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Obtém o valor da propriedade hotelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Define o valor da propriedade hotelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Obtém o valor da propriedade hotelRating.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public HotelInfoHotelRating getHotelRating() {
        return hotelRating;
    }

    /**
     * Define o valor da propriedade hotelRating.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public void setHotelRating(HotelInfoHotelRating value) {
        this.hotelRating = value;
    }

}
