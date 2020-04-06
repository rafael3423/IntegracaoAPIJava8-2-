
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SpecialRequest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SpecialRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RequestId" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RequestType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialRequest")
public class SpecialRequest {

    @XmlAttribute(name = "RequestId", required = true)
    protected int requestId;
    @XmlAttribute(name = "RequestType")
    protected String requestType;
    @XmlAttribute(name = "Remarks")
    protected String remarks;

    /**
     * Obtém o valor da propriedade requestId.
     * 
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Define o valor da propriedade requestId.
     * 
     */
    public void setRequestId(int value) {
        this.requestId = value;
    }

    /**
     * Obtém o valor da propriedade requestType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Define o valor da propriedade requestType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestType(String value) {
        this.requestType = value;
    }

    /**
     * Obtém o valor da propriedade remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define o valor da propriedade remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
