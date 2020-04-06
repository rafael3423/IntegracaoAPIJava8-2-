
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Hotel_Room complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Hotel_Room">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}RoomRate" minOccurs="0"/>
 *         &lt;element name="RoomPromtion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSupplement" minOccurs="0"/>
 *         &lt;element name="RoomEssentialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomAdditionalInfo" type="{http://TekTravel/HotelBookingApi}RoomInformation" minOccurs="0"/>
 *         &lt;element name="CancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/>
 *         &lt;element name="Amenities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MealType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel_Room", propOrder = {
    "roomIndex",
    "roomTypeName",
    "inclusion",
    "roomTypeCode",
    "ratePlanCode",
    "roomRate",
    "roomPromtion",
    "roomInstructions",
    "supplements",
    "roomEssentialInfo",
    "roomAdditionalInfo",
    "cancelPolicies",
    "amenities",
    "mealType"
})
public class HotelRoom {

    @XmlElement(name = "RoomIndex")
    protected int roomIndex;
    @XmlElement(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlElement(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlElement(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlElement(name = "RoomRate")
    protected RoomRate roomRate;
    @XmlElement(name = "RoomPromtion")
    protected String roomPromtion;
    @XmlElement(name = "RoomInstructions")
    protected String roomInstructions;
    @XmlElement(name = "Supplements")
    protected ArrayOfSupplement supplements;
    @XmlElement(name = "RoomEssentialInfo")
    protected String roomEssentialInfo;
    @XmlElement(name = "RoomAdditionalInfo")
    protected RoomInformation roomAdditionalInfo;
    @XmlElement(name = "CancelPolicies")
    protected CancelPolicies cancelPolicies;
    @XmlElement(name = "Amenities")
    protected String amenities;
    @XmlElement(name = "MealType")
    protected String mealType;

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
     *     {@link RoomRate }
     *     
     */
    public RoomRate getRoomRate() {
        return roomRate;
    }

    /**
     * Define o valor da propriedade roomRate.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomRate }
     *     
     */
    public void setRoomRate(RoomRate value) {
        this.roomRate = value;
    }

    /**
     * Obtém o valor da propriedade roomPromtion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomPromtion() {
        return roomPromtion;
    }

    /**
     * Define o valor da propriedade roomPromtion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomPromtion(String value) {
        this.roomPromtion = value;
    }

    /**
     * Obtém o valor da propriedade roomInstructions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomInstructions() {
        return roomInstructions;
    }

    /**
     * Define o valor da propriedade roomInstructions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomInstructions(String value) {
        this.roomInstructions = value;
    }

    /**
     * Obtém o valor da propriedade supplements.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSupplement }
     *     
     */
    public ArrayOfSupplement getSupplements() {
        return supplements;
    }

    /**
     * Define o valor da propriedade supplements.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSupplement }
     *     
     */
    public void setSupplements(ArrayOfSupplement value) {
        this.supplements = value;
    }

    /**
     * Obtém o valor da propriedade roomEssentialInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomEssentialInfo() {
        return roomEssentialInfo;
    }

    /**
     * Define o valor da propriedade roomEssentialInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomEssentialInfo(String value) {
        this.roomEssentialInfo = value;
    }

    /**
     * Obtém o valor da propriedade roomAdditionalInfo.
     * 
     * @return
     *     possible object is
     *     {@link RoomInformation }
     *     
     */
    public RoomInformation getRoomAdditionalInfo() {
        return roomAdditionalInfo;
    }

    /**
     * Define o valor da propriedade roomAdditionalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomInformation }
     *     
     */
    public void setRoomAdditionalInfo(RoomInformation value) {
        this.roomAdditionalInfo = value;
    }

    /**
     * Obtém o valor da propriedade cancelPolicies.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicies }
     *     
     */
    public CancelPolicies getCancelPolicies() {
        return cancelPolicies;
    }

    /**
     * Define o valor da propriedade cancelPolicies.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicies }
     *     
     */
    public void setCancelPolicies(CancelPolicies value) {
        this.cancelPolicies = value;
    }

    /**
     * Obtém o valor da propriedade amenities.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * Define o valor da propriedade amenities.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmenities(String value) {
        this.amenities = value;
    }

    /**
     * Obtém o valor da propriedade mealType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * Define o valor da propriedade mealType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealType(String value) {
        this.mealType = value;
    }

}
