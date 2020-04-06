
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de HotelInfoHotelRating.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelInfoHotelRating">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="OneStar"/>
 *     &lt;enumeration value="TwoStar"/>
 *     &lt;enumeration value="ThreeStar"/>
 *     &lt;enumeration value="FourStar"/>
 *     &lt;enumeration value="FiveStar"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HotelInfoHotelRating")
@XmlEnum
public enum HotelInfoHotelRating {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("OneStar")
    ONE_STAR("OneStar"),
    @XmlEnumValue("TwoStar")
    TWO_STAR("TwoStar"),
    @XmlEnumValue("ThreeStar")
    THREE_STAR("ThreeStar"),
    @XmlEnumValue("FourStar")
    FOUR_STAR("FourStar"),
    @XmlEnumValue("FiveStar")
    FIVE_STAR("FiveStar");
    private final String value;

    HotelInfoHotelRating(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelInfoHotelRating fromValue(String v) {
        for (HotelInfoHotelRating c: HotelInfoHotelRating.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
