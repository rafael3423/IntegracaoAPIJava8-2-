
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SupplementType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SupplementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PerStaySupplement"/>
 *     &lt;enumeration value="PerPersonSupplement"/>
 *     &lt;enumeration value="PerRoomSupplement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SupplementType")
@XmlEnum
public enum SupplementType {

    @XmlEnumValue("PerStaySupplement")
    PER_STAY_SUPPLEMENT("PerStaySupplement"),
    @XmlEnumValue("PerPersonSupplement")
    PER_PERSON_SUPPLEMENT("PerPersonSupplement"),
    @XmlEnumValue("PerRoomSupplement")
    PER_ROOM_SUPPLEMENT("PerRoomSupplement");
    private final String value;

    SupplementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupplementType fromValue(String v) {
        for (SupplementType c: SupplementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
