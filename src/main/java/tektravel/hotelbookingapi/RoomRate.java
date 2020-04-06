
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomRate complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DayRates" type="{http://TekTravel/HotelBookingApi}ArrayOfDayRate" minOccurs="0"/>
 *         &lt;element name="ExtraGuestCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ChildCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OtherCharges" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ServiceTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IsPackageRate" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IsInstantConfirmed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="B2CRates" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="HeadGSAMarkUp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AgentMarkUp" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RoomFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="RoomTax" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="TotalFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="PrefRoomFare" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefRoomTax" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefPrice" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomRate", propOrder = {
    "dayRates",
    "extraGuestCharges",
    "childCharges",
    "discount",
    "otherCharges",
    "serviceTax"
})
public class RoomRate {

    @XmlElement(name = "DayRates")
    protected ArrayOfDayRate dayRates;
    @XmlElement(name = "ExtraGuestCharges", required = true)
    protected BigDecimal extraGuestCharges;
    @XmlElement(name = "ChildCharges", required = true)
    protected BigDecimal childCharges;
    @XmlElement(name = "Discount", required = true)
    protected BigDecimal discount;
    @XmlElement(name = "OtherCharges", required = true)
    protected BigDecimal otherCharges;
    @XmlElement(name = "ServiceTax", required = true)
    protected BigDecimal serviceTax;
    @XmlAttribute(name = "IsPackageRate", required = true)
    protected boolean isPackageRate;
    @XmlAttribute(name = "IsInstantConfirmed", required = true)
    protected boolean isInstantConfirmed;
    @XmlAttribute(name = "B2CRates", required = true)
    protected boolean b2CRates;
    @XmlAttribute(name = "HeadGSAMarkUp")
    protected String headGSAMarkUp;
    @XmlAttribute(name = "AgentMarkUp", required = true)
    protected BigDecimal agentMarkUp;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "RoomFare", required = true)
    protected BigDecimal roomFare;
    @XmlAttribute(name = "RoomTax", required = true)
    protected BigDecimal roomTax;
    @XmlAttribute(name = "TotalFare", required = true)
    protected BigDecimal totalFare;
    @XmlAttribute(name = "PrefRoomFare")
    protected String prefRoomFare;
    @XmlAttribute(name = "PrefRoomTax")
    protected String prefRoomTax;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;
    @XmlAttribute(name = "PrefPrice")
    protected String prefPrice;

    /**
     * Obtém o valor da propriedade dayRates.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDayRate }
     *     
     */
    public ArrayOfDayRate getDayRates() {
        return dayRates;
    }

    /**
     * Define o valor da propriedade dayRates.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDayRate }
     *     
     */
    public void setDayRates(ArrayOfDayRate value) {
        this.dayRates = value;
    }

    /**
     * Obtém o valor da propriedade extraGuestCharges.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExtraGuestCharges() {
        return extraGuestCharges;
    }

    /**
     * Define o valor da propriedade extraGuestCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExtraGuestCharges(BigDecimal value) {
        this.extraGuestCharges = value;
    }

    /**
     * Obtém o valor da propriedade childCharges.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getChildCharges() {
        return childCharges;
    }

    /**
     * Define o valor da propriedade childCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setChildCharges(BigDecimal value) {
        this.childCharges = value;
    }

    /**
     * Obtém o valor da propriedade discount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Define o valor da propriedade discount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiscount(BigDecimal value) {
        this.discount = value;
    }

    /**
     * Obtém o valor da propriedade otherCharges.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherCharges() {
        return otherCharges;
    }

    /**
     * Define o valor da propriedade otherCharges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherCharges(BigDecimal value) {
        this.otherCharges = value;
    }

    /**
     * Obtém o valor da propriedade serviceTax.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getServiceTax() {
        return serviceTax;
    }

    /**
     * Define o valor da propriedade serviceTax.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setServiceTax(BigDecimal value) {
        this.serviceTax = value;
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
     * Obtém o valor da propriedade isInstantConfirmed.
     * 
     */
    public boolean isIsInstantConfirmed() {
        return isInstantConfirmed;
    }

    /**
     * Define o valor da propriedade isInstantConfirmed.
     * 
     */
    public void setIsInstantConfirmed(boolean value) {
        this.isInstantConfirmed = value;
    }

    /**
     * Obtém o valor da propriedade b2CRates.
     * 
     */
    public boolean isB2CRates() {
        return b2CRates;
    }

    /**
     * Define o valor da propriedade b2CRates.
     * 
     */
    public void setB2CRates(boolean value) {
        this.b2CRates = value;
    }

    /**
     * Obtém o valor da propriedade headGSAMarkUp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadGSAMarkUp() {
        return headGSAMarkUp;
    }

    /**
     * Define o valor da propriedade headGSAMarkUp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadGSAMarkUp(String value) {
        this.headGSAMarkUp = value;
    }

    /**
     * Obtém o valor da propriedade agentMarkUp.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAgentMarkUp() {
        return agentMarkUp;
    }

    /**
     * Define o valor da propriedade agentMarkUp.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAgentMarkUp(BigDecimal value) {
        this.agentMarkUp = value;
    }

    /**
     * Obtém o valor da propriedade currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Define o valor da propriedade currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Obtém o valor da propriedade roomFare.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRoomFare() {
        return roomFare;
    }

    /**
     * Define o valor da propriedade roomFare.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRoomFare(BigDecimal value) {
        this.roomFare = value;
    }

    /**
     * Obtém o valor da propriedade roomTax.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRoomTax() {
        return roomTax;
    }

    /**
     * Define o valor da propriedade roomTax.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRoomTax(BigDecimal value) {
        this.roomTax = value;
    }

    /**
     * Obtém o valor da propriedade totalFare.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalFare() {
        return totalFare;
    }

    /**
     * Define o valor da propriedade totalFare.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalFare(BigDecimal value) {
        this.totalFare = value;
    }

    /**
     * Obtém o valor da propriedade prefRoomFare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefRoomFare() {
        return prefRoomFare;
    }

    /**
     * Define o valor da propriedade prefRoomFare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefRoomFare(String value) {
        this.prefRoomFare = value;
    }

    /**
     * Obtém o valor da propriedade prefRoomTax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefRoomTax() {
        return prefRoomTax;
    }

    /**
     * Define o valor da propriedade prefRoomTax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefRoomTax(String value) {
        this.prefRoomTax = value;
    }

    /**
     * Obtém o valor da propriedade prefCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefCurrency() {
        return prefCurrency;
    }

    /**
     * Define o valor da propriedade prefCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefCurrency(String value) {
        this.prefCurrency = value;
    }

    /**
     * Obtém o valor da propriedade prefPrice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefPrice() {
        return prefPrice;
    }

    /**
     * Define o valor da propriedade prefPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefPrice(String value) {
        this.prefPrice = value;
    }

}
