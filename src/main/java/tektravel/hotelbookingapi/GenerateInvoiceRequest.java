
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
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentInfo" type="{http://TekTravel/HotelBookingApi}PaymentInfo" minOccurs="0"/>
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
    "bookingId",
    "confirmationNo",
    "paymentInfo"
})
@XmlRootElement(name = "GenerateInvoiceRequest")
public class GenerateInvoiceRequest {

    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlElement(name = "PaymentInfo")
    protected PaymentInfo paymentInfo;

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
     * Obtém o valor da propriedade confirmationNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationNo() {
        return confirmationNo;
    }

    /**
     * Define o valor da propriedade confirmationNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationNo(String value) {
        this.confirmationNo = value;
    }

    /**
     * Obtém o valor da propriedade paymentInfo.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfo }
     *     
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Define o valor da propriedade paymentInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfo }
     *     
     */
    public void setPaymentInfo(PaymentInfo value) {
        this.paymentInfo = value;
    }

}
