
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelCancelStatus.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelCancelStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UnProcessed"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="RefundAwaited"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HotelCancelStatus")
@XmlEnum
public enum HotelCancelStatus {

    @XmlEnumValue("UnProcessed")
    UN_PROCESSED("UnProcessed"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("RefundAwaited")
    REFUND_AWAITED("RefundAwaited");
    private final String value;

    HotelCancelStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelCancelStatus fromValue(String v) {
        for (HotelCancelStatus c: HotelCancelStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
