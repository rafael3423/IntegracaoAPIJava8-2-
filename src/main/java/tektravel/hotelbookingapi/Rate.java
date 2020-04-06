
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Rate complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Rate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RoomFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="RoomTax" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="TotalFare" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rate")
public class Rate {

    @XmlAttribute(name = "RoomFare", required = true)
    protected BigDecimal roomFare;
    @XmlAttribute(name = "RoomTax", required = true)
    protected BigDecimal roomTax;
    @XmlAttribute(name = "TotalFare", required = true)
    protected BigDecimal totalFare;

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

}
