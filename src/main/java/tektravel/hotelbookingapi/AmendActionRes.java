
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendActionRes.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendActionRes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Retained"/>
 *     &lt;enumeration value="Added"/>
 *     &lt;enumeration value="Deleted"/>
 *     &lt;enumeration value="Renamed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AmendActionRes")
@XmlEnum
public enum AmendActionRes {

    @XmlEnumValue("Retained")
    RETAINED("Retained"),
    @XmlEnumValue("Added")
    ADDED("Added"),
    @XmlEnumValue("Deleted")
    DELETED("Deleted"),
    @XmlEnumValue("Renamed")
    RENAMED("Renamed");
    private final String value;

    AmendActionRes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendActionRes fromValue(String v) {
        for (AmendActionRes c: AmendActionRes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
