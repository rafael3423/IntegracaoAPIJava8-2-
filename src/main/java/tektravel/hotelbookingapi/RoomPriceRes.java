
package tektravel.hotelbookingapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomPriceRes complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomPriceRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="RoomIndex" use="required" type="{http://TekTravel/HotelBookingApi}RoomRequested" />
 *       &lt;attribute name="RoomName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BeforeAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="AfterAmendmentPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomPriceRes")
public class RoomPriceRes {

    @XmlAttribute(name = "RoomIndex", required = true)
    protected RoomRequested roomIndex;
    @XmlAttribute(name = "RoomName")
    protected String roomName;
    @XmlAttribute(name = "BeforeAmendmentPrice", required = true)
    protected BigDecimal beforeAmendmentPrice;
    @XmlAttribute(name = "AfterAmendmentPrice", required = true)
    protected BigDecimal afterAmendmentPrice;

    /**
     * Obtém o valor da propriedade roomIndex.
     * 
     * @return
     *     possible object is
     *     {@link RoomRequested }
     *     
     */
    public RoomRequested getRoomIndex() {
        return roomIndex;
    }

    /**
     * Define o valor da propriedade roomIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomRequested }
     *     
     */
    public void setRoomIndex(RoomRequested value) {
        this.roomIndex = value;
    }

    /**
     * Obtém o valor da propriedade roomName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Define o valor da propriedade roomName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * Obtém o valor da propriedade beforeAmendmentPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBeforeAmendmentPrice() {
        return beforeAmendmentPrice;
    }

    /**
     * Define o valor da propriedade beforeAmendmentPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBeforeAmendmentPrice(BigDecimal value) {
        this.beforeAmendmentPrice = value;
    }

    /**
     * Obtém o valor da propriedade afterAmendmentPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAfterAmendmentPrice() {
        return afterAmendmentPrice;
    }

    /**
     * Define o valor da propriedade afterAmendmentPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAfterAmendmentPrice(BigDecimal value) {
        this.afterAmendmentPrice = value;
    }

}
