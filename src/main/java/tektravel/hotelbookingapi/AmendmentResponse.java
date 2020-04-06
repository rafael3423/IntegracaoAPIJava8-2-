
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
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/>
 *         &lt;element name="RequestStatus" type="{http://TekTravel/HotelBookingApi}RequestStatus"/>
 *         &lt;element name="ApprovalInformation" type="{http://TekTravel/HotelBookingApi}ApprovalInformation" minOccurs="0"/>
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NewConfirmatioNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewLastCancellationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmendmentMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmendmentRequested" type="{http://TekTravel/HotelBookingApi}AmendmentRequested" minOccurs="0"/>
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
    "requestStatus",
    "approvalInformation",
    "bookingId",
    "newConfirmatioNo",
    "newLastCancellationDate",
    "amendmentMessage",
    "amendmentRequested"
})
@XmlRootElement(name = "AmendmentResponse")
public class AmendmentResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "RequestStatus", required = true)
    protected RequestStatus requestStatus;
    @XmlElement(name = "ApprovalInformation")
    protected ApprovalInformation approvalInformation;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "NewConfirmatioNo")
    protected String newConfirmatioNo;
    @XmlElement(name = "NewLastCancellationDate")
    protected String newLastCancellationDate;
    @XmlElement(name = "AmendmentMessage")
    protected String amendmentMessage;
    @XmlElement(name = "AmendmentRequested")
    protected AmendmentRequested amendmentRequested;

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
     * Obtém o valor da propriedade requestStatus.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Define o valor da propriedade requestStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setRequestStatus(RequestStatus value) {
        this.requestStatus = value;
    }

    /**
     * Obtém o valor da propriedade approvalInformation.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalInformation }
     *     
     */
    public ApprovalInformation getApprovalInformation() {
        return approvalInformation;
    }

    /**
     * Define o valor da propriedade approvalInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalInformation }
     *     
     */
    public void setApprovalInformation(ApprovalInformation value) {
        this.approvalInformation = value;
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
     * Obtém o valor da propriedade newConfirmatioNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewConfirmatioNo() {
        return newConfirmatioNo;
    }

    /**
     * Define o valor da propriedade newConfirmatioNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewConfirmatioNo(String value) {
        this.newConfirmatioNo = value;
    }

    /**
     * Obtém o valor da propriedade newLastCancellationDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewLastCancellationDate() {
        return newLastCancellationDate;
    }

    /**
     * Define o valor da propriedade newLastCancellationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewLastCancellationDate(String value) {
        this.newLastCancellationDate = value;
    }

    /**
     * Obtém o valor da propriedade amendmentMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentMessage() {
        return amendmentMessage;
    }

    /**
     * Define o valor da propriedade amendmentMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentMessage(String value) {
        this.amendmentMessage = value;
    }

    /**
     * Obtém o valor da propriedade amendmentRequested.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentRequested }
     *     
     */
    public AmendmentRequested getAmendmentRequested() {
        return amendmentRequested;
    }

    /**
     * Define o valor da propriedade amendmentRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentRequested }
     *     
     */
    public void setAmendmentRequested(AmendmentRequested value) {
        this.amendmentRequested = value;
    }

}
