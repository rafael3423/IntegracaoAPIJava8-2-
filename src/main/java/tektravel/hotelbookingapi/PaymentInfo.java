
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PaymentInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="VoucherBooking" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="PaymentModeType" use="required" type="{http://TekTravel/HotelBookingApi}PaymentModeType" />
 *       &lt;attribute name="CvvNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo")
public class PaymentInfo {

    @XmlAttribute(name = "VoucherBooking", required = true)
    protected boolean voucherBooking;
    @XmlAttribute(name = "PaymentModeType", required = true)
    protected PaymentModeType paymentModeType;
    @XmlAttribute(name = "CvvNumber")
    protected String cvvNumber;

    /**
     * Obtém o valor da propriedade voucherBooking.
     * 
     */
    public boolean isVoucherBooking() {
        return voucherBooking;
    }

    /**
     * Define o valor da propriedade voucherBooking.
     * 
     */
    public void setVoucherBooking(boolean value) {
        this.voucherBooking = value;
    }

    /**
     * Obtém o valor da propriedade paymentModeType.
     * 
     * @return
     *     possible object is
     *     {@link PaymentModeType }
     *     
     */
    public PaymentModeType getPaymentModeType() {
        return paymentModeType;
    }

    /**
     * Define o valor da propriedade paymentModeType.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentModeType }
     *     
     */
    public void setPaymentModeType(PaymentModeType value) {
        this.paymentModeType = value;
    }

    /**
     * Obtém o valor da propriedade cvvNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvvNumber() {
        return cvvNumber;
    }

    /**
     * Define o valor da propriedade cvvNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvvNumber(String value) {
        this.cvvNumber = value;
    }

}
