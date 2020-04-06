
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdultCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ChildCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ChildAge" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RoomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ameneties" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GuestInfo" type="{http://TekTravel/HotelBookingApi}ArrayOfGuest" minOccurs="0"/>
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomPromtion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSupp_info" minOccurs="0"/>
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}RoomRate" minOccurs="0"/>
 *         &lt;element name="RoomEssentialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "RoomDetails", propOrder = {
    "adultCount",
    "childCount",
    "childAge",
    "roomName",
    "ameneties",
    "guestInfo",
    "inclusion",
    "roomPromtion",
    "roomInstructions",
    "supplements",
    "roomRate",
    "roomEssentialInfo",
    "mealType"
})
public class RoomDetails {

    @XmlElement(name = "AdultCount")
    protected int adultCount;
    @XmlElement(name = "ChildCount")
    protected int childCount;
    @XmlElement(name = "ChildAge", type = Integer.class)
    protected List<Integer> childAge;
    @XmlElement(name = "RoomName")
    protected String roomName;
    @XmlElement(name = "Ameneties")
    protected List<String> ameneties;
    @XmlElement(name = "GuestInfo")
    protected ArrayOfGuest guestInfo;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlElement(name = "RoomPromtion")
    protected String roomPromtion;
    @XmlElement(name = "RoomInstructions")
    protected String roomInstructions;
    @XmlElement(name = "Supplements")
    protected ArrayOfSuppInfo2 supplements;
    @XmlElement(name = "RoomRate")
    protected RoomRate roomRate;
    @XmlElement(name = "RoomEssentialInfo")
    protected String roomEssentialInfo;
    @XmlElement(name = "MealType")
    protected String mealType;

    /**
     * Obtém o valor da propriedade adultCount.
     * 
     */
    public int getAdultCount() {
        return adultCount;
    }

    /**
     * Define o valor da propriedade adultCount.
     * 
     */
    public void setAdultCount(int value) {
        this.adultCount = value;
    }

    /**
     * Obtém o valor da propriedade childCount.
     * 
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Define o valor da propriedade childCount.
     * 
     */
    public void setChildCount(int value) {
        this.childCount = value;
    }

    /**
     * Gets the value of the childAge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childAge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildAge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getChildAge() {
        if (childAge == null) {
            childAge = new ArrayList<Integer>();
        }
        return this.childAge;
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
     * Gets the value of the ameneties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ameneties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmeneties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAmeneties() {
        if (ameneties == null) {
            ameneties = new ArrayList<String>();
        }
        return this.ameneties;
    }

    /**
     * Obtém o valor da propriedade guestInfo.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuest }
     *     
     */
    public ArrayOfGuest getGuestInfo() {
        return guestInfo;
    }

    /**
     * Define o valor da propriedade guestInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuest }
     *     
     */
    public void setGuestInfo(ArrayOfGuest value) {
        this.guestInfo = value;
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
     *     {@link ArrayOfSuppInfo2 }
     *     
     */
    public ArrayOfSuppInfo2 getSupplements() {
        return supplements;
    }

    /**
     * Define o valor da propriedade supplements.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSuppInfo2 }
     *     
     */
    public void setSupplements(ArrayOfSuppInfo2 value) {
        this.supplements = value;
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
