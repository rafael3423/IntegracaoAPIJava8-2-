
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de OrderByFilter.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderByFilter">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PriceAsc"/>
 *     &lt;enumeration value="PriceDesc"/>
 *     &lt;enumeration value="StarRatingAsc"/>
 *     &lt;enumeration value="StarRatingDesc"/>
 *     &lt;enumeration value="TBOPreference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrderByFilter")
@XmlEnum
public enum OrderByFilter {

    @XmlEnumValue("PriceAsc")
    PRICE_ASC("PriceAsc"),
    @XmlEnumValue("PriceDesc")
    PRICE_DESC("PriceDesc"),
    @XmlEnumValue("StarRatingAsc")
    STAR_RATING_ASC("StarRatingAsc"),
    @XmlEnumValue("StarRatingDesc")
    STAR_RATING_DESC("StarRatingDesc"),
    @XmlEnumValue("TBOPreference")
    TBO_PREFERENCE("TBOPreference");
    private final String value;

    OrderByFilter(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrderByFilter fromValue(String v) {
        for (OrderByFilter c: OrderByFilter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
