
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AccountInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AccountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="AgencyBalance" use="required" type="{http://TekTravel/HotelBookingApi}AccountBalance" />
 *       &lt;attribute name="AgencyBlocked" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInfo")
public class AccountInfo {

    @XmlAttribute(name = "AgencyBalance", required = true)
    protected AccountBalance agencyBalance;
    @XmlAttribute(name = "AgencyBlocked", required = true)
    protected boolean agencyBlocked;

    /**
     * Obtém o valor da propriedade agencyBalance.
     * 
     * @return
     *     possible object is
     *     {@link AccountBalance }
     *     
     */
    public AccountBalance getAgencyBalance() {
        return agencyBalance;
    }

    /**
     * Define o valor da propriedade agencyBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountBalance }
     *     
     */
    public void setAgencyBalance(AccountBalance value) {
        this.agencyBalance = value;
    }

    /**
     * Obtém o valor da propriedade agencyBlocked.
     * 
     */
    public boolean isAgencyBlocked() {
        return agencyBlocked;
    }

    /**
     * Define o valor da propriedade agencyBlocked.
     * 
     */
    public void setAgencyBlocked(boolean value) {
        this.agencyBlocked = value;
    }

}
