
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendActionReq.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendActionReq">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Rename"/>
 *     &lt;enumeration value="Add"/>
 *     &lt;enumeration value="Delete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AmendActionReq")
@XmlEnum
public enum AmendActionReq {

    @XmlEnumValue("Rename")
    RENAME("Rename"),
    @XmlEnumValue("Add")
    ADD("Add"),
    @XmlEnumValue("Delete")
    DELETE("Delete");
    private final String value;

    AmendActionReq(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendActionReq fromValue(String v) {
        for (AmendActionReq c: AmendActionReq.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
