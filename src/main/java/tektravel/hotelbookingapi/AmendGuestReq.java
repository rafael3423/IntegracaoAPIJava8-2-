
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendGuestReq complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AmendGuestReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Action" use="required" type="{http://TekTravel/HotelBookingApi}AmendActionReq" />
 *       &lt;attribute name="ExistingName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GuestType" use="required" type="{http://TekTravel/HotelBookingApi}GuestType" />
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Age" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendGuestReq")
public class AmendGuestReq {

    @XmlAttribute(name = "Action", required = true)
    protected AmendActionReq action;
    @XmlAttribute(name = "ExistingName")
    protected String existingName;
    @XmlAttribute(name = "GuestType", required = true)
    protected GuestType guestType;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "FirstName")
    protected String firstName;
    @XmlAttribute(name = "LastName")
    protected String lastName;
    @XmlAttribute(name = "Age", required = true)
    protected int age;

    /**
     * Obtém o valor da propriedade action.
     * 
     * @return
     *     possible object is
     *     {@link AmendActionReq }
     *     
     */
    public AmendActionReq getAction() {
        return action;
    }

    /**
     * Define o valor da propriedade action.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendActionReq }
     *     
     */
    public void setAction(AmendActionReq value) {
        this.action = value;
    }

    /**
     * Obtém o valor da propriedade existingName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingName() {
        return existingName;
    }

    /**
     * Define o valor da propriedade existingName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingName(String value) {
        this.existingName = value;
    }

    /**
     * Obtém o valor da propriedade guestType.
     * 
     * @return
     *     possible object is
     *     {@link GuestType }
     *     
     */
    public GuestType getGuestType() {
        return guestType;
    }

    /**
     * Define o valor da propriedade guestType.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestType }
     *     
     */
    public void setGuestType(GuestType value) {
        this.guestType = value;
    }

    /**
     * Obtém o valor da propriedade title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o valor da propriedade title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtém o valor da propriedade firstName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Define o valor da propriedade firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Obtém o valor da propriedade lastName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define o valor da propriedade lastName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Obtém o valor da propriedade age.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Define o valor da propriedade age.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

}
