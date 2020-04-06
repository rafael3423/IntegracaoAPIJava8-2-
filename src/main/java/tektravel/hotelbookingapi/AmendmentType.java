
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AmendmentType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CheckStatus"/>
 *     &lt;enumeration value="OfflineAmendment"/>
 *     &lt;enumeration value="PriceApproved"/>
 *     &lt;enumeration value="WithdrawRequest"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AmendmentType")
@XmlEnum
public enum AmendmentType {

    @XmlEnumValue("CheckStatus")
    CHECK_STATUS("CheckStatus"),
    @XmlEnumValue("OfflineAmendment")
    OFFLINE_AMENDMENT("OfflineAmendment"),
    @XmlEnumValue("PriceApproved")
    PRICE_APPROVED("PriceApproved"),
    @XmlEnumValue("WithdrawRequest")
    WITHDRAW_REQUEST("WithdrawRequest");
    private final String value;

    AmendmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendmentType fromValue(String v) {
        for (AmendmentType c: AmendmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
