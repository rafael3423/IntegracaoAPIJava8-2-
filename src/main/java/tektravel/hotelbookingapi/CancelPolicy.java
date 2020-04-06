
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CancelPolicy complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CancelPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FromDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ToDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ChargeType" use="required" type="{http://TekTravel/HotelBookingApi}CancellationChargeTypeForHotel" />
 *       &lt;attribute name="CancellationCharge" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PrefCancellationCharge" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelPolicy")
public class CancelPolicy {

    @XmlAttribute(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlAttribute(name = "RoomIndex")
    protected String roomIndex;
    @XmlAttribute(name = "FromDate")
    protected String fromDate;
    @XmlAttribute(name = "ToDate")
    protected String toDate;
    @XmlAttribute(name = "ChargeType", required = true)
    protected CancellationChargeTypeForHotel chargeType;
    @XmlAttribute(name = "CancellationCharge", required = true)
    protected BigDecimal cancellationCharge;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "PrefCurrency")
    protected String prefCurrency;
    @XmlAttribute(name = "PrefCancellationCharge")
    protected String prefCancellationCharge;

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
     * Obtém o valor da propriedade roomIndex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomIndex() {
        return roomIndex;
    }

    /**
     * Define o valor da propriedade roomIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomIndex(String value) {
        this.roomIndex = value;
    }

    /**
     * Obtém o valor da propriedade fromDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Define o valor da propriedade fromDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDate(String value) {
        this.fromDate = value;
    }

    /**
     * Obtém o valor da propriedade toDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Define o valor da propriedade toDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDate(String value) {
        this.toDate = value;
    }

    /**
     * Obtém o valor da propriedade chargeType.
     * 
     * @return
     *     possible object is
     *     {@link CancellationChargeTypeForHotel }
     *     
     */
    public CancellationChargeTypeForHotel getChargeType() {
        return chargeType;
    }

    /**
     * Define o valor da propriedade chargeType.
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationChargeTypeForHotel }
     *     
     */
    public void setChargeType(CancellationChargeTypeForHotel value) {
        this.chargeType = value;
    }

    /**
     * Obtém o valor da propriedade cancellationCharge.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCancellationCharge() {
        return cancellationCharge;
    }

    /**
     * Define o valor da propriedade cancellationCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCancellationCharge(BigDecimal value) {
        this.cancellationCharge = value;
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
     * Obtém o valor da propriedade prefCancellationCharge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefCancellationCharge() {
        return prefCancellationCharge;
    }

    /**
     * Define o valor da propriedade prefCancellationCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefCancellationCharge(String value) {
        this.prefCancellationCharge = value;
    }

}
