
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfImageUrlDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfImageUrlDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImageUrl" type="{http://TekTravel/HotelBookingApi}ImageUrlDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfImageUrlDetails", propOrder = {
    "imageUrl"
})
public class ArrayOfImageUrlDetails {

    @XmlElement(name = "ImageUrl", nillable = true)
    protected List<ImageUrlDetails> imageUrl;

    /**
     * Gets the value of the imageUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageUrlDetails }
     * 
     * 
     */
    public List<ImageUrlDetails> getImageUrl() {
        if (imageUrl == null) {
            imageUrl = new ArrayList<ImageUrlDetails>();
        }
        return this.imageUrl;
    }

}
