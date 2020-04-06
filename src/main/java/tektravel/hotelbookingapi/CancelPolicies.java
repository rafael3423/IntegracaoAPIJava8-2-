
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de CancelPolicies complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CancelPolicies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LastCancellationDeadline" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CancelPolicy" type="{http://TekTravel/HotelBookingApi}CancelPolicy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TextPolicy" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NoShowPolicy" type="{http://TekTravel/HotelBookingApi}CancelPolicy" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DefaultPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AutoCancellationText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PolicyFormat" use="required" type="{http://TekTravel/HotelBookingApi}PolicyFormat" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelPolicies", propOrder = {
    "lastCancellationDeadline",
    "cancelPolicy",
    "textPolicy",
    "noShowPolicy",
    "defaultPolicy",
    "autoCancellationText"
})
public class CancelPolicies {

    @XmlElement(name = "LastCancellationDeadline", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastCancellationDeadline;
    @XmlElement(name = "CancelPolicy")
    protected List<CancelPolicy> cancelPolicy;
    @XmlElement(name = "TextPolicy")
    protected List<String> textPolicy;
    @XmlElement(name = "NoShowPolicy")
    protected List<CancelPolicy> noShowPolicy;
    @XmlElement(name = "DefaultPolicy")
    protected String defaultPolicy;
    @XmlElement(name = "AutoCancellationText")
    protected String autoCancellationText;
    @XmlAttribute(name = "PolicyFormat", required = true)
    protected PolicyFormat policyFormat;

    /**
     * Obtém o valor da propriedade lastCancellationDeadline.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastCancellationDeadline() {
        return lastCancellationDeadline;
    }

    /**
     * Define o valor da propriedade lastCancellationDeadline.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastCancellationDeadline(XMLGregorianCalendar value) {
        this.lastCancellationDeadline = value;
    }

    /**
     * Gets the value of the cancelPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelPolicy }
     * 
     * 
     */
    public List<CancelPolicy> getCancelPolicy() {
        if (cancelPolicy == null) {
            cancelPolicy = new ArrayList<CancelPolicy>();
        }
        return this.cancelPolicy;
    }

    /**
     * Gets the value of the textPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTextPolicy() {
        if (textPolicy == null) {
            textPolicy = new ArrayList<String>();
        }
        return this.textPolicy;
    }

    /**
     * Gets the value of the noShowPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noShowPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoShowPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelPolicy }
     * 
     * 
     */
    public List<CancelPolicy> getNoShowPolicy() {
        if (noShowPolicy == null) {
            noShowPolicy = new ArrayList<CancelPolicy>();
        }
        return this.noShowPolicy;
    }

    /**
     * Obtém o valor da propriedade defaultPolicy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPolicy() {
        return defaultPolicy;
    }

    /**
     * Define o valor da propriedade defaultPolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPolicy(String value) {
        this.defaultPolicy = value;
    }

    /**
     * Obtém o valor da propriedade autoCancellationText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCancellationText() {
        return autoCancellationText;
    }

    /**
     * Define o valor da propriedade autoCancellationText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCancellationText(String value) {
        this.autoCancellationText = value;
    }

    /**
     * Obtém o valor da propriedade policyFormat.
     * 
     * @return
     *     possible object is
     *     {@link PolicyFormat }
     *     
     */
    public PolicyFormat getPolicyFormat() {
        return policyFormat;
    }

    /**
     * Define o valor da propriedade policyFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyFormat }
     *     
     */
    public void setPolicyFormat(PolicyFormat value) {
        this.policyFormat = value;
    }

}
