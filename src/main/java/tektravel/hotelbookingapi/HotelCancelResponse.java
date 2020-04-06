
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
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
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CancellationCharge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RequestStatus" type="{http://TekTravel/HotelBookingApi}HotelCancelStatus"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "bookingId",
    "cancellationCharge",
    "refundAmount",
    "requestStatus",
    "currency"
})
@XmlRootElement(name = "HotelCancelResponse")
public class HotelCancelResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "CancellationCharge", required = true)
    protected BigDecimal cancellationCharge;
    @XmlElement(name = "RefundAmount", required = true)
    protected BigDecimal refundAmount;
    @XmlElement(name = "RequestStatus", required = true)
    protected HotelCancelStatus requestStatus;
    @XmlElement(name = "Currency")
    protected String currency;

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
     * Obtém o valor da propriedade bookingId.
     * 
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Define o valor da propriedade bookingId.
     * 
     */
    public void setBookingId(int value) {
        this.bookingId = value;
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
     * Obtém o valor da propriedade refundAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * Define o valor da propriedade refundAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

    /**
     * Obtém o valor da propriedade requestStatus.
     * 
     * @return
     *     possible object is
     *     {@link HotelCancelStatus }
     *     
     */
    public HotelCancelStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Define o valor da propriedade requestStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelCancelStatus }
     *     
     */
    public void setRequestStatus(HotelCancelStatus value) {
        this.requestStatus = value;
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

}
