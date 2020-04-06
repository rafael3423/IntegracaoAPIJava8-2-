
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Hotel_Result complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Hotel_Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HotelInfo" type="{http://TekTravel/HotelBookingApi}HotelInfo" minOccurs="0"/>
 *         &lt;element name="MinHotelPrice" type="{http://TekTravel/HotelBookingApi}MinHotelPrice" minOccurs="0"/>
 *         &lt;element name="IsPkgProperty" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RoomDetails" type="{http://TekTravel/HotelBookingApi}ArrayOfRooms" minOccurs="0"/>
 *         &lt;element name="IsPackageRate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MappedHotel" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsHalal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel_Result", propOrder = {
    "resultIndex",
    "hotelInfo",
    "minHotelPrice",
    "isPkgProperty",
    "roomDetails",
    "isPackageRate",
    "mappedHotel",
    "isHalal"
})
public class HotelResult {

    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelInfo")
    protected HotelInfo hotelInfo;
    @XmlElement(name = "MinHotelPrice")
    protected MinHotelPrice minHotelPrice;
    @XmlElement(name = "IsPkgProperty")
    protected boolean isPkgProperty;
    @XmlElement(name = "RoomDetails")
    protected ArrayOfRooms roomDetails;
    @XmlElement(name = "IsPackageRate")
    protected boolean isPackageRate;
    @XmlElement(name = "MappedHotel")
    protected boolean mappedHotel;
    @XmlElement(name = "IsHalal")
    protected boolean isHalal;

    /**
     * Obtém o valor da propriedade resultIndex.
     * 
     */
    public int getResultIndex() {
        return resultIndex;
    }

    /**
     * Define o valor da propriedade resultIndex.
     * 
     */
    public void setResultIndex(int value) {
        this.resultIndex = value;
    }

    /**
     * Obtém o valor da propriedade hotelInfo.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfo }
     *     
     */
    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Define o valor da propriedade hotelInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfo }
     *     
     */
    public void setHotelInfo(HotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Obtém o valor da propriedade minHotelPrice.
     * 
     * @return
     *     possible object is
     *     {@link MinHotelPrice }
     *     
     */
    public MinHotelPrice getMinHotelPrice() {
        return minHotelPrice;
    }

    /**
     * Define o valor da propriedade minHotelPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link MinHotelPrice }
     *     
     */
    public void setMinHotelPrice(MinHotelPrice value) {
        this.minHotelPrice = value;
    }

    /**
     * Obtém o valor da propriedade isPkgProperty.
     * 
     */
    public boolean isIsPkgProperty() {
        return isPkgProperty;
    }

    /**
     * Define o valor da propriedade isPkgProperty.
     * 
     */
    public void setIsPkgProperty(boolean value) {
        this.isPkgProperty = value;
    }

    /**
     * Obtém o valor da propriedade roomDetails.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRooms }
     *     
     */
    public ArrayOfRooms getRoomDetails() {
        return roomDetails;
    }

    /**
     * Define o valor da propriedade roomDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRooms }
     *     
     */
    public void setRoomDetails(ArrayOfRooms value) {
        this.roomDetails = value;
    }

    /**
     * Obtém o valor da propriedade isPackageRate.
     * 
     */
    public boolean isIsPackageRate() {
        return isPackageRate;
    }

    /**
     * Define o valor da propriedade isPackageRate.
     * 
     */
    public void setIsPackageRate(boolean value) {
        this.isPackageRate = value;
    }

    /**
     * Obtém o valor da propriedade mappedHotel.
     * 
     */
    public boolean isMappedHotel() {
        return mappedHotel;
    }

    /**
     * Define o valor da propriedade mappedHotel.
     * 
     */
    public void setMappedHotel(boolean value) {
        this.mappedHotel = value;
    }

    /**
     * Obtém o valor da propriedade isHalal.
     * 
     */
    public boolean isIsHalal() {
        return isHalal;
    }

    /**
     * Define o valor da propriedade isHalal.
     * 
     */
    public void setIsHalal(boolean value) {
        this.isHalal = value;
    }

}
