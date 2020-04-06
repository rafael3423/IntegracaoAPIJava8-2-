
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CancelRequestType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="CancelRequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HotelCancel"/>
 *     &lt;enumeration value="CheckStatus"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CancelRequestType")
@XmlEnum
public enum CancelRequestType {

    @XmlEnumValue("HotelCancel")
    HOTEL_CANCEL("HotelCancel"),
    @XmlEnumValue("CheckStatus")
    CHECK_STATUS("CheckStatus");
    private final String value;

    CancelRequestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancelRequestType fromValue(String v) {
        for (CancelRequestType c: CancelRequestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
